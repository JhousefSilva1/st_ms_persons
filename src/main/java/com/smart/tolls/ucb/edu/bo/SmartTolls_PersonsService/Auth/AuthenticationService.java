package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StGenderService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StPersonTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final StPersonRepository stPersonRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final StGenderService genderService;
    private final StPersonTypeService personTypeService;

    public AuthResponse register(RegisterRequest request) {
        // Verifica y obtiene las entidades relacionadas
        StGenderEntity gender = genderService.getGenderById(request.getIdGender())
                .orElseThrow(() -> new RuntimeException("Gender not found"));

        StPersonTypeEntity personType = personTypeService.getPersonTypeById(request.getIdPersonType())
                .orElseThrow(() -> new RuntimeException("PersonType not found"));

        // Construye la entidad con todos los campos necesarios
        StPersonEntity person = StPersonEntity.builder()
                .personName(request.getPersonName())
                .personSurname(request.getPersonSurname())
                .personEmail(request.getPersonEmail())
                .personPassword(passwordEncoder.encode(request.getPersonPassword()))
                .gender(gender)
                .personType(personType)
                // ... otros campos según tu entidad
                .build();

        // Guarda la entidad
        StPersonEntity savedPerson = stPersonRepository.save(person);

        // Obtiene UserDetails para generar el token
        UserDetails userDetails = userDetailsService.loadUserByUsername(savedPerson.getPersonEmail());

        // Genera los tokens
        String jwtToken = jwtService.generateToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(userDetails);

        return AuthResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getPersonEmail(),
                        request.getPersonPassword()
                )
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getPersonEmail());

        String jwtToken = jwtService.generateToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(userDetails);

        return AuthResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }
}