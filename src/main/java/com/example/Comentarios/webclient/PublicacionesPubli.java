package com.example.Comentarios.webclient;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;


@Component
public class PublicacionesPubli {

    private final WebClient webClient;

        public PublicacionesPubli(@Value("${publicaciones-service.url}") String publicacionesServiceUrl1) {
        this.webClient = WebClient.builder().baseUrl(publicacionesServiceUrl1).build();
    }





    //devuelve un Map<String, Object>, es decir, una estructura tipo 
    //clave:valor que representa los datos JSON del cliente.
    public Map<String, Object> getPublicacionesById(long id) {
        //vamos a hacer una solicitud HTTP de tipo GET
        //retrieve --> ejecuta la solicitud y obtén la respuesta
        //bodyToMono --ZAquí transformas el cuerpo de la respuesta en un objeto Java
        //es un objeto de programación reactiva que representa un solo valor futuro
        //block --> espera aquí hasta que llegue la respuesta
        return this.webClient.get().uri("/{id}",id).retrieve().onStatus(status -> status.is4xxClientError(), 
        response -> response.bodyToMono(String.class).map(body -> new RuntimeException("Publicaion no encontrada (ID: )" + id + ")" ) ) ).bodyToMono(Map.class).block();    
    }
}



/*
 * Desde pedido-service, antes de guardar un Pedido, consultamos 
 * cliente-service para asegurarnos que el cliente existe.

Usamos WebClient para la llamada HTTP.

Cada microservicio corre en su propio puerto local (8081 y 8082).

No usamos Docker ni Eureka, solo comunicación HTTP local.

Todo verificado fácilmente en Postman.
 */
