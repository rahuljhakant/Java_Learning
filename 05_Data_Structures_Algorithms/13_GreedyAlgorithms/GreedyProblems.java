package GreedyAlgorithms;

import java.util.*;

/**
 * Greedy Algorithm Problems - Comprehensive Solutions
 * 
 * This class contains solutions to fundamental greedy algorithm problems including:
 * - Jump game variations
 * - Gas station problems
 * - Partition and scheduling problems
 * - Activity selection problems
 * - Minimum spanning tree concepts
 * - Huffman coding concepts
 * - Fractional knapsack
 * - Meeting room problems
 * 
 * Each problem includes detailed comments on approach, time and space complexity.
 */
public class GreedyProblems {

    // ==================== JUMP GAME PROBLEMS ====================

    /**
     * Problem: Jump Game
     * Given an array of non-negative integers nums, you are initially positioned at the first index.
     * Each element in the array represents your maximum jump length at that position.
     * Return true if you can reach the last index, or false otherwise.
     * 
     * Approach: Greedy - track the farthest reachable position
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean canJump(int[] nums) {
        int farthest = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false; // Cannot reach current position
            }
            farthest = Math.max(farthest, i + nums[i]);
        }
        
        return true;
    }

    /**
     * Problem: Jump Game II
     * Return the minimum number of jumps to reach the last index.
     * 
     * Approach: Greedy - track current jump end and next jump end
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        
        return jumps;
    }

    // ==================== GAS STATION PROBLEMS ====================

    /**
     * Problem: Gas Station
     * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
     * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
     * 
     * Approach: Greedy - if total gas >= total cost, solution exists
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startStation = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
            
            // If current tank is negative, reset and try next station
            if (currentTank < 0) {
                startStation = i + 1;
                currentTank = 0;
            }
        }
        
        return totalTank >= 0 ? startStation : -1;
    }

    // ==================== PARTITION PROBLEMS ====================

    /**
     * Problem: Partition Labels
     * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible
     * so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
     * 
     * Approach: Greedy - track last occurrence of each character
     * Time Complexity: O(n)
     * Space Complexity: O(1) - at most 26 characters
     */
    public List<Integer> partitionLabels(String s) {
        int[] lastOccurrence = new int[26];
        
        // Find last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);
            
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }

