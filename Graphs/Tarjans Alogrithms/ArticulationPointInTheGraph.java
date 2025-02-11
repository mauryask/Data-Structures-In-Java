//T(n) : O(|V|+|E|)
//S(N) : O(|V|)

import java.util.*;

public class ArticulationPointInTheGraph {

    static int time = 1;

    void findCutVertex(int src, int[] tDisc, int[] low, boolean[] visited,
            int parent, ArrayList<ArrayList<Integer>> adj, int[] mark) {
        visited[src] = true;
        tDisc[src] = low[src] = time++;
        //Do not need to declare it globally as it is required onyl once for the root 
        // node with parent value as -1
        int child = 0;

        for (int v : adj.get(src)) {
            if (!visited[v]) {
                findCutVertex(v, tDisc, low, visited, src, adj, mark);

                //Update the low value of this node
                low[src] = Math.min(low[src], low[v]);

                //Check if this node is a cut vertex
                if (low[v] >= tDisc[src] && parent != -1) {
                    mark[src] = 1;
                }

                //Do it for parent node only
                if (parent == -1) {
                    child++;
                }

            } else if (parent != v) {
                //Here we are taking (low[src], tDisc[v]) cause if we take (low[src], low[v]) cause 
                //if the node src is removed, how it v is going to reach to the node with 
                //lowest discovery time which is ancestor of the removed node i.e. src
                low[src] = Math.min(low[src], tDisc[v]);
            }
        }

        //If it is parent node and has more than one child it is a cut vertex as well
        if (parent == -1 && child > 1) {
            mark[src] = 1;
        }
    }

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        //Array stores the time a node first discovered
        int[] tDisc = new int[V];
        //Array stores lowest discovery time of node to whioch this node can reach
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        //The List stores the resulting cut vertices
        ArrayList<Integer> list = new ArrayList<>();
        //The array index will be set one 1 if it is cut vertex else it is 0
        int[] mark = new int[V];

        // Initialize the time to 1
        time = 1;

        findCutVertex(0, tDisc, low, visited, -1, adj, mark);

        //Add the cut vertices in the list
        for (int i = 0; i < V; i++) {
            if (mark[i] == 1) {
                list.add(i);
            }
        }

        //If list is empty add store only -1 in it as per requirement
        if (list.isEmpty()) {
            list.add(-1);
        }

        return list;
    }
}
