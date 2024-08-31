package com.example.experiment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.experiment3.model.Student;
import com.example.experiment3.service.StudentService;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Experiment3Application implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(Experiment3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add new Student");
            System.out.println("2. Show all Students");
            System.out.println("3. Exit");
            System.out.println("\nChoose the given Option");

            int x = sc.nextInt();
            sc.nextLine();  // Consume the newline left-over after nextInt()

            switch (x) {
                case 1:
                    String name, address;
                    Student student = new Student();
                    System.out.println("Enter the Student Name");
                    name = sc.nextLine();
                    System.out.println("Enter the Student Address");
                    address = sc.nextLine();
                    student.setName(name);
                    student.setAddress(address);
                    studentService.insertStudent(student);
                    System.out.println("Student Saved Successfully");
                    break;

                case 2:
                    List<Student> students = studentService.getStudents();
                    System.out.println("All Students");
                    for (Student s : students) {
                        System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Address: " + s.getAddress());
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;  

                default:
                    System.out.println("Please choose a correct option");
            }
        }
    }
}
