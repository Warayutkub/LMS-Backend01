package com.sk.management.service;

import com.sk.management.Entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    Teacher saveTeacher(Teacher req);
    Teacher updateTeacher(Teacher req);
    List<Teacher> FindAllTeacher();
    Optional<Teacher> findTeacher(Long id);
    void deleteTeacher(Long id);
}
