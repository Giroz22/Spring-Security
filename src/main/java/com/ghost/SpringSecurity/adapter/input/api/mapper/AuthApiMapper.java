package com.ghost.SpringSecurity.adapter.input.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.ghost.SpringSecurity.adapter.input.api.dto.request.LoginRequest;
import com.ghost.SpringSecurity.adapter.input.api.dto.request.RegisterRequest;
import com.ghost.SpringSecurity.domain.model.UserModel;

@Mapper(componentModel = "spring")
public interface AuthApiMapper {
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "name", ignore = true),
        @Mapping(target = "nickname", ignore = true)
    })
    UserModel loginToUser(LoginRequest request);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "nickname", ignore = true)
    })
    UserModel registerToUser(RegisterRequest request);
}
