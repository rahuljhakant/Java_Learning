package com.tutorial.beginner;

/**
 * Classes and Objects Demo
 * 
 * This class demonstrates:
 * - Class definition and structure
 * - Object creation and instantiation
 * - Instance variables and methods
 * - Object references
 * - Memory allocation
 * - Garbage collection concepts
 */
public class ClassesAndObjects {
    
    public static void main(String[] args) {
        System.out.println("=== Classes and Objects Demo ===");
        System.out.println();
        
        // 1. Creating Objects
        demonstrateObjectCreation();
        
        // 2. Instance Variables and Methods
        demonstrateInstanceMembers();
        
        // 3. Object References
        demonstrateObjectReferences();
        
        // 4. Multiple Objects
        demonstrateMultipleObjects();
        
        // 5. Object Lifecycle
        demonstrateObjectLifecycle();
    }
    
    /**
     * Demonstrates basic object creation
     */
    private static void demonstrateObjectCreation() {
        System.out.println("1. Object Creation:");
        System.out.println("==================");
        
        // Creating objects using new keyword
        Student student1 = new Student();
        Student student2 = new Student("Alice", 20, "Computer Science");
        
        System.out.println("Student 1: " + student1);
        System.out.println("Student 2: " + student2);
        System.out.println();
    }
    
    /**
     * Demonstrates instance variables and methods
     */
    private static void demonstrateInstanceMembers() {
        System.out.println("2. Instance Variables and Methods:");
        System.out.println("==================================");
        
        Student student = new Student("Bob", 22, "Mathematics");
        
        // Accessing instance variables
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Major: " + student.getMajor());
        
        // Calling instance methods
        student.study();
        student.takeExam();
        
        // Modifying instance variables
        student.setAge(23);
        System.out.println("Updated age: " + student.getAge());
        System.out.println();
    }
    
    /**
     * Demonstrates object references
     */
    private static void demonstrateObjectReferences() {
        System.out.println("3. Object References:");
        System.out.println("====================");
        
        Student student1 = new Student("Charlie", 21, "Physics");
        Student student2 = student1; // Both references point to the same object
        
        System.out.println("student1: " + student1);
        System.out.println("student2: " + student2);
        System.out.println("Are they the same object? " + (student1 == student2));
        
        // Modifying through one reference affects the other
        student1.setAge(25);
        System.out.println("After changing student1's age:");
        System.out.println("student1 age: " + student1.getAge());
        System.out.println("student2 age: " + student2.getAge());
        
        // Creating a new object
        student2 = new Student("David", 19, "Chemistry");
        System.out.println("\nAfter creating new object for student2:");
        System.out.println("student1: " + student1);
        System.out.println("student2: " + student2);
        System.out.println("Are they the same object? " + (student1 == student2));
        System.out.println();
    }
    
    /**
     * Demonstrates multiple objects
     */
    private static void demonstrateMultipleObjects() {
        System.out.println("4. Multiple Objects:");
        System.out.println("===================");
        
        // Creating an array of Student objects
        Student[] students = new Student[3];
        students[0] = new Student("Eve", 20, "Biology");
        students[1] = new Student("Frank", 21, "Chemistry");
        students[2] = new Student("Grace", 19, "Physics");
        
        System.out.println("Student Information:");
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + students[i]);
        }
        
        // Finding the youngest student
        Student youngest = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getAge() < youngest.getAge()) {
                youngest = students[i];
            }
        }
        System.out.println("\nYoungest student: " + youngest);
        System.out.println();
    }
    
    /**
     * Demonstrates object lifecycle
     */
    private static void demonstrateObjectLifecycle() {
        System.out.println("5. Object Lifecycle:");
        System.out.println("===================");
        
        // Object creation
        System.out.println("Creating objects...");
        Student tempStudent = new Student("Temp", 18, "General");
        System.out.println("Object created: " + tempStudent);
        
        // Object usage
        tempStudent.study();
        tempStudent.takeExam();
        
        // Object reference becomes null (eligible for garbage collection)
        System.out.println("Setting reference to null...");
        tempStudent = null;
        System.out.println("Reference is now null");
        
        // Suggesting garbage collection (not guaranteed)
        System.gc();
        System.out.println("Garbage collection suggested");
        System.out.println();
    }
}

/**
 * Student class to demonstrate object-oriented concepts
 */
class Student {
    // Instance variables (attributes)
    private String name;
    private int age;
    private String major;
    private static int studentCount = 0; // Class variable
    
    // Default constructor
    public Student() {
        this.name = "Unknown";
        this.age = 0;
        this.major = "Undeclared";
        studentCount++;
        System.out.println("Default constructor called. Total students: " + studentCount);
    }
    
    // Parameterized constructor
    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
        studentCount++;
        System.out.println("Parameterized constructor called for " + name + ". Total students: " + studentCount);
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getMajor() {
        return major;
    }
    
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    // Instance methods (behaviors)
    public void study() {
        System.out.println(name + " is studying " + major);
    }
    
    public void takeExam() {
        System.out.println(name + " is taking an exam in " + major);
    }
    
    public void introduce() {
        System.out.println("Hi, I'm " + name + ", " + age + " years old, studying " + major);
    }
    
    // Class method
    public static int getStudentCount() {
        return studentCount;
    }
    
    // Override toString method for better object representation
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", major='" + major + "'}";
    }
    
    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return age == student.age && 
               name.equals(student.name) && 
               major.equals(student.major);
    }
    
    // Override hashCode method
    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age, major);
    }
}
