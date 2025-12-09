package com.tutorial.beginner;

/**
 * Operators and Expressions Demo
 * 
 * This class demonstrates:
 * - Arithmetic operators
 * - Relational operators
 * - Logical operators
 * - Bitwise operators
 * - Assignment operators
 * - Conditional (ternary) operator
 * - Operator precedence
 */
public class OperatorsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Operators and Expressions Demo ===");
        System.out.println();
        
        // 1. Arithmetic Operators
        demonstrateArithmeticOperators();
        
        // 2. Relational Operators
        demonstrateRelationalOperators();
        
        // 3. Logical Operators
        demonstrateLogicalOperators();
        
        // 4. Bitwise Operators
        demonstrateBitwiseOperators();
        
        // 5. Assignment Operators
        demonstrateAssignmentOperators();
        
        // 6. Conditional Operator
        demonstrateConditionalOperator();
        
        // 7. Operator Precedence
        demonstrateOperatorPrecedence();
    }
    
    /**
     * Demonstrates arithmetic operators: +, -, *, /, %, ++, --
     */
    private static void demonstrateArithmeticOperators() {
        System.out.println("1. Arithmetic Operators:");
        System.out.println("========================");
        
        int a = 15;
        int b = 4;
        
        System.out.println("a = " + a + ", b = " + b);
        System.out.println();
        
        // Basic arithmetic operations
        System.out.println("Addition (a + b): " + (a + b));
        System.out.println("Subtraction (a - b): " + (a - b));
        System.out.println("Multiplication (a * b): " + (a * b));
        System.out.println("Division (a / b): " + (a / b));
        System.out.println("Modulus (a % b): " + (a % b));
        System.out.println();
        
        // Increment and decrement operators
        int x = 5;
        System.out.println("Original x = " + x);
        System.out.println("Pre-increment (++x): " + (++x) + " (x is now " + x + ")");
        System.out.println("Post-increment (x++): " + (x++) + " (x is now " + x + ")");
        System.out.println("Pre-decrement (--x): " + (--x) + " (x is now " + x + ")");
        System.out.println("Post-decrement (x--): " + (x--) + " (x is now " + x + ")");
        System.out.println();
        
        // Floating-point arithmetic
        double d1 = 10.5;
        double d2 = 3.2;
        System.out.println("Floating-point division (" + d1 + " / " + d2 + "): " + (d1 / d2));
        System.out.println();
    }
    
    /**
     * Demonstrates relational operators: ==, !=, <, >, <=, >=
     */
    private static void demonstrateRelationalOperators() {
        System.out.println("2. Relational Operators:");
        System.out.println("========================");
        
        int a = 10;
        int b = 20;
        int c = 10;
        
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        System.out.println();
        
        System.out.println("a == b (equal to): " + (a == b));
        System.out.println("a == c (equal to): " + (a == c));
        System.out.println("a != b (not equal to): " + (a != b));
        System.out.println("a != c (not equal to): " + (a != c));
        System.out.println("a < b (less than): " + (a < b));
        System.out.println("a > b (greater than): " + (a > b));
        System.out.println("a <= b (less than or equal): " + (a <= b));
        System.out.println("a >= b (greater than or equal): " + (a >= b));
        System.out.println();
    }
    
    /**
     * Demonstrates logical operators: &&, ||, !
     */
    private static void demonstrateLogicalOperators() {
        System.out.println("3. Logical Operators:");
        System.out.println("====================");
        
        boolean p = true;
        boolean q = false;
        
        System.out.println("p = " + p + ", q = " + q);
        System.out.println();
        
        // Logical AND (&&) - short-circuit evaluation
        System.out.println("p && q (logical AND): " + (p && q));
        System.out.println("p && p (logical AND): " + (p && p));
        System.out.println("q && q (logical AND): " + (q && q));
        
        // Logical OR (||) - short-circuit evaluation
        System.out.println("p || q (logical OR): " + (p || q));
        System.out.println("p || p (logical OR): " + (p || p));
        System.out.println("q || q (logical OR): " + (q || q));
        
        // Logical NOT (!)
        System.out.println("!p (logical NOT): " + (!p));
        System.out.println("!q (logical NOT): " + (!q));
        System.out.println();
        
        // Short-circuit evaluation example
        System.out.println("Short-circuit evaluation:");
        System.out.println("false && (5/0 == 0): " + (false && (5/0 == 0))); // No error due to short-circuit
        System.out.println("true || (5/0 == 0): " + (true || (5/0 == 0)));   // No error due to short-circuit
        System.out.println();
    }
    
    /**
     * Demonstrates bitwise operators: &, |, ^, ~, <<, >>, >>>
     */
    private static void demonstrateBitwiseOperators() {
        System.out.println("4. Bitwise Operators:");
        System.out.println("====================");
        
        int a = 12;  // Binary: 1100
        int b = 10;  // Binary: 1010
        
        System.out.println("a = " + a + " (binary: " + Integer.toBinaryString(a) + ")");
        System.out.println("b = " + b + " (binary: " + Integer.toBinaryString(b) + ")");
        System.out.println();
        
        // Bitwise AND
        System.out.println("a & b (bitwise AND): " + (a & b) + " (binary: " + Integer.toBinaryString(a & b) + ")");
        
        // Bitwise OR
        System.out.println("a | b (bitwise OR): " + (a | b) + " (binary: " + Integer.toBinaryString(a | b) + ")");
        
        // Bitwise XOR
        System.out.println("a ^ b (bitwise XOR): " + (a ^ b) + " (binary: " + Integer.toBinaryString(a ^ b) + ")");
        
        // Bitwise NOT
        System.out.println("~a (bitwise NOT): " + (~a) + " (binary: " + Integer.toBinaryString(~a) + ")");
        
        // Left shift
        System.out.println("a << 2 (left shift): " + (a << 2) + " (binary: " + Integer.toBinaryString(a << 2) + ")");
        
        // Right shift (signed)
        System.out.println("a >> 2 (right shift): " + (a >> 2) + " (binary: " + Integer.toBinaryString(a >> 2) + ")");
        
        // Unsigned right shift
        System.out.println("a >>> 2 (unsigned right shift): " + (a >>> 2) + " (binary: " + Integer.toBinaryString(a >>> 2) + ")");
        System.out.println();
    }
    
    /**
     * Demonstrates assignment operators: =, +=, -=, *=, /=, %=, etc.
     */
    private static void demonstrateAssignmentOperators() {
        System.out.println("5. Assignment Operators:");
        System.out.println("=======================");
        
        int x = 10;
        System.out.println("Initial x = " + x);
        
        // Compound assignment operators
        x += 5;  // x = x + 5
        System.out.println("After x += 5: " + x);
        
        x -= 3;  // x = x - 3
        System.out.println("After x -= 3: " + x);
        
        x *= 2;  // x = x * 2
        System.out.println("After x *= 2: " + x);
        
        x /= 4;  // x = x / 4
        System.out.println("After x /= 4: " + x);
        
        x %= 3;  // x = x % 3
        System.out.println("After x %= 3: " + x);
        
        // Bitwise assignment operators
        x &= 7;  // x = x & 7
        System.out.println("After x &= 7: " + x);
        
        x |= 2;  // x = x | 2
        System.out.println("After x |= 2: " + x);
        
        x ^= 1;  // x = x ^ 1
        System.out.println("After x ^= 1: " + x);
        
        x <<= 2; // x = x << 2
        System.out.println("After x <<= 2: " + x);
        
        x >>= 1; // x = x >> 1
        System.out.println("After x >>= 1: " + x);
        System.out.println();
    }
    
    /**
     * Demonstrates the conditional (ternary) operator: condition ? value1 : value2
     */
    private static void demonstrateConditionalOperator() {
        System.out.println("6. Conditional (Ternary) Operator:");
        System.out.println("=================================");
        
        int a = 10;
        int b = 20;
        
        // Basic conditional operator
        int max = (a > b) ? a : b;
        System.out.println("Maximum of " + a + " and " + b + " is: " + max);
        
        // Nested conditional operator
        int c = 15;
        int largest = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
        System.out.println("Largest of " + a + ", " + b + ", and " + c + " is: " + largest);
        
        // String conditional
        String result = (a % 2 == 0) ? "even" : "odd";
        System.out.println(a + " is " + result);
        
        // Boolean conditional
        boolean isPositive = (a > 0) ? true : false;
        System.out.println(a + " is positive: " + isPositive);
        System.out.println();
    }
    
    /**
     * Demonstrates operator precedence
     */
    private static void demonstrateOperatorPrecedence() {
        System.out.println("7. Operator Precedence:");
        System.out.println("======================");
        
        int a = 2, b = 3, c = 4;
        
        // Without parentheses (following precedence rules)
        int result1 = a + b * c;
        System.out.println("a + b * c = " + a + " + " + b + " * " + c + " = " + result1);
        
        // With parentheses (explicit precedence)
        int result2 = (a + b) * c;
        System.out.println("(a + b) * c = (" + a + " + " + b + ") * " + c + " = " + result2);
        
        // Complex expression
        int result3 = a + b * c - a / b;
        System.out.println("a + b * c - a / b = " + a + " + " + b + " * " + c + " - " + a + " / " + b + " = " + result3);
        
        // Logical operator precedence
        boolean p = true, q = false, r = true;
        boolean result4 = p || q && r;
        System.out.println("p || q && r = " + p + " || " + q + " && " + r + " = " + result4);
        
        boolean result5 = (p || q) && r;
        System.out.println("(p || q) && r = (" + p + " || " + q + ") && " + r + " = " + result5);
        
        System.out.println();
        System.out.println("Operator Precedence (highest to lowest):");
        System.out.println("1. Postfix: ++, --");
        System.out.println("2. Unary: +, -, !, ~, ++, --");
        System.out.println("3. Multiplicative: *, /, %");
        System.out.println("4. Additive: +, -");
        System.out.println("5. Shift: <<, >>, >>>");
        System.out.println("6. Relational: <, >, <=, >=, instanceof");
        System.out.println("7. Equality: ==, !=");
        System.out.println("8. Bitwise AND: &");
        System.out.println("9. Bitwise XOR: ^");
        System.out.println("10. Bitwise OR: |");
        System.out.println("11. Logical AND: &&");
        System.out.println("12. Logical OR: ||");
        System.out.println("13. Conditional: ? :");
        System.out.println("14. Assignment: =, +=, -=, *=, /=, %=, etc.");
    }
}
