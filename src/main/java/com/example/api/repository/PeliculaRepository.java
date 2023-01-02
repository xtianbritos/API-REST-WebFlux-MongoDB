package com.example.api.repository;

import com.example.api.model.Pelicula;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends ReactiveMongoRepository<Pelicula, String> {
}
