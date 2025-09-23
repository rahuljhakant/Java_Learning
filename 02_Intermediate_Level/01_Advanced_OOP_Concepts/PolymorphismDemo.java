package com.tutorial.intermediate.advancedoop;

/**
 * Polymorphism Demo - Mastering Runtime and Compile-time Polymorphism in Java
 * 
 * This comprehensive tutorial demonstrates the concept of polymorphism in Java,
 * which is one of the four fundamental principles of Object-Oriented Programming.
 * Polymorphism allows objects of different types to be treated as objects of a
 * common base type, enabling flexible and extensible code design.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what polymorphism is and why it's important
 * - Learn about runtime polymorphism (method overriding)
 * - Master compile-time polymorphism (method overloading)
 * - Understand the difference between static and dynamic binding
 * - Learn about upcasting and downcasting
 * - Practice with real-world polymorphism examples
 * - Understand the benefits of polymorphism in software design
 * 
 * KEY CONCEPTS:
 * 1. Runtime Polymorphism: Method overriding with dynamic method dispatch
 * 2. Compile-time Polymorphism: Method overloading with static binding
 * 3. Upcasting: Treating a subclass object as a superclass object
 * 4. Downcasting: Treating a superclass object as a subclass object
 * 5. Dynamic Method Dispatch: JVM determines which method to call at runtime
 * 6. Method Overriding: Redefining parent class methods in child classes
 * 7. Method Overloading: Multiple methods with same name but different parameters
 * 
 * @author Java Tutorial Team
 * @version 1.0
 * @since 2024
 */
