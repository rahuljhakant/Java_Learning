package com.tutorial.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Encapsulation Demo - Mastering Data Hiding and Access Control in Java
 * 
 * This comprehensive tutorial demonstrates the concept of encapsulation in Java,
 * which is one of the four fundamental principles of Object-Oriented Programming.
 * Encapsulation involves bundling data and methods together and controlling
 * access to the internal state of objects through well-defined interfaces.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what encapsulation is and why it's important
 * - Learn about access modifiers and their role in encapsulation
 * - Master getter and setter methods for controlled access
 * - Understand data validation and business logic in setters
 * - Learn about immutable objects and their benefits
 * - Practice with real-world encapsulation examples
 * - Understand the benefits of encapsulation in software design
 * 
 * KEY CONCEPTS:
 * 1. Data Hiding: Keeping internal data private and inaccessible from outside
 * 2. Access Modifiers: public, private, protected, and default access levels
 * 3. Getter Methods: Methods to read private data safely
 * 4. Setter Methods: Methods to modify private data with validation
 * 5. Immutable Objects: Objects whose state cannot be changed after creation
 * 6. Business Logic: Rules and validation in setter methods
 * 7. Information Hiding: Hiding implementation details from users
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class EncapsulationDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Encapsulation Demo ===");
        System.out.println();
        
        // 1. Basic Encapsulation with Getters and Setters
        demonstrateBasicEncapsulation();
        
        // 2. Data Validation in Setters
        demonstrateDataValidation();
        
        // 3. Immutable Objects
        demonstrateImmutableObjects();
        
        // 4. Encapsulation with Business Logic
        demonstrateBusinessLogicEncapsulation();
        
        // 5. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 6. Encapsulation vs Public Fields
        demonstrateEncapsulationVsPublicFields();
        
        // 7. Benefits of Encapsulation
        demonstrateBenefitsOfEncapsulation();
        
        // 8. Best Practices and Common Patterns
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic encapsulation with getters and setters
     * 
     * This section shows how to create classes with private fields
     * and public methods to access and modify them safely.
     */
    private static void demonstrateBasicEncapsulation() {
        System.out.println("1. Basic Encapsulation with Getters and Setters:");
        System.out.println("===============================================");
        
        // Creating objects with encapsulated data
        Person person = new Person();
        
        // Using setters to set data
        person.setName("John Doe");
        person.setAge(25);
        person.setEmail("john.doe@example.com");
        
        // Using getters to retrieve data
        System.out.println("Person Information:");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Email: " + person.getEmail());
        
        // Demonstrating encapsulation benefits
        System.out.println("\nEncapsulation Benefits:");
        System.out.println("----------------------");
        
        // Cannot access private fields directly
        // person.name = "Jane Doe"; // This would cause compilation error
        
        // Must use setter methods
        person.setName("Jane Doe");
        System.out.println("Updated name: " + person.getName());
        
        // Creating another person
        Person person2 = new Person("Bob Smith", 30, "bob.smith@example.com");
        System.out.println("\nSecond Person:");
        System.out.println("Name: " + person2.getName());
        System.out.println("Age: " + person2.getAge());
        System.out.println("Email: " + person2.getEmail());
        
        System.out.println();
    }
    
    /**
     * Demonstrates data validation in setter methods
     * 
     * Setter methods can include validation logic to ensure
     * data integrity and prevent invalid states.
     */
    private static void demonstrateDataValidation() {
        System.out.println("2. Data Validation in Setters:");
        System.out.println("=============================");
        
        // Creating a bank account with validation
        BankAccount account = new BankAccount("123456789", "John Doe", 1000.0);
        
        System.out.println("Initial Account Information:");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Balance: $" + account.getBalance());
        
        // Testing valid operations
        System.out.println("\nValid Operations:");
        System.out.println("----------------");
        
        account.deposit(500.0);
        System.out.println("Balance after deposit: $" + account.getBalance());
        
        account.withdraw(200.0);
        System.out.println("Balance after withdrawal: $" + account.getBalance());
        
        // Testing invalid operations
        System.out.println("\nInvalid Operations:");
        System.out.println("------------------");
        
        account.deposit(-100.0); // Invalid deposit
        System.out.println("Balance after invalid deposit: $" + account.getBalance());
        
        account.withdraw(2000.0); // Invalid withdrawal
        System.out.println("Balance after invalid withdrawal: $" + account.getBalance());
        
        // Testing setter validation
        System.out.println("\nSetter Validation:");
        System.out.println("-----------------");
        
        account.setAccountHolder("Jane Smith"); // Valid name
        System.out.println("Updated account holder: " + account.getAccountHolder());
        
        account.setAccountHolder(""); // Invalid name
        System.out.println("Account holder after invalid name: " + account.getAccountHolder());
        
        System.out.println();
    }
    
    /**
     * Demonstrates immutable objects
     * 
     * Immutable objects are objects whose state cannot be changed
     * after creation. They provide thread safety and prevent
     * accidental modifications.
     */
    private static void demonstrateImmutableObjects() {
        System.out.println("3. Immutable Objects:");
        System.out.println("====================");
        
        // Creating immutable objects
        ImmutablePerson person1 = new ImmutablePerson("Alice", 25, "alice@example.com");
        ImmutablePerson person2 = new ImmutablePerson("Bob", 30, "bob@example.com");
        
        System.out.println("Immutable Person 1:");
        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());
        System.out.println("Email: " + person1.getEmail());
        
        System.out.println("\nImmutable Person 2:");
        System.out.println("Name: " + person2.getName());
        System.out.println("Age: " + person2.getAge());
        System.out.println("Email: " + person2.getEmail());
        
        // Demonstrating immutability
        System.out.println("\nImmutability Benefits:");
        System.out.println("--------------------");
        
        // Cannot modify immutable objects
        // person1.setName("Charlie"); // This would cause compilation error
        
        // Creating new objects with modified values
        ImmutablePerson person3 = person1.withName("Charlie");
        System.out.println("Original person: " + person1.getName());
        System.out.println("Modified person: " + person3.getName());
        
        ImmutablePerson person4 = person1.withAge(26);
        System.out.println("Original age: " + person1.getAge());
        System.out.println("Modified age: " + person4.getAge());
        
        // Creating immutable collections
        ImmutableList<String> list = new ImmutableList<>("Apple", "Banana", "Cherry");
        System.out.println("\nImmutable List:");
        System.out.println("Size: " + list.size());
        System.out.println("First element: " + list.get(0));
        System.out.println("All elements: " + list.getAll());
        
        System.out.println();
    }
    
    /**
     * Demonstrates encapsulation with business logic
     * 
     * This section shows how to encapsulate business rules
     * and logic within classes to maintain data integrity.
     */
    private static void demonstrateBusinessLogicEncapsulation() {
        System.out.println("4. Encapsulation with Business Logic:");
        System.out.println("====================================");
        
        // Creating a student with business logic
        Student student = new Student("John Doe", "S001");
        
        System.out.println("Student Information:");
        System.out.println("Name: " + student.getName());
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("GPA: " + student.getGPA());
        System.out.println("Status: " + student.getStatus());
        
        // Adding courses with business logic
        System.out.println("\nAdding Courses:");
        System.out.println("--------------");
        
        student.addCourse("Mathematics", 4, 85);
        student.addCourse("Physics", 3, 90);
        student.addCourse("Chemistry", 3, 78);
        
        System.out.println("GPA after adding courses: " + student.getGPA());
        System.out.println("Status: " + student.getStatus());
        
        // Testing business rules
        System.out.println("\nTesting Business Rules:");
        System.out.println("----------------------");
        
        // Cannot add duplicate course
        student.addCourse("Mathematics", 4, 85);
        
        // Cannot add course with invalid grade
        student.addCourse("Biology", 3, 150);
        
        // Cannot add course with invalid credits
        student.addCourse("History", -2, 80);
        
        System.out.println("Final GPA: " + student.getGPA());
        System.out.println("Final Status: " + student.getStatus());
        
        // Creating a product with business logic
        System.out.println("\nProduct with Business Logic:");
        System.out.println("----------------------------");
        
        Product product = new Product("Laptop", 1000.0, 10);
        
        System.out.println("Product: " + product.getName());
        System.out.println("Price: $" + product.getPrice());
        System.out.println("Stock: " + product.getStock());
        System.out.println("Available: " + product.isAvailable());
        
        // Testing product operations
        product.updatePrice(1200.0);
        System.out.println("Updated price: $" + product.getPrice());
        
        product.addStock(5);
        System.out.println("Stock after adding: " + product.getStock());
        
        product.reduceStock(3);
        System.out.println("Stock after reducing: " + product.getStock());
        
        // Testing business rules
        product.updatePrice(-100.0); // Invalid price
        product.addStock(-2); // Invalid stock
        product.reduceStock(20); // Insufficient stock
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples of encapsulation
     * 
     * This section shows practical examples of how encapsulation
     * is used in real-world software development.
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("5. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: Library Management System
        System.out.println("Example 1: Library Management System");
        System.out.println("-----------------------------------");
        
        LibraryBook book = new LibraryBook("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        
        System.out.println("Book Information:");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Available: " + book.isAvailable());
        
        // Book operations
        book.borrow();
        System.out.println("Available after borrowing: " + book.isAvailable());
        
        book.returnBook();
        System.out.println("Available after returning: " + book.isAvailable());
        
        // Example 2: Employee Management System
        System.out.println("\nExample 2: Employee Management System");
        System.out.println("------------------------------------");
        
        Employee employee = new Employee("Alice Smith", "E001", 50000.0);
        
        System.out.println("Employee Information:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Salary: $" + employee.getSalary());
        System.out.println("Department: " + employee.getDepartment());
        
        // Employee operations
        employee.setDepartment("Engineering");
        System.out.println("Updated department: " + employee.getDepartment());
        
        employee.giveRaise(5000.0);
        System.out.println("Salary after raise: $" + employee.getSalary());
        
        // Example 3: Car Rental System
        System.out.println("\nExample 3: Car Rental System");
        System.out.println("----------------------------");
        
        RentalCar car = new RentalCar("Toyota Camry", "ABC123", 50.0);
        
        System.out.println("Car Information:");
        System.out.println("Model: " + car.getModel());
        System.out.println("License Plate: " + car.getLicensePlate());
        System.out.println("Daily Rate: $" + car.getDailyRate());
        System.out.println("Available: " + car.isAvailable());
        
        // Car operations
        car.rent("John Doe");
        System.out.println("Available after renting: " + car.isAvailable());
        System.out.println("Rented by: " + car.getRentedBy());
        
        car.returnCar();
        System.out.println("Available after returning: " + car.isAvailable());
        
        System.out.println();
    }
    
    /**
     * Demonstrates encapsulation vs public fields
     * 
     * This section shows the difference between using encapsulation
     * and exposing public fields directly.
     */
    private static void demonstrateEncapsulationVsPublicFields() {
        System.out.println("6. Encapsulation vs Public Fields:");
        System.out.println("=================================");
        
        // Using encapsulated class
        System.out.println("Encapsulated Class:");
        System.out.println("------------------");
        
        EncapsulatedClass encapsulated = new EncapsulatedClass();
        encapsulated.setValue(100);
        encapsulated.setName("Encapsulated");
        
        System.out.println("Value: " + encapsulated.getValue());
        System.out.println("Name: " + encapsulated.getName());
        
        // Testing validation
        encapsulated.setValue(-50); // Invalid value
        System.out.println("Value after invalid input: " + encapsulated.getValue());
        
        // Using class with public fields
        System.out.println("\nClass with Public Fields:");
        System.out.println("------------------------");
        
        PublicFieldsClass publicFields = new PublicFieldsClass();
        publicFields.value = 100;
        publicFields.name = "Public Fields";
        
        System.out.println("Value: " + publicFields.value);
        System.out.println("Name: " + publicFields.name);
        
        // No validation possible
        publicFields.value = -50; // Invalid value accepted
        System.out.println("Value after invalid input: " + publicFields.value);
        
        System.out.println("\nComparison:");
        System.out.println("----------");
        System.out.println("Encapsulation provides:");
        System.out.println("• Data validation");
        System.out.println("• Controlled access");
        System.out.println("• Business logic enforcement");
        System.out.println("• Future flexibility");
        
        System.out.println("\nPublic fields provide:");
        System.out.println("• Direct access");
        System.out.println("• No validation");
        System.out.println("• No business logic");
        System.out.println("• Limited flexibility");
        
        System.out.println();
    }
    
    /**
     * Demonstrates the benefits of encapsulation
     * 
     * This section shows the advantages of using encapsulation
     * in software design and development.
     */
    private static void demonstrateBenefitsOfEncapsulation() {
        System.out.println("7. Benefits of Encapsulation:");
        System.out.println("============================");
        
        // Benefit 1: Data Integrity
        System.out.println("Benefit 1: Data Integrity");
        System.out.println("------------------------");
        
        BankAccount account = new BankAccount("123456789", "John Doe", 1000.0);
        
        // Validation prevents invalid states
        account.deposit(-100.0); // Invalid deposit
        account.withdraw(2000.0); // Invalid withdrawal
        
        System.out.println("Balance remains valid: $" + account.getBalance());
        
        // Benefit 2: Controlled Access
        System.out.println("\nBenefit 2: Controlled Access");
        System.out.println("---------------------------");
        
        Student student = new Student("Jane Doe", "S002");
        
        // Only valid operations are allowed
        student.addCourse("Mathematics", 4, 85);
        student.addCourse("Physics", 3, 90);
        
        System.out.println("GPA: " + student.getGPA());
        System.out.println("Status: " + student.getStatus());
        
        // Benefit 3: Future Flexibility
        System.out.println("\nBenefit 3: Future Flexibility");
        System.out.println("----------------------------");
        
        Product product = new Product("Smartphone", 500.0, 20);
        
        // Internal implementation can change without affecting clients
        product.updatePrice(450.0);
        product.addStock(10);
        
        System.out.println("Price: $" + product.getPrice());
        System.out.println("Stock: " + product.getStock());
        
        // Benefit 4: Business Logic Centralization
        System.out.println("\nBenefit 4: Business Logic Centralization");
        System.out.println("----------------------------------------");
        
        Employee employee = new Employee("Bob Smith", "E003", 60000.0);
        
        // Business rules are enforced automatically
        employee.giveRaise(10000.0);
        employee.setDepartment("Marketing");
        
        System.out.println("Salary: $" + employee.getSalary());
        System.out.println("Department: " + employee.getDepartment());
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices and common patterns
     * 
     * This section shows best practices for implementing
     * encapsulation effectively in Java applications.
     */
    private static void demonstrateBestPractices() {
        System.out.println("8. Best Practices and Common Patterns:");
        System.out.println("=====================================");
        
        // Best Practice 1: Always use private fields
        System.out.println("Best Practice 1: Private Fields");
        System.out.println("------------------------------");
        
        Person person = new Person("Alice", 25, "alice@example.com");
        System.out.println("Person: " + person.getName() + ", " + person.getAge());
        
        // Best Practice 2: Provide getters and setters
        System.out.println("\nBest Practice 2: Getters and Setters");
        System.out.println("-----------------------------------");
        
        BankAccount account = new BankAccount("987654321", "Bob", 2000.0);
        account.deposit(500.0);
        System.out.println("Balance: $" + account.getBalance());
        
        // Best Practice 3: Validate input in setters
        System.out.println("\nBest Practice 3: Input Validation");
        System.out.println("--------------------------------");
        
        Student student = new Student("Charlie", "S003");
        student.addCourse("Java Programming", 4, 95);
        System.out.println("GPA: " + student.getGPA());
        
        // Best Practice 4: Use immutable objects when possible
        System.out.println("\nBest Practice 4: Immutable Objects");
        System.out.println("---------------------------------");
        
        ImmutablePerson immutable = new ImmutablePerson("David", 30, "david@example.com");
        System.out.println("Immutable person: " + immutable.getName());
        
        // Best Practice 5: Encapsulate business logic
        System.out.println("\nBest Practice 5: Business Logic Encapsulation");
        System.out.println("--------------------------------------------");
        
        Product product = new Product("Tablet", 300.0, 15);
        product.updatePrice(280.0);
        product.reduceStock(2);
        System.out.println("Product: " + product.getName() + ", Price: $" + product.getPrice() + ", Stock: " + product.getStock());
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Encapsulation hides internal implementation details");
        System.out.println("• Use private fields and public methods for controlled access");
        System.out.println("• Implement validation in setter methods");
        System.out.println("• Create immutable objects when state shouldn't change");
        System.out.println("• Encapsulate business logic within classes");
        System.out.println("• Encapsulation promotes data integrity and maintainability");
        System.out.println("• Use encapsulation to provide future flexibility");
        System.out.println("• Always prefer encapsulation over public fields");
    }
}

// Basic encapsulation example

/**
 * Person class demonstrating basic encapsulation
 */
class Person {
    private String name;
    private int age;
    private String email;
    
    // Default constructor
    public Person() {
        this.name = "";
        this.age = 0;
        this.email = "";
    }
    
    // Parameterized constructor
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Setter methods
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }
    
    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        }
    }
    
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        }
    }
}

