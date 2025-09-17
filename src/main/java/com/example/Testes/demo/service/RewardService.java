package com.example.Testes.demo.service;

import com.example.Testes.demo.model.Student;
import com.example.Testes.demo.model.ForumPost;
import com.example.Testes.demo.model.Reward;
import com.example.Testes.demo.model.Course;

/**
 * Service interface for managing forum rewards.
 * This is a stub implementation for TDD Red phase.
 */
public interface RewardService {
    
    /**
     * Awards points to a student for creating a forum post.
     * @param student the student who created the post
     * @param post the forum post created
     * @return the reward points awarded
     */
    Reward awardPointsForCreatingPost(Student student, ForumPost post);
    
    /**
     * Awards points to a student for liking a forum post.
     * @param student the student who liked the post
     * @param post the forum post that was liked
     * @return the reward points awarded
     */
    Reward awardPointsForLikingPost(Student student, ForumPost post);
    
    /**
     * Checks if a student has enough points to access a course.
     * @param student the student to check
     * @param course the course to check access for
     * @return true if student has enough points, false otherwise
     */
    boolean canAccessCourse(Student student, Course course);
    
    /**
     * Gets the total points accumulated by a student.
     * @param student the student to check
     * @return total points accumulated
     */
    int getTotalPoints(Student student);
    
    /**
     * Sends notification to student about insufficient points.
     * @param student the student to notify
     * @param course the course they're trying to access
     * @return notification message
     */
    String notifyInsufficientPoints(Student student, Course course);
}
