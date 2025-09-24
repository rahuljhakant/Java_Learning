package com.tutorial.datastructures.trees;

/**
 * Tree Algorithms - Comprehensive Guide to Tree Operations in Java
 * 
 * This comprehensive tutorial demonstrates essential tree algorithms including
 * binary trees, binary search trees, and advanced tree operations. Trees are
 * hierarchical data structures that are fundamental for many algorithms and
 * system designs.
 * 
 * LEARNING OBJECTIVES:
 * - Master binary tree operations and traversals
 * - Understand binary search tree (BST) operations
 * - Learn tree height, diameter, and node counting
 * - Practice lowest common ancestor (LCA) algorithms
 * - Implement tree validation and serialization
 * - Understand balanced trees and AVL operations
 * - Master time and space complexity analysis
 * 
 * KEY CONCEPTS:
 * 1. Tree Traversals: Preorder, Inorder, Postorder, Level-order
 * 2. Binary Search Tree: Sorted property and operations
 * 3. Tree Properties: Height, diameter, balance factor
 * 4. Tree Algorithms: LCA, path sum, tree validation
 * 5. Tree Serialization: Converting trees to/from strings
 * 6. Balanced Trees: AVL trees and rotation operations
 * 7. Tree Construction: Building trees from traversals
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class TreeAlgorithms {
    
    public static void main(String[] args) {
        System.out.println("=== Tree Algorithms Demo ===");
        System.out.println();
        
        // 1. Basic Tree Operations
        demonstrateBasicTreeOperations();
        
        // 2. Tree Traversals
        demonstrateTreeTraversals();
        
        // 3. Binary Search Tree Operations
        demonstrateBSTOperations();
        
        // 4. Tree Properties
        demonstrateTreeProperties();
        
        // 5. Tree Algorithms
        demonstrateTreeAlgorithms();
        
        // 6. Tree Validation
        demonstrateTreeValidation();
        
        // 7. Tree Serialization
        demonstrateTreeSerialization();
        
        // 8. Advanced Tree Problems
        demonstrateAdvancedProblems();
        
        // 9. Performance Analysis
        demonstratePerformanceAnalysis();
    }
    
    /**
     * Demonstrates basic tree operations
     */
    private static void demonstrateBasicTreeOperations() {
        System.out.println("1. Basic Tree Operations:");
        System.out.println("========================");
        
        // Create a sample binary tree
        TreeNode root = createSampleTree();
        System.out.println("Sample Binary Tree:");
        System.out.println("      1");
        System.out.println("     / \\");
        System.out.println("    2   3");
        System.out.println("   / \\");
        System.out.println("  4   5");
        
        // Tree size
        int size = getTreeSize(root);
        System.out.println("\nTree size: " + size);
        
        // Tree height
        int height = getTreeHeight(root);
        System.out.println("Tree height: " + height);
        
        // Count leaves
        int leaves = countLeaves(root);
        System.out.println("Number of leaves: " + leaves);
        
        // Count internal nodes
        int internalNodes = countInternalNodes(root);
        System.out.println("Number of internal nodes: " + internalNodes);
        
        // Check if tree is complete
        boolean isComplete = isCompleteTree(root);
        System.out.println("Is complete tree: " + isComplete);
        
        // Check if tree is full
        boolean isFull = isFullTree(root);
        System.out.println("Is full tree: " + isFull);
        
        System.out.println();
    }
    
    /**
     * Demonstrates tree traversals
     */
    private static void demonstrateTreeTraversals() {
        System.out.println("2. Tree Traversals:");
        System.out.println("==================");
        
        TreeNode root = createSampleTree();
        
        // Preorder Traversal
        System.out.println("Preorder Traversal (Root-Left-Right):");
        java.util.List<Integer> preorder = preorderTraversal(root);
        System.out.println("  " + preorder);
        
        // Inorder Traversal
        System.out.println("\nInorder Traversal (Left-Root-Right):");
        java.util.List<Integer> inorder = inorderTraversal(root);
        System.out.println("  " + inorder);
        
        // Postorder Traversal
        System.out.println("\nPostorder Traversal (Left-Right-Root):");
        java.util.List<Integer> postorder = postorderTraversal(root);
        System.out.println("  " + postorder);
        
        // Level Order Traversal
        System.out.println("\nLevel Order Traversal (BFS):");
        java.util.List<java.util.List<Integer>> levelOrder = levelOrderTraversal(root);
        for (int i = 0; i < levelOrder.size(); i++) {
            System.out.println("  Level " + i + ": " + levelOrder.get(i));
        }
        
        // Zigzag Level Order Traversal
        System.out.println("\nZigzag Level Order Traversal:");
        java.util.List<java.util.List<Integer>> zigzag = zigzagLevelOrder(root);
        for (int i = 0; i < zigzag.size(); i++) {
            System.out.println("  Level " + i + ": " + zigzag.get(i));
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates BST operations
     */
    private static void demonstrateBSTOperations() {
        System.out.println("3. Binary Search Tree Operations:");
        System.out.println("=================================");
        
        // Create a BST
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        
        System.out.println("BST after inserting 5, 3, 7, 2, 4, 6, 8:");
        System.out.println("      5");
        System.out.println("     / \\");
        System.out.println("    3   7");
        System.out.println("   / \\ / \\");
        System.out.println("  2  4 6  8");
        
        // Search operations
        System.out.println("\nSearch operations:");
        System.out.println("  Search 4: " + bst.search(4));
        System.out.println("  Search 9: " + bst.search(9));
        
        // Inorder traversal (gives sorted order)
        System.out.println("\nInorder traversal (sorted): " + bst.inorderTraversal());
        
        // Find min and max
        System.out.println("  Minimum value: " + bst.findMin());
        System.out.println("  Maximum value: " + bst.findMax());
        
        // Delete operations
        System.out.println("\nDelete operations:");
        bst.delete(3);
        System.out.println("  After deleting 3: " + bst.inorderTraversal());
        
        bst.delete(7);
        System.out.println("  After deleting 7: " + bst.inorderTraversal());
        
        // Validate BST
        System.out.println("\nBST Validation:");
        boolean isValidBST = isValidBST(bst.root);
        System.out.println("  Is valid BST: " + isValidBST);
        
        System.out.println();
    }
    
    /**
     * Demonstrates tree properties
     */
    private static void demonstrateTreeProperties() {
        System.out.println("4. Tree Properties:");
        System.out.println("==================");
        
        TreeNode root = createSampleTree();
        
        // Tree diameter
        int diameter = getTreeDiameter(root);
        System.out.println("Tree diameter: " + diameter);
        
        // Maximum path sum
        int maxPathSum = maxPathSum(root);
        System.out.println("Maximum path sum: " + maxPathSum);
        
        // Check if tree is balanced
        boolean isBalanced = isBalancedTree(root);
        System.out.println("Is balanced tree: " + isBalanced);
        
        // Get balance factor
        int balanceFactor = getBalanceFactor(root);
        System.out.println("Balance factor: " + balanceFactor);
        
        // Count nodes at each level
        java.util.Map<Integer, Integer> levelCount = countNodesAtLevel(root);
        System.out.println("Nodes at each level: " + levelCount);
        
        // Find deepest node
        TreeNode deepest = findDeepestNode(root);
        System.out.println("Deepest node value: " + (deepest != null ? deepest.val : "null"));
        
        System.out.println();
    }
    
    /**
     * Demonstrates tree algorithms
     */
    private static void demonstrateTreeAlgorithms() {
        System.out.println("5. Tree Algorithms:");
        System.out.println("==================");
        
        TreeNode root = createSampleTree();
        
        // Lowest Common Ancestor
        TreeNode node4 = root.left.left;  // Node with value 4
        TreeNode node5 = root.left.right; // Node with value 5
        TreeNode lca = lowestCommonAncestor(root, node4, node5);
        System.out.println("Lowest Common Ancestor of 4 and 5: " + (lca != null ? lca.val : "null"));
        
        // Path Sum
        boolean hasPathSum = hasPathSum(root, 7);
        System.out.println("Has path sum 7: " + hasPathSum);
        
        // All Path Sums
        java.util.List<java.util.List<Integer>> allPaths = allPaths(root);
        System.out.println("All root-to-leaf paths: " + allPaths);
        
        // Path Sum II
        java.util.List<java.util.List<Integer>> pathSumII = pathSum(root, 7);
        System.out.println("Paths with sum 7: " + pathSumII);
        
        // Invert Binary Tree
        TreeNode inverted = invertTree(root);
        System.out.println("Inverted tree preorder: " + preorderTraversal(inverted));
        
        // Symmetric Tree
        boolean isSymmetric = isSymmetric(root);
        System.out.println("Is symmetric tree: " + isSymmetric);
        
        System.out.println();
    }
    
    /**
     * Demonstrates tree validation
     */
    private static void demonstrateTreeValidation() {
        System.out.println("6. Tree Validation:");
        System.out.println("==================");
        
        // Create a valid BST
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
        
        boolean isValidBST = isValidBST(validBST);
        System.out.println("  Is valid BST: " + isValidBST);
        
        // Create an invalid BST
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
        
        boolean isInvalidBST = isValidBST(invalidBST);
        System.out.println("  Is valid BST: " + isInvalidBST);
        
        // Same Tree
        TreeNode tree1 = createSampleTree();
        TreeNode tree2 = createSampleTree();
        boolean isSameTree = isSameTree(tree1, tree2);
        System.out.println("\nSame tree check: " + isSameTree);
        
        // Subtree
        TreeNode subtree = new TreeNode(2);
        subtree.left = new TreeNode(4);
        subtree.right = new TreeNode(5);
        boolean isSubtree = isSubtree(tree1, subtree);
        System.out.println("Is subtree: " + isSubtree);
        
        System.out.println();
    }
    
    /**
     * Demonstrates tree serialization
     */
    private static void demonstrateTreeSerialization() {
        System.out.println("7. Tree Serialization:");
        System.out.println("=====================");
        
        TreeNode root = createSampleTree();
        
        // Serialize tree
        String serialized = serialize(root);
        System.out.println("Serialized tree: " + serialized);
        
        // Deserialize tree
        TreeNode deserialized = deserialize(serialized);
        System.out.println("Deserialized tree preorder: " + preorderTraversal(deserialized));
        
        // Check if serialization/deserialization preserved the tree
        boolean isPreserved = isSameTree(root, deserialized);
        System.out.println("Tree preserved after serialization: " + isPreserved);
        
        // Serialize BST
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        
        String bstSerialized = serializeBST(bst.root);
        System.out.println("\nSerialized BST: " + bstSerialized);
        
        TreeNode bstDeserialized = deserializeBST(bstSerialized);
        System.out.println("Deserialized BST inorder: " + inorderTraversal(bstDeserialized));
        
        System.out.println();
    }
    
    /**
     * Demonstrates advanced tree problems
     */
    private static void demonstrateAdvancedProblems() {
        System.out.println("8. Advanced Tree Problems:");
        System.out.println("=========================");
        
        TreeNode root = createSampleTree();
        
        // Binary Tree Right Side View
        java.util.List<Integer> rightView = rightSideView(root);
        System.out.println("Right side view: " + rightView);
        
        // Binary Tree Left Side View
        java.util.List<Integer> leftView = leftSideView(root);
        System.out.println("Left side view: " + leftView);
        
        // Populate Next Right Pointers
        System.out.println("\nPopulate Next Right Pointers:");
        NodeWithNext nodeRoot = createNodeTree();
        connect(nodeRoot);
        System.out.println("Next pointers populated");
        
        // Flatten Binary Tree to Linked List
        TreeNode flattenRoot = createSampleTree();
        flatten(flattenRoot);
        System.out.println("Flattened tree: " + preorderTraversal(flattenRoot));
        
        // Construct Binary Tree from Preorder and Inorder
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode constructed = buildTree(preorder, inorder);
        System.out.println("Constructed tree preorder: " + preorderTraversal(constructed));
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance analysis
     */
    private static void demonstratePerformanceAnalysis() {
        System.out.println("9. Performance Analysis:");
        System.out.println("=======================");
        
        System.out.println("Tree Operation Complexity:");
        System.out.println("------------------------");
        System.out.println("Basic Operations:");
        System.out.println("  Insert (BST):      O(log n) average, O(n) worst");
        System.out.println("  Delete (BST):      O(log n) average, O(n) worst");
        System.out.println("  Search (BST):      O(log n) average, O(n) worst");
        System.out.println("  Height:            O(n)");
        System.out.println("  Size:              O(n)");
        
        System.out.println("\nTree Traversals:");
        System.out.println("  Preorder:          O(n) time, O(h) space");
        System.out.println("  Inorder:           O(n) time, O(h) space");
        System.out.println("  Postorder:         O(n) time, O(h) space");
        System.out.println("  Level Order:       O(n) time, O(w) space");
        System.out.println("  Where h = height, w = maximum width");
        
        System.out.println("\nTree Algorithms:");
        System.out.println("  LCA:               O(n) time, O(h) space");
        System.out.println("  Path Sum:          O(n) time, O(h) space");
        System.out.println("  Tree Validation:   O(n) time, O(h) space");
        System.out.println("  Serialization:     O(n) time, O(n) space");
        System.out.println("  Tree Construction: O(n) time, O(n) space");
        
        System.out.println("\nBalanced Trees (AVL):");
        System.out.println("  Insert:            O(log n) time, O(1) space");
        System.out.println("  Delete:            O(log n) time, O(1) space");
        System.out.println("  Search:            O(log n) time, O(1) space");
        System.out.println("  Rotation:          O(1) time, O(1) space");
        
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
    
    // Node with next pointer for advanced problems
    static class NodeWithNext {
        int val;
        NodeWithNext left;
        NodeWithNext right;
        NodeWithNext next;
        
        NodeWithNext(int val) {
            this.val = val;
        }
    }
    
    // Helper method to create sample tree
    private static TreeNode createSampleTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
    }
    
    private static NodeWithNext createNodeTree() {
        NodeWithNext root = new NodeWithNext(1);
        root.left = new NodeWithNext(2);
        root.right = new NodeWithNext(3);
        root.left.left = new NodeWithNext(4);
        root.left.right = new NodeWithNext(5);
        root.right.left = new NodeWithNext(6);
        root.right.right = new NodeWithNext(7);
        return root;
    }
    
    // Basic Tree Operations Implementation
    
    /**
     * Get tree size
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static int getTreeSize(TreeNode root) {
        if (root == null) return 0;
        return 1 + getTreeSize(root.left) + getTreeSize(root.right);
    }
    
    /**
     * Get tree height
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static int getTreeHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
    }
    
    /**
     * Count leaves
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }
    
    /**
     * Count internal nodes
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static int countInternalNodes(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        return 1 + countInternalNodes(root.left) + countInternalNodes(root.right);
    }
    
    /**
     * Check if tree is complete
     * Time Complexity: O(n), Space Complexity: O(w)
     */
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        boolean foundNull = false;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node == null) {
                foundNull = true;
            } else {
                if (foundNull) return false;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        
        return true;
    }
    
    /**
     * Check if tree is full
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static boolean isFullTree(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.right != null) {
            return isFullTree(root.left) && isFullTree(root.right);
        }
        return false;
    }
    
    // Tree Traversal Implementation
    
    /**
     * Preorder Traversal
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static java.util.List<Integer> preorderTraversal(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        preorderHelper(root, result);
        return result;
    }
    
    private static void preorderHelper(TreeNode root, java.util.List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preorderHelper(root.left, result);
            preorderHelper(root.right, result);
        }
    }
    
    /**
     * Inorder Traversal
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static java.util.List<Integer> inorderTraversal(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
    
    private static void inorderHelper(TreeNode root, java.util.List<Integer> result) {
        if (root != null) {
            inorderHelper(root.left, result);
            result.add(root.val);
            inorderHelper(root.right, result);
        }
    }
    
    /**
     * Postorder Traversal
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static java.util.List<Integer> postorderTraversal(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        postorderHelper(root, result);
        return result;
    }
    
    private static void postorderHelper(TreeNode root, java.util.List<Integer> result) {
        if (root != null) {
            postorderHelper(root.left, result);
            postorderHelper(root.right, result);
            result.add(root.val);
        }
    }
    
    /**
     * Level Order Traversal
     * Time Complexity: O(n), Space Complexity: O(w)
     */
    public static java.util.List<java.util.List<Integer>> levelOrderTraversal(TreeNode root) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if (root == null) return result;
        
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            java.util.List<Integer> currentLevel = new java.util.ArrayList<>();
            
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
     * Zigzag Level Order Traversal
     * Time Complexity: O(n), Space Complexity: O(w)
     */
    public static java.util.List<java.util.List<Integer>> zigzagLevelOrder(TreeNode root) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if (root == null) return result;
        
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            java.util.List<Integer> currentLevel = new java.util.ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                if (leftToRight) {
                    currentLevel.add(node.val);
                } else {
                    currentLevel.add(0, node.val);
                }
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }
        
        return result;
    }
    
    // Binary Search Tree Implementation
    
    /**
     * Binary Search Tree Implementation
     */
    static class BST {
        TreeNode root;
        
        public void insert(int val) {
            root = insertHelper(root, val);
        }
        
        private TreeNode insertHelper(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            
            if (val < root.val) {
                root.left = insertHelper(root.left, val);
            } else if (val > root.val) {
                root.right = insertHelper(root.right, val);
            }
            
            return root;
        }
        
        public boolean search(int val) {
            return searchHelper(root, val);
        }
        
        private boolean searchHelper(TreeNode root, int val) {
            if (root == null) return false;
            if (root.val == val) return true;
            
            if (val < root.val) {
                return searchHelper(root.left, val);
            } else {
                return searchHelper(root.right, val);
            }
        }
        
        public void delete(int val) {
            root = deleteHelper(root, val);
        }
        
        private TreeNode deleteHelper(TreeNode root, int val) {
            if (root == null) return null;
            
            if (val < root.val) {
                root.left = deleteHelper(root.left, val);
            } else if (val > root.val) {
                root.right = deleteHelper(root.right, val);
            } else {
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                
                TreeNode minNode = findMinNode(root.right);
                root.val = minNode.val;
                root.right = deleteHelper(root.right, minNode.val);
            }
            
            return root;
        }
        
        private TreeNode findMinNode(TreeNode root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }
        
        public int findMin() {
            if (root == null) throw new RuntimeException("Tree is empty");
            return findMinNode(root).val;
        }
        
        public int findMax() {
            if (root == null) throw new RuntimeException("Tree is empty");
            TreeNode current = root;
            while (current.right != null) {
                current = current.right;
            }
            return current.val;
        }
        
        public java.util.List<Integer> inorderTraversal() {
            return inorderTraversal(root);
        }
    }
    
    // Tree Properties Implementation
    
    /**
     * Get tree diameter
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static int getTreeDiameter(TreeNode root) {
        int[] diameter = new int[1];
        diameterHelper(root, diameter);
        return diameter[0];
    }
    
    private static int diameterHelper(TreeNode root, int[] diameter) {
        if (root == null) return 0;
        
        int leftHeight = diameterHelper(root.left, diameter);
        int rightHeight = diameterHelper(root.right, diameter);
        
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    /**
     * Maximum path sum
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static int maxPathSum(TreeNode root) {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        maxPathSumHelper(root, maxSum);
        return maxSum[0];
    }
    
    private static int maxPathSumHelper(TreeNode root, int[] maxSum) {
        if (root == null) return 0;
        
        int leftSum = Math.max(0, maxPathSumHelper(root.left, maxSum));
        int rightSum = Math.max(0, maxPathSumHelper(root.right, maxSum));
        
        maxSum[0] = Math.max(maxSum[0], root.val + leftSum + rightSum);
        
        return root.val + Math.max(leftSum, rightSum);
    }
    
    /**
     * Check if tree is balanced
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static boolean isBalancedTree(TreeNode root) {
        return heightHelper(root) != -1;
    }
    
    private static int heightHelper(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = heightHelper(root.left);
        if (leftHeight == -1) return -1;
        
        int rightHeight = heightHelper(root.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    /**
     * Get balance factor
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static int getBalanceFactor(TreeNode root) {
        if (root == null) return 0;
        return getTreeHeight(root.left) - getTreeHeight(root.right);
    }
    
    /**
     * Count nodes at each level
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static java.util.Map<Integer, Integer> countNodesAtLevel(TreeNode root) {
        java.util.Map<Integer, Integer> levelCount = new java.util.HashMap<>();
        countNodesAtLevelHelper(root, 0, levelCount);
        return levelCount;
    }
    
    private static void countNodesAtLevelHelper(TreeNode root, int level, java.util.Map<Integer, Integer> levelCount) {
        if (root == null) return;
        
        levelCount.put(level, levelCount.getOrDefault(level, 0) + 1);
        countNodesAtLevelHelper(root.left, level + 1, levelCount);
        countNodesAtLevelHelper(root.right, level + 1, levelCount);
    }
    
    /**
     * Find deepest node
     * Time Complexity: O(n), Space Complexity: O(w)
     */
    public static TreeNode findDeepestNode(TreeNode root) {
        if (root == null) return null;
        
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        TreeNode deepest = null;
        
        while (!queue.isEmpty()) {
            deepest = queue.poll();
            if (deepest.left != null) queue.offer(deepest.left);
            if (deepest.right != null) queue.offer(deepest.right);
        }
        
        return deepest;
    }
    
    // Tree Algorithms Implementation
    
    /**
     * Lowest Common Ancestor
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
    
    /**
     * Has path sum
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        
        return hasPathSum(root.left, targetSum - root.val) || 
               hasPathSum(root.right, targetSum - root.val);
    }
    
    /**
     * All paths
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static java.util.List<java.util.List<Integer>> allPaths(TreeNode root) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        allPathsHelper(root, new java.util.ArrayList<>(), result);
        return result;
    }
    
    private static void allPathsHelper(TreeNode root, java.util.List<Integer> currentPath, 
                                     java.util.List<java.util.List<Integer>> result) {
        if (root == null) return;
        
        currentPath.add(root.val);
        
        if (root.left == null && root.right == null) {
            result.add(new java.util.ArrayList<>(currentPath));
        } else {
            allPathsHelper(root.left, currentPath, result);
            allPathsHelper(root.right, currentPath, result);
        }
        
        currentPath.remove(currentPath.size() - 1);
    }
    
    /**
     * Path sum II
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static java.util.List<java.util.List<Integer>> pathSum(TreeNode root, int targetSum) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        pathSumHelper(root, targetSum, new java.util.ArrayList<>(), result);
        return result;
    }
    
    private static void pathSumHelper(TreeNode root, int targetSum, java.util.List<Integer> currentPath,
                                    java.util.List<java.util.List<Integer>> result) {
        if (root == null) return;
        
        currentPath.add(root.val);
        
        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new java.util.ArrayList<>(currentPath));
        } else {
            pathSumHelper(root.left, targetSum - root.val, currentPath, result);
            pathSumHelper(root.right, targetSum - root.val, currentPath, result);
        }
        
        currentPath.remove(currentPath.size() - 1);
    }
    
    /**
     * Invert binary tree
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
    
    /**
     * Check if tree is symmetric
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }
    
    private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        
        return left.val == right.val && 
               isSymmetricHelper(left.left, right.right) && 
               isSymmetricHelper(left.right, right.left);
    }
    
    // Tree Validation Implementation
    
    /**
     * Validate BST
     * Time Complexity: O(n), Space Complexity: O(h)
     */
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
     * Check if same tree
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    /**
     * Check if subtree
     * Time Complexity: O(m * n), Space Complexity: O(h)
     */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    // Tree Serialization Implementation
    
    /**
     * Serialize tree
     * Time Complexity: O(n), Space Complexity: O(n)
     */
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
    
    /**
     * Deserialize tree
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static TreeNode deserialize(String data) {
        java.util.Queue<String> queue = new java.util.LinkedList<>(java.util.Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    
    private static TreeNode deserializeHelper(java.util.Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        
        return root;
    }
    
    /**
     * Serialize BST
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static String serializeBST(TreeNode root) {
        if (root == null) return "";
        return root.val + "," + serializeBST(root.left) + "," + serializeBST(root.right);
    }
    
    /**
     * Deserialize BST
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static TreeNode deserializeBST(String data) {
        if (data.isEmpty()) return null;
        java.util.Queue<String> queue = new java.util.LinkedList<>(java.util.Arrays.asList(data.split(",")));
        return deserializeBSTHelper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static TreeNode deserializeBSTHelper(java.util.Queue<String> queue, int min, int max) {
        if (queue.isEmpty()) return null;
        
        int val = Integer.parseInt(queue.peek());
        if (val < min || val > max) return null;
        
        queue.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserializeBSTHelper(queue, min, val);
        root.right = deserializeBSTHelper(queue, val, max);
        
        return root;
    }
    
    // Advanced Problems Implementation
    
    /**
     * Right side view
     * Time Complexity: O(n), Space Complexity: O(w)
     */
    public static java.util.List<Integer> rightSideView(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (root == null) return result;
        
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == levelSize - 1) {
                    result.add(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        
        return result;
    }
    
    /**
     * Left side view
     * Time Complexity: O(n), Space Complexity: O(w)
     */
    public static java.util.List<Integer> leftSideView(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (root == null) return result;
        
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    result.add(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        
        return result;
    }
    
    /**
     * Connect next right pointers
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static NodeWithNext connect(NodeWithNext root) {
        if (root == null) return null;
        
        NodeWithNext leftmost = root;
        while (leftmost.left != null) {
            NodeWithNext head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        
        return root;
    }
    
    /**
     * Flatten binary tree to linked list
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public static void flatten(TreeNode root) {
        if (root == null) return;
        
        flatten(root.left);
        flatten(root.right);
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        root.right = left;
        
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = right;
    }
    
    /**
     * Build tree from preorder and inorder
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        java.util.Map<Integer, Integer> inorderMap = new java.util.HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }
    
    private static TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                          int[] inorder, int inStart, int inEnd,
                                          java.util.Map<Integer, Integer> inorderMap) {
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
}
