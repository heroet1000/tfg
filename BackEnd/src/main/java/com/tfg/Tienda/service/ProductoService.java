package com.tfg.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.tienda.dto.ProductoDTO;
import com.tfg.tienda.mapper.MapperProducto;
import com.tfg.tienda.model.Producto;
import com.tfg.tienda.repository.ProductoRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class ProductoService {
    @Autowired private ProductoRepository repo;
    @Autowired private MapperProducto mapper;
    public Producto save(ProductoDTO dto){
        Producto producto = mapper.aEntidad(dto);
        return repo.save(producto);
    }
    public Producto edit(ProductoDTO dto){
        Producto producto= repo.findById(dto.id()).orElseThrow(()->new EntityNotFoundException("No se encuentra el producto"));
        Optional.ofNullable(dto.nombre()).ifPresent(producto::setNombre);
        Optional.ofNullable(dto.cantidad()).ifPresent(producto::setCantidad);
        Optional.ofNullable(dto.descripcion()).ifPresent(producto::setDescripcion);
        Optional.ofNullable(dto.precio()).ifPresent(producto::setPrecio);
        return repo.save(producto);
    }
    public void delete(ProductoDTO dto){
        Producto producto= repo.findById(dto.id()).orElseThrow(()->new EntityNotFoundException("No se encuentra el producto"));
        repo.delete(producto);
    }
    public Optional<Producto> findById(Long id){
        return repo.findById(id);
    }
    public List<ProductoDTO> findAll(){
        List<Producto> lista=repo.findAll();
        return mapper.toDtoList(lista);
    }

}

