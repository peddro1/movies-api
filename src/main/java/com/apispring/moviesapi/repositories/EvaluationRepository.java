package com.apispring.moviesapi.repositories;

import com.apispring.moviesapi.entities.Evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    
}
