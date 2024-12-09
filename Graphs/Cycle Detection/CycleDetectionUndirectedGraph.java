import java.util.*;

public class CycleDetectionUndirectedGraph {

    private static List<Integer>[] createGraph(int n, List<List<Integer>> edges) {
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        // Creating undirected graph
        for (int i = 0; i < edges.size(); i++) {
            adj[edges.get(i).get(0)].add(edges.get(i).get(1));
            adj[edges.get(i).get(1)].add(edges.get(i).get(0));
        }

        return adj;
    }

    private static void isCycle(int node, List<Integer>[] adj,
            boolean[] visited, int[] parent, Set<String> set) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    parent[v] = u;
                } else if (parent[u] != v) { //If node already visited and node is not aprent of u then: it is a cycle
                    // Printing the edge causing cycle (The set takes care of duplicate edges)
                    if (!set.contains(u + ":" + v) && !set.contains(v + ":" + u)) {
                        System.out.println("Cycle found: "+u + " => " + v);
                        set.add(u + ":" + v);
                        set.add(v + ":" + u);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        boolean[] visited = new boolean[n];
        int parent[] = new int[n];
        // Finding the edge causing cycle
        Set<String> set = new HashSet<>();
        Arrays.fill(parent, -1);

        List<List<Integer>> edges = Arrays.asList(Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(3, 4),
                Arrays.asList(4, 5),
                Arrays.asList(2, 6),
                Arrays.asList(6, 4),
                Arrays.asList(7, 1),
                Arrays.asList(7, 8),
                Arrays.asList(8, 9),
                Arrays.asList(9, 7));

        List<Integer>[] adj = createGraph(n, edges);

        //The loop handles if graph is disconnected 
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                isCycle(i, adj, visited, parent, set);
            }
        }
    }
}