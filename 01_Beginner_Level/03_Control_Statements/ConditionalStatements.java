package com.tutorial.basics;

import java.util.Scanner;

/**
 * Conditional Statements Demo
 * 
 * This class demonstrates:
 * - if statement
 * - if-else statement
 * - if-else-if ladder
 * - Nested if statements
 * - switch statement
 * - switch with multiple cases
 * - switch with strings (Java 7+)
 * - switch expressions (Java 14+)
 */
public class ConditionalStatements {
    
    public static void main(String[] args) {
        System.out.println("=== Conditional Statements Demo ===");
        System.out.println();
        
        // 1. If Statement
        demonstrateIfStatement();
        
        // 2. If-Else Statement
        demonstrateIfElseStatement();
        
        // 3. If-Else-If Ladder
        demonstrateIfElseIfLadder();
        
        // 4. Nested If Statements
        demonstrateNestedIfStatements();
        
        // 5. Switch Statement
        demonstrateSwitchStatement();
        
        // 6. Switch with Strings
        demonstrateSwitchWithStrings();
        
        // 7. Switch Expressions (Java 14+)
        demonstrateSwitchExpressions();
        
        // 8. Interactive Example
        interactiveGradeCalculator();
    }
    
    /**
     * Demonstrates basic if statement
     */
    private static void demonstrateIfStatement() {
        System.out.println("1. If Statement:");
        System.out.println("================");
        
        int age = 18;
        System.out.println("Age: " + age);
        
        if (age >= 18) {
            System.out.println("You are eligible to vote!");
        }
        
        // Another example
        int temperature = 25;
        System.out.println("\nTemperature: " + temperature + "°C");
        
        if (temperature > 30) {
            System.out.println("It's hot outside!");
        }
        
        if (temperature < 10) {
            System.out.println("It's cold outside!");
        }
        
        if (temperature >= 10 && temperature <= 30) {
            System.out.println("The weather is pleasant!");
        }
        System.out.println();
    }
    
    /**
     * Demonstrates if-else statement
     */
    private static void demonstrateIfElseStatement() {
        System.out.println("2. If-Else Statement:");
        System.out.println("====================");
        
        int number = 7;
        System.out.println("Number: " + number);
        
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
        
        // Another example
        int score = 85;
        System.out.println("\nScore: " + score);
        
        if (score >= 60) {
            System.out.println("You passed the exam!");
        } else {
            System.out.println("You failed the exam. Better luck next time!");
        }
        System.out.println();
    }
    
    /**
     * Demonstrates if-else-if ladder
     */
    private static void demonstrateIfElseIfLadder() {
        System.out.println("3. If-Else-If Ladder:");
        System.out.println("====================");
        
        int marks = 78;
        System.out.println("Marks: " + marks);
        
        if (marks >= 90) {
            System.out.println("Grade: A+ (Excellent!)");
        } else if (marks >= 80) {
            System.out.println("Grade: A (Very Good!)");
        } else if (marks >= 70) {
            System.out.println("Grade: B (Good!)");
        } else if (marks >= 60) {
            System.out.println("Grade: C (Satisfactory)");
        } else if (marks >= 50) {
            System.out.println("Grade: D (Needs Improvement)");
        } else {
            System.out.println("Grade: F (Failed)");
        }
        
        // Another example - time of day
        int hour = 14; // 2 PM
        System.out.println("\nCurrent hour: " + hour);
        
        if (hour < 6) {
            System.out.println("Good night!");
        } else if (hour < 12) {
            System.out.println("Good morning!");
        } else if (hour < 18) {
            System.out.println("Good afternoon!");
        } else {
            System.out.println("Good evening!");
        }
        System.out.println();
    }
    
