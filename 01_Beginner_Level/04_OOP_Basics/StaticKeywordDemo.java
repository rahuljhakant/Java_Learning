package com.tutorial.basics;

/**
 * Static Keyword Demo
 * 
 * This class demonstrates:
 * - Static variables (class variables)
 * - Static methods (class methods)
 * - Static blocks
 * - Static nested classes
 * - Static imports
 * - When to use static vs non-static
 */
public class StaticKeywordDemo {
    
    // Static variable (class variable)
    private static int instanceCount = 0;
    private static String className = "StaticKeywordDemo";
    
    // Instance variable
    private String instanceName;
    
    // Static block - executed when class is first loaded
    static {
        System.out.println("Static block executed - class is being loaded");
        System.out.println("Class name: " + className);
    }
    
    // Instance block - executed before each constructor
    {
        instanceCount++;
        System.out.println("Instance block executed - instance #" + instanceCount + " created");
    }
    
    public StaticKeywordDemo(String instanceName) {
        this.instanceName = instanceName;
        System.out.println("Constructor called for: " + instanceName);
    }
    
    public static void main(String[] args) {
        System.out.println("=== Static Keyword Demo ===");
        System.out.println();
        
        // 1. Static Variables
        demonstrateStaticVariables();
        
        // 2. Static Methods
        demonstrateStaticMethods();
        
        // 3. Static vs Instance
        demonstrateStaticVsInstance();
        
        // 4. Static Nested Classes
        demonstrateStaticNestedClasses();
        
        // 5. Static Blocks
        demonstrateStaticBlocks();
        
        // 6. Static Imports
        demonstrateStaticImports();
    }
    
    /**
     * Demonstrates static variables
     */
    private static void demonstrateStaticVariables() {
        System.out.println("1. Static Variables:");
        System.out.println("===================");
        
        System.out.println("Current instance count: " + instanceCount);
        System.out.println("Class name: " + className);
        
        // Creating instances to see static variable behavior
        StaticKeywordDemo obj1 = new StaticKeywordDemo("Object1");
        StaticKeywordDemo obj2 = new StaticKeywordDemo("Object2");
        StaticKeywordDemo obj3 = new StaticKeywordDemo("Object3");
        
        System.out.println("After creating 3 objects:");
        System.out.println("Instance count: " + instanceCount);
        System.out.println("Instance count via obj1: " + obj1.instanceCount);
        System.out.println("Instance count via obj2: " + obj2.instanceCount);
        
        // Static variables are shared among all instances
        System.out.println("All objects share the same static variable");
        System.out.println();
    }
    
    /**
     * Demonstrates static methods
     */
    private static void demonstrateStaticMethods() {
        System.out.println("2. Static Methods:");
        System.out.println("=================");
        
        // Calling static methods without creating objects
        System.out.println("Calling static methods:");
        printClassName();
        System.out.println("Current instance count: " + getInstanceCount());
        
        // Static methods can be called on instances too (not recommended)
        StaticKeywordDemo obj = new StaticKeywordDemo("TestObject");
        obj.printClassName(); // Works but not recommended
        
        // Static utility methods
        System.out.println("Math operations using static methods:");
        System.out.println("Square root of 16: " + Math.sqrt(16));
        System.out.println("Maximum of 10 and 20: " + Math.max(10, 20));
        System.out.println("Random number: " + Math.random());
        System.out.println();
    }
    
    /**
     * Demonstrates static vs instance members
     */
    private static void demonstrateStaticVsInstance() {
        System.out.println("3. Static vs Instance:");
        System.out.println("=====================");
        
        StaticKeywordDemo obj1 = new StaticKeywordDemo("Instance1");
        StaticKeywordDemo obj2 = new StaticKeywordDemo("Instance2");
        
        // Instance variables are unique to each object
        System.out.println("Instance variables:");
        System.out.println("obj1.instanceName: " + obj1.instanceName);
        System.out.println("obj2.instanceName: " + obj2.instanceName);
        
        // Static variables are shared
        System.out.println("Static variables:");
        System.out.println("obj1.instanceCount: " + obj1.instanceCount);
        System.out.println("obj2.instanceCount: " + obj2.instanceCount);
        System.out.println("StaticKeywordDemo.instanceCount: " + StaticKeywordDemo.instanceCount);
        
        // Instance methods can access both static and instance members
        obj1.printInstanceInfo();
        obj2.printInstanceInfo();
        
        // Static methods can only access static members
        printStaticInfo();
        System.out.println();
    }
    
    /**
     * Demonstrates static nested classes
     */
    private static void demonstrateStaticNestedClasses() {
        System.out.println("4. Static Nested Classes:");
        System.out.println("=========================");
        
        // Creating instance of static nested class
        StaticKeywordDemo.StaticNestedClass nested = new StaticKeywordDemo.StaticNestedClass();
        nested.displayMessage();
        
        // Static nested class can access static members of outer class
        nested.accessStaticMembers();
        System.out.println();
    }
    
    /**
     * Demonstrates static blocks
     */
    private static void demonstrateStaticBlocks() {
        System.out.println("5. Static Blocks:");
        System.out.println("================");
        
        System.out.println("Static blocks are executed when the class is first loaded");
        System.out.println("They are executed only once, before any instance is created");
        System.out.println("Multiple static blocks are executed in the order they appear");
        System.out.println();
    }
    
    /**
     * Demonstrates static imports
     */
    private static void demonstrateStaticImports() {
        System.out.println("6. Static Imports:");
        System.out.println("=================");
        
        System.out.println("Static imports allow you to use static members without class name");
        System.out.println("Example: import static java.lang.Math.PI;");
        System.out.println("Then you can use PI directly instead of Math.PI");
        System.out.println("Value of PI: " + Math.PI);
        System.out.println("Value of E: " + Math.E);
        System.out.println();
    }
    
    // Static method
    public static void printClassName() {
        System.out.println("Class name: " + className);
    }
    
    // Static method
    public static int getInstanceCount() {
        return instanceCount;
    }
    
    // Static method
    public static void printStaticInfo() {
        System.out.println("Static method - can only access static members");
        System.out.println("Instance count: " + instanceCount);
        System.out.println("Class name: " + className);
        // System.out.println(instanceName); // This would cause compilation error
    }
    
    // Instance method
    public void printInstanceInfo() {
        System.out.println("Instance method - can access both static and instance members");
        System.out.println("Instance name: " + instanceName);
        System.out.println("Instance count: " + instanceCount);
        System.out.println("Class name: " + className);
    }
    
    // Static nested class
    public static class StaticNestedClass {
        public void displayMessage() {
            System.out.println("This is a static nested class");
        }
        
        public void accessStaticMembers() {
            System.out.println("Static nested class can access static members of outer class");
            System.out.println("Outer class name: " + className);
            System.out.println("Instance count: " + instanceCount);
        }
    }
}

/**
 * Utility class demonstrating static-only design
 */
class MathUtils {
    // Private constructor to prevent instantiation
    private MathUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
    
    // Static utility methods
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static int multiply(int a, int b) {
        return a * b;
    }
    
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}

/**
 * Constants class demonstrating static final variables
 */
class Constants {
    // Static final variables (constants)
    public static final String APPLICATION_NAME = "Java Tutorial";
    public static final String VERSION = "1.0.0";
    public static final int MAX_CONNECTIONS = 100;
    public static final double PI = 3.14159265359;
    
    // Private constructor to prevent instantiation
    private Constants() {
        throw new UnsupportedOperationException("Constants class cannot be instantiated");
    }
}
