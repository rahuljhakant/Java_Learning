package com.tutorial.datastructures.queue;

/**
 * Queue Algorithms - Comprehensive Guide to Queue Operations in Java
 * 
 * This comprehensive tutorial demonstrates essential queue algorithms including
 * standard queue operations, circular queues, and advanced queue-based problems.
 * Queues are FIFO (First In, First Out) data structures that are fundamental
 * for many algorithmic problems and system operations.
 * 
 * LEARNING OBJECTIVES:
 * - Master queue operations and implementations
 * - Understand circular queue and deque operations
 * - Learn sliding window maximum using deque
 * - Practice BFS (Breadth-First Search) with queues
 * - Implement LRU cache using queue and HashMap
 * - Understand priority queue and heap operations
 * - Master time and space complexity analysis
 * 
 * KEY CONCEPTS:
 * 1. FIFO Principle: First In, First Out data access
 * 2. Circular Queue: Efficient space utilization
 * 3. Deque (Double-ended Queue): Insertion/deletion at both ends
 * 4. Priority Queue: Elements with priority ordering
 * 5. BFS Algorithm: Level-order traversal using queues
 * 6. Sliding Window: Efficient subarray processing
 * 7. LRU Cache: Least Recently Used cache implementation
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
public class QueueAlgorithms {
    
    public static void main(String[] args) {
        System.out.println("=== Queue Algorithms Demo ===");
        System.out.println();
        
        // 1. Basic Queue Operations
        demonstrateBasicQueueOperations();
        
        // 2. Circular Queue Operations
        demonstrateCircularQueueOperations();
        
        // 3. Deque Operations
        demonstrateDequeOperations();
        
        // 4. Sliding Window Maximum
        demonstrateSlidingWindowMaximum();
        
        // 5. BFS with Queue
        demonstrateBFSWithQueue();
        
        // 6. LRU Cache
        demonstrateLRUCache();
        
        // 7. Priority Queue
        demonstratePriorityQueue();
        
        // 8. Advanced Queue Problems
        demonstrateAdvancedProblems();
        
        // 9. Performance Analysis
        demonstratePerformanceAnalysis();
    }
    
    /**
     * Demonstrates basic queue operations
     */
    private static void demonstrateBasicQueueOperations() {
        System.out.println("1. Basic Queue Operations:");
        System.out.println("=========================");
        
        // Array-based Queue
        System.out.println("Array-based Queue:");
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        System.out.println("  After enqueuing 1, 2, 3: " + arrayQueue);
        System.out.println("  Front element: " + arrayQueue.front());
        System.out.println("  Dequeued element: " + arrayQueue.dequeue());
        System.out.println("  After dequeuing: " + arrayQueue);
        
        // Linked List-based Queue
        System.out.println("\nLinked List-based Queue:");
        LinkedListQueue llQueue = new LinkedListQueue();
        llQueue.enqueue(10);
        llQueue.enqueue(20);
        llQueue.enqueue(30);
        System.out.println("  After enqueuing 10, 20, 30: " + llQueue);
        System.out.println("  Front element: " + llQueue.front());
        System.out.println("  Dequeued element: " + llQueue.dequeue());
        System.out.println("  After dequeuing: " + llQueue);
        
        // Java Queue
        System.out.println("\nJava Queue:");
        java.util.Queue<Integer> javaQueue = new java.util.LinkedList<>();
        javaQueue.offer(100);
        javaQueue.offer(200);
        javaQueue.offer(300);
        System.out.println("  After offering 100, 200, 300: " + javaQueue);
        System.out.println("  Front element: " + javaQueue.peek());
        System.out.println("  Polled element: " + javaQueue.poll());
        System.out.println("  After polling: " + javaQueue);
        
        System.out.println();
    }
    
    /**
     * Demonstrates circular queue operations
     */
    private static void demonstrateCircularQueueOperations() {
        System.out.println("2. Circular Queue Operations:");
        System.out.println("============================");
        
        CircularQueue circularQueue = new CircularQueue(5);
        
        System.out.println("Enqueuing elements:");
        for (int i = 1; i <= 5; i++) {
            circularQueue.enqueue(i);
            System.out.println("  After enqueuing " + i + ": " + circularQueue);
        }
        
        System.out.println("\nTrying to enqueue when full:");
        try {
            circularQueue.enqueue(6);
        } catch (RuntimeException e) {
            System.out.println("  " + e.getMessage());
        }
        
        System.out.println("\nDequeuing elements:");
        for (int i = 0; i < 3; i++) {
            int dequeued = circularQueue.dequeue();
            System.out.println("  Dequeued: " + dequeued + ", Queue: " + circularQueue);
        }
        
        System.out.println("\nEnqueuing more elements:");
        circularQueue.enqueue(6);
        circularQueue.enqueue(7);
        System.out.println("  After enqueuing 6, 7: " + circularQueue);
        
        System.out.println("\nQueue status:");
        System.out.println("  Is full: " + circularQueue.isFull());
        System.out.println("  Is empty: " + circularQueue.isEmpty());
        System.out.println("  Size: " + circularQueue.size());
        
        System.out.println();
    }
    
    /**
     * Demonstrates deque operations
     */
    private static void demonstrateDequeOperations() {
        System.out.println("3. Deque Operations:");
        System.out.println("===================");
        
        // Java Deque
        System.out.println("Java Deque:");
        java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();
        
        // Add at both ends
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);
        System.out.println("  After adding at both ends: " + deque);
        
        // Remove from both ends
        System.out.println("  Removed from front: " + deque.removeFirst());
        System.out.println("  Removed from rear: " + deque.removeLast());
        System.out.println("  After removing from both ends: " + deque);
        
        // Peek at both ends
        System.out.println("  Front element: " + deque.peekFirst());
        System.out.println("  Rear element: " + deque.peekLast());
        
        // Custom Deque implementation
        System.out.println("\nCustom Deque Implementation:");
        CustomDeque customDeque = new CustomDeque(5);
        customDeque.addFirst(10);
        customDeque.addLast(20);
        customDeque.addFirst(30);
        customDeque.addLast(40);
        System.out.println("  Custom deque: " + customDeque);
        System.out.println("  Removed from front: " + customDeque.removeFirst());
        System.out.println("  Removed from rear: " + customDeque.removeLast());
        System.out.println("  After removing: " + customDeque);
        
        System.out.println();
    }
    
    /**
     * Demonstrates sliding window maximum
     */
    private static void demonstrateSlidingWindowMaximum() {
        System.out.println("4. Sliding Window Maximum:");
        System.out.println("=========================");
        
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        System.out.println("Array: " + java.util.Arrays.toString(nums));
        System.out.println("Window size: " + k);
        
        int[] result = maxSlidingWindow(nums, k);
        System.out.println("Maximum in each window: " + java.util.Arrays.toString(result));
        
        // Sliding Window Minimum
        System.out.println("\nSliding Window Minimum:");
        int[] minResult = minSlidingWindow(nums, k);
        System.out.println("Minimum in each window: " + java.util.Arrays.toString(minResult));
        
        // Sliding Window Average
        System.out.println("\nSliding Window Average:");
        double[] avgResult = averageSlidingWindow(nums, k);
        System.out.println("Average in each window: " + java.util.Arrays.toString(avgResult));
        
        System.out.println();
    }
    
    /**
     * Demonstrates BFS with queue
     */
    private static void demonstrateBFSWithQueue() {
        System.out.println("5. BFS with Queue:");
        System.out.println("=================");
        
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        System.out.println("Binary Tree:");
        System.out.println("     1");
        System.out.println("   /   \\");
        System.out.println("  2     3");
        System.out.println(" / \\   / \\");
        System.out.println("4   5 6   7");
        
        // Level Order Traversal
        System.out.println("\nLevel Order Traversal (BFS):");
        java.util.List<java.util.List<Integer>> levels = levelOrder(root);
        for (int i = 0; i < levels.size(); i++) {
            System.out.println("  Level " + i + ": " + levels.get(i));
        }
        
        // Binary Tree Right Side View
        System.out.println("\nBinary Tree Right Side View:");
        java.util.List<Integer> rightView = rightSideView(root);
        System.out.println("  Right side view: " + rightView);
        
        // Binary Tree Left Side View
        System.out.println("\nBinary Tree Left Side View:");
        java.util.List<Integer> leftView = leftSideView(root);
        System.out.println("  Left side view: " + leftView);
        
        System.out.println();
    }
    
    /**
     * Demonstrates LRU cache
     */
    private static void demonstrateLRUCache() {
        System.out.println("6. LRU Cache:");
        System.out.println("=============");
        
        LRUCache lruCache = new LRUCache(3);
        
        System.out.println("Operations on LRU Cache (capacity = 3):");
        
        lruCache.put(1, 10);
        System.out.println("  put(1, 10) -> Cache: " + lruCache);
        
        lruCache.put(2, 20);
        System.out.println("  put(2, 20) -> Cache: " + lruCache);
        
        lruCache.put(3, 30);
        System.out.println("  put(3, 30) -> Cache: " + lruCache);
        
        System.out.println("  get(2) -> " + lruCache.get(2) + ", Cache: " + lruCache);
        
        lruCache.put(4, 40);
        System.out.println("  put(4, 40) -> Cache: " + lruCache + " (evicted LRU: 1)");
        
        System.out.println("  get(1) -> " + lruCache.get(1) + " (not found)");
        System.out.println("  get(3) -> " + lruCache.get(3) + ", Cache: " + lruCache);
        System.out.println("  get(4) -> " + lruCache.get(4) + ", Cache: " + lruCache);
        
        System.out.println();
    }
    
    /**
     * Demonstrates priority queue
     */
    private static void demonstratePriorityQueue() {
        System.out.println("7. Priority Queue:");
        System.out.println("=================");
        
        // Min Heap (default)
        System.out.println("Min Heap (Priority Queue):");
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
        minHeap.offer(5);
        minHeap.offer(2);
        minHeap.offer(8);
        minHeap.offer(1);
        minHeap.offer(9);
        System.out.println("  After inserting 5, 2, 8, 1, 9: " + minHeap);
        System.out.println("  Peek (min): " + minHeap.peek());
        System.out.println("  Poll: " + minHeap.poll() + ", Heap: " + minHeap);
        
        // Max Heap
        System.out.println("\nMax Heap (Priority Queue with reverse order):");
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
     * Demonstrates advanced queue problems
     */
    private static void demonstrateAdvancedProblems() {
        System.out.println("8. Advanced Queue Problems:");
        System.out.println("==========================");
        
        // Rotten Oranges Problem
        System.out.println("Rotten Oranges Problem:");
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println("  Grid:");
        for (int[] row : grid) {
            System.out.println("    " + java.util.Arrays.toString(row));
        }
        int timeToRot = orangesRotting(grid);
        System.out.println("  Time to rot all oranges: " + timeToRot + " minutes");
        
        // Task Scheduler
        System.out.println("\nTask Scheduler:");
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println("  Tasks: " + java.util.Arrays.toString(tasks) + ", n = " + n);
        int minTime = leastInterval(tasks, n);
        System.out.println("  Minimum time to complete all tasks: " + minTime);
        
        // Design Circular Queue
        System.out.println("\nDesign Circular Queue:");
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println("  enQueue(1): " + circularQueue.enQueue(1));
        System.out.println("  enQueue(2): " + circularQueue.enQueue(2));
        System.out.println("  enQueue(3): " + circularQueue.enQueue(3));
        System.out.println("  enQueue(4): " + circularQueue.enQueue(4) + " (false - full)");
        System.out.println("  Rear: " + circularQueue.Rear());
        System.out.println("  isFull: " + circularQueue.isFull());
        System.out.println("  deQueue: " + circularQueue.deQueue());
        System.out.println("  enQueue(4): " + circularQueue.enQueue(4));
        System.out.println("  Rear: " + circularQueue.Rear());
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance analysis
     */
    private static void demonstratePerformanceAnalysis() {
        System.out.println("9. Performance Analysis:");
        System.out.println("=======================");
        
        System.out.println("Queue Operation Complexity:");
        System.out.println("-------------------------");
        System.out.println("Basic Operations:");
        System.out.println("  Enqueue:        O(1) time, O(1) space");
        System.out.println("  Dequeue:        O(1) time, O(1) space");
        System.out.println("  Front/Peek:     O(1) time, O(1) space");
        System.out.println("  IsEmpty:        O(1) time, O(1) space");
        System.out.println("  Size:           O(1) time, O(1) space");
        
        System.out.println("\nCircular Queue:");
        System.out.println("  Enqueue:        O(1) time, O(1) space");
        System.out.println("  Dequeue:        O(1) time, O(1) space");
        System.out.println("  Space efficient: Reuses array space");
        
        System.out.println("\nDeque Operations:");
        System.out.println("  addFirst:       O(1) time, O(1) space");
        System.out.println("  addLast:        O(1) time, O(1) space");
        System.out.println("  removeFirst:    O(1) time, O(1) space");
        System.out.println("  removeLast:     O(1) time, O(1) space");
        
        System.out.println("\nPriority Queue:");
        System.out.println("  Insert:         O(log n) time, O(1) space");
        System.out.println("  Extract Min/Max: O(log n) time, O(1) space");
        System.out.println("  Peek:           O(1) time, O(1) space");
        
        System.out.println("\nAdvanced Problems:");
        System.out.println("  Sliding Window Max: O(n) time, O(k) space");
        System.out.println("  BFS:                O(V + E) time, O(V) space");
        System.out.println("  LRU Cache:          O(1) time, O(capacity) space");
        System.out.println("  Task Scheduler:     O(n) time, O(1) space");
        
        System.out.println();
    }
    
    // Queue Implementation Classes
    
    /**
     * Array-based Queue Implementation
     */
    static class ArrayQueue {
        private int[] queue;
        private int front;
        private int rear;
        private int size;
        private int capacity;
        
        public ArrayQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new int[capacity];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }
        
        public void enqueue(int data) {
            if (isFull()) {
                throw new RuntimeException("Queue overflow");
            }
            rear = (rear + 1) % capacity;
            queue[rear] = data;
            size++;
        }
        
        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Queue underflow");
            }
            int data = queue[front];
            front = (front + 1) % capacity;
            size--;
            return data;
        }
        
        public int front() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return queue[front];
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        public boolean isFull() {
            return size == capacity;
        }
        
        public int size() {
            return size;
        }
        
        @Override
        public String toString() {
            if (isEmpty()) return "[]";
            
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % capacity;
                sb.append(queue[index]);
                if (i < size - 1) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }
    
    /**
     * Linked List-based Queue Implementation
     */
    static class LinkedListQueue {
        private Node front;
        private Node rear;
        
        static class Node {
            int data;
            Node next;
            
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
        
        public void enqueue(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }
        
        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Queue underflow");
            }
            int data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return data;
        }
        
        public int front() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return front.data;
        }
        
        public boolean isEmpty() {
            return front == null;
        }
        
        public int size() {
            int count = 0;
            Node current = front;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }
        
        @Override
        public String toString() {
            if (isEmpty()) return "[]";
            
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Node current = front;
            while (current != null) {
                sb.append(current.data);
                if (current.next != null) sb.append(", ");
                current = current.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
    
    /**
     * Circular Queue Implementation
     */
    static class CircularQueue {
        private int[] queue;
        private int front;
        private int rear;
        private int size;
        private int capacity;
        
        public CircularQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new int[capacity];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }
        
        public void enqueue(int data) {
            if (isFull()) {
                throw new RuntimeException("Queue is full");
            }
            rear = (rear + 1) % capacity;
            queue[rear] = data;
            size++;
        }
        
        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            int data = queue[front];
            front = (front + 1) % capacity;
            size--;
            return data;
        }
        
        public int front() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return queue[front];
        }
        
        public int rear() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return queue[rear];
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        public boolean isFull() {
            return size == capacity;
        }
        
        public int size() {
            return size;
        }
        
        @Override
        public String toString() {
            if (isEmpty()) return "[]";
            
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % capacity;
                sb.append(queue[index]);
                if (i < size - 1) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }
    
    /**
     * Custom Deque Implementation
     */
    static class CustomDeque {
        private int[] deque;
        private int front;
        private int rear;
        private int size;
        private int capacity;
        
        public CustomDeque(int capacity) {
            this.capacity = capacity;
            this.deque = new int[capacity];
            this.front = 0;
            this.rear = 0;
            this.size = 0;
        }
        
        public void addFirst(int data) {
            if (isFull()) {
                throw new RuntimeException("Deque is full");
            }
            front = (front - 1 + capacity) % capacity;
            deque[front] = data;
            size++;
        }
        
        public void addLast(int data) {
            if (isFull()) {
                throw new RuntimeException("Deque is full");
            }
            deque[rear] = data;
            rear = (rear + 1) % capacity;
            size++;
        }
        
        public int removeFirst() {
            if (isEmpty()) {
                throw new RuntimeException("Deque is empty");
            }
            int data = deque[front];
            front = (front + 1) % capacity;
            size--;
            return data;
        }
        
        public int removeLast() {
            if (isEmpty()) {
                throw new RuntimeException("Deque is empty");
            }
            rear = (rear - 1 + capacity) % capacity;
            int data = deque[rear];
            size--;
            return data;
        }
        
        public int getFirst() {
            if (isEmpty()) {
                throw new RuntimeException("Deque is empty");
            }
            return deque[front];
        }
        
        public int getLast() {
            if (isEmpty()) {
                throw new RuntimeException("Deque is empty");
            }
            int lastIndex = (rear - 1 + capacity) % capacity;
            return deque[lastIndex];
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        public boolean isFull() {
            return size == capacity;
        }
        
        public int size() {
            return size;
        }
        
        @Override
        public String toString() {
            if (isEmpty()) return "[]";
            
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % capacity;
                sb.append(deque[index]);
                if (i < size - 1) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }
    
    // Tree Node for BFS
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    // Sliding Window Implementation
    
    /**
     * Sliding Window Maximum
     * Time Complexity: O(n), Space Complexity: O(k)
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Remove elements outside the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove elements smaller than current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            // Add maximum of current window to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
    
    /**
     * Sliding Window Minimum
     * Time Complexity: O(n), Space Complexity: O(k)
     */
    public static int[] minSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Remove elements outside the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove elements larger than current element
            while (!deque.isEmpty() && nums[deque.peekLast()] > nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            // Add minimum of current window to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
    
    /**
     * Sliding Window Average
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static double[] averageSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];
        double sum = 0;
        
        // Calculate sum of first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        result[0] = sum / k;
        
        // Slide the window
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            result[i - k + 1] = sum / k;
        }
        
        return result;
    }
    
    // BFS Implementation
    
    /**
     * Level Order Traversal (BFS)
     * Time Complexity: O(n), Space Complexity: O(w) where w is maximum width
     */
    public static java.util.List<java.util.List<Integer>> levelOrder(TreeNode root) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if (root == null) return result;
        
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            java.util.List<Integer> currentLevel = new java.util.ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            result.add(currentLevel);
        }
        
        return result;
    }
    
    /**
     * Binary Tree Right Side View
     * Time Complexity: O(n), Space Complexity: O(w)
     */
    public static java.util.List<Integer> rightSideView(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (root == null) return result;
        
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                if (i == levelSize - 1) { // Last node in current level
                    result.add(node.val);
                }
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        
        return result;
    }
    
    /**
     * Binary Tree Left Side View
     * Time Complexity: O(n), Space Complexity: O(w)
     */
    public static java.util.List<Integer> leftSideView(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (root == null) return result;
        
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                if (i == 0) { // First node in current level
                    result.add(node.val);
                }
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        
        return result;
    }
    
    // LRU Cache Implementation
    
    /**
     * LRU Cache Implementation
     */
    static class LRUCache {
        private int capacity;
        private java.util.LinkedHashMap<Integer, Integer> cache;
        
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new java.util.LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }
        
        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }
        
        public void put(int key, int value) {
            cache.put(key, value);
        }
        
        @Override
        public String toString() {
            return cache.toString();
        }
    }
    
    // Advanced Problems Implementation
    
    /**
     * Rotten Oranges Problem
     * Time Complexity: O(m * n), Space Complexity: O(m * n)
     */
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        int freshOranges = 0;
        
        // Find all rotten oranges and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        if (freshOranges == 0) return 0;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int time = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotten = false;
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                
                for (int[] dir : directions) {
                    int newRow = current[0] + dir[0];
                    int newCol = current[1] + dir[1];
                    
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                        grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        freshOranges--;
                        hasRotten = true;
                    }
                }
            }
            
            if (hasRotten) time++;
        }
        
        return freshOranges == 0 ? time : -1;
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
     * Design Circular Queue
     */
    static class MyCircularQueue {
        private int[] queue;
        private int front;
        private int rear;
        private int size;
        private int capacity;
        
        public MyCircularQueue(int k) {
            this.capacity = k;
            this.queue = new int[k];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }
        
        public boolean enQueue(int value) {
            if (isFull()) return false;
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            return true;
        }
        
        public boolean deQueue() {
            if (isEmpty()) return false;
            front = (front + 1) % capacity;
            size--;
            return true;
        }
        
        public int Front() {
            return isEmpty() ? -1 : queue[front];
        }
        
        public int Rear() {
            return isEmpty() ? -1 : queue[rear];
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        public boolean isFull() {
            return size == capacity;
        }
    }
}
