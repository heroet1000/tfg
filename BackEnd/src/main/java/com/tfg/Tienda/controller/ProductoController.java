package com.tfg.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.tienda.dto.ProductoDTO;
import com.tfg.tienda.model.Producto;
import com.tfg.tienda.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService service;

    @PostMapping("/save")
    public Producto save(@RequestBody ProductoDTO dto) {
        return service.save(dto);
    }

    @PostMapping("/edit")
    public Producto edit(@RequestBody ProductoDTO dto) {
        return service.edit(dto);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody ProductoDTO dto) {
        service.delete(dto);
    }
    @GetMapping("/findall")
    public List<ProductoDTO> findall() {
        return service.findAll();
    }
    

}
