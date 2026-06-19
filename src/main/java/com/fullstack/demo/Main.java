package com.fullstack.demo;

public class Main {
    public static void main(String[] args) {
        // Syntax for creating a new object (instance) of the Course class
        // ClassName objectName = new Constructor();
        // ClassName and Constructor usually match

        Instructor instructor1 = new Instructor("I001", "Alice Johnson", "Java Development");
        Instructor instructor2 = new Instructor("I002", "Bob Smith", "React Development");

        Course course1 = new Course("C001", "Java Fundamentals", 14, "Beginner", "Programming", true);
        Course course2 = new Course("C002", "React Frontend Development", 21, "Intermediate", "Project", true);

        Student student1 = new Student("S001", "Charlie Brown", "cFq0l@example.com");
        Student student2 = new Student("S002", "Daisy Duck", "d4oQG@example.com");

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);

        System.out.println("Instructor Profiles:");
        instructor1.printProfile();
        instructor2.printProfile();

        System.out.println("Course Summaries:");
        course1.printSummary();
        course2.printSummary();

        System.out.println("Student Profiles:");
        student1.printProfile();
        student2.printProfile();

        Course javaCourse = new Course("C001", "Java Fundamentals", 2, "Beginner", "Programming", true);
        Instructor instructor = new Instructor("I001", "Aina Rahman", "Java and Spring Boot");

        CourseOffering offering = new CourseOffering(
            "OFF001",
            "Java Fundamentals - June 2026 Intake",
            javaCourse,
            instructor,
            "2026-06-19",
            "2026-06-20",
            25,
            "Online"
        );
            CourseOffering offering2 = new CourseOffering(
            "OFF002",
            "Java Fundamentals - July 2026 Intake",
            javaCourse,
            instructor,
            "2026-07-19",
            "2026-07-20",
            20,
            "Online"
        );

        offering.printOfferingSummary();
        offering2.printOfferingSummary();
    }
}
