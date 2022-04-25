package com.system.systemsola.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.systemsola.dto.SystemSolarDTO;
import com.system.systemsola.service.ServiceListAllData;

@RestController
@RequestMapping("/api/v1/planetary/planetal/")
public class ControllerAllDataSumary {
    
	private ServiceListAllData service;
	
	public ControllerAllDataSumary(ServiceListAllData service) {
		this.service = service;
	}
	
	@GetMapping
	public List<SystemSolarDTO> listAllData(){
		return service.listByDataSystemSolar();
	}
 }
