package com.tutorial.datastructures.linkedlists;

/**
 * Linked List Algorithms - Comprehensive Guide to Linked List Operations in Java
 * 
 * This comprehensive tutorial demonstrates essential linked list algorithms including
 * insertion, deletion, traversal, and advanced linked list manipulation techniques.
 * Linked lists are fundamental dynamic data structures that provide efficient
 * insertion and deletion operations.
 * 
 * LEARNING OBJECTIVES:
 * - Master singly, doubly, and circular linked list operations
 * - Understand insertion and deletion at different positions
 * - Learn linked list reversal techniques (iterative and recursive)
 * - Practice cycle detection algorithms (Floyd's cycle detection)
 * - Implement merging and intersection algorithms
 * - Understand linked list flattening techniques
 * - Master advanced linked list problems
 * 
 * KEY CONCEPTS:
 * 1. Singly Linked List: Nodes with data and next pointer
 * 2. Doubly Linked List: Nodes with data, next, and previous pointers
 * 3. Circular Linked List: Last node points to first node
 * 4. Two Pointers: Fast and slow pointer technique
 * 5. Cycle Detection: Floyd's cycle detection algorithm
 * 6. List Merging: Combining two sorted linked lists
 * 7. List Intersection: Finding common elements in lists
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class LinkedListAlgorithms {
    
    public static void main(String[] args) {
        System.out.println("=== Linked List Algorithms Demo ===");
        System.out.println();
        
        // 1. Singly Linked List Operations
        demonstrateSinglyLinkedList();
        
        // 2. Doubly Linked List Operations
        demonstrateDoublyLinkedList();
        
        // 3. Circular Linked List Operations
        demonstrateCircularLinkedList();
        
        // 4. Linked List Reversal
        demonstrateLinkedListReversal();
        
        // 5. Cycle Detection
        demonstrateCycleDetection();
        
        // 6. List Merging and Intersection
        demonstrateMergingAndIntersection();
        
        // 7. Advanced Linked List Problems
        demonstrateAdvancedProblems();
        
        // 8. Performance Analysis
        demonstratePerformanceAnalysis();
    }
    
    /**
     * Demonstrates singly linked list operations
     */
    private static void demonstrateSinglyLinkedList() {
        System.out.println("1. Singly Linked List Operations:");
        System.out.println("================================");
        
        SinglyLinkedList list = new SinglyLinkedList();
        
        // Insertion operations
        System.out.println("Insertion Operations:");
        list.insertAtBeginning(3);
        list.insertAtBeginning(2);
        list.insertAtBeginning(1);
        System.out.println("  After inserting at beginning: " + list);
        
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        System.out.println("  After inserting at end: " + list);
        
        list.insertAtPosition(10, 2);
        System.out.println("  After inserting 10 at position 2: " + list);
        
        // Deletion operations
        System.out.println("\nDeletion Operations:");
        list.deleteAtBeginning();
        System.out.println("  After deleting from beginning: " + list);
        
        list.deleteAtEnd();
        System.out.println("  After deleting from end: " + list);
        
        list.deleteAtPosition(1);
        System.out.println("  After deleting at position 1: " + list);
        
        // Search operation
        System.out.println("\nSearch Operations:");
        boolean found = list.search(10);
        System.out.println("  Search for 10: " + found);
        
        int length = list.getLength();
        System.out.println("  List length: " + length);
        
        System.out.println();
    }
    
    /**
     * Demonstrates doubly linked list operations
     */
    private static void demonstrateDoublyLinkedList() {
        System.out.println("2. Doubly Linked List Operations:");
        System.out.println("=================================");
        
        DoublyLinkedList list = new DoublyLinkedList();
        
        // Insertion operations
        System.out.println("Insertion Operations:");
        list.insertAtBeginning(3);
        list.insertAtBeginning(2);
        list.insertAtBeginning(1);
        System.out.println("  After inserting at beginning: " + list);
        
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        System.out.println("  After inserting at end: " + list);
        
        list.insertAtPosition(10, 2);
        System.out.println("  After inserting 10 at position 2: " + list);
        
        // Traversal operations
        System.out.println("\nTraversal Operations:");
        System.out.println("  Forward traversal: " + list);
        System.out.println("  Backward traversal: " + list.backwardTraversal());
        
        // Deletion operations
        System.out.println("\nDeletion Operations:");
        list.deleteAtBeginning();
        System.out.println("  After deleting from beginning: " + list);
        
        list.deleteAtEnd();
        System.out.println("  After deleting from end: " + list);
        
        list.deleteAtPosition(1);
        System.out.println("  After deleting at position 1: " + list);
        
        System.out.println();
    }
    
    /**
     * Demonstrates circular linked list operations
     */
    private static void demonstrateCircularLinkedList() {
        System.out.println("3. Circular Linked List Operations:");
        System.out.println("===================================");
        
        CircularLinkedList list = new CircularLinkedList();
        
        // Insertion operations
        System.out.println("Insertion Operations:");
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        System.out.println("  After inserting elements: " + list);
        
        // Deletion operations
        System.out.println("\nDeletion Operations:");
        list.delete(2);
        System.out.println("  After deleting 2: " + list);
        
        // Search operation
        System.out.println("\nSearch Operations:");
        boolean found = list.search(3);
        System.out.println("  Search for 3: " + found);
        
        // Display operations
        System.out.println("\nDisplay Operations:");
        list.display();
        
        System.out.println();
    }
    
    /**
     * Demonstrates linked list reversal
     */
    private static void demonstrateLinkedListReversal() {
        System.out.println("4. Linked List Reversal:");
        System.out.println("=======================");
        
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        
        System.out.println("Original list: " + list);
        
        // Iterative reversal
        SinglyLinkedList reversedIterative = new SinglyLinkedList();
        reversedIterative.head = reverseIterative(list.head);
        System.out.println("Iterative reversal: " + reversedIterative);
        
        // Recursive reversal
        SinglyLinkedList reversedRecursive = new SinglyLinkedList();
        reversedRecursive.head = reverseRecursive(list.head);
        System.out.println("Recursive reversal: " + reversedRecursive);
        
        // Reverse in groups
        SinglyLinkedList groupReversed = new SinglyLinkedList();
        groupReversed.head = reverseInGroups(list.head, 2);
        System.out.println("Reverse in groups of 2: " + groupReversed);
        
        System.out.println();
    }
    
    /**
     * Demonstrates cycle detection
     */
    private static void demonstrateCycleDetection() {
        System.out.println("5. Cycle Detection:");
        System.out.println("==================");
        
        // Create a list with cycle
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        
        // Create cycle: 5 -> 2
        SinglyLinkedList.Node last = list.head;
        while (last.next != null) {
            last = last.next;
        }
        SinglyLinkedList.Node cycleNode = list.head.next; // Node with value 2
        last.next = cycleNode;
        
        System.out.println("List with cycle created (5 -> 2)");
        
        // Floyd's cycle detection
        boolean hasCycle = hasCycle(list.head);
        System.out.println("Has cycle (Floyd's algorithm): " + hasCycle);
        
        if (hasCycle) {
            SinglyLinkedList.Node cycleStart = detectCycleStart(list.head);
            System.out.println("Cycle starts at node with value: " + cycleStart.data);
            
            int cycleLength = getCycleLength(list.head);
            System.out.println("Cycle length: " + cycleLength);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates merging and intersection
     */
    private static void demonstrateMergingAndIntersection() {
        System.out.println("6. List Merging and Intersection:");
        System.out.println("=================================");
        
        // Merge two sorted lists
        System.out.println("Merge Two Sorted Lists:");
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.insertAtEnd(1);
        list1.insertAtEnd(3);
        list1.insertAtEnd(5);
        list1.insertAtEnd(7);
        
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertAtEnd(2);
        list2.insertAtEnd(4);
        list2.insertAtEnd(6);
        list2.insertAtEnd(8);
        
        System.out.println("  List 1: " + list1);
        System.out.println("  List 2: " + list2);
        
        SinglyLinkedList merged = new SinglyLinkedList();
        merged.head = mergeSortedLists(list1.head, list2.head);
        System.out.println("  Merged list: " + merged);
        
        // Intersection of two lists
        System.out.println("\nIntersection of Two Lists:");
        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.insertAtEnd(1);
        list3.insertAtEnd(2);
        list3.insertAtEnd(3);
        list3.insertAtEnd(4);
        
        SinglyLinkedList list4 = new SinglyLinkedList();
        list4.insertAtEnd(3);
        list4.insertAtEnd(4);
        list4.insertAtEnd(5);
        list4.insertAtEnd(6);
        
        System.out.println("  List 3: " + list3);
        System.out.println("  List 4: " + list4);
        
        SinglyLinkedList intersection = new SinglyLinkedList();
        intersection.head = getIntersection(list3.head, list4.head);
        System.out.println("  Intersection: " + intersection);
        
        System.out.println();
    }
    
    /**
     * Demonstrates advanced linked list problems
     */
    private static void demonstrateAdvancedProblems() {
        System.out.println("7. Advanced Linked List Problems:");
        System.out.println("=================================");
        
        // Remove Nth node from end
        System.out.println("Remove Nth Node From End:");
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        
        System.out.println("  Original list: " + list);
        SinglyLinkedList.Node removed = removeNthFromEnd(list.head, 2);
        SinglyLinkedList result = new SinglyLinkedList();
        result.head = removed;
        System.out.println("  After removing 2nd from end: " + result);
        
        // Swap nodes in pairs
        System.out.println("\nSwap Nodes in Pairs:");
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertAtEnd(1);
        list2.insertAtEnd(2);
        list2.insertAtEnd(3);
        list2.insertAtEnd(4);
        
        System.out.println("  Original list: " + list2);
        SinglyLinkedList.Node swapped = swapPairs(list2.head);
        SinglyLinkedList result2 = new SinglyLinkedList();
        result2.head = swapped;
        System.out.println("  After swapping pairs: " + result2);
        
        // Rotate list
        System.out.println("\nRotate List:");
        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.insertAtEnd(1);
        list3.insertAtEnd(2);
        list3.insertAtEnd(3);
        list3.insertAtEnd(4);
        list3.insertAtEnd(5);
        
        System.out.println("  Original list: " + list3);
        SinglyLinkedList.Node rotated = rotateList(list3.head, 2);
        SinglyLinkedList result3 = new SinglyLinkedList();
        result3.head = rotated;
        System.out.println("  After rotating by 2: " + result3);
        
        // Copy list with random pointer
        System.out.println("\nCopy List with Random Pointer:");
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next;
        
        RandomListNode copied = copyRandomList(head);
        System.out.println("  Original: " + head);
        System.out.println("  Copied: " + copied);
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance analysis
     */
    private static void demonstratePerformanceAnalysis() {
        System.out.println("8. Performance Analysis:");
        System.out.println("=======================");
        
        System.out.println("Linked List Operation Complexity:");
        System.out.println("--------------------------------");
        System.out.println("Singly Linked List:");
        System.out.println("  Insertion at beginning: O(1) time, O(1) space");
        System.out.println("  Insertion at end:       O(n) time, O(1) space");
        System.out.println("  Insertion at position:  O(n) time, O(1) space");
        System.out.println("  Deletion at beginning:  O(1) time, O(1) space");
        System.out.println("  Deletion at end:        O(n) time, O(1) space");
        System.out.println("  Deletion at position:   O(n) time, O(1) space");
        System.out.println("  Search:                 O(n) time, O(1) space");
        System.out.println("  Traversal:              O(n) time, O(1) space");
        
        System.out.println("\nDoubly Linked List:");
        System.out.println("  Insertion at beginning: O(1) time, O(1) space");
        System.out.println("  Insertion at end:       O(1) time, O(1) space");
        System.out.println("  Insertion at position:  O(n) time, O(1) space");
        System.out.println("  Deletion at beginning:  O(1) time, O(1) space");
        System.out.println("  Deletion at end:        O(1) time, O(1) space");
        System.out.println("  Deletion at position:   O(n) time, O(1) space");
        System.out.println("  Search:                 O(n) time, O(1) space");
        System.out.println("  Traversal:              O(n) time, O(1) space");
        
        System.out.println("\nAdvanced Operations:");
        System.out.println("  Reversal (iterative):   O(n) time, O(1) space");
        System.out.println("  Reversal (recursive):   O(n) time, O(n) space");
        System.out.println("  Cycle detection:        O(n) time, O(1) space");
        System.out.println("  Merge sorted lists:     O(m + n) time, O(1) space");
        System.out.println("  Find intersection:      O(m + n) time, O(1) space");
        
        System.out.println();
    }
    
    // Singly Linked List Implementation
    
    static class SinglyLinkedList {
        Node head;
        
        static class Node {
            int data;
            Node next;
            
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
        
        // Insert at beginning
        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        
        // Insert at end
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        
        // Insert at position
        public void insertAtPosition(int data, int position) {
            if (position < 0) return;
            
            if (position == 0) {
                insertAtBeginning(data);
                return;
            }
            
            Node newNode = new Node(data);
            Node current = head;
            
            for (int i = 0; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            
            if (current == null) return;
            
            newNode.next = current.next;
            current.next = newNode;
        }
        
        // Delete at beginning
        public void deleteAtBeginning() {
            if (head == null) return;
            head = head.next;
        }
        
        // Delete at end
        public void deleteAtEnd() {
            if (head == null) return;
            if (head.next == null) {
                head = null;
                return;
            }
            
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        
        // Delete at position
        public void deleteAtPosition(int position) {
            if (head == null || position < 0) return;
            
            if (position == 0) {
                deleteAtBeginning();
                return;
            }
            
            Node current = head;
            for (int i = 0; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            
            if (current == null || current.next == null) return;
            
            current.next = current.next.next;
        }
        
        // Search
        public boolean search(int data) {
            Node current = head;
            while (current != null) {
                if (current.data == data) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
        
        // Get length
        public int getLength() {
            int count = 0;
            Node current = head;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node current = head;
            while (current != null) {
                sb.append(current.data);
                if (current.next != null) {
                    sb.append(" -> ");
                }
                current = current.next;
            }
            return sb.toString();
        }
    }
    
    // Doubly Linked List Implementation
    
    static class DoublyLinkedList {
        Node head;
        Node tail;
        
        static class Node {
            int data;
            Node next;
            Node prev;
            
            Node(int data) {
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }
        
        // Insert at beginning
        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        
        // Insert at end
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        
        // Insert at position
        public void insertAtPosition(int data, int position) {
            if (position < 0) return;
            
            if (position == 0) {
                insertAtBeginning(data);
                return;
            }
            
            Node current = head;
            for (int i = 0; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            
            if (current == null) return;
            
            Node newNode = new Node(data);
            newNode.next = current.next;
            newNode.prev = current;
            
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;
            }
            
            current.next = newNode;
        }
        
        // Delete at beginning
        public void deleteAtBeginning() {
            if (head == null) return;
            
            if (head == tail) {
                head = tail = null;
                return;
            }
            
            head = head.next;
            head.prev = null;
        }
        
        // Delete at end
        public void deleteAtEnd() {
            if (head == null) return;
            
            if (head == tail) {
                head = tail = null;
                return;
            }
            
            tail = tail.prev;
            tail.next = null;
        }
        
        // Delete at position
        public void deleteAtPosition(int position) {
            if (head == null || position < 0) return;
            
            if (position == 0) {
                deleteAtBeginning();
                return;
            }
            
            Node current = head;
            for (int i = 0; i < position && current != null; i++) {
                current = current.next;
            }
            
            if (current == null) return;
            
            if (current == tail) {
                deleteAtEnd();
                return;
            }
            
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        
        // Backward traversal
        public String backwardTraversal() {
            StringBuilder sb = new StringBuilder();
            Node current = tail;
            while (current != null) {
                sb.append(current.data);
                if (current.prev != null) {
                    sb.append(" <- ");
                }
                current = current.prev;
            }
            return sb.toString();
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node current = head;
            while (current != null) {
                sb.append(current.data);
                if (current.next != null) {
                    sb.append(" <-> ");
                }
                current = current.next;
            }
            return sb.toString();
        }
    }
    
    // Circular Linked List Implementation
    
    static class CircularLinkedList {
        Node head;
        
        static class Node {
            int data;
            Node next;
            
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
        
        // Insert
        public void insert(int data) {
            Node newNode = new Node(data);
            
            if (head == null) {
                head = newNode;
                head.next = head;
                return;
            }
            
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            
            current.next = newNode;
            newNode.next = head;
        }
        
        // Delete
        public void delete(int data) {
            if (head == null) return;
            
            if (head.data == data) {
                if (head.next == head) {
                    head = null;
                    return;
                }
                
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                
                current.next = head.next;
                head = head.next;
                return;
            }
            
            Node current = head;
            while (current.next != head && current.next.data != data) {
                current = current.next;
            }
            
            if (current.next != head) {
                current.next = current.next.next;
            }
        }
        
        // Search
        public boolean search(int data) {
            if (head == null) return false;
            
            Node current = head;
            do {
                if (current.data == data) {
                    return true;
                }
                current = current.next;
            } while (current != head);
            
            return false;
        }
        
        // Display
        public void display() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            
            Node current = head;
            do {
                System.out.print(current.data + " -> ");
                current = current.next;
            } while (current != head);
            System.out.println("(back to " + head.data + ")");
        }
        
        @Override
        public String toString() {
            if (head == null) return "Empty";
            
            StringBuilder sb = new StringBuilder();
            Node current = head;
            do {
                sb.append(current.data);
                if (current.next != head) {
                    sb.append(" -> ");
                }
                current = current.next;
            } while (current != head);
            
            return sb.toString() + " -> (back to " + head.data + ")";
        }
    }
    
    // Advanced Algorithms Implementation
    
    /**
     * Reverse Linked List Iteratively
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static SinglyLinkedList.Node reverseIterative(SinglyLinkedList.Node head) {
        SinglyLinkedList.Node prev = null;
        SinglyLinkedList.Node current = head;
        SinglyLinkedList.Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    /**
     * Reverse Linked List Recursively
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static SinglyLinkedList.Node reverseRecursive(SinglyLinkedList.Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        SinglyLinkedList.Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
    
    /**
     * Reverse Linked List in Groups
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static SinglyLinkedList.Node reverseInGroups(SinglyLinkedList.Node head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        
        SinglyLinkedList.Node current = head;
        SinglyLinkedList.Node prev = null;
        SinglyLinkedList.Node next = null;
        int count = 0;
        
        // Reverse first k nodes
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        
        // Recursively reverse remaining nodes
        if (next != null) {
            head.next = reverseInGroups(next, k);
        }
        
        return prev;
    }
    
    /**
     * Floyd's Cycle Detection Algorithm
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static boolean hasCycle(SinglyLinkedList.Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        SinglyLinkedList.Node slow = head;
        SinglyLinkedList.Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Detect Cycle Start Node
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static SinglyLinkedList.Node detectCycleStart(SinglyLinkedList.Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        SinglyLinkedList.Node slow = head;
        SinglyLinkedList.Node fast = head;
        
        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                break;
            }
        }
        
        if (fast == null || fast.next == null) {
            return null; // No cycle
        }
        
        // Find cycle start
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
    
    /**
     * Get Cycle Length
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int getCycleLength(SinglyLinkedList.Node head) {
        if (head == null || head.next == null) {
            return 0;
        }
        
        SinglyLinkedList.Node slow = head;
        SinglyLinkedList.Node fast = head;
        
        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                break;
            }
        }
        
        if (fast == null || fast.next == null) {
            return 0; // No cycle
        }
        
        // Count cycle length
        int length = 1;
        fast = fast.next;
        while (slow != fast) {
            fast = fast.next;
            length++;
        }
        
        return length;
    }
    
    /**
     * Merge Two Sorted Lists
     * Time Complexity: O(m + n), Space Complexity: O(1)
     */
    public static SinglyLinkedList.Node mergeSortedLists(SinglyLinkedList.Node list1, SinglyLinkedList.Node list2) {
        SinglyLinkedList.Node dummy = new SinglyLinkedList.Node(0);
        SinglyLinkedList.Node current = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        if (list1 != null) {
            current.next = list1;
        }
        
        if (list2 != null) {
            current.next = list2;
        }
        
        return dummy.next;
    }
    
    /**
     * Get Intersection of Two Lists
     * Time Complexity: O(m + n), Space Complexity: O(1)
     */
    public static SinglyLinkedList.Node getIntersection(SinglyLinkedList.Node headA, SinglyLinkedList.Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        SinglyLinkedList.Node a = headA;
        SinglyLinkedList.Node b = headB;
        
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        
        return a;
    }
    
    /**
     * Remove Nth Node From End
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static SinglyLinkedList.Node removeNthFromEnd(SinglyLinkedList.Node head, int n) {
        SinglyLinkedList.Node dummy = new SinglyLinkedList.Node(0);
        dummy.next = head;
        
        SinglyLinkedList.Node first = dummy;
        SinglyLinkedList.Node second = dummy;
        
        // Move first n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // Move both pointers until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove the nth node
        second.next = second.next.next;
        
        return dummy.next;
    }
    
    /**
     * Swap Nodes in Pairs
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static SinglyLinkedList.Node swapPairs(SinglyLinkedList.Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        SinglyLinkedList.Node dummy = new SinglyLinkedList.Node(0);
        dummy.next = head;
        SinglyLinkedList.Node prev = dummy;
        
        while (prev.next != null && prev.next.next != null) {
            SinglyLinkedList.Node first = prev.next;
            SinglyLinkedList.Node second = prev.next.next;
            
            // Swap
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            // Move prev
            prev = first;
        }
        
        return dummy.next;
    }
    
    /**
     * Rotate List
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static SinglyLinkedList.Node rotateList(SinglyLinkedList.Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Find length and last node
        int length = 1;
        SinglyLinkedList.Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        // Normalize k
        k = k % length;
        if (k == 0) {
            return head;
        }
        
        // Find new tail
        SinglyLinkedList.Node newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        
        // Rotate
        SinglyLinkedList.Node newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        
        return newHead;
    }
    
    // Random List Node for advanced problems
    
    static class RandomListNode {
        int val;
        RandomListNode next;
        RandomListNode random;
        
        RandomListNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            RandomListNode current = this;
            while (current != null) {
                sb.append(current.val);
                if (current.random != null) {
                    sb.append("(").append(current.random.val).append(")");
                }
                if (current.next != null) {
                    sb.append(" -> ");
                }
                current = current.next;
            }
            return sb.toString();
        }
    }
    
    /**
     * Copy List with Random Pointer
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        // Step 1: Create new nodes and insert them after original nodes
        RandomListNode current = head;
        while (current != null) {
            RandomListNode newNode = new RandomListNode(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }
        
        // Step 2: Set random pointers for new nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        
        // Step 3: Separate original and new lists
        RandomListNode newHead = head.next;
        current = head;
        while (current != null) {
            RandomListNode newNode = current.next;
            current.next = newNode.next;
            if (newNode.next != null) {
                newNode.next = newNode.next.next;
            }
            current = current.next;
        }
        
        return newHead;
    }
}
