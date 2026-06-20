package com.universite.gestion_universite.controller;

import com.universite.gestion_universite.entity.Student;
import com.universite.gestion_universite.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

  @GetMapping("/{id}")
  public Student getStudentById(@PathVariable Long id) {
    return studentService.getStudentById(id);
  }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

  @PutMapping("/{id}")
  public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
    Student existing = studentService.getStudentById(id);

    if (existing != null) {
      existing.setIne(student.getIne());
      existing.setNom(student.getNom());
      existing.setPrenom(student.getPrenom());
      existing.setDateNaissance(student.getDateNaissance());
      existing.setFormation(student.getFormation());
      existing.setPromo(student.getPromo());
      existing.setAnneeDebut(student.getAnneeDebut());
      existing.setAnneeSortie(student.getAnneeSortie());
      existing.setDiplome(student.getDiplome());

      return studentService.saveStudent(existing);
    }

    return null;
  }

  @DeleteMapping("/{id}")
  public void deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
  }
}
