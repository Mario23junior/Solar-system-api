package com.system.systemsola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.systemsola.model.Uranos;

@Repository
public interface RepositoryUranus extends JpaRepository<Uranos, Long>{

	Uranos findByName(String name);

}