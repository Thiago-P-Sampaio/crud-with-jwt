package com.example.login_auth_rest_api_test2.infra.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.login_auth_rest_api_test2.model.User_entity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String GenerateToke(User_entity user){
        try {
        Algorithm AlgorithmCryp = Algorithm.HMAC256(secret);

        String Token = JWT.create()
                .withIssuer("Login-auth")
                .withSubject(user.getEmail())
                .withExpiresAt(this.generateExpirationDate())
                .sign(AlgorithmCryp);
                return Token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("Error Authenticating");
        }


    }
    public String ValidateToken(String Token){
        try {
            Algorithm AlgorithmCryp = Algorithm.HMAC256(secret);
            return JWT.require(AlgorithmCryp)
                    .withIssuer("Login-auth")
                    .build()
                    .verify(Token)
                    .getSubject();
        }catch (JWTVerificationException exception){
           return  null;
        }
    }


    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-3 Horas"));
    }
}
