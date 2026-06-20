package com.fullstack.demo;

import java.util.ArrayList;
import com.fullstack.demo.model.Course;
import com.fullstack.demo.model.CourseOffering;
import com.fullstack.demo.model.Instructor;
import com.fullstack.demo.model.Student;

public class Main {
    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("C001", "Java Fundamentals", 14, "Beginner"));
        courses.add(new Course("C002", "React Frontend Development", 21, "Intermediate"));
        courses.add(new Course("C003", "MongoDB Basics", 14, "Beginner"));

        ArrayList<Instructor> instructors = new ArrayList<>();
        instructors.add(new Instructor("I001", "Alice Johnson", "Java Development"));
        instructors.add(new Instructor("I002", "Bob Smith", "React Development"));

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("S001", "Fahim", "fahim@example.com"));
        students.add(new Student("S002", "Syabil", "syabil@example.com"));
        students.add(new Student("S003", "Nafiz", "nafiz@example.com"));

        ArrayList<CourseOffering> offerings = new ArrayList<>();
        offerings.add(new CourseOffering(
            "O001",
            "Java Fundamentals - June",
            courses.get(0),
            instructors.get(0),
            "2026-07-01",
            "2026-07-15",
            20,
            "Online"));
        offerings.add(new CourseOffering(
            "O002",
            "React Frontend - July",
            courses.get(1),
            instructors.get(1),
            "2026-07-20",
            "2026-08-10",
            18,
            "In-Person"));

        courses.get(0).setInstructor(instructors.get(0));
        courses.get(1).setInstructor(instructors.get(1));

        System.out.println("Course Summaries:");
        for (Course course : courses) {
            course.printSummary();
            System.out.println("----------------------------");
        }

        System.out.println("Instructor Profiles:");
        for (Instructor instructor : instructors) {
            instructor.printProfile();
            System.out.println("----------------------------");
        }

        System.out.println("Student Profiles:");
        for (Student student : students) {
            student.printProfile();
        }

        System.out.println("Course Offerings:");
        for (CourseOffering offering : offerings) {
            offering.printSummary();
            System.out.println("----------------------------");
        }
    }
}
