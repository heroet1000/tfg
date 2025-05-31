package com.tfg.tienda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.tienda.dto.LoginDTO;
import com.tfg.tienda.dto.UserDTO;
import com.tfg.tienda.dto.registerDTO;
import com.tfg.tienda.mapper.MapperUsuario;
import com.tfg.tienda.model.User;
import com.tfg.tienda.model.UserRole;
import com.tfg.tienda.security.JWTProvider;
import com.tfg.tienda.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    private JWTProvider tokenProvider;
    @Autowired
    private UserService service;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired 
    private MapperUsuario mapper;
    @PostMapping("/save")
    public User CreateUser(@RequestBody registerDTO dto) {
        //TODO: process POST request
        
        return service.save(dto);
    }
    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginDTO loginDTO){
        System.out.println(loginDTO.usuario());
        System.out.println(loginDTO.contrasena());
        Authentication authDTO = new UsernamePasswordAuthenticationToken(loginDTO.usuario(), loginDTO.contrasena());

        Authentication authentication = this.authManager.authenticate(authDTO);
        User user = (User) authentication.getPrincipal();

        String token = this.tokenProvider.generateToken(authentication);
        System.out.println(token);
        UserDTO dto=mapper.aDTO(user);
        System.out.println(dto);
        dto.setRoles(user.getAuthorities().stream().map(GrantedAuthority::getAuthority).map(role -> role.replace("ROLE_", "")).map(UserRole::valueOf).toList());
        dto.setToken(token);
        return dto;
}
    @PostMapping("/edit")
    public User EditUser(@RequestBody UserDTO dto) {
        return service.edit(dto);
    }

    

}