    /**
     * Demonstrates nested if statements
     */
    private static void demonstrateNestedIfStatements() {
        System.out.println("4. Nested If Statements:");
        System.out.println("========================");
        
        int age = 25;
        boolean hasLicense = true;
        boolean hasInsurance = false;
        
        System.out.println("Age: " + age);
        System.out.println("Has License: " + hasLicense);
        System.out.println("Has Insurance: " + hasInsurance);
        
        if (age >= 18) {
            System.out.println("You are old enough to drive.");
            if (hasLicense) {
                System.out.println("You have a valid license.");
                if (hasInsurance) {
                    System.out.println("You can drive legally!");
                } else {
                    System.out.println("You need insurance to drive legally.");
                }
            } else {
                System.out.println("You need a license to drive.");
            }
        } else {
            System.out.println("You are too young to drive.");
        }
        
        // Another example - login system
        String username = "admin";
        String password = "password123";
        boolean isAccountActive = true;
        
        System.out.println("\nLogin attempt:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Account Active: " + isAccountActive);
        
        if (username.equals("admin")) {
            if (password.equals("password123")) {
                if (isAccountActive) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Account is deactivated.");
                }
            } else {
                System.out.println("Invalid password.");
            }
        } else {
            System.out.println("Invalid username.");
        }
        System.out.println();
    }
    
    /**
     * Demonstrates switch statement with integers
     */
    private static void demonstrateSwitchStatement() {
        System.out.println("5. Switch Statement:");
        System.out.println("===================");
        
        int dayOfWeek = 3;
        System.out.println("Day of week (1-7): " + dayOfWeek);
        
        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday - Start of the work week!");
                break;
            case 2:
                System.out.println("Tuesday - Getting into the groove.");
                break;
            case 3:
                System.out.println("Wednesday - Midweek!");
                break;
            case 4:
                System.out.println("Thursday - Almost there!");
                break;
            case 5:
                System.out.println("Friday - TGIF!");
                break;
            case 6:
                System.out.println("Saturday - Weekend begins!");
                break;
            case 7:
                System.out.println("Sunday - Relax and recharge!");
                break;
            default:
                System.out.println("Invalid day of week!");
                break;
        }
        
        // Switch with multiple cases
        char grade = 'B';
        System.out.println("\nGrade: " + grade);
        
        switch (grade) {
            case 'A':
            case 'a':
                System.out.println("Excellent work!");
                break;
            case 'B':
            case 'b':
                System.out.println("Good job!");
                break;
            case 'C':
            case 'c':
                System.out.println("Satisfactory.");
                break;
            case 'D':
            case 'd':
                System.out.println("Needs improvement.");
                break;
            case 'F':
            case 'f':
                System.out.println("Failed. Please try again.");
                break;
            default:
                System.out.println("Invalid grade!");
                break;
        }
        System.out.println();
    }
    
    /**
     * Demonstrates switch statement with strings (Java 7+)
     */
    private static void demonstrateSwitchWithStrings() {
        System.out.println("6. Switch with Strings (Java 7+):");
        System.out.println("=================================");
        
        String month = "March";
        System.out.println("Month: " + month);
        
        switch (month.toLowerCase()) {
            case "december":
            case "january":
            case "february":
                System.out.println("It's winter!");
                break;
            case "march":
            case "april":
            case "may":
                System.out.println("It's spring!");
                break;
            case "june":
            case "july":
            case "august":
                System.out.println("It's summer!");
                break;
            case "september":
            case "october":
            case "november":
                System.out.println("It's autumn!");
                break;
            default:
                System.out.println("Invalid month!");
                break;
        }
        
        // Another example - programming language
        String language = "Java";
        System.out.println("\nProgramming Language: " + language);
        
        switch (language) {
            case "Java":
                System.out.println("Java: Write once, run anywhere!");
                break;
            case "Python":
                System.out.println("Python: Simple and powerful!");
                break;
            case "C++":
                System.out.println("C++: Fast and efficient!");
                break;
            case "JavaScript":
                System.out.println("JavaScript: The language of the web!");
                break;
            default:
                System.out.println("Unknown programming language!");
                break;
        }
        System.out.println();
    }
    
    /**
     * Demonstrates switch expressions (Java 14+)
     */
    private static void demonstrateSwitchExpressions() {
        System.out.println("7. Switch Expressions (Java 14+):");
        System.out.println("=================================");
        
        int day = 5;
        System.out.println("Day: " + day);
        
        // Switch expression with yield
        String dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid day";
        };
        
        System.out.println("Day type: " + dayType);
        
        // Switch expression with multiple statements
        int score = 85;
        System.out.println("\nScore: " + score);
        
        String grade = switch (score / 10) {
            case 10, 9 -> {
                System.out.println("Excellent performance!");
                yield "A";
            }
            case 8 -> {
                System.out.println("Very good performance!");
                yield "B";
            }
            case 7 -> {
                System.out.println("Good performance!");
                yield "C";
            }
            case 6 -> {
                System.out.println("Satisfactory performance!");
                yield "D";
            }
            default -> {
                System.out.println("Needs improvement!");
                yield "F";
            }
        };
        
        System.out.println("Grade: " + grade);
        System.out.println();
    }
    
    /**
     * Interactive grade calculator using conditional statements
     */
    private static void interactiveGradeCalculator() {
        System.out.println("8. Interactive Grade Calculator:");
        System.out.println("================================");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter marks (0-100): ");
        int marks = scanner.nextInt();
        
        System.out.println("\nStudent: " + name);
        System.out.println("Marks: " + marks);
        
        // Using if-else-if ladder
        String grade;
        String comment;
        
        if (marks >= 90) {
            grade = "A+";
            comment = "Outstanding! Keep up the excellent work!";
        } else if (marks >= 80) {
            grade = "A";
            comment = "Excellent! You're doing great!";
        } else if (marks >= 70) {
            grade = "B";
            comment = "Very good! Well done!";
        } else if (marks >= 60) {
            grade = "C";
            comment = "Good! Keep working hard!";
        } else if (marks >= 50) {
            grade = "D";
            comment = "Satisfactory. Try to improve!";
        } else {
            grade = "F";
            comment = "Failed. Please study harder and try again!";
        }
        
        System.out.println("Grade: " + grade);
        System.out.println("Comment: " + comment);
        
        // Using switch for additional feedback
        switch (grade) {
            case "A+":
            case "A":
                System.out.println("🎉 Congratulations! You've earned a scholarship consideration!");
                break;
            case "B":
                System.out.println("👍 Great job! You're on the right track!");
                break;
            case "C":
                System.out.println("📚 Good work! Consider additional study time.");
                break;
            case "D":
                System.out.println("📖 Keep studying! You can improve!");
                break;
            case "F":
                System.out.println("💪 Don't give up! Seek help and try again!");
                break;
        }
        
        scanner.close();
        System.out.println();
    }
}
