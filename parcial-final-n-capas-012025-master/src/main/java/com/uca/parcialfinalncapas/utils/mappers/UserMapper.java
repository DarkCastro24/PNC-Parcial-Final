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
        return User.builder()
                .id(userUpdate.getId())
                .nombre(userUpdate.getNombre())
                .password(userUpdate.getPassword())
                // Convierte String a Enum:
                .rol(Rol.valueOf(userUpdate.getRol().name()))
                .build();
    }

    public static UserResponse toDTO(User user) {
        return UserResponse.builder()
                .idUsuario(user.getId())
                .nombre(user.getNombre())
                .correo(user.getCorreo())
                // Devuelve el nombre del rol como String:
                .nombreRol(user.getRol().name())
                .build();
    }

    public static List<UserResponse> toDTOList(List<User> users) {
        return users.stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }
}
