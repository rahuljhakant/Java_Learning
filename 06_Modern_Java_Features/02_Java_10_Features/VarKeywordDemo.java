/**
 * Java 10 Local Variable Type Inference - var Keyword Tutorial
 * 
 * This comprehensive tutorial demonstrates the var keyword introduced in Java 10,
 * which enables local variable type inference. The var keyword allows developers
 * to declare local variables without explicitly specifying their type, making
 * code more concise while maintaining type safety.
 * 
 * LEARNING OBJECTIVES:
 * - Understand local variable type inference and its benefits
 * - Learn when and how to use the var keyword effectively
 * - Master var usage with different data types and expressions
 * - Understand var limitations and restrictions
 * - Practice var with collections, streams, and complex types
 * - Learn best practices for using var in production code
 * - Understand var's impact on code readability and maintainability
 * 
 * KEY CONCEPTS:
 * 1. Type Inference: Automatic type deduction by the compiler
 * 2. Local Variables: var can only be used for local variables
 * 3. Initialization: var variables must be initialized immediately
 * 4. Type Safety: var maintains compile-time type safety
 * 5. Readability: Balance between conciseness and clarity
 * 6. Best Practices: When to use var vs explicit types
 * 7. Limitations: Where var cannot be used
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class VarKeywordDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Java 10 var Keyword Tutorial ===");
        System.out.println();
        
        // 1. Introduction to var keyword
        demonstrateVarIntroduction();
        
        // 2. Basic var usage examples
        demonstrateBasicVarUsage();
        
        // 3. var with collections and generics
        demonstrateVarWithCollections();
        
        // 4. var with streams and lambdas
        demonstrateVarWithStreams();
        
        // 5. var limitations and restrictions
        demonstrateVarLimitations();
        
        // 6. Best practices and guidelines
        demonstrateBestPractices();
    }
    
    /**
     * Introduction to var keyword and its benefits
     */
    private static void demonstrateVarIntroduction() {
        System.out.println("1. Introduction to var Keyword:");
        System.out.println("==============================");
        
        System.out.println("The var keyword enables local variable type inference:");
        System.out.println("✓ Reduces boilerplate code");
        System.out.println("✓ Maintains type safety");
        System.out.println("✓ Improves code readability");
        System.out.println("✓ Works with complex generic types");
        System.out.println("✓ Compiler infers type from initializer");
        
        System.out.println("\nBefore Java 10:");
        System.out.println("Map<String, List<Integer>> complexMap = new HashMap<>();");
        System.out.println("List<String> names = new ArrayList<>();");
        System.out.println("StringBuilder sb = new StringBuilder();");
        
        System.out.println("\nWith var keyword:");
        System.out.println("var complexMap = new HashMap<String, List<Integer>>();");
        System.out.println("var names = new ArrayList<String>();");
        System.out.println("var sb = new StringBuilder();");
        
        System.out.println("\nKey Rules:");
        System.out.println("• var can only be used for local variables");
        System.out.println("• Variable must be initialized immediately");
        System.out.println("• Cannot be used for method parameters");
        System.out.println("• Cannot be used for return types");
        System.out.println("• Cannot be used for fields");
        
        System.out.println();
    }
    
    /**
     * Demonstrates basic var usage with different data types
     */
    private static void demonstrateBasicVarUsage() {
        System.out.println("2. Basic var Usage Examples:");
        System.out.println("===========================");
        
        // Primitive types
        System.out.println("Primitive Types:");
        var number = 42;                    // int
        var decimal = 3.14;                 // double
        var flag = true;                    // boolean
        var character = 'A';                // char
        var text = "Hello, Java 10!";       // String
        
        System.out.println("var number = 42;        // Type: " + 
            ((Object)number).getClass().getSimpleName());
        System.out.println("var decimal = 3.14;     // Type: " + 
            ((Object)decimal).getClass().getSimpleName());
        System.out.println("var flag = true;        // Type: " + 
            ((Object)flag).getClass().getSimpleName());
        System.out.println("var character = 'A';    // Type: " + 
            ((Object)character).getClass().getSimpleName());
        System.out.println("var text = \"Hello\";     // Type: " + 
            text.getClass().getSimpleName());
        
        // Object types
        System.out.println("\nObject Types:");
        var date = LocalDate.now();         // LocalDate
        var dateTime = LocalDateTime.now(); // LocalDateTime
        var list = new ArrayList<String>(); // ArrayList<String>
        var map = new HashMap<String, Integer>(); // HashMap<String, Integer>
        
        System.out.println("var date = LocalDate.now();     // Type: " + 
            date.getClass().getSimpleName());
        System.out.println("var dateTime = LocalDateTime.now(); // Type: " + 
            dateTime.getClass().getSimpleName());
        System.out.println("var list = new ArrayList<>();   // Type: " + 
            list.getClass().getSimpleName());
        System.out.println("var map = new HashMap<>();      // Type: " + 
            map.getClass().getSimpleName());
        
        // Method return types
        System.out.println("\nMethod Return Types:");
        var result = calculateSum(10, 20);  // int
        var message = getGreeting("Alice"); // String
        var numbers = getNumbers();         // List<Integer>
        
        System.out.println("var result = calculateSum(10, 20); // Type: " + 
            ((Object)result).getClass().getSimpleName());
        System.out.println("var message = getGreeting(\"Alice\"); // Type: " + 
            message.getClass().getSimpleName());
        System.out.println("var numbers = getNumbers();      // Type: " + 
            numbers.getClass().getSimpleName());
        
        System.out.println();
    }
    
    /**
     * Demonstrates var usage with collections and generics
     */
    private static void demonstrateVarWithCollections() {
        System.out.println("3. var with Collections and Generics:");
        System.out.println("====================================");
        
        // Simple collections
        System.out.println("Simple Collections:");
        var names = Arrays.asList("Alice", "Bob", "Charlie");
        var numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        var scores = new HashMap<String, Integer>();
        scores.put("Alice", 95);
        scores.put("Bob", 87);
        scores.put("Charlie", 92);
        
        System.out.println("var names = Arrays.asList(...); // Type: " + 
            names.getClass().getSimpleName());
        System.out.println("var numbers = new ArrayList<>(...); // Type: " + 
            numbers.getClass().getSimpleName());
        System.out.println("var scores = new HashMap<>(); // Type: " + 
            scores.getClass().getSimpleName());
        
        // Complex generic types
        System.out.println("\nComplex Generic Types:");
        var complexMap = new HashMap<String, List<Map<String, Integer>>>();
        var nestedList = new ArrayList<List<Set<String>>>();
        var optionalList = Optional.of(Arrays.asList("a", "b", "c"));
        
        System.out.println("var complexMap = new HashMap<String, List<Map<String, Integer>>>();");
        System.out.println("  // Type: " + complexMap.getClass().getSimpleName());
        System.out.println("var nestedList = new ArrayList<List<Set<String>>>();");
        System.out.println("  // Type: " + nestedList.getClass().getSimpleName());
        System.out.println("var optionalList = Optional.of(...);");
        System.out.println("  // Type: " + optionalList.getClass().getSimpleName());
        
        // Collection operations
        System.out.println("\nCollection Operations:");
        var filteredNames = names.stream()
            .filter(name -> name.length() > 4)
            .collect(Collectors.toList());
        
        var nameLengths = names.stream()
            .collect(Collectors.toMap(
                name -> name,
                String::length
            ));
        
        System.out.println("var filteredNames = names.stream()...");
        System.out.println("  // Type: " + filteredNames.getClass().getSimpleName());
        System.out.println("var nameLengths = names.stream()...");
        System.out.println("  // Type: " + nameLengths.getClass().getSimpleName());
        
        System.out.println();
    }
    
    /**
     * Demonstrates var usage with streams and lambdas
     */
    private static void demonstrateVarWithStreams() {
        System.out.println("4. var with Streams and Lambdas:");
        System.out.println("===============================");
        
        var numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Stream operations
        System.out.println("Stream Operations:");
        var evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        
        var doubledNumbers = numbers.stream()
            .map(n -> n * 2)
            .collect(Collectors.toList());
        
        var sum = numbers.stream()
            .reduce(0, Integer::sum);
        
        var groupedByParity = numbers.stream()
            .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd"));
        
        System.out.println("var evenNumbers = numbers.stream()...");
        System.out.println("  // Type: " + evenNumbers.getClass().getSimpleName());
        System.out.println("var doubledNumbers = numbers.stream()...");
        System.out.println("  // Type: " + doubledNumbers.getClass().getSimpleName());
        System.out.println("var sum = numbers.stream()...");
        System.out.println("  // Type: " + ((Object)sum).getClass().getSimpleName());
        System.out.println("var groupedByParity = numbers.stream()...");
        System.out.println("  // Type: " + groupedByParity.getClass().getSimpleName());
        
        // Complex stream operations
        System.out.println("\nComplex Stream Operations:");
        var people = Arrays.asList(
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 35)
        );
        
        var averageAge = people.stream()
            .mapToInt(Person::getAge)
            .average()
            .orElse(0.0);
        
        var namesByAgeGroup = people.stream()
            .collect(Collectors.groupingBy(
                person -> person.getAge() < 30 ? "young" : "mature",
                Collectors.mapping(Person::getName, Collectors.toList())
            ));
        
        System.out.println("var averageAge = people.stream()...");
        System.out.println("  // Type: " + ((Object)averageAge).getClass().getSimpleName());
        System.out.println("var namesByAgeGroup = people.stream()...");
        System.out.println("  // Type: " + namesByAgeGroup.getClass().getSimpleName());
        
        System.out.println();
    }
    
    /**
     * Demonstrates var limitations and restrictions
     */
    private static void demonstrateVarLimitations() {
        System.out.println("5. var Limitations and Restrictions:");
        System.out.println("===================================");
        
        System.out.println("❌ Cannot use var for:");
        System.out.println("• Method parameters");
        System.out.println("• Return types");
        System.out.println("• Field declarations");
        System.out.println("• Catch block parameters");
        System.out.println("• Lambda parameters");
        System.out.println("• Array initializers without explicit type");
        
        System.out.println("\n❌ Invalid var usage examples:");
        System.out.println("// Method parameter - NOT ALLOWED");
        System.out.println("public void method(var param) { }");
        
        System.out.println("\n// Return type - NOT ALLOWED");
        System.out.println("public var method() { return \"hello\"; }");
        
        System.out.println("\n// Field declaration - NOT ALLOWED");
        System.out.println("private var field = \"value\";");
        
        System.out.println("\n// Catch block - NOT ALLOWED");
        System.out.println("try { } catch (var e) { }");
        
        System.out.println("\n// Lambda parameter - NOT ALLOWED");
        System.out.println("list.forEach((var item) -> System.out.println(item));");
        
        System.out.println("\n// Array without explicit type - NOT ALLOWED");
        System.out.println("var array = {1, 2, 3}; // Compilation error");
        
        System.out.println("\n✅ Valid alternatives:");
        System.out.println("// Array with explicit type");
        System.out.println("var array = new int[]{1, 2, 3};");
        
        System.out.println("\n// Lambda with explicit type");
        System.out.println("list.forEach((String item) -> System.out.println(item));");
        
        System.out.println("\n// Method with explicit parameter");
        System.out.println("public void method(String param) { }");
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices for using var
     */
    private static void demonstrateBestPractices() {
        System.out.println("6. var Best Practices and Guidelines:");
        System.out.println("===================================");
        
        System.out.println("✅ DO use var when:");
        System.out.println("• Type is obvious from context");
        System.out.println("• Reduces boilerplate code");
        System.out.println("• Improves readability");
        System.out.println("• Working with complex generic types");
        
        System.out.println("\n✅ Good var usage examples:");
        System.out.println("var list = new ArrayList<String>();");
        System.out.println("var map = new HashMap<String, Integer>();");
        System.out.println("var stream = list.stream();");
        System.out.println("var result = calculateComplexResult();");
        
        System.out.println("\n❌ DON'T use var when:");
        System.out.println("• Type is not obvious");
        System.out.println("• Reduces code clarity");
        System.out.println("• Working with primitive types");
        System.out.println("• Type information is important for understanding");
        
        System.out.println("\n❌ Poor var usage examples:");
        System.out.println("var x = 10;           // Use: int x = 10;");
        System.out.println("var flag = true;      // Use: boolean flag = true;");
        System.out.println("var result = method(); // If return type is unclear");
        
        System.out.println("\n📋 Guidelines:");
        System.out.println("1. Use descriptive variable names");
        System.out.println("2. Consider team coding standards");
        System.out.println("3. Balance conciseness with clarity");
        System.out.println("4. Use var consistently in similar contexts");
        System.out.println("5. Consider IDE support and tooling");
        
        System.out.println("\n🔍 IDE Integration:");
        System.out.println("• Most IDEs show inferred types on hover");
        System.out.println("• Use IDE features to understand var types");
        System.out.println("• Configure IDE to show type information");
        
        System.out.println();
    }
    
    // Helper methods for demonstrations
    private static int calculateSum(int a, int b) {
        return a + b;
    }
    
    private static String getGreeting(String name) {
        return "Hello, " + name + "!";
    }
    
    private static List<Integer> getNumbers() {
        return Arrays.asList(1, 2, 3, 4, 5);
    }
    
    // Helper class for demonstrations
    static class Person {
        private final String name;
        private final int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() { return name; }
        public int getAge() { return age; }
        
        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }
}
