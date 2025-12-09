package com.tutorial.advanced;

import java.util.*;

/**
 * Maven Demo - Build Automation and Dependency Management
 * 
 * This comprehensive tutorial demonstrates Maven build automation,
 * dependency management, and project lifecycle management.
 * Learn how to use Maven effectively for Java projects.
 * 
 * LEARNING OBJECTIVES:
 * - Understand Maven project structure
 * - Use Maven for dependency management
 * - Configure Maven build lifecycle
 * - Use Maven plugins effectively
 * - Apply Maven best practices
 * - Integrate Maven with IDEs
 * 
 * KEY CONCEPTS:
 * 1. Project Structure: Standard Maven directory layout
 * 2. POM File: Project Object Model configuration
 * 3. Dependencies: External library management
 * 4. Build Lifecycle: Compile, test, package, deploy
 * 5. Plugins: Maven plugin system
 * 6. Best Practices: Effective Maven usage
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class MavenDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Maven Demo ===");
        System.out.println();
        
        // 1. Maven Project Structure
        demonstrateMavenProjectStructure();
        
        // 2. POM Configuration
        demonstratePOMConfiguration();
        
        // 3. Dependency Management
        demonstrateDependencyManagement();
        
        // 4. Build Lifecycle
        demonstrateBuildLifecycle();
        
        // 5. Maven Plugins
        demonstrateMavenPlugins();
        
        // 6. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates Maven project structure
     */
    private static void demonstrateMavenProjectStructure() {
        System.out.println("1. Maven Project Structure:");
        System.out.println("==========================");
        
        System.out.println("Standard Maven Directory Layout:");
        System.out.println("project-root/");
        System.out.println("├── pom.xml                    # Project Object Model");
        System.out.println("├── src/");
        System.out.println("│   ├── main/");
        System.out.println("│   │   ├── java/             # Main source code");
        System.out.println("│   │   ├── resources/        # Main resources");
        System.out.println("│   │   └── webapp/           # Web application");
        System.out.println("│   └── test/");
        System.out.println("│       ├── java/             # Test source code");
        System.out.println("│       └── resources/        # Test resources");
        System.out.println("├── target/                   # Build output");
        System.out.println("│   ├── classes/              # Compiled classes");
        System.out.println("│   ├── test-classes/         # Compiled test classes");
        System.out.println("│   └── *.jar                 # Generated artifacts");
        System.out.println("└── README.md");
        
        System.out.println();
    }
    
    /**
     * Demonstrates POM configuration
     */
    private static void demonstratePOMConfiguration() {
        System.out.println("2. POM Configuration:");
        System.out.println("====================");
        
        System.out.println("Essential POM elements:");
        System.out.println("• groupId: Project group identifier");
        System.out.println("• artifactId: Project artifact identifier");
        System.out.println("• version: Project version");
        System.out.println("• packaging: Project packaging type (jar, war, pom)");
        System.out.println("• name: Project display name");
        System.out.println("• description: Project description");
        System.out.println("• properties: Project properties");
        System.out.println("• dependencies: Project dependencies");
        System.out.println("• build: Build configuration");
        System.out.println("• plugins: Maven plugins");
        
        System.out.println();
    }
    
    /**
     * Demonstrates dependency management
     */
    private static void demonstrateDependencyManagement() {
        System.out.println("3. Dependency Management:");
        System.out.println("========================");
        
        System.out.println("Dependency scopes:");
        System.out.println("• compile: Default scope, available in all classpaths");
        System.out.println("• provided: Available at compile and test time");
        System.out.println("• runtime: Available at runtime and test time");
        System.out.println("• test: Available only at test time");
        System.out.println("• system: Similar to provided, but requires explicit path");
        System.out.println("• import: Used in dependency management section");
        
        System.out.println();
        System.out.println("Common dependencies:");
        System.out.println("• JUnit: Unit testing framework");
        System.out.println("• Spring Boot: Application framework");
        System.out.println("• Hibernate: ORM framework");
        System.out.println("• Jackson: JSON processing");
        System.out.println("• Logback: Logging framework");
        
        System.out.println();
    }
    
    /**
     * Demonstrates build lifecycle
     */
    private static void demonstrateBuildLifecycle() {
        System.out.println("4. Build Lifecycle:");
        System.out.println("==================");
        
        System.out.println("Maven Build Phases:");
        System.out.println("1. validate: Validate project structure");
        System.out.println("2. compile: Compile source code");
        System.out.println("3. test: Run unit tests");
        System.out.println("4. package: Package compiled code");
        System.out.println("5. verify: Run integration tests");
        System.out.println("6. install: Install package to local repository");
        System.out.println("7. deploy: Deploy package to remote repository");
        
        System.out.println();
        System.out.println("Common Maven commands:");
        System.out.println("• mvn clean: Clean target directory");
        System.out.println("• mvn compile: Compile source code");
        System.out.println("• mvn test: Run tests");
        System.out.println("• mvn package: Package the project");
        System.out.println("• mvn install: Install to local repository");
        System.out.println("• mvn deploy: Deploy to remote repository");
        
        System.out.println();
    }
    
    /**
     * Demonstrates Maven plugins
     */
    private static void demonstrateMavenPlugins() {
        System.out.println("5. Maven Plugins:");
        System.out.println("================");
        
        System.out.println("Essential Maven plugins:");
        System.out.println("• maven-compiler-plugin: Java compilation");
        System.out.println("• maven-surefire-plugin: Unit testing");
        System.out.println("• maven-failsafe-plugin: Integration testing");
        System.out.println("• maven-jar-plugin: JAR packaging");
        System.out.println("• maven-war-plugin: WAR packaging");
        System.out.println("• maven-shade-plugin: Fat JAR creation");
        System.out.println("• maven-assembly-plugin: Custom packaging");
        System.out.println("• maven-dependency-plugin: Dependency management");
        System.out.println("• maven-resources-plugin: Resource processing");
        System.out.println("• maven-clean-plugin: Clean operations");
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("6. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use standard Maven directory layout");
        System.out.println("✓ Keep POM files simple and focused");
        System.out.println("✓ Use dependency management for version control");
        System.out.println("✓ Use properties for version management");
        System.out.println("✓ Use profiles for different environments");
        System.out.println("✓ Use plugins for custom build steps");
        System.out.println("✓ Use multi-module projects for large applications");
        System.out.println("✓ Use Maven wrapper for consistent builds");
        System.out.println("✓ Use proper dependency scopes");
        System.out.println("✓ Use exclusions for transitive dependencies");
        System.out.println("✓ Use BOM (Bill of Materials) for dependency management");
        System.out.println("✓ Use Maven Central for dependencies");
        System.out.println("✓ Use proper versioning strategy");
        System.out.println("✓ Use Maven archetypes for project templates");
        
        System.out.println();
    }
    
    /**
     * Example Maven project class
     */
    public static class MavenProject {
        private String groupId;
        private String artifactId;
        private String version;
        private List<String> dependencies;
        
        public MavenProject(String groupId, String artifactId, String version) {
            this.groupId = groupId;
            this.artifactId = artifactId;
            this.version = version;
            this.dependencies = new ArrayList<>();
        }
        
        public void addDependency(String dependency) {
            dependencies.add(dependency);
        }
        
        public String getGroupId() { return groupId; }
        public String getArtifactId() { return artifactId; }
        public String getVersion() { return version; }
        public List<String> getDependencies() { return dependencies; }
        
        @Override
        public String toString() {
            return "MavenProject{" +
                    "groupId='" + groupId + '\'' +
                    ", artifactId='" + artifactId + '\'' +
                    ", version='" + version + '\'' +
                    ", dependencies=" + dependencies +
                    '}';
        }
    }
}