public class PolymorphismDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Polymorphism Demo ===");
        System.out.println();
        
        // 1. Runtime Polymorphism (Method Overriding)
        demonstrateRuntimePolymorphism();
        
        // 2. Compile-time Polymorphism (Method Overloading)
        demonstrateCompileTimePolymorphism();
        
        // 3. Upcasting and Downcasting
        demonstrateUpcastingAndDowncasting();
        
        // 4. Dynamic Method Dispatch
        demonstrateDynamicMethodDispatch();
        
        // 5. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 6. Polymorphism with Interfaces
        demonstratePolymorphismWithInterfaces();
        
        // 7. Benefits of Polymorphism
        demonstrateBenefitsOfPolymorphism();
        
        // 8. Best Practices and Common Patterns
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates runtime polymorphism through method overriding
     * 
     * Runtime polymorphism occurs when a method is overridden in a subclass.
     * The JVM determines which method to call at runtime based on the actual
     * type of the object, not the reference type.
     */
    private static void demonstrateRuntimePolymorphism() {
        System.out.println("1. Runtime Polymorphism (Method Overriding):");
        System.out.println("===========================================");
        
        // Creating objects of different types
        Animal animal = new Animal("Generic Animal");
        Dog dog = new Dog("Buddy");
        Cat cat = new Cat("Whiskers");
        Bird bird = new Bird("Tweety");
        
        // Demonstrating runtime polymorphism
        System.out.println("Demonstrating runtime polymorphism:");
        System.out.println("----------------------------------");
        
        // Each object calls its own overridden method
        animal.makeSound();  // Calls Animal's makeSound()
        dog.makeSound();     // Calls Dog's makeSound()
        cat.makeSound();     // Calls Cat's makeSound()
        bird.makeSound();    // Calls Bird's makeSound()
        
        // Polymorphic behavior with arrays
        System.out.println("\nPolymorphic behavior with arrays:");
        Animal[] animals = {animal, dog, cat, bird};
        
        for (Animal a : animals) {
            System.out.print(a.getName() + " says: ");
            a.makeSound(); // Each object calls its own implementation
        }
        
        // Polymorphic behavior with method parameters
        System.out.println("\nPolymorphic behavior with method parameters:");
        makeAnimalSound(animal);
        makeAnimalSound(dog);
        makeAnimalSound(cat);
        makeAnimalSound(bird);
        
        System.out.println();
    }
    
    /**
     * Demonstrates compile-time polymorphism through method overloading
     * 
     * Compile-time polymorphism occurs when multiple methods have the same name
     * but different parameters. The compiler determines which method to call
     * based on the number and types of arguments.
     */
    private static void demonstrateCompileTimePolymorphism() {
        System.out.println("2. Compile-time Polymorphism (Method Overloading):");
        System.out.println("=================================================");
        
        Calculator calculator = new Calculator();
        
        // Different method calls based on parameter types
        System.out.println("Method overloading examples:");
        System.out.println("---------------------------");
        
        // Integer addition
        int intResult = calculator.add(5, 3);
        System.out.println("add(5, 3) = " + intResult);
        
        // Double addition
        double doubleResult = calculator.add(5.5, 3.2);
        System.out.println("add(5.5, 3.2) = " + doubleResult);
        
        // String concatenation
        String stringResult = calculator.add("Hello", "World");
        System.out.println("add(\"Hello\", \"World\") = " + stringResult);
        
        // Three parameters
        int threeParamResult = calculator.add(1, 2, 3);
        System.out.println("add(1, 2, 3) = " + threeParamResult);
        
        // Array sum
        int[] numbers = {1, 2, 3, 4, 5};
        int arraySum = calculator.add(numbers);
        System.out.println("add([1,2,3,4,5]) = " + arraySum);
        
        // Varargs
        int varargsSum = calculator.add(1, 2, 3, 4, 5, 6);
        System.out.println("add(1,2,3,4,5,6) = " + varargsSum);
        
        // Constructor overloading
        System.out.println("\nConstructor overloading:");
        System.out.println("----------------------");
        
        Person person1 = new Person("John");
        Person person2 = new Person("Jane", 25);
        Person person3 = new Person("Bob", 30, "Engineer");
        
        person1.displayInfo();
        person2.displayInfo();
        person3.displayInfo();
        
        System.out.println();
    }
    
    /**
     * Demonstrates upcasting and downcasting
     * 
     * Upcasting is treating a subclass object as a superclass object.
     * Downcasting is treating a superclass object as a subclass object.
     * Downcasting requires explicit casting and can be dangerous.
     */
    private static void demonstrateUpcastingAndDowncasting() {
        System.out.println("3. Upcasting and Downcasting:");
        System.out.println("=============================");
        
        // Upcasting: Subclass object treated as superclass
        System.out.println("Upcasting examples:");
        System.out.println("------------------");
        
        Dog dog = new Dog("Rex");
        Animal animal = dog; // Upcasting - implicit
        
        System.out.println("Dog object: " + dog.getName());
        System.out.println("Animal reference: " + animal.getName());
        
        // Both references point to the same object
        System.out.println("Same object? " + (dog == animal));
        
        // Method calls through upcasted reference
        animal.makeSound(); // Calls Dog's makeSound() due to runtime polymorphism
        
        // Downcasting: Superclass object treated as subclass
        System.out.println("\nDowncasting examples:");
        System.out.println("--------------------");
        
        // Safe downcasting
        if (animal instanceof Dog) {
            Dog downcastedDog = (Dog) animal; // Downcasting - explicit
            System.out.println("Downcasted to Dog: " + downcastedDog.getName());
            downcastedDog.bark(); // Can call Dog-specific methods
        }
        
        // Dangerous downcasting
        Animal genericAnimal = new Animal("Generic");
        System.out.println("\nDangerous downcasting:");
        
        if (genericAnimal instanceof Dog) {
            Dog dangerousCast = (Dog) genericAnimal;
            System.out.println("This won't execute");
        } else {
            System.out.println("Cannot downcast Animal to Dog - different types");
        }
        
        // ClassCastException example
        System.out.println("\nClassCastException example:");
        try {
            Dog invalidCast = (Dog) genericAnimal; // This will throw ClassCastException
        } catch (ClassCastException e) {
            System.out.println("Caught ClassCastException: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates dynamic method dispatch
     * 
     * Dynamic method dispatch is the mechanism by which the JVM determines
     * which overridden method to call at runtime based on the actual object type.
     */
    private static void demonstrateDynamicMethodDispatch() {
        System.out.println("4. Dynamic Method Dispatch:");
        System.out.println("==========================");
        
        // Creating objects of different types
        Vehicle vehicle = new Vehicle("Generic Vehicle");
        Car car = new Car("Toyota Camry");
        Motorcycle motorcycle = new Motorcycle("Honda CBR");
        Truck truck = new Truck("Ford F-150");
        
        // Demonstrating dynamic method dispatch
        System.out.println("Dynamic method dispatch examples:");
        System.out.println("--------------------------------");
        
        Vehicle[] vehicles = {vehicle, car, motorcycle, truck};
        
        for (Vehicle v : vehicles) {
            System.out.println("\n" + v.getModel() + ":");
            v.start();        // Each calls its own implementation
            v.accelerate();   // Each calls its own implementation
            v.brake();        // Each calls its own implementation
            v.stop();         // Each calls its own implementation
        }
        
        // Demonstrating with method parameters
        System.out.println("\nDynamic dispatch with method parameters:");
        System.out.println("---------------------------------------");
        
        testVehicle(vehicle);
        testVehicle(car);
        testVehicle(motorcycle);
        testVehicle(truck);
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples of polymorphism
     * 
     * This section shows practical examples of how polymorphism is used
     * in real-world software development.
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("5. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: Media Player
        System.out.println("Example 1: Media Player");
        System.out.println("----------------------");
        
        MediaPlayer player = new MediaPlayer();
        
        MediaFile[] mediaFiles = {
            new AudioFile("song.mp3", "Audio"),
            new VideoFile("movie.mp4", "Video"),
            new ImageFile("photo.jpg", "Image")
        };
        
        for (MediaFile file : mediaFiles) {
            player.play(file);
        }
        
        // Example 2: Payment Processing
        System.out.println("\nExample 2: Payment Processing");
        System.out.println("----------------------------");
        
        PaymentProcessor processor = new PaymentProcessor();
        
        PaymentMethod[] payments = {
            new CreditCard("1234-5678-9012-3456"),
            new PayPal("user@example.com"),
            new BankTransfer("ACC123456789")
        };
        
        for (PaymentMethod payment : payments) {
            processor.processPayment(payment, 100.0);
        }
        
        // Example 3: Shape Drawing
        System.out.println("\nExample 3: Shape Drawing");
        System.out.println("----------------------");
        
        DrawingCanvas canvas = new DrawingCanvas();
        
        Drawable[] shapes = {
            new Circle(5.0),
            new Rectangle(4.0, 6.0),
            new Triangle(3.0, 4.0, 5.0)
        };
        
        for (Drawable shape : shapes) {
            canvas.draw(shape);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates polymorphism with interfaces
     * 
     * Interfaces provide another way to achieve polymorphism in Java.
     * Classes implementing the same interface can be treated polymorphically.
     */
    private static void demonstratePolymorphismWithInterfaces() {
        System.out.println("6. Polymorphism with Interfaces:");
        System.out.println("===============================");
        
        // Creating objects implementing the same interface
        Flyable[] flyables = {
            new Bird("Eagle"),
            new Airplane("Boeing 747"),
            new Helicopter("Apache")
        };
        
        System.out.println("Polymorphic behavior with interfaces:");
        System.out.println("-----------------------------------");
        
        for (Flyable flyable : flyables) {
            System.out.println("\n" + flyable.getClass().getSimpleName() + ":");
            flyable.fly();
            flyable.land();
        }
        
        // Demonstrating with method parameters
        System.out.println("\nInterface polymorphism with method parameters:");
        System.out.println("---------------------------------------------");
        
        testFlyable(new Bird("Sparrow"));
        testFlyable(new Airplane("Airbus A380"));
        testFlyable(new Helicopter("Black Hawk"));
        
        System.out.println();
    }
    
    /**
     * Demonstrates the benefits of polymorphism
     * 
     * This section shows the advantages of using polymorphism in software design,
     * including code reusability, maintainability, and extensibility.
     */
    private static void demonstrateBenefitsOfPolymorphism() {
        System.out.println("7. Benefits of Polymorphism:");
        System.out.println("===========================");
        
        // Benefit 1: Code Reusability
        System.out.println("Benefit 1: Code Reusability");
        System.out.println("--------------------------");
        
        // Single method can handle multiple types
        processAnimals(new Animal("Generic"), new Dog("Buddy"), new Cat("Whiskers"));
        
        // Benefit 2: Extensibility
        System.out.println("\nBenefit 2: Extensibility");
        System.out.println("----------------------");
        
        // Easy to add new types without modifying existing code
        Animal[] zoo = {
            new Animal("Generic"),
            new Dog("Rex"),
            new Cat("Luna"),
            new Bird("Polly"),
            new Fish("Nemo") // New type added easily
        };
        
        for (Animal animal : zoo) {
            animal.makeSound();
        }
        
        // Benefit 3: Maintainability
        System.out.println("\nBenefit 3: Maintainability");
        System.out.println("-------------------------");
        
        // Changes to one class don't affect others
        DatabaseManager dbManager = new DatabaseManager();
        
        DatabaseConnection[] connections = {
            new MySQLConnection("localhost:3306"),
            new PostgreSQLConnection("localhost:5432"),
            new OracleConnection("localhost:1521")
        };
        
        for (DatabaseConnection conn : connections) {
            dbManager.connect(conn);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices and common patterns
     * 
     * This section shows best practices for using polymorphism effectively
     * and common patterns in object-oriented design.
     */
    private static void demonstrateBestPractices() {
        System.out.println("8. Best Practices and Common Patterns:");
        System.out.println("=====================================");
        
        // Best Practice 1: Use polymorphism for collections
        System.out.println("Best Practice 1: Polymorphic Collections");
        System.out.println("---------------------------------------");
        
        java.util.List<Employee> employees = new java.util.ArrayList<>();
        employees.add(new Manager("Alice", "M001", 75000, "Engineering"));
        employees.add(new Developer("Bob", "D001", 60000, "Java"));
        employees.add(new Designer("Charlie", "D002", 55000, "UI/UX"));
        
        for (Employee emp : employees) {
            emp.work();
            emp.calculateBonus();
        }
        
        // Best Practice 2: Use interfaces for maximum flexibility
        System.out.println("\nBest Practice 2: Interface-based Polymorphism");
        System.out.println("--------------------------------------------");
        
        java.util.List<Shape> shapes = new java.util.ArrayList<>();
        shapes.add(new Circle(5.0));
        shapes.add(new Rectangle(4.0, 6.0));
        shapes.add(new Triangle(3.0, 4.0, 5.0));
        
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        System.out.println("Total area of all shapes: " + totalArea);
        
        // Best Practice 3: Avoid excessive downcasting
        System.out.println("\nBest Practice 3: Safe Type Checking");
        System.out.println("----------------------------------");
        
        Animal[] animals = {new Dog("Rex"), new Cat("Whiskers"), new Bird("Tweety")};
        
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                dog.bark();
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                cat.purr();
            } else if (animal instanceof Bird) {
                Bird bird = (Bird) animal;
                bird.fly();
            }
        }
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Runtime polymorphism enables flexible method calls");
        System.out.println("• Compile-time polymorphism provides method overloading");
        System.out.println("• Upcasting is safe and implicit");
        System.out.println("• Downcasting requires explicit casting and type checking");
        System.out.println("• Dynamic method dispatch determines method calls at runtime");
        System.out.println("• Polymorphism promotes code reusability and maintainability");
        System.out.println("• Use interfaces for maximum flexibility");
        System.out.println("• Always check types before downcasting");
    }
    
    // Helper methods for demonstrations
    
    /**
     * Helper method to demonstrate polymorphic method parameters
     */
    private static void makeAnimalSound(Animal animal) {
        System.out.print("Animal sound: ");
        animal.makeSound();
    }
    
    /**
     * Helper method to test vehicles polymorphically
     */
    private static void testVehicle(Vehicle vehicle) {
        System.out.println("Testing " + vehicle.getModel() + ":");
        vehicle.start();
        vehicle.accelerate();
        vehicle.brake();
        vehicle.stop();
    }
    
    /**
     * Helper method to test flyable objects
     */
    private static void testFlyable(Flyable flyable) {
        System.out.println("Testing " + flyable.getClass().getSimpleName() + ":");
        flyable.fly();
        flyable.land();
    }
    
    /**
     * Helper method to process animals polymorphically
     */
    private static void processAnimals(Animal... animals) {
        for (Animal animal : animals) {
            System.out.println("Processing " + animal.getName() + ":");
            animal.makeSound();
            animal.move();
        }
    }
}

// Base classes for polymorphism demonstration

/**
 * Base class for all animals
 */
class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void makeSound() {
        System.out.println(name + " makes a generic sound");
    }
    
    public void move() {
        System.out.println(name + " is moving");
    }
    
    public String getName() {
        return name;
    }
}

/**
 * Dog class with overridden methods
 */
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " runs on four legs");
    }
    
    public void bark() {
        System.out.println(name + " is barking");
    }
}

/**
 * Cat class with overridden methods
 */
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " walks silently");
    }
    
    public void purr() {
        System.out.println(name + " is purring");
    }
}

