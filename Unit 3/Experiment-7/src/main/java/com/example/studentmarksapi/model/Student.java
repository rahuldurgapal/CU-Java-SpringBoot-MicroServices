package com.example.studentmarksapi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Student {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   private String name;

   @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
   private Set<Marks> marks;

   //Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Marks> getMarks() {
        return marks;
    }

    public void setMarks(Set<Marks> marks) {
        this.marks = marks;
    }
}
