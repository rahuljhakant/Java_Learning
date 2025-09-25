# 🔧 Java Basics - Variables, Data Types, and Operators

This section covers the fundamental building blocks of Java programming. You'll learn about variables, data types, operators, and type casting - the essential concepts that form the foundation of all Java programs.

## 🎯 Learning Objectives

By the end of this section, you will:
- ✅ Understand all Java data types (primitive and reference)
- ✅ Declare and initialize variables correctly
- ✅ Use all types of operators effectively
- ✅ Perform type casting safely
- ✅ Understand variable scope and lifetime
- ✅ Work with constants and literals

## 📚 Tutorial Files

### VariablesDemo.java
**Purpose**: Comprehensive guide to variables and data types in Java

**Key Topics Covered**:
- Primitive data types (byte, short, int, long, float, double, char, boolean)
- Reference data types (String, Arrays, Objects)
- Variable declaration and initialization
- Variable scope (local, instance, static)
- Constants and final variables
- Type conversion (implicit and explicit)
- Literals and their usage

**Learning Outcomes**:
- Master all 8 primitive data types
- Understand memory allocation for different types
- Know when to use each data type
- Apply proper variable naming conventions
- Use constants effectively

### OperatorsDemo.java
**Purpose**: Complete guide to all Java operators

**Key Topics Covered**:
- Arithmetic operators (+, -, *, /, %, ++, --)
- Relational operators (==, !=, <, >, <=, >=)
- Logical operators (&&, ||, !)
- Bitwise operators (&, |, ^, ~, <<, >>, >>>)
- Assignment operators (=, +=, -=, *=, /=, %=)
- Ternary operator (condition ? true : false)
- Operator precedence and associativity

**Learning Outcomes**:
- Use all arithmetic operators correctly
- Apply logical operators for decision making
- Understand bitwise operations
- Know operator precedence rules
- Use compound assignment operators

### TypeCastingDemo.java
**Purpose**: Understanding type conversion in Java

**Key Topics Covered**:
- Implicit type casting (widening conversion)
- Explicit type casting (narrowing conversion)
- Data loss in type conversion
- String to number conversion
- Number to string conversion
- Safe type casting practices

**Learning Outcomes**:
- Perform safe type conversions
- Understand when data loss occurs
- Convert between different number types
- Handle string conversions properly
- Avoid common casting errors

## 🔧 Key Concepts

### Primitive Data Types

| Type | Size | Range | Default Value | Example |
|------|------|-------|---------------|---------|
| byte | 8 bits | -128 to 127 | 0 | byte b = 100; |
| short | 16 bits | -32,768 to 32,767 | 0 | short s = 1000; |
| int | 32 bits | -2³¹ to 2³¹-1 | 0 | int i = 100000; |
| long | 64 bits | -2⁶³ to 2⁶³-1 | 0L | long l = 1000000L; |
| float | 32 bits | IEEE 754 | 0.0f | float f = 3.14f; |
| double | 64 bits | IEEE 754 | 0.0d | double d = 3.14159; |
| char | 16 bits | 0 to 65,535 | '\u0000' | char c = 'A'; |
| boolean | 1 bit | true/false | false | boolean b = true; |

### Reference Data Types
- **String**: Sequence of characters
- **Arrays**: Collection of elements of the same type
- **Objects**: Instances of classes
- **Interfaces**: Contracts for classes

### Variable Scope
1. **Local Variables**: Declared inside methods, constructors, or blocks
2. **Instance Variables**: Declared inside a class but outside methods
3. **Static Variables**: Shared among all instances of a class

### Operator Categories

#### Arithmetic Operators
```java
int a = 10, b = 3;
int sum = a + b;        // 13
int diff = a - b;       // 7
int product = a * b;    // 30
int quotient = a / b;   // 3
int remainder = a % b;  // 1
```

#### Relational Operators
```java
int a = 10, b = 5;
boolean isEqual = (a == b);      // false
boolean isNotEqual = (a != b);   // true
boolean isGreater = (a > b);     // true
boolean isLess = (a < b);        // false
```

#### Logical Operators
```java
boolean x = true, y = false;
boolean and = x && y;    // false
boolean or = x || y;     // true
boolean not = !x;        // false
```

## 🚀 Hands-On Practice

### Exercise 1: Variable Declaration
Create a program that declares variables of all primitive types and displays their values.

### Exercise 2: Calculator Operations
Write a program that performs all arithmetic operations on two numbers and displays the results.

### Exercise 3: Type Conversion
Create a program that demonstrates:
- Implicit conversion from int to double
- Explicit conversion from double to int
- String to number conversion
- Number to string conversion

### Exercise 4: Operator Precedence
Write a program that demonstrates operator precedence by calculating complex expressions.

## 🎯 Common Scenarios

### Scenario 1: Choosing the Right Data Type
```java
// For small numbers: byte or short
byte age = 25;
short year = 2024;

// For whole numbers: int (most common)
int population = 1000000;

// For large numbers: long
long worldPopulation = 8000000000L;

// For decimal numbers: double (most common)
double price = 19.99;

// For single characters: char
char grade = 'A';

// For true/false: boolean
boolean isStudent = true;
```

### Scenario 2: Safe Type Casting
```java
// Safe: widening conversion
int intValue = 100;
double doubleValue = intValue;  // Automatic

// Careful: narrowing conversion
double doubleValue = 3.14;
int intValue = (int) doubleValue;  // Explicit cast, loses decimal part
```

### Scenario 3: String Operations
```java
String firstName = "John";
String lastName = "Doe";
String fullName = firstName + " " + lastName;  // Concatenation
int length = fullName.length();                // Get length
```

## 🚨 Common Issues and Solutions

### Issue 1: Data Type Overflow
```java
// Problem: byte overflow
byte b = 127;
b++;  // Results in -128 (overflow)

// Solution: Use appropriate data type
int i = 127;
i++;  // Results in 128 (correct)
```

### Issue 2: Division by Zero
```java
// Problem: Division by zero
int a = 10, b = 0;
int result = a / b;  // ArithmeticException

// Solution: Check for zero
if (b != 0) {
    int result = a / b;
} else {
    System.out.println("Cannot divide by zero");
}
```

### Issue 3: String vs Number Comparison
```java
// Problem: Comparing string and number
String str = "123";
int num = 123;
boolean equal = (str == num);  // Compilation error

// Solution: Convert to same type
boolean equal = str.equals(String.valueOf(num));  // true
```

## 📊 Progress Checklist

- [ ] Understand all 8 primitive data types
- [ ] Know the size and range of each data type
- [ ] Declare variables with appropriate data types
- [ ] Use all arithmetic operators correctly
- [ ] Apply relational operators for comparisons
- [ ] Use logical operators for complex conditions
- [ ] Understand operator precedence
- [ ] Perform safe type casting
- [ ] Convert between strings and numbers
- [ ] Use constants and final variables
- [ ] Understand variable scope

## 🔗 Next Steps

After completing this section, you're ready for:
- **Control Statements**: Making decisions with if-else and switch
- **Loops**: Repeating code with for, while, and do-while
- **OOP Basics**: Creating classes and objects

## 📚 Additional Resources

- [Java Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
- [Java Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)
- [Variable Scope in Java](https://docs.oracle.com/javase/tutorial/java/javaOO/variables.html)

## Author

**Created by: Rahul Kant Jha**
- Comprehensive Java Basics Tutorial
- Industry-standard implementations with detailed explanations
- Real-world applications and best practices

---

**Master the basics, and you'll build a strong foundation for advanced Java programming! 🚀**


