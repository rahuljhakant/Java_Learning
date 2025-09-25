package com.tutorial.performance.profiling;

import java.util.*;
import java.util.concurrent.*;

/**
 * Profiling Basics - Performance Analysis Fundamentals
 * 
 * This comprehensive tutorial demonstrates performance profiling concepts
 * and techniques in Java. Learn how to identify bottlenecks, analyze
 * performance metrics, and optimize application performance.
 * 
 * LEARNING OBJECTIVES:
 * - Understand performance profiling concepts and importance
 * - Identify common performance bottlenecks
 * - Use profiling techniques and tools
 * - Analyze CPU and memory usage patterns
 * - Implement performance monitoring
 * - Apply profiling best practices
 * 
 * KEY CONCEPTS:
 * 1. Profiling Types: CPU, memory, I/O, and thread profiling
 * 2. Bottleneck Identification: Finding performance issues
 * 3. Performance Metrics: Key performance indicators
 * 4. Profiling Tools: JVisualVM, JProfiler, and built-in tools
 * 5. Optimization Strategies: Performance improvement techniques
 * 6. Best Practices: Effective profiling and monitoring
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class ProfilingBasics {
    
    public static void main(String[] args) {
        System.out.println("=== Performance Profiling Basics ===");
        System.out.println();
        
        // 1. CPU Intensive Operations
        demonstrateCPUIntensiveOperations();
        
        // 2. Memory Intensive Operations
        demonstrateMemoryIntensiveOperations();
        
        // 3. I/O Operations
        demonstrateIOOperations();
        
        // 4. Threading Performance
        demonstrateThreadingPerformance();
        
        // 5. Algorithm Performance Comparison
        demonstrateAlgorithmPerformance();
        
        // 6. Memory Leak Detection
        demonstrateMemoryLeakDetection();
        
        // 7. Profiling Best Practices
        demonstrateProfilingBestPractices();
    }
    
    /**
     * Demonstrates CPU intensive operations for profiling
     */
    private static void demonstrateCPUIntensiveOperations() {
        System.out.println("1. CPU Intensive Operations:");
        System.out.println("===========================");
        
        // CPU intensive calculation
        long startTime = System.nanoTime();
        
        long result = calculateFibonacci(40);
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        
        System.out.println("Fibonacci(40) = " + result);
        System.out.println("Calculation time: " + duration + " ms");
        
        // Prime number calculation
        startTime = System.nanoTime();
        
        List<Integer> primes = findPrimes(10000);
        
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000;
        
        System.out.println("Found " + primes.size() + " primes up to 10000");
        System.out.println("Calculation time: " + duration + " ms");
        
        System.out.println();
    }
    
    /**
     * Demonstrates memory intensive operations
     */
    private static void demonstrateMemoryIntensiveOperations() {
        System.out.println("2. Memory Intensive Operations:");
        System.out.println("==============================");
        
        // Memory usage before
        long memoryBefore = getUsedMemory();
        System.out.println("Memory before: " + memoryBefore / 1024 / 1024 + " MB");
        
        // Create large collections
        List<String> largeList = new ArrayList<>();
        Map<String, String> largeMap = new HashMap<>();
        
        for (int i = 0; i < 100000; i++) {
            String key = "key" + i;
            String value = "value" + i + " with some additional data to make it larger";
            largeList.add(value);
            largeMap.put(key, value);
        }
        
        // Memory usage after
        long memoryAfter = getUsedMemory();
        System.out.println("Memory after: " + memoryAfter / 1024 / 1024 + " MB");
        System.out.println("Memory increase: " + (memoryAfter - memoryBefore) / 1024 / 1024 + " MB");
        
        // Force garbage collection
        System.gc();
        try {
            Thread.sleep(1000); // Wait for GC to complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        long memoryAfterGC = getUsedMemory();
        System.out.println("Memory after GC: " + memoryAfterGC / 1024 / 1024 + " MB");
        
        System.out.println();
    }
    
    /**
     * Demonstrates I/O operations for profiling
     */
    private static void demonstrateIOOperations() {
        System.out.println("3. I/O Operations:");
        System.out.println("=================");
        
        // Simulate file I/O operations
        long startTime = System.nanoTime();
        
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            data.add("Line " + i + " with some data content");
        }
        
        // Simulate writing to file
        simulateFileWrite(data);
        
        // Simulate reading from file
        List<String> readData = simulateFileRead(data.size());
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;
        
        System.out.println("I/O operations completed");
        System.out.println("Data written: " + data.size() + " lines");
        System.out.println("Data read: " + readData.size() + " lines");
        System.out.println("Total I/O time: " + duration + " ms");
        
        System.out.println();
    }
    
    /**
     * Demonstrates threading performance
     */
    private static void demonstrateThreadingPerformance() {
        System.out.println("4. Threading Performance:");
        System.out.println("========================");
        
        int numThreads = 4;
        int tasksPerThread = 1000;
        
        // Single-threaded execution
        long startTime = System.nanoTime();
        
        for (int i = 0; i < numThreads * tasksPerThread; i++) {
            performTask(i);
        }
        
        long singleThreadTime = System.nanoTime() - startTime;
        
        // Multi-threaded execution
        startTime = System.nanoTime();
        
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Void>> futures = new ArrayList<>();
        
        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            Future<Void> future = executor.submit(() -> {
                for (int j = 0; j < tasksPerThread; j++) {
                    performTask(threadId * tasksPerThread + j);
                }
                return null;
            });
            futures.add(future);
        }
        
        // Wait for all tasks to complete
        for (Future<Void> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Task execution failed: " + e.getMessage());
            }
        }
        
        executor.shutdown();
        long multiThreadTime = System.nanoTime() - startTime;
        
        System.out.println("Single-threaded time: " + singleThreadTime / 1_000_000 + " ms");
        System.out.println("Multi-threaded time: " + multiThreadTime / 1_000_000 + " ms");
        System.out.println("Speedup: " + (double) singleThreadTime / multiThreadTime + "x");
        
        System.out.println();
    }
    
    /**
     * Demonstrates algorithm performance comparison
     */
    private static void demonstrateAlgorithmPerformance() {
        System.out.println("5. Algorithm Performance Comparison:");
        System.out.println("===================================");
        
        int[] array = generateRandomArray(10000);
        
        // Bubble Sort
        int[] bubbleArray = array.clone();
        long startTime = System.nanoTime();
        bubbleSort(bubbleArray);
        long bubbleTime = System.nanoTime() - startTime;
        
        // Quick Sort
        int[] quickArray = array.clone();
        startTime = System.nanoTime();
        Arrays.sort(quickArray);
        long quickTime = System.nanoTime() - startTime;
        
        System.out.println("Array size: " + array.length);
        System.out.println("Bubble Sort time: " + bubbleTime / 1_000_000 + " ms");
        System.out.println("Quick Sort time: " + quickTime / 1_000_000 + " ms");
        System.out.println("Quick Sort is " + (double) bubbleTime / quickTime + "x faster");
        
        System.out.println();
    }
    
    /**
     * Demonstrates memory leak detection
     */
    private static void demonstrateMemoryLeakDetection() {
        System.out.println("6. Memory Leak Detection:");
        System.out.println("========================");
        
        // Simulate memory leak
        List<byte[]> memoryLeak = new ArrayList<>();
        
        long startTime = System.currentTimeMillis();
        long initialMemory = getUsedMemory();
        
        // Allocate memory without releasing it
        for (int i = 0; i < 1000; i++) {
            byte[] data = new byte[1024 * 1024]; // 1MB
            memoryLeak.add(data);
            
            if (i % 100 == 0) {
                long currentMemory = getUsedMemory();
                System.out.println("Iteration " + i + ": Memory = " + 
                    currentMemory / 1024 / 1024 + " MB");
            }
        }
        
        long endTime = System.currentTimeMillis();
        long finalMemory = getUsedMemory();
        
        System.out.println("Memory leak simulation completed");
        System.out.println("Initial memory: " + initialMemory / 1024 / 1024 + " MB");
        System.out.println("Final memory: " + finalMemory / 1024 / 1024 + " MB");
        System.out.println("Memory increase: " + (finalMemory - initialMemory) / 1024 / 1024 + " MB");
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        
        System.out.println();
    }
    
    /**
     * Demonstrates profiling best practices
     */
    private static void demonstrateProfilingBestPractices() {
        System.out.println("7. Profiling Best Practices:");
        System.out.println("===========================");
        
        System.out.println("✓ Profile in production-like environments");
        System.out.println("✓ Use multiple profiling tools for comprehensive analysis");
        System.out.println("✓ Focus on the biggest performance bottlenecks first");
        System.out.println("✓ Measure before and after optimizations");
        System.out.println("✓ Consider both CPU and memory usage");
        System.out.println("✓ Profile with realistic data volumes");
        System.out.println("✓ Use sampling profilers for production systems");
        System.out.println("✓ Monitor performance continuously");
        System.out.println("✓ Document performance requirements and measurements");
        System.out.println("✓ Use profiling to guide optimization efforts");
        
        System.out.println();
    }
    
    // Helper methods for demonstrations
    
    private static long calculateFibonacci(int n) {
        if (n <= 1) return n;
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }
    
    private static List<Integer> findPrimes(int limit) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
    
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    
    private static long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
    
    private static void simulateFileWrite(List<String> data) {
        // Simulate file writing delay
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private static List<String> simulateFileRead(int size) {
        // Simulate file reading delay
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        List<String> data = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            data.add("Read line " + i);
        }
        return data;
    }
    
    private static void performTask(int taskId) {
        // Simulate some work
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }
    
    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
