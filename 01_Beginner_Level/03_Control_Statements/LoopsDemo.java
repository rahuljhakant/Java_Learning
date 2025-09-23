package com.tutorial.basics;

import java.util.Scanner;

/**
 * Loops Demo
 * 
 * This class demonstrates:
 * - for loop
 * - enhanced for loop (for-each)
 * - while loop
 * - do-while loop
 * - Nested loops
 * - break and continue statements
 * - Loop control with labels
 */
public class LoopsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Loops Demo ===");
        System.out.println();
        
        // 1. For Loop
        demonstrateForLoop();
        
        // 2. Enhanced For Loop (For-Each)
        demonstrateEnhancedForLoop();
        
        // 3. While Loop
        demonstrateWhileLoop();
        
        // 4. Do-While Loop
        demonstrateDoWhileLoop();
        
        // 5. Nested Loops
        demonstrateNestedLoops();
        
        // 6. Break and Continue
        demonstrateBreakAndContinue();
        
        // 7. Loop Control with Labels
        demonstrateLoopLabels();
        
        // 8. Practical Examples
        demonstratePracticalExamples();
    }
    
    /**
     * Demonstrates basic for loop
     */
    private static void demonstrateForLoop() {
        System.out.println("1. For Loop:");
        System.out.println("============");
        
        // Basic for loop
        System.out.println("Counting from 1 to 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
        
        // For loop with different increment
        System.out.println("\nCounting by 2s from 0 to 10:");
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Reverse counting
        System.out.println("\nReverse counting from 10 to 1:");
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Multiple variables in for loop
        System.out.println("\nMultiple variables in for loop:");
        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.println("i = " + i + ", j = " + j);
        }
        System.out.println();
    }
    
    /**
     * Demonstrates enhanced for loop (for-each)
     */
    private static void demonstrateEnhancedForLoop() {
        System.out.println("2. Enhanced For Loop (For-Each):");
        System.out.println("================================");
        
        // Array iteration
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Array elements:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        
        // String array iteration
        String[] fruits = {"Apple", "Banana", "Orange", "Grape", "Mango"};
        System.out.println("\nFruits:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }
        
        // Character array iteration
        char[] message = {'H', 'e', 'l', 'l', 'o'};
        System.out.println("\nCharacter array:");
        for (char c : message) {
            System.out.print(c);
        }
        System.out.println();
        System.out.println();
    }
    
    /**
     * Demonstrates while loop
     */
    private static void demonstrateWhileLoop() {
        System.out.println("3. While Loop:");
        System.out.println("==============");
        
        // Basic while loop
        int count = 1;
        System.out.println("Counting from 1 to 5 using while loop:");
        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;
        }
        
        // While loop with condition
        int number = 64;
        System.out.println("\nFinding square root of " + number + ":");
        int guess = 1;
        while (guess * guess < number) {
            guess++;
        }
        System.out.println("Square root of " + number + " is approximately " + guess);
        
        // While loop with user input simulation
        System.out.println("\nSimulating user input (numbers 1-10):");
        int input = 1;
        while (input <= 10) {
            System.out.println("Processing input: " + input);
            input++;
        }
        System.out.println();
    }
    
    /**
     * Demonstrates do-while loop
     */
    private static void demonstrateDoWhileLoop() {
        System.out.println("4. Do-While Loop:");
        System.out.println("=================");
        
        // Basic do-while loop
        int count = 1;
        System.out.println("Counting from 1 to 5 using do-while loop:");
        do {
            System.out.println("Count: " + count);
            count++;
        } while (count <= 5);
        
        // Do-while loop that executes at least once
        int number = 10;
        System.out.println("\nDo-while with condition that's false initially:");
        do {
            System.out.println("This will execute at least once: " + number);
            number++;
        } while (number < 10);
        
        // Menu simulation
        System.out.println("\nMenu simulation:");
        int choice = 1;
        do {
            System.out.println("Menu option " + choice + " selected");
            choice++;
        } while (choice <= 3);
        System.out.println();
    }
    
    /**
     * Demonstrates nested loops
     */
    private static void demonstrateNestedLoops() {
        System.out.println("5. Nested Loops:");
        System.out.println("================");
        
        // Multiplication table
        System.out.println("Multiplication table (1-5):");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%3d ", i * j);
            }
            System.out.println();
        }
        
        // Pattern printing
        System.out.println("\nStar pattern:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        // Number pattern
        System.out.println("\nNumber pattern:");
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        
        // 2D array processing
        System.out.println("\n2D Array processing:");
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Demonstrates break and continue statements
     */
    private static void demonstrateBreakAndContinue() {
        System.out.println("6. Break and Continue:");
        System.out.println("=====================");
        
        // Break statement
        System.out.println("Using break to exit loop early:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                System.out.println("Breaking at " + i);
                break;
            }
            System.out.println("Count: " + i);
        }
        
        // Continue statement
        System.out.println("\nUsing continue to skip iterations:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Skipping even number: " + i);
                continue;
            }
            System.out.println("Odd number: " + i);
        }
        
        // Break and continue in while loop
        System.out.println("\nBreak and continue in while loop:");
        int number = 1;
        while (number <= 10) {
            if (number == 8) {
                System.out.println("Breaking at " + number);
                break;
            }
            if (number % 3 == 0) {
                System.out.println("Skipping multiple of 3: " + number);
                number++;
                continue;
            }
            System.out.println("Number: " + number);
            number++;
        }
        System.out.println();
    }
    
    /**
     * Demonstrates loop control with labels
     */
    private static void demonstrateLoopLabels() {
        System.out.println("7. Loop Control with Labels:");
        System.out.println("============================");
        
        // Labeled break
        System.out.println("Labeled break example:");
        outer: for (int i = 1; i <= 3; i++) {
            inner: for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("Breaking outer loop at i=" + i + ", j=" + j);
                    break outer;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
        
        // Labeled continue
        System.out.println("\nLabeled continue example:");
        outer: for (int i = 1; i <= 3; i++) {
            inner: for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("Continuing outer loop at i=" + i + ", j=" + j);
                    continue outer;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
        System.out.println();
    }
    
    /**
     * Demonstrates practical examples using loops
     */
    private static void demonstratePracticalExamples() {
        System.out.println("8. Practical Examples:");
        System.out.println("=====================");
        
        // Finding sum of numbers
        System.out.println("Finding sum of numbers 1 to 10:");
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
        
        // Finding factorial
        System.out.println("\nFinding factorial of 5:");
        int factorial = 1;
        for (int i = 1; i <= 5; i++) {
            factorial *= i;
        }
        System.out.println("5! = " + factorial);
        
        // Finding prime numbers
        System.out.println("\nPrime numbers between 1 and 20:");
        for (int i = 2; i <= 20; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // Fibonacci series
        System.out.println("\nFibonacci series (first 10 numbers):");
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < 10; i++) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
        }
        System.out.println();
        
        // Array operations
        System.out.println("\nArray operations:");
        int[] numbers = {5, 2, 8, 1, 9, 3};
        System.out.print("Original array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Finding maximum
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("Maximum value: " + max);
        
        // Finding minimum
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("Minimum value: " + min);
        
        // Finding average
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        double average = (double) total / numbers.length;
        System.out.println("Average: " + average);
        System.out.println();
    }
}
