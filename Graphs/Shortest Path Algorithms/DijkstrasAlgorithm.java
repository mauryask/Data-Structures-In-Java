/**
* Single Source Shortest Path Algorithm
* Time complexity: 
* O(E+V^2) : for linear search
* O(V + E*logV): for min heap -> see notes to check how it is so.
* Space complexity: O(V)
* This algo works for both directed and
* undirected graph as well
*/

/**
* It does not works with graphs containing
* edges with negative weights
*/

import static java.lang.System.*;
import java.util.*;

public class DijkstrasAlgorithm
{
	class Edge
	{
		int v, w;
		public Edge(int v, int w)
		{
			this.v = v;
			this.w = w;
		}
		
		@Override
		public String toString()
		{
			return "("+v+","+w+")";
		}
	}
	
	class Util implements Comparable<Util>
	{
		int vertex;
		int dist;
		Util(int vertex, int dist)
		{
			this.vertex = vertex;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Util o)
		
		return this.dist - o.dist;
	}
	
	List<Edge> adj[];
	
	public DijkstrasAlgorithm(int n)
	{
		adj = new LinkedList[n];
		for(int i=0; i<n; i++)
			adj[i] = new LinkedList<Edge>();
	}
	
	@Override
	public String toString()
	{
		String result = "";
		
		for(int i=0; i< adj.length; i++)
			result += i+" => "+adj[i]+"\n";
		return result;
	}
	
	void addEdge(int u, int v, int w)
	{
		adj[u].add(new Edge(v, w));
		adj[v].add(new Edge(u, w));
	}
	
	void dijkstra(int src,int n)
	{
		int distance[] = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean visited[] = new boolean[n];
		
		// Min heap to get the vertex with minimum distance
		Queue<Util> q = new PriorityQueue<>();
		
		distance[src] = 0;	
		q.add(new Util(src, 0));			
		
		while(!q.isEmpty())
		{			
			int u = q.remove().vertex;
			
			for(Edge e : adj[u])
			{
				if(!visited[e.v] && distance[u] + e.w < distance[e.v])
				{
					distance[e.v] = distance[u] + e.w;
					q.add(new Util(e.v, distance[e.v]));
				}
			}
			
			visited[u] = true;
		}
		
		for(int i=0; i<n; i++)
			out.println(src+" => "+i +" = "+distance[i]);
	}
	
	int findMin(int distance[], boolean visited[], int n)
	{
		int index = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++)
		{
			if(!visited[i] && min > distance[i])
			{
				min = distance[i];
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
	   
	   g.dijkstra(0, n);
	}
}
