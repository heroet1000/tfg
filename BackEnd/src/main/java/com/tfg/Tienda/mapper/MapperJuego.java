package com.tfg.tienda.mapper;

import org.mapstruct.Mapper;

import com.tfg.tienda.dto.JuegosDTO;
import com.tfg.tienda.model.Juegos;
@Mapper(componentModel = "spring")
public interface MapperJuego extends MapperGenerico<JuegosDTO,Juegos>{
    Juegos aEntidad(JuegosDTO dto);
}
