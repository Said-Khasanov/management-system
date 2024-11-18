package org.example.management_system.mapper;

import org.example.management_system.dto.UserRequestTo;
import org.example.management_system.dto.UserResponseTo;
import org.example.management_system.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserRequestTo userRequestTo);

    UserResponseTo toResponseTo(User user);
}
