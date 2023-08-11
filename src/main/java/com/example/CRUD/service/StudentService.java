package com.example.CRUD.service;

import com.example.CRUD.entity.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);
    Student update (String studentId);

    public void delete(String studentId);

    Student getSingle(String studentId);

    List<Student> getAll();


}
