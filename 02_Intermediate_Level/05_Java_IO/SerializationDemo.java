package com.tutorial.intermediate.io;

/**
 * Serialization Demo - Mastering Object Persistence in Java
 * 
 * This comprehensive tutorial demonstrates Java Serialization, which allows
 * objects to be converted into a byte stream for storage or transmission
 * and later reconstructed back into objects. Serialization is essential
 * for data persistence, network communication, and distributed systems.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what serialization is and why it's important
 * - Learn how to implement Serializable interface
 * - Master serialization and deserialization process
 * - Practice with real-world examples of serialization
 * - Learn about serialization best practices and common pitfalls
 * - Understand version control and compatibility
 * - Learn about custom serialization methods
 * 
 * KEY CONCEPTS:
 * 1. Serializable Interface: Marker interface for serializable classes
 * 2. ObjectOutputStream: Writing objects to byte stream
 * 3. ObjectInputStream: Reading objects from byte stream
 * 4. Serial Version UID: Version control for serialized objects
 * 5. Transient Keyword: Excluding fields from serialization
 * 6. Custom Serialization: writeObject() and readObject() methods
 * 7. Externalizable Interface: Custom serialization control
 * 8. Security: Serialization security considerations
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class SerializationDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Serialization Demo ===");
        System.out.println();
        
        // 1. Basic Serialization
        demonstrateBasicSerialization();
        
        // 2. Serialization with Transient Fields
        demonstrateTransientFields();
        
        // 3. Custom Serialization
        demonstrateCustomSerialization();
        
        // 4. Serialization with Inheritance
        demonstrateInheritanceSerialization();
        
        // 5. Serialization with Collections
        demonstrateCollectionsSerialization();
        
        // 6. Version Control
        demonstrateVersionControl();
        
        // 7. Externalizable Interface
        demonstrateExternalizable();
        
        // 8. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 9. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic serialization
     */
    private static void demonstrateBasicSerialization() {
        System.out.println("1. Basic Serialization:");
        System.out.println("======================");
        
        // Create a simple serializable object
        Person person = new Person("John Doe", 30, "john.doe@example.com");
        System.out.println("Original person: " + person);
        
        try {
            // Serialize the object
            java.io.FileOutputStream fileOut = new java.io.FileOutputStream("person.ser");
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("Person serialized successfully to person.ser");
            
            // Deserialize the object
            java.io.FileInputStream fileIn = new java.io.FileInputStream("person.ser");
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(fileIn);
            Person deserializedPerson = (Person) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Person deserialized successfully from person.ser");
            System.out.println("Deserialized person: " + deserializedPerson);
            
            // Verify the objects are equal
            System.out.println("Objects are equal: " + person.equals(deserializedPerson));
            
        } catch (Exception e) {
            System.err.println("Serialization error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates serialization with transient fields
     */
    private static void demonstrateTransientFields() {
        System.out.println("2. Serialization with Transient Fields:");
        System.out.println("=====================================");
        
        // Create an object with transient fields
        User user = new User("Alice", "password123", "alice@example.com");
        System.out.println("Original user: " + user);
        
        try {
            // Serialize the object
            java.io.FileOutputStream fileOut = new java.io.FileOutputStream("user.ser");
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(fileOut);
            out.writeObject(user);
            out.close();
            fileOut.close();
            System.out.println("User serialized successfully to user.ser");
            
            // Deserialize the object
            java.io.FileInputStream fileIn = new java.io.FileInputStream("user.ser");
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(fileIn);
            User deserializedUser = (User) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("User deserialized successfully from user.ser");
            System.out.println("Deserialized user: " + deserializedUser);
            
            // Note: password field is transient, so it won't be serialized
            System.out.println("Password field is transient and not serialized");
            
        } catch (Exception e) {
            System.err.println("Serialization error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates custom serialization
     */
    private static void demonstrateCustomSerialization() {
        System.out.println("3. Custom Serialization:");
        System.out.println("=======================");
        
        // Create an object with custom serialization
        BankAccount account = new BankAccount("12345", "John Doe", 1000.0);
        System.out.println("Original account: " + account);
        
        try {
            // Serialize the object
            java.io.FileOutputStream fileOut = new java.io.FileOutputStream("account.ser");
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(fileOut);
            out.writeObject(account);
            out.close();
            fileOut.close();
            System.out.println("Account serialized successfully to account.ser");
            
            // Deserialize the object
            java.io.FileInputStream fileIn = new java.io.FileInputStream("account.ser");
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(fileIn);
            BankAccount deserializedAccount = (BankAccount) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Account deserialized successfully from account.ser");
            System.out.println("Deserialized account: " + deserializedAccount);
            
            // Note: Custom serialization methods were called
            System.out.println("Custom serialization methods were used");
            
        } catch (Exception e) {
            System.err.println("Serialization error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates serialization with inheritance
     */
    private static void demonstrateInheritanceSerialization() {
        System.out.println("4. Serialization with Inheritance:");
        System.out.println("=================================");
        
        // Create objects with inheritance
        Employee employee = new Employee("Jane Smith", 25, "jane@example.com", "Engineering", 75000);
        Manager manager = new Manager("Bob Johnson", 35, "bob@example.com", "Engineering", 100000, 5);
        
        System.out.println("Original employee: " + employee);
        System.out.println("Original manager: " + manager);
        
        try {
            // Serialize employee
            java.io.FileOutputStream fileOut = new java.io.FileOutputStream("employee.ser");
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(fileOut);
            out.writeObject(employee);
            out.close();
            fileOut.close();
            System.out.println("Employee serialized successfully");
            
            // Serialize manager
            fileOut = new java.io.FileOutputStream("manager.ser");
            out = new java.io.ObjectOutputStream(fileOut);
            out.writeObject(manager);
            out.close();
            fileOut.close();
            System.out.println("Manager serialized successfully");
            
            // Deserialize employee
            java.io.FileInputStream fileIn = new java.io.FileInputStream("employee.ser");
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(fileIn);
            Employee deserializedEmployee = (Employee) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Employee deserialized successfully");
            System.out.println("Deserialized employee: " + deserializedEmployee);
            
            // Deserialize manager
            fileIn = new java.io.FileInputStream("manager.ser");
            in = new java.io.ObjectInputStream(fileIn);
            Manager deserializedManager = (Manager) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Manager deserialized successfully");
            System.out.println("Deserialized manager: " + deserializedManager);
            
        } catch (Exception e) {
            System.err.println("Serialization error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates serialization with collections
     */
    private static void demonstrateCollectionsSerialization() {
        System.out.println("5. Serialization with Collections:");
        System.out.println("=================================");
        
        // Create a collection of serializable objects
        java.util.List<Person> people = new java.util.ArrayList<>();
        people.add(new Person("Alice", 25, "alice@example.com"));
        people.add(new Person("Bob", 30, "bob@example.com"));
        people.add(new Person("Charlie", 35, "charlie@example.com"));
        
        System.out.println("Original people list: " + people);
        
        try {
            // Serialize the collection
            java.io.FileOutputStream fileOut = new java.io.FileOutputStream("people.ser");
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(fileOut);
            out.writeObject(people);
            out.close();
            fileOut.close();
            System.out.println("People list serialized successfully");
            
            // Deserialize the collection
            java.io.FileInputStream fileIn = new java.io.FileInputStream("people.ser");
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(fileIn);
            @SuppressWarnings("unchecked")
            java.util.List<Person> deserializedPeople = (java.util.List<Person>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("People list deserialized successfully");
            System.out.println("Deserialized people list: " + deserializedPeople);
            
            // Verify the collections are equal
            System.out.println("Collections are equal: " + people.equals(deserializedPeople));
            
        } catch (Exception e) {
            System.err.println("Serialization error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates version control
     */
    private static void demonstrateVersionControl() {
        System.out.println("6. Version Control:");
        System.out.println("=================");
        
        // Create an object with version control
        Product product = new Product("Laptop", 999.99, "Electronics");
        System.out.println("Original product: " + product);
        
        try {
            // Serialize the object
            java.io.FileOutputStream fileOut = new java.io.FileOutputStream("product.ser");
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(fileOut);
            out.writeObject(product);
            out.close();
            fileOut.close();
            System.out.println("Product serialized successfully");
            
            // Deserialize the object
            java.io.FileInputStream fileIn = new java.io.FileInputStream("product.ser");
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(fileIn);
            Product deserializedProduct = (Product) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Product deserialized successfully");
            System.out.println("Deserialized product: " + deserializedProduct);
            
            // Show serial version UID
            System.out.println("Serial version UID: " + product.getClass().getDeclaredField("serialVersionUID").getLong(null));
            
        } catch (Exception e) {
            System.err.println("Serialization error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates Externalizable interface
     */
    private static void demonstrateExternalizable() {
        System.out.println("7. Externalizable Interface:");
        System.out.println("===========================");
        
        // Create an object implementing Externalizable
        Student student = new Student("John", 20, "Computer Science");
        System.out.println("Original student: " + student);
        
        try {
            // Serialize the object
            java.io.FileOutputStream fileOut = new java.io.FileOutputStream("student.ser");
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(fileOut);
            out.writeObject(student);
            out.close();
            fileOut.close();
            System.out.println("Student serialized successfully");
            
            // Deserialize the object
            java.io.FileInputStream fileIn = new java.io.FileInputStream("student.ser");
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(fileIn);
            Student deserializedStudent = (Student) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Student deserialized successfully");
            System.out.println("Deserialized student: " + deserializedStudent);
            
            // Note: Externalizable methods were called
            System.out.println("Externalizable methods were used");
            
        } catch (Exception e) {
            System.err.println("Serialization error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("8. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: Configuration object serialization
        System.out.println("Example 1: Configuration Object Serialization");
        System.out.println("--------------------------------------------");
        
        AppConfig config = new AppConfig("MyApp", "1.0.0", "localhost", 8080, true);
        System.out.println("Original config: " + config);
        
        try {
            // Serialize config
            java.io.FileOutputStream fileOut = new java.io.FileOutputStream("config.ser");
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(fileOut);
            out.writeObject(config);
            out.close();
            fileOut.close();
            System.out.println("Config serialized successfully");
            
            // Deserialize config
            java.io.FileInputStream fileIn = new java.io.FileInputStream("config.ser");
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(fileIn);
            AppConfig deserializedConfig = (AppConfig) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Config deserialized successfully");
            System.out.println("Deserialized config: " + deserializedConfig);
            
        } catch (Exception e) {
            System.err.println("Serialization error: " + e.getMessage());
        }
        
        // Example 2: Game state serialization
        System.out.println("\nExample 2: Game State Serialization");
        System.out.println("----------------------------------");
        
        GameState gameState = new GameState("Player1", 100, 3, "Level 1");
        System.out.println("Original game state: " + gameState);
        
        try {
            // Serialize game state
            java.io.FileOutputStream fileOut = new java.io.FileOutputStream("gamestate.ser");
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(fileOut);
            out.writeObject(gameState);
            out.close();
            fileOut.close();
            System.out.println("Game state serialized successfully");
            
            // Deserialize game state
            java.io.FileInputStream fileIn = new java.io.FileInputStream("gamestate.ser");
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(fileIn);
            GameState deserializedGameState = (GameState) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Game state deserialized successfully");
            System.out.println("Deserialized game state: " + deserializedGameState);
            
        } catch (Exception e) {
            System.err.println("Serialization error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("9. Best Practices:");
        System.out.println("=================");
        
        System.out.println("Serialization Best Practices:");
        System.out.println("---------------------------");
        System.out.println("1. Always declare serialVersionUID for version control");
        System.out.println("2. Use transient for sensitive or non-serializable fields");
        System.out.println("3. Implement custom serialization for complex objects");
        System.out.println("4. Consider using Externalizable for better control");
        System.out.println("5. Handle serialization exceptions properly");
        System.out.println("6. Be aware of security implications");
        System.out.println("7. Test serialization compatibility across versions");
        System.out.println("8. Use serialization for data persistence, not for deep copying");
        
        System.out.println("\nCommon Pitfalls:");
        System.out.println("---------------");
        System.out.println("• Forgetting to implement Serializable interface");
        System.out.println("• Not handling serialization exceptions");
        System.out.println("• Serializing sensitive data without encryption");
        System.out.println("• Not considering version compatibility");
        System.out.println("• Serializing non-serializable objects");
        
        System.out.println("\nSecurity Considerations:");
        System.out.println("----------------------");
        System.out.println("• Serialization can be a security risk");
        System.out.println("• Use transient for sensitive fields");
        System.out.println("• Consider using alternative serialization formats");
        System.out.println("• Validate deserialized objects");
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Serialization allows objects to be converted to byte streams");
        System.out.println("• Use Serializable interface for basic serialization");
        System.out.println("• Use transient keyword for non-serializable fields");
        System.out.println("• Implement custom serialization for complex objects");
        System.out.println("• Use Externalizable for complete control");
        System.out.println("• Always declare serialVersionUID for version control");
        System.out.println("• Handle exceptions and security considerations");
        System.out.println("• Test compatibility across different versions");
    }
    
    // Inner classes for demonstration
    
    static class Person implements java.io.Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private int age;
        private String email;
        
        public Person(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }
        
        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return age == person.age && 
                   java.util.Objects.equals(name, person.name) && 
                   java.util.Objects.equals(email, person.email);
        }
    }
    
    static class User implements java.io.Serializable {
        private static final long serialVersionUID = 1L;
        private String username;
        private transient String password; // Transient field
        private String email;
        
        public User(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }
        
        @Override
        public String toString() {
            return "User{username='" + username + "', password='" + 
                   (password != null ? "[PROTECTED]" : "null") + "', email='" + email + "'}";
        }
    }
    
    static class BankAccount implements java.io.Serializable {
        private static final long serialVersionUID = 1L;
        private String accountNumber;
        private String accountHolder;
        private double balance;
        
        public BankAccount(String accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }
        
        // Custom serialization
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            System.out.println("Custom writeObject called");
            out.defaultWriteObject();
        }
        
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
            System.out.println("Custom readObject called");
            in.defaultReadObject();
        }
        
        @Override
        public String toString() {
            return "BankAccount{accountNumber='" + accountNumber + "', accountHolder='" + 
                   accountHolder + "', balance=" + balance + "}";
        }
    }
    
    static class Employee extends Person {
        private static final long serialVersionUID = 1L;
        private String department;
        private double salary;
        
        public Employee(String name, int age, String email, String department, double salary) {
            super(name, age, email);
            this.department = department;
            this.salary = salary;
        }
        
        @Override
        public String toString() {
            return "Employee{" + super.toString() + ", department='" + department + "', salary=" + salary + "}";
        }
    }
    
    static class Manager extends Employee {
        private static final long serialVersionUID = 1L;
        private int teamSize;
        
        public Manager(String name, int age, String email, String department, double salary, int teamSize) {
            super(name, age, email, department, salary);
            this.teamSize = teamSize;
        }
        
        @Override
        public String toString() {
            return "Manager{" + super.toString() + ", teamSize=" + teamSize + "}";
        }
    }
    
    static class Product implements java.io.Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private double price;
        private String category;
        
        public Product(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }
        
        @Override
        public String toString() {
            return "Product{name='" + name + "', price=" + price + ", category='" + category + "'}";
        }
    }
    
    static class Student implements java.io.Externalizable {
        private static final long serialVersionUID = 1L;
        private String name;
        private int age;
        private String major;
        
        public Student() {
            // Default constructor required for Externalizable
        }
        
        public Student(String name, int age, String major) {
            this.name = name;
            this.age = age;
            this.major = major;
        }
        
        @Override
        public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException {
            System.out.println("Custom writeExternal called");
            out.writeObject(name);
            out.writeInt(age);
            out.writeObject(major);
        }
        
        @Override
        public void readExternal(java.io.ObjectInput in) throws java.io.IOException, ClassNotFoundException {
            System.out.println("Custom readExternal called");
            name = (String) in.readObject();
            age = in.readInt();
            major = (String) in.readObject();
        }
        
        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + ", major='" + major + "'}";
        }
    }
    
    static class AppConfig implements java.io.Serializable {
        private static final long serialVersionUID = 1L;
        private String appName;
        private String version;
        private String host;
        private int port;
        private boolean debug;
        
        public AppConfig(String appName, String version, String host, int port, boolean debug) {
            this.appName = appName;
            this.version = version;
            this.host = host;
            this.port = port;
            this.debug = debug;
        }
        
        @Override
        public String toString() {
            return "AppConfig{appName='" + appName + "', version='" + version + 
                   "', host='" + host + "', port=" + port + ", debug=" + debug + "}";
        }
    }
    
    static class GameState implements java.io.Serializable {
        private static final long serialVersionUID = 1L;
        private String playerName;
        private int score;
        private int level;
        private String currentLevel;
        
        public GameState(String playerName, int score, int level, String currentLevel) {
            this.playerName = playerName;
            this.score = score;
            this.level = level;
            this.currentLevel = currentLevel;
        }
        
        @Override
        public String toString() {
            return "GameState{playerName='" + playerName + "', score=" + score + 
                   ", level=" + level + ", currentLevel='" + currentLevel + "'}";
        }
    }
}
