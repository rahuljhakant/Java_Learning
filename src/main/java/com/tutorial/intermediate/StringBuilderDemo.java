package com.tutorial.intermediate;

/**
 * StringBuilder Demo - Mastering String Building in Java
 * 
 * This comprehensive tutorial demonstrates the StringBuilder class in Java,
 * which is a mutable sequence of characters. Unlike String objects,
 * StringBuilder objects can be modified after creation, making them
 * more efficient for string manipulation operations.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what StringBuilder is and why it's important
 * - Learn about StringBuilder vs String performance differences
 * - Master StringBuilder methods for string manipulation
 * - Understand StringBuilder vs StringBuffer differences
 * - Practice with real-world StringBuilder examples
 * - Learn about StringBuilder best practices
 * 
 * KEY CONCEPTS:
 * 1. Mutable vs Immutable: StringBuilder can be modified, String cannot
 * 2. Performance: StringBuilder is more efficient for multiple operations
 * 3. Thread Safety: StringBuilder is not thread-safe, StringBuffer is
 * 4. Capacity Management: StringBuilder automatically manages capacity
 * 5. Method Chaining: StringBuilder methods return the object for chaining
 * 6. Memory Efficiency: StringBuilder reduces memory allocation overhead
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class StringBuilderDemo {
    
    public static void main(String[] args) {
        System.out.println("=== StringBuilder Demo ===");
        System.out.println();
        
        // 1. StringBuilder Basics
        demonstrateStringBuilderBasics();
        
        // 2. StringBuilder vs String Performance
        demonstratePerformanceComparison();
        
        // 3. StringBuilder Methods
        demonstrateStringBuilderMethods();
        
        // 4. StringBuilder vs StringBuffer
        demonstrateStringBuilderVsStringBuffer();
        
        // 5. Capacity Management
        demonstrateCapacityManagement();
        
        // 6. Method Chaining
        demonstrateMethodChaining();
        
        // 7. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 8. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic StringBuilder operations
     * 
     * This section shows how to create and use StringBuilder
     * for basic string operations.
     */
    private static void demonstrateStringBuilderBasics() {
        System.out.println("1. StringBuilder Basics:");
        System.out.println("=======================");
        
        // Creating StringBuilder objects
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("Hello");
        StringBuilder sb3 = new StringBuilder(20); // Initial capacity
        
        System.out.println("Empty StringBuilder: '" + sb1 + "'");
        System.out.println("StringBuilder with initial value: '" + sb2 + "'");
        System.out.println("StringBuilder with initial capacity: '" + sb3 + "'");
        
        // Basic operations
        sb1.append("Hello");
        sb1.append(" ");
        sb1.append("World");
        
        System.out.println("After appending: '" + sb1 + "'");
        System.out.println("Length: " + sb1.length());
        System.out.println("Capacity: " + sb1.capacity());
        
        // Modifying existing StringBuilder
        sb2.append(" World");
        System.out.println("Modified sb2: '" + sb2 + "'");
        
        // Converting to String
        String result = sb1.toString();
        System.out.println("Converted to String: '" + result + "'");
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance comparison between StringBuilder and String
     * 
     * This section shows the performance differences between
     * StringBuilder and String concatenation.
     */
    private static void demonstratePerformanceComparison() {
        System.out.println("2. StringBuilder vs String Performance:");
        System.out.println("======================================");
        
        int iterations = 10000;
        
        // String concatenation performance
        System.out.println("String Concatenation Performance:");
        System.out.println("--------------------------------");
        
        long startTime = System.currentTimeMillis();
        String stringResult = "";
        for (int i = 0; i < iterations; i++) {
            stringResult += "Item" + i + " ";
        }
        long endTime = System.currentTimeMillis();
        long stringTime = endTime - startTime;
        
        System.out.println("String concatenation time: " + stringTime + "ms");
        System.out.println("String result length: " + stringResult.length());
        
        // StringBuilder performance
        System.out.println("\nStringBuilder Performance:");
        System.out.println("-------------------------");
        
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Item").append(i).append(" ");
        }
        String sbResult = sb.toString();
        endTime = System.currentTimeMillis();
        long sbTime = endTime - startTime;
        
        System.out.println("StringBuilder time: " + sbTime + "ms");
        System.out.println("StringBuilder result length: " + sbResult.length());
        
        // Performance comparison
        System.out.println("\nPerformance Comparison:");
        System.out.println("---------------------");
        System.out.println("String concatenation: " + stringTime + "ms");
        System.out.println("StringBuilder: " + sbTime + "ms");
        System.out.println("Performance improvement: " + (stringTime / (double) sbTime) + "x faster");
        
        // Memory usage demonstration
        System.out.println("\nMemory Usage Demonstration:");
        System.out.println("--------------------------");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Force garbage collection
        
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        // String concatenation memory usage
        String memoryTest = "";
        for (int i = 0; i < 1000; i++) {
            memoryTest += "Test" + i + " ";
        }
        
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("String concatenation memory usage: " + (memoryAfter - memoryBefore) + " bytes");
        
        // StringBuilder memory usage
        runtime.gc();
        memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        StringBuilder sbMemory = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sbMemory.append("Test").append(i).append(" ");
        }
        String sbMemoryResult = sbMemory.toString();
        
        memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("StringBuilder memory usage: " + (memoryAfter - memoryBefore) + " bytes");
        
        System.out.println();
    }
    
    /**
     * Demonstrates various StringBuilder methods
     * 
     * This section shows the most commonly used StringBuilder
     * methods for string manipulation.
     */
    private static void demonstrateStringBuilderMethods() {
        System.out.println("3. StringBuilder Methods:");
        System.out.println("========================");
        
        StringBuilder sb = new StringBuilder("Hello World");
        System.out.println("Original: '" + sb + "'");
        
        // append() method
        System.out.println("\nappend() Method:");
        System.out.println("---------------");
        
        sb.append("!");
        System.out.println("After append('!'): '" + sb + "'");
        
        sb.append(" ").append("Java");
        System.out.println("After append(' ').append('Java'): '" + sb + "'");
        
        sb.append(" ").append(2024);
        System.out.println("After append(' ').append(2024): '" + sb + "'");
        
        // insert() method
        System.out.println("\ninsert() Method:");
        System.out.println("---------------");
        
        sb.insert(5, " Beautiful");
        System.out.println("After insert(5, ' Beautiful'): '" + sb + "'");
        
        sb.insert(0, "Welcome to ");
        System.out.println("After insert(0, 'Welcome to '): '" + sb + "'");
        
        // delete() method
        System.out.println("\ndelete() Method:");
        System.out.println("---------------");
        
        sb.delete(0, 11); // Delete "Welcome to "
        System.out.println("After delete(0, 11): '" + sb + "'");
        
        sb.deleteCharAt(sb.length() - 1); // Delete last character
        System.out.println("After deleteCharAt(last): '" + sb + "'");
        
        // replace() method
        System.out.println("\nreplace() Method:");
        System.out.println("----------------");
        
        sb.replace(0, 5, "Hi");
        System.out.println("After replace(0, 5, 'Hi'): '" + sb + "'");
        
        // reverse() method
        System.out.println("\nreverse() Method:");
        System.out.println("----------------");
        
        StringBuilder sbReverse = new StringBuilder("Hello");
        sbReverse.reverse();
        System.out.println("After reverse(): '" + sbReverse + "'");
        
        // setLength() method
        System.out.println("\nsetLength() Method:");
        System.out.println("-----------------");
        
        StringBuilder sbLength = new StringBuilder("Hello World");
        System.out.println("Original length: " + sbLength.length());
        System.out.println("Original: '" + sbLength + "'");
        
        sbLength.setLength(5);
        System.out.println("After setLength(5): '" + sbLength + "'");
        System.out.println("New length: " + sbLength.length());
        
        // ensureCapacity() method
        System.out.println("\nensureCapacity() Method:");
        System.out.println("----------------------");
        
        StringBuilder sbCapacity = new StringBuilder();
        System.out.println("Initial capacity: " + sbCapacity.capacity());
        
        sbCapacity.ensureCapacity(50);
        System.out.println("After ensureCapacity(50): " + sbCapacity.capacity());
        
        // trimToSize() method
        System.out.println("\ntrimToSize() Method:");
        System.out.println("------------------");
        
        StringBuilder sbTrim = new StringBuilder("Hello");
        System.out.println("Before trimToSize - Capacity: " + sbTrim.capacity());
        
        sbTrim.trimToSize();
        System.out.println("After trimToSize - Capacity: " + sbTrim.capacity());
        
        // substring() method
        System.out.println("\nsubstring() Method:");
        System.out.println("-----------------");
        
        StringBuilder sbSubstring = new StringBuilder("Hello World");
        String substring1 = sbSubstring.substring(0, 5);
        String substring2 = sbSubstring.substring(6);
        
        System.out.println("substring(0, 5): '" + substring1 + "'");
        System.out.println("substring(6): '" + substring2 + "'");
        
        // indexOf() and lastIndexOf() methods
        System.out.println("\nindexOf() and lastIndexOf() Methods:");
        System.out.println("----------------------------------");
        
        StringBuilder sbIndex = new StringBuilder("Hello World Hello");
        int index1 = sbIndex.indexOf("Hello");
        int index2 = sbIndex.lastIndexOf("Hello");
        
        System.out.println("indexOf('Hello'): " + index1);
        System.out.println("lastIndexOf('Hello'): " + index2);
        
        System.out.println();
    }
    
    /**
     * Demonstrates differences between StringBuilder and StringBuffer
     * 
     * This section shows the key differences between StringBuilder
     * and StringBuffer classes.
     */
    private static void demonstrateStringBuilderVsStringBuffer() {
        System.out.println("4. StringBuilder vs StringBuffer:");
        System.out.println("===============================");
        
        // StringBuilder (not thread-safe)
        System.out.println("StringBuilder (Not Thread-Safe):");
        System.out.println("-------------------------------");
        
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println("StringBuilder result: '" + sb + "'");
        
        // StringBuffer (thread-safe)
        System.out.println("\nStringBuffer (Thread-Safe):");
        System.out.println("--------------------------");
        
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" World");
        System.out.println("StringBuffer result: '" + sbf + "'");
        
        // Performance comparison
        System.out.println("\nPerformance Comparison:");
        System.out.println("---------------------");
        
        int iterations = 100000;
        
        // StringBuilder performance
        long startTime = System.currentTimeMillis();
        StringBuilder sbPerf = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbPerf.append("Item").append(i).append(" ");
        }
        long endTime = System.currentTimeMillis();
        long sbTime = endTime - startTime;
        
        // StringBuffer performance
        startTime = System.currentTimeMillis();
        StringBuffer sbfPerf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbfPerf.append("Item").append(i).append(" ");
        }
        endTime = System.currentTimeMillis();
        long sbfTime = endTime - startTime;
        
        System.out.println("StringBuilder time: " + sbTime + "ms");
        System.out.println("StringBuffer time: " + sbfTime + "ms");
        System.out.println("StringBuffer overhead: " + (sbfTime - sbTime) + "ms");
        
        // When to use which
        System.out.println("\nWhen to Use Which:");
        System.out.println("----------------");
        System.out.println("Use StringBuilder when:");
        System.out.println("• Single-threaded environment");
        System.out.println("• Performance is critical");
        System.out.println("• No thread safety required");
        
        System.out.println("\nUse StringBuffer when:");
        System.out.println("• Multi-threaded environment");
        System.out.println("• Thread safety is required");
        System.out.println("• Performance is less critical");
        
        System.out.println();
    }
    
    /**
     * Demonstrates capacity management in StringBuilder
     * 
     * This section shows how StringBuilder manages its internal
     * capacity and how to optimize it.
     */
    private static void demonstrateCapacityManagement() {
        System.out.println("5. Capacity Management:");
        System.out.println("=====================");
        
        // Default capacity
        StringBuilder sb1 = new StringBuilder();
        System.out.println("Default capacity: " + sb1.capacity());
        
        // Capacity with initial value
        StringBuilder sb2 = new StringBuilder("Hello");
        System.out.println("Capacity with 'Hello': " + sb2.capacity());
        
        // Capacity with initial capacity
        StringBuilder sb3 = new StringBuilder(50);
        System.out.println("Capacity with initial 50: " + sb3.capacity());
        
        // Capacity growth
        System.out.println("\nCapacity Growth:");
        System.out.println("---------------");
        
        StringBuilder sb4 = new StringBuilder();
        System.out.println("Initial capacity: " + sb4.capacity());
        
        // Add content to trigger capacity growth
        for (int i = 0; i < 20; i++) {
            sb4.append("Item" + i + " ");
            if (i % 5 == 0) {
                System.out.println("After " + (i + 1) + " items - Capacity: " + sb4.capacity());
            }
        }
        
        // Capacity formula
        System.out.println("\nCapacity Growth Formula:");
        System.out.println("----------------------");
        System.out.println("New capacity = (old capacity + 1) * 2");
        System.out.println("This ensures amortized O(1) append operations");
        
        // Manual capacity management
        System.out.println("\nManual Capacity Management:");
        System.out.println("-------------------------");
        
        StringBuilder sb5 = new StringBuilder();
        sb5.ensureCapacity(100);
        System.out.println("After ensureCapacity(100): " + sb5.capacity());
        
        sb5.append("Some content");
        sb5.trimToSize();
        System.out.println("After trimToSize(): " + sb5.capacity());
        
        // Memory optimization tips
        System.out.println("\nMemory Optimization Tips:");
        System.out.println("------------------------");
        System.out.println("• Set initial capacity if you know approximate size");
        System.out.println("• Use trimToSize() when done building to free unused memory");
        System.out.println("• Use ensureCapacity() to avoid multiple capacity expansions");
        System.out.println("• Consider capacity when creating StringBuilder");
        
        System.out.println();
    }
    
    /**
     * Demonstrates method chaining with StringBuilder
     * 
     * This section shows how to chain StringBuilder methods
     * for more concise and readable code.
     */
    private static void demonstrateMethodChaining() {
        System.out.println("6. Method Chaining:");
        System.out.println("==================");
        
        // Basic method chaining
        System.out.println("Basic Method Chaining:");
        System.out.println("--------------------");
        
        StringBuilder sb = new StringBuilder()
                .append("Hello")
                .append(" ")
                .append("World")
                .append("!")
                .insert(5, " Beautiful");
        
        System.out.println("Chained result: '" + sb + "'");
        
        // Complex method chaining
        System.out.println("\nComplex Method Chaining:");
        System.out.println("----------------------");
        
        StringBuilder complex = new StringBuilder()
                .append("Java")
                .append(" ")
                .append("Programming")
                .insert(0, "Welcome to ")
                .append("!")
                .replace(0, 11, "Learning")
                .append(" Language");
        
        System.out.println("Complex chained result: '" + complex + "'");
        
        // Method chaining with different data types
        System.out.println("\nMethod Chaining with Different Data Types:");
        System.out.println("----------------------------------------");
        
        StringBuilder mixed = new StringBuilder()
                .append("User ID: ")
                .append(12345)
                .append(", Name: ")
                .append("John Doe")
                .append(", Age: ")
                .append(25)
                .append(", Salary: $")
                .append(50000.50)
                .append(", Active: ")
                .append(true);
        
        System.out.println("Mixed data types: '" + mixed + "'");
        
        // Method chaining for formatting
        System.out.println("\nMethod Chaining for Formatting:");
        System.out.println("------------------------------");
        
        StringBuilder formatted = new StringBuilder()
                .append("Product: ")
                .append("Laptop")
                .append("\nPrice: $")
                .append(999.99)
                .append("\nQuantity: ")
                .append(2)
                .append("\nTotal: $")
                .append(1999.98);
        
        System.out.println("Formatted output:\n" + formatted);
        
        // Method chaining best practices
        System.out.println("\nMethod Chaining Best Practices:");
        System.out.println("------------------------------");
        System.out.println("• Chain methods that return StringBuilder");
        System.out.println("• Use line breaks for readability with long chains");
        System.out.println("• Group related operations together");
        System.out.println("• Consider breaking very long chains into multiple statements");
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples of StringBuilder usage
     * 
     * This section shows practical examples of how StringBuilder
     * is used in real-world applications.
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("7. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: SQL Query Builder
        System.out.println("Example 1: SQL Query Builder");
        System.out.println("----------------------------");
        
        StringBuilder sql = new StringBuilder()
                .append("SELECT ")
                .append("id, name, email, created_at ")
                .append("FROM users ")
                .append("WHERE active = true ")
                .append("AND created_at > '2024-01-01' ")
                .append("ORDER BY created_at DESC");
        
        System.out.println("SQL Query: " + sql);
        
        // Example 2: HTML Generator
        System.out.println("\nExample 2: HTML Generator");
        System.out.println("------------------------");
        
        StringBuilder html = new StringBuilder()
                .append("<html>\n")
                .append("  <head>\n")
                .append("    <title>User Profile</title>\n")
                .append("  </head>\n")
                .append("  <body>\n")
                .append("    <h1>User Information</h1>\n")
                .append("    <p>Name: John Doe</p>\n")
                .append("    <p>Email: john@example.com</p>\n")
                .append("    <p>Age: 25</p>\n")
                .append("  </body>\n")
                .append("</html>");
        
        System.out.println("HTML Output:\n" + html);
        
        // Example 3: CSV Generator
        System.out.println("\nExample 3: CSV Generator");
        System.out.println("----------------------");
        
        String[][] data = {
                {"Name", "Age", "City", "Salary"},
                {"John Doe", "25", "New York", "50000"},
                {"Jane Smith", "30", "Los Angeles", "60000"},
                {"Bob Johnson", "35", "Chicago", "55000"}
        };
        
        StringBuilder csv = new StringBuilder();
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                csv.append(row[i]);
                if (i < row.length - 1) {
                    csv.append(",");
                }
            }
            csv.append("\n");
        }
        
        System.out.println("CSV Output:\n" + csv);
        
        // Example 4: Log Message Builder
        System.out.println("\nExample 4: Log Message Builder");
        System.out.println("------------------------------");
        
        StringBuilder log = new StringBuilder()
                .append("[")
                .append(java.time.LocalDateTime.now())
                .append("] ")
                .append("INFO ")
                .append("UserService ")
                .append("User login successful ")
                .append("userId=")
                .append(12345)
                .append(" ip=")
                .append("192.168.1.100");
        
        System.out.println("Log Message: " + log);
        
        // Example 5: JSON Builder
        System.out.println("\nExample 5: JSON Builder");
        System.out.println("----------------------");
        
        StringBuilder json = new StringBuilder()
                .append("{\n")
                .append("  \"id\": ")
                .append(12345)
                .append(",\n")
                .append("  \"name\": \"")
                .append("John Doe")
                .append("\",\n")
                .append("  \"email\": \"")
                .append("john@example.com")
                .append("\",\n")
                .append("  \"active\": ")
                .append(true)
                .append(",\n")
                .append("  \"created_at\": \"")
                .append("2024-01-15T10:30:00Z")
                .append("\"\n")
                .append("}");
        
        System.out.println("JSON Output:\n" + json);
        
        // Example 6: Dynamic String Building
        System.out.println("\nExample 6: Dynamic String Building");
        System.out.println("----------------------------------");
        
        StringBuilder dynamic = new StringBuilder("Shopping List:\n");
        String[] items = {"Apples", "Bananas", "Milk", "Bread", "Eggs"};
        
        for (int i = 0; i < items.length; i++) {
            dynamic.append("  ")
                    .append(i + 1)
                    .append(". ")
                    .append(items[i])
                    .append("\n");
        }
        
        dynamic.append("Total items: ")
                .append(items.length);
        
        System.out.println("Dynamic Output:\n" + dynamic);
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices for using StringBuilder
     * 
     * This section shows best practices and common patterns
     * for using StringBuilder effectively.
     */
    private static void demonstrateBestPractices() {
        System.out.println("8. Best Practices:");
        System.out.println("=================");
        
        // Best Practice 1: Use appropriate initial capacity
        System.out.println("Best Practice 1: Use Appropriate Initial Capacity");
        System.out.println("------------------------------------------------");
        
        // Good: Set initial capacity if you know approximate size
        StringBuilder sb1 = new StringBuilder(100);
        sb1.append("This is a long string that will be built incrementally");
        System.out.println("With initial capacity: " + sb1.capacity());
        
        // Bad: Using default capacity for large strings
        StringBuilder sb2 = new StringBuilder();
        sb2.append("This is a long string that will be built incrementally");
        System.out.println("Without initial capacity: " + sb2.capacity());
        
        // Best Practice 2: Use method chaining for readability
        System.out.println("\nBest Practice 2: Use Method Chaining");
        System.out.println("-----------------------------------");
        
        // Good: Method chaining
        StringBuilder chained = new StringBuilder()
                .append("Hello")
                .append(" ")
                .append("World")
                .append("!");
        System.out.println("Chained: '" + chained + "'");
        
        // Bad: Multiple statements
        StringBuilder multiple = new StringBuilder();
        multiple.append("Hello");
        multiple.append(" ");
        multiple.append("World");
        multiple.append("!");
        System.out.println("Multiple statements: '" + multiple + "'");
        
        // Best Practice 3: Use StringBuilder for loops
        System.out.println("\nBest Practice 3: Use StringBuilder for Loops");
        System.out.println("-------------------------------------------");
        
        // Good: StringBuilder in loop
        StringBuilder loopGood = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            loopGood.append("Item").append(i).append(" ");
        }
        System.out.println("StringBuilder in loop: '" + loopGood + "'");
        
        // Bad: String concatenation in loop
        String loopBad = "";
        for (int i = 0; i < 5; i++) {
            loopBad += "Item" + i + " ";
        }
        System.out.println("String concatenation in loop: '" + loopBad + "'");
        
        // Best Practice 4: Use trimToSize() when done
        System.out.println("\nBest Practice 4: Use trimToSize() When Done");
        System.out.println("------------------------------------------");
        
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Hello World");
        System.out.println("Before trimToSize: " + sb3.capacity());
        
        sb3.trimToSize();
        System.out.println("After trimToSize: " + sb3.capacity());
        
        // Best Practice 5: Handle null values
        System.out.println("\nBest Practice 5: Handle Null Values");
        System.out.println("---------------------------------");
        
        String nullString = null;
        StringBuilder sb4 = new StringBuilder();
        
        // Safe null handling
        sb4.append(nullString != null ? nullString : "null");
        System.out.println("Safe null handling: '" + sb4 + "'");
        
        // Best Practice 6: Use StringBuilder for complex formatting
        System.out.println("\nBest Practice 6: Use StringBuilder for Complex Formatting");
        System.out.println("-------------------------------------------------------");
        
        StringBuilder formatted = new StringBuilder()
                .append("User: ")
                .append("John Doe")
                .append("\n")
                .append("ID: ")
                .append(12345)
                .append("\n")
                .append("Status: ")
                .append("Active");
        
        System.out.println("Complex formatting:\n" + formatted);
        
        // Common mistakes to avoid
        System.out.println("\nCommon Mistakes to Avoid:");
        System.out.println("------------------------");
        System.out.println("• Don't use String concatenation in loops");
        System.out.println("• Don't forget to call toString() when converting to String");
        System.out.println("• Don't use StringBuilder for single concatenation");
        System.out.println("• Don't ignore capacity management for large strings");
        System.out.println("• Don't use StringBuilder in multi-threaded environments without synchronization");
        
        // Performance tips
        System.out.println("\nPerformance Tips:");
        System.out.println("---------------");
        System.out.println("• Set initial capacity to avoid multiple expansions");
        System.out.println("• Use trimToSize() when done building to free memory");
        System.out.println("• Use method chaining for better performance");
        System.out.println("• Consider StringBuffer for thread-safe operations");
        System.out.println("• Use StringBuilder for string building, not for string manipulation");
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• StringBuilder is mutable and more efficient than String for multiple operations");
        System.out.println("• Use StringBuilder for string concatenation in loops");
        System.out.println("• Set appropriate initial capacity to avoid multiple expansions");
        System.out.println("• Use method chaining for cleaner and more efficient code");
        System.out.println("• Use trimToSize() when done building to free unused memory");
        System.out.println("• StringBuilder is not thread-safe; use StringBuffer for thread safety");
        System.out.println("• StringBuilder provides better performance than String for multiple operations");
        System.out.println("• Use StringBuilder for complex string building scenarios");
    }
}
