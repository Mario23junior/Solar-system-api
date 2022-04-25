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

import com.system.systemsola.dto.EarthDTO;
import com.system.systemsola.service.ServiceEarth;

@RestController
@RequestMapping("/api/v1/planetary/earth/")
public class ControllerEarth {

	private ServiceEarth service;

	public ControllerEarth(ServiceEarth service) {
	 		this.service = service;
		}

	@PostMapping
	public ResponseEntity<EarthDTO> save(@RequestBody EarthDTO earthDto) {
		return service.saveBody(earthDto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EarthDTO> list(@PathVariable Long id) {
		return service.listId(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EarthDTO> update(@PathVariable Long id, @RequestBody EarthDTO EarthDto) {
		return service.update(id, EarthDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<EarthDTO> delete(@PathVariable Long id) {
		return service.delete(id);
	}

}
