/**
* Time Complexity : O(E+V)
* Space Complexity : O(V)
* Works for both directed and 
* undirected 'connected' graph
*/

import static java.lang.System.*;
import java.util.*;

public class ShortestPathInUnweightedGraph
{
    List<Integer> adj[];
	
	public ShortestPathInUnweightedGraph(int n)
	{
		adj = new LinkedList[n];
		for(int i=0; i<n; i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	@Override
	public String toString()
	{
		String result = "";
		for(int i=0; i<adj.length; i++)
			result += i + " => " + adj[i] +"\n";
		return result;
	}
	
	void addEdge(int u, int v)
	{
		adj[u].add(v);
		adj[v].add(u);
	}
	
	
    void shortestPath(int n, int src, int dest)
	{
		boolean[] visited = new boolean[n];
		Queue<Integer> q = new ArrayDeque<>();
		int parent[] = new int[n];
		Arrays.fill(parent, -1);
		visited[src] = true;
		q.add(src);
		
		while(!q.isEmpty())
		{
			int u = q.poll();
			
			for(int v : adj[u])
			{
				if(!visited[v])
				{
					visited[v] = true;
					q.add(v);
					parent[v] = u;
				}
			}
		}
		
		int temp = dest;
		StringBuilder sb = new StringBuilder();
		while(temp != -1)
		{
			sb.insert(0, temp+" ");
			temp = parent[temp];
		}
		
		out.println(sb);
	}
	
	public static void main(String [] args)
	{
		int n = 7;
		ShortestPathInUnweightedGraph g = new ShortestPathInUnweightedGraph(n);
		g.addEdge(0,1);
		g.addEdge(0,4);
		g.addEdge(4,5);
		g.addEdge(4,3);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(5,6);
		
		g.shortestPath(n, 0, 2);		
	}
}
