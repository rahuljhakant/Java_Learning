package com.tutorial.datastructures.trees;

import java.util.*;

/**
 * Tree & Graph Problems - Comprehensive Solutions
 * 
 * This comprehensive implementation covers all essential tree and graph problems
 * commonly asked in technical interviews. Each solution includes detailed explanations,
 * time/space complexity analysis, and multiple approaches where applicable.
 * 
 * PROBLEMS COVERED:
 * 1. Maximum Depth of Binary Tree (Easy) - Find the height of a tree
 * 2. Same Tree (Easy) - Check if two trees are identical
 * 3. Invert/Flip Binary Tree (Easy) - Mirror a binary tree
 * 4. Binary Tree Level Order Traversal (Medium) - BFS traversal
 * 5. Validate Binary Search Tree (Medium) - Check if a tree is a valid BST
 * 6. Kth Smallest Element in a BST (Medium) - In-order traversal
 * 7. Construct Binary Tree from Preorder and Inorder Traversal (Medium) - Tree construction classic
 * 8. Lowest Common Ancestor of a Binary Tree (Medium) - Find LCA of two nodes
 * 9. Serialize and Deserialize Binary Tree (Hard) - Convert a tree to and from a string
 * 10. Number of Islands (Medium) - Count connected components in a grid (DFS/BFS)
 * 11. Clone Graph (Medium) - Deep copy a connected undirected graph
 * 12. Pacific Atlantic Water Flow (Medium) - Multi-source BFS/DFS
 * 13. Course Schedule (Medium) - Detect cycle in a directed graph (Topological Sort)
 * 14. Word Ladder (Hard) - Shortest path transformation (BFS)
 * 15. Redundant Connection (Medium) - Find edge that creates cycle in undirected graph
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class TreeGraphProblems {

    // TreeNode definition for all tree problems
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {}
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Graph Node definition for graph problems
    public static class Node {
        public int val;
        public List<Node> neighbors;
        
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Tree & Graph Problems ===");
        System.out.println();
        
        // Run all problem demonstrations
        demonstrateMaximumDepthOfBinaryTree();
        demonstrateSameTree();
        demonstrateInvertBinaryTree();
        demonstrateBinaryTreeLevelOrderTraversal();
        demonstrateValidateBinarySearchTree();
        demonstrateKthSmallestElementInBST();
        demonstrateConstructBinaryTree();
        demonstrateLowestCommonAncestor();
        demonstrateSerializeDeserializeBinaryTree();
        demonstrateNumberOfIslands();
        demonstrateCloneGraph();
        demonstratePacificAtlanticWaterFlow();
        demonstrateCourseSchedule();
        demonstrateWordLadder();
        demonstrateRedundantConnection();
    }

    /**
     * 1. Maximum Depth of Binary Tree (Easy)
     * Find the height of a tree
     * Time: O(n), Space: O(h)
     */
    public static void demonstrateMaximumDepthOfBinaryTree() {
        System.out.println("1. Maximum Depth of Binary Tree (Easy):");
        System.out.println("=======================================");
        
        TreeNode root = createSampleTree();
        System.out.println("Sample tree:");
        System.out.println("      3");
        System.out.println("     / \\");
        System.out.println("    9   20");
        System.out.println("       /  \\");
        System.out.println("      15   7");
        
        int maxDepth = maxDepth(root);
        System.out.println("Maximum depth: " + maxDepth);
        
        System.out.println("Time: O(n), Space: O(h)");
        System.out.println();
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * 2. Same Tree (Easy)
     * Check if two trees are identical
     * Time: O(n), Space: O(h)
     */
    public static void demonstrateSameTree() {
        System.out.println("2. Same Tree (Easy):");
        System.out.println("===================");
        
        TreeNode tree1 = createSampleTree();
        TreeNode tree2 = createSampleTree();
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        
        System.out.println("Tree 1 and Tree 2 (identical): " + isSameTree(tree1, tree2));
        System.out.println("Tree 1 and Tree 3 (different): " + isSameTree(tree1, tree3));
        
        System.out.println("Time: O(n), Space: O(h)");
        System.out.println();
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        
        return p.val == q.val && 
               isSameTree(p.left, q.left) && 
               isSameTree(p.right, q.right);
    }

    /**
     * 3. Invert/Flip Binary Tree (Easy)
     * Mirror a binary tree
     * Time: O(n), Space: O(h)
     */
    public static void demonstrateInvertBinaryTree() {
        System.out.println("3. Invert/Flip Binary Tree (Easy):");
        System.out.println("=================================");
        
        TreeNode root = createSampleTree();
        System.out.println("Original tree preorder: " + preorderTraversal(root));
        
        TreeNode inverted = invertTree(root);
        System.out.println("Inverted tree preorder: " + preorderTraversal(inverted));
        
        System.out.println("Time: O(n), Space: O(h)");
        System.out.println();
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }

    /**
     * 4. Binary Tree Level Order Traversal (Medium)
     * BFS traversal
     * Time: O(n), Space: O(w)
     */
    public static void demonstrateBinaryTreeLevelOrderTraversal() {
        System.out.println("4. Binary Tree Level Order Traversal (Medium):");
        System.out.println("=============================================");
        
        TreeNode root = createSampleTree();
        System.out.println("Sample tree:");
        System.out.println("      3");
        System.out.println("     / \\");
        System.out.println("    9   20");
        System.out.println("       /  \\");
        System.out.println("      15   7");
        
        List<List<Integer>> levelOrder = levelOrder(root);
        System.out.println("Level order traversal:");
        for (int i = 0; i < levelOrder.size(); i++) {
            System.out.println("  Level " + i + ": " + levelOrder.get(i));
        }
        
        System.out.println("Time: O(n), Space: O(w)");
        System.out.println();
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            result.add(currentLevel);
        }
        
        return result;
    }

    /**
     * 5. Validate Binary Search Tree (Medium)
     * Check if a tree is a valid BST
     * Time: O(n), Space: O(h)
     */
    public static void demonstrateValidateBinarySearchTree() {
        System.out.println("5. Validate Binary Search Tree (Medium):");
        System.out.println("=======================================");
        
        // Valid BST
        TreeNode validBST = new TreeNode(5);
        validBST.left = new TreeNode(3);
        validBST.right = new TreeNode(7);
        validBST.left.left = new TreeNode(2);
        validBST.left.right = new TreeNode(4);
        
        System.out.println("Valid BST:");
        System.out.println("      5");
        System.out.println("     / \\");
        System.out.println("    3   7");
        System.out.println("   / \\");
        System.out.println("  2   4");
        System.out.println("Is valid BST: " + isValidBST(validBST));
        
        // Invalid BST
        TreeNode invalidBST = new TreeNode(5);
        invalidBST.left = new TreeNode(3);
        invalidBST.right = new TreeNode(7);
        invalidBST.left.left = new TreeNode(2);
        invalidBST.left.right = new TreeNode(6); // Invalid: 6 > 5
        
        System.out.println("\nInvalid BST:");
        System.out.println("      5");
        System.out.println("     / \\");
        System.out.println("    3   7");
        System.out.println("   / \\");
        System.out.println("  2   6");
        System.out.println("Is valid BST: " + isValidBST(invalidBST));
        
        System.out.println("Time: O(n), Space: O(h)");
        System.out.println();
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBSTHelper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        
        return isValidBSTHelper(root.left, min, root.val) && 
               isValidBSTHelper(root.right, root.val, max);
    }

    /**
     * 6. Kth Smallest Element in a BST (Medium)
     * In-order traversal
     * Time: O(n), Space: O(h)
     */
    public static void demonstrateKthSmallestElementInBST() {
        System.out.println("6. Kth Smallest Element in a BST (Medium):");
        System.out.println("=========================================");
        
        TreeNode bst = new TreeNode(5);
        bst.left = new TreeNode(3);
        bst.right = new TreeNode(7);
        bst.left.left = new TreeNode(2);
        bst.left.right = new TreeNode(4);
        bst.right.left = new TreeNode(6);
        bst.right.right = new TreeNode(8);
        
        System.out.println("BST:");
        System.out.println("      5");
        System.out.println("     / \\");
        System.out.println("    3   7");
        System.out.println("   / \\ / \\");
        System.out.println("  2  4 6  8");
        
        for (int k = 1; k <= 7; k++) {
            int kthSmallest = kthSmallest(bst, k);
            System.out.println("Kth smallest element (k=" + k + "): " + kthSmallest);
        }
        
        System.out.println("Time: O(n), Space: O(h)");
        System.out.println();
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        return inorder.get(k - 1);
    }

    private static void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

    /**
     * 7. Construct Binary Tree from Preorder and Inorder Traversal (Medium)
     * Tree construction classic
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateConstructBinaryTree() {
        System.out.println("7. Construct Binary Tree from Preorder and Inorder Traversal (Medium):");
        System.out.println("=====================================================================");
        
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        System.out.println("Preorder: " + Arrays.toString(preorder));
        System.out.println("Inorder: " + Arrays.toString(inorder));
        
        TreeNode constructed = buildTree(preorder, inorder);
        System.out.println("Constructed tree preorder: " + preorderTraversal(constructed));
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, 0, preorder.length - 1, 
                              inorder, 0, inorder.length - 1, inorderMap);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                          int[] inorder, int inStart, int inEnd,
                                          Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = inorderMap.get(root.val);
        int leftSize = rootIndex - inStart;
        
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSize,
                                  inorder, inStart, rootIndex - 1, inorderMap);
        root.right = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd,
                                   inorder, rootIndex + 1, inEnd, inorderMap);
        
        return root;
    }

    /**
     * 8. Lowest Common Ancestor of a Binary Tree (Medium)
     * Find LCA of two nodes
     * Time: O(n), Space: O(h)
     */
    public static void demonstrateLowestCommonAncestor() {
        System.out.println("8. Lowest Common Ancestor of a Binary Tree (Medium):");
        System.out.println("==================================================");
        
        TreeNode root = createSampleTree();
        TreeNode p = root.right.left;  // Node with value 15
        TreeNode q = root.right.right; // Node with value 7
        
        System.out.println("Tree:");
        System.out.println("      3");
        System.out.println("     / \\");
        System.out.println("    9   20");
        System.out.println("       /  \\");
        System.out.println("      15   7");
        
        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 15 and 7: " + (lca != null ? lca.val : "null"));
        
        System.out.println("Time: O(n), Space: O(h)");
        System.out.println();
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    /**
     * 9. Serialize and Deserialize Binary Tree (Hard)
     * Convert a tree to and from a string
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateSerializeDeserializeBinaryTree() {
        System.out.println("9. Serialize and Deserialize Binary Tree (Hard):");
        System.out.println("===============================================");
        
        TreeNode root = createSampleTree();
        System.out.println("Original tree preorder: " + preorderTraversal(root));
        
        // Serialize
        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);
        
        // Deserialize
        TreeNode deserialized = deserialize(serialized);
        System.out.println("Deserialized tree preorder: " + preorderTraversal(deserialized));
        
        // Verify
        boolean isSame = isSameTree(root, deserialized);
        System.out.println("Tree preserved: " + isSame);
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private static void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
        } else {
            sb.append(root.val).append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }

    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private static TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        
        return root;
    }

    /**
     * 10. Number of Islands (Medium)
     * Count connected components in a grid (DFS/BFS)
     * Time: O(m*n), Space: O(m*n)
     */
    public static void demonstrateNumberOfIslands() {
        System.out.println("10. Number of Islands (Medium):");
        System.out.println("===============================");
        
        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        
        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        
        System.out.println("Grid 1:");
        printGrid(grid1);
        System.out.println("Number of islands: " + numIslands(grid1));
        
        System.out.println("\nGrid 2:");
        printGrid(grid2);
        System.out.println("Number of islands: " + numIslands(grid2));
        
        System.out.println("Time: O(m*n), Space: O(m*n)");
        System.out.println();
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        
        return islands;
    }

    private static void dfs(char[][] grid, int row, int col, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }
        
        grid[row][col] = '0'; // Mark as visited
        
        // Visit all four directions
        dfs(grid, row + 1, col, rows, cols);
        dfs(grid, row - 1, col, rows, cols);
        dfs(grid, row, col + 1, rows, cols);
        dfs(grid, row, col - 1, rows, cols);
    }

    /**
     * 11. Clone Graph (Medium)
     * Deep copy a connected undirected graph
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateCloneGraph() {
        System.out.println("11. Clone Graph (Medium):");
        System.out.println("========================");
        
        // Create a sample graph: 1 -- 2
        //                        |    |
        //                        4 -- 3
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        
        System.out.println("Original graph: 1 -- 2");
        System.out.println("                |    |");
        System.out.println("                4 -- 3");
        
        Node clonedGraph = cloneGraph(node1);
        System.out.println("Graph cloned successfully");
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Map<Node, Node> visited = new HashMap<>();
        return cloneGraphHelper(node, visited);
    }

    private static Node cloneGraphHelper(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);
        
        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraphHelper(neighbor, visited));
        }
        
        return clonedNode;
    }

    /**
     * 12. Pacific Atlantic Water Flow (Medium)
     * Multi-source BFS/DFS
     * Time: O(m*n), Space: O(m*n)
     */
    public static void demonstratePacificAtlanticWaterFlow() {
        System.out.println("12. Pacific Atlantic Water Flow (Medium):");
        System.out.println("========================================");
        
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
        
        System.out.println("Heights matrix:");
        printMatrix(heights);
        
        List<List<Integer>> result = pacificAtlantic(heights);
        System.out.println("Cells that can flow to both Pacific and Atlantic: " + result);
        
        System.out.println("Time: O(m*n), Space: O(m*n)");
        System.out.println();
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;
        
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        // DFS from Pacific (top and left edges)
        for (int i = 0; i < rows; i++) {
            dfsPacificAtlantic(heights, pacific, i, 0, rows, cols);
        }
        for (int j = 0; j < cols; j++) {
            dfsPacificAtlantic(heights, pacific, 0, j, rows, cols);
        }
        
        // DFS from Atlantic (bottom and right edges)
        for (int i = 0; i < rows; i++) {
            dfsPacificAtlantic(heights, atlantic, i, cols - 1, rows, cols);
        }
        for (int j = 0; j < cols; j++) {
            dfsPacificAtlantic(heights, atlantic, rows - 1, j, rows, cols);
        }
        
        // Find cells that can reach both oceans
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }

    private static void dfsPacificAtlantic(int[][] heights, boolean[][] visited, 
                                         int row, int col, int rows, int cols) {
        if (visited[row][col]) return;
        
        visited[row][col] = true;
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                heights[newRow][newCol] >= heights[row][col]) {
                dfsPacificAtlantic(heights, visited, newRow, newCol, rows, cols);
            }
        }
    }

    /**
     * 13. Course Schedule (Medium)
     * Detect cycle in a directed graph (Topological Sort)
     * Time: O(V + E), Space: O(V + E)
     */
    public static void demonstrateCourseSchedule() {
        System.out.println("13. Course Schedule (Medium):");
        System.out.println("============================");
        
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Courses: " + numCourses1 + ", Prerequisites: " + Arrays.deepToString(prerequisites1));
        System.out.println("Can finish all courses: " + canFinish(numCourses1, prerequisites1));
        
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("\nCourses: " + numCourses2 + ", Prerequisites: " + Arrays.deepToString(prerequisites2));
        System.out.println("Can finish all courses: " + canFinish(numCourses2, prerequisites2));
        
        System.out.println("Time: O(V + E), Space: O(V + E)");
        System.out.println();
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[numCourses];
        
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }
        
        // Topological sort using BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;
            
            for (int nextCourse : graph.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        return completedCourses == numCourses;
    }

    /**
     * 14. Word Ladder (Hard)
     * Shortest path transformation (BFS)
     * Time: O(M^2 * N), Space: O(M * N)
     */
    public static void demonstrateWordLadder() {
        System.out.println("14. Word Ladder (Hard):");
        System.out.println("======================");
        
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        
        System.out.println("Begin word: \"" + beginWord + "\"");
        System.out.println("End word: \"" + endWord + "\"");
        System.out.println("Word list: " + wordList);
        
        int ladderLength = ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest transformation sequence length: " + ladderLength);
        
        System.out.println("Time: O(M^2 * N), Space: O(M * N)");
        System.out.println();
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                
                if (currentWord.equals(endWord)) {
                    return level;
                }
                
                char[] wordChars = currentWord.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    
                    wordChars[j] = originalChar;
                }
            }
            
            level++;
        }
        
        return 0;
    }

    /**
     * 15. Redundant Connection (Medium)
     * Find edge that creates cycle in undirected graph
     * Time: O(n), Space: O(n)
     */
    public static void demonstrateRedundantConnection() {
        System.out.println("15. Redundant Connection (Medium):");
        System.out.println("=================================");
        
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        
        System.out.println("Edges 1: " + Arrays.deepToString(edges1));
        int[] redundant1 = findRedundantConnection(edges1);
        System.out.println("Redundant connection: " + Arrays.toString(redundant1));
        
        System.out.println("\nEdges 2: " + Arrays.deepToString(edges2));
        int[] redundant2 = findRedundantConnection(edges2);
        System.out.println("Redundant connection: " + Arrays.toString(redundant2));
        
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        
        // Initialize each node as its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            int rootU = find(parent, u);
            int rootV = find(parent, v);
            
            if (rootU == rootV) {
                return edge; // This edge creates a cycle
            }
            
            parent[rootU] = rootV; // Union
        }
        
        return new int[0];
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // Path compression
        }
        return parent[x];
    }

    // Utility methods

    private static TreeNode createSampleTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private static void preorderHelper(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preorderHelper(root.left, result);
            preorderHelper(root.right, result);
        }
    }

    private static void printGrid(char[][] grid) {
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
