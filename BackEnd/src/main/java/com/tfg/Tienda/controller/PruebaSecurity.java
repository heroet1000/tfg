package com.tfg.tienda.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PruebaSecurity {
    @GetMapping("/prueba")
    public void pruebaSecurity() {
        System.out.println("funciona");
    }
    

}
