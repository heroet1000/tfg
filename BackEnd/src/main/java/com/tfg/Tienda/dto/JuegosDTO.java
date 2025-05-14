package com.tfg.tienda.dto;

import com.tfg.tienda.model.EstadoJuego;

public record JuegosDTO(Long id, String nombre, String descripcion, Double precio, EstadoJuego juego) {

}
