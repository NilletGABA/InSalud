package com.nillet.insalud.repository;

import com.nillet.insalud.model.Atencion;
import com.nillet.insalud.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AtencionRepository extends JpaRepository<Atencion, Long> {
    List<Atencion> findByPacienteId(Long pacienteId);

    List<Atencion> findByEmpleadoId(Long empleadoId);

    List<Atencion> findByFecha(LocalDate fecha);

    List<Atencion> findByPaciente(Paciente paciente);

}
