package com.tfg.tienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.tienda.dto.FacturaDTO;
import com.tfg.tienda.mapper.MapperFactura;
import com.tfg.tienda.model.Factura;
import com.tfg.tienda.repository.FacturaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository repo;
    @Autowired private MapperFactura mapper;
    @Autowired private UserService service;
    @Autowired private TokenService tokenService;
    
    public Factura save(FacturaDTO dto, String token){
        Factura factura = mapper.aEntidad(dto);
        factura.setUser(service.findById(tokenService.getId(token)).orElseThrow(()->new EntityNotFoundException("No se encuentra el usuario")));
        return repo.save(factura);
    }
    public Factura edit(FacturaDTO dto){
        Factura factura= repo.findById(dto.id()).orElseThrow(()->new EntityNotFoundException("No se encuentra la factura"));
        Optional.ofNullable(dto.estado()).ifPresent(factura::setEstado);
        return repo.save(factura);
    }
    public void delete(FacturaDTO dto){
        Factura factura= repo.findById(dto.id()).orElseThrow(()->new EntityNotFoundException("No se encuentra la factura"));
        repo.delete(factura);
    }
}
