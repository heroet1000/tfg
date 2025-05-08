package com.tfg.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tfg.tienda.model.Juegos;

public interface JuegoRepository extends JpaRepository<Juegos,  Long >{

}
