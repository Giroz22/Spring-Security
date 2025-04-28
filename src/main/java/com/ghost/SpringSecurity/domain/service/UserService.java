package com.ghost.SpringSecurity.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ghost.SpringSecurity.domain.model.UserModel;
import com.ghost.SpringSecurity.domain.port.input.UserServicePort;
import com.ghost.SpringSecurity.domain.port.output.UserPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserServicePort{

    private final UserPersistencePort userPersistence;

    @Override
    public List<UserModel> getAll() {
        return this.userPersistence.getAll();
    }

    @Override
    public UserModel getByEmail(String email) {
        return this.userPersistence.findUserByEmail(email);
    }

    @Override
    public UserModel getById(String id) {
        return this.userPersistence.getById(id);
    }

    @Override
    public UserModel update(String id, UserModel entity) {
        return this.userPersistence.update(id, entity);
    }

    @Override
    public void delete(String id) {
        this.userPersistence.delete(id);
    }
}
