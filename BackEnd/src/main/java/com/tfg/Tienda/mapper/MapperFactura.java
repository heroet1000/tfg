package com.tfg.tienda.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tfg.tienda.dto.FacturaDTO;
import com.tfg.tienda.model.Factura;

@Mapper(componentModel = "spring")
public interface MapperFactura extends MapperGenerico<FacturaDTO,Factura>{
    @Mapping(target = "detalles", ignore = true)
    @Mapping(target = "fecha", ignore = true)
    @Mapping(target = "user", ignore = true)
    Factura aEntidad(FacturaDTO dto);
}
