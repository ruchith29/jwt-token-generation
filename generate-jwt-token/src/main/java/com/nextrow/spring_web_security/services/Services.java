package com.nextrow.spring_web_security.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class Services {

    public String generateJWTToken(String username,String password,String SECRET_KEY){

        Claims claims=
                Jwts.claims()
                        .setSubject(username)
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + 3600000));


        String jwtToken = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        System.out.println("Secret Key is: "+SECRET_KEY);
        System.out.println("Generate Token is: "+ jwtToken);

        return jwtToken;

    }

    public void validToken(String jwtToken,String SECRET_KEY){

        Claims token=Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwtToken)
                .getBody();

        System.out.println("Name: " + token.getSubject());
        System.out.println("Start Date: " + token.getIssuedAt());
        System.out.println("End Date: " + token.getExpiration());

    }

}
