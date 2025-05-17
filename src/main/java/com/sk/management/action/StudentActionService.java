package com.sk.management.action;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sk.management.Entity.Student;
import com.sk.management.Repository.StudentRepo;
import com.sk.management.service.StudentService;

@Service
public class StudentActionService implements StudentService {

    private final StudentRepo studentRepo;

    public StudentActionService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    @CacheEvict(value = "students", allEntries = true)
    public Student saveStudent(Student req) {
        return studentRepo.save(req);
    }

    @Override
    @CacheEvict(value = "students", allEntries = true)
    public Student updateStudent(Student req) {
        Student std = studentRepo.findById(req.getId())
            .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + req.getId()));
        std.setAll(req);
        return studentRepo.save(std);
    }

    @Override
    @Cacheable("students")
    public List<Student> FindAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> findStudent(Long id) {
       return studentRepo.findById(id);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}


