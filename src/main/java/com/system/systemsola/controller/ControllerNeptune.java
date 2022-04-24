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

import com.system.systemsola.dto.NeptuneDTO;
import com.system.systemsola.service.ServiceNeptune;

@RestController
@RequestMapping("/api/v1/planetary/neptune/")
public class ControllerNeptune {

	private ServiceNeptune service;

	public ControllerNeptune(ServiceNeptune service) {
	 		this.service = service;
		}

	@PostMapping
	public ResponseEntity<NeptuneDTO> save(@RequestBody NeptuneDTO neptuneDto) {
		return service.saveBody(neptuneDto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<NeptuneDTO> list(@PathVariable Long id){
		return service.listId(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<NeptuneDTO> update(@PathVariable Long id,@RequestBody NeptuneDTO neptuneDto){
		return service.update(id, neptuneDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<NeptuneDTO> delete(@PathVariable Long id){
		return service.delete(id);
	}

}
