package com.system.systemsola.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.systemsola.dto.UranosDTO;
import com.system.systemsola.service.ServiceUranus;

@RestController
@RequestMapping("/api/v1/planetary/uranos/")
public class ControllerUranos {

	private ServiceUranus service;

	public ControllerUranos(ServiceUranus service) {
	 		this.service = service;
		}

	@PostMapping
	public ResponseEntity<UranosDTO> save(@RequestBody UranosDTO uranoDto) {
		return service.saveBody(uranoDto);
	}
}
