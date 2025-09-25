package BinarySearch;

import java.util.*;

/**
 * Binary Search Problems - Comprehensive Solutions
 * 
 * This class contains solutions to fundamental binary search problems including:
 * - Basic binary search variations
 * - Search in rotated arrays
 * - Find insertion positions
 * - Search in 2D matrices
 * - Find peak elements
 * - Search in mountain arrays
 * - Find square roots
 * - Search in infinite arrays
 * 
 * Each problem includes detailed comments on approach, time and space complexity.
 */
public class BinarySearchProblems {

    // ==================== BASIC BINARY SEARCH ====================

    /**
     * Problem: Binary Search
     * Given an array of integers nums which is sorted in ascending order, and an integer target.
     * 
     * Approach: Classic binary search
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

    /**
     * Problem: Search Insert Position
     * Given a sorted array of distinct integers and a target value, return the index where the target should be inserted.
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }

    /**
     * Problem: Find First and Last Position of Element in Sorted Array
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     */
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = findLast(nums, target);
        return new int[]{first, last};
    }
    
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int first = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1; // Continue searching left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return first;
    }
    
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int last = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1; // Continue searching right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return last;
    }

    // ==================== ROTATED ARRAY PROBLEMS ====================

    /**
     * Problem: Search in Rotated Sorted Array
     * There is an integer array nums sorted in ascending order (with distinct values).
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k.
     * 
     * Approach: Modified binary search to handle rotation
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int searchRotated(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }

    /**
     * Problem: Find Minimum in Rotated Sorted Array
     * Given the sorted rotated array nums of unique elements, return the minimum element.
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // Minimum is in right half
                left = mid + 1;
            } else {
                // Minimum is in left half (including mid)
                right = mid;
            }
        }
        
        return nums[left];
    }

    /**
     * Problem: Search in Rotated Sorted Array II
     * The array may contain duplicates.
     */
    public boolean searchRotatedWithDuplicates(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            // Handle duplicates
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return false;
    }

    // ==================== 2D MATRIX PROBLEMS ====================

    /**
     * Problem: Search a 2D Matrix
     * Write an efficient algorithm that searches for a value target in an m x n integer matrix.
     * This matrix has the following properties:
     * - Integers in each row are sorted from left to right.
     * - The first integer of each row is greater than the last integer of the previous row.
     * 
     * Approach: Treat 2D matrix as 1D array
     * Time Complexity: O(log(m*n))
     * Space Complexity: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0, right = m * n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];
            
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }

    /**
     * Problem: Search a 2D Matrix II
     * Each row and column is sorted in ascending order.
     * 
     * Approach: Start from top-right corner
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     */
    public boolean searchMatrixII(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int row = 0, col = n - 1;
        
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }
        
        return false;
    }

    // ==================== PEAK AND VALLEY PROBLEMS ====================

    /**
     * Problem: Find Peak Element
     * A peak element is an element that is strictly greater than its neighbors.
     * 
     * Approach: Binary search on the trend
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[mid + 1]) {
                // Peak is in left half (including mid)
                right = mid;
            } else {
                // Peak is in right half
                left = mid + 1;
            }
        }
        
        return left;
    }

    /**
     * Problem: Find in Mountain Array
     * A mountain array is an array that increases to a peak and then decreases.
     */
    public int findInMountainArray(int target, int[] mountainArr) {
        int peak = findPeakIndex(mountainArr);
        
        // Search in ascending part
        int result = binarySearchAscending(mountainArr, target, 0, peak);
        if (result != -1) return result;
        
        // Search in descending part
        return binarySearchDescending(mountainArr, target, peak + 1, mountainArr.length - 1);
    }
    
    private int findPeakIndex(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private int binarySearchAscending(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    
    private int binarySearchDescending(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // ==================== SQUARE ROOT AND POW PROBLEMS ====================

    /**
     * Problem: Sqrt(x)
     * Given a non-negative integer x, compute and return the square root of x.
     * 
     * Approach: Binary search on possible square root values
     * Time Complexity: O(log x)
     * Space Complexity: O(1)
     */
    public int mySqrt(int x) {
        if (x < 2) return x;
        
        int left = 2, right = x / 2;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            
            if (square == x) {
                return mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }

    /**
     * Problem: Pow(x, n)
     * Implement pow(x, n), which calculates x raised to the power n.
     * 
     * Approach: Binary exponentiation
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        
        // Handle negative exponent
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        return powerHelper(x, n);
    }
    
    private double powerHelper(double x, int n) {
        if (n == 0) return 1.0;
        
        double half = powerHelper(x, n / 2);
        
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    // ==================== INFINITE ARRAY PROBLEMS ====================

    /**
     * Problem: Search in Infinite Sorted Array
     * Given an infinite sorted array, find the position of a target element.
     * 
     * Approach: First find bounds, then binary search
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int searchInfinite(int[] arr, int target) {
        // First find the bounds
        int left = 0, right = 1;
        
        while (arr[right] < target) {
            left = right;
            right *= 2;
        }
        
        // Now binary search in the found bounds
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

    // ==================== KTH ELEMENT PROBLEMS ====================

    /**
     * Problem: Kth Missing Positive Number
     * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
     * Find the kth positive integer that is missing from this array.
     */
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Number of missing elements before arr[mid]
            int missing = arr[mid] - mid - 1;
            
            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left + k;
    }

    /**
     * Problem: Kth Smallest Element in a Sorted Matrix
     * Given an n x n matrix where each of the rows and columns is sorted in ascending order,
     * return the kth smallest element in the matrix.
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (countLessOrEqual(matrix, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private int countLessOrEqual(int[][] matrix, int target) {
        int count = 0;
        int n = matrix.length;
        int row = n - 1, col = 0;
        
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        
        return count;
    }

    // ==================== ADVANCED PROBLEMS ====================

    /**
     * Problem: Capacity To Ship Packages Within D Days
     * Given weights of packages and days, find minimum ship capacity.
     */
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canShip(int[] weights, int days, int capacity) {
        int currentWeight = 0;
        int daysUsed = 1;
        
        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                daysUsed++;
                currentWeight = weight;
                if (daysUsed > days) return false;
            } else {
                currentWeight += weight;
            }
        }
        
        return true;
    }

    /**
     * Problem: Split Array Largest Sum
     * Given an array nums and an integer m, split the array into m non-empty continuous subarrays
     * such that the largest sum among these m subarrays is minimized.
     */
    public int splitArray(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canSplit(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canSplit(int[] nums, int m, int maxSum) {
        int currentSum = 0;
        int subarrays = 1;
        
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                subarrays++;
                currentSum = num;
                if (subarrays > m) return false;
            } else {
                currentSum += num;
            }
        }
        
        return true;
    }

    // ==================== DEMONSTRATION METHODS ====================

    /**
     * Demonstrate all binary search problems
     */
    public static void demonstrateAllProblems() {
        System.out.println("=== Binary Search Problems Demonstration ===\n");
        
        BinarySearchProblems bs = new BinarySearchProblems();
        
        // Basic Binary Search
        int[] nums = {1, 3, 5, 7, 9, 11};
        int target = 7;
        int index = bs.binarySearch(nums, target);
        System.out.println("Binary Search for " + target + ": " + index);
        
        // Search Insert Position
        int[] sorted = {1, 3, 5, 6};
        int insertPos = bs.searchInsert(sorted, 5);
        System.out.println("Search Insert Position: " + insertPos);
        
        // Search in Rotated Array
        int[] rotated = {4, 5, 6, 7, 0, 1, 2};
        int rotatedIndex = bs.searchRotated(rotated, 0);
        System.out.println("Search in Rotated Array: " + rotatedIndex);
        
        // Find Minimum in Rotated Array
        int min = bs.findMin(rotated);
        System.out.println("Minimum in Rotated Array: " + min);
        
        // Find Peak Element
        int[] peak = {1, 2, 3, 1};
        int peakIndex = bs.findPeakElement(peak);
        System.out.println("Peak Element Index: " + peakIndex);
        
        // Square Root
        int sqrt = bs.mySqrt(8);
        System.out.println("Square Root of 8: " + sqrt);
        
        System.out.println("\n=== Binary Search Problems Completed ===");
    }

    public static void main(String[] args) {
        demonstrateAllProblems();
    }
}
