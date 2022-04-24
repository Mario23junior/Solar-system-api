package com.system.systemsola.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.systemsola.dto.JupiterDTO;
import com.system.systemsola.service.ServiceJupiter;

@RestController
@RequestMapping("/api/v1/planetary/jupiter/")
public class ControllerJupiter {

	private ServiceJupiter service;

	public ControllerJupiter(ServiceJupiter service) {
	 		this.service = service;
		}

	@PostMapping
	public ResponseEntity<JupiterDTO> save(@RequestBody JupiterDTO jupiterDto) {
		return service.saveBody(jupiterDto);
	}
}
