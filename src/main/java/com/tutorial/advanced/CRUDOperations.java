package com.tutorial.advanced;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD Operations - Database Operations
 * 
 * This comprehensive tutorial demonstrates CRUD (Create, Read, Update, Delete)
 * operations using JDBC, including prepared statements, result sets,
 * and transaction management.
 * 
 * LEARNING OBJECTIVES:
 * - Perform CRUD operations using JDBC
 * - Use prepared statements for security
 * - Handle result sets effectively
 * - Implement transaction management
 * - Apply CRUD best practices
 * - Build database applications
 * 
 * KEY CONCEPTS:
 * 1. CRUD Operations: Create, Read, Update, Delete
 * 2. Prepared Statements: Parameterized queries
 * 3. Result Sets: Query result handling
 * 4. Transactions: ACID properties
 * 5. Batch Operations: Multiple operations
 * 6. Best Practices: Secure and efficient operations
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class CRUDOperations {
    
    private static final String URL = "jdbc:mysql://localhost:3306/javatutorial";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    
    public static void main(String[] args) {
        System.out.println("=== CRUD Operations Demo ===");
        System.out.println();
        
        // 1. Create Table
        createTable();
        
        // 2. Create (Insert) Operations
        demonstrateCreateOperations();
        
        // 3. Read (Select) Operations
        demonstrateReadOperations();
        
        // 4. Update Operations
        demonstrateUpdateOperations();
        
        // 5. Delete Operations
        demonstrateDeleteOperations();
        
        // 6. Batch Operations
        demonstrateBatchOperations();
        
        // 7. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Create table for demonstration
     */
    private static void createTable() {
        System.out.println("1. Creating Table:");
        System.out.println("=================");
        
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS students (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                email VARCHAR(100) UNIQUE NOT NULL,
                age INT,
                grade VARCHAR(10),
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            )
            """;
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            
            statement.executeUpdate(createTableSQL);
            System.out.println("✓ Students table created successfully");
            
        } catch (SQLException e) {
            System.err.println("✗ Error creating table: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates create (insert) operations
     */
    private static void demonstrateCreateOperations() {
        System.out.println("2. Create (Insert) Operations:");
        System.out.println("=============================");
        
        // Single insert
        String insertSQL = "INSERT INTO students (name, email, age, grade) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            
            // Insert first student
            statement.setString(1, "John Doe");
            statement.setString(2, "john.doe@email.com");
            statement.setInt(3, 20);
            statement.setString(4, "A");
            
            int rowsAffected = statement.executeUpdate();
            System.out.println("✓ Inserted " + rowsAffected + " student");
            
            // Insert second student
            statement.setString(1, "Jane Smith");
            statement.setString(2, "jane.smith@email.com");
            statement.setInt(3, 19);
            statement.setString(4, "B");
            
            rowsAffected = statement.executeUpdate();
            System.out.println("✓ Inserted " + rowsAffected + " student");
            
        } catch (SQLException e) {
            System.err.println("✗ Error inserting data: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates read (select) operations
     */
    private static void demonstrateReadOperations() {
        System.out.println("3. Read (Select) Operations:");
        System.out.println("============================");
        
        // Select all students
        String selectAllSQL = "SELECT * FROM students";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(selectAllSQL);
             ResultSet resultSet = statement.executeQuery()) {
            
            System.out.println("All Students:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int age = resultSet.getInt("age");
                String grade = resultSet.getString("grade");
                Timestamp createdAt = resultSet.getTimestamp("created_at");
                
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email + 
                                 ", Age: " + age + ", Grade: " + grade + ", Created: " + createdAt);
            }
            
        } catch (SQLException e) {
            System.err.println("✗ Error reading data: " + e.getMessage());
        }
        
        // Select specific student
        String selectByIdSQL = "SELECT * FROM students WHERE id = ?";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(selectByIdSQL)) {
            
            statement.setInt(1, 1);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("\nStudent with ID 1:");
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Email: " + resultSet.getString("email"));
                    System.out.println("Age: " + resultSet.getInt("age"));
                    System.out.println("Grade: " + resultSet.getString("grade"));
                }
            }
            
        } catch (SQLException e) {
            System.err.println("✗ Error reading specific data: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates update operations
     */
    private static void demonstrateUpdateOperations() {
        System.out.println("4. Update Operations:");
        System.out.println("====================");
        
        String updateSQL = "UPDATE students SET grade = ?, age = ? WHERE id = ?";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(updateSQL)) {
            
            statement.setString(1, "A+");
            statement.setInt(2, 21);
            statement.setInt(3, 1);
            
            int rowsAffected = statement.executeUpdate();
            System.out.println("✓ Updated " + rowsAffected + " student");
            
        } catch (SQLException e) {
            System.err.println("✗ Error updating data: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates delete operations
     */
    private static void demonstrateDeleteOperations() {
        System.out.println("5. Delete Operations:");
        System.out.println("====================");
        
        // Delete specific student
        String deleteSQL = "DELETE FROM students WHERE id = ?";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(deleteSQL)) {
            
            statement.setInt(1, 2);
            
            int rowsAffected = statement.executeUpdate();
            System.out.println("✓ Deleted " + rowsAffected + " student");
            
        } catch (SQLException e) {
            System.err.println("✗ Error deleting data: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates batch operations
     */
    private static void demonstrateBatchOperations() {
        System.out.println("6. Batch Operations:");
        System.out.println("===================");
        
        String insertSQL = "INSERT INTO students (name, email, age, grade) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            
            // Disable auto-commit for batch operations
            connection.setAutoCommit(false);
            
            // Add multiple statements to batch
            statement.setString(1, "Alice Johnson");
            statement.setString(2, "alice.johnson@email.com");
            statement.setInt(3, 22);
            statement.setString(4, "A");
            statement.addBatch();
            
            statement.setString(1, "Bob Wilson");
            statement.setString(2, "bob.wilson@email.com");
            statement.setInt(3, 20);
            statement.setString(4, "B");
            statement.addBatch();
            
            statement.setString(1, "Carol Brown");
            statement.setString(2, "carol.brown@email.com");
            statement.setInt(3, 21);
            statement.setString(4, "A");
            statement.addBatch();
            
            // Execute batch
            int[] results = statement.executeBatch();
            System.out.println("✓ Batch executed with " + results.length + " operations");
            
            // Commit transaction
            connection.commit();
            System.out.println("✓ Transaction committed");
            
        } catch (SQLException e) {
            System.err.println("✗ Error in batch operations: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("7. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use prepared statements to prevent SQL injection");
        System.out.println("✓ Always close resources in finally blocks or try-with-resources");
        System.out.println("✓ Use transactions for multiple related operations");
        System.out.println("✓ Implement proper error handling and logging");
        System.out.println("✓ Use batch operations for multiple inserts/updates");
        System.out.println("✓ Validate input data before database operations");
        System.out.println("✓ Use appropriate data types for database columns");
        System.out.println("✓ Implement connection pooling for better performance");
        System.out.println("✓ Use proper indexing for better query performance");
        System.out.println("✓ Implement proper exception handling");
        System.out.println("✓ Use parameterized queries for security");
        System.out.println("✓ Implement proper transaction management");
        
        System.out.println();
    }
    
    /**
     * Utility method to get all students
     */
    public static List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String selectSQL = "SELECT * FROM students";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(selectSQL);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setAge(resultSet.getInt("age"));
                student.setGrade(resultSet.getString("grade"));
                student.setCreatedAt(resultSet.getTimestamp("created_at"));
                students.add(student);
            }
        }
        
        return students;
    }
    
    /**
     * Student model class
     */
    public static class Student {
        private int id;
        private String name;
        private String email;
        private int age;
        private String grade;
        private Timestamp createdAt;
        
        // Getters and setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
        
        public String getGrade() { return grade; }
        public void setGrade(String grade) { this.grade = grade; }
        
        public Timestamp getCreatedAt() { return createdAt; }
        public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
        
        @Override
        public String toString() {
            return "Student{id=" + id + ", name='" + name + "', email='" + email + 
                   "', age=" + age + ", grade='" + grade + "', createdAt=" + createdAt + "}";
        }
    }
}
