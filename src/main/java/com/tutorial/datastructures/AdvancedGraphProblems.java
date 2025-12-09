package com.tutorial.datastructures;

import java.util.*;

/**
 * Advanced Graph Problems - Comprehensive Solutions
 * 
 * This class contains solutions to advanced graph problems including:
 * - Shortest path algorithms (Dijkstra, Floyd-Warshall)
 * - Topological sorting and cycle detection
 * - Union-Find (Disjoint Set Union)
 * - Strongly connected components
 * - Minimum spanning tree algorithms
 * - Network flow concepts
 * - Graph coloring problems
 * - Critical connections and bridges
 * 
 * Each problem includes detailed comments on approach, time and space complexity.
 */
public class AdvancedGraphProblems {

    // ==================== SHORTEST PATH ALGORITHMS ====================

    /**
     * Problem: Network Delay Time (Dijkstra's Algorithm)
     * You are given a network of n nodes, labeled from 1 to n. You are also given times,
     * a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node,
     * vi is the target node, and wi is the time it takes for a signal to travel from source to target.
     * 
     * Approach: Dijkstra's algorithm with priority queue
     * Time Complexity: O(E log V) where E is edges, V is vertices
     * Space Complexity: O(V + E)
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph.get(u).add(new int[]{v, w});
        }
        
        // Dijkstra's algorithm
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];
            
            if (dist > distances[node]) continue;
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int edgeWeight = neighbor[1];
                int newDist = dist + edgeWeight;
                
                if (newDist < distances[nextNode]) {
                    distances[nextNode] = newDist;
                    pq.offer(new int[]{nextNode, newDist});
                }
            }
        }
        
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                return -1; // Unreachable node
            }
            maxTime = Math.max(maxTime, distances[i]);
        }
        
        return maxTime;
    }

    /**
     * Problem: Cheapest Flights Within K Stops
     * There are n cities connected by some number of flights. You are given an array flights where
     * flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
     * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], price = flight[2];
            graph.get(from).add(new int[]{to, price});
        }
        
        // Modified Dijkstra with stops constraint
        int[][] distances = new int[n][k + 2];
        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distances[src][0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0, 0}); // {node, cost, stops}
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];
            int stops = current[2];
            
            if (stops > k) continue;
            if (cost > distances[node][stops]) continue;
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int price = neighbor[1];
                int newCost = cost + price;
                int newStops = stops + 1;
                
                if (newStops <= k + 1 && newCost < distances[nextNode][newStops]) {
                    distances[nextNode][newStops] = newCost;
                    pq.offer(new int[]{nextNode, newCost, newStops});
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            result = Math.min(result, distances[dst][i]);
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    // ==================== TOPOLOGICAL SORTING ====================

    /**
     * Problem: Course Schedule
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
     * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
     * you must take course bi first if you want to take course ai.
     * Return true if you can finish all courses. Otherwise, return false.
     * 
     * Approach: Topological sort using Kahn's algorithm (BFS)
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list and in-degree count
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }
        
        // Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int completed = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completed++;
            
            for (int nextCourse : graph.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        return completed == numCourses;
    }

    /**
     * Problem: Course Schedule II
     * Return the ordering of courses you should take to finish all courses.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] result = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;
            
            for (int nextCourse : graph.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        return index == numCourses ? result : new int[0];
    }

    /**
     * Problem: Alien Dictionary
     * There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
     * You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically
     * by the rules of this new language.
     * Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules.
     */
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        
        // Initialize graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }
        
