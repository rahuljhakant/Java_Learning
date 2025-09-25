package com.tutorial.intermediate.exceptions;

import java.io.*;
import java.util.*;

/**
 * Exception Hierarchy - Understanding Java Exception Types
 * 
 * This comprehensive tutorial demonstrates the Java exception hierarchy,
 * different types of exceptions, and how to handle them properly.
 * Learn about checked vs unchecked exceptions and best practices.
 * 
 * LEARNING OBJECTIVES:
 * - Understand the Java exception hierarchy
 * - Differentiate between checked and unchecked exceptions
 * - Handle different types of exceptions appropriately
 * - Use exception handling best practices
 * - Create custom exception hierarchies
 * - Apply proper exception handling patterns
 * 
 * KEY CONCEPTS:
 * 1. Exception Hierarchy: Throwable, Error, Exception structure
 * 2. Checked Exceptions: Compile-time enforced exceptions
 * 3. Unchecked Exceptions: Runtime exceptions and errors
 * 4. Exception Handling: try-catch-finally blocks
 * 5. Custom Exceptions: Creating your own exception classes
 * 6. Best Practices: Proper exception handling strategies
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class ExceptionHierarchy {
    
    public static void main(String[] args) {
        System.out.println("=== Exception Hierarchy Demo ===");
        System.out.println();
        
        // 1. Exception Hierarchy Overview
        demonstrateExceptionHierarchy();
        
        // 2. Checked Exceptions
        demonstrateCheckedExceptions();
        
        // 3. Unchecked Exceptions
        demonstrateUncheckedExceptions();
        
        // 4. Error Types
        demonstrateErrorTypes();
        
        // 5. Custom Exception Hierarchy
        demonstrateCustomExceptionHierarchy();
        
        // 6. Exception Handling Best Practices
        demonstrateExceptionHandlingBestPractices();
    }
    
    /**
     * Demonstrates the Java exception hierarchy
     */
    private static void demonstrateExceptionHierarchy() {
        System.out.println("1. Exception Hierarchy Overview:");
        System.out.println("================================");
        
        System.out.println("Java Exception Hierarchy:");
        System.out.println("Throwable (root class)");
        System.out.println("├── Error (unchecked)");
        System.out.println("│   ├── OutOfMemoryError");
        System.out.println("│   ├── StackOverflowError");
        System.out.println("│   └── VirtualMachineError");
        System.out.println("└── Exception (checked by default)");
        System.out.println("    ├── RuntimeException (unchecked)");
        System.out.println("    │   ├── NullPointerException");
        System.out.println("    │   ├── IllegalArgumentException");
        System.out.println("    │   ├── ArrayIndexOutOfBoundsException");
        System.out.println("    │   └── ArithmeticException");
        System.out.println("    └── Checked Exceptions");
        System.out.println("        ├── IOException");
        System.out.println("        ├── SQLException");
        System.out.println("        ├── ClassNotFoundException");
        System.out.println("        └── ParseException");
        
        System.out.println();
    }
    
    /**
     * Demonstrates checked exceptions
     */
    private static void demonstrateCheckedExceptions() {
        System.out.println("2. Checked Exceptions:");
        System.out.println("=====================");
        
        // File operations (IOException)
        try {
            File file = new File("nonexistent.txt");
            FileReader reader = new FileReader(file);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Checked Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Checked Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        
        // Class loading (ClassNotFoundException)
        try {
            Class.forName("NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("Checked Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        
        // Date parsing (ParseException)
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
            sdf.parse("invalid-date");
        } catch (java.text.ParseException e) {
            System.out.println("Checked Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates unchecked exceptions
     */
    private static void demonstrateUncheckedExceptions() {
        System.out.println("3. Unchecked Exceptions:");
        System.out.println("=======================");
        
        // NullPointerException
        try {
            String str = null;
            int length = str.length();
        } catch (NullPointerException e) {
            System.out.println("Unchecked Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        
        // ArrayIndexOutOfBoundsException
        try {
            int[] array = {1, 2, 3};
            int value = array[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Unchecked Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        
        // IllegalArgumentException
        try {
            if (true) {
                throw new IllegalArgumentException("Invalid argument provided");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Unchecked Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        
        // ArithmeticException
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Unchecked Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates error types
     */
    private static void demonstrateErrorTypes() {
        System.out.println("4. Error Types:");
        System.out.println("==============");
        
        // OutOfMemoryError (commented out to prevent actual error)
        System.out.println("OutOfMemoryError: Occurs when JVM runs out of memory");
        System.out.println("Example: Creating too many large objects");
        
        // StackOverflowError (commented out to prevent actual error)
        System.out.println("StackOverflowError: Occurs when stack overflow happens");
        System.out.println("Example: Infinite recursion");
        
        // VirtualMachineError
        System.out.println("VirtualMachineError: Base class for JVM errors");
        System.out.println("Examples: OutOfMemoryError, StackOverflowError");
        
        System.out.println();
    }
    
    /**
     * Demonstrates custom exception hierarchy
     */
    private static void demonstrateCustomExceptionHierarchy() {
        System.out.println("5. Custom Exception Hierarchy:");
        System.out.println("=============================");
        
        try {
            // Simulate business logic that throws custom exceptions
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        
        try {
            validateEmail("invalid-email");
        } catch (InvalidEmailException e) {
            System.out.println("Custom Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        
        try {
            processPayment(-100);
        } catch (PaymentException e) {
            System.out.println("Custom Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates exception handling best practices
     */
    private static void demonstrateExceptionHandlingBestPractices() {
        System.out.println("6. Exception Handling Best Practices:");
        System.out.println("====================================");
        
        System.out.println("✓ Use specific exception types instead of generic Exception");
        System.out.println("✓ Handle exceptions at the appropriate level");
        System.out.println("✓ Don't ignore exceptions - log or handle them");
        System.out.println("✓ Use try-with-resources for automatic resource management");
        System.out.println("✓ Create meaningful exception messages");
        System.out.println("✓ Use checked exceptions for recoverable conditions");
        System.out.println("✓ Use unchecked exceptions for programming errors");
        System.out.println("✓ Don't catch exceptions you can't handle");
        System.out.println("✓ Use finally blocks for cleanup code");
        System.out.println("✓ Consider using custom exceptions for business logic");
        System.out.println("✓ Log exceptions with appropriate log levels");
        System.out.println("✓ Use exception chaining to preserve stack traces");
        
        System.out.println();
    }
    
    // Custom exception classes
    public static class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message);
        }
    }
    
    public static class InvalidAgeException extends ValidationException {
        public InvalidAgeException(String message) {
            super(message);
        }
    }
    
    public static class InvalidEmailException extends ValidationException {
        public InvalidEmailException(String message) {
            super(message);
        }
    }
    
    public static class PaymentException extends Exception {
        public PaymentException(String message) {
            super(message);
        }
    }
    
    // Methods that throw custom exceptions
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Age must be between 0 and 150, got: " + age);
        }
    }
    
    public static void validateEmail(String email) throws InvalidEmailException {
        if (email == null || !email.contains("@")) {
            throw new InvalidEmailException("Invalid email format: " + email);
        }
    }
    
    public static void processPayment(double amount) throws PaymentException {
        if (amount < 0) {
            throw new PaymentException("Payment amount cannot be negative: " + amount);
        }
    }
}
