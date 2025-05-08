package com.tfg.tienda.mapper;

import org.mapstruct.Mapper;

import com.tfg.tienda.dto.FacturaDTO;
import com.tfg.tienda.model.Factura;

@Mapper(componentModel = "spring")
public interface MapperFactura extends MapperGenerico<FacturaDTO,Factura>{

}
