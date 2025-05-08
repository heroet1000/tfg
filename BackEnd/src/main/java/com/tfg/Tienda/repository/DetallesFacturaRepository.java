package com.tfg.tienda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfg.tienda.model.DetallesFactura;

public interface DetallesFacturaRepository extends JpaRepository<DetallesFactura,  Long > {

}
