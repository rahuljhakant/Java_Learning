package Backtracking;

import java.util.*;

/**
 * Backtracking Problems - Comprehensive Solutions
 * 
 * This class contains solutions to fundamental backtracking problems including:
 * - Subset generation (all subsets, subsets with duplicates)
 * - Permutation problems (all permutations, next permutation)
 * - Combination problems (combination sum, letter combinations)
 * - String problems (generate parentheses, letter case permutation)
 * - Matrix problems (word search, n-queens, sudoku solver)
 * - Path problems (unique paths, robot room cleaner)
 * 
 * Each problem includes detailed comments on approach, time and space complexity.
 */
public class BacktrackingProblems {

    // ==================== SUBSET PROBLEMS ====================

    /**
     * Problem: Subsets
     * Given an integer array nums of unique elements, return all possible subsets (the power set).
     * 
     * Approach: Backtracking - choose or not choose each element
     * Time Complexity: O(2^n * n) - 2^n subsets, each takes O(n) to copy
     * Space Complexity: O(2^n * n)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrackSubsets(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add current subset
        
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);           // Choose
            backtrackSubsets(nums, i + 1, current, result); // Explore
            current.remove(current.size() - 1); // Unchoose
        }
    }

    /**
     * Problem: Subsets II
     * Given an integer array nums that may contain duplicates, return all possible subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        backtrackSubsetsWithDup(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrackSubsetsWithDup(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at same level
            if (i > start && nums[i] == nums[i - 1]) continue;
            
            current.add(nums[i]);
            backtrackSubsetsWithDup(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    // ==================== PERMUTATION PROBLEMS ====================

    /**
     * Problem: Permutations
     * Given an array nums of distinct integers, return all the possible permutations.
     * 
     * Approach: Backtracking - try each remaining element at current position
     * Time Complexity: O(n! * n)
     * Space Complexity: O(n! * n)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackPermute(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }
    
    private void backtrackPermute(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                backtrackPermute(nums, current, used, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    /**
     * Problem: Permutations II
     * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrackPermuteUnique(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }
    
    private void backtrackPermuteUnique(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            
            // Skip duplicates: if current element is same as previous and previous is not used
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            
            used[i] = true;
            current.add(nums[i]);
            backtrackPermuteUnique(nums, current, used, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    /**
     * Problem: Next Permutation
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation.
     * 
     * Approach: Find the rightmost smaller element, then swap and reverse
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        // Find the rightmost smaller element
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            // Find the smallest element greater than nums[i]
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        
        // Reverse the suffix
        reverse(nums, i + 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    // ==================== COMBINATION PROBLEMS ====================

    /**
     * Problem: Combinations
     * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackCombine(n, k, 1, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrackCombine(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrackCombine(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    /**
     * Problem: Combination Sum
     * Given an array of distinct integers candidates and a target integer target,
     * return a list of all unique combinations of candidates where the chosen numbers sum to target.
     * 
     * Approach: Backtracking with pruning
     * Time Complexity: O(2^target) in worst case
     * Space Complexity: O(target)
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackCombinationSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrackCombinationSum(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                backtrackCombinationSum(candidates, target - candidates[i], i, current, result); // i, not i+1 (can reuse)
                current.remove(current.size() - 1);
            }
        }
    }

    /**
     * Problem: Combination Sum II
     * Each number in candidates may only be used once in the combination.
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrackCombinationSum2(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrackCombinationSum2(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break; // Pruning
            
            // Skip duplicates at same level
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            
            current.add(candidates[i]);
            backtrackCombinationSum2(candidates, target - candidates[i], i + 1, current, result); // i+1 (cannot reuse)
            current.remove(current.size() - 1);
        }
    }

    /**
     * Problem: Letter Combinations of a Phone Number
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations.
     */
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        
        String[] phoneMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        backtrackLetterCombinations(digits, 0, new StringBuilder(), phoneMap, result);
        return result;
    }
    
    private void backtrackLetterCombinations(String digits, int index, StringBuilder current, String[] phoneMap, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        String letters = phoneMap[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrackLetterCombinations(digits, index + 1, current, phoneMap, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    // ==================== STRING PROBLEMS ====================

    /**
     * Problem: Generate Parentheses
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * 
     * Approach: Backtracking with constraints (open < n, close < open)
     * Time Complexity: O(4^n / sqrt(n)) - Catalan number
     * Space Complexity: O(4^n / sqrt(n))
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrackParentheses(n, 0, 0, new StringBuilder(), result);
        return result;
    }
    
    private void backtrackParentheses(int n, int open, int close, StringBuilder current, List<String> result) {
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }
        
        if (open < n) {
            current.append('(');
            backtrackParentheses(n, open + 1, close, current, result);
            current.deleteCharAt(current.length() - 1);
        }
        
        if (close < open) {
            current.append(')');
            backtrackParentheses(n, open, close + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    /**
     * Problem: Letter Case Permutation
     * Given a string s, we can transform every letter individually to be lowercase or uppercase.
     * Return a list of all possible strings we could create.
     */
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrackLetterCase(s, 0, new StringBuilder(), result);
        return result;
    }
    
    private void backtrackLetterCase(String s, int index, StringBuilder current, List<String> result) {
        if (index == s.length()) {
            result.add(current.toString());
            return;
        }
        
        char c = s.charAt(index);
        
        if (Character.isLetter(c)) {
            // Try lowercase
            current.append(Character.toLowerCase(c));
            backtrackLetterCase(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
            
            // Try uppercase
            current.append(Character.toUpperCase(c));
            backtrackLetterCase(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        } else {
            // Digit or special character
            current.append(c);
            backtrackLetterCase(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    // ==================== MATRIX PROBLEMS ====================

    /**
     * Problem: Word Search
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     * 
     * Approach: DFS with backtracking
     * Time Complexity: O(m * n * 4^L) where L is word length
     * Space Complexity: O(L) for recursion stack
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfsWordSearch(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfsWordSearch(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) return true;
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
            || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        char temp = board[row][col];
        board[row][col] = '#'; // Mark as visited
        
        boolean found = dfsWordSearch(board, word, index + 1, row + 1, col) ||
                       dfsWordSearch(board, word, index + 1, row - 1, col) ||
                       dfsWordSearch(board, word, index + 1, row, col + 1) ||
                       dfsWordSearch(board, word, index + 1, row, col - 1);
        
        board[row][col] = temp; // Restore
        return found;
    }

    /**
     * Problem: N-Queens
     * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n]; // queens[i] = column position of queen in row i
        backtrackNQueens(queens, 0, result);
        return result;
    }
    
    private void backtrackNQueens(int[] queens, int row, List<List<String>> result) {
        if (row == queens.length) {
            result.add(buildBoard(queens));
            return;
        }
        
        for (int col = 0; col < queens.length; col++) {
            if (isValidQueen(queens, row, col)) {
                queens[row] = col;
                backtrackNQueens(queens, row + 1, result);
            }
        }
    }
    
    private boolean isValidQueen(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            // Check column and diagonals
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
    
    private List<String> buildBoard(int[] queens) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                row.append(queens[i] == j ? 'Q' : '.');
            }
            board.add(row.toString());
        }
        return board;
    }

    /**
     * Problem: Sudoku Solver
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     */
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
    
    private boolean solveSudokuHelper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidSudoku(board, i, j, c)) {
                            board[i][j] = c;
                            
                            if (solveSudokuHelper(board)) {
                                return true;
                            }
                            
                            board[i][j] = '.'; // Backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValidSudoku(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == c) return false;
            // Check column
            if (board[i][col] == c) return false;
            // Check 3x3 box
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }

    // ==================== PATH PROBLEMS ====================

    /**
     * Problem: Unique Paths III
     * On a 2-dimensional grid, there are 4 types of squares: 1 (starting square), 2 (ending square), 0 (empty squares), and -1 (obstacles).
     * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
     */
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int startX = 0, startY = 0, emptyCells = 0;
        
        // Find start position and count empty cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    emptyCells++;
                }
            }
        }
        
        return dfsUniquePaths(grid, startX, startY, emptyCells + 1); // +1 for starting cell
    }
    
    private int dfsUniquePaths(int[][] grid, int x, int y, int emptyCells) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        
        if (grid[x][y] == 2) {
            return emptyCells == 0 ? 1 : 0;
        }
        
        grid[x][y] = -1; // Mark as visited
        int paths = dfsUniquePaths(grid, x + 1, y, emptyCells - 1) +
                   dfsUniquePaths(grid, x - 1, y, emptyCells - 1) +
                   dfsUniquePaths(grid, x, y + 1, emptyCells - 1) +
                   dfsUniquePaths(grid, x, y - 1, emptyCells - 1);
        grid[x][y] = 0; // Restore
        
        return paths;
    }

    // ==================== DEMONSTRATION METHODS ====================

    /**
     * Demonstrate all backtracking problems
     */
    public static void demonstrateAllProblems() {
        System.out.println("=== Backtracking Problems Demonstration ===\n");
        
        BacktrackingProblems bt = new BacktrackingProblems();
        
        // Subsets
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = bt.subsets(nums);
        System.out.println("Subsets: " + subsets);
        
        // Permutations
        List<List<Integer>> permutations = bt.permute(nums);
        System.out.println("Permutations: " + permutations);
        
        // Combinations
        List<List<Integer>> combinations = bt.combine(4, 2);
        System.out.println("Combinations C(4,2): " + combinations);
        
        // Generate Parentheses
        List<String> parentheses = bt.generateParenthesis(3);
        System.out.println("Generate Parentheses (n=3): " + parentheses);
        
        // Letter Combinations
        List<String> letters = bt.letterCombinations("23");
        System.out.println("Letter Combinations '23': " + letters);
        
        System.out.println("\n=== Backtracking Problems Completed ===");
    }

    public static void main(String[] args) {
        demonstrateAllProblems();
    }
}
