package com.sk.management.Entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Course")
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Double price;

    private Integer frequency = 0;
    private Integer amountStudent = 0;

    @ManyToMany
    @JoinTable(
            name = "course_day",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "day_id")
    )
    private List<Day> day_learn;

    private String image;

    @CreatedDate
    @Column(updatable = false)
    @JsonProperty("createDate")
    private LocalDateTime createDate;

    @LastModifiedDate
    @JsonProperty("recentUpdate")
    private LocalDateTime recentUpdate;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<UserCourseEnrollment> enrollments;

    @ManyToMany(mappedBy = "courses")
    private List<Teacher> teachers;

    @ManyToMany(mappedBy = "courses")
    private List<Transaction> transactions;

    public void setAll(Course course){
        this.name = course.getName();
        this.price = course.getPrice();
        this.frequency = course.getFrequency();
        this.amountStudent = course.getAmountStudent();
        this.enrollments = course.getEnrollments();
        this.teachers = course.getTeachers();
        this.transactions = course.getTransactions();
        this.image = course.getImage();
        this.day_learn = course.getDay_learn();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public Integer getAmountStudent() {
        return amountStudent;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getRecentUpdate() {
        return recentUpdate;
    }

    public List<UserCourseEnrollment> getEnrollments() {
        return enrollments;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public void setAmountStudent(Integer amountStudent) {
        this.amountStudent = amountStudent;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setRecentUpdate(LocalDateTime recentUpdate) {
        this.recentUpdate = recentUpdate;
    }

    public void setEnrollments(List<UserCourseEnrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Day> getDay_learn() {
        return day_learn;
    }

    public void setDay_learn(List<Day> day_learn) {
        this.day_learn = day_learn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", frequency=" + frequency +
                ", amountStudent=" + amountStudent +
                ", createDate=" + createDate +
                ", recentUpdate=" + recentUpdate +
                ", enrollments=" + enrollments +
                ", teachers=" + teachers +
                ", transactions=" + transactions +
                '}';
    }
}
