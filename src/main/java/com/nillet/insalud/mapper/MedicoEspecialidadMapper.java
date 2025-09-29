package com.nillet.insalud.mapper;

import com.nillet.insalud.dto.MedicoEspecialidadDTO;
import com.nillet.insalud.model.MedicoEspecialidad;
import com.nillet.insalud.service.EmpleadoService;
import com.nillet.insalud.service.EspecialidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MedicoEspecialidadMapper {

    private final EmpleadoService empleadoService;
    private final EspecialidadService especialidadService;

    public MedicoEspecialidadDTO toDTO(MedicoEspecialidad me) {
        return new MedicoEspecialidadDTO(
                me.getId(),
                me.getEmpleado().getId(),
                me.getEspecialidad().getId()
        );
    }

    public MedicoEspecialidad toEntity(MedicoEspecialidadDTO dto) {
        MedicoEspecialidad me = new MedicoEspecialidad();
        me.setId(dto.getId());
        me.setEmpleado(empleadoService.obtenerPorId(dto.getEmpleadoId()));
        me.setEspecialidad(especialidadService.obtenerPorId(dto.getEspecialidadId()));
        return me;
    }
}
