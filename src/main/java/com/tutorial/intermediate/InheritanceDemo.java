package com.tutorial.intermediate;

/**
 * Inheritance Demo - Mastering Class Inheritance in Java
 * 
 * This comprehensive tutorial demonstrates the concept of inheritance in Java,
 * which is one of the four fundamental principles of Object-Oriented Programming.
 * Inheritance allows a class to inherit properties and methods from another class,
 * promoting code reusability and establishing an "is-a" relationship.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what inheritance is and why it's important
 * - Learn how to create parent and child classes
 * - Master the 'extends' keyword
 * - Understand the 'super' keyword and its usage
 * - Learn about method overriding
 * - Understand constructor inheritance and chaining
 * - Practice with real-world inheritance examples
 * - Learn about inheritance hierarchy and multiple inheritance limitations
 * 
 * KEY CONCEPTS:
 * 1. Parent Class (Superclass): The class being inherited from
 * 2. Child Class (Subclass): The class that inherits from parent
 * 3. 'extends' Keyword: Used to establish inheritance relationship
 * 4. 'super' Keyword: Used to access parent class members
 * 5. Method Overriding: Redefining parent class methods in child class
 * 6. Constructor Chaining: Calling parent constructors from child constructors
 * 7. 'is-a' Relationship: Inheritance represents an "is-a" relationship
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class InheritanceDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Inheritance Demo ===");
        System.out.println();
        
        // 1. Basic Inheritance
        demonstrateBasicInheritance();
        
        // 2. Constructor Inheritance and Chaining
        demonstrateConstructorInheritance();
        
        // 3. Method Overriding
        demonstrateMethodOverriding();
        
        // 4. The 'super' Keyword
        demonstrateSuperKeyword();
        
        // 5. Inheritance Hierarchy
        demonstrateInheritanceHierarchy();
        
        // 6. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 7. Access Modifiers in Inheritance
        demonstrateAccessModifiersInInheritance();
        
        // 8. Best Practices and Common Patterns
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic inheritance concepts
     * 
     * This section shows how to create parent and child classes,
     * and how child classes inherit properties and methods from parent classes.
     */
    private static void demonstrateBasicInheritance() {
        System.out.println("1. Basic Inheritance:");
        System.out.println("====================");
        
        // Creating objects of parent class
        Animal animal = new Animal("Generic Animal", 5);
        System.out.println("Parent class object:");
        animal.eat();
        animal.sleep();
        animal.makeSound();
        System.out.println("Age: " + animal.getAge());
        System.out.println("Species: " + animal.getSpecies());
        
        // Creating objects of child classes
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        System.out.println("\nChild class object (Dog):");
        dog.eat();        // Inherited method
        dog.sleep();      // Inherited method
        dog.makeSound();  // Overridden method
        dog.bark();       // Child-specific method
        System.out.println("Age: " + dog.getAge());           // Inherited getter
        System.out.println("Species: " + dog.getSpecies());   // Inherited getter
        System.out.println("Breed: " + dog.getBreed());       // Child-specific getter
        
        Cat cat = new Cat("Whiskers", 2, "Persian");
        System.out.println("\nChild class object (Cat):");
        cat.eat();        // Inherited method
        cat.sleep();      // Inherited method
        cat.makeSound();  // Overridden method
        cat.purr();       // Child-specific method
        System.out.println("Age: " + cat.getAge());           // Inherited getter
        System.out.println("Species: " + cat.getSpecies());   // Inherited getter
        System.out.println("Breed: " + cat.getBreed());       // Child-specific getter
        
        System.out.println();
    }
    
    /**
     * Demonstrates constructor inheritance and chaining
     * 
     * Constructors are not inherited, but child classes can call parent
     * constructors using the 'super' keyword. This section shows how
     * constructor chaining works in inheritance.
     */
    private static void demonstrateConstructorInheritance() {
        System.out.println("2. Constructor Inheritance and Chaining:");
        System.out.println("=======================================");
        
        // Creating objects to demonstrate constructor chaining
        System.out.println("Creating Dog object:");
        Dog dog1 = new Dog("Max", 4, "Labrador");
        
        System.out.println("\nCreating Cat object:");
        Cat cat1 = new Cat("Luna", 1, "Siamese");
        
        System.out.println("\nCreating Bird object:");
        Bird bird1 = new Bird("Tweety", 2, "Canary");
        
        // Demonstrating different constructor calls
        System.out.println("\nCreating Dog with default constructor:");
        Dog dog2 = new Dog();
        
        System.out.println("\nCreating Cat with name only:");
        Cat cat2 = new Cat("Mittens");
        
        System.out.println();
    }
    
    /**
     * Demonstrates method overriding
     * 
     * Method overriding allows child classes to provide their own
     * implementation of methods inherited from parent classes.
     */
    private static void demonstrateMethodOverriding() {
        System.out.println("3. Method Overriding:");
        System.out.println("====================");
        
        // Creating objects of different types
        Animal[] animals = {
            new Animal("Generic Animal", 5),
            new Dog("Rex", 3, "German Shepherd"),
            new Cat("Fluffy", 2, "Maine Coon"),
            new Bird("Polly", 1, "Parrot")
        };
        
        // Demonstrating polymorphism through method overriding
        System.out.println("Demonstrating method overriding:");
        for (Animal animal : animals) {
            System.out.println("\n" + animal.getSpecies() + " says:");
            animal.makeSound(); // Each subclass provides its own implementation
        }
        
        // Demonstrating overridden methods with different behaviors
        System.out.println("\nDemonstrating different behaviors:");
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat = new Cat("Whiskers", 2, "Persian");
        
        System.out.println("Dog's movement:");
        dog.move();
        
        System.out.println("Cat's movement:");
        cat.move();
        
        System.out.println();
    }
    
    /**
     * Demonstrates the 'super' keyword usage
     * 
     * The 'super' keyword is used to access parent class members
     * from child classes. It's essential for constructor chaining
     * and accessing overridden methods.
     */
    private static void demonstrateSuperKeyword() {
        System.out.println("4. The 'super' Keyword:");
        System.out.println("======================");
        
        // Creating objects to demonstrate super keyword usage
        Dog dog = new Dog("Rex", 4, "German Shepherd");
        Cat cat = new Cat("Luna", 2, "Siamese");
        
        // Demonstrating super keyword in methods
        System.out.println("Dog using super keyword:");
        dog.displayInfo();
        
        System.out.println("\nCat using super keyword:");
        cat.displayInfo();
        
        // Demonstrating super keyword in constructors
        System.out.println("\nCreating Dog with super constructor call:");
        Dog dog2 = new Dog("Max", 3, "Labrador");
        
        System.out.println("\nCreating Cat with super constructor call:");
        Cat cat2 = new Cat("Whiskers", 1, "Persian");
        
        System.out.println();
    }
    
    /**
     * Demonstrates inheritance hierarchy
     * 
     * This section shows how inheritance can create complex hierarchies
     * with multiple levels of inheritance.
     */
    private static void demonstrateInheritanceHierarchy() {
        System.out.println("5. Inheritance Hierarchy:");
        System.out.println("========================");
        
        // Creating objects at different levels of hierarchy
        Vehicle vehicle = new Vehicle("Generic Vehicle", 2020);
        Car car = new Car("Toyota Camry", 2023, "Sedan");
        SportsCar sportsCar = new SportsCar("Ferrari 488", 2023, "Supercar", 670);
        
        // Demonstrating inheritance chain
        System.out.println("Vehicle (Parent):");
        vehicle.start();
        vehicle.stop();
        vehicle.displayInfo();
        
        System.out.println("\nCar (Child of Vehicle):");
        car.start();
        car.stop();
        car.accelerate();
        car.displayInfo();
        
        System.out.println("\nSportsCar (Child of Car):");
        sportsCar.start();
        sportsCar.stop();
        sportsCar.accelerate();
        sportsCar.turboBoost();
        sportsCar.displayInfo();
        
        // Demonstrating method resolution in hierarchy
        System.out.println("\nMethod resolution in hierarchy:");
        Vehicle[] vehicles = {vehicle, car, sportsCar};
        
        for (Vehicle v : vehicles) {
            System.out.println("\n" + v.getModel() + " methods:");
            v.start();
            v.stop();
            if (v instanceof Car) {
                ((Car) v).accelerate();
            }
            if (v instanceof SportsCar) {
                ((SportsCar) v).turboBoost();
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples of inheritance
     * 
     * This section shows practical examples of inheritance
     * in real-world scenarios.
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("6. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: Employee hierarchy
        System.out.println("Example 1: Employee Hierarchy");
        System.out.println("-----------------------------");
        
        Employee employee = new Employee("John Doe", "E001", 50000);
        Manager manager = new Manager("Jane Smith", "M001", 75000, "Engineering");
        Developer developer = new Developer("Bob Johnson", "D001", 60000, "Java");
        
        System.out.println("Employee:");
        employee.work();
        employee.displayInfo();
        
        System.out.println("\nManager:");
        manager.work();
        manager.manageTeam();
        manager.displayInfo();
        
        System.out.println("\nDeveloper:");
        developer.work();
        developer.writeCode();
        developer.displayInfo();
        
        // Example 2: Shape hierarchy
        System.out.println("\nExample 2: Shape Hierarchy");
        System.out.println("-------------------------");
        
        Shape shape = new Shape("Generic Shape");
        Circle circle = new Circle("Circle", 5.0);
        Rectangle rectangle = new Rectangle("Rectangle", 4.0, 6.0);
        Triangle triangle = new Triangle("Triangle", 3.0, 4.0, 5.0);
        
        Shape[] shapes = {shape, circle, rectangle, triangle};
        
        for (Shape s : shapes) {
            System.out.println("\n" + s.getName() + ":");
            s.displayInfo();
            if (s instanceof Circle) {
                System.out.println("Area: " + ((Circle) s).calculateArea());
                System.out.println("Perimeter: " + ((Circle) s).calculatePerimeter());
            } else if (s instanceof Rectangle) {
                System.out.println("Area: " + ((Rectangle) s).calculateArea());
                System.out.println("Perimeter: " + ((Rectangle) s).calculatePerimeter());
            } else if (s instanceof Triangle) {
                System.out.println("Area: " + ((Triangle) s).calculateArea());
                System.out.println("Perimeter: " + ((Triangle) s).calculatePerimeter());
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates access modifiers in inheritance
     * 
     * This section shows how different access modifiers work
     * in inheritance scenarios.
     */
    private static void demonstrateAccessModifiersInInheritance() {
        System.out.println("7. Access Modifiers in Inheritance:");
        System.out.println("==================================");
        
        // Creating objects to demonstrate access modifiers
        ParentClass parent = new ParentClass();
        ChildClass child = new ChildClass();
        
        System.out.println("Accessing members from ParentClass:");
        parent.testAccess();
        
        System.out.println("\nAccessing members from ChildClass:");
        child.testAccess();
        child.accessInheritedMembers();
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices and common patterns
     * 
     * This section shows best practices for using inheritance
     * and common patterns in object-oriented design.
     */
    private static void demonstrateBestPractices() {
        System.out.println("8. Best Practices and Common Patterns:");
        System.out.println("=====================================");
        
        // Example 1: Proper use of inheritance
        System.out.println("Example 1: Proper Inheritance Usage");
        System.out.println("-----------------------------------");
        
        // Using inheritance for code reusability
        Animal[] animals = {
            new Dog("Buddy", 3, "Golden Retriever"),
            new Cat("Whiskers", 2, "Persian"),
            new Bird("Tweety", 1, "Canary")
        };
        
        // Polymorphic behavior
        for (Animal animal : animals) {
            System.out.println(animal.getSpecies() + " is eating:");
            animal.eat();
        }
        
        // Example 2: Composition over inheritance
        System.out.println("\nExample 2: Composition vs Inheritance");
        System.out.println("------------------------------------");
        
        // Using composition instead of inheritance
        Engine engine = new Engine("V8", 400);
        Car car = new Car("BMW M3", 2023, "Sedan");
        car.setEngine(engine);
        
        System.out.println("Car with engine:");
        car.start();
        car.displayInfo();
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Inheritance promotes code reusability");
        System.out.println("• Use 'extends' keyword to establish inheritance");
        System.out.println("• Use 'super' keyword to access parent class members");
        System.out.println("• Override methods to provide specific implementations");
        System.out.println("• Constructors are not inherited but can be called with 'super'");
        System.out.println("• Inheritance represents an 'is-a' relationship");
        System.out.println("• Java supports single inheritance for classes");
        System.out.println("• Use composition when 'has-a' relationship is more appropriate");
    }
}

// Base classes for inheritance demonstration

/**
 * Base class for all animals
 */
class Animal {
    protected String species;
    protected int age;
    
    public Animal(String species, int age) {
        this.species = species;
        this.age = age;
        System.out.println("Animal constructor called for " + species);
    }
    
    public void eat() {
        System.out.println(species + " is eating");
    }
    
    public void sleep() {
        System.out.println(species + " is sleeping");
    }
    
    public void makeSound() {
        System.out.println(species + " makes a generic sound");
    }
    
    public void move() {
        System.out.println(species + " is moving");
    }
    
    // Getters
    public String getSpecies() {
        return species;
    }
    
    public int getAge() {
        return age;
    }
    
    public void displayInfo() {
        System.out.println("Species: " + species + ", Age: " + age);
    }
}

/**
 * Dog class inheriting from Animal
 */
class Dog extends Animal {
    private String breed;
    
    public Dog() {
        super("Dog", 1);
        this.breed = "Unknown";
        System.out.println("Dog default constructor called");
    }
    
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
        System.out.println("Dog parameterized constructor called for " + name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(species + " barks: Woof! Woof!");
    }
    
    @Override
    public void move() {
        System.out.println(species + " runs on four legs");
    }
    
    public void bark() {
        System.out.println(species + " is barking");
    }
    
    public void fetch() {
        System.out.println(species + " is fetching");
    }
    
    public String getBreed() {
        return breed;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed);
    }
}

/**
 * Cat class inheriting from Animal
 */
class Cat extends Animal {
    private String breed;
    
    public Cat() {
        super("Cat", 1);
        this.breed = "Unknown";
        System.out.println("Cat default constructor called");
    }
    
    public Cat(String name) {
        super(name, 1);
        this.breed = "Unknown";
        System.out.println("Cat constructor with name called for " + name);
    }
    
    public Cat(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
        System.out.println("Cat parameterized constructor called for " + name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(species + " meows: Meow! Meow!");
    }
    
    @Override
    public void move() {
        System.out.println(species + " walks silently");
    }
    
    public void purr() {
        System.out.println(species + " is purring");
    }
    
    public void climb() {
        System.out.println(species + " is climbing");
    }
    
    public String getBreed() {
        return breed;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed);
    }
}

/**
 * Bird class inheriting from Animal
 */
class Bird extends Animal {
    private String breed;
    
    public Bird(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
        System.out.println("Bird constructor called for " + name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(species + " chirps: Tweet! Tweet!");
    }
    
    @Override
    public void move() {
        System.out.println(species + " flies");
    }
    
    public void fly() {
        System.out.println(species + " is flying");
    }
    
    public void sing() {
        System.out.println(species + " is singing");
    }
    
    public String getBreed() {
        return breed;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed);
    }
}

// Vehicle hierarchy for inheritance demonstration

/**
 * Base class for all vehicles
 */
class Vehicle {
    protected String model;
    protected int year;
    
    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
        System.out.println("Vehicle constructor called for " + model);
    }
    
    public void start() {
        System.out.println(model + " is starting");
    }
    
    public void stop() {
        System.out.println(model + " is stopping");
    }
    
    public void displayInfo() {
        System.out.println("Model: " + model + ", Year: " + year);
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
}

/**
 * Car class inheriting from Vehicle
 */
class Car extends Vehicle {
    protected String type;
    
    public Car(String model, int year, String type) {
        super(model, year);
        this.type = type;
        System.out.println("Car constructor called for " + model);
    }
    
    public void accelerate() {
        System.out.println(model + " is accelerating");
    }
    
    public void brake() {
        System.out.println(model + " is braking");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
    }
}

/**
 * SportsCar class inheriting from Car
 */
class SportsCar extends Car {
    private int horsepower;
    
    public SportsCar(String model, int year, String type, int horsepower) {
        super(model, year, type);
        this.horsepower = horsepower;
        System.out.println("SportsCar constructor called for " + model);
    }
    
    public void turboBoost() {
        System.out.println(model + " is using turbo boost!");
    }
    
    @Override
    public void accelerate() {
        System.out.println(model + " is accelerating rapidly!");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Horsepower: " + horsepower);
    }
}

// Employee hierarchy for real-world example

/**
 * Base class for all employees
 */
class Employee {
    protected String name;
    protected String employeeId;
    protected double salary;
    
    public Employee(String name, String employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }
    
    public void work() {
        System.out.println(name + " is working");
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + employeeId + ", Salary: $" + salary);
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public double getSalary() {
        return salary;
    }
}

/**
 * Manager class inheriting from Employee
 */
class Manager extends Employee {
    private String department;
    
    public Manager(String name, String employeeId, double salary, String department) {
        super(name, employeeId, salary);
        this.department = department;
    }
    
    @Override
    public void work() {
        System.out.println(name + " is managing the " + department + " department");
    }
    
    public void manageTeam() {
        System.out.println(name + " is managing the team");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
    }
}

/**
 * Developer class inheriting from Employee
 */
class Developer extends Employee {
    private String programmingLanguage;
    
    public Developer(String name, String employeeId, double salary, String programmingLanguage) {
        super(name, employeeId, salary);
        this.programmingLanguage = programmingLanguage;
    }
    
    @Override
    public void work() {
        System.out.println(name + " is developing software");
    }
    
    public void writeCode() {
        System.out.println(name + " is writing code in " + programmingLanguage);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Shape hierarchy for real-world example

/**
 * Base class for all shapes
 */
class Shape {
    protected String name;
    
    public Shape(String name) {
        this.name = name;
    }
    
    public void displayInfo() {
        System.out.println("This is a " + name);
    }
    
    public String getName() {
        return name;
    }
}

/**
 * Circle class inheriting from Shape
 */
class Circle extends Shape {
    private double radius;
    
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }
    
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Radius: " + radius);
    }
}

/**
 * Rectangle class inheriting from Shape
 */
class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(String name, double length, double width) {
        super(name);
        this.length = length;
        this.width = width;
    }
    
    public double calculateArea() {
        return length * width;
    }
    
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Length: " + length + ", Width: " + width);
    }
}

/**
 * Triangle class inheriting from Shape
 */
class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;
    
    public Triangle(String name, double side1, double side2, double side3) {
        super(name);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    public double calculateArea() {
        // Using Heron's formula
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sides: " + side1 + ", " + side2 + ", " + side3);
    }
}

// Classes for access modifiers demonstration

/**
 * Parent class for access modifiers demonstration
 */
class ParentClass {
    public String publicField = "Parent public field";
    protected String protectedField = "Parent protected field";
    String defaultField = "Parent default field";
    private String privateField = "Parent private field";
    
    public void testAccess() {
        System.out.println("Accessing from ParentClass:");
        System.out.println("Public: " + publicField);
        System.out.println("Protected: " + protectedField);
        System.out.println("Default: " + defaultField);
        System.out.println("Private: " + privateField);
    }
}

/**
 * Child class for access modifiers demonstration
 */
class ChildClass extends ParentClass {
    public void accessInheritedMembers() {
        System.out.println("Accessing from ChildClass:");
        System.out.println("Public: " + publicField);
        System.out.println("Protected: " + protectedField);
        System.out.println("Default: " + defaultField);
        // System.out.println("Private: " + privateField); // This would cause compilation error
    }
}

// Composition example

/**
 * Engine class for composition demonstration
 */
class Engine {
    private String type;
    private int horsepower;
    
    public Engine(String type, int horsepower) {
        this.type = type;
        this.horsepower = horsepower;
    }
    
    public void start() {
        System.out.println("Engine " + type + " with " + horsepower + " HP is starting");
    }
    
    public void stop() {
        System.out.println("Engine is stopping");
    }
    
    public String getType() {
        return type;
    }
    
    public int getHorsepower() {
        return horsepower;
    }
}
