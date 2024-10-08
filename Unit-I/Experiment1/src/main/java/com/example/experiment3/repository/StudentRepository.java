package com.example.experiment3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.experiment3.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}
