package com.tutorial.advanced;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit Testing - Unit Testing Framework
 * 
 * This comprehensive tutorial demonstrates JUnit 5 testing framework,
 * including test annotations, assertions, parameterized tests,
 * and testing best practices.
 * 
 * LEARNING OBJECTIVES:
 * - Understand JUnit testing concepts
 * - Write effective unit tests
 * - Use JUnit annotations and assertions
 * - Implement parameterized tests
 * - Apply testing best practices
 * - Build testable applications
 * 
 * KEY CONCEPTS:
 * 1. Test Annotations: @Test, @BeforeEach, @AfterEach, etc.
 * 2. Assertions: assertEquals, assertTrue, assertThrows, etc.
 * 3. Parameterized Tests: @ParameterizedTest with various sources
 * 4. Test Lifecycle: Setup, execution, teardown
 * 5. Test Organization: Test classes and methods
 * 6. Best Practices: Effective testing strategies
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class JUnitTesting {
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setting up test environment");
    }
    
    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("Cleaning up test environment");
    }
    
    @Test
    @DisplayName("Test addition of two positive numbers")
    void testAddition() {
        // Arrange
        int a = 5;
        int b = 3;
        int expected = 8;
        
        // Act
        int result = calculator.add(a, b);
        
        // Assert
        assertEquals(expected, result, "Addition should return correct sum");
    }
    
    @Test
    @DisplayName("Test subtraction of two numbers")
    void testSubtraction() {
        // Arrange
        int a = 10;
        int b = 3;
        int expected = 7;
        
        // Act
        int result = calculator.subtract(a, b);
        
        // Assert
        assertEquals(expected, result, "Subtraction should return correct difference");
    }
    
    @Test
    @DisplayName("Test multiplication of two numbers")
    void testMultiplication() {
        // Arrange
        int a = 4;
        int b = 5;
        int expected = 20;
        
        // Act
        int result = calculator.multiply(a, b);
        
        // Assert
        assertEquals(expected, result, "Multiplication should return correct product");
    }
    
    @Test
    @DisplayName("Test division of two numbers")
    void testDivision() {
        // Arrange
        int a = 15;
        int b = 3;
        int expected = 5;
        
        // Act
        int result = calculator.divide(a, b);
        
        // Assert
        assertEquals(expected, result, "Division should return correct quotient");
    }
    
    @Test
    @DisplayName("Test division by zero throws exception")
    void testDivisionByZero() {
        // Arrange
        int a = 10;
        int b = 0;
        
        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(a, b),
            "Division by zero should throw IllegalArgumentException"
        );
        
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
    
    @Test
    @DisplayName("Test square root of positive number")
    void testSquareRoot() {
        // Arrange
        double a = 16.0;
        double expected = 4.0;
        
        // Act
        double result = calculator.squareRoot(a);
        
        // Assert
        assertEquals(expected, result, 0.001, "Square root should return correct value");
    }
    
    @Test
    @DisplayName("Test square root of negative number throws exception")
    void testSquareRootOfNegativeNumber() {
        // Arrange
        double a = -4.0;
        
        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.squareRoot(a),
            "Square root of negative number should throw IllegalArgumentException"
        );
        
        assertEquals("Cannot calculate square root of negative number", exception.getMessage());
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Test factorial of positive numbers")
    void testFactorial(int n) {
        // Act
        long result = calculator.factorial(n);
        
        // Assert
        assertTrue(result > 0, "Factorial should be positive");
        assertTrue(result >= n, "Factorial should be greater than or equal to input");
    }
    
    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "2, 2",
        "3, 6",
        "4, 24",
        "5, 120"
    })
    @DisplayName("Test factorial with specific values")
    void testFactorialWithValues(int n, long expected) {
        // Act
        long result = calculator.factorial(n);
        
        // Assert
        assertEquals(expected, result, "Factorial should return correct value");
    }
    
    @Test
    @DisplayName("Test power calculation")
    void testPower() {
        // Arrange
        double base = 2.0;
        double exponent = 3.0;
        double expected = 8.0;
        
        // Act
        double result = calculator.power(base, exponent);
        
        // Assert
        assertEquals(expected, result, 0.001, "Power calculation should return correct value");
    }
    
    @Test
    @DisplayName("Test absolute value")
    void testAbsoluteValue() {
        // Test positive number
        assertEquals(5, calculator.absoluteValue(5), "Absolute value of positive number should be same");
        
        // Test negative number
        assertEquals(5, calculator.absoluteValue(-5), "Absolute value of negative number should be positive");
        
        // Test zero
        assertEquals(0, calculator.absoluteValue(0), "Absolute value of zero should be zero");
    }
    
    @Test
    @DisplayName("Test maximum of two numbers")
    void testMaximum() {
        // Test first number is greater
        assertEquals(10, calculator.maximum(10, 5), "Maximum should return greater number");
        
        // Test second number is greater
        assertEquals(15, calculator.maximum(5, 15), "Maximum should return greater number");
        
        // Test equal numbers
        assertEquals(7, calculator.maximum(7, 7), "Maximum of equal numbers should return the number");
    }
    
    @Test
    @DisplayName("Test minimum of two numbers")
    void testMinimum() {
        // Test first number is smaller
        assertEquals(5, calculator.minimum(5, 10), "Minimum should return smaller number");
        
        // Test second number is smaller
        assertEquals(3, calculator.minimum(8, 3), "Minimum should return smaller number");
        
        // Test equal numbers
        assertEquals(4, calculator.minimum(4, 4), "Minimum of equal numbers should return the number");
    }
    
    @Test
    @DisplayName("Test all operations together")
    void testAllOperations() {
        // Arrange
        int a = 10;
        int b = 3;
        
        // Act & Assert
        assertAll("Calculator operations",
            () -> assertEquals(13, calculator.add(a, b), "Addition failed"),
            () -> assertEquals(7, calculator.subtract(a, b), "Subtraction failed"),
            () -> assertEquals(30, calculator.multiply(a, b), "Multiplication failed"),
            () -> assertEquals(3, calculator.divide(a, b), "Division failed")
        );
    }
    
    @Test
    @DisplayName("Test calculator state")
    void testCalculatorState() {
        // Test initial state
        assertNotNull(calculator, "Calculator should be initialized");
        
        // Test operations don't change calculator state
        int result1 = calculator.add(5, 3);
        int result2 = calculator.add(2, 4);
        
        assertNotEquals(result1, result2, "Different operations should return different results");
    }
    
    @Nested
    @DisplayName("Edge Cases")
    class EdgeCasesTest {
        
        @Test
        @DisplayName("Test with zero values")
        void testWithZeroValues() {
            assertEquals(0, calculator.add(0, 0), "Adding zeros should return zero");
            assertEquals(0, calculator.subtract(0, 0), "Subtracting zeros should return zero");
            assertEquals(0, calculator.multiply(0, 5), "Multiplying by zero should return zero");
        }
        
        @Test
        @DisplayName("Test with negative values")
        void testWithNegativeValues() {
            assertEquals(-2, calculator.add(-5, 3), "Adding negative and positive should work");
            assertEquals(-8, calculator.subtract(-5, 3), "Subtracting from negative should work");
            assertEquals(-15, calculator.multiply(-5, 3), "Multiplying negative and positive should work");
        }
        
        @Test
        @DisplayName("Test with large values")
        void testWithLargeValues() {
            int large1 = Integer.MAX_VALUE;
            int large2 = Integer.MAX_VALUE - 1;
            
            assertThrows(ArithmeticException.class, () -> calculator.add(large1, 1), 
                "Adding to max value should throw ArithmeticException");
        }
    }
    
    /**
     * Calculator class for testing
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
                throw new IllegalArgumentException("Cannot divide by zero");
            }
            return a / b;
        }
        
        public double squareRoot(double a) {
            if (a < 0) {
                throw new IllegalArgumentException("Cannot calculate square root of negative number");
            }
            return Math.sqrt(a);
        }
        
        public long factorial(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Factorial is not defined for negative numbers");
            }
            if (n == 0 || n == 1) {
                return 1;
            }
            long result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        }
        
        public double power(double base, double exponent) {
            return Math.pow(base, exponent);
        }
        
        public int absoluteValue(int a) {
            return Math.abs(a);
        }
        
        public int maximum(int a, int b) {
            return Math.max(a, b);
        }
        
        public int minimum(int a, int b) {
            return Math.min(a, b);
        }
    }
}
