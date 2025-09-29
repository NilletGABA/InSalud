package com.nillet.insalud.repository;

import com.nillet.insalud.model.MedicoEspecialidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoEspecialidadRepository extends JpaRepository<MedicoEspecialidad, Long> {
    List<MedicoEspecialidad> findByEmpleadoId(Long empleadoId);
}
