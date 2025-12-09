package com.tutorial.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Comparable Demo - Mastering Natural Ordering in Java
 * 
 * This comprehensive tutorial demonstrates the Comparable interface in Java,
 * which provides a way to define the natural ordering of objects. The Comparable
 * interface is essential for sorting collections and maintaining order in
 * data structures like TreeSet and TreeMap.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what Comparable is and why it's important
 * - Learn how to implement the Comparable interface
 * - Master the compareTo() method and its return values
 * - Practice with real-world examples of Comparable
 * - Learn about Comparable vs Comparator
 * - Understand best practices for implementing Comparable
 * - Learn about common pitfalls and how to avoid them
 * 
 * KEY CONCEPTS:
 * 1. Comparable Interface: Defines natural ordering of objects
 * 2. compareTo() Method: Core method for comparison
 * 3. Return Values: Negative, zero, positive integers
 * 4. Natural Ordering: Default ordering for objects
 * 5. Sorting: Using Comparable for sorting collections
 * 6. TreeSet/TreeMap: Collections that use Comparable
 * 7. Consistency: Ensuring consistent ordering
 * 8. Best Practices: Guidelines for proper implementation
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class ComparableDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Comparable Demo ===");
        System.out.println();
        
        // 1. Basic Comparable Implementation
        demonstrateBasicComparable();
        
        // 2. String Comparable
        demonstrateStringComparable();
        
        // 3. Integer Comparable
        demonstrateIntegerComparable();
        
        // 4. Custom Class Comparable
        demonstrateCustomClassComparable();
        
        // 5. Sorting with Comparable
        demonstrateSortingWithComparable();
        
        // 6. TreeSet with Comparable
        demonstrateTreeSetWithComparable();
        
        // 7. TreeMap with Comparable
        demonstrateTreeMapWithComparable();
        
        // 8. Complex Comparable Examples
        demonstrateComplexComparableExamples();
        
        // 9. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic Comparable implementation
     * 
     * This section shows the basic structure of implementing
     * the Comparable interface and the compareTo method.
     */
    private static void demonstrateBasicComparable() {
        System.out.println("1. Basic Comparable Implementation:");
        System.out.println("=================================");
        
        // Basic comparison with integers
        System.out.println("Basic Integer Comparison:");
        System.out.println("------------------------");
        
        Integer a = 5;
        Integer b = 10;
        Integer c = 5;
        
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("a.compareTo(b): " + a.compareTo(b)); // -1 (a < b)
        System.out.println("b.compareTo(a): " + b.compareTo(a)); // 1 (b > a)
        System.out.println("a.compareTo(c): " + a.compareTo(c)); // 0 (a == c)
        
        // Basic comparison with strings
        System.out.println("\nBasic String Comparison:");
        System.out.println("----------------------");
        
        String str1 = "apple";
        String str2 = "banana";
        String str3 = "apple";
        
        System.out.println("str1 = \"" + str1 + "\", str2 = \"" + str2 + "\", str3 = \"" + str3 + "\"");
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2)); // Negative (apple < banana)
        System.out.println("str2.compareTo(str1): " + str2.compareTo(str1)); // Positive (banana > apple)
        System.out.println("str1.compareTo(str3): " + str1.compareTo(str3)); // 0 (apple == apple)
        
        // Understanding return values
        System.out.println("\nUnderstanding Return Values:");
        System.out.println("--------------------------");
        System.out.println("compareTo() returns:");
        System.out.println("• Negative integer: if this object is less than the argument");
        System.out.println("• Zero: if this object is equal to the argument");
        System.out.println("• Positive integer: if this object is greater than the argument");
        
        // Example with different types
        System.out.println("\nExample with Different Types:");
        System.out.println("----------------------------");
        
        Double d1 = 3.14;
        Double d2 = 2.71;
        System.out.println("d1 = " + d1 + ", d2 = " + d2);
        System.out.println("d1.compareTo(d2): " + d1.compareTo(d2)); // Positive (3.14 > 2.71)
        
        Character ch1 = 'A';
        Character ch2 = 'B';
        System.out.println("ch1 = '" + ch1 + "', ch2 = '" + ch2 + "'");
        System.out.println("ch1.compareTo(ch2): " + ch1.compareTo(ch2)); // Negative ('A' < 'B')
        
        System.out.println();
    }
    
    /**
     * Demonstrates String Comparable usage
     * 
     * This section shows how String implements Comparable
     * and how string comparison works.
     */
    private static void demonstrateStringComparable() {
        System.out.println("2. String Comparable:");
        System.out.println("===================");
        
        // String comparison examples
        System.out.println("String Comparison Examples:");
        System.out.println("-------------------------");
        
        String[] words = {"zebra", "apple", "banana", "cherry", "date"};
        
        System.out.println("Original words: " + Arrays.toString(words));
        
        // Sort using Comparable
        Arrays.sort(words);
        System.out.println("Sorted words: " + Arrays.toString(words));
        
        // Case-sensitive comparison
        System.out.println("\nCase-sensitive Comparison:");
        System.out.println("-------------------------");
        
        String str1 = "Apple";
        String str2 = "apple";
        String str3 = "Banana";
        
        System.out.println("\"" + str1 + "\".compareTo(\"" + str2 + "\"): " + str1.compareTo(str2));
        System.out.println("\"" + str1 + "\".compareTo(\"" + str3 + "\"): " + str1.compareTo(str3));
        
        // Case-insensitive comparison
        System.out.println("\nCase-insensitive Comparison:");
        System.out.println("---------------------------");
        
        System.out.println("\"" + str1 + "\".compareToIgnoreCase(\"" + str2 + "\"): " + str1.compareToIgnoreCase(str2));
        System.out.println("\"" + str1 + "\".compareToIgnoreCase(\"" + str3 + "\"): " + str1.compareToIgnoreCase(str3));
        
        // String comparison with different lengths
        System.out.println("\nString Comparison with Different Lengths:");
        System.out.println("--------------------------------------");
        
        String shortStr = "cat";
        String longStr = "caterpillar";
        
        System.out.println("\"" + shortStr + "\".compareTo(\"" + longStr + "\"): " + shortStr.compareTo(longStr));
        System.out.println("\"" + longStr + "\".compareTo(\"" + shortStr + "\"): " + longStr.compareTo(shortStr));
        
        // Lexicographic ordering
        System.out.println("\nLexicographic Ordering:");
        System.out.println("---------------------");
        
        String[] names = {"John", "Jane", "Bob", "Alice", "Charlie"};
        System.out.println("Original names: " + Arrays.toString(names));
        
        Arrays.sort(names);
        System.out.println("Sorted names: " + Arrays.toString(names));
        
        // String comparison with special characters
        System.out.println("\nString Comparison with Special Characters:");
        System.out.println("----------------------------------------");
        
        String[] special = {"@", "!", "#", "$", "%"};
        System.out.println("Special characters: " + Arrays.toString(special));
        
        Arrays.sort(special);
        System.out.println("Sorted special characters: " + Arrays.toString(special));
        
        System.out.println();
    }
    
    /**
     * Demonstrates Integer Comparable usage
     * 
     * This section shows how Integer implements Comparable
     * and how integer comparison works.
     */
    private static void demonstrateIntegerComparable() {
        System.out.println("3. Integer Comparable:");
        System.out.println("====================");
        
        // Integer comparison examples
        System.out.println("Integer Comparison Examples:");
        System.out.println("--------------------------");
        
        Integer[] numbers = {5, 2, 8, 1, 9, 3, 7, 4, 6};
        System.out.println("Original numbers: " + Arrays.toString(numbers));
        
        // Sort using Comparable
        Arrays.sort(numbers);
        System.out.println("Sorted numbers: " + Arrays.toString(numbers));
        
        // Integer comparison with different values
        System.out.println("\nInteger Comparison with Different Values:");
        System.out.println("---------------------------------------");
        
        Integer a = 10;
        Integer b = 20;
        Integer c = 10;
        
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("a.compareTo(b): " + a.compareTo(b)); // -1 (10 < 20)
        System.out.println("b.compareTo(a): " + b.compareTo(a)); // 1 (20 > 10)
        System.out.println("a.compareTo(c): " + a.compareTo(c)); // 0 (10 == 10)
        
        // Integer comparison with negative numbers
        System.out.println("\nInteger Comparison with Negative Numbers:");
        System.out.println("---------------------------------------");
        
        Integer neg1 = -5;
        Integer neg2 = -10;
        Integer pos = 5;
        
        System.out.println("neg1 = " + neg1 + ", neg2 = " + neg2 + ", pos = " + pos);
        System.out.println("neg1.compareTo(neg2): " + neg1.compareTo(neg2)); // 1 (-5 > -10)
        System.out.println("neg2.compareTo(neg1): " + neg2.compareTo(neg1)); // -1 (-10 < -5)
        System.out.println("neg1.compareTo(pos): " + neg1.compareTo(pos));   // -1 (-5 < 5)
        
        // Integer comparison with zero
        System.out.println("\nInteger Comparison with Zero:");
        System.out.println("----------------------------");
        
        Integer zero = 0;
        Integer positive = 5;
        Integer negative = -5;
        
        System.out.println("zero = " + zero + ", positive = " + positive + ", negative = " + negative);
        System.out.println("zero.compareTo(positive): " + zero.compareTo(positive)); // -1 (0 < 5)
        System.out.println("zero.compareTo(negative): " + zero.compareTo(negative)); // 1 (0 > -5)
        System.out.println("positive.compareTo(zero): " + positive.compareTo(zero)); // 1 (5 > 0)
        System.out.println("negative.compareTo(zero): " + negative.compareTo(zero)); // -1 (-5 < 0)
        
        // Integer comparison with large numbers
        System.out.println("\nInteger Comparison with Large Numbers:");
        System.out.println("------------------------------------");
        
        Integer large1 = Integer.MAX_VALUE;
        Integer large2 = Integer.MAX_VALUE - 1;
        
        System.out.println("large1 = " + large1 + ", large2 = " + large2);
        System.out.println("large1.compareTo(large2): " + large1.compareTo(large2)); // 1 (MAX_VALUE > MAX_VALUE-1)
        System.out.println("large2.compareTo(large1): " + large2.compareTo(large1)); // -1 (MAX_VALUE-1 < MAX_VALUE)
        
        System.out.println();
    }
    
    /**
     * Demonstrates custom class Comparable implementation
     * 
     * This section shows how to implement Comparable
     * in custom classes.
     */
    private static void demonstrateCustomClassComparable() {
        System.out.println("4. Custom Class Comparable:");
        System.out.println("==========================");
        
        // Person class with Comparable implementation
        System.out.println("Person Class with Comparable Implementation:");
        System.out.println("-----------------------------------------");
        
        Person[] people = {
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 20),
            new Person("Diana", 35),
            new Person("Eve", 28)
        };
        
        System.out.println("Original people:");
        for (Person person : people) {
            System.out.println("  " + person);
        }
        
        // Sort by age (natural ordering)
        Arrays.sort(people);
        System.out.println("\nSorted by age (natural ordering):");
        for (Person person : people) {
            System.out.println("  " + person);
        }
        
        // Person comparison examples
        System.out.println("\nPerson Comparison Examples:");
        System.out.println("--------------------------");
        
        Person p1 = new Person("John", 25);
        Person p2 = new Person("Jane", 30);
        Person p3 = new Person("Bob", 25);
        
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);
        
        System.out.println("p1.compareTo(p2): " + p1.compareTo(p2)); // -1 (25 < 30)
        System.out.println("p2.compareTo(p1): " + p2.compareTo(p1)); // 1 (30 > 25)
        System.out.println("p1.compareTo(p3): " + p1.compareTo(p3)); // 0 (25 == 25)
        
        // Student class with Comparable implementation
        System.out.println("\nStudent Class with Comparable Implementation:");
        System.out.println("-------------------------------------------");
        
        Student[] students = {
            new Student("Alice", 85.5),
            new Student("Bob", 92.0),
            new Student("Charlie", 78.5),
            new Student("Diana", 95.5),
            new Student("Eve", 88.0)
        };
        
        System.out.println("Original students:");
        for (Student student : students) {
            System.out.println("  " + student);
        }
        
        // Sort by grade (natural ordering)
        Arrays.sort(students);
        System.out.println("\nSorted by grade (natural ordering):");
        for (Student student : students) {
            System.out.println("  " + student);
        }
        
        // Product class with Comparable implementation
        System.out.println("\nProduct Class with Comparable Implementation:");
        System.out.println("-------------------------------------------");
        
        Product[] products = {
            new Product("Laptop", 999.99),
            new Product("Mouse", 29.99),
            new Product("Keyboard", 79.99),
            new Product("Monitor", 299.99),
            new Product("Headphones", 149.99)
        };
        
        System.out.println("Original products:");
        for (Product product : products) {
            System.out.println("  " + product);
        }
        
        // Sort by price (natural ordering)
        Arrays.sort(products);
        System.out.println("\nSorted by price (natural ordering):");
        for (Product product : products) {
            System.out.println("  " + product);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates sorting with Comparable
     * 
     * This section shows how to use Comparable for sorting
     * different types of collections.
     */
    private static void demonstrateSortingWithComparable() {
        System.out.println("5. Sorting with Comparable:");
        System.out.println("==========================");
        
        // Sorting arrays
        System.out.println("Sorting Arrays:");
        System.out.println("-------------");
        
        Integer[] numbers = {5, 2, 8, 1, 9, 3, 7, 4, 6};
        System.out.println("Original array: " + Arrays.toString(numbers));
        
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));
        
        // Sorting lists
        System.out.println("\nSorting Lists:");
        System.out.println("------------");
        
        List<String> words = new ArrayList<>();
        words.add("zebra");
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("date");
        
        System.out.println("Original list: " + words);
        
        Collections.sort(words);
        System.out.println("Sorted list: " + words);
        
        // Sorting with custom objects
        System.out.println("\nSorting with Custom Objects:");
        System.out.println("--------------------------");
        
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 20));
        people.add(new Person("Diana", 35));
        people.add(new Person("Eve", 28));
        
        System.out.println("Original people:");
        for (Person person : people) {
            System.out.println("  " + person);
        }
        
        Collections.sort(people);
        System.out.println("\nSorted people (by age):");
        for (Person person : people) {
            System.out.println("  " + person);
        }
        
        // Sorting with different data types
        System.out.println("\nSorting with Different Data Types:");
        System.out.println("--------------------------------");
        
        // Double array
        Double[] doubles = {3.14, 2.71, 1.41, 1.73, 2.23};
        System.out.println("Original doubles: " + Arrays.toString(doubles));
        Arrays.sort(doubles);
        System.out.println("Sorted doubles: " + Arrays.toString(doubles));
        
        // Character array
        Character[] chars = {'z', 'a', 'm', 'b', 'c'};
        System.out.println("Original chars: " + Arrays.toString(chars));
        Arrays.sort(chars);
        System.out.println("Sorted chars: " + Arrays.toString(chars));
        
        // Boolean array (Note: Boolean doesn't implement Comparable)
        System.out.println("\nNote: Boolean doesn't implement Comparable");
        System.out.println("Boolean values: true, false");
        System.out.println("Cannot sort boolean arrays using Comparable");
        
        System.out.println();
    }
    
    /**
     * Demonstrates TreeSet with Comparable
     * 
     * This section shows how TreeSet uses Comparable
     * to maintain sorted order.
     */
    private static void demonstrateTreeSetWithComparable() {
        System.out.println("6. TreeSet with Comparable:");
        System.out.println("==========================");
        
        // TreeSet with Integer
        System.out.println("TreeSet with Integer:");
        System.out.println("-------------------");
        
        java.util.TreeSet<Integer> numberSet = new java.util.TreeSet<>();
        numberSet.add(5);
        numberSet.add(2);
        numberSet.add(8);
        numberSet.add(1);
        numberSet.add(9);
        numberSet.add(3);
        numberSet.add(7);
        numberSet.add(4);
        numberSet.add(6);
        
        System.out.println("TreeSet (automatically sorted): " + numberSet);
        
        // TreeSet with String
        System.out.println("\nTreeSet with String:");
        System.out.println("------------------");
        
        java.util.TreeSet<String> wordSet = new java.util.TreeSet<>();
        wordSet.add("zebra");
        wordSet.add("apple");
        wordSet.add("banana");
        wordSet.add("cherry");
        wordSet.add("date");
        
        System.out.println("TreeSet (automatically sorted): " + wordSet);
        
        // TreeSet with custom objects
        System.out.println("\nTreeSet with Custom Objects:");
        System.out.println("---------------------------");
        
        java.util.TreeSet<Person> personSet = new java.util.TreeSet<>();
        personSet.add(new Person("Alice", 25));
        personSet.add(new Person("Bob", 30));
        personSet.add(new Person("Charlie", 20));
        personSet.add(new Person("Diana", 35));
        personSet.add(new Person("Eve", 28));
        
        System.out.println("TreeSet (automatically sorted by age):");
        for (Person person : personSet) {
            System.out.println("  " + person);
        }
        
        // TreeSet operations
        System.out.println("\nTreeSet Operations:");
        System.out.println("-----------------");
        
        java.util.TreeSet<Integer> set = new java.util.TreeSet<>();
        set.add(10);
        set.add(5);
        set.add(15);
        set.add(20);
        set.add(1);
        
        System.out.println("TreeSet: " + set);
        System.out.println("First element: " + set.first());
        System.out.println("Last element: " + set.last());
        System.out.println("Head set (elements < 10): " + set.headSet(10));
        System.out.println("Tail set (elements >= 10): " + set.tailSet(10));
        System.out.println("Sub set (elements >= 5 and < 15): " + set.subSet(5, 15));
        
        // TreeSet with duplicate elements
        System.out.println("\nTreeSet with Duplicate Elements:");
        System.out.println("-------------------------------");
        
        java.util.TreeSet<String> duplicateSet = new java.util.TreeSet<>();
        duplicateSet.add("apple");
        duplicateSet.add("banana");
        duplicateSet.add("apple"); // Duplicate
        duplicateSet.add("cherry");
        duplicateSet.add("banana"); // Duplicate
        
        System.out.println("TreeSet (duplicates automatically removed): " + duplicateSet);
        
        System.out.println();
    }
    
    /**
     * Demonstrates TreeMap with Comparable
     * 
     * This section shows how TreeMap uses Comparable
     * to maintain sorted order of keys.
     */
    private static void demonstrateTreeMapWithComparable() {
        System.out.println("7. TreeMap with Comparable:");
        System.out.println("==========================");
        
        // TreeMap with Integer keys
        System.out.println("TreeMap with Integer Keys:");
        System.out.println("------------------------");
        
        java.util.TreeMap<Integer, String> numberMap = new java.util.TreeMap<>();
        numberMap.put(5, "Five");
        numberMap.put(2, "Two");
        numberMap.put(8, "Eight");
        numberMap.put(1, "One");
        numberMap.put(9, "Nine");
        numberMap.put(3, "Three");
        numberMap.put(7, "Seven");
        numberMap.put(4, "Four");
        numberMap.put(6, "Six");
        
        System.out.println("TreeMap (automatically sorted by key): " + numberMap);
        
        // TreeMap with String keys
        System.out.println("\nTreeMap with String Keys:");
        System.out.println("-----------------------");
        
        java.util.TreeMap<String, Integer> wordMap = new java.util.TreeMap<>();
        wordMap.put("zebra", 5);
        wordMap.put("apple", 1);
        wordMap.put("banana", 2);
        wordMap.put("cherry", 3);
        wordMap.put("date", 4);
        
        System.out.println("TreeMap (automatically sorted by key): " + wordMap);
        
        // TreeMap with custom object keys
        System.out.println("\nTreeMap with Custom Object Keys:");
        System.out.println("-------------------------------");
        
        java.util.TreeMap<Person, String> personMap = new java.util.TreeMap<>();
        personMap.put(new Person("Alice", 25), "Engineer");
        personMap.put(new Person("Bob", 30), "Manager");
        personMap.put(new Person("Charlie", 20), "Intern");
        personMap.put(new Person("Diana", 35), "Director");
        personMap.put(new Person("Eve", 28), "Developer");
        
        System.out.println("TreeMap (automatically sorted by key - age):");
        for (java.util.Map.Entry<Person, String> entry : personMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        
        // TreeMap operations
        System.out.println("\nTreeMap Operations:");
        System.out.println("-----------------");
        
        java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
        map.put(10, "Ten");
        map.put(5, "Five");
        map.put(15, "Fifteen");
        map.put(20, "Twenty");
        map.put(1, "One");
        
        System.out.println("TreeMap: " + map);
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last key: " + map.lastKey());
        System.out.println("Head map (keys < 10): " + map.headMap(10));
        System.out.println("Tail map (keys >= 10): " + map.tailMap(10));
        System.out.println("Sub map (keys >= 5 and < 15): " + map.subMap(5, 15));
        
        // TreeMap with duplicate keys
        System.out.println("\nTreeMap with Duplicate Keys:");
        System.out.println("---------------------------");
        
        java.util.TreeMap<String, Integer> duplicateMap = new java.util.TreeMap<>();
        duplicateMap.put("apple", 1);
        duplicateMap.put("banana", 2);
        duplicateMap.put("apple", 10); // Duplicate key - value will be updated
        duplicateMap.put("cherry", 3);
        
        System.out.println("TreeMap (duplicate keys update values): " + duplicateMap);
        
        System.out.println();
    }
    
    /**
     * Demonstrates complex Comparable examples
     * 
     * This section shows more complex examples of
     * implementing Comparable in real-world scenarios.
     */
    private static void demonstrateComplexComparableExamples() {
        System.out.println("8. Complex Comparable Examples:");
        System.out.println("==============================");
        
        // Employee class with multiple comparison criteria
        System.out.println("Employee Class with Multiple Comparison Criteria:");
        System.out.println("----------------------------------------------");
        
        Employee[] employees = {
            new Employee("Alice", "Engineering", 75000),
            new Employee("Bob", "Marketing", 65000),
            new Employee("Charlie", "Engineering", 80000),
            new Employee("Diana", "Sales", 70000),
            new Employee("Eve", "Engineering", 75000)
        };
        
        System.out.println("Original employees:");
        for (Employee emp : employees) {
            System.out.println("  " + emp);
        }
        
        // Sort by salary (natural ordering)
        Arrays.sort(employees);
        System.out.println("\nSorted by salary (natural ordering):");
        for (Employee emp : employees) {
            System.out.println("  " + emp);
        }
        
        // Book class with title comparison
        System.out.println("\nBook Class with Title Comparison:");
        System.out.println("--------------------------------");
        
        Book[] books = {
            new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925),
            new Book("To Kill a Mockingbird", "Harper Lee", 1960),
            new Book("1984", "George Orwell", 1949),
            new Book("Pride and Prejudice", "Jane Austen", 1813),
            new Book("The Catcher in the Rye", "J.D. Salinger", 1951)
        };
        
        System.out.println("Original books:");
        for (Book book : books) {
            System.out.println("  " + book);
        }
        
        // Sort by title (natural ordering)
        Arrays.sort(books);
        System.out.println("\nSorted by title (natural ordering):");
        for (Book book : books) {
            System.out.println("  " + book);
        }
        
        // Date class with date comparison
        System.out.println("\nDate Class with Date Comparison:");
        System.out.println("-------------------------------");
        
        Date[] dates = {
            new Date(2024, 12, 25),
            new Date(2024, 1, 1),
            new Date(2024, 6, 15),
            new Date(2024, 3, 10),
            new Date(2024, 9, 5)
        };
        
        System.out.println("Original dates:");
        for (Date date : dates) {
            System.out.println("  " + date);
        }
        
        // Sort by date (natural ordering)
        Arrays.sort(dates);
        System.out.println("\nSorted by date (natural ordering):");
        for (Date date : dates) {
            System.out.println("  " + date);
        }
        
        // Version class with version comparison
        System.out.println("\nVersion Class with Version Comparison:");
        System.out.println("------------------------------------");
        
        Version[] versions = {
            new Version(2, 1, 0),
            new Version(1, 0, 0),
            new Version(2, 0, 1),
            new Version(1, 5, 2),
            new Version(2, 1, 1)
        };
        
        System.out.println("Original versions:");
        for (Version version : versions) {
            System.out.println("  " + version);
        }
        
        // Sort by version (natural ordering)
        Arrays.sort(versions);
        System.out.println("\nSorted by version (natural ordering):");
        for (Version version : versions) {
            System.out.println("  " + version);
        }
        
        // Complex comparison with multiple fields
        System.out.println("\nComplex Comparison with Multiple Fields:");
        System.out.println("--------------------------------------");
        
        ComplexObject[] objects = {
            new ComplexObject("A", 1, 10.5),
            new ComplexObject("B", 2, 5.5),
            new ComplexObject("A", 2, 10.5),
            new ComplexObject("B", 1, 5.5),
            new ComplexObject("C", 1, 15.5)
        };
        
        System.out.println("Original objects:");
        for (ComplexObject obj : objects) {
            System.out.println("  " + obj);
        }
        
        // Sort by multiple fields (natural ordering)
        Arrays.sort(objects);
        System.out.println("\nSorted by multiple fields (natural ordering):");
        for (ComplexObject obj : objects) {
            System.out.println("  " + obj);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices for implementing Comparable
     * 
     * This section shows best practices and common patterns
     * for implementing Comparable effectively.
     */
    private static void demonstrateBestPractices() {
        System.out.println("9. Best Practices:");
        System.out.println("=================");
        
        // Best Practice 1: Consistent with equals
        System.out.println("Best Practice 1: Consistent with equals");
        System.out.println("-------------------------------------");
        
        Person p1 = new Person("John", 25);
        Person p2 = new Person("Jane", 25);
        
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.compareTo(p2): " + p1.compareTo(p2));
        System.out.println("Note: compareTo should be consistent with equals");
        
        // Best Practice 2: Handle null values
        System.out.println("\nBest Practice 2: Handle null values");
        System.out.println("---------------------------------");
        
        System.out.println("Note: compareTo should throw NullPointerException for null arguments");
        System.out.println("This is the standard behavior for Comparable implementations");
        
        // Best Practice 3: Use appropriate return values
        System.out.println("\nBest Practice 3: Use appropriate return values");
        System.out.println("--------------------------------------------");
        
        System.out.println("Return values should be:");
        System.out.println("• Negative: if this object is less than the argument");
        System.out.println("• Zero: if this object is equal to the argument");
        System.out.println("• Positive: if this object is greater than the argument");
        
        // Best Practice 4: Avoid floating point comparison
        System.out.println("\nBest Practice 4: Avoid floating point comparison");
        System.out.println("-----------------------------------------------");
        
        System.out.println("For floating point numbers, use Double.compare() or Float.compare()");
        System.out.println("Example: Double.compare(3.14, 2.71)");
        System.out.println("This handles special cases like NaN and infinity correctly");
        
        // Best Practice 5: Use existing Comparable implementations
        System.out.println("\nBest Practice 5: Use existing Comparable implementations");
        System.out.println("------------------------------------------------------");
        
        System.out.println("Leverage existing Comparable implementations:");
        System.out.println("• String.compareTo() for string comparison");
        System.out.println("• Integer.compareTo() for integer comparison");
        System.out.println("• Double.compareTo() for double comparison");
        System.out.println("• Date.compareTo() for date comparison");
        
        // Best Practice 6: Consider performance
        System.out.println("\nBest Practice 6: Consider performance");
        System.out.println("-----------------------------------");
        
        System.out.println("Performance considerations:");
        System.out.println("• Keep compareTo() method simple and fast");
        System.out.println("• Avoid complex calculations in compareTo()");
        System.out.println("• Cache frequently used values");
        System.out.println("• Use primitive types when possible");
        
        // Best Practice 7: Document the ordering
        System.out.println("\nBest Practice 7: Document the ordering");
        System.out.println("------------------------------------");
        
        System.out.println("Always document what the natural ordering represents:");
        System.out.println("• What fields are compared");
        System.out.println("• In what order fields are compared");
        System.out.println("• What the ordering means for the business logic");
        
        // Common mistakes to avoid
        System.out.println("\nCommon Mistakes to Avoid:");
        System.out.println("------------------------");
        System.out.println("• Don't use subtraction for comparison (can cause overflow)");
        System.out.println("• Don't ignore null values");
        System.out.println("• Don't make compareTo inconsistent with equals");
        System.out.println("• Don't use floating point arithmetic for comparison");
        System.out.println("• Don't forget to handle edge cases");
        
        // Performance tips
        System.out.println("\nPerformance Tips:");
        System.out.println("---------------");
        System.out.println("• Use primitive types when possible");
        System.out.println("• Avoid creating new objects in compareTo()");
        System.out.println("• Use efficient comparison algorithms");
        System.out.println("• Consider using Comparator for different orderings");
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Comparable defines natural ordering of objects");
        System.out.println("• compareTo() returns negative, zero, or positive values");
        System.out.println("• Use for sorting collections and maintaining order");
        System.out.println("• TreeSet and TreeMap use Comparable for ordering");
        System.out.println("• Be consistent with equals() method");
        System.out.println("• Handle null values appropriately");
        System.out.println("• Use existing Comparable implementations when possible");
        System.out.println("• Consider performance implications");
        System.out.println("• Document the ordering clearly");
    }
    
    // Inner classes for demonstration
    
    /**
     * Person class implementing Comparable
     * Natural ordering: by age
     */
    static class Person implements Comparable<Person> {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.age, other.age);
        }
        
        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return age == person.age && java.util.Objects.equals(name, person.name);
        }
        
        @Override
        public int hashCode() {
            return java.util.Objects.hash(name, age);
        }
    }
    
    /**
     * Student class implementing Comparable
     * Natural ordering: by grade (descending)
     */
    static class Student implements Comparable<Student> {
        private String name;
        private double grade;
        
        public Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }
        
        @Override
        public int compareTo(Student other) {
            return Double.compare(other.grade, this.grade); // Descending order
        }
        
        @Override
        public String toString() {
            return "Student{name='" + name + "', grade=" + grade + "}";
        }
    }
    
    /**
     * Product class implementing Comparable
     * Natural ordering: by price
     */
    static class Product implements Comparable<Product> {
        private String name;
        private double price;
        
        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
        
        @Override
        public int compareTo(Product other) {
            return Double.compare(this.price, other.price);
        }
        
        @Override
        public String toString() {
            return "Product{name='" + name + "', price=" + price + "}";
        }
    }
    
    /**
     * Employee class implementing Comparable
     * Natural ordering: by salary
     */
    static class Employee implements Comparable<Employee> {
        private String name;
        private String department;
        private double salary;
        
        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        
        @Override
        public int compareTo(Employee other) {
            return Double.compare(this.salary, other.salary);
        }
        
        @Override
        public String toString() {
            return "Employee{name='" + name + "', department='" + department + "', salary=" + salary + "}";
        }
    }
    
    /**
     * Book class implementing Comparable
     * Natural ordering: by title
     */
    static class Book implements Comparable<Book> {
        private String title;
        private String author;
        private int year;
        
        public Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }
        
        @Override
        public int compareTo(Book other) {
            return this.title.compareTo(other.title);
        }
        
        @Override
        public String toString() {
            return "Book{title='" + title + "', author='" + author + "', year=" + year + "}";
        }
    }
    
    /**
     * Date class implementing Comparable
     * Natural ordering: by date
     */
    static class Date implements Comparable<Date> {
        private int year;
        private int month;
        private int day;
        
        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        
        @Override
        public int compareTo(Date other) {
            int yearComparison = Integer.compare(this.year, other.year);
            if (yearComparison != 0) return yearComparison;
            
            int monthComparison = Integer.compare(this.month, other.month);
            if (monthComparison != 0) return monthComparison;
            
            return Integer.compare(this.day, other.day);
        }
        
        @Override
        public String toString() {
            return String.format("%04d-%02d-%02d", year, month, day);
        }
    }
    
    /**
     * Version class implementing Comparable
     * Natural ordering: by version number
     */
    static class Version implements Comparable<Version> {
        private int major;
        private int minor;
        private int patch;
        
        public Version(int major, int minor, int patch) {
            this.major = major;
            this.minor = minor;
            this.patch = patch;
        }
        
        @Override
        public int compareTo(Version other) {
            int majorComparison = Integer.compare(this.major, other.major);
            if (majorComparison != 0) return majorComparison;
            
            int minorComparison = Integer.compare(this.minor, other.minor);
            if (minorComparison != 0) return minorComparison;
            
            return Integer.compare(this.patch, other.patch);
        }
        
        @Override
        public String toString() {
            return major + "." + minor + "." + patch;
        }
    }
    
    /**
     * ComplexObject class implementing Comparable
     * Natural ordering: by name, then by number, then by value
     */
    static class ComplexObject implements Comparable<ComplexObject> {
        private String name;
        private int number;
        private double value;
        
        public ComplexObject(String name, int number, double value) {
            this.name = name;
            this.number = number;
            this.value = value;
        }
        
        @Override
        public int compareTo(ComplexObject other) {
            int nameComparison = this.name.compareTo(other.name);
            if (nameComparison != 0) return nameComparison;
            
            int numberComparison = Integer.compare(this.number, other.number);
            if (numberComparison != 0) return numberComparison;
            
            return Double.compare(this.value, other.value);
        }
        
        @Override
        public String toString() {
            return "ComplexObject{name='" + name + "', number=" + number + ", value=" + value + "}";
        }
    }
}
