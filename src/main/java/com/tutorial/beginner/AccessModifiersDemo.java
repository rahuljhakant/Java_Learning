package com.tutorial.beginner;

/**
 * Access Modifiers Demo - Understanding Visibility and Encapsulation in Java
 * 
 * This comprehensive tutorial demonstrates the four access modifiers in Java:
 * public, private, protected, and default (package-private). Understanding
 * access modifiers is crucial for proper encapsulation and object-oriented
 * design principles.
 * 
 * LEARNING OBJECTIVES:
 * - Understand the four access modifiers in Java
 * - Learn when and how to use each access modifier
 * - Understand the concept of encapsulation
 * - Learn about getter and setter methods
 * - Practice with real-world examples
 * - Understand access modifier inheritance rules
 * 
 * KEY CONCEPTS:
 * 1. Public: Accessible from anywhere
 * 2. Private: Accessible only within the same class
 * 3. Protected: Accessible within the same package and subclasses
 * 4. Default (Package-private): Accessible within the same package
 * 5. Encapsulation: Hiding internal implementation details
 * 6. Getters and Setters: Methods to access and modify private fields
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class AccessModifiersDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Access Modifiers Demo ===");
        System.out.println();
        
        // 1. Public Access Modifier
        demonstratePublicAccess();
        
        // 2. Private Access Modifier
        demonstratePrivateAccess();
        
        // 3. Protected Access Modifier
        demonstrateProtectedAccess();
        
        // 4. Default (Package-private) Access Modifier
        demonstrateDefaultAccess();
        
        // 5. Encapsulation with Getters and Setters
        demonstrateEncapsulation();
        
        // 6. Access Modifiers in Inheritance
        demonstrateInheritanceAccess();
        
        // 7. Best Practices and Real-world Examples
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates public access modifier
     * 
     * Public members are accessible from anywhere in the program.
     * They can be accessed from other classes, packages, and even
     * from outside the application.
     */
    private static void demonstratePublicAccess() {
        System.out.println("1. Public Access Modifier:");
        System.out.println("=========================");
        
        // Creating objects to demonstrate public access
        PublicDemo publicObj = new PublicDemo();
        
        // Accessing public fields directly
        System.out.println("Public field: " + publicObj.publicField);
        publicObj.publicField = "Modified from outside";
        System.out.println("Modified public field: " + publicObj.publicField);
        
        // Calling public methods
        publicObj.publicMethod();
        String result = publicObj.publicMethodWithReturn("Hello");
        System.out.println("Public method result: " + result);
        
        // Public static members
        System.out.println("Public static field: " + PublicDemo.PUBLIC_STATIC_FIELD);
        PublicDemo.publicStaticMethod();
        
        System.out.println();
    }
    
    /**
     * Demonstrates private access modifier
     * 
     * Private members are accessible only within the same class.
     * They cannot be accessed from outside the class, ensuring
     * proper encapsulation and data hiding.
     */
    private static void demonstratePrivateAccess() {
        System.out.println("2. Private Access Modifier:");
        System.out.println("==========================");
        
        PrivateDemo privateObj = new PrivateDemo();
        
        // Cannot access private fields directly
        // privateObj.privateField; // This would cause compilation error
        
        // Accessing private fields through public methods
        System.out.println("Private field accessed through getter: " + privateObj.getPrivateField());
        
        // Modifying private fields through public methods
        privateObj.setPrivateField("Modified through setter");
        System.out.println("Private field after modification: " + privateObj.getPrivateField());
        
        // Calling public methods that use private methods internally
        privateObj.publicMethodUsingPrivate();
        
        // Demonstrating data validation in setter
        privateObj.setAge(25);
        System.out.println("Age set to 25: " + privateObj.getAge());
        
        privateObj.setAge(-5); // Invalid age
        System.out.println("Age after invalid input: " + privateObj.getAge());
        
        System.out.println();
    }
    
    /**
     * Demonstrates protected access modifier
     * 
     * Protected members are accessible within the same package and
     * by subclasses in other packages. This is commonly used in
     * inheritance scenarios.
     */
    private static void demonstrateProtectedAccess() {
        System.out.println("3. Protected Access Modifier:");
        System.out.println("============================");
        
        ProtectedDemo protectedObj = new ProtectedDemo();
        
        // Accessing protected members from the same package
        System.out.println("Protected field: " + protectedObj.protectedField);
        protectedObj.protectedMethod();
        
        // Creating subclass to demonstrate protected access in inheritance
        ChildClass child = new ChildClass();
        child.accessProtectedMembers();
        
        System.out.println();
    }
    
    /**
     * Demonstrates default (package-private) access modifier
     * 
     * Default access means the member is accessible only within
     * the same package. No access modifier keyword is used.
     */
    private static void demonstrateDefaultAccess() {
        System.out.println("4. Default (Package-private) Access Modifier:");
        System.out.println("============================================");
        
        DefaultDemo defaultObj = new DefaultDemo();
        
        // Accessing default members from the same package
        System.out.println("Default field: " + defaultObj.defaultField);
        defaultObj.defaultMethod();
        
        // Default static members
        System.out.println("Default static field: " + DefaultDemo.DEFAULT_STATIC_FIELD);
        DefaultDemo.defaultStaticMethod();
        
        System.out.println();
    }
    
    /**
     * Demonstrates encapsulation with getters and setters
     * 
     * Encapsulation is a fundamental principle of OOP that involves
     * hiding internal implementation details and providing controlled
     * access through methods.
     */
    private static void demonstrateEncapsulation() {
        System.out.println("5. Encapsulation with Getters and Setters:");
        System.out.println("=========================================");
        
        // Creating a bank account with proper encapsulation
        BankAccount account = new BankAccount("123456789", "John Doe", 1000.0);
        
        // Using getters to access private data
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Initial Balance: $" + account.getBalance());
        
        // Using setters with validation
        account.setAccountHolder("John Smith");
        System.out.println("Updated Account Holder: " + account.getAccountHolder());
        
        // Depositing money
        account.deposit(500.0);
        System.out.println("Balance after deposit: $" + account.getBalance());
        
        // Withdrawing money
        boolean withdrawalSuccess = account.withdraw(200.0);
        System.out.println("Withdrawal successful: " + withdrawalSuccess);
        System.out.println("Balance after withdrawal: $" + account.getBalance());
        
        // Attempting invalid withdrawal
        boolean invalidWithdrawal = account.withdraw(2000.0);
        System.out.println("Invalid withdrawal successful: " + invalidWithdrawal);
        System.out.println("Balance after invalid withdrawal: $" + account.getBalance());
        
        // Creating a student with encapsulation
        Student student = new Student();
        student.setName("Alice");
        student.setAge(20);
        student.setGrade('A');
        
        System.out.println("\nStudent Information:");
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Grade: " + student.getGrade());
        System.out.println("Is passing: " + student.isPassing());
        
        System.out.println();
    }
    
    /**
     * Demonstrates access modifiers in inheritance
     * 
     * This section shows how access modifiers work in inheritance
     * scenarios and what members are accessible in subclasses.
     */
    private static void demonstrateInheritanceAccess() {
        System.out.println("6. Access Modifiers in Inheritance:");
        System.out.println("==================================");
        
        // Creating objects of different classes in inheritance hierarchy
        ParentClass parent = new ParentClass();
        ChildClass child = new ChildClass();
        GrandChildClass grandChild = new GrandChildClass();
        
        // Testing access from different levels
        System.out.println("Testing access from ParentClass:");
        parent.testAccess();
        
        System.out.println("\nTesting access from ChildClass:");
        child.testAccess();
        child.accessProtectedMembers();
        
        System.out.println("\nTesting access from GrandChildClass:");
        grandChild.testAccess();
        grandChild.accessProtectedMembers();
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices and real-world examples
     * 
     * This section shows real-world examples of how access modifiers
     * are used in practice and best practices for their usage.
     */
    private static void demonstrateBestPractices() {
        System.out.println("7. Best Practices and Real-world Examples:");
        System.out.println("=========================================");
        
        // Example 1: Car class with proper encapsulation
        Car car = new Car("Toyota", "Camry", 2023);
        
        System.out.println("Car Information:");
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Mileage: " + car.getMileage());
        
        // Starting the car
        car.start();
        System.out.println("Is running: " + car.isRunning());
        
        // Driving the car
        car.drive(50);
        System.out.println("Mileage after driving: " + car.getMileage());
        
        // Stopping the car
        car.stop();
        System.out.println("Is running: " + car.isRunning());
        
        // Example 2: Library book with encapsulation
        LibraryBook book = new LibraryBook("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        
        System.out.println("\nLibrary Book Information:");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Is available: " + book.isAvailable());
        
        // Borrowing the book
        book.borrow();
        System.out.println("Is available after borrowing: " + book.isAvailable());
        
        // Returning the book
        book.returnBook();
        System.out.println("Is available after returning: " + book.isAvailable());
        
        // Example 3: Employee class with proper access control
        Employee employee = new Employee("John Doe", "E001", 50000.0);
        
        System.out.println("\nEmployee Information:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Salary: $" + employee.getSalary());
        
        // Giving a raise
        employee.giveRaise(5000.0);
        System.out.println("Salary after raise: $" + employee.getSalary());
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Use PUBLIC for methods that need to be accessible from anywhere");
        System.out.println("• Use PRIVATE for internal implementation details");
        System.out.println("• Use PROTECTED for members that subclasses need to access");
        System.out.println("• Use DEFAULT for package-level access");
        System.out.println("• Always use getters and setters for private fields");
        System.out.println("• Apply validation in setters to maintain data integrity");
        System.out.println("• Follow the principle of least privilege");
    }
}

// Classes demonstrating different access modifiers

/**
 * Class demonstrating public access modifier
 */
class PublicDemo {
    // Public field
    public String publicField = "This is a public field";
    
    // Public static field
    public static String PUBLIC_STATIC_FIELD = "This is a public static field";
    
    // Public method
    public void publicMethod() {
        System.out.println("This is a public method");
    }
    
    // Public method with return value
    public String publicMethodWithReturn(String input) {
        return "Public method received: " + input;
    }
    
    // Public static method
    public static void publicStaticMethod() {
        System.out.println("This is a public static method");
    }
}

/**
 * Class demonstrating private access modifier
 */
class PrivateDemo {
    // Private field
    private String privateField = "This is a private field";
    private int age = 0;
    
    // Public getter for private field
    public String getPrivateField() {
        return privateField;
    }
    
    // Public setter for private field
    public void setPrivateField(String value) {
        this.privateField = value;
    }
    
    // Public getter for age
    public int getAge() {
        return age;
    }
    
    // Public setter for age with validation
    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("Invalid age: " + age + ". Age must be between 0 and 150.");
        }
    }
    
    // Public method that uses private method
    public void publicMethodUsingPrivate() {
        System.out.println("Public method calling private method:");
        privateMethod();
    }
    
    // Private method
    private void privateMethod() {
        System.out.println("This is a private method");
    }
}

