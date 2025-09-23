package com.tutorial.intermediate.arraysstrings;

/**
 * String Demo - Mastering String Operations in Java
 * 
 * This comprehensive tutorial demonstrates the String class in Java,
 * which is one of the most commonly used classes for text manipulation.
 * Strings in Java are immutable objects that provide numerous methods
 * for text processing and manipulation.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what strings are and their immutability
 * - Learn about string creation and initialization
 * - Master string methods for manipulation and comparison
 * - Understand string concatenation and formatting
 * - Learn about string searching and replacement
 * - Practice with real-world string examples
 * - Understand performance considerations with strings
 * 
 * KEY CONCEPTS:
 * 1. String Immutability: Strings cannot be changed after creation
 * 2. String Pool: Memory optimization for string literals
 * 3. String Methods: Built-in methods for string operations
 * 4. String Concatenation: Combining strings using + operator or methods
 * 5. String Comparison: Using equals() vs == operator
 * 6. String Formatting: Using String.format() and printf()
 * 7. Regular Expressions: Pattern matching with strings
 * 
 * @author Java Tutorial Team
 * @version 1.0
 * @since 2024
 */
public class StringDemo {
    
    public static void main(String[] args) {
        System.out.println("=== String Demo ===");
        System.out.println();
        
        // 1. String Creation and Initialization
        demonstrateStringCreation();
        
        // 2. String Immutability
        demonstrateStringImmutability();
        
        // 3. String Methods
        demonstrateStringMethods();
        
        // 4. String Comparison
        demonstrateStringComparison();
        
        // 5. String Concatenation
        demonstrateStringConcatenation();
        
        // 6. String Formatting
        demonstrateStringFormatting();
        
        // 7. String Searching and Manipulation
        demonstrateStringSearchingAndManipulation();
        
        // 8. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 9. Performance Considerations
        demonstratePerformanceConsiderations();
    }
    
    /**
     * Demonstrates different ways to create and initialize strings
     * 
     * This section shows various methods for creating strings
     * and the differences between them.
     */
    private static void demonstrateStringCreation() {
        System.out.println("1. String Creation and Initialization:");
        System.out.println("=====================================");
        
        // Method 1: String literal
        String str1 = "Hello World";
        System.out.println("String literal: " + str1);
        
        // Method 2: Using new keyword
        String str2 = new String("Hello World");
        System.out.println("Using new keyword: " + str2);
        
        // Method 3: From character array
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(chars);
        System.out.println("From char array: " + str3);
        
        // Method 4: From byte array
        byte[] bytes = {72, 101, 108, 108, 111};
        String str4 = new String(bytes);
        System.out.println("From byte array: " + str4);
        
        // Method 5: Empty string
        String str5 = "";
        System.out.println("Empty string: '" + str5 + "'");
        
        // Method 6: Using String.valueOf()
        String str6 = String.valueOf(123);
        System.out.println("String.valueOf(123): " + str6);
        
        // Method 7: Using String.copyValueOf()
        String str7 = String.copyValueOf(chars);
        System.out.println("String.copyValueOf(): " + str7);
        
        // String pool demonstration
        System.out.println("\nString Pool Demonstration:");
        System.out.println("-------------------------");
        
        String pool1 = "Java";
        String pool2 = "Java";
        String pool3 = new String("Java");
        
        System.out.println("pool1 == pool2: " + (pool1 == pool2)); // true (same reference)
        System.out.println("pool1 == pool3: " + (pool1 == pool3)); // false (different references)
        System.out.println("pool1.equals(pool3): " + pool1.equals(pool3)); // true (same content)
        
        System.out.println();
    }
    
