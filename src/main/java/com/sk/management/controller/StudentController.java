package com.sk.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.management.Entity.Student;
import com.sk.management.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student req){
        Student student = studentService.saveStudent(req);
        return ResponseEntity.ok(student);
    }
    
    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student req) {
        Student student = studentService.updateStudent(req);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.FindAllStudent();
    }
    
    @GetMapping("/find-one")
    public Optional<Student> getOne(@RequestBody Long id) {
        return studentService.findStudent(id);
    }

    
    @DeleteMapping("/delete")
    public void deleteById(@RequestBody Long id){
        studentService.deleteStudent(id);
    }
}