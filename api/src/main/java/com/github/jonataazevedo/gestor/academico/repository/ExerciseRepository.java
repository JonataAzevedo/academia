package com.github.jonataazevedo.gestor.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.jonataazevedo.gestor.academico.model.entites.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

}
