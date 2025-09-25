package HashTables;

import java.util.*;

/**
 * Hash Table Problems - Comprehensive Solutions
 * 
 * This class contains solutions to fundamental hash table problems including:
 * - Two Sum variations
 * - Anagram problems
 * - Consecutive sequences
 * - Character frequency analysis
 * - Subarray problems
 * - Palindrome problems
 * - Cache implementations
 * 
 * Each problem includes detailed comments on approach, time and space complexity.
 */
public class HashTableProblems {

    // ==================== BASIC HASH TABLE PROBLEMS ====================

    /**
     * Problem: Two Sum
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * 
     * Approach: Use HashMap to store complement of each number
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        
        return new int[0]; // No solution found
    }

    /**
     * Problem: Two Sum II - Input array is sorted
     * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order.
     */
    public int[] twoSumSorted(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-indexed
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[0];
    }

    /**
     * Problem: Two Sum III - Data structure design
     * Design and implement a TwoSum class that supports add and find operations.
     */
    static class TwoSum {
        private Map<Integer, Integer> map;
        
        public TwoSum() {
            map = new HashMap<>();
        }
        
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        
        public boolean find(int value) {
            for (int num : map.keySet()) {
                int complement = value - num;
                if (map.containsKey(complement)) {
                    if (complement != num || map.get(complement) > 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /**
     * Problem: Group Anagrams
     * Given an array of strings strs, group the anagrams together.
     * 
     * Approach: Use sorted string as key to group anagrams
     * Time Complexity: O(n * k log k) where k is max string length
     * Space Complexity: O(n * k)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(map.values());
    }

    /**
     * Problem: Valid Anagram
     * Given two strings s and t, return true if t is an anagram of s.
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        
        // Count characters in s
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Subtract characters from t
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
        }
        
        return map.isEmpty();
    }

    /**
     * Problem: Longest Consecutive Sequence
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     * 
     * Approach: Use HashSet for O(1) lookup, find sequence starts
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int maxLength = 0;
        
        for (int num : set) {
            // Only start counting from sequence start
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        
        return maxLength;
    }

    /**
     * Problem: Contains Duplicate
     * Given an integer array nums, return true if any value appears at least twice in the array.
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Problem: First Unique Character in a String
     * Given a string s, find the first non-repeating character in it and return its index.
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        // Count character frequencies
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Find first unique character
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        
        return -1;
    }

    /**
     * Problem: Intersection of Two Arrays
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Problem: Subarray Sum Equals K
     * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
     * 
     * Approach: Use prefix sum with HashMap
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Empty subarray
        
        int count = 0;
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }

    /**
     * Problem: Longest Substring Without Repeating Characters
     * Given a string s, find the length of the longest substring without repeating characters.
     * 
     * Approach: Sliding window with HashMap
     * Time Complexity: O(n)
     * Space Complexity: O(min(m,n)) where m is charset size
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            
            map.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    /**
     * Problem: Minimum Window Substring
     * Given two strings s and t, return the minimum window substring of s such that every character in t is included in the window.
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        
        // Count characters needed
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        int valid = 0; // Number of valid characters in window
        int start = 0, len = Integer.MAX_VALUE;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                
                char d = s.charAt(left);
                left++;
                
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    /**
     * Problem: Longest Palindrome
     * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome.
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int length = 0;
        boolean hasOdd = false;
        
        for (int count : map.values()) {
            length += (count / 2) * 2;
            if (count % 2 == 1) {
                hasOdd = true;
            }
        }
        
        return hasOdd ? length + 1 : length;
    }

    /**
     * Problem: Isomorphic Strings
     * Given two strings s and t, determine if they are isomorphic.
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) return false;
            } else {
                if (used.contains(c2)) return false;
                map.put(c1, c2);
                used.add(c2);
            }
        }
        
        return true;
    }

    /**
     * Problem: Word Pattern
     * Given a pattern and a string s, find if s follows the same pattern.
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        
        Map<Character, String> map = new HashMap<>();
        Set<String> used = new HashSet<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) return false;
            } else {
                if (used.contains(word)) return false;
                map.put(c, word);
                used.add(word);
            }
        }
        
        return true;
    }

    /**
     * Problem: LRU Cache Implementation
     * Design and implement a data structure for Least Recently Used (LRU) cache.
     */
    static class LRUCache {
        private Map<Integer, Node> cache;
        private Node head, tail;
        private int capacity;
        
        class Node {
            int key, value;
            Node prev, next;
            
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            
            // Create dummy head and tail
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        
        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) return -1;
            
            // Move to head
            moveToHead(node);
            return node.value;
        }
        
        public void put(int key, int value) {
            Node node = cache.get(key);
            
            if (node != null) {
                node.value = value;
                moveToHead(node);
            } else {
                Node newNode = new Node(key, value);
                
                if (cache.size() >= capacity) {
                    Node tail = popTail();
                    cache.remove(tail.key);
                }
                
                cache.put(key, newNode);
                addNode(newNode);
            }
        }
        
        private void addNode(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
        
        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        private void moveToHead(Node node) {
            removeNode(node);
            addNode(node);
        }
        
        private Node popTail() {
            Node lastNode = tail.prev;
            removeNode(lastNode);
            return lastNode;
        }
    }

    /**
     * Problem: Design HashSet
     * Design a HashSet without using any built-in hash table libraries.
     */
    static class MyHashSet {
        private boolean[] set;
        
        public MyHashSet() {
            set = new boolean[1000001]; // Given constraint: 0 <= key <= 10^6
        }
        
        public void add(int key) {
            set[key] = true;
        }
        
        public void remove(int key) {
            set[key] = false;
        }
        
        public boolean contains(int key) {
            return set[key];
        }
    }

    /**
     * Problem: Design HashMap
     * Design a HashMap without using any built-in hash table libraries.
     */
    static class MyHashMap {
        private Integer[] map;
        
        public MyHashMap() {
            map = new Integer[1000001];
        }
        
        public void put(int key, int value) {
            map[key] = value;
        }
        
        public int get(int key) {
            return map[key] != null ? map[key] : -1;
        }
        
        public void remove(int key) {
            map[key] = null;
        }
    }

    // ==================== DEMONSTRATION METHODS ====================

    /**
     * Demonstrate all hash table problems
     */
    public static void demonstrateAllProblems() {
        System.out.println("=== Hash Table Problems Demonstration ===\n");
        
        HashTableProblems problems = new HashTableProblems();
        
        // Two Sum
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = problems.twoSum(nums, target);
        System.out.println("Two Sum: " + Arrays.toString(result));
        
        // Group Anagrams
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> anagrams = problems.groupAnagrams(strs);
        System.out.println("Group Anagrams: " + anagrams);
        
        // Longest Consecutive Sequence
        int[] sequence = {100, 4, 200, 1, 3, 2};
        int length = problems.longestConsecutive(sequence);
        System.out.println("Longest Consecutive: " + length);
        
        // Subarray Sum Equals K
        int[] subarray = {1, 1, 1};
        int k = 2;
        int count = problems.subarraySum(subarray, k);
        System.out.println("Subarray Sum Equals K: " + count);
        
        // Longest Substring Without Repeating Characters
        String s = "abcabcbb";
        int maxLen = problems.lengthOfLongestSubstring(s);
        System.out.println("Longest Substring: " + maxLen);
        
        System.out.println("\n=== Hash Table Problems Completed ===");
    }

    public static void main(String[] args) {
        demonstrateAllProblems();
    }
}
