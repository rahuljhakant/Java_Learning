package com.tutorial.testing.testng;

import org.testng.annotations.*;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

/**
 * TestNG Advanced Features - Advanced Testing Capabilities
 * 
 * This comprehensive tutorial demonstrates advanced TestNG features including
 * test groups, parallel execution, dependencies, data providers, and test
 * listeners for complex testing scenarios.
 * 
 * LEARNING OBJECTIVES:
 * - Master advanced TestNG annotations and configurations
 * - Implement test groups and execution control
 * - Use parallel test execution for performance
 * - Create test dependencies and execution order
 * - Apply data providers for parameterized testing
 * - Implement test listeners for custom behavior
 * 
 * KEY CONCEPTS:
 * 1. Test Groups: Organizing and running specific test groups
 * 2. Parallel Execution: Running tests concurrently
 * 3. Test Dependencies: Managing test execution order
 * 4. Data Providers: Parameterized testing with multiple data sets
 * 5. Test Listeners: Custom test execution behavior
 * 6. Configuration Methods: Advanced setup and teardown
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class TestNGAdvanced {
    
    private UserService userService;
    private DatabaseService databaseService;
    
    /**
     * Setup method that runs before all test methods in the class
     */
    @BeforeClass
    public void setUpClass() {
        System.out.println("Setting up test class...");
        userService = new UserService();
        databaseService = new DatabaseService();
    }
    
    /**
     * Teardown method that runs after all test methods in the class
     */
    @AfterClass
    public void tearDownClass() {
        System.out.println("Cleaning up test class...");
        userService = null;
        databaseService = null;
    }
    
    /**
     * Setup method that runs before each test method
     */
    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Setting up test method...");
        databaseService.clearData();
    }
    
    /**
     * Teardown method that runs after each test method
     */
    @AfterMethod
    public void tearDownMethod() {
        System.out.println("Cleaning up test method...");
        databaseService.cleanup();
    }
    
    /**
     * Smoke test group - critical functionality
     */
    @Test(groups = {"smoke", "critical"}, priority = 1, description = "Smoke test for user creation")
    public void testUserCreation() {
        System.out.println("Running smoke test: User creation...");
        
        User user = new User("john.doe", "john@example.com");
        User createdUser = userService.createUser(user);
        
        Assert.assertNotNull(createdUser, "User should be created");
        Assert.assertEquals(createdUser.getUsername(), "john.doe", "Username should match");
        Assert.assertEquals(createdUser.getEmail(), "john@example.com", "Email should match");
        
        System.out.println("Smoke test passed: User created successfully");
    }
    
    /**
     * Regression test group - comprehensive testing
     */
    @Test(groups = {"regression", "user-management"}, priority = 2, description = "Regression test for user operations")
    public void testUserOperations() {
        System.out.println("Running regression test: User operations...");
        
        // Create user
        User user = new User("jane.smith", "jane@example.com");
        User createdUser = userService.createUser(user);
        
        // Update user
        createdUser.setEmail("jane.updated@example.com");
        User updatedUser = userService.updateUser(createdUser);
        
        Assert.assertEquals(updatedUser.getEmail(), "jane.updated@example.com", "Email should be updated");
        
        // Delete user
        boolean deleted = userService.deleteUser(updatedUser.getId());
        Assert.assertTrue(deleted, "User should be deleted");
        
        System.out.println("Regression test passed: All user operations successful");
    }
    
    /**
     * Performance test group - parallel execution
     */
    @Test(groups = {"performance"}, 
          threadPoolSize = 3, 
          invocationCount = 5, 
          description = "Performance test with parallel execution")
    public void testPerformance() {
        System.out.println("Running performance test in thread: " + Thread.currentThread().getName());
        
        long startTime = System.currentTimeMillis();
        
        // Simulate some work
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        
        Assert.assertTrue(executionTime < 200, "Performance test should complete within 200ms");
        System.out.println("Performance test passed: Execution time " + executionTime + "ms");
    }
    
    /**
     * Test with dependencies - depends on user creation
     */
    @Test(dependsOnMethods = {"testUserCreation"}, 
          groups = {"user-management"}, 
          description = "Test user retrieval depends on user creation")
    public void testUserRetrieval() {
        System.out.println("Running dependent test: User retrieval...");
        
        User user = userService.getUserByUsername("john.doe");
        
        Assert.assertNotNull(user, "User should be retrievable");
        Assert.assertEquals(user.getUsername(), "john.doe", "Retrieved user should match");
        
        System.out.println("Dependent test passed: User retrieved successfully");
    }
    
    /**
     * Test with data provider for multiple test cases
     */
    @Test(dataProvider = "userData", 
          groups = {"data-driven"}, 
          description = "Data-driven test for user validation")
    public void testUserValidation(String username, String email, boolean shouldBeValid) {
        System.out.println("Testing user validation: " + username + " - " + email);
        
        User user = new User(username, email);
        boolean isValid = userService.validateUser(user);
        
        Assert.assertEquals(isValid, shouldBeValid, 
            "User validation should be " + shouldBeValid + " for " + username);
        
        System.out.println("Data-driven test passed: " + username + " validation = " + isValid);
    }
    
    /**
     * Data provider for user validation tests
     */
    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object[][] {
            {"valid.user", "valid@example.com", true},
            {"", "invalid@example.com", false},  // Empty username
            {"valid.user", "", false},           // Empty email
            {"valid.user", "invalid-email", false}, // Invalid email format
            {"user@with@special", "valid@example.com", false} // Invalid username
        };
    }
    
    /**
     * Test with timeout
     */
    @Test(timeOut = 1000, 
          groups = {"timeout"}, 
          description = "Test with timeout constraint")
    public void testWithTimeout() {
        System.out.println("Running timeout test...");
        
        // Simulate work that should complete within timeout
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        Assert.assertTrue(true, "Timeout test should complete successfully");
        System.out.println("Timeout test passed");
    }
    
    /**
     * Test with expected exceptions
     */
    @Test(expectedExceptions = IllegalArgumentException.class, 
          groups = {"exception"}, 
          description = "Test that expects exception")
    public void testExpectedException() {
        System.out.println("Running exception test...");
        
        User invalidUser = new User(null, "test@example.com");
        userService.createUser(invalidUser);
        
        System.out.println("Exception test passed: Exception thrown as expected");
    }
    
    /**
     * Test with multiple groups
     */
    @Test(groups = {"smoke", "regression", "critical"}, 
          priority = 3, 
          description = "Test belonging to multiple groups")
    public void testMultipleGroups() {
        System.out.println("Running multi-group test...");
        
        User user = new User("multi.group", "multi@example.com");
        User createdUser = userService.createUser(user);
        
        Assert.assertNotNull(createdUser, "User should be created in multi-group test");
        
        System.out.println("Multi-group test passed");
    }
    
    /**
     * Test with custom parameters
     */
    @Test(parameters = {"test.param"}, 
          groups = {"parameterized"}, 
          description = "Test with custom parameters")
    public void testWithParameters(String param) {
        System.out.println("Running parameterized test with param: " + param);
        
        Assert.assertNotNull(param, "Parameter should not be null");
        Assert.assertTrue(param.length() > 0, "Parameter should not be empty");
        
        System.out.println("Parameterized test passed with param: " + param);
    }
    
    /**
     * Test with invocation count
     */
    @Test(invocationCount = 3, 
          groups = {"repetition"}, 
          description = "Test that runs multiple times")
    public void testWithInvocationCount() {
        System.out.println("Running repetition test...");
        
        int randomValue = (int) (Math.random() * 100);
        Assert.assertTrue(randomValue >= 0 && randomValue < 100, 
            "Random value should be within range");
        
        System.out.println("Repetition test passed with value: " + randomValue);
    }
    
    /**
     * Test with success percentage
     */
    @Test(invocationCount = 10, 
          successPercentage = 80, 
          groups = {"success-rate"}, 
          description = "Test with success percentage requirement")
    public void testWithSuccessPercentage() {
        System.out.println("Running success percentage test...");
        
        // Simulate test that might fail occasionally
        double random = Math.random();
        if (random < 0.2) { // 20% chance of failure
            Assert.fail("Simulated test failure");
        }
        
        Assert.assertTrue(true, "Success percentage test passed");
        System.out.println("Success percentage test passed");
    }
    
    /**
     * Mock classes for testing
     */
    public static class User {
        private String username;
        private String email;
        private Long id;
        
        public User(String username, String email) {
            this.username = username;
            this.email = email;
            this.id = System.currentTimeMillis();
        }
        
        // Getters and setters
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public Long getId() { return id; }
    }
    
    public static class UserService {
        public User createUser(User user) {
            if (user.getUsername() == null || user.getEmail() == null) {
                throw new IllegalArgumentException("Username and email are required");
            }
            return user;
        }
        
        public User updateUser(User user) {
            return user;
        }
        
        public boolean deleteUser(Long id) {
            return true;
        }
        
        public User getUserByUsername(String username) {
            return new User(username, "retrieved@example.com");
        }
        
        public boolean validateUser(User user) {
            return user.getUsername() != null && 
                   !user.getUsername().isEmpty() && 
                   user.getEmail() != null && 
                   !user.getEmail().isEmpty() &&
                   user.getEmail().contains("@");
        }
    }
    
    public static class DatabaseService {
        public void clearData() {
            // Simulate database cleanup
        }
        
        public void cleanup() {
            // Simulate cleanup
        }
    }
}
