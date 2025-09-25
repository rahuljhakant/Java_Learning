package Miscellaneous;

import java.util.*;

/**
 * Miscellaneous Problems - Comprehensive Solutions
 * 
 * This class contains solutions to miscellaneous problems including:
 * - Array manipulation (shuffle, rotate, spiral)
 * - Matrix operations (rotate image, set zeros, search 2D)
 * - Number theory (reverse integer, palindrome number)
 * - String manipulation (reverse string, valid parentheses)
 * - Design problems (LRU cache, min stack, design parking lot)
 * - Math problems (power of two, missing number, single number)
 * - Bit manipulation (hamming distance, counting bits)
 * - System design concepts
 * 
 * Each problem includes detailed comments on approach, time and space complexity.
 */
public class MiscellaneousProblems {

    // ==================== ARRAY MANIPULATION ====================

    /**
     * Problem: Shuffle an Array
     * Given an integer array nums, design an algorithm to randomly shuffle the array.
     * 
     * Approach: Fisher-Yates shuffle algorithm
     * Time Complexity: O(n)
     * Space Complexity: O(n) for original array
     */
    static class ShuffleArray {
        private int[] original;
        private Random random;
        
        public ShuffleArray(int[] nums) {
            original = nums.clone();
            random = new Random();
        }
        
        public int[] reset() {
            return original.clone();
        }
        
        public int[] shuffle() {
            int[] shuffled = original.clone();
            
            for (int i = shuffled.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                swap(shuffled, i, j);
            }
            
            return shuffled;
        }
        
        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    /**
     * Problem: Rotate Array
     * Given an array, rotate the array to the right by k steps, where k is non-negative.
     * 
     * Approach: Reverse array in parts
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle k > n
        
        reverse(nums, 0, n - 1);     // Reverse entire array
        reverse(nums, 0, k - 1);     // Reverse first k elements
        reverse(nums, k, n - 1);     // Reverse remaining elements
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Problem: Spiral Matrix
     * Given an m x n matrix, return all elements of the matrix in spiral order.
     * 
     * Approach: Traverse in layers (top, right, bottom, left)
     * Time Complexity: O(m * n)
     * Space Complexity: O(1)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse top row
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            
            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // Traverse bottom row (if exists)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }
            
            // Traverse left column (if exists)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }

    /**
     * Problem: Spiral Matrix II
     * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n² in spiral order.
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;
        
        while (top <= bottom && left <= right) {
            // Fill top row
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num++;
            }
            top++;
            
            // Fill right column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            
            // Fill bottom row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = num++;
                }
                bottom--;
            }
            
            // Fill left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        
        return matrix;
    }

    // ==================== MATRIX OPERATIONS ====================

    /**
     * Problem: Rotate Image
     * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
     * 
     * Approach: Transpose then reverse rows
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public void rotateImage(int[][] matrix) {
        int n = matrix.length;
        
        // Transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    /**
     * Problem: Set Matrix Zeroes
     * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
     * 
     * Approach: Use first row and column as markers, with separate flags for them
     * Time Complexity: O(m * n)
     * Space Complexity: O(1)
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        // Check if first row has zero
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        // Check if first column has zero
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        
        // Use first row and column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // Set zeros based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Handle first row
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // Handle first column
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * Problem: Game of Life
     * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton."
     * Given the current state of the m x n grid board, return the next state.
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        // Directions: 8 neighbors
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;
                
                // Count live neighbors
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && 
                        (board[ni][nj] == 1 || board[ni][nj] == -1)) {
                        liveNeighbors++;
                    }
                }
                
                // Apply rules
                if (board[i][j] == 1) {
                    // Live cell
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = -1; // Will die
                    }
                } else {
                    // Dead cell
                    if (liveNeighbors == 3) {
                        board[i][j] = 2; // Will live
                    }
                }
            }
        }
        
        // Update board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    // ==================== NUMBER THEORY ====================

    /**
     * Problem: Reverse Integer
     * Given a signed 32-bit integer x, return x with its digits reversed.
     * 
     * Approach: Handle overflow while reversing
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int reverse(int x) {
        int result = 0;
        
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            
            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || 
                (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            
            result = result * 10 + digit;
        }
        
        return result;
    }

    /**
     * Problem: Palindrome Number
     * Given an integer x, return true if x is a palindrome integer.
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        
        return x == reversed || x == reversed / 10;
    }

    /**
     * Problem: Power of Two
     * Given an integer n, return true if it is a power of two. Otherwise, return false.
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * Problem: Missing Number
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }

    /**
     * Problem: Single Number
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operation
        }
        return result;
    }

    // ==================== STRING MANIPULATION ====================

    /**
     * Problem: Reverse String
     * Write a function that reverses a string. The input string is given as an array of characters s.
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Problem: Valid Parentheses
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    /**
     * Problem: Valid Anagram
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     */
    public boolean isAnagram(String s, String t) {
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

    // ==================== DESIGN PROBLEMS ====================

    /**
     * Problem: Min Stack
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     */
    static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }
        
        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }
        
