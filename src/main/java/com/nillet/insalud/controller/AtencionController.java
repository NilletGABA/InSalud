package com.nillet.insalud.controller;

import com.nillet.insalud.dto.AtencionDTO;
import com.nillet.insalud.service.AtencionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atenciones")
@RequiredArgsConstructor
public class AtencionController {

    private final AtencionService atencionService;

    // ✅ ADMIN: listar todas las atenciones con paginación
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<AtencionDTO>> listar(Pageable pageable) {
        return ResponseEntity.ok(atencionService.listarTodas(pageable));
    }

    // ✅ PACIENTE: listar atenciones del paciente autenticado
    @GetMapping("/mias")
    @PreAuthorize("hasRole('PACIENTE')")
    public ResponseEntity<List<AtencionDTO>> listarMias() {
        return ResponseEntity.ok(atencionService.listarMias());
    }

    // ✅ ADMIN o MEDICO: crear nueva atención
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MEDICO')")
    public ResponseEntity<AtencionDTO> crear(@RequestBody AtencionDTO dto) {
        return new ResponseEntity<>(atencionService.crear(dto), HttpStatus.CREATED);
    }

    // ✅ ADMIN o MEDICO: actualizar
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MEDICO')")
    public ResponseEntity<AtencionDTO> actualizar(@PathVariable Long id, @RequestBody AtencionDTO dto) {
        return ResponseEntity.ok(atencionService.actualizar(id, dto));
    }

    // ✅ ADMIN: eliminar
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        atencionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
