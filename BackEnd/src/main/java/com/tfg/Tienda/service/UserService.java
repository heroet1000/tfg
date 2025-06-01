package com.tfg.tienda.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tfg.tienda.dto.CarroDTO;
import com.tfg.tienda.dto.UserDTO;
import com.tfg.tienda.dto.registerDTO;
import com.tfg.tienda.mapper.MapperUsuario;
import com.tfg.tienda.model.Producto;
import com.tfg.tienda.model.User;
import com.tfg.tienda.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository repositorio;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MapperUsuario mapper;
    @Autowired
    private ProductoService service;
    

    public Optional<User> findByUsername(String username) {
        return this.repositorio.findByUsername(username);

    }

    public Optional<User> findById(Long id) {
        return this.repositorio.findById(id);

    }

    public User save(registerDTO dto) {
        User user = mapper.registro(dto);
        user.setPassword(passwordEncoder.encode(dto.contrasena()));
        user.setRoles(dto.roles());
        user.setEnabled(true);
        return repositorio.save(user);
    }

    public User edit(UserDTO dto) {
        User usuario = repositorio.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra el usuario"));
        Optional.ofNullable(dto.getUsername()).ifPresent(usuario::setNombre);
        Optional.ofNullable(dto.getEmail()).ifPresent(usuario::setEmail);
        Optional.ofNullable(dto.getNombre()).ifPresent(usuario::setNombre);
        Optional.ofNullable(dto.getAp1()).ifPresent(usuario::setAp1);
        usuario.setAp2(dto.getAp2());
        Optional.ofNullable(dto.getRoles()).ifPresent(usuario::setRoles);
        return repositorio.save(usuario);
    }

    public void delete(UserDTO dto) {
        User usuario = repositorio.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra el usuario"));
        repositorio.delete(usuario);
    }

    public Optional<User> findbyId(Long id) {
        return repositorio.findById(id);
    }

    public void anadirAlCarro(CarroDTO dto) {
        User usuario=repositorio.findById(dto.idUsuario()).orElseThrow(() -> new EntityNotFoundException("No se encuentra el usuario"));
        Producto producto=service.findById(dto.idProducto()).orElseThrow(() -> new EntityNotFoundException("No se encuentra el producto"));
        usuario.getCarrito().add(producto);
        repositorio.save(usuario);
    }

}
