package com.example.Testes.demo.model;

/**
 * Course entity representing an extra course that can be unlocked.
 * This is a stub implementation for TDD Red phase.
 */
public class Course {
    
    private Long id;
    private String name;
    private int requiredPoints;
    private String description;
    
    // Default constructor
    public Course() {
    }
    
    // Constructor with parameters
    public Course(Long id, String name, int requiredPoints, String description) {
        this.id = id;
        this.name = name;
        this.requiredPoints = requiredPoints;
        this.description = description;
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
    
    public int getRequiredPoints() {
        return requiredPoints;
    }
    
    public void setRequiredPoints(int requiredPoints) {
        this.requiredPoints = requiredPoints;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", requiredPoints=" + requiredPoints +
                ", description='" + description + '\'' +
                '}';
    }
}
