/**
 * Java Modules System - Module Declaration and Basics Tutorial
 * 
 * This comprehensive tutorial demonstrates the fundamentals of the Java Modules System,
 * including module declarations, dependencies, exports, and the module-info.java file.
 * The module system provides strong encapsulation, reliable configuration, and improved
 * performance for Java applications.
 * 
 * LEARNING OBJECTIVES:
 * - Understand the Java Modules System and its benefits
 * - Learn how to create and declare modules
 * - Master module-info.java file syntax
 * - Understand module dependencies and exports
 * - Learn about the service provider pattern in modules
 * - Practice creating modular applications
 * - Understand module resolution and loading
 * 
 * KEY CONCEPTS:
 * 1. Module Declaration: module-info.java file structure
 * 2. Module Dependencies: requires, exports, provides, uses
 * 3. Strong Encapsulation: Controlled access to internal APIs
 * 4. Reliable Configuration: Explicit dependency declaration
 * 5. Service Provider Pattern: Loose coupling through services
 * 6. Module Path: How Java finds and loads modules
 * 7. Migration: Converting existing applications to modules
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
package com.tutorial.modules.basics;

import java.util.ServiceLoader;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.util.Set;

/**
 * Module Declaration Demo - Main demonstration class
 * 
 * This class demonstrates various aspects of module declarations,
 * including module information, dependencies, and service discovery.
 */
