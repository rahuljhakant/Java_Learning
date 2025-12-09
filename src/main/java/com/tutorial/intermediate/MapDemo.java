package com.tutorial.intermediate;

import java.util.*;

/**
 * Map Interface Demo
 * 
 * This class demonstrates:
 * - HashMap implementation
 * - LinkedHashMap implementation
 * - TreeMap implementation
 * - Hashtable implementation
 * - Map operations and methods
 * - Performance characteristics
 * - When to use which implementation
 */
public class MapDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Map Interface Demo ===");
        System.out.println();
        
        // 1. HashMap Demo
        demonstrateHashMap();
        
        // 2. LinkedHashMap Demo
        demonstrateLinkedHashMap();
        
        // 3. TreeMap Demo
        demonstrateTreeMap();
        
        // 4. Hashtable Demo
        demonstrateHashtable();
        
        // 5. Map Operations
        demonstrateMapOperations();
        
        // 6. Map with Custom Objects
        demonstrateMapWithCustomObjects();
        
        // 7. Performance Comparison
        demonstratePerformanceComparison();
        
        // 8. When to Use Which Map
        demonstrateWhenToUseWhichMap();
    }
    
    /**
     * Demonstrates HashMap implementation
     */
    private static void demonstrateHashMap() {
        System.out.println("1. HashMap Implementation:");
        System.out.println("========================");
        
        // Creating HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        
        // Adding key-value pairs
        hashMap.put("Apple", 5);
        hashMap.put("Banana", 3);
        hashMap.put("Orange", 8);
        hashMap.put("Grape", 2);
        
        System.out.println("HashMap: " + hashMap);
        System.out.println("Size: " + hashMap.size());
        
        // Getting values
        System.out.println("Value for 'Apple': " + hashMap.get("Apple"));
        System.out.println("Value for 'Mango': " + hashMap.get("Mango")); // null
        
        // Checking if key exists
        System.out.println("Contains key 'Banana': " + hashMap.containsKey("Banana"));
        System.out.println("Contains value 8: " + hashMap.containsValue(8));
        
        // Updating values
        hashMap.put("Apple", 10); // Update existing key
        System.out.println("After updating 'Apple': " + hashMap);
        
        // Removing entries
        hashMap.remove("Grape");
        System.out.println("After removing 'Grape': " + hashMap);
        
        // Iterating through HashMap
        System.out.println("Iterating through HashMap:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        
        // Iterating through keys
        System.out.println("Keys: " + hashMap.keySet());
        
        // Iterating through values
        System.out.println("Values: " + hashMap.values());
        
        // Adding null key and value
        hashMap.put(null, 0);
        hashMap.put("NullValue", null);
        System.out.println("After adding null key and value: " + hashMap);
        System.out.println();
    }
    
    /**
     * Demonstrates LinkedHashMap implementation
     */
    private static void demonstrateLinkedHashMap() {
        System.out.println("2. LinkedHashMap Implementation:");
        System.out.println("==============================");
        
        // Creating LinkedHashMap
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        
        // Adding entries in order
        linkedHashMap.put("First", "1st");
        linkedHashMap.put("Second", "2nd");
        linkedHashMap.put("Third", "3rd");
        linkedHashMap.put("Fourth", "4th");
        
        System.out.println("LinkedHashMap: " + linkedHashMap);
        
        // LinkedHashMap maintains insertion order
        System.out.println("Order is maintained: " + linkedHashMap);
        
        // Accessing an entry moves it to the end (if accessOrder is true)
        Map<String, String> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
        accessOrderMap.put("A", "1");
        accessOrderMap.put("B", "2");
        accessOrderMap.put("C", "3");
        
        System.out.println("Before access: " + accessOrderMap);
        accessOrderMap.get("A"); // Access A
        System.out.println("After accessing 'A': " + accessOrderMap);
        
        // Iterating through LinkedHashMap
        System.out.println("Iterating through LinkedHashMap:");
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
    }
    
    /**
     * Demonstrates TreeMap implementation
     */
    private static void demonstrateTreeMap() {
        System.out.println("3. TreeMap Implementation:");
        System.out.println("========================");
        
        // Creating TreeMap
        Map<String, Integer> treeMap = new TreeMap<>();
        
        // Adding entries (will be automatically sorted by key)
        treeMap.put("Charlie", 25);
        treeMap.put("Alice", 30);
        treeMap.put("Bob", 28);
        treeMap.put("David", 22);
        
        System.out.println("TreeMap: " + treeMap);
        
        // TreeMap methods
        TreeMap<String, Integer> tm = (TreeMap<String, Integer>) treeMap;
        System.out.println("First key: " + tm.firstKey());
        System.out.println("Last key: " + tm.lastKey());
        System.out.println("First entry: " + tm.firstEntry());
        System.out.println("Last entry: " + tm.lastEntry());
        
        // Head map (keys less than specified key)
        System.out.println("Head map (keys < 'Charlie'): " + tm.headMap("Charlie"));
        
        // Tail map (keys greater than or equal to specified key)
        System.out.println("Tail map (keys >= 'Charlie'): " + tm.tailMap("Charlie"));
        
        // Sub map (keys in range)
        System.out.println("Sub map (keys >= 'Alice' and < 'David'): " + tm.subMap("Alice", "David"));
        
        // TreeMap with custom comparator
        Map<String, Integer> reverseTreeMap = new TreeMap<>(Collections.reverseOrder());
        reverseTreeMap.put("Apple", 5);
        reverseTreeMap.put("Banana", 3);
        reverseTreeMap.put("Cherry", 8);
        
        System.out.println("TreeMap with reverse order: " + reverseTreeMap);
        
        // TreeMap with case-insensitive comparator
        Map<String, Integer> caseInsensitiveTreeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        caseInsensitiveTreeMap.put("apple", 5);
        caseInsensitiveTreeMap.put("Banana", 3);
        caseInsensitiveTreeMap.put("CHERRY", 8);
        
        System.out.println("Case-insensitive TreeMap: " + caseInsensitiveTreeMap);
        System.out.println();
    }
    
    /**
     * Demonstrates Hashtable implementation
     */
    private static void demonstrateHashtable() {
        System.out.println("4. Hashtable Implementation:");
        System.out.println("===========================");
        
        // Creating Hashtable
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        
        // Adding entries
        hashtable.put("Java", 25);
        hashtable.put("Python", 30);
        hashtable.put("C++", 35);
        hashtable.put("JavaScript", 28);
        
        System.out.println("Hashtable: " + hashtable);
        System.out.println("Size: " + hashtable.size());
        
        // Hashtable is synchronized (thread-safe)
        System.out.println("Hashtable is synchronized: " + (hashtable instanceof java.util.Hashtable));
        
        // Hashtable doesn't allow null keys or values
        try {
            hashtable.put(null, 0);
        } catch (NullPointerException e) {
            System.out.println("Cannot add null key: " + e.getMessage());
        }
        
        try {
            hashtable.put("NullValue", null);
        } catch (NullPointerException e) {
            System.out.println("Cannot add null value: " + e.getMessage());
        }
        
        // Iterating through Hashtable
        System.out.println("Iterating through Hashtable:");
        Enumeration<String> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println("  " + key + " -> " + hashtable.get(key));
        }
        System.out.println();
    }
    
    /**
     * Demonstrates Map operations
     */
    private static void demonstrateMapOperations() {
        System.out.println("5. Map Operations:");
        System.out.println("=================");
        
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);
        
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("C", 30);
        map2.put("D", 4);
        map2.put("E", 5);
        
        System.out.println("Map 1: " + map1);
        System.out.println("Map 2: " + map2);
        
        // Merging maps
        Map<String, Integer> merged = new HashMap<>(map1);
        map2.forEach((key, value) -> 
            merged.merge(key, value, (v1, v2) -> v1 + v2));
        System.out.println("Merged map: " + merged);
        
        // Computing values
        Map<String, Integer> computed = new HashMap<>(map1);
        computed.compute("A", (key, value) -> value * 10);
        computed.computeIfAbsent("F", key -> 6);
        computed.computeIfPresent("B", (key, value) -> value * 2);
        System.out.println("Computed map: " + computed);
        
        // Filtering map
        Map<String, Integer> filtered = new HashMap<>();
        map1.entrySet().stream()
            .filter(entry -> entry.getValue() > 1)
            .forEach(entry -> filtered.put(entry.getKey(), entry.getValue()));
        System.out.println("Filtered map (values > 1): " + filtered);
        
        // Transforming map
        Map<String, String> transformed = new HashMap<>();
        map1.forEach((key, value) -> 
            transformed.put(key, "Value: " + value));
        System.out.println("Transformed map: " + transformed);
        
        // Getting default values
        System.out.println("Value for 'X' (default 0): " + map1.getOrDefault("X", 0));
        
        // Putting if absent
        map1.putIfAbsent("D", 4);
        System.out.println("After putIfAbsent('D', 4): " + map1);
        
        // Replacing values
        map1.replace("A", 10);
        map1.replace("B", 2, 20);
        System.out.println("After replacing values: " + map1);
        
        // Removing with condition
        map1.remove("C", 3);
        System.out.println("After removing 'C' with value 3: " + map1);
        System.out.println();
    }
    
    /**
     * Demonstrates Map with custom objects
     */
    private static void demonstrateMapWithCustomObjects() {
        System.out.println("6. Map with Custom Objects:");
        System.out.println("==========================");
        
        // Map with custom objects as values
        Map<String, Student> studentMap = new HashMap<>();
        studentMap.put("CS001", new Student("John", 20, "CS"));
        studentMap.put("EE001", new Student("Jane", 21, "EE"));
        studentMap.put("CS002", new Student("Bob", 19, "CS"));
        
        System.out.println("Student Map: " + studentMap);
        
        // Map with custom objects as keys (must implement equals and hashCode)
        Map<Student, String> gradeMap = new HashMap<>();
        Student student1 = new Student("Alice", 20, "CS");
        Student student2 = new Student("Bob", 21, "EE");
        Student student3 = new Student("Alice", 20, "CS"); // Duplicate
        
        gradeMap.put(student1, "A");
        gradeMap.put(student2, "B");
        gradeMap.put(student3, "A+"); // Will replace the previous entry
        
        System.out.println("Grade Map: " + gradeMap);
        System.out.println("Size: " + gradeMap.size()); // Should be 2, not 3
        
        // TreeMap with custom objects as keys (must implement Comparable)
        Map<Student, Integer> scoreMap = new TreeMap<>();
        scoreMap.put(new Student("Charlie", 19, "CS"), 95);
        scoreMap.put(new Student("Alice", 20, "EE"), 88);
        scoreMap.put(new Student("Bob", 21, "CS"), 92);
        
        System.out.println("Score Map (sorted by name): " + scoreMap);
        
        // TreeMap with custom comparator
        Map<Student, Integer> ageScoreMap = new TreeMap<>(Comparator.comparing(Student::getAge));
        ageScoreMap.put(new Student("Alice", 20, "CS"), 88);
        ageScoreMap.put(new Student("Bob", 19, "EE"), 92);
        ageScoreMap.put(new Student("Charlie", 21, "CS"), 95);
        
        System.out.println("Age Score Map (sorted by age): " + ageScoreMap);
        System.out.println();
    }
    
    /**
     * Demonstrates performance comparison between Map implementations
     */
    private static void demonstratePerformanceComparison() {
        System.out.println("7. Performance Comparison:");
        System.out.println("=========================");
        
        int size = 100000;
        
        // HashMap performance
        long startTime = System.currentTimeMillis();
        Map<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            hashMap.put(i, "Value" + i);
        }
        long hashMapTime = System.currentTimeMillis() - startTime;
        System.out.println("HashMap - Adding " + size + " entries: " + hashMapTime + "ms");
        
        // LinkedHashMap performance
        startTime = System.currentTimeMillis();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            linkedHashMap.put(i, "Value" + i);
        }
        long linkedHashMapTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedHashMap - Adding " + size + " entries: " + linkedHashMapTime + "ms");
        
        // TreeMap performance
        startTime = System.currentTimeMillis();
        Map<Integer, String> treeMap = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            treeMap.put(i, "Value" + i);
        }
        long treeMapTime = System.currentTimeMillis() - startTime;
        System.out.println("TreeMap - Adding " + size + " entries: " + treeMapTime + "ms");
        
        // Hashtable performance
        startTime = System.currentTimeMillis();
        Map<Integer, String> hashtable = new Hashtable<>();
        for (int i = 0; i < size; i++) {
            hashtable.put(i, "Value" + i);
        }
        long hashtableTime = System.currentTimeMillis() - startTime;
        System.out.println("Hashtable - Adding " + size + " entries: " + hashtableTime + "ms");
        
        // Lookup performance
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            hashMap.get(i * 100);
        }
        long hashMapLookupTime = System.currentTimeMillis() - startTime;
        System.out.println("HashMap - Lookup (1000 times): " + hashMapLookupTime + "ms");
        
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            treeMap.get(i * 100);
        }
        long treeMapLookupTime = System.currentTimeMillis() - startTime;
        System.out.println("TreeMap - Lookup (1000 times): " + treeMapLookupTime + "ms");
        
        System.out.println();
    }
    
    /**
     * Demonstrates when to use which Map implementation
     */
    private static void demonstrateWhenToUseWhichMap() {
        System.out.println("8. When to Use Which Map:");
        System.out.println("========================");
        
        System.out.println("HashMap:");
        System.out.println("  - Use when you need fast insertion, deletion, and lookup");
        System.out.println("  - Order is not important");
        System.out.println("  - Most commonly used Map implementation");
        System.out.println("  - Allows one null key and multiple null values");
        System.out.println("  - O(1) average time for basic operations");
        
        System.out.println("\nLinkedHashMap:");
        System.out.println("  - Use when you need to maintain insertion order");
        System.out.println("  - Slightly slower than HashMap due to maintaining order");
        System.out.println("  - Good for LRU (Least Recently Used) caches");
        System.out.println("  - O(1) average time for basic operations");
        
        System.out.println("\nTreeMap:");
        System.out.println("  - Use when you need sorted keys");
        System.out.println("  - Slower than HashMap for basic operations");
        System.out.println("  - Provides range operations (headMap, tailMap, subMap)");
        System.out.println("  - O(log n) time for basic operations");
        System.out.println("  - Keys must be Comparable or provide Comparator");
        
        System.out.println("\nHashtable:");
        System.out.println("  - Legacy class, similar to HashMap");
        System.out.println("  - Synchronized (thread-safe)");
        System.out.println("  - Slower than HashMap due to synchronization");
        System.out.println("  - Doesn't allow null keys or values");
        System.out.println("  - Use HashMap with Collections.synchronizedMap() instead");
        
        System.out.println();
    }
}
