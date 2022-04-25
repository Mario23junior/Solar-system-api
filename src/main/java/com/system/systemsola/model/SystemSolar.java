package com.system.systemsola.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SystemSolar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String Object;
	private Double idade;
	private String location;
	private Double mass;
	private String nearestStar;
	private String semiEixo;
	private String distanceKuiperCliff;
	
	@OneToMany(mappedBy = "systemSolar", cascade = CascadeType.ALL)
	private List<Uranos> uranos;
	
	@OneToMany(mappedBy = "systemSolar", cascade = CascadeType.ALL)
	private List<Venus> venus;
	
	@OneToMany(mappedBy = "systemSolar", cascade = CascadeType.ALL)
	private List<Neptune> neptunes;
	
	@OneToMany(mappedBy = "systemSolar", cascade = CascadeType.ALL)
	private List<Saturn> saturns;
	
	@OneToMany(mappedBy = "systemSolar", cascade = CascadeType.ALL)
	private List<Mercury> mercuriy;
	
	@OneToMany(mappedBy = "systemSolar", cascade = CascadeType.ALL)
	private List<Mars> mars;
	
	@OneToMany(mappedBy = "systemSolar", cascade = CascadeType.ALL)
	private List<Jupiter> jupiter;
	
	@OneToMany(mappedBy = "systemSolar", cascade = CascadeType.ALL)
	private List<Earth> earth;
 
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

	public List<Uranos> getUranos() {
		return uranos;
	}

	public void setUranos(List<Uranos> uranos) {
		this.uranos = uranos;
	}

	public List<Venus> getVenus() {
		return venus;
	}

	public void setVenus(List<Venus> venus) {
		this.venus = venus;
	}

	public List<Neptune> getNeptunes() {
		return neptunes;
	}

	public void setNeptunes(List<Neptune> neptunes) {
		this.neptunes = neptunes;
	}

	public List<Saturn> getSaturns() {
		return saturns;
	}

	public void setSaturns(List<Saturn> saturns) {
		this.saturns = saturns;
	}

	public List<Mercury> getMercuriy() {
		return mercuriy;
	}

	public void setMercuriy(List<Mercury> mercuriy) {
		this.mercuriy = mercuriy;
	}

	public List<Mars> getMars() {
		return mars;
	}

	public void setMars(List<Mars> mars) {
		this.mars = mars;
	}

	public List<Jupiter> getJupiter() {
		return jupiter;
	}

	public void setJupiter(List<Jupiter> jupiter) {
		this.jupiter = jupiter;
	}

	public List<Earth> getEarth() {
		return earth;
	}

	public void setEarth(List<Earth> earth) {
		this.earth = earth;
	}
	
	

}
