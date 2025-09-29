package com.nillet.insalud.service;

import com.nillet.insalud.exception.ResourceNotFoundException;
import com.nillet.insalud.model.Persona;
import com.nillet.insalud.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public Persona crear(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona obtenerPorId(Long id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada"));
    }

    @Override
    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    @Override
    public Persona actualizar(Long id, Persona persona) {
        Persona actual = obtenerPorId(id);
        actual.setNombre(persona.getNombre());
        actual.setEmail(persona.getEmail());
        actual.setEstado(persona.getEstado());
        return personaRepository.save(actual);
    }

    @Override
    public void eliminar(Long id) {
        personaRepository.deleteById(id);
    }
}
