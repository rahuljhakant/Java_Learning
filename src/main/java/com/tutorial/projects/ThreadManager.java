package com.tutorial.projects;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread Manager - Advanced Thread Management
 * 
 * This class demonstrates advanced thread management concepts
 * including thread pools, synchronization, and performance monitoring.
 * 
 * LEARNING OBJECTIVES:
 * - Implement advanced thread management
 * - Use thread pools and executors effectively
 * - Monitor thread performance and statistics
 * - Handle thread synchronization and coordination
 * - Apply concurrent programming best practices
 * - Build high-performance multi-threaded applications
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class ThreadManager {
    private ExecutorService executorService;
    private ScheduledExecutorService scheduledExecutor;
    private AtomicInteger activeThreads;
    private AtomicInteger completedTasks;
    private AtomicInteger failedTasks;
    private long startTime;
    private boolean isRunning;
    
    public ThreadManager(int maxThreads) {
        this.executorService = Executors.newFixedThreadPool(maxThreads);
        this.scheduledExecutor = Executors.newScheduledThreadPool(2);
        this.activeThreads = new AtomicInteger(0);
        this.completedTasks = new AtomicInteger(0);
        this.failedTasks = new AtomicInteger(0);
        this.isRunning = false;
    }
    
    /**
     * Start thread manager
     */
    public void start() {
        if (isRunning) {
            System.out.println("Thread manager is already running.");
            return;
        }
        
        isRunning = true;
        startTime = System.currentTimeMillis();
        
        // Start monitoring thread
        scheduledExecutor.scheduleAtFixedRate(this::monitorThreads, 0, 5, TimeUnit.SECONDS);
        
        System.out.println("Thread manager started with " + 
                          ((ThreadPoolExecutor) executorService).getCorePoolSize() + " threads.");
    }
    
    /**
     * Submit task for execution
     */
    public Future<?> submitTask(Runnable task) {
        if (!isRunning) {
            throw new IllegalStateException("Thread manager is not running.");
        }
        
        activeThreads.incrementAndGet();
        
        return executorService.submit(() -> {
            try {
                task.run();
                completedTasks.incrementAndGet();
            } catch (Exception e) {
                failedTasks.incrementAndGet();
                System.err.println("Task failed: " + e.getMessage());
            } finally {
                activeThreads.decrementAndGet();
            }
        });
    }
    
    /**
     * Submit task with result
     */
    public <T> Future<T> submitTask(Callable<T> task) {
        if (!isRunning) {
            throw new IllegalStateException("Thread manager is not running.");
        }
        
        activeThreads.incrementAndGet();
        
        return executorService.submit(() -> {
            try {
                T result = task.call();
                completedTasks.incrementAndGet();
                return result;
            } catch (Exception e) {
                failedTasks.incrementAndGet();
                System.err.println("Task failed: " + e.getMessage());
                throw e;
            } finally {
                activeThreads.decrementAndGet();
            }
        });
    }
    
    /**
     * Submit multiple tasks
     */
    public List<Future<?>> submitTasks(List<Runnable> tasks) {
        List<Future<?>> futures = new ArrayList<>();
        
        for (Runnable task : tasks) {
            futures.add(submitTask(task));
        }
        
        return futures;
    }
    
    /**
     * Wait for all tasks to complete
     */
    public void waitForCompletion() {
        executorService.shutdown();
        
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("Forcing shutdown of incomplete tasks...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted while waiting for completion: " + e.getMessage());
            executorService.shutdownNow();
        }
    }
    
    /**
     * Monitor thread performance
     */
    private void monitorThreads() {
        if (!isRunning) return;
        
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) executorService;
        
        System.out.println("\n=== Thread Manager Status ===");
        System.out.println("Active Threads: " + activeThreads.get());
        System.out.println("Pool Size: " + tpe.getPoolSize());
        System.out.println("Core Pool Size: " + tpe.getCorePoolSize());
        System.out.println("Maximum Pool Size: " + tpe.getMaximumPoolSize());
        System.out.println("Completed Tasks: " + completedTasks.get());
        System.out.println("Failed Tasks: " + failedTasks.get());
        System.out.println("Queue Size: " + tpe.getQueue().size());
        System.out.println("Uptime: " + (System.currentTimeMillis() - startTime) + " ms");
        System.out.println("=============================");
    }
    
    /**
     * Get thread statistics
     */
    public ThreadStatistics getStatistics() {
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) executorService;
        
        return new ThreadStatistics(
            activeThreads.get(),
            tpe.getPoolSize(),
            tpe.getCorePoolSize(),
            tpe.getMaximumPoolSize(),
            completedTasks.get(),
            failedTasks.get(),
            tpe.getQueue().size(),
            System.currentTimeMillis() - startTime
        );
    }
    
    /**
     * Stop thread manager
     */
    public void stop() {
        if (!isRunning) {
            System.out.println("Thread manager is not running.");
            return;
        }
        
        isRunning = false;
        
        // Shutdown scheduled executor
        scheduledExecutor.shutdown();
        
        // Shutdown main executor
        executorService.shutdown();
        
        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Forcing shutdown...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted during shutdown: " + e.getMessage());
            executorService.shutdownNow();
        }
        
        System.out.println("Thread manager stopped.");
    }
    
    /**
     * Check if thread manager is running
     */
    public boolean isRunning() {
        return isRunning;
    }
    
    /**
     * Get active thread count
     */
    public int getActiveThreadCount() {
        return activeThreads.get();
    }
    
    /**
     * Get completed task count
     */
    public int getCompletedTaskCount() {
        return completedTasks.get();
    }
    
    /**
     * Get failed task count
     */
    public int getFailedTaskCount() {
        return failedTasks.get();
    }
    
    /**
     * Thread statistics container
     */
    public static class ThreadStatistics {
        private final int activeThreads;
        private final int poolSize;
        private final int corePoolSize;
        private final int maxPoolSize;
        private final int completedTasks;
        private final int failedTasks;
        private final int queueSize;
        private final long uptime;
        
        public ThreadStatistics(int activeThreads, int poolSize, int corePoolSize, 
                               int maxPoolSize, int completedTasks, int failedTasks, 
                               int queueSize, long uptime) {
            this.activeThreads = activeThreads;
            this.poolSize = poolSize;
            this.corePoolSize = corePoolSize;
            this.maxPoolSize = maxPoolSize;
            this.completedTasks = completedTasks;
            this.failedTasks = failedTasks;
            this.queueSize = queueSize;
            this.uptime = uptime;
        }
        
        // Getters
        public int getActiveThreads() { return activeThreads; }
        public int getPoolSize() { return poolSize; }
        public int getCorePoolSize() { return corePoolSize; }
        public int getMaxPoolSize() { return maxPoolSize; }
        public int getCompletedTasks() { return completedTasks; }
        public int getFailedTasks() { return failedTasks; }
        public int getQueueSize() { return queueSize; }
        public long getUptime() { return uptime; }
        
        @Override
        public String toString() {
            return "ThreadStatistics{" +
                   "activeThreads=" + activeThreads +
                   ", poolSize=" + poolSize +
                   ", corePoolSize=" + corePoolSize +
                   ", maxPoolSize=" + maxPoolSize +
                   ", completedTasks=" + completedTasks +
                   ", failedTasks=" + failedTasks +
                   ", queueSize=" + queueSize +
                   ", uptime=" + uptime + "ms" +
                   '}';
        }
    }
}
