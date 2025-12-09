package com.tutorial.beginner;

/**
 * Variables and Data Types Demo
 * 
 * This class demonstrates:
 * - Different data types in Java
 * - Variable declaration and initialization
 * - Literals and constants
 * - Variable scope and lifetime
 * - Type conversion
 */
public class VariablesDemo {
    
    // Class-level (instance) variables
    private String className = "VariablesDemo";
    private static int classCounter = 0;
    
    public static void main(String[] args) {
        System.out.println("=== Variables and Data Types Demo ===");
        System.out.println();
        
        // 1. Primitive Data Types
        demonstratePrimitiveTypes();
        
        // 2. Reference Data Types
        demonstrateReferenceTypes();
        
        // 3. Variable Scope
        demonstrateVariableScope();
        
        // 4. Constants and Final Variables
        demonstrateConstants();
        
        // 5. Type Conversion
        demonstrateTypeConversion();
    }
    
    /**
     * Demonstrates all primitive data types in Java
     */
    private static void demonstratePrimitiveTypes() {
        System.out.println("1. Primitive Data Types:");
        System.out.println("========================");
        
        // Integer types
        byte byteValue = 127;                    // 8-bit signed integer (-128 to 127)
        short shortValue = 32000;                // 16-bit signed integer (-32,768 to 32,767)
        int intValue = 2147483647;               // 32-bit signed integer (-2^31 to 2^31-1)
        long longValue = 9223372036854775807L;   // 64-bit signed integer (-2^63 to 2^63-1)
        
        // Floating-point types
        float floatValue = 3.14159f;             // 32-bit IEEE 754 floating point
        double doubleValue = 3.141592653589793;  // 64-bit IEEE 754 floating point
        
        // Character type
        char charValue = 'A';                    // 16-bit Unicode character
        
        // Boolean type
        boolean booleanValue = true;             // true or false
        
        // Display values
        System.out.println("byte: " + byteValue + " (size: 8 bits)");
        System.out.println("short: " + shortValue + " (size: 16 bits)");
        System.out.println("int: " + intValue + " (size: 32 bits)");
        System.out.println("long: " + longValue + " (size: 64 bits)");
        System.out.println("float: " + floatValue + " (size: 32 bits)");
        System.out.println("double: " + doubleValue + " (size: 64 bits)");
        System.out.println("char: " + charValue + " (size: 16 bits)");
        System.out.println("boolean: " + booleanValue + " (size: 1 bit)");
        System.out.println();
    }
    
    /**
     * Demonstrates reference data types
     */
    private static void demonstrateReferenceTypes() {
        System.out.println("2. Reference Data Types:");
        System.out.println("========================");
        
        // String (most commonly used reference type)
        String stringValue = "Hello, Java!";
        String anotherString = new String("Created with new keyword");
        
        // Arrays
        int[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Java", "Python", "C++", "JavaScript"};
        
        // Objects (using built-in classes)
        Integer integerObject = Integer.valueOf(42);
        Double doubleObject = Double.valueOf(3.14);
        
        // Display values
        System.out.println("String: " + stringValue);
        System.out.println("Another String: " + anotherString);
        System.out.println("Integer Object: " + integerObject);
        System.out.println("Double Object: " + doubleObject);
        
        // Display arrays
        System.out.print("Int Array: [");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]);
            if (i < intArray.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        
        System.out.print("String Array: [");
        for (int i = 0; i < stringArray.length; i++) {
            System.out.print(stringArray[i]);
            if (i < stringArray.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println();
    }
    
    /**
     * Demonstrates variable scope
     */
    private static void demonstrateVariableScope() {
        System.out.println("3. Variable Scope:");
        System.out.println("==================");
        
        // Local variables (scope limited to this method)
        int localVar = 100;
        String localString = "I'm a local variable";
        
        System.out.println("Local variable: " + localVar);
        System.out.println("Local string: " + localString);
        
        // Block scope
        {
            int blockVar = 200;
            System.out.println("Block variable: " + blockVar);
        }
        // blockVar is not accessible here - it's out of scope
        
        // Static variable (class-level)
        classCounter++;
        System.out.println("Static class counter: " + classCounter);
        System.out.println();
    }
    
    /**
     * Demonstrates constants and final variables
     */
    private static void demonstrateConstants() {
        System.out.println("4. Constants and Final Variables:");
        System.out.println("=================================");
        
        // Final variables (constants)
        final int MAX_SIZE = 100;
        final String COMPANY_NAME = "Java Tutorial Corp";
        final double PI = 3.14159265359;
        
        // Compile-time constants
        final int COMPILE_TIME_CONSTANT = 42;
        
        System.out.println("Max Size: " + MAX_SIZE);
        System.out.println("Company Name: " + COMPANY_NAME);
        System.out.println("PI: " + PI);
        System.out.println("Compile-time constant: " + COMPILE_TIME_CONSTANT);
        
        // Note: You cannot reassign final variables
        // MAX_SIZE = 200; // This would cause a compilation error
        System.out.println();
    }
    
    /**
     * Demonstrates type conversion (casting)
     */
    private static void demonstrateTypeConversion() {
        System.out.println("5. Type Conversion:");
        System.out.println("==================");
        
        // Implicit conversion (widening)
        int intVal = 100;
        long longVal = intVal;        // int to long (automatic)
        float floatVal = intVal;      // int to float (automatic)
        double doubleVal = floatVal;  // float to double (automatic)
        
        System.out.println("Implicit conversion:");
        System.out.println("int " + intVal + " -> long " + longVal);
        System.out.println("int " + intVal + " -> float " + floatVal);
        System.out.println("float " + floatVal + " -> double " + doubleVal);
        
        // Explicit conversion (narrowing)
        double d = 3.14159;
        float f = (float) d;          // double to float (explicit cast)
        long l = 123456789L;
        int i = (int) l;              // long to int (explicit cast)
        short s = (short) i;          // int to short (explicit cast)
        byte b = (byte) s;            // short to byte (explicit cast)
        
        System.out.println("\nExplicit conversion:");
        System.out.println("double " + d + " -> float " + f);
        System.out.println("long " + l + " -> int " + i);
        System.out.println("int " + i + " -> short " + s);
        System.out.println("short " + s + " -> byte " + b);
        
        // String conversion
        int number = 42;
        String numberString = String.valueOf(number);
        String concatenated = "The number is: " + number;  // Automatic conversion
        
        System.out.println("\nString conversion:");
        System.out.println("int " + number + " -> String " + numberString);
        System.out.println("Concatenated: " + concatenated);
        System.out.println();
    }
}
