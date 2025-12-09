package com.tutorial.testing;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Checkstyle Demo - Code Style Analysis and Best Practices
 * 
 * This comprehensive tutorial demonstrates Checkstyle, a development tool
 * that helps programmers write Java code that adheres to a coding standard.
 * Checkstyle automates the process of checking Java code to ensure it
 * follows coding standards and best practices.
 * 
 * LEARNING OBJECTIVES:
 * - Understand Checkstyle and its benefits
 * - Configure Checkstyle rules and standards
 * - Fix common code style violations
 * - Integrate Checkstyle with build tools
 * - Apply coding standards consistently
 * - Use Checkstyle in CI/CD pipelines
 * 
 * KEY CONCEPTS:
 * 1. Code Style Rules: Naming conventions, formatting, and structure
 * 2. Checkstyle Configuration: XML configuration files and rule sets
 * 3. Build Integration: Maven and Gradle plugin configuration
 * 4. CI/CD Integration: Automated style checking in pipelines
 * 5. Custom Rules: Creating and applying custom style rules
 * 6. Best Practices: Applying consistent coding standards
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class CheckstyleDemo {
    
    // Constants should be in UPPER_CASE with underscores
    private static final int MAX_RETRY_COUNT = 3;
    private static final String DEFAULT_MESSAGE = "Hello World";
    
    // Instance variables should be camelCase
    private String userName;
    private int userAge;
    private List<String> userPreferences;
    
    /**
     * Constructor with proper JavaDoc documentation.
     * 
     * @param name the user name
     * @param age the user age
     */
    public CheckstyleDemo(String name, int age) {
        this.userName = name;
        this.userAge = age;
        this.userPreferences = new ArrayList<>();
    }
    
    /**
     * Getter method with proper naming convention.
     * 
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * Setter method with proper naming convention.
     * 
     * @param name the user name to set
     */
    public void setUserName(String name) {
        this.userName = name;
    }
    
    /**
     * Method with proper formatting and structure.
     * 
     * @param preference the preference to add
     * @return true if added successfully
     */
    public boolean addUserPreference(String preference) {
        if (preference == null || preference.trim().isEmpty()) {
            return false;
        }
        
        return userPreferences.add(preference);
    }
    
    /**
     * Method demonstrating proper exception handling.
     * 
     * @param value the value to process
     * @throws IllegalArgumentException if value is invalid
     */
    public void processValue(int value) throws IllegalArgumentException {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        
        // Process the value
        System.out.println("Processing value: " + value);
    }
    
    /**
     * Method with proper loop structure and formatting.
     * 
     * @param items the items to process
     */
    public void processItems(List<String> items) {
        if (items == null || items.isEmpty()) {
            return;
        }
        
        for (String item : items) {
            if (item != null && !item.trim().isEmpty()) {
                System.out.println("Processing item: " + item);
            }
        }
    }
    
    /**
     * Method demonstrating proper switch statement formatting.
     * 
     * @param status the status to process
     * @return the processed status
     */
    public String processStatus(String status) {
        if (status == null) {
            return "UNKNOWN";
        }
        
        switch (status.toLowerCase()) {
            case "active":
                return "ACTIVE";
            case "inactive":
                return "INACTIVE";
            case "pending":
                return "PENDING";
            default:
                return "UNKNOWN";
        }
    }
    
    /**
     * Method with proper try-catch structure.
     * 
     * @param data the data to parse
     * @return the parsed integer value
     */
    public int parseInteger(String data) {
        try {
            return Integer.parseInt(data);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + data);
            return 0;
        }
    }
    
    /**
     * Method demonstrating proper array handling.
     * 
     * @param numbers the array of numbers
     * @return the sum of all numbers
     */
    public int calculateSum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        
        return sum;
    }
    
    /**
     * Method with proper Map handling.
     * 
     * @param key the key to look up
     * @return the value associated with the key
     */
    public String getValueFromMap(String key) {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("key1", "value1");
        dataMap.put("key2", "value2");
        
        return dataMap.get(key);
    }
    
    /**
     * Method demonstrating proper method chaining.
     * 
     * @param input the input string
     * @return the processed string
     */
    public String processString(String input) {
        if (input == null) {
            return "";
        }
        
        return input.trim()
                   .toLowerCase()
                   .replaceAll("\\s+", "_");
    }
    
    /**
     * Method with proper validation and error handling.
     * 
     * @param email the email to validate
     * @return true if email is valid
     */
    public boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        
        // Simple email validation
        return email.contains("@") && 
               email.contains(".") && 
               email.length() > 5;
    }
    
    /**
     * Method demonstrating proper resource management.
     * 
     * @param resource the resource to process
     */
    public void processResource(String resource) {
        if (resource == null) {
            return;
        }
        
        // Simulate resource processing
        try {
            System.out.println("Processing resource: " + resource);
            // Resource processing logic here
        } catch (Exception e) {
            System.err.println("Error processing resource: " + e.getMessage());
        }
    }
    
    /**
     * Method with proper synchronization.
     * 
     * @param data the data to update
     */
    public synchronized void updateData(String data) {
        if (data != null) {
            this.userName = data;
        }
    }
    
    /**
     * Method demonstrating proper generic usage.
     * 
     * @param <T> the type parameter
     * @param list the list to process
     * @return the size of the list
     */
    public <T> int getListSize(List<T> list) {
        return list != null ? list.size() : 0;
    }
    
    /**
     * Method with proper enum usage.
     * 
     * @param status the status enum
     * @return the status description
     */
    public String getStatusDescription(Status status) {
        if (status == null) {
            return "Unknown status";
        }
        
        switch (status) {
            case ACTIVE:
                return "User is active";
            case INACTIVE:
                return "User is inactive";
            case PENDING:
                return "User is pending approval";
            default:
                return "Unknown status";
        }
    }
    
    /**
     * Enum demonstrating proper enum structure.
     */
    public enum Status {
        ACTIVE,
        INACTIVE,
        PENDING
    }
    
    /**
     * Inner class demonstrating proper inner class structure.
     */
    public static class UserInfo {
        private String name;
        private int age;
        
        public UserInfo(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() {
            return name;
        }
        
        public int getAge() {
            return age;
        }
    }
    
    /**
     * Method demonstrating proper method overloading.
     * 
     * @param value the integer value
     * @return the processed value
     */
    public int processValue(int value) {
        return value * 2;
    }
    
    /**
     * Method demonstrating proper method overloading.
     * 
     * @param value the double value
     * @return the processed value
     */
    public double processValue(double value) {
        return value * 2.0;
    }
    
    /**
     * Method demonstrating proper method overloading.
     * 
     * @param value the string value
     * @return the processed value
     */
    public String processValue(String value) {
        return value != null ? value.toUpperCase() : "";
    }
}
