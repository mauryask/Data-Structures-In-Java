/*
https://leetcode.com/problems/critical-connections-in-a-network/description/
https://www.youtube.com/watch?v=CsGP_s_3GWg
-------
T(N) : O(V+E)
S(N): O(V+E)
*/

import static java.lang.System.*;
import java.util.*;

public class BridgeInTheGraph 
{	
   List<Integer>[] graph;
   int n;
   
   BridgeInTheGraph(int n)
   {
	   this.n = n;
       graph = new ArrayList[n];	   
   }
   
   void initGraph()
   {
	   for(int i=0; i<n; i++)
		   graph[i] = new ArrayList<>();
   }
   
   void addEdge(int u, int v)
   {
	  graph[u].add(v);
	  graph[v].add(u);
   }
   
   static int timeDisc = 1;
   
   void findBridges(int u, boolean[] visited,
   int[] tDisc, int[] tMin)
   {
	   visited[u] = true;
	   tDisc[u] = timeDisc;
	   tMin[u] = timeDisc++; 
	   
	   for(int v : graph[u])
	   {
		   if(!visited[v])
		   {
			   findBridges(v, visited, tDisc, tMin);

			   for(int vn : graph[v])
			   {
				   if(vn != u)
					   tMin[v] = Math.min(tMin[v], Math.min(tMin[vn], tDisc[vn]));
			   }
	
			   if(tMin[v] > tDisc[u])
			      out.println(u+" --> "+v);
		   }
	   }
   }

   public static void main(String [] args)
   {
	   int n = 4;
	   int[][] edges = {{0,1},{1,2},{2,0},{1,3}};
	   BridgeInTheGraph obj = new BridgeInTheGraph(n);
	   obj.initGraph();
	   
	   for(int[] edge : edges)
		   obj.addEdge(edge[0], edge[1]);
	   
        int[] tDisc = new int[n];
        int[] tMin = new int[n];
        boolean[] visited = new boolean[n];
        obj.findBridges(0, visited, tDisc, tMin);			
   }
}