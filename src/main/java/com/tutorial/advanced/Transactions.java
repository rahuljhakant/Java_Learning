package com.tutorial.advanced;

import java.sql.*;
import java.util.Properties;

/**
 * Transactions - Database Transaction Management
 * 
 * This comprehensive tutorial demonstrates database transaction management
 * using JDBC, including ACID properties, isolation levels, and rollback.
 * 
 * LEARNING OBJECTIVES:
 * - Understand database transaction concepts
 * - Implement transaction management
 * - Handle transaction isolation levels
 * - Perform rollback operations
 * - Apply transaction best practices
 * - Build reliable database applications
 * 
 * KEY CONCEPTS:
 * 1. ACID Properties: Atomicity, Consistency, Isolation, Durability
 * 2. Transaction Isolation: Read committed, repeatable read, serializable
 * 3. Commit/Rollback: Transaction completion and cancellation
 * 4. Savepoints: Partial transaction rollback
 * 5. Deadlock Prevention: Avoiding transaction conflicts
 * 6. Best Practices: Reliable transaction management
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class Transactions {
    
    private static final String URL = "jdbc:mysql://localhost:3306/javatutorial";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    
    public static void main(String[] args) {
        System.out.println("=== Transactions Demo ===");
        System.out.println();
        
        // 1. Basic Transaction Management
        demonstrateBasicTransaction();
        
        // 2. Transaction with Rollback
        demonstrateTransactionRollback();
        
        // 3. Savepoints
        demonstrateSavepoints();
        
        // 4. Isolation Levels
        demonstrateIsolationLevels();
        
        // 5. Deadlock Prevention
        demonstrateDeadlockPrevention();
        
        // 6. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic transaction management
     */
    private static void demonstrateBasicTransaction() {
        System.out.println("1. Basic Transaction Management:");
        System.out.println("===============================");
        
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            // Disable auto-commit
            connection.setAutoCommit(false);
            System.out.println("✓ Auto-commit disabled");
            
            // Perform multiple operations
            String insertSQL1 = "INSERT INTO students (name, email, age, grade) VALUES (?, ?, ?, ?)";
            String insertSQL2 = "INSERT INTO students (name, email, age, grade) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement stmt1 = connection.prepareStatement(insertSQL1);
                 PreparedStatement stmt2 = connection.prepareStatement(insertSQL2)) {
                
                // First insert
                stmt1.setString(1, "Transaction Student 1");
                stmt1.setString(2, "trans1@email.com");
                stmt1.setInt(3, 20);
                stmt1.setString(4, "A");
                stmt1.executeUpdate();
                System.out.println("✓ First insert completed");
                
                // Second insert
                stmt2.setString(1, "Transaction Student 2");
                stmt2.setString(2, "trans2@email.com");
                stmt2.setInt(3, 21);
                stmt2.setString(4, "B");
                stmt2.executeUpdate();
                System.out.println("✓ Second insert completed");
                
                // Commit transaction
                connection.commit();
                System.out.println("✓ Transaction committed successfully");
                
            }
            
        } catch (SQLException e) {
            System.err.println("✗ Transaction failed: " + e.getMessage());
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("✓ Transaction rolled back");
                } catch (SQLException rollbackException) {
                    System.err.println("✗ Rollback failed: " + rollbackException.getMessage());
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("✗ Error closing connection: " + e.getMessage());
                }
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates transaction with rollback
     */
    private static void demonstrateTransactionRollback() {
        System.out.println("2. Transaction with Rollback:");
        System.out.println("============================");
        
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
            
            String insertSQL = "INSERT INTO students (name, email, age, grade) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement statement = connection.prepareStatement(insertSQL)) {
                
                // Insert first student
                statement.setString(1, "Rollback Student 1");
                statement.setString(2, "rollback1@email.com");
                statement.setInt(3, 20);
                statement.setString(4, "A");
                statement.executeUpdate();
                System.out.println("✓ First insert completed");
                
                // Insert second student with duplicate email (will cause error)
                statement.setString(1, "Rollback Student 2");
                statement.setString(2, "rollback1@email.com"); // Duplicate email
                statement.setInt(3, 21);
                statement.setString(4, "B");
                statement.executeUpdate();
                System.out.println("✓ Second insert completed");
                
                // This should not reach here due to duplicate email
                connection.commit();
                
            }
            
        } catch (SQLException e) {
            System.err.println("✗ Transaction failed (expected): " + e.getMessage());
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("✓ Transaction rolled back successfully");
                } catch (SQLException rollbackException) {
                    System.err.println("✗ Rollback failed: " + rollbackException.getMessage());
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("✗ Error closing connection: " + e.getMessage());
                }
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates savepoints
     */
    private static void demonstrateSavepoints() {
        System.out.println("3. Savepoints:");
        System.out.println("=============");
        
        Connection connection = null;
        Savepoint savepoint = null;
        
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
            
            String insertSQL = "INSERT INTO students (name, email, age, grade) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement statement = connection.prepareStatement(insertSQL)) {
                
                // Insert first student
                statement.setString(1, "Savepoint Student 1");
                statement.setString(2, "savepoint1@email.com");
                statement.setInt(3, 20);
                statement.setString(4, "A");
                statement.executeUpdate();
                System.out.println("✓ First insert completed");
                
                // Create savepoint
                savepoint = connection.setSavepoint("after_first_insert");
                System.out.println("✓ Savepoint created");
                
                // Insert second student
                statement.setString(1, "Savepoint Student 2");
                statement.setString(2, "savepoint2@email.com");
                statement.setInt(3, 21);
                statement.setString(4, "B");
                statement.executeUpdate();
                System.out.println("✓ Second insert completed");
                
                // Insert third student with duplicate email
                statement.setString(1, "Savepoint Student 3");
                statement.setString(2, "savepoint1@email.com"); // Duplicate email
                statement.setInt(3, 22);
                statement.setString(4, "C");
                statement.executeUpdate();
                System.out.println("✓ Third insert completed");
                
                // This should not reach here
                connection.commit();
                
            }
            
        } catch (SQLException e) {
            System.err.println("✗ Transaction failed (expected): " + e.getMessage());
            if (connection != null && savepoint != null) {
                try {
                    connection.rollback(savepoint);
                    System.out.println("✓ Rolled back to savepoint");
                    
                    // Commit the first insert
                    connection.commit();
                    System.out.println("✓ Committed up to savepoint");
                    
                } catch (SQLException rollbackException) {
                    System.err.println("✗ Rollback to savepoint failed: " + rollbackException.getMessage());
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("✗ Error closing connection: " + e.getMessage());
                }
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates isolation levels
     */
    private static void demonstrateIsolationLevels() {
        System.out.println("4. Isolation Levels:");
        System.out.println("===================");
        
        System.out.println("Transaction Isolation Levels:");
        System.out.println("• READ_UNCOMMITTED: Can read uncommitted changes");
        System.out.println("• READ_COMMITTED: Can only read committed changes");
        System.out.println("• REPEATABLE_READ: Consistent reads within transaction");
        System.out.println("• SERIALIZABLE: Highest isolation level");
        
        System.out.println();
        System.out.println("Setting Isolation Level:");
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            
            // Get current isolation level
            int currentLevel = connection.getTransactionIsolation();
            System.out.println("Current isolation level: " + getIsolationLevelName(currentLevel));
            
            // Set different isolation levels
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            System.out.println("✓ Set to READ_COMMITTED");
            
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            System.out.println("✓ Set to REPEATABLE_READ");
            
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            System.out.println("✓ Set to SERIALIZABLE");
            
        } catch (SQLException e) {
            System.err.println("✗ Error setting isolation level: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates deadlock prevention
     */
    private static void demonstrateDeadlockPrevention() {
        System.out.println("5. Deadlock Prevention:");
        System.out.println("======================");
        
        System.out.println("Deadlock Prevention Strategies:");
        System.out.println("• Always acquire locks in the same order");
        System.out.println("• Use timeouts for lock acquisition");
        System.out.println("• Implement retry logic with exponential backoff");
        System.out.println("• Use appropriate isolation levels");
        System.out.println("• Minimize transaction duration");
        System.out.println("• Avoid long-running transactions");
        System.out.println("• Use row-level locking when possible");
        System.out.println("• Implement proper error handling");
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("6. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Always disable auto-commit for transactions");
        System.out.println("✓ Use try-with-resources for automatic resource management");
        System.out.println("✓ Implement proper error handling and rollback");
        System.out.println("✓ Use appropriate isolation levels");
        System.out.println("✓ Keep transactions as short as possible");
        System.out.println("✓ Use savepoints for complex transactions");
        System.out.println("✓ Implement retry logic for deadlock situations");
        System.out.println("✓ Use connection pooling for better performance");
        System.out.println("✓ Monitor transaction performance and deadlocks");
        System.out.println("✓ Implement proper logging for transaction operations");
        System.out.println("✓ Use batch operations for multiple related operations");
        System.out.println("✓ Validate data before starting transactions");
        
        System.out.println();
    }
    
    /**
     * Utility method to get isolation level name
     */
    private static String getIsolationLevelName(int level) {
        switch (level) {
            case Connection.TRANSACTION_READ_UNCOMMITTED:
                return "READ_UNCOMMITTED";
            case Connection.TRANSACTION_READ_COMMITTED:
                return "READ_COMMITTED";
            case Connection.TRANSACTION_REPEATABLE_READ:
                return "REPEATABLE_READ";
            case Connection.TRANSACTION_SERIALIZABLE:
                return "SERIALIZABLE";
            default:
                return "UNKNOWN";
        }
    }
    
    /**
     * Utility method to execute transaction with retry logic
     */
    public static void executeTransactionWithRetry(TransactionOperation operation, int maxRetries) {
        int retryCount = 0;
        while (retryCount < maxRetries) {
            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                connection.setAutoCommit(false);
                operation.execute(connection);
                connection.commit();
                return; // Success
            } catch (SQLException e) {
                retryCount++;
                if (retryCount >= maxRetries) {
                    System.err.println("✗ Transaction failed after " + maxRetries + " retries: " + e.getMessage());
                    throw new RuntimeException("Transaction failed", e);
                }
                System.out.println("✗ Transaction failed, retrying (" + retryCount + "/" + maxRetries + "): " + e.getMessage());
                try {
                    Thread.sleep(1000 * retryCount); // Exponential backoff
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Transaction interrupted", ie);
                }
            }
        }
    }
    
    /**
     * Functional interface for transaction operations
     */
    @FunctionalInterface
    public interface TransactionOperation {
        void execute(Connection connection) throws SQLException;
    }
}