        // Build graph by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            // Check for invalid case: word1 is prefix of word2 but word1 > word2
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        
        // Topological sort
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);
            
            for (char next : graph.get(c)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        
        return result.length() == inDegree.size() ? result.toString() : "";
    }

    // ==================== UNION-FIND (DISJOINT SET UNION) ====================

    /**
     * Problem: Number of Connected Components in an Undirected Graph
     * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi]
     * indicates that there is an undirected edge between nodes ai and bi in the graph.
     * Return the number of connected components in the graph.
     * 
     * Approach: Union-Find data structure
     * Time Complexity: O(n * α(n)) where α is inverse Ackermann function
     * Space Complexity: O(n)
     */
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        return uf.getComponents();
    }
    
    static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int components;
        
        public UnionFind(int n) {
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
                // Union by rank
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
        
        public int getComponents() {
            return components;
        }
    }

    /**
     * Problem: Redundant Connection
     * In this problem, a tree is an undirected graph that is connected and has no cycles.
     * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added.
     * The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
     * The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
     * Return an edge that can be removed so that the resulting graph is a tree of n nodes.
     */
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        
        for (int[] edge : edges) {
            if (uf.find(edge[0]) == uf.find(edge[1])) {
                return edge; // This edge creates a cycle
            }
            uf.union(edge[0], edge[1]);
        }
        
        return new int[0];
    }

    // ==================== STRONGLY CONNECTED COMPONENTS ====================

    /**
     * Problem: Critical Connections in a Network
     * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network.
     * A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
     * Return all critical connections in the network in any order.
     * 
     * Approach: Tarjan's algorithm to find bridges
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        List<List<Integer>> bridges = new ArrayList<>();
        int[] discoveryTime = new int[n];
        int[] lowTime = new int[n];
        boolean[] visited = new boolean[n];
        
        tarjanDFS(0, -1, graph, discoveryTime, lowTime, visited, new int[]{0}, bridges);
        
        return bridges;
    }
    
    private void tarjanDFS(int u, int parent, List<List<Integer>> graph, int[] discoveryTime, 
                          int[] lowTime, boolean[] visited, int[] time, List<List<Integer>> bridges) {
        visited[u] = true;
        discoveryTime[u] = lowTime[u] = time[0]++;
        
        for (int v : graph.get(u)) {
            if (v == parent) continue;
            
            if (!visited[v]) {
                tarjanDFS(v, u, graph, discoveryTime, lowTime, visited, time, bridges);
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
                
                // If low time of v is greater than discovery time of u, it's a bridge
                if (lowTime[v] > discoveryTime[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            } else {
                lowTime[u] = Math.min(lowTime[u], discoveryTime[v]);
            }
        }
    }

    // ==================== MINIMUM SPANNING TREE ====================

    /**
     * Problem: Minimum Cost to Connect All Points
     * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
     * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them.
     * Return the minimum cost to make all points connected.
     * 
     * Approach: Prim's algorithm with priority queue
     * Time Complexity: O(n^2 log n)
     * Space Complexity: O(n^2)
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        // Start with point 0
        pq.offer(new int[]{0, 0});
        int minCost = 0;
        int edgesUsed = 0;
        
        while (edgesUsed < n) {
            int[] current = pq.poll();
            int point = current[0];
            int cost = current[1];
            
            if (visited[point]) continue;
            
            visited[point] = true;
            minCost += cost;
            edgesUsed++;
            
            // Add all unvisited points to priority queue
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int distance = Math.abs(points[point][0] - points[i][0]) + 
                                  Math.abs(points[point][1] - points[i][1]);
                    pq.offer(new int[]{i, distance});
                }
            }
        }
        
        return minCost;
    }

    // ==================== GRAPH COLORING ====================

    /**
     * Problem: Is Graph Bipartite?
     * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
     * You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
     * Return true if and only if it is bipartite.
     * 
     * Approach: BFS with coloring
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0: uncolored, 1: red, -1: blue
        
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!bfsColoring(graph, i, color)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean bfsColoring(int[][] graph, int start, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int neighbor : graph[node]) {
                if (color[neighbor] == 0) {
                    color[neighbor] = -color[node];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false; // Same color, not bipartite
                }
            }
        }
        
        return true;
    }

    // ==================== DEMONSTRATION METHODS ====================

    /**
     * Demonstrate all advanced graph problems
     */
    public static void demonstrateAllProblems() {
        System.out.println("=== Advanced Graph Problems Demonstration ===\n");
        
        AdvancedGraphProblems agp = new AdvancedGraphProblems();
        
        // Network Delay Time
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int delay = agp.networkDelayTime(times, 4, 2);
        System.out.println("Network Delay Time: " + delay);
        
        // Course Schedule
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        boolean canFinish = agp.canFinish(numCourses, prerequisites);
        System.out.println("Can Finish Courses: " + canFinish);
        
        // Count Components
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int components = agp.countComponents(n, edges);
        System.out.println("Number of Components: " + components);
        
        // Redundant Connection
        int[][] redundantEdges = {{1, 2}, {1, 3}, {2, 3}};
        int[] redundant = agp.findRedundantConnection(redundantEdges);
        System.out.println("Redundant Connection: " + Arrays.toString(redundant));
        
        // Minimum Cost Connect Points
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int minCost = agp.minCostConnectPoints(points);
        System.out.println("Minimum Cost Connect Points: " + minCost);
        
        // Is Bipartite
        int[][] bipartiteGraph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        boolean isBipartite = agp.isBipartite(bipartiteGraph);
        System.out.println("Is Bipartite: " + isBipartite);
        
        System.out.println("\n=== Advanced Graph Problems Completed ===");
    }

    public static void main(String[] args) {
        demonstrateAllProblems();
    }
}
