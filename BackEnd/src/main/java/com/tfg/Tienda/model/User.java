package com.tfg.tienda.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"  // Usa el campo "id" como identificador único
)
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String username;

    private String nombre;
    private String ap1;
    @Column(nullable = true)
    private String ap2;

    private String password;

    private Boolean enabled;
    private String direccion;

    private Long codPostal;

    @Column(nullable = true)

    private Long piso;

    @Column(unique = true)
    private String email;

    private Long numero;

    private Double monedero=0.0;
    private Long tel;
    @ManyToMany
    @JoinTable(
        name = "carrito",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private List<Producto> carrito;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<UserRole> roles = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Factura> facturas = new ArrayList<>();

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
    public User(String usuario, String nombre, String ap1, String ap2, String contrasena, String email, String direccion,Long codPostal, Long piso, Long numero, List<UserRole> roles, Long telefono, Double monedero){
        this.username=usuario;
        this.nombre=nombre;
        this.ap1=ap1;
        this.ap2=ap2;
        this.password=contrasena;
        this.email=email;
        this.direccion=direccion;
        this.codPostal=codPostal;
        this.piso=piso;
        this.numero=numero;
        this.roles=roles;
        this.tel=telefono;
        this.monedero=monedero;
    }
    @Builder
    public User(String usuario, String nombre, String ap1, String ap2, String contrasena, String email, List<UserRole> roles, Long telefono, Double monedero){
        this.username=usuario;
        this.nombre=nombre;
        this.ap1=ap1;
        this.ap2=ap2;
        this.password=contrasena;
        this.email=email;
        this.roles=roles;
        this.tel=telefono;
        this.monedero=monedero;
    }

}
