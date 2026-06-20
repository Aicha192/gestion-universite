package com.universite.gestion_universite.service;

import com.universite.gestion_universite.entity.Formation;
import com.universite.gestion_universite.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationService {

  @Autowired
  private FormationRepository formationRepository;

  public List<Formation> getAll() {
    return formationRepository.findAll();
  }

  public Formation getById(Long id) {
    return formationRepository.findById(id).orElse(null);
  }

  public Formation save(Formation formation) {
    return formationRepository.save(formation);
  }

  public void delete(Long id) {
    formationRepository.deleteById(id);
  }
}
