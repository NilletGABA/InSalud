package com.nillet.insalud.service;

import com.nillet.insalud.model.Empleado;

import java.util.List;

public interface EmpleadoService {

    Empleado crear(Empleado empleado);
    Empleado obtenerPorId(Long id);
    List<Empleado> listar();
}
