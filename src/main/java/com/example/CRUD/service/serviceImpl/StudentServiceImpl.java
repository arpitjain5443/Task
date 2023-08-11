package com.example.CRUD.service.serviceImpl;

import com.example.CRUD.entity.Student;
import com.example.CRUD.repositories.StudentRepository;
import com.example.CRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student create(Student student) {

        String studentId = UUID.randomUUID().toString();
        student.setStudentId(studentId);
        return studentRepository.save(student);

    }

    @Override
    public Student update( String studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException ("Student Not found by given ID"));
        student.setName(student.getName());
        student.setCity(student.getCity());
        student.setPhone(student.getPhone());
        return studentRepository.save(student);
    }

    @Override
    public void delete(String studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException ("Student Nt found by given ID"));
        studentRepository.delete(student);
    }

    @Override
    public Student getSingle(String studentId) {
        return  studentRepository.findById(studentId).orElseThrow(()->new RuntimeException ("Student Nt found by given ID"));
    }


    @Override
    public List<Student> getAll() {
        return new ArrayList<Student>(studentRepository.findAll());
    }
}
