package com.system.systemsola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.systemsola.model.Mars;
import com.system.systemsola.model.Mercury;

public interface RepositoryMars extends JpaRepository<Mars, Long>{

	Mercury findByName(String name);

}
