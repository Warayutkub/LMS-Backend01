package com.sk.management.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "History")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(nullable = false, length = 20)
    private String status;

    private String other;

    @CreatedDate
    @Column(updatable = false)
    @JsonProperty("createDate")
    private LocalDateTime createDate;

    @LastModifiedDate
    @JsonProperty("recentUpdate")
    private LocalDateTime recentUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
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
        return "History{" +
                "id=" + id +
                ", transaction=" + transaction +
                ", student=" + student +
                ", status='" + status + '\'' +
                ", other='" + other + '\'' +
                ", createDate=" + createDate +
                ", recentUpdate=" + recentUpdate +
                '}';
    }
}