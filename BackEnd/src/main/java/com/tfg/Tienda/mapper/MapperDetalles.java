package com.tfg.tienda.mapper;

import org.mapstruct.Mapper;

import com.tfg.tienda.dto.DetallesFacturaDTO;
import com.tfg.tienda.model.DetallesFactura;
@Mapper(componentModel = "spring")
public interface MapperDetalles extends MapperGenerico<DetallesFacturaDTO,DetallesFactura>{

}
