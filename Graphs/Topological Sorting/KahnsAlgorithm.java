
/**
 * Time Complexity : O(V+E)
 * Space Complexity  : O(V+E)
 */
import static java.lang.System.*;
import java.util.*;

public class KahnsAlgorithm {

    List<Integer> adj[];

    KahnsAlgorithm(int n) {
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    void topoLogicalOrdering(int indegree[], int n) {

        // Calculate indegree of each vertex
        for (int i = 0; i < n; i++) {
            for (int v : adj[i]) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        // T(n) = O(V+E)
        /*
		 * If graph is a DAG then each and every vertex will
		 * be processed once hence the count will be
		 * equal to 'n'
         */

        while (!q.isEmpty()) {
            int u = q.poll();
            out.print(u + " ");

            for (int v : adj[u]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }

            count++;
        }

        /**
         * Check if there exists a cycle in the graph or not
         */
        if (count != n) {
            out.println("..\nNot a DAG!!");
        }
    }

    public static void main(String[] args) {
        // number of vertices
        int n = 7;
        KahnsAlgorithm g = new KahnsAlgorithm(n);
        int indegree[] = new int[n];
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(2, 5);
        g.addEdge(4, 6);
        g.addEdge(4, 2);
        // The edge causing cycle
        // g.addEdge(2,0);

        // print topological ordering
        g.topoLogicalOrdering(indegree, n);
    }
}
