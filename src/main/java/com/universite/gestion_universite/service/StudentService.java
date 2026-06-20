package com.universite.gestion_universite.service;

import com.universite.gestion_universite.entity.Student;
import com.universite.gestion_universite.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

  public Student updateStudent(Long id, Student student) {
    Student existing = studentRepository.findById(id).orElse(null);

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

      return studentRepository.save(existing);
    }

    return null;
  }
}
