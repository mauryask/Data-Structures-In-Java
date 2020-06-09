// Detecting Cycle in an undirected graph using 
// DFS technique
// Here worst case time complexity : O(V+E)

// =======>>> Algorithm : 
/*
@ Traverse the Graph through DFS manner
@ if a vertext is found which is already 
@ visited and this vertex is not the parent of
@ the current vertex 
@ then we can say that cycle is present here
*/

import java.util.*;

class Graph 
{
	int v_num;
	List<Integer> G[];
	
	public Graph(int v_num)
	{
		this.v_num = v_num;
		G = new LinkedList[v_num];
		for(int i=0; i<v_num; i++)
			G[i] = new LinkedList<Integer>();
	}
	
	@Override
	public String toString() 
	{
		String result = "";
		for(int i=0; i<v_num; i++)
			result+= i+" ==>"+G[i]+"\n";
		return result;
		
	}
	
	void addEdge(int u, int v)
	{
		G[u].add(0,v);
		G[v].add(0,u);
	}
	
	boolean isCycleUtil(int u, boolean visited[], int parent)
	{
		visited[u] = true;
		
		for(int v : G[u])
		{
			if(!visited[v])
				if(isCycleUtil(v,visited,u/*updating the parent every time*/))
				   return true;
			   
			else if(visited[v] == true && v != parent)
			   return true;
		}
		
		return false;
	}
	
	boolean isCycle() //pass the source node here
	{
		boolean visited[] = new boolean[v_num];
		
		for(int i=0; i<v_num; i++) //this step is not necessary here
     		visited[i] = false;
		
		/*
		* here for loop is used to deal with the case if 
		* there are multiple components
		*  otherwise only // -> marked steps are enough for this
 		*/
		
		for(int u=0; u<v_num; u++) 
			if(!visited[u])
			  if(isCycleUtil(u,visited,-1)) // ->
				  return true; // ->
		return false;
	}
	
}
	
public class CycleDtectionUsingDFS
{
	public static void main(String [] args)
	{
        Graph g = new Graph(6);
			g.addEdge(0,1);
			g.addEdge(0,3);
			g.addEdge(1,2);
			g.addEdge(3,2);
			g.addEdge(4,2);
			g.addEdge(5,4);
			
			System.out.println(g);
			System.out.println("\n===========\n\n"+g.isCycle());
	}
}