package com.nillet.insalud.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoEspecialidadDTO {
    private Long id;
    private Long empleadoId;
    private Long especialidadId;
}
