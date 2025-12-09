package com.tutorial.intermediate;

/**
 * Nested and Inner Classes Demo - Mastering Class Nesting in Java
 * 
 * This comprehensive tutorial demonstrates the concept of nested and inner classes in Java,
 * which allow you to define classes within other classes. This provides better organization,
 * encapsulation, and access to outer class members.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what nested and inner classes are
 * - Learn about static nested classes
 * - Master non-static inner classes
 * - Understand local inner classes
 * - Learn about anonymous inner classes
 * - Practice with real-world examples
 * - Understand when to use each type of nested class
 * 
 * KEY CONCEPTS:
 * 1. Static Nested Class: A class defined inside another class with static modifier
 * 2. Non-static Inner Class: A class defined inside another class without static modifier
 * 3. Local Inner Class: A class defined inside a method
 * 4. Anonymous Inner Class: A class without a name, defined inline
 * 5. Access to Outer Class: Inner classes can access outer class members
 * 6. Memory Management: Understanding memory implications of different nested class types
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class NestedInnerClassesDemo {
    
    // Static nested class
    static class StaticNestedClass {
        private String message;
        
        public StaticNestedClass(String message) {
            this.message = message;
        }
        
        public void displayMessage() {
            System.out.println("Static Nested Class: " + message);
        }
        
        public static void staticMethod() {
            System.out.println("Static method in static nested class");
        }
    }
    
    // Non-static inner class
    class InnerClass {
        private String message;
        
        public InnerClass(String message) {
            this.message = message;
        }
        
        public void displayMessage() {
            System.out.println("Inner Class: " + message);
            System.out.println("Accessing outer class field: " + outerField);
            outerMethod();
        }
    }
    
    // Outer class fields and methods
    private String outerField = "Outer class field";
    
    private void outerMethod() {
        System.out.println("Outer class method called");
    }
    
    public static void main(String[] args) {
        System.out.println("=== Nested and Inner Classes Demo ===");
        System.out.println();
        
        // 1. Static Nested Classes
        demonstrateStaticNestedClasses();
        
        // 2. Non-static Inner Classes
        demonstrateNonStaticInnerClasses();
        
        // 3. Local Inner Classes
        demonstrateLocalInnerClasses();
        
        // 4. Anonymous Inner Classes
        demonstrateAnonymousInnerClasses();
        
        // 5. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 6. Access Patterns
        demonstrateAccessPatterns();
        
        // 7. Memory Considerations
        demonstrateMemoryConsiderations();
        
        // 8. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates static nested classes
     * 
     * Static nested classes are defined with the static modifier and
     * can be instantiated without an instance of the outer class.
     */
    private static void demonstrateStaticNestedClasses() {
        System.out.println("1. Static Nested Classes:");
        System.out.println("========================");
        
        // Creating instance of static nested class
        StaticNestedClass nested = new StaticNestedClass("Hello from static nested class");
        nested.displayMessage();
        
        // Calling static method
        StaticNestedClass.staticMethod();
        
        // Static nested class can access static members of outer class
        System.out.println("Accessing outer static field: " + outerStaticField);
        outerStaticMethod();
        
        // Example with multiple static nested classes
        System.out.println("\nMultiple static nested classes:");
        System.out.println("-------------------------------");
        
        // Creating instances of different static nested classes
        StaticNestedClass nested1 = new StaticNestedClass("First nested class");
        StaticNestedClass nested2 = new StaticNestedClass("Second nested class");
        
        nested1.displayMessage();
        nested2.displayMessage();
        
        System.out.println();
    }
    
    /**
     * Demonstrates non-static inner classes
     * 
     * Non-static inner classes can access instance members of the outer class
     * and require an instance of the outer class to be created.
     */
    private static void demonstrateNonStaticInnerClasses() {
        System.out.println("2. Non-static Inner Classes:");
        System.out.println("===========================");
        
        // Creating instance of outer class
        NestedInnerClassesDemo outer = new NestedInnerClassesDemo();
        
        // Creating instance of inner class
        InnerClass inner = outer.new InnerClass("Hello from inner class");
        inner.displayMessage();
        
        // Inner class can access outer class instance members
        System.out.println("\nInner class accessing outer class members:");
        System.out.println("----------------------------------------");
        
        InnerClass inner2 = outer.new InnerClass("Second inner class");
        inner2.displayMessage();
        
        // Example with multiple inner classes
        System.out.println("\nMultiple inner classes:");
        System.out.println("----------------------");
        
        InnerClass inner3 = outer.new InnerClass("Third inner class");
        InnerClass inner4 = outer.new InnerClass("Fourth inner class");
        
        inner3.displayMessage();
        inner4.displayMessage();
        
        System.out.println();
    }
    
    /**
     * Demonstrates local inner classes
     * 
     * Local inner classes are defined inside methods and can access
     * local variables and parameters of the enclosing method.
     */
    private static void demonstrateLocalInnerClasses() {
        System.out.println("3. Local Inner Classes:");
        System.out.println("======================");
        
        // Method with local inner class
        demonstrateLocalInnerClass("Hello from local inner class");
        
        // Another example with local inner class
        demonstrateLocalInnerClassWithParameters("John", 25);
        
        System.out.println();
    }
    
    /**
     * Method demonstrating local inner class
     */
    private static void demonstrateLocalInnerClass(String message) {
        // Local variable
        String localVariable = "Local variable";
        
        // Local inner class
        class LocalInnerClass {
            private String innerMessage;
            
            public LocalInnerClass(String innerMessage) {
                this.innerMessage = innerMessage;
            }
            
            public void displayMessage() {
                System.out.println("Local Inner Class: " + innerMessage);
                System.out.println("Accessing local variable: " + localVariable);
                System.out.println("Accessing method parameter: " + message);
            }
        }
        
        // Creating and using local inner class
        LocalInnerClass localInner = new LocalInnerClass(message);
        localInner.displayMessage();
    }
    
    /**
     * Method demonstrating local inner class with parameters
     */
    private static void demonstrateLocalInnerClassWithParameters(String name, int age) {
        // Local inner class with access to parameters
        class PersonInfo {
            public void displayInfo() {
                System.out.println("Person Info - Name: " + name + ", Age: " + age);
            }
        }
        
        PersonInfo personInfo = new PersonInfo();
        personInfo.displayInfo();
    }
    
    /**
     * Demonstrates anonymous inner classes
     * 
     * Anonymous inner classes are classes without a name that are
     * defined inline, typically for implementing interfaces or
     * extending classes.
     */
    private static void demonstrateAnonymousInnerClasses() {
        System.out.println("4. Anonymous Inner Classes:");
        System.out.println("==========================");
        
        // Anonymous inner class implementing interface
        System.out.println("Anonymous class implementing interface:");
        System.out.println("-------------------------------------");
        
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Runnable is running");
            }
        };
        
        runnable.run();
        
        // Anonymous inner class extending class
        System.out.println("\nAnonymous class extending class:");
        System.out.println("--------------------------------");
        
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Anonymous Thread is running");
            }
        };
        
        thread.start();
        
        // Anonymous inner class with custom interface
        System.out.println("\nAnonymous class with custom interface:");
        System.out.println("------------------------------------");
        
        Calculator calculator = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        
        System.out.println("Anonymous Calculator result: " + calculator.calculate(5, 3));
        
        // Multiple anonymous inner classes
        System.out.println("\nMultiple anonymous inner classes:");
        System.out.println("--------------------------------");
        
        Calculator add = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        
        Calculator multiply = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a * b;
            }
        };
        
        System.out.println("Addition: " + add.calculate(4, 5));
        System.out.println("Multiplication: " + multiply.calculate(4, 5));
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples of nested classes
     * 
     * This section shows practical examples of how nested classes
     * are used in real-world software development.
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("5. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: LinkedList with Node
        System.out.println("Example 1: LinkedList with Node");
        System.out.println("-------------------------------");
        
        LinkedList<String> list = new LinkedList<>();
        list.add("First");
        list.add("Second");
        list.add("Third");
        
        System.out.println("LinkedList contents:");
        list.display();
        
        // Example 2: Tree with TreeNode
        System.out.println("\nExample 2: Tree with TreeNode");
        System.out.println("-----------------------------");
        
        Tree<Integer> tree = new Tree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        
        System.out.println("Tree traversal:");
        tree.inorderTraversal();
        
        // Example 3: Map with Entry
        System.out.println("\nExample 3: Map with Entry");
        System.out.println("------------------------");
        
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("apple", 5);
        map.put("banana", 3);
        map.put("cherry", 8);
        
        System.out.println("Map contents:");
        map.display();
        
        System.out.println();
    }
    
    /**
     * Demonstrates access patterns in nested classes
     * 
     * This section shows how different types of nested classes
     * can access members of their outer classes.
     */
    private static void demonstrateAccessPatterns() {
        System.out.println("6. Access Patterns:");
        System.out.println("==================");
        
        // Creating outer class instance
        NestedInnerClassesDemo outer = new NestedInnerClassesDemo();
        
        // Static nested class access
        System.out.println("Static nested class access:");
        System.out.println("--------------------------");
        
        StaticNestedClass staticNested = new StaticNestedClass("Static access");
        staticNested.displayMessage();
        
        // Non-static inner class access
        System.out.println("\nNon-static inner class access:");
        System.out.println("------------------------------");
        
        InnerClass inner = outer.new InnerClass("Inner access");
        inner.displayMessage();
        
        // Local inner class access
        System.out.println("\nLocal inner class access:");
        System.out.println("------------------------");
        
        demonstrateLocalInnerClass("Local access");
        
        // Anonymous inner class access
        System.out.println("\nAnonymous inner class access:");
        System.out.println("-----------------------------");
        
        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class accessing outer static field: " + outerStaticField);
            }
        };
        
        anonymousRunnable.run();
        
        System.out.println();
    }
    
    /**
     * Demonstrates memory considerations for nested classes
     * 
     * This section shows the memory implications of different
     * types of nested classes.
     */
    private static void demonstrateMemoryConsiderations() {
        System.out.println("7. Memory Considerations:");
        System.out.println("========================");
        
        // Static nested class memory
        System.out.println("Static nested class memory:");
        System.out.println("--------------------------");
        
        StaticNestedClass staticNested = new StaticNestedClass("Static memory test");
        System.out.println("Static nested class created without outer class instance");
        
        // Non-static inner class memory
        System.out.println("\nNon-static inner class memory:");
        System.out.println("------------------------------");
        
        NestedInnerClassesDemo outer = new NestedInnerClassesDemo();
        InnerClass inner = outer.new InnerClass("Inner memory test");
        System.out.println("Inner class created with outer class instance");
        System.out.println("Inner class holds reference to outer class");
        
        // Memory implications
        System.out.println("\nMemory implications:");
        System.out.println("-------------------");
        System.out.println("• Static nested classes: No reference to outer class");
        System.out.println("• Non-static inner classes: Hold reference to outer class");
        System.out.println("• Local inner classes: Can access local variables");
        System.out.println("• Anonymous inner classes: Created inline, no name");
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices for nested classes
     * 
     * This section shows best practices for using nested classes
     * effectively in Java applications.
     */
    private static void demonstrateBestPractices() {
        System.out.println("8. Best Practices:");
        System.out.println("=================");
        
        // Best Practice 1: Use static nested classes for utility classes
        System.out.println("Best Practice 1: Static nested classes for utilities");
        System.out.println("--------------------------------------------------");
        
        StaticNestedClass utility = new StaticNestedClass("Utility class");
        utility.displayMessage();
        
        // Best Practice 2: Use inner classes for closely related functionality
        System.out.println("\nBest Practice 2: Inner classes for related functionality");
        System.out.println("------------------------------------------------------");
        
        NestedInnerClassesDemo outer = new NestedInnerClassesDemo();
        InnerClass related = outer.new InnerClass("Related functionality");
        related.displayMessage();
        
        // Best Practice 3: Use local inner classes for method-specific logic
        System.out.println("\nBest Practice 3: Local inner classes for method-specific logic");
        System.out.println("------------------------------------------------------------");
        
        demonstrateLocalInnerClass("Method-specific logic");
        
        // Best Practice 4: Use anonymous inner classes for simple implementations
        System.out.println("\nBest Practice 4: Anonymous inner classes for simple implementations");
        System.out.println("----------------------------------------------------------------");
        
        Calculator simpleAdd = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        
        System.out.println("Simple addition: " + simpleAdd.calculate(10, 20));
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Static nested classes: No reference to outer class, can be instantiated independently");
        System.out.println("• Non-static inner classes: Hold reference to outer class, can access instance members");
        System.out.println("• Local inner classes: Defined in methods, can access local variables");
        System.out.println("• Anonymous inner classes: No name, defined inline for simple implementations");
        System.out.println("• Use static nested classes for utility classes");
        System.out.println("• Use inner classes for closely related functionality");
        System.out.println("• Use local inner classes for method-specific logic");
        System.out.println("• Use anonymous inner classes for simple implementations");
    }
    
    // Static fields and methods for demonstration
    private static String outerStaticField = "Outer static field";
    
    private static void outerStaticMethod() {
        System.out.println("Outer static method called");
    }
}

