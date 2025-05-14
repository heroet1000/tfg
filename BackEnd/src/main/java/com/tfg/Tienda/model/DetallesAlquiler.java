package com.tfg.tienda.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"  // Usa el campo "id" como identificador único
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetallesAlquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreJuego;
    private String precioAlquiler;
    @ManyToOne
    @JoinColumn(name = "id_alquiler", nullable = false)
    private Alquiler alquiler;
    @ManyToOne
    @JoinColumn(name = "id_juego", nullable = false)
    private Juegos juego;
}
