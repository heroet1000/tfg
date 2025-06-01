package com.tfg.tienda.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tfg.tienda.dto.ProductoDTO;
import com.tfg.tienda.model.Producto;
@Mapper(componentModel = "spring")
public interface MapperProducto extends MapperGenerico<ProductoDTO,Producto>{
    @Override
    @Mapping(target="usuarios", ignore=true)
    @Mapping(target = "detallesFactura", ignore = true)
    Producto aEntidad(ProductoDTO dto);
    List<ProductoDTO> toDtoList(List<Producto> productos);

}
