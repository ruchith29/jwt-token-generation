package com.nextrow.spring_web_security.services;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class SecretKeyService {

    public String generateSecretKey(){
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[32]; // 256-bit key
        secureRandom.nextBytes(key);
        String secretKey = Base64.getEncoder().encodeToString(key);

        return secretKey;
    }
}