public class ModuleDeclarationDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Java Modules System - Module Declaration Tutorial ===");
        System.out.println();
        
        // 1. Introduction to modules
        demonstrateModuleIntroduction();
        
        // 2. Module declaration syntax
        demonstrateModuleDeclarationSyntax();
        
        // 3. Module dependencies
        demonstrateModuleDependencies();
        
        // 4. Module exports and encapsulation
        demonstrateModuleExports();
        
        // 5. Service provider pattern
        demonstrateServiceProviderPattern();
        
        // 6. Module resolution
        demonstrateModuleResolution();
        
        // 7. Best practices
        demonstrateBestPractices();
    }
    
    /**
     * Introduction to the Java Modules System
     */
    private static void demonstrateModuleIntroduction() {
        System.out.println("1. Java Modules System Introduction:");
        System.out.println("===================================");
        
        System.out.println("The Java Modules System (Project Jigsaw) provides:");
        System.out.println("✓ Strong Encapsulation: Hide internal APIs");
        System.out.println("✓ Reliable Configuration: Explicit dependencies");
        System.out.println("✓ Improved Performance: Faster startup, less memory");
        System.out.println("✓ Better Maintainability: Clear module boundaries");
        System.out.println("✓ Enhanced Security: Controlled access to APIs");
        
        System.out.println("\nKey Components:");
        System.out.println("• module-info.java: Module declaration file");
        System.out.println("• Module Path: Where Java finds modules");
        System.out.println("• Module Descriptor: Runtime module information");
        System.out.println("• Service Loader: Service discovery mechanism");
        
        System.out.println("\nModule vs Package:");
        System.out.println("Package: Logical grouping of related classes");
        System.out.println("Module: Physical grouping with explicit boundaries");
        System.out.println("Module = Package + Dependencies + Exports + Services");
        
        System.out.println();
    }
    
    /**
     * Demonstrates module declaration syntax
     */
    private static void demonstrateModuleDeclarationSyntax() {
        System.out.println("2. Module Declaration Syntax:");
        System.out.println("============================");
        
        System.out.println("Basic module-info.java structure:");
        System.out.println("module com.example.mymodule {");
        System.out.println("    // Module dependencies");
        System.out.println("    requires java.base;");
        System.out.println("    requires java.logging;");
        System.out.println("    ");
        System.out.println("    // Export packages");
        System.out.println("    exports com.example.mymodule.api;");
        System.out.println("    ");
        System.out.println("    // Provide services");
        System.out.println("    provides com.example.Service");
        System.out.println("        with com.example.ServiceImpl;");
        System.out.println("    ");
        System.out.println("    // Use services");
        System.out.println("    uses com.example.Service;");
        System.out.println("}");
        
        System.out.println("\nModule Declaration Keywords:");
        System.out.println("• module: Declares a module");
        System.out.println("• requires: Declares a dependency on another module");
        System.out.println("• exports: Makes a package available to other modules");
        System.out.println("• provides: Provides a service implementation");
        System.out.println("• uses: Declares that the module uses a service");
        System.out.println("• opens: Opens a package for reflection (Java 9+)");
        System.out.println("• requires static: Optional dependency");
        System.out.println("• requires transitive: Transitive dependency");
        
        System.out.println("\nModule Naming Conventions:");
        System.out.println("• Use reverse domain name notation");
        System.out.println("• Example: com.company.product.module");
        System.out.println("• Avoid conflicts with standard modules");
        System.out.println("• Use descriptive, meaningful names");
        
        System.out.println();
    }
    
    /**
     * Demonstrates module dependencies
     */
    private static void demonstrateModuleDependencies() {
        System.out.println("3. Module Dependencies:");
        System.out.println("=====================");
        
        System.out.println("Types of Module Dependencies:");
        
        System.out.println("\n1. Basic Dependencies (requires):");
        System.out.println("module com.example.app {");
        System.out.println("    requires java.base;        // Always implicit");
        System.out.println("    requires java.logging;     // Standard module");
        System.out.println("    requires com.example.util; // Custom module");
        System.out.println("}");
        
        System.out.println("\n2. Optional Dependencies (requires static):");
        System.out.println("module com.example.app {");
        System.out.println("    requires static java.desktop; // Optional GUI support");
        System.out.println("    requires static java.sql;     // Optional database support");
        System.out.println("}");
        
        System.out.println("\n3. Transitive Dependencies (requires transitive):");
        System.out.println("module com.example.api {");
        System.out.println("    requires transitive java.base;");
        System.out.println("    // Any module requiring com.example.api");
        System.out.println("    // automatically gets java.base");
        System.out.println("}");
        
        System.out.println("\nDependency Resolution:");
        System.out.println("• Java resolves dependencies at startup");
        System.out.println("• Missing dependencies cause startup failure");
        System.out.println("• Circular dependencies are not allowed");
        System.out.println("• Optional dependencies are ignored if missing");
        
        System.out.println("\nStandard Modules (Java 9+):");
        System.out.println("• java.base: Core Java classes (always available)");
        System.out.println("• java.logging: Logging framework");
        System.out.println("• java.desktop: GUI components");
        System.out.println("• java.sql: Database connectivity");
        System.out.println("• java.xml: XML processing");
        System.out.println("• java.net.http: HTTP client (Java 11+)");
        
        System.out.println();
    }
    
    /**
     * Demonstrates module exports and encapsulation
     */
    private static void demonstrateModuleExports() {
        System.out.println("4. Module Exports and Encapsulation:");
        System.out.println("===================================");
        
        System.out.println("Strong Encapsulation:");
        System.out.println("• By default, packages are not accessible outside the module");
        System.out.println("• Only explicitly exported packages are accessible");
        System.out.println("• Internal APIs are completely hidden");
        System.out.println("• Prevents unauthorized access to implementation details");
        
        System.out.println("\nExport Types:");
        
        System.out.println("\n1. Public Exports (exports):");
        System.out.println("module com.example.api {");
        System.out.println("    exports com.example.api.public;");
        System.out.println("    // Package is accessible to all modules");
        System.out.println("}");
        
        System.out.println("\n2. Qualified Exports (exports ... to):");
        System.out.println("module com.example.api {");
        System.out.println("    exports com.example.api.internal");
        System.out.println("        to com.example.test, com.example.debug;");
        System.out.println("    // Package only accessible to specific modules");
        System.out.println("}");
        
        System.out.println("\n3. Open Packages (opens):");
        System.out.println("module com.example.app {");
        System.out.println("    opens com.example.app.model;");
        System.out.println("    // Package accessible for reflection");
        System.out.println("}");
        
        System.out.println("\n4. Qualified Opens (opens ... to):");
        System.out.println("module com.example.app {");
        System.out.println("    opens com.example.app.model");
        System.out.println("        to com.example.test;");
        System.out.println("    // Package accessible for reflection to specific modules");
        System.out.println("}");
        
        System.out.println("\nEncapsulation Benefits:");
        System.out.println("• Prevents breaking changes in internal APIs");
        System.out.println("• Enables better refactoring");
        System.out.println("• Improves security");
        System.out.println("• Reduces coupling between modules");
        
        System.out.println();
    }
    
    /**
     * Demonstrates the service provider pattern in modules
     */
    private static void demonstrateServiceProviderPattern() {
        System.out.println("5. Service Provider Pattern:");
        System.out.println("===========================");
        
        System.out.println("Service Provider Pattern Benefits:");
        System.out.println("• Loose coupling between modules");
        System.out.println("• Runtime service discovery");
        System.out.println("• Multiple implementations");
        System.out.println("• Plugin architecture support");
        
        System.out.println("\nService Declaration:");
        System.out.println("// Service interface");
        System.out.println("public interface PaymentService {");
        System.out.println("    void processPayment(double amount);");
        System.out.println("}");
        
        System.out.println("\nService Implementation:");
        System.out.println("public class CreditCardPayment implements PaymentService {");
        System.out.println("    public void processPayment(double amount) {");
        System.out.println("        // Credit card payment logic");
        System.out.println("    }");
        System.out.println("}");
        
        System.out.println("\nModule Declaration:");
        System.out.println("module com.example.payment {");
        System.out.println("    // Provide service implementation");
        System.out.println("    provides com.example.PaymentService");
        System.out.println("        with com.example.CreditCardPayment;");
        System.out.println("}");
        
        System.out.println("\nService Consumer:");
        System.out.println("module com.example.app {");
        System.out.println("    requires com.example.payment;");
        System.out.println("    ");
        System.out.println("    // Use service");
        System.out.println("    uses com.example.PaymentService;");
        System.out.println("}");
        
        System.out.println("\nService Discovery:");
        System.out.println("ServiceLoader<PaymentService> loader =");
        System.out.println("    ServiceLoader.load(PaymentService.class);");
        System.out.println("for (PaymentService service : loader) {");
        System.out.println("    service.processPayment(100.0);");
        System.out.println("}");
        
        System.out.println();
    }
    
    /**
     * Demonstrates module resolution
     */
    private static void demonstrateModuleResolution() {
        System.out.println("6. Module Resolution:");
        System.out.println("===================");
        
        System.out.println("Module Resolution Process:");
        System.out.println("1. Start with root modules (--module parameter)");
        System.out.println("2. Resolve dependencies recursively");
        System.out.println("3. Check for conflicts and missing modules");
        System.out.println("4. Create module graph");
        System.out.println("5. Load and initialize modules");
        
        System.out.println("\nModule Path vs Classpath:");
        System.out.println("Classpath: Flat list of JARs and directories");
        System.out.println("Module Path: Hierarchical module structure");
        System.out.println("• --module-path: Where to find modules");
        System.out.println("• --add-modules: Additional modules to include");
        System.out.println("• --limit-modules: Limit module resolution");
        
        System.out.println("\nModule Resolution Commands:");
        System.out.println("java --module-path mods --module com.example.app/com.example.Main");
        System.out.println("java --module-path lib --add-modules java.desktop --module com.example.app");
        System.out.println("java --limit-modules java.base,java.logging --module com.example.app");
        
        System.out.println("\nModule Resolution Errors:");
        System.out.println("• Module not found: Module not in module path");
        System.out.println("• Package not exported: Trying to access non-exported package");
        System.out.println("• Circular dependency: Modules depending on each other");
        System.out.println("• Missing dependency: Required module not found");
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices for module development
     */
    private static void demonstrateBestPractices() {
        System.out.println("7. Module Development Best Practices:");
        System.out.println("====================================");
        
        System.out.println("✓ Module Design:");
        System.out.println("  • Keep modules focused and cohesive");
        System.out.println("  • Minimize module dependencies");
        System.out.println("  • Use clear, descriptive module names");
        System.out.println("  • Follow single responsibility principle");
        
        System.out.println("\n✓ Package Organization:");
        System.out.println("  • Use package-private for internal APIs");
        System.out.println("  • Export only necessary packages");
        System.out.println("  • Use qualified exports when possible");
        System.out.println("  • Organize packages by functionality");
        
        System.out.println("\n✓ Dependency Management:");
        System.out.println("  • Use 'requires static' for optional dependencies");
        System.out.println("  • Use 'requires transitive' for API modules");
        System.out.println("  • Avoid circular dependencies");
        System.out.println("  • Document module dependencies clearly");
        
        System.out.println("\n✓ Service Design:");
        System.out.println("  • Use services for loose coupling");
        System.out.println("  • Provide multiple implementations");
        System.out.println("  • Document service contracts");
        System.out.println("  • Use meaningful service interfaces");
        
        System.out.println("\n✓ Migration Strategy:");
        System.out.println("  • Start with automatic modules");
        System.out.println("  • Gradually convert to explicit modules");
        System.out.println("  • Test thoroughly at each step");
        System.out.println("  • Use module-info.java templates");
        
        System.out.println("\n✓ Performance Considerations:");
        System.out.println("  • Use module path instead of classpath");
        System.out.println("  • Minimize module dependencies");
        System.out.println("  • Use jlink to create custom runtime images");
        System.out.println("  • Profile module loading performance");
        
        System.out.println();
    }
}

