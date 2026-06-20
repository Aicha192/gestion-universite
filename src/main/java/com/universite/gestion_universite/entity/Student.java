package com.universite.gestion_universite.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String ine;
  private String nom;
  private String prenom;
  private String dateNaissance;
  private String formation;
  private String promo;
  private Integer anneeDebut;
  private Integer anneeSortie;
  private String diplome;
}
