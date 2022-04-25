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


	public List<SystemSolarDTO> listByDataSystemSolar() {
		return ((List<SystemSolar>) repository
				.findAll())
				.stream()
				.map(this::ConverterEntityToDTO)
				.collect(Collectors.toList());
	}

	public SystemSolarDTO ConverterEntityToDTO(SystemSolar systemSolar) {
		mapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		SystemSolarDTO solarDTO = mapper
				.map(systemSolar, SystemSolarDTO.class);
		return solarDTO;
	}

	public List<SystemSolarDTO> listAllData() {
		List<SystemSolarDTO> list = listByDataSystemSolar();
		return list
				.stream()
				.collect(Collectors.toList());
	}

}
