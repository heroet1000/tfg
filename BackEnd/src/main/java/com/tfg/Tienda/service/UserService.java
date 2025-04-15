package com.tfg.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tfg.tienda.dto.UserDTO;
import com.tfg.tienda.dto.registerDTO;
import com.tfg.tienda.model.User;
import com.tfg.tienda.model.UserRole;
import com.tfg.tienda.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repositorio;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public Optional<User> findByUsername(String username){
        return this.repositorio.findByUsername(username);
        
    }
    public User save(registerDTO dto){

        User user=new User(
            dto.usuario(),
            dto.nombre(),
            passwordEncoder.encode(dto.contrasena()),
            dto.email(),
            List.of(UserRole.USUARIO)

        );
        user.setEnabled(true);
        return repositorio.save(user);
    }
    
}
