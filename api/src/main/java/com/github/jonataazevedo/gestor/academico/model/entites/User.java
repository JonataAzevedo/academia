package com.github.jonataazevedo.gestor.academico.model.entites;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Max(100)
	private String nome;

	@NotBlank
	@Max(11)
	private String cpf;

	private String user_type;

	private int version;

	LocalDateTime birth_date;
	LocalDateTime creation_date;
	LocalDateTime update_date;

	public User() {

	}

	public User(String nome, String cpf, String user_type, int version, LocalDateTime birth_date,
			LocalDateTime creation_date, LocalDateTime update_date) {
		this.nome = nome;
		this.cpf = cpf;
		this.user_type = user_type;
		this.version = version;
		this.birth_date = birth_date;
		this.creation_date = creation_date;
		this.update_date = update_date;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public LocalDateTime getBirth_date() {
		return birth_date;
	}

	public LocalDateTime getCreation_date() {
		return creation_date;
	}

	public LocalDateTime getUpdate_date() {
		return update_date;
	}

}
