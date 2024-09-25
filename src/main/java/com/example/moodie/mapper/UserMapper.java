package com.example.moodie.mapper;

import com.example.moodie.dto.request.RegisterRequest;
import com.example.moodie.dto.response.LoginResponse;
import com.example.moodie.dto.response.RegisterResponse;
import com.example.moodie.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    public void mapRegisterRequestToUser(@MappingTarget User user, RegisterRequest request);
    public void mapUserToRegisterResponse(@MappingTarget RegisterResponse response, User user);
    public void mapUserToLoginResponse(@MappingTarget LoginResponse response, User user);
}
