package com.nillet.insalud.mapper;

import com.nillet.insalud.dto.PacienteDTO;
import com.nillet.insalud.model.Paciente;
import com.nillet.insalud.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PacienteMapper {
    private final PersonaService personaService;

    public PacienteDTO toDTO(Paciente paciente) {
        return new PacienteDTO(
                paciente.getId(),
                paciente.getPersona().getId(),
                paciente.getRol(),
                paciente.getEstado()
        );
    }

    public Paciente toEntity(PacienteDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setId(dto.getId());
        paciente.setPersona(personaService.obtenerPorId(dto.getPersonaId()));
        paciente.setRol(dto.getRol());
        paciente.setEstado(dto.getEstado());
        return paciente;
    }
}
