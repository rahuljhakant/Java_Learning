package com.tutorial.datastructures;

import java.util.Arrays;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Stack Algorithms - Comprehensive Guide to Stack Operations in Java
 * 
 * This comprehensive tutorial demonstrates essential stack algorithms including
 * expression evaluation, balanced parentheses, and advanced stack-based problems.
 * Stacks are LIFO (Last In, First Out) data structures that are fundamental
 * for many algorithmic problems and system operations.
 * 
 * LEARNING OBJECTIVES:
 * - Master stack operations and implementations
 * - Understand expression evaluation (postfix, prefix, infix)
 * - Learn balanced parentheses and bracket matching
 * - Practice advanced stack problems (next greater element, stock span)
 * - Implement min/max stack with O(1) operations
 * - Understand stack-based algorithm design patterns
 * - Master time and space complexity analysis
 * 
 * KEY CONCEPTS:
 * 1. LIFO Principle: Last In, First Out data access
 * 2. Expression Evaluation: Converting and evaluating mathematical expressions
 * 3. Balanced Parentheses: Matching opening and closing brackets
 * 4. Monotonic Stack: Maintaining sorted order in stack
 * 5. Two Stack Technique: Using multiple stacks for complex problems
 * 6. Stack-based DFS: Depth-first search using stack
 * 7. Memory Management: Stack frames and call stack
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class StackAlgorithms {
    
    public static void main(String[] args) {
        System.out.println("=== Stack Algorithms Demo ===");
        System.out.println();
        
        // 1. Basic Stack Operations
        demonstrateBasicStackOperations();
        
        // 2. Expression Evaluation
        demonstrateExpressionEvaluation();
        
        // 3. Balanced Parentheses
        demonstrateBalancedParentheses();
        
        // 4. Next Greater Element
        demonstrateNextGreaterElement();
        
        // 5. Stock Span Problem
        demonstrateStockSpanProblem();
        
        // 6. Min/Max Stack
        demonstrateMinMaxStack();
        
        // 7. Advanced Stack Problems
        demonstrateAdvancedProblems();
        
        // 8. Performance Analysis
        demonstratePerformanceAnalysis();
    }
    
    /**
     * Demonstrates basic stack operations
     */
    private static void demonstrateBasicStackOperations() {
        System.out.println("1. Basic Stack Operations:");
        System.out.println("=========================");
        
        // Array-based Stack
        System.out.println("Array-based Stack:");
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println("  After pushing 1, 2, 3: " + arrayStack);
        System.out.println("  Top element: " + arrayStack.peek());
        System.out.println("  Popped element: " + arrayStack.pop());
        System.out.println("  After popping: " + arrayStack);
        
        // Linked List-based Stack
        System.out.println("\nLinked List-based Stack:");
        LinkedListStack llStack = new LinkedListStack();
        llStack.push(10);
        llStack.push(20);
        llStack.push(30);
        System.out.println("  After pushing 10, 20, 30: " + llStack);
        System.out.println("  Top element: " + llStack.peek());
        System.out.println("  Popped element: " + llStack.pop());
        System.out.println("  After popping: " + llStack);
        
        // Java Stack
        System.out.println("\nJava Stack:");
        Stack<Integer> javaStack = new Stack<>();
        javaStack.push(100);
        javaStack.push(200);
        javaStack.push(300);
        System.out.println("  After pushing 100, 200, 300: " + javaStack);
        System.out.println("  Top element: " + javaStack.peek());
        System.out.println("  Popped element: " + javaStack.pop());
        System.out.println("  After popping: " + javaStack);
        
        System.out.println();
    }
    
    /**
     * Demonstrates expression evaluation
     */
    private static void demonstrateExpressionEvaluation() {
        System.out.println("2. Expression Evaluation:");
        System.out.println("========================");
        
        // Postfix Expression Evaluation
        System.out.println("Postfix Expression Evaluation:");
        String postfix = "3 4 + 2 * 7 /";
        int postfixResult = evaluatePostfix(postfix);
        System.out.println("  Expression: \"" + postfix + "\"");
        System.out.println("  Result: " + postfixResult);
        
        // Infix to Postfix Conversion
        System.out.println("\nInfix to Postfix Conversion:");
        String infix = "3 + 4 * 2 / (1 - 5) ^ 2 ^ 3";
        String convertedPostfix = infixToPostfix(infix);
        System.out.println("  Infix: \"" + infix + "\"");
        System.out.println("  Postfix: \"" + convertedPostfix + "\"");
        
        // Prefix Expression Evaluation
        System.out.println("\nPrefix Expression Evaluation:");
        String prefix = "* + 3 4 2";
        int prefixResult = evaluatePrefix(prefix);
        System.out.println("  Expression: \"" + prefix + "\"");
        System.out.println("  Result: " + prefixResult);
        
        // Infix Expression Evaluation
        System.out.println("\nInfix Expression Evaluation:");
        String infixExpr = "2 + 3 * 4";
        int infixResult = evaluateInfix(infixExpr);
        System.out.println("  Expression: \"" + infixExpr + "\"");
        System.out.println("  Result: " + infixResult);
        
        System.out.println();
    }
    
    /**
     * Demonstrates balanced parentheses
     */
    private static void demonstrateBalancedParentheses() {
        System.out.println("3. Balanced Parentheses:");
        System.out.println("=======================");
        
        String[] testCases = {
            "()",
            "()[]{}",
            "(]",
            "([)]",
            "{[]}",
            "((()))",
            "([{}])",
            "((())",
            "())(",
            ""
        };
        
        for (String testCase : testCases) {
            boolean isBalanced = isValidParentheses(testCase);
            System.out.println("  \"" + testCase + "\" -> " + isBalanced);
        }
        
        // Minimum Add to Make Parentheses Valid
        System.out.println("\nMinimum Add to Make Parentheses Valid:");
        String[] invalidCases = {"())", "(((", "()", "()))(("};
        for (String invalid : invalidCases) {
            int minAdd = minAddToMakeValid(invalid);
            System.out.println("  \"" + invalid + "\" -> " + minAdd + " additions needed");
        }
        
        // Remove Invalid Parentheses
        System.out.println("\nRemove Invalid Parentheses:");
        String invalidExpr = "()())()";
        List<String> validExpressions = removeInvalidParentheses(invalidExpr);
        System.out.println("  Input: \"" + invalidExpr + "\"");
        System.out.println("  Valid expressions: " + validExpressions);
        
        System.out.println();
    }
    
    /**
     * Demonstrates next greater element
     */
    private static void demonstrateNextGreaterElement() {
        System.out.println("4. Next Greater Element:");
        System.out.println("=======================");
        
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println("Array: " + Arrays.toString(arr));
        
        // Next Greater Element (Right)
        int[] nextGreater = nextGreaterElement(arr);
        System.out.println("Next Greater Element (Right): " + Arrays.toString(nextGreater));
        
        // Next Greater Element (Left)
        int[] nextGreaterLeft = nextGreaterElementLeft(arr);
        System.out.println("Next Greater Element (Left): " + Arrays.toString(nextGreaterLeft));
        
        // Next Smaller Element (Right)
        int[] nextSmaller = nextSmallerElement(arr);
        System.out.println("Next Smaller Element (Right): " + Arrays.toString(nextSmaller));
        
        // Next Greater Element II (Circular Array)
        int[] circularArr = {1, 2, 1};
        int[] nextGreaterCircular = nextGreaterElementsCircular(circularArr);
        System.out.println("Circular Array: " + Arrays.toString(circularArr));
        System.out.println("Next Greater Element (Circular): " + Arrays.toString(nextGreaterCircular));
        
        System.out.println();
    }
    
    /**
     * Demonstrates stock span problem
     */
    private static void demonstrateStockSpanProblem() {
        System.out.println("5. Stock Span Problem:");
        System.out.println("=====================");
        
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        System.out.println("Stock Prices: " + Arrays.toString(prices));
        
        int[] spans = stockSpan(prices);
        System.out.println("Stock Spans: " + Arrays.toString(spans));
        
        // Daily Temperatures (Similar to Stock Span)
        System.out.println("\nDaily Temperatures:");
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Temperatures: " + Arrays.toString(temperatures));
        
        int[] daysToWait = dailyTemperatures(temperatures);
        System.out.println("Days to wait for warmer: " + Arrays.toString(daysToWait));
        
        System.out.println();
    }
    
    /**
     * Demonstrates min/max stack
     */
    private static void demonstrateMinMaxStack() {
        System.out.println("6. Min/Max Stack:");
        System.out.println("================");
        
        // Min Stack
        System.out.println("Min Stack:");
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("  After pushing -2, 0, -3");
        System.out.println("  Min: " + minStack.getMin());
        minStack.pop();
        System.out.println("  After popping");
        System.out.println("  Top: " + minStack.top());
        System.out.println("  Min: " + minStack.getMin());
        
        // Max Stack
        System.out.println("\nMax Stack:");
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(5);
        System.out.println("  After pushing 5, 1, 5");
        System.out.println("  Top: " + maxStack.top());
        System.out.println("  Max: " + maxStack.getMax());
        maxStack.pop();
        System.out.println("  After popping");
        System.out.println("  Max: " + maxStack.getMax());
        
        System.out.println();
    }
    
    /**
     * Demonstrates advanced stack problems
     */
    private static void demonstrateAdvancedProblems() {
        System.out.println("7. Advanced Stack Problems:");
        System.out.println("==========================");
        
        // Largest Rectangle in Histogram
        System.out.println("Largest Rectangle in Histogram:");
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Heights: " + Arrays.toString(heights));
        int maxArea = largestRectangleArea(heights);
        System.out.println("Maximum area: " + maxArea);
        
        // Trapping Rain Water
        System.out.println("\nTrapping Rain Water:");
        int[] elevation = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Elevation: " + Arrays.toString(elevation));
        int trappedWater = trapRainWater(elevation);
        System.out.println("Trapped water: " + trappedWater);
        
        // Basic Calculator
        System.out.println("\nBasic Calculator:");
        String[] expressions = {"1 + 1", "2-1 + 2", "(1+(4+5+2)-3)+(6+8)"};
        for (String expr : expressions) {
            int result = calculate(expr);
            System.out.println("  \"" + expr + "\" = " + result);
        }
        
        // Decode String
        System.out.println("\nDecode String:");
        String[] encodedStrings = {"3[a]2[bc]", "2[abc]3[cd]ef", "abc3[cd]xyz"};
        for (String encoded : encodedStrings) {
            String decoded = decodeString(encoded);
            System.out.println("  \"" + encoded + "\" -> \"" + decoded + "\"");
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance analysis
     */
    private static void demonstratePerformanceAnalysis() {
        System.out.println("8. Performance Analysis:");
        System.out.println("=======================");
        
        System.out.println("Stack Operation Complexity:");
        System.out.println("-------------------------");
        System.out.println("Basic Operations:");
        System.out.println("  Push:           O(1) time, O(1) space");
        System.out.println("  Pop:            O(1) time, O(1) space");
        System.out.println("  Peek/Top:       O(1) time, O(1) space");
        System.out.println("  IsEmpty:        O(1) time, O(1) space");
        System.out.println("  Size:           O(1) time, O(1) space");
        
        System.out.println("\nExpression Evaluation:");
        System.out.println("  Postfix:        O(n) time, O(n) space");
        System.out.println("  Prefix:         O(n) time, O(n) space");
        System.out.println("  Infix:          O(n) time, O(n) space");
        System.out.println("  Infix to Postfix: O(n) time, O(n) space");
        
        System.out.println("\nAdvanced Problems:");
        System.out.println("  Balanced Parentheses: O(n) time, O(n) space");
        System.out.println("  Next Greater Element: O(n) time, O(n) space");
        System.out.println("  Stock Span:           O(n) time, O(n) space");
        System.out.println("  Min/Max Stack:        O(1) time, O(n) space");
        System.out.println("  Largest Rectangle:    O(n) time, O(n) space");
        System.out.println("  Trapping Rain Water:  O(n) time, O(n) space");
        
        System.out.println();
    }
    
    // Stack Implementation Classes
    
    /**
     * Array-based Stack Implementation
     */
    static class ArrayStack {
        private int[] stack;
        private int top;
        private int capacity;
        
        public ArrayStack(int capacity) {
            this.capacity = capacity;
            this.stack = new int[capacity];
            this.top = -1;
        }
        
        public void push(int data) {
            if (isFull()) {
                throw new RuntimeException("Stack overflow");
            }
            stack[++top] = data;
        }
        
        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack underflow");
            }
            return stack[top--];
        }
        
        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return stack[top];
        }
        
        public boolean isEmpty() {
            return top == -1;
        }
        
        public boolean isFull() {
            return top == capacity - 1;
        }
        
        public int size() {
            return top + 1;
        }
        
        @Override
        public String toString() {
            if (isEmpty()) return "[]";
            
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i <= top; i++) {
                sb.append(stack[i]);
                if (i < top) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }
    
    /**
     * Linked List-based Stack Implementation
     */
    static class LinkedListStack {
        private Node top;
        
        static class Node {
            int data;
            Node next;
            
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
        
        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }
        
        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack underflow");
            }
            int data = top.data;
            top = top.next;
            return data;
        }
        
        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return top.data;
        }
        
        public boolean isEmpty() {
            return top == null;
        }
        
        public int size() {
            int count = 0;
            Node current = top;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }
        
        @Override
        public String toString() {
            if (isEmpty()) return "[]";
            
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Node current = top;
            while (current != null) {
                sb.append(current.data);
                if (current.next != null) sb.append(", ");
                current = current.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
    
    // Expression Evaluation Implementation
    
    /**
     * Evaluate Postfix Expression
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");
        
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
    
    /**
     * Convert Infix to Postfix
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(c).append(" ");
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop(); // Remove '('
            } else if (isOperator(String.valueOf(c))) {
                while (!stack.isEmpty() && 
                       getPrecedence(stack.peek()) >= getPrecedence(c) &&
                       stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }
        
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        
        return result.toString().trim();
    }
    
    /**
     * Evaluate Prefix Expression
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int evaluatePrefix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");
        
        // Process from right to left
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (isOperator(token)) {
                int a = stack.pop();
                int b = stack.pop();
                int result = performOperation(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    /**
     * Evaluate Infix Expression
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int evaluateInfix(String expression) {
        String postfix = infixToPostfix(expression);
        return evaluatePostfix(postfix);
    }
    
    // Helper methods for expression evaluation
    
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/") || 
               token.equals("^");
    }
    
    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
    
    private static int performOperation(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            case "^":
                return (int) Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
    
    // Balanced Parentheses Implementation
    
    /**
     * Check if parentheses are valid
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static boolean isValidParentheses(String s) {
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
     * Minimum Add to Make Parentheses Valid
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        
        return open + close;
    }
    
    /**
     * Remove Invalid Parentheses
     * Time Complexity: O(2^n), Space Complexity: O(n)
     */
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        removeInvalidParenthesesHelper(s, 0, 0, '(', ')', result);
        return result;
    }
    
    private static void removeInvalidParenthesesHelper(String s, int iStart, int jStart, 
                                                     char openParen, char closeParen,
                                                     List<String> result) {
        int numOpenParen = 0, numCloseParen = 0;
        
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == openParen) numOpenParen++;
            if (s.charAt(i) == closeParen) numCloseParen++;
            if (numCloseParen > numOpenParen) {
                for (int j = jStart; j <= i; j++) {
                    if (s.charAt(j) == closeParen && (j == jStart || s.charAt(j - 1) != closeParen)) {
                        removeInvalidParenthesesHelper(s.substring(0, j) + s.substring(j + 1), 
                                                      i, j, openParen, closeParen, result);
                    }
                }
                return;
            }
        }
        
        String reversed = new StringBuilder(s).reverse().toString();
        if (openParen == '(') {
            removeInvalidParenthesesHelper(reversed, 0, 0, ')', '(', result);
        } else {
            result.add(reversed);
        }
    }
    
    // Next Greater Element Implementation
    
    /**
     * Next Greater Element (Right)
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        
        return result;
    }
    
    /**
     * Next Greater Element (Left)
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int[] nextGreaterElementLeft(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        
        return result;
    }
    
    /**
     * Next Smaller Element (Right)
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        
        return result;
    }
    
    /**
     * Next Greater Element II (Circular Array)
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int[] nextGreaterElementsCircular(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i % n]) {
                stack.pop();
            }
            result[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i % n]);
        }
        
        return result;
    }
    
    // Stock Span Problem Implementation
    
    /**
     * Stock Span Problem
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int[] stockSpan(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            spans[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        
        return spans;
    }
    
    /**
     * Daily Temperatures
     * Time Complexity: O(n), Space Complexity: O(n)
     */
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
    
    // Min/Max Stack Implementation
    
    /**
     * Min Stack Implementation
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
     * Max Stack Implementation
     */
    static class MaxStack {
        private Stack<Integer> stack;
        private Stack<Integer> maxStack;
        
        public MaxStack() {
            stack = new Stack<>();
            maxStack = new Stack<>();
        }
        
        public void push(int val) {
            stack.push(val);
            if (maxStack.isEmpty() || val >= maxStack.peek()) {
                maxStack.push(val);
            }
        }
        
        public void pop() {
            if (stack.isEmpty()) return;
            
            int val = stack.pop();
            if (val == maxStack.peek()) {
                maxStack.pop();
            }
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMax() {
            return maxStack.peek();
        }
    }
    
    // Advanced Problems Implementation
    
    /**
     * Largest Rectangle in Histogram
     * Time Complexity: O(n), Space Complexity: O(n)
     */
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
     * Trapping Rain Water
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int trapRainWater(int[] height) {
        if (height.length < 3) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                water += distance * boundedHeight;
            }
            stack.push(i);
        }
        
        return water;
    }
    
    /**
     * Basic Calculator
     * Time Complexity: O(n), Space Complexity: O(n)
     */
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
     * Decode String
     * Time Complexity: O(n), Space Complexity: O(n)
     */
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
}
