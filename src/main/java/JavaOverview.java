package com.tutorial.basics;

/**
 * Java Overview - Demonstrating Java's key features and environment information
 * 
 * This class showcases:
 * - Java version and environment details
 * - JVM, JDK, JRE concepts
 * - Basic Java program structure
 * - Platform independence demonstration
 */
public class JavaOverview {
    
    public static void main(String[] args) {
        System.out.println("=== Java Overview ===");
        System.out.println();
        
        // Display Java version information
        System.out.println("Java Version Information:");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Java Runtime Version: " + System.getProperty("java.runtime.version"));
        System.out.println("Java VM Name: " + System.getProperty("java.vm.name"));
        System.out.println("Java VM Version: " + System.getProperty("java.vm.version"));
        System.out.println("Java VM Vendor: " + System.getProperty("java.vm.vendor"));
        System.out.println();
        
        // Display system information
        System.out.println("System Information:");
        System.out.println("Operating System: " + System.getProperty("os.name"));
        System.out.println("OS Version: " + System.getProperty("os.version"));
        System.out.println("OS Architecture: " + System.getProperty("os.arch"));
        System.out.println();
        
        // Display Java installation paths
        System.out.println("Java Installation:");
        System.out.println("Java Home: " + System.getProperty("java.home"));
        System.out.println("Java Class Path: " + System.getProperty("java.class.path"));
        System.out.println();
        
        // Demonstrate Java's key features
        demonstrateJavaFeatures();
    }
    
    /**
     * Demonstrates key Java features:
     * 1. Platform Independence
     * 2. Object-Oriented Programming
     * 3. Strong Memory Management
     * 4. Security Features
     */
    private static void demonstrateJavaFeatures() {
        System.out.println("=== Java Key Features ===");
        System.out.println();
        
        // 1. Platform Independence
        System.out.println("1. Platform Independence:");
        System.out.println("   - Write once, run anywhere (WORA)");
        System.out.println("   - Java bytecode runs on any platform with JVM");
        System.out.println("   - Current platform: " + System.getProperty("os.name"));
        System.out.println();
        
        // 2. Object-Oriented Programming
        System.out.println("2. Object-Oriented Programming:");
        System.out.println("   - Everything in Java is an object (except primitives)");
        System.out.println("   - Supports inheritance, polymorphism, encapsulation, abstraction");
        System.out.println("   - Example: This class extends Object class");
        System.out.println("   - Superclass: " + JavaOverview.class.getSuperclass().getName());
        System.out.println();
        
        // 3. Strong Memory Management
        System.out.println("3. Strong Memory Management:");
        System.out.println("   - Automatic garbage collection");
        System.out.println("   - No manual memory management required");
        System.out.println("   - Memory usage: " + (Runtime.getRuntime().totalMemory() / 1024 / 1024) + " MB");
        System.out.println("   - Free memory: " + (Runtime.getRuntime().freeMemory() / 1024 / 1024) + " MB");
        System.out.println();
        
        // 4. Security Features
        System.out.println("4. Security Features:");
        System.out.println("   - Bytecode verification");
        System.out.println("   - Sandbox security model");
        System.out.println("   - No pointer arithmetic");
        System.out.println("   - Array bounds checking");
        System.out.println();
        
        // 5. Multithreading
        System.out.println("5. Multithreading Support:");
        System.out.println("   - Built-in thread support");
        System.out.println("   - Available processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("   - Current thread: " + Thread.currentThread().getName());
        System.out.println();
        
        // 6. High Performance
        System.out.println("6. High Performance:");
        System.out.println("   - Just-In-Time (JIT) compilation");
        System.out.println("   - Optimized bytecode execution");
        System.out.println("   - HotSpot JVM optimizations");
        System.out.println();
    }
}
