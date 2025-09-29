package com.nillet.insalud.mapper;

import com.nillet.insalud.dto.AtencionDTO;
import com.nillet.insalud.model.Atencion;
import com.nillet.insalud.service.EmpleadoService;
import com.nillet.insalud.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AtencionMapper {

    private final PacienteService pacienteService;
    private final EmpleadoService empleadoService;

    public AtencionDTO toDTO(Atencion atencion) {
        return new AtencionDTO(
                atencion.getId(),
                atencion.getFecha(),
                atencion.getMotivo(),
                atencion.getPaciente().getId(),
                atencion.getEmpleado().getId(),
                atencion.getEstado()
        );
    }

    public Atencion toEntity(AtencionDTO dto) {
        Atencion atencion = new Atencion();
        atencion.setId(dto.getId());
        atencion.setFecha(dto.getFecha());
        atencion.setMotivo(dto.getMotivo());
        atencion.setPaciente(pacienteService.obtenerPorId(dto.getPacienteId()));
        atencion.setEmpleado(empleadoService.obtenerPorId(dto.getEmpleadoId()));
        atencion.setEstado(dto.getEstado());
        return atencion;
    }
}
