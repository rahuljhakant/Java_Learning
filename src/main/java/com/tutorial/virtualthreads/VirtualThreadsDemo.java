/**
 * Virtual Threads (Project Loom) - Comprehensive Tutorial
 * 
 * This comprehensive tutorial demonstrates Virtual Threads, a revolutionary
 * concurrency feature introduced in Java 19 as part of Project Loom. Virtual
 * threads provide lightweight, scalable concurrency that can handle millions
 * of concurrent operations with minimal resource overhead.
 * 
 * LEARNING OBJECTIVES:
 * - Understand virtual threads and their benefits
 * - Learn how to create and manage virtual threads
 * - Master virtual thread executors and thread pools
 * - Understand virtual threads with I/O operations
 * - Learn best practices for virtual thread usage
 * - Practice advanced virtual thread features
 * - Understand migration strategies from platform threads
 * 
 * KEY CONCEPTS:
 * 1. Virtual Threads: Lightweight threads managed by the JVM
 * 2. Platform Threads: Traditional OS-managed threads
 * 3. Thread Creation: Thread.ofVirtual() and Executors
 * 4. Thread Lifecycle: Virtual thread lifecycle and management
 * 5. I/O Operations: Blocking I/O with virtual threads
 * 6. Executors: Virtual thread executors and services
 * 7. Performance: Scalability and resource efficiency
 * 8. Best Practices: Optimal virtual thread usage patterns
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;

/**
 * Virtual Threads Demo - Main demonstration class
 * 
 * This class demonstrates various virtual thread features including creation,
 * management, executors, I/O operations, and performance comparisons.
 */