/**
 * Class demonstrating protected access modifier
 */
class ProtectedDemo {
    // Protected field
    protected String protectedField = "This is a protected field";
    
    // Protected method
    protected void protectedMethod() {
        System.out.println("This is a protected method");
    }
    
    // Public method to test access
    public void testAccess() {
        System.out.println("Accessing protected members from same class:");
        System.out.println("Protected field: " + protectedField);
        protectedMethod();
    }
}

/**
 * Class demonstrating default (package-private) access modifier
 */
class DefaultDemo {
    // Default field (no access modifier)
    String defaultField = "This is a default field";
    
    // Default static field
    static String DEFAULT_STATIC_FIELD = "This is a default static field";
    
    // Default method
    void defaultMethod() {
        System.out.println("This is a default method");
    }
    
    // Default static method
    static void defaultStaticMethod() {
        System.out.println("This is a default static method");
    }
    
    // Public method to test access
    public void testAccess() {
        System.out.println("Accessing default members from same class:");
        System.out.println("Default field: " + defaultField);
        defaultMethod();
    }
}

/**
 * Child class demonstrating protected access in inheritance
 */
class ChildClass extends ProtectedDemo {
    public void accessProtectedMembers() {
        System.out.println("Accessing protected members from subclass:");
        System.out.println("Protected field: " + protectedField);
        protectedMethod();
    }
    
