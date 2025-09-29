package com.nillet.insalud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String usuario;
    @Column(nullable = false)
    private String contrasena;

    @OneToOne
    @JoinColumn(name = "persona_id", nullable = false)
    @JsonBackReference
    private Persona persona;


}
