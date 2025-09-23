package com.tutorial.intermediate.arraysstrings;

/**
 * Arrays Demo - Mastering Array Operations in Java
 * 
 * This comprehensive tutorial demonstrates the concept of arrays in Java,
 * which are data structures that store multiple values of the same type
 * in a single variable. Arrays are fundamental to programming and provide
 * efficient ways to store and manipulate collections of data.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what arrays are and how they work
 * - Learn how to declare, initialize, and access arrays
 * - Master one-dimensional and multi-dimensional arrays
 * - Learn about array operations and manipulations
 * - Practice with real-world array examples
 * - Understand array limitations and alternatives
 * 
 * KEY CONCEPTS:
 * 1. Array Declaration: Defining an array variable
 * 2. Array Initialization: Creating and populating arrays
 * 3. Array Access: Reading and writing array elements
 * 4. Array Length: Getting the size of an array
 * 5. Array Iteration: Looping through array elements
 * 6. Multi-dimensional Arrays: Arrays of arrays
 * 7. Array Methods: Built-in array operations
 * 
 * @author Java Tutorial Team
 * @version 1.0
 * @since 2024
 */
public class ArraysDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Arrays Demo ===");
        System.out.println();
        
        // 1. Basic Array Operations
        demonstrateBasicArrayOperations();
        
        // 2. Array Initialization Methods
        demonstrateArrayInitialization();
        
        // 3. Array Access and Modification
        demonstrateArrayAccessAndModification();
        
        // 4. Array Iteration Methods
        demonstrateArrayIteration();
        
        // 5. Multi-dimensional Arrays
        demonstrateMultiDimensionalArrays();
        
        // 6. Array Methods and Utilities
        demonstrateArrayMethods();
        
        // 7. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 8. Array Limitations and Best Practices
        demonstrateArrayLimitationsAndBestPractices();
    }
    
    /**
     * Demonstrates basic array operations
     * 
     * This section shows how to declare, initialize, and perform
     * basic operations on arrays.
     */
    private static void demonstrateBasicArrayOperations() {
        System.out.println("1. Basic Array Operations:");
        System.out.println("=========================");
        
        // Array declaration and initialization
        int[] numbers = {1, 2, 3, 4, 5};
        String[] names = {"Alice", "Bob", "Charlie", "Diana"};
        double[] prices = {19.99, 29.99, 39.99, 49.99};
        
        // Displaying arrays
        System.out.println("Integer array: " + java.util.Arrays.toString(numbers));
        System.out.println("String array: " + java.util.Arrays.toString(names));
        System.out.println("Double array: " + java.util.Arrays.toString(prices));
        
        // Array length
        System.out.println("Numbers array length: " + numbers.length);
        System.out.println("Names array length: " + names.length);
        System.out.println("Prices array length: " + prices.length);
        
        // Accessing individual elements
        System.out.println("First number: " + numbers[0]);
        System.out.println("Last name: " + names[names.length - 1]);
        System.out.println("Middle price: " + prices[prices.length / 2]);
        
        System.out.println();
    }
    
    /**
     * Demonstrates different ways to initialize arrays
     * 
     * This section shows various methods for creating and
     * initializing arrays in Java.
     */
    private static void demonstrateArrayInitialization() {
        System.out.println("2. Array Initialization Methods:");
        System.out.println("===============================");
        
        // Method 1: Array literal initialization
        int[] method1 = {10, 20, 30, 40, 50};
        System.out.println("Method 1 (literal): " + java.util.Arrays.toString(method1));
        
        // Method 2: New keyword with size
        int[] method2 = new int[5];
        method2[0] = 100;
        method2[1] = 200;
        method2[2] = 300;
        method2[3] = 400;
        method2[4] = 500;
        System.out.println("Method 2 (new keyword): " + java.util.Arrays.toString(method2));
        
        // Method 3: New keyword with values
        int[] method3 = new int[]{1, 2, 3, 4, 5};
        System.out.println("Method 3 (new with values): " + java.util.Arrays.toString(method3));
        
        // Method 4: Using Arrays.fill()
        int[] method4 = new int[5];
        java.util.Arrays.fill(method4, 42);
        System.out.println("Method 4 (Arrays.fill): " + java.util.Arrays.toString(method4));
        
        // Method 5: Using Arrays.copyOf()
        int[] method5 = java.util.Arrays.copyOf(method1, 3);
        System.out.println("Method 5 (Arrays.copyOf): " + java.util.Arrays.toString(method5));
        
        // Method 6: Using Arrays.copyOfRange()
        int[] method6 = java.util.Arrays.copyOfRange(method1, 1, 4);
        System.out.println("Method 6 (Arrays.copyOfRange): " + java.util.Arrays.toString(method6));
        
        System.out.println();
    }
    
    /**
     * Demonstrates array access and modification
     * 
     * This section shows how to read from and write to
     * array elements, including bounds checking.
     */
    private static void demonstrateArrayAccessAndModification() {
        System.out.println("3. Array Access and Modification:");
        System.out.println("================================");
        
        // Creating an array
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + java.util.Arrays.toString(numbers));
        
        // Reading array elements
        System.out.println("Reading elements:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
        
        // Modifying array elements
        System.out.println("\nModifying elements:");
        numbers[0] = 100;
        numbers[1] = 200;
        numbers[2] = 300;
        System.out.println("After modification: " + java.util.Arrays.toString(numbers));
        
        // Bounds checking
        System.out.println("\nBounds checking:");
        try {
            System.out.println("Accessing valid index: " + numbers[2]);
            System.out.println("Accessing invalid index: " + numbers[10]); // This will throw exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
        
        // Safe access with bounds checking
        System.out.println("\nSafe access:");
        int index = 3;
        if (index >= 0 && index < numbers.length) {
            System.out.println("Safe access: numbers[" + index + "] = " + numbers[index]);
        } else {
            System.out.println("Index " + index + " is out of bounds");
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates different ways to iterate through arrays
     * 
     * This section shows various methods for looping through
     * array elements.
     */
    private static void demonstrateArrayIteration() {
        System.out.println("4. Array Iteration Methods:");
        System.out.println("==========================");
        
        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Elderberry"};
        
        // Method 1: Traditional for loop
        System.out.println("Method 1 - Traditional for loop:");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("Index " + i + ": " + fruits[i]);
        }
        
        // Method 2: Enhanced for loop (for-each)
        System.out.println("\nMethod 2 - Enhanced for loop:");
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
        
        // Method 3: While loop
        System.out.println("\nMethod 3 - While loop:");
        int index = 0;
        while (index < fruits.length) {
            System.out.println("While loop: " + fruits[index]);
            index++;
        }
        
        // Method 4: Do-while loop
        System.out.println("\nMethod 4 - Do-while loop:");
        index = 0;
        do {
            System.out.println("Do-while: " + fruits[index]);
            index++;
        } while (index < fruits.length);
        
        // Method 5: Using Arrays.stream() (Java 8+)
        System.out.println("\nMethod 5 - Stream API:");
        java.util.Arrays.stream(fruits).forEach(fruit -> System.out.println("Stream: " + fruit));
        
        // Method 6: Using Arrays.asList() and forEach
        System.out.println("\nMethod 6 - Arrays.asList():");
        java.util.Arrays.asList(fruits).forEach(fruit -> System.out.println("List: " + fruit));
        
        System.out.println();
    }
    
    /**
     * Demonstrates multi-dimensional arrays
     * 
     * This section shows how to work with 2D and 3D arrays,
     * including initialization and access patterns.
     */
    private static void demonstrateMultiDimensionalArrays() {
        System.out.println("5. Multi-dimensional Arrays:");
        System.out.println("===========================");
        
        // 2D Array - Matrix
        System.out.println("2D Array (Matrix):");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Displaying 2D array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // 2D Array with different row lengths (jagged array)
        System.out.println("\nJagged Array:");
        int[][] jaggedArray = {
            {1, 2, 3, 4},
            {5, 6},
            {7, 8, 9}
        };
        
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
        
        // 3D Array
        System.out.println("\n3D Array:");
        int[][][] cube = new int[2][2][2];
        int value = 1;
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    cube[i][j][k] = value++;
                }
            }
        }
        
        // Displaying 3D array
        for (int i = 0; i < cube.length; i++) {
            System.out.println("Layer " + i + ":");
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    System.out.print(cube[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates array methods and utilities
     * 
     * This section shows built-in array methods and utility
     * functions available in Java.
     */
    private static void demonstrateArrayMethods() {
        System.out.println("6. Array Methods and Utilities:");
        System.out.println("==============================");
        
        int[] numbers = {5, 2, 8, 1, 9, 3, 7, 4, 6};
        System.out.println("Original array: " + java.util.Arrays.toString(numbers));
        
        // Sorting
        int[] sortedNumbers = numbers.clone();
        java.util.Arrays.sort(sortedNumbers);
        System.out.println("Sorted array: " + java.util.Arrays.toString(sortedNumbers));
        
        // Binary search (requires sorted array)
        int index = java.util.Arrays.binarySearch(sortedNumbers, 5);
        System.out.println("Binary search for 5: index " + index);
        
        // Filling
        int[] filledArray = new int[5];
        java.util.Arrays.fill(filledArray, 42);
        System.out.println("Filled array: " + java.util.Arrays.toString(filledArray));
        
        // Copying
        int[] copiedArray = java.util.Arrays.copyOf(numbers, 5);
        System.out.println("Copied array (first 5): " + java.util.Arrays.toString(copiedArray));
        
        // Copying range
        int[] rangeArray = java.util.Arrays.copyOfRange(numbers, 2, 6);
        System.out.println("Range array (index 2-5): " + java.util.Arrays.toString(rangeArray));
        
        // Comparing arrays
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {1, 2, 4};
        
        System.out.println("Array1 equals Array2: " + java.util.Arrays.equals(array1, array2));
        System.out.println("Array1 equals Array3: " + java.util.Arrays.equals(array1, array3));
        
        // Hash code
        System.out.println("Array1 hash code: " + java.util.Arrays.hashCode(array1));
        System.out.println("Array2 hash code: " + java.util.Arrays.hashCode(array2));
        
        // Deep comparison for multi-dimensional arrays
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{1, 2}, {3, 4}};
        int[][] matrix3 = {{1, 2}, {3, 5}};
        
        System.out.println("Matrix1 deep equals Matrix2: " + java.util.Arrays.deepEquals(matrix1, matrix2));
        System.out.println("Matrix1 deep equals Matrix3: " + java.util.Arrays.deepEquals(matrix1, matrix3));
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples of array usage
     * 
     * This section shows practical examples of how arrays
     * are used in real-world applications.
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("7. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: Student Grades
        System.out.println("Example 1: Student Grades");
        System.out.println("------------------------");
        
        String[] subjects = {"Math", "Science", "English", "History"};
        double[] grades = {85.5, 92.0, 78.5, 88.0};
        
        System.out.println("Student Report:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + grades[i]);
        }
        
        // Calculate average
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / grades.length;
        System.out.println("Average Grade: " + average);
        
        // Example 2: Shopping Cart
        System.out.println("\nExample 2: Shopping Cart");
        System.out.println("----------------------");
        
        String[] items = {"Laptop", "Mouse", "Keyboard", "Monitor"};
        double[] prices = {999.99, 25.99, 75.99, 299.99};
        int[] quantities = {1, 2, 1, 1};
        
        System.out.println("Shopping Cart:");
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            double itemTotal = prices[i] * quantities[i];
            System.out.println(items[i] + " x" + quantities[i] + " = $" + itemTotal);
            total += itemTotal;
        }
        System.out.println("Total: $" + total);
        
        // Example 3: Temperature Data
        System.out.println("\nExample 3: Temperature Data");
        System.out.println("--------------------------");
        
        double[] temperatures = {72.5, 75.2, 73.8, 76.1, 74.9, 77.3, 75.7};
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        
        System.out.println("Weekly Temperature Report:");
        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i] + ": " + temperatures[i] + "°F");
        }
        
        // Find highest and lowest temperatures
        double maxTemp = temperatures[0];
        double minTemp = temperatures[0];
        int maxDay = 0;
        int minDay = 0;
        
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] > maxTemp) {
                maxTemp = temperatures[i];
                maxDay = i;
            }
            if (temperatures[i] < minTemp) {
                minTemp = temperatures[i];
                minDay = i;
            }
        }
        
        System.out.println("Highest: " + days[maxDay] + " (" + maxTemp + "°F)");
        System.out.println("Lowest: " + days[minDay] + " (" + minTemp + "°F)");
        
        // Example 4: Game Board
        System.out.println("\nExample 4: Game Board");
        System.out.println("-------------------");
        
        char[][] gameBoard = {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'X', 'O', 'X'}
        };
        
        System.out.println("Tic-Tac-Toe Board:");
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates array limitations and best practices
     * 
     * This section shows the limitations of arrays and
     * best practices for using them effectively.
     */
    private static void demonstrateArrayLimitationsAndBestPractices() {
        System.out.println("8. Array Limitations and Best Practices:");
        System.out.println("=======================================");
        
        // Limitation 1: Fixed size
        System.out.println("Limitation 1: Fixed Size");
        System.out.println("----------------------");
        
        int[] fixedArray = new int[5];
        System.out.println("Fixed array size: " + fixedArray.length);
        System.out.println("Cannot add more elements than the declared size");
        
        // Limitation 2: No built-in methods
        System.out.println("\nLimitation 2: No Built-in Methods");
        System.out.println("--------------------------------");
        
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Array: " + java.util.Arrays.toString(numbers));
        System.out.println("No built-in methods like add(), remove(), contains()");
        System.out.println("Must use Arrays utility class or implement manually");
        
        // Limitation 3: Memory waste
        System.out.println("\nLimitation 3: Memory Waste");
        System.out.println("-------------------------");
        
        int[] largeArray = new int[1000];
        System.out.println("Created array of size 1000");
        System.out.println("Memory allocated even if not all elements are used");
        
        // Best Practice 1: Use appropriate size
        System.out.println("\nBest Practice 1: Use Appropriate Size");
        System.out.println("-----------------------------------");
        
        // Good: Use exact size needed
        String[] exactSize = {"Apple", "Banana", "Cherry"};
        System.out.println("Exact size array: " + java.util.Arrays.toString(exactSize));
        
        // Best Practice 2: Initialize with meaningful values
        System.out.println("\nBest Practice 2: Initialize with Meaningful Values");
        System.out.println("------------------------------------------------");
        
        // Good: Initialize with meaningful values
        int[] meaningfulArray = {10, 20, 30, 40, 50};
        System.out.println("Meaningful values: " + java.util.Arrays.toString(meaningfulArray));
        
        // Best Practice 3: Use enhanced for loop when possible
        System.out.println("\nBest Practice 3: Use Enhanced For Loop");
        System.out.println("------------------------------------");
        
        String[] fruits = {"Apple", "Banana", "Cherry"};
        System.out.println("Using enhanced for loop:");
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
        
        // Best Practice 4: Handle bounds checking
        System.out.println("\nBest Practice 4: Handle Bounds Checking");
        System.out.println("-------------------------------------");
        
        int[] safeArray = {1, 2, 3, 4, 5};
        int index = 3;
        if (index >= 0 && index < safeArray.length) {
            System.out.println("Safe access: " + safeArray[index]);
        } else {
            System.out.println("Index out of bounds");
        }
        
        // Best Practice 5: Use Arrays utility methods
        System.out.println("\nBest Practice 5: Use Arrays Utility Methods");
        System.out.println("------------------------------------------");
        
        int[] utilityArray = {5, 2, 8, 1, 9};
        System.out.println("Original: " + java.util.Arrays.toString(utilityArray));
        
        java.util.Arrays.sort(utilityArray);
        System.out.println("Sorted: " + java.util.Arrays.toString(utilityArray));
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Arrays store multiple values of the same type");
        System.out.println("• Arrays have fixed size and cannot be resized");
        System.out.println("• Use appropriate initialization methods");
        System.out.println("• Always check bounds when accessing elements");
        System.out.println("• Use enhanced for loop for simple iteration");
        System.out.println("• Use Arrays utility class for common operations");
        System.out.println("• Consider Collections for dynamic sizing needs");
        System.out.println("• Multi-dimensional arrays are arrays of arrays");
    }
}
