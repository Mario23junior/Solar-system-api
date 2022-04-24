package com.system.systemsola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.systemsola.model.SystemSolar;

@Repository
public interface RepositorySystemSolar extends JpaRepository<SystemSolar, Long>{

}
