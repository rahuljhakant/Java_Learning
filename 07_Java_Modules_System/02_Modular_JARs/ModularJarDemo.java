package com.tutorial.modules.jars;

/**
 * Modular JAR Demo - Creating and Using Modular JARs
 * 
 * This comprehensive tutorial demonstrates how to create, build, and use
 * modular JAR files in Java. Modular JARs are the standard way to package
 * and distribute Java modules, providing better encapsulation and dependency
 * management than traditional JAR files.
 * 
 * LEARNING OBJECTIVES:
 * - Understand the structure of modular JARs
 * - Create modular JAR files using command-line tools
 * - Use the module path for running modular applications
 * - Build modular applications with build tools
 * - Understand module resolution and loading
 * - Deploy modular applications effectively
 * 
 * KEY CONCEPTS:
 * 1. Modular JAR Structure: How modular JARs differ from regular JARs
 * 2. Module Path: The new way to specify module locations
 * 3. Module Resolution: How Java finds and loads modules
 * 4. Build Integration: Using Maven and Gradle with modules
 * 5. Deployment: Packaging and distributing modular applications
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class ModularJarDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Modular JAR Demo ===");
        System.out.println();
        
        // 1. Understanding Modular JARs
        demonstrateModularJarConcepts();
        
        // 2. Creating Modular JARs
        demonstrateCreatingModularJars();
        
        // 3. Module Path Usage
        demonstrateModulePath();
        
        // 4. Module Resolution
        demonstrateModuleResolution();
        
        // 5. Build Tool Integration
        demonstrateBuildToolIntegration();
        
        // 6. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates key concepts of modular JARs
     */
    private static void demonstrateModularJarConcepts() {
        System.out.println("1. Modular JAR Concepts:");
        System.out.println("=======================");
        
        System.out.println("Modular JARs vs Regular JARs:");
        System.out.println("✓ Modular JARs contain module-info.class");
        System.out.println("✓ Regular JARs are on the classpath");
        System.out.println("✓ Modular JARs are on the module path");
        System.out.println("✓ Modular JARs provide strong encapsulation");
        System.out.println("✓ Modular JARs have explicit dependencies");
        
        System.out.println("\nBenefits of Modular JARs:");
        System.out.println("✓ Better encapsulation and security");
        System.out.println("✓ Explicit dependency management");
        System.out.println("✓ Improved startup performance");
        System.out.println("✓ Reduced memory footprint");
        System.out.println("✓ Better tooling support");
        
        System.out.println();
    }
    
    /**
     * Demonstrates creating modular JARs
     */
    private static void demonstrateCreatingModularJars() {
        System.out.println("2. Creating Modular JARs:");
        System.out.println("=========================");
        
        System.out.println("Step-by-step process:");
        System.out.println("1. Create module-info.java file");
        System.out.println("2. Compile with --module-path");
        System.out.println("3. Package with jar command");
        System.out.println("4. Deploy to module path");
        
        System.out.println("\nExample commands:");
        System.out.println("# Compile module");
        System.out.println("javac --module-path mods -d out src/module-info.java src/com/example/*.java");
        
        System.out.println("\n# Create modular JAR");
        System.out.println("jar --create --file mods/com.example@1.0.jar -C out .");
        
        System.out.println("\n# Run modular application");
        System.out.println("java --module-path mods --module com.example/com.example.Main");
        
        System.out.println();
    }
    
    /**
     * Demonstrates module path usage
     */
    private static void demonstrateModulePath() {
        System.out.println("3. Module Path Usage:");
        System.out.println("====================");
        
        System.out.println("Module Path vs Classpath:");
        System.out.println("Module Path: --module-path or -p");
        System.out.println("Classpath: -cp or -classpath");
        
        System.out.println("\nModule Path Features:");
        System.out.println("✓ Automatic module discovery");
        System.out.println("✓ Module resolution");
        System.out.println("✓ Encapsulation enforcement");
        System.out.println("✓ Dependency validation");
        
        System.out.println("\nExample module path usage:");
        System.out.println("java --module-path mods:libs --module com.example/com.example.Main");
        
        System.out.println();
    }
    
    /**
     * Demonstrates module resolution
     */
    private static void demonstrateModuleResolution() {
        System.out.println("4. Module Resolution:");
        System.out.println("====================");
        
        System.out.println("Module Resolution Process:");
        System.out.println("1. Start with root modules");
        System.out.println("2. Resolve dependencies recursively");
        System.out.println("3. Check for conflicts");
        System.out.println("4. Create module graph");
        System.out.println("5. Load and initialize modules");
        
        System.out.println("\nResolution Strategies:");
        System.out.println("✓ Automatic modules (from classpath JARs)");
        System.out.println("✓ Explicit modules (from module path)");
        System.out.println("✓ System modules (from JDK)");
        
        System.out.println("\nCommon Resolution Issues:");
        System.out.println("✗ Missing dependencies");
        System.out.println("✗ Circular dependencies");
        System.out.println("✗ Version conflicts");
        System.out.println("✗ Split packages");
        
        System.out.println();
    }
    
    /**
     * Demonstrates build tool integration
     */
    private static void demonstrateBuildToolIntegration() {
        System.out.println("5. Build Tool Integration:");
        System.out.println("=========================");
        
        System.out.println("Maven Integration:");
        System.out.println("✓ maven-compiler-plugin with module support");
        System.out.println("✓ maven-jar-plugin for modular JARs");
        System.out.println("✓ Module path configuration");
        System.out.println("✓ Multi-module projects");
        
        System.out.println("\nGradle Integration:");
        System.out.println("✓ Java plugin with module support");
        System.out.println("✓ Module path configuration");
        System.out.println("✓ Multi-module builds");
        System.out.println("✓ Custom module tasks");
        
        System.out.println("\nExample Maven configuration:");
        System.out.println("<plugin>");
        System.out.println("  <groupId>org.apache.maven.plugins</groupId>");
        System.out.println("  <artifactId>maven-compiler-plugin</artifactId>");
        System.out.println("  <version>3.11.0</version>");
        System.out.println("  <configuration>");
        System.out.println("    <release>17</release>");
        System.out.println("    <compilerArgs>");
        System.out.println("      <arg>--module-path</arg>");
        System.out.println("      <arg>${project.build.directory}/modules</arg>");
        System.out.println("    </compilerArgs>");
        System.out.println("  </configuration>");
        System.out.println("</plugin>");
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices for modular JARs
     */
    private static void demonstrateBestPractices() {
        System.out.println("6. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use semantic versioning for modules");
        System.out.println("✓ Keep modules focused and cohesive");
        System.out.println("✓ Minimize module dependencies");
        System.out.println("✓ Use services for loose coupling");
        System.out.println("✓ Test modules in isolation");
        System.out.println("✓ Document module APIs clearly");
        System.out.println("✓ Use automatic modules for migration");
        System.out.println("✓ Avoid split packages");
        System.out.println("✓ Use module path consistently");
        System.out.println("✓ Monitor module resolution performance");
        
        System.out.println();
    }
}


