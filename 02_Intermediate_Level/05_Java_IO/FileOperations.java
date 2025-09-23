package com.tutorial.intermediate;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * File Operations Demo
 * 
 * This class demonstrates:
 * - Reading from files
 * - Writing to files
 * - File and directory operations
 * - try-with-resources
 * - Different file reading methods
 * - File metadata operations
 */
public class FileOperations {
    
    public static void main(String[] args) {
        System.out.println("=== File Operations Demo ===");
        System.out.println();
        
        // 1. Basic File Operations
        demonstrateBasicFileOperations();
        
        // 2. Reading Files
        demonstrateReadingFiles();
        
        // 3. Writing Files
        demonstrateWritingFiles();
        
        // 4. Directory Operations
        demonstrateDirectoryOperations();
        
        // 5. File Metadata
        demonstrateFileMetadata();
        
        // 6. NIO File Operations
        demonstrateNIOFileOperations();
        
        // 7. File Filtering and Searching
        demonstrateFileFiltering();
    }
    
    /**
     * Demonstrates basic file operations
     */
    private static void demonstrateBasicFileOperations() {
        System.out.println("1. Basic File Operations:");
        System.out.println("========================");
        
        // Creating File objects
        File file = new File("sample.txt");
        File directory = new File("test_directory");
        
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getPath());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Parent directory: " + file.getParent());
        
        // Checking file properties
        System.out.println("File exists: " + file.exists());
        System.out.println("Is file: " + file.isFile());
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Can read: " + file.canRead());
        System.out.println("Can write: " + file.canWrite());
        System.out.println("Is hidden: " + file.isHidden());
        
