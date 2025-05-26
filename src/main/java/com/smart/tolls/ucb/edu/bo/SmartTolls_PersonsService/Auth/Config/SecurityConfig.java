package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth.Config;


import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth.JwtAuthFilter;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth.Service.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.protocol.HTTP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;
    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService, JwtAuthFilter jwtAuthFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> {}) // Habilita CORS usando la configuración global de WebMvcConfigurer
                .exceptionHandling(handler ->
                        handler.authenticationEntryPoint((request, response, authException) ->
                                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
                        )
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(auth -> auth
                        // Auth
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()


                        // Persons
                        .requestMatchers(HttpMethod.GET, "/api/persons").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/persons/all").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/persons/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/persons/create").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/persons/update/{id}").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/api/persons/delete").hasRole("ADMINISTRADOR")

                        // Gender
                        .requestMatchers(HttpMethod.GET, "/api/gender").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/gender/all").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/gender/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/gender/create").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/gender/update/{id}").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/api/gender/delete/{id}").hasRole("ADMINISTRADOR")
//                     Person By personTypeId
                        .requestMatchers(HttpMethod.GET, "/api/persons/personType/{id}").permitAll()
                        // PersonsType
                        .requestMatchers(HttpMethod.GET, "/api/personsType").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/personsType/all").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/personsType/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/personsType/create").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/personsType/update/{id}").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/api/personsType/delete/{id}").hasRole("ADMINISTRADOR")

                        // Por defecto, denegar todo lo demás
                        .anyRequest().denyAll()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}