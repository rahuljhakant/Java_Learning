package com.tutorial.datastructures.strings;

/**
 * String Algorithms - Comprehensive Guide to String Operations in Java
 * 
 * This comprehensive tutorial demonstrates essential string algorithms including
 * pattern matching, string manipulation, and advanced string processing techniques.
 * String algorithms are fundamental for text processing, data validation, and
 * many real-world applications.
 * 
 * LEARNING OBJECTIVES:
 * - Master pattern matching algorithms (Naive, KMP, Rabin-Karp)
 * - Understand palindrome and anagram detection techniques
 * - Learn substring problems and sliding window techniques
 * - Practice string hashing and rolling hash algorithms
 * - Implement dynamic programming solutions for strings
 * - Understand time and space complexity analysis
 * 
 * KEY CONCEPTS:
 * 1. Pattern Matching: Finding patterns in text efficiently
 * 2. String Hashing: Using hash functions for string comparison
 * 3. Sliding Window: Optimized approach for substring problems
 * 4. Dynamic Programming: Solving complex string problems
 * 5. Two Pointers: Efficient technique for string manipulation
 * 6. Rolling Hash: Efficient hash computation for substrings
 * 7. Suffix Arrays: Advanced string data structures
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
public class StringAlgorithms {
    
    public static void main(String[] args) {
        System.out.println("=== String Algorithms Demo ===");
        System.out.println();
        
        // 1. Pattern Matching Algorithms
        demonstratePatternMatching();
        
        // 2. Palindrome Problems
        demonstratePalindromeProblems();
        
        // 3. Anagram Problems
        demonstrateAnagramProblems();
        
        // 4. Substring Problems
        demonstrateSubstringProblems();
        
        // 5. String Hashing
        demonstrateStringHashing();
        
        // 6. Dynamic Programming on Strings
        demonstrateDynamicProgramming();
        
        // 7. Advanced String Problems
        demonstrateAdvancedProblems();
        
        // 8. Performance Analysis
        demonstratePerformanceAnalysis();
    }
    
    /**
     * Demonstrates pattern matching algorithms
     */
    private static void demonstratePatternMatching() {
        System.out.println("1. Pattern Matching Algorithms:");
        System.out.println("==============================");
        
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        
        System.out.println("Text: \"" + text + "\"");
        System.out.println("Pattern: \"" + pattern + "\"");
        
        // Naive Pattern Matching
        System.out.println("\nNaive Pattern Matching:");
        int naiveResult = naivePatternMatching(text, pattern);
        System.out.println("  Pattern found at index: " + naiveResult);
        System.out.println("  Time Complexity: O(m(n-m+1)), Space Complexity: O(1)");
        
        // KMP Algorithm
        System.out.println("\nKMP Algorithm:");
        int kmpResult = kmpPatternMatching(text, pattern);
        System.out.println("  Pattern found at index: " + kmpResult);
        System.out.println("  Time Complexity: O(m + n), Space Complexity: O(m)");
        
        // Rabin-Karp Algorithm
        System.out.println("\nRabin-Karp Algorithm:");
        int rkResult = rabinKarpPatternMatching(text, pattern);
        System.out.println("  Pattern found at index: " + rkResult);
        System.out.println("  Time Complexity: O(m + n) avg, O(mn) worst, Space: O(1)");
        
        System.out.println();
    }
    
    /**
     * Demonstrates palindrome problems
     */
    private static void demonstratePalindromeProblems() {
        System.out.println("2. Palindrome Problems:");
        System.out.println("======================");
        
        String[] testStrings = {
            "racecar",
            "A man a plan a canal Panama",
            "hello",
            "Madam",
            "Was it a car or a cat I saw?"
        };
        
        for (String str : testStrings) {
            boolean isPalindrome = isPalindrome(str);
            System.out.println("  \"" + str + "\" -> " + isPalindrome);
        }
        
        // Longest Palindromic Substring
        System.out.println("\nLongest Palindromic Substring:");
        String testStr = "babad";
        String longestPalindrome = longestPalindromicSubstring(testStr);
        System.out.println("  Input: \"" + testStr + "\"");
        System.out.println("  Longest palindrome: \"" + longestPalindrome + "\"");
        
        // Count Palindromic Substrings
        System.out.println("\nCount Palindromic Substrings:");
        String countStr = "aaa";
        int count = countPalindromicSubstrings(countStr);
        System.out.println("  Input: \"" + countStr + "\"");
        System.out.println("  Count: " + count);
        
        System.out.println();
    }
    
    /**
     * Demonstrates anagram problems
     */
    private static void demonstrateAnagramProblems() {
        System.out.println("3. Anagram Problems:");
        System.out.println("===================");
        
        String[][] testPairs = {
            {"listen", "silent"},
            {"evil", "vile"},
            {"hello", "world"},
            {"anagram", "nagaram"},
            {"rat", "car"}
        };
        
        for (String[] pair : testPairs) {
            boolean isAnagram = isAnagram(pair[0], pair[1]);
            System.out.println("  \"" + pair[0] + "\" and \"" + pair[1] + "\" -> " + isAnagram);
        }
        
        // Group Anagrams
        System.out.println("\nGroup Anagrams:");
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        java.util.List<java.util.List<String>> groups = groupAnagrams(words);
        System.out.println("  Input: " + java.util.Arrays.toString(words));
        System.out.println("  Groups: " + groups);
        
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
     * Demonstrates substring problems
     */
    private static void demonstrateSubstringProblems() {
        System.out.println("4. Substring Problems:");
        System.out.println("=====================");
        
        // Longest Substring Without Repeating Characters
        System.out.println("Longest Substring Without Repeating Characters:");
        String str1 = "abcabcbb";
        int length1 = lengthOfLongestSubstring(str1);
        System.out.println("  Input: \"" + str1 + "\"");
        System.out.println("  Length: " + length1);
        
        // Longest Substring with At Most K Distinct Characters
        System.out.println("\nLongest Substring with At Most K Distinct Characters:");
        String str2 = "eceba";
        int k = 2;
        int length2 = lengthOfLongestSubstringKDistinct(str2, k);
        System.out.println("  Input: \"" + str2 + "\", K: " + k);
        System.out.println("  Length: " + length2);
        
        // Minimum Window Substring
        System.out.println("\nMinimum Window Substring:");
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minWindow = minWindow(s, t);
        System.out.println("  String: \"" + s + "\", Pattern: \"" + t + "\"");
        System.out.println("  Minimum window: \"" + minWindow + "\"");
        
        // Longest Common Substring
        System.out.println("\nLongest Common Substring:");
        String str3 = "ABCDGH";
        String str4 = "ACDGHR";
        String lcs = longestCommonSubstring(str3, str4);
        System.out.println("  String1: \"" + str3 + "\", String2: \"" + str4 + "\"");
        System.out.println("  Longest common substring: \"" + lcs + "\"");
        
        System.out.println();
    }
    
    /**
     * Demonstrates string hashing
     */
    private static void demonstrateStringHashing() {
        System.out.println("5. String Hashing:");
        System.out.println("=================");
        
        String str = "hello";
        System.out.println("String: \"" + str + "\"");
        
        // Basic String Hash
        int basicHash = str.hashCode();
        System.out.println("  Basic hash: " + basicHash);
        
        // Rolling Hash
        System.out.println("\nRolling Hash:");
        String text = "abcdefgh";
        String pattern = "cde";
        int patternHash = rollingHash(pattern);
        System.out.println("  Text: \"" + text + "\", Pattern: \"" + pattern + "\"");
        System.out.println("  Pattern hash: " + patternHash);
        
        // Find pattern using rolling hash
        int foundIndex = findPatternRollingHash(text, pattern);
        System.out.println("  Pattern found at index: " + foundIndex);
        
        // String Hashing for Substring Comparison
        System.out.println("\nSubstring Comparison using Hashing:");
        String str1 = "hello";
        String str2 = "hello";
        boolean areEqual = compareSubstrings(str1, 0, 2, str2, 0, 2);
        System.out.println("  \"" + str1.substring(0, 3) + "\" == \"" + str2.substring(0, 3) + "\": " + areEqual);
        
        System.out.println();
    }
    
    /**
     * Demonstrates dynamic programming on strings
     */
    private static void demonstrateDynamicProgramming() {
        System.out.println("6. Dynamic Programming on Strings:");
        System.out.println("=================================");
        
        // Longest Common Subsequence
        System.out.println("Longest Common Subsequence:");
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        int lcsLength = longestCommonSubsequence(str1, str2);
        System.out.println("  String1: \"" + str1 + "\", String2: \"" + str2 + "\"");
        System.out.println("  LCS length: " + lcsLength);
        
        // Edit Distance (Levenshtein Distance)
        System.out.println("\nEdit Distance:");
        String word1 = "horse";
        String word2 = "ros";
        int editDistance = editDistance(word1, word2);
        System.out.println("  Word1: \"" + word1 + "\", Word2: \"" + word2 + "\"");
        System.out.println("  Edit distance: " + editDistance);
        
        // Palindrome Partitioning
        System.out.println("\nPalindrome Partitioning:");
        String palindromeStr = "aab";
        java.util.List<java.util.List<String>> partitions = partitionPalindrome(palindromeStr);
        System.out.println("  String: \"" + palindromeStr + "\"");
        System.out.println("  Partitions: " + partitions);
        
        // Longest Palindromic Subsequence
        System.out.println("\nLongest Palindromic Subsequence:");
        String lpsStr = "bbbab";
        int lpsLength = longestPalindromicSubsequence(lpsStr);
        System.out.println("  String: \"" + lpsStr + "\"");
        System.out.println("  LPS length: " + lpsLength);
        
        System.out.println();
    }
    
    /**
     * Demonstrates advanced string problems
     */
    private static void demonstrateAdvancedProblems() {
        System.out.println("7. Advanced String Problems:");
        System.out.println("===========================");
        
        // Word Break
        System.out.println("Word Break:");
        String wordBreakStr = "leetcode";
        java.util.List<String> wordDict = java.util.Arrays.asList("leet", "code");
        boolean canBreak = wordBreak(wordBreakStr, wordDict);
        System.out.println("  String: \"" + wordBreakStr + "\"");
        System.out.println("  Dictionary: " + wordDict);
        System.out.println("  Can break: " + canBreak);
        
        // Valid Parentheses
        System.out.println("\nValid Parentheses:");
        String[] parentheses = {"()", "()[]{}", "(]", "([)]", "{[]}"};
        for (String paren : parentheses) {
            boolean isValid = isValidParentheses(paren);
            System.out.println("  \"" + paren + "\" -> " + isValid);
        }
        
        // String Compression
        System.out.println("\nString Compression:");
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int compressedLength = compress(chars);
        System.out.println("  Original: " + java.util.Arrays.toString(chars));
        System.out.println("  Compressed length: " + compressedLength);
        
        // Reverse Words in String
        System.out.println("\nReverse Words in String:");
        String reverseStr = "the sky is blue";
        String reversed = reverseWords(reverseStr);
        System.out.println("  Original: \"" + reverseStr + "\"");
        System.out.println("  Reversed: \"" + reversed + "\"");
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance analysis
     */
    private static void demonstratePerformanceAnalysis() {
        System.out.println("8. Performance Analysis:");
        System.out.println("=======================");
        
        System.out.println("String Algorithm Complexity Summary:");
        System.out.println("----------------------------------");
        System.out.println("Pattern Matching:");
        System.out.println("  Naive:           O(m(n-m+1)) time, O(1) space");
        System.out.println("  KMP:             O(m + n) time, O(m) space");
        System.out.println("  Rabin-Karp:      O(m + n) avg, O(mn) worst, O(1) space");
        
        System.out.println("\nString Operations:");
        System.out.println("  Palindrome Check: O(n) time, O(1) space");
        System.out.println("  Anagram Check:    O(n) time, O(1) space");
        System.out.println("  Substring Search: O(n) time, O(1) space");
        
        System.out.println("\nDynamic Programming:");
        System.out.println("  LCS:             O(mn) time, O(mn) space");
        System.out.println("  Edit Distance:   O(mn) time, O(mn) space");
        System.out.println("  LPS:             O(n²) time, O(n²) space");
        
        System.out.println("\nAdvanced Operations:");
        System.out.println("  Rolling Hash:    O(n) time, O(1) space");
        System.out.println("  String Hashing:  O(n) time, O(1) space");
        System.out.println("  Suffix Array:    O(n log n) time, O(n) space");
        
        System.out.println();
    }
    
    // Pattern Matching Algorithms Implementation
    
    /**
     * Naive Pattern Matching Algorithm
     * Time Complexity: O(m(n-m+1)), Space Complexity: O(1)
     */
    public static int naivePatternMatching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * KMP Pattern Matching Algorithm
     * Time Complexity: O(m + n), Space Complexity: O(m)
     */
    public static int kmpPatternMatching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        
        int[] lps = computeLPSArray(pattern);
        
        int i = 0; // index for text
        int j = 0; // index for pattern
        
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            
            if (j == m) {
                return i - j;
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        return -1;
    }
    
    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
    
    /**
     * Rabin-Karp Pattern Matching Algorithm
     * Time Complexity: O(m + n) average, O(mn) worst, Space Complexity: O(1)
     */
    public static int rabinKarpPatternMatching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int d = 256; // number of characters in input alphabet
        int q = 101; // prime number
        
        int h = 1;
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }
        
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        
        // Calculate hash value of pattern and first window of text
        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }
        
        // Slide the pattern over text one by one
        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                // Check for characters one by one
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == m) {
                    return i;
                }
            }
            
            // Calculate hash value for next window of text
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0) {
                    t = t + q;
                }
            }
        }
        
        return -1;
    }
    
    // Palindrome Problems Implementation
    
    /**
     * Check if string is palindrome
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
    
    /**
     * Longest Palindromic Substring
     * Time Complexity: O(n²), Space Complexity: O(1)
     */
    public static String longestPalindromicSubstring(String s) {
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
     * Count Palindromic Substrings
     * Time Complexity: O(n²), Space Complexity: O(1)
     */
    public static int countPalindromicSubstrings(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count += expandAroundCenter(s, i, i);
            count += expandAroundCenter(s, i, i + 1);
        }
        
        return count;
    }
    
    // Anagram Problems Implementation
    
    /**
     * Check if two strings are anagrams
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
    
    // Substring Problems Implementation
    
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
     * Longest Substring with At Most K Distinct Characters
     * Time Complexity: O(n), Space Complexity: O(k)
     */
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        java.util.Map<Character, Integer> map = new java.util.HashMap<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            
            while (map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            
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
    
    /**
     * Longest Common Substring
     * Time Complexity: O(mn), Space Complexity: O(mn)
     */
    public static String longestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        int endIndex = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                }
            }
        }
        
        return str1.substring(endIndex - maxLength + 1, endIndex + 1);
    }
    
    // String Hashing Implementation
    
    /**
     * Rolling Hash Function
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int rollingHash(String str) {
        int hash = 0;
        int base = 256;
        int mod = 1000000007;
        
        for (char c : str.toCharArray()) {
            hash = (hash * base + c) % mod;
        }
        
        return hash;
    }
    
    /**
     * Find Pattern using Rolling Hash
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int findPatternRollingHash(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int base = 256;
        int mod = 1000000007;
        
        int patternHash = rollingHash(pattern);
        int textHash = 0;
        int h = 1;
        
        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % mod;
        }
        
        for (int i = 0; i < m; i++) {
            textHash = (textHash * base + text.charAt(i)) % mod;
        }
        
        for (int i = 0; i <= n - m; i++) {
            if (textHash == patternHash) {
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == m) {
                    return i;
                }
            }
            
            if (i < n - m) {
                textHash = (base * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % mod;
                if (textHash < 0) {
                    textHash += mod;
                }
            }
        }
        
        return -1;
    }
    
    /**
     * Compare Substrings using Hashing
     * Time Complexity: O(1), Space Complexity: O(1)
     */
    public static boolean compareSubstrings(String str1, int start1, int end1, 
                                          String str2, int start2, int end2) {
        if (end1 - start1 != end2 - start2) return false;
        
        for (int i = 0; i < end1 - start1; i++) {
            if (str1.charAt(start1 + i) != str2.charAt(start2 + i)) {
                return false;
            }
        }
        
        return true;
    }
    
    // Dynamic Programming Implementation
    
    /**
     * Longest Common Subsequence
     * Time Complexity: O(mn), Space Complexity: O(mn)
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }
    
    /**
     * Edit Distance (Levenshtein Distance)
     * Time Complexity: O(mn), Space Complexity: O(mn)
     */
    public static int editDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        
        return dp[m][n];
    }
    
    /**
     * Palindrome Partitioning
     * Time Complexity: O(2^n), Space Complexity: O(n)
     */
    public static java.util.List<java.util.List<String>> partitionPalindrome(String s) {
        java.util.List<java.util.List<String>> result = new java.util.ArrayList<>();
        java.util.List<String> current = new java.util.ArrayList<>();
        partitionPalindromeHelper(s, 0, current, result);
        return result;
    }
    
    private static void partitionPalindromeHelper(String s, int start, 
                                                java.util.List<String> current,
                                                java.util.List<java.util.List<String>> result) {
        if (start == s.length()) {
            result.add(new java.util.ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (isPalindromeSubstring(s, start, i)) {
                current.add(s.substring(start, i + 1));
                partitionPalindromeHelper(s, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private static boolean isPalindromeSubstring(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    /**
     * Longest Palindromic Subsequence
     * Time Complexity: O(n²), Space Complexity: O(n²)
     */
    public static int longestPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[0][n - 1];
    }
    
    // Advanced Problems Implementation
    
    /**
     * Word Break
     * Time Complexity: O(n²), Space Complexity: O(n)
     */
    public static boolean wordBreak(String s, java.util.List<String> wordDict) {
        java.util.Set<String> wordSet = new java.util.HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
    
    /**
     * Valid Parentheses
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static boolean isValidParentheses(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        
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
     * String Compression
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int compress(char[] chars) {
        int index = 0;
        int i = 0;
        
        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;
            
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }
            
            chars[index++] = currentChar;
            
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        
        return index;
    }
    
    /**
     * Reverse Words in String
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        java.util.Collections.reverse(java.util.Arrays.asList(words));
        return String.join(" ", words);
    }
}
