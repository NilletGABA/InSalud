package com.nillet.insalud.service;

import com.nillet.insalud.exception.ResourceNotFoundException;
import com.nillet.insalud.model.Paciente;
import com.nillet.insalud.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {
    private final PacienteRepository pacienteRepository;

    @Override
    public Paciente crear(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente obtenerPorId(Long id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));
    }

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }
}
