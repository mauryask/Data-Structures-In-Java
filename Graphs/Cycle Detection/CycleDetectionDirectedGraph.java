/*
* Note: Cycle can be dtected using BFS(Kahns algorithm: if count is not equal to n then cycle)
**/
import java.util.*;

public class CycleDetectionDirectedGraph {
    // Method:1 with extra space as pathVisited

    private static boolean isCycle(int node, List<Integer>[] adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int v : adj[node]) {
            // If node not visited
            if (!visited[v]) {
                if (isCycle(v, adj, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[v]) { // If node visited and on the same path
                return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }

    // Method:2 optimized space
    // Here 2 means path visited, 1 mens visited node, 0 unvisited node
    private static boolean isCycleOptimizedSpace(int node, List<Integer>[] adj, int[] visited) {
        visited[node] = 2; //Mark path visited (On the same path)

        for (int v : adj[node]) {
            //If node not visited at all

            if (visited[v] == 0 && isCycleOptimizedSpace(v, adj, visited)) {
                return true; 
            }else if (visited[v] == 2) { //If node visited and on the smae path
                return true;
            }
        }

        visited[node] = 1;// Remove as path visited while backtracking
        return false;
    }

    private static List<Integer>[] createGraph(int n, List<List<Integer>> edges) {
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.size(); i++) {
            adj[edges.get(i).get(0)].add(edges.get(i).get(1));
        }

        return adj;
    }

    public static void main(String[] args) {
        int n = 10;
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];

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

        int intVisited[] = new int[n];

        for (int i = 0; i < n; i++) {
            // if (!visited[i]) {
            // System.out.println(i + " => " + isCycle(i, adj, visited, pathVisited));
            // }

            if (intVisited[i] == 0) {
                System.out.println(i + " => " + isCycleOptimizedSpace(i, adj, intVisited));
            }
        }
    }
}
