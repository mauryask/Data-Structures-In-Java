
/**
* Time Complexity : O(V+E)
* Space Complexity  : O(V)
* Kahn's Algorithm : (It uses BFS)
*/

import static java.lang.System.*;
import java.util.*;

public class KahnsAlgorithm {
	List<Integer> adj[];

	KahnsAlgorithm(int n) {
		adj = new LinkedList[n];
		for (int i = 0; i < n; i++)
			adj[i] = new LinkedList<>();
	}

	void addEdge(int u, int v, int[] indegree) {
		adj[u].add(v);
		// Update indgree of the vertex
		indegree[v]++;
	}

	// Calculating indegree using DFS
	private static void calculateIndegree(int node, int[] indegree,
			List<Integer>[] adj, boolean[] visited) {
		visited[node] = true;

		for (int v : adj[node]) {
			indegree[v]++;

			if (!visited[v]) {
				calculateIndegree(v, indegree, adj, visited);
			}
		}
	}

	void topoLogicalOrdering(int indegree[], int n) {
		// Thxis q is going to hold vertices with indgree 0
		Queue<Integer> q = new LinkedList<>();

		/*
		 * add all the vertices in the Queue
		 * having indegree 0
		 * Because there could be multiple vertices
		 * with indegree 0 (as in this example)
		 * Taking only one vertex with indegree 0
		 * is not going to work in this example
		 */

		// T(n) = O(V)
		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0)
				q.add(i);
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
				if (indegree[v] == 0)
					q.add(v);
			}

			count++;
		}

		/**
		 * Check if there exists a cycle
		 * in the graph or not
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
		g.addEdge(0, 1, indegree);
		g.addEdge(0, 3, indegree);
		g.addEdge(1, 2, indegree);
		g.addEdge(3, 5, indegree);
		g.addEdge(4, 5, indegree);
		g.addEdge(2, 5, indegree);
		g.addEdge(4, 6, indegree);
		g.addEdge(4, 2, indegree);
		// The edge causing cycle
		// g.addEdge(2,0, indegree);

		// print topological ordering
		g.topoLogicalOrdering(indegree, n);
	}
}
