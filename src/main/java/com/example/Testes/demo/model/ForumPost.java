package com.example.Testes.demo.model;

/**
 * ForumPost entity representing a post in the forum.
 * This is a stub implementation for TDD Red phase.
 */
public class ForumPost {
    
    private Long id;
    private String content;
    private Student author;
    private int likesCount;
    
    // Default constructor
    public ForumPost() {
    }
    
    // Constructor with parameters
    public ForumPost(Long id, String content, Student author, int likesCount) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.likesCount = likesCount;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Student getAuthor() {
        return author;
    }
    
    public void setAuthor(Student author) {
        this.author = author;
    }
    
    public int getLikesCount() {
        return likesCount;
    }
    
    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }
    
    @Override
    public String toString() {
        return "ForumPost{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", likesCount=" + likesCount +
                '}';
    }
}
