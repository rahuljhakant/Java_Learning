package com.tutorial.projects;

import java.util.Scanner;

/**
 * Simple Calculator Application
 * 
 * This project demonstrates:
 * - Basic Java syntax and structure
 * - User input handling
 * - Control statements (if-else, switch)
 * - Methods and method overloading
 * - Error handling
 * - Object-oriented programming basics
 */
public class Calculator {
    
    private Scanner scanner;
    
    public Calculator() {
        this.scanner = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }
    
    /**
     * Main application loop
     */
    public void run() {
        System.out.println("=== Simple Calculator ===");
        System.out.println("Welcome to the Calculator Application!");
        System.out.println();
        
        boolean continueCalculating = true;
        
        while (continueCalculating) {
            displayMenu();
            int choice = getMenuChoice();
            
            switch (choice) {
                case 1:
                    performAddition();
                    break;
                case 2:
                    performSubtraction();
                    break;
                case 3:
                    performMultiplication();
                    break;
                case 4:
                    performDivision();
                    break;
                case 5:
                    performAdvancedOperations();
                    break;
                case 6:
                    displayHistory();
                    break;
                case 7:
                    continueCalculating = false;
                    System.out.println("Thank you for using the Calculator!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            if (continueCalculating) {
                System.out.println();
                System.out.print("Press Enter to continue...");
                scanner.nextLine();
                System.out.println();
            }
        }
        
        scanner.close();
    }
    
    /**
     * Displays the main menu
     */
    private void displayMenu() {
        System.out.println("Choose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Advanced Operations");
        System.out.println("6. View History");
        System.out.println("7. Exit");
        System.out.print("Enter your choice (1-7): ");
    }
    
    /**
     * Gets user's menu choice
     */
    private int getMenuChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            return choice;
        } catch (Exception e) {
            scanner.nextLine(); // Consume invalid input
            return -1;
        }
    }
    
    /**
     * Performs addition operation
     */
    private void performAddition() {
        System.out.println("\n=== Addition ===");
        double[] numbers = getNumbers(2);
        double result = add(numbers[0], numbers[1]);
        System.out.printf("%.2f + %.2f = %.2f%n", numbers[0], numbers[1], result);
        addToHistory(numbers[0] + " + " + numbers[1] + " = " + result);
    }
    
    /**
     * Performs subtraction operation
     */
    private void performSubtraction() {
        System.out.println("\n=== Subtraction ===");
        double[] numbers = getNumbers(2);
        double result = subtract(numbers[0], numbers[1]);
        System.out.printf("%.2f - %.2f = %.2f%n", numbers[0], numbers[1], result);
        addToHistory(numbers[0] + " - " + numbers[1] + " = " + result);
    }
    
    /**
     * Performs multiplication operation
     */
    private void performMultiplication() {
        System.out.println("\n=== Multiplication ===");
        double[] numbers = getNumbers(2);
        double result = multiply(numbers[0], numbers[1]);
        System.out.printf("%.2f * %.2f = %.2f%n", numbers[0], numbers[1], result);
        addToHistory(numbers[0] + " * " + numbers[1] + " = " + result);
    }
    
    /**
     * Performs division operation
     */
    private void performDivision() {
        System.out.println("\n=== Division ===");
        double[] numbers = getNumbers(2);
        
        if (numbers[1] == 0) {
            System.out.println("Error: Division by zero is not allowed!");
            return;
        }
        
        double result = divide(numbers[0], numbers[1]);
        System.out.printf("%.2f / %.2f = %.2f%n", numbers[0], numbers[1], result);
        addToHistory(numbers[0] + " / " + numbers[1] + " = " + result);
    }
    
    /**
     * Performs advanced operations
     */
    private void performAdvancedOperations() {
        System.out.println("\n=== Advanced Operations ===");
        System.out.println("1. Power (a^b)");
        System.out.println("2. Square Root");
        System.out.println("3. Percentage");
        System.out.println("4. Factorial");
        System.out.print("Choose operation (1-4): ");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    performPower();
                    break;
                case 2:
                    performSquareRoot();
                    break;
                case 3:
                    performPercentage();
                    break;
                case 4:
                    performFactorial();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (Exception e) {
            System.out.println("Invalid input!");
            scanner.nextLine();
        }
    }
    
    /**
     * Performs power operation
     */
    private void performPower() {
        System.out.println("\n=== Power Operation ===");
        double[] numbers = getNumbers(2);
        double result = power(numbers[0], numbers[1]);
        System.out.printf("%.2f ^ %.2f = %.2f%n", numbers[0], numbers[1], result);
        addToHistory(numbers[0] + " ^ " + numbers[1] + " = " + result);
    }
    
    /**
     * Performs square root operation
     */
    private void performSquareRoot() {
        System.out.println("\n=== Square Root ===");
        double number = getNumber();
        
        if (number < 0) {
            System.out.println("Error: Cannot calculate square root of negative number!");
            return;
        }
        
        double result = squareRoot(number);
        System.out.printf("√%.2f = %.2f%n", number, result);
        addToHistory("√" + number + " = " + result);
    }
    
    /**
     * Performs percentage calculation
     */
    private void performPercentage() {
        System.out.println("\n=== Percentage ===");
        System.out.print("Enter the number: ");
        double number = getNumber();
        System.out.print("Enter the percentage: ");
        double percentage = getNumber();
        
        double result = percentage(number, percentage);
        System.out.printf("%.2f%% of %.2f = %.2f%n", percentage, number, result);
        addToHistory(percentage + "% of " + number + " = " + result);
    }
    
    /**
     * Performs factorial operation
     */
    private void performFactorial() {
        System.out.println("\n=== Factorial ===");
        System.out.print("Enter a non-negative integer: ");
        
        try {
            int number = scanner.nextInt();
            scanner.nextLine();
            
            if (number < 0) {
                System.out.println("Error: Factorial is not defined for negative numbers!");
                return;
            }
            
            if (number > 20) {
                System.out.println("Error: Number too large for factorial calculation!");
                return;
            }
            
            long result = factorial(number);
            System.out.printf("%d! = %d%n", number, result);
            addToHistory(number + "! = " + result);
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid integer.");
            scanner.nextLine();
        }
    }
    
    /**
     * Gets numbers from user input
     */
    private double[] getNumbers(int count) {
        double[] numbers = new double[count];
        
        for (int i = 0; i < count; i++) {
            System.out.printf("Enter number %d: ", i + 1);
            numbers[i] = getNumber();
        }
        
        return numbers;
    }
    
    /**
     * Gets a single number from user input
     */
    private double getNumber() {
        while (true) {
            try {
                double number = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                return number;
            } catch (Exception e) {
                System.out.print("Invalid input! Please enter a valid number: ");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }
    
    // Mathematical operations
    
    /**
     * Adds two numbers
     */
    public double add(double a, double b) {
        return a + b;
    }
    
    /**
     * Subtracts two numbers
     */
    public double subtract(double a, double b) {
        return a - b;
    }
    
    /**
     * Multiplies two numbers
     */
    public double multiply(double a, double b) {
        return a * b;
    }
    
    /**
     * Divides two numbers
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
    
    /**
     * Calculates power
     */
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    /**
     * Calculates square root
     */
    public double squareRoot(double number) {
        return Math.sqrt(number);
    }
    
    /**
     * Calculates percentage
     */
    public double percentage(double number, double percentage) {
        return (number * percentage) / 100;
    }
    
    /**
     * Calculates factorial
     */
    public long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    // History management
    
    private java.util.List<String> history = new java.util.ArrayList<>();
    
    /**
     * Adds operation to history
     */
    private void addToHistory(String operation) {
        history.add(operation);
    }
    
    /**
     * Displays calculation history
     */
    private void displayHistory() {
        System.out.println("\n=== Calculation History ===");
        
        if (history.isEmpty()) {
            System.out.println("No calculations performed yet.");
        } else {
            for (int i = 0; i < history.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, history.get(i));
            }
        }
    }
}
