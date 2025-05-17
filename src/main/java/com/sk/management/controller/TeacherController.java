package com.sk.management.controller;

import com.sk.management.DTO.TeacherDTO;
import com.sk.management.Entity.Teacher;
import com.sk.management.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<Teacher> save(@RequestBody Teacher req){
        Teacher teacher = teacherService.saveTeacher(req);
        return ResponseEntity.ok(teacher);
    }
    
    @PutMapping
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher req) {
        Teacher teacher = teacherService.updateTeacher(req);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping
    public List<Teacher> getAll() {
        return teacherService.FindAllTeacher();
    }

    @GetMapping("/combobox")
    public List<TeacherDTO> getAllForComboBox() {
        List<Teacher> data = teacherService.FindAllTeacher();
        List<TeacherDTO> result = new ArrayList<>();
        for (Teacher tea : data) {
            result.add(new TeacherDTO(String.valueOf(tea.getId()), tea.getName()));
        }
        return result;
    }
    
    @GetMapping("/find-one")
    public Optional<Teacher> getOne(@RequestBody Long id) {
        return teacherService.findTeacher(id);
    }

    
    @DeleteMapping("/delete")
    public void deleteById(@RequestBody Long id){
        teacherService.deleteTeacher(id);
    }
}