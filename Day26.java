// Problem26: Detect a Cycle in an Undirected Graph
// You are given an undirected graph represented by an adjacency list. Your task is to determine if the graph contains any cycle.
// A cycle is formed if you can traverse through a sequence of edges that starts and ends at the same vertex, with at least one edge in between.

// Input :
// * An integer V representing the number of vertices in the graph.
// * A list of edges, where each edge connects two vertices of the graph.
// * Input: V = 5, Edges = [[0, 1], [1, 2], [2, 3], [3, 4], [4, 0]]

import java.util.*;
public class GraphCycleDetector {
    public static boolean dfs(int node, int parent, Map<Integer, List<Integer>> adj, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, node, adj, visited)) return true;
            } else if (neighbor != parent) {
                // Cycle detected
                return true;
            }
        }
        return false;
    }
    public static boolean hasCycle(int V, List<int[]> edges) {
        if (edges.isEmpty()) return false;

        for (int[] e : edges) {
            if (e[0] == e[1]) return true; // Self-loop
        }

        Set<String> edgeSet = new HashSet<>();
        for (int[] e : edges) {
            int u = Math.min(e[0], e[1]);
            int v = Math.max(e[0], e[1]);
            String key = u + "-" + v;
            if (edgeSet.contains(key)) return true; // Duplicate edge
            edgeSet.add(key);
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] e : edges) {
            adj.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            adj.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < V; i++) {
            if (!visited.contains(i)) {
                if (dfs(i, -1, adj, visited)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<int[]> edges1 = Arrays.asList(new int[]{0,1}, new int[]{1,2}, new int[]{2,3}, new int[]{3,4}, new int[]{4,0});
        System.out.println(hasCycle(5, edges1)); // true

        List<int[]> edges2 = Arrays.asList(new int[]{0,1}, new int[]{1,2});
        System.out.println(hasCycle(3, edges2)); // false

        List<int[]> edges3 = new ArrayList<>();
        System.out.println(hasCycle(4, edges3)); // false

        List<int[]> edges4 = Arrays.asList(new int[]{0,1}, new int[]{1,2}, new int[]{2,0}, new int[]{2,0});
        System.out.println(hasCycle(4, edges4)); // true

        List<int[]> edges5 = Arrays.asList(new int[]{1,1});
        System.out.println(hasCycle(2, edges5)); // true
    }
}
