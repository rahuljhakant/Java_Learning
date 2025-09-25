package com.tutorial.advanced;

import java.util.*;
import java.util.concurrent.*;

/**
 * Concurrent Collections Demo - Thread-Safe Data Structures
 * 
 * This comprehensive tutorial demonstrates Java's concurrent collections,
 * which provide thread-safe alternatives to standard collections. These
 * collections are designed for high-performance concurrent access and
 * eliminate the need for external synchronization in many cases.
 * 
 * LEARNING OBJECTIVES:
 * - Understand the benefits of concurrent collections
 * - Use ConcurrentHashMap for thread-safe maps
 * - Implement CopyOnWriteArrayList for read-heavy scenarios
 * - Use BlockingQueue implementations for producer-consumer patterns
 * - Apply ConcurrentLinkedQueue for high-performance queues
 * - Choose appropriate concurrent collection for each use case
 * - Understand performance implications of different collections
 * 
 * KEY CONCEPTS:
 * 1. ConcurrentHashMap: Thread-safe hash map with high concurrency
 * 2. CopyOnWriteArrayList: Thread-safe list optimized for reads
 * 3. BlockingQueue: Thread-safe queue with blocking operations
 * 4. ConcurrentLinkedQueue: Lock-free high-performance queue
 * 5. ConcurrentSkipListMap: Thread-safe sorted map
 * 6. Performance: Understanding trade-offs between different collections
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class ConcurrentCollections {
    
    public static void main(String[] args) {
        System.out.println("=== Concurrent Collections Demo ===");
        System.out.println();
        
        // 1. ConcurrentHashMap
        demonstrateConcurrentHashMap();
        
        // 2. CopyOnWriteArrayList
        demonstrateCopyOnWriteArrayList();
        
        // 3. BlockingQueue Implementations
        demonstrateBlockingQueues();
        
        // 4. ConcurrentLinkedQueue
        demonstrateConcurrentLinkedQueue();
        
        // 5. ConcurrentSkipListMap
        demonstrateConcurrentSkipListMap();
        
        // 6. Performance Comparison
        demonstratePerformanceComparison();
        
        // 7. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates ConcurrentHashMap usage
     */
    private static void demonstrateConcurrentHashMap() {
        System.out.println("1. ConcurrentHashMap:");
        System.out.println("====================");
        
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        
        // Multiple threads adding elements
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        for (int i = 0; i < 4; i++) {
            final int threadId = i;
            executor.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    String key = "Thread-" + threadId + "-Key-" + j;
                    concurrentMap.put(key, j);
                }
            });
        }
        
        // Wait for completion
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("ConcurrentHashMap size: " + concurrentMap.size());
        System.out.println("Sample entries:");
        concurrentMap.entrySet().stream()
            .limit(5)
            .forEach(entry -> System.out.println("  " + entry.getKey() + " = " + entry.getValue()));
        
        // Atomic operations
        System.out.println("\nAtomic operations:");
        concurrentMap.putIfAbsent("NewKey", 100);
        System.out.println("putIfAbsent result: " + concurrentMap.get("NewKey"));
        
        concurrentMap.computeIfPresent("NewKey", (k, v) -> v + 50);
        System.out.println("computeIfPresent result: " + concurrentMap.get("NewKey"));
        
        System.out.println();
    }
    
    /**
     * Demonstrates CopyOnWriteArrayList usage
     */
    private static void demonstrateCopyOnWriteArrayList() {
        System.out.println("2. CopyOnWriteArrayList:");
        System.out.println("=======================");
        
        CopyOnWriteArrayList<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        
        // Add initial elements
        copyOnWriteList.add("Element1");
        copyOnWriteList.add("Element2");
        copyOnWriteList.add("Element3");
        
        System.out.println("Initial list: " + copyOnWriteList);
        
        // Multiple threads reading and writing
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Reader thread
        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Reader sees: " + copyOnWriteList);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        
        // Writer thread
        executor.submit(() -> {
            for (int i = 0; i < 3; i++) {
                copyOnWriteList.add("NewElement" + i);
                System.out.println("Writer added: NewElement" + i);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        
        // Another reader thread
        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Reader2 sees: " + copyOnWriteList);
                try {
                    Thread.sleep(120);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        
        // Wait for completion
        executor.shutdown();
        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Final list: " + copyOnWriteList);
        System.out.println();
    }
    
    /**
     * Demonstrates BlockingQueue implementations
     */
    private static void demonstrateBlockingQueues() {
        System.out.println("3. BlockingQueue Implementations:");
        System.out.println("=================================");
        
        // ArrayBlockingQueue
        BlockingQueue<String> arrayQueue = new ArrayBlockingQueue<>(5);
        
        // Producer-Consumer pattern
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        // Producer
        executor.submit(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    arrayQueue.put("Item-" + i);
                    System.out.println("Produced: Item-" + i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        
        // Consumer
        executor.submit(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    String item = arrayQueue.take();
                    System.out.println("Consumed: " + item);
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        
        // Wait for completion
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // LinkedBlockingQueue
        System.out.println("\nLinkedBlockingQueue example:");
        BlockingQueue<Integer> linkedQueue = new LinkedBlockingQueue<>();
        
        // Add elements
        linkedQueue.offer(1);
        linkedQueue.offer(2);
        linkedQueue.offer(3);
        
        System.out.println("Queue contents: " + linkedQueue);
        
        // Poll elements
        while (!linkedQueue.isEmpty()) {
            System.out.println("Polled: " + linkedQueue.poll());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates ConcurrentLinkedQueue usage
     */
    private static void demonstrateConcurrentLinkedQueue() {
        System.out.println("4. ConcurrentLinkedQueue:");
        System.out.println("=========================");
        
        ConcurrentLinkedQueue<String> concurrentQueue = new ConcurrentLinkedQueue<>();
        
        // Multiple threads adding elements
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        for (int i = 0; i < 4; i++) {
            final int threadId = i;
            executor.submit(() -> {
                for (int j = 0; j < 100; j++) {
                    concurrentQueue.offer("Thread-" + threadId + "-Item-" + j);
                }
            });
        }
        
        // Wait for completion
        executor.shutdown();
        try {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Queue size: " + concurrentQueue.size());
        
        // Poll elements
        System.out.println("Polling first 5 elements:");
        for (int i = 0; i < 5; i++) {
            String element = concurrentQueue.poll();
            if (element != null) {
                System.out.println("  " + element);
            }
        }
        
        System.out.println("Remaining queue size: " + concurrentQueue.size());
        System.out.println();
    }
    
    /**
     * Demonstrates ConcurrentSkipListMap usage
     */
    private static void demonstrateConcurrentSkipListMap() {
        System.out.println("5. ConcurrentSkipListMap:");
        System.out.println("=========================");
        
        ConcurrentSkipListMap<Integer, String> skipListMap = new ConcurrentSkipListMap<>();
        
        // Add elements in random order
        skipListMap.put(3, "Three");
        skipListMap.put(1, "One");
        skipListMap.put(5, "Five");
        skipListMap.put(2, "Two");
        skipListMap.put(4, "Four");
        
        System.out.println("SkipListMap contents (sorted):");
        skipListMap.forEach((key, value) -> System.out.println("  " + key + " = " + value));
        
        // Navigable operations
        System.out.println("\nNavigable operations:");
        System.out.println("First entry: " + skipListMap.firstEntry());
        System.out.println("Last entry: " + skipListMap.lastEntry());
        System.out.println("Floor entry for 3: " + skipListMap.floorEntry(3));
        System.out.println("Ceiling entry for 3: " + skipListMap.ceilingEntry(3));
        
        // Submap operations
        System.out.println("\nSubmap from 2 to 4:");
        skipListMap.subMap(2, 4).forEach((key, value) -> 
            System.out.println("  " + key + " = " + value));
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance comparison between collections
     */
    private static void demonstratePerformanceComparison() {
        System.out.println("6. Performance Comparison:");
        System.out.println("=========================");
        
        int iterations = 100000;
        
        // HashMap vs ConcurrentHashMap
        System.out.println("HashMap vs ConcurrentHashMap (write operations):");
        
        Map<String, Integer> hashMap = new HashMap<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            hashMap.put("key" + i, i);
        }
        long hashMapTime = System.currentTimeMillis() - startTime;
        
        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            concurrentHashMap.put("key" + i, i);
        }
        long concurrentHashMapTime = System.currentTimeMillis() - startTime;
        
        System.out.println("HashMap time: " + hashMapTime + " ms");
        System.out.println("ConcurrentHashMap time: " + concurrentHashMapTime + " ms");
        
        // ArrayList vs CopyOnWriteArrayList
        System.out.println("\nArrayList vs CopyOnWriteArrayList (read operations):");
        
        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add("item" + i);
        }
        
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            arrayList.get(i % 1000);
        }
        long arrayListTime = System.currentTimeMillis() - startTime;
        
        List<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 1000; i++) {
            copyOnWriteList.add("item" + i);
        }
        
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            copyOnWriteList.get(i % 1000);
        }
        long copyOnWriteTime = System.currentTimeMillis() - startTime;
        
        System.out.println("ArrayList time: " + arrayListTime + " ms");
        System.out.println("CopyOnWriteArrayList time: " + copyOnWriteTime + " ms");
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices for concurrent collections
     */
    private static void demonstrateBestPractices() {
        System.out.println("7. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use ConcurrentHashMap for high-concurrency map operations");
        System.out.println("✓ Use CopyOnWriteArrayList for read-heavy scenarios");
        System.out.println("✓ Use BlockingQueue for producer-consumer patterns");
        System.out.println("✓ Use ConcurrentLinkedQueue for high-performance queues");
        System.out.println("✓ Use ConcurrentSkipListMap for sorted concurrent maps");
        System.out.println("✓ Consider performance trade-offs between collections");
        System.out.println("✓ Use atomic operations when available");
        System.out.println("✓ Avoid unnecessary synchronization with concurrent collections");
        System.out.println("✓ Monitor memory usage with CopyOnWrite collections");
        System.out.println("✓ Choose appropriate collection based on access patterns");
        
        System.out.println();
    }
}


