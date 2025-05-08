package com.tfg.tienda.dto;

import com.tfg.tienda.model.Categoria;

public record ProductoDTO(Long id, String nombre, String descripcion, Double precio, Long cantidad, Categoria categoria) {

}
