package com.tutorial.projects.beginner;

import java.util.*;

/**
 * Student Grade Calculator - Beginner Project
 * 
 * This comprehensive project demonstrates a complete student grade management
 * system that calculates grades, generates reports, and handles multiple
 * students. Perfect for beginners to practice arrays, collections, and
 * object-oriented programming concepts.
 * 
 * LEARNING OBJECTIVES:
 * - Work with arrays and collections effectively
 * - Implement grade calculation algorithms
 * - Handle user input validation and error handling
 * - Create formatted output and reports
 * - Apply conditional logic for grade determination
 * - Structure code with proper method organization
 * 
 * KEY FEATURES:
 * 1. Grade Calculation: Average calculation and letter grade assignment
 * 2. Multiple Students: Handle multiple student records
 * 3. Input Validation: Robust input validation and error handling
 * 4. Report Generation: Comprehensive grade reports
 * 5. Data Management: Store and retrieve student information
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class StudentGradeCalculator {
    
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("=== Student Grade Calculator ===");
        System.out.println("Welcome to the Student Grade Management System!");
        System.out.println();
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getValidChoice();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    calculateGrades();
                    break;
                case 3:
                    displayAllStudents();
                    break;
                case 4:
                    displayStudentReport();
                    break;
                case 5:
                    displayClassStatistics();
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using Student Grade Calculator!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Display the main menu
     */
    private static void displayMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Add Student");
        System.out.println("2. Calculate Grades for Student");
        System.out.println("3. Display All Students");
        System.out.println("4. Display Student Report");
        System.out.println("5. Display Class Statistics");
        System.out.println("6. Exit");
        System.out.print("Enter your choice (1-6): ");
    }
    
    /**
     * Get valid menu choice from user
     */
    private static int getValidChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= 6) {
                    return choice;
                } else {
                    System.out.print("Please enter a number between 1 and 6: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
    
    /**
     * Add a new student to the system
     */
    private static void addStudent() {
        System.out.println("\n=== Add New Student ===");
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        
        if (name.isEmpty()) {
            System.out.println("Error: Student name cannot be empty!");
            return;
        }
        
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine().trim();
        
        if (studentId.isEmpty()) {
            System.out.println("Error: Student ID cannot be empty!");
            return;
        }
        
        // Check if student ID already exists
        if (findStudentById(studentId) != null) {
            System.out.println("Error: Student with ID " + studentId + " already exists!");
            return;
        }
        
        System.out.print("Enter number of subjects: ");
        int numSubjects = getValidNumber("Number of subjects must be between 1 and 10: ", 1, 10);
        
        String[] subjects = new String[numSubjects];
        double[] marks = new double[numSubjects];
        
        // Get subject names and marks
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter subject " + (i + 1) + " name: ");
            subjects[i] = scanner.nextLine().trim();
            
            System.out.print("Enter marks for " + subjects[i] + " (0-100): ");
            marks[i] = getValidNumber("Marks must be between 0 and 100: ", 0, 100);
        }
        
        Student student = new Student(name, studentId, subjects, marks);
        students.add(student);
        
        System.out.println("✓ Student " + name + " added successfully!");
        System.out.println("Student ID: " + studentId);
        System.out.println("Number of subjects: " + numSubjects);
    }
    
    /**
     * Calculate grades for a specific student
     */
    private static void calculateGrades() {
        System.out.println("\n=== Calculate Grades ===");
        
        if (students.isEmpty()) {
            System.out.println("No students found. Please add students first.");
            return;
        }
        
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine().trim();
        
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student with ID " + studentId + " not found!");
            return;
        }
        
        // Calculate grades
        student.calculateGrades();
        
        System.out.println("✓ Grades calculated for " + student.getName());
        System.out.println("Average: " + String.format("%.2f", student.getAverage()));
        System.out.println("Grade: " + student.getGrade());
    }
    
    /**
     * Display all students in the system
     */
    private static void displayAllStudents() {
        System.out.println("\n=== All Students ===");
        
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        
        System.out.printf("%-15s %-20s %-10s %-10s %-8s%n", 
            "Student ID", "Name", "Subjects", "Average", "Grade");
        System.out.println("-".repeat(70));
        
        for (Student student : students) {
            System.out.printf("%-15s %-20s %-10d %-10.2f %-8s%n",
                student.getStudentId(),
                student.getName(),
                student.getSubjects().length,
                student.getAverage(),
                student.getGrade());
        }
    }
    
    /**
     * Display detailed report for a specific student
     */
    private static void displayStudentReport() {
        System.out.println("\n=== Student Report ===");
        
        if (students.isEmpty()) {
            System.out.println("No students found. Please add students first.");
            return;
        }
        
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine().trim();
        
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student with ID " + studentId + " not found!");
            return;
        }
        
        // Generate and display detailed report
        generateStudentReport(student);
    }
    
    /**
     * Display class statistics
     */
    private static void displayClassStatistics() {
        System.out.println("\n=== Class Statistics ===");
        
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        
        int totalStudents = students.size();
        double totalAverage = 0;
        int[] gradeCounts = new int[5]; // A, B, C, D, F
        
        for (Student student : students) {
            if (student.getAverage() > 0) { // Only count students with calculated grades
                totalAverage += student.getAverage();
                
                switch (student.getGrade()) {
                    case "A": gradeCounts[0]++; break;
                    case "B": gradeCounts[1]++; break;
                    case "C": gradeCounts[2]++; break;
                    case "D": gradeCounts[3]++; break;
                    case "F": gradeCounts[4]++; break;
                }
            }
        }
        
        double classAverage = totalAverage / totalStudents;
        
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Class Average: " + String.format("%.2f", classAverage));
        System.out.println();
        System.out.println("Grade Distribution:");
        System.out.println("A: " + gradeCounts[0] + " students");
        System.out.println("B: " + gradeCounts[1] + " students");
        System.out.println("C: " + gradeCounts[2] + " students");
        System.out.println("D: " + gradeCounts[3] + " students");
        System.out.println("F: " + gradeCounts[4] + " students");
    }
    
    /**
     * Generate detailed report for a student
     */
    private static void generateStudentReport(Student student) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("STUDENT REPORT");
        System.out.println("=".repeat(50));
        System.out.println("Name: " + student.getName());
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Number of Subjects: " + student.getSubjects().length);
        System.out.println();
        
        System.out.println("Subject-wise Marks:");
        System.out.println("-".repeat(30));
        for (int i = 0; i < student.getSubjects().length; i++) {
            System.out.printf("%-20s: %6.2f%n", 
                student.getSubjects()[i], 
                student.getMarks()[i]);
        }
        
        System.out.println("-".repeat(30));
        System.out.printf("%-20s: %6.2f%n", "Average", student.getAverage());
        System.out.printf("%-20s: %6s%n", "Grade", student.getGrade());
        System.out.println("=".repeat(50));
    }
    
    /**
     * Find student by ID
     */
    private static Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
    
    /**
     * Get valid number input from user
     */
    private static int getValidNumber(String errorMessage, int min, int max) {
        while (true) {
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.print(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
    
    /**
     * Student class to represent student data
     */
    public static class Student {
        private String name;
        private String studentId;
        private String[] subjects;
        private double[] marks;
        private double average;
        private String grade;
        
        public Student(String name, String studentId, String[] subjects, double[] marks) {
            this.name = name;
            this.studentId = studentId;
            this.subjects = subjects;
            this.marks = marks;
            this.average = 0.0;
            this.grade = "N/A";
        }
        
        /**
         * Calculate average and grade
         */
        public void calculateGrades() {
            double sum = 0;
            for (double mark : marks) {
                sum += mark;
            }
            this.average = sum / marks.length;
            this.grade = calculateLetterGrade(average);
        }
        
        /**
         * Calculate letter grade based on average
         */
        private String calculateLetterGrade(double average) {
            if (average >= 90) return "A";
            else if (average >= 80) return "B";
            else if (average >= 70) return "C";
            else if (average >= 60) return "D";
            else return "F";
        }
        
        // Getters
        public String getName() { return name; }
        public String getStudentId() { return studentId; }
        public String[] getSubjects() { return subjects; }
        public double[] getMarks() { return marks; }
        public double getAverage() { return average; }
        public String getGrade() { return grade; }
    }
}
