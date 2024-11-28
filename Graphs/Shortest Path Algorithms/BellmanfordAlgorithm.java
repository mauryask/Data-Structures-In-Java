
/**
* Single source shortest path algorithm 
* Time complexity: O(V*E)
* Space complaexity: O(V)
* Works with both directed and undirected graphs
* ** Works well with graph having -ve weight edges
* ** Does not work in case of -ve edge-weight cycle (very important)
*/

import static java.lang.System.out;
import java.util.*;

public class BellmanfordAlgorithm {
	class Edge {
		int u, v, w;

		Edge(int u, int v, int w) {
			this.u = u;
			this.w = w;
			this.v = v;
		}
	}

	int vNum;
	int eNum;
	Edge[] edges;

	BellmanfordAlgorithm(int vNum, int eNum) {
		this.vNum = vNum;
		this.eNum = eNum;
		edges = new Edge[eNum];
	}

	void addEdge(int u, int v, int w, int index) {
		edges[index] = new Edge(u, v, w);
	}

	int[] bellManFord(int src) {
		int dist[] = new int[vNum];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;

		for (int i = 0; i < vNum; i++) {
			for (Edge edge : edges) {
				int u = edge.u;
				int v = edge.v;
				int w = edge.w;

				if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
					// Check if there is a negative weight cycle
					if (i == vNum - 1)
						return new int[] { -1 };

					dist[v] = dist[u] + w;
				}
			}
		}

		return dist;
	}

	public static void main(String[] args) {
		int vNum = 6;
		int eNum = 7;

		BellmanfordAlgorithm bfa = new BellmanfordAlgorithm(vNum, eNum);
		bfa.addEdge(1, 2, 3, 3);
		bfa.addEdge(3, 2, 4, 4);
		bfa.addEdge(5, 3, 2, 2);
		bfa.addEdge(4, 5, -5, 6);
		bfa.addEdge(3, 4, 7, 5);
		bfa.addEdge(0, 1, -2, 0);
		bfa.addEdge(0, 3, 9, 1);
		int[] dist = bfa.bellManFord(0);

		for (int i = 0; i < vNum; i++)
			out.println(i + " => " + dist[i]);
	}
}