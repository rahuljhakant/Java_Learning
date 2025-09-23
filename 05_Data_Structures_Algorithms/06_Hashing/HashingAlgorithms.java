package com.tutorial.datastructures.hashing;

/**
 * Hashing Algorithms - Comprehensive Guide to Hashing in Java
 * 
 * This comprehensive tutorial demonstrates essential hashing algorithms and
 * data structures including HashMap, HashSet, and advanced hashing techniques.
 * Hashing is fundamental for efficient data storage, retrieval, and many
 * algorithmic optimizations.
 * 
 * LEARNING OBJECTIVES:
 * - Master HashMap, HashSet, and TreeMap operations
 * - Understand hash functions and collision handling
 * - Learn frequency counting and element tracking
 * - Practice subarray and two-sum problems
 * - Implement group anagrams and duplicate detection
 * - Understand consistent hashing and load balancing
 * - Master time and space complexity analysis
 * 
 * KEY CONCEPTS:
 * 1. Hash Functions: Converting keys to array indices
 * 2. Collision Handling: Chaining and open addressing
 * 3. Load Factor: Balancing space and time efficiency
 * 4. Frequency Counting: Tracking element occurrences
 * 5. Two Pointers with Hashing: Optimized search techniques
 * 6. Grouping: Organizing data by common characteristics
 * 7. Caching: Using hash tables for fast lookups
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
public class HashingAlgorithms {
    
    public static void main(String[] args) {
        System.out.println("=== Hashing Algorithms Demo ===");
        System.out.println();
        
        // 1. Basic Hashing Operations
        demonstrateBasicHashingOperations();
        
        // 2. Frequency Counting
        demonstrateFrequencyCounting();
        
        // 3. Two Sum Problems
        demonstrateTwoSumProblems();
        
        // 4. Group Anagrams
        demonstrateGroupAnagrams();
        
        // 5. Subarray Problems
        demonstrateSubarrayProblems();
        
        // 6. Duplicate Detection
        demonstrateDuplicateDetection();
        
        // 7. Advanced Hashing Problems
        demonstrateAdvancedProblems();
        
        // 8. Custom Hash Table Implementation
        demonstrateCustomHashTable();
        
        // 9. Performance Analysis
        demonstratePerformanceAnalysis();
    }
    
    /**
     * Demonstrates basic hashing operations
     */
    private static void demonstrateBasicHashingOperations() {
        System.out.println("1. Basic Hashing Operations:");
        System.out.println("===========================");
        
        // HashMap Operations
        System.out.println("HashMap Operations:");
        java.util.HashMap<String, Integer> hashMap = new java.util.HashMap<>();
        hashMap.put("apple", 5);
        hashMap.put("banana", 3);
        hashMap.put("cherry", 8);
        System.out.println("  After putting (apple,5), (banana,3), (cherry,8): " + hashMap);
        System.out.println("  Get apple: " + hashMap.get("apple"));
        System.out.println("  Contains banana: " + hashMap.containsKey("banana"));
        System.out.println("  Size: " + hashMap.size());
        
        // HashSet Operations
        System.out.println("\nHashSet Operations:");
        java.util.HashSet<Integer> hashSet = new java.util.HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(2); // Duplicate
        System.out.println("  After adding 1, 2, 3, 2: " + hashSet);
        System.out.println("  Contains 2: " + hashSet.contains(2));
        System.out.println("  Size: " + hashSet.size());
        
        // TreeMap Operations (Sorted)
        System.out.println("\nTreeMap Operations (Sorted):");
        java.util.TreeMap<String, Integer> treeMap = new java.util.TreeMap<>();
        treeMap.put("zebra", 1);
        treeMap.put("apple", 2);
        treeMap.put("banana", 3);
        System.out.println("  TreeMap (sorted): " + treeMap);
        System.out.println("  First key: " + treeMap.firstKey());
        System.out.println("  Last key: " + treeMap.lastKey());
        
        // LinkedHashMap Operations (Insertion Order)
        System.out.println("\nLinkedHashMap Operations (Insertion Order):");
        java.util.LinkedHashMap<String, Integer> linkedHashMap = new java.util.LinkedHashMap<>();
        linkedHashMap.put("third", 3);
        linkedHashMap.put("first", 1);
        linkedHashMap.put("second", 2);
        System.out.println("  LinkedHashMap (insertion order): " + linkedHashMap);
        
        System.out.println();
    }
    
    /**
     * Demonstrates frequency counting
     */
    private static void demonstrateFrequencyCounting() {
        System.out.println("2. Frequency Counting:");
        System.out.println("=====================");
        
        // Character Frequency
        System.out.println("Character Frequency:");
        String text = "hello world";
        java.util.Map<Character, Integer> charFreq = getCharacterFrequency(text);
        System.out.println("  Text: \"" + text + "\"");
        System.out.println("  Character frequencies: " + charFreq);
        
        // Word Frequency
        System.out.println("\nWord Frequency:");
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        java.util.Map<String, Integer> wordFreq = getWordFrequency(words);
        System.out.println("  Words: " + java.util.Arrays.toString(words));
        System.out.println("  Word frequencies: " + wordFreq);
        
        // Number Frequency
        System.out.println("\nNumber Frequency:");
        int[] numbers = {1, 2, 3, 2, 1, 3, 4, 2, 1};
        java.util.Map<Integer, Integer> numFreq = getNumberFrequency(numbers);
        System.out.println("  Numbers: " + java.util.Arrays.toString(numbers));
        System.out.println("  Number frequencies: " + numFreq);
        
        // Most Frequent Element
        System.out.println("\nMost Frequent Element:");
        int[] arr = {1, 2, 3, 2, 1, 3, 4, 2, 1, 2};
        int mostFrequent = findMostFrequentElement(arr);
        System.out.println("  Array: " + java.util.Arrays.toString(arr));
        System.out.println("  Most frequent element: " + mostFrequent);
        
        // Top K Frequent Elements
        System.out.println("\nTop K Frequent Elements:");
        int[] topKArr = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4};
        int k = 2;
        java.util.List<Integer> topK = topKFrequent(topKArr, k);
        System.out.println("  Array: " + java.util.Arrays.toString(topKArr));
        System.out.println("  Top " + k + " frequent elements: " + topK);
        
        System.out.println();
    }
    
    /**
     * Demonstrates two sum problems
     */
    private static void demonstrateTwoSumProblems() {
        System.out.println("3. Two Sum Problems:");
        System.out.println("===================");
        
        // Two Sum
        System.out.println("Two Sum:");
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] twoSumResult = twoSum(nums, target);
        System.out.println("  Array: " + java.util.Arrays.toString(nums) + ", Target: " + target);
        System.out.println("  Indices: " + java.util.Arrays.toString(twoSumResult));
        
        // Two Sum II (Sorted Array)
        System.out.println("\nTwo Sum II (Sorted Array):");
        int[] sortedNums = {2, 7, 11, 15};
        int[] twoSumSorted = twoSumSorted(sortedNums, target);
        System.out.println("  Sorted Array: " + java.util.Arrays.toString(sortedNums) + ", Target: " + target);
        System.out.println("  Indices: " + java.util.Arrays.toString(twoSumSorted));
        
        // Three Sum
        System.out.println("\nThree Sum:");
        int[] threeSumNums = {-1, 0, 1, 2, -1, -4};
        java.util.List<java.util.List<Integer>> threeSumResult = threeSum(threeSumNums);
        System.out.println("  Array: " + java.util.Arrays.toString(threeSumNums));
        System.out.println("  Three sum triplets: " + threeSumResult);
        
        // Four Sum
        System.out.println("\nFour Sum:");
        int[] fourSumNums = {1, 0, -1, 0, -2, 2};
        int fourSumTarget = 0;
        java.util.List<java.util.List<Integer>> fourSumResult = fourSum(fourSumNums, fourSumTarget);
        System.out.println("  Array: " + java.util.Arrays.toString(fourSumNums) + ", Target: " + fourSumTarget);
        System.out.println("  Four sum quadruplets: " + fourSumResult);
        
        System.out.println();
    }
    
    /**
     * Demonstrates group anagrams
     */
    private static void demonstrateGroupAnagrams() {
        System.out.println("4. Group Anagrams:");
        System.out.println("=================");
        
        // Group Anagrams
        System.out.println("Group Anagrams:");
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        java.util.List<java.util.List<String>> groups = groupAnagrams(words);
        System.out.println("  Words: " + java.util.Arrays.toString(words));
        System.out.println("  Anagram groups: " + groups);
        
        // Valid Anagram
        System.out.println("\nValid Anagram:");
        String[][] pairs = {{"anagram", "nagaram"}, {"rat", "car"}, {"listen", "silent"}};
        for (String[] pair : pairs) {
            boolean isValid = isAnagram(pair[0], pair[1]);
            System.out.println("  \"" + pair[0] + "\" and \"" + pair[1] + "\": " + isValid);
        }
        
        // Find All Anagrams in String
        System.out.println("\nFind All Anagrams in String:");
        String s = "cbaebabacd";
        String p = "abc";
        java.util.List<Integer> anagramIndices = findAnagrams(s, p);
        System.out.println("  String: \"" + s + "\", Pattern: \"" + p + "\"");
        System.out.println("  Anagram indices: " + anagramIndices);
        
        System.out.println();
    }
    
    /**
     * Demonstrates subarray problems
     */
    private static void demonstrateSubarrayProblems() {
        System.out.println("5. Subarray Problems:");
        System.out.println("====================");
        
        // Subarray Sum Equals K
        System.out.println("Subarray Sum Equals K:");
        int[] nums = {1, 1, 1};
        int k = 2;
        int count = subarraySum(nums, k);
        System.out.println("  Array: " + java.util.Arrays.toString(nums) + ", K: " + k);
        System.out.println("  Number of subarrays: " + count);
        
        // Longest Subarray with Sum K
        System.out.println("\nLongest Subarray with Sum K:");
        int[] longNums = {10, 5, 2, 7, 1, 9};
        int longK = 15;
        int maxLength = longestSubarrayWithSumK(longNums, longK);
        System.out.println("  Array: " + java.util.Arrays.toString(longNums) + ", K: " + longK);
        System.out.println("  Maximum length: " + maxLength);
        
        // Subarray with Given Sum
        System.out.println("\nSubarray with Given Sum:");
        int[] sumNums = {1, 4, 20, 3, 10, 5};
        int sumTarget = 33;
        boolean hasSubarray = hasSubarrayWithSum(sumNums, sumTarget);
        System.out.println("  Array: " + java.util.Arrays.toString(sumNums) + ", Sum: " + sumTarget);
        System.out.println("  Has subarray: " + hasSubarray);
        
        // Longest Consecutive Sequence
        System.out.println("\nLongest Consecutive Sequence:");
        int[] seqNums = {100, 4, 200, 1, 3, 2};
        int longestSeq = longestConsecutive(seqNums);
        System.out.println("  Array: " + java.util.Arrays.toString(seqNums));
        System.out.println("  Longest consecutive sequence length: " + longestSeq);
        
        System.out.println();
    }
    
    /**
     * Demonstrates duplicate detection
     */
    private static void demonstrateDuplicateDetection() {
        System.out.println("6. Duplicate Detection:");
        System.out.println("=====================");
        
        // Contains Duplicate
        System.out.println("Contains Duplicate:");
        int[][] testArrays = {{1, 2, 3, 1}, {1, 2, 3, 4}, {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}};
        for (int[] arr : testArrays) {
            boolean hasDuplicate = containsDuplicate(arr);
            System.out.println("  " + java.util.Arrays.toString(arr) + " -> " + hasDuplicate);
        }
        
        // Contains Duplicate II (within k distance)
        System.out.println("\nContains Duplicate II (within k distance):");
        int[] dupNums = {1, 2, 3, 1};
        int k = 3;
        boolean hasNearbyDuplicate = containsNearbyDuplicate(dupNums, k);
        System.out.println("  Array: " + java.util.Arrays.toString(dupNums) + ", k: " + k);
        System.out.println("  Has nearby duplicate: " + hasNearbyDuplicate);
        
        // Contains Duplicate III (within value and index range)
        System.out.println("\nContains Duplicate III (within value and index range):");
        int[] dup3Nums = {1, 2, 3, 1};
        int indexDiff = 3;
        int valueDiff = 0;
        boolean hasNearbyAlmostDuplicate = containsNearbyAlmostDuplicate(dup3Nums, indexDiff, valueDiff);
        System.out.println("  Array: " + java.util.Arrays.toString(dup3Nums));
        System.out.println("  Index diff: " + indexDiff + ", Value diff: " + valueDiff);
        System.out.println("  Has nearby almost duplicate: " + hasNearbyAlmostDuplicate);
        
        // Find All Duplicates
        System.out.println("\nFind All Duplicates:");
        int[] allDupNums = {4, 3, 2, 7, 8, 2, 3, 1};
        java.util.List<Integer> allDuplicates = findDuplicates(allDupNums);
        System.out.println("  Array: " + java.util.Arrays.toString(allDupNums));
        System.out.println("  All duplicates: " + allDuplicates);
        
        System.out.println();
    }
    
    /**
     * Demonstrates advanced hashing problems
     */
    private static void demonstrateAdvancedProblems() {
        System.out.println("7. Advanced Hashing Problems:");
        System.out.println("============================");
        
        // First Unique Character
        System.out.println("First Unique Character:");
        String[] testStrings = {"leetcode", "loveleetcode", "aabb"};
        for (String str : testStrings) {
            int firstUnique = firstUniqChar(str);
            System.out.println("  \"" + str + "\" -> " + firstUnique);
        }
        
        // Valid Sudoku
        System.out.println("\nValid Sudoku:");
        char[][] sudoku = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        boolean isValidSudoku = isValidSudoku(sudoku);
        System.out.println("  Valid Sudoku: " + isValidSudoku);
        
        // Word Pattern
        System.out.println("\nWord Pattern:");
        String[][] patternTests = {{"abba", "dog cat cat dog"}, {"abba", "dog cat cat fish"}, {"aaaa", "dog cat cat dog"}};
        for (String[] test : patternTests) {
            boolean matches = wordPattern(test[0], test[1]);
            System.out.println("  Pattern: \"" + test[0] + "\", String: \"" + test[1] + "\" -> " + matches);
        }
        
        // Isomorphic Strings
        System.out.println("\nIsomorphic Strings:");
        String[][] isoTests = {{"egg", "add"}, {"foo", "bar"}, {"paper", "title"}};
        for (String[] test : isoTests) {
            boolean isIsomorphic = isIsomorphic(test[0], test[1]);
            System.out.println("  \"" + test[0] + "\" and \"" + test[1] + "\" -> " + isIsomorphic);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates custom hash table implementation
     */
    private static void demonstrateCustomHashTable() {
        System.out.println("8. Custom Hash Table Implementation:");
        System.out.println("===================================");
        
        CustomHashTable<String, Integer> hashTable = new CustomHashTable<>(10);
        
        System.out.println("Custom Hash Table Operations:");
        hashTable.put("apple", 5);
        hashTable.put("banana", 3);
        hashTable.put("cherry", 8);
        System.out.println("  After putting (apple,5), (banana,3), (cherry,8)");
        System.out.println("  Get apple: " + hashTable.get("apple"));
        System.out.println("  Contains banana: " + hashTable.containsKey("banana"));
        System.out.println("  Size: " + hashTable.size());
        
        hashTable.put("apple", 10); // Update existing
        System.out.println("  After updating apple to 10: " + hashTable.get("apple"));
        
        hashTable.remove("banana");
        System.out.println("  After removing banana: " + hashTable.containsKey("banana"));
        System.out.println("  Size: " + hashTable.size());
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance analysis
     */
    private static void demonstratePerformanceAnalysis() {
        System.out.println("9. Performance Analysis:");
        System.out.println("=======================");
        
        System.out.println("Hashing Data Structure Complexity:");
        System.out.println("--------------------------------");
        System.out.println("HashMap/HashSet:");
        System.out.println("  Insert:         O(1) average, O(n) worst case");
        System.out.println("  Delete:         O(1) average, O(n) worst case");
        System.out.println("  Search:         O(1) average, O(n) worst case");
        System.out.println("  Space:          O(n)");
        
        System.out.println("\nTreeMap/TreeSet:");
        System.out.println("  Insert:         O(log n)");
        System.out.println("  Delete:         O(log n)");
        System.out.println("  Search:         O(log n)");
        System.out.println("  Space:          O(n)");
        
        System.out.println("\nLinkedHashMap/LinkedHashSet:");
        System.out.println("  Insert:         O(1) average");
        System.out.println("  Delete:         O(1) average");
        System.out.println("  Search:         O(1) average");
        System.out.println("  Space:          O(n)");
        
        System.out.println("\nCommon Hashing Algorithms:");
        System.out.println("  Two Sum:        O(n) time, O(n) space");
        System.out.println("  Group Anagrams: O(n * m log m) time, O(n * m) space");
        System.out.println("  Frequency Count: O(n) time, O(n) space");
        System.out.println("  Subarray Sum:   O(n) time, O(n) space");
        System.out.println("  Duplicate Check: O(n) time, O(n) space");
        
        System.out.println();
    }
    
    // Frequency Counting Implementation
    
    /**
     * Get character frequency
     * Time Complexity: O(n), Space Complexity: O(1) - limited by alphabet size
     */
    public static java.util.Map<Character, Integer> getCharacterFrequency(String text) {
        java.util.Map<Character, Integer> frequency = new java.util.HashMap<>();
        for (char c : text.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        return frequency;
    }
    
    /**
     * Get word frequency
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static java.util.Map<String, Integer> getWordFrequency(String[] words) {
        java.util.Map<String, Integer> frequency = new java.util.HashMap<>();
        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        return frequency;
    }
    
    /**
     * Get number frequency
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static java.util.Map<Integer, Integer> getNumberFrequency(int[] numbers) {
        java.util.Map<Integer, Integer> frequency = new java.util.HashMap<>();
        for (int num : numbers) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        return frequency;
    }
    
    /**
     * Find most frequent element
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int findMostFrequentElement(int[] arr) {
        java.util.Map<Integer, Integer> frequency = new java.util.HashMap<>();
        int maxFreq = 0;
        int mostFrequent = arr[0];
        
        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            if (frequency.get(num) > maxFreq) {
                maxFreq = frequency.get(num);
                mostFrequent = num;
            }
        }
        
        return mostFrequent;
    }
    
    /**
     * Top K frequent elements
     * Time Complexity: O(n log k), Space Complexity: O(n)
     */
    public static java.util.List<Integer> topKFrequent(int[] nums, int k) {
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
    
    // Two Sum Implementation
    
    /**
     * Two Sum
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1};
    }
    
    /**
     * Two Sum II (Sorted Array)
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int[] twoSumSorted(int[] numbers, int target) {
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
        
        return new int[]{-1, -1};
    }
    
    /**
     * Three Sum
     * Time Complexity: O(n²), Space Complexity: O(1)
     */
    public static java.util.List<java.util.List<Integer>> threeSum(int[] nums) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        java.util.Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
            
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(java.util.Arrays.asList(nums[i], nums[left], nums[right]));
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
     * Four Sum
     * Time Complexity: O(n³), Space Complexity: O(1)
     */
    public static java.util.List<java.util.List<Integer>> fourSum(int[] nums, int target) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        java.util.Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(java.util.Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
    
    // Group Anagrams Implementation
    
    /**
     * Group Anagrams
     * Time Complexity: O(n * m log m), Space Complexity: O(n * m)
     */
    public static java.util.List<java.util.List<String>> groupAnagrams(String[] strs) {
        java.util.Map<String, java.util.List<String>> map = new java.util.HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            java.util.Arrays.sort(chars);
            String key = new String(chars);
            
            map.computeIfAbsent(key, k -> new java.util.ArrayList<>()).add(str);
        }
        
        return new java.util.ArrayList<>(map.values());
    }
    
    /**
     * Valid Anagram
     * Time Complexity: O(n), Space Complexity: O(1)
     */
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
     * Find All Anagrams in String
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static java.util.List<Integer> findAnagrams(String s, String p) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (s.length() < p.length()) return result;
        
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        
        if (java.util.Arrays.equals(pCount, sCount)) {
            result.add(0);
        }
        
        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i - p.length()) - 'a']--;
            sCount[s.charAt(i) - 'a']++;
            
            if (java.util.Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }
        
        return result;
    }
    
    // Subarray Problems Implementation
    
    /**
     * Subarray Sum Equals K
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int subarraySum(int[] nums, int k) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        map.put(0, 1);
        
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
     * Longest Subarray with Sum K
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int longestSubarrayWithSumK(int[] nums, int k) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        map.put(0, -1);
        
        int maxLength = 0;
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return maxLength;
    }
    
    /**
     * Has Subarray with Given Sum
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static boolean hasSubarrayWithSum(int[] nums, int target) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
        set.add(0);
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (set.contains(sum - target)) {
                return true;
            }
            set.add(sum);
        }
        
        return false;
    }
    
    /**
     * Longest Consecutive Sequence
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int longestConsecutive(int[] nums) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int maxLength = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) { // Start of sequence
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
    
    // Duplicate Detection Implementation
    
    /**
     * Contains Duplicate
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static boolean containsDuplicate(int[] nums) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
    
    /**
     * Contains Duplicate II (within k distance)
     * Time Complexity: O(n), Space Complexity: O(min(n, k))
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            
            if (set.contains(nums[i])) {
                return true;
            }
            
            set.add(nums[i]);
        }
        
        return false;
    }
    
    /**
     * Contains Duplicate III (within value and index range)
     * Time Complexity: O(n log k), Space Complexity: O(k)
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        java.util.TreeSet<Long> set = new java.util.TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i > indexDiff) {
                set.remove((long) nums[i - indexDiff - 1]);
            }
            
            Long floor = set.floor((long) nums[i]);
            Long ceiling = set.ceiling((long) nums[i]);
            
            if ((floor != null && nums[i] - floor <= valueDiff) ||
                (ceiling != null && ceiling - nums[i] <= valueDiff)) {
                return true;
            }
            
            set.add((long) nums[i]);
        }
        
        return false;
    }
    
    /**
     * Find All Duplicates
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static java.util.List<Integer> findDuplicates(int[] nums) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        
        return result;
    }
    
    // Advanced Problems Implementation
    
    /**
     * First Unique Character
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int firstUniqChar(String s) {
        java.util.Map<Character, Integer> count = new java.util.HashMap<>();
        
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * Valid Sudoku
     * Time Complexity: O(1), Space Complexity: O(1) - fixed 9x9 grid
     */
    public static boolean isValidSudoku(char[][] board) {
        java.util.Set<String> seen = new java.util.HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    if (!seen.add(num + " in row " + i) ||
                        !seen.add(num + " in column " + j) ||
                        !seen.add(num + " in block " + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    /**
     * Word Pattern
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        
        java.util.Map<Character, String> charToWord = new java.util.HashMap<>();
        java.util.Map<String, Character> wordToChar = new java.util.HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            if (charToWord.containsKey(c) && !charToWord.get(c).equals(word)) {
                return false;
            }
            if (wordToChar.containsKey(word) && wordToChar.get(word) != c) {
                return false;
            }
            
            charToWord.put(c, word);
            wordToChar.put(word, c);
        }
        
        return true;
    }
    
    /**
     * Isomorphic Strings
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        java.util.Map<Character, Character> map = new java.util.HashMap<>();
        java.util.Set<Character> used = new java.util.HashSet<>();
        
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
    
    // Custom Hash Table Implementation
    
    /**
     * Custom Hash Table Implementation
     */
    static class CustomHashTable<K, V> {
        private static final int DEFAULT_CAPACITY = 16;
        private static final double LOAD_FACTOR = 0.75;
        
        private Entry<K, V>[] table;
        private int size;
        private int capacity;
        
        @SuppressWarnings("unchecked")
        public CustomHashTable(int capacity) {
            this.capacity = capacity;
            this.table = new Entry[capacity];
            this.size = 0;
        }
        
        public CustomHashTable() {
            this(DEFAULT_CAPACITY);
        }
        
        static class Entry<K, V> {
            K key;
            V value;
            Entry<K, V> next;
            
            Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        
        public void put(K key, V value) {
            if (key == null) return;
            
            int index = hash(key);
            Entry<K, V> entry = table[index];
            
            // Check if key already exists
            while (entry != null) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            
            // Add new entry
            Entry<K, V> newEntry = new Entry<>(key, value);
            newEntry.next = table[index];
            table[index] = newEntry;
            size++;
            
            // Resize if necessary
            if (size > capacity * LOAD_FACTOR) {
                resize();
            }
        }
        
        public V get(K key) {
            if (key == null) return null;
            
            int index = hash(key);
            Entry<K, V> entry = table[index];
            
            while (entry != null) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
                entry = entry.next;
            }
            
            return null;
        }
        
        public boolean containsKey(K key) {
            return get(key) != null;
        }
        
        public V remove(K key) {
            if (key == null) return null;
            
            int index = hash(key);
            Entry<K, V> entry = table[index];
            Entry<K, V> prev = null;
            
            while (entry != null) {
                if (entry.key.equals(key)) {
                    if (prev == null) {
                        table[index] = entry.next;
                    } else {
                        prev.next = entry.next;
                    }
                    size--;
                    return entry.value;
                }
                prev = entry;
                entry = entry.next;
            }
            
            return null;
        }
        
        public int size() {
            return size;
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        private int hash(K key) {
            return Math.abs(key.hashCode()) % capacity;
        }
        
        @SuppressWarnings("unchecked")
        private void resize() {
            Entry<K, V>[] oldTable = table;
            capacity *= 2;
            table = new Entry[capacity];
            size = 0;
            
            for (Entry<K, V> entry : oldTable) {
                while (entry != null) {
                    put(entry.key, entry.value);
                    entry = entry.next;
                }
            }
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            boolean first = true;
            
            for (Entry<K, V> entry : table) {
                while (entry != null) {
                    if (!first) sb.append(", ");
                    sb.append(entry.key).append("=").append(entry.value);
                    first = false;
                    entry = entry.next;
                }
            }
            
            sb.append("}");
            return sb.toString();
        }
    }
}
