package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import com.fullstack.demo.service.CourseService;

public class CourseServiceDemo {
    public static void main(String[] args) {
        
        CourseRepository repository = new InMemoryCourseRepository();
        CourseService service = new CourseService(repository);

        // --- 1. VALID COURSE TEST ---
        System.out.println("=== Valid Course Test ===");
        try {
            Course validCourse = new Course("C001", "Java Fundamentals", 14, "Beginner", "Programming", true);
            service.createCourse(validCourse);
            System.out.println("Course saved successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // --- 2. INVALID COURSE TESTS ---
        System.out.println("\n=== Invalid Course Tests ===");

        // Test A: Empty ID
        try {
            Course emptyIdCourse = new Course("", "React Basics", 20, "Beginner", "Frontend", true);
            service.createCourse(emptyIdCourse);
        } catch (Exception e) { 
            System.out.println("Validation error: " + e.getMessage());
        }

        // Test B: Empty Title
        try {
            Course emptyTitleCourse = new Course("C002", "", 15, "Intermediate", "Database", true);
            service.createCourse(emptyTitleCourse);
        } catch (Exception e) { 
            System.out.println("Validation error: " + e.getMessage());
        }

        // Test C: Duration 0
        try {
            Course zeroDurationCourse = new Course("C003", "Quick Git", 0, "Beginner", "Tools", true);
            service.createCourse(zeroDurationCourse);
        } catch (Exception e) { 
            System.out.println("Validation error: " + e.getMessage());
        }
        
        // Test D: Empty Level
        try {
            Course emptyLevelCourse = new Course("C004", "Spring Boot", 30, "", "Backend", true);
            service.createCourse(emptyLevelCourse);
        } catch (Exception e) { 
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}