    /**
     * Demonstrates string immutability
     * 
     * This section shows how strings are immutable in Java
     * and what happens when we try to modify them.
     */
    private static void demonstrateStringImmutability() {
        System.out.println("2. String Immutability:");
        System.out.println("======================");
        
        String original = "Hello";
        System.out.println("Original string: " + original);
        System.out.println("Original string hash: " + original.hashCode());
        
        // Attempting to modify string
        String modified = original.toUpperCase();
        System.out.println("Modified string: " + modified);
        System.out.println("Modified string hash: " + modified.hashCode());
        System.out.println("Original string unchanged: " + original);
        
        // String concatenation creates new string
        String concatenated = original + " World";
        System.out.println("Concatenated string: " + concatenated);
        System.out.println("Concatenated string hash: " + concatenated.hashCode());
        System.out.println("Original string still unchanged: " + original);
        
        // Demonstrating with references
        System.out.println("\nReference Demonstration:");
        System.out.println("----------------------");
        
        String str1 = "Java";
        String str2 = str1; // str2 points to same object as str1
        
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str1 == str2: " + (str1 == str2));
        
        str1 = str1 + " Programming"; // str1 now points to new object
        System.out.println("After modification:");
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str1 == str2: " + (str1 == str2));
        
        System.out.println();
    }
    
    /**
     * Demonstrates various string methods
     * 
     * This section shows the most commonly used string methods
     * for manipulation and information retrieval.
     */
    private static void demonstrateStringMethods() {
        System.out.println("3. String Methods:");
        System.out.println("=================");
        
        String text = "  Hello World  ";
        System.out.println("Original text: '" + text + "'");
        
        // Length method
        System.out.println("Length: " + text.length());
        
        // Character access
        System.out.println("Character at index 2: " + text.charAt(2));
        
        // Substring methods
        System.out.println("Substring from index 2: " + text.substring(2));
        System.out.println("Substring from 2 to 7: " + text.substring(2, 7));
        
        // Case conversion
        System.out.println("To uppercase: " + text.toUpperCase());
        System.out.println("To lowercase: " + text.toLowerCase());
        
        // Trimming whitespace
        System.out.println("Trimmed: '" + text.trim() + "'");
        
        // String replacement
        System.out.println("Replace 'l' with 'L': " + text.replace('l', 'L'));
        System.out.println("Replace 'World' with 'Java': " + text.replace("World", "Java"));
        
        // String splitting
        String csv = "apple,banana,cherry,date";
        String[] fruits = csv.split(",");
        System.out.println("Split by comma: " + java.util.Arrays.toString(fruits));
        
        // String joining (Java 8+)
        String joined = String.join(" | ", fruits);
        System.out.println("Joined with ' | ': " + joined);
        
        // String checking methods
        System.out.println("\nString Checking Methods:");
        System.out.println("----------------------");
        
        String checkText = "Hello123";
        System.out.println("Is empty: " + checkText.isEmpty());
        System.out.println("Is blank: " + checkText.isBlank());
        System.out.println("Starts with 'Hello': " + checkText.startsWith("Hello"));
        System.out.println("Ends with '123': " + checkText.endsWith("123"));
        System.out.println("Contains 'lo1': " + checkText.contains("lo1"));
        
        // String conversion methods
        System.out.println("\nString Conversion Methods:");
        System.out.println("------------------------");
        
        String numberText = "123";
        System.out.println("String to int: " + Integer.parseInt(numberText));
        System.out.println("String to double: " + Double.parseDouble("123.45"));
        System.out.println("String to boolean: " + Boolean.parseBoolean("true"));
        
        System.out.println();
    }
    
