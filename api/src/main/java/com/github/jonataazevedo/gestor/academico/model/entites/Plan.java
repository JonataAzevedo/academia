package com.github.jonataazevedo.gestor.academico.model.entites;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int id_user;

	@NotBlank
	private String name;

	@Min(100)
	private String description;

	@Min(100)
	private String muscle_group;

	private int version;

	LocalDateTime update_date;
	LocalDateTime creation_date;

	public Plan(int id_user, String name, String description, String muscle_group, int version,
			LocalDateTime creation_date, LocalDateTime update_date) {
		this.id_user = id_user;
		this.name = name;
		this.description = description;
		this.muscle_group = muscle_group;
		this.version = version;
		this.creation_date = creation_date;
		this.update_date = update_date;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMuscle_group() {
		return muscle_group;
	}

	public void setMuscle_group(String muscle_group) {
		this.muscle_group = muscle_group;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public LocalDateTime getUpdate_date() {
		return update_date;
	}

	public LocalDateTime getCreation_date() {
		return creation_date;
	}

}
