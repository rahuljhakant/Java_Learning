/**
 * JVM Memory Management - Comprehensive Tutorial
 * 
 * This comprehensive tutorial demonstrates JVM memory management concepts,
 * including heap memory, stack memory, garbage collection, and memory
 * optimization techniques. Understanding JVM memory management is crucial
 * for writing efficient Java applications and troubleshooting performance issues.
 * 
 * LEARNING OBJECTIVES:
 * - Understand JVM memory structure and organization
 * - Learn about heap memory and its generations
 * - Understand stack memory and method execution
 * - Master garbage collection concepts and algorithms
 * - Learn memory optimization techniques
 * - Understand memory leaks and how to prevent them
 * - Practice memory monitoring and analysis
 * 
 * KEY CONCEPTS:
 * 1. Heap Memory: Object storage and garbage collection
 * 2. Stack Memory: Method calls and local variables
 * 3. Method Area: Class metadata and constant pool
 * 4. Garbage Collection: Automatic memory management
 * 5. Memory Generations: Young, Old, and Permanent generations
 * 6. GC Algorithms: Different garbage collection strategies
 * 7. Memory Tuning: JVM parameters for memory optimization
 * 8. Memory Monitoring: Tools for memory analysis
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.GarbageCollectorMXBean;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * JVM Memory Management Demo - Main demonstration class
 * 
 * This class demonstrates various JVM memory management concepts including
 * memory monitoring, garbage collection, and memory optimization techniques.
 */
public class MemoryManagement {
    
    public static void main(String[] args) {
        System.out.println("=== JVM Memory Management Tutorial ===");
        System.out.println();
        
        // 1. JVM memory structure overview
        demonstrateJVMMemoryStructure();
        
        // 2. Memory monitoring
        demonstrateMemoryMonitoring();
        
        // 3. Garbage collection
        demonstrateGarbageCollection();
        
        // 4. Memory optimization techniques
        demonstrateMemoryOptimization();
        
        // 5. Memory leaks and prevention
        demonstrateMemoryLeaks();
        
        // 6. JVM tuning parameters
        demonstrateJVMTuning();
    }
    
    /**
     * Demonstrates JVM memory structure and organization
     */
    private static void demonstrateJVMMemoryStructure() {
        System.out.println("1. JVM Memory Structure:");
        System.out.println("=======================");
        
        System.out.println("JVM Memory Areas:");
        System.out.println("• Heap Memory: Object storage and garbage collection");
        System.out.println("• Stack Memory: Method calls and local variables");
        System.out.println("• Method Area: Class metadata and constant pool");
        System.out.println("• PC Register: Program counter for current instruction");
        System.out.println("• Native Method Stack: Native method calls");
        
        System.out.println("\nHeap Memory Structure:");
        System.out.println("• Young Generation: New objects and short-lived objects");
        System.out.println("  - Eden Space: New object allocation");
        System.out.println("  - Survivor Spaces: Objects that survive minor GC");
        System.out.println("• Old Generation: Long-lived objects");
        System.out.println("• Metaspace (Java 8+): Class metadata storage");
        
        System.out.println("\nStack Memory:");
        System.out.println("• Each thread has its own stack");
        System.out.println("• Stores method parameters and local variables");
        System.out.println("• LIFO (Last In, First Out) structure");
        System.out.println("• Stack overflow occurs when stack is full");
        
        System.out.println("\nMemory Allocation:");
        System.out.println("• Objects are allocated in heap memory");
        System.out.println("• Local variables are stored in stack memory");
        System.out.println("• Class metadata is stored in method area");
        System.out.println("• Strings may be stored in string pool");
        
        System.out.println();
    }
    
    /**
     * Demonstrates memory monitoring and analysis
     */
    private static void demonstrateMemoryMonitoring() {
        System.out.println("2. Memory Monitoring:");
        System.out.println("===================");
        
        // Get memory management bean
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        
        // Heap memory usage
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        System.out.println("Heap Memory Usage:");
        System.out.println("  Initial: " + formatBytes(heapUsage.getInit()));
        System.out.println("  Used: " + formatBytes(heapUsage.getUsed()));
        System.out.println("  Committed: " + formatBytes(heapUsage.getCommitted()));
        System.out.println("  Max: " + formatBytes(heapUsage.getMax()));
        
        // Non-heap memory usage
        MemoryUsage nonHeapUsage = memoryBean.getNonHeapMemoryUsage();
        System.out.println("\nNon-Heap Memory Usage:");
        System.out.println("  Initial: " + formatBytes(nonHeapUsage.getInit()));
        System.out.println("  Used: " + formatBytes(nonHeapUsage.getUsed()));
        System.out.println("  Committed: " + formatBytes(nonHeapUsage.getCommitted()));
        System.out.println("  Max: " + formatBytes(nonHeapUsage.getMax()));
        
        // Memory pool information
        System.out.println("\nMemory Pools:");
        ManagementFactory.getMemoryPoolMXBeans().forEach(pool -> {
            System.out.println("  " + pool.getName() + ": " + 
                formatBytes(pool.getUsage().getUsed()) + " / " + 
                formatBytes(pool.getUsage().getMax()));
        });
        
        // Runtime memory information
        Runtime runtime = Runtime.getRuntime();
        System.out.println("\nRuntime Memory Information:");
        System.out.println("  Total Memory: " + formatBytes(runtime.totalMemory()));
        System.out.println("  Free Memory: " + formatBytes(runtime.freeMemory()));
        System.out.println("  Used Memory: " + formatBytes(runtime.totalMemory() - runtime.freeMemory()));
        System.out.println("  Max Memory: " + formatBytes(runtime.maxMemory()));
        
        System.out.println();
    }
    
