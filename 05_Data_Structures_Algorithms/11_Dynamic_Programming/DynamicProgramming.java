package com.tutorial.datastructures.dynamicprogramming;

/**
 * Dynamic Programming - Comprehensive Guide to Dynamic Programming in Java
 * 
 * This comprehensive tutorial demonstrates essential dynamic programming algorithms
 * including problems on arrays, strings, grids, and trees. Dynamic programming
 * is a powerful optimization technique for solving complex problems efficiently.
 * 
 * LEARNING OBJECTIVES:
 * - Master dynamic programming fundamentals and patterns
 * - Understand memoization and tabulation approaches
 * - Learn DP on arrays (LIS, Kadane's, Subset Sum, Knapsack)
 * - Practice DP on strings (LCS, Edit Distance, Palindrome)
 * - Implement DP on grids and trees
 * - Understand space optimization techniques
 * - Master time and space complexity analysis
 * 
 * KEY CONCEPTS:
 * 1. Overlapping Subproblems: Same subproblems solved multiple times
 * 2. Optimal Substructure: Optimal solution contains optimal solutions to subproblems
 * 3. Memoization: Top-down approach with caching
 * 4. Tabulation: Bottom-up approach with table filling
 * 5. State Transition: How to move from one state to another
 * 6. Base Cases: Initial conditions for the problem
 * 7. Space Optimization: Reducing space complexity
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class DynamicProgramming {
    
    public static void main(String[] args) {
        System.out.println("=== Dynamic Programming Demo ===");
        System.out.println();
        
        // 1. DP on Arrays
        demonstrateDPOnArrays();
        
        // 2. DP on Strings
        demonstrateDPOnStrings();
        
        // 3. DP on Grids
        demonstrateDPOnGrids();
        
        // 4. DP on Trees
        demonstrateDPOnTrees();
        
        // 5. Advanced DP Problems
        demonstrateAdvancedDP();
        
        // 6. Performance Analysis
        demonstratePerformanceAnalysis();
    }
    
    /**
     * Demonstrates DP on arrays
     */
    private static void demonstrateDPOnArrays() {
        System.out.println("1. DP on Arrays:");
        System.out.println("===============");
        
        // Longest Increasing Subsequence
        System.out.println("Longest Increasing Subsequence:");
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int lis = longestIncreasingSubsequence(nums);
        System.out.println("  Array: " + java.util.Arrays.toString(nums));
        System.out.println("  LIS length: " + lis);
        
        // Kadane's Algorithm (Maximum Subarray Sum)
        System.out.println("\nKadane's Algorithm (Maximum Subarray Sum):");
        int[] kadaneNums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = kadanesAlgorithm(kadaneNums);
        System.out.println("  Array: " + java.util.Arrays.toString(kadaneNums));
        System.out.println("  Maximum subarray sum: " + maxSum);
        
        // Subset Sum Problem
        System.out.println("\nSubset Sum Problem:");
        int[] subsetNums = {3, 34, 4, 12, 5, 2};
        int target = 9;
        boolean hasSubset = subsetSum(subsetNums, target);
        System.out.println("  Array: " + java.util.Arrays.toString(subsetNums));
        System.out.println("  Target: " + target);
        System.out.println("  Has subset with sum " + target + ": " + hasSubset);
        
        // 0/1 Knapsack Problem
        System.out.println("\n0/1 Knapsack Problem:");
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        int maxValue = knapsack(weights, values, capacity);
        System.out.println("  Weights: " + java.util.Arrays.toString(weights));
        System.out.println("  Values: " + java.util.Arrays.toString(values));
        System.out.println("  Capacity: " + capacity);
        System.out.println("  Maximum value: " + maxValue);
        
        // Coin Change Problem
        System.out.println("\nCoin Change Problem:");
        int[] coins = {1, 3, 4};
        int amount = 6;
        int minCoins = coinChange(coins, amount);
        System.out.println("  Coins: " + java.util.Arrays.toString(coins));
        System.out.println("  Amount: " + amount);
        System.out.println("  Minimum coins needed: " + minCoins);
        
        System.out.println();
    }
    
    /**
     * Demonstrates DP on strings
     */
    private static void demonstrateDPOnStrings() {
        System.out.println("2. DP on Strings:");
        System.out.println("================");
        
        // Longest Common Subsequence
        System.out.println("Longest Common Subsequence:");
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        int lcsLength = longestCommonSubsequence(str1, str2);
        System.out.println("  String 1: \"" + str1 + "\"");
        System.out.println("  String 2: \"" + str2 + "\"");
        System.out.println("  LCS length: " + lcsLength);
        
        // Edit Distance (Levenshtein Distance)
        System.out.println("\nEdit Distance:");
        String word1 = "horse";
        String word2 = "ros";
        int editDist = editDistance(word1, word2);
        System.out.println("  Word 1: \"" + word1 + "\"");
        System.out.println("  Word 2: \"" + word2 + "\"");
        System.out.println("  Edit distance: " + editDist);
        
        // Longest Palindromic Subsequence
        System.out.println("\nLongest Palindromic Subsequence:");
        String palindromeStr = "bbbab";
        int lpsLength = longestPalindromicSubsequence(palindromeStr);
        System.out.println("  String: \"" + palindromeStr + "\"");
        System.out.println("  LPS length: " + lpsLength);
        
        // Palindrome Partitioning
        System.out.println("\nPalindrome Partitioning:");
        String partitionStr = "aab";
        int minCuts = minCut(partitionStr);
        System.out.println("  String: \"" + partitionStr + "\"");
        System.out.println("  Minimum cuts: " + minCuts);
        
        // Word Break
        System.out.println("\nWord Break:");
        String wordBreakStr = "leetcode";
        java.util.List<String> wordDict = java.util.Arrays.asList("leet", "code");
        boolean canBreak = wordBreak(wordBreakStr, wordDict);
        System.out.println("  String: \"" + wordBreakStr + "\"");
        System.out.println("  Dictionary: " + wordDict);
        System.out.println("  Can break: " + canBreak);
        
        System.out.println();
    }
    
    /**
     * Demonstrates DP on grids
     */
    private static void demonstrateDPOnGrids() {
        System.out.println("3. DP on Grids:");
        System.out.println("==============");
        
        // Unique Paths
        System.out.println("Unique Paths:");
        int m = 3, n = 7;
        int uniquePaths = uniquePaths(m, n);
        System.out.println("  Grid size: " + m + " x " + n);
        System.out.println("  Unique paths: " + uniquePaths);
        
        // Unique Paths with Obstacles
        System.out.println("\nUnique Paths with Obstacles:");
        int[][] obstacleGrid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int uniquePathsWithObstacles = uniquePathsWithObstacles(obstacleGrid);
        System.out.println("  Grid with obstacles:");
        for (int[] row : obstacleGrid) {
            System.out.println("    " + java.util.Arrays.toString(row));
        }
        System.out.println("  Unique paths: " + uniquePathsWithObstacles);
        
        // Minimum Path Sum
        System.out.println("\nMinimum Path Sum:");
        int[][] pathGrid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        int minPathSum = minPathSum(pathGrid);
        System.out.println("  Grid:");
        for (int[] row : pathGrid) {
            System.out.println("    " + java.util.Arrays.toString(row));
        }
        System.out.println("  Minimum path sum: " + minPathSum);
        
        // Maximum Path Sum
        System.out.println("\nMaximum Path Sum:");
        int[][] maxPathGrid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int maxPathSum = maxPathSum(maxPathGrid);
        System.out.println("  Grid:");
        for (int[] row : maxPathGrid) {
            System.out.println("    " + java.util.Arrays.toString(row));
        }
        System.out.println("  Maximum path sum: " + maxPathSum);
        
        System.out.println();
    }
    
    /**
     * Demonstrates DP on trees
     */
    private static void demonstrateDPOnTrees() {
        System.out.println("4. DP on Trees:");
        System.out.println("==============");
        
        // Create a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        System.out.println("Sample Tree:");
        System.out.println("      1");
        System.out.println("     / \\");
        System.out.println("    2   3");
        System.out.println("   / \\ / \\");
        System.out.println("  4  5 6  7");
        
        // Maximum Path Sum in Binary Tree
        System.out.println("\nMaximum Path Sum in Binary Tree:");
        int maxTreePathSum = maxPathSumTree(root);
        System.out.println("  Maximum path sum: " + maxTreePathSum);
        
        // House Robber III
        System.out.println("\nHouse Robber III:");
        int maxRobbed = rob(root);
        System.out.println("  Maximum amount that can be robbed: " + maxRobbed);
        
        // Binary Tree Cameras
        System.out.println("\nBinary Tree Cameras:");
        int minCameras = minCameraCover(root);
        System.out.println("  Minimum cameras needed: " + minCameras);
        
        System.out.println();
    }
    
    /**
     * Demonstrates advanced DP problems
     */
    private static void demonstrateAdvancedDP() {
        System.out.println("5. Advanced DP Problems:");
        System.out.println("=======================");
        
        // Longest Common Substring
        System.out.println("Longest Common Substring:");
        String substr1 = "ABCDGH";
        String substr2 = "ACDGHR";
        int lcSubstrLength = longestCommonSubstring(substr1, substr2);
        System.out.println("  String 1: \"" + substr1 + "\"");
        System.out.println("  String 2: \"" + substr2 + "\"");
        System.out.println("  Longest common substring length: " + lcSubstrLength);
        
        // Longest Increasing Path in Matrix
        System.out.println("\nLongest Increasing Path in Matrix:");
        int[][] matrix = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };
        int longestPath = longestIncreasingPath(matrix);
        System.out.println("  Matrix:");
        for (int[] row : matrix) {
            System.out.println("    " + java.util.Arrays.toString(row));
        }
        System.out.println("  Longest increasing path: " + longestPath);
        
        // Regular Expression Matching
        System.out.println("\nRegular Expression Matching:");
        String[][] regexTests = {{"aa", "a"}, {"aa", "a*"}, {"ab", ".*"}, {"aab", "c*a*b"}};
        for (String[] test : regexTests) {
            boolean matches = isMatch(test[0], test[1]);
            System.out.println("  \"" + test[0] + "\" matches \"" + test[1] + "\": " + matches);
        }
        
        // Wildcard Matching
        System.out.println("\nWildcard Matching:");
        String[][] wildcardTests = {{"aa", "a"}, {"aa", "*"}, {"cb", "?a"}, {"adceb", "*a*b"}};
        for (String[] test : wildcardTests) {
            boolean matches = isMatchWildcard(test[0], test[1]);
            System.out.println("  \"" + test[0] + "\" matches \"" + test[1] + "\": " + matches);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance analysis
     */
    private static void demonstratePerformanceAnalysis() {
        System.out.println("6. Performance Analysis:");
        System.out.println("=======================");
        
        System.out.println("Dynamic Programming Complexity:");
        System.out.println("------------------------------");
        System.out.println("DP on Arrays:");
        System.out.println("  LIS:                O(n²) time, O(n) space");
        System.out.println("  Kadane's:           O(n) time, O(1) space");
        System.out.println("  Subset Sum:         O(n * sum) time, O(n * sum) space");
        System.out.println("  Knapsack:           O(n * W) time, O(n * W) space");
        System.out.println("  Coin Change:        O(amount * coins) time, O(amount) space");
        
        System.out.println("\nDP on Strings:");
        System.out.println("  LCS:                O(m * n) time, O(m * n) space");
        System.out.println("  Edit Distance:      O(m * n) time, O(m * n) space");
        System.out.println("  LPS:                O(n²) time, O(n²) space");
        System.out.println("  Word Break:         O(n²) time, O(n) space");
        
        System.out.println("\nDP on Grids:");
        System.out.println("  Unique Paths:       O(m * n) time, O(m * n) space");
        System.out.println("  Min Path Sum:       O(m * n) time, O(m * n) space");
        System.out.println("  Max Path Sum:       O(m * n) time, O(m * n) space");
        
        System.out.println("\nDP on Trees:");
        System.out.println("  Max Path Sum:       O(n) time, O(h) space");
        System.out.println("  House Robber:       O(n) time, O(h) space");
        System.out.println("  Camera Cover:       O(n) time, O(h) space");
        
        System.out.println("\nSpace Optimization:");
        System.out.println("  Rolling Array:      Reduces space by factor of 2");
        System.out.println("  State Compression:  Reduces space using bit manipulation");
        System.out.println("  Memoization:        O(n) space for recursive calls");
        
        System.out.println();
    }
    
    // TreeNode Definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    // DP on Arrays Implementation
    
    /**
     * Longest Increasing Subsequence
     * Time Complexity: O(n²), Space Complexity: O(n)
     */
    public static int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, 1);
        
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
    
    /**
     * Kadane's Algorithm
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int kadanesAlgorithm(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
    
    /**
     * Subset Sum Problem
     * Time Complexity: O(n * sum), Space Complexity: O(n * sum)
     */
    public static boolean subsetSum(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        
        // Base case: sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        
        return dp[n][target];
    }
    
    /**
     * 0/1 Knapsack Problem
     * Time Complexity: O(n * W), Space Complexity: O(n * W)
     */
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], 
                                       dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        return dp[n][capacity];
    }
    
    /**
     * Coin Change Problem
     * Time Complexity: O(amount * coins), Space Complexity: O(amount)
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        java.util.Arrays.fill(dp, amount + 1);
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
    
    // DP on Strings Implementation
    
    /**
     * Longest Common Subsequence
     * Time Complexity: O(m * n), Space Complexity: O(m * n)
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
     * Edit Distance
     * Time Complexity: O(m * n), Space Complexity: O(m * n)
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
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], 
                                           Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        
        return dp[m][n];
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
    
    /**
     * Minimum Cut for Palindrome Partitioning
     * Time Complexity: O(n²), Space Complexity: O(n²)
     */
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] cuts = new int[n];
        
        for (int i = 0; i < n; i++) {
            int minCuts = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                    minCuts = j == 0 ? 0 : Math.min(minCuts, cuts[j - 1] + 1);
                }
            }
            cuts[i] = minCuts;
        }
        
        return cuts[n - 1];
    }
    
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
    
    // DP on Grids Implementation
    
    /**
     * Unique Paths
     * Time Complexity: O(m * n), Space Complexity: O(m * n)
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    /**
     * Unique Paths with Obstacles
     * Time Complexity: O(m * n), Space Complexity: O(m * n)
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 1) ? 0 : dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 1) ? 0 : dp[0][j - 1];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    /**
     * Minimum Path Sum
     * Time Complexity: O(m * n), Space Complexity: O(m * n)
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        dp[0][0] = grid[0][0];
        
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    /**
     * Maximum Path Sum
     * Time Complexity: O(m * n), Space Complexity: O(m * n)
     */
    public static int maxPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        dp[0][0] = grid[0][0];
        
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    // DP on Trees Implementation
    
    /**
     * Maximum Path Sum in Binary Tree
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static int maxPathSumTree(TreeNode root) {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        maxPathSumTreeHelper(root, maxSum);
        return maxSum[0];
    }
    
    private static int maxPathSumTreeHelper(TreeNode root, int[] maxSum) {
        if (root == null) return 0;
        
        int leftSum = Math.max(0, maxPathSumTreeHelper(root.left, maxSum));
        int rightSum = Math.max(0, maxPathSumTreeHelper(root.right, maxSum));
        
        maxSum[0] = Math.max(maxSum[0], root.val + leftSum + rightSum);
        
        return root.val + Math.max(leftSum, rightSum);
    }
    
    /**
     * House Robber III
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }
    
    private static int[] robHelper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        
        int rob = root.val + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[]{rob, notRob};
    }
    
    /**
     * Binary Tree Cameras
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static int minCameraCover(TreeNode root) {
        int[] result = minCameraCoverHelper(root);
        return Math.min(result[1], result[2]);
    }
    
    private static int[] minCameraCoverHelper(TreeNode root) {
        if (root == null) return new int[]{0, 0, 99999};
        
        int[] left = minCameraCoverHelper(root.left);
        int[] right = minCameraCoverHelper(root.right);
        
        int minLeft = Math.min(left[1], left[2]);
        int minRight = Math.min(right[1], right[2]);
        
        int d0 = left[1] + right[1];
        int d1 = Math.min(left[2] + minRight, right[2] + minLeft);
        int d2 = 1 + Math.min(left[0], minLeft) + Math.min(right[0], minRight);
        
        return new int[]{d0, d1, d2};
    }
    
    // Advanced DP Implementation
    
    /**
     * Longest Common Substring
     * Time Complexity: O(m * n), Space Complexity: O(m * n)
     */
    public static int longestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return maxLength;
    }
    
    /**
     * Longest Increasing Path in Matrix
     * Time Complexity: O(m * n), Space Complexity: O(m * n)
     */
    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLength = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, i, j, dp));
            }
        }
        
        return maxLength;
    }
    
    private static int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int maxLength = 1;
        
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && 
                matrix[x][y] > matrix[i][j]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, x, y, dp));
            }
        }
        
        dp[i][j] = maxLength;
        return maxLength;
    }
    
    /**
     * Regular Expression Matching
     * Time Complexity: O(m * n), Space Complexity: O(m * n)
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || 
                               (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && 
                               (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        
        return dp[m][n];
    }
    
    /**
     * Wildcard Matching
     * Time Complexity: O(m * n), Space Complexity: O(m * n)
     */
    public static boolean isMatchWildcard(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