/**
 * Bird class with overridden methods
 */
class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " flies");
    }
    
    public void fly() {
        System.out.println(name + " is flying");
    }
}

/**
 * Fish class for extensibility demonstration
 */
class Fish extends Animal {
    public Fish(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " makes bubble sounds");
    }
    
    @Override
    public void move() {
        System.out.println(name + " swims");
    }
}

// Calculator class for method overloading demonstration

/**
 * Calculator class demonstrating method overloading
 */
class Calculator {
    // Integer addition
    public int add(int a, int b) {
        return a + b;
    }
    
    // Double addition
    public double add(double a, double b) {
        return a + b;
    }
    
    // String concatenation
    public String add(String a, String b) {
        return a + b;
    }
    
    // Three parameter addition
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Array sum
    public int add(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
    
    // Varargs
    public int add(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}

// Person class for constructor overloading demonstration

/**
 * Person class demonstrating constructor overloading
 */
class Person {
    private String name;
    private int age;
    private String occupation;
    
    public Person(String name) {
        this.name = name;
        this.age = 0;
        this.occupation = "Unknown";
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.occupation = "Unknown";
    }
    
    public Person(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Occupation: " + occupation);
    }
}

// Vehicle hierarchy for dynamic method dispatch demonstration

/**
 * Base class for all vehicles
 */
class Vehicle {
    protected String model;
    
    public Vehicle(String model) {
        this.model = model;
    }
    
    public void start() {
        System.out.println(model + " is starting");
    }
    
    public void accelerate() {
        System.out.println(model + " is accelerating");
    }
    
    public void brake() {
        System.out.println(model + " is braking");
    }
    
    public void stop() {
        System.out.println(model + " is stopping");
    }
    
    public String getModel() {
        return model;
    }
}

/**
 * Car class with overridden methods
 */
class Car extends Vehicle {
    public Car(String model) {
        super(model);
    }
    
    @Override
    public void start() {
        System.out.println(model + " car is starting with key");
    }
    
    @Override
    public void accelerate() {
        System.out.println(model + " car is accelerating smoothly");
    }
    
    @Override
    public void brake() {
        System.out.println(model + " car is braking with ABS");
    }
}

/**
 * Motorcycle class with overridden methods
 */
class Motorcycle extends Vehicle {
    public Motorcycle(String model) {
        super(model);
    }
    
    @Override
    public void start() {
        System.out.println(model + " motorcycle is starting with kick");
    }
    
    @Override
    public void accelerate() {
        System.out.println(model + " motorcycle is accelerating quickly");
    }
    
    @Override
    public void brake() {
        System.out.println(model + " motorcycle is braking with both wheels");
    }
}

/**
 * Truck class with overridden methods
 */
class Truck extends Vehicle {
    public Truck(String model) {
        super(model);
    }
    
    @Override
    public void start() {
        System.out.println(model + " truck is starting with diesel engine");
    }
    
    @Override
    public void accelerate() {
        System.out.println(model + " truck is accelerating slowly");
    }
    
    @Override
    public void brake() {
        System.out.println(model + " truck is braking with air brakes");
    }
}

// Media Player example for real-world demonstration

/**
 * Base class for media files
 */
abstract class MediaFile {
    protected String filename;
    protected String type;
    
    public MediaFile(String filename, String type) {
        this.filename = filename;
        this.type = type;
    }
    
    public abstract void play();
    
    public String getFilename() {
        return filename;
    }
    
    public String getType() {
        return type;
    }
}

/**
 * Audio file class
 */
class AudioFile extends MediaFile {
    public AudioFile(String filename, String type) {
        super(filename, type);
    }
    
    @Override
    public void play() {
        System.out.println("Playing audio file: " + filename);
    }
}

/**
 * Video file class
 */
class VideoFile extends MediaFile {
    public VideoFile(String filename, String type) {
        super(filename, type);
    }
    
    @Override
    public void play() {
        System.out.println("Playing video file: " + filename);
    }
}

/**
 * Image file class
 */
class ImageFile extends MediaFile {
    public ImageFile(String filename, String type) {
        super(filename, type);
    }
    
    @Override
    public void play() {
        System.out.println("Displaying image file: " + filename);
    }
}

/**
 * Media player class
 */
class MediaPlayer {
    public void play(MediaFile file) {
        System.out.println("Media Player: " + file.getType() + " - " + file.getFilename());
        file.play();
    }
}

// Payment processing example

/**
 * Base class for payment methods
 */
abstract class PaymentMethod {
    protected String identifier;
    
    public PaymentMethod(String identifier) {
        this.identifier = identifier;
    }
    
    public abstract void processPayment(double amount);
    
    public String getIdentifier() {
        return identifier;
    }
}

/**
 * Credit card payment class
 */
class CreditCard extends PaymentMethod {
    public CreditCard(String cardNumber) {
        super(cardNumber);
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount + " with card " + identifier);
    }
}

/**
 * PayPal payment class
 */
class PayPal extends PaymentMethod {
    public PayPal(String email) {
        super(email);
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " with email " + identifier);
    }
}

