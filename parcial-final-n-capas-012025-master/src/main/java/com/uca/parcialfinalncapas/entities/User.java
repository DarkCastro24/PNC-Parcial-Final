package com.uca.parcialfinalncapas.entities;

import com.uca.parcialfinalncapas.utils.enums.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol; // USER o TECH
}
