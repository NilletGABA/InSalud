package com.nillet.insalud.mapper;


import com.nillet.insalud.dto.EspecialidadDTO;
import com.nillet.insalud.model.Especialidad;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EspecialidadMapper {

    public EspecialidadDTO toDTO(Especialidad especialidad) {
        return new EspecialidadDTO(
                especialidad.getId(),
                especialidad.getNombre(),
                especialidad.getEstado()
        );
    }

    public Especialidad toEntity(EspecialidadDTO dto) {
        Especialidad especialidad = new Especialidad();
        especialidad.setId(dto.getId());
        especialidad.setNombre(dto.getNombre());
        especialidad.setEstado(dto.getEstado());
        return especialidad;
    }
}
