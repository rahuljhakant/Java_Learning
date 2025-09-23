/**
 * Java 9 JShell - Interactive Java Shell Tutorial
 * 
 * This comprehensive tutorial demonstrates JShell, the interactive Java shell tool
 * introduced in Java 9. JShell provides a Read-Eval-Print Loop (REPL) environment
 * for Java, allowing developers to quickly test code snippets, explore APIs,
 * and prototype solutions without creating full Java applications.
 * 
 * LEARNING OBJECTIVES:
 * - Understand JShell and its benefits for Java development
 * - Learn how to start and use JShell effectively
 * - Master JShell commands and shortcuts
 * - Practice interactive Java programming
 * - Learn how to save and load JShell sessions
 * - Understand JShell's integration with IDEs
 * - Master advanced JShell features and techniques
 * 
 * KEY CONCEPTS:
 * 1. REPL Environment: Interactive programming in Java
 * 2. JShell Commands: Built-in commands for session management
 * 3. Code Snippets: Executing Java code without compilation
 * 4. Variable Management: Creating and managing variables
 * 5. Method Definition: Defining methods interactively
 * 6. Import Management: Adding imports to JShell session
 * 7. Error Handling: Understanding JShell error messages
 * 8. Session Persistence: Saving and loading JShell sessions
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
public class JShellDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Java 9 JShell Tutorial ===");
        System.out.println();
        
        // 1. Introduction to JShell
        demonstrateJShellIntroduction();
        
        // 2. JShell commands
        demonstrateJShellCommands();
        
        // 3. Interactive programming examples
        demonstrateInteractiveProgramming();
        
        // 4. Advanced JShell features
        demonstrateAdvancedFeatures();
        
        // 5. Best practices and tips
        demonstrateBestPractices();
    }
    
    /**
     * Introduction to JShell and its benefits
     */
    private static void demonstrateJShellIntroduction() {
        System.out.println("1. JShell Introduction:");
        System.out.println("======================");
        
        System.out.println("JShell is an interactive Java shell that provides:");
        System.out.println("✓ Read-Eval-Print Loop (REPL) for Java");
        System.out.println("✓ Immediate feedback on code execution");
        System.out.println("✓ No need to create classes or main methods");
        System.out.println("✓ Quick prototyping and experimentation");
        System.out.println("✓ API exploration and testing");
        System.out.println("✓ Learning Java concepts interactively");
        
        System.out.println("\nHow to start JShell:");
        System.out.println("1. Open command prompt/terminal");
        System.out.println("2. Type: jshell");
        System.out.println("3. Start coding immediately!");
        
        System.out.println("\nExample JShell session:");
        System.out.println("jshell> int x = 10");
        System.out.println("x ==> 10");
        System.out.println("jshell> int y = 20");
        System.out.println("y ==> 20");
        System.out.println("jshell> x + y");
        System.out.println("$3 ==> 30");
        
        System.out.println();
    }
    
    /**
     * Demonstrates essential JShell commands
     */
    private static void demonstrateJShellCommands() {
        System.out.println("2. Essential JShell Commands:");
        System.out.println("============================");
        
        System.out.println("Session Management:");
        System.out.println("/help          - Show help information");
        System.out.println("/exit          - Exit JShell");
        System.out.println("/reset         - Reset the session");
        System.out.println("/clear         - Clear the screen");
        
        System.out.println("\nCode Navigation:");
        System.out.println("/list          - List all code snippets");
        System.out.println("/list -all     - List all snippets including errors");
        System.out.println("/list -start   - List startup snippets");
        System.out.println("/history       - Show command history");
        
        System.out.println("\nVariable and Method Management:");
        System.out.println("/vars          - List all variables");
        System.out.println("/methods       - List all methods");
        System.out.println("/types         - List all types");
        System.out.println("/imports       - List all imports");
        
        System.out.println("\nCode Editing:");
        System.out.println("/edit          - Open code editor");
        System.out.println("/edit <id>     - Edit specific snippet");
        System.out.println("/drop <id>     - Delete specific snippet");
        
        System.out.println("\nSession Persistence:");
        System.out.println("/save <file>   - Save session to file");
        System.out.println("/open <file>   - Load session from file");
        System.out.println("/reload        - Reload startup snippets");
        
        System.out.println();
    }
    
    /**
     * Demonstrates interactive programming examples
     */
    private static void demonstrateInteractiveProgramming() {
        System.out.println("3. Interactive Programming Examples:");
        System.out.println("===================================");
        
        System.out.println("Basic Operations:");
        System.out.println("jshell> 2 + 3");
        System.out.println("$1 ==> 5");
        System.out.println("jshell> Math.sqrt(16)");
        System.out.println("$2 ==> 4.0");
        System.out.println("jshell> String name = \"Java\"");
        System.out.println("name ==> \"Java\"");
        
        System.out.println("\nMethod Definition:");
        System.out.println("jshell> int add(int a, int b) {");
        System.out.println("   ...>     return a + b;");
        System.out.println("   ...> }");
        System.out.println("|  created method add(int,int)");
        System.out.println("jshell> add(5, 3)");
        System.out.println("$4 ==> 8");
        
        System.out.println("\nClass Definition:");
        System.out.println("jshell> class Person {");
        System.out.println("   ...>     String name;");
        System.out.println("   ...>     int age;");
        System.out.println("   ...>     Person(String name, int age) {");
        System.out.println("   ...>         this.name = name;");
        System.out.println("   ...>         this.age = age;");
        System.out.println("   ...>     }");
        System.out.println("   ...> }");
        System.out.println("|  created class Person");
        System.out.println("jshell> Person p = new Person(\"Alice\", 25)");
        System.out.println("p ==> Person@12345678");
        
        System.out.println("\nImport Management:");
        System.out.println("jshell> import java.time.*");
        System.out.println("jshell> LocalDate.now()");
        System.out.println("$6 ==> 2024-01-15");
        
        System.out.println();
    }
    
    /**
     * Demonstrates advanced JShell features
     */
    private static void demonstrateAdvancedFeatures() {
        System.out.println("4. Advanced JShell Features:");
        System.out.println("===========================");
        
        System.out.println("Startup Scripts:");
        System.out.println("Create a startup file with common imports:");
        System.out.println("// startup.jsh");
        System.out.println("import java.util.*;");
        System.out.println("import java.time.*;");
        System.out.println("import java.math.*;");
        System.out.println("System.out.println(\"Welcome to JShell!\");");
        
        System.out.println("\nRun with startup script:");
        System.out.println("jshell startup.jsh");
        
        System.out.println("\nTab Completion:");
        System.out.println("jshell> Math.<TAB>");
        System.out.println("abs()    acos()   addExact()  asin()   atan()");
        System.out.println("Use TAB for method and variable completion");
        
        System.out.println("\nError Recovery:");
        System.out.println("jshell> int x = ");
        System.out.println("|  Error: illegal start of expression");
        System.out.println("jshell> int x = 10");
        System.out.println("x ==> 10");
        System.out.println("JShell allows you to fix errors and continue");
        
        System.out.println("\nMulti-line Input:");
        System.out.println("jshell> if (x > 5) {");
        System.out.println("   ...>     System.out.println(\"x is greater than 5\");");
        System.out.println("   ...> }");
        System.out.println("x is greater than 5");
        
        System.out.println("\nExternal Editor Integration:");
        System.out.println("jshell> /edit");
        System.out.println("Opens external editor for code editing");
        System.out.println("Save and close to return to JShell");
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices and tips for JShell
     */
    private static void demonstrateBestPractices() {
        System.out.println("5. JShell Best Practices and Tips:");
        System.out.println("=================================");
        
        System.out.println("✓ Use JShell for:");
        System.out.println("  - Quick API exploration");
        System.out.println("  - Algorithm prototyping");
        System.out.println("  - Testing small code snippets");
        System.out.println("  - Learning new Java features");
        System.out.println("  - Debugging complex expressions");
        
        System.out.println("\n✓ Create Startup Scripts:");
        System.out.println("  - Common imports");
        System.out.println("  - Utility methods");
        System.out.println("  - Test data");
        System.out.println("  - Configuration settings");
        
        System.out.println("\n✓ Use Meaningful Variable Names:");
        System.out.println("  - Avoid $1, $2, $3 for important values");
        System.out.println("  - Use descriptive names for clarity");
        System.out.println("  - Example: result instead of $4");
        
        System.out.println("\n✓ Leverage Tab Completion:");
        System.out.println("  - Use TAB for method completion");
        System.out.println("  - Use TAB for variable completion");
        System.out.println("  - Use TAB for import suggestions");
        
        System.out.println("\n✓ Save Important Sessions:");
        System.out.println("  - Use /save for useful code snippets");
        System.out.println("  - Create reusable JShell scripts");
        System.out.println("  - Share JShell sessions with team");
        
        System.out.println("\n✓ IDE Integration:");
        System.out.println("  - IntelliJ IDEA: Built-in JShell support");
        System.out.println("  - VS Code: Java Extension Pack");
        System.out.println("  - Eclipse: JShell view");
        
        System.out.println("\n✓ Performance Tips:");
        System.out.println("  - Use /reset to clear memory");
        System.out.println("  - Avoid creating too many variables");
        System.out.println("  - Use /drop to remove unused snippets");
        
        System.out.println();
    }
}

/**
 * JShell Utility Class
 * 
 * This class provides utility methods that can be used in JShell sessions
 * for common operations and demonstrations.
 */
class JShellUtils {
    
    /**
     * Calculate factorial of a number
     */
    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
    
    /**
     * Check if a number is prime
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    /**
     * Generate Fibonacci sequence
     */
    public static int[] fibonacci(int count) {
        int[] fib = new int[count];
        if (count > 0) fib[0] = 0;
        if (count > 1) fib[1] = 1;
        for (int i = 2; i < count; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib;
    }
    
    /**
     * Format current date and time
     */
    public static String getCurrentDateTime() {
        return java.time.LocalDateTime.now().toString();
    }
}
