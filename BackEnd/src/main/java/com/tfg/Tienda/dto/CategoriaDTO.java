package com.tfg.tienda.dto;

import java.util.List;

import com.tfg.tienda.model.Producto;

public record CategoriaDTO(Long id, String nombre, String descripcion, List<Producto> productos) {

}