// Data validation example

/**
 * BankAccount class demonstrating data validation
 */
class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    // Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Setter methods with validation
    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && !accountHolder.trim().isEmpty()) {
            this.accountHolder = accountHolder;
        }
    }
    
    // Business methods with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount: $" + amount);
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount: $" + amount);
        }
    }
}

// Immutable object example

/**
 * ImmutablePerson class demonstrating immutability
 */
class ImmutablePerson {
    private final String name;
    private final int age;
    private final String email;
    
    public ImmutablePerson(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Methods that return new instances
    public ImmutablePerson withName(String name) {
        return new ImmutablePerson(name, this.age, this.email);
    }
    
    public ImmutablePerson withAge(int age) {
        return new ImmutablePerson(this.name, age, this.email);
    }
    
    public ImmutablePerson withEmail(String email) {
        return new ImmutablePerson(this.name, this.age, email);
    }
}

/**
 * ImmutableList class demonstrating immutable collections
 */
class ImmutableList<T> {
    private final List<T> items;
    
    @SafeVarargs
    public ImmutableList(T... items) {
        this.items = Arrays.asList(items);
    }
    
    public T get(int index) {
        return items.get(index);
    }
    
    public int size() {
        return items.size();
    }
    
    public List<T> getAll() {
        return new ArrayList<>(items);
    }
}

// Business logic encapsulation example

/**
 * Student class demonstrating business logic encapsulation
 */
class Student {
    private String name;
    private String studentId;
    private List<Course> courses;
    private double gpa;
    private String status;
    
    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.courses = new ArrayList<>();
        this.gpa = 0.0;
        this.status = "Active";
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public double getGPA() {
        return gpa;
    }
    
