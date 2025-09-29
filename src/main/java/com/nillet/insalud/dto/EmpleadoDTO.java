package com.nillet.insalud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO {
    private Long id;
    private Long personaId;
    private String rol; // Ejemplo: "MEDICO", "ADMIN"
    private Boolean estado;

}
