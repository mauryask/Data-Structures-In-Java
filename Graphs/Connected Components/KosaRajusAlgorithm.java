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
   	static List<List<Integer>> getScc(List<ArrayList<Integer>> graph, int n)
	{
		  Stack<Integer> stack = new Stack<>();
		  boolean visited[] = new boolean[n];
		  
		  for(int i=0; i<n; i++)
		  {
			  if(!visited[i])
				  fillOrder(i, graph, stack, visited);
		  }
		  
		  graph = getTranspose(graph, n);
		  
		  Arrays.fill(visited, false);
		  int count = 0;
		  
		  List<List<Integer>> ans = new ArrayList<>();
		  
		  while(!stack.isEmpty())
		  {
			  int u  = stack.pop();
			  if(!visited[u])
			  {
				  count++;
				  List<Integer> scc = new ArrayList<>();
				  findScc(u, graph, visited, scc);
				  ans.add(scc);
			  }
		  }
		  
		  return ans;
	}
		
	// O(V+E)
	static void fillOrder(int u, List<ArrayList<Integer>> graph, Stack<Integer> stack, boolean visited[])
	{
	   visited[u] = true;

       for(int v : graph.get(u))
		   if(!visited[v])
			   fillOrder(v, graph, stack, visited);
       stack.push(u);		   
	}
	
	// O(V+E)
	static List<ArrayList<Integer>> getTranspose(List<ArrayList<Integer>> graph, int n)
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
	static void findScc(int u, List<ArrayList<Integer>> graph, boolean visited[], List<Integer> scc)
	{
		visited[u] = true;
		scc.add(u);
		for(int v : graph.get(u))
			if(!visited[v])
				findScc(v, graph, visited, scc);
	}
	
	public static void main(String [] args)
	{
		Scanner sc =  new Scanner(in);
		out.print("Enter number of vertices: ");
		int n = sc.nextInt();
		out.print("Enter number of edges: ");
		int e = sc.nextInt();
		
        List<ArrayList<Integer>> graph =  
		new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<n; i++)
			graph.add(new ArrayList<Integer>());
		out.println("Enter edges u-->v: ");
        while(e-->0)
		{			
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph.get(u).add(v);
		}			
		
		out.println(getScc(graph, n));
	}
}
