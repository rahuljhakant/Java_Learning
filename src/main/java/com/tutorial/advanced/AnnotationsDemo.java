package com.tutorial.advanced;

import java.lang.annotation.*;
import java.lang.reflect.*;

/**
 * Annotations Demo - Metadata and Reflection
 * 
 * This comprehensive tutorial demonstrates Java annotations,
 * including built-in annotations, custom annotations,
 * and annotation processing with reflection.
 * 
 * LEARNING OBJECTIVES:
 * - Understand built-in Java annotations
 * - Create custom annotations
 * - Use annotations with reflection
 * - Apply annotation processing
 * - Implement annotation best practices
 * - Use annotations in real-world scenarios
 * 
 * KEY CONCEPTS:
 * 1. Built-in Annotations: @Override, @Deprecated, @SuppressWarnings
 * 2. Custom Annotations: Creating your own annotations
 * 3. Meta-annotations: @Target, @Retention, @Documented
 * 4. Annotation Processing: Using reflection with annotations
 * 5. Runtime Annotations: Accessing annotations at runtime
 * 6. Best Practices: Effective annotation usage
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class AnnotationsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Annotations Demo ===");
        System.out.println();
        
        // 1. Built-in Annotations
        demonstrateBuiltInAnnotations();
        
        // 2. Custom Annotations
        demonstrateCustomAnnotations();
        
        // 3. Annotation Processing
        demonstrateAnnotationProcessing();
        
        // 4. Meta-annotations
        demonstrateMetaAnnotations();
        
        // 5. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates built-in annotations
     */
    private static void demonstrateBuiltInAnnotations() {
        System.out.println("1. Built-in Annotations:");
        System.out.println("=======================");
        
        // @Override annotation
        ParentClass parent = new ParentClass();
        parent.display();
        
        ChildClass child = new ChildClass();
        child.display();
        
        // @Deprecated annotation
        DeprecatedClass deprecated = new DeprecatedClass();
        deprecated.oldMethod();
        
        // @SuppressWarnings annotation
        @SuppressWarnings("unchecked")
        java.util.List<String> list = new java.util.ArrayList();
        list.add("test");
        
        System.out.println();
    }
    
    /**
     * Demonstrates custom annotations
     */
    private static void demonstrateCustomAnnotations() {
        System.out.println("2. Custom Annotations:");
        System.out.println("=====================");
        
        // Use custom annotations
        @Author(name = "Rahul Kant Jha", date = "2024-01-01")
        @Version(major = 1, minor = 0)
        class TestClass {
            @NotNull
            private String name;
            
            @Range(min = 0, max = 100)
            private int age;
            
            @NotNull
            public String getName() {
                return name;
            }
            
            public void setName(@NotNull String name) {
                this.name = name;
            }
        }
        
        System.out.println("Custom annotations applied to TestClass");
        
        System.out.println();
    }
    
    /**
     * Demonstrates annotation processing
     */
    private static void demonstrateAnnotationProcessing() {
        System.out.println("3. Annotation Processing:");
        System.out.println("========================");
        
        try {
            // Get class with annotations
            Class<?> clazz = AnnotatedClass.class;
            
            // Check if class has annotation
            if (clazz.isAnnotationPresent(Author.class)) {
                Author author = clazz.getAnnotation(Author.class);
                System.out.println("Class author: " + author.name());
                System.out.println("Creation date: " + author.date());
            }
            
            // Get method annotations
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Version.class)) {
                    Version version = method.getAnnotation(Version.class);
                    System.out.println("Method " + method.getName() + 
                                     " version: " + version.major() + "." + version.minor());
                }
            }
            
            // Get field annotations
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(NotNull.class)) {
                    System.out.println("Field " + field.getName() + " is marked as @NotNull");
                }
            }
            
        } catch (Exception e) {
            System.err.println("Annotation processing error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates meta-annotations
     */
    private static void demonstrateMetaAnnotations() {
        System.out.println("4. Meta-annotations:");
        System.out.println("===================");
        
        // Get annotation information
        Class<?> annotationClass = Author.class;
        
        // Check retention policy
        Retention retention = annotationClass.getAnnotation(Retention.class);
        System.out.println("Retention policy: " + retention.value());
        
        // Check target
        Target target = annotationClass.getAnnotation(Target.class);
        System.out.println("Target elements: " + java.util.Arrays.toString(target.value()));
        
        // Check if documented
        Documented documented = annotationClass.getAnnotation(Documented.class);
        System.out.println("Is documented: " + (documented != null));
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("5. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use annotations for metadata and configuration");
        System.out.println("✓ Create meaningful annotation names");
        System.out.println("✓ Use appropriate retention policies");
        System.out.println("✓ Specify target elements clearly");
        System.out.println("✓ Document custom annotations");
        System.out.println("✓ Use annotations consistently");
        System.out.println("✓ Consider performance implications");
        System.out.println("✓ Use annotations for validation");
        System.out.println("✓ Implement proper annotation processing");
        System.out.println("✓ Use annotations for dependency injection");
        System.out.println("✓ Apply annotations for testing");
        System.out.println("✓ Use annotations for serialization");
        
        System.out.println();
    }
    
    // Custom annotation definitions
    
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface Author {
        String name();
        String date();
    }
    
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Version {
        int major();
        int minor();
    }
    
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NotNull {
    }
    
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Range {
        int min();
        int max();
    }
    
    // Example classes using annotations
    
    @Author(name = "Rahul Kant Jha", date = "2024-01-01")
    @Version(major = 1, minor = 0)
    public static class AnnotatedClass {
        @NotNull
        private String name;
        
        @Range(min = 0, max = 100)
        private int age;
        
        @Version(major = 1, minor = 0)
        public void method() {
            System.out.println("Annotated method");
        }
    }
    
    public static class ParentClass {
        public void display() {
            System.out.println("Parent class display method");
        }
    }
    
    public static class ChildClass extends ParentClass {
        @Override
        public void display() {
            System.out.println("Child class display method (overridden)");
        }
    }
    
    public static class DeprecatedClass {
        @Deprecated
        public void oldMethod() {
            System.out.println("This method is deprecated");
        }
        
        public void newMethod() {
            System.out.println("This is the new method");
        }
    }
}
