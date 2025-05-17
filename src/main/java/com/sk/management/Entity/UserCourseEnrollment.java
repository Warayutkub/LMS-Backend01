package com.sk.management.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "User_course_enrollment")
public class UserCourseEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @CreatedDate
    @Column(updatable = false)
    @JsonProperty("createDate")
    private LocalDateTime createDate;

    @LastModifiedDate
    @JsonProperty("recentUpdate")
    private LocalDateTime recentUpdate;

    private Integer maxAllowedSessions;
    private Integer usedSessions;

    private Boolean status = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getMaxAllowedSessions() {
        return maxAllowedSessions;
    }

    public void setMaxAllowedSessions(Integer maxAllowedSessions) {
        this.maxAllowedSessions = maxAllowedSessions;
    }

    public Integer getUsedSessions() {
        return usedSessions;
    }

    public void setUsedSessions(Integer usedSessions) {
        this.usedSessions = usedSessions;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getRecentUpdate() {
        return recentUpdate;
    }

    public void setRecentUpdate(LocalDateTime recentUpdate) {
        this.recentUpdate = recentUpdate;
    }

    @Override
    public String toString() {
        return "UserCourseEnrollment{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", createDate=" + createDate +
                ", recentUpdate=" + recentUpdate +
                ", maxAllowedSessions=" + maxAllowedSessions +
                ", usedSessions=" + usedSessions +
                ", status=" + status +
                '}';
    }
}