public class VirtualThreadsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Virtual Threads (Project Loom) Tutorial ===");
        System.out.println();
        
        // 1. Virtual threads introduction
        demonstrateVirtualThreadsIntroduction();
        
        // 2. Creating virtual threads
        demonstrateVirtualThreadCreation();
        
        // 3. Virtual thread executors
        demonstrateVirtualThreadExecutors();
        
        // 4. Virtual threads with I/O
        demonstrateVirtualThreadsWithIO();
        
        // 5. Performance comparison
        demonstratePerformanceComparison();
        
        // 6. Best practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates virtual threads introduction and benefits
     */
    private static void demonstrateVirtualThreadsIntroduction() {
        System.out.println("1. Virtual Threads Introduction:");
        System.out.println("===============================");
        
        System.out.println("What are Virtual Threads?");
        System.out.println("• Lightweight threads managed by the JVM");
        System.out.println("• Mapped to platform threads by the JVM scheduler");
        System.out.println("• Designed for high-throughput concurrent applications");
        System.out.println("• Part of Project Loom (Java 19+)");
        
        System.out.println("\nKey Benefits:");
        System.out.println("✓ Lightweight: Millions of virtual threads with minimal memory overhead");
        System.out.println("✓ Scalable: Handle massive concurrency without thread pool limitations");
        System.out.println("✓ Simple: No need for complex async programming patterns");
        System.out.println("✓ Compatible: Works with existing blocking I/O code");
        System.out.println("✓ Efficient: Better resource utilization and performance");
        
        System.out.println("\nVirtual Threads vs Platform Threads:");
        System.out.println("Virtual Threads:");
        System.out.println("  • Managed by JVM");
        System.out.println("  • Lightweight (few KB memory)");
        System.out.println("  • Millions can exist simultaneously");
        System.out.println("  • Blocking I/O is efficient");
        System.out.println("  • No thread pool needed");
        
        System.out.println("Platform Threads:");
        System.out.println("  • Managed by OS");
        System.out.println("  • Heavyweight (1-2 MB memory)");
        System.out.println("  • Limited by OS thread limits");
        System.out.println("  • Blocking I/O blocks OS thread");
        System.out.println("  • Requires thread pools for scalability");
        
        System.out.println("\nWhen to Use Virtual Threads:");
        System.out.println("• High-throughput concurrent applications");
        System.out.println("• I/O-bound operations (file, network, database)");
        System.out.println("• Applications with many concurrent tasks");
        System.out.println("• Microservices and web applications");
        System.out.println("• Applications that benefit from simple blocking code");
        
        System.out.println();
    }
    
    /**
     * Demonstrates virtual thread creation and management
     */
    private static void demonstrateVirtualThreadCreation() {
        System.out.println("2. Virtual Thread Creation:");
        System.out.println("==========================");
        
        System.out.println("Creating Virtual Threads:");
        
        // Method 1: Using Thread.ofVirtual()
        System.out.println("\nMethod 1: Thread.ofVirtual()");
        Thread virtualThread1 = Thread.ofVirtual()
            .name("virtual-thread-1")
            .start(() -> {
                System.out.println("Virtual thread 1 running: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Virtual thread 1 completed");
            });
        
        // Method 2: Using Thread.ofVirtual().unstarted()
        System.out.println("\nMethod 2: Thread.ofVirtual().unstarted()");
        Thread virtualThread2 = Thread.ofVirtual()
            .name("virtual-thread-2")
            .unstarted(() -> {
                System.out.println("Virtual thread 2 running: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Virtual thread 2 completed");
            });
        
        virtualThread2.start();
        
        // Method 3: Using Thread.ofVirtual().factory()
        System.out.println("\nMethod 3: Thread.ofVirtual().factory()");
        Thread.Builder.OfVirtual factory = Thread.ofVirtual().name("virtual-thread-", 0);
        
        List<Thread> virtualThreads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread vt = factory.start(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Factory virtual thread running: " + threadName);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Factory virtual thread completed: " + threadName);
            });
            virtualThreads.add(vt);
        }
        
        // Wait for all threads to complete
        try {
            virtualThread1.join();
            virtualThread2.join();
            for (Thread vt : virtualThreads) {
                vt.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\nVirtual Thread Properties:");
        System.out.println("• Is Virtual: " + virtualThread1.isVirtual());
        System.out.println("• Thread Name: " + virtualThread1.getName());
        System.out.println("• Thread State: " + virtualThread1.getState());
        System.out.println("• Thread Group: " + virtualThread1.getThreadGroup().getName());
        
        System.out.println();
    }
    
    /**
     * Demonstrates virtual thread executors and services
     */
    private static void demonstrateVirtualThreadExecutors() {
        System.out.println("3. Virtual Thread Executors:");
        System.out.println("===========================");
        
        System.out.println("Virtual Thread Executors:");
        
        // Method 1: Using Executors.newVirtualThreadPerTaskExecutor()
        System.out.println("\nMethod 1: newVirtualThreadPerTaskExecutor()");
        ExecutorService virtualExecutor = Executors.newVirtualThreadPerTaskExecutor();
        
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            Future<String> future = virtualExecutor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task " + taskId + " running on: " + threadName);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return "Task " + taskId + " interrupted";
                }
                return "Task " + taskId + " completed on " + threadName;
            });
            futures.add(future);
        }
        
        // Collect results
        for (Future<String> future : futures) {
            try {
                String result = future.get();
                System.out.println("Result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Task failed: " + e.getMessage());
            }
        }
        
        virtualExecutor.shutdown();
        
        // Method 2: Using custom virtual thread executor
        System.out.println("\nMethod 2: Custom Virtual Thread Executor");
        ExecutorService customExecutor = Executors.newThreadPerTaskExecutor(
            Thread.ofVirtual().name("custom-virtual-", 0).factory()
        );
        
        AtomicInteger counter = new AtomicInteger(0);
        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                int taskId = counter.incrementAndGet();
                String threadName = Thread.currentThread().getName();
                System.out.println("Custom task " + taskId + " running on: " + threadName);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Custom task " + taskId + " completed");
            }, customExecutor);
            completableFutures.add(future);
        }
        
        // Wait for all tasks to complete
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
        
        customExecutor.shutdown();
        
        System.out.println();
    }
    
    /**
     * Demonstrates virtual threads with I/O operations
     */
    private static void demonstrateVirtualThreadsWithIO() {
        System.out.println("4. Virtual Threads with I/O:");
        System.out.println("===========================");
        
        System.out.println("I/O Operations with Virtual Threads:");
        System.out.println("• Virtual threads are perfect for I/O-bound operations");
        System.out.println("• Blocking I/O doesn't block platform threads");
        System.out.println("• JVM automatically manages thread scheduling");
        System.out.println("• No need for complex async programming patterns");
        
        // Simulate I/O operations with virtual threads
        System.out.println("\nSimulating I/O Operations:");
        
        ExecutorService ioExecutor = Executors.newVirtualThreadPerTaskExecutor();
        
        List<CompletableFuture<String>> ioFutures = new ArrayList<>();
        
        // Simulate file I/O
        ioFutures.add(CompletableFuture.supplyAsync(() -> {
            System.out.println("Starting file I/O operation on: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000); // Simulate file read
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "File I/O interrupted";
            }
            System.out.println("File I/O completed on: " + Thread.currentThread().getName());
            return "File I/O result";
        }, ioExecutor));
        
        // Simulate network I/O
        ioFutures.add(CompletableFuture.supplyAsync(() -> {
            System.out.println("Starting network I/O operation on: " + Thread.currentThread().getName());
            try {
                Thread.sleep(800); // Simulate network request
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Network I/O interrupted";
            }
            System.out.println("Network I/O completed on: " + Thread.currentThread().getName());
            return "Network I/O result";
        }, ioExecutor));
        
        // Simulate database I/O
        ioFutures.add(CompletableFuture.supplyAsync(() -> {
            System.out.println("Starting database I/O operation on: " + Thread.currentThread().getName());
            try {
                Thread.sleep(600); // Simulate database query
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Database I/O interrupted";
            }
            System.out.println("Database I/O completed on: " + Thread.currentThread().getName());
            return "Database I/O result";
        }, ioExecutor));
        
        // Wait for all I/O operations to complete
        CompletableFuture.allOf(ioFutures.toArray(new CompletableFuture[0])).join();
        
        // Collect results
        for (CompletableFuture<String> future : ioFutures) {
            try {
                String result = future.get();
                System.out.println("I/O Result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("I/O operation failed: " + e.getMessage());
            }
        }
        
        ioExecutor.shutdown();
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance comparison between virtual and platform threads
     */
    private static void demonstratePerformanceComparison() {
        System.out.println("5. Performance Comparison:");
        System.out.println("=========================");
        
        System.out.println("Performance Comparison: Virtual Threads vs Platform Threads");
        
        int taskCount = 1000;
        int sleepTime = 10; // milliseconds
        
        // Test with virtual threads
        System.out.println("\nTesting with Virtual Threads:");
        Instant start = Instant.now();
        
        ExecutorService virtualExecutor = Executors.newVirtualThreadPerTaskExecutor();
        List<CompletableFuture<Void>> virtualFutures = new ArrayList<>();
        
        for (int i = 0; i < taskCount; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, virtualExecutor);
            virtualFutures.add(future);
        }
        
        CompletableFuture.allOf(virtualFutures.toArray(new CompletableFuture[0])).join();
        virtualExecutor.shutdown();
        
        Duration virtualDuration = Duration.between(start, Instant.now());
        System.out.println("Virtual threads completed " + taskCount + " tasks in: " + 
            virtualDuration.toMillis() + " ms");
        
        // Test with platform threads (limited thread pool)
        System.out.println("\nTesting with Platform Threads (limited pool):");
        start = Instant.now();
        
        ExecutorService platformExecutor = Executors.newFixedThreadPool(100);
        List<CompletableFuture<Void>> platformFutures = new ArrayList<>();
        
        for (int i = 0; i < taskCount; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, platformExecutor);
            platformFutures.add(future);
        }
        
        CompletableFuture.allOf(platformFutures.toArray(new CompletableFuture[0])).join();
        platformExecutor.shutdown();
        
        Duration platformDuration = Duration.between(start, Instant.now());
        System.out.println("Platform threads completed " + taskCount + " tasks in: " + 
            platformDuration.toMillis() + " ms");
        
        // Performance analysis
        System.out.println("\nPerformance Analysis:");
        System.out.println("Virtual threads: " + virtualDuration.toMillis() + " ms");
        System.out.println("Platform threads: " + platformDuration.toMillis() + " ms");
        
        if (virtualDuration.toMillis() < platformDuration.toMillis()) {
            System.out.println("Virtual threads were " + 
                (platformDuration.toMillis() - virtualDuration.toMillis()) + " ms faster");
        } else {
            System.out.println("Platform threads were " + 
                (virtualDuration.toMillis() - platformDuration.toMillis()) + " ms faster");
        }
        
        System.out.println("\nMemory Usage Comparison:");
        System.out.println("Virtual threads: ~" + (taskCount * 1) + " KB (1 KB per thread)");
        System.out.println("Platform threads: ~" + (100 * 1024) + " KB (1 MB per thread, 100 threads)");
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices for virtual threads
     */
    private static void demonstrateBestPractices() {
        System.out.println("6. Virtual Threads Best Practices:");
        System.out.println("=================================");
        
        System.out.println("Best Practices for Virtual Threads:");
        
        System.out.println("\n✓ Use Virtual Threads for I/O-bound Operations:");
        System.out.println("  • File I/O operations");
        System.out.println("  • Network requests");
        System.out.println("  • Database operations");
        System.out.println("  • Web service calls");
        
        System.out.println("\n✓ Avoid CPU-intensive Tasks:");
        System.out.println("  • Mathematical computations");
        System.out.println("  • Image processing");
        System.out.println("  • Data compression");
        System.out.println("  • Use platform threads for CPU-bound work");
        
        System.out.println("\n✓ Use Executors.newVirtualThreadPerTaskExecutor():");
        System.out.println("  • Preferred way to create virtual thread executors");
        System.out.println("  • Automatically manages virtual thread lifecycle");
        System.out.println("  • No need to manage thread pools");
        
        System.out.println("\n✓ Handle Exceptions Properly:");
        System.out.println("  • Use try-catch blocks in virtual thread tasks");
        System.out.println("  • Handle InterruptedException correctly");
        System.out.println("  • Log exceptions for debugging");
        
        System.out.println("\n✓ Monitor Virtual Thread Performance:");
        System.out.println("  • Use JFR (Java Flight Recorder) for monitoring");
        System.out.println("  • Monitor thread creation and destruction");
        System.out.println("  • Watch for memory usage patterns");
        
        System.out.println("\n✓ Migration Strategy:");
        System.out.println("  • Start with I/O-bound operations");
        System.out.println("  • Gradually migrate blocking code");
        System.out.println("  • Test thoroughly before production");
        System.out.println("  • Monitor performance improvements");
        
        System.out.println("\n✓ Common Pitfalls to Avoid:");
        System.out.println("  • Don't use virtual threads for CPU-intensive tasks");
        System.out.println("  • Don't create too many virtual threads unnecessarily");
        System.out.println("  • Don't ignore exception handling");
        System.out.println("  • Don't forget to shutdown executors");
        
        System.out.println("\nExample: Proper Virtual Thread Usage");
        System.out.println("ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();");
        System.out.println("try {");
        System.out.println("    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {");
        System.out.println("        try {");
        System.out.println("            // I/O operation here");
        System.out.println("            return \"result\";");
        System.out.println("        } catch (Exception e) {");
        System.out.println("            // Handle exception");
        System.out.println("            return \"error\";");
        System.out.println("        }");
        System.out.println("    }, executor);");
        System.out.println("    String result = future.get();");
        System.out.println("} finally {");
        System.out.println("    executor.shutdown();");
        System.out.println("}");
        
        System.out.println();
    }
}

/**
 * Example service class demonstrating virtual thread usage
 */
class VirtualThreadService {
    
    private final ExecutorService executor;
    
    public VirtualThreadService() {
        this.executor = Executors.newVirtualThreadPerTaskExecutor();
    }
    
    public CompletableFuture<String> processData(String data) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate I/O operation
                Thread.sleep(100);
                return "Processed: " + data;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Processing interrupted";
            }
        }, executor);
    }
    
    public void shutdown() {
        executor.shutdown();
    }
}

/**
 * Example of virtual thread with structured concurrency
 */
class StructuredConcurrencyExample {
    
    public String processWithStructuredConcurrency() {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(100);
                    return "Task 1 result";
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return "Task 1 interrupted";
                }
            }, executor);
            
            CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(150);
                    return "Task 2 result";
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return "Task 2 interrupted";
                }
            }, executor);
            
            // Wait for both tasks to complete
            CompletableFuture<String> combined = task1.thenCombine(task2, 
                (result1, result2) -> result1 + " + " + result2);
            
            return combined.join();
        }
    }
}
