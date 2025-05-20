package com.example.InteraccionesSociales.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "interacciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Interacciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_interaccion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private String usuario;

    @ManyToOne
    @JoinColumn(name = "id_publicacion", nullable = false)
    private long publicacion;

    private LocalDateTime fecha_publicacion;

}