/**
 * Bank transfer payment class
 */
class BankTransfer extends PaymentMethod {
    public BankTransfer(String accountNumber) {
        super(accountNumber);
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer of $" + amount + " to account " + identifier);
    }
}

/**
 * Payment processor class
 */
class PaymentProcessor {
    public void processPayment(PaymentMethod payment, double amount) {
        payment.processPayment(amount);
    }
}

// Shape drawing example

/**
 * Interface for drawable objects
 */
interface Drawable {
    void draw();
    double calculateArea();
}

/**
 * Circle class implementing Drawable
 */
class Circle implements Drawable {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

/**
 * Rectangle class implementing Drawable
 */
class Rectangle implements Drawable {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with length " + length + " and width " + width);
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
}

/**
 * Triangle class implementing Drawable
 */
class Triangle implements Drawable {
    private double side1;
    private double side2;
    private double side3;
    
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a triangle with sides " + side1 + ", " + side2 + ", " + side3);
    }
    
    @Override
    public double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}

/**
 * Drawing canvas class
 */
class DrawingCanvas {
    public void draw(Drawable drawable) {
        drawable.draw();
        System.out.println("Area: " + drawable.calculateArea());
    }
}

// Interface for flyable objects

/**
 * Interface for objects that can fly
 */
interface Flyable {
    void fly();
    void land();
}

