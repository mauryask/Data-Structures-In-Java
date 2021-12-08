/*
* T(n) : O(V+E)
* S(n) : O(V)
**Steps: 
1: Apply DFS store the vertices in stack 
before backtracking
2: reverse the edges 
3: aply DFS by removing the vertices from stack
at the same time count the number of components
*/

import static java.lang.System.*;
import java.util.*;

public class KosaRajusAlgorithm
{
   static List<Integer> adj[];
   
   KosaRajusAlgorithm(int n)
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
		  result += i+" => " + adj[i]+ "\n";
	  return result;
	}
	
	static void addEdge(int u,int v)
	{
		adj[u].add(v);
	}
	
	static void dfs(int u, boolean visited[], Stack<Integer> stack)
	{	
		visited[u] = true;
		
		for(int v : adj[u])
		{
			if(!visited[v])
				dfs(v, visited, stack);
		}	
		
		stack.push(u);
	}
	
	static void dfs2(int u, boolean[] visited)
	{
		visited[u] = true;
		
		for(int v : adj[u])
		{
			if(!visited[v])
				dfs2(v, visited);
		}
	}
	
   public static void main(String [] args)
   {
	   int n = 13;
	   
	   KosaRajusAlgorithm g = new KosaRajusAlgorithm(n);
	  
	   boolean visited[] = new boolean[n];
	   Stack<Integer> stack = new Stack<>();
	   int count = 0;
	   
	   g.addEdge(0,2);
	   g.addEdge(2,3);
	   g.addEdge(3,4);
	   g.addEdge(4,2);
	   g.addEdge(4,5);
	   g.addEdge(3,2);
	   g.addEdge(3,7);
	   g.addEdge(8,3);
	   g.addEdge(8,5);
	   g.addEdge(2,9);
	   g.addEdge(9,6);
	   g.addEdge(6,2);
	   g.addEdge(6,12);
	   g.addEdge(7,10);
	   g.addEdge(10,8);
	   g.addEdge(8,7);
	   g.addEdge(8,11);
	  	  	   
	   out.println(g);

	   for(int i = n-1; i>=0; i--)
		   if(!visited[i])
			   g.dfs(i, visited, stack);
		   
	   out.println(stack);	
	   
	   Arrays.fill(visited, false); 	    
	   
       for(int u : stack)
	   {
		   if(!visited[u])
		   {
			   count++;
			   g.dfs2(u, visited);
		   }
	   }

      out.println(count);	
	  
   }   
}