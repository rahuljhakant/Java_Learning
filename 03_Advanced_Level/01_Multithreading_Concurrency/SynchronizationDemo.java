package com.tutorial.advanced;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronization Demo
 * 
 * This class demonstrates:
 * - Synchronized methods
 * - Synchronized blocks
 * - Static synchronization
 * - ReentrantLock
 * - Atomic variables
 * - Thread safety issues and solutions
 * - Deadlock prevention
 */
public class SynchronizationDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Synchronization Demo ===");
        System.out.println();
        
        // 1. Thread Safety Issues
        demonstrateThreadSafetyIssues();
        
        // 2. Synchronized Methods
        demonstrateSynchronizedMethods();
        
        // 3. Synchronized Blocks
        demonstrateSynchronizedBlocks();
        
        // 4. Static Synchronization
        demonstrateStaticSynchronization();
        
        // 5. ReentrantLock
        demonstrateReentrantLock();
        
        // 6. Atomic Variables
        demonstrateAtomicVariables();
        
        // 7. Deadlock Prevention
        demonstrateDeadlockPrevention();
    }
    
    /**
     * Demonstrates thread safety issues without synchronization
     */
    private static void demonstrateThreadSafetyIssues() {
        System.out.println("1. Thread Safety Issues:");
        System.out.println("=======================");
        
        Counter counter = new Counter();
        
        // Creating multiple threads that increment the counter
        Thread thread1 = new Thread(new IncrementTask(counter), "Thread-1");
        Thread thread2 = new Thread(new IncrementTask(counter), "Thread-2");
        Thread thread3 = new Thread(new IncrementTask(counter), "Thread-3");
        
        System.out.println("Starting threads without synchronization...");
        thread1.start();
        thread2.start();
        thread3.start();
        
        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("Final counter value (without sync): " + counter.getCount());
        System.out.println("Expected value: 3000 (3 threads × 1000 increments each)");
        System.out.println();
    }
    
    /**
     * Demonstrates synchronized methods
     */
    private static void demonstrateSynchronizedMethods() {
        System.out.println("2. Synchronized Methods:");
        System.out.println("=======================");
        
        SynchronizedCounter counter = new SynchronizedCounter();
        
        // Creating multiple threads that increment the synchronized counter
        Thread thread1 = new Thread(new SynchronizedIncrementTask(counter), "SyncThread-1");
        Thread thread2 = new Thread(new SynchronizedIncrementTask(counter), "SyncThread-2");
        Thread thread3 = new Thread(new SynchronizedIncrementTask(counter), "SyncThread-3");
        
        System.out.println("Starting threads with synchronized methods...");
        thread1.start();
        thread2.start();
        thread3.start();
        
        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("Final counter value (with sync): " + counter.getCount());
        System.out.println("Expected value: 3000 (3 threads × 1000 increments each)");
        System.out.println();
    }
    
    /**
     * Demonstrates synchronized blocks
     */
    private static void demonstrateSynchronizedBlocks() {
        System.out.println("3. Synchronized Blocks:");
        System.out.println("======================");
        
        BlockSynchronizedCounter counter = new BlockSynchronizedCounter();
        
        // Creating multiple threads that increment the counter using synchronized blocks
        Thread thread1 = new Thread(new BlockSynchronizedIncrementTask(counter), "BlockThread-1");
        Thread thread2 = new Thread(new BlockSynchronizedIncrementTask(counter), "BlockThread-2");
        Thread thread3 = new Thread(new BlockSynchronizedIncrementTask(counter), "BlockThread-3");
        
        System.out.println("Starting threads with synchronized blocks...");
        thread1.start();
        thread2.start();
        thread3.start();
        
        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("Final counter value (with sync blocks): " + counter.getCount());
        System.out.println("Expected value: 3000 (3 threads × 1000 increments each)");
        System.out.println();
    }
    
    /**
     * Demonstrates static synchronization
     */
    private static void demonstrateStaticSynchronization() {
        System.out.println("4. Static Synchronization:");
        System.out.println("=========================");
        
        // Creating multiple threads that increment the static counter
        Thread thread1 = new Thread(new StaticIncrementTask(), "StaticThread-1");
        Thread thread2 = new Thread(new StaticIncrementTask(), "StaticThread-2");
        Thread thread3 = new Thread(new StaticIncrementTask(), "StaticThread-3");
        
        System.out.println("Starting threads with static synchronization...");
        thread1.start();
        thread2.start();
        thread3.start();
        
        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("Final static counter value: " + StaticCounter.getCount());
        System.out.println("Expected value: 3000 (3 threads × 1000 increments each)");
        System.out.println();
    }
    
    /**
     * Demonstrates ReentrantLock
     */
    private static void demonstrateReentrantLock() {
        System.out.println("5. ReentrantLock:");
        System.out.println("================");
        
        LockCounter counter = new LockCounter();
        
        // Creating multiple threads that increment the counter using ReentrantLock
        Thread thread1 = new Thread(new LockIncrementTask(counter), "LockThread-1");
        Thread thread2 = new Thread(new LockIncrementTask(counter), "LockThread-2");
        Thread thread3 = new Thread(new LockIncrementTask(counter), "LockThread-3");
        
        System.out.println("Starting threads with ReentrantLock...");
        thread1.start();
        thread2.start();
        thread3.start();
        
        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("Final counter value (with ReentrantLock): " + counter.getCount());
        System.out.println("Expected value: 3000 (3 threads × 1000 increments each)");
        System.out.println();
    }
    
    /**
     * Demonstrates atomic variables
     */
    private static void demonstrateAtomicVariables() {
        System.out.println("6. Atomic Variables:");
        System.out.println("==================");
        
        AtomicCounter counter = new AtomicCounter();
        
        // Creating multiple threads that increment the atomic counter
        Thread thread1 = new Thread(new AtomicIncrementTask(counter), "AtomicThread-1");
        Thread thread2 = new Thread(new AtomicIncrementTask(counter), "AtomicThread-2");
        Thread thread3 = new Thread(new AtomicIncrementTask(counter), "AtomicThread-3");
        
        System.out.println("Starting threads with atomic variables...");
        thread1.start();
        thread2.start();
        thread3.start();
        
        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("Final counter value (with atomic): " + counter.getCount());
        System.out.println("Expected value: 3000 (3 threads × 1000 increments each)");
        System.out.println();
    }
    
    /**
     * Demonstrates deadlock prevention
     */
    private static void demonstrateDeadlockPrevention() {
        System.out.println("7. Deadlock Prevention:");
        System.out.println("======================");
        
        // Creating two resources
        Resource resource1 = new Resource("Resource-1");
        Resource resource2 = new Resource("Resource-2");
        
        // Creating threads that could cause deadlock
        Thread thread1 = new Thread(new DeadlockTask(resource1, resource2), "DeadlockThread-1");
        Thread thread2 = new Thread(new DeadlockTask(resource2, resource1), "DeadlockThread-2");
        
        System.out.println("Starting threads that could cause deadlock...");
        thread1.start();
        thread2.start();
        
        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("Deadlock prevention demonstration completed");
        System.out.println();
    }
}

