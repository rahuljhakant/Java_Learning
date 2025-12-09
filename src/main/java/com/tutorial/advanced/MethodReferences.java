package com.tutorial.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import Function;
import BiFunction;
import Supplier;
import Consumer;
import Predicate;
import Collectors;
import Stream;

/**
 * Method References Demo - Mastering Method References in Java 8+
 * 
 * This comprehensive tutorial demonstrates method references in Java 8+,
 * which provide a way to refer to methods without executing them.
 * Method references are a shorthand notation for lambda expressions
 * that make code more concise and readable.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what method references are and why they're useful
 * - Learn about different types of method references
 * - Master method reference syntax and usage
 * - Practice with real-world examples of method references
 * - Learn about method reference best practices
 * - Understand when to use method references vs lambda expressions
 * - Learn about method reference performance implications
 * 
 * KEY CONCEPTS:
 * 1. Static Method References: Class::staticMethod
 * 2. Instance Method References: object::instanceMethod
 * 3. Instance Method References on Type: Class::instanceMethod
 * 4. Constructor References: Class::new
 * 5. Array Constructor References: Type[]::new
 * 6. Method Reference vs Lambda: When to use each
 * 7. Best Practices: Guidelines for effective method reference usage
 * 8. Performance: Understanding method reference performance
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class MethodReferences {
    
    public static void main(String[] args) {
        System.out.println("=== Method References Demo ===");
        System.out.println();
        
        // 1. Static Method References
        demonstrateStaticMethodReferences();
        
        // 2. Instance Method References
        demonstrateInstanceMethodReferences();
        
        // 3. Instance Method References on Type
        demonstrateInstanceMethodReferencesOnType();
        
        // 4. Constructor References
        demonstrateConstructorReferences();
        
        // 5. Array Constructor References
        demonstrateArrayConstructorReferences();
        
        // 6. Method References with Streams
        demonstrateMethodReferencesWithStreams();
        
        // 7. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 8. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates static method references
     */
    private static void demonstrateStaticMethodReferences() {
        System.out.println("1. Static Method References:");
        System.out.println("============================");
        
        // Static method reference: Class::staticMethod
        System.out.println("Static Method References:");
        
        // Example 1: String.valueOf()
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> stringNumbers = numbers.stream()
            .map(String::valueOf)  // Static method reference
            .collect(Collectors.toList());
        System.out.println("  String.valueOf(): " + stringNumbers);
        
        // Example 2: Math.abs()
        List<Double> negativeNumbers = Arrays.asList(-1.5, -2.7, -3.9);
        List<Double> absoluteNumbers = negativeNumbers.stream()
            .map(Math::abs)  // Static method reference
            .collect(Collectors.toList());
        System.out.println("  Math.abs(): " + absoluteNumbers);
        
        // Example 3: Integer.parseInt()
        List<String> stringNumbers2 = Arrays.asList("10", "20", "30");
        List<Integer> parsedNumbers = stringNumbers2.stream()
            .map(Integer::parseInt)  // Static method reference
            .collect(Collectors.toList());
        System.out.println("  Integer.parseInt(): " + parsedNumbers);
        
        // Example 4: Custom static method
        List<String> words = Arrays.asList("hello", "world", "java");
        List<String> capitalizedWords = words.stream()
            .map(MethodReferences::capitalize)  // Custom static method reference
            .collect(Collectors.toList());
        System.out.println("  Custom static method: " + capitalizedWords);
        
        // Example 5: System.out.println
        System.out.println("  Using System.out::println:");
        words.forEach(System.out::println);  // Static method reference
        
        System.out.println();
    }
    
    /**
     * Demonstrates instance method references
     */
    private static void demonstrateInstanceMethodReferences() {
        System.out.println("2. Instance Method References:");
        System.out.println("=============================");
        
        // Instance method reference: object::instanceMethod
        System.out.println("Instance Method References:");
        
        // Example 1: String methods
        String prefix = "Hello, ";
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> greetings = names.stream()
            .map(prefix::concat)  // Instance method reference
            .collect(Collectors.toList());
        System.out.println("  String.concat(): " + greetings);
        
        // Example 2: StringBuilder methods
        StringBuilder sb = new StringBuilder();
        List<String> words = Arrays.asList("Java", "is", "awesome");
        words.forEach(sb::append);  // Instance method reference
        System.out.println("  StringBuilder.append(): " + sb.toString());
        
        // Example 3: Custom object methods
        Calculator calculator = new Calculator();
        List<Double> numbers = Arrays.asList(2.0, 3.0, 4.0);
        List<Double> squares = numbers.stream()
            .map(calculator::square)  // Instance method reference
            .collect(Collectors.toList());
        System.out.println("  Calculator.square(): " + squares);
        
        // Example 4: Collection methods
        List<String> list = new ArrayList<>();
        List<String> items = Arrays.asList("item1", "item2", "item3");
        items.forEach(list::add);  // Instance method reference
        System.out.println("  List.add(): " + list);
        
        System.out.println();
    }
    
    /**
     * Demonstrates instance method references on type
     */
    private static void demonstrateInstanceMethodReferencesOnType() {
        System.out.println("3. Instance Method References on Type:");
        System.out.println("=====================================");
        
        // Instance method reference on type: Class::instanceMethod
        System.out.println("Instance Method References on Type:");
        
        // Example 1: String methods
        List<String> words = Arrays.asList("hello", "world", "java");
        List<String> upperCaseWords = words.stream()
            .map(String::toUpperCase)  // Instance method reference on type
            .collect(Collectors.toList());
        System.out.println("  String.toUpperCase(): " + upperCaseWords);
        
        // Example 2: String methods with different types
        List<String> mixedCase = Arrays.asList("Hello", "WORLD", "java");
        List<String> lowerCaseWords = mixedCase.stream()
            .map(String::toLowerCase)  // Instance method reference on type
            .collect(Collectors.toList());
        System.out.println("  String.toLowerCase(): " + lowerCaseWords);
        
        // Example 3: String length
        List<String> textWords = Arrays.asList("apple", "banana", "cherry");
        List<Integer> wordLengths = textWords.stream()
            .map(String::length)  // Instance method reference on type
            .collect(Collectors.toList());
        System.out.println("  String.length(): " + wordLengths);
        
        // Example 4: Integer methods
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> numberStrings = numbers.stream()
            .map(Integer::toString)  // Instance method reference on type
            .collect(Collectors.toList());
        System.out.println("  Integer.toString(): " + numberStrings);
        
        // Example 5: Object methods
        List<Object> objects = Arrays.asList("hello", 123, 45.67, true);
        List<String> objectStrings = objects.stream()
            .map(Object::toString)  // Instance method reference on type
            .collect(Collectors.toList());
        System.out.println("  Object.toString(): " + objectStrings);
        
        System.out.println();
    }
    
    /**
     * Demonstrates constructor references
     */
    private static void demonstrateConstructorReferences() {
        System.out.println("4. Constructor References:");
        System.out.println("=========================");
        
        // Constructor reference: Class::new
        System.out.println("Constructor References:");
        
        // Example 1: String constructor
        List<String> words = Arrays.asList("hello", "world", "java");
        List<String> newStrings = words.stream()
            .map(String::new)  // Constructor reference
            .collect(Collectors.toList());
        System.out.println("  String constructor: " + newStrings);
        
        // Example 2: Custom class constructor
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<Person> people = names.stream()
            .map(Person::new)  // Constructor reference
            .collect(Collectors.toList());
        System.out.println("  Person constructor: " + people);
        
        // Example 3: Integer constructor
        List<String> numberStrings = Arrays.asList("10", "20", "30");
        List<Integer> numbers = numberStrings.stream()
            .map(Integer::new)  // Constructor reference
            .collect(Collectors.toList());
        System.out.println("  Integer constructor: " + numbers);
        
        // Example 4: ArrayList constructor
        List<String> items = Arrays.asList("item1", "item2", "item3");
        List<List<String>> lists = items.stream()
            .map(s -> Arrays.asList(s))
            .map(java.util.ArrayList::new)  // Constructor reference
            .collect(Collectors.toList());
        System.out.println("  ArrayList constructor: " + lists);
        
        // Example 5: HashMap constructor
        List<String> keys = Arrays.asList("key1", "key2", "key3");
        List<java.util.Map<String, String>> maps = keys.stream()
            .map(key -> {
                java.util.Map<String, String> map = new java.util.HashMap<>();
                map.put(key, "value");
                return map;
            })
            .collect(Collectors.toList());
        System.out.println("  HashMap constructor: " + maps);
        
        System.out.println();
    }
    
    /**
     * Demonstrates array constructor references
     */
    private static void demonstrateArrayConstructorReferences() {
        System.out.println("5. Array Constructor References:");
        System.out.println("===============================");
        
        // Array constructor reference: Type[]::new
        System.out.println("Array Constructor References:");
        
        // Example 1: String array constructor
        List<String> words = Arrays.asList("hello", "world", "java");
        String[] stringArray = words.stream()
            .toArray(String[]::new);  // Array constructor reference
        System.out.println("  String array: " + Arrays.toString(stringArray));
        
        // Example 2: Integer array constructor
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer[] integerArray = numbers.stream()
            .toArray(Integer[]::new);  // Array constructor reference
        System.out.println("  Integer array: " + Arrays.toString(integerArray));
        
        // Example 3: Double array constructor
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
        Double[] doubleArray = doubles.stream()
            .toArray(Double[]::new);  // Array constructor reference
        System.out.println("  Double array: " + Arrays.toString(doubleArray));
        
        // Example 4: Custom class array constructor
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Person[] personArray = names.stream()
            .map(Person::new)
            .toArray(Person[]::new);  // Array constructor reference
        System.out.println("  Person array: " + Arrays.toString(personArray));
        
        // Example 5: Primitive array constructor
        List<Integer> intNumbers = Arrays.asList(1, 2, 3, 4, 5);
        int[] primitiveArray = intNumbers.stream()
            .mapToInt(Integer::intValue)
            .toArray();  // Primitive array constructor
        System.out.println("  Primitive int array: " + Arrays.toString(primitiveArray));
        
        System.out.println();
    }
    
    /**
     * Demonstrates method references with streams
     */
    private static void demonstrateMethodReferencesWithStreams() {
        System.out.println("6. Method References with Streams:");
        System.out.println("=================================");
        
        // Method references are commonly used with streams
        System.out.println("Method References with Streams:");
        
        // Example 1: Filtering and mapping
        List<String> words = Arrays.asList("hello", "world", "java", "programming");
        List<String> filteredAndMapped = words.stream()
            .filter(s -> s.length() > 4)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("  Filtered and mapped: " + filteredAndMapped);
        
        // Example 2: Sorting with method reference
        List<String> unsorted = Arrays.asList("banana", "apple", "cherry");
        List<String> sorted = unsorted.stream()
            .sorted(String::compareTo)  // Method reference for sorting
            .collect(Collectors.toList());
        System.out.println("  Sorted: " + sorted);
        
        // Example 3: Collecting to different collections
        List<String> items = Arrays.asList("item1", "item2", "item3");
        java.util.Set<String> set = items.stream()
            .collect(Collectors.toCollection(java.util.HashSet::new));  // Constructor reference
        System.out.println("  HashSet: " + set);
        
        // Example 4: Grouping by method reference
        List<String> words2 = Arrays.asList("apple", "banana", "cherry", "date");
        java.util.Map<Integer, List<String>> groupedByLength = words2.stream()
            .collect(Collectors.groupingBy(String::length));  // Method reference
        System.out.println("  Grouped by length: " + groupedByLength);
        
        // Example 5: Reducing with method reference
        List<String> words3 = Arrays.asList("hello", "world", "java");
        String concatenated = words3.stream()
            .reduce("", String::concat);  // Method reference
        System.out.println("  Concatenated: " + concatenated);
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("7. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: Data processing pipeline
        System.out.println("Example 1: Data Processing Pipeline");
        System.out.println("-----------------------------------");
        
        List<String> rawData = Arrays.asList(
            "  john doe  ", "  jane smith  ", "  bob johnson  "
        );
        
        List<String> processedData = rawData.stream()
            .map(String::trim)  // Method reference
            .map(String::toLowerCase)  // Method reference
            .map(MethodReferences::capitalize)  // Static method reference
            .collect(Collectors.toList());
        
        System.out.println("  Raw data: " + rawData);
        System.out.println("  Processed data: " + processedData);
        
        // Example 2: Configuration processing
        System.out.println("\nExample 2: Configuration Processing");
        System.out.println("-----------------------------------");
        
        java.util.Map<String, String> config = new java.util.HashMap<>();
        config.put("db.host", "localhost");
        config.put("db.port", "3306");
        config.put("app.name", "MyApp");
        
        java.util.Map<String, String> processedConfig = config.entrySet().stream()
            .collect(Collectors.toMap(
                java.util.Map.Entry::getKey,  // Method reference
                entry -> entry.getValue().toUpperCase()  // Lambda with method reference
            ));
        
        System.out.println("  Original config: " + config);
        System.out.println("  Processed config: " + processedConfig);
        
        // Example 3: User management
        System.out.println("\nExample 3: User Management");
        System.out.println("-------------------------");
        
        List<User> users = Arrays.asList(
            new User("john", "john@example.com"),
            new User("jane", "jane@example.com"),
            new User("bob", "bob@example.com")
        );
        
        List<String> userNames = users.stream()
            .map(User::getName)  // Method reference
            .map(String::toUpperCase)  // Method reference
            .collect(Collectors.toList());
        
        List<String> userEmails = users.stream()
            .map(User::getEmail)  // Method reference
            .collect(Collectors.toList());
        
        System.out.println("  User names: " + userNames);
        System.out.println("  User emails: " + userEmails);
        
        // Example 4: File processing
        System.out.println("\nExample 4: File Processing");
        System.out.println("-------------------------");
        
        List<String> fileNames = Arrays.asList(
            "document.txt", "image.jpg", "data.csv", "script.js"
        );
        
        List<String> fileExtensions = fileNames.stream()
            .map(fileName -> fileName.substring(fileName.lastIndexOf('.') + 1))
            .map(String::toUpperCase)  // Method reference
            .collect(Collectors.toList());
        
        System.out.println("  File names: " + fileNames);
        System.out.println("  File extensions: " + fileExtensions);
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("8. Best Practices:");
        System.out.println("=================");
        
        System.out.println("Method Reference Best Practices:");
        System.out.println("-------------------------------");
        System.out.println("1. Use method references when they make code more readable");
        System.out.println("2. Prefer method references over lambda expressions when possible");
        System.out.println("3. Use static method references for utility functions");
        System.out.println("4. Use instance method references for object-specific operations");
        System.out.println("5. Use constructor references for object creation");
        System.out.println("6. Use array constructor references for array creation");
        System.out.println("7. Consider method reference performance implications");
        System.out.println("8. Use method references consistently throughout your codebase");
        
        System.out.println("\nWhen to Use Method References vs Lambda Expressions:");
        System.out.println("--------------------------------------------------");
        System.out.println("• Use method references when the lambda just calls a method");
        System.out.println("• Use lambda expressions when you need additional logic");
        System.out.println("• Use method references for simple transformations");
        System.out.println("• Use lambda expressions for complex operations");
        System.out.println("• Use method references for better readability");
        System.out.println("• Use lambda expressions when method references are unclear");
        
        System.out.println("\nPerformance Considerations:");
        System.out.println("-------------------------");
        System.out.println("• Method references have minimal performance overhead");
        System.out.println("• Method references are often optimized by the JVM");
        System.out.println("• Use method references for better code maintainability");
        System.out.println("• Consider method reference readability over micro-optimizations");
        
        System.out.println("\nCommon Mistakes:");
        System.out.println("---------------");
        System.out.println("• Using method references when lambda expressions are clearer");
        System.out.println("• Not understanding the difference between method reference types");
        System.out.println("• Using method references for complex operations");
        System.out.println("• Not considering method reference readability");
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Method references provide concise syntax for method calls");
        System.out.println("• Use static method references for utility functions");
        System.out.println("• Use instance method references for object operations");
        System.out.println("• Use constructor references for object creation");
        System.out.println("• Use array constructor references for array creation");
        System.out.println("• Method references improve code readability and maintainability");
        System.out.println("• Choose method references over lambda expressions when appropriate");
        System.out.println("• Follow best practices for effective method reference usage");
    }
    
    // Helper methods for demonstration
    
    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
    
    // Inner classes for demonstration
    
    static class Calculator {
        public double square(double number) {
            return number * number;
        }
    }
    
    static class Person {
        private String name;
        
        public Person(String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
        }
        
        @Override
        public String toString() {
            return "Person{name='" + name + "'}";
        }
    }
    
    static class User {
        private String name;
        private String email;
        
        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
        
        public String getName() {
            return name;
        }
        
        public String getEmail() {
            return email;
        }
        
        @Override
        public String toString() {
            return "User{name='" + name + "', email='" + email + "'}";
        }
    }
}
