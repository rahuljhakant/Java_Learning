package com.tutorial.basics;

/**
 * Type Casting Demo - Understanding Data Type Conversions in Java
 * 
 * This comprehensive tutorial demonstrates the concept of type casting in Java,
 * which is the process of converting a value from one data type to another.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what type casting is and why it's important
 * - Learn about implicit (automatic) type casting
 * - Master explicit (manual) type casting
 * - Understand data loss and precision issues
 * - Learn about casting between primitive and wrapper types
 * - Practice safe casting techniques
 * 
 * KEY CONCEPTS:
 * 1. Implicit Casting (Widening): Automatic conversion from smaller to larger data types
 * 2. Explicit Casting (Narrowing): Manual conversion from larger to smaller data types
 * 3. Data Loss: Information that may be lost during casting
 * 4. Type Safety: Ensuring conversions are valid and safe
 * 
 * @author Java Tutorial Team
 * @version 1.0
 * @since 2024
 */
public class TypeCastingDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Type Casting Demo ===");
        System.out.println();
        
        // 1. Implicit Type Casting (Widening)
        demonstrateImplicitCasting();
        
        // 2. Explicit Type Casting (Narrowing)
        demonstrateExplicitCasting();
        
        // 3. Casting with Data Loss
        demonstrateDataLoss();
        
        // 4. Casting Between Primitive and Wrapper Types
        demonstratePrimitiveWrapperCasting();
        
        // 5. String to Number Conversions
        demonstrateStringToNumberCasting();
        
        // 6. Safe Casting Techniques
        demonstrateSafeCasting();
        
        // 7. Character and ASCII Conversions
        demonstrateCharacterCasting();
    }
    
    /**
     * Demonstrates implicit type casting (automatic widening)
     * 
     * Implicit casting occurs automatically when converting from a smaller
     * data type to a larger data type. This is safe because no data is lost.
     * 
     * Casting hierarchy (smallest to largest):
     * byte -> short -> int -> long -> float -> double
     * char -> int -> long -> float -> double
     */
    private static void demonstrateImplicitCasting() {
        System.out.println("1. Implicit Type Casting (Widening):");
        System.out.println("====================================");
        
        // byte to short
        byte byteValue = 100;
        short shortValue = byteValue; // Automatic conversion
        System.out.println("byte " + byteValue + " -> short " + shortValue);
        
        // short to int
        int intValue = shortValue; // Automatic conversion
        System.out.println("short " + shortValue + " -> int " + intValue);
        
        // int to long
        long longValue = intValue; // Automatic conversion
        System.out.println("int " + intValue + " -> long " + longValue);
        
        // long to float
        float floatValue = longValue; // Automatic conversion
        System.out.println("long " + longValue + " -> float " + floatValue);
        
        // float to double
        double doubleValue = floatValue; // Automatic conversion
        System.out.println("float " + floatValue + " -> double " + doubleValue);
        
        // char to int (ASCII value)
        char charValue = 'A';
        int charAsInt = charValue; // Automatic conversion to ASCII
        System.out.println("char '" + charValue + "' -> int " + charAsInt + " (ASCII)");
        
        // Multiple implicit conversions in one expression
        byte b = 50;
        short s = b;
        int i = s;
        long l = i;
        float f = l;
        double d = f;
        System.out.println("Chain: byte " + b + " -> double " + d);
        
        System.out.println();
    }
    
    /**
     * Demonstrates explicit type casting (manual narrowing)
     * 
     * Explicit casting is required when converting from a larger data type
     * to a smaller data type. This can result in data loss and must be done carefully.
     */
    private static void demonstrateExplicitCasting() {
        System.out.println("2. Explicit Type Casting (Narrowing):");
        System.out.println("=====================================");
        
        // double to float
        double doubleValue = 3.14159265359;
        float floatValue = (float) doubleValue; // Explicit cast required
        System.out.println("double " + doubleValue + " -> float " + floatValue);
        
        // float to long
        long longValue = (long) floatValue; // Explicit cast required
        System.out.println("float " + floatValue + " -> long " + longValue);
        
        // long to int
        int intValue = (int) longValue; // Explicit cast required
        System.out.println("long " + longValue + " -> int " + intValue);
        
        // int to short
        short shortValue = (short) intValue; // Explicit cast required
        System.out.println("int " + intValue + " -> short " + shortValue);
        
        // short to byte
        byte byteValue = (byte) shortValue; // Explicit cast required
        System.out.println("short " + shortValue + " -> byte " + byteValue);
        
        // int to char (ASCII to character)
        int asciiValue = 65;
        char charValue = (char) asciiValue; // Explicit cast required
        System.out.println("int " + asciiValue + " -> char '" + charValue + "'");
        
        // Multiple explicit conversions
        double d = 123.456;
        int i = (int) d; // Truncates decimal part
        System.out.println("double " + d + " -> int " + i + " (truncated)");
        
        System.out.println();
    }
    
    /**
     * Demonstrates data loss during casting
     * 
     * When casting from larger to smaller data types, data loss can occur.
     * This section shows examples of where and how data loss happens.
     */
    private static void demonstrateDataLoss() {
        System.out.println("3. Casting with Data Loss:");
        System.out.println("=========================");
        
        // Precision loss: double to float
        double preciseDouble = 3.141592653589793;
        float lessPreciseFloat = (float) preciseDouble;
        System.out.println("Original double: " + preciseDouble);
        System.out.println("After casting to float: " + lessPreciseFloat);
        System.out.println("Precision lost: " + (preciseDouble - lessPreciseFloat));
        
        // Truncation: double to int
        double decimalNumber = 9.99;
        int truncatedInt = (int) decimalNumber;
        System.out.println("Original double: " + decimalNumber);
        System.out.println("After casting to int: " + truncatedInt);
        System.out.println("Decimal part lost: " + (decimalNumber - truncatedInt));
        
        // Overflow: int to byte
        int largeInt = 300;
        byte overflowedByte = (byte) largeInt;
        System.out.println("Original int: " + largeInt);
        System.out.println("After casting to byte: " + overflowedByte);
        System.out.println("Overflow occurred (byte range: -128 to 127)");
        
        // Underflow: negative int to byte
        int negativeInt = -200;
        byte underflowedByte = (byte) negativeInt;
        System.out.println("Original int: " + negativeInt);
        System.out.println("After casting to byte: " + underflowedByte);
        
        // Character to number conversion
        char character = 'Z';
        int asciiValue = (int) character;
        System.out.println("Character '" + character + "' -> ASCII " + asciiValue);
        
        System.out.println();
    }
    
    /**
     * Demonstrates casting between primitive and wrapper types
     * 
     * Java provides automatic boxing and unboxing between primitive types
     * and their corresponding wrapper classes.
     */
    private static void demonstratePrimitiveWrapperCasting() {
        System.out.println("4. Primitive and Wrapper Type Casting:");
        System.out.println("=====================================");
        
        // Primitive to Wrapper (Boxing)
        int primitiveInt = 42;
        Integer wrapperInt = primitiveInt; // Automatic boxing
        System.out.println("Primitive int: " + primitiveInt);
        System.out.println("Wrapper Integer: " + wrapperInt);
        
        // Wrapper to Primitive (Unboxing)
        Integer anotherWrapper = 100;
        int anotherPrimitive = anotherWrapper; // Automatic unboxing
        System.out.println("Wrapper Integer: " + anotherWrapper);
        System.out.println("Primitive int: " + anotherPrimitive);
        
        // Explicit boxing and unboxing
        double primitiveDouble = 3.14;
        Double wrapperDouble = Double.valueOf(primitiveDouble); // Explicit boxing
        double unboxedDouble = wrapperDouble.doubleValue(); // Explicit unboxing
        System.out.println("Explicit boxing: " + primitiveDouble + " -> " + wrapperDouble);
        System.out.println("Explicit unboxing: " + wrapperDouble + " -> " + unboxedDouble);
        
        // Boolean casting
        boolean primitiveBool = true;
        Boolean wrapperBool = primitiveBool; // Automatic boxing
        boolean unboxedBool = wrapperBool; // Automatic unboxing
        System.out.println("Boolean boxing: " + primitiveBool + " -> " + wrapperBool);
        System.out.println("Boolean unboxing: " + wrapperBool + " -> " + unboxedBool);
        
        System.out.println();
    }
    
    /**
     * Demonstrates string to number conversions
     * 
     * Converting strings to numbers is a common operation that requires
     * careful handling to avoid NumberFormatException.
     */
    private static void demonstrateStringToNumberCasting() {
        System.out.println("5. String to Number Conversions:");
        System.out.println("===============================");
        
        // String to int
        String numberString = "123";
        int parsedInt = Integer.parseInt(numberString);
        System.out.println("String \"" + numberString + "\" -> int " + parsedInt);
        
        // String to double
        String decimalString = "45.67";
        double parsedDouble = Double.parseDouble(decimalString);
        System.out.println("String \"" + decimalString + "\" -> double " + parsedDouble);
        
        // String to float
        String floatString = "89.12";
        float parsedFloat = Float.parseFloat(floatString);
        System.out.println("String \"" + floatString + "\" -> float " + parsedFloat);
        
        // String to long
        String longString = "987654321";
        long parsedLong = Long.parseLong(longString);
        System.out.println("String \"" + longString + "\" -> long " + parsedLong);
        
        // Number to String
        int number = 456;
        String stringFromNumber = String.valueOf(number);
        System.out.println("int " + number + " -> String \"" + stringFromNumber + "\"");
        
        // Using toString() method
        double doubleNumber = 78.90;
        String stringFromDouble = Double.toString(doubleNumber);
        System.out.println("double " + doubleNumber + " -> String \"" + stringFromDouble + "\"");
        
        // String concatenation with numbers
        int age = 25;
        String name = "John";
        String message = name + " is " + age + " years old"; // Automatic conversion
        System.out.println("Concatenated message: " + message);
        
        System.out.println();
    }
    
    /**
     * Demonstrates safe casting techniques
     * 
     * Safe casting involves checking if a conversion is valid before
     * attempting it, preventing runtime errors.
     */
    private static void demonstrateSafeCasting() {
        System.out.println("6. Safe Casting Techniques:");
        System.out.println("==========================");
        
        // Safe string to number conversion
        String[] testStrings = {"123", "45.67", "abc", "999999999999999999999"};
        
        for (String str : testStrings) {
            try {
                int safeInt = Integer.parseInt(str);
                System.out.println("String \"" + str + "\" -> int " + safeInt + " (safe)");
            } catch (NumberFormatException e) {
                System.out.println("String \"" + str + "\" -> Cannot convert to int: " + e.getMessage());
            }
        }
        
        // Safe object casting
        Object obj1 = "Hello";
        Object obj2 = 42;
        Object obj3 = new Object();
        
        // Safe string casting
        if (obj1 instanceof String) {
            String safeString = (String) obj1;
            System.out.println("Object \"" + obj1 + "\" -> String \"" + safeString + "\" (safe)");
        }
        
        // Safe integer casting
        if (obj2 instanceof Integer) {
            Integer safeInteger = (Integer) obj2;
            System.out.println("Object " + obj2 + " -> Integer " + safeInteger + " (safe)");
        }
        
        // Unsafe casting attempt
        if (obj3 instanceof String) {
            String unsafeString = (String) obj3;
            System.out.println("This won't execute");
        } else {
            System.out.println("Object " + obj3 + " is not a String, cannot cast safely");
        }
        
        // Range checking for safe casting
        int largeNumber = 1000;
        if (largeNumber >= Byte.MIN_VALUE && largeNumber <= Byte.MAX_VALUE) {
            byte safeByte = (byte) largeNumber;
            System.out.println("int " + largeNumber + " -> byte " + safeByte + " (range safe)");
        } else {
            System.out.println("int " + largeNumber + " is outside byte range, casting unsafe");
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates character and ASCII conversions
     * 
     * Characters in Java are represented using Unicode, and each character
     * has a corresponding numeric value (ASCII/Unicode code point).
     */
    private static void demonstrateCharacterCasting() {
        System.out.println("7. Character and ASCII Conversions:");
        System.out.println("==================================");
        
        // Character to ASCII
        char letter = 'A';
        int asciiValue = (int) letter;
        System.out.println("Character '" + letter + "' -> ASCII " + asciiValue);
        
        // ASCII to Character
        int ascii = 97;
        char character = (char) ascii;
        System.out.println("ASCII " + ascii + " -> Character '" + character + "'");
        
        // Character arithmetic
        char startChar = 'A';
        char nextChar = (char) (startChar + 1);
        System.out.println("Character '" + startChar + "' + 1 = '" + nextChar + "'");
        
        // Case conversion using ASCII
        char lowercase = 'a';
        char uppercase = (char) (lowercase - 32); // ASCII difference
        System.out.println("Lowercase '" + lowercase + "' -> Uppercase '" + uppercase + "'");
        
        // Unicode characters
        char unicodeChar = '\u0041'; // Unicode for 'A'
        System.out.println("Unicode \\u0041 -> Character '" + unicodeChar + "'");
        
        // Character range demonstration
        System.out.println("Character ranges:");
        System.out.println("Digits: '0' = " + (int) '0' + ", '9' = " + (int) '9');
        System.out.println("Uppercase: 'A' = " + (int) 'A' + ", 'Z' = " + (int) 'Z');
        System.out.println("Lowercase: 'a' = " + (int) 'a' + ", 'z' = " + (int) 'z');
        
        // Character classification
        char testChar = '5';
        if (testChar >= '0' && testChar <= '9') {
            System.out.println("Character '" + testChar + "' is a digit");
        } else if (testChar >= 'A' && testChar <= 'Z') {
            System.out.println("Character '" + testChar + "' is uppercase");
        } else if (testChar >= 'a' && testChar <= 'z') {
            System.out.println("Character '" + testChar + "' is lowercase");
        }
        
        System.out.println();
    }
}
