package com.fullstack.demo.model;

public class Student {
    private String studentId;
    private String name;
    private String email;

    // Task 3: Constructor using setters
    public Student(String studentId, String name, String email) {
        setStudentId(studentId);
        setName(name);
        setEmail(email);
    }

    // Task 4 & 5: Getters and Setters with Validation
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = requireText(studentId, "Student ID");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = requireText(name, "Name");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = requireText(email, "Email");
    }

    // Task 6: Print method with dashed line
    public void printProfile() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("----------------------------");
    }

    // Task 5: Helper method for text validation
    private static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " is required.");
        }
        return value.trim();
    }
}