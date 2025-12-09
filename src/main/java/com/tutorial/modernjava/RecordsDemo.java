package com.tutorial.modernjava;

import java.util.*;

/**
 * Records Demo - Immutable Data Carriers
 * 
 * This comprehensive tutorial demonstrates Java Records introduced in Java 14
 * and finalized in Java 15. Records provide a concise way to declare classes
 * that are transparent holders for immutable data.
 * 
 * LEARNING OBJECTIVES:
 * - Understand the purpose and benefits of records
 * - Create and use record classes effectively
 * - Apply records in real-world scenarios
 * - Use record features like compact constructors
 * - Integrate records with other Java features
 * - Apply record best practices and patterns
 * 
 * KEY CONCEPTS:
 * 1. Record Declaration: Concise class declaration for data carriers
 * 2. Immutable Data: Automatic generation of getters and equals/hashCode
 * 3. Compact Constructors: Validation and transformation in constructors
 * 4. Record Patterns: Pattern matching with records (Java 19+)
 * 5. Integration: Using records with collections, streams, and APIs
 * 6. Best Practices: When and how to use records effectively
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class RecordsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Records Demo ===");
        System.out.println();
        
        // 1. Basic Record Usage
        demonstrateBasicRecords();
        
        // 2. Record with Validation
        demonstrateRecordValidation();
        
        // 3. Record with Methods
        demonstrateRecordMethods();
        
        // 4. Record with Collections
        demonstrateRecordCollections();
        
        // 5. Record with Streams
        demonstrateRecordStreams();
        
        // 6. Record with APIs
        demonstrateRecordAPIs();
        
        // 7. Record Best Practices
        demonstrateRecordBestPractices();
    }
    
    /**
     * Demonstrates basic record usage
     */
    private static void demonstrateBasicRecords() {
        System.out.println("1. Basic Record Usage:");
        System.out.println("=====================");
        
        // Create records
        Person person = new Person("John Doe", 30, "john@example.com");
        Point point = new Point(10, 20);
        Rectangle rectangle = new Rectangle(5, 10);
        
        System.out.println("Person: " + person);
        System.out.println("Point: " + point);
        System.out.println("Rectangle: " + rectangle);
        
        // Access record components
        System.out.println("Person name: " + person.name());
        System.out.println("Person age: " + person.age());
        System.out.println("Point x: " + point.x());
        System.out.println("Rectangle area: " + rectangle.area());
        
        // Record equality
        Person person2 = new Person("John Doe", 30, "john@example.com");
        System.out.println("Persons equal: " + person.equals(person2));
        System.out.println("Person hash codes: " + person.hashCode() + " vs " + person2.hashCode());
        
        System.out.println();
    }
    
    /**
     * Demonstrates record with validation
     */
    private static void demonstrateRecordValidation() {
        System.out.println("2. Record with Validation:");
        System.out.println("=========================");
        
        try {
            // Valid email
            Email email1 = new Email("user@example.com");
            System.out.println("Valid email: " + email1);
            
            // Invalid email
            Email email2 = new Email("invalid-email");
            System.out.println("Invalid email: " + email2);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Email validation error: " + e.getMessage());
        }
        
        try {
            // Valid age
            Age age1 = new Age(25);
            System.out.println("Valid age: " + age1);
            
            // Invalid age
            Age age2 = new Age(-5);
            System.out.println("Invalid age: " + age2);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Age validation error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates record with methods
     */
    private static void demonstrateRecordMethods() {
        System.out.println("3. Record with Methods:");
        System.out.println("======================");
        
        // Bank account with methods
        BankAccount account = new BankAccount("123456789", 1000.0, "USD");
        System.out.println("Account: " + account);
        System.out.println("Formatted balance: " + account.getFormattedBalance());
        System.out.println("Is high balance: " + account.isHighBalance());
        
        // Transaction with methods
        Transaction transaction = new Transaction("TXN001", 100.0, "USD", "DEPOSIT");
        System.out.println("Transaction: " + transaction);
        System.out.println("Is deposit: " + transaction.isDeposit());
        System.out.println("Is withdrawal: " + transaction.isWithdrawal());
        System.out.println("Formatted amount: " + transaction.getFormattedAmount());
        
        System.out.println();
    }
    
    /**
     * Demonstrates record with collections
     */
    private static void demonstrateRecordCollections() {
        System.out.println("4. Record with Collections:");
        System.out.println("==========================");
        
        // Create a list of products
        List<Product> products = Arrays.asList(
            new Product("Laptop", 999.99, "Electronics"),
            new Product("Book", 19.99, "Education"),
            new Product("Phone", 699.99, "Electronics"),
            new Product("Pen", 2.99, "Office")
        );
        
        System.out.println("Products:");
        products.forEach(System.out::println);
        
        // Filter electronics
        List<Product> electronics = products.stream()
            .filter(p -> p.category().equals("Electronics"))
            .toList();
        
        System.out.println("\nElectronics:");
        electronics.forEach(System.out::println);
        
        // Calculate total price
        double totalPrice = products.stream()
            .mapToDouble(Product::price)
            .sum();
        
        System.out.println("Total price: $" + String.format("%.2f", totalPrice));
        
        System.out.println();
    }
    
    /**
     * Demonstrates record with streams
     */
    private static void demonstrateRecordStreams() {
        System.out.println("5. Record with Streams:");
        System.out.println("======================");
        
        // Create a list of students
        List<Student> students = Arrays.asList(
            new Student("Alice", 85, "Computer Science"),
            new Student("Bob", 92, "Mathematics"),
            new Student("Charlie", 78, "Computer Science"),
            new Student("Diana", 95, "Physics"),
            new Student("Eve", 88, "Computer Science")
        );
        
        System.out.println("Students:");
        students.forEach(System.out::println);
        
        // Find top students
        List<Student> topStudents = students.stream()
            .filter(s -> s.grade() >= 90)
            .sorted((s1, s2) -> Integer.compare(s2.grade(), s1.grade()))
            .toList();
        
        System.out.println("\nTop students (90+):");
        topStudents.forEach(System.out::println);
        
        // Group by major
        Map<String, List<Student>> studentsByMajor = students.stream()
            .collect(java.util.stream.Collectors.groupingBy(Student::major));
        
        System.out.println("\nStudents by major:");
        studentsByMajor.forEach((major, studentList) -> {
            System.out.println(major + ": " + studentList.size() + " students");
        });
        
        // Calculate average grade by major
        Map<String, Double> averageGradeByMajor = students.stream()
            .collect(java.util.stream.Collectors.groupingBy(
                Student::major,
                java.util.stream.Collectors.averagingInt(Student::grade)
            ));
        
        System.out.println("\nAverage grade by major:");
        averageGradeByMajor.forEach((major, avgGrade) -> {
            System.out.println(major + ": " + String.format("%.1f", avgGrade));
        });
        
        System.out.println();
    }
    
    /**
     * Demonstrates record with APIs
     */
    private static void demonstrateRecordAPIs() {
        System.out.println("6. Record with APIs:");
        System.out.println("===================");
        
        // API response simulation
        ApiResponse<String> successResponse = new ApiResponse<>(200, "Success", "Data retrieved successfully");
        ApiResponse<String> errorResponse = new ApiResponse<>(404, "Not Found", "Resource not found");
        
        System.out.println("Success response: " + successResponse);
        System.out.println("Error response: " + errorResponse);
        System.out.println("Is success: " + successResponse.isSuccess());
        System.out.println("Is error: " + errorResponse.isError());
        
        // Configuration record
        DatabaseConfig dbConfig = new DatabaseConfig("localhost", 5432, "mydb", "admin");
        System.out.println("Database config: " + dbConfig);
        System.out.println("Connection string: " + dbConfig.getConnectionString());
        
        // Event record
        Event event = new Event("user.login", System.currentTimeMillis(), "user123");
        System.out.println("Event: " + event);
        System.out.println("Event age: " + event.getAgeInSeconds() + " seconds");
        
        System.out.println();
    }
    
    /**
     * Demonstrates record best practices
     */
    private static void demonstrateRecordBestPractices() {
        System.out.println("7. Record Best Practices:");
        System.out.println("=========================");
        
        System.out.println("✓ Use records for immutable data carriers");
        System.out.println("✓ Keep records simple and focused");
        System.out.println("✓ Use compact constructors for validation");
        System.out.println("✓ Add methods for derived data");
        System.out.println("✓ Use records with collections and streams");
        System.out.println("✓ Consider records for API responses and DTOs");
        System.out.println("✓ Use records for configuration and settings");
        System.out.println("✓ Avoid records for complex business logic");
        System.out.println("✓ Use records for value objects and data transfer");
        System.out.println("✓ Consider records for event and message types");
        
        System.out.println();
    }
    
    // Record definitions
    
    /**
     * Basic person record
     */
    public record Person(String name, int age, String email) {
        // Compact constructor for validation
        public Person {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
            if (age < 0 || age > 150) {
                throw new IllegalArgumentException("Age must be between 0 and 150");
            }
            if (email == null || !email.contains("@")) {
                throw new IllegalArgumentException("Email must be valid");
            }
        }
    }
    
    /**
     * Point record with methods
     */
    public record Point(int x, int y) {
        public double distanceFromOrigin() {
            return Math.sqrt(x * x + y * y);
        }
        
        public Point translate(int dx, int dy) {
            return new Point(x + dx, y + dy);
        }
    }
    
    /**
     * Rectangle record with methods
     */
    public record Rectangle(int width, int height) {
        public int area() {
            return width * height;
        }
        
        public int perimeter() {
            return 2 * (width + height);
        }
        
        public boolean isSquare() {
            return width == height;
        }
    }
    
    /**
     * Email record with validation
     */
    public record Email(String address) {
        public Email {
            if (address == null || !address.contains("@") || !address.contains(".")) {
                throw new IllegalArgumentException("Invalid email address: " + address);
            }
        }
    }
    
    /**
     * Age record with validation
     */
    public record Age(int value) {
        public Age {
            if (value < 0 || value > 150) {
                throw new IllegalArgumentException("Age must be between 0 and 150: " + value);
            }
        }
    }
    
    /**
     * Bank account record with methods
     */
    public record BankAccount(String accountNumber, double balance, String currency) {
        public String getFormattedBalance() {
            return String.format("%s %.2f", currency, balance);
        }
        
        public boolean isHighBalance() {
            return balance > 10000;
        }
    }
    
    /**
     * Transaction record with methods
     */
    public record Transaction(String id, double amount, String currency, String type) {
        public boolean isDeposit() {
            return "DEPOSIT".equals(type);
        }
        
        public boolean isWithdrawal() {
            return "WITHDRAWAL".equals(type);
        }
        
        public String getFormattedAmount() {
            return String.format("%s %.2f", currency, amount);
        }
    }
    
    /**
     * Product record
     */
    public record Product(String name, double price, String category) {}
    
    /**
     * Student record
     */
    public record Student(String name, int grade, String major) {}
    
    /**
     * API response record
     */
    public record ApiResponse<T>(int statusCode, String message, T data) {
        public boolean isSuccess() {
            return statusCode >= 200 && statusCode < 300;
        }
        
        public boolean isError() {
            return statusCode >= 400;
        }
    }
    
    /**
     * Database configuration record
     */
    public record DatabaseConfig(String host, int port, String database, String username) {
        public String getConnectionString() {
            return String.format("jdbc:postgresql://%s:%d/%s", host, port, database);
        }
    }
    
    /**
     * Event record
     */
    public record Event(String type, long timestamp, String userId) {
        public long getAgeInSeconds() {
            return (System.currentTimeMillis() - timestamp) / 1000;
        }
    }
}
