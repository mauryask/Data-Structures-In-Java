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
	public Graph(int n)
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
	  int parent[] = new int[n];
	  int distance[] = new int[n];
	  
	  for(int i=0; i<n; i++)
	  {
		  parent[i] = -1;
		  distance[i] = Integer.MAX_VALUE;
	  }
	  
	   shortestPathUtil(n, src, dest, distance, parent);
	  
       Stack<Integer> stack = new Stack<>();
       stack.push(dest);
       int temp = parent[dest];
	   
       while(temp != -1)
	   {
		   stack.push(temp);
		   temp = parent[temp];
	   }
      	
       for(;!stack.isEmpty();)
		out.print(stack.pop()+" ");		   
	}
	
	
	void shortestPathUtil(int n, int src, int dest, int distance[], int parent[])
	{
		List<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[n];
		
		q.add(src);
		visited[src] = true;
		distance[src] = 0;
		
		while(!q.isEmpty())
		{
			int u = q.remove(0);
			
			for(int v : adj[u])
			{
				if(!visited[v])
				{
					visited[v] = true;
					q.add(v);
					distance[v] = distance[u] + 1;
					parent[v] = u;
					
					if(v == dest)
						return;
				}
			}
		}
	}
	
	public static void main(String [] args)
	{
		int n = 7;
		Graph g = new Graph(n);
		g.addEdge(0,1);
		g.addEdge(0,4);
		g.addEdge(4,5);
		g.addEdge(4,3);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(5,6);
		out.println(g);
		
		g.shortestPath(n, 0, 2);		
	}
}