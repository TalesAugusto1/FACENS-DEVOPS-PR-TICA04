package com.example.Testes.demo.service;

import com.example.Testes.demo.model.Student;
import com.example.Testes.demo.model.ForumPost;
import com.example.Testes.demo.model.Reward;
import com.example.Testes.demo.model.Course;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Implementation of RewardService.
 * GREEN phase implementation - methods now implemented to make tests pass.
 */
@Service
public class RewardServiceImpl implements RewardService {
    
    private final List<Reward> rewards = new ArrayList<>();
    private final AtomicLong rewardIdGenerator = new AtomicLong(1);
    
    @Override
    public Reward awardPointsForCreatingPost(Student student, ForumPost post) {
        // Validate student is active
        if (!student.isActiveEnrollment()) {
            throw new IllegalArgumentException("Student must have active enrollment to receive points");
        }
        
        // Award 10 points for creating a post
        Reward reward = new Reward(
            rewardIdGenerator.getAndIncrement(),
            10,
            student,
            LocalDateTime.now(),
            "Created forum post"
        );
        
        rewards.add(reward);
        return reward;
    }
    
    @Override
    public Reward awardPointsForLikingPost(Student student, ForumPost post) {
        // Validate student is active
        if (!student.isActiveEnrollment()) {
            throw new IllegalArgumentException("Student must have active enrollment to receive points");
        }
        
        // Award 5 points for liking a post
        Reward reward = new Reward(
            rewardIdGenerator.getAndIncrement(),
            5,
            student,
            LocalDateTime.now(),
            "Liked forum post"
        );
        
        rewards.add(reward);
        return reward;
    }
    
    @Override
    public boolean canAccessCourse(Student student, Course course) {
        int totalPoints = getTotalPoints(student);
        return totalPoints >= course.getRequiredPoints();
    }
    
    @Override
    public int getTotalPoints(Student student) {
        return rewards.stream()
            .filter(reward -> reward.getStudent().getId().equals(student.getId()))
            .mapToInt(Reward::getPoints)
            .sum();
    }
    
    @Override
    public String notifyInsufficientPoints(Student student, Course course) {
        int totalPoints = getTotalPoints(student);
        int neededPoints = course.getRequiredPoints() - totalPoints;
        
        return String.format(
            "Dear %s, you have insufficient points to access '%s'. " +
            "You have %d points but need %d points. " +
            "You need %d more points to access this course.",
            student.getName(),
            course.getName(),
            totalPoints,
            course.getRequiredPoints(),
            neededPoints
        );
    }
}