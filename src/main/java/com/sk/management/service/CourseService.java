package com.sk.management.service;

import java.util.List;
import java.util.Optional;

import com.sk.management.Entity.Course;


public interface CourseService {
    Course saveCourse(Course req);
    Course updateCourse(Course req);
    List<Course> FindAllCourse();
    Optional<Course> findCourse(Long id);
    void deleteCourse(Long id);
    void deleteMoreCourse(Long[] id);
}
