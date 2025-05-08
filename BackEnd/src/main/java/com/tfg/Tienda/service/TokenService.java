package com.tfg.tienda.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {
    @Value("${app.security.jwt.secret}")
    private String jwtSecret;
    private Claims claims;
    private Claims extractFromToken(String token){
        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .build();

        claims = parser.parseClaimsJws(token).getBody();
        
        return claims;


    }
    public Long getId(String token){
        claims=this.extractFromToken(token);
        return ((Number)claims.get("id")).longValue();
    }
}
