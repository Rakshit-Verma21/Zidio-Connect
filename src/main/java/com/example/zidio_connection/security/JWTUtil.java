package com.example.zidio_connection.security;

import java.util.Date;

import com.example.zidio_connection.Enum.Role;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;

@Component
public class JWTUtil {

    private final String SECRET_KEY="zidio_secret_key";


    public String generateToken(String email, Role role) {

        return Jwts.builder().
                setSubject(email).
                claim("role",role).
                setIssuedAt(new Date()).
                setExpiration(new Date(System.currentTimeMillis()+36000)).
                signWith(SignatureAlgorithm.HS256,SECRET_KEY).
                compact();

    }


    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }


    public Claims getClaims(String token) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));

        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims;
    }
}
