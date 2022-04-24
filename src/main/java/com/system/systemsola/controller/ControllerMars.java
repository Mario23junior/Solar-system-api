package com.system.systemsola.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.systemsola.dto.MarsDTO;
import com.system.systemsola.service.ServiceMars;

@RestController
@RequestMapping("/api/v1/planetary/mars/")
public class ControllerMars {

	private ServiceMars service;

	public ControllerMars(ServiceMars service) {
 		this.service = service;
	}

	@PostMapping
	public ResponseEntity<MarsDTO> save(@RequestBody MarsDTO MarsDto) {
		return service.saveBody(MarsDto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<MarsDTO> lists(@PathVariable Long id) {
		return service.listId(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<MarsDTO> update(@PathVariable Long id, @RequestBody MarsDTO marsDto) {
		return service.update(id, marsDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<MarsDTO> delete(@PathVariable Long id) {
		return service.delete(id);
	}

}
