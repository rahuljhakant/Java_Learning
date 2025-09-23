# Intermediate Level - Java Tutorial

Welcome to the Intermediate Level of the Java Tutorial! This section builds upon the foundational concepts learned in the Beginner Level and introduces more advanced Java programming concepts.

## 📚 Learning Objectives

By the end of this level, you will be able to:
- ✅ Handle exceptions properly in your applications
- ✅ Work with Java Collections Framework effectively
- ✅ Perform file I/O operations
- ✅ Understand advanced OOP concepts
- ✅ Build more complex applications

## 🗂️ Topics Covered

### 1. Exception Handling
- **Basic Exceptions**: try-catch blocks, finally blocks, exception hierarchy
- **Custom Exceptions**: Creating your own exception classes
- **Best Practices**: Proper exception handling strategies

### 2. Collections Framework
- **List Interface**: ArrayList, LinkedList, Vector, Stack
- **Set Interface**: HashSet, LinkedHashSet, TreeSet
- **Map Interface**: HashMap, LinkedHashMap, TreeMap, Hashtable
- **Iterators**: Iterator, ListIterator, enhanced for loops
- **Comparable & Comparator**: Sorting and comparing objects

### 3. Java I/O
- **File Operations**: Reading and writing files
- **Streams**: Input/Output streams
- **Serialization**: Object serialization and deserialization
- **NIO**: New I/O features

## 📁 Directory Structure

```
02_Intermediate_Level/
├── 01_Advanced_OOP_Concepts/
│   ├── InheritanceDemo.java
│   ├── PolymorphismDemo.java
│   ├── AbstractionDemo.java
│   ├── InterfacesDemo.java
│   ├── EncapsulationDemo.java
│   └── README.md
├── 02_Arrays_Strings/
│   ├── ArraysDemo.java
│   ├── StringDemo.java
│   ├── StringBuilderDemo.java
│   └── README.md
├── 03_Exception_Handling/
│   ├── BasicExceptions.java
│   ├── CustomExceptions.java
│   ├── ExceptionHierarchy.java
│   └── README.md
├── 04_Collections_Framework/
│   ├── ListDemo.java
│   ├── SetDemo.java
│   ├── MapDemo.java
│   ├── IteratorDemo.java
│   ├── ComparableDemo.java
│   ├── ComparatorDemo.java
│   └── README.md
├── 05_Java_IO/
│   ├── FileOperations.java
│   ├── SerializationDemo.java
│   ├── StreamsDemo.java
│   └── README.md
└── README.md (this file)
```

## 🚀 Getting Started

1. **Prerequisites**: Complete the Beginner Level topics
2. **Start with**: Exception Handling (03_Exception_Handling)
3. **Progress through**: Collections Framework → Java I/O
4. **Practice**: Complete all code examples and exercises

## 📖 Learning Path

### Week 1-2: Exception Handling
- Learn about different types of exceptions
- Practice with try-catch-finally blocks
- Create custom exception classes
- Understand exception hierarchy

### Week 3-4: Collections Framework
- Master List, Set, and Map interfaces
- Understand when to use which collection
- Practice with iterators and comparators
- Learn about performance characteristics

### Week 5-6: Java I/O
- Learn file reading and writing
- Understand streams and serialization
- Practice with NIO features
- Build file processing applications

## 💡 Key Concepts

### Exception Handling
```java
try {
    // Code that might throw an exception
    riskyOperation();
} catch (SpecificException e) {
    // Handle specific exception
    System.out.println("Specific error: " + e.getMessage());
} catch (Exception e) {
    // Handle general exception
    System.out.println("General error: " + e.getMessage());
} finally {
    // Cleanup code (always executes)
    cleanup();
}
```

### Collections Framework
```java
// List example
List<String> list = new ArrayList<>();
list.add("Item 1");
list.add("Item 2");

// Set example
Set<String> set = new HashSet<>();
set.add("Unique Item");

// Map example
Map<String, Integer> map = new HashMap<>();
map.put("Key", 42);
```

### File I/O
```java
// Reading a file
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

## 🎯 Practice Exercises

### Exception Handling
1. Create a custom exception for invalid user input
2. Implement a method that handles multiple exception types
3. Build a file reader with proper exception handling

### Collections Framework
1. Implement a student management system using Lists
2. Create a word frequency counter using Maps
3. Build a unique item tracker using Sets

### Java I/O
1. Create a file backup utility
2. Implement a log file analyzer
3. Build a configuration file reader

## 🔧 Tools and Resources

- **IDE**: IntelliJ IDEA, Eclipse, or VS Code
- **Java Version**: Java 17 or higher
- **Build Tool**: Maven or Gradle
- **Testing**: JUnit for unit testing

## 📚 Additional Resources

- [Oracle Java Collections Tutorial](https://docs.oracle.com/javase/tutorial/collections/)
- [Oracle Java I/O Tutorial](https://docs.oracle.com/javase/tutorial/essential/io/)
- [Exception Handling Best Practices](https://docs.oracle.com/javase/tutorial/essential/exceptions/)

## 🎓 Assessment

After completing this level, you should be able to:
- [ ] Handle exceptions properly in your code
- [ ] Choose appropriate collection types for different scenarios
- [ ] Read and write files effectively
- [ ] Implement custom exception classes
- [ ] Use iterators and comparators
- [ ] Work with file metadata and directories

## 🚀 Next Steps

After completing the Intermediate Level, you'll be ready for:
- **Advanced Level**: Multithreading, Networking, Java 8+ Features
- **Project Development**: Building real-world applications
- **Framework Learning**: Spring, Hibernate, etc.

---

**Happy Learning! 🎉**

Remember to practice regularly and build small projects to reinforce your learning. Each concept builds upon the previous ones, so make sure you understand each topic before moving to the next.
