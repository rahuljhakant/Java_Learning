package com.tutorial.datastructures.graphs;

/**
 * Graph Algorithms - Comprehensive Guide to Graph Operations in Java
 * 
 * This comprehensive tutorial demonstrates essential graph algorithms including
 * BFS, DFS, shortest path, minimum spanning tree, and topological sort.
 * Graphs are fundamental data structures for modeling relationships and
 * solving complex algorithmic problems.
 * 
 * LEARNING OBJECTIVES:
 * - Master graph representation and traversal algorithms
 * - Understand BFS and DFS implementations
 * - Learn shortest path algorithms (Dijkstra, Bellman-Ford)
 * - Practice minimum spanning tree algorithms (Kruskal, Prim)
 * - Implement topological sort and cycle detection
 * - Understand bipartite graph checking
 * - Master time and space complexity analysis
 * 
 * KEY CONCEPTS:
 * 1. Graph Representation: Adjacency list, adjacency matrix
 * 2. Graph Traversal: BFS (breadth-first), DFS (depth-first)
 * 3. Shortest Path: Dijkstra, Bellman-Ford, Floyd-Warshall
 * 4. Minimum Spanning Tree: Kruskal's, Prim's algorithms
 * 5. Topological Sort: Ordering vertices in DAG
 * 6. Cycle Detection: Detecting cycles in directed/undirected graphs
 * 7. Connected Components: Finding connected components
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
public class GraphAlgorithms {
    
    public static void main(String[] args) {
        System.out.println("=== Graph Algorithms Demo ===");
        System.out.println();
        
        // 1. Graph Representation
        demonstrateGraphRepresentation();
        
        // 2. Graph Traversals
        demonstrateGraphTraversals();
        
        // 3. Shortest Path Algorithms
        demonstrateShortestPath();
        
        // 4. Minimum Spanning Tree
        demonstrateMST();
        
        // 5. Topological Sort
        demonstrateTopologicalSort();
        
        // 6. Cycle Detection
        demonstrateCycleDetection();
        
        // 7. Connected Components
        demonstrateConnectedComponents();
        
        // 8. Advanced Graph Problems
        demonstrateAdvancedProblems();
        
        // 9. Performance Analysis
        demonstratePerformanceAnalysis();
    }
    
    /**
     * Demonstrates graph representation
     */
    private static void demonstrateGraphRepresentation() {
        System.out.println("1. Graph Representation:");
        System.out.println("=======================");
        
        // Adjacency List
        System.out.println("Adjacency List:");
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.printGraph();
        
        // Adjacency Matrix
        System.out.println("\nAdjacency Matrix:");
        int[][] adjMatrix = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0}
        };
        printAdjacencyMatrix(adjMatrix);
        
        System.out.println();
    }
    
    /**
     * Demonstrates graph traversals
     */
    private static void demonstrateGraphTraversals() {
        System.out.println("2. Graph Traversals:");
        System.out.println("===================");
        
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        
        System.out.println("Graph:");
        graph.printGraph();
        
        // BFS
        System.out.println("\nBFS Traversal (starting from 0):");
        java.util.List<Integer> bfsResult = bfs(graph, 0);
        System.out.println("  " + bfsResult);
        
        // DFS
        System.out.println("\nDFS Traversal (starting from 0):");
        java.util.List<Integer> dfsResult = dfs(graph, 0);
        System.out.println("  " + dfsResult);
        
        // DFS Recursive
        System.out.println("\nDFS Recursive (starting from 0):");
        java.util.List<Integer> dfsRecursive = dfsRecursive(graph, 0);
        System.out.println("  " + dfsRecursive);
        
        System.out.println();
    }
    
    /**
     * Demonstrates shortest path algorithms
     */
    private static void demonstrateShortestPath() {
        System.out.println("3. Shortest Path Algorithms:");
        System.out.println("===========================");
        
        // Dijkstra's Algorithm
        System.out.println("Dijkstra's Algorithm:");
        WeightedGraph wGraph = new WeightedGraph(5);
        wGraph.addEdge(0, 1, 4);
        wGraph.addEdge(0, 2, 1);
        wGraph.addEdge(1, 3, 1);
        wGraph.addEdge(2, 1, 2);
        wGraph.addEdge(2, 3, 5);
        wGraph.addEdge(3, 4, 3);
        
        int[] distances = dijkstra(wGraph, 0);
        System.out.println("  Shortest distances from vertex 0: " + java.util.Arrays.toString(distances));
        
        // Bellman-Ford Algorithm
        System.out.println("\nBellman-Ford Algorithm:");
        int[] bellmanDistances = bellmanFord(wGraph, 0);
        System.out.println("  Shortest distances from vertex 0: " + java.util.Arrays.toString(bellmanDistances));
        
        System.out.println();
    }
    
    /**
     * Demonstrates minimum spanning tree
     */
    private static void demonstrateMST() {
        System.out.println("4. Minimum Spanning Tree:");
        System.out.println("========================");
        
        WeightedGraph wGraph = new WeightedGraph(4);
        wGraph.addEdge(0, 1, 10);
        wGraph.addEdge(0, 2, 6);
        wGraph.addEdge(0, 3, 5);
        wGraph.addEdge(1, 3, 15);
        wGraph.addEdge(2, 3, 4);
        
        // Kruskal's Algorithm
        System.out.println("Kruskal's MST:");
        java.util.List<Edge> kruskalMST = kruskalMST(wGraph);
        System.out.println("  MST edges: " + kruskalMST);
        
        // Prim's Algorithm
        System.out.println("\nPrim's MST:");
        java.util.List<Edge> primMST = primMST(wGraph);
        System.out.println("  MST edges: " + primMST);
        
        System.out.println();
    }
    
    /**
     * Demonstrates topological sort
     */
    private static void demonstrateTopologicalSort() {
        System.out.println("5. Topological Sort:");
        System.out.println("===================");
        
        Graph dag = new Graph(6);
        dag.addEdge(5, 2);
        dag.addEdge(5, 0);
        dag.addEdge(4, 0);
        dag.addEdge(4, 1);
        dag.addEdge(2, 3);
        dag.addEdge(3, 1);
        
        System.out.println("DAG:");
        dag.printGraph();
        
        // Topological Sort (DFS)
        System.out.println("\nTopological Sort (DFS):");
        java.util.List<Integer> topoSort = topologicalSortDFS(dag);
        System.out.println("  " + topoSort);
        
        // Topological Sort (Kahn's Algorithm)
        System.out.println("\nTopological Sort (Kahn's):");
        java.util.List<Integer> kahnSort = topologicalSortKahn(dag);
        System.out.println("  " + kahnSort);
        
        System.out.println();
    }
    
    /**
     * Demonstrates cycle detection
     */
    private static void demonstrateCycleDetection() {
        System.out.println("6. Cycle Detection:");
        System.out.println("==================");
        
        // Directed Graph with Cycle
        Graph directedGraph = new Graph(4);
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(3, 1); // Creates cycle
        
        System.out.println("Directed Graph:");
        directedGraph.printGraph();
        
        boolean hasCycleDirected = hasCycleDirected(directedGraph);
        System.out.println("  Has cycle (directed): " + hasCycleDirected);
        
        // Undirected Graph with Cycle
        Graph undirectedGraph = new Graph(4);
        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(2, 3);
        undirectedGraph.addEdge(3, 0); // Creates cycle
        
        System.out.println("\nUndirected Graph:");
        undirectedGraph.printGraph();
        
        boolean hasCycleUndirected = hasCycleUndirected(undirectedGraph);
        System.out.println("  Has cycle (undirected): " + hasCycleUndirected);
        
        System.out.println();
    }
    
    /**
     * Demonstrates connected components
     */
    private static void demonstrateConnectedComponents() {
        System.out.println("7. Connected Components:");
        System.out.println("=======================");
        
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        // Vertex 5 is isolated
        
        System.out.println("Graph:");
        graph.printGraph();
        
        // Connected Components (DFS)
        java.util.List<java.util.List<Integer>> components = connectedComponents(graph);
        System.out.println("  Connected components: " + components);
        
        // Number of Islands
        System.out.println("\nNumber of Islands:");
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        int islands = numIslands(grid);
        System.out.println("  Number of islands: " + islands);
        
        System.out.println();
    }
    
    /**
     * Demonstrates advanced graph problems
     */
    private static void demonstrateAdvancedProblems() {
        System.out.println("8. Advanced Graph Problems:");
        System.out.println("==========================");
        
        // Bipartite Graph Check
        System.out.println("Bipartite Graph Check:");
        Graph bipartiteGraph = new Graph(4);
        bipartiteGraph.addEdge(0, 1);
        bipartiteGraph.addEdge(1, 2);
        bipartiteGraph.addEdge(2, 3);
        bipartiteGraph.addEdge(3, 0);
        
        boolean isBipartite = isBipartite(bipartiteGraph);
        System.out.println("  Is bipartite: " + isBipartite);
        
        // Course Schedule
        System.out.println("\nCourse Schedule:");
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        boolean canFinish = canFinish(numCourses, prerequisites);
        System.out.println("  Can finish all courses: " + canFinish);
        
        // Word Ladder
        System.out.println("\nWord Ladder:");
        String beginWord = "hit";
        String endWord = "cog";
        java.util.List<String> wordList = java.util.Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int ladderLength = ladderLength(beginWord, endWord, wordList);
        System.out.println("  Ladder length: " + ladderLength);
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance analysis
     */
    private static void demonstratePerformanceAnalysis() {
        System.out.println("9. Performance Analysis:");
        System.out.println("=======================");
        
        System.out.println("Graph Algorithm Complexity:");
        System.out.println("-------------------------");
        System.out.println("Traversal:");
        System.out.println("  BFS:                O(V + E) time, O(V) space");
        System.out.println("  DFS:                O(V + E) time, O(V) space");
        
        System.out.println("\nShortest Path:");
        System.out.println("  Dijkstra:           O((V + E) log V) time, O(V) space");
        System.out.println("  Bellman-Ford:       O(VE) time, O(V) space");
        System.out.println("  Floyd-Warshall:     O(V³) time, O(V²) space");
        
        System.out.println("\nMinimum Spanning Tree:");
        System.out.println("  Kruskal:            O(E log E) time, O(V) space");
        System.out.println("  Prim:               O(E log V) time, O(V) space");
        
        System.out.println("\nOther Algorithms:");
        System.out.println("  Topological Sort:   O(V + E) time, O(V) space");
        System.out.println("  Cycle Detection:    O(V + E) time, O(V) space");
        System.out.println("  Connected Components: O(V + E) time, O(V) space");
        
        System.out.println();
    }
    
    // Graph Classes
    
    static class Graph {
        private int vertices;
        private java.util.List<java.util.List<Integer>> adjacencyList;
        
        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new java.util.ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new java.util.ArrayList<>());
            }
        }
        
        public void addEdge(int source, int destination) {
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source); // For undirected graph
        }
        
        public void printGraph() {
            for (int i = 0; i < vertices; i++) {
                System.out.println("  Vertex " + i + ": " + adjacencyList.get(i));
            }
        }
        
        public java.util.List<Integer> getNeighbors(int vertex) {
            return adjacencyList.get(vertex);
        }
        
        public int getVertices() {
            return vertices;
        }
    }
    
    static class WeightedGraph {
        private int vertices;
        private java.util.List<java.util.List<Edge>> adjacencyList;
        
        public WeightedGraph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new java.util.ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new java.util.ArrayList<>());
            }
        }
        
        public void addEdge(int source, int destination, int weight) {
            adjacencyList.get(source).add(new Edge(source, destination, weight));
            adjacencyList.get(destination).add(new Edge(destination, source, weight)); // For undirected graph
        }
        
        public java.util.List<Edge> getNeighbors(int vertex) {
            return adjacencyList.get(vertex);
        }
        
        public int getVertices() {
            return vertices;
        }
    }
    
    static class Edge implements Comparable<Edge> {
        int source, destination, weight;
        
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
        
        @Override
        public String toString() {
            return "(" + source + "-" + destination + ":" + weight + ")";
        }
    }
    
    // Graph Traversal Implementation
    
    /**
     * BFS Traversal
     * Time Complexity: O(V + E), Space Complexity: O(V)
     */
    public static java.util.List<Integer> bfs(Graph graph, int start) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        boolean[] visited = new boolean[graph.getVertices()];
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result.add(vertex);
            
            for (int neighbor : graph.getNeighbors(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        
        return result;
    }
    
    /**
     * DFS Traversal (Iterative)
     * Time Complexity: O(V + E), Space Complexity: O(V)
     */
    public static java.util.List<Integer> dfs(Graph graph, int start) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        boolean[] visited = new boolean[graph.getVertices()];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        stack.push(start);
        
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                visited[vertex] = true;
                result.add(vertex);
                
                for (int neighbor : graph.getNeighbors(vertex)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        
        return result;
    }
    
    /**
     * DFS Traversal (Recursive)
     * Time Complexity: O(V + E), Space Complexity: O(V)
     */
    public static java.util.List<Integer> dfsRecursive(Graph graph, int start) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        boolean[] visited = new boolean[graph.getVertices()];
        dfsHelper(graph, start, visited, result);
        return result;
    }
    
    private static void dfsHelper(Graph graph, int vertex, boolean[] visited, java.util.List<Integer> result) {
        visited[vertex] = true;
        result.add(vertex);
        
        for (int neighbor : graph.getNeighbors(vertex)) {
            if (!visited[neighbor]) {
                dfsHelper(graph, neighbor, visited, result);
            }
        }
    }
    
    // Shortest Path Implementation
    
    /**
     * Dijkstra's Algorithm
     * Time Complexity: O((V + E) log V), Space Complexity: O(V)
     */
    public static int[] dijkstra(WeightedGraph graph, int start) {
        int[] distances = new int[graph.getVertices()];
        java.util.Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        
        java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];
            int distance = current[1];
            
            if (distance > distances[vertex]) continue;
            
            for (Edge edge : graph.getNeighbors(vertex)) {
                int newDistance = distances[vertex] + edge.weight;
                if (newDistance < distances[edge.destination]) {
                    distances[edge.destination] = newDistance;
                    pq.offer(new int[]{edge.destination, newDistance});
                }
            }
        }
        
        return distances;
    }
    
    /**
     * Bellman-Ford Algorithm
     * Time Complexity: O(VE), Space Complexity: O(V)
     */
    public static int[] bellmanFord(WeightedGraph graph, int start) {
        int[] distances = new int[graph.getVertices()];
        java.util.Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        
        // Relax edges V-1 times
        for (int i = 0; i < graph.getVertices() - 1; i++) {
            for (int v = 0; v < graph.getVertices(); v++) {
                for (Edge edge : graph.getNeighbors(v)) {
                    if (distances[v] != Integer.MAX_VALUE && 
                        distances[v] + edge.weight < distances[edge.destination]) {
                        distances[edge.destination] = distances[v] + edge.weight;
                    }
                }
            }
        }
        
        return distances;
    }
    
    // MST Implementation
    
    /**
     * Kruskal's MST Algorithm
     * Time Complexity: O(E log E), Space Complexity: O(V)
     */
    public static java.util.List<Edge> kruskalMST(WeightedGraph graph) {
        java.util.List<Edge> mst = new java.util.ArrayList<>();
        java.util.List<Edge> edges = new java.util.ArrayList<>();
        
        // Collect all edges
        for (int v = 0; v < graph.getVertices(); v++) {
            for (Edge edge : graph.getNeighbors(v)) {
                if (edge.source < edge.destination) { // Avoid duplicates
                    edges.add(edge);
                }
            }
        }
        
        java.util.Collections.sort(edges);
        
        // Union-Find for cycle detection
        int[] parent = new int[graph.getVertices()];
        for (int i = 0; i < graph.getVertices(); i++) {
            parent[i] = i;
        }
        
        for (Edge edge : edges) {
            int root1 = find(parent, edge.source);
            int root2 = find(parent, edge.destination);
            
            if (root1 != root2) {
                mst.add(edge);
                union(parent, root1, root2);
            }
        }
        
        return mst;
    }
    
    /**
     * Prim's MST Algorithm
     * Time Complexity: O(E log V), Space Complexity: O(V)
     */
    public static java.util.List<Edge> primMST(WeightedGraph graph) {
        java.util.List<Edge> mst = new java.util.ArrayList<>();
        boolean[] inMST = new boolean[graph.getVertices()];
        java.util.PriorityQueue<Edge> pq = new java.util.PriorityQueue<>();
        
        // Start with vertex 0
        inMST[0] = true;
        for (Edge edge : graph.getNeighbors(0)) {
            pq.offer(edge);
        }
        
        while (!pq.isEmpty() && mst.size() < graph.getVertices() - 1) {
            Edge edge = pq.poll();
            
            if (inMST[edge.destination]) continue;
            
            mst.add(edge);
            inMST[edge.destination] = true;
            
            for (Edge nextEdge : graph.getNeighbors(edge.destination)) {
                if (!inMST[nextEdge.destination]) {
                    pq.offer(nextEdge);
                }
            }
        }
        
        return mst;
    }
    
    // Union-Find Helper Methods
    
    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    
    private static void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        parent[rootX] = rootY;
    }
    
    // Topological Sort Implementation
    
    /**
     * Topological Sort (DFS)
     * Time Complexity: O(V + E), Space Complexity: O(V)
     */
    public static java.util.List<Integer> topologicalSortDFS(Graph graph) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        boolean[] visited = new boolean[graph.getVertices()];
        boolean[] recStack = new boolean[graph.getVertices()];
        
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                if (!topologicalSortDFSHelper(graph, i, visited, recStack, result)) {
                    return new java.util.ArrayList<>(); // Cycle detected
                }
            }
        }
        
        java.util.Collections.reverse(result);
        return result;
    }
    
    private static boolean topologicalSortDFSHelper(Graph graph, int vertex, boolean[] visited, 
                                                   boolean[] recStack, java.util.List<Integer> result) {
        visited[vertex] = true;
        recStack[vertex] = true;
        
        for (int neighbor : graph.getNeighbors(vertex)) {
            if (!visited[neighbor]) {
                if (!topologicalSortDFSHelper(graph, neighbor, visited, recStack, result)) {
                    return false;
                }
            } else if (recStack[neighbor]) {
                return false; // Cycle detected
            }
        }
        
        recStack[vertex] = false;
        result.add(vertex);
        return true;
    }
    
    /**
     * Topological Sort (Kahn's Algorithm)
     * Time Complexity: O(V + E), Space Complexity: O(V)
     */
    public static java.util.List<Integer> topologicalSortKahn(Graph graph) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        int[] inDegree = new int[graph.getVertices()];
        
        // Calculate in-degrees
        for (int i = 0; i < graph.getVertices(); i++) {
            for (int neighbor : graph.getNeighbors(i)) {
                inDegree[neighbor]++;
            }
        }
        
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        for (int i = 0; i < graph.getVertices(); i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result.add(vertex);
            
            for (int neighbor : graph.getNeighbors(vertex)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return result.size() == graph.getVertices() ? result : new java.util.ArrayList<>();
    }
    
    // Cycle Detection Implementation
    
    /**
     * Cycle Detection in Directed Graph
     * Time Complexity: O(V + E), Space Complexity: O(V)
     */
    public static boolean hasCycleDirected(Graph graph) {
        boolean[] visited = new boolean[graph.getVertices()];
        boolean[] recStack = new boolean[graph.getVertices()];
        
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                if (hasCycleDirectedHelper(graph, i, visited, recStack)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private static boolean hasCycleDirectedHelper(Graph graph, int vertex, boolean[] visited, boolean[] recStack) {
        visited[vertex] = true;
        recStack[vertex] = true;
        
        for (int neighbor : graph.getNeighbors(vertex)) {
            if (!visited[neighbor]) {
                if (hasCycleDirectedHelper(graph, neighbor, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true;
            }
        }
        
        recStack[vertex] = false;
        return false;
    }
    
    /**
     * Cycle Detection in Undirected Graph
     * Time Complexity: O(V + E), Space Complexity: O(V)
     */
    public static boolean hasCycleUndirected(Graph graph) {
        boolean[] visited = new boolean[graph.getVertices()];
        
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                if (hasCycleUndirectedHelper(graph, i, -1, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private static boolean hasCycleUndirectedHelper(Graph graph, int vertex, int parent, boolean[] visited) {
        visited[vertex] = true;
        
        for (int neighbor : graph.getNeighbors(vertex)) {
            if (!visited[neighbor]) {
                if (hasCycleUndirectedHelper(graph, neighbor, vertex, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        
        return false;
    }
    
    // Connected Components Implementation
    
    /**
     * Connected Components
     * Time Complexity: O(V + E), Space Complexity: O(V)
     */
    public static java.util.List<java.util.List<Integer>> connectedComponents(Graph graph) {
        java.util.List<java.util.List<Integer>> components = new java.util.ArrayList<>();
        boolean[] visited = new boolean[graph.getVertices()];
        
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                java.util.List<Integer> component = new java.util.ArrayList<>();
                dfsHelper(graph, i, visited, component);
                components.add(component);
            }
        }
        
        return components;
    }
    
    /**
     * Number of Islands
     * Time Complexity: O(m * n), Space Complexity: O(m * n)
     */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfsIslands(grid, i, j);
                }
            }
        }
        
        return islands;
    }
    
    private static void dfsIslands(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }
        
        grid[row][col] = '0'; // Mark as visited
        
        // Check all 4 directions
        dfsIslands(grid, row + 1, col);
        dfsIslands(grid, row - 1, col);
        dfsIslands(grid, row, col + 1);
        dfsIslands(grid, row, col - 1);
    }
    
    // Advanced Problems Implementation
    
    /**
     * Bipartite Graph Check
     * Time Complexity: O(V + E), Space Complexity: O(V)
     */
    public static boolean isBipartite(Graph graph) {
        int[] color = new int[graph.getVertices()];
        java.util.Arrays.fill(color, -1);
        
        for (int i = 0; i < graph.getVertices(); i++) {
            if (color[i] == -1) {
                if (!isBipartiteHelper(graph, i, color)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static boolean isBipartiteHelper(Graph graph, int vertex, int[] color) {
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(vertex);
        color[vertex] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int neighbor : graph.getNeighbors(current)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[current];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[current]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Course Schedule
     * Time Complexity: O(V + E), Space Complexity: O(V)
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        java.util.List<java.util.List<Integer>> graph = new java.util.ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new java.util.ArrayList<>());
        }
        
        int[] inDegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            inDegree[prereq[0]]++;
        }
        
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
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
     * Word Ladder
     * Time Complexity: O(M² * N), Space Complexity: O(M * N)
     */
    public static int ladderLength(String beginWord, String endWord, java.util.List<String> wordList) {
        java.util.Set<String> wordSet = new java.util.HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        
        java.util.Queue<String> queue = new java.util.LinkedList<>();
        queue.offer(beginWord);
        
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                if (current.equals(endWord)) {
                    return level;
                }
                
                char[] chars = current.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        
                        chars[j] = c;
                        String newWord = new String(chars);
                        
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    
                    chars[j] = original;
                }
            }
            
            level++;
        }
        
        return 0;
    }
    
    // Helper Methods
    
    private static void printAdjacencyMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println("  " + java.util.Arrays.toString(row));
        }
    }
}
