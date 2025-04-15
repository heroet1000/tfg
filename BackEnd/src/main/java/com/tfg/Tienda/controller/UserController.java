package com.tfg.tienda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.tienda.dto.LoginDTO;
import com.tfg.tienda.dto.UserDTO;
import com.tfg.tienda.dto.registerDTO;
import com.tfg.tienda.model.User;
import com.tfg.tienda.security.JWTProvider;
import com.tfg.tienda.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    private JWTProvider tokenProvider;
    @Autowired
    private UserService service;
    @Autowired
    private AuthenticationManager authManager;
    @PostMapping("/save")
    public User CreateUser(@RequestBody registerDTO dto) {
        //TODO: process POST request
        
        return service.save(dto);
    }
    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginDTO loginDTO){
        Authentication authDTO = new UsernamePasswordAuthenticationToken(loginDTO.usuario(), loginDTO.contrasena());

        Authentication authentication = this.authManager.authenticate(authDTO);
        User user = (User) authentication.getPrincipal();

        String token = this.tokenProvider.generateToken(authentication);
        System.out.println(token);
        return new UserDTO(
        user.getUsername(),
        user.getEmail(),
        user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList(),
        token
    );
}
    

}