    public void testAccess() {
        System.out.println("Testing access from ChildClass:");
        // Can access protected members from parent
        System.out.println("Protected field: " + protectedField);
        protectedMethod();
    }
}

/**
 * Grandchild class for inheritance demonstration
 */
class GrandChildClass extends ChildClass {
    public void testAccess() {
        System.out.println("Testing access from GrandChildClass:");
        // Can access protected members from grandparent
        System.out.println("Protected field: " + protectedField);
        protectedMethod();
    }
}

/**
 * Parent class for inheritance demonstration
 */
class ParentClass {
    public String publicField = "Parent public field";
    protected String protectedField = "Parent protected field";
    String defaultField = "Parent default field";
    private String privateField = "Parent private field";
    
    public void testAccess() {
        System.out.println("Testing access from ParentClass:");
        System.out.println("Public field: " + publicField);
        System.out.println("Protected field: " + protectedField);
        System.out.println("Default field: " + defaultField);
        System.out.println("Private field: " + privateField);
    }
}

/**
 * Bank Account class demonstrating proper encapsulation
 */
class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Setters with validation
    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && !accountHolder.trim().isEmpty()) {
            this.accountHolder = accountHolder;
        }
    }
    
    // Business methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount: $" + amount);
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            return true;
        } else {
            System.out.println("Invalid withdrawal amount: $" + amount);
            return false;
        }
    }
}

