package com.tfg.tienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.tienda.dto.JuegosDTO;
import com.tfg.tienda.mapper.MapperJuego;
import com.tfg.tienda.model.Juegos;
import com.tfg.tienda.repository.JuegoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class JuegoService {
    @Autowired private JuegoRepository repo;
    @Autowired private MapperJuego mapper;
    public Juegos save(JuegosDTO dto){
        Juegos juego = mapper.aEntidad(dto);
        return repo.save(juego);
    }
    public Juegos edit(JuegosDTO dto){
        Juegos juego= repo.findById(dto.id()).orElseThrow(()->new EntityNotFoundException("No se encuentra el producto"));
        Optional.ofNullable(dto.nombre()).ifPresent(juego::setNombre);
        Optional.ofNullable(dto.precio()).ifPresent(juego::setPrecio);
        Optional.ofNullable(dto.descripcion()).ifPresent(juego::setDescripcion);
        return repo.save(juego);
    }
    public void delete(JuegosDTO dto){
        Juegos juego= repo.findById(dto.id()).orElseThrow(()->new EntityNotFoundException("No se encuentra el producto"));
        repo.delete(juego);
    }
    public Optional<Juegos> findById(Long id){
        return repo.findById(id);
    }
}
