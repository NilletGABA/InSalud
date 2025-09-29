package com.nillet.insalud.service;

import com.nillet.insalud.exception.ResourceNotFoundException;
import com.nillet.insalud.model.MedicoEspecialidad;
import com.nillet.insalud.repository.MedicoEspecialidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoEspecialidadServiceImpl implements MedicoEspecialidadService {

    private final MedicoEspecialidadRepository medicoEspecialidadRepository;

    @Override
    public MedicoEspecialidad asignarEspecialidad(MedicoEspecialidad medicoEspecialidad) {
        return medicoEspecialidadRepository.save(medicoEspecialidad);
    }

    @Override
    public List<MedicoEspecialidad> listar() {
        return medicoEspecialidadRepository.findAll();
    }

    @Override
    public List<MedicoEspecialidad> listarPorEmpleado(Long empleadoId) {
        return medicoEspecialidadRepository.findByEmpleadoId(empleadoId);
    }

    @Override
    public void eliminar(Long id) {
        if (!medicoEspecialidadRepository.existsById(id)) {
            throw new ResourceNotFoundException("Asignación no encontrada con ID: " + id);
        }
        medicoEspecialidadRepository.deleteById(id);
    }
}
