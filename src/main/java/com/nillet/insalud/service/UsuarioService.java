package com.nillet.insalud.service;

import com.nillet.insalud.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario crear(Usuario usuario);
    Usuario obtenerPorId(Long id);
    List<Usuario> listar();
}
