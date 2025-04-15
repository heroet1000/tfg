package com.tfg.tienda.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import jakarta.enterprise.inject.Default;
import jakarta.persistence.*;
import jakarta.ws.rs.DefaultValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String username;

    private String nombre;

    private String password;

    private Boolean enabled;
    private String direccion;

    private Long codPostal;

    @Column(nullable = true)

    private Long piso;

    @Column(unique = true)
    private String email;

    private Long numero;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<UserRole> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name())) // Prefijo "ROLE_" requerido por Spring
                                                                                // Security
                .toList();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
    public User(String usuario, String nombre, String contrasena, String email, String direccion,Long codPostal, Long piso, Long numero, List<UserRole> roles){
        this.username=usuario;
        this.nombre=nombre;
        this.password=contrasena;
        this.email=email;
        this.direccion=direccion;
        this.codPostal=codPostal;
        this.piso=piso;
        this.numero=numero;
        this.roles=roles;
    }
    public User(String usuario, String nombre, String contrasena, String email, List<UserRole> roles){
        this.username=usuario;
        this.nombre=nombre;
        this.password=contrasena;
        this.email=email;
        this.roles=roles;
    }
}
