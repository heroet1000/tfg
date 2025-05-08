package com.tfg.tienda.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tfg.tienda.dto.UserDTO;
import com.tfg.tienda.dto.registerDTO;
import com.tfg.tienda.model.User;
@Mapper(componentModel = "spring")
public interface MapperUsuario extends MapperGenerico<UserDTO,User>{
    @Override
    @Mapping(target = "token",ignore = true)
    @Mapping(source = "username", target = "usuario")
    @Mapping(source = "password", target = "contrasena")
    @Mapping(target = "roles", ignore = true)
    UserDTO aDTO(User entidad);
    @Override
    User aEntidad(UserDTO dto);
    @Mapping(target = "contrasena",ignore = true)
    @Mapping(target = "roles", ignore = true)
    User registro(registerDTO registro);

}
