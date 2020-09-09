package com.admin.vermouth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity security) throws Exception{
        security.
                cors().disable().
                csrf().disable().
                formLogin().disable().
                headers().frameOptions().disable();
    }

    public static String passwordEncoder(String target) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");

            sha.update(target.getBytes());

            byte byteData[] = sha.digest();

            StringBuffer result_sbf = new StringBuffer();

            for(byte val : byteData) {
                result_sbf.append(Integer.toString((val & 0xff) + 0x100, 16).substring(1));
            }

            return result_sbf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}