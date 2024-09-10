package com.example.studentmarksapi.repository;

import com.example.studentmarksapi.model.Marks;
import com.example.studentmarksapi.model.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer> {

    @Query("SELECT m FROM Marks m WHERE m.student = :student")
    List<Marks> findByStudent(@Param("student") Student student, Sort sort);
}