/**
 * Counter class without synchronization (thread-unsafe)
 */
class Counter {
    private int count = 0;
    
    public void increment() {
        count++; // This is not atomic
    }
    
    public int getCount() {
        return count;
    }
}

/**
 * Counter class with synchronized methods (thread-safe)
 */
class SynchronizedCounter {
    private int count = 0;
    
    public synchronized void increment() {
        count++;
    }
    
    public synchronized int getCount() {
        return count;
    }
}

/**
 * Counter class with synchronized blocks (thread-safe)
 */
class BlockSynchronizedCounter {
    private int count = 0;
    private final Object lock = new Object();
    
    public void increment() {
        synchronized (lock) {
            count++;
        }
    }
    
    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }
}

/**
 * Static counter class with static synchronization
 */
class StaticCounter {
    private static int count = 0;
    
    public static synchronized void increment() {
        count++;
    }
    
    public static synchronized int getCount() {
        return count;
    }
}

/**
 * Counter class using ReentrantLock
 */
class LockCounter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();
    
    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
    
    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}

/**
 * Counter class using atomic variables
 */
class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);
    
    public void increment() {
        count.incrementAndGet();
    }
    
    public int getCount() {
        return count.get();
    }
}

/**
 * Resource class for deadlock demonstration
 */
class Resource {
    private String name;
    private final Object lock = new Object();
    
    public Resource(String name) {
        this.name = name;
    }
    
    public void use(Resource other) {
        // Always acquire locks in the same order to prevent deadlock
        Object firstLock = this.lock.hashCode() < other.lock.hashCode() ? this.lock : other.lock;
        Object secondLock = this.lock.hashCode() < other.lock.hashCode() ? other.lock : this.lock;
        
        synchronized (firstLock) {
            System.out.println(Thread.currentThread().getName() + " acquired lock on " + name);
            try {
                Thread.sleep(100); // Simulate work
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
            
            synchronized (secondLock) {
                System.out.println(Thread.currentThread().getName() + " acquired lock on " + other.name);
                try {
                    Thread.sleep(100); // Simulate work
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
                System.out.println(Thread.currentThread().getName() + " completed work with both resources");
            }
        }
    }
}

/**
 * Task class for incrementing counter without synchronization
 */
class IncrementTask implements Runnable {
    private Counter counter;
    
    public IncrementTask(Counter counter) {
        this.counter = counter;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

/**
 * Task class for incrementing synchronized counter
 */
class SynchronizedIncrementTask implements Runnable {
    private SynchronizedCounter counter;
    
    public SynchronizedIncrementTask(SynchronizedCounter counter) {
        this.counter = counter;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

/**
 * Task class for incrementing counter with synchronized blocks
 */
class BlockSynchronizedIncrementTask implements Runnable {
    private BlockSynchronizedCounter counter;
    
    public BlockSynchronizedIncrementTask(BlockSynchronizedCounter counter) {
        this.counter = counter;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

/**
 * Task class for incrementing static counter
 */
class StaticIncrementTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            StaticCounter.increment();
        }
    }
}

/**
 * Task class for incrementing counter with ReentrantLock
 */
class LockIncrementTask implements Runnable {
    private LockCounter counter;
    
    public LockIncrementTask(LockCounter counter) {
        this.counter = counter;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

/**
 * Task class for incrementing atomic counter
 */
class AtomicIncrementTask implements Runnable {
    private AtomicCounter counter;
    
    public AtomicIncrementTask(AtomicCounter counter) {
        this.counter = counter;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

/**
 * Task class for deadlock demonstration
 */
class DeadlockTask implements Runnable {
    private Resource resource1;
    private Resource resource2;
    
    public DeadlockTask(Resource resource1, Resource resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }
    
    @Override
    public void run() {
        resource1.use(resource2);
    }
}
