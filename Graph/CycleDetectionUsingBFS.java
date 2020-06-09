// Detecting Cycle in an undirected graph using 
// BFS technique
// Here wordt case time complexity : O(V+E)

// =======>>> Algorithm : 
/*
@ Traverse the Graph through BFS manner
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
	
	boolean isCycle(int src) //pass the source node here
	{
		boolean visited[] = new boolean[v_num];
		int parent[] = new int[v_num];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[src] = true;
		queue.add(src);
		parent[src] = src;
		
		while(!queue.isEmpty())
		{
			int u = queue.remove();
			for(int v : G[u])
			{
				if(visited[v] == true && parent[u] != v)
					return true;
				else if(!visited[v])
				{
					visited[v] = true;
					parent[v] = u;
					queue.add(v);
				}
			}
		}
		
		return false;
	}
	
}

public class CycleDetectionUsingBFS
{
	public static void main(String [] args)
	{
		Graph g = new Graph(7);
		g.addEdge(0,1);
		g.addEdge(0,3);
		g.addEdge(0,2);
		g.addEdge(3,4);
		g.addEdge(3,5);
		g.addEdge(6,5);
		System.out.println(g);
		System.out.println("\n=========================\n\n"+g.isCycle(0));
	}
}