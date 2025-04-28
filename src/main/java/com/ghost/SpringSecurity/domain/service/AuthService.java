package com.ghost.SpringSecurity.domain.service;

import org.springframework.stereotype.Service;

import com.ghost.SpringSecurity.domain.model.UserModel;
import com.ghost.SpringSecurity.domain.port.input.AuthServicePort;
import com.ghost.SpringSecurity.domain.port.output.UserPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthServicePort {

    private final UserPersistencePort userPersistence;

    @Override
    public String Login(UserModel user) {
        return "";
    }

    @Override
    public String Register(UserModel user) {
        this.userPersistence.create(user);
        return "";
    }
    
}
