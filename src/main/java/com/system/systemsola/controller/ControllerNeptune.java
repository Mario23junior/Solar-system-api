package com.system.systemsola.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

}
