package com.tutorial.datastructures;

import java.util.*;

/**
 * Arrays & Strings Foundation Problems - Comprehensive Solutions
 * 
 * This comprehensive implementation covers all essential array and string problems
 * commonly asked in technical interviews. Each solution includes detailed explanations,
 * time/space complexity analysis, and multiple approaches where applicable.
 * 
 * PROBLEMS COVERED:
 * 1. Two Sum (Easy) - Find two numbers that add up to a target
 * 2. Best Time to Buy and Sell Stock (Easy) - Maximum profit from one transaction
 * 3. Contains Duplicate (Easy) - Check if array contains duplicates
 * 4. Product of Array Except Self (Medium) - Calculate product without using division
 * 5. Maximum Subarray (Easy) - Find contiguous subarray with largest sum (Kadane's)
 * 6. Maximum Product Subarray (Medium) - Similar to above, but for product
 * 7. Find Minimum in Rotated Sorted Array (Medium) - Search in a rotated array
 * 8. Search in Rotated Sorted Array (Medium) - Search for target in rotated array
 * 9. 3Sum (Medium) - Find all triplets that add up to zero
 * 10. Container With Most Water (Medium) - Maximize area between two lines
 * 11. Longest Substring Without Repeating Characters (Medium) - Sliding Window classic
 * 12. Longest Palindromic Substring (Medium) - Find longest palindrome in string
 * 13. Valid Parentheses (Easy) - Check if brackets are balanced using stack
 * 14. Valid Anagram (Easy) - Check if two strings are anagrams
 * 15. Group Anagrams (Medium) - Group strings that are anagrams together
 * 16. Longest Consecutive Sequence (Medium) - Find longest sequence in unsorted array
 * 17. Trapping Rain Water (Hard) - Calculate how much water can be trapped
 * 18. Merge Intervals (Medium) - Merge overlapping intervals
 * 19. Insert Interval (Medium) - Insert new interval into sorted intervals
 * 20. Spiral Matrix (Medium) - Traverse matrix in spiral order
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class ArraysStringsFoundation {

    public static void main(String[] args) {
        System.out.println("=== Arrays & Strings Foundation Problems ===");
        System.out.println();
        
        // Run all problem demonstrations
        demonstrateTwoSum();
        demonstrateBestTimeToBuyStock();
        demonstrateContainsDuplicate();
        demonstrateProductExceptSelf();
        demonstrateMaximumSubarray();
        demonstrateMaximumProductSubarray();
        demonstrateFindMinimumInRotatedArray();
        demonstrateSearchInRotatedArray();
        demonstrateThreeSum();
        demonstrateContainerWithMostWater();
        demonstrateLongestSubstringWithoutRepeating();
        demonstrateLongestPalindromicSubstring();
        demonstrateValidParentheses();
        demonstrateValidAnagram();
        demonstrateGroupAnagrams();
        demonstrateLongestConsecutiveSequence();
        demonstrateTrappingRainWater();
        demonstrateMergeIntervals();
        demonstrateInsertInterval();
        demonstrateSpiralMatrix();
    }

    // ==================== ARRAY PROBLEMS ====================

    /**
     * 1. Two Sum (Easy)
     * Find two numbers that add up to a target
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateTwoSum() {
        System.out.println("1. Two Sum (Easy):");
        System.out.println("==================");
        
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        System.out.println("Input: nums = " + Arrays.toString(nums) + ", target = " + target);
        
        // Approach 1: Hash Map (Recommended)
        int[] result1 = twoSumHashMap(nums, target);
        System.out.println("HashMap Approach: " + Arrays.toString(result1));
        
        // Approach 2: Two Pointers (requires sorted array)
        int[] numsSorted = nums.clone();
        Arrays.sort(numsSorted);
        int[] result2 = twoSumTwoPointers(numsSorted, target);
        System.out.println("Two Pointers Approach: " + Arrays.toString(result2));
        
        System.out.println("Time Complexity: O(n), Space Complexity: O(n)");
        System.out.println();
    }

    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1};
    }

    public static int[] twoSumTwoPointers(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
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
     * 2. Best Time to Buy and Sell Stock (Easy)
     * Maximum profit from one transaction
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateBestTimeToBuyStock() {
        System.out.println("2. Best Time to Buy and Sell Stock (Easy):");
        System.out.println("=========================================");
        
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Input: prices = " + Arrays.toString(prices));
        
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
        System.out.println("Time Complexity: O(n), Space Complexity: O(1)");
        System.out.println();
    }

    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        
        return maxProfit;
    }

    /**
     * 3. Contains Duplicate (Easy)
     * Check if array contains duplicates
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateContainsDuplicate() {
        System.out.println("3. Contains Duplicate (Easy):");
        System.out.println("=============================");
        
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Contains Duplicate: " + containsDuplicate(nums1));
        
        System.out.println("Input: nums = " + Arrays.toString(nums2));
        System.out.println("Contains Duplicate: " + containsDuplicate(nums2));
        
        System.out.println("Time Complexity: O(n), Space Complexity: O(n)");
        System.out.println();
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        
        return false;
    }

    /**
     * 4. Product of Array Except Self (Medium)
     * Calculate product without using division
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateProductExceptSelf() {
        System.out.println("4. Product of Array Except Self (Medium):");
        System.out.println("=========================================");
        
        int[] nums = {1, 2, 3, 4};
        System.out.println("Input: nums = " + Arrays.toString(nums));
        
        int[] result = productExceptSelf(nums);
        System.out.println("Output: " + Arrays.toString(result));
        
        System.out.println("Time Complexity: O(n), Space Complexity: O(1)");
        System.out.println();
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Calculate right products and multiply
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }

    /**
     * 5. Maximum Subarray (Easy) - Kadane's Algorithm
     * Find contiguous subarray with largest sum
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateMaximumSubarray() {
        System.out.println("5. Maximum Subarray (Easy) - Kadane's Algorithm:");
        System.out.println("===============================================");
        
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: nums = " + Arrays.toString(nums));
        
        int maxSum = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + maxSum);
        
        System.out.println("Time Complexity: O(n), Space Complexity: O(1)");
        System.out.println();
    }

    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }

    /**
     * 6. Maximum Product Subarray (Medium)
     * Similar to Kadane's, but for product
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateMaximumProductSubarray() {
        System.out.println("6. Maximum Product Subarray (Medium):");
        System.out.println("====================================");
        
        int[] nums = {2, 3, -2, 4};
        System.out.println("Input: nums = " + Arrays.toString(nums));
        
        int maxProduct = maxProduct(nums);
        System.out.println("Maximum Product: " + maxProduct);
        
        System.out.println("Time Complexity: O(n), Space Complexity: O(1)");
        System.out.println();
    }

    public static int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int temp = maxEndingHere;
            maxEndingHere = Math.max(nums[i], Math.max(maxEndingHere * nums[i], minEndingHere * nums[i]));
            minEndingHere = Math.min(nums[i], Math.min(temp * nums[i], minEndingHere * nums[i]));
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }

    /**
     * 7. Find Minimum in Rotated Sorted Array (Medium)
     * Search in a rotated array
     * Time: O(log n), Space: O(1)
     */
    public static void demonstrateFindMinimumInRotatedArray() {
        System.out.println("7. Find Minimum in Rotated Sorted Array (Medium):");
        System.out.println("===============================================");
        
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println("Input: nums = " + Arrays.toString(nums));
        
        int min = findMin(nums);
        System.out.println("Minimum Element: " + min);
        
        System.out.println("Time Complexity: O(log n), Space Complexity: O(1)");
        System.out.println();
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return nums[left];
    }

    /**
     * 8. Search in Rotated Sorted Array (Medium)
     * Search for target in rotated array
     * Time: O(log n), Space: O(1)
     */
    public static void demonstrateSearchInRotatedArray() {
        System.out.println("8. Search in Rotated Sorted Array (Medium):");
        System.out.println("==========================================");
        
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        
        System.out.println("Input: nums = " + Arrays.toString(nums) + ", target = " + target);
        
        int index = searchInRotatedArray(nums, target);
        System.out.println("Target Index: " + index);
        
        System.out.println("Time Complexity: O(log n), Space Complexity: O(1)");
        System.out.println();
    }

    public static int searchInRotatedArray(int[] nums, int target) {
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
     * 9. 3Sum (Medium)
     * Find all triplets that add up to zero
     * Time: O(n²), Space: O(1)
     */
    public static void demonstrateThreeSum() {
        System.out.println("9. 3Sum (Medium):");
        System.out.println("=================");
        
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: nums = " + Arrays.toString(nums));
        
        List<List<Integer>> result = threeSum(nums);
        System.out.println("Triplets: " + result);
        
        System.out.println("Time Complexity: O(n²), Space Complexity: O(1)");
        System.out.println();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1, right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }

    /**
     * 10. Container With Most Water (Medium)
     * Maximize area between two lines
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateContainerWithMostWater() {
        System.out.println("10. Container With Most Water (Medium):");
        System.out.println("======================================");
        
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Input: height = " + Arrays.toString(height));
        
        int maxArea = maxArea(height);
        System.out.println("Maximum Area: " + maxArea);
        
        System.out.println("Time Complexity: O(n), Space Complexity: O(1)");
        System.out.println();
    }

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

    // ==================== STRING PROBLEMS ====================

    /**
     * 11. Longest Substring Without Repeating Characters (Medium)
     * Sliding Window classic
     * Time: O(n), Space: O(min(m, n))
     */
    public static void demonstrateLongestSubstringWithoutRepeating() {
        System.out.println("11. Longest Substring Without Repeating Characters (Medium):");
        System.out.println("=========================================================");
        
        String s = "abcabcbb";
        System.out.println("Input: s = \"" + s + "\"");
        
        int length = lengthOfLongestSubstring(s);
        System.out.println("Longest Length: " + length);
        
        System.out.println("Time Complexity: O(n), Space Complexity: O(min(m, n))");
        System.out.println();
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
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
     * 12. Longest Palindromic Substring (Medium)
     * Find longest palindrome in string
     * Time: O(n²), Space: O(1)
     */
    public static void demonstrateLongestPalindromicSubstring() {
        System.out.println("12. Longest Palindromic Substring (Medium):");
        System.out.println("==========================================");
        
        String s = "babad";
        System.out.println("Input: s = \"" + s + "\"");
        
        String longest = longestPalindrome(s);
        System.out.println("Longest Palindrome: \"" + longest + "\"");
        
        System.out.println("Time Complexity: O(n²), Space Complexity: O(1)");
        System.out.println();
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 13. Valid Parentheses (Easy)
     * Check if brackets are balanced using stack
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateValidParentheses() {
        System.out.println("13. Valid Parentheses (Easy):");
        System.out.println("============================");
        
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        
        System.out.println("Input: s = \"" + s1 + "\"");
        System.out.println("Valid: " + isValid(s1));
        
        System.out.println("Input: s = \"" + s2 + "\"");
        System.out.println("Valid: " + isValid(s2));
        
        System.out.println("Input: s = \"" + s3 + "\"");
        System.out.println("Valid: " + isValid(s3));
        
        System.out.println("Time Complexity: O(n), Space Complexity: O(n)");
        System.out.println();
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    /**
     * 14. Valid Anagram (Easy)
     * Check if two strings are anagrams
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateValidAnagram() {
        System.out.println("14. Valid Anagram (Easy):");
        System.out.println("========================");
        
        String s1 = "anagram", t1 = "nagaram";
        String s2 = "rat", t2 = "car";
        
        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("Valid Anagram: " + isAnagram(s1, t1));
        
        System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("Valid Anagram: " + isAnagram(s2, t2));
        
        System.out.println("Time Complexity: O(n), Space Complexity: O(1)");
        System.out.println();
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] count = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        
        for (int c : count) {
            if (c != 0) return false;
        }
        
        return true;
    }

    /**
     * 15. Group Anagrams (Medium)
     * Group strings that are anagrams together
     * Time: O(n * m log m), Space: O(n * m)
     */
    public static void demonstrateGroupAnagrams() {
        System.out.println("15. Group Anagrams (Medium):");
        System.out.println("===========================");
        
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input: strs = " + Arrays.toString(strs));
        
        List<List<String>> result = groupAnagrams(strs);
        System.out.println("Grouped Anagrams: " + result);
        
        System.out.println("Time Complexity: O(n * m log m), Space Complexity: O(n * m)");
        System.out.println();
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(map.values());
    }

    /**
     * 16. Longest Consecutive Sequence (Medium)
     * Find longest sequence in unsorted array
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateLongestConsecutiveSequence() {
        System.out.println("16. Longest Consecutive Sequence (Medium):");
        System.out.println("=========================================");
        
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Input: nums = " + Arrays.toString(nums));
        
        int longest = longestConsecutive(nums);
        System.out.println("Longest Consecutive Sequence: " + longest);
        
        System.out.println("Time Complexity: O(n), Space Complexity: O(n)");
        System.out.println();
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int longest = 0;
        
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                
                longest = Math.max(longest, currentLength);
            }
        }
        
        return longest;
    }

    /**
     * 17. Trapping Rain Water (Hard)
     * Calculate how much water can be trapped
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateTrappingRainWater() {
        System.out.println("17. Trapping Rain Water (Hard):");
        System.out.println("==============================");
        
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Input: height = " + Arrays.toString(height));
        
        int water = trap(height);
        System.out.println("Trapped Water: " + water);
        
        System.out.println("Time Complexity: O(n), Space Complexity: O(1)");
        System.out.println();
    }

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
     * 18. Merge Intervals (Medium)
     * Merge overlapping intervals
     * Time: O(n log n), Space: O(1)
     */
    public static void demonstrateMergeIntervals() {
        System.out.println("18. Merge Intervals (Medium):");
        System.out.println("=============================");
        
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Input: intervals = " + Arrays.deepToString(intervals));
        
        int[][] merged = merge(intervals);
        System.out.println("Merged Intervals: " + Arrays.deepToString(merged));
        
        System.out.println("Time Complexity: O(n log n), Space Complexity: O(1)");
        System.out.println();
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                // Overlapping intervals, merge them
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // No overlap, add current to result and start new interval
                result.add(current);
                current = intervals[i];
            }
        }
        
        result.add(current);
        
        return result.toArray(new int[result.size()][]);
    }

    /**
     * 19. Insert Interval (Medium)
     * Insert new interval into sorted intervals
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateInsertInterval() {
        System.out.println("19. Insert Interval (Medium):");
        System.out.println("============================");
        
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        
        System.out.println("Input: intervals = " + Arrays.deepToString(intervals));
        System.out.println("       newInterval = " + Arrays.toString(newInterval));
        
        int[][] result = insert(intervals, newInterval);
        System.out.println("Result: " + Arrays.deepToString(result));
        
        System.out.println("Time Complexity: O(n), Space Complexity: O(n)");
        System.out.println();
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        
        // Add all intervals that end before new interval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        result.add(newInterval);
        
        // Add remaining intervals
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }

    /**
     * 20. Spiral Matrix (Medium)
     * Traverse matrix in spiral order
     * Time: O(m * n), Space: O(1)
     */
    public static void demonstrateSpiralMatrix() {
        System.out.println("20. Spiral Matrix (Medium):");
        System.out.println("==========================");
        
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        System.out.println("Input: matrix = " + Arrays.deepToString(matrix));
        
        List<Integer> result = spiralOrder(matrix);
        System.out.println("Spiral Order: " + result);
        
        System.out.println("Time Complexity: O(m * n), Space Complexity: O(1)");
        System.out.println();
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            
            // Traverse down
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // Traverse left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            // Traverse up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}
