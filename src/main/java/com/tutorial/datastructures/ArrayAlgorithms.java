package com.tutorial.datastructures;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Array Algorithms - Comprehensive Guide to Array Operations in Java
 * 
 * This comprehensive tutorial demonstrates essential array algorithms including
 * searching, sorting, and advanced array manipulation techniques. Arrays are
 * fundamental data structures that form the basis for many other data structures
 * and algorithms.
 * 
 * LEARNING OBJECTIVES:
 * - Master linear and binary search algorithms
 * - Understand various sorting algorithms and their complexities
 * - Learn advanced array algorithms like Kadane's and sliding window
 * - Practice two-pointer techniques for array problems
 * - Implement prefix sum for range queries
 * - Understand time and space complexity analysis
 * 
 * KEY CONCEPTS:
 * 1. Linear Search: O(n) time complexity, works on unsorted arrays
 * 2. Binary Search: O(log n) time complexity, requires sorted arrays
 * 3. Sorting Algorithms: Bubble, Insertion, Selection, Merge, Quick, Heap
 * 4. Two Pointers: Efficient technique for array problems
 * 5. Sliding Window: Optimized approach for subarray problems
 * 6. Prefix Sum: Preprocessing for range sum queries
 * 7. Kadane's Algorithm: Maximum subarray sum in O(n)
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class ArrayAlgorithms {
    
    public static void main(String[] args) {
        System.out.println("=== Array Algorithms Demo ===");
        System.out.println();
        
        // 1. Searching Algorithms
        demonstrateSearchingAlgorithms();
        
        // 2. Sorting Algorithms
        demonstrateSortingAlgorithms();
        
        // 3. Two Pointers Technique
        demonstrateTwoPointers();
        
        // 4. Sliding Window Technique
        demonstrateSlidingWindow();
        
        // 5. Prefix Sum
        demonstratePrefixSum();
        
        // 6. Kadane's Algorithm
        demonstrateKadanesAlgorithm();
        
        // 7. Advanced Array Problems
        demonstrateAdvancedProblems();
        
        // 8. Performance Analysis
        demonstratePerformanceAnalysis();
    }
    
    /**
     * Demonstrates searching algorithms
     */
    private static void demonstrateSearchingAlgorithms() {
        System.out.println("1. Searching Algorithms:");
        System.out.println("=======================");
        
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 67, 78, 89};
        int target = 23;
        
        // Linear Search
        System.out.println("Linear Search:");
        int linearResult = linearSearch(arr, target);
        System.out.println("  Target " + target + " found at index: " + linearResult);
        System.out.println("  Time Complexity: O(n), Space Complexity: O(1)");
        
        // Binary Search
        System.out.println("\nBinary Search:");
        int binaryResult = binarySearch(arr, target);
        System.out.println("  Target " + target + " found at index: " + binaryResult);
        System.out.println("  Time Complexity: O(log n), Space Complexity: O(1)");
        
        // Ternary Search
        System.out.println("\nTernary Search:");
        int ternaryResult = ternarySearch(arr, target);
        System.out.println("  Target " + target + " found at index: " + ternaryResult);
        System.out.println("  Time Complexity: O(log₃ n), Space Complexity: O(1)");
        
        System.out.println();
    }
    
    /**
     * Demonstrates sorting algorithms
     */
    private static void demonstrateSortingAlgorithms() {
        System.out.println("2. Sorting Algorithms:");
        System.out.println("=====================");
        
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        // Bubble Sort
        int[] bubbleArr = arr.clone();
        bubbleSort(bubbleArr);
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleArr));
        System.out.println("  Time Complexity: O(n²), Space Complexity: O(1)");
        
        // Insertion Sort
        int[] insertionArr = arr.clone();
        insertionSort(insertionArr);
        System.out.println("Insertion Sort: " + Arrays.toString(insertionArr));
        System.out.println("  Time Complexity: O(n²), Space Complexity: O(1)");
        
        // Selection Sort
        int[] selectionArr = arr.clone();
        selectionSort(selectionArr);
        System.out.println("Selection Sort: " + Arrays.toString(selectionArr));
        System.out.println("  Time Complexity: O(n²), Space Complexity: O(1)");
        
        // Merge Sort
        int[] mergeArr = arr.clone();
        mergeSort(mergeArr, 0, mergeArr.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(mergeArr));
        System.out.println("  Time Complexity: O(n log n), Space Complexity: O(n)");
        
        // Quick Sort
        int[] quickArr = arr.clone();
        quickSort(quickArr, 0, quickArr.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(quickArr));
        System.out.println("  Time Complexity: O(n log n) avg, O(n²) worst, Space: O(log n)");
        
        // Heap Sort
        int[] heapArr = arr.clone();
        heapSort(heapArr);
        System.out.println("Heap Sort: " + Arrays.toString(heapArr));
        System.out.println("  Time Complexity: O(n log n), Space Complexity: O(1)");
        
        // Counting Sort
        int[] countingArr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(countingArr);
        System.out.println("Counting Sort: " + Arrays.toString(countingArr));
        System.out.println("  Time Complexity: O(n + k), Space Complexity: O(k)");
        
        // Radix Sort
        int[] radixArr = {170, 45, 75, 90, 2, 802, 24, 66};
        radixSort(radixArr);
        System.out.println("Radix Sort: " + Arrays.toString(radixArr));
        System.out.println("  Time Complexity: O(d(n + k)), Space Complexity: O(n + k)");
        
        System.out.println();
    }
    
    /**
     * Demonstrates two pointers technique
     */
    private static void demonstrateTwoPointers() {
        System.out.println("3. Two Pointers Technique:");
        System.out.println("=========================");
        
        // Pair Sum Problem
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] pairSum = twoSum(arr, target);
        System.out.println("Two Sum Problem:");
        System.out.println("  Array: " + Arrays.toString(arr) + ", Target: " + target);
        System.out.println("  Indices: " + Arrays.toString(pairSum));
        
        // Move Zeros
        int[] zerosArr = {0, 1, 0, 3, 12};
        moveZeros(zerosArr);
        System.out.println("\nMove Zeros:");
        System.out.println("  Result: " + Arrays.toString(zerosArr));
        
        // Remove Duplicates
        int[] duplicatesArr = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = removeDuplicates(duplicatesArr);
        System.out.println("\nRemove Duplicates:");
        System.out.println("  New length: " + newLength);
        System.out.println("  Array: " + Arrays.toString(java.util.Arrays.copyOf(duplicatesArr, newLength)));
        
        // Valid Palindrome
        String palindrome = "A man a plan a canal Panama";
        boolean isValid = isPalindrome(palindrome);
        System.out.println("\nValid Palindrome:");
        System.out.println("  String: \"" + palindrome + "\"");
        System.out.println("  Is valid: " + isValid);
        
        System.out.println();
    }
    
    /**
     * Demonstrates sliding window technique
     */
    private static void demonstrateSlidingWindow() {
        System.out.println("4. Sliding Window Technique:");
        System.out.println("===========================");
        
        // Maximum Sum Subarray of Size K
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        int maxSum = maxSumSubarray(arr, k);
        System.out.println("Maximum Sum Subarray of Size " + k + ":");
        System.out.println("  Array: " + Arrays.toString(arr));
        System.out.println("  Maximum sum: " + maxSum);
        
        // Longest Substring Without Repeating Characters
        String str = "abcabcbb";
        int longestLength = lengthOfLongestSubstring(str);
        System.out.println("\nLongest Substring Without Repeating Characters:");
        System.out.println("  String: \"" + str + "\"");
        System.out.println("  Longest length: " + longestLength);
        
        // Minimum Window Substring
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minWindow = minWindow(s, t);
        System.out.println("\nMinimum Window Substring:");
        System.out.println("  String: \"" + s + "\", Pattern: \"" + t + "\"");
        System.out.println("  Minimum window: \"" + minWindow + "\"");
        
        System.out.println();
    }
    
    /**
     * Demonstrates prefix sum technique
     */
    private static void demonstratePrefixSum() {
        System.out.println("5. Prefix Sum:");
        System.out.println("=============");
        
        int[] arr = {1, 2, 3, 4, 5};
        int[] prefixSum = calculatePrefixSum(arr);
        
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Prefix sum: " + Arrays.toString(prefixSum));
        
        // Range Sum Query
        int left = 1, right = 3;
        int rangeSum = rangeSum(prefixSum, left, right);
        System.out.println("\nRange Sum Query:");
        System.out.println("  Range [" + left + ", " + right + "]: " + rangeSum);
        
        // Subarray Sum Equals K
        int[] sumArr = {1, 1, 1};
        int k = 2;
        int count = subarraySum(sumArr, k);
        System.out.println("\nSubarray Sum Equals K:");
        System.out.println("  Array: " + Arrays.toString(sumArr) + ", K: " + k);
        System.out.println("  Count: " + count);
        
        System.out.println();
    }
    
    /**
     * Demonstrates Kadane's Algorithm
     */
    private static void demonstrateKadanesAlgorithm() {
        System.out.println("6. Kadane's Algorithm:");
        System.out.println("=====================");
        
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = kadanesAlgorithm(arr);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Maximum subarray sum: " + maxSum);
        System.out.println("Time Complexity: O(n), Space Complexity: O(1)");
        
        // Maximum Product Subarray
        int[] productArr = {2, 3, -2, 4};
        int maxProduct = maxProductSubarray(productArr);
        System.out.println("\nMaximum Product Subarray:");
        System.out.println("  Array: " + Arrays.toString(productArr));
        System.out.println("  Maximum product: " + maxProduct);
        
        System.out.println();
    }
    
    /**
     * Demonstrates advanced array problems
     */
    private static void demonstrateAdvancedProblems() {
        System.out.println("7. Advanced Array Problems:");
        System.out.println("==========================");
        
        // Container With Most Water
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
        System.out.println("Container With Most Water:");
        System.out.println("  Heights: " + Arrays.toString(height));
        System.out.println("  Maximum area: " + maxArea);
        
        // Trapping Rain Water
        int[] trapHeight = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trappedWater = trap(trapHeight);
        System.out.println("\nTrapping Rain Water:");
        System.out.println("  Heights: " + Arrays.toString(trapHeight));
        System.out.println("  Trapped water: " + trappedWater);
        
        // Product of Array Except Self
        int[] productArr = {1, 2, 3, 4};
        int[] result = productExceptSelf(productArr);
        System.out.println("\nProduct of Array Except Self:");
        System.out.println("  Array: " + Arrays.toString(productArr));
        System.out.println("  Result: " + Arrays.toString(result));
        
        // Rotate Array
        int[] rotateArr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(rotateArr, k);
        System.out.println("\nRotate Array:");
        System.out.println("  Original: [1, 2, 3, 4, 5, 6, 7], k = " + k);
        System.out.println("  Rotated: " + Arrays.toString(rotateArr));
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance analysis
     */
    private static void demonstratePerformanceAnalysis() {
        System.out.println("8. Performance Analysis:");
        System.out.println("=======================");
        
        System.out.println("Algorithm Complexity Summary:");
        System.out.println("---------------------------");
        System.out.println("Searching:");
        System.out.println("  Linear Search:    O(n) time, O(1) space");
        System.out.println("  Binary Search:    O(log n) time, O(1) space");
        System.out.println("  Ternary Search:   O(log₃ n) time, O(1) space");
        
        System.out.println("\nSorting:");
        System.out.println("  Bubble Sort:      O(n²) time, O(1) space");
        System.out.println("  Insertion Sort:   O(n²) time, O(1) space");
        System.out.println("  Selection Sort:   O(n²) time, O(1) space");
        System.out.println("  Merge Sort:       O(n log n) time, O(n) space");
        System.out.println("  Quick Sort:       O(n log n) avg, O(n²) worst, O(log n) space");
        System.out.println("  Heap Sort:        O(n log n) time, O(1) space");
        System.out.println("  Counting Sort:    O(n + k) time, O(k) space");
        System.out.println("  Radix Sort:       O(d(n + k)) time, O(n + k) space");
        
        System.out.println("\nAdvanced Algorithms:");
        System.out.println("  Two Pointers:     O(n) time, O(1) space");
        System.out.println("  Sliding Window:   O(n) time, O(1) space");
        System.out.println("  Prefix Sum:       O(n) preprocessing, O(1) query");
        System.out.println("  Kadane's:         O(n) time, O(1) space");
        
        System.out.println();
    }
    
    // Searching Algorithms Implementation
    
    /**
     * Linear Search Algorithm
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Binary Search Algorithm
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    /**
     * Ternary Search Algorithm
     * Time Complexity: O(log₃ n), Space Complexity: O(1)
     */
    public static int ternarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;
            
            if (arr[mid1] == target) {
                return mid1;
            }
            if (arr[mid2] == target) {
                return mid2;
            }
            
            if (target < arr[mid1]) {
                right = mid1 - 1;
            } else if (target > arr[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        
        return -1;
    }
    
    // Sorting Algorithms Implementation
    
    /**
     * Bubble Sort Algorithm
     * Time Complexity: O(n²), Space Complexity: O(1)
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: array is sorted
        }
    }
    
    /**
     * Insertion Sort Algorithm
     * Time Complexity: O(n²), Space Complexity: O(1)
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    /**
     * Selection Sort Algorithm
     * Time Complexity: O(n²), Space Complexity: O(1)
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }
    
    /**
     * Merge Sort Algorithm
     * Time Complexity: O(n log n), Space Complexity: O(n)
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    /**
     * Quick Sort Algorithm
     * Time Complexity: O(n log n) average, O(n²) worst, Space Complexity: O(log n)
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    /**
     * Heap Sort Algorithm
     * Time Complexity: O(n log n), Space Complexity: O(1)
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
    
    private static void heapify(int[] arr, int n, int i) {
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
            heapify(arr, n, largest);
        }
    }
    
    /**
     * Counting Sort Algorithm
     * Time Complexity: O(n + k), Space Complexity: O(k)
     */
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        int min = Arrays.stream(arr).min().orElse(0);
        int range = max - min + 1;
        
        int[] count = new int[range];
        int[] output = new int[arr.length];
        
        // Store count of each element
        for (int value : arr) {
            count[value - min]++;
        }
        
        // Change count[i] so that count[i] now contains actual position
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        
        // Build the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        
        // Copy the output array to arr
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
    
    /**
     * Radix Sort Algorithm
     * Time Complexity: O(d(n + k)), Space Complexity: O(n + k)
     */
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }
    
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        
        for (int value : arr) {
            count[(value / exp) % 10]++;
        }
        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        System.arraycopy(output, 0, arr, 0, n);
    }
    
    // Two Pointers Implementation
    
    /**
     * Two Sum Problem
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int[] twoSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{-1, -1};
    }
    
    /**
     * Move Zeros to End
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static void moveZeros(int[] arr) {
        int nonZeroIndex = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[nonZeroIndex++] = arr[i];
            }
        }
        
        while (nonZeroIndex < arr.length) {
            arr[nonZeroIndex++] = 0;
        }
    }
    
    /**
     * Remove Duplicates from Sorted Array
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        
        return i + 1;
    }
    
    /**
     * Valid Palindrome
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    // Sliding Window Implementation
    
    /**
     * Maximum Sum Subarray of Size K
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int maxSumSubarray(int[] arr, int k) {
        int maxSum = 0;
        int windowSum = 0;
        
        // Calculate sum of first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        
        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
    
    /**
     * Longest Substring Without Repeating Characters
     * Time Complexity: O(n), Space Complexity: O(min(m, n))
     */
    public static int lengthOfLongestSubstring(String s) {
        java.util.Set<Character> set = new java.util.HashSet<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    /**
     * Minimum Window Substring
     * Time Complexity: O(|s| + |t|), Space Complexity: O(|s| + |t|)
     */
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        java.util.Map<Character, Integer> map = new java.util.HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int count = map.size();
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) count--;
            }
            right++;
            
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }
                
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) count++;
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
    
    // Prefix Sum Implementation
    
    /**
     * Calculate Prefix Sum
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int[] calculatePrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        
        return prefixSum;
    }
    
    /**
     * Range Sum Query
     * Time Complexity: O(1), Space Complexity: O(1)
     */
    public static int rangeSum(int[] prefixSum, int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];
    }
    
    /**
     * Subarray Sum Equals K
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int subarraySum(int[] arr, int k) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        map.put(0, 1);
        
        int count = 0;
        int sum = 0;
        
        for (int num : arr) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
    
    // Kadane's Algorithm Implementation
    
    /**
     * Kadane's Algorithm - Maximum Subarray Sum
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int kadanesAlgorithm(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
    
    /**
     * Maximum Product Subarray
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int maxProductSubarray(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        int minEndingHere = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            int temp = maxEndingHere;
            maxEndingHere = Math.max(arr[i], Math.max(maxEndingHere * arr[i], minEndingHere * arr[i]));
            minEndingHere = Math.min(arr[i], Math.min(temp * arr[i], minEndingHere * arr[i]));
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
    
    // Advanced Problems Implementation
    
    /**
     * Container With Most Water
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
    
    /**
     * Trapping Rain Water
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        
        return water;
    }
    
    /**
     * Product of Array Except Self
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        
        // Calculate left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }
        
        // Calculate right products and multiply
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= arr[i];
        }
        
        return result;
    }
    
    /**
     * Rotate Array
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static void rotate(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }
    
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    
    // Utility Methods
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
