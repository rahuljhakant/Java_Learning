package com.tutorial.beginner;

/**
 * Constructors Demo
 * 
 * This class demonstrates:
 * - Default constructor
 * - Parameterized constructor
 * - Constructor overloading
 * - Constructor chaining
 * - Copy constructor
 * - Private constructor (Singleton pattern)
 */
public class ConstructorsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Constructors Demo ===");
        System.out.println();
        
        // 1. Default Constructor
        demonstrateDefaultConstructor();
        
        // 2. Parameterized Constructor
        demonstrateParameterizedConstructor();
        
        // 3. Constructor Overloading
        demonstrateConstructorOverloading();
        
        // 4. Constructor Chaining
        demonstrateConstructorChaining();
        
        // 5. Copy Constructor
        demonstrateCopyConstructor();
        
        // 6. Private Constructor (Singleton)
        demonstratePrivateConstructor();
    }
    
    /**
     * Demonstrates default constructor
     */
    private static void demonstrateDefaultConstructor() {
        System.out.println("1. Default Constructor:");
        System.out.println("======================");
        
        // Using default constructor
        Person person1 = new Person();
        System.out.println("Person created with default constructor: " + person1);
        System.out.println();
    }
    
    /**
     * Demonstrates parameterized constructor
     */
    private static void demonstrateParameterizedConstructor() {
        System.out.println("2. Parameterized Constructor:");
        System.out.println("=============================");
        
        // Using parameterized constructor
        Person person2 = new Person("Alice", 25, "Engineer");
        System.out.println("Person created with parameterized constructor: " + person2);
        System.out.println();
    }
    
    /**
     * Demonstrates constructor overloading
     */
    private static void demonstrateConstructorOverloading() {
        System.out.println("3. Constructor Overloading:");
        System.out.println("===========================");
        
        // Different constructors for different scenarios
        Person person1 = new Person("Bob");
        Person person2 = new Person("Charlie", 30);
        Person person3 = new Person("David", 28, "Doctor");
        
        System.out.println("Person with name only: " + person1);
        System.out.println("Person with name and age: " + person2);
        System.out.println("Person with all details: " + person3);
        System.out.println();
    }
    
    /**
     * Demonstrates constructor chaining
     */
    private static void demonstrateConstructorChaining() {
        System.out.println("4. Constructor Chaining:");
        System.out.println("========================");
        
        // Constructor chaining example
        Employee employee = new Employee("Eve", 32, "Manager", 75000);
        System.out.println("Employee created with constructor chaining: " + employee);
        System.out.println();
    }
    
    /**
     * Demonstrates copy constructor
     */
    private static void demonstrateCopyConstructor() {
        System.out.println("5. Copy Constructor:");
        System.out.println("===================");
        
        // Original person
        Person original = new Person("Frank", 35, "Teacher");
        System.out.println("Original person: " + original);
        
        // Creating a copy using copy constructor
        Person copy = new Person(original);
        System.out.println("Copied person: " + copy);
        
        // Modifying the copy doesn't affect the original
        copy.setName("Frank Jr.");
        copy.setAge(10);
        System.out.println("After modifying copy:");
        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);
        System.out.println();
    }
    
    /**
     * Demonstrates private constructor (Singleton pattern)
     */
    private static void demonstratePrivateConstructor() {
        System.out.println("6. Private Constructor (Singleton):");
        System.out.println("===================================");
        
        // Getting singleton instances
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        
        System.out.println("Database connection 1: " + db1);
        System.out.println("Database connection 2: " + db2);
        System.out.println("Are they the same instance? " + (db1 == db2));
        System.out.println();
    }
}

/**
 * Person class to demonstrate various constructor types
 */
class Person {
    private String name;
    private int age;
    private String occupation;
    
    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.occupation = "Unemployed";
        System.out.println("Default constructor called");
    }
    
    // Constructor with name only
    public Person(String name) {
        this(); // Calling default constructor
        this.name = name;
        System.out.println("Constructor with name called");
    }
    
    // Constructor with name and age
    public Person(String name, int age) {
        this(name); // Calling constructor with name
        this.age = age;
        System.out.println("Constructor with name and age called");
    }
    
    // Constructor with all parameters
    public Person(String name, int age, String occupation) {
        this(name, age); // Calling constructor with name and age
        this.occupation = occupation;
        System.out.println("Constructor with all parameters called");
    }
    
    // Copy constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
        this.occupation = other.occupation;
        System.out.println("Copy constructor called");
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getOccupation() {
        return occupation;
    }
    
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", occupation='" + occupation + "'}";
    }
}

/**
 * Employee class demonstrating constructor chaining
 */
class Employee extends Person {
    private double salary;
    
    // Constructor with all parameters including salary
    public Employee(String name, int age, String occupation, double salary) {
        super(name, age, occupation); // Calling parent class constructor
        this.salary = salary;
        System.out.println("Employee constructor called");
    }
    
    // Getter and setter for salary
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", occupation='" + getOccupation() + '\'' +
                ", salary=" + salary +
                '}';
    }
}

/**
 * DatabaseConnection class demonstrating Singleton pattern with private constructor
 */
class DatabaseConnection {
    private static DatabaseConnection instance;
    private String connectionString;
    
    // Private constructor to prevent instantiation
    private DatabaseConnection() {
        this.connectionString = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Database connection created (Singleton)");
    }
    
    // Static method to get the single instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    public String getConnectionString() {
        return connectionString;
    }
    
    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
    
    @Override
    public String toString() {
        return "DatabaseConnection{connectionString='" + connectionString + "'}";
    }
}