    public String getStatus() {
        return status;
    }
    
    // Business methods with encapsulated logic
    public void addCourse(String courseName, int credits, int grade) {
        // Validation
        if (courseName == null || courseName.trim().isEmpty()) {
            System.out.println("Invalid course name");
            return;
        }
        
        if (credits <= 0 || credits > 6) {
            System.out.println("Invalid credits: " + credits);
            return;
        }
        
        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade: " + grade);
            return;
        }
        
        // Check for duplicate course
        for (Course course : courses) {
            if (course.getName().equals(courseName)) {
                System.out.println("Course already exists: " + courseName);
                return;
            }
        }
        
        // Add course
        courses.add(new Course(courseName, credits, grade));
        calculateGPA();
        updateStatus();
        
        System.out.println("Added course: " + courseName + " (" + credits + " credits, Grade: " + grade + ")");
    }
    
    private void calculateGPA() {
        if (courses.isEmpty()) {
            gpa = 0.0;
            return;
        }
        
        double totalPoints = 0;
        int totalCredits = 0;
        
        for (Course course : courses) {
            double points = getGradePoints(course.getGrade());
            totalPoints += points * course.getCredits();
            totalCredits += course.getCredits();
        }
        
        gpa = totalCredits > 0 ? totalPoints / totalCredits : 0.0;
    }
    
