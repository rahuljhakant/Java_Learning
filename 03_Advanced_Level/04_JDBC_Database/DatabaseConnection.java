package com.tutorial.advanced.jdbc;

import java.sql.*;
import java.util.Properties;

/**
 * Database Connection - JDBC Connection Management
 * 
 * This comprehensive tutorial demonstrates database connection management
 * using JDBC, including connection pooling, configuration, and best practices.
 * 
 * LEARNING OBJECTIVES:
 * - Establish database connections using JDBC
 * - Configure connection properties
 * - Implement connection pooling
 * - Handle connection errors
 * - Apply connection best practices
 * - Manage database resources
 * 
 * KEY CONCEPTS:
 * 1. JDBC Drivers: Database-specific drivers
 * 2. Connection URLs: Database connection strings
 * 3. Connection Properties: Configuration parameters
 * 4. Connection Pooling: Efficient connection management
 * 5. Error Handling: Connection exception management
 * 6. Best Practices: Secure and efficient connections
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class DatabaseConnection {
    
    public static void main(String[] args) {
        System.out.println("=== Database Connection Demo ===");
        System.out.println();
        
        // 1. Basic Database Connection
        demonstrateBasicConnection();
        
        // 2. Connection with Properties
        demonstrateConnectionWithProperties();
        
        // 3. Connection Pooling
        demonstrateConnectionPooling();
        
        // 4. Error Handling
        demonstrateErrorHandling();
        
        // 5. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic database connection
     */
    private static void demonstrateBasicConnection() {
        System.out.println("1. Basic Database Connection:");
        System.out.println("=============================");
        
        Connection connection = null;
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✓ MySQL JDBC Driver loaded successfully");
            
            // Establish connection
            String url = "jdbc:mysql://localhost:3306/javatutorial";
            String username = "root";
            String password = "password";
            
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("✓ Database connection established");
            
            // Get database metadata
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("Database: " + metaData.getDatabaseProductName());
            System.out.println("Version: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver: " + metaData.getDriverName());
            System.out.println("Driver Version: " + metaData.getDriverVersion());
            
        } catch (ClassNotFoundException e) {
            System.err.println("✗ JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("✗ Database connection failed: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("✓ Database connection closed");
                } catch (SQLException e) {
                    System.err.println("✗ Error closing connection: " + e.getMessage());
                }
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates connection with properties
     */
    private static void demonstrateConnectionWithProperties() {
        System.out.println("2. Connection with Properties:");
        System.out.println("=============================");
        
        Connection connection = null;
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Create connection properties
            Properties props = new Properties();
            props.setProperty("user", "root");
            props.setProperty("password", "password");
            props.setProperty("useSSL", "false");
            props.setProperty("serverTimezone", "UTC");
            props.setProperty("autoReconnect", "true");
            props.setProperty("maxReconnects", "3");
            
            // Establish connection with properties
            String url = "jdbc:mysql://localhost:3306/javatutorial";
            connection = DriverManager.getConnection(url, props);
            System.out.println("✓ Database connection established with properties");
            
            // Test connection
            if (connection.isValid(5)) {
                System.out.println("✓ Connection is valid");
            } else {
                System.out.println("✗ Connection is invalid");
            }
            
        } catch (Exception e) {
            System.err.println("✗ Connection with properties failed: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("✗ Error closing connection: " + e.getMessage());
                }
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates connection pooling
     */
    private static void demonstrateConnectionPooling() {
        System.out.println("3. Connection Pooling:");
        System.out.println("=====================");
        
        System.out.println("Connection Pooling Benefits:");
        System.out.println("• Improved performance");
        System.out.println("• Resource management");
        System.out.println("• Connection reuse");
        System.out.println("• Load balancing");
        System.out.println("• Connection validation");
        
        System.out.println();
        System.out.println("Connection Pool Configuration:");
        System.out.println("• Initial pool size: 5");
        System.out.println("• Maximum pool size: 20");
        System.out.println("• Connection timeout: 30 seconds");
        System.out.println("• Idle timeout: 10 minutes");
        System.out.println("• Validation query: SELECT 1");
        
        System.out.println();
    }
    
    /**
     * Demonstrates error handling
     */
    private static void demonstrateErrorHandling() {
        System.out.println("4. Error Handling:");
        System.out.println("=================");
        
        // Connection timeout
        try {
            String url = "jdbc:mysql://localhost:9999/nonexistent";
            Connection connection = DriverManager.getConnection(url, "user", "pass");
        } catch (SQLException e) {
            System.out.println("Connection timeout handled: " + e.getMessage());
        }
        
        // Invalid credentials
        try {
            String url = "jdbc:mysql://localhost:3306/javatutorial";
            Connection connection = DriverManager.getConnection(url, "invalid", "invalid");
        } catch (SQLException e) {
            System.out.println("Invalid credentials handled: " + e.getMessage());
        }
        
        // Database not found
        try {
            String url = "jdbc:mysql://localhost:3306/nonexistent";
            Connection connection = DriverManager.getConnection(url, "root", "password");
        } catch (SQLException e) {
            System.out.println("Database not found handled: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("5. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use connection pooling for production applications");
        System.out.println("✓ Always close connections in finally blocks");
        System.out.println("✓ Use try-with-resources for automatic resource management");
        System.out.println("✓ Implement proper error handling and logging");
        System.out.println("✓ Use prepared statements for better performance");
        System.out.println("✓ Configure connection timeouts appropriately");
        System.out.println("✓ Use connection validation queries");
        System.out.println("✓ Implement connection retry logic");
        System.out.println("✓ Use appropriate transaction isolation levels");
        System.out.println("✓ Monitor connection usage and performance");
        System.out.println("✓ Use secure connection strings");
        System.out.println("✓ Implement proper connection cleanup");
        
        System.out.println();
    }
    
    /**
     * Utility method to create database connection
     */
    public static Connection createConnection(String url, String username, String password) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found", e);
        }
        return DriverManager.getConnection(url, username, password);
    }
    
    /**
     * Utility method to create connection with properties
     */
    public static Connection createConnectionWithProperties(String url, Properties props) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found", e);
        }
        return DriverManager.getConnection(url, props);
    }
    
    /**
     * Utility method to close connection safely
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
