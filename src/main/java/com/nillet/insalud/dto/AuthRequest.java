package com.nillet.insalud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthRequest {
    @NotBlank(message = "Usuario es Obligatorio")
    private String usuario;
    @NotBlank(message = "Contrasena es obligatorio")
    private String contrasena;
}
