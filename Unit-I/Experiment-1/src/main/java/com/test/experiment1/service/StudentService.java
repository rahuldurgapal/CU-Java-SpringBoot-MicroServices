package com.test.experiment1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.experiment1.model.Student;
import com.test.experiment1.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    public Student insertStudent(Student student) {
       
        return studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

}