    /**
     * Problem: Partition Array into Disjoint Intervals
     * Given an array nums, partition it into two (contiguous) subarrays left and right so that:
     * - Every element in left is less than or equal to every element in right.
     * - left has the smallest possible size.
     * Return the length of left after such a partitioning.
     */
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];
        
        maxLeft[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }
        
        minRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }
        
        for (int i = 1; i < n; i++) {
            if (maxLeft[i - 1] <= minRight[i]) {
                return i;
            }
        }
        
        return -1;
    }

    // ==================== ACTIVITY SELECTION PROBLEMS ====================

    /**
     * Problem: Activity Selection (Maximum Number of Events)
     * Given an array of events where events[i] = [startDayi, endDayi].
     * Every event i starts at startDayi and ends at endDayi.
     * You can attend an event i at any day d where startTimei <= d <= endTimei.
     * Return the maximum number of events you can attend.
     * 
     * Approach: Greedy - sort by end day, try to attend as early as possible
     * Time Complexity: O(n log n + n * d) where d is max duration
     * Space Complexity: O(n)
     */
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]); // Sort by end day
        
        boolean[] attended = new boolean[100001]; // Track attended days
        int count = 0;
        
        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            
            for (int day = start; day <= end; day++) {
                if (!attended[day]) {
                    attended[day] = true;
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }

    /**
     * Problem: Meeting Rooms II
     * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
     * return the minimum number of conference rooms required.
     * 
     * Approach: Greedy - use priority queue to track room end times
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // Priority queue to track end times of meetings in rooms
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.offer(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            // If current meeting starts after the earliest ending meeting
            if (intervals[i][0] >= endTimes.peek()) {
                endTimes.poll(); // Remove the earliest ending meeting
            }
            endTimes.offer(intervals[i][1]); // Add current meeting
        }
        
        return endTimes.size();
    }

    // ==================== SCHEDULING PROBLEMS ====================

    /**
     * Problem: Task Scheduler
     * Given a characters array tasks, representing the tasks a CPU needs to do,
     * where each letter represents a different task. Tasks could be done in any order.
     * Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
     * Return the least number of units of times that the CPU will take to finish all the given tasks.
     * 
     * Approach: Greedy - schedule most frequent tasks first
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        
        Arrays.sort(frequencies);
        int maxFreq = frequencies[25];
        int idleSlots = (maxFreq - 1) * n;
        
        for (int i = 24; i >= 0 && frequencies[i] > 0; i--) {
            idleSlots -= Math.min(maxFreq - 1, frequencies[i]);
        }
        
        idleSlots = Math.max(0, idleSlots);
        return tasks.length + idleSlots;
    }

    /**
     * Problem: Minimum Number of Arrows to Burst Balloons
     * Given an array points where points[i] = [xstart, xend], return the minimum number of arrows
     * that must be shot to burst all balloons.
     * 
     * Approach: Greedy - sort by end position, shoot at end of first balloon
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); // Sort by end position
        
        int arrows = 1;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        
        return arrows;
    }

    // ==================== KNAPSACK PROBLEMS ====================

    /**
     * Problem: Fractional Knapsack
     * Given weights and values of n items, we need to put these items in a knapsack of capacity W
     * to get the maximum total value in the knapsack. We can take fractions of items.
     * 
     * Approach: Greedy - sort by value/weight ratio, take items with highest ratio
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public double fractionalKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        Item[] items = new Item[n];
        
        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], values[i]);
        }
        
        // Sort by value/weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        
        double totalValue = 0.0;
        int remainingCapacity = capacity;
        
        for (Item item : items) {
            if (remainingCapacity >= item.weight) {
                // Take the whole item
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                // Take fraction of the item
                totalValue += item.ratio * remainingCapacity;
                break;
            }
        }
        
        return totalValue;
    }
    
    static class Item {
        int weight, value;
        double ratio;
        
        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
        }
    }

    // ==================== STRING PROBLEMS ====================

    /**
     * Problem: Remove Duplicate Letters
     * Given a string s, remove duplicate letters so that every letter appears once and only once.
     * You must make sure your result is the smallest in lexicographical order among all possible results.
     * 
     * Approach: Greedy with stack - maintain lexicographically smallest result
     * Time Complexity: O(n)
     * Space Complexity: O(1) - at most 26 characters
     */
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] inStack = new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        // Count frequency of each character
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (char c : s.toCharArray()) {
            count[c - 'a']--; // Decrease count
            
            if (inStack[c - 'a']) continue; // Already in stack
            
            // Remove characters that are greater than current and can be added later
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }
            
            stack.push(c);
            inStack[c - 'a'] = true;
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.reverse().toString();
    }

    /**
     * Problem: Reorganize String
     * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
     * Return any possible rearrangement of s or return "" if not possible.
     * 
     * Approach: Greedy - use priority queue to alternate most frequent characters
     * Time Complexity: O(n log 26) = O(n)
     * Space Complexity: O(26) = O(1)
     */
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // Priority queue ordered by frequency (descending)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.offer(new int[]{i, count[i]});
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            
            if (result.length() == 0 || result.charAt(result.length() - 1) != (char) (first[0] + 'a')) {
                result.append((char) (first[0] + 'a'));
                if (--first[1] > 0) {
                    pq.offer(first);
                }
            } else if (!pq.isEmpty()) {
                int[] second = pq.poll();
                result.append((char) (second[0] + 'a'));
                if (--second[1] > 0) {
                    pq.offer(second);
                }
                pq.offer(first);
            } else {
                return ""; // Impossible to reorganize
            }
        }
        
        return result.toString();
    }

    // ==================== INTERVAL PROBLEMS ====================

    /**
     * Problem: Merge Intervals
     * Given an array of intervals where intervals[i] = [starti, endi],
     * merge all overlapping intervals, and return an array of the non-overlapping intervals.
     * 
     * Approach: Greedy - sort by start time, merge overlapping intervals
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        
        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                // Overlapping intervals, merge them
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // Non-overlapping, add current and start new
                merged.add(current);
                current = intervals[i];
            }
        }
        merged.add(current); // Add the last interval
        
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * Problem: Insert Interval
     * Given a set of non-overlapping intervals sorted by their start times,
     * insert a new interval and merge if necessary.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        
        // Add all intervals before newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        
        // Add remaining intervals
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }

    // ==================== DEMONSTRATION METHODS ====================

    /**
     * Demonstrate all greedy algorithm problems
     */
    public static void demonstrateAllProblems() {
        System.out.println("=== Greedy Algorithm Problems Demonstration ===\n");
        
        GreedyProblems greedy = new GreedyProblems();
        
        // Jump Game
        int[] jumpArray = {2, 3, 1, 1, 4};
        boolean canJump = greedy.canJump(jumpArray);
        System.out.println("Can Jump: " + canJump);
        
        int minJumps = greedy.jump(jumpArray);
        System.out.println("Minimum Jumps: " + minJumps);
        
        // Gas Station
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int startStation = greedy.canCompleteCircuit(gas, cost);
        System.out.println("Gas Station Start: " + startStation);
        
        // Partition Labels
        String partitionStr = "ababcbacadefegdehijhklij";
        List<Integer> partitions = greedy.partitionLabels(partitionStr);
        System.out.println("Partition Labels: " + partitions);
        
        // Task Scheduler
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        int intervals = greedy.leastInterval(tasks, n);
        System.out.println("Task Scheduler Intervals: " + intervals);
        
        // Merge Intervals
        int[][] intervalsArray = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = greedy.merge(intervalsArray);
        System.out.println("Merge Intervals: " + Arrays.deepToString(merged));
        
        System.out.println("\n=== Greedy Algorithm Problems Completed ===");
    }

    public static void main(String[] args) {
        demonstrateAllProblems();
    }
}
