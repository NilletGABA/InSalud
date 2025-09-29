package com.nillet.insalud.service;

import com.nillet.insalud.exception.ResourceNotFoundException;
import com.nillet.insalud.model.Usuario;
import com.nillet.insalud.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
}
