package com.apispring.moviesapi.controllers;

import com.apispring.moviesapi.entities.Movie;
import com.apispring.moviesapi.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("/movie")
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @CrossOrigin
    @PostMapping("/save")
    public Mono<Movie> save(@RequestBody Movie movie){
        return Mono.just(this.movieService.save(movie));
    }

    @CrossOrigin
    @GetMapping("/findById")
    public Mono<Movie> findById(@RequestParam("id") Long id) throws Exception{
        return Mono.just(this.movieService.getById(id));
    }

    @CrossOrigin
    @PostMapping("/update")
    public Mono<Movie> update(@RequestBody Movie movie){
        return Mono.just(this.movieService.save(movie));
    }

}
