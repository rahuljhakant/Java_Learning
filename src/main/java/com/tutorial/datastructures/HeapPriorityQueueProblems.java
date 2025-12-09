package com.tutorial.datastructures;

import java.util.*;

/**
 * Heap & Priority Queue Problems - Comprehensive Solutions
 * 
 * This comprehensive implementation covers all essential heap and priority queue problems
 * commonly asked in technical interviews. Each solution includes detailed explanations,
 * time/space complexity analysis, and multiple approaches where applicable.
 * 
 * PROBLEMS COVERED:
 * 1. Kth Largest Element in an Array (Medium) - Use a min-heap
 * 2. Top K Frequent Elements (Medium) - Use a heap or bucket sort
 * 3. Find Median from Data Stream (Hard) - Use two heaps (min and max)
 * 4. Merge k Sorted Lists (Hard) - Also solvable with a heap
 * 5. Last Stone Weight (Easy) - Use a max-heap
 * 6. Reorganize String (Medium) - Use a max-heap with frequency
 * 7. Task Scheduler (Medium) - Use a max-heap for task frequencies
 * 8. K Closest Points to Origin (Medium) - Use a max-heap
 * 9. Sliding Window Maximum (Hard) - Use a deque or heap
 * 10. Ugly Number II (Medium) - Use a min-heap
 * 11. Super Ugly Number (Medium) - Use a min-heap
 * 12. Kth Smallest Element in a Sorted Matrix (Medium) - Use a min-heap
 * 13. Find K Pairs with Smallest Sums (Medium) - Use a min-heap
 * 14. Sort Characters By Frequency (Medium) - Use a max-heap
 * 15. Maximum Performance of a Team (Hard) - Use a min-heap with sorting
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class HeapPriorityQueueProblems {

    public static void main(String[] args) {
        System.out.println("=== Heap & Priority Queue Problems ===");
        System.out.println();
        
        // Run all problem demonstrations
        demonstrateKthLargestElement();
        demonstrateTopKFrequentElements();
        demonstrateFindMedianFromDataStream();
        demonstrateMergeKSortedLists();
        demonstrateLastStoneWeight();
        demonstrateReorganizeString();
        demonstrateTaskScheduler();
        demonstrateKClosestPointsToOrigin();
        demonstrateSlidingWindowMaximum();
        demonstrateUglyNumberII();
        demonstrateSuperUglyNumber();
        demonstrateKthSmallestElementInSortedMatrix();
        demonstrateFindKPairsWithSmallestSums();
        demonstrateSortCharactersByFrequency();
        demonstrateMaximumPerformanceOfATeam();
    }

    /**
     * 1. Kth Largest Element in an Array (Medium)
     * Use a min-heap
     * Time: O(n log k), Space: O(k)
     */
    public static void demonstrateKthLargestElement() {
        System.out.println("1. Kth Largest Element in an Array (Medium):");
        System.out.println("===========================================");
        
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("K = " + k);
        
        int kthLargest = findKthLargest(nums, k);
        System.out.println("Kth largest element: " + kthLargest);
        
        // Test with different values
        for (int i = 1; i <= nums.length; i++) {
            int result = findKthLargest(nums, i);
            System.out.println("Kth largest (k=" + i + "): " + result);
        }
        
        System.out.println("Time: O(n log k), Space: O(k)");
        System.out.println();
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }

    /**
     * 2. Top K Frequent Elements (Medium)
     * Use a heap or bucket sort
     * Time: O(n log k), Space: O(n)
     */
    public static void demonstrateTopKFrequentElements() {
        System.out.println("2. Top K Frequent Elements (Medium):");
        System.out.println("===================================");
        
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        
        System.out.println("Array: " + Arrays.toString(nums1));
        System.out.println("K = " + k1);
        
        int[] result1 = topKFrequent(nums1, k1);
        System.out.println("Top K frequent elements: " + Arrays.toString(result1));
        
        int[] nums2 = {1, 2};
        int k2 = 2;
        
        System.out.println("\nArray: " + Arrays.toString(nums2));
        System.out.println("K = " + k2);
        
        int[] result2 = topKFrequent(nums2, k2);
        System.out.println("Top K frequent elements: " + Arrays.toString(result2));
        
        System.out.println("Time: O(n log k), Space: O(n)");
        System.out.println();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        
        return result;
    }

    /**
     * 3. Find Median from Data Stream (Hard)
     * Use two heaps (min and max)
     * Time: O(log n) add, O(1) find, Space: O(n)
     */
    public static void demonstrateFindMedianFromDataStream() {
        System.out.println("3. Find Median from Data Stream (Hard):");
        System.out.println("=======================================");
        
        MedianFinder medianFinder = new MedianFinder();
        
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Adding numbers to stream:");
        
        for (int num : numbers) {
            medianFinder.addNum(num);
            double median = medianFinder.findMedian();
            System.out.println("Add " + num + " -> Median: " + median);
        }
        
        // Test with different sequence
        System.out.println("\nDifferent sequence:");
        MedianFinder medianFinder2 = new MedianFinder();
        int[] numbers2 = {5, 15, 1, 3};
        
        for (int num : numbers2) {
            medianFinder2.addNum(num);
            double median = medianFinder2.findMedian();
            System.out.println("Add " + num + " -> Median: " + median);
        }
        
        System.out.println("Time: O(log n) add, O(1) find, Space: O(n)");
        System.out.println();
    }

    static class MedianFinder {
        private PriorityQueue<Integer> maxHeap; // Left half (smaller numbers)
        private PriorityQueue<Integer> minHeap; // Right half (larger numbers)
        
        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
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
     * 4. Merge k Sorted Lists (Hard)
     * Also solvable with a heap
     * Time: O(n log k), Space: O(k)
     */
    public static void demonstrateMergeKSortedLists() {
        System.out.println("4. Merge k Sorted Lists (Hard):");
        System.out.println("===============================");
        
        // Create sample sorted lists
        ListNode list1 = createList(new int[]{1, 4, 5});
        ListNode list2 = createList(new int[]{1, 3, 4});
        ListNode list3 = createList(new int[]{2, 6});
        
        System.out.println("List 1: " + listToString(list1));
        System.out.println("List 2: " + listToString(list2));
        System.out.println("List 3: " + listToString(list3));
        
        ListNode[] lists = {list1, list2, list3};
        ListNode merged = mergeKLists(lists);
        System.out.println("Merged: " + listToString(merged));
        
        System.out.println("Time: O(n log k), Space: O(k)");
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add first node of each list to heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;
            
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        
        return dummy.next;
    }

    /**
     * 5. Last Stone Weight (Easy)
     * Use a max-heap
     * Time: O(n log n), Space: O(n)
     */
    public static void demonstrateLastStoneWeight() {
        System.out.println("5. Last Stone Weight (Easy):");
        System.out.println("============================");
        
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        int[] stones2 = {1};
        
        System.out.println("Stones: " + Arrays.toString(stones1));
        int lastWeight1 = lastStoneWeight(stones1);
        System.out.println("Last stone weight: " + lastWeight1);
        
        System.out.println("\nStones: " + Arrays.toString(stones2));
        int lastWeight2 = lastStoneWeight(stones2);
        System.out.println("Last stone weight: " + lastWeight2);
        
        System.out.println("Time: O(n log n), Space: O(n)");
        System.out.println();
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
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
     * 6. Reorganize String (Medium)
     * Use a max-heap with frequency
     * Time: O(n log k), Space: O(k)
     */
    public static void demonstrateReorganizeString() {
        System.out.println("6. Reorganize String (Medium):");
        System.out.println("==============================");
        
        String[] testCases = {"aab", "aaab", "aabbcc", "vvvlo"};
        
        for (String s : testCases) {
            String result = reorganizeString(s);
            System.out.println("Input: \"" + s + "\"");
            System.out.println("Output: \"" + result + "\"");
            System.out.println();
        }
        
        System.out.println("Time: O(n log k), Space: O(k)");
        System.out.println();
    }

    public static String reorganizeString(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));
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
     * 7. Task Scheduler (Medium)
     * Use a max-heap for task frequencies
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateTaskScheduler() {
        System.out.println("7. Task Scheduler (Medium):");
        System.out.println("===========================");
        
        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n1 = 2;
        
        System.out.println("Tasks: " + Arrays.toString(tasks1));
        System.out.println("n = " + n1);
        
        int minTime1 = leastInterval(tasks1, n1);
        System.out.println("Minimum time: " + minTime1);
        
        char[] tasks2 = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n2 = 2;
        
        System.out.println("\nTasks: " + Arrays.toString(tasks2));
        System.out.println("n = " + n2);
        
        int minTime2 = leastInterval(tasks2, n2);
        System.out.println("Minimum time: " + minTime2);
        
        System.out.println("Time: O(n), Space: O(1)");
        System.out.println();
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        
        Arrays.sort(frequencies);
        int maxFreq = frequencies[25];
        int idleSlots = (maxFreq - 1) * n;
        
        for (int i = 24; i >= 0 && frequencies[i] > 0; i--) {
            idleSlots -= Math.min(maxFreq - 1, frequencies[i]);
        }
        
        return Math.max(tasks.length, tasks.length + idleSlots);
    }

    /**
     * 8. K Closest Points to Origin (Medium)
     * Use a max-heap
     * Time: O(n log k), Space: O(k)
     */
    public static void demonstrateKClosestPointsToOrigin() {
        System.out.println("8. K Closest Points to Origin (Medium):");
        System.out.println("=======================================");
        
        int[][] points1 = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int k1 = 3;
        
        System.out.println("Points: " + Arrays.deepToString(points1));
        System.out.println("K = " + k1);
        
        int[][] result1 = kClosest(points1, k1);
        System.out.println("K closest points: " + Arrays.deepToString(result1));
        
        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int k2 = 2;
        
        System.out.println("\nPoints: " + Arrays.deepToString(points2));
        System.out.println("K = " + k2);
        
        int[][] result2 = kClosest(points2, k2);
        System.out.println("K closest points: " + Arrays.deepToString(result2));
        
        System.out.println("Time: O(n log k), Space: O(k)");
        System.out.println();
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 
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

    /**
     * 9. Sliding Window Maximum (Hard)
     * Use a deque or heap
     * Time: O(n), Space: O(k)
     */
    public static void demonstrateSlidingWindowMaximum() {
        System.out.println("9. Sliding Window Maximum (Hard):");
        System.out.println("=================================");
        
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        
        System.out.println("Array: " + Arrays.toString(nums1));
        System.out.println("Window size: " + k1);
        
        int[] result1 = maxSlidingWindow(nums1, k1);
        System.out.println("Sliding window maximum: " + Arrays.toString(result1));
        
        int[] nums2 = {1};
        int k2 = 1;
        
        System.out.println("\nArray: " + Arrays.toString(nums2));
        System.out.println("Window size: " + k2);
        
        int[] result2 = maxSlidingWindow(nums2, k2);
        System.out.println("Sliding window maximum: " + Arrays.toString(result2));
        
        System.out.println("Time: O(n), Space: O(k)");
        System.out.println();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        
        for (int i = 0; i < nums.length; i++) {
            // Remove elements outside the window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove elements smaller than current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            // Add to result when window is complete
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }

    /**
     * 10. Ugly Number II (Medium)
     * Use a min-heap
     * Time: O(n log n), Space: O(n)
     */
    public static void demonstrateUglyNumberII() {
        System.out.println("10. Ugly Number II (Medium):");
        System.out.println("============================");
        
        int n = 10;
        System.out.println("n = " + n);
        
        int nthUgly = nthUglyNumber(n);
        System.out.println("nth ugly number: " + nthUgly);
        
        // Show first 10 ugly numbers
        System.out.println("First 10 ugly numbers:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(nthUglyNumber(i) + " ");
        }
        System.out.println();
        
        System.out.println("Time: O(n log n), Space: O(n)");
        System.out.println();
    }

    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        
        minHeap.offer(1L);
        seen.add(1L);
        
        int[] primes = {2, 3, 5};
        
        for (int i = 0; i < n - 1; i++) {
            long current = minHeap.poll();
            
            for (int prime : primes) {
                long next = current * prime;
                if (!seen.contains(next)) {
                    seen.add(next);
                    minHeap.offer(next);
                }
            }
        }
        
        return minHeap.poll().intValue();
    }

    /**
     * 11. Super Ugly Number (Medium)
     * Use a min-heap
     * Time: O(n log n), Space: O(n)
     */
    public static void demonstrateSuperUglyNumber() {
        System.out.println("11. Super Ugly Number (Medium):");
        System.out.println("===============================");
        
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        
        System.out.println("n = " + n);
        System.out.println("Primes: " + Arrays.toString(primes));
        
        int nthSuperUgly = nthSuperUglyNumber(n, primes);
        System.out.println("nth super ugly number: " + nthSuperUgly);
        
        System.out.println("Time: O(n log n), Space: O(n)");
        System.out.println();
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        
        minHeap.offer(1L);
        seen.add(1L);
        
        for (int i = 0; i < n - 1; i++) {
            long current = minHeap.poll();
            
            for (int prime : primes) {
                long next = current * prime;
                if (!seen.contains(next)) {
                    seen.add(next);
                    minHeap.offer(next);
                }
            }
        }
        
        return minHeap.poll().intValue();
    }

    /**
     * 12. Kth Smallest Element in a Sorted Matrix (Medium)
     * Use a min-heap
     * Time: O(k log n), Space: O(n)
     */
    public static void demonstrateKthSmallestElementInSortedMatrix() {
        System.out.println("12. Kth Smallest Element in a Sorted Matrix (Medium):");
        System.out.println("===================================================");
        
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;
        
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("K = " + k);
        
        int kthSmallest = kthSmallest(matrix, k);
        System.out.println("Kth smallest element: " + kthSmallest);
        
        System.out.println("Time: O(k log n), Space: O(n)");
        System.out.println();
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Add first element of each row to heap
        for (int i = 0; i < matrix.length; i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }
        
        for (int i = 0; i < k - 1; i++) {
            int[] current = minHeap.poll();
            int row = current[1];
            int col = current[2];
            
            if (col + 1 < matrix[row].length) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        
        return minHeap.poll()[0];
    }

    /**
     * 13. Find K Pairs with Smallest Sums (Medium)
     * Use a min-heap
     * Time: O(k log k), Space: O(k)
     */
    public static void demonstrateFindKPairsWithSmallestSums() {
        System.out.println("13. Find K Pairs with Smallest Sums (Medium):");
        System.out.println("============================================");
        
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("k = " + k);
        
        List<List<Integer>> result = kSmallestPairs(nums1, nums2, k);
        System.out.println("K smallest pairs: " + result);
        
        System.out.println("Time: O(k log k), Space: O(k)");
        System.out.println();
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums1.length == 0 || nums2.length == 0) {
            return result;
        }
        
        // Add first element of each pair (nums1[i], nums2[0])
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }
        
        while (k > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int i = current[1];
            int j = current[2];
            
            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;
            
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        
        return result;
    }

    /**
     * 14. Sort Characters By Frequency (Medium)
     * Use a max-heap
     * Time: O(n log k), Space: O(n)
     */
    public static void demonstrateSortCharactersByFrequency() {
        System.out.println("14. Sort Characters By Frequency (Medium):");
        System.out.println("==========================================");
        
        String[] testCases = {"tree", "cccaaa", "Aabb"};
        
        for (String s : testCases) {
            String result = frequencySort(s);
            System.out.println("Input: \"" + s + "\"");
            System.out.println("Output: \"" + result + "\"");
            System.out.println();
        }
        
        System.out.println("Time: O(n log k), Space: O(n)");
        System.out.println();
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> 
            frequency.get(b) - frequency.get(a));
        maxHeap.addAll(frequency.keySet());
        
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int count = frequency.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }
        
        return result.toString();
    }

    /**
     * 15. Maximum Performance of a Team (Hard)
     * Use a min-heap with sorting
     * Time: O(n log n), Space: O(k)
     */
    public static void demonstrateMaximumPerformanceOfATeam() {
        System.out.println("15. Maximum Performance of a Team (Hard):");
        System.out.println("========================================");
        
        int n = 6;
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 2;
        
        System.out.println("n = " + n);
        System.out.println("speed: " + Arrays.toString(speed));
        System.out.println("efficiency: " + Arrays.toString(efficiency));
        System.out.println("k = " + k);
        
        int maxPerformance = maxPerformance(n, speed, efficiency, k);
        System.out.println("Maximum performance: " + maxPerformance);
        
        System.out.println("Time: O(n log n), Space: O(k)");
        System.out.println();
    }

    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i] = new int[]{efficiency[i], speed[i]};
        }
        
        // Sort by efficiency in descending order
        Arrays.sort(engineers, (a, b) -> Integer.compare(b[0], a[0]));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long speedSum = 0;
        long maxPerf = 0;
        
        for (int[] engineer : engineers) {
            int eff = engineer[0];
            int spd = engineer[1];
            
            minHeap.offer(spd);
            speedSum += spd;
            
            if (minHeap.size() > k) {
                speedSum -= minHeap.poll();
            }
            
            maxPerf = Math.max(maxPerf, speedSum * eff);
        }
        
        return (int) (maxPerf % 1000000007);
    }

    // Utility methods

    private static ListNode createList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        
        return head;
    }

    private static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
}
