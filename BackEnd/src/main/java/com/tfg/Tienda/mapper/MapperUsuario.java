package com.tfg.tienda.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.tfg.tienda.dto.UserDTO;
import com.tfg.tienda.dto.registerDTO;
import com.tfg.tienda.model.User;

@Mapper(componentModel = "spring")
public interface MapperUsuario extends MapperGenerico<UserDTO,User>{
    User aEntidad(UserDTO dto);
    @Mapping(target = "token", ignore = true)
    UserDTO aDto(User usuario);
    User registro(registerDTO dto);
}
