package com.uca.parcialfinalncapas.service;

import com.uca.parcialfinalncapas.entities.User;
import com.uca.parcialfinalncapas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String correo, String password) {
        Optional<User> userOpt = userRepository.findByCorreo(correo);
        System.out.println("Correo recibido: " + correo);
        System.out.println("¿Encontró usuario?: " + userOpt.isPresent());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            System.out.println("Contraseña recibida: " + password);
            System.out.println("Contraseña almacenada: " + user.getPassword());
            System.out.println("Comparación: " + password.equals(user.getPassword()));
        }
        return userOpt
                .map(user -> password.equals(user.getPassword()))
                .orElse(false);
    }

}

