package com.fullstack.demo;

// ADD THESE IMPORTS SO MAIN KNOWS WHERE TO LOOK
import com.fullstack.demo.model.Course;
import com.fullstack.demo.model.Instructor;
import com.fullstack.demo.model.Student;

public class Main {
    public static void main(String[] args) {
        Instructor instructor1 = new Instructor("I001", "Alice Johnson", "Java Development");
        Instructor instructor2 = new Instructor("I002", "Bob Smith", "React Development");

        Course course1 = new Course("C001", "Java Fundamentals", 14, "Beginner", "Programming", true);
        Course course2 = new Course("C002", "React Frontend Development", 21, "Intermediate", "Frontend", true);

        Student student1 = new Student("S001", "Charlie Brown", "cFq0l@example.com");
        Student student2 = new Student("S002", "Daisy Duck", "d4oQG@example.com");

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);

        System.out.println("Instructor Profiles:");
        instructor1.printProfile();
        instructor2.printProfile();

        System.out.println("\nCourse Summaries:");
        course1.printSummary();
        course2.printSummary();

        System.out.println("\nStudent Profiles:");
        student1.printProfile();
        student2.printProfile();
    }
}