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
    static void dfs1(int u, ArrayList<ArrayList<Integer>> adj,
	Stack<Integer> stack, boolean visited[]){
        visited[u] = true;
        
        for(int v : adj.get(u))
        {
            if(!visited[v])
            {
                dfs1(v, adj, stack, visited);
            }
        }
        
        stack.push(u);
    }
    
    
    static void dfs2(int u, ArrayList<ArrayList<Integer>> adj,
	boolean[] visited)
    {
        visited[u] = true;
        
        for(int v : adj.get(u))
        {
            if(!visited[v])
            {
                dfs2(v, adj, visited);
            }
        }
    }
    
    static ArrayList<ArrayList<Integer>> reverse(ArrayList<ArrayList<Integer>> adj, int V)
    {
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        
        for(int i=0; i<V; i++)
           revAdj.add(new ArrayList<>());
          
        for(int i=0; i<V; i++)
        {
            for(int u : adj.get(i))
                revAdj.get(u).add(i);
        }
        
        return revAdj;
    }
    
    static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[] =  new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<V; i++)
        {
            if(!visited[i])
              dfs1(i, adj, stack, visited);
        }
        
        adj = reverse(adj, V);
        
        Arrays.fill(visited, false);
        
        int count = 0;
        
        while(!stack.isEmpty())
        {
             int v = stack.pop();
             
             if(!visited[v])
             {
                count++;
                dfs2(v, adj, visited);
             }
        }
        
        return count;
    }
	
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
	{
		adj.get(u).add(v);
	}
	
	public static void main(String [] args)
	{
		int n = 6;		
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i=0; i<n; i++)
			adj.add(new ArrayList<>());
						
        addEdge(adj, 0, 1);			
        addEdge(adj, 1, 2);			
        addEdge(adj, 2, 0);			
        addEdge(adj, 2, 3);			
        addEdge(adj, 3, 4);			
        addEdge(adj, 4, 5);			
        addEdge(adj, 5, 3);			
		
		out.println(kosaraju(n, adj));
	}
}