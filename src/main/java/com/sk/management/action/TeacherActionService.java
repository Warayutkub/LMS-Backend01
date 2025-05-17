package com.sk.management.action;

import com.sk.management.Entity.Teacher;
import com.sk.management.Repository.TeacherRepo;
import com.sk.management.service.TeacherService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherActionService implements TeacherService {

    private final TeacherRepo teacherRepo;

    public TeacherActionService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    @CacheEvict(value = "teachers", allEntries = true)
    public Teacher saveTeacher(Teacher req) {
        return teacherRepo.save(req);
    }

    @Override
    @CacheEvict(value = "teachers", allEntries = true)
    public Teacher updateTeacher(Teacher req) {
        Teacher std = teacherRepo.findById(req.getId())
            .orElseThrow(() -> new IllegalArgumentException("Teacher not found with id: " + req.getId()));
        std.setAll(req);
        return teacherRepo.save(std);
    }

    @Override
    @Cacheable("teachers")
    public List<Teacher> FindAllTeacher() {
        return teacherRepo.findAll();
    }

    @Override
    public Optional<Teacher> findTeacher(Long id) {
       return teacherRepo.findById(id);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepo.deleteById(id);
    }
}


