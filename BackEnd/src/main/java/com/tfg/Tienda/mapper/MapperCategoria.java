package com.tfg.tienda.mapper;

import org.mapstruct.Mapper;

import com.tfg.tienda.dto.CategoriaDTO;
import com.tfg.tienda.model.Categoria;

@Mapper(componentModel = "spring")
public interface MapperCategoria extends MapperGenerico<CategoriaDTO,Categoria>{

}
