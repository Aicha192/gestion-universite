package com.universite.gestion_universite.repository;

import com.universite.gestion_universite.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Long> {
}
