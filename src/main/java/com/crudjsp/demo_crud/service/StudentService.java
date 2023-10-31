package com.crudjsp.demo_crud.service;

import com.crudjsp.demo_crud.entity.Student;

import java.util.List;


public interface StudentService {
    void save(Student student);
    List<Student> getAll();
    Student getById(Integer id);
    void delete(Student student);
}