# 🏗️ OOP Basics - Object-Oriented Programming Fundamentals

Object-Oriented Programming (OOP) is a programming paradigm that organizes code into objects that contain both data and methods. This section introduces you to the fundamental concepts of OOP in Java.

## 🎯 Learning Objectives

By the end of this section, you will:
- ✅ Understand the principles of Object-Oriented Programming
- ✅ Create classes and objects
- ✅ Use constructors effectively
- ✅ Define and call methods
- ✅ Apply access modifiers correctly
- ✅ Use static members appropriately
- ✅ Understand encapsulation and data hiding

## 📚 Tutorial Files

### ClassesAndObjects.java
**Purpose**: Introduction to classes and objects in Java

**Key Topics Covered**:
- Class definition and structure
- Object creation and instantiation
- Instance variables and methods
- Object references and memory
- Constructor basics
- Method calling and parameters
- Object lifecycle

**Learning Outcomes**:
- Define classes with proper structure
- Create objects using the new keyword
- Understand the difference between classes and objects
- Access instance members through objects
- Understand object references and memory allocation

### ConstructorsDemo.java
**Purpose**: Complete guide to constructors in Java

**Key Topics Covered**:
- Default constructor
- Parameterized constructor
- Constructor overloading
- Constructor chaining with this()
- Copy constructor
- Constructor best practices
- Common constructor patterns

**Learning Outcomes**:
- Create different types of constructors
- Use constructor overloading effectively
- Implement constructor chaining
- Understand constructor execution order
- Apply constructor best practices

### MethodsDemo.java
**Purpose**: Comprehensive guide to methods in Java

**Key Topics Covered**:
- Method definition and syntax
- Method parameters and return types
- Method overloading
- Method calling and invocation
- Parameter passing (by value)
- Method visibility and scope
- Static vs instance methods

**Learning Outcomes**:
- Define methods with proper signatures
- Use method overloading effectively
- Understand parameter passing mechanisms
- Call methods correctly
- Choose between static and instance methods

### AccessModifiersDemo.java
**Purpose**: Understanding access control in Java

**Key Topics Covered**:
- public access modifier
- private access modifier
- protected access modifier
- default (package-private) access
- Access modifier rules and restrictions
- Best practices for access control
- Encapsulation principles

**Learning Outcomes**:
- Apply appropriate access modifiers
- Understand encapsulation principles
- Control access to class members
- Follow access modifier best practices
- Implement data hiding effectively

### StaticKeywordDemo.java
**Purpose**: Understanding static members in Java

**Key Topics Covered**:
- Static variables (class variables)
- Static methods (class methods)
- Static blocks
- Static nested classes
- Static import
- Memory allocation for static members
- When to use static members

**Learning Outcomes**:
- Use static variables effectively
- Create and call static methods
- Understand static block execution
- Know when to use static members
- Understand memory implications of static

## 🔧 Key Concepts

### Object-Oriented Programming Principles

#### 1. Encapsulation
- Bundling data and methods together
- Data hiding through access modifiers
- Controlled access to object state

#### 2. Abstraction
- Hiding complex implementation details
- Showing only essential features
- Creating simple interfaces

#### 3. Inheritance
- Creating new classes based on existing ones
- Code reuse and extension
- "is-a" relationship

#### 4. Polymorphism
- Same interface, different implementations
- Method overriding and overloading
- Runtime and compile-time polymorphism

### Class Structure
```java
public class ClassName {
    // Static variables
    private static int classCounter = 0;
    
    // Instance variables
    private String name;
    private int age;
    
    // Static block
    static {
        // Static initialization code
    }
    
    // Constructors
    public ClassName() {
        // Default constructor
    }
    
    public ClassName(String name, int age) {
        // Parameterized constructor
        this.name = name;
        this.age = age;
    }
    
    // Static methods
    public static void staticMethod() {
        // Static method implementation
    }
    
    // Instance methods
    public void instanceMethod() {
        // Instance method implementation
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
```

### Access Modifiers

| Modifier | Class | Package | Subclass | World |
|----------|-------|---------|----------|-------|
| public | ✓ | ✓ | ✓ | ✓ |
| protected | ✓ | ✓ | ✓ | ✗ |
| default | ✓ | ✓ | ✗ | ✗ |
| private | ✓ | ✗ | ✗ | ✗ |

### Constructor Types

