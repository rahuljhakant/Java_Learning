package com.tutorial.modules.jars;

/**
 * Module Path Demo - Understanding Module Path System
 * 
 * This tutorial demonstrates the module path system in Java, which is the
 * new way to specify module locations and resolve module dependencies.
 * Understanding the module path is crucial for working with Java modules
 * effectively.
 * 
 * LEARNING OBJECTIVES:
 * - Understand the module path concept
 * - Configure module path for applications
 * - Use automatic modules for migration
 * - Handle module resolution issues
 * - Optimize module loading performance
 * 
 * KEY CONCEPTS:
 * 1. Module Path: Location where Java looks for modules
 * 2. Automatic Modules: Converting classpath JARs to modules
 * 3. Module Resolution: How Java finds and loads modules
 * 4. Performance: Optimizing module loading
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class ModulePathDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Module Path Demo ===");
        System.out.println();
        
        // 1. Understanding Module Path
        demonstrateModulePathConcepts();
        
        // 2. Module Path Configuration
        demonstrateModulePathConfiguration();
        
        // 3. Automatic Modules
        demonstrateAutomaticModules();
        
        // 4. Module Resolution
        demonstrateModuleResolution();
        
        // 5. Performance Considerations
        demonstratePerformanceConsiderations();
    }
    
    /**
     * Demonstrates module path concepts
     */
    private static void demonstrateModulePathConcepts() {
        System.out.println("1. Module Path Concepts:");
        System.out.println("=======================");
        
        System.out.println("What is Module Path?");
        System.out.println("✓ Location where Java looks for modules");
        System.out.println("✓ Replaces classpath for modular applications");
        System.out.println("✓ Supports both explicit and automatic modules");
        System.out.println("✓ Enables module resolution and loading");
        
        System.out.println("\nModule Path vs Classpath:");
        System.out.println("Module Path: --module-path or -p");
        System.out.println("Classpath: -cp or -classpath");
        
        System.out.println("\nModule Path Benefits:");
        System.out.println("✓ Better encapsulation");
        System.out.println("✓ Explicit dependencies");
        System.out.println("✓ Improved performance");
        System.out.println("✓ Better tooling support");
        
        System.out.println();
    }
    
    /**
     * Demonstrates module path configuration
     */
    private static void demonstrateModulePathConfiguration() {
        System.out.println("2. Module Path Configuration:");
        System.out.println("============================");
        
        System.out.println("Setting Module Path:");
        System.out.println("✓ Command line: --module-path <path>");
        System.out.println("✓ Environment variable: JAVA_MODULE_PATH");
        System.out.println("✓ System property: jdk.module.path");
        
        System.out.println("\nExample configurations:");
        System.out.println("# Single directory");
        System.out.println("java --module-path mods --module com.example/com.example.Main");
        
        System.out.println("\n# Multiple directories");
        System.out.println("java --module-path mods:libs:custom --module com.example/com.example.Main");
        
        System.out.println("\n# With system modules");
        System.out.println("java --module-path mods --add-modules java.logging --module com.example/com.example.Main");
        
        System.out.println();
    }
    
    /**
     * Demonstrates automatic modules
     */
    private static void demonstrateAutomaticModules() {
        System.out.println("3. Automatic Modules:");
        System.out.println("====================");
        
        System.out.println("What are Automatic Modules?");
        System.out.println("✓ Regular JARs placed on module path");
        System.out.println("✓ Automatically converted to modules");
        System.out.println("✓ Useful for migration from classpath");
        System.out.println("✓ Export all packages by default");
        
        System.out.println("\nAutomatic Module Naming:");
        System.out.println("✓ Based on JAR file name");
        System.out.println("✓ Removes version numbers");
        System.out.println("✓ Converts to valid module name");
        
        System.out.println("\nExample automatic modules:");
        System.out.println("commons-lang3-3.12.0.jar → commons.lang3");
        System.out.println("gson-2.8.9.jar → gson");
        System.out.println("junit-4.13.2.jar → junit");
        
        System.out.println("\nUsing Automatic Modules:");
        System.out.println("module com.example {");
        System.out.println("    requires commons.lang3;");
        System.out.println("    requires gson;");
        System.out.println("}");
        
        System.out.println();
    }
    
    /**
     * Demonstrates module resolution
     */
    private static void demonstrateModuleResolution() {
        System.out.println("4. Module Resolution:");
        System.out.println("====================");
        
        System.out.println("Resolution Process:");
        System.out.println("1. Start with root modules");
        System.out.println("2. Resolve dependencies recursively");
        System.out.println("3. Check for conflicts");
        System.out.println("4. Create module graph");
        System.out.println("5. Load and initialize modules");
        
        System.out.println("\nResolution Strategies:");
        System.out.println("✓ Explicit modules (from module path)");
        System.out.println("✓ Automatic modules (from classpath JARs)");
        System.out.println("✓ System modules (from JDK)");
        
        System.out.println("\nCommon Resolution Issues:");
        System.out.println("✗ Missing dependencies");
        System.out.println("✗ Circular dependencies");
        System.out.println("✗ Version conflicts");
        System.out.println("✗ Split packages");
        
        System.out.println("\nDebugging Module Resolution:");
        System.out.println("java --show-module-resolution --module-path mods --module com.example/com.example.Main");
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance considerations
     */
    private static void demonstratePerformanceConsiderations() {
        System.out.println("5. Performance Considerations:");
        System.out.println("=============================");
        
        System.out.println("Module Loading Performance:");
        System.out.println("✓ Faster startup with modules");
        System.out.println("✓ Reduced memory footprint");
        System.out.println("✓ Better JVM optimizations");
        System.out.println("✓ Improved garbage collection");
        
        System.out.println("\nOptimization Tips:");
        System.out.println("✓ Use module path consistently");
        System.out.println("✓ Minimize module dependencies");
        System.out.println("✓ Avoid unnecessary automatic modules");
        System.out.println("✓ Use jlink for custom runtime images");
        
        System.out.println("\nPerformance Monitoring:");
        System.out.println("✓ Use --show-module-resolution for debugging");
        System.out.println("✓ Monitor module loading times");
        System.out.println("✓ Profile application startup");
        System.out.println("✓ Use JFR for detailed analysis");
        
        System.out.println();
    }
}


