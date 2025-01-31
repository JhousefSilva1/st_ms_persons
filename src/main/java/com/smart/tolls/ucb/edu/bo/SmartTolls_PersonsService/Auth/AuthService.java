package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Client.CountryCityClient;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.City;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.Country;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StGenderService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StPersonTypeService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final StPersonRepository stPersonRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CountryCityClient countryCityClient;

    @Autowired
    private StGenderService stGenderService;

    @Autowired
    private StPersonTypeService stPersonTypeService;

    public TokenResponse register(final RegisterRequest request){
        try {
            Optional<StGenderEntity> gender = stGenderService.getGenderById(request.idGender());
            if(!gender.isPresent()){
                return null;
            }
            Optional<StPersonTypeEntity> personType = stPersonTypeService.getPersonTypeById(request.idPersonType());
            if(!personType.isPresent()){
                return null;
            }

            Optional<Country> country = Optional.ofNullable(countryCityClient.getCountryById(request.idCountry()));
//            Country country = countryCityClient.getCountryById(request.idCountry());
            if(!country.isPresent()){
                return null;
            }
            Optional<City> city = Optional.ofNullable(countryCityClient.getCityById(request.idCity()));
//            City city = countryCityClient.getCityById(request.idCity());
            if(!city.isPresent()){
                return null;
            }

            final StPersonEntity user = StPersonEntity.builder()
                    .personName(request.personName())
                    .personSurname(request.personSurname())
                    .personBirthdate(request.personBirthdate())
                    .personWhatsappNumber(request.personWhatsappNumber())
                    .personEmail(request.personEmail())
                    .personPassword(passwordEncoder.encode(request.personPassword()))
                    .personDni(request.personDni())
                    .personAddress(request.personAddress())
                    .personAge(request.personAge())
                    .genders(gender.get())
                    .personsType(personType.get())
                    .idCountry(country.get().getId())
                    .idCity(city.get().getId())
                    .build();

            final StPersonEntity savedUser = stPersonRepository.save(user);
            final String JwtToken = jwtService.generateToken(savedUser);
            final String refreshToken = jwtService.generateRefreshToken(savedUser);

            saveUserToken(savedUser, JwtToken);
            return new TokenResponse(JwtToken, refreshToken);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TokenResponse authenticate(final AuthRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.personEmail(),
                        request.personPassword()
                )
        );
        final StPersonEntity user = stPersonRepository.findByPersonEmail(request.personEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        final String accessToken = jwtService.generateToken(user);
        final String refreshToken = jwtService.generateRefreshToken(user);
        return new TokenResponse(accessToken, refreshToken);
    }

    public void saveUserToken(StPersonEntity user, String JwtToken){
        final Token token = Token.builder()
                .user(user)
                .token(JwtToken)
                .tokenType(Token.TokenType.BEARER)
                .isExpired(false)
                .isRevoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(final StPersonEntity user){
        final List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getIdPerson());
        if(!validUserTokens.isEmpty()){
            validUserTokens.forEach(token ->{
                token.setIsExpired(true);
                token.setIsRevoked(true);
            });
            tokenRepository.saveAll(validUserTokens);
        }
    }

    public TokenResponse refreshToken(@NotNull final String authentication){
        if(authentication == null || authentication.startsWith("Bearer ")) {
            throw new IllegalArgumentException("invalid auth header");
        }
        final String userEmail = jwtService.extractUsername(authentication);
        if(userEmail == null){
            return null;
        }

        final StPersonEntity user = this.stPersonRepository.findByPersonEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        final boolean isTokenValid = jwtService.isTokenValid(authentication, user);
        if (!isTokenValid){
            return null;
        }
        final String accessToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, accessToken);

        return new TokenResponse(accessToken, authentication);
    }
}
