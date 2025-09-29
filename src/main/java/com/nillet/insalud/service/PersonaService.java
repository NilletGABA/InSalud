package com.nillet.insalud.service;

import com.nillet.insalud.model.Persona;

import java.util.List;

public interface PersonaService{
    Persona crear(Persona persona);
    Persona obtenerPorId(Long id);
    List<Persona> listar();
    Persona actualizar(Long id, Persona persona);
    void eliminar(Long id);
}
