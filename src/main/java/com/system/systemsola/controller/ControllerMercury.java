package com.system.systemsola.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.systemsola.dto.MercuryDTO;
import com.system.systemsola.service.ServiceMercury;

@RestController
@RequestMapping("/api/v1/planetary/mercury/")
public class ControllerMercury {
 
	private ServiceMercury service;

	public ControllerMercury(ServiceMercury service) {
 		this.service = service;
	}

	@PostMapping
	public ResponseEntity<MercuryDTO> save(@RequestBody MercuryDTO mercuryDTO) {
		return service.saveBody(mercuryDTO);
	}
	
}
