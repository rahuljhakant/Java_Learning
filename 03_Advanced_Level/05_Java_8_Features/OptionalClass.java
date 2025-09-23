package com.tutorial.advanced.java8;

/**
 * Optional Class Demo - Mastering Null Safety in Java 8+
 * 
 * This comprehensive tutorial demonstrates the Optional class in Java 8+,
 * which provides a way to handle null values safely and expressively.
 * Optional helps prevent NullPointerException and makes code more
 * readable by explicitly indicating when a value might be absent.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what Optional is and why it's important
 * - Learn how to create and use Optional objects
 * - Master Optional methods and operations
 * - Practice with real-world examples of Optional
 * - Learn about Optional best practices and common pitfalls
 * - Understand when to use Optional vs null checks
 * - Learn about Optional chaining and composition
 * 
 * KEY CONCEPTS:
 * 1. Optional Creation: of(), ofNullable(), empty()
 * 2. Value Checking: isPresent(), isEmpty()
 * 3. Value Retrieval: get(), orElse(), orElseGet(), orElseThrow()
 * 4. Value Transformation: map(), flatMap(), filter()
 * 5. Conditional Operations: ifPresent(), ifPresentOrElse()
 * 6. Optional Chaining: Combining multiple Optional operations
 * 7. Best Practices: When and how to use Optional effectively
 * 8. Performance: Understanding Optional performance implications
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
public class OptionalClass {
    
    public static void main(String[] args) {
        System.out.println("=== Optional Class Demo ===");
        System.out.println();
        
        // 1. Basic Optional Operations
        demonstrateBasicOptionalOperations();
        
        // 2. Optional Creation Methods
        demonstrateOptionalCreation();
        
        // 3. Value Checking and Retrieval
        demonstrateValueCheckingAndRetrieval();
        
        // 4. Value Transformation
        demonstrateValueTransformation();
        
        // 5. Conditional Operations
        demonstrateConditionalOperations();
        
        // 6. Optional Chaining
        demonstrateOptionalChaining();
        
        // 7. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 8. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic Optional operations
     */
    private static void demonstrateBasicOptionalOperations() {
        System.out.println("1. Basic Optional Operations:");
        System.out.println("============================");
        
        // Creating Optional with a value
        java.util.Optional<String> optionalWithValue = java.util.Optional.of("Hello, World!");
        System.out.println("Optional with value: " + optionalWithValue);
        System.out.println("Is present: " + optionalWithValue.isPresent());
        System.out.println("Value: " + optionalWithValue.get());
        
        // Creating empty Optional
        java.util.Optional<String> emptyOptional = java.util.Optional.empty();
        System.out.println("\nEmpty Optional: " + emptyOptional);
        System.out.println("Is present: " + emptyOptional.isPresent());
        System.out.println("Is empty: " + emptyOptional.isEmpty());
        
        // Creating Optional with nullable value
        String nullableValue = null;
        java.util.Optional<String> optionalWithNullable = java.util.Optional.ofNullable(nullableValue);
        System.out.println("\nOptional with nullable value: " + optionalWithNullable);
        System.out.println("Is present: " + optionalWithNullable.isPresent());
        
        // Safe value retrieval
        String safeValue = optionalWithNullable.orElse("Default Value");
        System.out.println("Safe value: " + safeValue);
        
        System.out.println();
    }
    
    /**
     * Demonstrates Optional creation methods
     */
    private static void demonstrateOptionalCreation() {
        System.out.println("2. Optional Creation Methods:");
        System.out.println("============================");
        
        // Optional.of() - throws exception if null
        System.out.println("Using Optional.of():");
        try {
            java.util.Optional<String> nonNullOptional = java.util.Optional.of("Non-null value");
            System.out.println("  Created: " + nonNullOptional);
        } catch (Exception e) {
            System.err.println("  Error: " + e.getMessage());
        }
        
        // Optional.ofNullable() - handles null values
        System.out.println("\nUsing Optional.ofNullable():");
        String nullValue = null;
        java.util.Optional<String> nullableOptional = java.util.Optional.ofNullable(nullValue);
        System.out.println("  Created with null: " + nullableOptional);
        
        String nonNullValue = "Non-null value";
        java.util.Optional<String> nonNullOptional2 = java.util.Optional.ofNullable(nonNullValue);
        System.out.println("  Created with value: " + nonNullOptional2);
        
        // Optional.empty() - creates empty Optional
        System.out.println("\nUsing Optional.empty():");
        java.util.Optional<String> emptyOptional = java.util.Optional.empty();
        System.out.println("  Created empty: " + emptyOptional);
        
        // Creating Optional from method return
        System.out.println("\nCreating Optional from method return:");
        java.util.Optional<String> methodOptional = findUserById(1);
        System.out.println("  Method return: " + methodOptional);
        
        java.util.Optional<String> methodOptional2 = findUserById(999);
        System.out.println("  Method return (not found): " + methodOptional2);
        
        System.out.println();
    }
    
    /**
     * Demonstrates value checking and retrieval
     */
    private static void demonstrateValueCheckingAndRetrieval() {
        System.out.println("3. Value Checking and Retrieval:");
        System.out.println("===============================");
        
        java.util.Optional<String> presentOptional = java.util.Optional.of("Present Value");
        java.util.Optional<String> emptyOptional = java.util.Optional.empty();
        
        // Value checking
        System.out.println("Value Checking:");
        System.out.println("  Present optional is present: " + presentOptional.isPresent());
        System.out.println("  Present optional is empty: " + presentOptional.isEmpty());
        System.out.println("  Empty optional is present: " + emptyOptional.isPresent());
        System.out.println("  Empty optional is empty: " + emptyOptional.isEmpty());
        
        // Value retrieval
        System.out.println("\nValue Retrieval:");
        
        // get() - throws exception if empty
        try {
            String value = presentOptional.get();
            System.out.println("  get() from present: " + value);
        } catch (Exception e) {
            System.err.println("  get() error: " + e.getMessage());
        }
        
        // orElse() - returns default value if empty
        String defaultValue = presentOptional.orElse("Default");
        System.out.println("  orElse() from present: " + defaultValue);
        
        String defaultValue2 = emptyOptional.orElse("Default");
        System.out.println("  orElse() from empty: " + defaultValue2);
        
        // orElseGet() - returns value from supplier if empty
        String supplierValue = presentOptional.orElseGet(() -> "Supplier Value");
        System.out.println("  orElseGet() from present: " + supplierValue);
        
        String supplierValue2 = emptyOptional.orElseGet(() -> "Supplier Value");
        System.out.println("  orElseGet() from empty: " + supplierValue2);
        
        // orElseThrow() - throws exception if empty
        try {
            String value = presentOptional.orElseThrow(() -> new RuntimeException("Value not found"));
            System.out.println("  orElseThrow() from present: " + value);
        } catch (Exception e) {
            System.err.println("  orElseThrow() error: " + e.getMessage());
        }
        
        try {
            String value = emptyOptional.orElseThrow(() -> new RuntimeException("Value not found"));
            System.out.println("  orElseThrow() from empty: " + value);
        } catch (Exception e) {
            System.err.println("  orElseThrow() from empty: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates value transformation
     */
    private static void demonstrateValueTransformation() {
        System.out.println("4. Value Transformation:");
        System.out.println("=======================");
        
        java.util.Optional<String> presentOptional = java.util.Optional.of("  hello world  ");
        java.util.Optional<String> emptyOptional = java.util.Optional.empty();
        
        // map() - transforms value if present
        System.out.println("Using map():");
        java.util.Optional<String> mapped = presentOptional.map(String::toUpperCase);
        System.out.println("  Original: " + presentOptional);
        System.out.println("  Mapped: " + mapped);
        
        java.util.Optional<String> mappedEmpty = emptyOptional.map(String::toUpperCase);
        System.out.println("  Empty mapped: " + mappedEmpty);
        
        // map() with multiple transformations
        java.util.Optional<String> multipleMapped = presentOptional
            .map(String::trim)
            .map(String::toUpperCase)
            .map(s -> s.replace(" ", "_"));
        System.out.println("  Multiple transformations: " + multipleMapped);
        
        // flatMap() - flattens nested Optionals
        System.out.println("\nUsing flatMap():");
        java.util.Optional<String> flatMapped = presentOptional
            .flatMap(s -> java.util.Optional.of(s.trim().toUpperCase()));
        System.out.println("  Flat mapped: " + flatMapped);
        
        // filter() - filters values based on condition
        System.out.println("\nUsing filter():");
        java.util.Optional<String> filtered = presentOptional
            .filter(s -> s.length() > 5);
        System.out.println("  Filtered (length > 5): " + filtered);
        
        java.util.Optional<String> filteredEmpty = presentOptional
            .filter(s -> s.length() > 100);
        System.out.println("  Filtered (length > 100): " + filteredEmpty);
        
        // Complex transformation chain
        System.out.println("\nComplex transformation chain:");
        java.util.Optional<String> complex = presentOptional
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .map(String::toUpperCase)
            .map(s -> s.replace(" ", "_"))
            .map(s -> "PREFIX_" + s);
        System.out.println("  Complex transformation: " + complex);
        
        System.out.println();
    }
    
    /**
     * Demonstrates conditional operations
     */
    private static void demonstrateConditionalOperations() {
        System.out.println("5. Conditional Operations:");
        System.out.println("=========================");
        
        java.util.Optional<String> presentOptional = java.util.Optional.of("Present Value");
        java.util.Optional<String> emptyOptional = java.util.Optional.empty();
        
        // ifPresent() - executes action if value is present
        System.out.println("Using ifPresent():");
        presentOptional.ifPresent(value -> System.out.println("  Value is present: " + value));
        emptyOptional.ifPresent(value -> System.out.println("  This won't be printed"));
        
        // ifPresentOrElse() - executes different actions based on presence
        System.out.println("\nUsing ifPresentOrElse():");
        presentOptional.ifPresentOrElse(
            value -> System.out.println("  Value is present: " + value),
            () -> System.out.println("  Value is not present")
        );
        
        emptyOptional.ifPresentOrElse(
            value -> System.out.println("  This won't be printed"),
            () -> System.out.println("  Value is not present")
        );
        
        // Conditional operations with side effects
        System.out.println("\nConditional operations with side effects:");
        presentOptional.ifPresent(value -> {
            System.out.println("  Processing value: " + value);
            // Simulate some processing
            System.out.println("  Value processed successfully");
        });
        
        emptyOptional.ifPresentOrElse(
            value -> System.out.println("  Processing value: " + value),
            () -> System.out.println("  No value to process")
        );
        
        System.out.println();
    }
    
    /**
     * Demonstrates Optional chaining
     */
    private static void demonstrateOptionalChaining() {
        System.out.println("6. Optional Chaining:");
        System.out.println("====================");
        
        // Chaining multiple Optional operations
        System.out.println("Chaining multiple operations:");
        java.util.Optional<String> result = java.util.Optional.of("  hello world  ")
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .map(String::toUpperCase)
            .map(s -> s.replace(" ", "_"))
            .map(s -> "PREFIX_" + s);
        
        System.out.println("  Chained result: " + result);
        
        // Chaining with flatMap
        System.out.println("\nChaining with flatMap:");
        java.util.Optional<String> flatMapResult = java.util.Optional.of("test")
            .flatMap(s -> java.util.Optional.of(s.toUpperCase()))
            .flatMap(s -> java.util.Optional.of(s + "_SUFFIX"));
        
        System.out.println("  FlatMap chained result: " + flatMapResult);
        
        // Chaining with conditional operations
        System.out.println("\nChaining with conditional operations:");
        java.util.Optional.of("  hello world  ")
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .ifPresent(value -> {
                System.out.println("  Processing chained value: " + value);
                System.out.println("  Value length: " + value.length());
            });
        
        // Complex chaining example
        System.out.println("\nComplex chaining example:");
        java.util.Optional<String> complexResult = java.util.Optional.of("  hello world  ")
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .map(String::toUpperCase)
            .map(s -> s.replace(" ", "_"))
            .map(s -> "PREFIX_" + s)
            .filter(s -> s.length() > 10)
            .map(s -> s + "_SUFFIX");
        
        System.out.println("  Complex chained result: " + complexResult);
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("7. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: User service with Optional
        System.out.println("Example 1: User Service with Optional");
        System.out.println("------------------------------------");
        
        UserService userService = new UserService();
        
        // Find user by ID
        java.util.Optional<User> user = userService.findUserById(1);
        user.ifPresent(u -> System.out.println("Found user: " + u.getName()));
        
        java.util.Optional<User> userNotFound = userService.findUserById(999);
        userNotFound.ifPresentOrElse(
            u -> System.out.println("Found user: " + u.getName()),
            () -> System.out.println("User not found")
        );
        
        // Get user email safely
        String email = userService.findUserById(1)
            .map(User::getEmail)
            .orElse("No email available");
        System.out.println("User email: " + email);
        
        // Example 2: Configuration with Optional
        System.out.println("\nExample 2: Configuration with Optional");
        System.out.println("-------------------------------------");
        
        Configuration config = new Configuration();
        
        String dbHost = config.getDatabaseHost()
            .orElse("localhost");
        System.out.println("Database host: " + dbHost);
        
        int dbPort = config.getDatabasePort()
            .orElse(3306);
        System.out.println("Database port: " + dbPort);
        
        // Example 3: File processing with Optional
        System.out.println("\nExample 3: File Processing with Optional");
        System.out.println("---------------------------------------");
        
        FileProcessor processor = new FileProcessor();
        
        java.util.Optional<String> content = processor.readFile("test.txt");
        content.ifPresent(c -> {
            System.out.println("File content length: " + c.length());
            System.out.println("First 50 characters: " + c.substring(0, Math.min(50, c.length())));
        });
        
        // Example 4: API response handling
        System.out.println("\nExample 4: API Response Handling");
        System.out.println("--------------------------------");
        
        ApiClient apiClient = new ApiClient();
        
        java.util.Optional<ApiResponse> response = apiClient.getUserData(1);
        response.ifPresent(r -> {
            System.out.println("API Response: " + r.getData());
            System.out.println("Status: " + r.getStatus());
        });
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("8. Best Practices:");
        System.out.println("=================");
        
        System.out.println("Optional Best Practices:");
        System.out.println("----------------------");
        System.out.println("1. Use Optional for return types, not parameters");
        System.out.println("2. Don't use Optional for collections (use empty collections instead)");
        System.out.println("3. Don't use Optional for primitive types (use OptionalInt, OptionalLong, etc.)");
        System.out.println("4. Use Optional.of() for non-null values, Optional.ofNullable() for nullable values");
        System.out.println("5. Use orElse() for simple defaults, orElseGet() for expensive defaults");
        System.out.println("6. Use map() for transformations, flatMap() for nested Optionals");
        System.out.println("7. Use filter() for conditional operations");
        System.out.println("8. Use ifPresent() for side effects, avoid get() when possible");
        
        System.out.println("\nCommon Mistakes:");
        System.out.println("---------------");
        System.out.println("• Using Optional.get() without checking isPresent()");
        System.out.println("• Using Optional.of() with null values");
        System.out.println("• Using Optional for collections");
        System.out.println("• Using Optional for primitive types");
        System.out.println("• Overusing Optional in method parameters");
        System.out.println("• Not handling empty Optional cases");
        
        System.out.println("\nPerformance Considerations:");
        System.out.println("-------------------------");
        System.out.println("• Optional has minimal performance overhead");
        System.out.println("• Use orElseGet() instead of orElse() for expensive operations");
        System.out.println("• Avoid creating Optional objects in loops");
        System.out.println("• Consider using OptionalInt, OptionalLong for primitives");
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Optional provides null-safe operations");
        System.out.println("• Use Optional for return types to indicate absence of values");
        System.out.println("• Chain operations with map(), flatMap(), and filter()");
        System.out.println("• Use conditional operations for side effects");
        System.out.println("• Follow best practices for effective Optional usage");
        System.out.println("• Avoid common mistakes and performance pitfalls");
        System.out.println("• Optional makes code more readable and less error-prone");
    }
    
    // Helper methods for demonstration
    
    private static java.util.Optional<String> findUserById(int id) {
        if (id == 1) {
            return java.util.Optional.of("John Doe");
        }
        return java.util.Optional.empty();
    }
    
    // Inner classes for demonstration
    
    static class User {
        private String name;
        private String email;
        
        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
        
        public String getName() { return name; }
        public String getEmail() { return email; }
        
        @Override
        public String toString() {
            return "User{name='" + name + "', email='" + email + "'}";
        }
    }
    
    static class UserService {
        private java.util.Map<Integer, User> users = new java.util.HashMap<>();
        
        public UserService() {
            users.put(1, new User("John Doe", "john@example.com"));
            users.put(2, new User("Jane Smith", "jane@example.com"));
        }
        
        public java.util.Optional<User> findUserById(int id) {
            return java.util.Optional.ofNullable(users.get(id));
        }
    }
    
    static class Configuration {
        private java.util.Map<String, String> config = new java.util.HashMap<>();
        
        public Configuration() {
            config.put("db.host", "localhost");
            config.put("db.port", "3306");
        }
        
        public java.util.Optional<String> getDatabaseHost() {
            return java.util.Optional.ofNullable(config.get("db.host"));
        }
        
        public java.util.Optional<Integer> getDatabasePort() {
            String port = config.get("db.port");
            if (port != null) {
                try {
                    return java.util.Optional.of(Integer.parseInt(port));
                } catch (NumberFormatException e) {
                    return java.util.Optional.empty();
                }
            }
            return java.util.Optional.empty();
        }
    }
    
    static class FileProcessor {
        public java.util.Optional<String> readFile(String filename) {
            // Simulate file reading
            if ("test.txt".equals(filename)) {
                return java.util.Optional.of("This is test file content");
            }
            return java.util.Optional.empty();
        }
    }
    
    static class ApiResponse {
        private String data;
        private int status;
        
        public ApiResponse(String data, int status) {
            this.data = data;
            this.status = status;
        }
        
        public String getData() { return data; }
        public int getStatus() { return status; }
    }
    
    static class ApiClient {
        public java.util.Optional<ApiResponse> getUserData(int userId) {
            // Simulate API call
            if (userId == 1) {
                return java.util.Optional.of(new ApiResponse("User data", 200));
            }
            return java.util.Optional.empty();
        }
    }
}
