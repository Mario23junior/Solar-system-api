package com.system.systemsola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.systemsola.model.Mercury;

public interface RepositoryMercury extends JpaRepository<Mercury, Long>{

	Mercury findByName(String name);

}
