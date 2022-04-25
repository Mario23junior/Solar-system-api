package com.system.systemsola.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class SystemSolarDTO {

	private String name;
	private String Object;
	private Double idade;
	private String location;
	private Double mass;
	private String nearestStar;
	private String semiEixo;
	private String distanceKuiperCliff;
	
	@OneToMany(mappedBy = "systemSolarDTO", cascade = CascadeType.ALL)
	private List<UranosDTO> uranosDTO;
	
	@OneToMany(mappedBy = "systemSolarDTO", cascade = CascadeType.ALL)
	private List<VenusDTO> venusDTO;
	
	@OneToMany(mappedBy = "systemSolarDTO", cascade = CascadeType.ALL)
	private List<NeptuneDTO> neptunesDTO;
	
	@OneToMany(mappedBy = "systemSolarDTO", cascade = CascadeType.ALL)
	private List<SaturnDTO> saturnsDTO;
	
	@OneToMany(mappedBy = "systemSolarDTO", cascade = CascadeType.ALL)
	private List<MercuryDTO> mercuriyDTO;
	
	@OneToMany(mappedBy = "systemSolarDTO", cascade = CascadeType.ALL)
	private List<MarsDTO> marsDTO;
	
	@OneToMany(mappedBy = "systemSolarDTO", cascade = CascadeType.ALL)
	private List<JupiterDTO> jupiterDTO;
	
	@OneToMany(mappedBy = "systemSolarDTO", cascade = CascadeType.ALL)
	private List<EarthDTO> earthDTO;

	public SystemSolarDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObject() {
		return Object;
	}

	public void setObject(String object) {
		Object = object;
	}

	public Double getIdade() {
		return idade;
	}

	public void setIdade(Double idade) {
		this.idade = idade;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getMass() {
		return mass;
	}

	public void setMass(Double mass) {
		this.mass = mass;
	}

	public String getNearestStar() {
		return nearestStar;
	}

	public void setNearestStar(String nearestStar) {
		this.nearestStar = nearestStar;
	}

	public String getSemiEixo() {
		return semiEixo;
	}

	public void setSemiEixo(String semiEixo) {
		this.semiEixo = semiEixo;
	}

	public String getDistanceKuiperCliff() {
		return distanceKuiperCliff;
	}

	public void setDistanceKuiperCliff(String distanceKuiperCliff) {
		this.distanceKuiperCliff = distanceKuiperCliff;
	}

	public List<UranosDTO> getUranosDTO() {
		return uranosDTO;
	}

	public void setUranosDTO(List<UranosDTO> uranosDTO) {
		this.uranosDTO = uranosDTO;
	}

	public List<VenusDTO> getVenusDTO() {
		return venusDTO;
	}

	public void setVenusDTO(List<VenusDTO> venusDTO) {
		this.venusDTO = venusDTO;
	}

	public List<NeptuneDTO> getNeptunesDTO() {
		return neptunesDTO;
	}

	public void setNeptunesDTO(List<NeptuneDTO> neptunesDTO) {
		this.neptunesDTO = neptunesDTO;
	}

	public List<SaturnDTO> getSaturnsDTO() {
		return saturnsDTO;
	}

	public void setSaturnsDTO(List<SaturnDTO> saturnsDTO) {
		this.saturnsDTO = saturnsDTO;
	}

	public List<MercuryDTO> getMercuriyDTO() {
		return mercuriyDTO;
	}

	public void setMercuriyDTO(List<MercuryDTO> mercuriyDTO) {
		this.mercuriyDTO = mercuriyDTO;
	}

	public List<MarsDTO> getMarsDTO() {
		return marsDTO;
	}

	public void setMarsDTO(List<MarsDTO> marsDTO) {
		this.marsDTO = marsDTO;
	}

	public List<JupiterDTO> getJupiterDTO() {
		return jupiterDTO;
	}

	public void setJupiterDTO(List<JupiterDTO> jupiterDTO) {
		this.jupiterDTO = jupiterDTO;
	}

	public List<EarthDTO> getEarthDTO() {
		return earthDTO;
	}

	public void setEarthDTO(List<EarthDTO> earthDTO) {
		this.earthDTO = earthDTO;
	}
	
	
}
