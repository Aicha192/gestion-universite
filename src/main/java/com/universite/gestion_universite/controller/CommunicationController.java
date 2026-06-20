package com.universite.gestion_universite.controller;

import com.universite.gestion_universite.entity.Communication;
import com.universite.gestion_universite.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/communications")
@CrossOrigin("*")
public class CommunicationController {

  @Autowired
  private CommunicationService service;

  @GetMapping
  public List<Communication> getAll() {
    return service.getAll();
  }

  @PostMapping
  public Communication create(@RequestBody Communication c) {
    return service.save(c);
  }

  @PutMapping("/{id}")
  public Communication update(@PathVariable Long id, @RequestBody Communication c) {
    Communication existing = service.getById(id);

    if (existing != null) {
      existing.setTitre(c.getTitre());
      existing.setTypeReunion(c.getTypeReunion());
      existing.setDate(c.getDate());
      existing.setDocument(c.getDocument());
      return service.save(existing);
    }
    return null;
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}
