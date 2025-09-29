package com.nillet.insalud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegistroUsuarioDTO {
    @NotBlank(message = "Usuario Obligatorio")
    private String usuario;
    @NotBlank(message = "Contrasena Obligatorio")
    private String contrasena;
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "Email es obligatorio")
    private String email;
    @NotBlank(message = "ROL es obligatorio")
    private String rol;
}
