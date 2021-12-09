/*
* Kosa Raju's Algorithm 
* To find number of strongly connected 
* components
* T(n) : O(V+E)
* S(n) : O(V+E)
*/
import static java.lang.System.*;
import java.util.*;

public class KosaRajusAlgorithm
{
	static int scc(List<ArrayList<Integer>> graph, int n)
	{
	  Stack<Integer> stack = new Stack<>();
	  boolean visited[] = new boolean[n];
	  
	  for(int i=0; i<n; i++)
	  {
		  if(!visited[i])
		  {
			  stack.push(i);
			  dfs1(i, graph, stack, visited);
		  }	  
	  }
	  
	  graph = revEdge(graph, n);
	  
	  Arrays.fill(visited, false);
	  int count = 0;
	  
	  while(!stack.isEmpty())
	  {
		  int u  = stack.pop();
		  if(!visited[u])
		  {
			  count++;
			  dfs2(u, graph, visited);
		  }
	  }
	  
	  return count;
	}
		
	// O(V+E)
	static void dfs1(int u, List<ArrayList<Integer>> graph, Stack<Integer> stack, boolean visited[])
	{
	   if(!visited[u])
		   visited[u] = true;

       for(int v : graph.get(u))
	   {
		   if(!visited[v])
		   {
			   dfs1(v, graph, stack, visited);
			   stack.push(v);
		   }
	   }		   
	}
	
	// O(V+E)
	static List<ArrayList<Integer>> revEdge(List<ArrayList<Integer>> graph, int n)
	{
		List<ArrayList<Integer>> g = 
		new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<n; i++)
			g.add(new ArrayList<Integer>());
		
		for(int i=0; i<n; i++)
		{
		    for(int u : graph.get(i))
				g.get(u).add(i);
		}
		
		return g;
	}
	
	// O(V+E)
	static void dfs2(int u, List<ArrayList<Integer>> graph, boolean visited[])
	{
		if(!visited[u])
			visited[u] = true;
		
		for(int v : graph.get(u))
		{
			if(!visited[v])
				dfs2(v, graph, visited);
		}
	}
	
	public static void main(String [] args)
	{
		Scanner sc =  new Scanner(in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		
        List<ArrayList<Integer>> graph =  
		new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<n; i++)
			graph.add(new ArrayList<Integer>());
		
        while(e-->0)
		{
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph.get(u).add(v);
		}			
		
		out.println(scc(graph, n));
	}
}