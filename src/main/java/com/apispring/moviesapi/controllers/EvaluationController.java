package com.apispring.moviesapi.controllers;

import com.apispring.moviesapi.entities.Evaluation;
import com.apispring.moviesapi.services.EvaluationService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("/evaluation")
public class EvaluationController {
    
    private EvaluationService evaluationService;

    @CrossOrigin
    @PostMapping("/save")
    public Mono<Evaluation> save(Evaluation evaluation){
        return Mono.just(this.evaluationService.save(evaluation));
    }

    @CrossOrigin
    @GetMapping("/findById")
    public Mono<Evaluation> findById(@RequestParam("id") Long id) throws Exception{
        return Mono.just(evaluationService.findById(id));
    }

    @CrossOrigin
    @PostMapping("/update")
    public Mono<Evaluation> update(Evaluation evaluation){
        return Mono.just(evaluationService.update(evaluation));
    }

}
