package com.uca.parcialfinalncapas.controller;

import com.uca.parcialfinalncapas.dto.AuthRequest;
import com.uca.parcialfinalncapas.dto.AuthResponse;
import com.uca.parcialfinalncapas.security.JwtUtil;
import com.uca.parcialfinalncapas.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        if (authService.login(request.getCorreo(), request.getPassword())) {
            String token = jwtUtil.generateToken(request.getCorreo());
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(401).body("Correo o contraseña inválidos");
        }
    }
}

