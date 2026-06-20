package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import com.fullstack.demo.service.CourseService;

public class CourseServiceDemo {
    public static void main(String[] args) {
        
        CourseRepository repository = new InMemoryCourseRepository();
        CourseService service = new CourseService(repository);

        // 1. Create Courses Setup
        try {
            service.createCourse(new Course("C001", "Java Fundamentals", 14, "Beginner", "Programming", true));
            service.createCourse(new Course("C002", "React Frontend Development", 21, "Intermediate", "Frontend", true));
            service.createCourse(new Course("C003", "MongoDB Basics", 14, "Beginner", "Database", true));
        } catch (Exception e) {
            System.out.println("Setup Error: " + e.getMessage());
        }

        // 2. Test Update Duration
        System.out.println("=== Update Duration ===");
        try {
            Course updatedCourse = service.updateDuration("C001", 20);
            System.out.println(updatedCourse.getCourseId() + " duration updated to " + updatedCourse.getDurationHours() + " hours");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 3. Test Delete Course
        System.out.println("\n=== Delete Course ===");
        try {
            service.deleteCourse("C003");
            System.out.println("C003 deleted successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 4. Print Remaining Courses
        System.out.println("\n=== Remaining Courses ===");
        for (Course c : service.getAllCourses()) {
            System.out.println(c.getCourseId() + " - " + c.getTitle());
        }

        // 5. Test Find Deleted Course
        System.out.println("\n=== Find Deleted Course ===");
        try {
            service.getCourseById("C003");
        } catch (Exception e) {
            System.out.println("Course not found error: " + e.getMessage());
        }

        // 6. Test Invalid Duration Update
        System.out.println("\n=== Invalid Duration Test ===");
        try {
            service.updateDuration("C002", 0);
        } catch (Exception e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}