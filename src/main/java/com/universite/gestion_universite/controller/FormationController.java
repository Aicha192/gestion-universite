package com.universite.gestion_universite.controller;

import com.universite.gestion_universite.entity.Formation;
import com.universite.gestion_universite.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formations")
@CrossOrigin("*")
public class FormationController {

  @Autowired
  private FormationService formationService;

  @GetMapping
  public List<Formation> getAll() {
    return formationService.getAll();
  }

  @GetMapping("/{id}")
  public Formation getById(@PathVariable Long id) {
    return formationService.getById(id);
  }

  @PostMapping
  public Formation create(@RequestBody Formation formation) {
    return formationService.save(formation);
  }

  @PutMapping("/{id}")
  public Formation update(@PathVariable Long id, @RequestBody Formation formation) {
    Formation existing = formationService.getById(id);

    if (existing != null) {
      existing.setNomFormation(formation.getNomFormation());
      existing.setTypeFormation(formation.getTypeFormation());
      existing.setNiveau(formation.getNiveau());
      existing.setDateDebut(formation.getDateDebut());
      existing.setDateFin(formation.getDateFin());
      existing.setFinancement(formation.getFinancement());
      existing.setNombreEtudiants(formation.getNombreEtudiants());

      return formationService.save(existing);
    }
    return null;
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    formationService.delete(id);
  }
}
