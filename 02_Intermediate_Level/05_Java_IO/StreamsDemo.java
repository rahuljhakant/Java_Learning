package com.tutorial.intermediate.io;

/**
 * Streams Demo - Mastering Java I/O Streams
 * 
 * This comprehensive tutorial demonstrates Java I/O Streams, which provide
 * a way to read from and write to various data sources and destinations.
 * Streams are essential for file operations, network communication, and
 * data processing in Java applications.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what streams are and how they work
 * - Learn about different types of streams (byte vs character)
 * - Master input and output stream operations
 * - Practice with file reading and writing
 * - Learn about buffered streams for performance
 * - Understand stream chaining and filtering
 * - Learn about stream best practices
 * 
 * KEY CONCEPTS:
 * 1. Stream Types: Byte streams vs Character streams
 * 2. Input Streams: Reading data from sources
 * 3. Output Streams: Writing data to destinations
 * 4. Buffered Streams: Improving performance with buffering
 * 5. Stream Chaining: Combining multiple streams
 * 6. Exception Handling: Proper stream exception handling
 * 7. Resource Management: Try-with-resources for automatic cleanup
 * 8. Performance: Optimizing stream operations
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
public class StreamsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Streams Demo ===");
        System.out.println();
        
        // 1. Basic File Reading and Writing
        demonstrateBasicFileOperations();
        
        // 2. Character Streams
        demonstrateCharacterStreams();
        
        // 3. Buffered Streams
        demonstrateBufferedStreams();
        
        // 4. Stream Chaining
        demonstrateStreamChaining();
        
        // 5. Exception Handling
        demonstrateExceptionHandling();
        
        // 6. Try-with-Resources
        demonstrateTryWithResources();
        
        // 7. Performance Comparison
        demonstratePerformanceComparison();
        
        // 8. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 9. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic file operations
     */
    private static void demonstrateBasicFileOperations() {
        System.out.println("1. Basic File Operations:");
        System.out.println("========================");
        
        // Create a test file
        String fileName = "test.txt";
        String content = "Hello, World!\nThis is a test file.\nJava I/O Streams Demo.";
        
        try {
            // Write to file using FileOutputStream
            System.out.println("Writing to file: " + fileName);
            java.io.FileOutputStream fos = new java.io.FileOutputStream(fileName);
            fos.write(content.getBytes());
            fos.close();
            System.out.println("File written successfully");
            
            // Read from file using FileInputStream
            System.out.println("\nReading from file: " + fileName);
            java.io.FileInputStream fis = new java.io.FileInputStream(fileName);
            int byteData;
            System.out.print("File content: ");
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData);
            }
            fis.close();
            System.out.println("\nFile read successfully");
            
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates character streams
     */
    private static void demonstrateCharacterStreams() {
        System.out.println("2. Character Streams:");
        System.out.println("====================");
        
        String fileName = "character_test.txt";
        String content = "Character streams handle text data efficiently.\n" +
                        "They automatically handle character encoding.\n" +
                        "Perfect for reading and writing text files.";
        
        try {
            // Write using FileWriter
            System.out.println("Writing using FileWriter:");
            java.io.FileWriter writer = new java.io.FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("File written successfully");
            
            // Read using FileReader
            System.out.println("\nReading using FileReader:");
            java.io.FileReader reader = new java.io.FileReader(fileName);
            int charData;
            System.out.print("File content: ");
            while ((charData = reader.read()) != -1) {
                System.out.print((char) charData);
            }
            reader.close();
            System.out.println("\nFile read successfully");
            
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates buffered streams
     */
    private static void demonstrateBufferedStreams() {
        System.out.println("3. Buffered Streams:");
        System.out.println("===================");
        
        String fileName = "buffered_test.txt";
        String content = "Buffered streams improve performance by reducing I/O operations.\n" +
                        "They read/write data in chunks instead of byte by byte.\n" +
                        "This is especially beneficial for large files.";
        
        try {
            // Write using BufferedWriter
            System.out.println("Writing using BufferedWriter:");
            java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(fileName));
            writer.write(content);
            writer.close();
            System.out.println("File written successfully");
            
            // Read using BufferedReader
            System.out.println("\nReading using BufferedReader:");
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(fileName));
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
            reader.close();
            System.out.println("File read successfully");
            
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates stream chaining
     */
    private static void demonstrateStreamChaining() {
        System.out.println("4. Stream Chaining:");
        System.out.println("==================");
        
        String fileName = "chained_test.txt";
        String content = "Stream chaining allows combining multiple streams.\n" +
                        "This provides powerful data processing capabilities.\n" +
                        "Example: FileInputStream -> BufferedInputStream -> DataInputStream";
        
        try {
            // Write using chained streams
            System.out.println("Writing using chained streams:");
            java.io.DataOutputStream dos = new java.io.DataOutputStream(
                new java.io.BufferedOutputStream(
                    new java.io.FileOutputStream(fileName)));
            
            dos.writeUTF(content);
            dos.close();
            System.out.println("File written successfully");
            
            // Read using chained streams
            System.out.println("\nReading using chained streams:");
            java.io.DataInputStream dis = new java.io.DataInputStream(
                new java.io.BufferedInputStream(
                    new java.io.FileInputStream(fileName)));
            
            String readContent = dis.readUTF();
            dis.close();
            System.out.println("File content:");
            System.out.println("  " + readContent);
            System.out.println("File read successfully");
            
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates exception handling
     */
    private static void demonstrateExceptionHandling() {
        System.out.println("5. Exception Handling:");
        System.out.println("=====================");
        
        String fileName = "nonexistent.txt";
        
        try {
            // Attempt to read from non-existent file
            System.out.println("Attempting to read from non-existent file: " + fileName);
            java.io.FileInputStream fis = new java.io.FileInputStream(fileName);
            int data = fis.read();
            fis.close();
            System.out.println("Data read: " + data);
            
        } catch (java.io.FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (java.io.IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
        
        // Demonstrate proper exception handling
        System.out.println("\nProper exception handling:");
        String validFileName = "valid_test.txt";
        String content = "This file exists and can be read safely.";
        
        try {
            // Write to file
            java.io.FileWriter writer = new java.io.FileWriter(validFileName);
            writer.write(content);
            writer.close();
            System.out.println("File written successfully");
            
            // Read from file
            java.io.FileReader reader = new java.io.FileReader(validFileName);
            int charData;
            System.out.print("File content: ");
            while ((charData = reader.read()) != -1) {
                System.out.print((char) charData);
            }
            reader.close();
            System.out.println("\nFile read successfully");
            
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates try-with-resources
     */
    private static void demonstrateTryWithResources() {
        System.out.println("6. Try-with-Resources:");
        System.out.println("=====================");
        
        String fileName = "try_with_resources_test.txt";
        String content = "Try-with-resources automatically closes streams.\n" +
                        "This prevents resource leaks and ensures proper cleanup.\n" +
                        "It's the recommended way to handle streams in Java.";
        
        // Write using try-with-resources
        System.out.println("Writing using try-with-resources:");
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
            writer.write(content);
            System.out.println("File written successfully");
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Read using try-with-resources
        System.out.println("\nReading using try-with-resources:");
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
            System.out.println("File read successfully");
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Multiple resources in try-with-resources
        System.out.println("\nMultiple resources in try-with-resources:");
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        
        try (java.io.FileReader reader = new java.io.FileReader(inputFile);
             java.io.FileWriter writer = new java.io.FileWriter(outputFile)) {
            
            int charData;
            while ((charData = reader.read()) != -1) {
                writer.write(charData);
            }
            System.out.println("File copied successfully");
            
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance comparison
     */
    private static void demonstratePerformanceComparison() {
        System.out.println("7. Performance Comparison:");
        System.out.println("=========================");
        
        String fileName = "performance_test.txt";
        String content = "This is a performance test file. ".repeat(1000);
        
        // Test 1: FileOutputStream vs BufferedOutputStream
        System.out.println("Test 1: FileOutputStream vs BufferedOutputStream");
        
        // FileOutputStream
        long startTime = System.currentTimeMillis();
        try (java.io.FileOutputStream fos = new java.io.FileOutputStream(fileName + "_1")) {
            fos.write(content.getBytes());
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("FileOutputStream time: " + (endTime - startTime) + "ms");
        
        // BufferedOutputStream
        startTime = System.currentTimeMillis();
        try (java.io.BufferedOutputStream bos = new java.io.BufferedOutputStream(
                new java.io.FileOutputStream(fileName + "_2"))) {
            bos.write(content.getBytes());
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        endTime = System.currentTimeMillis();
        System.out.println("BufferedOutputStream time: " + (endTime - startTime) + "ms");
        
        // Test 2: FileReader vs BufferedReader
        System.out.println("\nTest 2: FileReader vs BufferedReader");
        
        // FileReader
        startTime = System.currentTimeMillis();
        try (java.io.FileReader reader = new java.io.FileReader(fileName + "_1")) {
            int charData;
            while ((charData = reader.read()) != -1) {
                // Just reading, not processing
            }
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        endTime = System.currentTimeMillis();
        System.out.println("FileReader time: " + (endTime - startTime) + "ms");
        
        // BufferedReader
        startTime = System.currentTimeMillis();
        try (java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.FileReader(fileName + "_2"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Just reading, not processing
            }
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        endTime = System.currentTimeMillis();
        System.out.println("BufferedReader time: " + (endTime - startTime) + "ms");
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("8. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: Configuration file reader
        System.out.println("Example 1: Configuration File Reader");
        System.out.println("-----------------------------------");
        
        String configFile = "config.properties";
        String configContent = "app.name=MyApplication\n" +
                              "app.version=1.0.0\n" +
                              "database.host=localhost\n" +
                              "database.port=3306\n" +
                              "debug.enabled=true";
        
        try (java.io.FileWriter writer = new java.io.FileWriter(configFile)) {
            writer.write(configContent);
            System.out.println("Configuration file created");
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Read configuration
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(configFile))) {
            String line;
            System.out.println("Configuration content:");
            while ((line = reader.readLine()) != null) {
                if (line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    System.out.println("  " + parts[0] + " = " + parts[1]);
                }
            }
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Example 2: Log file writer
        System.out.println("\nExample 2: Log File Writer");
        System.out.println("-------------------------");
        
        String logFile = "application.log";
        String[] logEntries = {
            "2024-01-01 10:00:00 INFO Application started",
            "2024-01-01 10:01:00 DEBUG Loading configuration",
            "2024-01-01 10:02:00 INFO Database connection established",
            "2024-01-01 10:03:00 WARN Low memory warning",
            "2024-01-01 10:04:00 ERROR Failed to connect to external service"
        };
        
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(logFile, true))) {
            for (String entry : logEntries) {
                writer.write(entry);
                writer.newLine();
            }
            System.out.println("Log entries written successfully");
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Example 3: File backup utility
        System.out.println("\nExample 3: File Backup Utility");
        System.out.println("------------------------------");
        
        String sourceFile = "source.txt";
        String backupFile = "backup.txt";
        String backupContent = "This is the source file content that needs to be backed up.";
        
        // Create source file
        try (java.io.FileWriter writer = new java.io.FileWriter(sourceFile)) {
            writer.write(backupContent);
            System.out.println("Source file created");
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Backup file
        try (java.io.FileInputStream fis = new java.io.FileInputStream(sourceFile);
             java.io.FileOutputStream fos = new java.io.FileOutputStream(backupFile)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("File backed up successfully");
            
        } catch (java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("9. Best Practices:");
        System.out.println("=================");
        
        System.out.println("Stream Best Practices:");
        System.out.println("--------------------");
        System.out.println("1. Always use try-with-resources for automatic resource management");
        System.out.println("2. Use buffered streams for better performance");
        System.out.println("3. Choose the right stream type (byte vs character)");
        System.out.println("4. Handle exceptions properly");
        System.out.println("5. Close streams in finally blocks if not using try-with-resources");
        System.out.println("6. Use appropriate buffer sizes");
        System.out.println("7. Consider using NIO for high-performance I/O");
        System.out.println("8. Test with different file sizes and types");
        
        System.out.println("\nCommon Mistakes:");
        System.out.println("---------------");
        System.out.println("• Forgetting to close streams");
        System.out.println("• Not handling I/O exceptions");
        System.out.println("• Using wrong stream type for data");
        System.out.println("• Not using buffered streams for large files");
        System.out.println("• Ignoring resource leaks");
        
        System.out.println("\nPerformance Tips:");
        System.out.println("---------------");
        System.out.println("• Use buffered streams for better performance");
        System.out.println("• Choose appropriate buffer sizes");
        System.out.println("• Use NIO for high-performance scenarios");
        System.out.println("• Consider memory mapping for large files");
        System.out.println("• Profile your I/O operations");
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Streams provide a way to read from and write to data sources");
        System.out.println("• Use byte streams for binary data, character streams for text");
        System.out.println("• Buffered streams improve performance significantly");
        System.out.println("• Always use try-with-resources for automatic cleanup");
        System.out.println("• Handle exceptions properly");
        System.out.println("• Choose the right stream type for your data");
        System.out.println("• Consider performance implications");
        System.out.println("• Test with different scenarios");
    }
}
