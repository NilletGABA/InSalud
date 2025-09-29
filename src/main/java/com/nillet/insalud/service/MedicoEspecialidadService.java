package com.nillet.insalud.service;

import com.nillet.insalud.model.MedicoEspecialidad;

import java.util.List;

public interface MedicoEspecialidadService {

    MedicoEspecialidad asignarEspecialidad(MedicoEspecialidad medicoEspecialidad);

    List<MedicoEspecialidad> listar();

    List<MedicoEspecialidad> listarPorEmpleado(Long empleadoId);

    void eliminar(Long id);

}
