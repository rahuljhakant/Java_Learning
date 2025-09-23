package com.tutorial.intermediate;

import java.util.*;

/**
 * List Interface Demo
 * 
 * This class demonstrates:
 * - ArrayList implementation
 * - LinkedList implementation
 * - Vector implementation
 * - Stack implementation
 * - List operations and methods
 * - Performance comparisons
 * - When to use which implementation
 */
public class ListDemo {
    
    public static void main(String[] args) {
        System.out.println("=== List Interface Demo ===");
        System.out.println();
        
        // 1. ArrayList Demo
        demonstrateArrayList();
        
        // 2. LinkedList Demo
        demonstrateLinkedList();
        
        // 3. Vector Demo
        demonstrateVector();
        
        // 4. Stack Demo
        demonstrateStack();
        
        // 5. List Operations
        demonstrateListOperations();
        
        // 6. Performance Comparison
        demonstratePerformanceComparison();
        
        // 7. When to Use Which List
        demonstrateWhenToUseWhichList();
    }
    
    /**
     * Demonstrates ArrayList implementation
     */
    private static void demonstrateArrayList() {
        System.out.println("1. ArrayList Implementation:");
        System.out.println("===========================");
        
        // Creating ArrayList
        List<String> arrayList = new ArrayList<>();
        
        // Adding elements
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");
        arrayList.add("JavaScript");
        
        System.out.println("ArrayList: " + arrayList);
        System.out.println("Size: " + arrayList.size());
        
        // Adding element at specific index
        arrayList.add(1, "Go");
        System.out.println("After adding 'Go' at index 1: " + arrayList);
        
        // Accessing elements
        System.out.println("Element at index 2: " + arrayList.get(2));
        
        // Removing elements
        arrayList.remove("C++");
        System.out.println("After removing 'C++': " + arrayList);
        
        // Checking if element exists
        System.out.println("Contains 'Java': " + arrayList.contains("Java"));
        System.out.println("Index of 'Python': " + arrayList.indexOf("Python"));
        
        // Converting to array
        String[] array = arrayList.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println();
    }
    
    /**
     * Demonstrates LinkedList implementation
     */
    private static void demonstrateLinkedList() {
        System.out.println("2. LinkedList Implementation:");
        System.out.println("============================");
        
        // Creating LinkedList
        List<Integer> linkedList = new LinkedList<>();
        
        // Adding elements
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        
        System.out.println("LinkedList: " + linkedList);
        
        // Adding at beginning and end
        linkedList.add(0, 5);  // Add at beginning
        linkedList.add(50);    // Add at end
        System.out.println("After adding 5 at beginning and 50 at end: " + linkedList);
        
        // LinkedList specific operations (when cast to LinkedList)
        LinkedList<Integer> ll = (LinkedList<Integer>) linkedList;
        ll.addFirst(1);
        ll.addLast(100);
        System.out.println("After addFirst(1) and addLast(100): " + ll);
        
        // Remove first and last
        System.out.println("First element: " + ll.removeFirst());
        System.out.println("Last element: " + ll.removeLast());
        System.out.println("After removing first and last: " + ll);
        
        // Get first and last
        System.out.println("First element: " + ll.getFirst());
        System.out.println("Last element: " + ll.getLast());
        System.out.println();
    }
    
    /**
     * Demonstrates Vector implementation
     */
    private static void demonstrateVector() {
        System.out.println("3. Vector Implementation:");
        System.out.println("========================");
        
        // Creating Vector
        Vector<String> vector = new Vector<>();
        
        // Adding elements
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Orange");
        
        System.out.println("Vector: " + vector);
        System.out.println("Size: " + vector.size());
        System.out.println("Capacity: " + vector.capacity());
        
        // Adding more elements to see capacity increase
        for (int i = 0; i < 10; i++) {
            vector.add("Fruit" + i);
        }
        
        System.out.println("After adding 10 more elements:");
        System.out.println("Size: " + vector.size());
        System.out.println("Capacity: " + vector.capacity());
        
        // Vector with initial capacity
        Vector<Integer> vectorWithCapacity = new Vector<>(5);
        System.out.println("Vector with initial capacity 5: " + vectorWithCapacity.capacity());
        
        // Vector with capacity increment
        Vector<Integer> vectorWithIncrement = new Vector<>(3, 2);
        for (int i = 0; i < 8; i++) {
            vectorWithIncrement.add(i);
        }
        System.out.println("Vector with capacity increment 2: " + vectorWithIncrement);
        System.out.println("Capacity: " + vectorWithIncrement.capacity());
        System.out.println();
    }
    
