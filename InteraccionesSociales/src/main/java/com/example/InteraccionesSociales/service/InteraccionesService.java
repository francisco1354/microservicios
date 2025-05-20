package com.example.InteraccionesSociales.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InteraccionesSociales.model.Interacciones;
import com.example.InteraccionesSociales.repository.InteraccionesRepository;
import com.example.InteraccionesSociales.webclient.PublicacionesPubli;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InteraccionesService {

    @Autowired
    private InteraccionesRepository interaccionesRepository;
    
    @Autowired
    private PublicacionesPubli publicacionesPubli;

    public List<Interacciones> findAll() {
        return interaccionesRepository.findAll();
    }


    public Interacciones findById(Long id) {
        return interaccionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("interaccion no encontrado"));
    }

    public Interacciones save(Interacciones interacciones){
     // Validar que el cliente exista consultando al cliente-service
     Map<String, Object> publicaciones = publicacionesPubli.getPublicacionesById(interacciones.getId_interaccion());
     if (publicaciones == null || publicaciones.isEmpty()) {
        throw new RuntimeException("Publicaion no encontrada. No se puede crear interaccion.");
     }
     return interaccionesRepository.save(interacciones);

    }


    public Interacciones crearInteraccion(Interacciones interacciones) {
        throw new UnsupportedOperationException("error en crear interaccion");
    }


    public void eliminarInteraccion(Long id) {
        if (interaccionesRepository.existsById(id)) {
            interaccionesRepository.deleteById(id);
    } else {

        throw new UnsupportedOperationException("error al eliminar publicacion");
        }
    }
}




