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

import com.github.jonataazevedo.gestor.academico.model.dto.UserDto;
import com.github.jonataazevedo.gestor.academico.model.entites.User;
import com.github.jonataazevedo.gestor.academico.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/gestor")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/novo") // criar cadastro
	public ResponseEntity<User> obterUsuario(@RequestBody UserDto userDto) {
		User instanciaUser = new User();
		instanciaUser.setName(userDto.getName());
		instanciaUser.setCpf(userDto.getCpf());
		instanciaUser.setBirthDate(userDto.getBirthDate());
		instanciaUser.setUserType(userDto.getUserType());
		instanciaUser.setUsername(userDto.getUsername());
		instanciaUser.setPassword(userDto.getPassword());
		User user = userRepository.save(instanciaUser);
		return ResponseEntity.ok(user);
	}

	@GetMapping("/cliente") // obter lista de cadastros
	public ResponseEntity<Iterable<User>> obterUsuarios() {
		return ResponseEntity.ok(userRepository.findAll());
	}

	@GetMapping(path = "/busca") // consulta por nome
	public Iterable<User> obterUserPorNome(@RequestParam String nome) {
		return userRepository.findByNameContainingIgnoreCase(nome);
	}

	@GetMapping(path = "/busca/{id}") // consulta por id
	public ResponseEntity<?> buscarPorId(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user.get());
	}

	@PutMapping(path = "/alterar/{id}") // alterar cadastro
	public User alterarUsuario(@PathVariable int id, @RequestBody UserDto userDto) {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent()) {
			return null;
		}
		User instanciaUser = user.get();
		instanciaUser.setName(userDto.getName());
		instanciaUser.setCpf(userDto.getCpf());
		instanciaUser.setBirthDate(userDto.getBirthDate());
		instanciaUser.setUserType(userDto.getUserType());
		instanciaUser.setUsername(userDto.getUsername());
		instanciaUser.setPassword(userDto.getPassword());
		return userRepository.save(instanciaUser);
	}

	@DeleteMapping(path = "/deletar/{id}") // deleter cadastro por id
	public void excluirUsuario(@PathVariable int id) {
		userRepository.deleteById(id);
	}

}
