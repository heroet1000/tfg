package com.tfg.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tfg.tienda.dto.JuegosDTO;
import com.tfg.tienda.model.Juegos;
import com.tfg.tienda.service.JuegoService;

public class JuegoController {
    @Autowired
    private JuegoService service;
 @PostMapping("/save")
    public Juegos save(@RequestBody JuegosDTO dto) {
        return service.save(dto);
    }

    @PostMapping("/edit")
    public Juegos edit(@RequestBody JuegosDTO dto) {
        return service.edit(dto);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody JuegosDTO dto) {
        service.delete(dto);
    }
}
