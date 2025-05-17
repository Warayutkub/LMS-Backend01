package com.sk.management.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Student")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    private Double notPaid = 0.0;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<UserCourseEnrollment> enrollments;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<History> histories;

    private String nickName;

    private String graduation;

    private String school;

    private String class_school;

    private String address;

    private String parent_name;

    private String parent_type;

    private String student_phone;

    private String parent_phone;

    private String vehicle_regis;

    private String reason_for_study;

    private  String learning_issue;

    private String know_here_from;

    @CreatedDate
    @Column(updatable = false)
    @JsonProperty("createDate")
    private LocalDateTime createDate;

    @LastModifiedDate
    @JsonProperty("recentUpdate")
    private LocalDateTime recentUpdate;

    public LocalDateTime getRecentUpdate() {
        return recentUpdate;
    }

    public void setAll(Student std){
        this.name = std.getName();
        this.notPaid = std.getPaid();
        this.enrollments = std.getEnrollments();
        this.transactions = std.getTransactions();
        this.histories = std.getHistories();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPaid(Double paid) {
        this.notPaid = paid;
    }

    public void setEnrollments(List<UserCourseEnrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setRecentUpdate(LocalDateTime recentUpdate) {
        this.recentUpdate = recentUpdate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public List<History> getHistories() {
        return histories;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<UserCourseEnrollment> getEnrollments() {
        return enrollments;
    }

    public Double getPaid() {
        return notPaid;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Double getNotPaid() {
        return notPaid;
    }

    public void setNotPaid(Double notPaid) {
        this.notPaid = notPaid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getClass_school() {
        return class_school;
    }

    public void setClass_school(String class_school) {
        this.class_school = class_school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getParent_type() {
        return parent_type;
    }

    public void setParent_type(String parent_type) {
        this.parent_type = parent_type;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public String getParent_phone() {
        return parent_phone;
    }

    public void setParent_phone(String parent_phone) {
        this.parent_phone = parent_phone;
    }

    public String getVehicle_regis() {
        return vehicle_regis;
    }

    public void setVehicle_regis(String vehicle_regis) {
        this.vehicle_regis = vehicle_regis;
    }

    public String getReason_for_study() {
        return reason_for_study;
    }

    public void setReason_for_study(String reason_for_study) {
        this.reason_for_study = reason_for_study;
    }

    public String getLearning_issue() {
        return learning_issue;
    }

    public void setLearning_issue(String learning_issue) {
        this.learning_issue = learning_issue;
    }

    public String getKnow_here_from() {
        return know_here_from;
    }

    public void setKnow_here_from(String know_here_from) {
        this.know_here_from = know_here_from;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", notPaid=" + notPaid +
                ", enrollments=" + enrollments +
                ", transactions=" + transactions +
                ", histories=" + histories +
                ", nickName='" + nickName + '\'' +
                ", graduation='" + graduation + '\'' +
                ", school='" + school + '\'' +
                ", class_school='" + class_school + '\'' +
                ", address='" + address + '\'' +
                ", parent_name='" + parent_name + '\'' +
                ", parent_type='" + parent_type + '\'' +
                ", student_phone='" + student_phone + '\'' +
                ", parent_phone='" + parent_phone + '\'' +
                ", vehicle_regis='" + vehicle_regis + '\'' +
                ", reason_for_study='" + reason_for_study + '\'' +
                ", learning_issue='" + learning_issue + '\'' +
                ", know_here_from='" + know_here_from + '\'' +
                ", createDate=" + createDate +
                ", recentUpdate=" + recentUpdate +
                '}';
    }
}
