package com.tfg.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.tienda.dto.CategoriaDTO;
import com.tfg.tienda.mapper.MapperCategoria;
import com.tfg.tienda.model.Categoria;
import com.tfg.tienda.repository.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;
    @Autowired
    private MapperCategoria mapper;

    public Categoria save(CategoriaDTO dto) {
        Categoria categoria = mapper.aEntidad(dto);
        return repo.save(categoria);
    }

    public Categoria edit(CategoriaDTO dto) {
        Categoria categoria = repo.findById(dto.id())
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra la categoria"));
        return repo.save(categoria);
    }
    public void delete(CategoriaDTO dto){
        Categoria categoria = repo.findById(dto.id())
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra la categoria"));
        repo.delete(categoria);
    }

}
