package com.github.jonataazevedo.gestor.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.jonataazevedo.gestor.academico.model.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Iterable<User> findByNameContainingIgnoreCase(String nome);

}