/**
 * Example Service Interface for Module Demo
 */
interface ExampleService {
    String getServiceName();
    void performOperation();
}

/**
 * Example Service Implementation
 */
class ExampleServiceImpl implements ExampleService {
    @Override
    public String getServiceName() {
        return "Example Service";
    }
    
    @Override
    public void performOperation() {
        System.out.println("Performing example operation");
    }
}

/**
 * Module Utilities for demonstration
 */
class ModuleUtils {
    
    /**
     * Get current module information
     */
    public static void printCurrentModuleInfo() {
        Module currentModule = ModuleDeclarationDemo.class.getModule();
        System.out.println("Current Module: " + currentModule.getName());
        System.out.println("Is Named: " + currentModule.isNamed());
        
        if (currentModule.getDescriptor() != null) {
            ModuleDescriptor descriptor = currentModule.getDescriptor();
            System.out.println("Exports: " + descriptor.exports());
            System.out.println("Requires: " + descriptor.requires());
            System.out.println("Provides: " + descriptor.provides());
            System.out.println("Uses: " + descriptor.uses());
        }
    }
    
    /**
     * List all available modules
     */
    public static void listAvailableModules() {
        System.out.println("Available Modules:");
        ModuleLayer.boot().modules().stream()
            .filter(Module::isNamed)
            .limit(20) // Show first 20 modules
            .forEach(module -> System.out.println("  - " + module.getName()));
    }
}
