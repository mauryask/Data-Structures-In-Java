/*
* T(n) : O(E + V*V)
* S(n) : O(V+E)
*/
import static java.lang.System.*;
import java.util.*;

public class DijkstrasAlgorithmUsingLinearSearch
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
	
	List<Edge> adj[];
	
	public DijkstrasAlgorithmUsingLinearSearch(int n)
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
	
	
	void dijkstra(int src, int n)
	{
		int distance[] = new int[n];
		int parent[] = new int[n];
		boolean visited[] = new boolean[n];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		
		distance[src] = 0;
		
		for(int i=1; i<=n; i++)
		{
			int u = findMin(distance, visited, n);
				
			for(Edge e: adj[u])
			{
				if(!visited[e.v] && distance[u] + e.w < distance[e.v])
				{
					distance[e.v] = distance[u] + e.w;
					parent[e.v] = u;
				}
			}
			
			visited[u] = true;
		}
		
		
		for(int  i= 0; i<n; i++)
			out.println(src+" => "+ distance[i]);
	}
	
	static int findMin(int[] distance, boolean[] visited, int n)
	{
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for(int i=0; i<n; i++)
		{
			if(!visited[i] && min > distance[i])
			{
				min = distance[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	public static void main(String [] args)
	{
	   int n = 9;
	   DijkstrasAlgorithmUsingLinearSearch g =
	   new DijkstrasAlgorithmUsingLinearSearch(n);
	   
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
