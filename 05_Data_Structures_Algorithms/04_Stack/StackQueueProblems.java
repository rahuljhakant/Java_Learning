package com.tutorial.datastructures.stack;

import java.util.*;

/**
 * Stack & Queue Problems - Comprehensive Solutions
 * 
 * This comprehensive implementation covers all essential stack and queue problems
 * commonly asked in technical interviews. Each solution includes detailed explanations,
 * time/space complexity analysis, and multiple approaches where applicable.
 * 
 * PROBLEMS COVERED:
 * 1. Implement Queue using Stacks (Easy) - Implement FIFO using two stacks
 * 2. Implement Stack using Queues (Easy) - Implement LIFO using two queues
 * 3. Min Stack (Medium) - Design a stack that supports getMin() in O(1)
 * 4. Evaluate Reverse Polish Notation (Medium) - Evaluate postfix expression
 * 5. Decode String (Medium) - Decode a string like "3[a2[c]]" to "accaccacc"
 * 6. LRU Cache (Medium) - Design a Least Recently Used cache
 * 7. Valid Parentheses (Easy) - Check if brackets are balanced using stack
 * 8. Daily Temperatures (Medium) - Find next warmer day for each day
 * 9. Next Greater Element (Easy) - Find next greater element for each element
 * 10. Largest Rectangle in Histogram (Hard) - Find largest rectangle area
 * 11. Basic Calculator (Hard) - Evaluate basic arithmetic expressions
 * 12. Remove Duplicate Letters (Medium) - Remove duplicates maintaining lexicographical order
 * 13. Simplify Path (Medium) - Simplify Unix-style file path
 * 14. Asteroid Collision (Medium) - Simulate asteroid collisions
 * 15. Score of Parentheses (Medium) - Calculate score of balanced parentheses
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class StackQueueProblems {

    public static void main(String[] args) {
        System.out.println("=== Stack & Queue Problems ===");
        System.out.println();
        
        // Run all problem demonstrations
        demonstrateQueueUsingStacks();
        demonstrateStackUsingQueues();
        demonstrateMinStack();
        demonstrateEvaluateRPN();
        demonstrateDecodeString();
        demonstrateLRUCache();
        demonstrateValidParentheses();
        demonstrateDailyTemperatures();
        demonstrateNextGreaterElement();
        demonstrateLargestRectangleInHistogram();
        demonstrateBasicCalculator();
        demonstrateRemoveDuplicateLetters();
        demonstrateSimplifyPath();
        demonstrateAsteroidCollision();
        demonstrateScoreOfParentheses();
    }

    /**
     * 1. Implement Queue using Stacks (Easy)
     * Implement FIFO using two stacks
     * Time: O(1) amortized, Space: O(n)
     */
    public static void demonstrateQueueUsingStacks() {
        System.out.println("1. Implement Queue using Stacks (Easy):");
        System.out.println("======================================");
        
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        
        System.out.println("After pushing 1, 2, 3:");
        System.out.println("Peek: " + queue.peek());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Empty: " + queue.empty());
        
        System.out.println("Time: O(1) amortized, Space: O(n)");
        System.out.println();
    }

    static class MyQueue {
        private Stack<Integer> input;
        private Stack<Integer> output;
        
        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }
        
        public void push(int x) {
            input.push(x);
        }
        
        public int pop() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.pop();
        }
        
        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }
        
        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }

    /**
     * 2. Implement Stack using Queues (Easy)
     * Implement LIFO using two queues
     * Time: O(n) push, O(1) pop, Space: O(n)
     */
    public static void demonstrateStackUsingQueues() {
        System.out.println("2. Implement Stack using Queues (Easy):");
        System.out.println("======================================");
        
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("After pushing 1, 2, 3:");
        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Empty: " + stack.empty());
        
        System.out.println("Time: O(n) push, O(1) pop, Space: O(n)");
        System.out.println();
    }

    static class MyStack {
        private Queue<Integer> queue;
        
        public MyStack() {
            queue = new LinkedList<>();
        }
        
        public void push(int x) {
            queue.offer(x);
            int size = queue.size();
            // Rotate queue to make the last element first
            for (int i = 0; i < size - 1; i++) {
                queue.offer(queue.poll());
            }
        }
        
        public int pop() {
            return queue.poll();
        }
        
        public int top() {
            return queue.peek();
        }
        
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    /**
     * 3. Min Stack (Medium)
     * Design a stack that supports getMin() in O(1)
     * Time: O(1) all operations, Space: O(n)
     */
    public static void demonstrateMinStack() {
        System.out.println("3. Min Stack (Medium):");
        System.out.println("=====================");
        
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        
        System.out.println("After pushing -2, 0, -3:");
        System.out.println("Min: " + minStack.getMin());
        
        minStack.pop();
        System.out.println("After popping:");
        System.out.println("Top: " + minStack.top());
        System.out.println("Min: " + minStack.getMin());
        
        System.out.println("Time: O(1) all operations, Space: O(n)");
        System.out.println();
    }

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
            if (stack.isEmpty()) return;
            
            int val = stack.pop();
            if (val == minStack.peek()) {
                minStack.pop();
            }
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return minStack.peek();
        }
    }

    /**
     * 4. Evaluate Reverse Polish Notation (Medium)
     * Evaluate postfix expression
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateEvaluateRPN() {
        System.out.println("4. Evaluate Reverse Polish Notation (Medium):");
        System.out.println("============================================");
        
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        
        System.out.println("Tokens: " + Arrays.toString(tokens1));
        System.out.println("Result: " + evalRPN(tokens1));
        
        System.out.println("Tokens: " + Arrays.toString(tokens2));
        System.out.println("Result: " + evalRPN(tokens2));
        
        System.out.println("Tokens: " + Arrays.toString(tokens3));
        System.out.println("Result: " + evalRPN(tokens3));
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = performOperation(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/");
    }

    private static int performOperation(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    /**
     * 5. Decode String (Medium)
     * Decode a string like "3[a2[c]]" to "accaccacc"
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateDecodeString() {
        System.out.println("5. Decode String (Medium):");
        System.out.println("==========================");
        
        String[] testCases = {
            "3[a]2[bc]",
            "2[abc]3[cd]ef",
            "abc3[cd]xyz",
            "3[a2[c]]",
            "2[2[y]pq4[2[jk]e1[f]]]"
        };
        
        for (String testCase : testCases) {
            String decoded = decodeString(testCase);
            System.out.println("Input: \"" + testCase + "\"");
            System.out.println("Output: \"" + decoded + "\"");
            System.out.println();
        }
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int currentNumber = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(currentNumber);
                stringStack.push(currentString);
                currentNumber = 0;
                currentString = "";
            } else if (c == ']') {
                int count = countStack.pop();
                String previousString = stringStack.pop();
                currentString = previousString + currentString.repeat(count);
            } else {
                currentString += c;
            }
        }
        
        return currentString;
    }

    /**
     * 6. LRU Cache (Medium)
     * Design a Least Recently Used cache
     * Time: O(1) get and put, Space: O(capacity)
     */
    public static void demonstrateLRUCache() {
        System.out.println("6. LRU Cache (Medium):");
        System.out.println("=====================");
        
        LRUCache cache = new LRUCache(2);
        
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("After putting (1,1) and (2,2):");
        System.out.println("Get 1: " + cache.get(1));
        
        cache.put(3, 3); // evicts key 2
        System.out.println("After putting (3,3):");
        System.out.println("Get 2: " + cache.get(2)); // returns -1 (not found)
        
        cache.put(4, 4); // evicts key 1
        System.out.println("After putting (4,4):");
        System.out.println("Get 1: " + cache.get(1)); // returns -1 (not found)
        System.out.println("Get 3: " + cache.get(3));
        System.out.println("Get 4: " + cache.get(4));
        
        System.out.println("Time: O(1) get and put, Space: O(capacity)");
        System.out.println();
    }

    static class LRUCache {
        private Map<Integer, Node> cache;
        private Node head;
        private Node tail;
        private int capacity;
        
        static class Node {
            int key;
            int value;
            Node prev;
            Node next;
            
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        
        public int get(int key) {
            Node node = cache.get(key);
            if (node != null) {
                moveToHead(node);
                return node.value;
            }
            return -1;
        }
        
        public void put(int key, int value) {
            Node node = cache.get(key);
            
            if (node != null) {
                node.value = value;
                moveToHead(node);
            } else {
                Node newNode = new Node(key, value);
                
                if (cache.size() >= capacity) {
                    Node tail = removeTail();
                    cache.remove(tail.key);
                }
                
                cache.put(key, newNode);
                addToHead(newNode);
            }
        }
        
        private void addToHead(Node node) {
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
            addToHead(node);
        }
        
        private Node removeTail() {
            Node lastNode = tail.prev;
            removeNode(lastNode);
            return lastNode;
        }
    }

    /**
     * 7. Valid Parentheses (Easy)
     * Check if brackets are balanced using stack
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateValidParentheses() {
        System.out.println("7. Valid Parentheses (Easy):");
        System.out.println("============================");
        
        String[] testCases = {"()", "()[]{}", "(]", "([)]", "{[]}", "((()))", ""};
        
        for (String testCase : testCases) {
            boolean isValid = isValid(testCase);
            System.out.println("\"" + testCase + "\" -> " + isValid);
        }
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
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
     * 8. Daily Temperatures (Medium)
     * Find next warmer day for each day
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateDailyTemperatures() {
        System.out.println("8. Daily Temperatures (Medium):");
        System.out.println("===============================");
        
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Temperatures: " + Arrays.toString(temperatures));
        
        int[] result = dailyTemperatures(temperatures);
        System.out.println("Days to wait: " + Arrays.toString(result));
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        
        return result;
    }

    /**
     * 9. Next Greater Element (Easy)
     * Find next greater element for each element
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateNextGreaterElement() {
        System.out.println("9. Next Greater Element (Easy):");
        System.out.println("===============================");
        
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        
        int[] result = nextGreaterElement(nums1, nums2);
        System.out.println("Next greater elements: " + Arrays.toString(result));
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.getOrDefault(nums1[i], -1);
        }
        
        return result;
    }

    /**
     * 10. Largest Rectangle in Histogram (Hard)
     * Find largest rectangle area
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateLargestRectangleInHistogram() {
        System.out.println("10. Largest Rectangle in Histogram (Hard):");
        System.out.println("=========================================");
        
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Heights: " + Arrays.toString(heights));
        
        int maxArea = largestRectangleArea(heights);
        System.out.println("Maximum area: " + maxArea);
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }

    /**
     * 11. Basic Calculator (Hard)
     * Evaluate basic arithmetic expressions
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateBasicCalculator() {
        System.out.println("11. Basic Calculator (Hard):");
        System.out.println("============================");
        
        String[] expressions = {
            "1 + 1",
            "2-1 + 2",
            "(1+(4+5+2)-3)+(6+8)",
            "1-(     -2)"
        };
        
        for (String expr : expressions) {
            int result = calculate(expr);
            System.out.println("\"" + expr + "\" = " + result);
        }
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // sign
                result += stack.pop(); // previous result
            }
        }
        
        return result + sign * number;
    }

    /**
     * 12. Remove Duplicate Letters (Medium)
     * Remove duplicates maintaining lexicographical order
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateRemoveDuplicateLetters() {
        System.out.println("12. Remove Duplicate Letters (Medium):");
        System.out.println("=====================================");
        
        String[] testCases = {"bcabc", "cbacdcbc", "abacaba"};
        
        for (String testCase : testCases) {
            String result = removeDuplicateLetters(testCase);
            System.out.println("Input: \"" + testCase + "\"");
            System.out.println("Output: \"" + result + "\"");
        }
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        // Count frequency of each character
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            
            if (visited[c - 'a']) continue;
            
            while (!stack.isEmpty() && 
                   stack.peek() > c && 
                   count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            
            stack.push(c);
            visited[c - 'a'] = true;
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.reverse().toString();
    }

    /**
     * 13. Simplify Path (Medium)
     * Simplify Unix-style file path
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateSimplifyPath() {
        System.out.println("13. Simplify Path (Medium):");
        System.out.println("===========================");
        
        String[] paths = {
            "/home/",
            "/../",
            "/home//foo/",
            "/a/./b/../../c/",
            "/a/../../b/../c//.//",
            "/a//b////c/d//././/.."
        };
        
        for (String path : paths) {
            String simplified = simplifyPath(path);
            System.out.println("Input: \"" + path + "\"");
            System.out.println("Output: \"" + simplified + "\"");
        }
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String component : components) {
            if (component.equals(".") || component.isEmpty()) {
                continue;
            } else if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        
        return result.length() > 0 ? result.toString() : "/";
    }

    /**
     * 14. Asteroid Collision (Medium)
     * Simulate asteroid collisions
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateAsteroidCollision() {
        System.out.println("14. Asteroid Collision (Medium):");
        System.out.println("================================");
        
        int[] asteroids1 = {5, 10, -5};
        int[] asteroids2 = {8, -8};
        int[] asteroids3 = {10, 2, -5};
        int[] asteroids4 = {-2, -1, 1, 2};
        
        System.out.println("Asteroids: " + Arrays.toString(asteroids1));
        System.out.println("After collision: " + Arrays.toString(asteroidCollision(asteroids1)));
        
        System.out.println("Asteroids: " + Arrays.toString(asteroids2));
        System.out.println("After collision: " + Arrays.toString(asteroidCollision(asteroids2)));
        
        System.out.println("Asteroids: " + Arrays.toString(asteroids3));
        System.out.println("After collision: " + Arrays.toString(asteroidCollision(asteroids3)));
        
        System.out.println("Asteroids: " + Arrays.toString(asteroids4));
        System.out.println("After collision: " + Arrays.toString(asteroidCollision(asteroids4)));
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            while (!stack.isEmpty() && 
                   stack.peek() > 0 && 
                   asteroid < 0 && 
                   stack.peek() < Math.abs(asteroid)) {
                stack.pop();
            }
            
            if (!stack.isEmpty() && 
                stack.peek() > 0 && 
                asteroid < 0 && 
                stack.peek() == Math.abs(asteroid)) {
                stack.pop();
            } else if (stack.isEmpty() || 
                       stack.peek() < 0 || 
                       asteroid > 0) {
                stack.push(asteroid);
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }

    /**
     * 15. Score of Parentheses (Medium)
     * Calculate score of balanced parentheses
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateScoreOfParentheses() {
        System.out.println("15. Score of Parentheses (Medium):");
        System.out.println("==================================");
        
        String[] testCases = {"()", "(())", "()()", "(()(()))"};
        
        for (String testCase : testCases) {
            int score = scoreOfParentheses(testCase);
            System.out.println("\"" + testCase + "\" -> Score: " + score);
        }
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Base score
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int top = stack.pop();
                int score = top == 0 ? 1 : top * 2;
                stack.push(stack.pop() + score);
            }
        }
        
        return stack.pop();
    }
}
