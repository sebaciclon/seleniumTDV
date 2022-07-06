package com.seleniumTDV.app.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.seleniumTDV.app.model.User;
import com.seleniumTDV.app.service.UserServiceImpl;



@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	// create a new product
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User u) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(u));
	}
	
	// List of products
	
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();
	}
	
	// read an product
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Optional<User> oUser = userService.findById(id);
			
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
	}
	
	// update an product
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User u, @PathVariable Long id) {
		Optional<User> oUser = userService.findById(id);
		
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		oUser.get().setName(u.getName());
		oUser.get().setSurname(u.getSurname());
		oUser.get().setEmail(u.getEmail());
		oUser.get().setUsername(u.getUsername());
		oUser.get().setPassword(u.getPassword());
			
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(oUser.get()));
	}
	
	// delete an product
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<User> oUser = userService.findById(id);
			
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		userService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
