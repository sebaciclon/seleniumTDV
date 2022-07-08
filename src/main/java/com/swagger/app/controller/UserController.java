package com.swagger.app.controller;

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
import com.swagger.app.model.User;
import com.swagger.app.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/user")
@Api(value = "Controlador de usuario", description = "Esta API contiene un CRUD para la clase usuario")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@ApiOperation(value = "create, Crea un nuevo usuario", notes = "Servicio encargado de crear un nuevo usuario")
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "Success. El usuario se cargo correctamente", response = String.class),
					@ApiResponse(code = 404, message = "Not found. Error al cargar el usuario"),
		            @ApiResponse(code = 500, message = "Internal error. Error inesperado del sistema")})
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User u) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(u));
	}
	
	@ApiOperation(value = "findAll, Retorna una lista de usuarios", notes = "Servicio encargado de listar todos los usuarios")
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "Success. La lista de usuarios se cargo correctamente", response = String.class),
					@ApiResponse(code = 404, message = "Not found. Error al cargar la lista de usuarios"),
		            @ApiResponse(code = 500, message = "Internal error. Error inesperado del sistema")})
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@ApiOperation(value = "getById, Retorna un usuario", notes =  "Servicio que devuelve un usuario si existe, cuyo id es pasado por parametro")
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "Success. El usuario se cargo correctamente", response = String.class),
					@ApiResponse(code = 404, message = "Not found. Error al cargar el usuario"),
		            @ApiResponse(code = 500, message = "Internal error. Error inesperado del sistema")})
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Optional<User> oUser = userService.findById(id);
			
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
	}
	
	@ApiOperation(value = "update, actualiza un usuario", notes = "Servicio que actualiza un usuario si existe, el usuario e id son pasados por parametro")
	@ApiResponses(
	value = {
			@ApiResponse(code = 200, message = "Success. El usuario se actualizo correctamente", response = String.class),
			@ApiResponse(code = 404, message = "Not found. Error al actualizar el usuario"),
            @ApiResponse(code = 500, message = "Internal error. Error inesperado del sistema")})
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User u, @PathVariable Long id) {
		Optional<User> oUser = userService.findById(id);
		
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		oUser.get().setName(u.getName());
		oUser.get().setSurname(u.getSurname());
		oUser.get().setEmail(u.getEmail());
		oUser.get().setEdad(u.getEdad());
			
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(oUser.get()));
	}
	
	@ApiOperation(value = "delete, elimina un usuario", notes = "Servicio que elimina un usuario si existe, cuyo id es pasado por parametro")
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "Success. El usuario se elimino correctamente", response = String.class),
					@ApiResponse(code = 404, message = "Not found. Error al eliminar el usuario"),
		            @ApiResponse(code = 500, message = "Internal error. Error inesperado del sistema")})
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
