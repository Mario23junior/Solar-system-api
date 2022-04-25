package com.system.systemsola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.systemsola.model.Earth;

public interface RepositoryEarth extends JpaRepository<Earth, Long>{

	Earth findByName(String name);

}
