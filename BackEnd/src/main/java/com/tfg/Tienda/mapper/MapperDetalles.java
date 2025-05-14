package com.tfg.tienda.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tfg.tienda.dto.DetallesFacturaDTO;
import com.tfg.tienda.model.DetallesFactura;
@Mapper(componentModel = "spring")
public interface MapperDetalles extends MapperGenerico<DetallesFacturaDTO,DetallesFactura>{
    @Mapping(target = "factura", ignore = true)
    @Mapping(target = "producto", ignore = true)
    DetallesFactura aEntidad(DetallesFacturaDTO dto);
}
