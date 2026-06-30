package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Controller exposing the JWT authenticate endpoint.
 */
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    /**
     * Authenticates user using HTTP Basic credentials sent in Authorization header
     * and returns a generated JWT token.
     * @param authHeader String containing "Basic <base64>" credentials.
     * @return Map containing token key-value mapping.
     */
    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start authenticate");
        LOGGER.debug("authHeader: {}", authHeader);

        String user = getUser(authHeader);
        String token = generateJwt(user);

        Map<String, String> result = new HashMap<>();
        result.put("token", token);

        LOGGER.info("End authenticate");
        return result;
    }

    /**
     * Extracts and decodes the Base64 username from the Authorization header.
     * @param authHeader String auth header.
     * @return String decoded username.
     */
    private String getUser(String authHeader) {
        LOGGER.debug("Start getUser");
        
        // Remove the "Basic " prefix
        String encodedCredentials = authHeader.replace("Basic ", "");
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);
        
        // Split credentials into username and password
        String user = credentials.split(":")[0];
        
        LOGGER.debug("Decoded user: {}", user);
        LOGGER.debug("End getUser");
        return user;
    }

    /**
     * Generates a signed JWT token valid for 20 minutes (1200000 ms).
     * @param user String username subject.
     * @return String compact JWT.
     */
    private String generateJwt(String user) {
        LOGGER.debug("Start generateJwt for user: {}", user);
        
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);

        // Set the token issue time as current time
        builder.setIssuedAt(new Date());

        // Set the token expiry as 20 minutes from now
        builder.setExpiration(new Date(System.currentTimeMillis() + 1200000));
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");

        String token = builder.compact();
        
        LOGGER.debug("Generated Token: {}", token);
        LOGGER.debug("End generateJwt");
        return token;
    }
}
