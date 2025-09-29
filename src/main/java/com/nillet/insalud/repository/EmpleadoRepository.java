package com.nillet.insalud.repository;

import com.nillet.insalud.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByRol(String rol); // Para filtrar por médicos o admins

}
