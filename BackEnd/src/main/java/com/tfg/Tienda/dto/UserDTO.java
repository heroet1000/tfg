package com.tfg.tienda.dto;

import java.util.List;

import com.tfg.tienda.model.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String usuario;
    private String contrasena;
    private String nombre;
    private String ap1;
    private String ap2;
    private String email;
    private List<UserRole> roles;
    private String token;
}