// Interface for anonymous inner class demonstration
interface Calculator {
    int calculate(int a, int b);
}

// Real-world examples

/**
 * LinkedList class demonstrating static nested class
 */
class LinkedList<T> {
    private Node<T> head;
    private int size;
    
    // Static nested class for Node
    static class Node<T> {
        private T data;
        private Node<T> next;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
        
        public T getData() {
            return data;
        }
        
        public Node<T> getNext() {
            return next;
        }
        
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
    
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }
    
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.println("Data: " + current.getData());
            current = current.getNext();
        }
    }
    
    public int size() {
        return size;
    }
}

/**
 * Tree class demonstrating static nested class
 */
class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;
    
    // Static nested class for TreeNode
    static class TreeNode<T> {
        private T data;
        private TreeNode<T> left;
        private TreeNode<T> right;
        
        public TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
        public T getData() {
            return data;
        }
        
        public TreeNode<T> getLeft() {
            return left;
        }
        
        public void setLeft(TreeNode<T> left) {
            this.left = left;
        }
        
        public TreeNode<T> getRight() {
            return right;
        }
        
        public void setRight(TreeNode<T> right) {
            this.right = right;
        }
    }
    
    public void insert(T data) {
        root = insertRecursive(root, data);
    }
    
    private TreeNode<T> insertRecursive(TreeNode<T> node, T data) {
        if (node == null) {
            return new TreeNode<>(data);
        }
        
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insertRecursive(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(insertRecursive(node.getRight(), data));
        }
        
        return node;
    }
    
    public void inorderTraversal() {
        inorderRecursive(root);
    }
    
    private void inorderRecursive(TreeNode<T> node) {
        if (node != null) {
            inorderRecursive(node.getLeft());
            System.out.println("Data: " + node.getData());
            inorderRecursive(node.getRight());
        }
    }
}

/**
 * SimpleMap class demonstrating static nested class
 */
class SimpleMap<K, V> {
    private Entry<K, V>[] entries;
    private int size;
    private int capacity;
    
    // Static nested class for Entry
    static class Entry<K, V> {
        private K key;
        private V value;
        
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() {
            return key;
        }
        
        public V getValue() {
            return value;
        }
        
        public void setValue(V value) {
            this.value = value;
        }
    }
    
    @SuppressWarnings("unchecked")
    public SimpleMap() {
        this.capacity = 10;
        this.entries = new Entry[capacity];
        this.size = 0;
    }
    
    public void put(K key, V value) {
        if (size >= capacity) {
            resize();
        }
        entries[size] = new Entry<>(key, value);
        size++;
    }
    
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(key)) {
                return entries[i].getValue();
            }
        }
        return null;
    }
    
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println("Key: " + entries[i].getKey() + ", Value: " + entries[i].getValue());
        }
    }
    
    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        Entry<K, V>[] newEntries = new Entry[capacity];
        System.arraycopy(entries, 0, newEntries, 0, size);
        entries = newEntries;
    }
}
