package com.tutorial.intermediate;

import java.util.*;

/**
 * Set Interface Demo
 * 
 * This class demonstrates:
 * - HashSet implementation
 * - LinkedHashSet implementation
 * - TreeSet implementation
 * - Set operations and methods
 * - Performance characteristics
 * - When to use which implementation
 */
public class SetDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Set Interface Demo ===");
        System.out.println();
        
        // 1. HashSet Demo
        demonstrateHashSet();
        
        // 2. LinkedHashSet Demo
        demonstrateLinkedHashSet();
        
        // 3. TreeSet Demo
        demonstrateTreeSet();
        
        // 4. Set Operations
        demonstrateSetOperations();
        
        // 5. Set with Custom Objects
        demonstrateSetWithCustomObjects();
        
        // 6. Performance Comparison
        demonstratePerformanceComparison();
        
        // 7. When to Use Which Set
        demonstrateWhenToUseWhichSet();
    }
    
    /**
     * Demonstrates HashSet implementation
     */
    private static void demonstrateHashSet() {
        System.out.println("1. HashSet Implementation:");
        System.out.println("=========================");
        
        // Creating HashSet
        Set<String> hashSet = new HashSet<>();
        
        // Adding elements
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");
        hashSet.add("Grape");
        hashSet.add("Apple"); // Duplicate - will be ignored
        
        System.out.println("HashSet: " + hashSet);
        System.out.println("Size: " + hashSet.size());
        
        // Checking if element exists
        System.out.println("Contains 'Apple': " + hashSet.contains("Apple"));
        System.out.println("Contains 'Mango': " + hashSet.contains("Mango"));
        
        // Removing elements
        hashSet.remove("Banana");
        System.out.println("After removing 'Banana': " + hashSet);
        
        // Adding null (HashSet allows one null)
        hashSet.add(null);
        System.out.println("After adding null: " + hashSet);
        
        // Iterating through HashSet
        System.out.println("Iterating through HashSet:");
        for (String fruit : hashSet) {
            System.out.println("  " + fruit);
        }
        System.out.println();
    }
    
    /**
     * Demonstrates LinkedHashSet implementation
     */
    private static void demonstrateLinkedHashSet() {
        System.out.println("2. LinkedHashSet Implementation:");
        System.out.println("===============================");
        
        // Creating LinkedHashSet
        Set<String> linkedHashSet = new LinkedHashSet<>();
        
        // Adding elements in order
        linkedHashSet.add("First");
        linkedHashSet.add("Second");
        linkedHashSet.add("Third");
        linkedHashSet.add("Fourth");
        linkedHashSet.add("Second"); // Duplicate - will be ignored
        
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println("Size: " + linkedHashSet.size());
        
        // LinkedHashSet maintains insertion order
        System.out.println("Order is maintained: " + linkedHashSet);
        
        // Adding element at the end
        linkedHashSet.add("Fifth");
        System.out.println("After adding 'Fifth': " + linkedHashSet);
        
        // Iterating through LinkedHashSet
        System.out.println("Iterating through LinkedHashSet:");
        for (String item : linkedHashSet) {
            System.out.println("  " + item);
        }
        System.out.println();
    }
    
    /**
     * Demonstrates TreeSet implementation
     */
    private static void demonstrateTreeSet() {
        System.out.println("3. TreeSet Implementation:");
        System.out.println("=========================");
        
        // Creating TreeSet
        Set<Integer> treeSet = new TreeSet<>();
        
        // Adding elements (will be automatically sorted)
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);
        treeSet.add(1);
        treeSet.add(9);
        treeSet.add(3);
        
        System.out.println("TreeSet: " + treeSet);
        System.out.println("Size: " + treeSet.size());
        
        // TreeSet methods
        TreeSet<Integer> ts = (TreeSet<Integer>) treeSet;
        System.out.println("First element: " + ts.first());
        System.out.println("Last element: " + ts.last());
        System.out.println("Head set (elements < 5): " + ts.headSet(5));
        System.out.println("Tail set (elements >= 5): " + ts.tailSet(5));
        System.out.println("Sub set (elements >= 3 and < 8): " + ts.subSet(3, 8));
        
        // TreeSet with custom comparator
        Set<String> reverseTreeSet = new TreeSet<>(Collections.reverseOrder());
        reverseTreeSet.add("Apple");
        reverseTreeSet.add("Banana");
        reverseTreeSet.add("Cherry");
        reverseTreeSet.add("Date");
        
        System.out.println("TreeSet with reverse order: " + reverseTreeSet);
        
        // TreeSet with case-insensitive comparator
        Set<String> caseInsensitiveTreeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        caseInsensitiveTreeSet.add("apple");
        caseInsensitiveTreeSet.add("Banana");
        caseInsensitiveTreeSet.add("CHERRY");
        caseInsensitiveTreeSet.add("date");
        
        System.out.println("Case-insensitive TreeSet: " + caseInsensitiveTreeSet);
        System.out.println();
    }
    
    /**
     * Demonstrates Set operations
     */
    private static void demonstrateSetOperations() {
        System.out.println("4. Set Operations:");
        System.out.println("=================");
        
        Set<String> set1 = new HashSet<>();
        set1.add("A");
        set1.add("B");
        set1.add("C");
        set1.add("D");
        
        Set<String> set2 = new HashSet<>();
        set2.add("C");
        set2.add("D");
        set2.add("E");
        set2.add("F");
        
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        
        // Union (addAll)
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union (set1 ∪ set2): " + union);
        
        // Intersection (retainAll)
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection (set1 ∩ set2): " + intersection);
        
        // Difference (removeAll)
        Set<String> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference (set1 - set2): " + difference);
        
        // Symmetric difference
        Set<String> symmetricDifference = new HashSet<>(union);
        symmetricDifference.removeAll(intersection);
        System.out.println("Symmetric difference: " + symmetricDifference);
        
        // Subset check
        Set<String> subset = new HashSet<>();
        subset.add("A");
        subset.add("B");
        System.out.println("Is {A, B} subset of set1: " + set1.containsAll(subset));
        
        // Disjoint check
        Set<String> disjoint = new HashSet<>();
        disjoint.add("X");
        disjoint.add("Y");
        System.out.println("Are set1 and {X, Y} disjoint: " + Collections.disjoint(set1, disjoint));
        System.out.println();
    }
    
    /**
     * Demonstrates Set with custom objects
     */
    private static void demonstrateSetWithCustomObjects() {
        System.out.println("5. Set with Custom Objects:");
        System.out.println("==========================");
        
        // Set with custom objects (must implement equals and hashCode)
        Set<Student> studentSet = new HashSet<>();
        
        Student student1 = new Student("John", 20, "CS");
        Student student2 = new Student("Jane", 21, "EE");
        Student student3 = new Student("John", 20, "CS"); // Duplicate
        
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        
        System.out.println("Student Set: " + studentSet);
        System.out.println("Size: " + studentSet.size()); // Should be 2, not 3
        
        // TreeSet with custom objects (must implement Comparable)
        Set<Student> studentTreeSet = new TreeSet<>();
        studentTreeSet.add(new Student("Alice", 19, "CS"));
        studentTreeSet.add(new Student("Bob", 20, "EE"));
        studentTreeSet.add(new Student("Charlie", 18, "CS"));
        
        System.out.println("Student TreeSet (sorted by name): " + studentTreeSet);
        
        // TreeSet with custom comparator
        Set<Student> studentTreeSetByAge = new TreeSet<>(Comparator.comparing(Student::getAge));
        studentTreeSetByAge.add(new Student("Alice", 19, "CS"));
        studentTreeSetByAge.add(new Student("Bob", 20, "EE"));
        studentTreeSetByAge.add(new Student("Charlie", 18, "CS"));
        
        System.out.println("Student TreeSet (sorted by age): " + studentTreeSetByAge);
        System.out.println();
    }
    
    /**
     * Demonstrates performance comparison between Set implementations
     */
    private static void demonstratePerformanceComparison() {
        System.out.println("6. Performance Comparison:");
        System.out.println("=========================");
        
        int size = 100000;
        
        // HashSet performance
        long startTime = System.currentTimeMillis();
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            hashSet.add(i);
        }
        long hashSetTime = System.currentTimeMillis() - startTime;
        System.out.println("HashSet - Adding " + size + " elements: " + hashSetTime + "ms");
        
        // LinkedHashSet performance
        startTime = System.currentTimeMillis();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            linkedHashSet.add(i);
        }
        long linkedHashSetTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedHashSet - Adding " + size + " elements: " + linkedHashSetTime + "ms");
        
        // TreeSet performance
        startTime = System.currentTimeMillis();
        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            treeSet.add(i);
        }
        long treeSetTime = System.currentTimeMillis() - startTime;
        System.out.println("TreeSet - Adding " + size + " elements: " + treeSetTime + "ms");
        
        // Lookup performance
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            hashSet.contains(i * 100);
        }
        long hashSetLookupTime = System.currentTimeMillis() - startTime;
        System.out.println("HashSet - Lookup (1000 times): " + hashSetLookupTime + "ms");
        
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            treeSet.contains(i * 100);
        }
        long treeSetLookupTime = System.currentTimeMillis() - startTime;
        System.out.println("TreeSet - Lookup (1000 times): " + treeSetLookupTime + "ms");
        
        System.out.println();
    }
    
    /**
     * Demonstrates when to use which Set implementation
     */
    private static void demonstrateWhenToUseWhichSet() {
        System.out.println("7. When to Use Which Set:");
        System.out.println("========================");
        
        System.out.println("HashSet:");
        System.out.println("  - Use when you need fast insertion, deletion, and lookup");
        System.out.println("  - Order is not important");
        System.out.println("  - Most commonly used Set implementation");
        System.out.println("  - O(1) average time for basic operations");
        
        System.out.println("\nLinkedHashSet:");
        System.out.println("  - Use when you need to maintain insertion order");
        System.out.println("  - Slightly slower than HashSet due to maintaining order");
        System.out.println("  - Good for LRU (Least Recently Used) caches");
        System.out.println("  - O(1) average time for basic operations");
        
        System.out.println("\nTreeSet:");
        System.out.println("  - Use when you need sorted elements");
        System.out.println("  - Slower than HashSet for basic operations");
        System.out.println("  - Provides range operations (headSet, tailSet, subSet)");
        System.out.println("  - O(log n) time for basic operations");
        System.out.println("  - Elements must be Comparable or provide Comparator");
        
        System.out.println();
    }
}

/**
 * Student class for demonstrating Set with custom objects
 */
class Student implements Comparable<Student> {
    private String name;
    private int age;
    private String major;
    
    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }
    
    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getMajor() { return major; }
    
    // Override equals and hashCode for HashSet
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return age == student.age && 
               Objects.equals(name, student.name) && 
               Objects.equals(major, student.major);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age, major);
    }
    
    // Implement Comparable for TreeSet
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", major='" + major + "'}";
    }
}
