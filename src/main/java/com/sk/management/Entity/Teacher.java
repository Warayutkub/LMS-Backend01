package com.sk.management.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String password;

    @CreatedDate
    @Column(updatable = false)
    @JsonProperty("createDate")
    private LocalDateTime createDate;

    @LastModifiedDate
    @JsonProperty("recentUpdate")
    private LocalDateTime recentUpdate;

    @ManyToMany
    @JoinTable(
            name = "teacher_course",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    public void setAll(Teacher teacher){
        this.name = teacher.getName();
        this.password = teacher.getPassword();
        this.courses = teacher.getCourses();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setRecentUpdate(LocalDateTime recentUpdate) {
        this.recentUpdate = recentUpdate;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getRecentUpdate() {
        return recentUpdate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                ", recentUpdate=" + recentUpdate +
                ", courses=" + courses +
                '}';
    }
}