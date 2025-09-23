package com.tutorial.basics;

/**
 * Hello World - Your First Java Program
 * 
 * This is the traditional first program that every programmer writes
 * when learning a new programming language.
 * 
 * Key concepts demonstrated:
 * - Class declaration
 * - Main method (program entry point)
 * - System.out.println() for output
 * - String literals
 * - Comments (single-line and multi-line)
 */
public class HelloWorld {
    
    /**
     * The main method is the entry point of any Java application.
     * 
     * @param args command line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Single-line comment: Print "Hello, World!" to the console
        System.out.println("Hello, World!");
        
        // Print additional information
        System.out.println("Welcome to Java Programming!");
        System.out.println("This is your first Java program.");
        
        // Demonstrate different print methods
        System.out.print("Using print() - no newline: ");
        System.out.println("This continues on the same line");
        
        System.out.printf("Using printf() - formatted output: %s %d%n", "Java", 17);
        
        // Print system information
        System.out.println("\nSystem Information:");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Operating System: " + System.getProperty("os.name"));
    }
}
