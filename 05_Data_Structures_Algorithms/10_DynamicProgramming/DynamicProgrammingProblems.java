package DynamicProgramming;

import java.util.*;

/**
 * Dynamic Programming Problems - Comprehensive Solutions
 * 
 * This class contains solutions to fundamental DP problems including:
 * - Basic DP (Fibonacci, Climbing Stairs)
 * - Path problems (Unique Paths, Minimum Path Sum)
 * - Sequence problems (LIS, LCS, Edit Distance)
 * - Knapsack problems (0/1 Knapsack, Unbounded)
 * - String problems (Palindrome, Subsequence)
 * - Matrix problems (Longest Increasing Path, Maximal Square)
 * 
 * Each problem includes detailed comments on approach, time and space complexity.
 */
public class DynamicProgrammingProblems {

    // ==================== BASIC DP PROBLEMS ====================

    /**
     * Problem: Climbing Stairs
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * 
     * Approach: Fibonacci sequence - dp[i] = dp[i-1] + dp[i-2]
     * Time Complexity: O(n)
     * Space Complexity: O(1) with optimization
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        
        int prev2 = 1; // dp[0]
        int prev1 = 2; // dp[1]
        
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }

    /**
     * Problem: Fibonacci Number
     * Calculate the nth Fibonacci number using DP.
     */
    public int fibonacci(int n) {
        if (n <= 1) return n;
        
        int prev2 = 0;
        int prev1 = 1;
        
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }

    /**
     * Problem: House Robber
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed.
     * Adjacent houses have security systems connected and will automatically contact the police.
     * 
     * Approach: dp[i] = max(dp[i-1], dp[i-2] + nums[i])
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }

    /**
     * Problem: House Robber II
     * Houses are arranged in a circle. First and last houses are adjacent.
     */
    public int robCircular(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        // Case 1: Rob first house, skip last
        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        
        // Case 2: Skip first house, can rob last
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
        
        return Math.max(rob(nums1), rob(nums2));
    }

    /**
     * Problem: Coin Change
     * You are given an integer array coins representing coins of different denominations.
     * Return the fewest number of coins that you need to make up that amount.
     * 
     * Approach: dp[i] = minimum coins needed for amount i
     * Time Complexity: O(amount * coins.length)
     * Space Complexity: O(amount)
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * Problem: Coin Change II
     * Return the number of combinations that make up that amount.
     */
    public int coinChangeCombinations(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[amount];
    }

    // ==================== PATH PROBLEMS ====================

