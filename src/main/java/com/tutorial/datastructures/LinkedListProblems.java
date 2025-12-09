package com.tutorial.datastructures;

import java.util.*;

/**
 * Linked List Problems - Comprehensive Solutions
 * 
 * This comprehensive implementation covers all essential linked list problems
 * commonly asked in technical interviews. Each solution includes detailed explanations,
 * time/space complexity analysis, and multiple approaches where applicable.
 * 
 * PROBLEMS COVERED:
 * 1. Reverse a Linked List (Easy) - Classic iterative and recursive problem
 * 2. Detect Cycle in a Linked List (Easy) - Floyd's Cycle Detection Algorithm
 * 3. Merge Two Sorted Lists (Easy) - Merge two sorted linked lists
 * 4. Merge k Sorted Lists (Hard) - Efficiently merge multiple sorted lists
 * 5. Remove Nth Node From End of List (Medium) - Two-pointer technique
 * 6. Reorder List (Medium) - L0 → Ln → L1 → Ln-1 ...
 * 7. Copy List with Random Pointer (Medium) - Deep copy a linked list with random pointer
 * 8. Add Two Numbers (Medium) - Add two numbers represented as linked lists
 * 9. Remove Duplicates from Sorted List (Easy) - Remove duplicates from sorted list
 * 10. Remove Duplicates from Sorted List II (Medium) - Remove all duplicates
 * 11. Rotate List (Medium) - Rotate list to the right by k places
 * 12. Partition List (Medium) - Partition list around a value x
 * 13. Sort List (Medium) - Sort linked list using merge sort
 * 14. Intersection of Two Linked Lists (Easy) - Find intersection point
 * 15. Palindrome Linked List (Easy) - Check if linked list is palindrome
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class LinkedListProblems {

    // ListNode definition for all problems
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                sb.append(current.val);
                if (current.next != null) {
                    sb.append(" -> ");
                }
                current = current.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Linked List Problems ===");
        System.out.println();
        
        // Run all problem demonstrations
        demonstrateReverseLinkedList();
        demonstrateDetectCycle();
        demonstrateMergeTwoSortedLists();
        demonstrateMergeKSortedLists();
        demonstrateRemoveNthFromEnd();
        demonstrateReorderList();
        demonstrateCopyListWithRandomPointer();
        demonstrateAddTwoNumbers();
        demonstrateRemoveDuplicates();
        demonstrateRemoveDuplicatesII();
        demonstrateRotateList();
        demonstratePartitionList();
        demonstrateSortList();
        demonstrateIntersectionOfTwoLists();
        demonstratePalindromeLinkedList();
    }

    /**
     * 1. Reverse a Linked List (Easy)
     * Classic iterative and recursive problem
     * Time: O(n), Space: O(1) iterative, O(n) recursive
     */
    public static void demonstrateReverseLinkedList() {
        System.out.println("1. Reverse a Linked List (Easy):");
        System.out.println("===============================");
        
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original: " + head);
        
        // Iterative approach
        ListNode reversedIterative = reverseListIterative(head);
        System.out.println("Reversed (Iterative): " + reversedIterative);
        
        // Recursive approach
        ListNode head2 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode reversedRecursive = reverseListRecursive(head2);
        System.out.println("Reversed (Recursive): " + reversedRecursive);
        
        System.out.println("Time: O(n), Space: O(1) iterative, O(n) recursive");
        System.out.println();
    }

    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }

    /**
     * 2. Detect Cycle in a Linked List (Easy)
     * Floyd's Cycle Detection Algorithm
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateDetectCycle() {
        System.out.println("2. Detect Cycle in a Linked List (Easy):");
        System.out.println("=======================================");
        
        // Create list without cycle
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("List without cycle: " + head1);
        System.out.println("Has cycle: " + hasCycle(head1));
        
        // Create list with cycle
        ListNode head2 = createList(new int[]{1, 2, 3, 4, 5});
        // Create cycle: 5 -> 2
        ListNode tail = head2;
        while (tail.next != null) tail = tail.next;
        tail.next = head2.next; // 5 -> 2
        
        System.out.println("List with cycle (5 -> 2): Has cycle: " + hasCycle(head2));
        
        ListNode cycleStart = detectCycleStart(head2);
        System.out.println("Cycle starts at: " + (cycleStart != null ? cycleStart.val : "No cycle"));
        
        System.out.println("Time: O(n), Space: O(1)");
        System.out.println();
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }

    public static ListNode detectCycleStart(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
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
     * 3. Merge Two Sorted Lists (Easy)
     * Merge two sorted linked lists
     * Time: O(m + n), Space: O(1)
     */
    public static void demonstrateMergeTwoSortedLists() {
        System.out.println("3. Merge Two Sorted Lists (Easy):");
        System.out.println("=================================");
        
        ListNode list1 = createList(new int[]{1, 2, 4});
        ListNode list2 = createList(new int[]{1, 3, 4});
        
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        
        ListNode merged = mergeTwoLists(list1, list2);
        System.out.println("Merged: " + merged);
        
        System.out.println("Time: O(m + n), Space: O(1)");
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
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
     * 4. Merge k Sorted Lists (Hard)
     * Efficiently merge multiple sorted lists
     * Time: O(n log k), Space: O(k)
     */
    public static void demonstrateMergeKSortedLists() {
        System.out.println("4. Merge k Sorted Lists (Hard):");
        System.out.println("===============================");
        
        ListNode[] lists = {
            createList(new int[]{1, 4, 5}),
            createList(new int[]{1, 3, 4}),
            createList(new int[]{2, 6})
        };
        
        System.out.println("Lists:");
        for (int i = 0; i < lists.length; i++) {
            System.out.println("  List " + (i + 1) + ": " + lists[i]);
        }
        
        ListNode merged = mergeKLists(lists);
        System.out.println("Merged: " + merged);
        
        System.out.println("Time: O(n log k), Space: O(k)");
        System.out.println();
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add first node of each list to heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;
            
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        
        return dummy.next;
    }

    /**
     * 5. Remove Nth Node From End of List (Medium)
     * Two-pointer technique
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateRemoveNthFromEnd() {
        System.out.println("5. Remove Nth Node From End of List (Medium):");
        System.out.println("============================================");
        
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        int n = 2;
        
        System.out.println("Original: " + head);
        System.out.println("Remove " + n + "th from end");
        
        ListNode result = removeNthFromEnd(head, n);
        System.out.println("Result: " + result);
        
        System.out.println("Time: O(n), Space: O(1)");
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode first = dummy;
        ListNode second = dummy;
        
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
     * 6. Reorder List (Medium)
     * L0 → Ln → L1 → Ln-1 ...
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateReorderList() {
        System.out.println("6. Reorder List (Medium):");
        System.out.println("=========================");
        
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original: " + head);
        
        reorderList(head);
        System.out.println("Reordered: " + head);
        
        System.out.println("Time: O(n), Space: O(1)");
        System.out.println();
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        // Find middle
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Split into two halves
        ListNode secondHalf = slow.next;
        slow.next = null;
        
        // Reverse second half
        secondHalf = reverseListIterative(secondHalf);
        
        // Merge alternately
        ListNode first = head;
        ListNode second = secondHalf;
        
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            
            first.next = second;
            second.next = temp1;
            
            first = temp1;
            second = temp2;
        }
    }

    /**
     * 7. Copy List with Random Pointer (Medium)
     * Deep copy a linked list with random pointer
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateCopyListWithRandomPointer() {
        System.out.println("7. Copy List with Random Pointer (Medium):");
        System.out.println("=========================================");
        
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next;
        
        System.out.println("Original: " + head);
        
        RandomListNode copied = copyRandomList(head);
        System.out.println("Copied: " + copied);
        
        System.out.println("Time: O(n), Space: O(1)");
        System.out.println();
    }

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

    /**
     * 8. Add Two Numbers (Medium)
     * Add two numbers represented as linked lists
     * Time: O(max(m, n)), Space: O(max(m, n))
     */
    public static void demonstrateAddTwoNumbers() {
        System.out.println("8. Add Two Numbers (Medium):");
        System.out.println("============================");
        
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});
        
        System.out.println("Number 1: " + l1);
        System.out.println("Number 2: " + l2);
        
        ListNode sum = addTwoNumbers(l1, l2);
        System.out.println("Sum: " + sum);
        
        System.out.println("Time: O(max(m, n)), Space: O(max(m, n))");
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        return dummy.next;
    }

    /**
     * 9. Remove Duplicates from Sorted List (Easy)
     * Remove duplicates from sorted list
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateRemoveDuplicates() {
        System.out.println("9. Remove Duplicates from Sorted List (Easy):");
        System.out.println("============================================");
        
        ListNode head = createList(new int[]{1, 1, 2, 3, 3});
        System.out.println("Original: " + head);
        
        ListNode result = deleteDuplicates(head);
        System.out.println("After removing duplicates: " + result);
        
        System.out.println("Time: O(n), Space: O(1)");
        System.out.println();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return head;
    }

    /**
     * 10. Remove Duplicates from Sorted List II (Medium)
     * Remove all duplicates
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateRemoveDuplicatesII() {
        System.out.println("10. Remove Duplicates from Sorted List II (Medium):");
        System.out.println("==================================================");
        
        ListNode head = createList(new int[]{1, 2, 3, 3, 4, 4, 5});
        System.out.println("Original: " + head);
        
        ListNode result = deleteDuplicatesII(head);
        System.out.println("After removing all duplicates: " + result);
        
        System.out.println("Time: O(n), Space: O(1)");
        System.out.println();
    }

    public static ListNode deleteDuplicatesII(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode current = head;
        
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                int val = current.val;
                while (current != null && current.val == val) {
                    current = current.next;
                }
                prev.next = current;
            } else {
                prev = current;
                current = current.next;
            }
        }
        
        return dummy.next;
    }

    /**
     * 11. Rotate List (Medium)
     * Rotate list to the right by k places
     * Time: O(n), Space: O(1)
     */
    public static void demonstrateRotateList() {
        System.out.println("11. Rotate List (Medium):");
        System.out.println("=========================");
        
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        int k = 2;
        
        System.out.println("Original: " + head);
        System.out.println("Rotate by " + k + " positions");
        
        ListNode rotated = rotateRight(head, k);
        System.out.println("Rotated: " + rotated);
        
        System.out.println("Time: O(n), Space: O(1)");
        System.out.println();
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Find length and last node
        int length = 1;
        ListNode tail = head;
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
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        
        // Rotate
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        
        return newHead;
    }

    /**
     * 12. Partition List (Medium)
     * Partition list around a value x
     * Time: O(n), Space: O(1)
     */
    public static void demonstratePartitionList() {
        System.out.println("12. Partition List (Medium):");
        System.out.println("===========================");
        
        ListNode head = createList(new int[]{1, 4, 3, 2, 5, 2});
        int x = 3;
        
        System.out.println("Original: " + head);
        System.out.println("Partition around " + x);
        
        ListNode partitioned = partition(head, x);
        System.out.println("Partitioned: " + partitioned);
        
        System.out.println("Time: O(n), Space: O(1)");
        System.out.println();
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;
        
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        
        after.next = null;
        before.next = afterHead.next;
        
        return beforeHead.next;
    }

    /**
     * 13. Sort List (Medium)
     * Sort linked list using merge sort
     * Time: O(n log n), Space: O(log n)
     */
    public static void demonstrateSortList() {
        System.out.println("13. Sort List (Medium):");
        System.out.println("=======================");
        
        ListNode head = createList(new int[]{4, 2, 1, 3});
        System.out.println("Original: " + head);
        
        ListNode sorted = sortList(head);
        System.out.println("Sorted: " + sorted);
        
        System.out.println("Time: O(n log n), Space: O(log n)");
        System.out.println();
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Find middle
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Split into two halves
        prev.next = null;
        
        // Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        // Merge sorted halves
        return mergeTwoLists(left, right);
    }

    /**
     * 14. Intersection of Two Linked Lists (Easy)
     * Find intersection point
     * Time: O(m + n), Space: O(1)
     */
    public static void demonstrateIntersectionOfTwoLists() {
        System.out.println("14. Intersection of Two Linked Lists (Easy):");
        System.out.println("===========================================");
        
        // Create intersecting lists
        ListNode common = createList(new int[]{8, 4, 5});
        ListNode listA = createList(new int[]{4, 1});
        ListNode listB = createList(new int[]{5, 6, 1});
        
        // Connect to common part
        ListNode tailA = listA;
        while (tailA.next != null) tailA = tailA.next;
        tailA.next = common;
        
        ListNode tailB = listB;
        while (tailB.next != null) tailB = tailB.next;
        tailB.next = common;
        
        System.out.println("List A: " + listA);
        System.out.println("List B: " + listB);
        
        ListNode intersection = getIntersectionNode(listA, listB);
        System.out.println("Intersection point: " + (intersection != null ? intersection.val : "None"));
        
        System.out.println("Time: O(m + n), Space: O(1)");
        System.out.println();
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        
        return a;
    }

    /**
     * 15. Palindrome Linked List (Easy)
     * Check if linked list is palindrome
     * Time: O(n), Space: O(1)
     */
    public static void demonstratePalindromeLinkedList() {
        System.out.println("15. Palindrome Linked List (Easy):");
        System.out.println("=================================");
        
        ListNode head1 = createList(new int[]{1, 2, 2, 1});
        ListNode head2 = createList(new int[]{1, 2, 3, 4});
        
        System.out.println("List 1: " + head1);
        System.out.println("Is palindrome: " + isPalindrome(head1));
        
        System.out.println("List 2: " + head2);
        System.out.println("Is palindrome: " + isPalindrome(head2));
        
        System.out.println("Time: O(n), Space: O(1)");
        System.out.println();
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        // Find middle
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        ListNode secondHalf = reverseListIterative(slow.next);
        
        // Compare first half with reversed second half
        ListNode first = head;
        ListNode second = secondHalf;
        
        while (second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        
        return true;
    }

    // Utility methods

    public static ListNode createList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        
        return head;
    }
}
