// Time Complexity  : O(V+E)
// Space Complexity : O(V) // as Queue and Stack
// it uses BFS
// inspired from Jenny's Lecture

import static java.lang.System.*;
import java.util.*;

class Graph 
{
	int v_num;
	List<Integer> adj[];
	Graph(int v_num)
	{
		this.v_num = v_num;
		adj = new LinkedList[v_num];
		for(int i=0; i<v_num; i++)
			adj[i] = new LinkedList<>();
	}
	
	@Override
	public String toString()
	{
		String result = "";
		for(int i=0;i<v_num; i++)
		{
			result += i+" ==> "+adj[i]+"\n";
		}
		
		return result;
	}
	
	void addEdge(int u, int v)
	{
		adj[u].add(v);
	}
	
	void topologicalSort()
	{
		int indegree[] = new int[v_num];

		// finding indegree of the vertices
		for(int i=0; i<v_num; i++)
		{
			for(int v : adj[i])
				indegree[v]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		
		//get first vertex with indgree = 0
		for(int i=0; i<v_num; i++)
			if(indegree[i] == 0)
				q.add(i);
		
		int count = 0;
		
		while(!q.isEmpty())
		{
			int u = q.poll();
			out.print(u+" "); //printing topological ordering
			for(int v : adj[u])
			{
		       indegree[v]--;	
			   if(indegree[v] == 0)
				  q.add(v);
			}
			count++;
		}
		
		// checking whether the graph is "acyclic or not"
		if(count < v_num)
		{
			out.println("Not a DAG");
		}
	}
}

public class KahnsAlgorithm
{
	public static void main(String [] args)
	{
		Graph g = new Graph(7);
		g.addEdge(0,1);
		g.addEdge(0,3);
		g.addEdge(1,2);
		g.addEdge(3,5);
		g.addEdge(2,5);
		g.addEdge(2,4);
		g.addEdge(5,4);
		g.addEdge(5,6);
	    
		g.topologicalSort();
	}
}