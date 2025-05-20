package com.example.Comentarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Comentarios.model.Comentarios;
import com.example.Comentarios.service.ComentariosService;

@RestController
@RequestMapping("microservicios/comentarios")
public class ComentariosController {

    @Autowired
    private ComentariosService comentariosService;

    @GetMapping
    public ResponseEntity<List<Comentarios>> getAllComentarios(){
        List<Comentarios> lista2 = comentariosService.findAll();
    
        if(lista2.isEmpty()){
            //si esta vacia devuelvo un codigo not_content
            return ResponseEntity.noContent().build();
        }
        //si la lista tiene registros
        return ResponseEntity.ok(lista2);
    
    }

    @PostMapping
    public ResponseEntity<?> crearComentario(@RequestBody Comentarios comentarios){
        try{
            Comentarios savedComentarios = comentariosService.save(comentarios);
            return ResponseEntity.status(201).body(savedComentarios);
        }catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
        //return ResponseEntity.status(201).body(comentariosService.save(comentarios));
    }



}
