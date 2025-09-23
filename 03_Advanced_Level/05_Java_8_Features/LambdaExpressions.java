package com.tutorial.advanced;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Lambda Expressions Demo
 * 
 * This class demonstrates:
 * - Lambda expression syntax
 * - Functional interfaces
 * - Method references
 * - Built-in functional interfaces
 * - Lambda expressions with collections
 * - Lambda expressions with streams
 * - Best practices and common patterns
 */
public class LambdaExpressions {
    
    public static void main(String[] args) {
        System.out.println("=== Lambda Expressions Demo ===");
        System.out.println();
        
        // 1. Basic Lambda Syntax
        demonstrateBasicLambdaSyntax();
        
        // 2. Functional Interfaces
        demonstrateFunctionalInterfaces();
        
        // 3. Built-in Functional Interfaces
        demonstrateBuiltInFunctionalInterfaces();
        
        // 4. Lambda with Collections
        demonstrateLambdaWithCollections();
        
        // 5. Method References
        demonstrateMethodReferences();
        
        // 6. Lambda with Streams
        demonstrateLambdaWithStreams();
        
        // 7. Lambda Best Practices
        demonstrateLambdaBestPractices();
    }
    
    /**
     * Demonstrates basic lambda expression syntax
     */
    private static void demonstrateBasicLambdaSyntax() {
        System.out.println("1. Basic Lambda Syntax:");
        System.out.println("======================");
        
        // Traditional anonymous inner class
        Runnable traditionalRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Traditional anonymous inner class");
            }
        };
        
        // Lambda expression equivalent
        Runnable lambdaRunnable = () -> System.out.println("Lambda expression");
        
        // Executing both
        traditionalRunnable.run();
        lambdaRunnable.run();
        
        // Lambda with parameters
        Comparator<String> traditionalComparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        };
        
        Comparator<String> lambdaComparator = (a, b) -> a.compareTo(b);
        
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
        System.out.println("Original list: " + names);
        
        // Using traditional comparator
        List<String> sorted1 = new ArrayList<>(names);
        sorted1.sort(traditionalComparator);
        System.out.println("Sorted with traditional: " + sorted1);
        
        // Using lambda comparator
        List<String> sorted2 = new ArrayList<>(names);
        sorted2.sort(lambdaComparator);
        System.out.println("Sorted with lambda: " + sorted2);
        
        // Lambda with single parameter (parentheses optional)
        Consumer<String> printer1 = (String s) -> System.out.println("Hello " + s);
        Consumer<String> printer2 = s -> System.out.println("Hi " + s);
        
        printer1.accept("World");
        printer2.accept("Java");
        
        // Lambda with multiple statements
        Function<String, String> formatter = s -> {
            String trimmed = s.trim();
            return trimmed.toUpperCase();
        };
        
        System.out.println("Formatted: " + formatter.apply("  hello world  "));
        System.out.println();
    }
    
    /**
     * Demonstrates functional interfaces
     */
    private static void demonstrateFunctionalInterfaces() {
        System.out.println("2. Functional Interfaces:");
        System.out.println("========================");
        
        // Custom functional interface
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> a / b;
        
        System.out.println("Addition: " + addition.operate(10, 5));
        System.out.println("Subtraction: " + subtraction.operate(10, 5));
        System.out.println("Multiplication: " + multiplication.operate(10, 5));
        System.out.println("Division: " + division.operate(10, 5));
        
        // Using method reference
        MathOperation max = Math::max;
        MathOperation min = Math::min;
        
        System.out.println("Max: " + max.operate(10, 5));
        System.out.println("Min: " + min.operate(10, 5));
        
        // Lambda with custom functional interface
        StringProcessor processor = s -> s.toUpperCase() + "!";
        System.out.println("Processed: " + processor.process("hello"));
        
        System.out.println();
    }
    
    /**
     * Demonstrates built-in functional interfaces
     */
    private static void demonstrateBuiltInFunctionalInterfaces() {
        System.out.println("3. Built-in Functional Interfaces:");
        System.out.println("=================================");
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        
        // Predicate<T> - takes one argument, returns boolean
        Predicate<String> isLongName = name -> name.length() > 4;
        System.out.println("Long names: " + names.stream().filter(isLongName).collect(Collectors.toList()));
        
        // Function<T, R> - takes one argument, returns result
        Function<String, Integer> nameLength = String::length;
        System.out.println("Name lengths: " + names.stream().map(nameLength).collect(Collectors.toList()));
        
        // Consumer<T> - takes one argument, returns void
        Consumer<String> printer = name -> System.out.println("  " + name);
        System.out.println("All names:");
        names.forEach(printer);
        
        // Supplier<T> - takes no arguments, returns result
        Supplier<String> randomName = () -> names.get(new Random().nextInt(names.size()));
        System.out.println("Random name: " + randomName.get());
        
        // UnaryOperator<T> - takes one argument of type T, returns T
        UnaryOperator<String> addPrefix = name -> "Mr. " + name;
        System.out.println("With prefix: " + names.stream().map(addPrefix).collect(Collectors.toList()));
        
        // BinaryOperator<T> - takes two arguments of type T, returns T
        BinaryOperator<String> concatenate = (a, b) -> a + " and " + b;
        System.out.println("Concatenated: " + concatenate.apply("Alice", "Bob"));
        
        // BiFunction<T, U, R> - takes two arguments, returns result
        BiFunction<String, Integer, String> repeatString = (s, n) -> s.repeat(n);
        System.out.println("Repeated: " + repeatString.apply("Hello", 3));
        
        System.out.println();
    }
    
    /**
     * Demonstrates lambda expressions with collections
     */
    private static void demonstrateLambdaWithCollections() {
        System.out.println("4. Lambda with Collections:");
        System.out.println("==========================");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Original numbers: " + numbers);
        
        // Filtering with lambda
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
        
        // Mapping with lambda
        List<String> numberStrings = numbers.stream()
            .map(n -> "Number: " + n)
            .collect(Collectors.toList());
        System.out.println("Number strings: " + numberStrings);
        
        // Reducing with lambda
        int sum = numbers.stream()
            .reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);
        
        // Sorting with lambda
        List<String> words = Arrays.asList("banana", "apple", "cherry", "date");
        List<String> sortedWords = words.stream()
            .sorted((a, b) -> a.compareTo(b))
            .collect(Collectors.toList());
        System.out.println("Sorted words: " + sortedWords);
        
        // Grouping with lambda
        Map<String, List<String>> groupedByLength = words.stream()
            .collect(Collectors.groupingBy(word -> word.length() > 5 ? "long" : "short"));
        System.out.println("Grouped by length: " + groupedByLength);
        
        // Using forEach with lambda
        System.out.println("Printing numbers:");
        numbers.forEach(n -> System.out.println("  " + n));
        
        System.out.println();
    }
    
    /**
     * Demonstrates method references
     */
    private static void demonstrateMethodReferences() {
        System.out.println("5. Method References:");
        System.out.println("===================");
        
        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");
        System.out.println("Original names: " + names);
        
        // Static method reference
        List<String> upperCaseNames = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Uppercase names: " + upperCaseNames);
        
        // Instance method reference
        List<Integer> nameLengths = names.stream()
            .map(String::length)
            .collect(Collectors.toList());
        System.out.println("Name lengths: " + nameLengths);
        
        // Constructor reference
        List<String> greetings = names.stream()
            .map(name -> "Hello " + name)
            .collect(Collectors.toList());
        System.out.println("Greetings: " + greetings);
        
        // Method reference with custom class
        List<Person> people = Arrays.asList(
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 35)
        );
        
        List<String> personNames = people.stream()
            .map(Person::getName)
            .collect(Collectors.toList());
        System.out.println("Person names: " + personNames);
        
        List<Integer> personAges = people.stream()
            .map(Person::getAge)
            .collect(Collectors.toList());
        System.out.println("Person ages: " + personAges);
        
        // Method reference with System.out::println
        System.out.println("Printing names:");
        names.forEach(System.out::println);
        
        System.out.println();
    }
    
    /**
     * Demonstrates lambda expressions with streams
     */
    private static void demonstrateLambdaWithStreams() {
        System.out.println("6. Lambda with Streams:");
        System.out.println("======================");
        
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, "Engineer"),
            new Person("Bob", 30, "Manager"),
            new Person("Charlie", 35, "Engineer"),
            new Person("David", 28, "Designer"),
            new Person("Eve", 32, "Manager")
        );
        
        System.out.println("All people: " + people);
        
        // Filter engineers
        List<Person> engineers = people.stream()
            .filter(person -> "Engineer".equals(person.getJob()))
            .collect(Collectors.toList());
        System.out.println("Engineers: " + engineers);
        
        // Get names of people over 30
        List<String> namesOver30 = people.stream()
            .filter(person -> person.getAge() > 30)
            .map(Person::getName)
            .collect(Collectors.toList());
        System.out.println("Names of people over 30: " + namesOver30);
        
        // Calculate average age
        double averageAge = people.stream()
            .mapToInt(Person::getAge)
            .average()
            .orElse(0.0);
        System.out.println("Average age: " + averageAge);
        
        // Group by job
        Map<String, List<Person>> groupedByJob = people.stream()
            .collect(Collectors.groupingBy(Person::getJob));
        System.out.println("Grouped by job: " + groupedByJob);
        
        // Find oldest person
        Optional<Person> oldestPerson = people.stream()
            .max(Comparator.comparing(Person::getAge));
        oldestPerson.ifPresent(person -> 
            System.out.println("Oldest person: " + person.getName() + " (" + person.getAge() + ")"));
        
        // Count people by job
        Map<String, Long> jobCounts = people.stream()
            .collect(Collectors.groupingBy(Person::getJob, Collectors.counting()));
        System.out.println("Job counts: " + jobCounts);
        
        System.out.println();
    }
    
    /**
     * Demonstrates lambda best practices
     */
    private static void demonstrateLambdaBestPractices() {
        System.out.println("7. Lambda Best Practices:");
        System.out.println("========================");
        
        List<String> words = Arrays.asList("hello", "world", "java", "lambda", "stream");
        
        // Good: Simple lambda
        List<String> upperCase = words.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Uppercase words: " + upperCase);
        
        // Good: Lambda with clear intent
        List<String> longWords = words.stream()
            .filter(word -> word.length() > 4)
            .collect(Collectors.toList());
        System.out.println("Long words: " + longWords);
        
        // Good: Method reference when possible
        List<Integer> lengths = words.stream()
            .map(String::length)
            .collect(Collectors.toList());
        System.out.println("Word lengths: " + lengths);
        
        // Good: Extract complex logic to method
        List<String> processedWords = words.stream()
            .map(LambdaExpressions::processWord)
            .collect(Collectors.toList());
        System.out.println("Processed words: " + processedWords);
        
        // Good: Use meaningful variable names
        Predicate<String> isLongWord = word -> word.length() > 4;
        List<String> filteredWords = words.stream()
            .filter(isLongWord)
            .collect(Collectors.toList());
        System.out.println("Filtered words: " + filteredWords);
        
        System.out.println();
    }
    
    /**
     * Helper method for processing words
     */
    private static String processWord(String word) {
        return word.toUpperCase() + " (" + word.length() + ")";
    }
}

/**
 * Custom functional interface for math operations
 */
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

/**
 * Custom functional interface for string processing
 */
@FunctionalInterface
interface StringProcessor {
    String process(String input);
}

/**
 * Person class for demonstration
 */
class Person {
    private String name;
    private int age;
    private String job;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getJob() {
        return job;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", job='" + job + "'}";
    }
}
