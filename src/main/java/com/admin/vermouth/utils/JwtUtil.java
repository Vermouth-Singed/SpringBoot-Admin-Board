package com.admin.vermouth.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    @Getter
    private String secret;

    public String createToken(String userName){
        LocalDateTime now = LocalDateTime.now();
        now.plusMinutes(10);

        return Jwts.builder().claim("user_name", userName).
                claim("expired_date",now.getYear()+"/"+now.getMonthValue()+"/"+now.getDayOfMonth()+"/"+
                        now.getHour()+"/"+now.getMinute()).
                setExpiration(Date.from(now.toInstant(ZoneOffset.UTC))).
                signWith(Keys.hmacShaKeyFor(this.secret.getBytes()), SignatureAlgorithm.HS256).compact();
    }
}