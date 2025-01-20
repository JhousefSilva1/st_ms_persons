package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth;

import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    //@Value("${application.security.jwt.secret-key}")
    private String secretKey = "una1clave2segura3y4mas5larga6para7jwt8256bits";
    //@Value("${application.security.jwt.expiration}")
    private long jwtExpiration = 3600000;
    //@Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration = 3600000;


    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public String generateToken(final StPersonEntity user) {
        return buildToken(user, refreshExpiration);
    }

    public String generateRefreshToken(final StPersonEntity user) {
        return buildToken(user, refreshExpiration);
    }

    private String buildToken(final StPersonEntity user, final long expiration) {
        return Jwts
                .builder()
                .claims(Map.of("name", user.getPersonName()))
                .claims(Map.of("lastName", user.getPersonSurname()))
                .claims(Map.of("email", user.getPersonEmail()))
                .claims(Map.of("role", user.getPersonsType().getPersonType()))
                .subject(user.getPersonEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey())
                .compact();
    }

    public boolean isTokenValid(String token, StPersonEntity user) {
        final String username = extractUsername(token);
        return (username.equals(user.getPersonEmail())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
    }

    private SecretKey getSignInKey() {
        final byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
