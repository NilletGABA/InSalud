package com.nillet.insalud.service;

import com.nillet.insalud.model.Paciente;

import java.util.List;

public interface PacienteService {
    Paciente crear(Paciente paciente);
    Paciente obtenerPorId(Long id);
    List<Paciente> listar();

}
