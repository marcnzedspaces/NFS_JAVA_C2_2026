package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.model.CourseOffering;
import com.fullstack.demo.model.Instructor;
import com.fullstack.demo.model.Student;
import java.util.ArrayList; 

public class Main {
    public static void main(String[] args) {

        // TASK 2: Create Instructor List
        ArrayList<Instructor> instructors = new ArrayList<>();
        Instructor instructor1 = new Instructor("I001", "Alice Johnson", "Java Development");
        Instructor instructor2 = new Instructor("I002", "Bob Smith", "React Development");
        instructors.add(instructor1);
        instructors.add(instructor2);

        // TASK 1: Create Course List
        ArrayList<Course> courses = new ArrayList<>();
        Course course1 = new Course("C001", "Java Fundamentals", 14, "Beginner", "Programming", true);
        Course course2 = new Course("C002", "React Frontend Development", 21, "Intermediate", "Frontend", true);
        Course course3 = new Course("C003", "MongoDB Basics", 14, "Beginner", "Database", true);
        
        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);
        course3.setInstructor(instructor1); 
        
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        // TASK 3: Create Student List
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("S001", "Charlie Brown", "cFq0l@example.com"));
        students.add(new Student("S002", "Daisy Duck", "d4oQG@example.com"));
        students.add(new Student("S003", "Ethan Hunt", "ethan@example.com"));

        // TASK 4: Create Course Offering List
        ArrayList<CourseOffering> offerings = new ArrayList<>();
        offerings.add(new CourseOffering("OFF001", "Java Fundamentals - June 2026", course1, instructor1, "2026-06-19", "2026-06-20", 25, "Hybrid"));
        offerings.add(new CourseOffering("OFF002", "React Bootcamp - July 2026", course2, instructor2, "2026-07-01", "2026-07-15", 40, "Online"));

        // TASK 5: Print all records using enhanced for loops
        System.out.println("=== INSTRUCTOR PROFILES ===");
        for (Instructor instructor : instructors) {
            instructor.printProfile();
        }

        System.out.println("\n=== COURSE SUMMARIES ===");
        for (Course course : courses) {
            course.printSummary();
        }

        System.out.println("\n=== STUDENT PROFILES ===");
        for (Student student : students) {
            student.printProfile();
        }

        System.out.println("\n=== COURSE OFFERINGS ===");
        for (CourseOffering offering : offerings) {
            // FIXED: Now calling printSummary() to match your file!
            offering.printSummary();
            System.out.println("----------------------------");
        }
    }
}