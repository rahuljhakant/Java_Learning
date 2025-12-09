package com.tutorial.advanced;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC Basics - Java Database Connectivity Fundamentals
 * 
 * This comprehensive tutorial demonstrates the fundamentals of Java Database
 * Connectivity (JDBC), including database connections, SQL operations, and
 * best practices for database programming in Java.
 * 
 * LEARNING OBJECTIVES:
 * - Understand JDBC architecture and components
 * - Establish database connections using JDBC
 * - Execute SQL statements and queries
 * - Handle ResultSets and database results
 * - Use PreparedStatements for parameterized queries
 * - Implement proper connection management and error handling
 * 
 * KEY CONCEPTS:
 * 1. JDBC Drivers: Database-specific drivers for connectivity
 * 2. Connection Management: Establishing and managing database connections
 * 3. SQL Operations: SELECT, INSERT, UPDATE, DELETE operations
 * 4. PreparedStatements: Parameterized queries for security and performance
 * 5. ResultSet Handling: Processing query results
 * 6. Exception Handling: SQLException and database error handling
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class JDBCBasics {
    
    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/javatutorial";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";
    
    public static void main(String[] args) {
        System.out.println("=== JDBC Basics Demo ===");
        System.out.println();
        
        // 1. Basic Database Connection
        demonstrateBasicConnection();
        
        // 2. Simple Query Execution
        demonstrateSimpleQuery();
        
        // 3. PreparedStatement Usage
        demonstratePreparedStatement();
        
        // 4. CRUD Operations
        demonstrateCRUDOperations();
        
        // 5. Transaction Management
        demonstrateTransactionManagement();
        
        // 6. Best Practices
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
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
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
            // Close connection
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
     * Demonstrates simple query execution
     */
    private static void demonstrateSimpleQuery() {
        System.out.println("2. Simple Query Execution:");
        System.out.println("==========================");
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            statement = connection.createStatement();
            
            // Execute a simple query
            String query = "SELECT 1 as test_value, 'Hello JDBC' as message";
            resultSet = statement.executeQuery(query);
            
            System.out.println("Query executed: " + query);
            
            // Process results
            while (resultSet.next()) {
                int testValue = resultSet.getInt("test_value");
                String message = resultSet.getString("message");
                System.out.println("Result: " + testValue + " - " + message);
            }
            
        } catch (SQLException e) {
            System.err.println("✗ Query execution failed: " + e.getMessage());
        } finally {
            closeResources(connection, statement, resultSet);
        }
        System.out.println();
    }
    
    /**
     * Demonstrates PreparedStatement usage
     */
    private static void demonstratePreparedStatement() {
        System.out.println("3. PreparedStatement Usage:");
        System.out.println("===========================");
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            
            // Create a sample table for demonstration
            createSampleTable(connection);
            
            // Insert data using PreparedStatement
            String insertQuery = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            
            // Insert multiple records
            String[][] userData = {
                {"John Doe", "john@example.com", "25"},
                {"Jane Smith", "jane@example.com", "30"},
                {"Bob Johnson", "bob@example.com", "35"}
            };
            
            for (String[] user : userData) {
                preparedStatement.setString(1, user[0]);
                preparedStatement.setString(2, user[1]);
                preparedStatement.setInt(3, Integer.parseInt(user[2]));
                preparedStatement.executeUpdate();
            }
            
            System.out.println("✓ Inserted " + userData.length + " users using PreparedStatement");
            
            // Query data using PreparedStatement
            String selectQuery = "SELECT * FROM users WHERE age > ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, 25);
            resultSet = preparedStatement.executeQuery();
            
            System.out.println("Users older than 25:");
            while (resultSet.next()) {
                System.out.println("  ID: " + resultSet.getInt("id") +
                                 ", Name: " + resultSet.getString("name") +
                                 ", Email: " + resultSet.getString("email") +
                                 ", Age: " + resultSet.getInt("age"));
            }
            
        } catch (SQLException e) {
            System.err.println("✗ PreparedStatement operation failed: " + e.getMessage());
        } finally {
            closeResources(connection, preparedStatement, resultSet);
        }
        System.out.println();
    }
    
    /**
     * Demonstrates CRUD operations
     */
    private static void demonstrateCRUDOperations() {
        System.out.println("4. CRUD Operations:");
        System.out.println("==================");
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            
            // CREATE - Insert a new user
            String insertQuery = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, "Alice Brown");
            preparedStatement.setString(2, "alice@example.com");
            preparedStatement.setInt(3, 28);
            
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("✓ CREATE: Inserted " + rowsAffected + " user");
            
            // Get the generated ID
            resultSet = preparedStatement.getGeneratedKeys();
            int newUserId = 0;
            if (resultSet.next()) {
                newUserId = resultSet.getInt(1);
                System.out.println("  Generated ID: " + newUserId);
            }
            
            // READ - Select all users
            String selectQuery = "SELECT * FROM users ORDER BY id";
            preparedStatement = connection.prepareStatement(selectQuery);
            resultSet = preparedStatement.executeQuery();
            
            System.out.println("✓ READ: All users:");
            while (resultSet.next()) {
                System.out.println("  ID: " + resultSet.getInt("id") +
                                 ", Name: " + resultSet.getString("name") +
                                 ", Email: " + resultSet.getString("email") +
                                 ", Age: " + resultSet.getInt("age"));
            }
            
            // UPDATE - Update user information
            String updateQuery = "UPDATE users SET age = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, 29);
            preparedStatement.setInt(2, newUserId);
            
            rowsAffected = preparedStatement.executeUpdate();
            System.out.println("✓ UPDATE: Updated " + rowsAffected + " user");
            
            // DELETE - Delete a user
            String deleteQuery = "DELETE FROM users WHERE id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, newUserId);
            
            rowsAffected = preparedStatement.executeUpdate();
            System.out.println("✓ DELETE: Deleted " + rowsAffected + " user");
            
        } catch (SQLException e) {
            System.err.println("✗ CRUD operation failed: " + e.getMessage());
        } finally {
            closeResources(connection, preparedStatement, resultSet);
        }
        System.out.println();
    }
    
    /**
     * Demonstrates transaction management
     */
    private static void demonstrateTransactionManagement() {
        System.out.println("5. Transaction Management:");
        System.out.println("=========================");
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = getConnection();
            
            // Disable auto-commit to start a transaction
            connection.setAutoCommit(false);
            System.out.println("✓ Transaction started (auto-commit disabled)");
            
            // Perform multiple operations in a transaction
            String insertQuery = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            
            // Insert first user
            preparedStatement.setString(1, "Transaction User 1");
            preparedStatement.setString(2, "trans1@example.com");
            preparedStatement.setInt(3, 25);
            preparedStatement.executeUpdate();
            System.out.println("✓ Inserted first user");
            
            // Insert second user
            preparedStatement.setString(1, "Transaction User 2");
            preparedStatement.setString(2, "trans2@example.com");
            preparedStatement.setInt(3, 30);
            preparedStatement.executeUpdate();
            System.out.println("✓ Inserted second user");
            
            // Simulate a condition to decide whether to commit or rollback
            boolean shouldCommit = true; // Change this to false to test rollback
            
            if (shouldCommit) {
                connection.commit();
                System.out.println("✓ Transaction committed successfully");
            } else {
                connection.rollback();
                System.out.println("✓ Transaction rolled back");
            }
            
        } catch (SQLException e) {
            System.err.println("✗ Transaction failed: " + e.getMessage());
            try {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("✓ Transaction rolled back due to error");
                }
            } catch (SQLException rollbackException) {
                System.err.println("✗ Rollback failed: " + rollbackException.getMessage());
            }
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true); // Re-enable auto-commit
                }
            } catch (SQLException e) {
                System.err.println("✗ Error re-enabling auto-commit: " + e.getMessage());
            }
            closeResources(connection, preparedStatement, null);
        }
        System.out.println();
    }
    
    /**
     * Demonstrates JDBC best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("6. JDBC Best Practices:");
        System.out.println("======================");
        
        System.out.println("✓ Always use PreparedStatement for parameterized queries");
        System.out.println("✓ Close resources in finally blocks or use try-with-resources");
        System.out.println("✓ Use connection pooling for production applications");
        System.out.println("✓ Handle SQLException appropriately");
        System.out.println("✓ Use transactions for multiple related operations");
        System.out.println("✓ Validate input data before database operations");
        System.out.println("✓ Use appropriate data types for database columns");
        System.out.println("✓ Implement proper error logging and monitoring");
        System.out.println("✓ Use batch operations for multiple inserts/updates");
        System.out.println("✓ Consider using ORM frameworks for complex applications");
        
        System.out.println();
    }
    
    /**
     * Helper method to get database connection
     */
    private static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found", e);
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    
    /**
     * Helper method to close database resources
     */
    private static void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            System.err.println("Error closing resources: " + e.getMessage());
        }
    }
    
    /**
     * Helper method to create a sample table for demonstration
     */
    private static void createSampleTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        
        // Drop table if exists
        try {
            statement.executeUpdate("DROP TABLE IF EXISTS users");
        } catch (SQLException e) {
            // Ignore if table doesn't exist
        }
        
        // Create table
        String createTableQuery = """
            CREATE TABLE users (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                email VARCHAR(100) UNIQUE NOT NULL,
                age INT NOT NULL,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            )
            """;
        
        statement.executeUpdate(createTableQuery);
        System.out.println("✓ Sample table 'users' created");
        
        statement.close();
    }
}
