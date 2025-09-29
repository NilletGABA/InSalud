package com.nillet.insalud.repository;

import com.nillet.insalud.model.Paciente;
import com.nillet.insalud.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByPersona(Persona persona);

}
