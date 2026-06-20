package com.universite.gestion_universite.service;

import com.universite.gestion_universite.entity.Communication;
import com.universite.gestion_universite.repository.CommunicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunicationService {

  @Autowired
  private CommunicationRepository repository;

  public List<Communication> getAll() {
    return repository.findAll();
  }

  public Communication getById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public Communication save(Communication c) {
    return repository.save(c);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }
}
