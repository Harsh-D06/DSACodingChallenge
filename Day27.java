// Problem27 : Find the Shortest Path in an Unweighted Graph
// You are given an unweighted graph represented by an adjacency list. Your task is to find the shortest path (in terms of the number of edges) between two given nodes in the graph.

// Input:
// An integer V representing the number of vertices in the graph.
// A list of edges, where each edge connects two vertices of the graph.
// Two integers, start and end, representing the source and destination nodes respectively.

import java.util.*;
public class ShortestPathUnweightedGraph {
    public static int shortestPath(int V, int[][] edges, int start, int end) {
        // Build the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // Since it's an undirected graph
        }
         // BFS setup
        boolean[] visited = new boolean[V];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0], depth = current[1];

            if (node == end) return depth;

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, depth + 1});
                }
            }
        }
        return -1; // No path found
    }
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {2, 3}, {3, 4}};
        int start = 0, end = 4;

        int result = shortestPath(V, edges, start, end);
        System.out.println("Shortest path length: " + result); // Output: 3
    }
}
