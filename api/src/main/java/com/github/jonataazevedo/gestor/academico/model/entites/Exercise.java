package com.github.jonataazevedo.gestor.academico.model.entites;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	private String name;

	private int sets;

	private int reps;

	private int version;

	LocalDateTime update_date;
	LocalDateTime creation_date;

	public Exercise() {

	}

	public Exercise(String name, int sets, int reps, int version, LocalDateTime creation_date,
			LocalDateTime update_date) {
		this.name = name;
		this.sets = sets;
		this.reps = reps;
		this.version = version;
		this.creation_date = creation_date;
		this.update_date = update_date;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