        public void pop() {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return minStack.peek();
        }
    }

    /**
     * Problem: Design Parking Lot
     * Design a parking lot system with different types of vehicles and spots.
     */
    enum VehicleType {
        MOTORCYCLE, CAR, BUS
    }
    
    enum SpotType {
        COMPACT, LARGE
    }
    
    static class Vehicle {
        VehicleType type;
        String licensePlate;
        
        Vehicle(VehicleType type, String licensePlate) {
            this.type = type;
            this.licensePlate = licensePlate;
        }
    }
    
    static class ParkingSpot {
        int id;
        SpotType type;
        boolean isOccupied;
        Vehicle vehicle;
        
        ParkingSpot(int id, SpotType type) {
            this.id = id;
            this.type = type;
            this.isOccupied = false;
        }
    }
    
    static class ParkingLot {
        private List<ParkingSpot> spots;
        private Map<String, ParkingSpot> vehicleToSpot;
        
        public ParkingLot(int compactSpots, int largeSpots) {
            spots = new ArrayList<>();
            vehicleToSpot = new HashMap<>();
            
            for (int i = 0; i < compactSpots; i++) {
                spots.add(new ParkingSpot(i, SpotType.COMPACT));
            }
            for (int i = compactSpots; i < compactSpots + largeSpots; i++) {
                spots.add(new ParkingSpot(i, SpotType.LARGE));
            }
        }
        
        public boolean parkVehicle(Vehicle vehicle) {
            for (ParkingSpot spot : spots) {
                if (!spot.isOccupied && canFit(vehicle, spot)) {
                    spot.isOccupied = true;
                    spot.vehicle = vehicle;
                    vehicleToSpot.put(vehicle.licensePlate, spot);
                    return true;
                }
            }
            return false;
        }
        
        public boolean unparkVehicle(String licensePlate) {
            ParkingSpot spot = vehicleToSpot.get(licensePlate);
            if (spot != null) {
                spot.isOccupied = false;
                spot.vehicle = null;
                vehicleToSpot.remove(licensePlate);
                return true;
            }
            return false;
        }
        
        private boolean canFit(Vehicle vehicle, ParkingSpot spot) {
            if (vehicle.type == VehicleType.MOTORCYCLE) {
                return true; // Can fit in any spot
            } else if (vehicle.type == VehicleType.CAR) {
                return spot.type == SpotType.COMPACT || spot.type == SpotType.LARGE;
            } else { // BUS
                return spot.type == SpotType.LARGE;
            }
        }
    }

    // ==================== BIT MANIPULATION ====================

    /**
     * Problem: Hamming Distance
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     */
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        
        while (xor != 0) {
            distance += xor & 1;
            xor >>= 1;
        }
        
        return distance;
    }

    /**
     * Problem: Counting Bits
     * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
     * ans[i] is the number of 1's in the binary representation of i.
     */
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        
        return result;
    }

    /**
     * Problem: Single Number II
     * Given an integer array nums where every element appears three times except for one,
     * which appears exactly once. Find the single element.
     */
    public int singleNumberII(int[] nums) {
        int ones = 0, twos = 0;
        
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        
        return ones;
    }

    // ==================== DEMONSTRATION METHODS ====================

    /**
     * Demonstrate all miscellaneous problems
     */
    public static void demonstrateAllProblems() {
        System.out.println("=== Miscellaneous Problems Demonstration ===\n");
        
        MiscellaneousProblems mp = new MiscellaneousProblems();
        
        // Rotate Array
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        mp.rotate(nums, 3);
        System.out.println("Rotated Array: " + Arrays.toString(nums));
        
        // Reverse Integer
        int reversed = mp.reverse(123);
        System.out.println("Reverse Integer 123: " + reversed);
        
        // Palindrome Number
        boolean isPal = mp.isPalindrome(121);
        System.out.println("Is Palindrome 121: " + isPal);
        
        // Power of Two
        boolean isPower = mp.isPowerOfTwo(16);
        System.out.println("Is Power of Two 16: " + isPower);
        
        // Missing Number
        int[] missingNums = {3, 0, 1};
        int missing = mp.missingNumber(missingNums);
        System.out.println("Missing Number: " + missing);
        
        // Single Number
        int[] singleNums = {2, 2, 1};
        int single = mp.singleNumber(singleNums);
        System.out.println("Single Number: " + single);
        
        // Valid Parentheses
        boolean valid = mp.isValid("()[]{}");
        System.out.println("Valid Parentheses: " + valid);
        
        // Hamming Distance
        int hamming = mp.hammingDistance(1, 4);
        System.out.println("Hamming Distance (1, 4): " + hamming);
        
        // Counting Bits
        int[] bits = mp.countBits(5);
        System.out.println("Counting Bits: " + Arrays.toString(bits));
        
        // Min Stack Demo
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Min Stack - Min: " + minStack.getMin());
        minStack.pop();
        System.out.println("Min Stack - Top: " + minStack.top());
        System.out.println("Min Stack - Min: " + minStack.getMin());
        
        // Parking Lot Demo
        ParkingLot parkingLot = new ParkingLot(2, 2);
        Vehicle car = new Vehicle(VehicleType.CAR, "ABC123");
        boolean parked = parkingLot.parkVehicle(car);
        System.out.println("Car Parked: " + parked);
        
        System.out.println("\n=== Miscellaneous Problems Completed ===");
    }

    public static void main(String[] args) {
        demonstrateAllProblems();
    }
}
