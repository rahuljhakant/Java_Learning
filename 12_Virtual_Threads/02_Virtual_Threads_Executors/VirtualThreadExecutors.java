package com.tutorial.virtual.threads;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Virtual Thread Executors - Advanced Thread Management
 * 
 * This comprehensive tutorial demonstrates virtual thread executors,
 * thread pools, and advanced virtual thread management in Java.
 * Learn how to use virtual threads effectively for high-performance
 * concurrent applications.
 * 
 * LEARNING OBJECTIVES:
 * - Use virtual thread executors effectively
 * - Configure virtual thread pools
 * - Handle virtual thread lifecycle
 * - Apply virtual thread best practices
 * - Monitor virtual thread performance
 * - Integrate with existing thread code
 * 
 * KEY CONCEPTS:
 * 1. Virtual Thread Executors: Executor for virtual threads
 * 2. Thread Pool Management: Configuring virtual thread pools
 * 3. Task Execution: Submitting and managing tasks
 * 4. Performance Monitoring: Tracking virtual thread performance
 * 5. Best Practices: Effective virtual thread usage
 * 6. Integration: Using virtual threads with existing code
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class VirtualThreadExecutors {
    
    public static void main(String[] args) {
        System.out.println("=== Virtual Thread Executors Demo ===");
        System.out.println();
        
        // 1. Basic Virtual Thread Executor
        demonstrateBasicVirtualThreadExecutor();
        
        // 2. Virtual Thread Pool
        demonstrateVirtualThreadPool();
        
        // 3. Task Submission and Management
        demonstrateTaskSubmission();
        
        // 4. Performance Comparison
        demonstratePerformanceComparison();
        
        // 5. Error Handling
        demonstrateErrorHandling();
        
        // 6. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic virtual thread executor
     */
    private static void demonstrateBasicVirtualThreadExecutor() {
        System.out.println("1. Basic Virtual Thread Executor:");
        System.out.println("=================================");
        
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            System.out.println("Virtual thread executor created");
            
            // Submit tasks
            Future<String> future1 = executor.submit(() -> {
                Thread.sleep(1000);
                return "Task 1 completed";
            });
            
            Future<String> future2 = executor.submit(() -> {
                Thread.sleep(500);
                return "Task 2 completed";
            });
            
            // Wait for results
            System.out.println("Result 1: " + future1.get());
            System.out.println("Result 2: " + future2.get());
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates virtual thread pool
     */
    private static void demonstrateVirtualThreadPool() {
        System.out.println("2. Virtual Thread Pool:");
        System.out.println("======================");
        
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            System.out.println("Virtual thread pool created");
            
            // Submit multiple tasks
            List<Future<Integer>> futures = IntStream.range(0, 10)
                .mapToObj(i -> executor.submit(() -> {
                    Thread.sleep(1000);
                    return i * i;
                }))
                .toList();
            
            // Collect results
            List<Integer> results = futures.stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        return -1;
                    }
                })
                .toList();
            
            System.out.println("Results: " + results);
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates task submission and management
     */
    private static void demonstrateTaskSubmission() {
        System.out.println("3. Task Submission and Management:");
        System.out.println("=================================");
        
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            System.out.println("Virtual thread executor created");
            
            // Submit different types of tasks
            CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return "Async task completed";
            }, executor);
            
            CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return "Another async task completed";
            }, executor);
            
            // Combine results
            CompletableFuture<String> combined = future1.thenCombine(future2, (result1, result2) -> 
                result1 + " and " + result2);
            
            System.out.println("Combined result: " + combined.get());
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance comparison
     */
    private static void demonstratePerformanceComparison() {
        System.out.println("4. Performance Comparison:");
        System.out.println("=========================");
        
        int taskCount = 1000;
        int taskDuration = 100; // milliseconds
        
        // Test with virtual threads
        long startTime = System.currentTimeMillis();
        try (ExecutorService virtualExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Future<Void>> futures = IntStream.range(0, taskCount)
                .mapToObj(i -> virtualExecutor.submit(() -> {
                    try {
                        Thread.sleep(taskDuration);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    return null;
                }))
                .toList();
            
            // Wait for all tasks to complete
            futures.forEach(future -> {
                try {
                    future.get();
                } catch (Exception e) {
                    // Handle exception
                }
            });
        }
        long virtualThreadTime = System.currentTimeMillis() - startTime;
        
        // Test with platform threads
        startTime = System.currentTimeMillis();
        try (ExecutorService platformExecutor = Executors.newFixedThreadPool(10)) {
            List<Future<Void>> futures = IntStream.range(0, taskCount)
                .mapToObj(i -> platformExecutor.submit(() -> {
                    try {
                        Thread.sleep(taskDuration);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    return null;
                }))
                .toList();
            
            // Wait for all tasks to complete
            futures.forEach(future -> {
                try {
                    future.get();
                } catch (Exception e) {
                    // Handle exception
                }
            });
        }
        long platformThreadTime = System.currentTimeMillis() - startTime;
        
        System.out.println("Task count: " + taskCount);
        System.out.println("Task duration: " + taskDuration + " ms");
        System.out.println("Virtual threads time: " + virtualThreadTime + " ms");
        System.out.println("Platform threads time: " + platformThreadTime + " ms");
        System.out.println("Performance ratio: " + (double) platformThreadTime / virtualThreadTime);
        
        System.out.println();
    }
    
    /**
     * Demonstrates error handling
     */
    private static void demonstrateErrorHandling() {
        System.out.println("5. Error Handling:");
        System.out.println("=================");
        
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            System.out.println("Virtual thread executor created");
            
            // Submit tasks with potential errors
            List<Future<String>> futures = IntStream.range(0, 5)
                .mapToObj(i -> executor.submit(() -> {
                    if (i == 2) {
                        throw new RuntimeException("Task " + i + " failed");
                    }
                    return "Task " + i + " completed";
                }))
                .toList();
            
            // Handle results and errors
            futures.forEach(future -> {
                try {
                    String result = future.get();
                    System.out.println("Success: " + result);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getCause().getMessage());
                }
            });
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("6. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use virtual threads for I/O-bound tasks");
        System.out.println("✓ Use platform threads for CPU-intensive tasks");
        System.out.println("✓ Use try-with-resources for executor management");
        System.out.println("✓ Handle exceptions properly in virtual threads");
        System.out.println("✓ Use CompletableFuture for complex async operations");
        System.out.println("✓ Monitor virtual thread performance");
        System.out.println("✓ Use virtual threads with existing thread code");
        System.out.println("✓ Consider thread-local variables carefully");
        System.out.println("✓ Use proper synchronization when needed");
        System.out.println("✓ Test virtual thread behavior thoroughly");
        
        System.out.println();
    }
    
    /**
     * Utility method to create a virtual thread executor
     */
    public static ExecutorService createVirtualThreadExecutor() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }
    
    /**
     * Utility method to submit a task to virtual thread executor
     */
    public static <T> CompletableFuture<T> submitTask(ExecutorService executor, java.util.function.Supplier<T> task) {
        return CompletableFuture.supplyAsync(task, executor);
    }
    
    /**
     * Utility method to submit multiple tasks
     */
    public static <T> List<CompletableFuture<T>> submitTasks(ExecutorService executor, 
                                                           List<java.util.function.Supplier<T>> tasks) {
        return tasks.stream()
            .map(task -> CompletableFuture.supplyAsync(task, executor))
            .toList();
    }
    
    /**
     * Utility method to wait for all tasks to complete
     */
    public static <T> List<T> waitForAllTasks(List<CompletableFuture<T>> futures) {
        return futures.stream()
            .map(future -> {
                try {
                    return future.get();
                } catch (Exception e) {
                    throw new RuntimeException("Task failed", e);
                }
            })
            .toList();
    }
}
