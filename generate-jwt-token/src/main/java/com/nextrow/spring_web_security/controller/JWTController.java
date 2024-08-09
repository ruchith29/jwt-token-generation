package com.nextrow.spring_web_security.controller;

import com.nextrow.spring_web_security.services.SecretKeyService;
import com.nextrow.spring_web_security.services.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTController {

    @Autowired
    private Services services;

    @Autowired
    private SecretKeyService secretKeyService;

    @GetMapping("/getToken")
    public void getToken(){

        String SECRET_KEY=secretKeyService.generateSecretKey();

        String username="bramhi";
        String password="bramhi@143";

        String token=services.generateJWTToken(username,password,SECRET_KEY);

        services.validToken(token,SECRET_KEY);
    }



}