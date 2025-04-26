package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth.Controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth.Models.AuthRequest;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth.Models.AuthResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth.Models.RegisterRequest;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth.Service.JwtService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth.Service.UserDetailsServiceImpl;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Client.CountryCityClient;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Controller.ApiController;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.CityDto;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.CountryDto;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Request.StPersonRequest;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StGenderService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StPersonService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StPersonTypeService;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController extends ApiController {

    private final StPersonService stPersonService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtService jwtService;
    private final CountryCityClient countryCityClient;
    private final StGenderService stGenderService;
    private final StPersonTypeService stPersonTypeService;
    private final StPersonService stPersonRepository;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(
            @RequestBody RegisterRequest request
    ) {
        ApiResponse<AuthResponse> response = new ApiResponse<>();

        try {
            // Verificar si el usuario ya existe
            if (stPersonService.existsByEmail(request.getPersonEmail())) {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Email already in use");
                return ResponseEntity.badRequest().body(response);
            }

            // Validar ciudad y país llamando al microservicio
            ApiResponse<CountryDto> countryResponse = countryCityClient.getCountryById(request.getIdCountry());
            if (countryResponse.getStatus() != HttpStatus.OK.value()) {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Country not found");
                return ResponseEntity.badRequest().body(response);
            }

            ApiResponse<CityDto> cityResponse = countryCityClient.getCityById(request.getIdCity());
            if (cityResponse.getStatus() != HttpStatus.OK.value()) {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("City not found");
                return ResponseEntity.badRequest().body(response);
            }

            // Validar género y tipo de persona
            Optional<StGenderEntity> gender = stGenderService.getGenderById(request.getIdGender());
            if (gender.isEmpty()) {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Gender not found");
                return ResponseEntity.badRequest().body(response);
            }

            Optional<StPersonTypeEntity> personType = stPersonTypeService.getPersonTypeById(request.getIdPersonType());
            if (personType.isEmpty()) {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Person Type not found");
                return ResponseEntity.badRequest().body(response);
            }

            // Crear la persona
            StPersonEntity person = new StPersonEntity();
            person.setPersonName(request.getPersonName());
            person.setPersonSurname(request.getPersonSurname());
            person.setPersonEmail(request.getPersonEmail());
            person.setPersonPassword(request.getPersonPassword());
            person.setPersonStatus(1);
            person.setPersonType(personType.get());
            person.setGender(gender.get());
            person.setIdCountry(request.getIdCountry());
            person.setIdCity(request.getIdCity());

            // Setear otros campos si es necesario
            person.setPersonDni(request.getPersonDni());
            person.setPersonBirthdate(request.getPersonBirthdate());
            person.setPersonWhatsappNumber(request.getPersonWhatsappNumber());
            person.setPersonAddress(request.getPersonAddress());

            // Guardar la persona
            Optional<StPersonEntity> savedPerson = stPersonRepository.createPerson(person);

            // Generar token
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getPersonEmail());
            String jwtToken = jwtService.generateToken(userDetails, savedPerson.get());
            String refreshToken = jwtService.generateRefreshToken(userDetails);

            AuthResponse authResponse = AuthResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .build();

            response.setData(authResponse);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("User registered successfully");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Error during registration: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> authenticate(
            @RequestBody AuthRequest request
    ) {
        ApiResponse<AuthResponse> response = new ApiResponse<>();

        try {
            // 1. Autenticar con Spring Security
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getPersonEmail(),
                            request.getPersonPassword()
                    )
            );

            // 2. Verificar que la autenticación fue exitosa
            if (authentication.isAuthenticated()) {
                // 3. Obtener UserDetails
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();

                // 4. Obtener la entidad Person completa
                StPersonEntity person = stPersonService.findByEmail(request.getPersonEmail())
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));

                // 5. Generar tokens
                String jwtToken = jwtService.generateToken(userDetails, person);
                String refreshToken = jwtService.generateRefreshToken(userDetails);

                AuthResponse authResponse = AuthResponse.builder()
                        .accessToken(jwtToken)
                        .refreshToken(refreshToken)
                        .build();

                response.setData(authResponse);
                response.setStatus(HttpStatus.OK.value());
                response.setMessage("Login successful");
                return ResponseEntity.ok(response);
            } else {
                throw new AuthenticationCredentialsNotFoundException("Authentication failed");
            }

        } catch (BadCredentialsException e) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Error during authentication: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<ApiResponse<AuthResponse>> refreshToken(
            @RequestHeader("Authorization") String refreshToken
    ) {
        ApiResponse<AuthResponse> response = new ApiResponse<>();

        try {
            if (refreshToken == null || !refreshToken.startsWith("Bearer ")) {
                throw new IllegalArgumentException("Invalid refresh token");
            }

            String jwt = refreshToken.substring(7);
            String userEmail = jwtService.extractUsername(jwt);

            if (userEmail != null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);

                if (jwtService.isTokenValid(jwt, userDetails)) {
                    // Obtener datos actualizados de la persona
                    StPersonEntity person = stPersonService.findByEmail(userEmail)
                            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

                    // Generar nuevos tokens con información actualizada
                    String newToken = jwtService.generateToken(userDetails, person);
                    String newRefreshToken = jwtService.generateRefreshToken(userDetails);

                    AuthResponse authResponse = AuthResponse.builder()
                            .accessToken(newToken)
                            .refreshToken(newRefreshToken)
                            .build();

                    response.setData(authResponse);
                    response.setStatus(HttpStatus.OK.value());
                    response.setMessage("Token refreshed successfully");
                    return ResponseEntity.ok(response);
                }
            }
            throw new JwtException("Invalid refresh token");

        } catch (JwtException | IllegalArgumentException e) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Invalid refresh token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Error refreshing token: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}