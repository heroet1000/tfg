package com.tfg.tienda.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class PruebaSecurity {
    @GetMapping("/prueba")
    public void pruebaSecurity() {
        System.out.println("funciona");
    }
    

}
