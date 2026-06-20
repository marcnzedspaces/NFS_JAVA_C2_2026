package com.fullstack.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.fullstack.demo.exception.CourseNotFoundException;
import com.fullstack.demo.exception.DuplicateCourseException;
import com.fullstack.demo.exception.InvalidCourseException;
import com.fullstack.demo.model.Course;
import com.fullstack.demo.model.Instructor;
import com.fullstack.demo.repository.CourseRepository;

public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        validateCourse(course);
        if (courseRepository.existsById(course.getCourseId())) {
            throw new DuplicateCourseException(course.getCourseId());
        }
        return courseRepository.save(course);
    }

    public Course getCourseById(String courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(courseId));
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> searchByTitle(String keyword) {
        String searchText = normalize(keyword);

        return courseRepository.findAll().stream()
                .filter(course -> normalize(course.getTitle()).contains(searchText))
                .collect(Collectors.toList());
    }

    public List<Course> filterByLevel(String level) {
        String levelText = normalize(level);

        return courseRepository.findAll().stream()
                .filter(course -> normalize(course.getLevel()).equals(levelText))
                .collect(Collectors.toList());
    }

    public Course assignInstructor(String courseId, Instructor instructor) {
        Course course = getCourseById(courseId);
        course.setInstructor(instructor);
        return courseRepository.save(course);
    }

    public List<Course> searchByInstructorName(String instructorName) {
        String searchText = normalize(instructorName);

        return courseRepository.findAll().stream()
                .filter(course -> course.getInstructor() != null)
                .filter(course -> normalize(course.getInstructor().getInstructorName()).contains(searchText))
                .collect(Collectors.toList());
    }

    public Course updateDuration(String courseId, int newDurationHours) {
        if (newDurationHours <= 0) {
            throw new InvalidCourseException("Course duration must be greater than zero.");
        }

        Course course = getCourseById(courseId);
        course.setDurationHours(newDurationHours);
        return courseRepository.save(course);
    }

    public void deleteCourse(String courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new CourseNotFoundException(courseId);
        }

        courseRepository.deleteById(courseId);
    }

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
        return value == null || value.isBlank();
    }

    private String normalize(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toLowerCase();
    }
}

