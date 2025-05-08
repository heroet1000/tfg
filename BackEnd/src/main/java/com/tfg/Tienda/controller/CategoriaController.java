package com.tfg.tienda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.tienda.dto.CategoriaDTO;
import com.tfg.tienda.model.Categoria;
import com.tfg.tienda.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @PostMapping("/save")
    public Categoria save(@RequestBody CategoriaDTO dto) {
        return service.save(dto);
    }

    @PostMapping("/edit")
    public Categoria edit(@RequestBody CategoriaDTO dto) {
        return service.edit(dto);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody CategoriaDTO dto) {
        service.delete(dto);
    }

}
