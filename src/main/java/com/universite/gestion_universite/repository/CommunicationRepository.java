package com.universite.gestion_universite.repository;

import com.universite.gestion_universite.entity.Communication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicationRepository extends JpaRepository<Communication, Long> {
}
