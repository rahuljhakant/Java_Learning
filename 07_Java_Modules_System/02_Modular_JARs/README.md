# 📦 Modular JARs - Building and Deploying Java Modules

This section covers creating modular JARs, using the module path, and building modular applications with modern build tools.

## 🎯 Learning Objectives

- ✅ Create modular JAR files
- ✅ Use the module path effectively
- ✅ Build modular applications with Maven/Gradle
- ✅ Understand module resolution
- ✅ Deploy modular applications

## 📚 Tutorial Files

### ModularJarDemo.java
**Purpose**: Demonstrates creating and using modular JARs

**Key Topics**:
- Creating modular JAR files
- Module path vs classpath
- Building modular applications
- Module resolution process

### ModulePathDemo.java
**Purpose**: Understanding the module path system

**Key Topics**:
- Module path configuration
- Module resolution order
- Automatic modules
- Multi-release JARs

## 🔧 Key Concepts

### Creating Modular JARs
```bash
# Compile with module path
javac --module-path mods -d out src/module-info.java src/com/example/*.java

# Create modular JAR
jar --create --file mods/com.example@1.0.jar -C out .
```

### Module Path Usage
```bash
# Run with module path
java --module-path mods --module com.example/com.example.Main
```

## 🚀 Hands-On Practice

### Exercise 1: Create Modular JAR
Create a simple module and package it as a modular JAR.

### Exercise 2: Multi-Module Application
Build an application with multiple modules and dependencies.

## Author

**Created by: Rahul Kant Jha**
- Comprehensive Modular JARs Tutorial
- Industry-standard implementations with detailed explanations

---

**Master modular JARs for modern Java development! 🚀**


