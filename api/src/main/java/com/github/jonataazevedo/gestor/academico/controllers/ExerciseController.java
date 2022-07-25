package com.github.jonataazevedo.gestor.academico.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.jonataazevedo.gestor.academico.model.dto.ExerciseDto;

import com.github.jonataazevedo.gestor.academico.model.entites.Exercise;
import com.github.jonataazevedo.gestor.academico.repository.ExerciseRepository;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
	
	private ExerciseRepository exerciseRepository;
	
	@PostMapping("/novo") //criar novo exercicio
	public ResponseEntity<Exercise> obterExercicio(@RequestBody ExerciseDto exerciseDto){
		Exercise instanciaExercise = new Exercise();
		instanciaExercise.setName(exerciseDto.getName());
		instanciaExercise.setSets(exerciseDto.getSets());
		instanciaExercise.setReps(exerciseDto.getReps());
		Exercise exercise = exerciseRepository.save(instanciaExercise);
		return ResponseEntity.ok(exercise);
	}
}
