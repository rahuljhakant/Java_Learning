/**
 * Foreign Function and Memory API - Comprehensive Tutorial
 * 
 * This comprehensive tutorial demonstrates the Foreign Function and Memory API (FFM API),
 * a powerful feature introduced in Java 19 as part of Project Panama. The FFM API
 * provides a safe and efficient way to interact with native code and memory, enabling
 * Java applications to call native libraries and manage off-heap memory.
 * 
 * LEARNING OBJECTIVES:
 * - Understand the Foreign Function and Memory API and its benefits
 * - Learn how to manage off-heap memory safely
 * - Master calling native functions from Java
 * - Understand memory layouts and structured data access
 * - Learn how to integrate with native libraries
 * - Practice advanced FFM API features
 * - Understand best practices for native code integration
 * 
 * KEY CONCEPTS:
 * 1. Memory Segments: Off-heap memory allocation and management
 * 2. Memory Layouts: Structured memory layouts and access patterns
 * 3. Function Descriptors: Describing native function signatures
 * 4. Function Handles: Calling native functions from Java
 * 5. Symbol Lookup: Finding and resolving native library symbols
 * 6. Data Marshalling: Converting between Java and native types
 * 7. Memory Safety: Safe memory access and lifecycle management
 * 8. Performance: Optimizing native code integration
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * Foreign Function and Memory API Demo - Main demonstration class
 * 
 * This class demonstrates various FFM API features including memory management,
 * native function calls, and structured data access.
 */
public class ForeignFunctionMemoryDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Foreign Function and Memory API Tutorial ===");
        System.out.println();
        
        // 1. FFM API introduction
        demonstrateFFMAPIIntroduction();
        
        // 2. Memory management
        demonstrateMemoryManagement();
        
        // 3. Memory layouts
        demonstrateMemoryLayouts();
        
        // 4. Function descriptors and handles
        demonstrateFunctionDescriptors();
        
        // 5. Native library integration
        demonstrateNativeLibraryIntegration();
        
        // 6. Best practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates FFM API introduction and benefits
     */
    private static void demonstrateFFMAPIIntroduction() {
        System.out.println("1. Foreign Function and Memory API Introduction:");
        System.out.println("==============================================");
        
        System.out.println("What is the Foreign Function and Memory API?");
        System.out.println("• Part of Project Panama (Java 19+)");
        System.out.println("• Safe and efficient native code integration");
        System.out.println("• Memory-safe access to off-heap memory");
        System.out.println("• Direct calling of native functions");
        System.out.println("• Alternative to JNI for many use cases");
        
        System.out.println("\nKey Benefits:");
        System.out.println("✓ Performance: Direct native code access without JNI overhead");
        System.out.println("✓ Safety: Memory-safe access to native memory");
        System.out.println("✓ Simplicity: Easier than JNI for many use cases");
        System.out.println("✓ Efficiency: Better performance than JNI");
        System.out.println("✓ Modern: Designed for modern Java features");
        
        System.out.println("\nFFM API vs JNI:");
        System.out.println("FFM API:");
        System.out.println("  • Memory-safe by design");
        System.out.println("  • Easier to use");
        System.out.println("  • Better performance");
        System.out.println("  • Modern Java integration");
        System.out.println("  • Automatic memory management");
        
        System.out.println("JNI:");
        System.out.println("  • More complex to use");
        System.out.println("  • Manual memory management");
        System.out.println("  • More error-prone");
        System.out.println("  • Legacy approach");
        System.out.println("  • Requires C/C++ code");
        
        System.out.println("\nUse Cases:");
        System.out.println("• Calling native libraries (C, C++, Rust)");
        System.out.println("• Working with system APIs");
        System.out.println("• High-performance computing");
        System.out.println("• Graphics and multimedia libraries");
        System.out.println("• Database drivers");
        System.out.println("• Cryptographic libraries");
        
        System.out.println();
    }
    
    /**
     * Demonstrates memory management with FFM API
     */
    private static void demonstrateMemoryManagement() {
        System.out.println("2. Memory Management:");
        System.out.println("===================");
        
        System.out.println("Memory Segments:");
        System.out.println("• Off-heap memory allocation");
        System.out.println("• Automatic memory management");
        System.out.println("• Memory safety guarantees");
        System.out.println("• Lifecycle management");
        
        // Demonstrate memory segment allocation
        System.out.println("\nMemory Segment Allocation:");
        
        // Allocate memory segment
        try (MemorySegment segment = MemorySegment.allocateNative(1024)) {
            System.out.println("Allocated memory segment of size: " + segment.byteSize() + " bytes");
            System.out.println("Memory segment address: " + segment.address());
            System.out.println("Memory segment is alive: " + segment.isAlive());
            
            // Access memory segment
            System.out.println("\nMemory Access:");
            
            // Write data to memory
            segment.set(ValueLayout.JAVA_INT, 0, 42);
            segment.set(ValueLayout.JAVA_INT, 4, 100);
            segment.set(ValueLayout.JAVA_LONG, 8, 12345L);
            
            // Read data from memory
            int value1 = segment.get(ValueLayout.JAVA_INT, 0);
            int value2 = segment.get(ValueLayout.JAVA_INT, 4);
            long value3 = segment.get(ValueLayout.JAVA_LONG, 8);
            
            System.out.println("Read values:");
            System.out.println("  Integer 1: " + value1);
            System.out.println("  Integer 2: " + value2);
            System.out.println("  Long: " + value3);
            
            // Demonstrate memory copying
            System.out.println("\nMemory Copying:");
            try (MemorySegment source = MemorySegment.allocateNative(16);
                 MemorySegment target = MemorySegment.allocateNative(16)) {
                
                // Write data to source
                for (int i = 0; i < 4; i++) {
                    source.set(ValueLayout.JAVA_INT, i * 4, i * 10);
                }
                
                // Copy from source to target
                target.copyFrom(source);
                
                // Verify copy
                System.out.println("Copied values:");
                for (int i = 0; i < 4; i++) {
                    int value = target.get(ValueLayout.JAVA_INT, i * 4);
                    System.out.println("  Value " + i + ": " + value);
                }
            }
        }
        
        System.out.println("\nMemory Safety:");
        System.out.println("• Automatic bounds checking");
        System.out.println("• Automatic memory deallocation");
        System.out.println("• Prevention of memory leaks");
        System.out.println("• Thread-safe memory access");
        
        System.out.println();
    }
    
    /**
     * Demonstrates memory layouts and structured data access
     */
    private static void demonstrateMemoryLayouts() {
        System.out.println("3. Memory Layouts:");
        System.out.println("=================");
        
        System.out.println("Memory Layouts:");
        System.out.println("• Structured memory access");
        System.out.println("• Type-safe memory operations");
        System.out.println("• Layout optimization");
        System.out.println("• Cross-platform compatibility");
        
        // Demonstrate structured memory layout
        System.out.println("\nStructured Memory Layout:");
        
        // Define a struct layout (similar to C struct)
        StructLayout pointLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("x"),
            ValueLayout.JAVA_INT.withName("y")
        );
        
        System.out.println("Point struct layout:");
        System.out.println("  Size: " + pointLayout.byteSize() + " bytes");
        System.out.println("  Alignment: " + pointLayout.byteAlignment() + " bytes");
        
        // Allocate memory for the struct
        try (MemorySegment segment = MemorySegment.allocateNative(pointLayout)) {
            // Access struct fields using var handles
            VarHandle xHandle = pointLayout.varHandle(MemoryLayout.PathElement.groupElement("x"));
            VarHandle yHandle = pointLayout.varHandle(MemoryLayout.PathElement.groupElement("y"));
            
            // Set struct values
            xHandle.set(segment, 10);
            yHandle.set(segment, 20);
            
            // Get struct values
            int x = (int) xHandle.get(segment);
            int y = (int) yHandle.get(segment);
            
            System.out.println("Point coordinates: (" + x + ", " + y + ")");
        }
        
        // Demonstrate array layout
        System.out.println("\nArray Layout:");
        
        SequenceLayout arrayLayout = MemoryLayout.sequenceLayout(5, ValueLayout.JAVA_INT);
        
        System.out.println("Integer array layout:");
        System.out.println("  Element count: " + arrayLayout.elementCount());
        System.out.println("  Element size: " + arrayLayout.elementLayout().byteSize() + " bytes");
        System.out.println("  Total size: " + arrayLayout.byteSize() + " bytes");
        
        try (MemorySegment segment = MemorySegment.allocateNative(arrayLayout)) {
            VarHandle arrayHandle = arrayLayout.varHandle(MemoryLayout.PathElement.sequenceElement());
            
            // Set array values
            for (int i = 0; i < 5; i++) {
                arrayHandle.set(segment, i, i * i);
            }
            
            // Get array values
            System.out.println("Array values:");
            for (int i = 0; i < 5; i++) {
                int value = (int) arrayHandle.get(segment, i);
                System.out.println("  [" + i + "] = " + value);
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates function descriptors and handles
     */
    private static void demonstrateFunctionDescriptors() {
        System.out.println("4. Function Descriptors and Handles:");
        System.out.println("===================================");
        
        System.out.println("Function Descriptors:");
        System.out.println("• Describe native function signatures");
        System.out.println("• Type-safe function calls");
        System.out.println("• Automatic parameter marshalling");
        System.out.println("• Return value handling");
        
        // Demonstrate function descriptor creation
        System.out.println("\nFunction Descriptor Examples:");
        
        // Simple function: int add(int a, int b)
        FunctionDescriptor addDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );
        
        System.out.println("Add function descriptor:");
        System.out.println("  Return type: " + addDescriptor.returnLayout());
        System.out.println("  Parameter count: " + addDescriptor.argumentLayouts().size());
        
        // Function with no parameters: void print_hello()
        FunctionDescriptor printDescriptor = FunctionDescriptor.ofVoid();
        
        System.out.println("Print function descriptor:");
        System.out.println("  Return type: " + printDescriptor.returnLayout());
        System.out.println("  Parameter count: " + printDescriptor.argumentLayouts().size());
        
        // Function with pointer parameter: void process_data(int* data, int size)
        FunctionDescriptor processDescriptor = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );
        
        System.out.println("Process function descriptor:");
        System.out.println("  Return type: " + processDescriptor.returnLayout());
        System.out.println("  Parameter count: " + processDescriptor.argumentLayouts().size());
        
        System.out.println("\nFunction Handles:");
        System.out.println("• Method handles for native functions");
        System.out.println("• Type-safe function invocation");
        System.out.println("• Performance optimization");
        System.out.println("• Exception handling");
        
        System.out.println("\nNote: Actual function handle creation requires native library");
        System.out.println("Example:");
        System.out.println("SymbolLookup lookup = SymbolLookup.loaderLookup();");
        System.out.println("MethodHandle addHandle = Linker.nativeLinker().downcallHandle(");
        System.out.println("    lookup.find(\"add\").orElseThrow(),");
        System.out.println("    addDescriptor");
        System.out.println(");");
        
        System.out.println();
    }
    
    /**
     * Demonstrates native library integration
     */
    private static void demonstrateNativeLibraryIntegration() {
        System.out.println("5. Native Library Integration:");
        System.out.println("=============================");
        
        System.out.println("Native Library Integration:");
        System.out.println("• Loading native libraries");
        System.out.println("• Symbol resolution");
        System.out.println("• Function binding");
        System.out.println("• Data marshalling");
        
        System.out.println("\nLibrary Loading:");
        System.out.println("• System.loadLibrary(\"mylib\")");
        System.out.println("• SymbolLookup.loaderLookup()");
        System.out.println("• SymbolLookup.libraryLookup()");
        System.out.println("• Automatic library management");
        
        System.out.println("\nSymbol Resolution:");
        System.out.println("• Finding native symbols");
        System.out.println("• Function name resolution");
        System.out.println("• Variable name resolution");
        System.out.println("• Error handling for missing symbols");
        
        System.out.println("\nExample Integration Pattern:");
        System.out.println("// 1. Load native library");
        System.out.println("System.loadLibrary(\"mylib\");");
        System.out.println();
        System.out.println("// 2. Create symbol lookup");
        System.out.println("SymbolLookup lookup = SymbolLookup.loaderLookup();");
        System.out.println();
        System.out.println("// 3. Find function symbol");
        System.out.println("MemorySegment symbol = lookup.find(\"my_function\").orElseThrow();");
        System.out.println();
        System.out.println("// 4. Create function descriptor");
        System.out.println("FunctionDescriptor descriptor = FunctionDescriptor.of(");
        System.out.println("    ValueLayout.JAVA_INT,");
        System.out.println("    ValueLayout.JAVA_INT,");
        System.out.println("    ValueLayout.JAVA_INT");
        System.out.println(");");
        System.out.println();
        System.out.println("// 5. Create method handle");
        System.out.println("MethodHandle handle = Linker.nativeLinker().downcallHandle(");
        System.out.println("    symbol, descriptor");
        System.out.println(");");
        System.out.println();
        System.out.println("// 6. Call native function");
        System.out.println("int result = (int) handle.invoke(10, 20);");
        
        System.out.println("\nData Marshalling:");
        System.out.println("• Automatic type conversion");
        System.out.println("• Java to native type mapping");
        System.out.println("• Memory layout optimization");
        System.out.println("• Endianness handling");
        
        System.out.println("\nType Mappings:");
        System.out.println("Java Type -> Native Type");
        System.out.println("int -> int32_t");
        System.out.println("long -> int64_t");
        System.out.println("float -> float");
        System.out.println("double -> double");
        System.out.println("boolean -> bool");
        System.out.println("MemorySegment -> void*");
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices for FFM API usage
     */
    private static void demonstrateBestPractices() {
        System.out.println("6. Best Practices:");
        System.out.println("=================");
        
        System.out.println("Memory Management Best Practices:");
        System.out.println("✓ Use try-with-resources for memory segments");
        System.out.println("✓ Always check memory segment bounds");
        System.out.println("✓ Use appropriate memory layouts");
        System.out.println("✓ Avoid memory leaks with proper cleanup");
        System.out.println("✓ Use memory barriers when needed");
        
        System.out.println("\nFunction Call Best Practices:");
        System.out.println("✓ Use appropriate function descriptors");
        System.out.println("✓ Handle native function errors properly");
        System.out.println("✓ Use method handles for performance");
        System.out.println("✓ Cache method handles when possible");
        System.out.println("✓ Validate function parameters");
        
        System.out.println("\nPerformance Best Practices:");
        System.out.println("✓ Minimize native function calls");
        System.out.println("✓ Use bulk operations when possible");
        System.out.println("✓ Cache frequently used symbols");
        System.out.println("✓ Use appropriate memory layouts");
        System.out.println("✓ Profile native code performance");
        
        System.out.println("\nSecurity Best Practices:");
        System.out.println("✓ Validate all inputs to native functions");
        System.out.println("✓ Use memory-safe access patterns");
        System.out.println("✓ Avoid buffer overflows");
        System.out.println("✓ Handle native errors gracefully");
        System.out.println("✓ Use secure coding practices");
        
        System.out.println("\nError Handling Best Practices:");
        System.out.println("✓ Handle native function errors");
        System.out.println("✓ Use appropriate exception types");
        System.out.println("✓ Log errors for debugging");
        System.out.println("✓ Provide meaningful error messages");
        System.out.println("✓ Implement fallback mechanisms");
        
        System.out.println("\nTesting Best Practices:");
        System.out.println("✓ Test native function calls thoroughly");
        System.out.println("✓ Use mock native libraries for testing");
        System.out.println("✓ Test error conditions");
        System.out.println("✓ Validate memory management");
        System.out.println("✓ Test cross-platform compatibility");
        
        System.out.println("\nCommon Pitfalls to Avoid:");
        System.out.println("❌ Don't forget to close memory segments");
        System.out.println("❌ Don't access memory after segment is closed");
        System.out.println("❌ Don't ignore native function errors");
        System.out.println("❌ Don't use incorrect function descriptors");
        System.out.println("❌ Don't forget to handle endianness");
        
        System.out.println("\nExample: Proper FFM API Usage");
        System.out.println("try (MemorySegment segment = MemorySegment.allocateNative(1024)) {");
        System.out.println("    // Use memory segment");
        System.out.println("    segment.set(ValueLayout.JAVA_INT, 0, 42);");
        System.out.println("    int value = segment.get(ValueLayout.JAVA_INT, 0);");
        System.out.println("    System.out.println(\"Value: \" + value);");
        System.out.println("} // Memory automatically deallocated");
        
        System.out.println();
    }
}

