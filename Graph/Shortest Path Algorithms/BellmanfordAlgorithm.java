/**
* Single source shortest path algorithm 
* Time complaexity: O(V*E)
* Space complaexity: O(V)
* Works with both directed and undirected graphs
* ** Works well with graph having -ve weight edges
* ** Does not work in case of -ve weight cycle (very important)
*/

import static java.lang.System.*;
import java.util.*;

public class BellmanfordAlgorithm
{
	static class Edge 
	{
		int u;
		int v;
		int w;
	
		Edge(int u, int v, int w)
		{
			this.v = v;
			this.w = w;
			this.u = u;
		}
	}
	
	void bellManFord(int src, int n, int e, Edge edge[])
	{
		int dist[] = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[src] = 0;
		/*
		* Relaxing all the edges (n-1) times exactly
		* Realxing means D[v] = D[u] + C[u, v] thing
		**/
		for(int j=1; j<n; j++)
		{
		   for(int i=0; i<e; i++)
		   {
			  int u = edge[i].u;
			  int v = edge[i].v;
			  int w = edge[i].w;
			  
			  if(dist[u] != Integer.MAX_VALUE &&
			  dist[u] + w < dist[v])
			  {
				  dist[v] = dist[u] + w;
			  }
		   }
		}

		for(int i=0; i<e; i++)
		{
			int u = edge[i].u;
			int v = edge[i].v;
			int w = edge[i].w;
			
			if(dist[u] != Integer.MAX_VALUE &&
			dist[u] + w < dist[v])
			{
				out.println("The graph contains negative weight cycle");
				return;
			}
		}
		
		for(int i=0; i<n; i++)
			out.println(src+" => "+i+ " = "+dist[i]);
	}
	
	public static void main(String [] args)
	{
		int n = 5; 
        int e = 8; 
   
		Edge edge[] = new Edge[e];   
        
        BellmanfordAlgorithm g = new BellmanfordAlgorithm(); 
  						 //u,v,w
        edge[0] = new Edge(0,1,-1);
        edge[1] = new Edge(0,2,4);
        edge[2] = new Edge(1,2,3);
        edge[3] = new Edge(1,3,2);
        edge[4] = new Edge(1,4,2);
        edge[5] = new Edge(3,2,5);
        edge[6] = new Edge(3,1,1);
        edge[7] = new Edge(4,3,-3);
 
        g.bellManFord(0, n, e, edge);
	}
}