//T(N) : O(|E| * log|V|) => |E| times log|V|
//S(N) : O(|V|) => All the nodes will be pushed in the queue

import java.util.*;

public class PrimsAlgorithm {

    class Edge implements Comparable<Edge> {

        int parent;
        int node;
        int weight;

        Edge(int parent, int node, int weight) {
            this.parent = parent;
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    void primsMST(int src, List<List<int[]>> adj, int n) {
        boolean[] visited = new boolean[n];
        //Min heap
        Queue<Edge> q = new PriorityQueue<>();
        int edgeWeightSum = 0;
        //Assign a weight 0 and parent as -1 then put source node in the queue 
        q.add(new Edge(-1, src, 0));

        while (!q.isEmpty()) { //this will be executed almost |E| times
            Edge edge = q.poll(); //T(n) : log|V|
            int node = edge.node;

            //Check if node is already processed 
            if (visited[node]) {
                continue;
            }

            //Check if node is source node : if yes skip this step
            if (node != src) {
                int weight = edge.weight;
                int parent = edge.parent;
                System.out.println(parent + " => " + node + " : " + weight);
                edgeWeightSum += weight;
            }

            for (int[] e : adj.get(node)) {
                int v = e[0];
                int w = e[1];

                if (!visited[v]) {
                    q.add(new Edge(node, v, w));
                }
            }
            //Mark the current node as processed
            visited[node] = true;
        }

        System.out.println("Edge weight edgeWeightSum of MST: " + edgeWeightSum);
    }
}
