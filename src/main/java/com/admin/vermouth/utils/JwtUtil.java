package com.admin.vermouth.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    @Getter
    private String secret;

    public String createToken(String userName){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,10);

        return Jwts.builder().claim("user_name", userName).
                claim("expired_date",calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+
                        "/"+calendar.get(Calendar.DAY_OF_MONTH)+"/"+calendar.get(Calendar.HOUR_OF_DAY)+"/"
                        +calendar.get(Calendar.MINUTE)).
                setExpiration(calendar.getTime()).
                signWith(Keys.hmacShaKeyFor(this.secret.getBytes()), SignatureAlgorithm.HS256).compact();
    }
}