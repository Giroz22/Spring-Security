package com.ghost.SpringSecurity.adapter.input.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghost.SpringSecurity.adapter.input.api.dto.request.LoginRequest;
import com.ghost.SpringSecurity.adapter.input.api.dto.request.RegisterRequest;
import com.ghost.SpringSecurity.adapter.input.api.dto.response.AuthResponse;
import com.ghost.SpringSecurity.adapter.input.api.mapper.AuthApiMapper;
import com.ghost.SpringSecurity.domain.port.input.AuthServicePort;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(name = "/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServicePort authService;
    private final AuthApiMapper mapper;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok().body(
            AuthResponse.builder()
            .token(this.authService.Register(
                this.mapper.registerToUser(request)
            ))
            .build()
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok().body(
            AuthResponse.builder()
            .token(this.authService.Login(
                this.mapper.loginToUser(request)
            ))
            .build()
        );
    }
    
    
}
