package com.sk.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.management.Entity.Course;

public interface  CourseRepo extends JpaRepository<Course, Long>{
    
}
