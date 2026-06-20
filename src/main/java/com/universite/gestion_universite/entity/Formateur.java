package com.universite.gestion_universite.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "formateurs")
public class Formateur {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nom;
  private String email;
  private String specialite;
  private String type; // enseignant, tuteur, associe
}
