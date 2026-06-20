package com.universite.gestion_universite.controller;

import com.universite.gestion_universite.entity.User;
import com.universite.gestion_universite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.universite.gestion_universite.dto.LoginRequest;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public User register(@RequestBody User user) {
    return userService.saveUser(user);
  }

  @PostMapping("/login")
  public Map<String, Object> login(@RequestBody LoginRequest request) {

    System.out.println("EMAIL RECU: " + request.getEmail());
    System.out.println("PASSWORD RECU: " + request.getPassword());

    Map<String, Object> response = new HashMap<>();

    Optional<User> user = userService.findByEmail(request.getEmail());

    if (user.isPresent()) {

      User u = user.get();

      if (u.getPassword().equals(request.getPassword())) {

        response.put("token", "fake-token"); // pour test
        response.put("role", u.getRole());
        response.put("email", u.getEmail());

        return response;
      }
    }

    response.put("message", "Email ou mot de passe incorrect");
    return response;
  }
}
