package com.nillet.insalud.mapper;

import com.nillet.insalud.dto.PersonaDTO;
import com.nillet.insalud.model.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonaMapper {
    public PersonaDTO toDTO(Persona persona) {
        if (persona == null) return null;

        return new PersonaDTO(
                persona.getId(),
                persona.getNombre(),
                persona.getEmail(),
                persona.getEstado()
        );
    }

    public Persona toEntity(PersonaDTO dto) {
        if (dto == null) return null;

        Persona persona = new Persona();
        persona.setId(dto.getId());
        persona.setNombre(dto.getNombre());
        persona.setEmail(dto.getEmail());
        persona.setEstado(dto.getEstado());
        return persona;
    }
}
