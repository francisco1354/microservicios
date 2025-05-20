package com.example.Comentarios.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Comentarios.model.Comentarios;
import com.example.Comentarios.repository.ComentariosRepository;
import com.example.Comentarios.webclient.PublicacionesPubli;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComentariosService {

    @Autowired
    private ComentariosRepository comentariosRepository;

    @Autowired
    private PublicacionesPubli publicacionesPubli;

    public List<Comentarios> findAll(){
        return comentariosRepository.findAll();
    }

    public Comentarios save(Comentarios comenetarios){
     // Validar que el cliente exista consultando al cliente-service
     Map<String, Object> publicaciones = publicacionesPubli.getPublicacionesById(comenetarios.getId_comentario());
     if (publicaciones == null || publicaciones.isEmpty()) {
        throw new RuntimeException("Publicaion no encontrada. No se puede crear comentario.");
     }
     return comentariosRepository.save(comenetarios);

    }
}
