package com.tutorial.beginner;

/**
 * Break and Continue Demo - Mastering Loop Control in Java
 * 
 * This comprehensive tutorial demonstrates the use of break and continue statements
 * in Java, which are essential for controlling the flow of loops and making
 * your code more efficient and readable.
 * 
 * LEARNING OBJECTIVES:
 * - Understand when and how to use break statements
 * - Master continue statements for loop control
 * - Learn about labeled break and continue
 * - Practice nested loop control
 * - Understand the difference between break and continue
 * - Learn best practices for loop control
 * 
 * KEY CONCEPTS:
 * 1. Break Statement: Exits the current loop immediately
 * 2. Continue Statement: Skips the current iteration and continues with the next
 * 3. Labeled Break: Exits a specific labeled loop (useful in nested loops)
 * 4. Labeled Continue: Continues with the next iteration of a specific labeled loop
 * 5. Return Statement: Exits the entire method (also covered for comparison)
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class BreakContinueDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Break and Continue Demo ===");
        System.out.println();
        
        // 1. Basic Break Statement
        demonstrateBasicBreak();
        
        // 2. Basic Continue Statement
        demonstrateBasicContinue();
        
        // 3. Break vs Continue Comparison
        demonstrateBreakVsContinue();
        
        // 4. Labeled Break Statement
        demonstrateLabeledBreak();
        
        // 5. Labeled Continue Statement
        demonstrateLabeledContinue();
        
        // 6. Practical Examples
        demonstratePracticalExamples();
        
        // 7. Return Statement (for comparison)
        demonstrateReturnStatement();
        
        // 8. Best Practices and Common Patterns
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic break statement usage
     * 
     * The break statement is used to exit a loop immediately when a certain
     * condition is met. It's commonly used in search algorithms or when
     * you need to stop processing once you find what you're looking for.
     */
    private static void demonstrateBasicBreak() {
        System.out.println("1. Basic Break Statement:");
        System.out.println("========================");
        
        // Break in for loop
        System.out.println("For loop with break:");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Found 5! Breaking the loop.");
                break; // Exit the loop immediately
            }
            System.out.println("i = " + i);
        }
        
        // Break in while loop
        System.out.println("\nWhile loop with break:");
        int count = 1;
        while (count <= 10) {
            if (count == 7) {
                System.out.println("Found 7! Breaking the loop.");
                break; // Exit the loop immediately
            }
            System.out.println("count = " + count);
            count++;
        }
        
        // Break in do-while loop
        System.out.println("\nDo-while loop with break:");
        int value = 1;
        do {
            if (value == 3) {
                System.out.println("Found 3! Breaking the loop.");
                break; // Exit the loop immediately
            }
            System.out.println("value = " + value);
            value++;
        } while (value <= 10);
        
        // Break in switch statement
        System.out.println("\nSwitch statement with break:");
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break; // Exit switch statement
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Weekend");
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates basic continue statement usage
     * 
     * The continue statement is used to skip the current iteration of a loop
     * and continue with the next iteration. It's useful for filtering out
     * certain values or conditions.
     */
    private static void demonstrateBasicContinue() {
        System.out.println("2. Basic Continue Statement:");
        System.out.println("===========================");
        
        // Continue in for loop
        System.out.println("For loop with continue (skip even numbers):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Skip even numbers
            }
            System.out.println("Odd number: " + i);
        }
        
        // Continue in while loop
        System.out.println("\nWhile loop with continue (skip multiples of 3):");
        int num = 1;
        while (num <= 15) {
            if (num % 3 == 0) {
                num++; // Important: increment before continue
                continue; // Skip multiples of 3
            }
            System.out.println("Number: " + num);
            num++;
        }
        
        // Continue in do-while loop
        System.out.println("\nDo-while loop with continue (skip numbers ending with 5):");
        int value = 1;
        do {
            if (value % 10 == 5) {
                value++; // Important: increment before continue
                continue; // Skip numbers ending with 5
            }
            System.out.println("Value: " + value);
            value++;
        } while (value <= 20);
        
        // Continue with complex condition
        System.out.println("\nContinue with complex condition (skip vowels):");
        String text = "Hello World";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == ' ') {
                continue; // Skip vowels and spaces
            }
            System.out.println("Consonant: " + ch);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates the difference between break and continue
     * 
     * This section clearly shows how break and continue behave differently
     * in the same loop structure, helping you understand when to use each.
     */
    private static void demonstrateBreakVsContinue() {
        System.out.println("3. Break vs Continue Comparison:");
        System.out.println("===============================");
        
        // Using break
        System.out.println("Using BREAK (stops at first even number):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Found even number " + i + " - BREAKING!");
                break; // Stops the entire loop
            }
            System.out.println("Processing: " + i);
        }
        
        // Using continue
        System.out.println("\nUsing CONTINUE (skips all even numbers):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Skipping even number: " + i);
                continue; // Skips current iteration, continues with next
            }
            System.out.println("Processing: " + i);
        }
        
        // Side-by-side comparison
        System.out.println("\nSide-by-side comparison:");
        System.out.println("Numbers 1-10, stopping/skipping at multiples of 3:");
        
        System.out.println("With BREAK:");
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                System.out.println("  Found multiple of 3: " + i + " - STOPPING");
                break;
            }
            System.out.println("  " + i);
        }
        
        System.out.println("With CONTINUE:");
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                System.out.println("  Skipping multiple of 3: " + i);
                continue;
            }
            System.out.println("  " + i);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates labeled break statement
     * 
     * Labeled break allows you to break out of nested loops by specifying
     * which loop to break from. This is essential when working with
     * multi-dimensional arrays or nested loop structures.
     */
    private static void demonstrateLabeledBreak() {
        System.out.println("4. Labeled Break Statement:");
        System.out.println("==========================");
        
        // Nested loops without labels (breaks only inner loop)
        System.out.println("Nested loops without labels:");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Outer loop: " + i);
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("  Breaking inner loop at i=" + i + ", j=" + j);
                    break; // Only breaks inner loop
                }
                System.out.println("  Inner loop: " + j);
            }
        }
        
        // Nested loops with labeled break
        System.out.println("\nNested loops with labeled break:");
        outerLoop: for (int i = 1; i <= 3; i++) {
            System.out.println("Outer loop: " + i);
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("  Breaking outer loop at i=" + i + ", j=" + j);
                    break outerLoop; // Breaks the labeled outer loop
                }
                System.out.println("  Inner loop: " + j);
            }
        }
        
        // Matrix search with labeled break
        System.out.println("\nMatrix search with labeled break:");
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int target = 5;
        
        searchLoop: for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    System.out.println("Found " + target + " at position [" + i + "][" + j + "]");
                    break searchLoop; // Exit both loops when found
                }
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates labeled continue statement
     * 
     * Labeled continue allows you to continue with the next iteration of
     * a specific labeled loop, skipping the rest of the current iteration
     * in all nested loops up to the labeled one.
     */
    private static void demonstrateLabeledContinue() {
        System.out.println("5. Labeled Continue Statement:");
        System.out.println("=============================");
        
        // Nested loops with labeled continue
        System.out.println("Nested loops with labeled continue:");
        outerLoop: for (int i = 1; i <= 3; i++) {
            System.out.println("Outer loop: " + i);
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("  Continuing outer loop at i=" + i + ", j=" + j);
                    continue outerLoop; // Continue with next iteration of outer loop
                }
                System.out.println("  Inner loop: " + j);
            }
        }
        
        // Processing matrix with labeled continue
        System.out.println("\nProcessing matrix with labeled continue:");
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        processLoop: for (int i = 0; i < matrix.length; i++) {
            System.out.println("Processing row " + i + ":");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % 2 == 0) {
                    System.out.println("  Skipping even number " + matrix[i][j] + " - continuing to next row");
                    continue processLoop; // Skip to next row
                }
                System.out.println("  Processing odd number: " + matrix[i][j]);
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates practical examples of break and continue
     * 
     * This section shows real-world scenarios where break and continue
     * statements are commonly used, such as input validation, searching,
     * and data processing.
     */
    private static void demonstratePracticalExamples() {
        System.out.println("6. Practical Examples:");
        System.out.println("=====================");
        
        // Example 1: Finding the first prime number in a range
        System.out.println("Example 1: Finding first prime number in range 10-20");
        for (int num = 10; num <= 20; num++) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break; // No need to check further if not prime
                }
            }
            if (isPrime) {
                System.out.println("First prime number found: " + num);
                break; // Exit outer loop when first prime is found
            }
        }
        
        // Example 2: Processing user input (simulating)
        System.out.println("\nExample 2: Processing numbers, skipping negatives");
        int[] numbers = {5, -2, 8, -1, 3, 0, -4, 7};
        int sum = 0;
        int count = 0;
        
        for (int num : numbers) {
            if (num < 0) {
                System.out.println("Skipping negative number: " + num);
                continue; // Skip negative numbers
            }
            if (num == 0) {
                System.out.println("Found zero - stopping processing");
                break; // Stop when zero is encountered
            }
            sum += num;
            count++;
            System.out.println("Added " + num + " to sum. Current sum: " + sum);
        }
        System.out.println("Final sum: " + sum + ", Count: " + count);
        
        // Example 3: String processing
        System.out.println("\nExample 3: Processing string, stopping at first digit");
        String text = "Hello123World";
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isDigit(ch)) {
                System.out.println("Found first digit '" + ch + "' - stopping");
                break; // Stop at first digit
            }
            result.append(ch);
        }
        System.out.println("Result: " + result.toString());
        
        // Example 4: Nested loop with complex condition
        System.out.println("\nExample 4: Finding first pair that sums to target");
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8};
        int target = 10;
        
        found: for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] + array2[j] == target) {
                    System.out.println("Found pair: " + array1[i] + " + " + array2[j] + " = " + target);
                    break found; // Exit both loops
                }
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates return statement for comparison
     * 
     * The return statement exits the entire method, not just a loop.
     * This is included for comparison to show the difference between
     * break, continue, and return.
     */
    private static void demonstrateReturnStatement() {
        System.out.println("7. Return Statement (for comparison):");
        System.out.println("====================================");
        
        System.out.println("Method with return statement:");
        int result = findFirstEvenNumber();
        System.out.println("First even number found: " + result);
        
        System.out.println("\nMethod with return in loop:");
        processNumbersWithReturn();
        
        System.out.println();
    }
    
    /**
     * Helper method demonstrating return statement
     */
    private static int findFirstEvenNumber() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                return i; // Exits the entire method, not just the loop
            }
        }
        return -1; // This line won't be reached if even number is found
    }
    
    /**
     * Helper method demonstrating return in loop
     */
    private static void processNumbersWithReturn() {
        int[] numbers = {1, 3, 5, 7, 9, 11};
        
        for (int num : numbers) {
            if (num > 8) {
                System.out.println("Found number > 8: " + num + " - returning from method");
                return; // Exits the entire method
            }
            System.out.println("Processing: " + num);
        }
        System.out.println("All numbers processed");
    }
    
    /**
     * Demonstrates best practices and common patterns
     * 
     * This section shows common patterns and best practices when using
     * break and continue statements, including when to use them and
     * how to make your code more readable.
     */
    private static void demonstrateBestPractices() {
        System.out.println("8. Best Practices and Common Patterns:");
        System.out.println("=====================================");
        
        // Best Practice 1: Use break for early termination
        System.out.println("Best Practice 1: Early termination with break");
        int[] scores = {85, 92, 78, 96, 88, 91};
        int passingScore = 90;
        
        for (int score : scores) {
            if (score >= passingScore) {
                System.out.println("Found first passing score: " + score);
                break; // Good: Early termination when condition is met
            }
        }
        
        // Best Practice 2: Use continue for filtering
        System.out.println("\nBest Practice 2: Filtering with continue");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;
        
        for (int num : numbers) {
            if (num % 2 == 0) {
                continue; // Good: Skip even numbers
            }
            sum += num; // Only process odd numbers
        }
        System.out.println("Sum of odd numbers: " + sum);
        
        // Best Practice 3: Use labeled break/continue for nested loops
        System.out.println("\nBest Practice 3: Labeled statements for clarity");
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        search: for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 5) {
                    System.out.println("Found 5 at [" + i + "][" + j + "]");
                    break search; // Good: Clear intent with labeled break
                }
            }
        }
        
        // Best Practice 4: Avoid deep nesting
        System.out.println("\nBest Practice 4: Avoiding deep nesting");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // Good: Skip instead of deep nesting
            }
            System.out.println("Processing: " + i);
        }
        
        // Common Pattern: Input validation loop
        System.out.println("\nCommon Pattern: Input validation simulation");
        int[] userInputs = {5, -1, 0, 3, 2}; // Simulating user inputs
        int validCount = 0;
        
        for (int input : userInputs) {
            if (input < 0) {
                System.out.println("Invalid input: " + input + " (negative)");
                continue; // Skip invalid input
            }
            if (input == 0) {
                System.out.println("Input 0 received - stopping");
                break; // Stop on sentinel value
            }
            validCount++;
            System.out.println("Valid input: " + input);
        }
        System.out.println("Total valid inputs: " + validCount);
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Use BREAK to exit loops early when condition is met");
        System.out.println("• Use CONTINUE to skip current iteration and continue with next");
        System.out.println("• Use LABELED break/continue for nested loops");
        System.out.println("• Use RETURN to exit entire method");
        System.out.println("• Always increment loop variables before continue in while/do-while loops");
        System.out.println("• Use meaningful labels for better code readability");
    }
}
