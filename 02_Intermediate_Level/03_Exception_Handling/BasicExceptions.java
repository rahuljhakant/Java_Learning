package com.tutorial.intermediate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Basic Exception Handling Demo
 * 
 * This class demonstrates:
 * - try-catch blocks
 * - finally blocks
 * - Multiple catch blocks
 * - Exception hierarchy
 * - Checked vs Unchecked exceptions
 * - try-with-resources
 */
public class BasicExceptions {
    
    public static void main(String[] args) {
        System.out.println("=== Basic Exception Handling Demo ===");
        System.out.println();
        
        // 1. Basic try-catch
        demonstrateBasicTryCatch();
        
        // 2. Multiple catch blocks
        demonstrateMultipleCatchBlocks();
        
        // 3. Finally block
        demonstrateFinallyBlock();
        
        // 4. Checked vs Unchecked exceptions
        demonstrateCheckedVsUnchecked();
        
        // 5. try-with-resources
        demonstrateTryWithResources();
        
        // 6. Exception hierarchy
        demonstrateExceptionHierarchy();
        
        // 7. Common exceptions
        demonstrateCommonExceptions();
    }
    
    /**
     * Demonstrates basic try-catch block
     */
    private static void demonstrateBasicTryCatch() {
        System.out.println("1. Basic Try-Catch Block:");
        System.out.println("========================");
        
        try {
            // This will cause an ArithmeticException
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
            System.out.println("Exception type: " + e.getClass().getSimpleName());
        }
        
        System.out.println("Program continues after exception handling");
        System.out.println();
    }
    
    /**
     * Demonstrates multiple catch blocks
     */
    private static void demonstrateMultipleCatchBlocks() {
        System.out.println("2. Multiple Catch Blocks:");
        System.out.println("========================");
        
        String[] operations = {"divide", "array", "parse"};
        
        for (String operation : operations) {
            try {
                switch (operation) {
                    case "divide":
                        int result = 10 / 0;
                        break;
                    case "array":
                        int[] arr = new int[5];
                        int value = arr[10]; // ArrayIndexOutOfBoundsException
                        break;
                    case "parse":
                        int number = Integer.parseInt("abc"); // NumberFormatException
                        break;
                }
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic error: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array index error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Number format error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("General error: " + e.getMessage());
            }
        }
        System.out.println();
    }
    
    /**
     * Demonstrates finally block
     */
    private static void demonstrateFinallyBlock() {
        System.out.println("3. Finally Block:");
        System.out.println("================");
        
        // Finally block always executes
        try {
            System.out.println("Inside try block");
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed - cleanup code here");
        }
        
        // Finally block executes even when exception occurs
        try {
            System.out.println("\nInside try block with exception");
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed even with exception");
        }
        System.out.println();
    }
    
    /**
     * Demonstrates checked vs unchecked exceptions
     */
    private static void demonstrateCheckedVsUnchecked() {
        System.out.println("4. Checked vs Unchecked Exceptions:");
        System.out.println("===================================");
        
        // Unchecked exception (RuntimeException) - no need to handle
        System.out.println("Unchecked exception example:");
        try {
            int[] arr = new int[5];
            int value = arr[10]; // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Unchecked exception caught: " + e.getMessage());
        }
        
        // Checked exception - must be handled or declared
        System.out.println("\nChecked exception example:");
        try {
            File file = new File("nonexistent.txt");
            FileInputStream fis = new FileInputStream(file); // FileNotFoundException
        } catch (FileNotFoundException e) {
            System.out.println("Checked exception caught: " + e.getMessage());
        }
        System.out.println();
    }
    
    /**
     * Demonstrates try-with-resources
     */
    private static void demonstrateTryWithResources() {
        System.out.println("5. Try-With-Resources:");
        System.out.println("=====================");
        
        // try-with-resources automatically closes resources
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Scanner resource is automatically managed");
            // Scanner will be automatically closed here
        } catch (Exception e) {
            System.out.println("Exception in try-with-resources: " + e.getMessage());
        }
        
        // Multiple resources in try-with-resources
        try (FileInputStream fis1 = new FileInputStream("file1.txt");
             FileInputStream fis2 = new FileInputStream("file2.txt")) {
            System.out.println("Multiple resources managed automatically");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        
        System.out.println("Resources are automatically closed");
        System.out.println();
    }
    
    /**
     * Demonstrates exception hierarchy
     */
    private static void demonstrateExceptionHierarchy() {
        System.out.println("6. Exception Hierarchy:");
        System.out.println("======================");
        
        try {
            // This will cause a RuntimeException
            String str = null;
            int length = str.length(); // NullPointerException
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught general Exception: " + e.getClass().getSimpleName());
        }
        
        // Demonstrating inheritance in exception handling
        try {
            int[] arr = new int[5];
            int value = arr[10];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nCaught IndexOutOfBoundsException: " + e.getClass().getSimpleName());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("Caught general Exception: " + e.getClass().getSimpleName());
        }
        System.out.println();
    }
    
    /**
     * Demonstrates common exceptions
     */
    private static void demonstrateCommonExceptions() {
        System.out.println("7. Common Exceptions:");
        System.out.println("====================");
        
        // NullPointerException
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
        
        // ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            int value = arr[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
        
        // NumberFormatException
        try {
            int number = Integer.parseInt("not_a_number");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }
        
        // ClassCastException
        try {
            Object obj = "Hello";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: " + e.getMessage());
        }
        
        // IllegalArgumentException
        try {
            if (true) {
                throw new IllegalArgumentException("Invalid argument provided");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
        
        // IllegalStateException
        try {
            if (true) {
                throw new IllegalStateException("Object is in invalid state");
            }
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException: " + e.getMessage());
        }
        System.out.println();
    }
    
    /**
     * Method that throws a checked exception
     */
    public static void methodWithCheckedException() throws FileNotFoundException {
        File file = new File("nonexistent.txt");
        FileInputStream fis = new FileInputStream(file);
    }
    
    /**
     * Method that throws an unchecked exception
     */
    public static void methodWithUncheckedException() {
        throw new RuntimeException("This is an unchecked exception");
    }
    
    /**
     * Method demonstrating exception propagation
     */
    public static void methodWithExceptionPropagation() {
        try {
            methodWithUncheckedException();
        } catch (RuntimeException e) {
            System.out.println("Exception caught and re-thrown");
            throw e; // Re-throwing the exception
        }
    }
}
