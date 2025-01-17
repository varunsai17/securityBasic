package com.example.springsecuritystarter.controller;

import com.example.springsecuritystarter.configuration.JwtTokenProvider;
import com.example.springsecuritystarter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthenticationProvider authenticationProvider;

    @GetMapping ("/login/{username}/{password}")
    public ResponseEntity<?> login(@PathVariable String username, @PathVariable String password){
        Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(username,password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(jwt);

    }
}
