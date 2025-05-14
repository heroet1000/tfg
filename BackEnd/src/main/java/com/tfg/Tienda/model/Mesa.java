package com.tfg.tienda.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"  // Usa el campo "id" como identificador único
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long tamaño;
    @Lob  // Para campos grandes (en MySQL se mapea a LONGTEXT)
    @Column(name = "imagen", columnDefinition = "LONGTEXT")
    private String imagen;

}
