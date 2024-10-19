package com.TradingPlatform.top_developers.models;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;


public class AuthenticationResponse {
    private final String jwt;
    private Object userId;
    private String username;
    private String email;
    private String role;
    private int statusCode;
    private String errorMessage;

    //Constructors
    public AuthenticationResponse(String jwtToken) {
        this.jwt = jwtToken;

        try {
            // Defining a secret key
            String secretKey = "your-secret-key-here"; // Replace with your actual secret key

            @SuppressWarnings("unchecked")
            Jws<Claims> jws = (Jws<Claims>) Jwts.parser().setSigningKey(secretKey).parse(jwtToken);
            Claims claims = jws.getBody();

            this.userId = claims.get("user_id");
            this.username = claims.get("username").toString();
            this.email = claims.get("email").toString();
            this.role = claims.get("role").toString();
            this.statusCode = 200;

        } catch (JwtException e) {
            this.statusCode = 401;
            this.errorMessage = "Invalid JWT token";
        } catch (Exception e) {
            this.statusCode = 500;
            this.errorMessage = "Error parsing JWT token";
        }
    }

    public String getJwt() {
        return jwt;
    }

    public int getUserId() {
        return (int) userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    // Check if authentication was successful
    public boolean isAuthenticated() {
        return statusCode == 200;
    }
}
