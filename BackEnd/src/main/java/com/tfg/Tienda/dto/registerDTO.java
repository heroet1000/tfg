package com.tfg.tienda.dto;

import java.util.List;

import com.tfg.tienda.model.UserRole;


public record registerDTO(String usuario, String contrasena,String nombre, String ap1, String ap2, String email, List<UserRole> roles) {

}
