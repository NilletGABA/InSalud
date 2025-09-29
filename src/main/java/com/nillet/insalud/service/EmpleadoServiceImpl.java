package com.nillet.insalud.service;

import com.nillet.insalud.exception.ResourceNotFoundException;
import com.nillet.insalud.model.Empleado;
import com.nillet.insalud.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public Empleado crear(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado obtenerPorId(Long id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado"));
    }

    @Override
    public List<Empleado> listar() {
        return empleadoRepository.findAll();
    }
}
