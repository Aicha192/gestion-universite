package com.universite.gestion_universite.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "formations")
public class Formation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nomFormation;
  private String typeFormation;
  private String niveau;

  private String dateDebut;
  private String dateFin;

  private String financement;

  private Integer nombreEtudiants;
}
