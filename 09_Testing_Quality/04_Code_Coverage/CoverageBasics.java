package com.tutorial.testing.coverage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Code Coverage Basics - Understanding Coverage Metrics
 * 
 * This comprehensive tutorial demonstrates code coverage concepts and metrics
 * in Java testing. Code coverage measures how much of your code is executed
 * during testing, helping you identify untested code and improve test quality.
 * 
 * LEARNING OBJECTIVES:
 * - Understand different types of code coverage
 * - Learn about coverage metrics and their importance
 * - Implement tests to achieve high coverage
 * - Use coverage tools effectively
 * - Set coverage goals and thresholds
 * - Interpret coverage reports
 * 
 * KEY CONCEPTS:
 * 1. Line Coverage: Percentage of lines executed during testing
 * 2. Branch Coverage: Percentage of branches tested
 * 3. Method Coverage: Percentage of methods called
 * 4. Class Coverage: Percentage of classes instantiated
 * 5. Coverage Goals: Setting and achieving coverage targets
 * 6. Coverage Tools: Using JaCoCo and other coverage tools
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class CoverageBasics {
    
    private Calculator calculator;
    private UserService userService;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        userService = new UserService();
    }
    
    /**
     * Test basic arithmetic operations for line coverage
     */
    @Test
    void testBasicArithmetic() {
        // Test addition - covers add method
        assertEquals(5, calculator.add(2, 3), "Addition should work correctly");
        
        // Test subtraction - covers subtract method
        assertEquals(1, calculator.subtract(3, 2), "Subtraction should work correctly");
        
        // Test multiplication - covers multiply method
        assertEquals(6, calculator.multiply(2, 3), "Multiplication should work correctly");
        
        // Test division - covers divide method
        assertEquals(2, calculator.divide(6, 3), "Division should work correctly");
    }
    
    /**
     * Test edge cases for branch coverage
     */
    @Test
    void testEdgeCases() {
        // Test division by zero - covers exception branch
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        }, "Division by zero should throw exception");
        
        // Test negative numbers - covers negative number branches
        assertEquals(-1, calculator.add(-2, 1), "Negative addition should work");
        assertEquals(-3, calculator.subtract(-2, 1), "Negative subtraction should work");
        
        // Test zero operations - covers zero branches
        assertEquals(5, calculator.add(5, 0), "Adding zero should work");
        assertEquals(5, calculator.subtract(5, 0), "Subtracting zero should work");
    }
    
    /**
     * Test user service for method coverage
     */
    @Test
    void testUserService() {
        // Test user creation - covers createUser method
        User user = new User("john.doe", "john@example.com");
        User createdUser = userService.createUser(user);
        
        assertNotNull(createdUser, "User should be created");
        assertEquals("john.doe", createdUser.getUsername(), "Username should match");
        assertEquals("john@example.com", createdUser.getEmail(), "Email should match");
        
        // Test user validation - covers validateUser method
        assertTrue(userService.validateUser(createdUser), "Valid user should pass validation");
        
        // Test invalid user - covers validation failure branch
        User invalidUser = new User("", "invalid-email");
        assertFalse(userService.validateUser(invalidUser), "Invalid user should fail validation");
    }
    
    /**
     * Test complex logic for comprehensive coverage
     */
    @Test
    void testComplexLogic() {
        // Test calculator with complex operations
        int result1 = calculator.add(calculator.multiply(2, 3), calculator.divide(6, 2));
        assertEquals(9, result1, "Complex calculation should work");
        
        // Test user service with multiple operations
        User user1 = new User("user1", "user1@example.com");
        User user2 = new User("user2", "user2@example.com");
        
        User created1 = userService.createUser(user1);
        User created2 = userService.createUser(user2);
        
        assertNotNull(created1, "First user should be created");
        assertNotNull(created2, "Second user should be created");
        
        // Test user retrieval - covers getUserById method
        User retrieved = userService.getUserById(created1.getId());
        assertNotNull(retrieved, "User should be retrievable");
        assertEquals(created1.getUsername(), retrieved.getUsername(), "Retrieved user should match");
    }
    
    /**
     * Test error handling for exception coverage
     */
    @Test
    void testErrorHandling() {
        // Test calculator error handling
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        }, "Division by zero should throw exception");
        
        // Test user service error handling
        assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(null);
        }, "Creating null user should throw exception");
        
        assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(new User("", ""));
        }, "Creating user with empty data should throw exception");
    }
    
    /**
     * Test boundary conditions for edge case coverage
     */
    @Test
    void testBoundaryConditions() {
        // Test with maximum integer values
        assertEquals(Integer.MAX_VALUE, calculator.add(Integer.MAX_VALUE, 0), 
            "Adding zero to max value should work");
        
        // Test with minimum integer values
        assertEquals(Integer.MIN_VALUE, calculator.add(Integer.MIN_VALUE, 0), 
            "Adding zero to min value should work");
        
        // Test with very large numbers
        long largeResult = calculator.multiply(1000000, 1000000);
        assertTrue(largeResult > 0, "Large number multiplication should work");
    }
    
    /**
     * Test all methods for complete method coverage
     */
    @Test
    void testAllMethods() {
        // Ensure all calculator methods are called
        calculator.add(1, 1);
        calculator.subtract(1, 1);
        calculator.multiply(1, 1);
        calculator.divide(1, 1);
        calculator.getHistory();
        calculator.clearHistory();
        
        // Ensure all user service methods are called
        User user = new User("test", "test@example.com");
        userService.createUser(user);
        userService.validateUser(user);
        userService.getUserById(1L);
        userService.getAllUsers();
        userService.deleteUser(1L);
    }
    
    /**
     * Calculator class for coverage testing
     */
    public static class Calculator {
        private java.util.List<String> history = new java.util.ArrayList<>();
        
        public int add(int a, int b) {
            int result = a + b;
            history.add(a + " + " + b + " = " + result);
            return result;
        }
        
        public int subtract(int a, int b) {
            int result = a - b;
            history.add(a + " - " + b + " = " + result);
            return result;
        }
        
        public int multiply(int a, int b) {
            int result = a * b;
            history.add(a + " * " + b + " = " + result);
            return result;
        }
        
        public int divide(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            int result = a / b;
            history.add(a + " / " + b + " = " + result);
            return result;
        }
        
        public java.util.List<String> getHistory() {
            return new java.util.ArrayList<>(history);
        }
        
        public void clearHistory() {
            history.clear();
        }
    }
    
    /**
     * User class for coverage testing
     */
    public static class User {
        private Long id;
        private String username;
        private String email;
        
        public User(String username, String email) {
            this.id = System.currentTimeMillis();
            this.username = username;
            this.email = email;
        }
        
        // Getters and setters
        public Long getId() { return id; }
        public String getUsername() { return username; }
        public String getEmail() { return email; }
        public void setUsername(String username) { this.username = username; }
        public void setEmail(String email) { this.email = email; }
    }
    
    /**
     * UserService class for coverage testing
     */
    public static class UserService {
        private java.util.List<User> users = new java.util.ArrayList<>();
        private Long nextId = 1L;
        
        public User createUser(User user) {
            if (user == null) {
                throw new IllegalArgumentException("User cannot be null");
            }
            if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
                throw new IllegalArgumentException("Username cannot be empty");
            }
            if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
                throw new IllegalArgumentException("Email cannot be empty");
            }
            
            user.id = nextId++;
            users.add(user);
            return user;
        }
        
        public boolean validateUser(User user) {
            if (user == null) return false;
            if (user.getUsername() == null || user.getUsername().trim().isEmpty()) return false;
            if (user.getEmail() == null || user.getEmail().trim().isEmpty()) return false;
            if (!user.getEmail().contains("@")) return false;
            return true;
        }
        
        public User getUserById(Long id) {
            return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
        }
        
        public java.util.List<User> getAllUsers() {
            return new java.util.ArrayList<>(users);
        }
        
        public boolean deleteUser(Long id) {
            return users.removeIf(user -> user.getId().equals(id));
        }
    }
}
