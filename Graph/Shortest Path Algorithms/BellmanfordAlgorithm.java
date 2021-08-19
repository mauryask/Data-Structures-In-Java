/**
* Single source shortest path algorithm 
* Time complexity: O(V*E)
* Space complaexity: O(V)
* Works with both directed and undirected graphs
* ** Works well with graph having -ve weight edges
* ** Does not work in case of -ve weight cycle (very important)
*/


/**
* Very Important: 
* Negative weight cycle means
* the sum of the weights of the edges 
* in the cycle is negative
*/

import static java.lang.System.*;
import java.util.*;

public class BellmanfordAlgorithm
{
	static class Edge 
	{
		int u, v, w;
		Edge(int u, int v, int w)
		{
			this.u = u;
			this.w = w;
			this.v = v;
		}
	}
	
	static void bellManFord(int src, int n, int e, Edge edge[])
	{
		int distance[] = new int [n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[src] = 0;
		
		/* Relaxing all the edges exactly (n-1) times*/
		
		for(int i=1; i<n; i++)
			relaxEdge(e, edge, distance);
		
		/*
		* if in n-th iteration any change occurs
		* to the distances already calculated
		* then the graph contains -ve weight cycle
		*/
		
		if(relaxEdge(e, edge, distance))
		  out.println("Graph contains -ve weight cycle!!"); 
		else // ptint the distances
		{
			for(int i=0; i<n; i++)
				out.println(src+" ==> "+i+" = "+distance[i]);				
		}			
	}
	
	static boolean relaxEdge(int e,
	Edge edge[],int distance[])
	{
		boolean isRelaxed = false;
				
		for(int j=0; j<e; j++)
		{
			int u = edge[j].u;
			int v = edge[j].v;
			int w = edge[j].w;
			
			if(distance[u] != Integer.MAX_VALUE &&
			(distance[u] + w < distance[v]))
			{
				distance[v] = distance[u] + w;
				isRelaxed = true;
			}
		}

		return isRelaxed;
	}
	
	public static void main(String [] args)
	{
	   int n = 6;
	   int e = 7;
	   
	   Edge[] edge = new Edge[e];

       edge[0] = new Edge(0,1,-2);	   
       edge[1] = new Edge(0,3,9);	   
       edge[2] = new Edge(5,3,2);	   
       edge[3] = new Edge(1,2,3);	   
       edge[4] = new Edge(3,2,4);	   
       edge[5] = new Edge(3,4,7);	   
       edge[6] = new Edge(4,5,-5);	   
	   
	   bellManFord(0, n, e, edge);
	}
}