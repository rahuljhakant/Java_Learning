# 🎛️ Control Statements - Making Decisions and Loops

Control statements are the backbone of program logic. They allow your programs to make decisions, repeat actions, and control the flow of execution. This section covers all the essential control structures in Java.

## 🎯 Learning Objectives

By the end of this section, you will:
- ✅ Use conditional statements to make decisions
- ✅ Apply different types of loops effectively
- ✅ Control loop execution with break and continue
- ✅ Use nested control structures
- ✅ Handle complex decision-making scenarios
- ✅ Optimize loop performance

## 📚 Tutorial Files

### ConditionalStatements.java
**Purpose**: Complete guide to decision-making in Java

**Key Topics Covered**:
- if statement (simple decision)
- if-else statement (binary decision)
- if-else-if ladder (multiple conditions)
- Nested if statements
- switch statement (multiple choice)
- switch expressions (Java 14+)
- Ternary operator (conditional expression)
- Best practices for conditional statements

**Learning Outcomes**:
- Write clear and efficient conditional logic
- Choose the right conditional structure for each scenario
- Handle multiple conditions effectively
- Use switch statements for multiple choices
- Apply ternary operators for simple conditions

### LoopsDemo.java
**Purpose**: Comprehensive guide to loops in Java

**Key Topics Covered**:
- for loop (definite iteration)
- Enhanced for loop (for-each loop)
- while loop (indefinite iteration)
- do-while loop (execute at least once)
- Nested loops
- Loop control and optimization
- Common loop patterns
- Performance considerations

**Learning Outcomes**:
- Choose the appropriate loop type for each situation
- Write efficient loops
- Handle nested iterations
- Use enhanced for loops with collections
- Optimize loop performance

### BreakContinueDemo.java
**Purpose**: Controlling loop execution flow

**Key Topics Covered**:
- break statement (exit loop immediately)
- continue statement (skip current iteration)
- Labeled break and continue
- Nested loop control
- Practical use cases
- Best practices for loop control

**Learning Outcomes**:
- Control loop execution precisely
- Use break and continue effectively
- Handle complex nested loop scenarios
- Apply labeled statements when needed
- Write clean and readable loop control code

## 🔧 Key Concepts

### Conditional Statements

#### if Statement
```java
if (condition) {
    // Code to execute if condition is true
}
```

#### if-else Statement
```java
if (condition) {
    // Code if condition is true
} else {
    // Code if condition is false
}
```

#### if-else-if Ladder
```java
if (condition1) {
    // Code for condition1
} else if (condition2) {
    // Code for condition2
} else if (condition3) {
    // Code for condition3
} else {
    // Default code
}
```

#### Switch Statement
```java
switch (variable) {
    case value1:
        // Code for value1
        break;
    case value2:
        // Code for value2
        break;
    default:
        // Default code
}
```

### Loop Structures

#### for Loop
```java
for (initialization; condition; increment) {
    // Loop body
}
```

#### Enhanced for Loop
```java
for (dataType variable : collection) {
    // Loop body
}
```

#### while Loop
```java
while (condition) {
    // Loop body
}
```

#### do-while Loop
```java
do {
    // Loop body
} while (condition);
```

### Loop Control

#### break Statement
```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break;  // Exit loop when i equals 5
    }
    System.out.println(i);
}
```

#### continue Statement
```java
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) {
        continue;  // Skip even numbers
    }
    System.out.println(i);
}
```

#### Labeled Statements
```java
outer: for (int i = 0; i < 3; i++) {
    inner: for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) {
            break outer;  // Break outer loop
        }
    }
}
```

## 🚀 Hands-On Practice

### Exercise 1: Grade Calculator
Create a program that:
1. Takes a student's score as input
2. Uses if-else-if ladder to assign grades (A, B, C, D, F)
3. Displays the grade and corresponding message

### Exercise 2: Number Patterns
Write programs to print:
1. Right triangle pattern
2. Inverted triangle pattern
3. Diamond pattern
4. Number pyramid

### Exercise 3: Menu-Driven Program
Create a calculator program with:
1. Menu options (Add, Subtract, Multiply, Divide)
2. Switch statement for operation selection
3. Loop to continue until user chooses to exit

### Exercise 4: Prime Number Checker
Write a program that:
1. Takes a number as input
2. Uses loops to check if it's prime
3. Uses break to optimize the checking process

### Exercise 5: Array Processing
Create a program that:
1. Declares an array of numbers
2. Uses enhanced for loop to find sum, average, max, min
3. Uses continue to skip negative numbers

## 🎯 Common Scenarios

### Scenario 1: User Input Validation
```java
Scanner scanner = new Scanner(System.in);
int age;

do {
    System.out.print("Enter your age (1-120): ");
    age = scanner.nextInt();
    
    if (age < 1 || age > 120) {
        System.out.println("Invalid age! Please try again.");
    }
} while (age < 1 || age > 120);
```

### Scenario 2: Menu System
```java
int choice;
do {
    System.out.println("1. Add");
    System.out.println("2. Subtract");
    System.out.println("3. Exit");
    System.out.print("Enter choice: ");
    choice = scanner.nextInt();
    
    switch (choice) {
        case 1:
            // Add operation
            break;
        case 2:
            // Subtract operation
            break;
        case 3:
            System.out.println("Goodbye!");
            break;
        default:
            System.out.println("Invalid choice!");
    }
} while (choice != 3);
```

### Scenario 3: Data Processing
```java
int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int sum = 0;
int count = 0;

for (int num : numbers) {
    if (num % 2 == 0) {
        continue;  // Skip even numbers
    }
    sum += num;
    count++;
}
```

## 🚨 Common Issues and Solutions

### Issue 1: Infinite Loops
```java
// Problem: Missing increment
int i = 0;
while (i < 10) {
    System.out.println(i);
    // Missing i++
}

// Solution: Add increment
int i = 0;
while (i < 10) {
    System.out.println(i);
    i++;
}
```

### Issue 2: Missing Break in Switch
```java
// Problem: Fall-through behavior
switch (day) {
    case 1:
        System.out.println("Monday");
        // Missing break
    case 2:
        System.out.println("Tuesday");
        break;
}

// Solution: Add break statements
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
}
```

### Issue 3: Incorrect Loop Condition
```java
// Problem: Off-by-one error
for (int i = 1; i <= 10; i++) {
    // This runs 10 times, not 9
}

// Solution: Use appropriate bounds
for (int i = 0; i < 10; i++) {
    // This runs 10 times (0 to 9)
}
```

## 📊 Progress Checklist

- [ ] Write if statements for simple decisions
- [ ] Use if-else for binary decisions
- [ ] Apply if-else-if for multiple conditions
- [ ] Use switch statements for multiple choices
- [ ] Write for loops for definite iteration
- [ ] Use while loops for indefinite iteration
- [ ] Apply do-while loops when needed
- [ ] Use enhanced for loops with arrays
- [ ] Control loops with break and continue
- [ ] Handle nested control structures
- [ ] Write efficient and readable control logic

## 🔗 Next Steps

After completing this section, you're ready for:
- **OOP Basics**: Creating classes and objects
- **Methods**: Defining reusable code blocks
- **Arrays**: Working with collections of data

## 📚 Additional Resources

- [Java Control Flow Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)
- [The for Statement](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html)
- [The while and do-while Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html)

## Author

**Created by: Rahul Kant Jha**
- Comprehensive Control Statements Tutorial
- Industry-standard implementations with detailed explanations
- Real-world applications and best practices

---

**Master control flow, and you'll have the power to create dynamic and interactive programs! 🚀**


