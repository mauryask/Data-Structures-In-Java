// Time Complexity of this graph : O(E*V) > O(n^2)
// If the graph is complete : O(n^3) (worst case)
// It is a Dynamic programing algorithm

import java.util.*;
class Graph 
{
	class Edge 
	{
		int src;
		int dest;
		int weight;
	}
	
	int v_num;
	int e_num;
	Edge edge[];
	Graph(int v_num, int e_num)
	{
		this.v_num = v_num;
		this.e_num = e_num;
		edge = new Edge[e_num];
		for(int i=0; i<e_num; i++)
			edge[i] = new Edge();
	}
	
	void bellManFord(int src)
	{
	   		
		int dist[] = new int[v_num];
		for(int i=0; i<v_num; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;
		
		//relax edges (|v|-1) times
		for(int i=1; i<v_num; i++)
		{
			for(int j=0; j<e_num; j++)
			{
				int u = edge[j].src;
				int v = edge[j].dest;
				int w = edge[j].weight;
				if(dist[u] != Integer.MAX_VALUE && (dist[u] + w) < dist[v])
					dist[v] = dist[u] + w;
			}
		}
		
		 // if after (|V|-1)th iteration there is further changes occurs in
		 // distance of vertices then it means there is negative weight cycle
		 boolean status =  isNegativeWeightCycle(dist);
		 
		 if(status)
		 {
			 System.out.println("\nThe graph contains negative weight cycle");
			 return;
		 }
		
		printDist(dist);
	}
	
	void printDist(int dist[])
	{
		for(int i=0; i<v_num; i++)
		{
			System.out.println(i+" ==> "+dist[i]);
		}
	}
	
	boolean isNegativeWeightCycle(int dist[])
	{
	    for(int i=0; i<e_num; i++)
		{
			int u = edge[i].src;
			int v = edge[i].dest;
			int w = edge[i].weight;
			
			if(dist[u] != Integer.MAX_VALUE && (dist[u] + w) < dist[v])
				return true;
		}
		return false;
	}
}

public class BellmanfordAlgorithm
{
	public static void main(String [] args)
	{
		int v_num = 5; 
        int e_num = 8; 
  
        Graph g = new Graph(v_num, e_num); 
  
        g.edge[0].src = 0; 
        g.edge[0].dest = 1; 
        g.edge[0].weight = -1; 
  
        g.edge[1].src = 0; 
        g.edge[1].dest = 2; 
        g.edge[1].weight = 4; 
  
        g.edge[2].src = 1; 
        g.edge[2].dest = 2; 
        g.edge[2].weight = 3; 
  
        g.edge[3].src = 1; 
        g.edge[3].dest = 3; 
        g.edge[3].weight = 2; 
  
        g.edge[4].src = 1; 
        g.edge[4].dest = 4; 
        g.edge[4].weight = 2; 
  
        g.edge[5].src = 3; 
        g.edge[5].dest = 2; 
        g.edge[5].weight = 5; 
  
        g.edge[6].src = 3; 
        g.edge[6].dest = 1; 
        g.edge[6].weight = 1; 
  
        g.edge[7].src = 4; 
        g.edge[7].dest = 3; 
        g.edge[7].weight = -3; 
  
        g.bellManFord(0);
	}
}