    /**
     * Problem: Unique Paths
     * A robot is located at the top-left corner of a m x n grid.
     * The robot can only move either down or right at any point in time.
     * 
     * Approach: dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n) -> O(n) with optimization
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }

    /**
     * Problem: Unique Paths with Obstacles
     * Some cells are marked as obstacles (1) and cannot be passed.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return dp[n - 1];
    }

    /**
     * Problem: Minimum Path Sum
     * Find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        
        // Initialize first row
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0]; // First column
            
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        
        return dp[n - 1];
    }

    // ==================== SEQUENCE PROBLEMS ====================

    /**
     * Problem: Longest Increasing Subsequence (LIS)
     * Given an integer array nums, return the length of the longest strictly increasing subsequence.
     * 
     * Approach: Binary search optimization - O(n log n)
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();
        
        for (int num : nums) {
            int pos = binarySearch(tails, num);
            
            if (pos == tails.size()) {
                tails.add(num);
            } else {
                tails.set(pos, num);
            }
        }
        
        return tails.size();
    }
    
    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }

    /**
     * Problem: Longest Common Subsequence (LCS)
     * Given two strings text1 and text2, return the length of their longest common subsequence.
     * 
     * Approach: 2D DP - dp[i][j] = LCS length of text1[0:i] and text2[0:j]
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n) -> O(min(m,n)) with optimization
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev[n];
    }

    /**
     * Problem: Edit Distance (Levenshtein Distance)
     * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
     * Operations: insert, delete, or replace a character.
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        
        // Initialize first row
        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }
        
        for (int i = 1; i <= m; i++) {
            curr[0] = i; // Initialize first column
            
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], curr[j - 1]));
                }
            }
            
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev[n];
    }

    /**
     * Problem: Longest Palindromic Subsequence
     * Given a string s, find the length of the longest palindromic subsequence.
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] prev = new int[n];
        int[] curr = new int[n];
        
        // Initialize diagonal
        for (int i = 0; i < n; i++) {
            prev[i] = 1;
        }
        
        // Fill DP table
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                if (s.charAt(i) == s.charAt(j)) {
                    curr[j] = 2 + (len == 2 ? 0 : prev[j - 1]);
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev[n - 1];
    }

    // ==================== KNAPSACK PROBLEMS ====================

    /**
     * Problem: 0/1 Knapsack
     * Given weights and values of n items, put these items in a knapsack of capacity W.
     * 
     * Approach: dp[i][w] = max value using first i items with capacity w
     * Time Complexity: O(n * W)
     * Space Complexity: O(W) with optimization
     */
    public int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];
        
        for (int i = 0; i < n; i++) {
            for (int w = capacity; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }
        
        return dp[capacity];
    }

    /**
     * Problem: Unbounded Knapsack (Coin Change variant)
     * Items can be used unlimited times.
     */
    public int unboundedKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];
        
        for (int w = 1; w <= capacity; w++) {
            for (int i = 0; i < n; i++) {
                if (weights[i] <= w) {
                    dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
                }
            }
        }
        
        return dp[capacity];
    }

    // ==================== STRING PROBLEMS ====================

    /**
     * Problem: Longest Palindromic Substring
     * Given a string s, return the longest palindromic substring in s.
     * 
     * Approach: Expand around centers
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);     // Odd length
            int len2 = expandAroundCenter(s, i, i + 1); // Even length
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * Problem: Word Break
     * Given a string s and a dictionary of strings wordDict, return true if s can be segmented.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
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
     * Problem: Decode Ways
     * A message containing letters from A-Z can be encoded into numbers using A=1, B=2, ..., Z=26.
     * Given a non-empty string containing only digits, determine the total number of ways to decode it.
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1; // Empty string has 1 way
        
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i + 1];
                
                if (i < n - 1 && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        
        return dp[0];
    }

    // ==================== MATRIX PROBLEMS ====================

    /**
     * Problem: Longest Increasing Path in a Matrix
     * Given an m x n integers matrix, return the length of the longest increasing path.
     * 
     * Approach: DFS with memoization
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        
        int maxPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, memo));
            }
        }
        
        return maxPath;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int maxLen = 1;
        
        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            
            if (ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length 
                && matrix[ni][nj] > matrix[i][j]) {
                maxLen = Math.max(maxLen, 1 + dfs(matrix, ni, nj, memo));
            }
        }
        
        memo[i][j] = maxLen;
        return maxLen;
    }

    /**
     * Problem: Maximal Square
     * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's.
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        int maxSide = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    curr[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], curr[j - 1]));
                    maxSide = Math.max(maxSide, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return maxSide * maxSide;
    }

    // ==================== DEMONSTRATION METHODS ====================

    /**
     * Demonstrate all dynamic programming problems
     */
    public static void demonstrateAllProblems() {
        System.out.println("=== Dynamic Programming Problems Demonstration ===\n");
        
        DynamicProgrammingProblems dp = new DynamicProgrammingProblems();
        
        // Climbing Stairs
        int stairs = dp.climbStairs(5);
        System.out.println("Climbing Stairs (5): " + stairs);
        
        // House Robber
        int[] houses = {2, 7, 9, 3, 1};
        int maxRob = dp.rob(houses);
        System.out.println("House Robber: " + maxRob);
        
        // Coin Change
        int[] coins = {1, 3, 4};
        int amount = 6;
        int minCoins = dp.coinChange(coins, amount);
        System.out.println("Coin Change: " + minCoins);
        
        // Unique Paths
        int paths = dp.uniquePaths(3, 7);
        System.out.println("Unique Paths (3x7): " + paths);
        
        // Longest Increasing Subsequence
        int[] sequence = {10, 9, 2, 5, 3, 7, 101, 18};
        int lis = dp.lengthOfLIS(sequence);
        System.out.println("Longest Increasing Subsequence: " + lis);
        
        // Longest Common Subsequence
        String text1 = "abcde";
        String text2 = "ace";
        int lcs = dp.longestCommonSubsequence(text1, text2);
        System.out.println("Longest Common Subsequence: " + lcs);
        
        System.out.println("\n=== Dynamic Programming Problems Completed ===");
    }

    public static void main(String[] args) {
        demonstrateAllProblems();
    }
}
