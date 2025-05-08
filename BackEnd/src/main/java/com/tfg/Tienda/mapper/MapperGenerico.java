package com.tfg.tienda.mapper;


public interface MapperGenerico<D, E> {
    D aDTO(E entidad);

    E aEntidad(D dto);
}
