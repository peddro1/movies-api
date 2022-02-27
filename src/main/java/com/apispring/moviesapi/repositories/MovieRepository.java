package com.apispring.moviesapi.repositories;

import java.util.List;

import com.apispring.moviesapi.entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

    List<Movie> findByIdAPI(Long idAPI);
    
}
