package com.TradingPlatform.top_developers.controllers;


import com.TradingPlatform.top_developers.models.AuthenticationRequest;
import com.TradingPlatform.top_developers.models.AuthenticationResponse;
import com.TradingPlatform.top_developers.models.User;
import com.TradingPlatform.top_developers.services.CustomUserDetailsService;
import com.TradingPlatform.top_developers.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Invalid credentials", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return new AuthenticationResponse(jwt);
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        // Add logic to save user in the database
        return "User registered successfully!";
    }
}
