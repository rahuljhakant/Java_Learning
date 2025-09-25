package Tries;

import java.util.*;

/**
 * Trie Problems - Comprehensive Solutions
 * 
 * This class contains solutions to fundamental trie problems including:
 * - Basic Trie implementation
 * - Word search and validation
 * - Prefix matching and autocomplete
 * - Word search in 2D grid
 * - Stream of characters
 * - Word squares
 * - Design search autocomplete system
 * 
 * Each problem includes detailed comments on approach, time and space complexity.
 */
public class TrieProblems {

    // ==================== BASIC TRIE IMPLEMENTATION ====================

    /**
     * Problem: Implement Trie (Prefix Tree)
     * A trie (pronounced as "try") or prefix tree is a tree data structure used to store strings.
     * 
     * Approach: Tree structure with nodes containing children and end-of-word flag
     * Time Complexity: O(m) for insert/search/startsWith where m is word length
     * Space Complexity: O(ALPHABET_SIZE * N * M) where N is number of words, M is average length
     */
    static class Trie {
        private TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.containsKey(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setEnd();
        }
        
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }
        
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
        
        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.containsKey(c)) {
                    node = node.get(c);
                } else {
                    return null;
                }
            }
            return node;
        }
    }
    
    static class TrieNode {
        private TrieNode[] children;
        private boolean isEnd;
        
        public TrieNode() {
            children = new TrieNode[26]; // Assuming lowercase English letters
            isEnd = false;
        }
        
        public boolean containsKey(char c) {
            return children[c - 'a'] != null;
        }
        
        public TrieNode get(char c) {
            return children[c - 'a'];
        }
        
        public void put(char c, TrieNode node) {
            children[c - 'a'] = node;
        }
        
        public void setEnd() {
            isEnd = true;
        }
        
        public boolean isEnd() {
            return isEnd;
        }
    }

    /**
     * Problem: Design Add and Search Words Data Structure
     * Design a data structure that supports adding new words and finding if a string matches any previously added string.
     * Word may contain dots '.' where dots can be matched with any letter.
     * 
     * Approach: Trie with DFS for wildcard matching
     * Time Complexity: O(m) for add, O(n*26^m) for search where m is word length, n is number of nodes
     * Space Complexity: O(ALPHABET_SIZE * N * M)
     */
    static class WordDictionary {
        private TrieNode root;
        
        public WordDictionary() {
            root = new TrieNode();
        }
        
        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.containsKey(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setEnd();
        }
        
        public boolean search(String word) {
            return searchHelper(word, 0, root);
        }
        
        private boolean searchHelper(String word, int index, TrieNode node) {
            if (index == word.length()) {
                return node.isEnd();
            }
            
            char c = word.charAt(index);
            
            if (c == '.') {
                // Wildcard - check all possible children
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null && searchHelper(word, index + 1, node.children[i])) {
                        return true;
                    }
                }
                return false;
            } else {
                // Regular character
                if (!node.containsKey(c)) {
                    return false;
                }
                return searchHelper(word, index + 1, node.get(c));
            }
        }
    }

    // ==================== WORD SEARCH PROBLEMS ====================

    /**
     * Problem: Word Search II
     * Given an m x n board of characters and a list of strings words,
     * return all words on the board.
     * 
     * Approach: Trie + DFS backtracking
     * Time Complexity: O(m * n * 4^L) where L is max word length
     * Space Complexity: O(N * L) for trie
     */
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfsWordSearch(board, i, j, trie.root, "", result);
            }
        }
        
        return new ArrayList<>(result);
    }
    
    private void dfsWordSearch(char[][] board, int i, int j, TrieNode node, String current, Set<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return;
        }
        
        char c = board[i][j];
        if (!node.containsKey(c)) {
            return;
        }
        
        node = node.get(c);
        String newWord = current + c;
        
        if (node.isEnd()) {
            result.add(newWord);
        }
        
        board[i][j] = '#'; // Mark as visited
        
        // Explore all four directions
        dfsWordSearch(board, i + 1, j, node, newWord, result);
        dfsWordSearch(board, i - 1, j, node, newWord, result);
        dfsWordSearch(board, i, j + 1, node, newWord, result);
        dfsWordSearch(board, i, j - 1, node, newWord, result);
        
        board[i][j] = c; // Restore
    }

    // ==================== PREFIX MATCHING PROBLEMS ====================

    /**
     * Problem: Longest Word in Dictionary
     * Given a list of strings words representing an English Dictionary,
     * find the longest word in words that can be built one character at a time by other words in words.
     */
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        
        // Insert all words
        for (String word : words) {
            trie.insert(word);
        }
        
        String longest = "";
        for (String word : words) {
            if (canBuildWord(trie, word) && 
                (word.length() > longest.length() || 
                 (word.length() == longest.length() && word.compareTo(longest) < 0))) {
                longest = word;
            }
        }
        
        return longest;
    }
    
    private boolean canBuildWord(Trie trie, String word) {
        TrieNode node = trie.root;
        for (int i = 0; i < word.length() - 1; i++) {
            node = node.get(word.charAt(i));
            if (node == null || !node.isEnd()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Problem: Replace Words
     * In English, we have a concept called root, which can be followed by some other word
     * to form another longer word - let's call this word successor.
     * Given a dictionary consisting of many roots and a sentence,
     * replace all the successors in the sentence with the root forming it.
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        
        // Insert all roots
        for (String root : dictionary) {
            trie.insert(root);
        }
        
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String prefix = findShortestPrefix(trie, word);
            result.append(prefix != null ? prefix : word);
            
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    private String findShortestPrefix(Trie trie, String word) {
        TrieNode node = trie.root;
        StringBuilder prefix = new StringBuilder();
        
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                return null;
            }
            
            node = node.get(c);
            prefix.append(c);
            
            if (node.isEnd()) {
                return prefix.toString();
            }
        }
        
        return null;
    }

    // ==================== STREAM PROBLEMS ====================

    /**
     * Problem: Stream of Characters
     * Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string in the given list of words.
     */
    static class StreamChecker {
        private TrieNode root;
        private StringBuilder stream;
        
        public StreamChecker(String[] words) {
            root = new TrieNode();
            stream = new StringBuilder();
            
            // Insert reversed words into trie
            for (String word : words) {
                insertReversed(word);
            }
        }
        
        private void insertReversed(String word) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (!node.containsKey(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setEnd();
        }
        
        public boolean query(char letter) {
            stream.append(letter);
            TrieNode node = root;
            
            // Check suffixes from the end
            for (int i = stream.length() - 1; i >= 0 && node != null; i--) {
                char c = stream.charAt(i);
                node = node.get(c);
                if (node != null && node.isEnd()) {
                    return true;
                }
            }
            
            return false;
        }
    }

    // ==================== ADVANCED PROBLEMS ====================

    /**
     * Problem: Word Squares
     * A sequence of words forms a valid word square if the kth row and column read the same string.
     * Given an array of unique strings words, return all the possible word squares.
     */
    public List<List<String>> wordSquares(String[] words) {
        Map<String, Set<String>> prefixMap = new HashMap<>();
        int n = words[0].length();
        
        // Build prefix map
        for (String word : words) {
            for (int i = 1; i <= n; i++) {
                String prefix = word.substring(0, i);
                prefixMap.computeIfAbsent(prefix, k -> new HashSet<>()).add(word);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        
        for (String word : words) {
            current.add(word);
            backtrackWordSquares(current, prefixMap, n, result);
            current.remove(current.size() - 1);
        }
        
        return result;
    }
    
    private void backtrackWordSquares(List<String> current, Map<String, Set<String>> prefixMap, int n, List<List<String>> result) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        int row = current.size();
        StringBuilder prefix = new StringBuilder();
        
        // Build prefix from current column
        for (String word : current) {
            prefix.append(word.charAt(row));
        }
        
        Set<String> candidates = prefixMap.get(prefix.toString());
        if (candidates == null) return;
        
        for (String word : candidates) {
            current.add(word);
            backtrackWordSquares(current, prefixMap, n, result);
            current.remove(current.size() - 1);
        }
    }

    /**
     * Problem: Design Search Autocomplete System
     * Design a search autocomplete system for a search engine.
     */
    static class AutocompleteSystem {
        private TrieNode root;
        private StringBuilder currentQuery;
        private TrieNode current;
        
        public AutocompleteSystem(String[] sentences, int[] times) {
            root = new TrieNode();
            currentQuery = new StringBuilder();
            current = root;
            
            // Insert sentences with their frequencies
            for (int i = 0; i < sentences.length; i++) {
                insert(sentences[i], times[i]);
            }
        }
        
        private void insert(String sentence, int times) {
            TrieNode node = root;
            for (char c : sentence.toCharArray()) {
                if (!node.containsKey(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setEnd();
            node.times += times;
        }
        
        public List<String> input(char c) {
            List<String> result = new ArrayList<>();
            
            if (c == '#') {
                // End of query, add to trie
                insert(currentQuery.toString(), 1);
                currentQuery = new StringBuilder();
                current = root;
                return result;
            }
            
            currentQuery.append(c);
            
            if (current != null && current.containsKey(c)) {
                current = current.get(c);
                result = findAllSentences(current);
            } else {
                current = null;
            }
            
            return result;
        }
        
        private List<String> findAllSentences(TrieNode node) {
            List<String> sentences = new ArrayList<>();
            dfsAutocomplete(node, currentQuery.toString(), sentences);
            
            // Sort by frequency (descending), then lexicographically
            sentences.sort((a, b) -> {
                int freqA = getFrequency(a);
                int freqB = getFrequency(b);
                if (freqA != freqB) {
                    return Integer.compare(freqB, freqA);
                }
                return a.compareTo(b);
            });
            
            return sentences.subList(0, Math.min(3, sentences.size()));
        }
        
        private void dfsAutocomplete(TrieNode node, String prefix, List<String> result) {
            if (node.isEnd()) {
                result.add(prefix);
            }
            
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    char c = (char) ('a' + i);
                    dfsAutocomplete(node.children[i], prefix + c, result);
                }
            }
        }
        
        private int getFrequency(String sentence) {
            TrieNode node = root;
            for (char c : sentence.toCharArray()) {
                if (!node.containsKey(c)) return 0;
                node = node.get(c);
            }
            return node.times;
        }
    }
    
    // Extended TrieNode for autocomplete
    static class AutocompleteTrieNode extends TrieNode {
        int times = 0;
    }

    /**
     * Problem: Maximum XOR of Two Numbers in an Array
     * Given an integer array nums, return the maximum XOR of any two numbers in the array.
     */
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        
        // Insert all numbers into trie
        for (int num : nums) {
            insertNumber(root, num);
        }
        
        int maxXOR = 0;
        
        // Find maximum XOR for each number
        for (int num : nums) {
            int currentXOR = findMaxXOR(root, num);
            maxXOR = Math.max(maxXOR, currentXOR);
        }
        
        return maxXOR;
    }
    
    private void insertNumber(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey((char) ('0' + bit))) {
                node.put((char) ('0' + bit), new TrieNode());
            }
            node = node.get((char) ('0' + bit));
        }
    }
    
    private int findMaxXOR(TrieNode root, int num) {
        TrieNode node = root;
        int maxXOR = 0;
        
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int oppositeBit = 1 - bit;
            
            if (node.containsKey((char) ('0' + oppositeBit))) {
                maxXOR |= (1 << i);
                node = node.get((char) ('0' + oppositeBit));
            } else {
                node = node.get((char) ('0' + bit));
            }
        }
        
        return maxXOR;
    }

    // ==================== DEMONSTRATION METHODS ====================

    /**
     * Demonstrate all trie problems
     */
    public static void demonstrateAllProblems() {
        System.out.println("=== Trie Problems Demonstration ===\n");
        
        // Basic Trie
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        System.out.println("Trie search 'app': " + trie.search("app"));
        System.out.println("Trie startsWith 'app': " + trie.startsWith("app"));
        
        // Word Dictionary
        WordDictionary wordDict = new WordDictionary();
        wordDict.addWord("bad");
        wordDict.addWord("dad");
        wordDict.addWord("mad");
        System.out.println("Word Dictionary search 'pad': " + wordDict.search("pad"));
        System.out.println("Word Dictionary search '.ad': " + wordDict.search(".ad"));
        
        // Longest Word
        TrieProblems tp = new TrieProblems();
        String[] words = {"w", "wo", "wor", "worl", "world"};
        String longest = tp.longestWord(words);
        System.out.println("Longest Word: " + longest);
        
        // Replace Words
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String replaced = tp.replaceWords(dictionary, sentence);
        System.out.println("Replace Words: " + replaced);
        
        System.out.println("\n=== Trie Problems Completed ===");
    }

    public static void main(String[] args) {
        demonstrateAllProblems();
    }
}
