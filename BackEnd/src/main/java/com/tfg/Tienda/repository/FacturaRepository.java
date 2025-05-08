package com.tfg.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfg.tienda.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura,  Long >{

}
