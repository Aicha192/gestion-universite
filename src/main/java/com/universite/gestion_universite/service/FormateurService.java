package com.universite.gestion_universite.service;

import com.universite.gestion_universite.entity.Formateur;
import com.universite.gestion_universite.repository.FormateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormateurService {

  @Autowired
  private FormateurRepository repository;

  public List<Formateur> getAll() {
    return repository.findAll();
  }

  public Formateur getById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public Formateur save(Formateur f) {
    return repository.save(f);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }
}
