package com.tutorial.advanced.concepts;

import java.util.*;

/**
 * Generics Demo - Type Safety and Code Reuse
 * 
 * This comprehensive tutorial demonstrates Java generics, which provide
 * type safety and enable code reuse by allowing classes, interfaces,
 * and methods to operate on different types while maintaining compile-time
 * type checking.
 * 
 * LEARNING OBJECTIVES:
 * - Understand the benefits and importance of generics
 * - Create generic classes, interfaces, and methods
 * - Use bounded type parameters and wildcards
 * - Understand type erasure and its implications
 * - Apply generics with collections and data structures
 * - Handle generic type safety and best practices
 * 
 * KEY CONCEPTS:
 * 1. Generic Classes: Type-safe classes that work with different types
 * 2. Generic Methods: Methods that can work with different types
 * 3. Bounded Type Parameters: Restricting generic types to specific hierarchies
 * 4. Wildcards: Flexible generic type parameters
 * 5. Type Erasure: How generics are implemented at runtime
 * 6. Generic Collections: Type-safe collections and data structures
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class GenericsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Generics Demo ===");
        System.out.println();
        
        // 1. Basic Generic Class
        demonstrateBasicGenericClass();
        
        // 2. Generic Methods
        demonstrateGenericMethods();
        
        // 3. Bounded Type Parameters
        demonstrateBoundedTypeParameters();
        
        // 4. Wildcards
        demonstrateWildcards();
        
        // 5. Generic Collections
        demonstrateGenericCollections();
        
        // 6. Multiple Type Parameters
        demonstrateMultipleTypeParameters();
        
        // 7. Generic Interfaces
        demonstrateGenericInterfaces();
        
        // 8. Type Erasure
        demonstrateTypeErasure();
        
        // 9. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic generic class usage
     */
    private static void demonstrateBasicGenericClass() {
        System.out.println("1. Basic Generic Class:");
        System.out.println("======================");
        
        // Create generic box for different types
        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello, Generics!");
        System.out.println("String box content: " + stringBox.getContent());
        
        Box<Integer> intBox = new Box<>();
        intBox.setContent(42);
        System.out.println("Integer box content: " + intBox.getContent());
        
        Box<Double> doubleBox = new Box<>();
        doubleBox.setContent(3.14159);
        System.out.println("Double box content: " + doubleBox.getContent());
        
        // Type safety demonstration
        // stringBox.setContent(123); // This would cause compile-time error
        
        System.out.println();
    }
    
    /**
     * Demonstrates generic methods
     */
    private static void demonstrateGenericMethods() {
        System.out.println("2. Generic Methods:");
        System.out.println("==================");
        
        // Generic method with different types
        String[] stringArray = {"apple", "banana", "cherry"};
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3};
        
        System.out.println("String array: " + Arrays.toString(stringArray));
        System.out.println("Last element: " + getLastElement(stringArray));
        
        System.out.println("Integer array: " + Arrays.toString(intArray));
        System.out.println("Last element: " + getLastElement(intArray));
        
        System.out.println("Double array: " + Arrays.toString(doubleArray));
        System.out.println("Last element: " + getLastElement(doubleArray));
        
        // Generic method with multiple parameters
        System.out.println("Are equal: " + isEqual("Hello", "Hello"));
        System.out.println("Are equal: " + isEqual(42, 42));
        System.out.println("Are equal: " + isEqual(3.14, 3.141));
        
        System.out.println();
    }
    
    /**
     * Demonstrates bounded type parameters
     */
    private static void demonstrateBoundedTypeParameters() {
        System.out.println("3. Bounded Type Parameters:");
        System.out.println("===========================");
        
        // Numbers that implement Comparable
        System.out.println("Maximum of 10, 20, 5: " + findMaximum(10, 20, 5));
        System.out.println("Maximum of 3.14, 2.71, 1.41: " + findMaximum(3.14, 2.71, 1.41));
        System.out.println("Maximum of 'z', 'a', 'm': " + findMaximum("z", "a", "m"));
        
        // Calculate sum of numbers
        System.out.println("Sum of integers: " + calculateSum(1, 2, 3, 4, 5));
        System.out.println("Sum of doubles: " + calculateSum(1.1, 2.2, 3.3, 4.4, 5.5));
        
        System.out.println();
    }
    
    /**
     * Demonstrates wildcards
     */
    private static void demonstrateWildcards() {
        System.out.println("4. Wildcards:");
        System.out.println("=============");
        
        // List of different types
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);
        List<String> stringList = Arrays.asList("apple", "banana", "cherry");
        
        // Unbounded wildcard
        System.out.println("Integer list size: " + getListSize(intList));
        System.out.println("Double list size: " + getListSize(doubleList));
        System.out.println("String list size: " + getListSize(stringList));
        
        // Upper bounded wildcard
        System.out.println("Sum of integers: " + sumOfNumbers(intList));
        System.out.println("Sum of doubles: " + sumOfNumbers(doubleList));
        
        // Lower bounded wildcard
        List<Number> numberList = new ArrayList<>();
        addNumbers(numberList, 1, 2, 3);
        addNumbers(numberList, 1.1, 2.2, 3.3);
        System.out.println("Number list: " + numberList);
        
        System.out.println();
    }
    
    /**
     * Demonstrates generic collections
     */
    private static void demonstrateGenericCollections() {
        System.out.println("5. Generic Collections:");
        System.out.println("======================");
        
        // Generic List
        List<String> stringList = new ArrayList<>();
        stringList.add("Java");
        stringList.add("Generics");
        stringList.add("Collections");
        
        System.out.println("String list: " + stringList);
        
        // Generic Set
        Set<Integer> intSet = new HashSet<>();
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(2); // Duplicate, won't be added
        
        System.out.println("Integer set: " + intSet);
        
        // Generic Map
        Map<String, Integer> wordCount = new HashMap<>();
        wordCount.put("Java", 1);
        wordCount.put("Generics", 1);
        wordCount.put("Collections", 1);
        
        System.out.println("Word count map: " + wordCount);
        
        // Generic Stack
        Stack<String> stringStack = new Stack<>();
        stringStack.push("First");
        stringStack.push("Second");
        stringStack.push("Third");
        
        System.out.println("Stack contents:");
        while (!stringStack.isEmpty()) {
            System.out.println("  Popped: " + stringStack.pop());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates multiple type parameters
     */
    private static void demonstrateMultipleTypeParameters() {
        System.out.println("6. Multiple Type Parameters:");
        System.out.println("===========================");
        
        // Pair with different types
        Pair<String, Integer> nameAge = new Pair<>("John", 25);
        Pair<String, Double> nameSalary = new Pair<>("Jane", 75000.0);
        Pair<Integer, String> idName = new Pair<>(123, "Bob");
        
        System.out.println("Name-Age pair: " + nameAge);
        System.out.println("Name-Salary pair: " + nameSalary);
        System.out.println("ID-Name pair: " + idName);
        
        // Triple with different types
        Triple<String, Integer, Double> person = new Triple<>("Alice", 30, 85000.0);
        System.out.println("Person triple: " + person);
        
        System.out.println();
    }
    
    /**
     * Demonstrates generic interfaces
     */
    private static void demonstrateGenericInterfaces() {
        System.out.println("7. Generic Interfaces:");
        System.out.println("=====================");
        
        // Repository implementations
        Repository<String> stringRepo = new StringRepository();
        stringRepo.save("Hello");
        stringRepo.save("World");
        System.out.println("String repository size: " + stringRepo.size());
        System.out.println("Found 'Hello': " + stringRepo.findById("Hello"));
        
        Repository<Integer> intRepo = new IntegerRepository();
        intRepo.save(1);
        intRepo.save(2);
        intRepo.save(3);
        System.out.println("Integer repository size: " + intRepo.size());
        System.out.println("Found 2: " + intRepo.findById(2));
        
        System.out.println();
    }
    
    /**
     * Demonstrates type erasure
     */
    private static void demonstrateTypeErasure() {
        System.out.println("8. Type Erasure:");
        System.out.println("===============");
        
        // Type erasure demonstration
        Box<String> stringBox = new Box<>();
        Box<Integer> intBox = new Box<>();
        
        // At runtime, both boxes have the same type due to type erasure
        System.out.println("String box class: " + stringBox.getClass().getName());
        System.out.println("Integer box class: " + intBox.getClass().getName());
        System.out.println("Are classes equal? " + (stringBox.getClass() == intBox.getClass()));
        
        // Generic method with type erasure
        System.out.println("Type of 'Hello': " + getType("Hello"));
        System.out.println("Type of 42: " + getType(42));
        System.out.println("Type of 3.14: " + getType(3.14));
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices for generics
     */
    private static void demonstrateBestPractices() {
        System.out.println("9. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use generics for type safety and code reuse");
        System.out.println("✓ Prefer generic types over raw types");
        System.out.println("✓ Use bounded wildcards for maximum flexibility");
        System.out.println("✓ Avoid using raw types in new code");
        System.out.println("✓ Use generic methods when appropriate");
        System.out.println("✓ Be aware of type erasure limitations");
        System.out.println("✓ Use generic collections for type safety");
        System.out.println("✓ Consider performance implications of generics");
        System.out.println("✓ Use meaningful type parameter names");
        System.out.println("✓ Document generic type constraints");
        
        System.out.println();
    }
    
    // Generic method examples
    public static <T> T getLastElement(T[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        return array[array.length - 1];
    }
    
    public static <T> boolean isEqual(T a, T b) {
        return a.equals(b);
    }
    
    public static <T extends Comparable<T>> T findMaximum(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) max = b;
        if (c.compareTo(max) > 0) max = c;
        return max;
    }
    
    public static <T extends Number> double calculateSum(T... numbers) {
        double sum = 0.0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
    
    public static int getListSize(List<?> list) {
        return list.size();
    }
    
    public static double sumOfNumbers(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
    
    public static void addNumbers(List<? super Number> numbers, Number... values) {
        for (Number value : values) {
            numbers.add(value);
        }
    }
    
    public static String getType(Object obj) {
        return obj.getClass().getSimpleName();
    }
    
    // Generic class examples
    public static class Box<T> {
        private T content;
        
        public void setContent(T content) {
            this.content = content;
        }
        
        public T getContent() {
            return content;
        }
        
        @Override
        public String toString() {
            return "Box{" + "content=" + content + '}';
        }
    }
    
    public static class Pair<T, U> {
        private T first;
        private U second;
        
        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
        
        public T getFirst() { return first; }
        public U getSecond() { return second; }
        
        @Override
        public String toString() {
            return "Pair{" + "first=" + first + ", second=" + second + '}';
        }
    }
    
    public static class Triple<T, U, V> {
        private T first;
        private U second;
        private V third;
        
        public Triple(T first, U second, V third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
        
        public T getFirst() { return first; }
        public U getSecond() { return second; }
        public V getThird() { return third; }
        
        @Override
        public String toString() {
            return "Triple{" + "first=" + first + ", second=" + second + ", third=" + third + '}';
        }
    }
    
    // Generic interface
    public interface Repository<T> {
        void save(T item);
        T findById(T id);
        int size();
    }
    
    public static class StringRepository implements Repository<String> {
        private List<String> items = new ArrayList<>();
        
        @Override
        public void save(String item) {
            items.add(item);
        }
        
        @Override
        public String findById(String id) {
            return items.contains(id) ? id : null;
        }
        
        @Override
        public int size() {
            return items.size();
        }
    }
    
    public static class IntegerRepository implements Repository<Integer> {
        private List<Integer> items = new ArrayList<>();
        
        @Override
        public void save(Integer item) {
            items.add(item);
        }
        
        @Override
        public Integer findById(Integer id) {
            return items.contains(id) ? id : null;
        }
        
        @Override
        public int size() {
            return items.size();
        }
    }
}
