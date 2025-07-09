package com.uca.parcialfinalncapas.dto;

<<<<<<< HEAD
=======
import jakarta.validation.constraints.NotBlank;
>>>>>>> ed0d9c3709e92100b0b62f983b939ab4d88d3039
import lombok.Data;

@Data
public class AuthRequest {
<<<<<<< HEAD
    private String correo;
    private String password;
}
=======
    @NotBlank
    private String correo;

    @NotBlank
    private String password;
}
>>>>>>> ed0d9c3709e92100b0b62f983b939ab4d88d3039
