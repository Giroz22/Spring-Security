package com.ghost.SpringSecurity.adapter.input.api.mapper;

import com.ghost.SpringSecurity.adapter.input.api.dto.request.UserRequest;
import com.ghost.SpringSecurity.adapter.input.api.dto.response.UserResponse;
import com.ghost.SpringSecurity.domain.model.UserModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T14:05:34-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserApiMapperImpl implements UserApiMapper {

    @Override
    public UserModel RequestToEntity(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        UserModel.UserModelBuilder userModel = UserModel.builder();

        userModel.email( request.getEmail() );
        userModel.name( request.getName() );
        userModel.nickname( request.getNickname() );
        userModel.password( request.getPassword() );

        return userModel.build();
    }

    @Override
    public UserResponse EntityToResponse(UserModel user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.email( user.getEmail() );
        userResponse.name( user.getName() );
        userResponse.nickname( user.getNickname() );
        userResponse.password( user.getPassword() );

        return userResponse.build();
    }

    @Override
    public List<UserResponse> EntityToResponse(List<UserModel> user) {
        if ( user == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( user.size() );
        for ( UserModel userModel : user ) {
            list.add( EntityToResponse( userModel ) );
        }

        return list;
    }
}
