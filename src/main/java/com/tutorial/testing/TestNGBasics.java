package com.tutorial.testing;

import org.testng.annotations.*;
import org.testng.Assert;

/**
 * TestNG Basics - Introduction to TestNG Framework
 * 
 * This comprehensive tutorial demonstrates the TestNG testing framework,
 * which provides advanced features for Java testing including annotations,
 * test groups, parallel execution, and comprehensive reporting.
 * 
 * LEARNING OBJECTIVES:
 * - Understand TestNG framework and its benefits
 * - Use TestNG annotations effectively
 * - Implement test configuration and setup
 * - Apply assertions and validations
 * - Organize tests with groups and priorities
 * - Generate test reports
 * 
 * KEY CONCEPTS:
 * 1. TestNG Annotations: @Test, @BeforeMethod, @AfterMethod, etc.
 * 2. Test Configuration: Setup and teardown methods
 * 3. Assertions: Validating test results
 * 4. Test Groups: Organizing and running specific tests
 * 5. Test Reports: Generating comprehensive test reports
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class TestNGBasics {
    
    private Calculator calculator;
    
    /**
     * Setup method that runs before each test method
     */
    @BeforeMethod
    public void setUp() {
        System.out.println("Setting up test environment...");
        calculator = new Calculator();
    }
    
    /**
     * Teardown method that runs after each test method
     */
    @AfterMethod
    public void tearDown() {
        System.out.println("Cleaning up test environment...");
        calculator = null;
    }
    
    /**
     * Basic test method demonstrating TestNG annotations
     */
    @Test(description = "Test addition operation")
    public void testAddition() {
        System.out.println("Testing addition operation...");
        
        // Test data
        int a = 5;
        int b = 3;
        int expected = 8;
        
        // Execute
        int result = calculator.add(a, b);
        
        // Assert
        Assert.assertEquals(result, expected, "Addition result should be " + expected);
        System.out.println("Addition test passed: " + a + " + " + b + " = " + result);
    }
    
    /**
     * Test method with priority
     */
    @Test(priority = 1, description = "Test subtraction operation")
    public void testSubtraction() {
        System.out.println("Testing subtraction operation...");
        
        int a = 10;
        int b = 4;
        int expected = 6;
        
        int result = calculator.subtract(a, b);
        
        Assert.assertEquals(result, expected, "Subtraction result should be " + expected);
        System.out.println("Subtraction test passed: " + a + " - " + b + " = " + result);
    }
    
    /**
     * Test method with groups
     */
    @Test(groups = {"smoke", "arithmetic"}, description = "Test multiplication operation")
    public void testMultiplication() {
        System.out.println("Testing multiplication operation...");
        
        int a = 6;
        int b = 7;
        int expected = 42;
        
        int result = calculator.multiply(a, b);
        
        Assert.assertEquals(result, expected, "Multiplication result should be " + expected);
        System.out.println("Multiplication test passed: " + a + " * " + b + " = " + result);
    }
    
    /**
     * Test method for division operation
     */
    @Test(groups = {"arithmetic"}, description = "Test division operation")
    public void testDivision() {
        System.out.println("Testing division operation...");
        
        int a = 15;
        int b = 3;
        int expected = 5;
        
        int result = calculator.divide(a, b);
        
        Assert.assertEquals(result, expected, "Division result should be " + expected);
        System.out.println("Division test passed: " + a + " / " + b + " = " + result);
    }
    
    /**
     * Test method for division by zero
     */
    @Test(expectedExceptions = ArithmeticException.class, 
          description = "Test division by zero throws exception")
    public void testDivisionByZero() {
        System.out.println("Testing division by zero...");
        
        int a = 10;
        int b = 0;
        
        calculator.divide(a, b);
        
        System.out.println("Division by zero test passed - exception thrown as expected");
    }
    
    /**
     * Test method with timeout
     */
    @Test(timeOut = 1000, description = "Test method execution time")
    public void testPerformance() {
        System.out.println("Testing performance...");
        
        // Simulate some work
        try {
            Thread.sleep(500); // Should complete within timeout
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        Assert.assertTrue(true, "Performance test completed within timeout");
        System.out.println("Performance test passed");
    }
    
    /**
     * Test method with multiple assertions
     */
    @Test(description = "Test multiple operations")
    public void testMultipleOperations() {
        System.out.println("Testing multiple operations...");
        
        int a = 10;
        int b = 5;
        
        // Test multiple operations
        Assert.assertEquals(calculator.add(a, b), 15, "Addition failed");
        Assert.assertEquals(calculator.subtract(a, b), 5, "Subtraction failed");
        Assert.assertEquals(calculator.multiply(a, b), 50, "Multiplication failed");
        Assert.assertEquals(calculator.divide(a, b), 2, "Division failed");
        
        System.out.println("Multiple operations test passed");
    }
    
    /**
     * Test method with data provider
     */
    @Test(dataProvider = "additionData", description = "Test addition with multiple data sets")
    public void testAdditionWithDataProvider(int a, int b, int expected) {
        System.out.println("Testing addition with data: " + a + " + " + b + " = " + expected);
        
        int result = calculator.add(a, b);
        
        Assert.assertEquals(result, expected, "Addition with data provider failed");
        System.out.println("Data provider test passed: " + a + " + " + b + " = " + result);
    }
    
    /**
     * Data provider for test data
     */
    @DataProvider(name = "additionData")
    public Object[][] additionData() {
        return new Object[][] {
            {1, 2, 3},
            {5, 5, 10},
            {10, 20, 30},
            {100, 200, 300}
        };
    }
    
    /**
     * Test method with enabled/disabled
     */
    @Test(enabled = false, description = "Disabled test method")
    public void testDisabled() {
        System.out.println("This test is disabled");
        Assert.fail("This test should not run");
    }
    
    /**
     * Test method with depends on
     */
    @Test(dependsOnMethods = {"testAddition"}, description = "Test that depends on addition")
    public void testDependsOnAddition() {
        System.out.println("Testing method that depends on addition...");
        
        // This test will only run if testAddition passes
        Assert.assertTrue(calculator != null, "Calculator should be initialized");
        System.out.println("Dependent test passed");
    }
    
    /**
     * Simple Calculator class for testing
     */
    public static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }
        
        public int subtract(int a, int b) {
            return a - b;
        }
        
        public int multiply(int a, int b) {
            return a * b;
        }
        
        public int divide(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        }
    }
}
