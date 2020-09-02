// Time Complexty : O(V^2)
// It can be reduced to : O(E*logV) using min heap
// It works for both dircetd and undirected graph

import java.util.*;
class Graph
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
	}
	
	int v_num;
    List<Edge> G[];	
	
	Graph(int v_num)
	{
		this.v_num = v_num;
		G = new LinkedList[v_num];
		for(int i=0; i<v_num; i++)
		  G[i] = new LinkedList<Edge>();
	}
	
	void addEdge(int u, int v, int w)
	{
		G[u].add(0, new Edge(v,w));
		G[v].add(0, new Edge(u,w));
	}
		
	int parent[];	
		
	void dijkstra(int src)
	{
		boolean visited[] = new boolean[v_num];
		int dist[] = new int[v_num];
		parent = new int[v_num];
		
		for(int i=0; i<v_num; i++)
		{
			dist[i] = Integer.MAX_VALUE;
			parent[i] = -1;
		}
		
		dist[src] = 0;
		
	for(int i=0; i<v_num; i++) //that means run |v| - times
		{
			int u = minDist(dist, visited);
			
			for(Edge e : G[u])
			{
				if(!visited[e.v] && (dist[u] + e.w) < dist[e.v])
				{
					dist[e.v] = dist[u] + e.w;
					parent[e.v] = u;
				}
			}	
			visited[u] = true;
		}
	
		for(int i=0; i<v_num; i++)
			System.out.println(src+" ==> "+i+" = "+dist[i]);
	}
      
	  
	void printPath(int dest)
	{
		int crawl =  dest;
		List<Integer> path = new LinkedList<>();
		path.add(crawl);
		
		while(parent[crawl] != -1)
		{
			path.add(0,parent[crawl]);
			crawl = parent[crawl];
		}
		
		System.out.println("The path: ");
		for(int x: path)
			System.out.print(x+" ");
	}	
	   
    int minDist(int dist[], boolean visited[])
	{
		int min = Integer.MAX_VALUE;
		int min_index = 0;
		for(int i=0; i<v_num; i++)
		{
			if(!visited[i] && dist[i] <= min)
			{
				min = dist[i];
				min_index = i;
			}
		}
		return min_index;
	}		
}

public class DijkstrasAlgorithm
{
	public static void main(String [] args)
	{
		Graph g = new Graph(6);
		g.addEdge(0,1,4);
		g.addEdge(0,3,10);
		g.addEdge(0,2,5);
		g.addEdge(1,2,2);
		g.addEdge(1,4,3);
		g.addEdge(3,2,7);
		g.addEdge(2,4,1);
		g.addEdge(2,5,6);
		g.addEdge(4,5,11);
		g.addEdge(3,5,3);
		
		g.dijkstra(0);
		g.printPath(5);
	}
}