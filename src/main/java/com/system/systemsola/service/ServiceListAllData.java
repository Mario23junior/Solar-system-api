package com.system.systemsola.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.system.systemsola.dto.SystemSolarDTO;
import com.system.systemsola.model.SystemSolar;
import com.system.systemsola.repository.RepositorySystemSolar;

@Service
public class ServiceListAllData {
  
	private RepositorySystemSolar repository;
	private ModelMapper mapper;
	
	public ServiceListAllData(RepositorySystemSolar repository, ModelMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public List<SystemSolarDTO> listAllDataPlanetary() {
		return ((List<SystemSolar>) repository
				.findAll())
				.stream()
				.map(this::ConvertEntityDataDto)
				.collect(Collectors.toList());
	}

	public SystemSolarDTO ConvertEntityDataDto(SystemSolar systemSolar) {
		mapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		
		SystemSolarDTO systemSolarDto = mapper.map(systemSolar, SystemSolarDTO.class);
		return systemSolarDto;
	}
  
	
	public List<SystemSolarDTO> listAllData() {
		List<SystemSolarDTO> list = listAllDataPlanetary();
		return list
				.stream()
				.collect(Collectors.toList());
	}
	
	
	
	
}
