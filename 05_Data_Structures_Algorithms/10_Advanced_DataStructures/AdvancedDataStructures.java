package com.tutorial.datastructures.advanced;

/**
 * Advanced Data Structures - Comprehensive Guide to Advanced Data Structures in Java
 * 
 * This comprehensive tutorial demonstrates advanced data structures including
 * Trie, Segment Tree, Disjoint Set Union, and LRU Cache. These structures
 * are essential for solving complex algorithmic problems efficiently.
 * 
 * LEARNING OBJECTIVES:
 * - Master Trie implementation and applications
 * - Understand Segment Tree for range queries
 * - Learn Disjoint Set Union (Union-Find) operations
 * - Implement LRU Cache with O(1) operations
 * - Practice advanced tree-based data structures
 * - Understand space-time tradeoffs
 * - Master time and space complexity analysis
 * 
 * KEY CONCEPTS:
 * 1. Trie: Prefix tree for efficient string operations
 * 2. Segment Tree: Range query and update operations
 * 3. Disjoint Set Union: Connected components and cycle detection
 * 4. LRU Cache: Least Recently Used cache implementation
 * 5. Fenwick Tree: Binary Indexed Tree for prefix sums
 * 6. Sparse Table: Range minimum/maximum queries
 * 7. Advanced Trees: B-Tree, Red-Black Tree concepts
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
public class AdvancedDataStructures {
    
    public static void main(String[] args) {
        System.out.println("=== Advanced Data Structures Demo ===");
        System.out.println();
        
        // 1. Trie Implementation
        demonstrateTrie();
        
        // 2. Segment Tree
        demonstrateSegmentTree();
        
        // 3. Disjoint Set Union
        demonstrateDisjointSetUnion();
        
        // 4. LRU Cache
        demonstrateLRUCache();
        
        // 5. Fenwick Tree
        demonstrateFenwickTree();
        
        // 6. Sparse Table
        demonstrateSparseTable();
        
        // 7. Performance Analysis
        demonstratePerformanceAnalysis();
    }
    
    /**
     * Demonstrates Trie implementation
     */
    private static void demonstrateTrie() {
        System.out.println("1. Trie Implementation:");
        System.out.println("======================");
        
        Trie trie = new Trie();
        
        // Insert words
        String[] words = {"apple", "app", "application", "apply", "banana", "band"};
        System.out.println("Inserting words: " + java.util.Arrays.toString(words));
        for (String word : words) {
            trie.insert(word);
        }
        
        // Search operations
        System.out.println("\nSearch operations:");
        String[] searchWords = {"app", "apple", "banana", "band", "ban", "application"};
        for (String word : searchWords) {
            System.out.println("  Search \"" + word + "\": " + trie.search(word));
        }
        
        // Prefix operations
        System.out.println("\nPrefix operations:");
        String[] prefixes = {"app", "ban", "cat"};
        for (String prefix : prefixes) {
            System.out.println("  Starts with \"" + prefix + "\": " + trie.startsWith(prefix));
        }
        
        // Word search
        System.out.println("\nWord Search:");
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String[] searchWords2 = {"ABCCED", "SEE", "ABCB"};
        for (String word : searchWords2) {
            boolean found = wordSearch(board, word);
            System.out.println("  \"" + word + "\" found: " + found);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates Segment Tree
     */
    private static void demonstrateSegmentTree() {
        System.out.println("2. Segment Tree:");
        System.out.println("===============");
        
        int[] arr = {1, 3, 5, 7, 9, 11};
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        
        SegmentTree segmentTree = new SegmentTree(arr);
        
        // Range sum queries
        System.out.println("\nRange Sum Queries:");
        int[][] queries = {{0, 2}, {1, 4}, {0, 5}};
        for (int[] query : queries) {
            int sum = segmentTree.rangeSum(query[0], query[1]);
            System.out.println("  Sum from " + query[0] + " to " + query[1] + ": " + sum);
        }
        
        // Range minimum queries
        System.out.println("\nRange Minimum Queries:");
        for (int[] query : queries) {
            int min = segmentTree.rangeMin(query[0], query[1]);
            System.out.println("  Min from " + query[0] + " to " + query[1] + ": " + min);
        }
        
        // Update operations
        System.out.println("\nUpdate Operations:");
        segmentTree.update(1, 10);
        System.out.println("  After updating index 1 to 10:");
        System.out.println("  Sum from 0 to 2: " + segmentTree.rangeSum(0, 2));
        System.out.println("  Min from 0 to 2: " + segmentTree.rangeMin(0, 2));
        
        System.out.println();
    }
    
    /**
     * Demonstrates Disjoint Set Union
     */
    private static void demonstrateDisjointSetUnion() {
        System.out.println("3. Disjoint Set Union:");
        System.out.println("=====================");
        
        DisjointSetUnion dsu = new DisjointSetUnion(6);
        
        System.out.println("Initial state:");
        System.out.println("  Components: " + dsu.getComponents());
        
        // Union operations
        System.out.println("\nUnion operations:");
        dsu.union(0, 1);
        System.out.println("  Union(0, 1): " + dsu.getComponents());
        
        dsu.union(2, 3);
        System.out.println("  Union(2, 3): " + dsu.getComponents());
        
        dsu.union(1, 2);
        System.out.println("  Union(1, 2): " + dsu.getComponents());
        
        dsu.union(4, 5);
        System.out.println("  Union(4, 5): " + dsu.getComponents());
        
        // Find operations
        System.out.println("\nFind operations:");
        System.out.println("  Find(0): " + dsu.find(0));
        System.out.println("  Find(3): " + dsu.find(3));
        System.out.println("  Find(4): " + dsu.find(4));
        System.out.println("  Find(5): " + dsu.find(5));
        
        // Connected check
        System.out.println("\nConnected check:");
        System.out.println("  Connected(0, 3): " + dsu.connected(0, 3));
        System.out.println("  Connected(0, 4): " + dsu.connected(0, 4));
        System.out.println("  Connected(4, 5): " + dsu.connected(4, 5));
        
        System.out.println();
    }
    
    /**
     * Demonstrates LRU Cache
     */
    private static void demonstrateLRUCache() {
        System.out.println("4. LRU Cache:");
        System.out.println("=============");
        
        LRUCache lruCache = new LRUCache(3);
        
        System.out.println("LRU Cache operations (capacity = 3):");
        
        lruCache.put(1, 10);
        System.out.println("  put(1, 10) -> Cache: " + lruCache);
        
        lruCache.put(2, 20);
        System.out.println("  put(2, 20) -> Cache: " + lruCache);
        
        lruCache.put(3, 30);
        System.out.println("  put(3, 30) -> Cache: " + lruCache);
        
        System.out.println("  get(2) -> " + lruCache.get(2) + ", Cache: " + lruCache);
        
        lruCache.put(4, 40);
        System.out.println("  put(4, 40) -> Cache: " + lruCache + " (evicted LRU: 1)");
        
        System.out.println("  get(1) -> " + lruCache.get(1) + " (not found)");
        System.out.println("  get(3) -> " + lruCache.get(3) + ", Cache: " + lruCache);
        System.out.println("  get(4) -> " + lruCache.get(4) + ", Cache: " + lruCache);
        
        System.out.println();
    }
    
    /**
     * Demonstrates Fenwick Tree
     */
    private static void demonstrateFenwickTree() {
        System.out.println("5. Fenwick Tree (Binary Indexed Tree):");
        System.out.println("=====================================");
        
        int[] arr = {1, 3, 5, 7, 9, 11};
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        
        FenwickTree fenwickTree = new FenwickTree(arr);
        
        // Range sum queries
        System.out.println("\nRange Sum Queries:");
        int[][] queries = {{0, 2}, {1, 4}, {0, 5}};
        for (int[] query : queries) {
            int sum = fenwickTree.rangeSum(query[0], query[1]);
            System.out.println("  Sum from " + query[0] + " to " + query[1] + ": " + sum);
        }
        
        // Update operations
        System.out.println("\nUpdate Operations:");
        fenwickTree.update(1, 10);
        System.out.println("  After updating index 1 to 10:");
        System.out.println("  Sum from 0 to 2: " + fenwickTree.rangeSum(0, 2));
        
        System.out.println();
    }
    
    /**
     * Demonstrates Sparse Table
     */
    private static void demonstrateSparseTable() {
        System.out.println("6. Sparse Table:");
        System.out.println("===============");
        
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        
        SparseTable sparseTable = new SparseTable(arr);
        
        // Range minimum queries
        System.out.println("\nRange Minimum Queries:");
        int[][] queries = {{0, 2}, {1, 4}, {0, 7}, {3, 6}};
        for (int[] query : queries) {
            int min = sparseTable.rangeMin(query[0], query[1]);
            System.out.println("  Min from " + query[0] + " to " + query[1] + ": " + min);
        }
        
        // Range maximum queries
        System.out.println("\nRange Maximum Queries:");
        for (int[] query : queries) {
            int max = sparseTable.rangeMax(query[0], query[1]);
            System.out.println("  Max from " + query[0] + " to " + query[1] + ": " + max);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance analysis
     */
    private static void demonstratePerformanceAnalysis() {
        System.out.println("7. Performance Analysis:");
        System.out.println("=======================");
        
        System.out.println("Advanced Data Structure Complexity:");
        System.out.println("---------------------------------");
        System.out.println("Trie:");
        System.out.println("  Insert:         O(m) time, O(m) space");
        System.out.println("  Search:         O(m) time, O(1) space");
        System.out.println("  Prefix Search:  O(m) time, O(1) space");
        System.out.println("  Where m = length of string");
        
        System.out.println("\nSegment Tree:");
        System.out.println("  Build:          O(n) time, O(n) space");
        System.out.println("  Query:          O(log n) time, O(1) space");
        System.out.println("  Update:         O(log n) time, O(1) space");
        
        System.out.println("\nDisjoint Set Union:");
        System.out.println("  Find:           O(α(n)) time, O(1) space");
        System.out.println("  Union:          O(α(n)) time, O(1) space");
        System.out.println("  Where α(n) = inverse Ackermann function");
        
        System.out.println("\nLRU Cache:");
        System.out.println("  Get:            O(1) time, O(1) space");
        System.out.println("  Put:            O(1) time, O(1) space");
        
        System.out.println("\nFenwick Tree:");
        System.out.println("  Build:          O(n log n) time, O(n) space");
        System.out.println("  Query:          O(log n) time, O(1) space");
        System.out.println("  Update:         O(log n) time, O(1) space");
        
        System.out.println("\nSparse Table:");
        System.out.println("  Build:          O(n log n) time, O(n log n) space");
        System.out.println("  Query:          O(1) time, O(1) space");
        System.out.println("  Update:         O(n log n) time, O(1) space");
        
        System.out.println();
    }
    
    // Trie Implementation
    
    static class Trie {
        private TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode());
                }
                current = current.children.get(c);
            }
            current.isEndOfWord = true;
        }
        
        public boolean search(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    return false;
                }
                current = current.children.get(c);
            }
            return current.isEndOfWord;
        }
        
        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    return false;
                }
                current = current.children.get(c);
            }
            return true;
        }
        
        static class TrieNode {
            java.util.Map<Character, TrieNode> children;
            boolean isEndOfWord;
            
            public TrieNode() {
                children = new java.util.HashMap<>();
                isEndOfWord = false;
            }
        }
    }
    
    // Segment Tree Implementation
    
    static class SegmentTree {
        private int[] tree;
        private int[] arr;
        private int n;
        
        public SegmentTree(int[] arr) {
            this.arr = arr.clone();
            this.n = arr.length;
            this.tree = new int[4 * n];
            build(0, 0, n - 1);
        }
        
        private void build(int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                build(2 * node + 1, start, mid);
                build(2 * node + 2, mid + 1, end);
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }
        
        public void update(int index, int value) {
            arr[index] = value;
            update(0, 0, n - 1, index, value);
        }
        
        private void update(int node, int start, int end, int index, int value) {
            if (start == end) {
                tree[node] = value;
            } else {
                int mid = (start + end) / 2;
                if (index <= mid) {
                    update(2 * node + 1, start, mid, index, value);
                } else {
                    update(2 * node + 2, mid + 1, end, index, value);
                }
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }
        
        public int rangeSum(int left, int right) {
            return rangeSum(0, 0, n - 1, left, right);
        }
        
        private int rangeSum(int node, int start, int end, int left, int right) {
            if (right < start || left > end) {
                return 0;
            }
            if (left <= start && end <= right) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            return rangeSum(2 * node + 1, start, mid, left, right) +
                   rangeSum(2 * node + 2, mid + 1, end, left, right);
        }
        
        public int rangeMin(int left, int right) {
            return rangeMin(0, 0, n - 1, left, right);
        }
        
        private int rangeMin(int node, int start, int end, int left, int right) {
            if (right < start || left > end) {
                return Integer.MAX_VALUE;
            }
            if (left <= start && end <= right) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            return Math.min(rangeMin(2 * node + 1, start, mid, left, right),
                           rangeMin(2 * node + 2, mid + 1, end, left, right));
        }
    }
    
    // Disjoint Set Union Implementation
    
    static class DisjointSetUnion {
        private int[] parent;
        private int[] rank;
        private int components;
        
        public DisjointSetUnion(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                components--;
            }
        }
        
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
        
        public int getComponents() {
            return components;
        }
    }
    
    // LRU Cache Implementation
    
    static class LRUCache {
        private int capacity;
        private java.util.LinkedHashMap<Integer, Integer> cache;
        
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new java.util.LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }
        
        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }
        
        public void put(int key, int value) {
            cache.put(key, value);
        }
        
        @Override
        public String toString() {
            return cache.toString();
        }
    }
    
    // Fenwick Tree Implementation
    
    static class FenwickTree {
        private int[] tree;
        private int n;
        
        public FenwickTree(int[] arr) {
            this.n = arr.length;
            this.tree = new int[n + 1];
            for (int i = 0; i < n; i++) {
                update(i, arr[i]);
            }
        }
        
        public void update(int index, int delta) {
            index++;
            while (index <= n) {
                tree[index] += delta;
                index += index & (-index);
            }
        }
        
        public int prefixSum(int index) {
            index++;
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & (-index);
            }
            return sum;
        }
        
        public int rangeSum(int left, int right) {
            return prefixSum(right) - prefixSum(left - 1);
        }
    }
    
    // Sparse Table Implementation
    
    static class SparseTable {
        private int[][] table;
        private int[] log;
        private int n;
        
        public SparseTable(int[] arr) {
            this.n = arr.length;
            this.log = new int[n + 1];
            this.table = new int[n][20];
            
            // Precompute log values
            for (int i = 2; i <= n; i++) {
                log[i] = log[i / 2] + 1;
            }
            
            // Build sparse table
            for (int i = 0; i < n; i++) {
                table[i][0] = arr[i];
            }
            
            for (int j = 1; j <= log[n]; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    table[i][j] = Math.min(table[i][j - 1], table[i + (1 << (j - 1))][j - 1]);
                }
            }
        }
        
        public int rangeMin(int left, int right) {
            int j = log[right - left + 1];
            return Math.min(table[left][j], table[right - (1 << j) + 1][j]);
        }
        
        public int rangeMax(int left, int right) {
            int j = log[right - left + 1];
            return Math.max(table[left][j], table[right - (1 << j) + 1][j]);
        }
    }
    
    // Word Search Implementation
    
    /**
     * Word Search using Trie
     * Time Complexity: O(m * n * 4^L), Space Complexity: O(L)
     */
    public static boolean wordSearch(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.isEmpty()) {
            return false;
        }
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (wordSearchHelper(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private static boolean wordSearchHelper(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
            visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        visited[row][col] = true;
        
        boolean found = wordSearchHelper(board, word, index + 1, row + 1, col, visited) ||
                       wordSearchHelper(board, word, index + 1, row - 1, col, visited) ||
                       wordSearchHelper(board, word, index + 1, row, col + 1, visited) ||
                       wordSearchHelper(board, word, index + 1, row, col - 1, visited);
        
        visited[row][col] = false;
        return found;
    }
}