    private double getGradePoints(int grade) {
        if (grade >= 90) return 4.0;
        if (grade >= 80) return 3.0;
        if (grade >= 70) return 2.0;
        if (grade >= 60) return 1.0;
        return 0.0;
    }
    
    private void updateStatus() {
        if (gpa >= 3.5) {
            status = "Honor Roll";
        } else if (gpa >= 2.0) {
            status = "Good Standing";
        } else {
            status = "Academic Probation";
        }
    }
}

/**
 * Course class for student courses
 */
class Course {
    private String name;
    private int credits;
    private int grade;
    
    public Course(String name, int credits, int grade) {
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public int getGrade() {
        return grade;
    }
}

/**
 * Product class demonstrating business logic encapsulation
 */
class Product {
    private String name;
    private double price;
    private int stock;
    
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getStock() {
        return stock;
    }
    
    public boolean isAvailable() {
        return stock > 0;
    }
    
    // Business methods with encapsulated logic
    public void updatePrice(double newPrice) {
        if (newPrice > 0) {
            this.price = newPrice;
            System.out.println("Price updated to: $" + newPrice);
        } else {
            System.out.println("Invalid price: $" + newPrice);
        }
    }
    
    public void addStock(int quantity) {
        if (quantity > 0) {
            this.stock += quantity;
            System.out.println("Added " + quantity + " units. New stock: " + stock);
        } else {
            System.out.println("Invalid quantity: " + quantity);
        }
    }
    
