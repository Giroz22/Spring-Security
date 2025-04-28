package com.ghost.SpringSecurity.adapter.input.api.mapper;

import com.ghost.SpringSecurity.adapter.input.api.dto.request.LoginRequest;
import com.ghost.SpringSecurity.adapter.input.api.dto.request.RegisterRequest;
import com.ghost.SpringSecurity.domain.model.UserModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T14:05:41-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class AuthApiMapperImpl implements AuthApiMapper {

    @Override
    public UserModel loginToUser(LoginRequest request) {
        if ( request == null ) {
            return null;
        }

        UserModel.UserModelBuilder userModel = UserModel.builder();

        userModel.email( request.getEmail() );
        userModel.password( request.getPassword() );

        return userModel.build();
    }

    @Override
    public UserModel registerToUser(RegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        UserModel.UserModelBuilder userModel = UserModel.builder();

        userModel.email( request.getEmail() );
        userModel.name( request.getName() );
        userModel.password( request.getPassword() );

        return userModel.build();
    }
}
