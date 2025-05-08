package com.tfg.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.tienda.dto.FacturaDTO;
import com.tfg.tienda.model.Factura;
import com.tfg.tienda.security.JwtFilter;
import com.tfg.tienda.service.FacturaService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("factura")
public class FacturaController {
    @Autowired
    private FacturaService service;
    @Autowired
    private JwtFilter filter;

    @PostMapping("/save")
    public Factura save(@RequestBody FacturaDTO dto,HttpServletRequest request) {
        String token= filter.extractToken(request);
        return service.save(dto,token);
    }

    @PostMapping("/edit")
    public Factura edit(@RequestBody FacturaDTO dto) {
        return service.edit(dto);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody FacturaDTO dto) {
        service.delete(dto);
    }

}
