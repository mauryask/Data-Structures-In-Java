/**
* Time complaexity: O(V*E)
* Space complaexity: O(V)
* Works with both directed and undirected graphs
* Works well with graph having -ve weight edges
* Does not work in case of -ve weight cycle
*/

import static java.lang.System.*;
import java.util.*;

public class BellmanfordAlgorithm
{
	class Edge 
	{
		int u;
		int v;
		int w;
	}
	
	Edge edge[];
	
	public BellmanfordAlgorithm(int e)
	{
		edge = new Edge[e];
		for(int i=0; i<e; i++)
			edge[i] = new Edge();
	}
	
	void bellManFord(int src, int n, int e)
	{
		int dist[] = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[src] = 0;
		
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
  
        BellmanfordAlgorithm g = new BellmanfordAlgorithm(e); 
  
        g.edge[0].u = 0; 
        g.edge[0].v = 1; 
        g.edge[0].w = -1; 
  
        g.edge[1].u = 0; 
        g.edge[1].v = 2; 
        g.edge[1].w = 4; 
  
        g.edge[2].u = 1; 
        g.edge[2].v = 2; 
        g.edge[2].w = 3; 
  
        g.edge[3].u = 1; 
        g.edge[3].v = 3; 
        g.edge[3].w = 2; 
  
        g.edge[4].u = 1; 
        g.edge[4].v = 4; 
        g.edge[4].w = 2; 
  
        g.edge[5].u = 3; 
        g.edge[5].v = 2; 
        g.edge[5].w = 5; 
  
        g.edge[6].u = 3; 
        g.edge[6].v = 1; 
        g.edge[6].w = 1; 
  
        g.edge[7].u = 4; 
        g.edge[7].v = 3; 
        g.edge[7].w = -3; 
  
        g.bellManFord(0, n, e);
	}
}