    /**
     * Demonstrates Stack implementation
     */
    private static void demonstrateStack() {
        System.out.println("4. Stack Implementation:");
        System.out.println("=======================");
        
        // Creating Stack
        Stack<String> stack = new Stack<>();
        
        // Pushing elements
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.push("Fourth");
        
        System.out.println("Stack: " + stack);
        System.out.println("Stack size: " + stack.size());
        
        // Peeking at top element
        System.out.println("Top element (peek): " + stack.peek());
        System.out.println("Stack after peek: " + stack);
        
        // Popping elements
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
        
        // Checking if stack is empty
        System.out.println("Is stack empty: " + stack.empty());
        
        // Searching for element
        System.out.println("Position of 'Second' from top: " + stack.search("Second"));
        
        // Popping all elements
        System.out.println("Popping all elements:");
        while (!stack.empty()) {
            System.out.println("Popped: " + stack.pop());
        }
        System.out.println("Stack after popping all: " + stack);
        System.out.println("Is stack empty: " + stack.empty());
        System.out.println();
    }
    
    /**
     * Demonstrates common List operations
     */
    private static void demonstrateListOperations() {
        System.out.println("5. List Operations:");
        System.out.println("==================");
        
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        
        List<String> list2 = new ArrayList<>();
        list2.add("C");
        list2.add("D");
        list2.add("E");
        list2.add("F");
        
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        
        // Sublist
        List<String> subList = list1.subList(1, 3);
        System.out.println("Sublist (1, 3): " + subList);
        
        // List iteration
        System.out.println("Iterating through list:");
        for (String item : list1) {
            System.out.println("  " + item);
        }
        
        // List iteration with index
        System.out.println("Iterating with index:");
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("  Index " + i + ": " + list1.get(i));
        }
        
        // List iteration using Iterator
        System.out.println("Iterating using Iterator:");
        Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }
        
        // List iteration using ListIterator
        System.out.println("Iterating using ListIterator (backwards):");
        ListIterator<String> listIterator = list1.listIterator(list1.size());
        while (listIterator.hasPrevious()) {
            System.out.println("  " + listIterator.previous());
        }
        
        // Sorting
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(9);
        
        System.out.println("Numbers before sorting: " + numbers);
        Collections.sort(numbers);
        System.out.println("Numbers after sorting: " + numbers);
        
        // Reversing
        Collections.reverse(numbers);
        System.out.println("Numbers after reversing: " + numbers);
        
        // Shuffling
        Collections.shuffle(numbers);
        System.out.println("Numbers after shuffling: " + numbers);
        System.out.println();
    }
    
    /**
     * Demonstrates performance comparison between List implementations
     */
    private static void demonstratePerformanceComparison() {
        System.out.println("6. Performance Comparison:");
        System.out.println("=========================");
        
        int size = 100000;
        
        // ArrayList performance
        long startTime = System.currentTimeMillis();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long arrayListTime = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList - Adding " + size + " elements: " + arrayListTime + "ms");
        
        // LinkedList performance
        startTime = System.currentTimeMillis();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        long linkedListTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList - Adding " + size + " elements: " + linkedListTime + "ms");
        
        // Vector performance
        startTime = System.currentTimeMillis();
        List<Integer> vector = new Vector<>();
        for (int i = 0; i < size; i++) {
            vector.add(i);
        }
        long vectorTime = System.currentTimeMillis() - startTime;
        System.out.println("Vector - Adding " + size + " elements: " + vectorTime + "ms");
        
        // Random access performance
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            arrayList.get(i * 100);
        }
        long arrayListAccessTime = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList - Random access (1000 times): " + arrayListAccessTime + "ms");
        
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            linkedList.get(i * 100);
        }
        long linkedListAccessTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList - Random access (1000 times): " + linkedListAccessTime + "ms");
        
        System.out.println();
    }
    
    /**
     * Demonstrates when to use which List implementation
     */
    private static void demonstrateWhenToUseWhichList() {
        System.out.println("7. When to Use Which List:");
        System.out.println("=========================");
        
        System.out.println("ArrayList:");
        System.out.println("  - Use when you need frequent random access");
        System.out.println("  - Good for read-heavy operations");
        System.out.println("  - Not synchronized (not thread-safe)");
        System.out.println("  - Better performance for most operations");
        
        System.out.println("\nLinkedList:");
        System.out.println("  - Use when you need frequent insertions/deletions");
        System.out.println("  - Good for implementing stacks and queues");
        System.out.println("  - Implements both List and Deque interfaces");
        System.out.println("  - Poor performance for random access");
        
        System.out.println("\nVector:");
        System.out.println("  - Legacy class, similar to ArrayList");
        System.out.println("  - Synchronized (thread-safe)");
        System.out.println("  - Slower than ArrayList due to synchronization");
        System.out.println("  - Use ArrayList with Collections.synchronizedList() instead");
        
        System.out.println("\nStack:");
        System.out.println("  - Use when you need LIFO (Last In, First Out) behavior");
        System.out.println("  - Good for implementing algorithms like expression evaluation");
        System.out.println("  - Extends Vector, so it's synchronized");
        System.out.println("  - Consider using ArrayDeque for better performance");
        
        System.out.println();
    }
}