    public void reduceStock(int quantity) {
        if (quantity > 0 && quantity <= stock) {
            this.stock -= quantity;
            System.out.println("Reduced " + quantity + " units. New stock: " + stock);
        } else {
            System.out.println("Invalid quantity or insufficient stock: " + quantity);
        }
    }
}

// Real-world examples

/**
 * LibraryBook class for library management
 */
class LibraryBook {
    private String title;
    private String author;
    private String isbn;
    private boolean available;
    private String borrowedBy;
    
    public LibraryBook(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
        this.borrowedBy = null;
    }
    
    // Getter methods
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public String getBorrowedBy() {
        return borrowedBy;
    }
    
    // Business methods
    public void borrow() {
        if (available) {
            available = false;
            borrowedBy = "Unknown"; // In real system, this would be set properly
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book is not available for borrowing");
        }
    }
    
    public void returnBook() {
        if (!available) {
            available = true;
            borrowedBy = null;
            System.out.println("Book returned successfully");
        } else {
            System.out.println("Book is already available");
        }
    }
}

/**
 * Employee class for employee management
 */
class Employee {
    private String name;
    private String employeeId;
    private double salary;
    private String department;
    
    public Employee(String name, String employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
        this.department = "Unassigned";
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public String getDepartment() {
        return department;
    }
    
    // Setter methods with validation
    public void setDepartment(String department) {
        if (department != null && !department.trim().isEmpty()) {
            this.department = department;
            System.out.println("Department updated to: " + department);
        } else {
            System.out.println("Invalid department name");
        }
    }
    
    // Business methods
    public void giveRaise(double amount) {
        if (amount > 0) {
            this.salary += amount;
            System.out.println("Raise of $" + amount + " given. New salary: $" + salary);
        } else {
            System.out.println("Invalid raise amount: $" + amount);
        }
    }
}

/**
 * RentalCar class for car rental system
 */
class RentalCar {
    private String model;
    private String licensePlate;
    private double dailyRate;
    private boolean available;
    private String rentedBy;
    
    public RentalCar(String model, String licensePlate, double dailyRate) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.dailyRate = dailyRate;
        this.available = true;
        this.rentedBy = null;
    }
    
    // Getter methods
    public String getModel() {
        return model;
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public double getDailyRate() {
        return dailyRate;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public String getRentedBy() {
        return rentedBy;
    }
    
    // Business methods
    public void rent(String customerName) {
        if (available) {
            available = false;
            rentedBy = customerName;
            System.out.println("Car rented to: " + customerName);
        } else {
            System.out.println("Car is not available for rental");
        }
    }
    
    public void returnCar() {
        if (!available) {
            available = true;
            rentedBy = null;
            System.out.println("Car returned successfully");
        } else {
            System.out.println("Car is already available");
        }
    }
}

// Encapsulation vs public fields comparison

/**
 * Class demonstrating proper encapsulation
 */
class EncapsulatedClass {
    private int value;
    private String name;
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        if (value >= 0) {
            this.value = value;
        } else {
            System.out.println("Invalid value: " + value);
        }
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name");
        }
    }
}

/**
 * Class demonstrating public fields (not recommended)
 */
class PublicFieldsClass {
    public int value;
    public String name;
}