/**
 * Bird class implementing Flyable
 */
class Bird implements Flyable {
    private String name;
    
    public Bird(String name) {
        this.name = name;
    }
    
    @Override
    public void fly() {
        System.out.println(name + " is flying with wings");
    }
    
    @Override
    public void land() {
        System.out.println(name + " is landing on a branch");
    }
}

/**
 * Airplane class implementing Flyable
 */
class Airplane implements Flyable {
    private String model;
    
    public Airplane(String model) {
        this.model = model;
    }
    
    @Override
    public void fly() {
        System.out.println(model + " is flying with jet engines");
    }
    
    @Override
    public void land() {
        System.out.println(model + " is landing on runway");
    }
}

/**
 * Helicopter class implementing Flyable
 */
class Helicopter implements Flyable {
    private String model;
    
    public Helicopter(String model) {
        this.model = model;
    }
    
    @Override
    public void fly() {
        System.out.println(model + " is flying with rotors");
    }
    
    @Override
    public void land() {
        System.out.println(model + " is landing vertically");
    }
}

// Database connection example

/**
 * Base class for database connections
 */
abstract class DatabaseConnection {
    protected String connectionString;
    
    public DatabaseConnection(String connectionString) {
        this.connectionString = connectionString;
    }
    
    public abstract void connect();
    
