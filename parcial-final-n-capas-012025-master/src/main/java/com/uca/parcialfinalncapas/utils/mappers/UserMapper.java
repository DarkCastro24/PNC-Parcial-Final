package com.uca.parcialfinalncapas.utils.mappers;

import com.uca.parcialfinalncapas.dto.request.UserCreateRequest;
import com.uca.parcialfinalncapas.dto.request.UserUpdateRequest;
import com.uca.parcialfinalncapas.dto.response.UserResponse;
import com.uca.parcialfinalncapas.entities.User;
import com.uca.parcialfinalncapas.utils.enums.Rol; // Asegúrate de importar el enum
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User toEntityCreate(UserCreateRequest userRequest) {
        return User.builder()
                .nombre(userRequest.getNombre())
                .correo(userRequest.getCorreo())
                .password(userRequest.getPassword())
                .rol(Rol.valueOf(userRequest.getRol().name()))
                .build();
    }

    public static User toEntityUpdate(UserUpdateRequest userUpdate) {
        User.UserBuilder builder = User.builder()
                .id(userUpdate.getId())
                .nombre(userUpdate.getNombre())
                .password(userUpdate.getPassword());

        if (userUpdate.getRol() != null) {
            builder.rol(userUpdate.getRol());
        }

        return builder.build();
    }

    public static UserResponse toDTO(User user) {
        return UserResponse.builder()
                .idUsuario(user.getId())
                .nombre(user.getNombre())
                .correo(user.getCorreo())
                .nombreRol(user.getRol() != null ? user.getRol().name() : null)
                .build();
    }

    public static List<UserResponse> toDTOList(List<User> users) {
        return users.stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }
}
