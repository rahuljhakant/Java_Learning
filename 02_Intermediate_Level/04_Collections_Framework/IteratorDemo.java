package com.tutorial.intermediate.collections;

/**
 * Iterator Demo - Mastering Collection Iteration in Java
 * 
 * This comprehensive tutorial demonstrates the Iterator interface in Java,
 * which provides a way to traverse through collections in a uniform manner.
 * Iterators are essential for safely removing elements during iteration
 * and provide a standardized way to access collection elements.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what iterators are and why they're important
 * - Learn about the Iterator interface and its methods
 * - Master different types of iterators (Iterator, ListIterator, Enumeration)
 * - Learn about enhanced for loop and iterator relationship
 * - Practice with real-world iterator examples
 * - Understand iterator best practices and common pitfalls
 * 
 * KEY CONCEPTS:
 * 1. Iterator Interface: Standard interface for collection traversal
 * 2. Iterator Methods: hasNext(), next(), remove()
 * 3. ListIterator: Enhanced iterator for List collections
 * 4. Enumeration: Legacy iterator interface
 * 5. Enhanced For Loop: Syntactic sugar for iterator usage
 * 6. Concurrent Modification: Issues with modifying collections during iteration
 * 7. Iterator vs For Loop: When to use each approach
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
public class IteratorDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Iterator Demo ===");
        System.out.println();
        
        // 1. Basic Iterator Usage
        demonstrateBasicIterator();
        
        // 2. Iterator vs Enhanced For Loop
        demonstrateIteratorVsEnhancedForLoop();
        
        // 3. ListIterator
        demonstrateListIterator();
        
        // 4. Enumeration (Legacy)
        demonstrateEnumeration();
        
        // 5. Iterator with Different Collections
        demonstrateIteratorWithCollections();
        
        // 6. Safe Element Removal
        demonstrateSafeElementRemoval();
        
        // 7. Concurrent Modification
        demonstrateConcurrentModification();
        
        // 8. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 9. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic iterator usage
     * 
     * This section shows how to use the basic Iterator interface
     * to traverse through collections.
     */
    private static void demonstrateBasicIterator() {
        System.out.println("1. Basic Iterator Usage:");
        System.out.println("=======================");
        
        // Creating a list for demonstration
        java.util.List<String> fruits = new java.util.ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Elderberry");
        
        System.out.println("Original list: " + fruits);
        
        // Using Iterator
        System.out.println("\nUsing Iterator:");
        System.out.println("--------------");
        
        java.util.Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("Fruit: " + fruit);
        }
        
        // Iterator with index tracking
        System.out.println("\nIterator with Index Tracking:");
        System.out.println("----------------------------");
        
        iterator = fruits.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("Index " + index + ": " + fruit);
            index++;
        }
        
        // Iterator with conditional processing
        System.out.println("\nIterator with Conditional Processing:");
        System.out.println("-----------------------------------");
        
        iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            if (fruit.startsWith("A") || fruit.startsWith("B")) {
                System.out.println("Fruit starting with A or B: " + fruit);
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates iterator vs enhanced for loop
     * 
     * This section shows the differences between using iterators
     * and enhanced for loops for collection traversal.
     */
    private static void demonstrateIteratorVsEnhancedForLoop() {
        System.out.println("2. Iterator vs Enhanced For Loop:");
        System.out.println("===============================");
        
        java.util.List<Integer> numbers = new java.util.ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        
        System.out.println("Original list: " + numbers);
        
        // Using Iterator
        System.out.println("\nUsing Iterator:");
        System.out.println("--------------");
        
        java.util.Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            System.out.println("Number: " + number);
        }
        
        // Using Enhanced For Loop
        System.out.println("\nUsing Enhanced For Loop:");
        System.out.println("----------------------");
        
        for (Integer number : numbers) {
            System.out.println("Number: " + number);
        }
        
        // Performance comparison
        System.out.println("\nPerformance Comparison:");
        System.out.println("---------------------");
        
        int iterations = 100000;
        
        // Iterator performance
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            iterator = numbers.iterator();
            while (iterator.hasNext()) {
                iterator.next();
            }
        }
        long endTime = System.currentTimeMillis();
        long iteratorTime = endTime - startTime;
        
        // Enhanced for loop performance
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            for (Integer number : numbers) {
                // Just accessing the element
            }
        }
        endTime = System.currentTimeMillis();
        long enhancedForTime = endTime - startTime;
        
        System.out.println("Iterator time: " + iteratorTime + "ms");
        System.out.println("Enhanced for loop time: " + enhancedForTime + "ms");
        
        // When to use which
        System.out.println("\nWhen to Use Which:");
        System.out.println("----------------");
        System.out.println("Use Iterator when:");
        System.out.println("• You need to remove elements during iteration");
        System.out.println("• You need to access iterator methods (hasNext, next, remove)");
        System.out.println("• You're working with legacy code");
        
        System.out.println("\nUse Enhanced For Loop when:");
        System.out.println("• You only need to read elements");
        System.out.println("• You want cleaner, more readable code");
        System.out.println("• You don't need to modify the collection");
        
        System.out.println();
    }
    
    /**
     * Demonstrates ListIterator usage
     * 
     * This section shows how to use ListIterator for bidirectional
     * traversal and modification of List collections.
     */
    private static void demonstrateListIterator() {
        System.out.println("3. ListIterator:");
        System.out.println("===============");
        
        java.util.List<String> colors = new java.util.ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Purple");
        
        System.out.println("Original list: " + colors);
        
        // Forward traversal
        System.out.println("\nForward Traversal:");
        System.out.println("-----------------");
        
        java.util.ListIterator<String> listIterator = colors.listIterator();
        while (listIterator.hasNext()) {
            String color = listIterator.next();
            System.out.println("Color: " + color + " (Index: " + listIterator.nextIndex() + ")");
        }
        
        // Backward traversal
        System.out.println("\nBackward Traversal:");
        System.out.println("------------------");
        
        while (listIterator.hasPrevious()) {
            String color = listIterator.previous();
            System.out.println("Color: " + color + " (Index: " + listIterator.previousIndex() + ")");
        }
        
        // Adding elements during iteration
        System.out.println("\nAdding Elements During Iteration:");
        System.out.println("--------------------------------");
        
        listIterator = colors.listIterator();
        while (listIterator.hasNext()) {
            String color = listIterator.next();
            if (color.equals("Green")) {
                listIterator.add("Orange"); // Add after Green
            }
        }
        System.out.println("After adding Orange: " + colors);
        
        // Replacing elements during iteration
        System.out.println("\nReplacing Elements During Iteration:");
        System.out.println("----------------------------------");
        
        listIterator = colors.listIterator();
        while (listIterator.hasNext()) {
            String color = listIterator.next();
            if (color.equals("Blue")) {
                listIterator.set("Cyan"); // Replace Blue with Cyan
            }
        }
        System.out.println("After replacing Blue with Cyan: " + colors);
        
        // Removing elements during iteration
        System.out.println("\nRemoving Elements During Iteration:");
        System.out.println("----------------------------------");
        
        listIterator = colors.listIterator();
        while (listIterator.hasNext()) {
            String color = listIterator.next();
            if (color.equals("Yellow")) {
                listIterator.remove(); // Remove Yellow
            }
        }
        System.out.println("After removing Yellow: " + colors);
        
        // ListIterator with specific index
        System.out.println("\nListIterator with Specific Index:");
        System.out.println("--------------------------------");
        
        listIterator = colors.listIterator(2); // Start at index 2
        System.out.println("Starting at index 2:");
        while (listIterator.hasNext()) {
            String color = listIterator.next();
            System.out.println("Color: " + color);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates Enumeration usage (legacy)
     * 
     * This section shows how to use Enumeration, which is the
     * legacy iterator interface, mainly for Vector and Hashtable.
     */
    private static void demonstrateEnumeration() {
        System.out.println("4. Enumeration (Legacy):");
        System.out.println("=======================");
        
        // Using Enumeration with Vector
        System.out.println("Using Enumeration with Vector:");
        System.out.println("-----------------------------");
        
        java.util.Vector<String> vector = new java.util.Vector<>();
        vector.add("First");
        vector.add("Second");
        vector.add("Third");
        vector.add("Fourth");
        
        java.util.Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            String element = enumeration.nextElement();
            System.out.println("Element: " + element);
        }
        
        // Using Enumeration with Hashtable
        System.out.println("\nUsing Enumeration with Hashtable:");
        System.out.println("--------------------------------");
        
        java.util.Hashtable<String, Integer> hashtable = new java.util.Hashtable<>();
        hashtable.put("Apple", 5);
        hashtable.put("Banana", 3);
        hashtable.put("Cherry", 8);
        hashtable.put("Date", 2);
        
        // Enumerating keys
        System.out.println("Keys:");
        java.util.Enumeration<String> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println("Key: " + key);
        }
        
        // Enumerating values
        System.out.println("\nValues:");
        java.util.Enumeration<Integer> values = hashtable.elements();
        while (values.hasMoreElements()) {
            Integer value = values.nextElement();
            System.out.println("Value: " + value);
        }
        
        // Converting Enumeration to Iterator
        System.out.println("\nConverting Enumeration to Iterator:");
        System.out.println("----------------------------------");
        
        java.util.Iterator<String> iterator = java.util.Collections.list(vector.elements());
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("Converted element: " + element);
        }
        
        // Legacy vs Modern approach
        System.out.println("\nLegacy vs Modern Approach:");
        System.out.println("------------------------");
        System.out.println("Legacy (Enumeration):");
        System.out.println("• hasMoreElements() and nextElement()");
        System.out.println("• No remove() method");
        System.out.println("• Used with Vector and Hashtable");
        
        System.out.println("\nModern (Iterator):");
        System.out.println("• hasNext() and next()");
        System.out.println("• Has remove() method");
        System.out.println("• Used with all modern collections");
        
        System.out.println();
    }
    
    /**
     * Demonstrates iterator usage with different collections
     * 
     * This section shows how iterators work with different
     * types of collections (List, Set, Map).
     */
    private static void demonstrateIteratorWithCollections() {
        System.out.println("5. Iterator with Different Collections:");
        System.out.println("=====================================");
        
        // Iterator with ArrayList
        System.out.println("Iterator with ArrayList:");
        System.out.println("----------------------");
        
        java.util.List<String> arrayList = new java.util.ArrayList<>();
        arrayList.add("Item1");
        arrayList.add("Item2");
        arrayList.add("Item3");
        
        java.util.Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println("ArrayList item: " + iterator.next());
        }
        
        // Iterator with LinkedList
        System.out.println("\nIterator with LinkedList:");
        System.out.println("-----------------------");
        
        java.util.List<String> linkedList = new java.util.LinkedList<>();
        linkedList.add("Node1");
        linkedList.add("Node2");
        linkedList.add("Node3");
        
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println("LinkedList node: " + iterator.next());
        }
        
        // Iterator with HashSet
        System.out.println("\nIterator with HashSet:");
        System.out.println("--------------------");
        
        java.util.Set<String> hashSet = new java.util.HashSet<>();
        hashSet.add("Set1");
        hashSet.add("Set2");
        hashSet.add("Set3");
        
        iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("HashSet element: " + iterator.next());
        }
        
        // Iterator with TreeSet
        System.out.println("\nIterator with TreeSet:");
        System.out.println("--------------------");
        
        java.util.Set<String> treeSet = new java.util.TreeSet<>();
        treeSet.add("Tree1");
        treeSet.add("Tree2");
        treeSet.add("Tree3");
        
        iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("TreeSet element: " + iterator.next());
        }
        
        // Iterator with HashMap (keys)
        System.out.println("\nIterator with HashMap (keys):");
        System.out.println("----------------------------");
        
        java.util.Map<String, Integer> hashMap = new java.util.HashMap<>();
        hashMap.put("Key1", 1);
        hashMap.put("Key2", 2);
        hashMap.put("Key3", 3);
        
        iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("HashMap key: " + key + ", value: " + hashMap.get(key));
        }
        
        // Iterator with HashMap (values)
        System.out.println("\nIterator with HashMap (values):");
        System.out.println("------------------------------");
        
        iterator = hashMap.values().iterator();
        while (iterator.hasNext()) {
            System.out.println("HashMap value: " + iterator.next());
        }
        
        // Iterator with HashMap (entries)
        System.out.println("\nIterator with HashMap (entries):");
        System.out.println("-------------------------------");
        
        java.util.Iterator<java.util.Map.Entry<String, Integer>> entryIterator = hashMap.entrySet().iterator();
        while (entryIterator.hasNext()) {
            java.util.Map.Entry<String, Integer> entry = entryIterator.next();
            System.out.println("HashMap entry: " + entry.getKey() + " = " + entry.getValue());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates safe element removal during iteration
     * 
     * This section shows how to safely remove elements
     * from collections during iteration using iterators.
     */
    private static void demonstrateSafeElementRemoval() {
        System.out.println("6. Safe Element Removal:");
        System.out.println("=======================");
        
        // Creating a list with some elements to remove
        java.util.List<String> items = new java.util.ArrayList<>();
        items.add("Keep1");
        items.add("Remove");
        items.add("Keep2");
        items.add("Remove");
        items.add("Keep3");
        items.add("Remove");
        
        System.out.println("Original list: " + items);
        
        // Safe removal using Iterator
        System.out.println("\nSafe Removal using Iterator:");
        System.out.println("---------------------------");
        
        java.util.Iterator<String> iterator = items.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("Remove")) {
                iterator.remove(); // Safe removal
                System.out.println("Removed: " + item);
            } else {
                System.out.println("Kept: " + item);
            }
        }
        System.out.println("After safe removal: " + items);
        
        // Demonstrating unsafe removal (will cause exception)
        System.out.println("\nUnsafe Removal (will cause exception):");
        System.out.println("-------------------------------------");
        
        items.clear();
        items.add("Item1");
        items.add("Item2");
        items.add("Item3");
        
        try {
            for (String item : items) {
                if (item.equals("Item2")) {
                    items.remove(item); // This will cause ConcurrentModificationException
                }
            }
        } catch (java.util.ConcurrentModificationException e) {
            System.out.println("Caught ConcurrentModificationException: " + e.getMessage());
        }
        
        // Safe removal with ListIterator
        System.out.println("\nSafe Removal with ListIterator:");
        System.out.println("------------------------------");
        
        items.clear();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");
        
        System.out.println("Original list: " + items);
        
        java.util.ListIterator<String> listIterator = items.listIterator();
        while (listIterator.hasNext()) {
            String item = listIterator.next();
            if (item.equals("B") || item.equals("D")) {
                listIterator.remove();
                System.out.println("Removed: " + item);
            }
        }
        System.out.println("After ListIterator removal: " + items);
        
        // Removing elements based on condition
        System.out.println("\nRemoving Elements Based on Condition:");
        System.out.println("-----------------------------------");
        
        java.util.List<Integer> numbers = new java.util.ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        
        System.out.println("Original numbers: " + numbers);
        
        iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 2 == 0) { // Remove even numbers
                iterator.remove();
            }
        }
        System.out.println("After removing even numbers: " + numbers);
        
        System.out.println();
    }
    
    /**
     * Demonstrates concurrent modification issues
     * 
     * This section shows what happens when collections are
     * modified during iteration and how to avoid these issues.
     */
    private static void demonstrateConcurrentModification() {
        System.out.println("7. Concurrent Modification:");
        System.out.println("==========================");
        
        java.util.List<String> list = new java.util.ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        
        System.out.println("Original list: " + list);
        
        // Concurrent modification with enhanced for loop
        System.out.println("\nConcurrent Modification with Enhanced For Loop:");
        System.out.println("---------------------------------------------");
        
        try {
            for (String item : list) {
                if (item.equals("B")) {
                    list.add("E"); // This will cause ConcurrentModificationException
                }
            }
        } catch (java.util.ConcurrentModificationException e) {
            System.out.println("Caught ConcurrentModificationException: " + e.getMessage());
        }
        
        // Concurrent modification with iterator
        System.out.println("\nConcurrent Modification with Iterator:");
        System.out.println("------------------------------------");
        
        try {
            java.util.Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String item = iterator.next();
                if (item.equals("B")) {
                    list.add("E"); // This will cause ConcurrentModificationException
                }
            }
        } catch (java.util.ConcurrentModificationException e) {
            System.out.println("Caught ConcurrentModificationException: " + e.getMessage());
        }
        
        // Safe modification using iterator
        System.out.println("\nSafe Modification using Iterator:");
        System.out.println("--------------------------------");
        
        java.util.Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("B")) {
                iterator.remove(); // Safe removal
                System.out.println("Safely removed: " + item);
            }
        }
        System.out.println("After safe removal: " + list);
        
        // Concurrent modification with multiple threads
        System.out.println("\nConcurrent Modification with Multiple Threads:");
        System.out.println("--------------------------------------------");
        
        java.util.List<String> threadList = new java.util.ArrayList<>();
        threadList.add("Thread1");
        threadList.add("Thread2");
        threadList.add("Thread3");
        
        // This is a simplified example - in real applications, use proper synchronization
        System.out.println("Note: In real applications, use proper synchronization mechanisms");
        System.out.println("like synchronized collections or concurrent collections");
        
        // Using synchronized collection
        System.out.println("\nUsing Synchronized Collection:");
        System.out.println("-----------------------------");
        
        java.util.List<String> syncList = java.util.Collections.synchronizedList(new java.util.ArrayList<>());
        syncList.add("Sync1");
        syncList.add("Sync2");
        syncList.add("Sync3");
        
        synchronized (syncList) {
            iterator = syncList.iterator();
            while (iterator.hasNext()) {
                String item = iterator.next();
                System.out.println("Synchronized item: " + item);
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples of iterator usage
     * 
     * This section shows practical examples of how iterators
     * are used in real-world applications.
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("8. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: Data Processing
        System.out.println("Example 1: Data Processing");
        System.out.println("-------------------------");
        
        java.util.List<String> data = new java.util.ArrayList<>();
        data.add("user1,John,25,Engineer");
        data.add("user2,Jane,30,Manager");
        data.add("user3,Bob,35,Developer");
        data.add("user4,Alice,28,Designer");
        
        System.out.println("Processing user data:");
        java.util.Iterator<String> iterator = data.iterator();
        while (iterator.hasNext()) {
            String line = iterator.next();
            String[] fields = line.split(",");
            System.out.println("ID: " + fields[0] + ", Name: " + fields[1] + 
                             ", Age: " + fields[2] + ", Job: " + fields[3]);
        }
        
        // Example 2: Filtering Data
        System.out.println("\nExample 2: Filtering Data");
        System.out.println("------------------------");
        
        java.util.List<Integer> numbers = new java.util.ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            numbers.add(i);
        }
        
        System.out.println("Original numbers: " + numbers);
        
        // Remove numbers divisible by 3
        iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 3 == 0) {
                iterator.remove();
            }
        }
        System.out.println("After removing numbers divisible by 3: " + numbers);
        
        // Example 3: Search and Replace
        System.out.println("\nExample 3: Search and Replace");
        System.out.println("----------------------------");
        
        java.util.List<String> text = new java.util.ArrayList<>();
        text.add("Hello World");
        text.add("Java Programming");
        text.add("Hello Java");
        text.add("World of Java");
        
        System.out.println("Original text: " + text);
        
        // Replace "Hello" with "Hi"
        java.util.ListIterator<String> listIterator = text.listIterator();
        while (listIterator.hasNext()) {
            String line = listIterator.next();
            if (line.contains("Hello")) {
                listIterator.set(line.replace("Hello", "Hi"));
            }
        }
        System.out.println("After replacing 'Hello' with 'Hi': " + text);
        
        // Example 4: Duplicate Removal
        System.out.println("\nExample 4: Duplicate Removal");
        System.out.println("---------------------------");
        
        java.util.List<String> duplicates = new java.util.ArrayList<>();
        duplicates.add("Apple");
        duplicates.add("Banana");
        duplicates.add("Apple");
        duplicates.add("Cherry");
        duplicates.add("Banana");
        duplicates.add("Date");
        
        System.out.println("Original list with duplicates: " + duplicates);
        
        java.util.Set<String> seen = new java.util.HashSet<>();
        iterator = duplicates.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (seen.contains(item)) {
                iterator.remove();
            } else {
                seen.add(item);
            }
        }
        System.out.println("After removing duplicates: " + duplicates);
        
        // Example 5: Data Validation
        System.out.println("\nExample 5: Data Validation");
        System.out.println("-------------------------");
        
        java.util.List<String> emails = new java.util.ArrayList<>();
        emails.add("user@example.com");
        emails.add("invalid-email");
        emails.add("admin@company.com");
        emails.add("not-an-email");
        emails.add("test@domain.org");
        
        System.out.println("Original emails: " + emails);
        
        // Remove invalid emails
        iterator = emails.iterator();
        while (iterator.hasNext()) {
            String email = iterator.next();
            if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                iterator.remove();
                System.out.println("Removed invalid email: " + email);
            }
        }
        System.out.println("Valid emails: " + emails);
        
        // Example 6: Batch Processing
        System.out.println("\nExample 6: Batch Processing");
        System.out.println("--------------------------");
        
        java.util.List<String> tasks = new java.util.ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            tasks.add("Task" + i);
        }
        
        System.out.println("Processing tasks in batches:");
        iterator = tasks.iterator();
        int batchSize = 3;
        int currentBatch = 1;
        
        while (iterator.hasNext()) {
            System.out.println("Batch " + currentBatch + ":");
            for (int i = 0; i < batchSize && iterator.hasNext(); i++) {
                String task = iterator.next();
                System.out.println("  Processing: " + task);
            }
            currentBatch++;
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices for using iterators
     * 
     * This section shows best practices and common patterns
     * for using iterators effectively.
     */
    private static void demonstrateBestPractices() {
        System.out.println("9. Best Practices:");
        System.out.println("=================");
        
        // Best Practice 1: Use appropriate iterator type
        System.out.println("Best Practice 1: Use Appropriate Iterator Type");
        System.out.println("---------------------------------------------");
        
        java.util.List<String> list = new java.util.ArrayList<>();
        list.add("Item1");
        list.add("Item2");
        list.add("Item3");
        
        // Use Iterator for simple traversal
        java.util.Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("Simple traversal: " + iterator.next());
        }
        
        // Use ListIterator for bidirectional traversal
        java.util.ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String item = listIterator.next();
            if (item.equals("Item2")) {
                listIterator.add("Item2.5"); // Add after Item2
            }
        }
        System.out.println("After adding with ListIterator: " + list);
        
        // Best Practice 2: Use enhanced for loop when possible
        System.out.println("\nBest Practice 2: Use Enhanced For Loop When Possible");
        System.out.println("--------------------------------------------------");
        
        java.util.Set<String> set = new java.util.HashSet<>();
        set.add("Set1");
        set.add("Set2");
        set.add("Set3");
        
        // Good: Use enhanced for loop for simple traversal
        for (String item : set) {
            System.out.println("Enhanced for loop: " + item);
        }
        
        // Best Practice 3: Handle concurrent modification safely
        System.out.println("\nBest Practice 3: Handle Concurrent Modification Safely");
        System.out.println("----------------------------------------------------");
        
        java.util.List<String> safeList = new java.util.ArrayList<>();
        safeList.add("Safe1");
        safeList.add("Safe2");
        safeList.add("Safe3");
        
        // Safe removal
        iterator = safeList.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("Safe2")) {
                iterator.remove(); // Safe removal
            }
        }
        System.out.println("After safe removal: " + safeList);
        
        // Best Practice 4: Use try-with-resources when applicable
        System.out.println("\nBest Practice 4: Use Try-With-Resources When Applicable");
        System.out.println("-----------------------------------------------------");
        
        // Note: Iterators don't implement AutoCloseable, but this is a general principle
        System.out.println("Note: Iterators don't implement AutoCloseable");
        System.out.println("But always handle exceptions properly when using iterators");
        
        // Best Practice 5: Use iterator for safe removal
        System.out.println("\nBest Practice 5: Use Iterator for Safe Removal");
        System.out.println("---------------------------------------------");
        
        java.util.List<String> removeList = new java.util.ArrayList<>();
        removeList.add("Keep1");
        removeList.add("Remove");
        removeList.add("Keep2");
        removeList.add("Remove");
        
        System.out.println("Before removal: " + removeList);
        
        iterator = removeList.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("Remove")) {
                iterator.remove(); // Safe removal
            }
        }
        System.out.println("After safe removal: " + removeList);
        
        // Common mistakes to avoid
        System.out.println("\nCommon Mistakes to Avoid:");
        System.out.println("------------------------");
        System.out.println("• Don't modify collection during enhanced for loop iteration");
        System.out.println("• Don't call next() without checking hasNext()");
        System.out.println("• Don't call remove() without calling next() first");
        System.out.println("• Don't use iterator after collection modification");
        System.out.println("• Don't forget to handle ConcurrentModificationException");
        
        // Performance tips
        System.out.println("\nPerformance Tips:");
        System.out.println("---------------");
        System.out.println("• Use enhanced for loop for simple traversal (faster)");
        System.out.println("• Use iterator only when you need to remove elements");
        System.out.println("• Use ListIterator for bidirectional traversal");
        System.out.println("• Consider using stream API for complex operations");
        System.out.println("• Use appropriate collection type for your use case");
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Iterator provides safe way to traverse and modify collections");
        System.out.println("• Use enhanced for loop for simple traversal");
        System.out.println("• Use iterator when you need to remove elements during iteration");
        System.out.println("• Use ListIterator for bidirectional traversal and modification");
        System.out.println("• Always handle concurrent modification exceptions");
        System.out.println("• Use appropriate iterator type for your collection");
        System.out.println("• Iterator is essential for safe collection modification");
        System.out.println("• Consider performance implications of different iteration methods");
    }
}
