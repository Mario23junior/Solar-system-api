package com.system.systemsola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.systemsola.model.Neptune;

public interface RepositoryNeptune extends JpaRepository<Neptune, Long>{

	Neptune findByName(String name);

}
