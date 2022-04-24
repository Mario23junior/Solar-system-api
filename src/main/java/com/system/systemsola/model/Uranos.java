package com.system.systemsola.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Uranos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double distanceSun;
	private Double surfaceArea;
	private String gravity;
	private Double radius;
	private Double orbitalPeriod;
	private Boolean moons;
	private Integer qtmoons;
	private Double temMedia;
	private Double temMinima;
	private Double temMaxima;
	
	public Uranos() {
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

	public Double getDistanceSun() {
		return distanceSun;
	}

	public void setDistanceSun(Double distanceSun) {
		this.distanceSun = distanceSun;
	}

	public Double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public String getGravity() {
		return gravity;
	}

	public void setGravity(String gravity) {
		this.gravity = gravity;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Double getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public void setOrbitalPeriod(Double orbitalPeriod) {
		this.orbitalPeriod = orbitalPeriod;
	}

	public Boolean getMoons() {
		return moons;
	}

	public void setMoons(Boolean moons) {
		this.moons = moons;
	}

	public Integer getQtmoons() {
		return qtmoons;
	}

	public void setQtmoons(Integer qtmoons) {
		this.qtmoons = qtmoons;
	}

	public Double getTemMedia() {
		return temMedia;
	}

	public void setTemMedia(Double temMedia) {
		this.temMedia = temMedia;
	}

	public Double getTemMinima() {
		return temMinima;
	}

	public void setTemMinima(Double temMinima) {
		this.temMinima = temMinima;
	}

	public Double getTemMaxima() {
		return temMaxima;
	}

	public void setTemMaxima(Double temMaxima) {
		this.temMaxima = temMaxima;
	}
	
	
}
