package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final StPersonRepository stPersonRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public TokenResponse register(final RegisterRequest request){
        try {
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
                    .idCountry(request.idCountry())
                    .idCity(request.idCity())
                    .genders(request.gender())
                    .personsType(request.personType())
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
