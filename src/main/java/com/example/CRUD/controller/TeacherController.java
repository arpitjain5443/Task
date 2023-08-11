package com.example.CRUD.controller;

import com.example.CRUD.entity.Teacher;
import com.example.CRUD.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService  teacherService;

    @PostMapping
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
        Teacher addTeacher = teacherService.create(teacher);
        return  new ResponseEntity<>(addTeacher, HttpStatus.CREATED);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable String teacherId, @RequestBody Teacher teacher){
        Teacher updateTeacher = teacherService.update(teacherId);
        return new ResponseEntity<>(updateTeacher,HttpStatus.OK);
    }

    @DeleteMapping("/{teacherId}")
    public String delete(@PathVariable String teacherId){
        teacherService.delete(teacherId);
        return "Successfully Deleted";
    }

    @GetMapping
    public List<Teacher> getAll(){
        return teacherService.getAll();
    }

    @GetMapping("/{teacherId}")
    public Teacher getStudent(@PathVariable String teacherId){
        return teacherService.getSingle(teacherId);

    }


}
