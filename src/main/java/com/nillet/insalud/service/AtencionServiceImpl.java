package com.nillet.insalud.service;

import com.nillet.insalud.dto.AtencionDTO;
import com.nillet.insalud.exception.ResourceNotFoundException;
import com.nillet.insalud.model.Atencion;
import com.nillet.insalud.model.Empleado;
import com.nillet.insalud.model.Paciente;
import com.nillet.insalud.model.Usuario;
import com.nillet.insalud.repository.AtencionRepository;
import com.nillet.insalud.repository.EmpleadoRepository;
import com.nillet.insalud.repository.PacienteRepository;
import com.nillet.insalud.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AtencionServiceImpl implements AtencionService {

    private final AtencionRepository atencionRepository;
    private final PacienteRepository pacienteRepository;
    private final EmpleadoRepository empleadoRepository;
    private final UsuarioRepository usuarioRepository;

    //ADMIN: listar todas con paginación
    @Override
    public Page<AtencionDTO> listarTodas(Pageable pageable) {
        return atencionRepository.findAll(pageable)
                .map(this::mapToDTO);
    }

    //PACIENTE: listar atenciones del paciente autenticado
    @Override
    public List<AtencionDTO> listarMias() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // Buscar usuario logueado
        Usuario usuario = usuarioRepository.findByUsuario(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Verificar que tenga un paciente asociado
        Paciente paciente = pacienteRepository.findByPersona(usuario.getPersona())
                .orElseThrow(() -> new RuntimeException("No existe paciente asociado"));

        return atencionRepository.findByPaciente(paciente)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    //ADMIN/MEDICO: crear atención
    @Override
    public AtencionDTO crear(AtencionDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        Empleado empleado = empleadoRepository.findById(dto.getEmpleadoId())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        Atencion atencion = new Atencion();
        atencion.setFecha(dto.getFecha());
        atencion.setMotivo(dto.getMotivo());
        atencion.setEstado(dto.getEstado());
        atencion.setPaciente(paciente);
        atencion.setEmpleado(empleado);

        return mapToDTO(atencionRepository.save(atencion));
    }

    // ADMIN/MEDICO: actualizar atención
    @Override
    public AtencionDTO actualizar(Long id, AtencionDTO dto) {
        Atencion atencion = atencionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atención no encontrada"));

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        Empleado empleado = empleadoRepository.findById(dto.getEmpleadoId())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        atencion.setFecha(dto.getFecha());
        atencion.setMotivo(dto.getMotivo());
        atencion.setEstado(dto.getEstado());
        atencion.setPaciente(paciente);
        atencion.setEmpleado(empleado);

        return mapToDTO(atencionRepository.save(atencion));
    }

    //ADMIN: eliminar atención
    @Override
    public void eliminar(Long id) {
        if (!atencionRepository.existsById(id)) {
            throw new RuntimeException("Atención no encontrada");
        }
        atencionRepository.deleteById(id);
    }

    //Mapper manual
    private AtencionDTO mapToDTO(Atencion atencion) {
        return new AtencionDTO(
                atencion.getId(),
                atencion.getFecha(),
                atencion.getMotivo(),
                atencion.getPaciente().getId(),
                atencion.getEmpleado().getId(),
                atencion.getEstado()
        );
    }
}
