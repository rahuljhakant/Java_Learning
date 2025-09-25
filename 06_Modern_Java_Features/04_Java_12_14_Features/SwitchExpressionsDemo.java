package com.tutorial.modern.java.features;

/**
 * Switch Expressions Demo - Modern Switch Syntax
 * 
 * This comprehensive tutorial demonstrates switch expressions introduced in Java 12
 * and enhanced in Java 13 and 14. Switch expressions provide a more concise and
 * expressive way to handle multiple conditions, with improved type safety and
 * better control flow.
 * 
 * LEARNING OBJECTIVES:
 * - Understand switch expression syntax and benefits
 * - Use arrow syntax for cleaner code
 * - Implement yield statements for complex logic
 * - Apply pattern matching in switch expressions
 * - Convert traditional switch statements to expressions
 * - Handle multiple cases and default values
 * 
 * KEY CONCEPTS:
 * 1. Switch Expression Syntax: Modern switch with arrow operators
 * 2. Yield Statements: Returning values from switch expressions
 * 3. Multiple Case Labels: Handling multiple values in one case
 * 4. Type Safety: Compile-time checking for exhaustiveness
 * 5. Pattern Matching: Using patterns in switch expressions
 * 6. Best Practices: When and how to use switch expressions
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class SwitchExpressionsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Switch Expressions Demo ===");
        System.out.println();
        
        // 1. Basic Switch Expressions
        demonstrateBasicSwitchExpressions();
        
        // 2. Switch with Yield Statements
        demonstrateYieldStatements();
        
        // 3. Multiple Case Labels
        demonstrateMultipleCaseLabels();
        
        // 4. Switch with Complex Logic
        demonstrateComplexLogic();
        
        // 5. Switch with Enums
        demonstrateEnumSwitch();
        
        // 6. Switch with Pattern Matching
        demonstratePatternMatching();
        
        // 7. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic switch expressions with arrow syntax
     */
    private static void demonstrateBasicSwitchExpressions() {
        System.out.println("1. Basic Switch Expressions:");
        System.out.println("============================");
        
        int dayOfWeek = 3;
        
        // Traditional switch statement
        String traditionalResult;
        switch (dayOfWeek) {
            case 1:
                traditionalResult = "Monday";
                break;
            case 2:
                traditionalResult = "Tuesday";
                break;
            case 3:
                traditionalResult = "Wednesday";
                break;
            default:
                traditionalResult = "Unknown";
        }
        
        // Modern switch expression
        String modernResult = switch (dayOfWeek) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Unknown";
        };
        
        System.out.println("Traditional: " + traditionalResult);
        System.out.println("Modern: " + modernResult);
        System.out.println();
    }
    
    /**
     * Demonstrates switch expressions with yield statements
     */
    private static void demonstrateYieldStatements() {
        System.out.println("2. Switch with Yield Statements:");
        System.out.println("===============================");
        
        int score = 85;
        
        String grade = switch (score) {
            case 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 -> "A";
            case 80, 81, 82, 83, 84, 85, 86, 87, 88, 89 -> "B";
            case 70, 71, 72, 73, 74, 75, 76, 77, 78, 79 -> "C";
            case 60, 61, 62, 63, 64, 65, 66, 67, 68, 69 -> "D";
            default -> {
                if (score < 0) {
                    yield "Invalid Score";
                } else {
                    yield "F";
                }
            }
        };
        
        System.out.println("Score: " + score + ", Grade: " + grade);
        System.out.println();
    }
    
    /**
     * Demonstrates multiple case labels in switch expressions
     */
    private static void demonstrateMultipleCaseLabels() {
        System.out.println("3. Multiple Case Labels:");
        System.out.println("=======================");
        
        String month = "March";
        
        String season = switch (month) {
            case "December", "January", "February" -> "Winter";
            case "March", "April", "May" -> "Spring";
            case "June", "July", "August" -> "Summer";
            case "September", "October", "November" -> "Fall";
            default -> "Unknown Season";
        };
        
        System.out.println("Month: " + month + ", Season: " + season);
        System.out.println();
    }
    
    /**
     * Demonstrates switch expressions with complex logic
     */
    private static void demonstrateComplexLogic() {
        System.out.println("4. Switch with Complex Logic:");
        System.out.println("=============================");
        
        int temperature = 25;
        
        String weatherAdvice = switch (temperature) {
            case 0, 1, 2, 3, 4, 5 -> "Very cold, wear heavy winter clothes";
            case 6, 7, 8, 9, 10 -> "Cold, wear warm clothes";
            case 11, 12, 13, 14, 15 -> "Cool, wear light jacket";
            case 16, 17, 18, 19, 20 -> "Mild, comfortable clothing";
            case 21, 22, 23, 24, 25 -> "Warm, light clothing";
            case 26, 27, 28, 29, 30 -> "Hot, wear summer clothes";
            default -> {
                if (temperature < 0) {
                    yield "Extremely cold, stay indoors";
                } else if (temperature > 30) {
                    yield "Extremely hot, stay hydrated";
                } else {
                    yield "Temperature not in range";
                }
            }
        };
        
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Advice: " + weatherAdvice);
        System.out.println();
    }
    
    /**
     * Demonstrates switch expressions with enums
     */
    private static void demonstrateEnumSwitch() {
        System.out.println("5. Switch with Enums:");
        System.out.println("====================");
        
        Day day = Day.WEDNESDAY;
        
        String dayType = switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
            case SATURDAY, SUNDAY -> "Weekend";
        };
        
        String dayDescription = switch (day) {
            case MONDAY -> "Start of work week";
            case TUESDAY -> "Second day of work";
            case WEDNESDAY -> "Midweek";
            case THURSDAY -> "Almost weekend";
            case FRIDAY -> "TGIF!";
            case SATURDAY -> "Weekend relaxation";
            case SUNDAY -> "Weekend preparation";
        };
        
        System.out.println("Day: " + day);
        System.out.println("Type: " + dayType);
        System.out.println("Description: " + dayDescription);
        System.out.println();
    }
    
    /**
     * Demonstrates switch expressions with pattern matching
     */
    private static void demonstratePatternMatching() {
        System.out.println("6. Switch with Pattern Matching:");
        System.out.println("===============================");
        
        Object obj = "Hello World";
        
        String result = switch (obj) {
            case String s when s.length() > 10 -> "Long string: " + s;
            case String s when s.length() > 5 -> "Medium string: " + s;
            case String s -> "Short string: " + s;
            case Integer i when i > 100 -> "Large number: " + i;
            case Integer i -> "Small number: " + i;
            case Double d -> "Double value: " + d;
            case null -> "Null value";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };
        
        System.out.println("Object: " + obj);
        System.out.println("Result: " + result);
        System.out.println();
    }
    
    /**
     * Demonstrates best practices for switch expressions
     */
    private static void demonstrateBestPractices() {
        System.out.println("7. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use switch expressions for value assignment");
        System.out.println("✓ Prefer arrow syntax for simple cases");
        System.out.println("✓ Use yield for complex logic blocks");
        System.out.println("✓ Handle all possible cases (exhaustiveness)");
        System.out.println("✓ Use multiple case labels for related values");
        System.out.println("✓ Consider pattern matching for type checking");
        System.out.println("✓ Keep switch expressions readable and maintainable");
        System.out.println("✓ Use default case for unexpected values");
        
        System.out.println();
    }
    
    /**
     * Enum for demonstration
     */
    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    
    /**
     * Utility method to demonstrate switch expression in method
     */
    public static String getDayType(Day day) {
        return switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
            case SATURDAY, SUNDAY -> "Weekend";
        };
    }
    
    /**
     * Utility method to demonstrate switch expression with yield
     */
    public static String getTemperatureDescription(int temp) {
        return switch (temp) {
            case 0, 1, 2, 3, 4, 5 -> "Freezing";
            case 6, 7, 8, 9, 10 -> "Very Cold";
            case 11, 12, 13, 14, 15 -> "Cold";
            case 16, 17, 18, 19, 20 -> "Cool";
            case 21, 22, 23, 24, 25 -> "Warm";
            case 26, 27, 28, 29, 30 -> "Hot";
            default -> {
                if (temp < 0) {
                    yield "Extremely Cold";
                } else if (temp > 30) {
                    yield "Extremely Hot";
                } else {
                    yield "Temperature not in range";
                }
            }
        };
    }
}
