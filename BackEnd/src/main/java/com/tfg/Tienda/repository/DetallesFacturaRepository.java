package com.tfg.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfg.tienda.model.DetallesFactura;

public interface DetallesFacturaRepository extends JpaRepository<DetallesFactura,  Long > {
    List<DetallesFactura> findByFacturaId(Long id);
}
