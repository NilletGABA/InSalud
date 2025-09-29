package com.nillet.insalud.service;

import com.nillet.insalud.model.Especialidad;
import com.nillet.insalud.repository.EspecialidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecialidadServiceImpl implements EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    @Override
    public Especialidad crear(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public List<Especialidad> listar() {
        return especialidadRepository.findAll();
    }
    @Override
    public Especialidad obtenerPorId(Long id) {
        return especialidadRepository.findById(id)
                .orElse(null);
    }
}