    /**
     * Demonstrates string comparison methods
     * 
     * This section shows different ways to compare strings
     * and the differences between them.
     */
    private static void demonstrateStringComparison() {
        System.out.println("4. String Comparison:");
        System.out.println("====================");
        
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = "HELLO";
        String str5 = "World";
        
        // Using == operator (reference comparison)
        System.out.println("Reference Comparison (==):");
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1 == str3: " + (str1 == str3));
        
        // Using equals() method (content comparison)
        System.out.println("\nContent Comparison (equals()):");
        System.out.println("str1.equals(str2): " + str1.equals(str2));
        System.out.println("str1.equals(str3): " + str1.equals(str3));
        System.out.println("str1.equals(str4): " + str1.equals(str4));
        System.out.println("str1.equals(str5): " + str1.equals(str5));
        
        // Using equalsIgnoreCase() method
        System.out.println("\nCase-insensitive Comparison (equalsIgnoreCase()):");
        System.out.println("str1.equalsIgnoreCase(str4): " + str1.equalsIgnoreCase(str4));
        
        // Using compareTo() method (lexicographic comparison)
        System.out.println("\nLexicographic Comparison (compareTo()):");
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2));
        System.out.println("str1.compareTo(str5): " + str1.compareTo(str5));
        System.out.println("str5.compareTo(str1): " + str5.compareTo(str1));
        
        // Using compareToIgnoreCase() method
        System.out.println("\nCase-insensitive Lexicographic Comparison (compareToIgnoreCase()):");
        System.out.println("str1.compareToIgnoreCase(str4): " + str1.compareToIgnoreCase(str4));
        
        // String comparison with null safety
        System.out.println("\nNull-safe Comparison:");
        String nullString = null;
        String safeString = "Hello";
        
        // Safe comparison
        if (safeString != null && safeString.equals("Hello")) {
            System.out.println("Safe comparison: Strings are equal");
        }
        
        // Using Objects.equals() for null safety
        System.out.println("Objects.equals(null, safeString): " + java.util.Objects.equals(null, safeString));
        System.out.println("Objects.equals(safeString, \"Hello\"): " + java.util.Objects.equals(safeString, "Hello"));
        
        System.out.println();
    }
    
    /**
     * Demonstrates string concatenation methods
     * 
     * This section shows different ways to concatenate strings
     * and their performance implications.
     */
    private static void demonstrateStringConcatenation() {
        System.out.println("5. String Concatenation:");
        System.out.println("=======================");
        
        String str1 = "Hello";
        String str2 = "World";
        
        // Method 1: Using + operator
        String result1 = str1 + " " + str2;
        System.out.println("Using + operator: " + result1);
        
        // Method 2: Using concat() method
        String result2 = str1.concat(" ").concat(str2);
        System.out.println("Using concat() method: " + result2);
        
        // Method 3: Using String.format()
        String result3 = String.format("%s %s", str1, str2);
        System.out.println("Using String.format(): " + result3);
        
        // Method 4: Using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append(str1).append(" ").append(str2);
        String result4 = sb.toString();
        System.out.println("Using StringBuilder: " + result4);
        
        // Method 5: Using String.join()
        String result5 = String.join(" ", str1, str2);
        System.out.println("Using String.join(): " + result5);
        
        // Method 6: Using StringBuffer
        StringBuffer sbf = new StringBuffer();
        sbf.append(str1).append(" ").append(str2);
        String result6 = sbf.toString();
        System.out.println("Using StringBuffer: " + result6);
        
        // Concatenation with different data types
        System.out.println("\nConcatenation with Different Data Types:");
        System.out.println("-------------------------------------");
        
        int number = 42;
        double decimal = 3.14;
        boolean flag = true;
        
        String mixed = str1 + " " + number + " " + decimal + " " + flag;
        System.out.println("Mixed types: " + mixed);
        
        // Concatenation in loops (performance consideration)
        System.out.println("\nConcatenation in Loops:");
        System.out.println("---------------------");
        
        // Inefficient way (creates many temporary objects)
        String inefficient = "";
        for (int i = 0; i < 5; i++) {
            inefficient += "Item" + i + " ";
        }
        System.out.println("Inefficient: " + inefficient);
        
        // Efficient way (using StringBuilder)
        StringBuilder efficient = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            efficient.append("Item").append(i).append(" ");
        }
        System.out.println("Efficient: " + efficient.toString());
        
        System.out.println();
    }
    
    /**
     * Demonstrates string formatting
     * 
     * This section shows how to format strings using
     * various formatting methods and patterns.
     */
    private static void demonstrateStringFormatting() {
        System.out.println("6. String Formatting:");
        System.out.println("====================");
        
        String name = "John";
        int age = 25;
        double salary = 50000.50;
        
        // Using String.format()
        System.out.println("String.format() Examples:");
        System.out.println("----------------------");
        
        String formatted1 = String.format("Name: %s, Age: %d, Salary: $%.2f", name, age, salary);
        System.out.println(formatted1);
        
        String formatted2 = String.format("Hello %s, you are %d years old", name, age);
        System.out.println(formatted2);
        
        // Using printf()
        System.out.println("\nprintf() Examples:");
        System.out.println("-----------------");
        
        System.out.printf("Name: %s, Age: %d, Salary: $%.2f%n", name, age, salary);
        System.out.printf("Hello %s, you are %d years old%n", name, age);
        
        // Format specifiers
        System.out.println("\nFormat Specifiers:");
        System.out.println("----------------");
        
        int number = 12345;
        double decimal = 123.456789;
        
        System.out.printf("Integer: %d%n", number);
        System.out.printf("Integer with padding: %08d%n", number);
        System.out.printf("Float: %.2f%n", decimal);
        System.out.printf("Float with padding: %10.2f%n", decimal);
        System.out.printf("String: %s%n", name);
        System.out.printf("String with padding: %10s%n", name);
        System.out.printf("Boolean: %b%n", true);
        System.out.printf("Character: %c%n", 'A');
        System.out.printf("Hexadecimal: %x%n", number);
        System.out.printf("Octal: %o%n", number);
        
        // Date and time formatting
        System.out.println("\nDate and Time Formatting:");
        System.out.println("------------------------");
        
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        System.out.printf("Date: %tY-%tm-%td%n", now, now, now);
        System.out.printf("Time: %tH:%tM:%tS%n", now, now, now);
        System.out.printf("DateTime: %tY-%tm-%td %tH:%tM:%tS%n", now, now, now, now, now, now);
        
        // Using MessageFormat for complex formatting
        System.out.println("\nMessageFormat Examples:");
        System.out.println("---------------------");
        
        String pattern = "Hello {0}, you have {1} messages and {2} unread emails";
        String message = java.text.MessageFormat.format(pattern, "Alice", 5, 2);
        System.out.println(message);
        
        System.out.println();
    }
    
    /**
     * Demonstrates string searching and manipulation
     * 
     * This section shows methods for searching within strings
     * and manipulating string content.
     */
    private static void demonstrateStringSearchingAndManipulation() {
        System.out.println("7. String Searching and Manipulation:");
        System.out.println("====================================");
        
        String text = "Hello World, Hello Java, Hello Programming";
        System.out.println("Original text: " + text);
        
        // Searching methods
        System.out.println("\nSearching Methods:");
        System.out.println("-----------------");
        
        System.out.println("Index of 'Hello': " + text.indexOf("Hello"));
        System.out.println("Last index of 'Hello': " + text.lastIndexOf("Hello"));
        System.out.println("Index of 'Hello' from position 10: " + text.indexOf("Hello", 10));
        System.out.println("Contains 'Java': " + text.contains("Java"));
        System.out.println("Starts with 'Hello': " + text.startsWith("Hello"));
        System.out.println("Ends with 'Programming': " + text.endsWith("Programming"));
        
        // Character searching
        System.out.println("\nCharacter Searching:");
        System.out.println("------------------");
        
        System.out.println("Index of 'W': " + text.indexOf('W'));
        System.out.println("Last index of 'o': " + text.lastIndexOf('o'));
        System.out.println("Index of 'o' from position 5: " + text.indexOf('o', 5));
        
        // String manipulation
        System.out.println("\nString Manipulation:");
        System.out.println("------------------");
        
        String manipulated = text.replace("Hello", "Hi");
        System.out.println("Replace 'Hello' with 'Hi': " + manipulated);
        
        String replaced = text.replaceFirst("Hello", "Hi");
        System.out.println("Replace first 'Hello' with 'Hi': " + replaced);
        
        String[] parts = text.split(", ");
        System.out.println("Split by ', ': " + java.util.Arrays.toString(parts));
        
        String trimmed = "  Hello World  ".trim();
        System.out.println("Trimmed: '" + trimmed + "'");
        
        // Regular expressions
        System.out.println("\nRegular Expressions:");
        System.out.println("------------------");
        
        String email = "user@example.com";
        String phone = "123-456-7890";
        String date = "2024-01-15";
        
        // Email validation
        boolean isValidEmail = email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        System.out.println("Valid email: " + isValidEmail);
        
        // Phone validation
        boolean isValidPhone = phone.matches("\\d{3}-\\d{3}-\\d{4}");
        System.out.println("Valid phone: " + isValidPhone);
        
        // Date validation
        boolean isValidDate = date.matches("\\d{4}-\\d{2}-\\d{2}");
        System.out.println("Valid date: " + isValidDate);
        
        // String replacement with regex
        String textWithNumbers = "I have 5 apples and 10 oranges";
        String replacedNumbers = textWithNumbers.replaceAll("\\d+", "X");
        System.out.println("Replace numbers with X: " + replacedNumbers);
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples of string usage
     * 
     * This section shows practical examples of how strings
     * are used in real-world applications.
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("8. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: User Input Validation
        System.out.println("Example 1: User Input Validation");
        System.out.println("--------------------------------");
        
        String userInput = "  john.doe@example.com  ";
        System.out.println("User input: '" + userInput + "'");
        
        // Clean and validate input
        String cleanedInput = userInput.trim().toLowerCase();
        System.out.println("Cleaned input: '" + cleanedInput + "'");
        
        boolean isValid = cleanedInput.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        System.out.println("Is valid email: " + isValid);
        
        // Example 2: Text Processing
        System.out.println("\nExample 2: Text Processing");
        System.out.println("-------------------------");
        
        String document = "The quick brown fox jumps over the lazy dog. The fox is very quick.";
        System.out.println("Document: " + document);
        
        // Word count
        String[] words = document.split("\\s+");
        System.out.println("Word count: " + words.length);
        
        // Find most common word
        java.util.Map<String, Integer> wordCount = new java.util.HashMap<>();
        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        String mostCommon = wordCount.entrySet().stream()
                .max(java.util.Map.Entry.comparingByValue())
                .map(java.util.Map.Entry::getKey)
                .orElse("None");
        
        System.out.println("Most common word: " + mostCommon);
        
        // Example 3: Data Parsing
        System.out.println("\nExample 3: Data Parsing");
        System.out.println("----------------------");
        
        String csvData = "John,25,Engineer,50000\nJane,30,Manager,60000\nBob,35,Developer,55000";
        System.out.println("CSV Data: " + csvData);
        
        String[] lines = csvData.split("\n");
        System.out.println("Parsed data:");
        for (String line : lines) {
            String[] fields = line.split(",");
            System.out.printf("Name: %s, Age: %s, Job: %s, Salary: %s%n", 
                    fields[0], fields[1], fields[2], fields[3]);
        }
        
        // Example 4: URL Processing
        System.out.println("\nExample 4: URL Processing");
        System.out.println("------------------------");
        
        String url = "https://www.example.com:8080/path/to/resource?param1=value1&param2=value2";
        System.out.println("URL: " + url);
        
        // Extract protocol
        String protocol = url.substring(0, url.indexOf("://"));
        System.out.println("Protocol: " + protocol);
        
        // Extract domain
        String domain = url.substring(url.indexOf("://") + 3);
        domain = domain.substring(0, domain.indexOf("/"));
        System.out.println("Domain: " + domain);
        
        // Extract path
        String path = url.substring(url.indexOf(domain) + domain.length());
        if (path.contains("?")) {
            path = path.substring(0, path.indexOf("?"));
        }
        System.out.println("Path: " + path);
        
        // Example 5: Password Validation
        System.out.println("\nExample 5: Password Validation");
        System.out.println("------------------------------");
        
        String password = "MySecure123!";
        System.out.println("Password: " + password);
        
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
        boolean hasMinLength = password.length() >= 8;
        
        System.out.println("Has uppercase: " + hasUpperCase);
        System.out.println("Has lowercase: " + hasLowerCase);
        System.out.println("Has digit: " + hasDigit);
        System.out.println("Has special character: " + hasSpecialChar);
        System.out.println("Has minimum length: " + hasMinLength);
        
        boolean isValidPassword = hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar && hasMinLength;
        System.out.println("Is valid password: " + isValidPassword);
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance considerations with strings
     * 
     * This section shows performance implications of different
     * string operations and best practices.
     */
    private static void demonstratePerformanceConsiderations() {
        System.out.println("9. Performance Considerations:");
        System.out.println("=============================");
        
        // String concatenation performance
        System.out.println("String Concatenation Performance:");
        System.out.println("--------------------------------");
        
        // Inefficient concatenation in loop
        long startTime = System.currentTimeMillis();
        String inefficient = "";
        for (int i = 0; i < 1000; i++) {
            inefficient += "Item" + i + " ";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Inefficient concatenation time: " + (endTime - startTime) + "ms");
        
        // Efficient concatenation using StringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder efficient = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            efficient.append("Item").append(i).append(" ");
        }
        String efficientResult = efficient.toString();
        endTime = System.currentTimeMillis();
        System.out.println("Efficient concatenation time: " + (endTime - startTime) + "ms");
        
        // String comparison performance
        System.out.println("\nString Comparison Performance:");
        System.out.println("-----------------------------");
        
        String str1 = "Hello World";
        String str2 = "Hello World";
        String str3 = new String("Hello World");
        
        // Reference comparison (fastest)
        startTime = System.nanoTime();
        boolean refComparison = (str1 == str2);
        endTime = System.nanoTime();
        System.out.println("Reference comparison time: " + (endTime - startTime) + "ns");
        
        // Content comparison
        startTime = System.nanoTime();
        boolean contentComparison = str1.equals(str2);
        endTime = System.nanoTime();
        System.out.println("Content comparison time: " + (endTime - startTime) + "ns");
        
        // String method performance
        System.out.println("\nString Method Performance:");
        System.out.println("-------------------------");
        
        String text = "Hello World";
        
        // charAt() vs substring()
        startTime = System.nanoTime();
        char charAt = text.charAt(0);
        endTime = System.nanoTime();
        System.out.println("charAt() time: " + (endTime - startTime) + "ns");
        
        startTime = System.nanoTime();
        String substring = text.substring(0, 1);
        endTime = System.nanoTime();
        System.out.println("substring() time: " + (endTime - startTime) + "ns");
        
        // Best practices
        System.out.println("\nBest Practices:");
        System.out.println("--------------");
        System.out.println("• Use StringBuilder for multiple concatenations");
        System.out.println("• Use StringBuffer for thread-safe operations");
        System.out.println("• Use == for reference comparison, equals() for content");
        System.out.println("• Use charAt() instead of substring() for single characters");
        System.out.println("• Use String.join() for joining collections");
        System.out.println("• Use String.format() for complex formatting");
        System.out.println("• Use regular expressions for pattern matching");
        System.out.println("• Consider string interning for frequently used strings");
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Strings are immutable objects in Java");
        System.out.println("• String literals are stored in string pool for memory optimization");
        System.out.println("• Use appropriate string methods for different operations");
        System.out.println("• Be aware of performance implications of string operations");
        System.out.println("• Use StringBuilder for efficient string concatenation");
        System.out.println("• Use equals() for content comparison, == for reference comparison");
        System.out.println("• String formatting provides powerful text formatting capabilities");
        System.out.println("• Regular expressions enable complex pattern matching");
    }
}
