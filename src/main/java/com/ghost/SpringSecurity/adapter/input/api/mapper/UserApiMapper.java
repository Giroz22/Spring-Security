package com.ghost.SpringSecurity.adapter.input.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.ghost.SpringSecurity.adapter.input.api.dto.request.UserRequest;
import com.ghost.SpringSecurity.adapter.input.api.dto.response.UserResponse;
import com.ghost.SpringSecurity.domain.model.UserModel;

@Mapper(componentModel = "spring")
public interface UserApiMapper {
    @Mappings(
        @Mapping(target = "id", ignore = true)
    )
    UserModel RequestToEntity(UserRequest request);
    UserResponse EntityToResponse(UserModel user);
    List<UserResponse> EntityToResponse(List<UserModel> user);
}
