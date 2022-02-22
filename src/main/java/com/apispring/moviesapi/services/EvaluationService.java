package com.apispring.moviesapi.services;

import com.apispring.moviesapi.entities.Evaluation;
import com.apispring.moviesapi.repositories.EvaluationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EvaluationService {
    
    @Autowired
    private EvaluationRepository evaluationRepository;

    @Transactional
    public Evaluation findById(Long id) throws Exception{
        return this.evaluationRepository.findById(id)
            .orElseThrow(() -> new Exception("Avaliação não encontrada"));
    }

    @Transactional
    public Evaluation save(Evaluation evaluation){
        return this.evaluationRepository.saveAndFlush(evaluation);
    }

    @Transactional
    public Evaluation update(Evaluation evaluation){
        return this.save(evaluation);
    }
}