        // File size and timestamps
        if (file.exists()) {
            System.out.println("File size: " + file.length() + " bytes");
            System.out.println("Last modified: " + new Date(file.lastModified()));
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates reading files using different methods
     */
    private static void demonstrateReadingFiles() {
        System.out.println("2. Reading Files:");
        System.out.println("================");
        
        // Create a sample file for reading
        createSampleFile();
        
        // Method 1: FileReader with BufferedReader
        System.out.println("Method 1: FileReader with BufferedReader");
        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        // Method 2: Scanner
        System.out.println("\nMethod 2: Scanner");
        try (Scanner scanner = new Scanner(new File("sample.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println("  " + scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        
        // Method 3: Files.readAllLines (Java 7+)
        System.out.println("\nMethod 3: Files.readAllLines");
        try {
            List<String> lines = Files.readAllLines(Paths.get("sample.txt"));
            for (String line : lines) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        // Method 4: Files.lines (Java 8+)
        System.out.println("\nMethod 4: Files.lines (Stream)");
        try {
            Files.lines(Paths.get("sample.txt"))
                 .forEach(line -> System.out.println("  " + line));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        // Method 5: Reading binary file
        System.out.println("\nMethod 5: Reading binary file");
        try (FileInputStream fis = new FileInputStream("sample.txt")) {
            int byteRead;
            System.out.print("  Binary content (first 20 bytes): ");
            int count = 0;
            while ((byteRead = fis.read()) != -1 && count < 20) {
                System.out.print(byteRead + " ");
                count++;
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading binary file: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates writing files using different methods
     */
    private static void demonstrateWritingFiles() {
        System.out.println("3. Writing Files:");
        System.out.println("================");
        
        // Method 1: FileWriter with BufferedWriter
        System.out.println("Method 1: FileWriter with BufferedWriter");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output1.txt"))) {
            writer.write("Hello, World!");
            writer.newLine();
            writer.write("This is a test file.");
            writer.newLine();
            writer.write("Written using BufferedWriter.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        
        // Method 2: PrintWriter
        System.out.println("Method 2: PrintWriter");
        try (PrintWriter writer = new PrintWriter(new FileWriter("output2.txt"))) {
            writer.println("Hello, World!");
            writer.println("This is a test file.");
            writer.println("Written using PrintWriter.");
            writer.printf("Number: %d, String: %s%n", 42, "test");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        
        // Method 3: Files.write (Java 7+)
        System.out.println("Method 3: Files.write");
        try {
            List<String> lines = Arrays.asList(
                "Hello, World!",
                "This is a test file.",
                "Written using Files.write."
            );
            Files.write(Paths.get("output3.txt"), lines);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        
        // Method 4: Writing binary file
        System.out.println("Method 4: Writing binary file");
        try (FileOutputStream fos = new FileOutputStream("output4.bin")) {
            byte[] data = {72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33};
            fos.write(data);
        } catch (IOException e) {
            System.out.println("Error writing binary file: " + e.getMessage());
        }
        
        // Method 5: Appending to file
        System.out.println("Method 5: Appending to file");
        try (FileWriter writer = new FileWriter("output1.txt", true)) {
            writer.write("\nThis line was appended.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates directory operations
     */
    private static void demonstrateDirectoryOperations() {
        System.out.println("4. Directory Operations:");
        System.out.println("=======================");
        
        // Creating directories
        File dir = new File("test_directory");
        if (!dir.exists()) {
            boolean created = dir.mkdir();
            System.out.println("Directory created: " + created);
        }
        
        // Creating nested directories
        File nestedDir = new File("test_directory/nested/subdir");
        if (!nestedDir.exists()) {
            boolean created = nestedDir.mkdirs();
            System.out.println("Nested directories created: " + created);
        }
        
        // Listing directory contents
        System.out.println("\nDirectory contents:");
        if (dir.exists() && dir.isDirectory()) {
            String[] contents = dir.list();
            if (contents != null) {
                for (String item : contents) {
                    System.out.println("  " + item);
                }
            }
        }
        
        // Listing files only
        System.out.println("\nFiles only:");
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles(File::isFile);
            if (files != null) {
                for (File file : files) {
                    System.out.println("  " + file.getName());
                }
            }
        }
        
        // Listing directories only
        System.out.println("\nDirectories only:");
        if (dir.exists() && dir.isDirectory()) {
            File[] dirs = dir.listFiles(File::isDirectory);
            if (dirs != null) {
                for (File directory : dirs) {
                    System.out.println("  " + directory.getName());
                }
            }
        }
        
        // Using FilenameFilter
        System.out.println("\nFiles with .txt extension:");
        if (dir.exists() && dir.isDirectory()) {
            String[] txtFiles = dir.list((dir1, name) -> name.endsWith(".txt"));
            if (txtFiles != null) {
                for (String file : txtFiles) {
                    System.out.println("  " + file);
                }
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates file metadata operations
     */
    private static void demonstrateFileMetadata() {
        System.out.println("5. File Metadata:");
        System.out.println("================");
        
        File file = new File("sample.txt");
        
        if (file.exists()) {
            System.out.println("File name: " + file.getName());
            System.out.println("File path: " + file.getPath());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Canonical path: " + getCanonicalPath(file));
            System.out.println("Parent: " + file.getParent());
            System.out.println("File size: " + file.length() + " bytes");
            System.out.println("Last modified: " + new Date(file.lastModified()));
            System.out.println("Is file: " + file.isFile());
            System.out.println("Is directory: " + file.isDirectory());
            System.out.println("Is absolute: " + file.isAbsolute());
            System.out.println("Can read: " + file.canRead());
            System.out.println("Can write: " + file.canWrite());
            System.out.println("Can execute: " + file.canExecute());
            System.out.println("Is hidden: " + file.isHidden());
            
            // File permissions (Unix-like systems)
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Executable: " + file.canExecute());
        } else {
            System.out.println("File does not exist");
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates NIO file operations
     */
    private static void demonstrateNIOFileOperations() {
        System.out.println("6. NIO File Operations:");
        System.out.println("======================");
        
        // Creating file using NIO
        Path path = Paths.get("nio_sample.txt");
        try {
            Files.createFile(path);
            System.out.println("File created using NIO: " + path);
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
        
        // Writing to file using NIO
        try {
            String content = "Hello from NIO!\nThis is a test file.";
            Files.write(path, content.getBytes());
            System.out.println("Content written using NIO");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        
        // Reading file using NIO
        try {
            byte[] bytes = Files.readAllBytes(path);
            String content = new String(bytes);
            System.out.println("Content read using NIO:");
            System.out.println("  " + content);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        // File attributes using NIO
        try {
            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("File attributes:");
            System.out.println("  Size: " + attrs.size() + " bytes");
            System.out.println("  Created: " + attrs.creationTime());
            System.out.println("  Last accessed: " + attrs.lastAccessTime());
            System.out.println("  Last modified: " + attrs.lastModifiedTime());
            System.out.println("  Is directory: " + attrs.isDirectory());
            System.out.println("  Is regular file: " + attrs.isRegularFile());
        } catch (IOException e) {
            System.out.println("Error reading attributes: " + e.getMessage());
        }
        
        // Copying file using NIO
        try {
            Path copyPath = Paths.get("nio_sample_copy.txt");
            Files.copy(path, copyPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied using NIO");
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
        
        // Moving file using NIO
        try {
            Path movePath = Paths.get("nio_sample_moved.txt");
            Files.move(path, movePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved using NIO");
        } catch (IOException e) {
            System.out.println("Error moving file: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates file filtering and searching
     */
    private static void demonstrateFileFiltering() {
        System.out.println("7. File Filtering and Searching:");
        System.out.println("===============================");
        
        // Create some test files
        createTestFiles();
        
        File currentDir = new File(".");
        
        // Find all .txt files
        System.out.println("All .txt files:");
        File[] txtFiles = currentDir.listFiles((dir, name) -> name.endsWith(".txt"));
        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println("  " + file.getName());
            }
        }
        
        // Find files larger than 100 bytes
        System.out.println("\nFiles larger than 100 bytes:");
        File[] largeFiles = currentDir.listFiles((dir, name) -> {
            File file = new File(dir, name);
            return file.isFile() && file.length() > 100;
        });
        if (largeFiles != null) {
            for (File file : largeFiles) {
                System.out.println("  " + file.getName() + " (" + file.length() + " bytes)");
            }
        }
        
        // Find files modified in the last 24 hours
        System.out.println("\nFiles modified in the last 24 hours:");
        long oneDayAgo = System.currentTimeMillis() - (24 * 60 * 60 * 1000);
        File[] recentFiles = currentDir.listFiles((dir, name) -> {
            File file = new File(dir, name);
            return file.isFile() && file.lastModified() > oneDayAgo;
        });
        if (recentFiles != null) {
            for (File file : recentFiles) {
                System.out.println("  " + file.getName() + " (" + new Date(file.lastModified()) + ")");
            }
        }
        
        // Recursive directory listing
        System.out.println("\nRecursive directory listing:");
        listDirectoryRecursively(currentDir, 0);
        
        System.out.println();
    }
    
    /**
     * Helper method to create a sample file
     */
    private static void createSampleFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("sample.txt"))) {
            writer.println("This is a sample file.");
            writer.println("It contains multiple lines.");
            writer.println("Used for demonstrating file reading operations.");
            writer.println("Line 4: More content here.");
            writer.println("Line 5: Final line of the file.");
        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }
    
    /**
     * Helper method to create test files
     */
    private static void createTestFiles() {
        try {
            Files.write(Paths.get("test1.txt"), "Short content".getBytes());
            Files.write(Paths.get("test2.txt"), "This is a longer content that exceeds 100 bytes to demonstrate file filtering based on size criteria.".getBytes());
            Files.write(Paths.get("test3.log"), "Log file content".getBytes());
        } catch (IOException e) {
            System.out.println("Error creating test files: " + e.getMessage());
        }
    }
    
    /**
     * Helper method to get canonical path safely
     */
    private static String getCanonicalPath(File file) {
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            return "Error getting canonical path: " + e.getMessage();
        }
    }
    
    /**
     * Helper method to list directory recursively
     */
    private static void listDirectoryRecursively(File dir, int depth) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    for (int i = 0; i < depth; i++) {
                        System.out.print("  ");
                    }
                    System.out.println(file.getName());
                    if (file.isDirectory()) {
                        listDirectoryRecursively(file, depth + 1);
                    }
                }
            }
        }
    }
}
