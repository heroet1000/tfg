package com.tfg.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfg.tienda.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto,  Long >{

}
