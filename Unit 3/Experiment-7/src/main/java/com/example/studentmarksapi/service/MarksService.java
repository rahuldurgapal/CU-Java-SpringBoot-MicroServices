package com.example.studentmarksapi.service;

import com.example.studentmarksapi.model.Marks;
import com.example.studentmarksapi.model.Student;
import com.example.studentmarksapi.repository.MarksRepository;
import com.example.studentmarksapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;
import java.util.Optional;

@Service
public class MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Marks saveMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    public List<Marks> getSortedMarksForStudent(int studentId, String sortBy) {
        Optional<Student>  student = studentRepository.findById(studentId);
        if(student.isPresent()) {
            Sort sort = Sort.by(Sort.Order.asc(sortBy));
            return marksRepository.findByStudent(student.get(), sort);
        }

        return null;
    }





}
