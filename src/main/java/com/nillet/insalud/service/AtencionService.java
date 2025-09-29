package com.nillet.insalud.service;

import com.nillet.insalud.dto.AtencionDTO;
import com.nillet.insalud.model.Atencion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AtencionService {
    Page<AtencionDTO> listarTodas(Pageable pageable);       // ADMIN
    List<AtencionDTO> listarMias();                         // PACIENTE
    AtencionDTO crear(AtencionDTO dto);                     // ADMIN/MEDICO
    AtencionDTO actualizar(Long id, AtencionDTO dto);       // ADMIN/MEDICO
    void eliminar(Long id);                                 // ADMIN
}
