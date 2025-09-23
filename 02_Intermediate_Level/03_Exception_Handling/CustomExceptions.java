package com.tutorial.intermediate;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom Exceptions Demo
 * 
 * This class demonstrates:
 * - Creating custom exception classes
 * - Exception inheritance
 * - Custom exception with additional data
 * - Exception chaining
 * - Best practices for custom exceptions
 */
public class CustomExceptions {
    
    public static void main(String[] args) {
        System.out.println("=== Custom Exceptions Demo ===");
        System.out.println();
        
        // 1. Basic Custom Exception
        demonstrateBasicCustomException();
        
        // 2. Custom Exception with Additional Data
        demonstrateCustomExceptionWithData();
        
        // 3. Exception Chaining
        demonstrateExceptionChaining();
        
        // 4. Business Logic Exceptions
        demonstrateBusinessLogicExceptions();
        
        // 5. Validation Exceptions
        demonstrateValidationExceptions();
        
        // 6. Exception Best Practices
        demonstrateExceptionBestPractices();
    }
    
    /**
     * Demonstrates basic custom exception
     */
    private static void demonstrateBasicCustomException() {
        System.out.println("1. Basic Custom Exception:");
        System.out.println("=========================");
        
        try {
            throw new CustomException("This is a custom exception");
        } catch (CustomException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
            System.out.println("Exception type: " + e.getClass().getSimpleName());
        }
        System.out.println();
    }
    
    /**
     * Demonstrates custom exception with additional data
     */
    private static void demonstrateCustomExceptionWithData() {
        System.out.println("2. Custom Exception with Additional Data:");
        System.out.println("========================================");
        
        try {
            // Simulating a bank account operation
            BankAccount account = new BankAccount("12345", 1000.0);
            account.withdraw(1500.0); // This will cause an exception
        } catch (InsufficientFundsException e) {
            System.out.println("Caught InsufficientFundsException:");
            System.out.println("Account: " + e.getAccountNumber());
            System.out.println("Current Balance: $" + e.getCurrentBalance());
            System.out.println("Requested Amount: $" + e.getRequestedAmount());
            System.out.println("Shortfall: $" + e.getShortfall());
        }
        System.out.println();
    }
    
    /**
     * Demonstrates exception chaining
     */
    private static void demonstrateExceptionChaining() {
        System.out.println("3. Exception Chaining:");
        System.out.println("=====================");
        
        try {
            processFile("config.txt");
        } catch (FileProcessingException e) {
            System.out.println("Caught FileProcessingException: " + e.getMessage());
            System.out.println("Root cause: " + e.getCause().getClass().getSimpleName());
            System.out.println("Root cause message: " + e.getCause().getMessage());
            
            // Print the full stack trace
            System.out.println("\nFull exception chain:");
            e.printStackTrace();
        }
        System.out.println();
    }
    
    /**
     * Demonstrates business logic exceptions
     */
    private static void demonstrateBusinessLogicExceptions() {
        System.out.println("4. Business Logic Exceptions:");
        System.out.println("=============================");
        
        UserService userService = new UserService();
        
        try {
            userService.registerUser("", "password123"); // Empty username
        } catch (InvalidUserException e) {
            System.out.println("Invalid user: " + e.getMessage());
            System.out.println("Validation errors: " + e.getValidationErrors());
        }
        
        try {
            userService.registerUser("john", "123"); // Weak password
        } catch (InvalidUserException e) {
            System.out.println("Invalid user: " + e.getMessage());
            System.out.println("Validation errors: " + e.getValidationErrors());
        }
        
        try {
            userService.registerUser("admin", "strongPassword123");
            userService.registerUser("admin", "anotherPassword"); // Duplicate username
        } catch (InvalidUserException e) {
            System.out.println("Invalid user: " + e.getMessage());
            System.out.println("Validation errors: " + e.getValidationErrors());
        }
        System.out.println();
    }
    
    /**
     * Demonstrates validation exceptions
     */
    private static void demonstrateValidationExceptions() {
        System.out.println("5. Validation Exceptions:");
        System.out.println("========================");
        
        ProductService productService = new ProductService();
        
        try {
            productService.addProduct("", 10.0); // Empty name
        } catch (ValidationException e) {
            System.out.println("Validation failed: " + e.getMessage());
            System.out.println("Field: " + e.getFieldName());
            System.out.println("Value: " + e.getFieldValue());
        }
        
        try {
            productService.addProduct("Laptop", -100.0); // Negative price
        } catch (ValidationException e) {
            System.out.println("Validation failed: " + e.getMessage());
            System.out.println("Field: " + e.getFieldName());
            System.out.println("Value: " + e.getFieldValue());
        }
        System.out.println();
    }
    
