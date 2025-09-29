package com.nillet.insalud.service;

import com.nillet.insalud.dto.RegistroUsuarioDTO;
import com.nillet.insalud.model.Empleado;
import com.nillet.insalud.model.Paciente;
import com.nillet.insalud.model.Persona;
import com.nillet.insalud.model.Usuario;
import com.nillet.insalud.repository.EmpleadoRepository;
import com.nillet.insalud.repository.PacienteRepository;
import com.nillet.insalud.repository.PersonaRepository;
import com.nillet.insalud.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;
    private final EmpleadoRepository empleadoRepository;
    private final PacienteRepository pacienteRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registrarUsuario(RegistroUsuarioDTO dto) {

        if (usuarioRepository.existsByUsuario(dto.getUsuario())) {
            throw new RuntimeException("El usuario ya existe");
        }

        if (personaRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }

        // Crear persona
        Persona persona = new Persona();
        persona.setNombre(dto.getNombre());
        persona.setEmail(dto.getEmail());
        persona.setEstado(true);
        personaRepository.save(persona);

        // Crear usuario
        Usuario usuario = new Usuario();
        usuario.setUsuario(dto.getUsuario());
        usuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));
        usuario.setPersona(persona);
        usuarioRepository.save(usuario);

        // Crear paciente o empleado según rol
        switch (dto.getRol().toUpperCase()) {
            case "PACIENTE" -> {
                Paciente paciente = new Paciente();
                paciente.setPersona(persona);
                paciente.setRol("PACIENTE");
                paciente.setEstado(true);
                pacienteRepository.save(paciente);
            }
            case "MEDICO", "ADMIN" -> {
                Empleado empleado = new Empleado();
                empleado.setPersona(persona);
                empleado.setRol(dto.getRol().toUpperCase());
                empleado.setEstado(true);
                empleadoRepository.save(empleado);
            }
            default -> throw new RuntimeException("Rol inválido");
        }
    }
}
