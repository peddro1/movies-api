package com.apispring.moviesapi.services;

import com.apispring.moviesapi.entities.Movie;
import com.apispring.moviesapi.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public Movie getById(Long id) throws Exception{
        return this.movieRepository.findById(id)
            .orElseThrow( () -> new Exception("Filme não encontrado"));
    }

    @Transactional
    public Movie save(Movie movie){
        return this.movieRepository.saveAndFlush(movie);
    }

    @Transactional
    public Movie update(Movie movie){
        return this.movieRepository.save(movie);
    }
    
}
