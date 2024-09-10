package com.example.studentmarksapi.controller;


import com.example.studentmarksapi.model.Marks;
import com.example.studentmarksapi.model.Student;
import com.example.studentmarksapi.service.MarksService;
import com.example.studentmarksapi.service.StudentService;
import com.sun.net.httpserver.HttpsServer;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MarksService marksService;

    @GetMapping
    public ResponseEntity<Page<Student>> getAllStudents(Pageable pageable) {
        Page<Student> students = studentService.getAllStudents(pageable);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentBYId(@PathVariable("id") int id) {
        Student student = studentService.getStudentById(id);
        if(student != null) {
            return new ResponseEntity<>(student,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {

        if(studentService.getStudentById(id) != null) {
            student.setId(id);
            Student updateStudent = studentService.saveStudent(student);
            return new ResponseEntity<>(updateStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id) {
        if(studentService.getStudentById(id) != null) {
            studentService.deleteStudent(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/marks")
    public ResponseEntity<Marks> addMarksToStudent(@PathVariable("id") int id, @RequestBody Marks marks) {
        Student student = studentService.getStudentById(id);
        if(student!=null) {
            marks.setStudent(student);
            Marks savedMarks = marksService.saveMarks(marks);
            return new ResponseEntity<>(savedMarks, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/marks")
    public ResponseEntity<List<Marks>> getSortedMarksForStudent(@PathVariable("id") int id, @RequestParam(defaultValue = "marks") String sortBY ) {
        List<Marks> sortedMarks = marksService.getSortedMarksForStudent(id, sortBY);
        System.out.println(sortedMarks);
        if(sortedMarks != null) {
            return new ResponseEntity<>(sortedMarks, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
