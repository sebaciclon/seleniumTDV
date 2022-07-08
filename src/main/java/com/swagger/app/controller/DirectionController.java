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
import com.swagger.app.model.Direction;
import com.swagger.app.model.User;
import com.swagger.app.model.UserFK;
import com.swagger.app.service.DirectionServiceImpl;
import com.swagger.app.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/direction")
@Api(value = "Controlador de direccion", description = "Esta API contiene un CRUD para la clase direccion")
public class DirectionController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private DirectionServiceImpl directionService;

	@ApiOperation(value = "create, Crea una nueva direccion", notes = "Servicio encargado de crear una nueva direccion")
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "Created. La direccion se creo correctamente", response = UserFK.class),
					@ApiResponse(code = 404, message = "Not found. Error al crear la direccion"),
		            @ApiResponse(code = 500, message = "Internal error. Error inesperado del sistema")})
	@PostMapping
	public ResponseEntity<?> create(@RequestBody UserFK u) {
		
		Optional<User> oUser = userService.findById(u.getFk_user());
				
		Direction direction = new Direction();
		direction.setUser(oUser.get());
		direction.setCity(u.getCity());
		direction.setStreet(u.getStreet());
		direction.setNumber(u.getNumber());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(directionService.save(direction));
	}
	
	@ApiOperation(value = "findAll, Retorna una lista de direcciones", notes = "Servicio encargado de listar todas las direcciones")
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "Success. La lista de direcciones se cargo correctamente", response = String.class),
					@ApiResponse(code = 404, message = "Not found. Error al cargar la lista de direcciones"),
		            @ApiResponse(code = 500, message = "Internal error. Error inesperado del sistema")})
	@GetMapping
	public List<Direction> findAll(){
		return directionService.findAll();
	}
	
	@ApiOperation(value = "getById, Retorna una direccion", notes =  "Servicio que devuelve una direccion si existe, cuyo id es pasado por parametro")
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "Success. La direccion se cargo correctamente", response = String.class),
					@ApiResponse(code = 404, message = "Not found. Error al cargar la direccion"),
		            @ApiResponse(code = 500, message = "Internal error. Error inesperado del sistema")})
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Optional<Direction> oDirection = directionService.findById(id);
		
		if(!oDirection.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oDirection);
	}
	
	@ApiOperation(value = "update, actualiza una direccion", notes = "Servicio que actualiza una direccion si existe, la direccion e id son pasados por parametro")
	@ApiResponses(
	value = {
			@ApiResponse(code = 200, message = "Success. La direccion se actualizo correctamente", response = UserFK.class),
			@ApiResponse(code = 404, message = "Not found. Error al actualizar la direccion"),
            @ApiResponse(code = 500, message = "Internal error. Error inesperado del sistema")})
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody UserFK u, @PathVariable Long id) {
		Optional<Direction> oDirection = directionService.findById(id);
		
		Optional<User> userNuevo = userService.findById(u.getFk_user());
		
		if(!oDirection.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		oDirection.get().setUser(userNuevo.get());
		oDirection.get().setCity(u.getCity());
		oDirection.get().setStreet(u.getStreet());
		oDirection.get().setNumber(u.getNumber());
				
		return ResponseEntity.status(HttpStatus.CREATED).body(directionService.save(oDirection.get()));
	}
	
	@ApiOperation(value = "delete, elimina una direccion", notes = "Servicio que elimina una direccion si existe, cuyo id es pasado por parametro")
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "Success. La direccion se elimino correctamente", response = String.class),
					@ApiResponse(code = 404, message = "Not found. Error al eliminar la direccion"),
		            @ApiResponse(code = 500, message = "Internal error. Error inesperado del sistema")})
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Direction> oOrder = directionService.findById(id);
		
		if(!oOrder.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		directionService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	
	
}
