package com.tutorial.intermediate.advancedoop;

/**
 * Interfaces Demo - Mastering Interface Implementation in Java
 * 
 * This comprehensive tutorial demonstrates the concept of interfaces in Java,
 * which provide a way to achieve abstraction and multiple inheritance-like
 * behavior. Interfaces define a contract that implementing classes must follow,
 * promoting loose coupling and flexible design.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what interfaces are and why they're important
 * - Learn how to create and implement interfaces
 * - Master interface inheritance and multiple interface implementation
 * - Understand default methods and static methods in interfaces
 * - Learn about functional interfaces and lambda expressions
 * - Practice with real-world interface examples
 * - Understand the benefits of interfaces in software design
 * 
 * KEY CONCEPTS:
 * 1. Interface Declaration: Defining an interface with methods and constants
 * 2. Interface Implementation: Classes implementing interface contracts
 * 3. Multiple Implementation: A class can implement multiple interfaces
 * 4. Interface Inheritance: Interfaces can extend other interfaces
 * 5. Default Methods: Methods with implementation in interfaces (Java 8+)
 * 6. Static Methods: Static methods in interfaces (Java 8+)
 * 7. Functional Interfaces: Interfaces with single abstract method
 * 
 * @author Java Tutorial Team
 * @version 1.0
 * @since 2024
 */
