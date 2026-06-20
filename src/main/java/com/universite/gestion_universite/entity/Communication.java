package com.universite.gestion_universite.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "communications")
public class Communication {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titre;
  private String typeReunion;
  private String date;
  private String document; // (on simule PDF ici)
}
