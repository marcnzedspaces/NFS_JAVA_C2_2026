package com.fullstack.demo.service;

import com.fullstack.demo.exception.InvalidCourseException;
import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import java.util.List;

public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        // 1. Call the private validation method before doing anything else
        validateCourse(course);
        
        // 2. If no exceptions were thrown, it is safe to save!
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // --- PRIVATE HELPER METHODS ---

    private void validateCourse(Course course) {
        if (course == null) {
            throw new InvalidCourseException("Course cannot be null.");
        }
        if (isBlank(course.getCourseId())) {
            throw new InvalidCourseException("Course ID is required.");
        }
        if (isBlank(course.getTitle())) {
            throw new InvalidCourseException("Course title is required.");
        }
        if (course.getDurationHours() <= 0) {
            throw new InvalidCourseException("Course duration must be greater than zero.");
        }
        if (isBlank(course.getLevel())) {
            throw new InvalidCourseException("Course level is required.");
        }
    }

    private boolean isBlank(String value) {
        // Returns true if the string is completely null OR just empty spaces
        return value == null || value.trim().isEmpty();
    }
}