package com.ghost.SpringSecurity.adapter.output.persistence.mapper;

import com.ghost.SpringSecurity.adapter.output.persistence.entities.UserEntity;
import com.ghost.SpringSecurity.domain.model.UserModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T14:05:50-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserPersistenceMapperImpl implements UserPersistenceMapper {

    @Override
    public UserModel entityToModel(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserModel.UserModelBuilder userModel = UserModel.builder();

        userModel.email( entity.getEmail() );
        userModel.id( entity.getId() );
        userModel.name( entity.getName() );
        userModel.nickname( entity.getNickname() );
        userModel.password( entity.getPassword() );

        return userModel.build();
    }

    @Override
    public List<UserModel> entityToModel(List<UserEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<UserModel> list = new ArrayList<UserModel>( entity.size() );
        for ( UserEntity userEntity : entity ) {
            list.add( entityToModel( userEntity ) );
        }

        return list;
    }

    @Override
    public UserEntity modelToEntity(UserModel model) {
        if ( model == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.email( model.getEmail() );
        userEntity.id( model.getId() );
        userEntity.name( model.getName() );
        userEntity.nickname( model.getNickname() );
        userEntity.password( model.getPassword() );

        return userEntity.build();
    }

    @Override
    public void updateUserFromSource(UserEntity source, UserEntity target) {
        if ( source == null ) {
            return;
        }

        if ( source.getEmail() != null ) {
            target.setEmail( source.getEmail() );
        }
        if ( source.getId() != null ) {
            target.setId( source.getId() );
        }
        if ( source.getName() != null ) {
            target.setName( source.getName() );
        }
        if ( source.getNickname() != null ) {
            target.setNickname( source.getNickname() );
        }
        if ( source.getPassword() != null ) {
            target.setPassword( source.getPassword() );
        }
    }
}
