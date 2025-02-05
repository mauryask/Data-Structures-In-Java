/*
https://leetcode.com/problems/critical-connections-in-a-network/description/
https://www.youtube.com/watch?v=CsGP_s_3GWg
-------
T(N) : O(V+E)
S(N): O(V+E)

Note: Bridge is concepts of Directed Graphs only. 
A bridge is an edge removing which increases the number of connected components in the graph.
*/

import static java.lang.System.*;
import java.util.*;

public class BridgeInTheGraph {

    List<Integer>[] graph;
    int n;

    BridgeInTheGraph(int n) {
        this.n = n;
        graph = new ArrayList[n];
    }

    void initGraph() {
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    static int timeDisc = 1;

    void findBridges(int u, boolean[] visited,
            int[] tDisc, int[] low, int parent) {
        visited[u] = true;
        tDisc[u] =  low[u] = timeDisc++;

        for (int v : graph[u]) {
            if (!visited[v]) {
                findBridges(v, visited, tDisc, low, u);
                low[u] = Math.min(low[u], low[v]);
				//If discovery time of u is less than min discovery time of v, then it is a bridge
                if (tDisc[u] < low[v]) {
                    out.println(u + " " + v);
                }
            } else if (v != parent) {
                low[u] = Math.min(low[u], low[v]);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {1, 3}};
        BridgeInTheGraph obj = new BridgeInTheGraph(n);
        obj.initGraph();

        for (int[] edge : edges) {
            obj.addEdge(edge[0], edge[1]);
        }

        int[] tDisc = new int[n]; //Discovery time
        int[] low = new int[n]; //Min discovery time
        boolean[] visited = new boolean[n];
        obj.findBridges(0, visited, tDisc, low, -1);
    }
}
