package com.test.experiment1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.experiment1.model.Student;

/**
 * StudentRepository
 */

 @Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
      
    
}