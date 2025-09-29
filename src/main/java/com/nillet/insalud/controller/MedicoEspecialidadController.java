package com.nillet.insalud.controller;
import com.nillet.insalud.model.MedicoEspecialidad;
import com.nillet.insalud.service.MedicoEspecialidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medico-especialidades")
@RequiredArgsConstructor
public class MedicoEspecialidadController {

    private final MedicoEspecialidadService medicoEspecialidadService;

    @PostMapping
    public ResponseEntity<MedicoEspecialidad> asignar(@RequestBody MedicoEspecialidad me) {
        return new ResponseEntity<>(medicoEspecialidadService.asignarEspecialidad(me), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicoEspecialidad>> listar() {
        return ResponseEntity.ok(medicoEspecialidadService.listar());
    }

    @GetMapping("/empleado/{empleadoId}")
    public ResponseEntity<List<MedicoEspecialidad>> listarPorEmpleado(@PathVariable Long empleadoId) {
        return ResponseEntity.ok(medicoEspecialidadService.listarPorEmpleado(empleadoId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        medicoEspecialidadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
