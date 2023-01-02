package com.example.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "peliculas")
public class Pelicula {

    @Id
    private String id;
    private String nombre;
    private String director;
}
