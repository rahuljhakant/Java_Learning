package com.tutorial.advanced;

import java.util.regex.*;
import java.util.*;

/**
 * Regular Expressions - Pattern Matching and Text Processing
 * 
 * This comprehensive tutorial demonstrates Java regular expressions,
 * including pattern matching, text processing, and advanced regex features.
 * 
 * LEARNING OBJECTIVES:
 * - Understand regular expression syntax
 * - Use Pattern and Matcher classes
 * - Implement text validation and processing
 * - Apply regex best practices
 * - Build text processing applications
 * - Handle complex pattern matching
 * 
 * KEY CONCEPTS:
 * 1. Regex Syntax: Character classes, quantifiers, anchors
 * 2. Pattern Class: Compiling and using patterns
 * 3. Matcher Class: Finding and replacing text
 * 4. Groups: Capturing and non-capturing groups
 * 5. Flags: Case-insensitive, multiline, dotall
 * 6. Best Practices: Efficient and readable regex
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class RegularExpressions {
    
    public static void main(String[] args) {
        System.out.println("=== Regular Expressions Demo ===");
        System.out.println();
        
        // 1. Basic Pattern Matching
        demonstrateBasicPatternMatching();
        
        // 2. Character Classes
        demonstrateCharacterClasses();
        
        // 3. Quantifiers
        demonstrateQuantifiers();
        
        // 4. Anchors and Boundaries
        demonstrateAnchorsAndBoundaries();
        
        // 5. Groups and Capturing
        demonstrateGroupsAndCapturing();
        
        // 6. Text Replacement
        demonstrateTextReplacement();
        
        // 7. Validation Examples
        demonstrateValidationExamples();
        
        // 8. Advanced Features
        demonstrateAdvancedFeatures();
        
        // 9. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic pattern matching
     */
    private static void demonstrateBasicPatternMatching() {
        System.out.println("1. Basic Pattern Matching:");
        System.out.println("==========================");
        
        String text = "Hello World! Java is awesome.";
        String pattern = "Java";
        
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(text);
        
        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);
        System.out.println("Found: " + matcher.find());
        
        if (matcher.find()) {
            System.out.println("Match found at position: " + matcher.start());
            System.out.println("Match: " + matcher.group());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates character classes
     */
    private static void demonstrateCharacterClasses() {
        System.out.println("2. Character Classes:");
        System.out.println("====================");
        
        String text = "abc123XYZ!@#";
        
        // Digit character class
        Pattern digitPattern = Pattern.compile("\\d");
        Matcher digitMatcher = digitPattern.matcher(text);
        System.out.println("Digits in '" + text + "':");
        while (digitMatcher.find()) {
            System.out.println("  " + digitMatcher.group() + " at position " + digitMatcher.start());
        }
        
        // Word character class
        Pattern wordPattern = Pattern.compile("\\w");
        Matcher wordMatcher = wordPattern.matcher(text);
        System.out.println("\nWord characters in '" + text + "':");
        while (wordMatcher.find()) {
            System.out.println("  " + wordMatcher.group() + " at position " + wordMatcher.start());
        }
        
        // Custom character class
        Pattern customPattern = Pattern.compile("[a-z]");
        Matcher customMatcher = customPattern.matcher(text);
        System.out.println("\nLowercase letters in '" + text + "':");
        while (customMatcher.find()) {
            System.out.println("  " + customMatcher.group() + " at position " + customMatcher.start());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates quantifiers
     */
    private static void demonstrateQuantifiers() {
        System.out.println("3. Quantifiers:");
        System.out.println("==============");
        
        String text = "aaabbbcccdddeee";
        
        // Zero or more
        Pattern zeroOrMorePattern = Pattern.compile("a*");
        Matcher zeroOrMoreMatcher = zeroOrMorePattern.matcher(text);
        System.out.println("Zero or more 'a' in '" + text + "':");
        while (zeroOrMoreMatcher.find()) {
            System.out.println("  '" + zeroOrMoreMatcher.group() + "' at position " + zeroOrMoreMatcher.start());
        }
        
        // One or more
        Pattern oneOrMorePattern = Pattern.compile("b+");
        Matcher oneOrMoreMatcher = oneOrMorePattern.matcher(text);
        System.out.println("\nOne or more 'b' in '" + text + "':");
        while (oneOrMoreMatcher.find()) {
            System.out.println("  '" + oneOrMoreMatcher.group() + "' at position " + oneOrMoreMatcher.start());
        }
        
        // Exactly n times
        Pattern exactPattern = Pattern.compile("c{3}");
        Matcher exactMatcher = exactPattern.matcher(text);
        System.out.println("\nExactly 3 'c' in '" + text + "':");
        while (exactMatcher.find()) {
            System.out.println("  '" + exactMatcher.group() + "' at position " + exactMatcher.start());
        }
        
        // Between n and m times
        Pattern rangePattern = Pattern.compile("d{2,4}");
        Matcher rangeMatcher = rangePattern.matcher(text);
        System.out.println("\nBetween 2 and 4 'd' in '" + text + "':");
        while (rangeMatcher.find()) {
            System.out.println("  '" + rangeMatcher.group() + "' at position " + rangeMatcher.start());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates anchors and boundaries
     */
    private static void demonstrateAnchorsAndBoundaries() {
        System.out.println("4. Anchors and Boundaries:");
        System.out.println("=========================");
        
        String[] texts = {"Hello World", "World Hello", "Hello", "World"};
        
        // Start of string anchor
        Pattern startPattern = Pattern.compile("^Hello");
        System.out.println("Strings starting with 'Hello':");
        for (String text : texts) {
            Matcher matcher = startPattern.matcher(text);
            System.out.println("  '" + text + "': " + matcher.find());
        }
        
        // End of string anchor
        Pattern endPattern = Pattern.compile("World$");
        System.out.println("\nStrings ending with 'World':");
        for (String text : texts) {
            Matcher matcher = endPattern.matcher(text);
            System.out.println("  '" + text + "': " + matcher.find());
        }
        
        // Word boundary
        Pattern wordBoundaryPattern = Pattern.compile("\\bHello\\b");
        System.out.println("\nStrings with word boundary 'Hello':");
        for (String text : texts) {
            Matcher matcher = wordBoundaryPattern.matcher(text);
            System.out.println("  '" + text + "': " + matcher.find());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates groups and capturing
     */
    private static void demonstrateGroupsAndCapturing() {
        System.out.println("5. Groups and Capturing:");
        System.out.println("=======================");
        
        String text = "John Doe, Jane Smith, Bob Johnson";
        Pattern pattern = Pattern.compile("(\\w+)\\s+(\\w+)");
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Text: " + text);
        System.out.println("Pattern: (\\w+)\\s+(\\w+)");
        System.out.println("Captured groups:");
        
        while (matcher.find()) {
            System.out.println("  Full match: " + matcher.group(0));
            System.out.println("  First name: " + matcher.group(1));
            System.out.println("  Last name: " + matcher.group(2));
            System.out.println();
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates text replacement
     */
    private static void demonstrateTextReplacement() {
        System.out.println("6. Text Replacement:");
        System.out.println("===================");
        
        String text = "Hello World! Hello Java! Hello Programming!";
        
        // Simple replacement
        String replaced = text.replaceAll("Hello", "Hi");
        System.out.println("Original: " + text);
        System.out.println("Replaced: " + replaced);
        
        // Replacement with groups
        String textWithNumbers = "Price: $100, Tax: $10, Total: $110";
        String formatted = textWithNumbers.replaceAll("\\$(\\d+)", "USD $1.00");
        System.out.println("\nOriginal: " + textWithNumbers);
        System.out.println("Formatted: " + formatted);
        
        // Case-insensitive replacement
        String caseInsensitive = text.replaceAll("(?i)hello", "Greetings");
        System.out.println("\nCase-insensitive replacement: " + caseInsensitive);
        
        System.out.println();
    }
    
    /**
     * Demonstrates validation examples
     */
    private static void demonstrateValidationExamples() {
        System.out.println("7. Validation Examples:");
        System.out.println("======================");
        
        // Email validation
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String[] emails = {"user@example.com", "invalid-email", "test@domain.co.uk", "not@valid"};
        
        System.out.println("Email validation:");
        for (String email : emails) {
            boolean isValid = email.matches(emailPattern);
            System.out.println("  '" + email + "': " + (isValid ? "Valid" : "Invalid"));
        }
        
        // Phone number validation
        String phonePattern = "^\\+?[1-9]\\d{1,14}$";
        String[] phones = {"+1234567890", "1234567890", "123", "abc123"};
        
        System.out.println("\nPhone number validation:");
        for (String phone : phones) {
            boolean isValid = phone.matches(phonePattern);
            System.out.println("  '" + phone + "': " + (isValid ? "Valid" : "Invalid"));
        }
        
        // Password validation (at least 8 chars, 1 uppercase, 1 lowercase, 1 digit)
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d@$!%*?&]{8,}$";
        String[] passwords = {"Password123", "weak", "StrongPass1", "noNumbers"};
        
        System.out.println("\nPassword validation:");
        for (String password : passwords) {
            boolean isValid = password.matches(passwordPattern);
            System.out.println("  '" + password + "': " + (isValid ? "Valid" : "Invalid"));
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates advanced features
     */
    private static void demonstrateAdvancedFeatures() {
        System.out.println("8. Advanced Features:");
        System.out.println("====================");
        
        // Lookahead and lookbehind
        String text = "password123 secret456 token789";
        
        // Positive lookahead
        Pattern lookaheadPattern = Pattern.compile("\\w+(?=\\d)");
        Matcher lookaheadMatcher = lookaheadPattern.matcher(text);
        System.out.println("Positive lookahead (word followed by digit):");
        while (lookaheadMatcher.find()) {
            System.out.println("  " + lookaheadMatcher.group());
        }
        
        // Positive lookbehind
        Pattern lookbehindPattern = Pattern.compile("(?<=\\w)\\d+");
        Matcher lookbehindMatcher = lookbehindPattern.matcher(text);
        System.out.println("\nPositive lookbehind (digit preceded by word):");
        while (lookbehindMatcher.find()) {
            System.out.println("  " + lookbehindMatcher.group());
        }
        
        // Named groups
        String textWithDate = "Date: 2024-01-15";
        Pattern namedGroupPattern = Pattern.compile("Date: (?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})");
        Matcher namedGroupMatcher = namedGroupPattern.matcher(textWithDate);
        
        if (namedGroupMatcher.find()) {
            System.out.println("\nNamed groups:");
            System.out.println("  Year: " + namedGroupMatcher.group("year"));
            System.out.println("  Month: " + namedGroupMatcher.group("month"));
            System.out.println("  Day: " + namedGroupMatcher.group("day"));
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("9. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Compile patterns once and reuse them");
        System.out.println("✓ Use specific character classes instead of . when possible");
        System.out.println("✓ Avoid catastrophic backtracking with nested quantifiers");
        System.out.println("✓ Use non-capturing groups (?:...) when you don't need the group");
        System.out.println("✓ Test your regex with various inputs");
        System.out.println("✓ Use regex testing tools for complex patterns");
        System.out.println("✓ Consider performance implications of complex patterns");
        System.out.println("✓ Use appropriate flags (CASE_INSENSITIVE, MULTILINE, etc.)");
        System.out.println("✓ Escape special characters properly");
        System.out.println("✓ Use comments in complex regex patterns");
        System.out.println("✓ Validate input before applying regex");
        System.out.println("✓ Handle regex exceptions properly");
        
        System.out.println();
    }
    
    /**
     * Utility method to validate email
     */
    public static boolean isValidEmail(String email) {
        String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(pattern);
    }
    
    /**
     * Utility method to extract phone numbers
     */
    public static List<String> extractPhoneNumbers(String text) {
        List<String> phoneNumbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\+?[1-9]\\d{1,14}");
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            phoneNumbers.add(matcher.group());
        }
        
        return phoneNumbers;
    }
    
    /**
     * Utility method to sanitize input
     */
    public static String sanitizeInput(String input) {
        // Remove potentially dangerous characters
        return input.replaceAll("[<>\"'&]", "");
    }
}
