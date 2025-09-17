package com.example.Testes.demo.model;

/**
 * Student entity representing a student in the forum rewards system.
 * This is a stub implementation for TDD Red phase.
 */
public class Student {
    
    private Long id;
    private String name;
    private boolean activeEnrollment;
    
    // Default constructor
    public Student() {
    }
    
    // Constructor with parameters
    public Student(Long id, String name, boolean activeEnrollment) {
        this.id = id;
        this.name = name;
        this.activeEnrollment = activeEnrollment;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isActiveEnrollment() {
        return activeEnrollment;
    }
    
    public void setActiveEnrollment(boolean activeEnrollment) {
        this.activeEnrollment = activeEnrollment;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activeEnrollment=" + activeEnrollment +
                '}';
    }
}