public class InterfacesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Interfaces Demo ===");
        System.out.println();
        
        // 1. Basic Interface Implementation
        demonstrateBasicInterfaceImplementation();
        
        // 2. Multiple Interface Implementation
        demonstrateMultipleInterfaceImplementation();
        
        // 3. Interface Inheritance
        demonstrateInterfaceInheritance();
        
        // 4. Default Methods in Interfaces
        demonstrateDefaultMethods();
        
        // 5. Static Methods in Interfaces
        demonstrateStaticMethods();
        
        // 6. Functional Interfaces and Lambda Expressions
        demonstrateFunctionalInterfaces();
        
        // 7. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 8. Best Practices and Common Patterns
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic interface implementation
     * 
     * This section shows how to create interfaces and implement them in classes.
     * Interfaces define a contract that implementing classes must follow.
     */
    private static void demonstrateBasicInterfaceImplementation() {
        System.out.println("1. Basic Interface Implementation:");
        System.out.println("=================================");
        
        // Creating objects that implement interfaces
        Drawable circle = new Circle(5.0);
        Drawable rectangle = new Rectangle(4.0, 6.0);
        Drawable triangle = new Triangle(3.0, 4.0, 5.0);
        
        System.out.println("Drawing shapes using interface:");
        System.out.println("-----------------------------");
        
        // Using interface reference to call methods
        circle.draw();
        System.out.println("Area: " + circle.calculateArea());
        
        System.out.println();
        rectangle.draw();
        System.out.println("Area: " + rectangle.calculateArea());
        
        System.out.println();
        triangle.draw();
        System.out.println("Area: " + triangle.calculateArea());
        
        // Polymorphic behavior with interfaces
        System.out.println("\nPolymorphic behavior with interfaces:");
        System.out.println("-----------------------------------");
        
        Drawable[] shapes = {circle, rectangle, triangle};
        for (Drawable shape : shapes) {
            shape.draw();
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates multiple interface implementation
     * 
     * A class can implement multiple interfaces, allowing it to have
     * multiple behaviors and capabilities.
     */
    private static void demonstrateMultipleInterfaceImplementation() {
        System.out.println("2. Multiple Interface Implementation:");
        System.out.println("====================================");
        
        // Creating objects that implement multiple interfaces
        SmartPhone phone = new SmartPhone("iPhone 15");
        Laptop laptop = new Laptop("MacBook Pro");
        Tablet tablet = new Tablet("iPad Pro");
        
        System.out.println("Devices implementing multiple interfaces:");
        System.out.println("---------------------------------------");
        
        // Testing different interface methods
        System.out.println("SmartPhone:");
        phone.powerOn();
        phone.makeCall("123-456-7890");
        phone.sendMessage("Hello World");
        phone.takePhoto();
        phone.playMusic("Song.mp3");
        
        System.out.println("\nLaptop:");
        laptop.powerOn();
        laptop.runApplication("VS Code");
        laptop.playMusic("Background Music.mp3");
        laptop.takePhoto();
        
        System.out.println("\nTablet:");
        tablet.powerOn();
        tablet.makeCall("987-654-3210");
        tablet.sendMessage("Tablet message");
        tablet.takePhoto();
        tablet.playMusic("Podcast.mp3");
        
        // Using interface references
        System.out.println("\nUsing interface references:");
        System.out.println("--------------------------");
        
        Powerable[] devices = {phone, laptop, tablet};
        for (Powerable device : devices) {
            device.powerOn();
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates interface inheritance
     * 
     * Interfaces can extend other interfaces, creating a hierarchy
     * of interfaces with increasing levels of functionality.
     */
    private static void demonstrateInterfaceInheritance() {
        System.out.println("3. Interface Inheritance:");
        System.out.println("========================");
        
        // Creating objects that implement inherited interfaces
        Car car = new Car("Toyota Camry");
        Airplane airplane = new Airplane("Boeing 747");
        Boat boat = new Boat("Yacht");
        
        System.out.println("Vehicles with interface inheritance:");
        System.out.println("----------------------------------");
        
        // Testing different levels of interface inheritance
        System.out.println("Car (implements Vehicle, Movable, Drivable):");
        car.start();
        car.move();
        car.drive();
        car.stop();
        
        System.out.println("\nAirplane (implements Vehicle, Movable, Flyable):");
        airplane.start();
        airplane.move();
        airplane.fly();
        airplane.land();
        
        System.out.println("\nBoat (implements Vehicle, Movable, Floatable):");
        boat.start();
        boat.move();
        boat.floatOnWater();
        boat.stop();
        
        // Using different interface references
        System.out.println("\nUsing different interface references:");
        System.out.println("------------------------------------");
        
        Movable[] movables = {car, airplane, boat};
        for (Movable movable : movables) {
            movable.move();
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates default methods in interfaces
     * 
     * Default methods allow interfaces to provide default implementations
     * for methods, making interfaces more flexible and backward compatible.
     */
    private static void demonstrateDefaultMethods() {
        System.out.println("4. Default Methods in Interfaces:");
        System.out.println("================================");
        
        // Creating objects that implement interfaces with default methods
        Dog dog = new Dog("Buddy");
        Cat cat = new Cat("Whiskers");
        Bird bird = new Bird("Tweety");
        
        System.out.println("Animals with default methods:");
        System.out.println("----------------------------");
        
        // Testing default methods
        System.out.println("Dog:");
        dog.makeSound();
        dog.sleep(); // Default method
        dog.eat();   // Default method
        
        System.out.println("\nCat:");
        cat.makeSound();
        cat.sleep(); // Default method
        cat.eat();   // Default method
        
        System.out.println("\nBird:");
        bird.makeSound();
        bird.sleep(); // Default method
        bird.eat();   // Default method
        
        // Using interface references
        System.out.println("\nUsing interface references:");
        System.out.println("--------------------------");
        
        Animal[] animals = {dog, cat, bird};
        for (Animal animal : animals) {
            animal.makeSound();
            animal.sleep(); // Default method
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates static methods in interfaces
     * 
     * Static methods in interfaces provide utility methods that can be
     * called directly on the interface without needing an implementation.
     */
    private static void demonstrateStaticMethods() {
        System.out.println("5. Static Methods in Interfaces:");
        System.out.println("===============================");
        
        // Calling static methods directly on interfaces
        System.out.println("Utility methods from interfaces:");
        System.out.println("------------------------------");
        
        // MathUtils static methods
        System.out.println("MathUtils.add(5, 3) = " + MathUtils.add(5, 3));
        System.out.println("MathUtils.multiply(4, 6) = " + MathUtils.multiply(4, 6));
        System.out.println("MathUtils.isEven(8) = " + MathUtils.isEven(8));
        
        // StringUtils static methods
        System.out.println("StringUtils.reverse(\"Hello\") = " + StringUtils.reverse("Hello"));
        System.out.println("StringUtils.isPalindrome(\"racecar\") = " + StringUtils.isPalindrome("racecar"));
        System.out.println("StringUtils.countWords(\"Hello World\") = " + StringUtils.countWords("Hello World"));
        
        // DateUtils static methods
        System.out.println("DateUtils.getCurrentDate() = " + DateUtils.getCurrentDate());
        System.out.println("DateUtils.isWeekend() = " + DateUtils.isWeekend());
        
        System.out.println();
    }
    
    /**
     * Demonstrates functional interfaces and lambda expressions
     * 
     * Functional interfaces are interfaces with a single abstract method.
     * They can be implemented using lambda expressions for concise code.
     */
    private static void demonstrateFunctionalInterfaces() {
        System.out.println("6. Functional Interfaces and Lambda Expressions:");
        System.out.println("==============================================");
        
        // Using built-in functional interfaces
        System.out.println("Built-in functional interfaces:");
        System.out.println("------------------------------");
        
        // Predicate example
        java.util.function.Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));
        System.out.println("Is 7 even? " + isEven.test(7));
        
        // Function example
        java.util.function.Function<String, Integer> stringLength = str -> str.length();
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));
        
        // Consumer example
        java.util.function.Consumer<String> printer = str -> System.out.println("Printing: " + str);
        printer.accept("Hello World");
        
        // Supplier example
        java.util.function.Supplier<Double> randomValue = () -> Math.random();
        System.out.println("Random value: " + randomValue.get());
        
        // Custom functional interface
        System.out.println("\nCustom functional interface:");
        System.out.println("---------------------------");
        
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> b != 0 ? a / b : 0;
        
        System.out.println("5 + 3 = " + add.calculate(5, 3));
        System.out.println("4 * 6 = " + multiply.calculate(4, 6));
        System.out.println("10 / 2 = " + divide.calculate(10, 2));
        
        // Using functional interface with method reference
        System.out.println("\nMethod references:");
        System.out.println("-----------------");
        
        java.util.function.Function<String, String> toUpperCase = String::toUpperCase;
        System.out.println("'hello' to uppercase: " + toUpperCase.apply("hello"));
        
        java.util.function.Function<String, Integer> parseInt = Integer::parseInt;
        System.out.println("Parse '123': " + parseInt.apply("123"));
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples of interfaces
     * 
     * This section shows practical examples of how interfaces are used
     * in real-world software development.
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("7. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: Database Operations
        System.out.println("Example 1: Database Operations");
        System.out.println("------------------------------");
        
        DatabaseManager dbManager = new DatabaseManager();
        
        DatabaseConnection[] connections = {
            new MySQLConnection("localhost:3306"),
            new PostgreSQLConnection("localhost:5432"),
            new OracleConnection("localhost:1521")
        };
        
        for (DatabaseConnection conn : connections) {
            dbManager.performOperations(conn);
        }
        
        // Example 2: Payment Processing
        System.out.println("\nExample 2: Payment Processing");
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
        
        // Example 3: Media Player
        System.out.println("\nExample 3: Media Player");
        System.out.println("----------------------");
        
        MediaPlayer player = new MediaPlayer();
        
        MediaFile[] mediaFiles = {
            new AudioFile("song.mp3"),
            new VideoFile("movie.mp4"),
            new ImageFile("photo.jpg")
        };
        
        for (MediaFile file : mediaFiles) {
            player.play(file);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices and common patterns
     * 
     * This section shows best practices for using interfaces effectively
     * and common patterns in object-oriented design.
     */
    private static void demonstrateBestPractices() {
        System.out.println("8. Best Practices and Common Patterns:");
        System.out.println("=====================================");
        
        // Best Practice 1: Use interfaces for contracts
        System.out.println("Best Practice 1: Interface Contracts");
        System.out.println("-----------------------------------");
        
        // Interface defines contract
        java.util.List<Shape> shapes = new java.util.ArrayList<>();
        shapes.add(new Circle(5.0));
        shapes.add(new Rectangle(4.0, 6.0));
        shapes.add(new Triangle(3.0, 4.0, 5.0));
        
        for (Shape shape : shapes) {
            shape.draw();
            System.out.println("Area: " + shape.calculateArea());
        }
        
        // Best Practice 2: Use interfaces for dependency injection
        System.out.println("\nBest Practice 2: Dependency Injection");
        System.out.println("------------------------------------");
        
        // Service depends on interface, not concrete implementation
        NotificationService emailService = new EmailNotificationService();
        NotificationService smsService = new SMSNotificationService();
        
        UserService userService1 = new UserService(emailService);
        UserService userService2 = new UserService(smsService);
        
        userService1.sendWelcomeMessage("user1@example.com");
        userService2.sendWelcomeMessage("user2@example.com");
        
        // Best Practice 3: Use interfaces for multiple inheritance
        System.out.println("\nBest Practice 3: Multiple Inheritance");
        System.out.println("------------------------------------");
        
        // Class implementing multiple interfaces
        SmartWatch watch = new SmartWatch("Apple Watch");
        watch.powerOn();
        watch.makeCall("123-456-7890");
        watch.takePhoto();
        watch.playMusic("Workout Music.mp3");
        watch.trackHeartRate();
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Interfaces define contracts that implementing classes must follow");
        System.out.println("• Classes can implement multiple interfaces");
        System.out.println("• Interfaces can extend other interfaces");
        System.out.println("• Default methods provide backward compatibility");
        System.out.println("• Static methods provide utility functions");
        System.out.println("• Functional interfaces enable lambda expressions");
        System.out.println("• Use interfaces for loose coupling and flexibility");
        System.out.println("• Interfaces promote code reusability and maintainability");
    }
}

// Basic interface for drawing shapes

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

// Multiple interface implementation example

/**
 * Interface for devices that can be powered on/off
 */
interface Powerable {
    void powerOn();
    void powerOff();
}

/**
 * Interface for devices that can make calls
 */
interface Callable {
    void makeCall(String number);
    void receiveCall(String number);
}

/**
 * Interface for devices that can send messages
 */
interface Messagable {
    void sendMessage(String message);
    void receiveMessage(String message);
}

/**
 * Interface for devices that can take photos
 */
interface Photographable {
    void takePhoto();
    void viewPhotos();
}

/**
 * Interface for devices that can play music
 */
interface MusicPlayable {
    void playMusic(String song);
    void pauseMusic();
    void stopMusic();
}

/**
 * Interface for devices that can run applications
 */
interface ApplicationRunnable {
    void runApplication(String appName);
    void closeApplication(String appName);
}

/**
 * SmartPhone class implementing multiple interfaces
 */
class SmartPhone implements Powerable, Callable, Messagable, Photographable, MusicPlayable {
    private String model;
    
    public SmartPhone(String model) {
        this.model = model;
    }
    
    @Override
    public void powerOn() {
        System.out.println(model + " smartphone is powering on");
    }
    
    @Override
    public void powerOff() {
        System.out.println(model + " smartphone is powering off");
    }
    
    @Override
    public void makeCall(String number) {
        System.out.println(model + " is calling " + number);
    }
    
    @Override
    public void receiveCall(String number) {
        System.out.println(model + " is receiving call from " + number);
    }
    
    @Override
    public void sendMessage(String message) {
        System.out.println(model + " is sending message: " + message);
    }
    
    @Override
    public void receiveMessage(String message) {
        System.out.println(model + " received message: " + message);
    }
    
    @Override
    public void takePhoto() {
        System.out.println(model + " is taking a photo");
    }
    
    @Override
    public void viewPhotos() {
        System.out.println(model + " is viewing photos");
    }
    
    @Override
    public void playMusic(String song) {
        System.out.println(model + " is playing: " + song);
    }
    
    @Override
    public void pauseMusic() {
        System.out.println(model + " paused music");
    }
    
    @Override
    public void stopMusic() {
        System.out.println(model + " stopped music");
    }
}

/**
 * Laptop class implementing multiple interfaces
 */
class Laptop implements Powerable, ApplicationRunnable, Photographable, MusicPlayable {
    private String model;
    
    public Laptop(String model) {
        this.model = model;
    }
    
    @Override
    public void powerOn() {
        System.out.println(model + " laptop is powering on");
    }
    
    @Override
    public void powerOff() {
        System.out.println(model + " laptop is powering off");
    }
    
    @Override
    public void runApplication(String appName) {
        System.out.println(model + " is running application: " + appName);
    }
    
    @Override
    public void closeApplication(String appName) {
        System.out.println(model + " is closing application: " + appName);
    }
    
    @Override
    public void takePhoto() {
        System.out.println(model + " is taking a photo with webcam");
    }
    
    @Override
    public void viewPhotos() {
        System.out.println(model + " is viewing photos");
    }
    
    @Override
    public void playMusic(String song) {
        System.out.println(model + " is playing: " + song);
    }
    
    @Override
    public void pauseMusic() {
        System.out.println(model + " paused music");
    }
    
    @Override
    public void stopMusic() {
        System.out.println(model + " stopped music");
    }
}

/**
 * Tablet class implementing multiple interfaces
 */
class Tablet implements Powerable, Callable, Messagable, Photographable, MusicPlayable {
    private String model;
    
    public Tablet(String model) {
        this.model = model;
    }
    
    @Override
    public void powerOn() {
        System.out.println(model + " tablet is powering on");
    }
    
    @Override
    public void powerOff() {
        System.out.println(model + " tablet is powering off");
    }
    
    @Override
    public void makeCall(String number) {
        System.out.println(model + " is calling " + number);
    }
    
    @Override
    public void receiveCall(String number) {
        System.out.println(model + " is receiving call from " + number);
    }
    
    @Override
    public void sendMessage(String message) {
        System.out.println(model + " is sending message: " + message);
    }
    
    @Override
    public void receiveMessage(String message) {
        System.out.println(model + " received message: " + message);
    }
    
    @Override
    public void takePhoto() {
        System.out.println(model + " is taking a photo");
    }
    
    @Override
    public void viewPhotos() {
        System.out.println(model + " is viewing photos");
    }
    
    @Override
    public void playMusic(String song) {
        System.out.println(model + " is playing: " + song);
    }
    
    @Override
    public void pauseMusic() {
        System.out.println(model + " paused music");
    }
    
    @Override
    public void stopMusic() {
        System.out.println(model + " stopped music");
    }
}

// Interface inheritance example

/**
 * Base interface for all vehicles
 */
interface Vehicle {
    void start();
    void stop();
}

/**
 * Interface for movable objects
 */
interface Movable extends Vehicle {
    void move();
}

/**
 * Interface for drivable vehicles
 */
interface Drivable extends Movable {
    void drive();
}

/**
 * Interface for flyable objects
 */
interface Flyable extends Movable {
    void fly();
    void land();
}

/**
 * Interface for floatable objects
 */
interface Floatable extends Movable {
    void floatOnWater();
}

/**
 * Car class implementing Drivable
 */
class Car implements Drivable {
    private String model;
    
    public Car(String model) {
        this.model = model;
    }
    
    @Override
    public void start() {
        System.out.println(model + " car is starting");
    }
    
    @Override
    public void stop() {
        System.out.println(model + " car is stopping");
    }
    
    @Override
    public void move() {
        System.out.println(model + " car is moving");
    }
    
    @Override
    public void drive() {
        System.out.println(model + " car is being driven");
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
    public void start() {
        System.out.println(model + " airplane is starting");
    }
    
    @Override
    public void stop() {
        System.out.println(model + " airplane is stopping");
    }
    
    @Override
    public void move() {
        System.out.println(model + " airplane is moving");
    }
    
    @Override
    public void fly() {
        System.out.println(model + " airplane is flying");
    }
    
    @Override
    public void land() {
        System.out.println(model + " airplane is landing");
    }
}

/**
 * Boat class implementing Floatable
 */
class Boat implements Floatable {
    private String model;
    
    public Boat(String model) {
        this.model = model;
    }
    
    @Override
    public void start() {
        System.out.println(model + " boat is starting");
    }
    
    @Override
    public void stop() {
        System.out.println(model + " boat is stopping");
    }
    
    @Override
    public void move() {
        System.out.println(model + " boat is moving");
    }
    
    @Override
    public void floatOnWater() {
        System.out.println(model + " boat is floating on water");
    }
}

// Default methods example

/**
 * Interface for animals with default methods
 */
interface Animal {
    void makeSound();
    
    // Default methods
    default void sleep() {
        System.out.println("Animal is sleeping");
    }
    
    default void eat() {
        System.out.println("Animal is eating");
    }
}

/**
 * Dog class implementing Animal
 */
class Dog implements Animal {
    private String name;
    
    public Dog(String name) {
        this.name = name;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
}

/**
 * Cat class implementing Animal
 */
class Cat implements Animal {
    private String name;
    
    public Cat(String name) {
        this.name = name;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
}

/**
 * Bird class implementing Animal
 */
class Bird implements Animal {
    private String name;
    
    public Bird(String name) {
        this.name = name;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet!");
    }
}

// Static methods example

/**
 * Interface with static utility methods
 */
interface MathUtils {
    static int add(int a, int b) {
        return a + b;
    }
    
    static int multiply(int a, int b) {
        return a * b;
    }
    
    static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

/**
 * Interface with static string utility methods
 */
interface StringUtils {
    static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    static boolean isPalindrome(String str) {
        return str.equals(reverse(str));
    }
    
    static int countWords(String str) {
        return str.trim().split("\\s+").length;
    }
}

/**
 * Interface with static date utility methods
 */
interface DateUtils {
    static String getCurrentDate() {
        return java.time.LocalDate.now().toString();
    }
    
    static boolean isWeekend() {
        java.time.DayOfWeek day = java.time.LocalDate.now().getDayOfWeek();
        return day == java.time.DayOfWeek.SATURDAY || day == java.time.DayOfWeek.SUNDAY;
    }
}

// Functional interface example

/**
 * Functional interface for calculator operations
 */
@FunctionalInterface
interface Calculator {
    double calculate(double a, double b);
}

// Real-world examples

/**
 * Interface for database connections
 */
interface DatabaseConnection {
    void connect();
    void disconnect();
    void executeQuery(String query);
}

/**
 * MySQL connection implementation
 */
class MySQLConnection implements DatabaseConnection {
    private String connectionString;
    
    public MySQLConnection(String connectionString) {
        this.connectionString = connectionString;
    }
    
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL: " + connectionString);
    }
    
    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MySQL");
    }
    
    @Override
    public void executeQuery(String query) {
        System.out.println("Executing MySQL query: " + query);
    }
}

/**
 * PostgreSQL connection implementation
 */
class PostgreSQLConnection implements DatabaseConnection {
    private String connectionString;
    
    public PostgreSQLConnection(String connectionString) {
        this.connectionString = connectionString;
    }
    
    @Override
    public void connect() {
        System.out.println("Connecting to PostgreSQL: " + connectionString);
    }
    
    @Override
    public void disconnect() {
        System.out.println("Disconnecting from PostgreSQL");
    }
    
    @Override
    public void executeQuery(String query) {
        System.out.println("Executing PostgreSQL query: " + query);
    }
}

/**
 * Oracle connection implementation
 */
class OracleConnection implements DatabaseConnection {
    private String connectionString;
    
    public OracleConnection(String connectionString) {
        this.connectionString = connectionString;
    }
    
    @Override
    public void connect() {
        System.out.println("Connecting to Oracle: " + connectionString);
    }
    
    @Override
    public void disconnect() {
        System.out.println("Disconnecting from Oracle");
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
    public void performOperations(DatabaseConnection connection) {
        connection.connect();
        connection.executeQuery("SELECT * FROM users");
        connection.disconnect();
    }
}

/**
 * Interface for payment methods
 */
interface PaymentMethod {
    void processPayment(double amount);
    void validatePayment();
}

/**
 * Credit card payment implementation
 */
class CreditCard implements PaymentMethod {
    private String cardNumber;
    
    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount + " with card " + cardNumber);
    }
    
    @Override
    public void validatePayment() {
        System.out.println("Validating credit card: " + cardNumber);
    }
}

/**
 * PayPal payment implementation
 */
class PayPal implements PaymentMethod {
    private String email;
    
    public PayPal(String email) {
        this.email = email;
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " with email " + email);
    }
    
    @Override
    public void validatePayment() {
        System.out.println("Validating PayPal account: " + email);
    }
}

/**
 * Bank transfer payment implementation
 */
class BankTransfer implements PaymentMethod {
    private String accountNumber;
    
    public BankTransfer(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer of $" + amount + " to account " + accountNumber);
    }
    
    @Override
    public void validatePayment() {
        System.out.println("Validating bank account: " + accountNumber);
    }
}

/**
 * Payment processor class
 */
class PaymentProcessor {
    public void processPayment(PaymentMethod payment, double amount) {
        payment.validatePayment();
        payment.processPayment(amount);
    }
}

/**
 * Interface for media files
 */
interface MediaFile {
    void play();
    void pause();
    void stop();
}

/**
 * Audio file implementation
 */
class AudioFile implements MediaFile {
    private String filename;
    
    public AudioFile(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void play() {
        System.out.println("Playing audio file: " + filename);
    }
    
    @Override
    public void pause() {
        System.out.println("Pausing audio file: " + filename);
    }
    
    @Override
    public void stop() {
        System.out.println("Stopping audio file: " + filename);
    }
}

/**
 * Video file implementation
 */
class VideoFile implements MediaFile {
    private String filename;
    
    public VideoFile(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void play() {
        System.out.println("Playing video file: " + filename);
    }
    
    @Override
    public void pause() {
        System.out.println("Pausing video file: " + filename);
    }
    
    @Override
    public void stop() {
        System.out.println("Stopping video file: " + filename);
    }
}

/**
 * Image file implementation
 */
class ImageFile implements MediaFile {
    private String filename;
    
    public ImageFile(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void play() {
        System.out.println("Displaying image file: " + filename);
    }
    
    @Override
    public void pause() {
        System.out.println("Pausing image display: " + filename);
    }
    
    @Override
    public void stop() {
        System.out.println("Stopping image display: " + filename);
    }
}

/**
 * Media player class
 */
class MediaPlayer {
    public void play(MediaFile file) {
        file.play();
    }
}

// Best practices example

/**
 * Interface for notification services
 */
interface NotificationService {
    void sendNotification(String message, String recipient);
}

/**
 * Email notification service implementation
 */
class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending email to " + recipient + ": " + message);
    }
}

/**
 * SMS notification service implementation
 */
class SMSNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}

/**
 * User service class using dependency injection
 */
class UserService {
    private NotificationService notificationService;
    
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    
    public void sendWelcomeMessage(String userEmail) {
        notificationService.sendNotification("Welcome to our service!", userEmail);
    }
}

/**
 * Smart watch class implementing multiple interfaces
 */
class SmartWatch implements Powerable, Callable, Photographable, MusicPlayable {
    private String model;
    
    public SmartWatch(String model) {
        this.model = model;
    }
    
    @Override
    public void powerOn() {
        System.out.println(model + " smart watch is powering on");
    }
    
    @Override
    public void powerOff() {
        System.out.println(model + " smart watch is powering off");
    }
    
    @Override
    public void makeCall(String number) {
        System.out.println(model + " is calling " + number);
    }
    
    @Override
    public void receiveCall(String number) {
        System.out.println(model + " is receiving call from " + number);
    }
    
    @Override
    public void takePhoto() {
        System.out.println(model + " is taking a photo");
    }
    
    @Override
    public void viewPhotos() {
        System.out.println(model + " is viewing photos");
    }
    
    @Override
    public void playMusic(String song) {
        System.out.println(model + " is playing: " + song);
    }
    
    @Override
    public void pauseMusic() {
        System.out.println(model + " paused music");
    }
    
    @Override
    public void stopMusic() {
        System.out.println(model + " stopped music");
    }
    
    public void trackHeartRate() {
        System.out.println(model + " is tracking heart rate");
    }
}
