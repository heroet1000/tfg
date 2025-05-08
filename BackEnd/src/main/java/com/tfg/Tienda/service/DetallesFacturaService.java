package com.tfg.tienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.tienda.dto.DetallesFacturaDTO;

import com.tfg.tienda.mapper.MapperDetalles;

import com.tfg.tienda.model.DetallesFactura;

import com.tfg.tienda.repository.DetallesFacturaRepository;


import jakarta.persistence.EntityNotFoundException;
@Service
public class DetallesFacturaService {
    @Autowired
    private DetallesFacturaRepository repo;
    @Autowired 
    private MapperDetalles mapper;
    
    public DetallesFactura save(DetallesFacturaDTO dto){
        DetallesFactura factura = mapper.aEntidad(dto);
        return repo.save(factura);
    }
    public void delete(DetallesFacturaDTO dto){
        DetallesFactura factura= repo.findById(dto.id()).orElseThrow(()->new EntityNotFoundException("No se encuentra la factura"));
        repo.delete(factura);
    }
}
