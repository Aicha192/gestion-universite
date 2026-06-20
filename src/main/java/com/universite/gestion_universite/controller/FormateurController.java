package com.universite.gestion_universite.controller;

import com.universite.gestion_universite.entity.Formateur;
import com.universite.gestion_universite.service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formateurs")
@CrossOrigin("*")
public class FormateurController {

  @Autowired
  private FormateurService service;

  @GetMapping
  public List<Formateur> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public Formateur getById(@PathVariable Long id) {
    return service.getById(id);
  }

  @PostMapping
  public Formateur create(@RequestBody Formateur f) {
    return service.save(f);
  }

  @PutMapping("/{id}")
  public Formateur update(@PathVariable Long id, @RequestBody Formateur f) {
    Formateur existing = service.getById(id);

    if (existing != null) {
      existing.setNom(f.getNom());
      existing.setEmail(f.getEmail());
      existing.setSpecialite(f.getSpecialite());
      existing.setType(f.getType());
      return service.save(existing);
    }
    return null;
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}