/**
 * Student class demonstrating encapsulation
 */
class Student {
    private String name;
    private int age;
    private char grade;
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public char getGrade() {
        return grade;
    }
    
    // Setters with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }
    
    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        }
    }
    
    public void setGrade(char grade) {
        if (grade >= 'A' && grade <= 'F') {
            this.grade = grade;
        }
    }
    
    // Business method
    public boolean isPassing() {
        return grade >= 'A' && grade <= 'D';
    }
}

/**
 * Car class demonstrating real-world encapsulation
 */
class Car {
    private String make;
    private String model;
    private int year;
    private double mileage;
    private boolean isRunning;
    
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = 0.0;
        this.isRunning = false;
    }
    
    // Getters
    public String getMake() {
        return make;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    public double getMileage() {
        return mileage;
    }
    
    public boolean isRunning() {
        return isRunning;
    }
    
    // Business methods
    public void start() {
        if (!isRunning) {
            isRunning = true;
            System.out.println("Car started");
        } else {
            System.out.println("Car is already running");
        }
    }
    
    public void stop() {
        if (isRunning) {
            isRunning = false;
            System.out.println("Car stopped");
        } else {
            System.out.println("Car is already stopped");
        }
    }
    
    public void drive(double distance) {
        if (isRunning && distance > 0) {
            mileage += distance;
            System.out.println("Drove " + distance + " miles");
        } else if (!isRunning) {
            System.out.println("Cannot drive - car is not running");
        } else {
            System.out.println("Invalid distance: " + distance);
        }
    }
}

/**
 * Library Book class demonstrating encapsulation
 */
class LibraryBook {
    private String title;
    private String author;
    private String isbn;
    private boolean available;
    
    public LibraryBook(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }
    
    // Getters
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    // Business methods
    public void borrow() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book is not available for borrowing");
        }
    }
    
    public void returnBook() {
        if (!available) {
            available = true;
            System.out.println("Book returned successfully");
        } else {
            System.out.println("Book is already available");
        }
    }
}

/**
 * Employee class demonstrating proper access control
 */
class Employee {
    private String name;
    private String employeeId;
    private double salary;
    
    public Employee(String name, String employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public double getSalary() {
        return salary;
    }
    
    // Business methods
    public void giveRaise(double amount) {
        if (amount > 0) {
            salary += amount;
            System.out.println("Raise of $" + amount + " given");
        } else {
            System.out.println("Invalid raise amount: $" + amount);
        }
    }
}
