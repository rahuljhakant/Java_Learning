package com.tutorial.advanced;

/**
 * Thread Basics Demo
 * 
 * This class demonstrates:
 * - Creating threads using Thread class
 * - Creating threads using Runnable interface
 * - Thread lifecycle and states
 * - Thread priorities
 * - Daemon threads
 * - Thread naming and identification
 */
public class ThreadBasics {
    
    public static void main(String[] args) {
        System.out.println("=== Thread Basics Demo ===");
        System.out.println();
        
        // 1. Creating Threads using Thread class
        demonstrateThreadClass();
        
        // 2. Creating Threads using Runnable interface
        demonstrateRunnableInterface();
        
        // 3. Thread Lifecycle and States
        demonstrateThreadLifecycle();
        
        // 4. Thread Priorities
        demonstrateThreadPriorities();
        
        // 5. Daemon Threads
        demonstrateDaemonThreads();
        
        // 6. Thread Naming and Identification
        demonstrateThreadNaming();
        
        // 7. Thread Grouping
        demonstrateThreadGrouping();
    }
    
    /**
     * Demonstrates creating threads using Thread class
     */
    private static void demonstrateThreadClass() {
        System.out.println("1. Creating Threads using Thread Class:");
        System.out.println("======================================");
        
        // Creating and starting threads
        Thread thread1 = new MyThread("Thread-1");
        Thread thread2 = new MyThread("Thread-2");
        
        System.out.println("Starting threads...");
        thread1.start();
        thread2.start();
        
        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("All threads completed");
        System.out.println();
    }
    
    /**
     * Demonstrates creating threads using Runnable interface
     */
    private static void demonstrateRunnableInterface() {
        System.out.println("2. Creating Threads using Runnable Interface:");
        System.out.println("===========================================");
        
        // Creating Runnable objects
        Runnable runnable1 = new MyRunnable("Runnable-1");
        Runnable runnable2 = new MyRunnable("Runnable-2");
        
        // Creating threads with Runnable
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        
        System.out.println("Starting threads with Runnable...");
        thread1.start();
        thread2.start();
        
        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("All Runnable threads completed");
        System.out.println();
    }
    
