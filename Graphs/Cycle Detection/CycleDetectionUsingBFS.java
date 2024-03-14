// Here worst case time complexity : O(V+E)

import java.util.*;
import static java.lang.System.*;

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
	
	boolean isCycle(int src, boolean visited[], int parent[])
	{
		List<Integer> queue = new LinkedList<>();
		visited[src] = true;
		queue.add(src);
		parent[src] = src;
		
		while(!queue.isEmpty())
		{
			int u = queue.remove(0);
			for(int v : G[u])
			{
				// if any neighbor of the give node
				// is already visited and it is not the parent of
				// the given node it means thet there is a cycle
				
				if(visited[v] && parent[u] != v)
					return true;
			   
			    if(!visited[v])
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
		g.addEdge(1,2);
		g.addEdge(0,3);
		g.addEdge(2,0);
		g.addEdge(3,4);
		g.addEdge(3,5);
		g.addEdge(6,5);
		g.addEdge(2,6);
		System.out.println(g);
		boolean visited[] = new boolean[7];
		int parent[] = new int[7];
		boolean flag = false;
		
		for(int i=0;i<7;i++)
		{
			parent[i]  = -1;
			visited[i] = false;
		}
		
		// loop is used to handle connected component
		// otherwise we can pass simply '0' as source vertex
		
		for(int i=0;i<7;i++)
			if(!visited[i])
				flag = g.isCycle(i, visited, parent);
        out.println(flag);
	}
}