#### Default Constructor
```java
public class Student {
    public Student() {
        // Default constructor
    }
}
```

#### Parameterized Constructor
```java
public class Student {
    private String name;
    private int age;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

#### Constructor Chaining
```java
public class Student {
    private String name;
    private int age;
    private String course;
    
    public Student() {
        this("Unknown", 0);
    }
    
    public Student(String name, int age) {
        this(name, age, "General");
    }
    
    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }
}
```

## 🚀 Hands-On Practice

### Exercise 1: Bank Account Class
Create a BankAccount class with:
1. Private fields: accountNumber, balance, accountHolder
2. Constructor to initialize account
3. Methods: deposit(), withdraw(), getBalance()
4. Proper encapsulation with getters/setters

### Exercise 2: Student Management System
Create a Student class with:
1. Fields: name, rollNumber, marks (array)
2. Methods: calculateAverage(), getGrade(), displayInfo()
3. Static method to get total number of students
4. Constructor overloading

### Exercise 3: Calculator Class
Create a Calculator class with:
1. Static methods for basic operations (add, subtract, multiply, divide)
2. Instance methods for advanced operations
3. Static variable to track operation count
4. Method overloading for different parameter types

### Exercise 4: Library Book Class
Create a Book class with:
1. Fields: title, author, isbn, isAvailable
2. Methods: borrow(), return(), displayInfo()
3. Static method to get total books in library
4. Proper access control

## 🎯 Common Scenarios

### Scenario 1: Object Creation and Usage
```java
// Create objects
Student student1 = new Student("John", 20);
Student student2 = new Student("Jane", 22, "Computer Science");

// Access methods
student1.displayInfo();
double average = student2.calculateAverage();

// Access static members
int totalStudents = Student.getTotalStudents();
```

### Scenario 2: Encapsulation
```java
public class BankAccount {
    private double balance;
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
    
    public double getBalance() {
        return balance;
    }
}
```

### Scenario 3: Static vs Instance
```java
public class MathUtils {
    // Static method - belongs to class
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }
    
    // Instance method - belongs to object
    private double precision;
    
    public MathUtils(double precision) {
        this.precision = precision;
    }
    
    public double calculateAreaWithPrecision(double radius) {
        return Math.round(calculateArea(radius) * precision) / precision;
    }
}
```

## 🚨 Common Issues and Solutions

### Issue 1: Null Pointer Exception
```java
// Problem: Accessing methods on null object
Student student = null;
student.getName();  // NullPointerException

// Solution: Check for null
if (student != null) {
    String name = student.getName();
}
```

### Issue 2: Accessing Private Members
```java
// Problem: Direct access to private fields
public class Student {
    private String name;
}

Student s = new Student();
s.name = "John";  // Compilation error

// Solution: Use public methods
public class Student {
    private String name;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
```

### Issue 3: Static vs Instance Confusion
```java
// Problem: Accessing instance members from static context
public class Student {
    private String name;
    
    public static void displayInfo() {
        System.out.println(name);  // Compilation error
    }
}

// Solution: Use instance methods or pass object
public class Student {
    private String name;
    
    public void displayInfo() {
        System.out.println(name);
    }
    
    public static void displayInfo(Student student) {
        System.out.println(student.name);
    }
}
```

## 📊 Progress Checklist

- [ ] Understand OOP principles
- [ ] Create classes with proper structure
- [ ] Instantiate objects using constructors
- [ ] Define and call methods
- [ ] Use constructor overloading
- [ ] Implement constructor chaining
- [ ] Apply appropriate access modifiers
- [ ] Use static variables and methods
- [ ] Understand encapsulation
- [ ] Create getter and setter methods
- [ ] Handle object references properly

## 🔗 Next Steps

After completing this section, you're ready for:
- **Advanced OOP Concepts**: Inheritance, polymorphism, abstraction
- **Interfaces**: Defining contracts for classes
- **Exception Handling**: Managing errors and exceptions

## 📚 Additional Resources

- [Java Classes and Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/)
- [Java Access Control](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
- [Java Static Members](https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html)

## Author

**Created by: Rahul Kant Jha**
- Comprehensive OOP Basics Tutorial
- Industry-standard implementations with detailed explanations
- Real-world applications and best practices

---

**Master OOP basics, and you'll be ready to build complex, maintainable applications! 🚀**


