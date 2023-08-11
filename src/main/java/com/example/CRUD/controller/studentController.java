package com.example.CRUD.controller;

import com.example.CRUD.entity.Student;
import com.example.CRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student addStudent;
        addStudent = studentService.create(student);
        return new ResponseEntity<>(addStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable String studentId, @RequestBody Student student){
        Student updateStudent = studentService.update(studentId);
        return new ResponseEntity<>(updateStudent,HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public String delete(@PathVariable String studentId){
        studentService.delete(studentId);
        return "Successfully Deleted";
    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable String studentId){
        return studentService.getSingle(studentId);

    }
}
