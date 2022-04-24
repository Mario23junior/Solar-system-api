package com.system.systemsola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.systemsola.model.SolaSystem;

@Repository
public interface RepositorySystemSolar extends JpaRepository<SolaSystem, Long>{

}