    /**
     * Demonstrates thread lifecycle and states
     */
    private static void demonstrateThreadLifecycle() {
        System.out.println("3. Thread Lifecycle and States:");
        System.out.println("==============================");
        
        Thread lifecycleThread = new Thread(() -> {
            try {
                System.out.println("Thread is running...");
                Thread.sleep(2000); // Simulate work
                System.out.println("Thread completed its work");
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted: " + e.getMessage());
            }
        });
        
        System.out.println("Thread state before start: " + lifecycleThread.getState());
        
        lifecycleThread.start();
        System.out.println("Thread state after start: " + lifecycleThread.getState());
        
        // Wait a bit to see RUNNABLE state
        try {
            Thread.sleep(100);
            System.out.println("Thread state while running: " + lifecycleThread.getState());
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        // Wait for thread to complete
        try {
            lifecycleThread.join();
            System.out.println("Thread state after completion: " + lifecycleThread.getState());
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates thread priorities
     */
    private static void demonstrateThreadPriorities() {
        System.out.println("4. Thread Priorities:");
        System.out.println("===================");
        
        // Creating threads with different priorities
        Thread lowPriorityThread = new Thread(new PriorityTask("Low Priority"), "LowPriority");
        Thread normalPriorityThread = new Thread(new PriorityTask("Normal Priority"), "NormalPriority");
        Thread highPriorityThread = new Thread(new PriorityTask("High Priority"), "HighPriority");
        
        // Setting priorities
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);    // 1
        normalPriorityThread.setPriority(Thread.NORM_PRIORITY); // 5
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);    // 10
        
        System.out.println("Thread priorities:");
        System.out.println("Low Priority: " + lowPriorityThread.getPriority());
        System.out.println("Normal Priority: " + normalPriorityThread.getPriority());
        System.out.println("High Priority: " + highPriorityThread.getPriority());
        
        // Starting threads
        System.out.println("\nStarting threads...");
        highPriorityThread.start();
        normalPriorityThread.start();
        lowPriorityThread.start();
        
        // Wait for all threads to complete
        try {
            highPriorityThread.join();
            normalPriorityThread.join();
            lowPriorityThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("All priority threads completed");
        System.out.println();
    }
    
    /**
     * Demonstrates daemon threads
     */
    private static void demonstrateDaemonThreads() {
        System.out.println("5. Daemon Threads:");
        System.out.println("=================");
        
        // Creating daemon thread
        Thread daemonThread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Daemon thread is running...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Daemon thread interrupted: " + e.getMessage());
                    break;
                }
            }
            System.out.println("Daemon thread is terminating");
        });
        
        daemonThread.setDaemon(true);
        System.out.println("Is daemon thread: " + daemonThread.isDaemon());
        
        // Creating user thread
        Thread userThread = new Thread(() -> {
            try {
                System.out.println("User thread is running...");
                Thread.sleep(3000);
                System.out.println("User thread completed");
            } catch (InterruptedException e) {
                System.out.println("User thread interrupted: " + e.getMessage());
            }
        });
        
        System.out.println("Is user thread daemon: " + userThread.isDaemon());
        
        // Starting threads
        System.out.println("\nStarting threads...");
        daemonThread.start();
        userThread.start();
        
        // Wait for user thread to complete
        try {
            userThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("User thread completed, daemon thread will terminate automatically");
        System.out.println();
    }
    
    /**
     * Demonstrates thread naming and identification
     */
    private static void demonstrateThreadNaming() {
        System.out.println("6. Thread Naming and Identification:");
        System.out.println("==================================");
        
        // Creating threads with custom names
        Thread namedThread1 = new Thread(new NamedTask(), "CustomThread-1");
        Thread namedThread2 = new Thread(new NamedTask(), "CustomThread-2");
        
        System.out.println("Thread names:");
        System.out.println("Thread 1: " + namedThread1.getName());
        System.out.println("Thread 2: " + namedThread2.getName());
        
        // Getting current thread information
        Thread currentThread = Thread.currentThread();
        System.out.println("Current thread: " + currentThread.getName());
        System.out.println("Current thread ID: " + currentThread.getId());
        System.out.println("Current thread priority: " + currentThread.getPriority());
        
        // Starting named threads
        System.out.println("\nStarting named threads...");
        namedThread1.start();
        namedThread2.start();
        
        // Wait for threads to complete
        try {
            namedThread1.join();
            namedThread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("All named threads completed");
        System.out.println();
    }
    
    /**
     * Demonstrates thread grouping
     */
    private static void demonstrateThreadGrouping() {
        System.out.println("7. Thread Grouping:");
        System.out.println("==================");
        
        // Creating thread group
        ThreadGroup group = new ThreadGroup("MyThreadGroup");
        
        // Creating threads in the group
        Thread thread1 = new Thread(group, new GroupedTask(), "GroupedThread-1");
        Thread thread2 = new Thread(group, new GroupedTask(), "GroupedThread-2");
        Thread thread3 = new Thread(group, new GroupedTask(), "GroupedThread-3");
        
        System.out.println("Thread group name: " + group.getName());
        System.out.println("Thread group active count: " + group.activeCount());
        System.out.println("Thread group max priority: " + group.getMaxPriority());
        
        // Starting threads
        System.out.println("\nStarting grouped threads...");
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
        
        System.out.println("All grouped threads completed");
        System.out.println();
    }
}

/**
 * Custom Thread class extending Thread
 */
class MyThread extends Thread {
    private String threadName;
    
    public MyThread(String name) {
        this.threadName = name;
    }
    
    @Override
    public void run() {
        System.out.println("Thread " + threadName + " is running");
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread " + threadName + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " was interrupted: " + e.getMessage());
        }
        System.out.println("Thread " + threadName + " completed");
    }
}

/**
 * Custom Runnable class implementing Runnable
 */
class MyRunnable implements Runnable {
    private String taskName;
    
    public MyRunnable(String name) {
        this.taskName = name;
    }
    
    @Override
    public void run() {
        System.out.println("Runnable " + taskName + " is running");
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Runnable " + taskName + ": " + i);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            System.out.println("Runnable " + taskName + " was interrupted: " + e.getMessage());
        }
        System.out.println("Runnable " + taskName + " completed");
    }
}

/**
 * Task class for demonstrating priorities
 */
class PriorityTask implements Runnable {
    private String taskName;
    
    public PriorityTask(String name) {
        this.taskName = name;
    }
    
    @Override
    public void run() {
        System.out.println(taskName + " thread started");
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(taskName + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(taskName + " was interrupted: " + e.getMessage());
        }
        System.out.println(taskName + " thread completed");
    }
}

/**
 * Task class for demonstrating named threads
 */
class NamedTask implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Named task running in thread: " + threadName);
        try {
            for (int i = 1; i <= 2; i++) {
                System.out.println(threadName + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted: " + e.getMessage());
        }
        System.out.println("Named task completed in thread: " + threadName);
    }
}

/**
 * Task class for demonstrating thread groups
 */
class GroupedTask implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        System.out.println("Grouped task running in thread: " + threadName + " (Group: " + group.getName() + ")");
        try {
            for (int i = 1; i <= 2; i++) {
                System.out.println(threadName + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted: " + e.getMessage());
        }
        System.out.println("Grouped task completed in thread: " + threadName);
    }
}
