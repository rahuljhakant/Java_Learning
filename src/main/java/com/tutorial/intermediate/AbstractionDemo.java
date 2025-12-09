package com.tutorial.intermediate;

/**
 * Abstraction Demo - Mastering Abstract Classes and Methods in Java
 * 
 * This comprehensive tutorial demonstrates the concept of abstraction in Java,
 * which is one of the four fundamental principles of Object-Oriented Programming.
 * Abstraction allows you to hide complex implementation details and provide
 * a simplified interface for users to interact with.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what abstraction is and why it's important
 * - Learn about abstract classes and abstract methods
 * - Master the 'abstract' keyword usage
 * - Understand the difference between abstract classes and concrete classes
 * - Learn about abstract method implementation in subclasses
 * - Practice with real-world abstraction examples
 * - Understand the benefits of abstraction in software design
 * 
 * KEY CONCEPTS:
 * 1. Abstract Class: A class that cannot be instantiated directly
 * 2. Abstract Method: A method without implementation that must be overridden
 * 3. Concrete Class: A class that can be instantiated and provides implementations
 * 4. Partial Abstraction: Abstract classes can have both abstract and concrete methods
 * 5. Template Method Pattern: Using abstract classes to define algorithm structure
 * 6. Code Reusability: Abstract classes promote code reuse through inheritance
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class AbstractionDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Abstraction Demo ===");
        System.out.println();
        
        // 1. Basic Abstract Classes and Methods
        demonstrateBasicAbstraction();
        
        // 2. Abstract Classes with Concrete Methods
        demonstrateAbstractWithConcreteMethods();
        
        // 3. Abstract Method Implementation
        demonstrateAbstractMethodImplementation();
        
        // 4. Template Method Pattern
        demonstrateTemplateMethodPattern();
        
        // 5. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 6. Abstract Classes vs Interfaces
        demonstrateAbstractVsInterface();
        
        // 7. Benefits of Abstraction
        demonstrateBenefitsOfAbstraction();
        
        // 8. Best Practices and Common Patterns
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic abstract classes and methods
     * 
     * This section shows how to create abstract classes and abstract methods,
     * and how they cannot be instantiated directly.
     */
    private static void demonstrateBasicAbstraction() {
        System.out.println("1. Basic Abstract Classes and Methods:");
        System.out.println("=====================================");
        
        // Cannot instantiate abstract class directly
        // Shape shape = new Shape("Generic Shape"); // This would cause compilation error
        
        // Creating objects of concrete subclasses
        Circle circle = new Circle("Circle", 5.0);
        Rectangle rectangle = new Rectangle("Rectangle", 4.0, 6.0);
        Triangle triangle = new Triangle("Triangle", 3.0, 4.0, 5.0);
        
        System.out.println("Concrete implementations of abstract Shape class:");
        System.out.println("-----------------------------------------------");
        
        // Each concrete class provides its own implementation
        circle.displayInfo();
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter: " + circle.calculatePerimeter());
        
        System.out.println();
        rectangle.displayInfo();
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
        
        System.out.println();
        triangle.displayInfo();
        System.out.println("Area: " + triangle.calculateArea());
        System.out.println("Perimeter: " + triangle.calculatePerimeter());
        
        System.out.println();
    }
    
    /**
     * Demonstrates abstract classes with concrete methods
     * 
     * Abstract classes can contain both abstract methods (without implementation)
     * and concrete methods (with implementation). This allows for partial abstraction.
     */
    private static void demonstrateAbstractWithConcreteMethods() {
        System.out.println("2. Abstract Classes with Concrete Methods:");
        System.out.println("=========================================");
        
        // Creating objects of concrete subclasses
        Car car = new Car("Toyota Camry", 2023, "Sedan");
        Motorcycle motorcycle = new Motorcycle("Honda CBR", 2023, "Sport");
        Truck truck = new Truck("Ford F-150", 2023, "Pickup");
        
        System.out.println("Vehicles with shared concrete methods and unique abstract methods:");
        System.out.println("----------------------------------------------------------------");
        
        Vehicle[] vehicles = {car, motorcycle, truck};
        
        for (Vehicle vehicle : vehicles) {
            System.out.println("\n" + vehicle.getModel() + ":");
            
            // Concrete methods (inherited from abstract class)
            vehicle.start();
            vehicle.stop();
            vehicle.displayInfo();
            
            // Abstract methods (implemented in each subclass)
            vehicle.accelerate();
            vehicle.brake();
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates abstract method implementation in subclasses
     * 
     * This section shows how subclasses must implement all abstract methods
     * from their parent abstract class, or they themselves must be abstract.
     */
    private static void demonstrateAbstractMethodImplementation() {
        System.out.println("3. Abstract Method Implementation:");
        System.out.println("=================================");
        
        // Creating objects of different animal types
        Dog dog = new Dog("Buddy", 3);
        Cat cat = new Cat("Whiskers", 2);
        Bird bird = new Bird("Tweety", 1);
        
        System.out.println("Animals with implemented abstract methods:");
        System.out.println("----------------------------------------");
        
        Animal[] animals = {dog, cat, bird};
        
        for (Animal animal : animals) {
            System.out.println("\n" + animal.getName() + ":");
            
            // Concrete methods from abstract class
            animal.eat();
            animal.sleep();
            animal.displayInfo();
            
            // Abstract methods implemented in each subclass
            animal.makeSound();
            animal.move();
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates the Template Method Pattern
     * 
     * The Template Method Pattern uses abstract classes to define the structure
     * of an algorithm while allowing subclasses to override specific steps.
     */
    private static void demonstrateTemplateMethodPattern() {
        System.out.println("4. Template Method Pattern:");
        System.out.println("==========================");
        
        // Creating different types of data processors
        TextProcessor textProcessor = new TextProcessor();
        ImageProcessor imageProcessor = new ImageProcessor();
        VideoProcessor videoProcessor = new VideoProcessor();
        
        System.out.println("Data processors using template method pattern:");
        System.out.println("--------------------------------------------");
        
        DataProcessor[] processors = {textProcessor, imageProcessor, videoProcessor};
        
        for (DataProcessor processor : processors) {
            System.out.println("\n" + processor.getClass().getSimpleName() + ":");
            processor.processData("sample_data"); // Template method
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples of abstraction
     * 
     * This section shows practical examples of how abstraction is used
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
        
        // Example 2: Database Operations
        System.out.println("\nExample 2: Database Operations");
        System.out.println("------------------------------");
        
        DatabaseManager dbManager = new DatabaseManager();
        
        DatabaseConnection[] connections = {
            new MySQLConnection("localhost:3306"),
            new PostgreSQLConnection("localhost:5432"),
            new OracleConnection("localhost:1521")
        };
        
        for (DatabaseConnection conn : connections) {
            dbManager.performDatabaseOperations(conn);
        }
        
        // Example 3: Payment Processing
        System.out.println("\nExample 3: Payment Processing");
        System.out.println("-----------------------------");
        
        PaymentProcessor processor = new PaymentProcessor();
        
        PaymentMethod[] payments = {
            new CreditCard("1234-5678-9012-3456"),
            new PayPal("user@example.com"),
            new BankTransfer("ACC123456789")
        };
        
        for (PaymentMethod payment : payments) {
            processor.processPayment(payment, 100.0);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates abstract classes vs interfaces
     * 
     * This section shows the differences between abstract classes and interfaces,
     * and when to use each approach.
     */
    private static void demonstrateAbstractVsInterface() {
        System.out.println("6. Abstract Classes vs Interfaces:");
        System.out.println("=================================");
        
        // Abstract class example
        System.out.println("Abstract Class Example:");
        System.out.println("----------------------");
        
        Car car = new Car("BMW M3", 2023, "Sedan");
        car.start();
        car.accelerate();
        car.brake();
        car.stop();
        
        // Interface example
        System.out.println("\nInterface Example:");
        System.out.println("-----------------");
        
        Flyable[] flyables = {
            new Bird("Eagle"),
            new Airplane("Boeing 747"),
            new Helicopter("Apache")
        };
        
        for (Flyable flyable : flyables) {
            flyable.fly();
            flyable.land();
        }
        
        // Class implementing both abstract class and interface
        System.out.println("\nClass implementing both abstract class and interface:");
        System.out.println("--------------------------------------------------");
        
        FlyingCar flyingCar = new FlyingCar("Flying Car", 2023, "Hybrid");
        flyingCar.start();    // From abstract class
        flyingCar.accelerate(); // From abstract class
        flyingCar.fly();      // From interface
        flyingCar.land();     // From interface
        
        System.out.println();
    }
    
    /**
     * Demonstrates the benefits of abstraction
     * 
     * This section shows the advantages of using abstraction in software design,
     * including code reusability, maintainability, and flexibility.
     */
    private static void demonstrateBenefitsOfAbstraction() {
        System.out.println("7. Benefits of Abstraction:");
        System.out.println("==========================");
        
        // Benefit 1: Code Reusability
        System.out.println("Benefit 1: Code Reusability");
        System.out.println("--------------------------");
        
        // Shared functionality in abstract class
        Shape[] shapes = {
            new Circle("Circle", 5.0),
            new Rectangle("Rectangle", 4.0, 6.0),
            new Triangle("Triangle", 3.0, 4.0, 5.0)
        };
        
        for (Shape shape : shapes) {
            shape.displayInfo(); // Shared method from abstract class
            System.out.println("Area: " + shape.calculateArea()); // Abstract method
        }
        
        // Benefit 2: Maintainability
        System.out.println("\nBenefit 2: Maintainability");
        System.out.println("-------------------------");
        
        // Changes to abstract class affect all subclasses
        Employee[] employees = {
            new Manager("Alice", "M001", 75000, "Engineering"),
            new Developer("Bob", "D001", 60000, "Java"),
            new Designer("Charlie", "D002", 55000, "UI/UX")
        };
        
        for (Employee emp : employees) {
            emp.work(); // Abstract method
            emp.calculateBonus(); // Concrete method from abstract class
        }
        
        // Benefit 3: Flexibility
        System.out.println("\nBenefit 3: Flexibility");
        System.out.println("--------------------");
        
        // Easy to add new implementations
        MediaFile[] mediaFiles = {
            new AudioFile("song.mp3", "Audio"),
            new VideoFile("movie.mp4", "Video"),
            new ImageFile("photo.jpg", "Image"),
            new DocumentFile("report.pdf", "Document") // New type added easily
        };
        
        for (MediaFile file : mediaFiles) {
            file.play(); // Abstract method
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices and common patterns
     * 
     * This section shows best practices for using abstraction effectively
     * and common patterns in object-oriented design.
     */
    private static void demonstrateBestPractices() {
        System.out.println("8. Best Practices and Common Patterns:");
        System.out.println("=====================================");
        
        // Best Practice 1: Use abstract classes for shared functionality
        System.out.println("Best Practice 1: Shared Functionality");
        System.out.println("------------------------------------");
        
        // Abstract class provides common functionality
        Animal[] animals = {
            new Dog("Rex", 3),
            new Cat("Luna", 2),
            new Bird("Polly", 1)
        };
        
        for (Animal animal : animals) {
            animal.eat(); // Shared method
            animal.makeSound(); // Abstract method
        }
        
        // Best Practice 2: Use abstract classes for template methods
        System.out.println("\nBest Practice 2: Template Methods");
        System.out.println("--------------------------------");
        
        // Template method pattern
        DataProcessor[] processors = {
            new TextProcessor(),
            new ImageProcessor(),
            new VideoProcessor()
        };
        
        for (DataProcessor processor : processors) {
            processor.processData("sample_data");
        }
        
        // Best Practice 3: Use abstract classes for partial implementation
        System.out.println("\nBest Practice 3: Partial Implementation");
        System.out.println("--------------------------------------");
        
        // Abstract class provides partial implementation
        Vehicle[] vehicles = {
            new Car("Toyota", 2023, "Sedan"),
            new Motorcycle("Honda", 2023, "Sport"),
            new Truck("Ford", 2023, "Pickup")
        };
        
        for (Vehicle vehicle : vehicles) {
            vehicle.start(); // Concrete method
            vehicle.accelerate(); // Abstract method
        }
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Abstract classes cannot be instantiated directly");
        System.out.println("• Abstract methods must be implemented in subclasses");
        System.out.println("• Abstract classes can have both abstract and concrete methods");
        System.out.println("• Use abstract classes for shared functionality and partial implementation");
        System.out.println("• Template method pattern uses abstract classes effectively");
        System.out.println("• Abstraction promotes code reusability and maintainability");
        System.out.println("• Choose abstract classes when you need shared state and behavior");
        System.out.println("• Choose interfaces when you need multiple inheritance");
    }
}

// Abstract classes for demonstration

/**
 * Abstract class for all shapes
 */
abstract class Shape {
    protected String name;
    
    public Shape(String name) {
        this.name = name;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateArea();
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculatePerimeter();
    
    // Concrete method - shared by all subclasses
    public void displayInfo() {
        System.out.println("This is a " + name);
    }
    
    public String getName() {
        return name;
    }
}

/**
 * Concrete implementation of Shape - Circle
 */
class Circle extends Shape {
    private double radius;
    
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
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
 * Concrete implementation of Shape - Rectangle
 */
class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(String name, double length, double width) {
        super(name);
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
    
    @Override
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
 * Concrete implementation of Shape - Triangle
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
    
    @Override
    public double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sides: " + side1 + ", " + side2 + ", " + side3);
    }
}

// Vehicle hierarchy for abstraction demonstration

/**
 * Abstract class for all vehicles
 */
abstract class Vehicle {
    protected String model;
    protected int year;
    protected String type;
    
    public Vehicle(String model, int year, String type) {
        this.model = model;
        this.year = year;
        this.type = type;
    }
    
    // Concrete methods - shared by all vehicles
    public void start() {
        System.out.println(model + " is starting");
    }
    
    public void stop() {
        System.out.println(model + " is stopping");
    }
    
    public void displayInfo() {
        System.out.println("Model: " + model + ", Year: " + year + ", Type: " + type);
    }
    
    // Abstract methods - must be implemented by subclasses
    public abstract void accelerate();
    public abstract void brake();
    
    public String getModel() {
        return model;
    }
}

/**
 * Concrete implementation of Vehicle - Car
 */
class Car extends Vehicle {
    public Car(String model, int year, String type) {
        super(model, year, type);
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
 * Concrete implementation of Vehicle - Motorcycle
 */
class Motorcycle extends Vehicle {
    public Motorcycle(String model, int year, String type) {
        super(model, year, type);
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
 * Concrete implementation of Vehicle - Truck
 */
class Truck extends Vehicle {
    public Truck(String model, int year, String type) {
        super(model, year, type);
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

// Animal hierarchy for abstraction demonstration

/**
 * Abstract class for all animals
 */
abstract class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Concrete methods - shared by all animals
    public void eat() {
        System.out.println(name + " is eating");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    // Abstract methods - must be implemented by subclasses
    public abstract void makeSound();
    public abstract void move();
    
    public String getName() {
        return name;
    }
}

/**
 * Concrete implementation of Animal - Dog
 */
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " runs on four legs");
    }
}

/**
 * Concrete implementation of Animal - Cat
 */
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " walks silently");
    }
}

/**
 * Concrete implementation of Animal - Bird
 */
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " flies");
    }
}

// Template Method Pattern example

/**
 * Abstract class for data processors using template method pattern
 */
abstract class DataProcessor {
    // Template method - defines the algorithm structure
    public final void processData(String data) {
        System.out.println("Starting data processing...");
        
        validateData(data);
        preprocessData(data);
        processDataInternal(data);
        postprocessData(data);
        
        System.out.println("Data processing completed.");
    }
    
    // Concrete methods - shared by all processors
    private void validateData(String data) {
        System.out.println("Validating data: " + data);
    }
    
    private void preprocessData(String data) {
        System.out.println("Preprocessing data: " + data);
    }
    
    private void postprocessData(String data) {
        System.out.println("Postprocessing data: " + data);
    }
    
    // Abstract method - must be implemented by subclasses
    protected abstract void processDataInternal(String data);
}

/**
 * Concrete implementation of DataProcessor - TextProcessor
 */
class TextProcessor extends DataProcessor {
    @Override
    protected void processDataInternal(String data) {
        System.out.println("Processing text data: " + data);
    }
}

/**
 * Concrete implementation of DataProcessor - ImageProcessor
 */
class ImageProcessor extends DataProcessor {
    @Override
    protected void processDataInternal(String data) {
        System.out.println("Processing image data: " + data);
    }
}

/**
 * Concrete implementation of DataProcessor - VideoProcessor
 */
class VideoProcessor extends DataProcessor {
    @Override
    protected void processDataInternal(String data) {
        System.out.println("Processing video data: " + data);
    }
}

// Media Player example for real-world demonstration

/**
 * Abstract class for media files
 */
abstract class MediaFile {
    protected String filename;
    protected String type;
    
    public MediaFile(String filename, String type) {
        this.filename = filename;
        this.type = type;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract void play();
    
    // Concrete methods - shared by all media files
    public void displayInfo() {
        System.out.println("File: " + filename + ", Type: " + type);
    }
    
    public String getFilename() {
        return filename;
    }
    
    public String getType() {
        return type;
    }
}

/**
 * Concrete implementation of MediaFile - AudioFile
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
 * Concrete implementation of MediaFile - VideoFile
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
 * Concrete implementation of MediaFile - ImageFile
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
 * Concrete implementation of MediaFile - DocumentFile
 */
class DocumentFile extends MediaFile {
    public DocumentFile(String filename, String type) {
        super(filename, type);
    }
    
    @Override
    public void play() {
        System.out.println("Opening document file: " + filename);
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

// Database connection example

/**
 * Abstract class for database connections
 */
abstract class DatabaseConnection {
    protected String connectionString;
    
    public DatabaseConnection(String connectionString) {
        this.connectionString = connectionString;
    }
    
    // Abstract methods - must be implemented by subclasses
    public abstract void connect();
    public abstract void disconnect();
    public abstract void executeQuery(String query);
    
    // Concrete methods - shared by all database connections
    public void displayConnectionInfo() {
        System.out.println("Connection String: " + connectionString);
    }
    
    public String getConnectionString() {
        return connectionString;
    }
}

/**
 * Concrete implementation of DatabaseConnection - MySQLConnection
 */
class MySQLConnection extends DatabaseConnection {
    public MySQLConnection(String connectionString) {
        super(connectionString);
    }
    
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL database: " + connectionString);
    }
    
    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MySQL database");
    }
    
    @Override
    public void executeQuery(String query) {
        System.out.println("Executing MySQL query: " + query);
    }
}

/**
 * Concrete implementation of DatabaseConnection - PostgreSQLConnection
 */
class PostgreSQLConnection extends DatabaseConnection {
    public PostgreSQLConnection(String connectionString) {
        super(connectionString);
    }
    
    @Override
    public void connect() {
        System.out.println("Connecting to PostgreSQL database: " + connectionString);
    }
    
    @Override
    public void disconnect() {
        System.out.println("Disconnecting from PostgreSQL database");
    }
    
    @Override
    public void executeQuery(String query) {
        System.out.println("Executing PostgreSQL query: " + query);
    }
}

/**
 * Concrete implementation of DatabaseConnection - OracleConnection
 */
class OracleConnection extends DatabaseConnection {
    public OracleConnection(String connectionString) {
        super(connectionString);
    }
    
    @Override
    public void connect() {
        System.out.println("Connecting to Oracle database: " + connectionString);
    }
    
    @Override
    public void disconnect() {
        System.out.println("Disconnecting from Oracle database");
    }
    
    @Override
    public void executeQuery(String query) {
        System.out.println("Executing Oracle query: " + query);
    }
}

/**
 * Database manager class
 */
class DatabaseManager {
    public void performDatabaseOperations(DatabaseConnection connection) {
        connection.displayConnectionInfo();
        connection.connect();
        connection.executeQuery("SELECT * FROM users");
        connection.disconnect();
    }
}

// Payment processing example

/**
 * Abstract class for payment methods
 */
abstract class PaymentMethod {
    protected String identifier;
    
    public PaymentMethod(String identifier) {
        this.identifier = identifier;
    }
    
    // Abstract methods - must be implemented by subclasses
    public abstract void processPayment(double amount);
    public abstract void validatePayment();
    
    // Concrete methods - shared by all payment methods
    public void displayPaymentInfo() {
        System.out.println("Payment Method: " + getClass().getSimpleName());
        System.out.println("Identifier: " + identifier);
    }
    
    public String getIdentifier() {
        return identifier;
    }
}

/**
 * Concrete implementation of PaymentMethod - CreditCard
 */
class CreditCard extends PaymentMethod {
    public CreditCard(String cardNumber) {
        super(cardNumber);
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount + " with card " + identifier);
    }
    
    @Override
    public void validatePayment() {
        System.out.println("Validating credit card: " + identifier);
    }
}

/**
 * Concrete implementation of PaymentMethod - PayPal
 */
class PayPal extends PaymentMethod {
    public PayPal(String email) {
        super(email);
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " with email " + identifier);
    }
    
    @Override
    public void validatePayment() {
        System.out.println("Validating PayPal account: " + identifier);
    }
}

/**
 * Concrete implementation of PaymentMethod - BankTransfer
 */
class BankTransfer extends PaymentMethod {
    public BankTransfer(String accountNumber) {
        super(accountNumber);
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer of $" + amount + " to account " + identifier);
    }
    
    @Override
    public void validatePayment() {
        System.out.println("Validating bank account: " + identifier);
    }
}

/**
 * Payment processor class
 */
class PaymentProcessor {
    public void processPayment(PaymentMethod payment, double amount) {
        payment.displayPaymentInfo();
        payment.validatePayment();
        payment.processPayment(amount);
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

/**
 * Flying car class implementing both abstract class and interface
 */
class FlyingCar extends Vehicle implements Flyable {
    public FlyingCar(String model, int year, String type) {
        super(model, year, type);
    }
    
    @Override
    public void accelerate() {
        System.out.println(model + " flying car is accelerating");
    }
    
    @Override
    public void brake() {
        System.out.println(model + " flying car is braking");
    }
    
    @Override
    public void fly() {
        System.out.println(model + " flying car is flying");
    }
    
    @Override
    public void land() {
        System.out.println(model + " flying car is landing");
    }
}

// Employee hierarchy for best practices demonstration

/**
 * Abstract class for all employees
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
    
    // Abstract method - must be implemented by subclasses
    public abstract void work();
    
    // Concrete methods - shared by all employees
    public void calculateBonus() {
        double bonus = salary * 0.1;
        System.out.println(name + " receives bonus: $" + bonus);
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + employeeId + ", Salary: $" + salary);
    }
    
    public String getName() {
        return name;
    }
}

/**
 * Concrete implementation of Employee - Manager
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
 * Concrete implementation of Employee - Developer
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
 * Concrete implementation of Employee - Designer
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
