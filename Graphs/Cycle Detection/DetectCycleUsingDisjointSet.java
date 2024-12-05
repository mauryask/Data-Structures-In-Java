
/*
* T(n) : 𝑂(𝐸𝛼(𝑉)) 
* S(n): O(V)
*/
import static java.lang.System.*;
import java.util.*;

public class DetectCycleUsingDisjointSet {
	static class Edge {
		int src;
		int dest;

		Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}
	}

	static int find(int[] rank, int key) // O(log n) (worst case)
	{
		if (rank[key] < 0) {
			return key;
		} else {
			rank[key] = find(rank, rank[key]);
			return rank[key];
		}
	}

	static void union(int[] rank, int xSet, int ySet) {
		if (Math.abs(rank[ySet]) > Math.abs(rank[xSet])) {
			rank[ySet] += rank[xSet];
			rank[xSet] = ySet;
		} else {
			rank[xSet] += rank[ySet];
			rank[ySet] = xSet;
		}
	}

	static boolean isCycle(List<Edge> edge) {
		int n = 7;
		int[] rank = new int[n];
		Arrays.fill(rank, -1);

		for (Edge e : edge) {
			int xSet = find(rank, e.src);
			int ySet = find(rank, e.dest);

			if (xSet == ySet)
				return true;

			union(rank, xSet, ySet);
		}

		return false;
	}

	public static void main(String[] args) {
		List<Edge> edge = new ArrayList<>();

		edge.add(new Edge(0, 1));
		edge.add(new Edge(1, 2));
		edge.add(new Edge(0, 3));
		edge.add(new Edge(2, 6));
		edge.add(new Edge(2, 4));
		edge.add(new Edge(2, 3));
		edge.add(new Edge(5, 4));

		out.println(isCycle(edge));
	}
}
