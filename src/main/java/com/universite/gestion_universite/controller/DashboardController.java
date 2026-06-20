package com.universite.gestion_universite.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import com.universite.gestion_universite.repository.StudentRepository;
import com.universite.gestion_universite.repository.FormateurRepository;
import com.universite.gestion_universite.repository.FormationRepository;
import com.universite.gestion_universite.repository.CommunicationRepository;

@RestController
@RequestMapping("/api")
public class DashboardController {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private FormateurRepository formateurRepository;

  @Autowired
  private FormationRepository formationRepository;

  @Autowired
  private CommunicationRepository communicationRepository;

  @GetMapping("/dashboard/stats")
  public Map<String, Long> getStats() {

    Map<String, Long> stats = new HashMap<>();

    stats.put("students", studentRepository.count());
    stats.put("formateurs", formateurRepository.count());
    stats.put("formations", formationRepository.count());
    stats.put("communications", communicationRepository.count());

    return stats;
  }
}
