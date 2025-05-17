package com.sk.management.action;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sk.management.Entity.Course;
import com.sk.management.Repository.CourseRepo;
import com.sk.management.service.CourseService;

@Service
public class CourseActionService implements CourseService {

    private final CourseRepo courseRepo;

    public CourseActionService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    @CacheEvict(value = "courses", allEntries = true)
    public Course saveCourse(Course req) {
        return courseRepo.save(req);
    }

    @Override
    @CacheEvict(value = "courses", allEntries = true)
    public Course updateCourse(Course req) {
        Course course = courseRepo.findById(req.getId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + req.getId()));
        course.setAll(req);
        return courseRepo.save(course);
    }

    @Override
    @Cacheable("courses")
    public List<Course> FindAllCourse() {
        return courseRepo.findAll();
    }

    @Override
    public Optional<Course> findCourse(Long id) {
        return courseRepo.findById(id);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }

    @Override
    public void deleteMoreCourse(Long[] id) {
       courseRepo.deleteAllById(Arrays.asList(id));
    }
}
