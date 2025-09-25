package com.tutorial.advanced;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Executor Framework Demo - Advanced Thread Management
 * 
 * This comprehensive tutorial demonstrates the Java Executor Framework,
 * which provides a higher-level replacement for working with threads directly.
 * The Executor Framework simplifies thread management and provides better
 * performance and resource utilization.
 * 
 * LEARNING OBJECTIVES:
 * - Understand the Executor Framework and its benefits
 * - Use different types of Executors (Fixed, Cached, Single, Scheduled)
 * - Implement ThreadPoolExecutor for custom thread pools
 * - Handle asynchronous operations with CompletableFuture
 * - Use Fork/Join framework for parallel processing
 * - Apply best practices for thread pool management
 * 
 * KEY CONCEPTS:
 * 1. Executor Interface: Basic interface for executing tasks
 * 2. ExecutorService: Extended interface with lifecycle management
 * 3. Thread Pools: Pre-created threads for task execution
 * 4. Future: Represents result of asynchronous computation
 * 5. CompletableFuture: Enhanced Future with completion callbacks
 * 6. Fork/Join: Framework for parallel divide-and-conquer algorithms
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class ExecutorFramework {
    
    public static void main(String[] args) {
        System.out.println("=== Executor Framework Demo ===");
        System.out.println();
        
        // 1. Basic Executor Usage
        demonstrateBasicExecutor();
        
        // 2. Different Types of Executors
        demonstrateExecutorTypes();
        
        // 3. ThreadPoolExecutor
        demonstrateThreadPoolExecutor();
        
        // 4. Scheduled Executor
        demonstrateScheduledExecutor();
        
        // 5. CompletableFuture
        demonstrateCompletableFuture();
        
        // 6. Fork/Join Framework
        demonstrateForkJoin();
        
        // 7. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic Executor usage
     */
    private static void demonstrateBasicExecutor() {
        System.out.println("1. Basic Executor Usage:");
        System.out.println("=======================");
        
        // Create a simple executor
        Executor executor = Executors.newSingleThreadExecutor();
        
        // Submit tasks
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " executed by: " + 
                    Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        System.out.println("All tasks submitted to single thread executor");
        System.out.println();
    }
    
    /**
     * Demonstrates different types of executors
     */
    private static void demonstrateExecutorTypes() {
        System.out.println("2. Different Types of Executors:");
        System.out.println("===============================");
        
        // Fixed Thread Pool
        System.out.println("Fixed Thread Pool (4 threads):");
        ExecutorService fixedPool = Executors.newFixedThreadPool(4);
        submitTasks(fixedPool, "FixedPool");
        shutdownExecutor(fixedPool);
        
        // Cached Thread Pool
        System.out.println("\nCached Thread Pool:");
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        submitTasks(cachedPool, "CachedPool");
        shutdownExecutor(cachedPool);
        
        // Single Thread Executor
        System.out.println("\nSingle Thread Executor:");
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        submitTasks(singleThread, "SingleThread");
        shutdownExecutor(singleThread);
        
        System.out.println();
    }
    
    /**
     * Demonstrates ThreadPoolExecutor for custom configuration
     */
    private static void demonstrateThreadPoolExecutor() {
        System.out.println("3. ThreadPoolExecutor:");
        System.out.println("=====================");
        
        // Custom ThreadPoolExecutor
        ThreadPoolExecutor customPool = new ThreadPoolExecutor(
            2,                          // Core pool size
            5,                          // Maximum pool size
            60L,                        // Keep alive time
            TimeUnit.SECONDS,           // Time unit
            new LinkedBlockingQueue<>(10), // Work queue
            new ThreadFactory() {       // Custom thread factory
                private final AtomicInteger threadNumber = new AtomicInteger(1);
                
                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r, "CustomThread-" + threadNumber.getAndIncrement());
                    t.setDaemon(false);
                    return t;
                }
            },
            new ThreadPoolExecutor.CallerRunsPolicy() // Rejection policy
        );
        
        System.out.println("Custom ThreadPoolExecutor created:");
        System.out.println("Core pool size: " + customPool.getCorePoolSize());
        System.out.println("Maximum pool size: " + customPool.getMaximumPoolSize());
        System.out.println("Queue capacity: " + customPool.getQueue().remainingCapacity());
        
        // Submit tasks
        for (int i = 1; i <= 8; i++) {
            final int taskId = i;
            customPool.submit(() -> {
                System.out.println("Custom task " + taskId + " executed by: " + 
                    Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        // Monitor pool
        System.out.println("Active threads: " + customPool.getActiveCount());
        System.out.println("Completed tasks: " + customPool.getCompletedTaskCount());
        
        shutdownExecutor(customPool);
        System.out.println();
    }
    
    /**
     * Demonstrates ScheduledExecutorService
     */
    private static void demonstrateScheduledExecutor() {
        System.out.println("4. Scheduled Executor:");
        System.out.println("=====================");
        
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        
        // Schedule a task to run after delay
        System.out.println("Scheduling task to run after 2 seconds...");
        scheduler.schedule(() -> {
            System.out.println("Delayed task executed at: " + System.currentTimeMillis());
        }, 2, TimeUnit.SECONDS);
        
        // Schedule a task to run periodically
        System.out.println("Scheduling periodic task (every 1 second)...");
        ScheduledFuture<?> periodicTask = scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Periodic task executed at: " + System.currentTimeMillis());
        }, 0, 1, TimeUnit.SECONDS);
        
        // Let it run for a few seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Cancel periodic task
        periodicTask.cancel(false);
        System.out.println("Periodic task cancelled");
        
        shutdownExecutor(scheduler);
        System.out.println();
    }
    
    /**
     * Demonstrates CompletableFuture for asynchronous operations
     */
    private static void demonstrateCompletableFuture() {
        System.out.println("5. CompletableFuture:");
        System.out.println("===================");
        
        // Simple CompletableFuture
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Hello from CompletableFuture!";
        });
        
        // Chain operations
        CompletableFuture<String> chainedFuture = future
            .thenApply(result -> result.toUpperCase())
            .thenApply(result -> result + " - Processed");
        
        // Handle completion
        chainedFuture.thenAccept(result -> {
            System.out.println("Final result: " + result);
        });
        
        // Combine multiple futures
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");
        
        CompletableFuture<String> combined = future1.thenCombine(future2, (s1, s2) -> s1 + " " + s2);
        combined.thenAccept(result -> System.out.println("Combined result: " + result));
        
        // Wait for completion
        try {
            chainedFuture.get(5, TimeUnit.SECONDS);
            combined.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.err.println("Error waiting for completion: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates Fork/Join framework
     */
    private static void demonstrateForkJoin() {
        System.out.println("6. Fork/Join Framework:");
        System.out.println("=====================");
        
        // Create array of numbers
        int[] numbers = IntStream.rangeClosed(1, 1000000).toArray();
        
        // Create ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        
        // Create task
        SumTask task = new SumTask(numbers, 0, numbers.length);
        
        // Execute task
        long startTime = System.currentTimeMillis();
        Long result = forkJoinPool.invoke(task);
        long endTime = System.currentTimeMillis();
        
        System.out.println("Sum of numbers 1 to 1,000,000: " + result);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        
        forkJoinPool.shutdown();
        System.out.println();
    }
    
    /**
     * Demonstrates best practices for Executor Framework
     */
    private static void demonstrateBestPractices() {
        System.out.println("7. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use appropriate executor type for your use case");
        System.out.println("✓ Always shutdown executors to prevent resource leaks");
        System.out.println("✓ Use CompletableFuture for complex asynchronous operations");
        System.out.println("✓ Consider thread pool size based on CPU cores and I/O operations");
        System.out.println("✓ Use proper exception handling in submitted tasks");
        System.out.println("✓ Monitor thread pool metrics for performance tuning");
        System.out.println("✓ Use Fork/Join for CPU-intensive parallel tasks");
        System.out.println("✓ Avoid blocking operations in thread pool threads");
        
        System.out.println();
    }
    
    /**
     * Helper method to submit tasks to executor
     */
    private static void submitTasks(ExecutorService executor, String poolName) {
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("  " + poolName + " Task " + taskId + " by: " + 
                    Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
    }
    
    /**
     * Helper method to shutdown executor properly
     */
    private static void shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    System.err.println("Executor did not terminate");
                }
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Fork/Join task for calculating sum of array elements
     */
    static class SumTask extends RecursiveTask<Long> {
        private final int[] array;
        private final int start;
        private final int end;
        private static final int THRESHOLD = 10000;
        
        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        
        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                // Base case: compute sum directly
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                // Recursive case: split task
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);
                
                leftTask.fork();
                long rightResult = rightTask.compute();
                long leftResult = leftTask.join();
                
                return leftResult + rightResult;
            }
        }
    }
}


