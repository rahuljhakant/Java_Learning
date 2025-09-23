package com.tutorial.basics;

/**
 * Methods Demo - Mastering Method Creation and Usage in Java
 * 
 * This comprehensive tutorial demonstrates the concept of methods in Java,
 * which are blocks of code that perform specific tasks and can be reused
 * throughout your program. Methods are fundamental to object-oriented
 * programming and code organization.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what methods are and why they're important
 * - Learn how to create and call methods
 * - Master method parameters and return types
 * - Understand method overloading
 * - Learn about method scope and visibility
 * - Practice with different types of methods
 * - Understand recursion and recursive methods
 * 
 * KEY CONCEPTS:
 * 1. Method Declaration: Defining a method with name, parameters, and return type
 * 2. Method Invocation: Calling a method to execute its code
 * 3. Parameters: Values passed to methods for processing
 * 4. Return Values: Values returned by methods after processing
 * 5. Method Overloading: Multiple methods with same name but different parameters
 * 6. Recursion: Methods that call themselves
 * 
 * @author Java Tutorial Team
 * @version 1.0
 * @since 2024
 */
public class MethodsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Methods Demo ===");
        System.out.println();
        
        // 1. Basic Method Creation and Calling
        demonstrateBasicMethods();
        
        // 2. Methods with Parameters
        demonstrateMethodsWithParameters();
        
        // 3. Methods with Return Values
        demonstrateMethodsWithReturnValues();
        
        // 4. Method Overloading
        demonstrateMethodOverloading();
        
        // 5. Static vs Instance Methods
        demonstrateStaticVsInstanceMethods();
        
        // 6. Recursive Methods
        demonstrateRecursiveMethods();
        
        // 7. Method Scope and Local Variables
        demonstrateMethodScope();
        
        // 8. Practical Examples
        demonstratePracticalExamples();
    }
    
    /**
     * Demonstrates basic method creation and calling
     * 
     * This section shows how to create simple methods without parameters
     * and return values, and how to call them from the main method.
     */
    private static void demonstrateBasicMethods() {
        System.out.println("1. Basic Method Creation and Calling:");
        System.out.println("====================================");
        
        // Calling simple methods
        sayHello();
        sayGoodbye();
        printSeparator();
        
        // Calling methods multiple times
        System.out.println("Calling methods multiple times:");
        for (int i = 0; i < 3; i++) {
            sayHello();
        }
        
        System.out.println();
    }
    
    /**
     * A simple method that prints a greeting message
     * 
     * This method demonstrates:
     * - Method declaration with 'public static void'
     * - Method naming convention (camelCase)
     * - Method body with executable code
     */
    public static void sayHello() {
        System.out.println("Hello from the sayHello method!");
    }
    
    /**
     * Another simple method that prints a farewell message
     */
    public static void sayGoodbye() {
        System.out.println("Goodbye from the sayGoodbye method!");
    }
    
    /**
     * A utility method that prints a separator line
     */
    public static void printSeparator() {
        System.out.println("----------------------------------------");
    }
    
    /**
     * Demonstrates methods with parameters
     * 
     * Parameters allow methods to receive data from the calling code,
     * making methods more flexible and reusable.
     */
    private static void demonstrateMethodsWithParameters() {
        System.out.println("2. Methods with Parameters:");
        System.out.println("==========================");
        
        // Calling methods with different parameters
        greetPerson("Alice");
        greetPerson("Bob");
        greetPerson("Charlie");
        
        // Methods with multiple parameters
        printFullName("John", "Doe");
        printFullName("Jane", "Smith");
        
        // Methods with different parameter types
        printNumber(42);
        printNumber(3.14);
        printNumber(true);
        
        // Method with array parameter
        int[] numbers = {1, 2, 3, 4, 5};
        printArray(numbers);
        
        System.out.println();
    }
    
    /**
     * A method that greets a person by name
     * 
     * @param name the name of the person to greet
     */
    public static void greetPerson(String name) {
        System.out.println("Hello, " + name + "! Nice to meet you.");
    }
    
    /**
     * A method that prints a full name
     * 
     * @param firstName the person's first name
     * @param lastName the person's last name
     */
    public static void printFullName(String firstName, String lastName) {
        System.out.println("Full name: " + firstName + " " + lastName);
    }
    
    /**
     * A method that prints a number
     * 
     * @param number the number to print
     */
    public static void printNumber(int number) {
        System.out.println("Integer number: " + number);
    }
    
    /**
     * Method overloading: same name, different parameter type
     * 
     * @param number the double number to print
     */
    public static void printNumber(double number) {
        System.out.println("Double number: " + number);
    }
    
    /**
     * Method overloading: same name, different parameter type
     * 
     * @param value the boolean value to print
     */
    public static void printNumber(boolean value) {
        System.out.println("Boolean value: " + value);
    }
    
    /**
     * A method that prints an array of integers
     * 
     * @param array the array to print
     */
    public static void printArray(int[] array) {
        System.out.print("Array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Demonstrates methods with return values
     * 
     * Methods can return values to the calling code, allowing for
     * data processing and result communication.
     */
    private static void demonstrateMethodsWithReturnValues() {
        System.out.println("3. Methods with Return Values:");
        System.out.println("=============================");
        
        // Methods returning different types
        int sum = add(5, 3);
        System.out.println("Sum: " + sum);
        
        double product = multiply(2.5, 4.0);
        System.out.println("Product: " + product);
        
        String fullName = createFullName("John", "Doe");
        System.out.println("Full name: " + fullName);
        
        boolean isEven = checkEven(8);
        System.out.println("Is 8 even? " + isEven);
        
        // Using return values in expressions
        int result = add(multiply(2, 3), 4);
        System.out.println("Complex calculation: " + result);
        
        // Method returning array
        int[] squares = generateSquares(5);
        System.out.print("Squares: ");
        for (int square : squares) {
            System.out.print(square + " ");
        }
        System.out.println();
        
        System.out.println();
    }
    
    /**
     * A method that adds two integers and returns the result
     * 
     * @param a the first number
     * @param b the second number
     * @return the sum of a and b
     */
    public static int add(int a, int b) {
        return a + b;
    }
    
    /**
     * A method that multiplies two doubles and returns the result
     * 
     * @param a the first number
     * @param b the second number
     * @return the product of a and b
     */
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    /**
     * A method that creates a full name from first and last name
     * 
     * @param firstName the first name
     * @param lastName the last name
     * @return the concatenated full name
     */
    public static String createFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
    
    /**
     * A method that checks if a number is even
     * 
     * @param number the number to check
     * @return true if the number is even, false otherwise
     */
    public static boolean checkEven(int number) {
        return number % 2 == 0;
    }
    
    /**
     * A method that generates an array of squares
     * 
     * @param count the number of squares to generate
     * @return an array containing squares from 1 to count
     */
    public static int[] generateSquares(int count) {
        int[] squares = new int[count];
        for (int i = 0; i < count; i++) {
            squares[i] = (i + 1) * (i + 1);
        }
        return squares;
    }
    
    /**
     * Demonstrates method overloading
     * 
     * Method overloading allows you to have multiple methods with the same name
     * but different parameters. Java determines which method to call based on
     * the number and types of parameters.
     */
    private static void demonstrateMethodOverloading() {
        System.out.println("4. Method Overloading:");
        System.out.println("=====================");
        
        // Different number of parameters
        System.out.println("Sum of 2 numbers: " + calculateSum(5, 3));
        System.out.println("Sum of 3 numbers: " + calculateSum(5, 3, 2));
        System.out.println("Sum of 4 numbers: " + calculateSum(5, 3, 2, 1));
        
        // Different parameter types
        System.out.println("Integer max: " + findMax(10, 20));
        System.out.println("Double max: " + findMax(10.5, 20.3));
        System.out.println("String max: " + findMax("apple", "banana"));
        
        // Different parameter order
        printInfo("John", 25);
        printInfo(30, "Jane");
        
        // Array vs individual parameters
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Array average: " + calculateAverage(numbers));
        System.out.println("Individual average: " + calculateAverage(1, 2, 3, 4, 5));
        
        System.out.println();
    }
    
    /**
     * Overloaded method: calculates sum of two numbers
     */
    public static int calculateSum(int a, int b) {
        return a + b;
    }
    
    /**
     * Overloaded method: calculates sum of three numbers
     */
    public static int calculateSum(int a, int b, int c) {
        return a + b + c;
    }
    
    /**
     * Overloaded method: calculates sum of four numbers
     */
    public static int calculateSum(int a, int b, int c, int d) {
        return a + b + c + d;
    }
    
    /**
     * Overloaded method: finds maximum of two integers
     */
    public static int findMax(int a, int b) {
        return Math.max(a, b);
    }
    
    /**
     * Overloaded method: finds maximum of two doubles
     */
    public static double findMax(double a, double b) {
        return Math.max(a, b);
    }
    
    /**
     * Overloaded method: finds maximum of two strings (lexicographically)
     */
    public static String findMax(String a, String b) {
        return a.compareTo(b) > 0 ? a : b;
    }
    
    /**
     * Overloaded method: prints name and age
     */
    public static void printInfo(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    /**
     * Overloaded method: prints age and name (different parameter order)
     */
    public static void printInfo(int age, String name) {
        System.out.println("Age: " + age + ", Name: " + name);
    }
    
    /**
     * Overloaded method: calculates average of array
     */
    public static double calculateAverage(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }
    
    /**
     * Overloaded method: calculates average of individual numbers (varargs)
     */
    public static double calculateAverage(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }
    
    /**
     * Demonstrates static vs instance methods
     * 
     * Static methods belong to the class and can be called without creating
     * an instance. Instance methods belong to an object and require an
     * instance to be called.
     */
    private static void demonstrateStaticVsInstanceMethods() {
        System.out.println("5. Static vs Instance Methods:");
        System.out.println("=============================");
        
        // Static methods (called on class)
        System.out.println("Static method call:");
        StaticMethodsDemo.staticMethod();
        int result = StaticMethodsDemo.staticAdd(5, 3);
        System.out.println("Static add result: " + result);
        
        // Instance methods (called on object)
        System.out.println("\nInstance method call:");
        StaticMethodsDemo obj = new StaticMethodsDemo("Test Object");
        obj.instanceMethod();
        int instanceResult = obj.instanceAdd(5, 3);
        System.out.println("Instance add result: " + instanceResult);
        
        // Static variable access
        System.out.println("Static variable: " + StaticMethodsDemo.staticCounter);
        
        // Instance variable access
        System.out.println("Instance variable: " + obj.instanceName);
        
        System.out.println();
    }
    
    /**
     * Demonstrates recursive methods
     * 
     * Recursion is when a method calls itself. It's useful for solving
     * problems that can be broken down into smaller, similar problems.
     */
    private static void demonstrateRecursiveMethods() {
        System.out.println("6. Recursive Methods:");
        System.out.println("===================");
        
        // Factorial using recursion
        int n = 5;
        long factorial = calculateFactorial(n);
        System.out.println("Factorial of " + n + " = " + factorial);
        
        // Fibonacci using recursion
        int fibN = 8;
        long fibonacci = calculateFibonacci(fibN);
        System.out.println("Fibonacci(" + fibN + ") = " + fibonacci);
        
        // Sum of digits using recursion
        int number = 12345;
        int digitSum = sumOfDigits(number);
        System.out.println("Sum of digits of " + number + " = " + digitSum);
        
        // Power calculation using recursion
        int base = 2;
        int exponent = 8;
        long power = calculatePower(base, exponent);
        System.out.println(base + "^" + exponent + " = " + power);
        
        // Print numbers recursively
        System.out.println("Printing numbers 1 to 5 recursively:");
        printNumbersRecursively(1, 5);
        
        System.out.println();
    }
    
    /**
     * Recursive method to calculate factorial
     * 
     * @param n the number to calculate factorial for
     * @return the factorial of n
     */
    public static long calculateFactorial(int n) {
        if (n <= 1) {
            return 1; // Base case
        }
        return n * calculateFactorial(n - 1); // Recursive case
    }
    
    /**
     * Recursive method to calculate Fibonacci number
     * 
     * @param n the position in Fibonacci sequence
     * @return the nth Fibonacci number
     */
    public static long calculateFibonacci(int n) {
        if (n <= 1) {
            return n; // Base case
        }
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2); // Recursive case
    }
    
    /**
     * Recursive method to calculate sum of digits
     * 
     * @param number the number to sum digits of
     * @return the sum of digits
     */
    public static int sumOfDigits(int number) {
        if (number < 10) {
            return number; // Base case
        }
        return (number % 10) + sumOfDigits(number / 10); // Recursive case
    }
    
    /**
     * Recursive method to calculate power
     * 
     * @param base the base number
     * @param exponent the exponent
     * @return base raised to the power of exponent
     */
    public static long calculatePower(int base, int exponent) {
        if (exponent == 0) {
            return 1; // Base case
        }
        return base * calculatePower(base, exponent - 1); // Recursive case
    }
    
    /**
     * Recursive method to print numbers in a range
     * 
     * @param start the starting number
     * @param end the ending number
     */
    public static void printNumbersRecursively(int start, int end) {
        if (start > end) {
            return; // Base case
        }
        System.out.println("Number: " + start);
        printNumbersRecursively(start + 1, end); // Recursive case
    }
    
    /**
     * Demonstrates method scope and local variables
     * 
     * Variables declared inside methods have local scope and are only
     * accessible within that method.
     */
    private static void demonstrateMethodScope() {
        System.out.println("7. Method Scope and Local Variables:");
        System.out.println("===================================");
        
        // Each method call has its own local variables
        demonstrateLocalScope(5);
        demonstrateLocalScope(10);
        
        // Variables with same name in different scopes
        int globalVar = 100;
        System.out.println("Global variable: " + globalVar);
        
        demonstrateScopeExample(globalVar);
        
        System.out.println();
    }
    
    /**
     * Method demonstrating local scope
     * 
     * @param parameter the parameter passed to the method
     */
    public static void demonstrateLocalScope(int parameter) {
        int localVar = parameter * 2; // Local variable
        System.out.println("Parameter: " + parameter + ", Local variable: " + localVar);
        
        // Local variable is only accessible within this method
        // localVar goes out of scope when method ends
    }
    
    /**
     * Method demonstrating scope with same variable names
     * 
     * @param localVar a parameter with same name as global variable
     */
    public static void demonstrateScopeExample(int localVar) {
        System.out.println("Local parameter: " + localVar);
        
        // Local variable shadows global variable
        int anotherLocal = localVar + 50;
        System.out.println("Another local: " + anotherLocal);
    }
    
    /**
     * Demonstrates practical examples of method usage
     * 
     * This section shows real-world examples of how methods are used
     * to solve common programming problems.
     */
    private static void demonstratePracticalExamples() {
        System.out.println("8. Practical Examples:");
        System.out.println("=====================");
        
        // Example 1: String utility methods
        String text = "Hello World";
        System.out.println("Original: " + text);
        System.out.println("Reversed: " + reverseString(text));
        System.out.println("Word count: " + countWords(text));
        System.out.println("Is palindrome: " + isPalindrome("racecar"));
        
        // Example 2: Array utility methods
        int[] numbers = {5, 2, 8, 1, 9, 3};
        System.out.println("Original array: " + java.util.Arrays.toString(numbers));
        System.out.println("Maximum: " + findMaximum(numbers));
        System.out.println("Minimum: " + findMinimum(numbers));
        System.out.println("Average: " + calculateAverage(numbers));
        
        // Example 3: Validation methods
        String email = "user@example.com";
        String phone = "123-456-7890";
        System.out.println("Email valid: " + isValidEmail(email));
        System.out.println("Phone valid: " + isValidPhone(phone));
        
        // Example 4: Mathematical utility methods
        System.out.println("Is prime 17: " + isPrime(17));
        System.out.println("Is prime 15: " + isPrime(15));
        System.out.println("GCD of 48 and 18: " + calculateGCD(48, 18));
        
        System.out.println();
    }
    
    // Utility methods for practical examples
    
    /**
     * Reverses a string
     */
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
    
    /**
     * Counts words in a string
     */
    public static int countWords(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        return str.trim().split("\\s+").length;
    }
    
    /**
     * Checks if a string is a palindrome
     */
    public static boolean isPalindrome(String str) {
        String reversed = reverseString(str);
        return str.equals(reversed);
    }
    
    /**
     * Finds maximum value in an array
     */
    public static int findMaximum(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    
    /**
     * Finds minimum value in an array
     */
    public static int findMinimum(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
    
    /**
     * Validates email format
     */
    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
    
    /**
     * Validates phone number format
     */
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{3}-\\d{3}-\\d{4}");
    }
    
    /**
     * Checks if a number is prime
     */
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Calculates Greatest Common Divisor using Euclidean algorithm
     */
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

/**
 * Helper class to demonstrate static vs instance methods
 */
class StaticMethodsDemo {
    // Static variable
    public static int staticCounter = 0;
    
    // Instance variable
    public String instanceName;
    
    // Constructor
    public StaticMethodsDemo(String name) {
        this.instanceName = name;
    }
    
    // Static method
    public static void staticMethod() {
        staticCounter++;
        System.out.println("Static method called. Counter: " + staticCounter);
    }
    
    // Static method with return value
    public static int staticAdd(int a, int b) {
        return a + b;
    }
    
    // Instance method
    public void instanceMethod() {
        System.out.println("Instance method called on: " + instanceName);
    }
    
    // Instance method with return value
    public int instanceAdd(int a, int b) {
        return a + b;
    }
}
