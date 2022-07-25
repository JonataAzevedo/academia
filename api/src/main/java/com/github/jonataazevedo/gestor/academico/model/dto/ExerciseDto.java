package com.github.jonataazevedo.gestor.academico.model.dto;

public class ExerciseDto {
	
	private String name;
	
	private int sets;
	
	private int reps;
	
	public ExerciseDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}	
}
