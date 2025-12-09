package com.tutorial.foreignapi;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;

/**
 * Memory Segments - Foreign Memory API Memory Management
 * 
 * This comprehensive tutorial demonstrates memory management using the
 * Foreign Memory API, including memory segments, allocation, and
 * deallocation. Learn how to work with off-heap memory safely and
 * efficiently.
 * 
 * LEARNING OBJECTIVES:
 * - Use memory segments for data storage
 * - Allocate and deallocate memory safely
 * - Work with different memory layouts
 * - Handle memory access patterns
 * - Apply memory management best practices
 * - Integrate with native libraries
 * 
 * KEY CONCEPTS:
 * 1. Memory Segments: Contiguous memory regions
 * 2. Memory Layouts: Structured memory organization
 * 3. Memory Access: Safe memory access patterns
 * 4. Memory Safety: Preventing memory-related errors
 * 5. Memory Allocation: Dynamic memory management
 * 6. Memory Deallocation: Proper memory cleanup
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class MemorySegments {
    
    public static void main(String[] args) {
        System.out.println("=== Memory Segments Demo ===");
        System.out.println();
        
        // 1. Basic Memory Segment Creation
        demonstrateBasicMemorySegments();
        
        // 2. Memory Layout and Access
        demonstrateMemoryLayout();
        
        // 3. Memory Allocation and Deallocation
        demonstrateMemoryAllocation();
        
        // 4. Memory Safety
        demonstrateMemorySafety();
        
        // 5. Memory Access Patterns
        demonstrateMemoryAccessPatterns();
        
        // 6. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic memory segment creation
     */
    private static void demonstrateBasicMemorySegments() {
        System.out.println("1. Basic Memory Segment Creation:");
        System.out.println("=================================");
        
        try (Arena arena = Arena.ofConfined()) {
            // Create a memory segment
            MemorySegment segment = arena.allocate(1024);
            System.out.println("Memory segment created with size: " + segment.byteSize() + " bytes");
            
            // Access memory segment properties
            System.out.println("Segment address: " + segment.address());
            System.out.println("Segment is alive: " + segment.scope().isAlive());
            System.out.println("Segment is confined: " + segment.scope().isConfined());
            
            // Create segment with specific layout
            MemoryLayout layout = MemoryLayout.sequenceLayout(10, ValueLayout.JAVA_INT);
            MemorySegment arraySegment = arena.allocate(layout);
            System.out.println("Array segment created with layout: " + layout);
            System.out.println("Array segment size: " + arraySegment.byteSize() + " bytes");
            
        } catch (Exception e) {
            System.err.println("Error creating memory segments: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates memory layout and access
     */
    private static void demonstrateMemoryLayout() {
        System.out.println("2. Memory Layout and Access:");
        System.out.println("============================");
        
        try (Arena arena = Arena.ofConfined()) {
            // Create a struct-like layout
            MemoryLayout structLayout = MemoryLayout.structLayout(
                ValueLayout.JAVA_INT.withName("id"),
                ValueLayout.JAVA_LONG.withName("timestamp"),
                ValueLayout.JAVA_DOUBLE.withName("value")
            );
            
            MemorySegment structSegment = arena.allocate(structLayout);
            System.out.println("Struct layout: " + structLayout);
            System.out.println("Struct size: " + structSegment.byteSize() + " bytes");
            
            // Access struct fields
            VarHandle idHandle = structLayout.varHandle(MemoryLayout.PathElement.groupElement("id"));
            VarHandle timestampHandle = structLayout.varHandle(MemoryLayout.PathElement.groupElement("timestamp"));
            VarHandle valueHandle = structLayout.varHandle(MemoryLayout.PathElement.groupElement("value"));
            
            // Set values
            idHandle.set(structSegment, 0, 42);
            timestampHandle.set(structSegment, 0, System.currentTimeMillis());
            valueHandle.set(structSegment, 0, 3.14159);
            
            // Get values
            int id = (int) idHandle.get(structSegment, 0);
            long timestamp = (long) timestampHandle.get(structSegment, 0);
            double value = (double) valueHandle.get(structSegment, 0);
            
            System.out.println("Struct values:");
            System.out.println("  ID: " + id);
            System.out.println("  Timestamp: " + timestamp);
            System.out.println("  Value: " + value);
            
        } catch (Exception e) {
            System.err.println("Error with memory layout: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates memory allocation and deallocation
     */
    private static void demonstrateMemoryAllocation() {
        System.out.println("3. Memory Allocation and Deallocation:");
        System.out.println("=====================================");
        
        // Demonstrate different arena types
        System.out.println("Confined Arena:");
        try (Arena confinedArena = Arena.ofConfined()) {
            MemorySegment segment = confinedArena.allocate(1024);
            System.out.println("  Segment allocated in confined arena");
            System.out.println("  Segment size: " + segment.byteSize() + " bytes");
        } // Automatically deallocated when arena is closed
        
        System.out.println("Shared Arena:");
        try (Arena sharedArena = Arena.ofShared()) {
            MemorySegment segment = sharedArena.allocate(1024);
            System.out.println("  Segment allocated in shared arena");
            System.out.println("  Segment size: " + segment.byteSize() + " bytes");
        } // Automatically deallocated when arena is closed
        
        System.out.println("Global Arena:");
        Arena globalArena = Arena.global();
        MemorySegment globalSegment = globalArena.allocate(1024);
        System.out.println("  Segment allocated in global arena");
        System.out.println("  Segment size: " + globalSegment.byteSize() + " bytes");
        // Global arena segments are deallocated when the JVM exits
        
        System.out.println();
    }
    
    /**
     * Demonstrates memory safety
     */
    private static void demonstrateMemorySafety() {
        System.out.println("4. Memory Safety:");
        System.out.println("================");
        
        try (Arena arena = Arena.ofConfined()) {
            // Create a memory segment
            MemorySegment segment = arena.allocate(100);
            System.out.println("Segment created with size: " + segment.byteSize() + " bytes");
            
            // Safe access within bounds
            try {
                segment.set(ValueLayout.JAVA_BYTE, 0, (byte) 42);
                byte value = segment.get(ValueLayout.JAVA_BYTE, 0);
                System.out.println("Safe access - value at index 0: " + value);
            } catch (Exception e) {
                System.err.println("Safe access error: " + e.getMessage());
            }
            
            // Demonstrate bounds checking
            try {
                segment.set(ValueLayout.JAVA_BYTE, 100, (byte) 42); // Out of bounds
            } catch (Exception e) {
                System.out.println("Bounds checking works: " + e.getMessage());
            }
            
            // Demonstrate scope checking
            MemorySegment segmentCopy = segment;
            arena.close(); // Close the arena
            
            try {
                segmentCopy.get(ValueLayout.JAVA_BYTE, 0); // Access after arena is closed
            } catch (Exception e) {
                System.out.println("Scope checking works: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.err.println("Memory safety error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates memory access patterns
     */
    private static void demonstrateMemoryAccessPatterns() {
        System.out.println("5. Memory Access Patterns:");
        System.out.println("=========================");
        
        try (Arena arena = Arena.ofConfined()) {
            // Create an array of integers
            MemoryLayout arrayLayout = MemoryLayout.sequenceLayout(10, ValueLayout.JAVA_INT);
            MemorySegment arraySegment = arena.allocate(arrayLayout);
            
            // Initialize array
            for (int i = 0; i < 10; i++) {
                arraySegment.set(ValueLayout.JAVA_INT, i * 4, i * i);
            }
            
            // Read array values
            System.out.println("Array values:");
            for (int i = 0; i < 10; i++) {
                int value = arraySegment.get(ValueLayout.JAVA_INT, i * 4);
                System.out.println("  [" + i + "] = " + value);
            }
            
            // Create a 2D array layout
            MemoryLayout matrixLayout = MemoryLayout.sequenceLayout(3, 
                MemoryLayout.sequenceLayout(4, ValueLayout.JAVA_DOUBLE));
            MemorySegment matrixSegment = arena.allocate(matrixLayout);
            
            // Initialize matrix
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    double value = i * 4 + j + 0.5;
                    matrixSegment.set(ValueLayout.JAVA_DOUBLE, 
                        i * 4 * 8 + j * 8, value);
                }
            }
            
            // Read matrix values
            System.out.println("Matrix values:");
            for (int i = 0; i < 3; i++) {
                System.out.print("  Row " + i + ": ");
                for (int j = 0; j < 4; j++) {
                    double value = matrixSegment.get(ValueLayout.JAVA_DOUBLE, 
                        i * 4 * 8 + j * 8);
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            
        } catch (Exception e) {
            System.err.println("Memory access patterns error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("6. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use try-with-resources for arena management");
        System.out.println("✓ Choose appropriate arena type for your use case");
        System.out.println("✓ Always check memory bounds before access");
        System.out.println("✓ Use proper memory layouts for structured data");
        System.out.println("✓ Handle memory access exceptions properly");
        System.out.println("✓ Consider memory alignment requirements");
        System.out.println("✓ Use VarHandle for efficient memory access");
        System.out.println("✓ Avoid accessing memory after arena is closed");
        System.out.println("✓ Use appropriate data types for memory values");
        System.out.println("✓ Consider endianness for cross-platform compatibility");
        System.out.println("✓ Test memory management thoroughly");
        System.out.println("✓ Monitor memory usage and performance");
        
        System.out.println();
    }
    
    /**
     * Utility method to create a memory segment with specific size
     */
    public static MemorySegment createMemorySegment(Arena arena, long size) {
        return arena.allocate(size);
    }
    
    /**
     * Utility method to create a memory segment with specific layout
     */
    public static MemorySegment createMemorySegment(Arena arena, MemoryLayout layout) {
        return arena.allocate(layout);
    }
    
    /**
     * Utility method to safely access memory segment
     */
    public static <T> T safeGet(MemorySegment segment, ValueLayout<T> layout, long offset) {
        try {
            return segment.get(layout, offset);
        } catch (Exception e) {
            throw new RuntimeException("Memory access error", e);
        }
    }
    
    /**
     * Utility method to safely set memory segment value
     */
    public static <T> void safeSet(MemorySegment segment, ValueLayout<T> layout, long offset, T value) {
        try {
            segment.set(layout, offset, value);
        } catch (Exception e) {
            throw new RuntimeException("Memory access error", e);
        }
    }
}
