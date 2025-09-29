package com.nillet.insalud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadDTO {
    private Long id;
    private String nombre;
    private Boolean estado;
}
