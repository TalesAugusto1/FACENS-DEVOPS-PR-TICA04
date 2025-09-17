package com.example.Testes.demo.model;

import java.time.LocalDateTime;

/**
 * Reward entity representing points earned by students.
 * This is a stub implementation for TDD Red phase.
 */
public class Reward {
    
    private Long id;
    private int points;
    private Student student;
    private LocalDateTime date;
    private String reason;
    
    // Default constructor
    public Reward() {
    }
    
    // Constructor with parameters
    public Reward(Long id, int points, Student student, LocalDateTime date, String reason) {
        this.id = id;
        this.points = points;
        this.student = student;
        this.date = date;
        this.reason = reason;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public int getPoints() {
        return points;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public LocalDateTime getDate() {
        return date;
    }
    
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    @Override
    public String toString() {
        return "Reward{" +
                "id=" + id +
                ", points=" + points +
                ", student=" + student +
                ", date=" + date +
                ", reason='" + reason + '\'' +
                '}';
    }
}
