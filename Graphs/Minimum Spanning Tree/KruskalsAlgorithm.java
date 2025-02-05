//T(N) : O(|E| log |E|) // Sorting the edges in the list
//S(N) : O(|E| + |V|) => Edge list + rank array size


import java.util.*;

public class KruskalsAlgorithm {

    class Edge implements Comparable<Edge> {

        int u;
        int v;
        int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.w = e.w;
        }
    }

    int[] makeSet(int n) {
        int[] rank = new int[n];
        Arrays.fill(rank, -1);
        return rank;
    }

    int find(int key, int[] rank) {
        if (rank[key] < 0) {
            return key;
        } else {
            rank[key] = find(rank[key], rank);
            return rank[key];
        }
    }

    boolean union(int x, int y, int[] rank) {
        int xSet = find(x, rank);
        int ySet = find(y, rank);

        if (xSet != ySet) {
            int xRank = Math.abs(rank[xSet]);
            int yRank = Math.abs(rank[ySet]);

            if (yRank > xRank) {
                rank[ySet] -= xRank;
                rank[xSet] = ySet;
            } else {
                rank[xSet] -= yRank;
                rank[ySet] = xSet;
            }
            //Return true if no cycle is formed with this edge
            return true;
        }
        //Return false if a cycle is formed with this edge
        return false;
    }

    void kruskalsMST(List<List<int[]>> adj, int n) {
        List<Edge> edgeList = new ArrayList<>();
        int[] rank = makeSet(n);
        boolean[][] set = new boolean[n][n];
        int edgeWeightSum = 0;

        for (int i = 0; i < n; i++) {
            for (int[] edge : adj.get(i)) {
                int v = edge[0];
                int w = edge[1];
				//This condition check if an edge is already taken (prevents duplicate edge)
                if (!set[i][v] && !set[v][i]) {
                    edgeList.add(new Edge(i, v, w));
					//Mark this edge as taken
                    set[i][v] = true;
                    set[v][i] = true;
                }
            }
        }

        //Sort edges in ascending order of there weights
        Collections.sort(edgeList); //T(N) : O(|E| log|E|)

        for (Edge edge : edgeList) {
			//If no cycle is formed with this edge
            if (union(edge.u, edge.v, rank)) {
                System.err.println(edge.u + " => " + edge.v + " : " + edge.w);
                edgeWeightSum += edge.w;
            }
        }

		System.err.println("Edge weight sum for MST "+ edgeWeightSum);
    }
}
