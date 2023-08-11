package com.example.CRUD.service.serviceImpl;

import com.example.CRUD.entity.Teacher;
import com.example.CRUD.repositories.TeacherRepository;
import com.example.CRUD.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public Teacher create(Teacher teacher) {
        String teacherId = UUID.randomUUID().toString();
        teacher.setTeacherId(teacherId);
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(String teacherId) {
       Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(()-> new RuntimeException("Teacher Not found by given id"));
       teacher.setName(teacher.getName());
       teacher.setCity(teacher.getCity());
       teacher.setPhone(teacher.getPhone());
       return teacherRepository.save(teacher);
    }

    @Override
    public void delete(String teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(()-> new RuntimeException("Teacher Not found by given id"));
        teacherRepository.delete(teacher);
    }

    @Override
    public Teacher getSingle(String teacherId) {
       return teacherRepository.findById(teacherId).orElseThrow(()-> new RuntimeException("Teacher Not found by given id"));
    }

    @Override
    public List<Teacher> getAll() {
       return new ArrayList<Teacher>(teacherRepository.findAll());
    }
}
