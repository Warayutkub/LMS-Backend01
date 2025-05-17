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

import com.sk.management.Entity.Course;
import com.sk.management.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> save(@RequestBody Course req) {
        Course course = courseService.saveCourse(req);
        return ResponseEntity.ok(course);
    }


    @PutMapping()
    public ResponseEntity<Course> putMethodName(@RequestBody Course req) {
        Course course = courseService.updateCourse(req);
        return ResponseEntity.ok(course);
    }

    @GetMapping
    public List<Course> getMethodName() {
        return courseService.FindAllCourse();
    }

    @GetMapping("/find-one")
    public Optional<Course> getMethodName(@RequestBody Long id) {
        return courseService.findCourse(id);
    }
    

    @DeleteMapping("/delete-one")
    public void delete(@RequestBody Long id){
        courseService.deleteCourse(id);
    }

    @DeleteMapping("/delete")
    public void deleteMore(@RequestBody Long[] id){
        courseService.deleteMoreCourse(id);
    }
    
    
}
