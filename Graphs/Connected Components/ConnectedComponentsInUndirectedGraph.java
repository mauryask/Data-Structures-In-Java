/*
* T(n) : O(V+E)
* S(n) : O(V)
******
** we can apply either BFS or DFS
*/

import static java.lang.System.*;
import java.util.*;

public class ConnectedComponentsInUndirectedGraph 
{
   static List<Integer> adj[];
   
   ConnectedComponentsInUndirectedGraph(int n)
   {
	   adj = new LinkedList[n];
	   for(int i=0; i<n; i++)
		   adj[i] = new LinkedList<>();
   }
	
	@Override
	public String toString()
	{
	  String result = "";
	  for(int i=0; i<adj.length; i++)
		  result += i+" => " + adj[i]+ "\n";
	  return result;
	}
	
	static void addEdge(int u,int v)
	{
		adj[u].add(v);
		adj[v].add(u);
	}
	
	// Using BFS
	static void bfs(int src, boolean [] visited)
	{
		visited[src] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		
		while(!q.isEmpty())
		{
			int u = q.remove();
			
			for(int v : adj[u])
			{
				if(!visited[v])
				{
					visited[v] = true;
					q.add(v);
				}
			}
		}
	}
	
	// Using DFS
	static void dfs(int src, boolean visited[])
	{
		Stack<Integer> stack = new Stack<>();
		stack.push(src);
		
		while(!stack.isEmpty())
		{
			int u = stack.pop();
			
			if(!visited[u])
				visited[u] = true;
			
			for(int v : adj[u])
			{
				if(!visited[v])
					stack.add(v);
			}
		}
	}
	
   public static void main(String [] args)
   {
	   int n = 5;
	   
	   ConnectedComponentsInUndirectedGraph g =
	   new ConnectedComponentsInUndirectedGraph(n);
	   boolean visited[] = new boolean[n];
	   
	   g.addEdge(0,1);
	   g.addEdge(2,3);
	   g.addEdge(3,4);
	  	   
	   out.println(g);
	   int count = 0;
	   
	   for(int i = 0; i<n; i++)
	   {
		   if(!visited[i])
		   {
			   count++;
			   g.dfs(i, visited);
		   }
	   }

	   out.println(count);
   }   
}