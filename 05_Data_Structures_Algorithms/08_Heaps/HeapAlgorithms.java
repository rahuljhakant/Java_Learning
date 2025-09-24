package com.tutorial.datastructures.heaps;

/**
 * Heap Algorithms - Comprehensive Guide to Heap Operations in Java
 * 
 * This comprehensive tutorial demonstrates essential heap algorithms including
 * min heap, max heap, heap sort, and priority queue operations. Heaps are
 * complete binary trees that maintain heap property and are fundamental for
 * many algorithms and data structures.
 * 
 * LEARNING OBJECTIVES:
 * - Master min heap and max heap operations
 * - Understand heapify and heap sort algorithms
 * - Learn priority queue implementation and usage
 * - Practice finding Kth largest/smallest elements
 * - Implement merge K sorted arrays using heaps
 * - Understand median in data stream problems
 * - Master time and space complexity analysis
 * 
 * KEY CONCEPTS:
 * 1. Heap Property: Min heap (parent ≤ children) and Max heap (parent ≥ children)
 * 2. Complete Binary Tree: All levels filled except possibly the last
 * 3. Heapify: Maintaining heap property after insertion/deletion
 * 4. Priority Queue: Heap-based implementation for efficient operations
 * 5. Heap Sort: Sorting using heap data structure
 * 6. Top K Problems: Finding K largest/smallest elements efficiently
 * 7. Median Maintenance: Using two heaps for dynamic median
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class HeapAlgorithms {
    
    public static void main(String[] args) {
        System.out.println("=== Heap Algorithms Demo ===");
        System.out.println();
        
        // 1. Basic Heap Operations
        demonstrateBasicHeapOperations();
        
        // 2. Min Heap Implementation
        demonstrateMinHeap();
        
        // 3. Max Heap Implementation
        demonstrateMaxHeap();
        
        // 4. Heap Sort
        demonstrateHeapSort();
        
        // 5. Priority Queue
        demonstratePriorityQueue();
        
        // 6. Top K Problems
        demonstrateTopKProblems();
        
        // 7. Merge K Sorted Arrays
        demonstrateMergeKSortedArrays();
        
        // 8. Median in Data Stream
        demonstrateMedianInDataStream();
        
        // 9. Advanced Heap Problems
        demonstrateAdvancedProblems();
        
        // 10. Performance Analysis
        demonstratePerformanceAnalysis();
    }
    
    /**
     * Demonstrates basic heap operations
     */
    private static void demonstrateBasicHeapOperations() {
        System.out.println("1. Basic Heap Operations:");
        System.out.println("========================");
        
        // Java Priority Queue (Min Heap by default)
        System.out.println("Java Priority Queue (Min Heap):");
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
        minHeap.offer(5);
        minHeap.offer(2);
        minHeap.offer(8);
        minHeap.offer(1);
        minHeap.offer(9);
        System.out.println("  After inserting 5, 2, 8, 1, 9: " + minHeap);
        System.out.println("  Peek (min): " + minHeap.peek());
        System.out.println("  Poll: " + minHeap.poll() + ", Heap: " + minHeap);
        
        // Java Priority Queue (Max Heap)
        System.out.println("\nJava Priority Queue (Max Heap):");
        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
        maxHeap.offer(5);
        maxHeap.offer(2);
        maxHeap.offer(8);
        maxHeap.offer(1);
        maxHeap.offer(9);
        System.out.println("  After inserting 5, 2, 8, 1, 9: " + maxHeap);
        System.out.println("  Peek (max): " + maxHeap.peek());
        System.out.println("  Poll: " + maxHeap.poll() + ", Heap: " + maxHeap);
        
        // Custom Priority Queue
        System.out.println("\nCustom Priority Queue (by string length):");
        java.util.PriorityQueue<String> customPQ = new java.util.PriorityQueue<>((a, b) -> a.length() - b.length());
        customPQ.offer("apple");
        customPQ.offer("pie");
        customPQ.offer("banana");
        customPQ.offer("cat");
        System.out.println("  After inserting by length: " + customPQ);
        
        System.out.println();
    }
    
    /**
     * Demonstrates min heap implementation
     */
    private static void demonstrateMinHeap() {
        System.out.println("2. Min Heap Implementation:");
        System.out.println("===========================");
        
        MinHeap minHeap = new MinHeap(10);
        
        System.out.println("Min Heap Operations:");
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(9);
        System.out.println("  After inserting 5, 2, 8, 1, 9: " + minHeap);
        System.out.println("  Min element: " + minHeap.getMin());
        System.out.println("  Extract min: " + minHeap.extractMin());
        System.out.println("  After extracting min: " + minHeap);
        System.out.println("  Size: " + minHeap.size());
        System.out.println("  Is empty: " + minHeap.isEmpty());
        
        // Heapify array
        System.out.println("\nHeapify Array:");
        int[] arr = {9, 4, 7, 1, -2, 6, 5};
        System.out.println("  Original array: " + java.util.Arrays.toString(arr));
        MinHeap heapified = new MinHeap(arr);
        System.out.println("  Heapified: " + heapified);
        
        System.out.println();
    }
    
    /**
     * Demonstrates max heap implementation
     */
    private static void demonstrateMaxHeap() {
        System.out.println("3. Max Heap Implementation:");
        System.out.println("===========================");
        
        MaxHeap maxHeap = new MaxHeap(10);
        
        System.out.println("Max Heap Operations:");
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(8);
        maxHeap.insert(1);
        maxHeap.insert(9);
        System.out.println("  After inserting 5, 2, 8, 1, 9: " + maxHeap);
        System.out.println("  Max element: " + maxHeap.getMax());
        System.out.println("  Extract max: " + maxHeap.extractMax());
        System.out.println("  After extracting max: " + maxHeap);
        System.out.println("  Size: " + maxHeap.size());
        System.out.println("  Is empty: " + maxHeap.isEmpty());
        
        // Heapify array
        System.out.println("\nHeapify Array:");
        int[] arr = {9, 4, 7, 1, -2, 6, 5};
        System.out.println("  Original array: " + java.util.Arrays.toString(arr));
        MaxHeap heapified = new MaxHeap(arr);
        System.out.println("  Heapified: " + heapified);
        
        System.out.println();
    }
    
    /**
     * Demonstrates heap sort
     */
    private static void demonstrateHeapSort() {
        System.out.println("4. Heap Sort:");
        System.out.println("=============");
        
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));
        
        // Heap Sort (Ascending)
        int[] ascendingArr = arr.clone();
        heapSortAscending(ascendingArr);
        System.out.println("Heap sort (ascending): " + java.util.Arrays.toString(ascendingArr));
        
        // Heap Sort (Descending)
        int[] descendingArr = arr.clone();
        heapSortDescending(descendingArr);
        System.out.println("Heap sort (descending): " + java.util.Arrays.toString(descendingArr));
        
        // In-place heap sort
        int[] inPlaceArr = arr.clone();
        inPlaceHeapSort(inPlaceArr);
        System.out.println("In-place heap sort: " + java.util.Arrays.toString(inPlaceArr));
        
        System.out.println();
    }
    
    /**
     * Demonstrates priority queue
     */
    private static void demonstratePriorityQueue() {
        System.out.println("5. Priority Queue:");
        System.out.println("==================");
        
        // Custom Priority Queue for tasks
        System.out.println("Task Priority Queue:");
        java.util.PriorityQueue<Task> taskQueue = new java.util.PriorityQueue<>();
        taskQueue.offer(new Task("High Priority Task", 1));
        taskQueue.offer(new Task("Low Priority Task", 3));
        taskQueue.offer(new Task("Medium Priority Task", 2));
        taskQueue.offer(new Task("Critical Task", 0));
        
        System.out.println("  Tasks in priority order:");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("    " + task);
        }
        
        // Custom Priority Queue for students
        System.out.println("\nStudent Priority Queue (by GPA):");
        java.util.PriorityQueue<Student> studentQueue = new java.util.PriorityQueue<>((a, b) -> Double.compare(b.gpa, a.gpa));
        studentQueue.offer(new Student("Alice", 3.8));
        studentQueue.offer(new Student("Bob", 3.2));
        studentQueue.offer(new Student("Charlie", 3.9));
        studentQueue.offer(new Student("Diana", 3.5));
        
        System.out.println("  Students by GPA (highest first):");
        while (!studentQueue.isEmpty()) {
            Student student = studentQueue.poll();
            System.out.println("    " + student);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates top K problems
     */
    private static void demonstrateTopKProblems() {
        System.out.println("6. Top K Problems:");
        System.out.println("==================");
        
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int k = 3;
        
        System.out.println("Array: " + java.util.Arrays.toString(nums));
        System.out.println("K = " + k);
        
        // Top K Largest Elements
        java.util.List<Integer> topKLargest = findTopKLargest(nums, k);
        System.out.println("  Top " + k + " largest elements: " + topKLargest);
        
        // Top K Smallest Elements
        java.util.List<Integer> topKSmallest = findTopKSmallest(nums, k);
        System.out.println("  Top " + k + " smallest elements: " + topKSmallest);
        
        // Kth Largest Element
        int kthLargest = findKthLargest(nums, k);
        System.out.println("  " + k + "th largest element: " + kthLargest);
        
        // Kth Smallest Element
        int kthSmallest = findKthSmallest(nums, k);
        System.out.println("  " + k + "th smallest element: " + kthSmallest);
        
        // Top K Frequent Elements
        int[] freqNums = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4};
        java.util.List<Integer> topKFrequent = findTopKFrequent(freqNums, 2);
        System.out.println("\nFrequency array: " + java.util.Arrays.toString(freqNums));
        System.out.println("  Top 2 frequent elements: " + topKFrequent);
        
        System.out.println();
    }
    
    /**
     * Demonstrates merge K sorted arrays
     */
    private static void demonstrateMergeKSortedArrays() {
        System.out.println("7. Merge K Sorted Arrays:");
        System.out.println("========================");
        
        int[][] sortedArrays = {
            {1, 4, 7, 10},
            {2, 5, 8, 11},
            {3, 6, 9, 12}
        };
        
        System.out.println("Sorted arrays:");
        for (int i = 0; i < sortedArrays.length; i++) {
            System.out.println("  Array " + i + ": " + java.util.Arrays.toString(sortedArrays[i]));
        }
        
        // Merge K sorted arrays
        int[] merged = mergeKSortedArrays(sortedArrays);
        System.out.println("  Merged result: " + java.util.Arrays.toString(merged));
        
        // Merge K sorted lists
        System.out.println("\nMerge K Sorted Lists:");
        java.util.List<java.util.List<Integer>> sortedLists = java.util.Arrays.asList(
            java.util.Arrays.asList(1, 4, 7),
            java.util.Arrays.asList(2, 5, 8),
            java.util.Arrays.asList(3, 6, 9)
        );
        
        for (int i = 0; i < sortedLists.size(); i++) {
            System.out.println("  List " + i + ": " + sortedLists.get(i));
        }
        
        java.util.List<Integer> mergedList = mergeKSortedLists(sortedLists);
        System.out.println("  Merged list: " + mergedList);
        
        System.out.println();
    }
    
    /**
     * Demonstrates median in data stream
     */
    private static void demonstrateMedianInDataStream() {
        System.out.println("8. Median in Data Stream:");
        System.out.println("========================");
        
        MedianFinder medianFinder = new MedianFinder();
        
        int[] stream = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Adding numbers to stream:");
        
        for (int num : stream) {
            medianFinder.addNum(num);
            double median = medianFinder.findMedian();
            System.out.println("  Add " + num + " -> Median: " + median);
        }
        
        // Sliding Window Median
        System.out.println("\nSliding Window Median:");
        int[] windowNums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        double[] windowMedians = medianSlidingWindow(windowNums, k);
        System.out.println("  Array: " + java.util.Arrays.toString(windowNums));
        System.out.println("  Window size: " + k);
        System.out.println("  Sliding window medians: " + java.util.Arrays.toString(windowMedians));
        
        System.out.println();
    }
    
    /**
     * Demonstrates advanced heap problems
     */
    private static void demonstrateAdvancedProblems() {
        System.out.println("9. Advanced Heap Problems:");
        System.out.println("=========================");
        
        // Find Median from Data Stream
        System.out.println("Find Median from Data Stream:");
        MedianFinder medianFinder = new MedianFinder();
        int[] numbers = {5, 15, 1, 3};
        for (int num : numbers) {
            medianFinder.addNum(num);
            System.out.println("  Add " + num + " -> Median: " + medianFinder.findMedian());
        }
        
        // Last Stone Weight
        System.out.println("\nLast Stone Weight:");
        int[] stones = {2, 7, 4, 1, 8, 1};
        int lastWeight = lastStoneWeight(stones);
        System.out.println("  Stones: " + java.util.Arrays.toString(stones));
        System.out.println("  Last stone weight: " + lastWeight);
        
        // Reorganize String
        System.out.println("\nReorganize String:");
        String[] testStrings = {"aab", "aaab", "aabbcc"};
        for (String str : testStrings) {
            String reorganized = reorganizeString(str);
            System.out.println("  \"" + str + "\" -> \"" + reorganized + "\"");
        }
        
        // Task Scheduler
        System.out.println("\nTask Scheduler:");
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        int minTime = leastInterval(tasks, n);
        System.out.println("  Tasks: " + java.util.Arrays.toString(tasks) + ", n = " + n);
        System.out.println("  Minimum time: " + minTime);
        
        // K Closest Points to Origin
        System.out.println("\nK Closest Points to Origin:");
        int[][] points = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int k = 3;
        int[][] closest = kClosest(points, k);
        System.out.println("  Points: " + java.util.Arrays.deepToString(points));
        System.out.println("  K = " + k);
        System.out.println("  K closest points: " + java.util.Arrays.deepToString(closest));
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance analysis
     */
    private static void demonstratePerformanceAnalysis() {
        System.out.println("10. Performance Analysis:");
        System.out.println("========================");
        
        System.out.println("Heap Operation Complexity:");
        System.out.println("------------------------");
        System.out.println("Basic Operations:");
        System.out.println("  Insert:         O(log n) time, O(1) space");
        System.out.println("  Extract Min/Max: O(log n) time, O(1) space");
        System.out.println("  Peek:           O(1) time, O(1) space");
        System.out.println("  Delete:         O(log n) time, O(1) space");
        System.out.println("  Heapify:        O(n) time, O(1) space");
        
        System.out.println("\nHeap Sort:");
        System.out.println("  Time Complexity: O(n log n)");
        System.out.println("  Space Complexity: O(1) for in-place, O(n) for extra space");
        System.out.println("  Stable: No");
        System.out.println("  In-place: Yes (with optimization)");
        
        System.out.println("\nPriority Queue:");
        System.out.println("  Insert:         O(log n) time");
        System.out.println("  Extract:        O(log n) time");
        System.out.println("  Peek:           O(1) time");
        System.out.println("  Size:           O(1) time");
        
        System.out.println("\nAdvanced Problems:");
        System.out.println("  Top K Elements:     O(n log k) time, O(k) space");
        System.out.println("  Merge K Arrays:     O(n log k) time, O(k) space");
        System.out.println("  Median in Stream:   O(log n) per operation");
        System.out.println("  Task Scheduler:     O(n) time, O(1) space");
        System.out.println("  K Closest Points:   O(n log k) time, O(k) space");
        
        System.out.println();
    }
    
    // Helper Classes
    
    static class Task implements Comparable<Task> {
        String name;
        int priority; // Lower number = higher priority
        
        Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }
        
        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.priority, other.priority);
        }
        
        @Override
        public String toString() {
            return name + " (Priority: " + priority + ")";
        }
    }
    
    static class Student {
        String name;
        double gpa;
        
        Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }
        
        @Override
        public String toString() {
            return name + " (GPA: " + gpa + ")";
        }
    }
    
    // Min Heap Implementation
    
    static class MinHeap {
        private int[] heap;
        private int size;
        private int capacity;
        
        public MinHeap(int capacity) {
            this.capacity = capacity;
            this.heap = new int[capacity];
            this.size = 0;
        }
        
        public MinHeap(int[] arr) {
            this.capacity = arr.length;
            this.heap = arr.clone();
            this.size = arr.length;
            buildMinHeap();
        }
        
        private void buildMinHeap() {
            for (int i = size / 2 - 1; i >= 0; i--) {
                minHeapify(i);
            }
        }
        
        public void insert(int value) {
            if (size >= capacity) {
                throw new RuntimeException("Heap overflow");
            }
            
            heap[size] = value;
            int current = size;
            size++;
            
            // Heapify up
            while (current > 0 && heap[current] < heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }
        
        public int extractMin() {
            if (size == 0) {
                throw new RuntimeException("Heap underflow");
            }
            
            int min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            minHeapify(0);
            
            return min;
        }
        
        public int getMin() {
            if (size == 0) {
                throw new RuntimeException("Heap is empty");
            }
            return heap[0];
        }
        
        private void minHeapify(int index) {
            int smallest = index;
            int left = leftChild(index);
            int right = rightChild(index);
            
            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }
            
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }
            
            if (smallest != index) {
                swap(index, smallest);
                minHeapify(smallest);
            }
        }
        
        private int parent(int index) {
            return (index - 1) / 2;
        }
        
        private int leftChild(int index) {
            return 2 * index + 1;
        }
        
        private int rightChild(int index) {
            return 2 * index + 2;
        }
        
        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
        
        public int size() {
            return size;
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        @Override
        public String toString() {
            if (size == 0) return "[]";
            
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(heap[i]);
                if (i < size - 1) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }
    
    // Max Heap Implementation
    
    static class MaxHeap {
        private int[] heap;
        private int size;
        private int capacity;
        
        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.heap = new int[capacity];
            this.size = 0;
        }
        
        public MaxHeap(int[] arr) {
            this.capacity = arr.length;
            this.heap = arr.clone();
            this.size = arr.length;
            buildMaxHeap();
        }
        
        private void buildMaxHeap() {
            for (int i = size / 2 - 1; i >= 0; i--) {
                maxHeapify(i);
            }
        }
        
        public void insert(int value) {
            if (size >= capacity) {
                throw new RuntimeException("Heap overflow");
            }
            
            heap[size] = value;
            int current = size;
            size++;
            
            // Heapify up
            while (current > 0 && heap[current] > heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }
        
        public int extractMax() {
            if (size == 0) {
                throw new RuntimeException("Heap underflow");
            }
            
            int max = heap[0];
            heap[0] = heap[size - 1];
            size--;
            maxHeapify(0);
            
            return max;
        }
        
        public int getMax() {
            if (size == 0) {
                throw new RuntimeException("Heap is empty");
            }
            return heap[0];
        }
        
        private void maxHeapify(int index) {
            int largest = index;
            int left = leftChild(index);
            int right = rightChild(index);
            
            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }
            
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }
            
            if (largest != index) {
                swap(index, largest);
                maxHeapify(largest);
            }
        }
        
        private int parent(int index) {
            return (index - 1) / 2;
        }
        
        private int leftChild(int index) {
            return 2 * index + 1;
        }
        
        private int rightChild(int index) {
            return 2 * index + 2;
        }
        
        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
        
        public int size() {
            return size;
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        @Override
        public String toString() {
            if (size == 0) return "[]";
            
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(heap[i]);
                if (i < size - 1) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }
    
    // Heap Sort Implementation
    
    /**
     * Heap Sort (Ascending)
     * Time Complexity: O(n log n), Space Complexity: O(1)
     */
    public static void heapSortAscending(int[] arr) {
        int n = arr.length;
        
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
        
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(arr, 0, i);
            
            // Call max heapify on the reduced heap
            maxHeapify(arr, i, 0);
        }
    }
    
    /**
     * Heap Sort (Descending)
     * Time Complexity: O(n log n), Space Complexity: O(1)
     */
    public static void heapSortDescending(int[] arr) {
        int n = arr.length;
        
        // Build min heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(arr, n, i);
        }
        
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(arr, 0, i);
            
            // Call min heapify on the reduced heap
            minHeapify(arr, i, 0);
        }
    }
    
    /**
     * In-place Heap Sort
     * Time Complexity: O(n log n), Space Complexity: O(1)
     */
    public static void inPlaceHeapSort(int[] arr) {
        heapSortAscending(arr);
    }
    
    private static void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, n, largest);
        }
    }
    
    private static void minHeapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }
        
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }
        
        if (smallest != i) {
            swap(arr, i, smallest);
            minHeapify(arr, n, smallest);
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Top K Problems Implementation
    
    /**
     * Find Top K Largest Elements
     * Time Complexity: O(n log k), Space Complexity: O(k)
     */
    public static java.util.List<Integer> findTopKLargest(int[] nums, int k) {
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return new java.util.ArrayList<>(minHeap);
    }
    
    /**
     * Find Top K Smallest Elements
     * Time Complexity: O(n log k), Space Complexity: O(k)
     */
    public static java.util.List<Integer> findTopKSmallest(int[] nums, int k) {
        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
        
        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        return new java.util.ArrayList<>(maxHeap);
    }
    
    /**
     * Find Kth Largest Element
     * Time Complexity: O(n log k), Space Complexity: O(k)
     */
    public static int findKthLargest(int[] nums, int k) {
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
    
    /**
     * Find Kth Smallest Element
     * Time Complexity: O(n log k), Space Complexity: O(k)
     */
    public static int findKthSmallest(int[] nums, int k) {
        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
        
        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        return maxHeap.peek();
    }
    
    /**
     * Find Top K Frequent Elements
     * Time Complexity: O(n log k), Space Complexity: O(n)
     */
    public static java.util.List<Integer> findTopKFrequent(int[] nums, int k) {
        java.util.Map<Integer, Integer> frequency = new java.util.HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        java.util.PriorityQueue<java.util.Map.Entry<Integer, Integer>> heap = 
            new java.util.PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        for (java.util.Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        java.util.List<Integer> result = new java.util.ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll().getKey());
        }
        
        java.util.Collections.reverse(result);
        return result;
    }
    
    // Merge K Sorted Arrays Implementation
    
    /**
     * Merge K Sorted Arrays
     * Time Complexity: O(n log k), Space Complexity: O(k)
     */
    public static int[] mergeKSortedArrays(int[][] arrays) {
        java.util.PriorityQueue<int[]> minHeap = new java.util.PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Add first element of each array to heap
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new int[]{arrays[i][0], i, 0});
            }
        }
        
        java.util.List<Integer> result = new java.util.ArrayList<>();
        
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int value = current[0];
            int arrayIndex = current[1];
            int elementIndex = current[2];
            
            result.add(value);
            
            // Add next element from the same array
            if (elementIndex + 1 < arrays[arrayIndex].length) {
                minHeap.offer(new int[]{arrays[arrayIndex][elementIndex + 1], arrayIndex, elementIndex + 1});
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    /**
     * Merge K Sorted Lists
     * Time Complexity: O(n log k), Space Complexity: O(k)
     */
    public static java.util.List<Integer> mergeKSortedLists(java.util.List<java.util.List<Integer>> lists) {
        java.util.PriorityQueue<int[]> minHeap = new java.util.PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Add first element of each list to heap
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.offer(new int[]{lists.get(i).get(0), i, 0});
            }
        }
        
        java.util.List<Integer> result = new java.util.ArrayList<>();
        
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int value = current[0];
            int listIndex = current[1];
            int elementIndex = current[2];
            
            result.add(value);
            
            // Add next element from the same list
            if (elementIndex + 1 < lists.get(listIndex).size()) {
                minHeap.offer(new int[]{lists.get(listIndex).get(elementIndex + 1), listIndex, elementIndex + 1});
            }
        }
        
        return result;
    }
    
    // Median in Data Stream Implementation
    
    /**
     * Median Finder using two heaps
     */
    static class MedianFinder {
        private java.util.PriorityQueue<Integer> maxHeap; // Left half
        private java.util.PriorityQueue<Integer> minHeap; // Right half
        
        public MedianFinder() {
            maxHeap = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
            minHeap = new java.util.PriorityQueue<>();
        }
        
        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            
            // Balance the heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
        
        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }
    
    /**
     * Sliding Window Median
     * Time Complexity: O(n log k), Space Complexity: O(k)
     */
    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Add new element
            if (maxHeap.isEmpty() || nums[i] <= maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }
            
            // Remove old element
            if (i >= k) {
                int oldElement = nums[i - k];
                if (oldElement <= maxHeap.peek()) {
                    maxHeap.remove(oldElement);
                } else {
                    minHeap.remove(oldElement);
                }
            }
            
            // Balance heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            
            // Calculate median
            if (i >= k - 1) {
                if (maxHeap.size() > minHeap.size()) {
                    result[i - k + 1] = maxHeap.peek();
                } else {
                    result[i - k + 1] = (maxHeap.peek() + minHeap.peek()) / 2.0;
                }
            }
        }
        
        return result;
    }
    
    // Advanced Problems Implementation
    
    /**
     * Last Stone Weight
     * Time Complexity: O(n log n), Space Complexity: O(n)
     */
    public static int lastStoneWeight(int[] stones) {
        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
        
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        
        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            
            if (first != second) {
                maxHeap.offer(first - second);
            }
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
    
    /**
     * Reorganize String
     * Time Complexity: O(n log k), Space Complexity: O(k)
     */
    public static String reorganizeString(String s) {
        java.util.Map<Character, Integer> count = new java.util.HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        java.util.PriorityQueue<Character> maxHeap = new java.util.PriorityQueue<>((a, b) -> count.get(b) - count.get(a));
        maxHeap.addAll(count.keySet());
        
        StringBuilder result = new StringBuilder();
        char prev = 0;
        
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            result.append(current);
            count.put(current, count.get(current) - 1);
            
            if (prev != 0 && count.get(prev) > 0) {
                maxHeap.offer(prev);
            }
            
            prev = count.get(current) > 0 ? current : 0;
        }
        
        return result.length() == s.length() ? result.toString() : "";
    }
    
    /**
     * Task Scheduler
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        
        java.util.Arrays.sort(frequencies);
        int maxFreq = frequencies[25];
        int idleSlots = (maxFreq - 1) * n;
        
        for (int i = 24; i >= 0 && frequencies[i] > 0; i--) {
            idleSlots -= Math.min(maxFreq - 1, frequencies[i]);
        }
        
        return Math.max(tasks.length, tasks.length + idleSlots);
    }
    
    /**
     * K Closest Points to Origin
     * Time Complexity: O(n log k), Space Complexity: O(k)
     */
    public static int[][] kClosest(int[][] points, int k) {
        java.util.PriorityQueue<int[]> maxHeap = new java.util.PriorityQueue<>((a, b) -> 
            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        
        return result;
    }
}
