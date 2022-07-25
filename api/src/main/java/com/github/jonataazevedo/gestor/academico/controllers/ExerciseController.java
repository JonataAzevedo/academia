package com.github.jonataazevedo.gestor.academico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.jonataazevedo.gestor.academico.model.dto.ExerciseDto;

import com.github.jonataazevedo.gestor.academico.model.entites.Exercise;
import com.github.jonataazevedo.gestor.academico.repository.ExerciseRepository;

import java.util.Optional;
@RestController
@RequestMapping("/exercicios")
public class ExerciseController {
	
	
	@Autowired
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
	
	@GetMapping("/lista") //listar exercicios
	public ResponseEntity<Iterable<Exercise>> obterLista() {
		return ResponseEntity.ok(exerciseRepository.findAll());
	}
	
	@GetMapping(path ="/buscar/{id}") //buscar por id
	public ResponseEntity<?> consultPorId(int id){
		Optional<Exercise> exercise = exerciseRepository.findById(id);
		if(!exercise.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(exercise.get());
	}	
	
	@PutMapping(path = "/alterar/{id}") //alterar por id
	public Exercise alterarPorId(@PathVariable int id,@RequestBody ExerciseDto exerciseDto){
		Optional<Exercise> exercise = exerciseRepository.findById(id);
		
		if(!exercise.isPresent()) {
			return null;
		}
		Exercise instanciaExercise = exercise.get();
		instanciaExercise.setName(exerciseDto.getName());
		instanciaExercise.setSets(exerciseDto.getSets());
		instanciaExercise.setReps(exerciseDto.getReps());
		return exerciseRepository.save(instanciaExercise);
	}
	
	@DeleteMapping(path = "/deletar/{id}") //deletar por id
	public void excluirExercicio(@PathVariable int id) {
		exerciseRepository.deleteById(id);
	}
	
	@GetMapping(path = "/buscar") //busca por nome
	public Iterable<Exercise> obterExercicioPorNome(@RequestParam String nome){
		return exerciseRepository.findByNameContainingIgnoreCase(nome);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
