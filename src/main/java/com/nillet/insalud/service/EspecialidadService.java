package com.nillet.insalud.service;

import com.nillet.insalud.model.Especialidad;

import java.util.List;

public interface EspecialidadService {
    Especialidad crear(Especialidad especialidad);
    List<Especialidad> listar();
    Especialidad obtenerPorId(Long id);
}
