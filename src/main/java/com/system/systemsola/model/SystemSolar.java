package com.system.systemsola.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SystemSolar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String Object;
	private Double idade;
	private String location;
	private Double mass;
	private String nearestStar;
	private String semiEixo;
	private String distanceKuiperCliff;

	public SystemSolar() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
