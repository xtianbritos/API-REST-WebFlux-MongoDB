package com.example.api.controller;

import com.example.api.model.Pelicula;
import com.example.api.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/pelis")
public class PeliculaController {

    @Autowired
    PeliculaRepository repo;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    Flux<Pelicula> read() {
        return repo.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Mono<Pelicula> create(@RequestBody Pelicula p) {
        return repo.save(p);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    Mono<Pelicula> readById(@PathVariable String id) {
        return repo.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    Mono<Pelicula> update(@RequestBody Pelicula datos, @PathVariable String id) {
        Pelicula peliActu = new Pelicula();
        peliActu.setId(id);
        peliActu.setNombre(datos.getNombre());
        peliActu.setDirector(datos.getDirector());
        return repo.save(peliActu);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable String id) {
        return repo.deleteById(id);
    }
}
