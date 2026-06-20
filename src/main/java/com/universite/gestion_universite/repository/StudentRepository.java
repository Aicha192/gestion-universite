package com.universite.gestion_universite.repository;

import com.universite.gestion_universite.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
