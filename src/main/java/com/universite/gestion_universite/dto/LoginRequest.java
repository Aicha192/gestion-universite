package com.universite.gestion_universite.dto;

import lombok.Data;

@Data
public class LoginRequest {

  private String email;
  private String password;
}
