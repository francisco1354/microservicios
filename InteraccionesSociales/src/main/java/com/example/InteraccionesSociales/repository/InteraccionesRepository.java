package com.example.InteraccionesSociales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.InteraccionesSociales.model.Interacciones;


@Repository
public interface InteraccionesRepository extends JpaRepository<Interacciones, Long>{

}
