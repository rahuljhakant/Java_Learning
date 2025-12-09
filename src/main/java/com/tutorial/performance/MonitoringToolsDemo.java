package com.tutorial.performance;

import java.lang.management.*;
import java.util.*;

/**
 * Monitoring Tools Demo - JVM and Application Monitoring
 * 
 * This comprehensive tutorial demonstrates various monitoring tools and
 * techniques for Java applications, including JVM monitoring, application
 * performance monitoring, and system resource monitoring.
 * 
 * LEARNING OBJECTIVES:
 * - Use built-in Java monitoring tools and APIs
 * - Monitor JVM performance and memory usage
 * - Track application performance metrics
 * - Use external monitoring tools and frameworks
 * - Implement custom monitoring solutions
 * - Apply monitoring best practices
 * 
 * KEY CONCEPTS:
 * 1. JVM Monitoring: Memory, threads, and garbage collection
 * 2. Application Monitoring: Performance metrics and health checks
 * 3. System Monitoring: CPU, memory, and I/O monitoring
 * 4. External Tools: JVisualVM, JProfiler, and APM tools
 * 5. Custom Monitoring: Implementing monitoring solutions
 * 6. Best Practices: Effective monitoring strategies
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class MonitoringToolsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Monitoring Tools Demo ===");
        System.out.println();
        
        // 1. JVM Monitoring
        demonstrateJVMMonitoring();
        
        // 2. Memory Monitoring
        demonstrateMemoryMonitoring();
        
        // 3. Thread Monitoring
        demonstrateThreadMonitoring();
        
        // 4. Garbage Collection Monitoring
        demonstrateGCMonitoring();
        
        // 5. Application Performance Monitoring
        demonstrateAPM();
        
        // 6. System Resource Monitoring
        demonstrateSystemMonitoring();
        
        // 7. Custom Monitoring
        demonstrateCustomMonitoring();
        
        // 8. Monitoring Best Practices
        demonstrateMonitoringBestPractices();
    }
    
    /**
     * Demonstrates JVM monitoring
     */
    private static void demonstrateJVMMonitoring() {
        System.out.println("1. JVM Monitoring:");
        System.out.println("==================");
        
        // Runtime information
        Runtime runtime = Runtime.getRuntime();
        System.out.println("JVM Name: " + System.getProperty("java.vm.name"));
        System.out.println("JVM Version: " + System.getProperty("java.vm.version"));
        System.out.println("JVM Vendor: " + System.getProperty("java.vm.vendor"));
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("OS Name: " + System.getProperty("os.name"));
        System.out.println("OS Version: " + System.getProperty("os.version"));
        System.out.println("Available Processors: " + runtime.availableProcessors());
        
        // Memory information
        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        
        System.out.println("Max Memory: " + formatBytes(maxMemory));
        System.out.println("Total Memory: " + formatBytes(totalMemory));
        System.out.println("Free Memory: " + formatBytes(freeMemory));
        System.out.println("Used Memory: " + formatBytes(usedMemory));
        System.out.println("Memory Usage: " + String.format("%.1f%%", (double) usedMemory / totalMemory * 100));
        
        System.out.println();
    }
    
    /**
     * Demonstrates memory monitoring
     */
    private static void demonstrateMemoryMonitoring() {
        System.out.println("2. Memory Monitoring:");
        System.out.println("=====================");
        
        // Memory MXBean
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeapUsage = memoryBean.getNonHeapMemoryUsage();
        
        System.out.println("Heap Memory:");
        System.out.println("  Init: " + formatBytes(heapUsage.getInit()));
        System.out.println("  Used: " + formatBytes(heapUsage.getUsed()));
        System.out.println("  Committed: " + formatBytes(heapUsage.getCommitted()));
        System.out.println("  Max: " + formatBytes(heapUsage.getMax()));
        
        System.out.println("Non-Heap Memory:");
        System.out.println("  Init: " + formatBytes(nonHeapUsage.getInit()));
        System.out.println("  Used: " + formatBytes(nonHeapUsage.getUsed()));
        System.out.println("  Committed: " + formatBytes(nonHeapUsage.getCommitted()));
        System.out.println("  Max: " + formatBytes(nonHeapUsage.getMax()));
        
        // Memory pool information
        List<MemoryPoolMXBean> memoryPools = ManagementFactory.getMemoryPoolMXBeans();
        System.out.println("\nMemory Pools:");
        for (MemoryPoolMXBean pool : memoryPools) {
            MemoryUsage usage = pool.getUsage();
            System.out.println("  " + pool.getName() + ": " + formatBytes(usage.getUsed()) + 
                             " / " + formatBytes(usage.getMax()));
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates thread monitoring
     */
    private static void demonstrateThreadMonitoring() {
        System.out.println("3. Thread Monitoring:");
        System.out.println("====================");
        
        // Thread MXBean
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        
        System.out.println("Thread Count: " + threadBean.getThreadCount());
        System.out.println("Peak Thread Count: " + threadBean.getPeakThreadCount());
        System.out.println("Total Started Threads: " + threadBean.getTotalStartedThreadCount());
        System.out.println("Daemon Thread Count: " + threadBean.getDaemonThreadCount());
        
        // Thread information
        long[] threadIds = threadBean.getAllThreadIds();
        ThreadInfo[] threadInfos = threadBean.getThreadInfo(threadIds);
        
        System.out.println("\nThread Details:");
        for (ThreadInfo info : threadInfos) {
            if (info != null) {
                System.out.println("  " + info.getThreadName() + 
                                 " (ID: " + info.getThreadId() + 
                                 ", State: " + info.getThreadState() + 
                                 ", CPU Time: " + threadBean.getThreadCpuTime(info.getThreadId()) + " ns)");
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates garbage collection monitoring
     */
    private static void demonstrateGCMonitoring() {
        System.out.println("4. Garbage Collection Monitoring:");
        System.out.println("=================================");
        
        // Garbage collection MXBeans
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        
        System.out.println("Garbage Collectors:");
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            System.out.println("  " + gcBean.getName() + ":");
            System.out.println("    Collections: " + gcBean.getCollectionCount());
            System.out.println("    Total Time: " + gcBean.getCollectionTime() + " ms");
            System.out.println("    Memory Pools: " + Arrays.toString(gcBean.getMemoryPoolNames()));
        }
        
        // Memory manager information
        List<MemoryManagerMXBean> memoryManagers = ManagementFactory.getMemoryManagerMXBeans();
        System.out.println("\nMemory Managers:");
        for (MemoryManagerMXBean manager : memoryManagers) {
            System.out.println("  " + manager.getName() + 
                             " (Pools: " + Arrays.toString(manager.getMemoryPoolNames()) + ")");
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates application performance monitoring
     */
    private static void demonstrateAPM() {
        System.out.println("5. Application Performance Monitoring:");
        System.out.println("=====================================");
        
        // Compilation monitoring
        CompilationMXBean compilationBean = ManagementFactory.getCompilationMXBean();
        if (compilationBean != null) {
            System.out.println("Compilation:");
            System.out.println("  Compiler: " + compilationBean.getName());
            System.out.println("  Total Compilation Time: " + compilationBean.getTotalCompilationTime() + " ms");
        }
        
        // Class loading monitoring
        ClassLoadingMXBean classLoadingBean = ManagementFactory.getClassLoadingMXBean();
        System.out.println("Class Loading:");
        System.out.println("  Loaded Classes: " + classLoadingBean.getLoadedClassCount());
        System.out.println("  Total Loaded: " + classLoadingBean.getTotalLoadedClassCount());
        System.out.println("  Unloaded Classes: " + classLoadingBean.getUnloadedClassCount());
        
        // Operating system monitoring
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println("Operating System:");
        System.out.println("  Name: " + osBean.getName());
        System.out.println("  Version: " + osBean.getVersion());
        System.out.println("  Architecture: " + osBean.getArch());
        System.out.println("  Available Processors: " + osBean.getAvailableProcessors());
        System.out.println("  System Load Average: " + osBean.getSystemLoadAverage());
        
        System.out.println();
    }
    
    /**
     * Demonstrates system resource monitoring
     */
    private static void demonstrateSystemMonitoring() {
        System.out.println("6. System Resource Monitoring:");
        System.out.println("==============================");
        
        // System properties
        System.out.println("System Properties:");
        System.out.println("  User Name: " + System.getProperty("user.name"));
        System.out.println("  User Home: " + System.getProperty("user.home"));
        System.out.println("  User Directory: " + System.getProperty("user.dir"));
        System.out.println("  File Separator: " + System.getProperty("file.separator"));
        System.out.println("  Path Separator: " + System.getProperty("path.separator"));
        System.out.println("  Line Separator: " + System.getProperty("line.separator"));
        
        // Environment variables
        System.out.println("\nEnvironment Variables:");
        Map<String, String> env = System.getenv();
        env.entrySet().stream()
            .limit(5) // Show only first 5 for brevity
            .forEach(entry -> System.out.println("  " + entry.getKey() + " = " + entry.getValue()));
        
        System.out.println();
    }
    
    /**
     * Demonstrates custom monitoring
     */
    private static void demonstrateCustomMonitoring() {
        System.out.println("7. Custom Monitoring:");
        System.out.println("====================");
        
        // Custom performance metrics
        PerformanceMetrics metrics = new PerformanceMetrics();
        
        // Simulate some operations
        for (int i = 0; i < 1000; i++) {
            long startTime = System.nanoTime();
            
            // Simulate some work
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            long endTime = System.nanoTime();
            metrics.recordOperation("simulated_work", endTime - startTime);
        }
        
        // Display metrics
        System.out.println("Custom Metrics:");
        System.out.println("  Total Operations: " + metrics.getTotalOperations());
        System.out.println("  Average Time: " + String.format("%.2f", metrics.getAverageTime()) + " ns");
        System.out.println("  Min Time: " + metrics.getMinTime() + " ns");
        System.out.println("  Max Time: " + metrics.getMaxTime() + " ns");
        System.out.println("  Total Time: " + metrics.getTotalTime() + " ns");
        
        System.out.println();
    }
    
    /**
     * Demonstrates monitoring best practices
     */
    private static void demonstrateMonitoringBestPractices() {
        System.out.println("8. Monitoring Best Practices:");
        System.out.println("=============================");
        
        System.out.println("✓ Monitor key performance indicators (KPIs)");
        System.out.println("✓ Set up alerts for critical metrics");
        System.out.println("✓ Use multiple monitoring tools for comprehensive coverage");
        System.out.println("✓ Monitor both application and infrastructure metrics");
        System.out.println("✓ Implement health checks and status endpoints");
        System.out.println("✓ Use distributed tracing for microservices");
        System.out.println("✓ Monitor business metrics alongside technical metrics");
        System.out.println("✓ Set up dashboards for real-time monitoring");
        System.out.println("✓ Implement log aggregation and analysis");
        System.out.println("✓ Use APM tools for production monitoring");
        System.out.println("✓ Monitor security metrics and vulnerabilities");
        System.out.println("✓ Implement custom metrics for business logic");
        
        System.out.println();
    }
    
    /**
     * Utility method to format bytes
     */
    private static String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
        return String.format("%.1f GB", bytes / (1024.0 * 1024.0 * 1024.0));
    }
    
    /**
     * Custom performance metrics class
     */
    public static class PerformanceMetrics {
        private long totalOperations = 0;
        private long totalTime = 0;
        private long minTime = Long.MAX_VALUE;
        private long maxTime = 0;
        
        public void recordOperation(String operationName, long duration) {
            totalOperations++;
            totalTime += duration;
            minTime = Math.min(minTime, duration);
            maxTime = Math.max(maxTime, duration);
        }
        
        public long getTotalOperations() { return totalOperations; }
        public long getTotalTime() { return totalTime; }
        public long getMinTime() { return minTime == Long.MAX_VALUE ? 0 : minTime; }
        public long getMaxTime() { return maxTime; }
        public double getAverageTime() { 
            return totalOperations > 0 ? (double) totalTime / totalOperations : 0; 
        }
    }
}
