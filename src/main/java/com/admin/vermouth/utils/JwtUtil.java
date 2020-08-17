package com.admin.vermouth.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

//    @Value("${jwt.secret}")
    private String secret = "12345678901234567890123456789012";

    public String createToken(String userId){
        return Jwts.builder().claim("user_id", userId)
                .signWith(Keys.hmacShaKeyFor(this.secret.getBytes()), SignatureAlgorithm.HS256).compact();
    }
}