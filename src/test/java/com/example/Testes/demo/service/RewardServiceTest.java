package com.example.Testes.demo.service;

import com.example.Testes.demo.model.Student;
import com.example.Testes.demo.model.ForumPost;
import com.example.Testes.demo.model.Reward;
import com.example.Testes.demo.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * Test class for RewardService based on BDD scenarios.
 * These tests should FAIL in the Red phase of TDD.
 */
@SpringBootTest
class RewardServiceTest {
    
    @Autowired
    private RewardService rewardService;
    
    private Student activeStudent;
    private Student inactiveStudent;
    private ForumPost testPost;
    private Course extraCourse;
    
    @BeforeEach
    void setUp() {
        // Arrange: Setup test data
        activeStudent = new Student(1L, "João Silva", true);
        inactiveStudent = new Student(2L, "Maria Santos", false);
        testPost = new ForumPost(1L, "Minha primeira postagem no fórum", activeStudent, 0);
        extraCourse = new Course(1L, "Curso Extra de DevOps", 100, "Curso avançado de DevOps");
    }
    
    @Test
    void scenario1_StudentCreatesPost_ShouldAwardPoints() {
        // Arrange: Student is active and logged in
        Assertions.assertTrue(activeStudent.isActiveEnrollment(), "Student should have active enrollment");
        
        // Action: Student creates a forum post
        Reward reward = rewardService.awardPointsForCreatingPost(activeStudent, testPost);
        
        // Assert: System should register interaction and add reward points
        Assertions.assertNotNull(reward, "Reward should not be null");
        Assertions.assertEquals(activeStudent, reward.getStudent(), "Reward should be for the correct student");
        Assertions.assertTrue(reward.getPoints() > 0, "Student should receive positive points");
        Assertions.assertEquals("Created forum post", reward.getReason(), "Reason should indicate post creation");
    }
    
    @Test
    void scenario2_StudentLikesPost_ShouldAwardPoints() {
        // Arrange: Student is active and logged in
        Assertions.assertTrue(activeStudent.isActiveEnrollment(), "Student should have active enrollment");
        
        // Action: Student likes a forum post
        Reward reward = rewardService.awardPointsForLikingPost(activeStudent, testPost);
        
        // Assert: System should register interaction and add reward points
        Assertions.assertNotNull(reward, "Reward should not be null");
        Assertions.assertEquals(activeStudent, reward.getStudent(), "Reward should be for the correct student");
        Assertions.assertTrue(reward.getPoints() > 0, "Student should receive positive points");
        Assertions.assertEquals("Liked forum post", reward.getReason(), "Reason should indicate post liking");
    }
    
    @Test
    void scenario3_StudentHasEnoughPoints_ShouldGrantCourseAccess() {
        // Arrange: Student has accumulated sufficient points by creating posts
        activeStudent.setId(1L);
        
        // Give student enough points (create 11 posts to get 110 points, course needs 100)
        for (int i = 0; i < 11; i++) {
            rewardService.awardPointsForCreatingPost(activeStudent, testPost);
        }
        
        int totalPoints = rewardService.getTotalPoints(activeStudent);
        
        // Action: System performs monthly check
        boolean canAccess = rewardService.canAccessCourse(activeStudent, extraCourse);
        
        // Assert: Student should receive access to extra course
        Assertions.assertTrue(canAccess, "Student with sufficient points should access the course");
        Assertions.assertTrue(totalPoints >= extraCourse.getRequiredPoints(), 
            "Student should have at least " + extraCourse.getRequiredPoints() + " points");
    }
    
    @Test
    void scenario4_StudentInsufficientPoints_ShouldNotifyCriteria() {
        // Arrange: Student has insufficient points
        Student studentWithFewPoints = new Student(3L, "Pedro Costa", true);
        
        // Action: System performs monthly check
        String notification = rewardService.notifyInsufficientPoints(studentWithFewPoints, extraCourse);
        
        // Assert: Student should be notified about necessary criteria
        Assertions.assertNotNull(notification, "Notification should not be null");
        Assertions.assertTrue(notification.contains("insufficient"), "Notification should mention insufficient points");
        Assertions.assertTrue(notification.contains(String.valueOf(extraCourse.getRequiredPoints())), 
            "Notification should mention required points");
    }
    
    @Test
    void inactiveStudent_ShouldNotReceivePoints() {
        // Arrange: Student is not active
        Assertions.assertFalse(inactiveStudent.isActiveEnrollment(), "Student should not have active enrollment");
        
        // Action & Assert: Inactive student should not receive points
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rewardService.awardPointsForCreatingPost(inactiveStudent, testPost);
        }, "Inactive student should not be able to receive points");
    }
}
