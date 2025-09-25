package com.tutorial.advanced.concepts;

import java.lang.reflect.*;
import java.util.*;

/**
 * Reflection Demo - Runtime Class Inspection
 * 
 * This comprehensive tutorial demonstrates Java Reflection API,
 * including class inspection, method and field access,
 * dynamic object creation, and reflection security.
 * 
 * LEARNING OBJECTIVES:
 * - Understand reflection concepts and capabilities
 * - Inspect classes, methods, and fields at runtime
 * - Create objects dynamically using reflection
 * - Access and modify private members
 * - Apply reflection best practices
 * - Handle reflection security considerations
 * 
 * KEY CONCEPTS:
 * 1. Class Inspection: Examining class structure at runtime
 * 2. Method Access: Invoking methods dynamically
 * 3. Field Access: Reading and writing fields
 * 4. Object Creation: Creating instances dynamically
 * 5. Security: Reflection security considerations
 * 6. Best Practices: Effective reflection usage
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class ReflectionDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Reflection Demo ===");
        System.out.println();
        
        // 1. Class Inspection
        demonstrateClassInspection();
        
        // 2. Method Access
        demonstrateMethodAccess();
        
        // 3. Field Access
        demonstrateFieldAccess();
        
        // 4. Object Creation
        demonstrateObjectCreation();
        
        // 5. Constructor Access
        demonstrateConstructorAccess();
        
        // 6. Security Considerations
        demonstrateSecurityConsiderations();
        
        // 7. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates class inspection
     */
    private static void demonstrateClassInspection() {
        System.out.println("1. Class Inspection:");
        System.out.println("==================");
        
        try {
            // Get class object
            Class<?> clazz = Person.class;
            
            System.out.println("Class Name: " + clazz.getName());
            System.out.println("Simple Name: " + clazz.getSimpleName());
            System.out.println("Package: " + clazz.getPackage());
            System.out.println("Superclass: " + clazz.getSuperclass());
            System.out.println("Interfaces: " + Arrays.toString(clazz.getInterfaces()));
            System.out.println("Modifiers: " + Modifier.toString(clazz.getModifiers()));
            
            // Get declared methods
            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("\nDeclared Methods:");
            for (Method method : methods) {
                System.out.println("  " + method.getName() + " - " + 
                                 Modifier.toString(method.getModifiers()));
            }
            
            // Get declared fields
            Field[] fields = clazz.getDeclaredFields();
            System.out.println("\nDeclared Fields:");
            for (Field field : fields) {
                System.out.println("  " + field.getName() + " - " + 
                                 Modifier.toString(field.getModifiers()));
            }
            
            // Get constructors
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println("  " + constructor.getName() + " - " + 
                                 Modifier.toString(constructor.getModifiers()));
            }
            
        } catch (Exception e) {
            System.err.println("Class inspection error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates method access
     */
    private static void demonstrateMethodAccess() {
        System.out.println("2. Method Access:");
        System.out.println("===============");
        
        try {
            Person person = new Person("John", 30);
            Class<?> clazz = person.getClass();
            
            // Get public method
            Method getNameMethod = clazz.getMethod("getName");
            String name = (String) getNameMethod.invoke(person);
            System.out.println("Name (via reflection): " + name);
            
            // Get method with parameters
            Method setAgeMethod = clazz.getMethod("setAge", int.class);
            setAgeMethod.invoke(person, 35);
            System.out.println("Age after setting (via reflection): " + person.getAge());
            
            // Get private method
            Method privateMethod = clazz.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(person);
            
            // Get static method
            Method staticMethod = clazz.getMethod("staticMethod");
            staticMethod.invoke(null);
            
        } catch (Exception e) {
            System.err.println("Method access error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates field access
     */
    private static void demonstrateFieldAccess() {
        System.out.println("3. Field Access:");
        System.out.println("===============");
        
        try {
            Person person = new Person("Jane", 25);
            Class<?> clazz = person.getClass();
            
            // Get public field
            Field nameField = clazz.getField("name");
            String name = (String) nameField.get(person);
            System.out.println("Name (via reflection): " + name);
            
            // Set public field
            nameField.set(person, "Jane Doe");
            System.out.println("Name after setting (via reflection): " + person.getName());
            
            // Get private field
            Field ageField = clazz.getDeclaredField("age");
            ageField.setAccessible(true);
            int age = (int) ageField.get(person);
            System.out.println("Age (via reflection): " + age);
            
            // Set private field
            ageField.set(person, 30);
            System.out.println("Age after setting (via reflection): " + person.getAge());
            
        } catch (Exception e) {
            System.err.println("Field access error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates object creation
     */
    private static void demonstrateObjectCreation() {
        System.out.println("4. Object Creation:");
        System.out.println("==================");
        
        try {
            Class<?> clazz = Person.class;
            
            // Create object using default constructor
            Constructor<?> defaultConstructor = clazz.getDeclaredConstructor();
            Person person1 = (Person) defaultConstructor.newInstance();
            System.out.println("Person created with default constructor: " + person1);
            
            // Create object using parameterized constructor
            Constructor<?> paramConstructor = clazz.getDeclaredConstructor(String.class, int.class);
            Person person2 = (Person) paramConstructor.newInstance("Bob", 40);
            System.out.println("Person created with parameterized constructor: " + person2);
            
            // Create object using Class.newInstance() (deprecated)
            Person person3 = (Person) clazz.newInstance();
            System.out.println("Person created with newInstance(): " + person3);
            
        } catch (Exception e) {
            System.err.println("Object creation error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates constructor access
     */
    private static void demonstrateConstructorAccess() {
        System.out.println("5. Constructor Access:");
        System.out.println("====================");
        
        try {
            Class<?> clazz = Person.class;
            
            // Get all constructors
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            System.out.println("All constructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println("  " + constructor.getName() + " - " + 
                                 Modifier.toString(constructor.getModifiers()));
                System.out.println("    Parameters: " + 
                                 Arrays.toString(constructor.getParameterTypes()));
            }
            
            // Get specific constructor
            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
            System.out.println("\nSpecific constructor: " + constructor.getName());
            System.out.println("Parameter types: " + 
                             Arrays.toString(constructor.getParameterTypes()));
            System.out.println("Modifiers: " + Modifier.toString(constructor.getModifiers()));
            
        } catch (Exception e) {
            System.err.println("Constructor access error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates security considerations
     */
    private static void demonstrateSecurityConsiderations() {
        System.out.println("6. Security Considerations:");
        System.out.println("=========================");
        
        System.out.println("Security Manager Considerations:");
        System.out.println("• Reflection can bypass access controls");
        System.out.println("• setAccessible(true) can access private members");
        System.out.println("• Security managers can restrict reflection");
        System.out.println("• Use reflection responsibly and securely");
        
        System.out.println();
        System.out.println("Security Best Practices:");
        System.out.println("• Validate input parameters");
        System.out.println("• Use reflection only when necessary");
        System.out.println("• Implement proper access controls");
        System.out.println("• Log reflection operations");
        System.out.println("• Consider using MethodHandles for better performance");
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("7. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use reflection only when necessary");
        System.out.println("✓ Cache reflection objects for better performance");
        System.out.println("✓ Handle exceptions properly");
        System.out.println("✓ Use setAccessible(true) carefully");
        System.out.println("✓ Consider using MethodHandles for better performance");
        System.out.println("✓ Implement proper error handling");
        System.out.println("✓ Use reflection for frameworks and libraries");
        System.out.println("✓ Avoid reflection in performance-critical code");
        System.out.println("✓ Use reflection for testing and debugging");
        System.out.println("✓ Consider alternatives like interfaces and polymorphism");
        System.out.println("✓ Document reflection usage clearly");
        System.out.println("✓ Test reflection code thoroughly");
        
        System.out.println();
    }
    
    // Example class for reflection demonstration
    public static class Person {
        public String name;
        private int age;
        
        public Person() {
            this.name = "Unknown";
            this.age = 0;
        }
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public int getAge() {
            return age;
        }
        
        public void setAge(int age) {
            this.age = age;
        }
        
        private void privateMethod() {
            System.out.println("Private method called via reflection");
        }
        
        public static void staticMethod() {
            System.out.println("Static method called via reflection");
        }
        
        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
}
