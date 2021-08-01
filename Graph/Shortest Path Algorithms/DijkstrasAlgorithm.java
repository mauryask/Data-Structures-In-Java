// Time Complexty : O(V^2)
// It can be reduced to : O(E*logV) using min heap
// It works for both dircetd and undirected graph
// Single source shortest path algorithm

import static java.lang.System.*;
import java.util.*;

public class DijkstrasAlgorithm
{
   class Edge 
   {
	   int v; 
	   int w;
	   
	   Edge(int v, int w)
	   {
		   this.v = v;
		   this.w = w;
	   }
	   
	   @Override
	   public String toString()
	   {
		   return "("+ v + "," + w + ")";
	   }
   }   
   
   List<Edge> adj[];
   DijkstrasAlgorithm(int n)
   {
	   adj = new LinkedList[n];
	   for(int i=0; i<n; i++)
		   adj[i] = new LinkedList<Edge>();
   }
   
   @Override
   public String toString()
   {
	   String result = "";
	   for(int i=0; i<adj.length; i++)
		   result += i +" => " + adj[i]+"\n";
	   return result;
   }
   
   void addEdge(int u, int v, int w)
   {
	   adj[u].add(new Edge(v, w));
	   adj[v].add(new Edge(u, w));
   }
   
   void dijkstra(int src, int n, int dest)
   {
	   boolean visited[] = new boolean[n];
	   int dist[] = new int[n];
	   int parent[] = new int[n];
	   
	   for(int i=0; i<n; i++)
	   {
		   dist[i] = Integer.MAX_VALUE;
		   parent[i] = -1;
	   }
	   
	   dist[src] = 0;
	   
	   for(int i=0; i<n; i++)
	   {
		    int u = findMin(dist, visited, n);		
			visited[u] = true;
			for(Edge e : adj[u])
			{
				if(!visited[e.v] && (dist[u] + e.w) < dist[e.v])
				{
					dist[e.v] = dist[u] + e.w;
					parent[e.v] = u;
				}
			}
	   }
     
      for(int i=0; i<n; i++)
		out.println(src+ " ==> " + i +"  =  "+ dist[i]);
      printPath(parent, n, dest);	
   }
   
   void printPath(int parent[], int n, int dest)
   {
	   Stack<Integer> path = new Stack<>();
	   int temp = parent[dest];
	   path.push(dest);
	   
	   while(temp != -1)
	   {
		   path.push(temp);
		   temp =  parent[temp];
	   }
	   out.println();
	   for(;!path.isEmpty();)
		   out.print(path.pop()+" ");
	   out.println();
   }
   
   int findMin(int dist[], boolean visited[], int n)
   {
	   int min = Integer.MAX_VALUE;
	   int index = 0;
	   
	   for(int i=0; i<n ; i++)
	   {
		   if(!visited[i] && min > dist[i])
		   {
			   min = dist[i];
			   index = i;
		   }
	   }
	   
	   return index;
   }
   
   public static void main(String [] args)
   {
	   int n = 9;
	   DijkstrasAlgorithm g = new DijkstrasAlgorithm(n);
	   g.addEdge(0,1,4);
	   g.addEdge(0,4,8);
	   g.addEdge(1,4,11);
	   g.addEdge(4,5,1);
	   g.addEdge(4,8,7);
	   g.addEdge(8,2,2);
	   g.addEdge(1,2,8);
	   g.addEdge(2,3,7);
	   g.addEdge(2,6,4);
	   g.addEdge(5,6,2);
	   g.addEdge(3,6,14);
	   g.addEdge(3,7,9);
	   g.addEdge(6,7,10);
	   g.addEdge(8,5,6);
	   
	   out.println(g);
	   
	   g.dijkstra(0, n, 7);
   }
}