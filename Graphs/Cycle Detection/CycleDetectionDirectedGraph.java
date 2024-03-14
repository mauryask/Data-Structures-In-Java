/*
* Cycle Detection in a Directed graph Using colors
*  0 > white (vertex is not yet discovered)
* -1 > gray (vertext is discovered)
*  1 > black (vertex is visited)
* Time complexity : O(V+E)
*/

import java.util.*;
class Graph 
{
	int v;
	List<Integer> G[];
	Graph(int v)
	{
		this.v = v;
		G = new LinkedList[v];
		for(int i=0; i<v; i++)
			G[i] = new LinkedList<Integer>();
	}
	
	void addEdge(int u, int v)
	{
		G[u].add(v);
	}
	
	boolean isCycleUtil(int u, boolean visited[])
	{
		visited[u] = true;
		
		for(int v : G[u])
		{
			// if we discover a node and any
			// of its neighbor is alrady visited
			// then there is a cycle			
			
			if(visited[v])
				return true;
			
			isCycleUtil(v);					
		}
		
		visited[u] = false;
		
        return false;		
	}
	
	boolean isCycle()
	{
		boolean visited[] =  new boolean[v];
			
		for(int i=0; i<v ; i++)
		{
			isCycleUtil(i, visited);
		}
		
		return false;
	}
}

public class CycleDetectionDirectedGraph 
{
	public static void main(String [] args)
	{
	   Graph  g = new  Graph(6);
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(1,3);
		g.addEdge(2,4);
		g.addEdge(5,4);
		
      System.out.println(g.isCycle());		
	}
}