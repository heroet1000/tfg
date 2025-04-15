package com.tfg.tienda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tfg.tienda.service.UserService;


@Configuration
public class UserDetailService implements UserDetailsService {
    @Autowired
    private final UserService userService;

    public UserDetailService(UserService userService){
        this.userService=userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userService.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("no hay ninguna cuenta con el usuario"+username)
        );
    }
    

}