    /**
     * Demonstrates garbage collection concepts and monitoring
     */
    private static void demonstrateGarbageCollection() {
        System.out.println("3. Garbage Collection:");
        System.out.println("====================");
        
        System.out.println("Garbage Collection Concepts:");
        System.out.println("• Automatic memory management");
        System.out.println("• Identifies and removes unreachable objects");
        System.out.println("• Runs when memory is low or on demand");
        System.out.println("• Different algorithms for different scenarios");
        
        // Get garbage collector information
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        System.out.println("\nGarbage Collectors:");
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            System.out.println("  " + gcBean.getName() + ":");
            System.out.println("    Collections: " + gcBean.getCollectionCount());
            System.out.println("    Time: " + gcBean.getCollectionTime() + " ms");
        }
        
        // Demonstrate garbage collection
        System.out.println("\nGarbage Collection Demo:");
        long beforeGC = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        
        // Create some objects to trigger GC
        List<String> objects = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            objects.add("Object " + i);
        }
        
        long afterAllocation = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory before allocation: " + formatBytes(beforeGC));
        System.out.println("Memory after allocation: " + formatBytes(afterAllocation));
        
        // Clear references to make objects eligible for GC
        objects.clear();
        objects = null;
        
        // Suggest garbage collection
        System.gc();
        
        try {
            Thread.sleep(1000); // Wait for GC to complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        long afterGC = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory after GC: " + formatBytes(afterGC));
        System.out.println("Memory freed: " + formatBytes(afterAllocation - afterGC));
        
        System.out.println();
    }
    
    /**
     * Demonstrates memory optimization techniques
     */
    private static void demonstrateMemoryOptimization() {
        System.out.println("4. Memory Optimization Techniques:");
        System.out.println("=================================");
        
        System.out.println("Memory Optimization Strategies:");
        System.out.println("• Use appropriate data structures");
        System.out.println("• Avoid memory leaks");
        System.out.println("• Optimize object creation");
        System.out.println("• Use object pooling");
        System.out.println("• Minimize string operations");
        System.out.println("• Use primitive types when possible");
        
        // Demonstrate efficient object creation
        System.out.println("\nEfficient Object Creation:");
        long startTime = System.currentTimeMillis();
        
        // Inefficient: Creating many temporary objects
        StringBuilder inefficient = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            inefficient.append("Item ").append(i).append(", ");
        }
        
        long inefficientTime = System.currentTimeMillis() - startTime;
        System.out.println("Inefficient string concatenation: " + inefficientTime + " ms");
        
        // Efficient: Using StringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder efficient = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            efficient.append("Item ").append(i).append(", ");
        }
        
        long efficientTime = System.currentTimeMillis() - startTime;
        System.out.println("Efficient string concatenation: " + efficientTime + " ms");
        
        // Demonstrate primitive vs wrapper types
        System.out.println("\nPrimitive vs Wrapper Types:");
        System.out.println("• Use int instead of Integer when possible");
        System.out.println("• Use double instead of Double when possible");
        System.out.println("• Primitives use less memory and are faster");
        System.out.println("• Wrappers are needed for collections and generics");
        
        // Demonstrate object pooling concept
        System.out.println("\nObject Pooling Concept:");
        System.out.println("• Reuse objects instead of creating new ones");
        System.out.println("• Reduces garbage collection pressure");
        System.out.println("• Useful for expensive object creation");
        System.out.println("• Example: Database connections, threads");
        
        System.out.println();
    }
    
    /**
     * Demonstrates memory leaks and prevention techniques
     */
    private static void demonstrateMemoryLeaks() {
        System.out.println("5. Memory Leaks and Prevention:");
        System.out.println("==============================");
        
        System.out.println("Common Memory Leak Causes:");
        System.out.println("• Unclosed resources (files, streams, connections)");
        System.out.println("• Static collections that grow indefinitely");
        System.out.println("• Event listeners not removed");
        System.out.println("• Threads that don't terminate");
        System.out.println("• Circular references");
        System.out.println("• Caches without size limits");
        
        System.out.println("\nMemory Leak Prevention:");
        System.out.println("• Use try-with-resources for automatic resource management");
        System.out.println("• Remove event listeners when no longer needed");
        System.out.println("• Use weak references for caches");
        System.out.println("• Set timeouts for threads and connections");
        System.out.println("• Monitor memory usage regularly");
        System.out.println("• Use profiling tools to detect leaks");
        
        // Demonstrate try-with-resources
        System.out.println("\nTry-with-Resources Example:");
        System.out.println("try (FileInputStream fis = new FileInputStream(\"file.txt\")) {");
        System.out.println("    // Use the resource");
        System.out.println("} // Resource is automatically closed");
        
        // Demonstrate weak references
        System.out.println("\nWeak References Example:");
        System.out.println("WeakReference<Object> weakRef = new WeakReference<>(object);");
        System.out.println("// Object can be garbage collected even if weakRef exists");
        
        System.out.println("\nMemory Leak Detection:");
        System.out.println("• Monitor heap usage over time");
        System.out.println("• Use heap dumps for analysis");
        System.out.println("• Look for objects that should be collected");
        System.out.println("• Use profiling tools like JVisualVM");
        
        System.out.println();
    }
    
    /**
     * Demonstrates JVM tuning parameters
     */
    private static void demonstrateJVMTuning() {
        System.out.println("6. JVM Tuning Parameters:");
        System.out.println("========================");
        
        System.out.println("Heap Memory Tuning:");
        System.out.println("• -Xms<size>: Initial heap size");
        System.out.println("• -Xmx<size>: Maximum heap size");
        System.out.println("• -XX:NewRatio=<ratio>: Ratio of old to young generation");
        System.out.println("• -XX:SurvivorRatio=<ratio>: Ratio of Eden to Survivor spaces");
        
        System.out.println("\nGarbage Collection Tuning:");
        System.out.println("• -XX:+UseG1GC: Use G1 garbage collector");
        System.out.println("• -XX:+UseParallelGC: Use parallel garbage collector");
        System.out.println("• -XX:+UseConcMarkSweepGC: Use CMS garbage collector");
        System.out.println("• -XX:MaxGCPauseMillis=<ms>: Target GC pause time");
        
        System.out.println("\nPerformance Tuning:");
        System.out.println("• -XX:+AggressiveOpts: Enable aggressive optimizations");
        System.out.println("• -XX:+UseCompressedOops: Use compressed object pointers");
        System.out.println("• -XX:+TieredCompilation: Enable tiered compilation");
        System.out.println("• -XX:CompileThreshold=<count>: JIT compilation threshold");
        
        System.out.println("\nMonitoring and Debugging:");
        System.out.println("• -XX:+PrintGC: Print garbage collection information");
        System.out.println("• -XX:+PrintGCDetails: Print detailed GC information");
        System.out.println("• -XX:+HeapDumpOnOutOfMemoryError: Create heap dump on OOM");
        System.out.println("• -XX:HeapDumpPath=<path>: Specify heap dump location");
        
        System.out.println("\nExample JVM Arguments:");
        System.out.println("java -Xms512m -Xmx2g -XX:+UseG1GC -XX:MaxGCPauseMillis=200 \\");
        System.out.println("     -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp \\");
        System.out.println("     -jar MyApplication.jar");
        
        System.out.println();
    }
    
    /**
     * Utility method to format bytes in human-readable format
     */
    private static String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
        return String.format("%.1f GB", bytes / (1024.0 * 1024.0 * 1024.0));
    }
}

/**
 * Example class demonstrating memory-efficient design
 */
class MemoryEfficientClass {
    private final int id;
    private final String name;
    private final List<String> items;
    
    public MemoryEfficientClass(int id, String name) {
        this.id = id;
        this.name = name;
        this.items = new ArrayList<>(); // Initialize with appropriate capacity
    }
    
    public void addItem(String item) {
        items.add(item);
    }
    
    public void clearItems() {
        items.clear(); // Clear instead of creating new list
    }
    
    @Override
    public String toString() {
        return "MemoryEfficientClass{id=" + id + ", name='" + name + "', items=" + items.size() + "}";
    }
}

/**
 * Example of object pooling for memory optimization
 */
class ObjectPool<T> {
    private final List<T> pool;
    private final int maxSize;
    
    public ObjectPool(int maxSize) {
        this.pool = new ArrayList<>();
        this.maxSize = maxSize;
    }
    
    public synchronized T acquire() {
        if (pool.isEmpty()) {
            return null; // Pool is empty
        }
        return pool.remove(pool.size() - 1);
    }
    
    public synchronized void release(T object) {
        if (pool.size() < maxSize) {
            pool.add(object);
        }
    }
    
    public synchronized int size() {
        return pool.size();
    }
}