/**
 * Example class demonstrating FFM API usage patterns
 */
class FFMAPIExample {
    
    private final Linker linker;
    private final SymbolLookup lookup;
    
    public FFMAPIExample() {
        this.linker = Linker.nativeLinker();
        this.lookup = SymbolLookup.loaderLookup();
    }
    
    /**
     * Example of calling a native function
     */
    public int callNativeFunction(int a, int b) {
        try {
            // Find native function symbol
            MemorySegment symbol = lookup.find("add").orElseThrow();
            
            // Create function descriptor
            FunctionDescriptor descriptor = FunctionDescriptor.of(
                ValueLayout.JAVA_INT,
                ValueLayout.JAVA_INT,
                ValueLayout.JAVA_INT
            );
            
            // Create method handle
            MethodHandle handle = linker.downcallHandle(symbol, descriptor);
            
            // Call native function
            return (int) handle.invoke(a, b);
            
        } catch (Throwable e) {
            throw new RuntimeException("Failed to call native function", e);
        }
    }
    
    /**
     * Example of working with structured data
     */
    public void workWithStructuredData() {
        // Define struct layout
        StructLayout personLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("id"),
            ValueLayout.ADDRESS.withName("name"),
            ValueLayout.JAVA_INT.withName("age")
        );
        
        try (MemorySegment segment = MemorySegment.allocateNative(personLayout)) {
            // Create var handles for struct fields
            VarHandle idHandle = personLayout.varHandle(MemoryLayout.PathElement.groupElement("id"));
            VarHandle nameHandle = personLayout.varHandle(MemoryLayout.PathElement.groupElement("name"));
            VarHandle ageHandle = personLayout.varHandle(MemoryLayout.PathElement.groupElement("age"));
            
            // Set struct values
            idHandle.set(segment, 1);
            ageHandle.set(segment, 30);
            
            // Allocate memory for name string
            try (MemorySegment nameSegment = MemorySegment.allocateNative(50)) {
                nameSegment.setUtf8String(0, "John Doe");
                nameHandle.set(segment, nameSegment);
                
                // Get struct values
                int id = (int) idHandle.get(segment);
                MemorySegment name = (MemorySegment) nameHandle.get(segment);
                int age = (int) ageHandle.get(segment);
                
                System.out.println("Person: ID=" + id + ", Name=" + name.getUtf8String(0) + ", Age=" + age);
            }
        }
    }
}
