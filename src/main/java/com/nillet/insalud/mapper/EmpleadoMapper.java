package com.nillet.insalud.mapper;


import com.nillet.insalud.dto.EmpleadoDTO;
import com.nillet.insalud.model.Empleado;
import com.nillet.insalud.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmpleadoMapper {

    private final PersonaService personaService;

    public EmpleadoDTO toDTO(Empleado empleado) {
        return new EmpleadoDTO(
                empleado.getId(),
                empleado.getPersona().getId(),
                empleado.getRol(),
                empleado.getEstado()
        );
    }

    public Empleado toEntity(EmpleadoDTO dto) {
        Empleado empleado = new Empleado();
        empleado.setId(dto.getId());
        empleado.setPersona(personaService.obtenerPorId(dto.getPersonaId()));
        empleado.setRol(dto.getRol());
        empleado.setEstado(dto.getEstado());
        return empleado;
    }
}
