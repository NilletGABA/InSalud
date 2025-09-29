package com.nillet.insalud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="empleados")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "persona_id", nullable = false)
    @JsonBackReference
    private Persona persona;
    @Column(nullable = false)
    private String rol;
    @Column(nullable = false)
    private Boolean estado;

    // Relación con Especialidades (solo si es Médico)
    @OneToMany(mappedBy = "empleado",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicoEspecialidad> especialidads;

    // Relación con Atenciones
    @OneToMany(mappedBy = "empleado",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atencion> atenciones;

}
