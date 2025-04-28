package com.ghost.SpringSecurity.adapter.output.persistence.adapter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ghost.SpringSecurity.adapter.output.persistence.entities.UserEntity;
import com.ghost.SpringSecurity.adapter.output.persistence.mapper.UserPersistenceMapper;
import com.ghost.SpringSecurity.adapter.output.persistence.repository.UserRepository;
import com.ghost.SpringSecurity.domain.model.UserModel;
import com.ghost.SpringSecurity.domain.port.output.UserPersistencePort;
import com.ghost.SpringSecurity.infrastructure.exception.EmailNotFoundException;
import com.ghost.SpringSecurity.infrastructure.exception.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort{

    private final UserRepository userRepository;

    private final UserPersistenceMapper userMapper;

    @Override
    public UserModel create(UserModel entity) {
        UserEntity userEntity = this.userMapper.modelToEntity(entity);

        UserEntity userSaved = this.userRepository.save(userEntity);

        return this.userMapper.entityToModel(userSaved);
    }

    @Override
    public UserModel update(String id, UserModel entity) {
        UserEntity user = this.find(id);
        UserEntity userUpdate = this.userMapper.modelToEntity(entity);
        this.userMapper.updateUserFromSource(userUpdate, user);

        UserEntity userUpdated = this.userRepository.save(user);
        
        return this.userMapper.entityToModel(userUpdated);
    }

    @Override
    public List<UserModel> getAll() {
        return this.userMapper.entityToModel(this.userRepository.findAll());
    }

    @Override
    public UserModel getById(String id) {
        return this.userMapper.entityToModel(this.find(id));
    }

    @Override
    public void delete(String id) {
        UserEntity user = this.find(id);
        this.userRepository.delete(user);
    }

    @Override
    public UserModel findUserByEmail(String Email) {
        UserEntity userEntity = this.userRepository.findByEmail(Email).orElseThrow(() -> new EmailNotFoundException());

        return this.userMapper.entityToModel(userEntity);
    }

    private UserEntity find(String id){
        return this.userRepository.findById(id).orElseThrow(() -> new IdNotFoundException("usuario"));
    }
    
}
