package com.ghost.SpringSecurity.adapter.output.persistence.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.ghost.SpringSecurity.adapter.output.persistence.entities.UserEntity;
import com.ghost.SpringSecurity.domain.model.UserModel;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {
    UserModel entityToModel(UserEntity entity);
    List<UserModel> entityToModel(List<UserEntity> entity);
    UserEntity modelToEntity(UserModel model);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromSource(UserEntity source, @MappingTarget UserEntity target);
}