    /**
     * Demonstrates exception best practices
     */
    private static void demonstrateExceptionBestPractices() {
        System.out.println("6. Exception Best Practices:");
        System.out.println("===========================");
        
        // 1. Use specific exception types
        try {
            throw new SpecificException("Specific error occurred");
        } catch (SpecificException e) {
            System.out.println("Caught specific exception: " + e.getMessage());
        }
        
        // 2. Provide meaningful error messages
        try {
            throw new MeaningfulException("User authentication failed: Invalid credentials");
        } catch (MeaningfulException e) {
            System.out.println("Meaningful error: " + e.getMessage());
        }
        
        // 3. Don't catch and ignore exceptions
        try {
            throw new CustomException("This should be handled properly");
        } catch (CustomException e) {
            System.out.println("Properly handled: " + e.getMessage());
            // Log the exception or take appropriate action
        }
        
        System.out.println();
    }
    
    /**
     * Simulates file processing that can cause exceptions
     */
    private static void processFile(String filename) throws FileProcessingException {
        try {
            // Simulate file reading that might fail
            if (filename.equals("config.txt")) {
                throw new java.io.FileNotFoundException("File not found: " + filename);
            }
        } catch (java.io.FileNotFoundException e) {
            // Chain the exception
            throw new FileProcessingException("Failed to process file: " + filename, e);
        }
    }
}

/**
 * Basic custom exception class
 */
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
    
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}

/**
 * Custom exception with additional data
 */
class InsufficientFundsException extends Exception {
    private String accountNumber;
    private double currentBalance;
    private double requestedAmount;
    
    public InsufficientFundsException(String accountNumber, double currentBalance, double requestedAmount) {
        super(String.format("Insufficient funds in account %s. Current: $%.2f, Requested: $%.2f", 
                           accountNumber, currentBalance, requestedAmount));
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.requestedAmount = requestedAmount;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getCurrentBalance() {
        return currentBalance;
    }
    
    public double getRequestedAmount() {
        return requestedAmount;
    }
    
    public double getShortfall() {
        return requestedAmount - currentBalance;
    }
}

/**
 * Exception chaining example
 */
class FileProcessingException extends Exception {
    public FileProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

/**
 * Business logic exception with validation errors
 */
class InvalidUserException extends Exception {
    private List<String> validationErrors;
    
    public InvalidUserException(String message, List<String> validationErrors) {
        super(message);
        this.validationErrors = validationErrors;
    }
    
    public List<String> getValidationErrors() {
        return validationErrors;
    }
}

/**
 * Validation exception with field information
 */
class ValidationException extends Exception {
    private String fieldName;
    private Object fieldValue;
    
    public ValidationException(String message, String fieldName, Object fieldValue) {
        super(message);
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    
    public String getFieldName() {
        return fieldName;
    }
    
    public Object getFieldValue() {
        return fieldValue;
    }
}

/**
 * Specific exception type
 */
class SpecificException extends Exception {
    public SpecificException(String message) {
        super(message);
    }
}

/**
 * Exception with meaningful error message
 */
class MeaningfulException extends Exception {
    public MeaningfulException(String message) {
        super(message);
    }
}

/**
 * Bank Account class for demonstration
 */
class BankAccount {
    private String accountNumber;
    private double balance;
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(accountNumber, balance, amount);
        }
        balance -= amount;
        System.out.println("Withdrawn $" + amount + " from account " + accountNumber);
    }
    
    public double getBalance() {
        return balance;
    }
}

/**
 * User Service for demonstration
 */
class UserService {
    private List<String> registeredUsers = new ArrayList<>();
    
    public void registerUser(String username, String password) throws InvalidUserException {
        List<String> errors = new ArrayList<>();
        
        if (username == null || username.trim().isEmpty()) {
            errors.add("Username cannot be empty");
        }
        
        if (password == null || password.length() < 8) {
            errors.add("Password must be at least 8 characters long");
        }
        
        if (registeredUsers.contains(username)) {
            errors.add("Username already exists");
        }
        
        if (!errors.isEmpty()) {
            throw new InvalidUserException("User registration failed", errors);
        }
        
        registeredUsers.add(username);
        System.out.println("User " + username + " registered successfully");
    }
}

/**
 * Product Service for demonstration
 */
class ProductService {
    public void addProduct(String name, double price) throws ValidationException {
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("Product name cannot be empty", "name", name);
        }
        
        if (price < 0) {
            throw new ValidationException("Product price cannot be negative", "price", price);
        }
        
        System.out.println("Product " + name + " added with price $" + price);
    }
}
