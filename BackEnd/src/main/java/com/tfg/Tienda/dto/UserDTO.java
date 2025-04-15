package com.tfg.tienda.dto;

import java.util.List;

import com.tfg.tienda.model.UserRole;

public record UserDTO(String usuario, String email, List<String> roles, String token) {

}
