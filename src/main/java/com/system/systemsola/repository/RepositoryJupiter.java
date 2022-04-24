package com.system.systemsola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.systemsola.model.Jupiter;

public interface RepositoryJupiter extends JpaRepository<Jupiter, Long>{

	Jupiter findByName(String name);

}
