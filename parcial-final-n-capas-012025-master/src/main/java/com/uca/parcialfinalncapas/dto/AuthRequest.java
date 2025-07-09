package com.uca.parcialfinalncapas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRequest {
    @NotBlank
    private String correo;

    @NotBlank
    private String password;
}
