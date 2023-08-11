package com.example.CRUD.service;

import com.example.CRUD.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher create(Teacher teacher);
    Teacher update (String teacherId);
    public void delete (String teacherId);
    Teacher getSingle (String teacherId);
    List<Teacher> getAll();

}
