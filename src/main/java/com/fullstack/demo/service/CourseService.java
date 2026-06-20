package com.fullstack.demo.service;

import com.fullstack.demo.exception.CourseNotFoundException;
import com.fullstack.demo.exception.InvalidCourseException;
import com.fullstack.demo.model.Course;
import com.fullstack.demo.model.Instructor;
import com.fullstack.demo.repository.CourseRepository;
import java.util.List;

public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // --- CREATE & READ (CRUD) ---

    public Course createCourse(Course course) {
        validateCourse(course);
        return courseRepository.save(course);
    }

    public Course getCourseById(String courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found: " + courseId));
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // --- UPDATE & DELETE (CRUD) ---

    public Course updateDuration(String courseId, int newDurationHours) {
        // 1. Check duration first
        if (newDurationHours <= 0) {
            throw new InvalidCourseException("Course duration must be greater than zero.");
        }
        
        // 2. Find the course (this will automatically throw CourseNotFoundException if missing)
        Course course = getCourseById(courseId);
        
        // 3. Update the duration using your specific setter
        course.setDurationHours(newDurationHours);
        
        // 4. Save and return
        return courseRepository.save(course);
    }

    public void deleteCourse(String courseId) {
        // 1. Check if it exists (throws CourseNotFoundException if missing)
        Course course = getCourseById(courseId);
        
        // 2. Delete using the repository
        // NOTE: If this causes an error, change "deleteById" to "delete" or "remove" 
        courseRepository.deleteById(courseId); 
    }

    // --- SEARCH & FILTER METHODS ---

    public List<Course> searchByTitle(String keyword) {
        String safeKeyword = (keyword == null) ? "" : keyword.toLowerCase();
        return courseRepository.findAll().stream()
                .filter(course -> course.getTitle().toLowerCase().contains(safeKeyword))
                .toList();
    }

    public List<Course> filterByLevel(String level) {
        String safeLevel = (level == null) ? "" : level;
        return courseRepository.findAll().stream()
                .filter(course -> course.getLevel().equalsIgnoreCase(safeLevel))
                .toList();
    }

    public Course assignInstructor(String courseId, Instructor instructor) {
        Course course = getCourseById(courseId);
        course.setInstructor(instructor);
        return courseRepository.save(course);
    }

    public List<Course> searchByInstructorName(String instructorName) {
        String safeName = (instructorName == null) ? "" : instructorName.toLowerCase();
        return courseRepository.findAll().stream()
                .filter(course -> course.getInstructor() != null)
                .filter(course -> course.getInstructor().getInstructorName().toLowerCase().contains(safeName))
                .toList();
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
        return value == null || value.trim().isEmpty();
    }
}