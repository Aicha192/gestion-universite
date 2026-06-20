package com.universite.gestion_universite.repository;

import com.universite.gestion_universite.entity.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
}
