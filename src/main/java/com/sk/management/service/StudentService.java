package com.sk.management.service;

import java.util.List;
import java.util.Optional;

import com.sk.management.Entity.Student;

public interface  StudentService {
    Student saveStudent(Student req);
    Student updateStudent(Student req);
    List<Student> FindAllStudent();
    Optional<Student> findStudent(Long id);
    void deleteStudent(Long id);
}