    public String getConnectionString() {
        return connectionString;
    }
}

/**
 * MySQL connection class
 */
class MySQLConnection extends DatabaseConnection {
    public MySQLConnection(String connectionString) {
        super(connectionString);
    }
    
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL database: " + connectionString);
    }
}

/**
 * PostgreSQL connection class
 */
class PostgreSQLConnection extends DatabaseConnection {
    public PostgreSQLConnection(String connectionString) {
        super(connectionString);
    }
    
    @Override
    public void connect() {
        System.out.println("Connecting to PostgreSQL database: " + connectionString);
    }
}

/**
 * Oracle connection class
 */
class OracleConnection extends DatabaseConnection {
    public OracleConnection(String connectionString) {
        super(connectionString);
    }
    
    @Override
    public void connect() {
        System.out.println("Connecting to Oracle database: " + connectionString);
    }
}

/**
 * Database manager class
 */
class DatabaseManager {
    public void connect(DatabaseConnection connection) {
        connection.connect();
    }
}

// Employee hierarchy for best practices demonstration

/**
 * Base class for all employees
 */
abstract class Employee {
    protected String name;
    protected String employeeId;
    protected double salary;
    
    public Employee(String name, String employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }
    
    public abstract void work();
    
    public void calculateBonus() {
        double bonus = salary * 0.1;
        System.out.println(name + " receives bonus: $" + bonus);
    }
    
    public String getName() {
        return name;
    }
}

/**
 * Manager class
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
}

/**
 * Developer class
 */
class Developer extends Employee {
    private String programmingLanguage;
    
    public Developer(String name, String employeeId, double salary, String programmingLanguage) {
        super(name, employeeId, salary);
        this.programmingLanguage = programmingLanguage;
    }
    
    @Override
    public void work() {
        System.out.println(name + " is developing software in " + programmingLanguage);
    }
}

/**
 * Designer class
 */
class Designer extends Employee {
    private String designSpecialty;
    
    public Designer(String name, String employeeId, double salary, String designSpecialty) {
        super(name, employeeId, salary);
        this.designSpecialty = designSpecialty;
    }
    
    @Override
    public void work() {
        System.out.println(name + " is designing " + designSpecialty);
    }
}
