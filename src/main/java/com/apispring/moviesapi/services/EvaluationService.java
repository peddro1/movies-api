package com.apispring.moviesapi.services;

import java.util.List;

import com.apispring.moviesapi.entities.Evaluation;
import com.apispring.moviesapi.entities.Movie;
import com.apispring.moviesapi.repositories.EvaluationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EvaluationService {
    
    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private MovieService movieService;

    @Transactional
    public Evaluation findById(Long id) throws Exception{
        return this.evaluationRepository.findById(id)
            .orElseThrow(() -> new Exception("Avaliação não encontrada"));
    }

    @Transactional
    public Evaluation save(Evaluation evaluation) throws Exception{
        if(evaluation.getMovie().getId() != null){
            Movie foundMovie = this.movieService.getById(evaluation.getMovie().getId());
            if(foundMovie != null){
                evaluation.setMovie(foundMovie);
            }
        }else{
            this.movieService.save(evaluation.getMovie());
        }
        
       
        return this.evaluationRepository.saveAndFlush(evaluation);
    }

    @Transactional
    public Evaluation update(Evaluation evaluation) throws Exception{
        return this.save(evaluation);
    }

    @Transactional
    public List<Evaluation> findEvaluationsByMovie(Long idMovie) throws Exception{
        Movie mov = this.movieService.getById(idMovie);
        return this.evaluationRepository.findByMovie(mov);
    }
}
