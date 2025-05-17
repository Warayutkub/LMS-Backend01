package com.sk.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.management.Entity.Student;

public interface  StudentRepo extends JpaRepository<Student, Long> {
    
}
