package com.tfg.tienda.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.tfg.tienda.dto.UserDTO;
import com.tfg.tienda.dto.registerDTO;
import com.tfg.tienda.model.User;

@Mapper(componentModel = "spring")
public interface MapperUsuario extends MapperGenerico<UserDTO,User>{
    @Mapping(target  = "contrasena", ignore = true)
    @Mapping(target  = "usuario", source = "username")
    @Mapping(target = "telefono", source = "tel")
    User aEntidad(UserDTO dto);
    @Mapping(target = "token", ignore = true)
    UserDTO aDto(User usuario);
    @Mapping(target = "monedero", ignore = true)
    @Mapping(target = "telefono", source = "tel")
    User registro(registerDTO dto);
}
