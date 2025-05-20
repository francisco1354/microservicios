package com.example.InteraccionesSociales.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InteraccionesSociales.model.Interacciones;
import com.example.InteraccionesSociales.service.InteraccionesService;

@RestController
@RequestMapping("/api/interacciones")
public class InteraccionesController {

    private final InteraccionesService interaccionesService;

    public InteraccionesController(InteraccionesService interaccionesService) {
        this.interaccionesService = interaccionesService;
    }

    @GetMapping
    public List<Interacciones> getAll() {
        return interaccionesService.findAll();
    }

    @GetMapping("/{id}")
    public Interacciones getById(@PathVariable Long id) {
        return interaccionesService.findById(id);
    }

    @PostMapping
    public Interacciones create(@RequestBody Interacciones interacciones) {
        return interaccionesService.crearInteraccion(interacciones);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        interaccionesService.eliminarInteraccion(id);
    }




}
