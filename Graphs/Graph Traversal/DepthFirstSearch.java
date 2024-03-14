/*
* Time complexity: O(|V|+|E|)
* Space complexity: O(|V|+|E|)
**/

import java.util.*;
import static java.lang.System.*;

class Graph  
{
	class Edge
	{
		int v,w;
		Edge(int v, int w)
		{
			this.v = v;
			this.w = w;
		}
		
		@Override
		public String toString()
		{
			return "("+v+","+w+")";
		}
	}
	
	int v_num;
	List<Edge> G[];
	
	Graph(int v_num)
	{
		this.v_num = v_num;
		G = new LinkedList[v_num];
		for(int i=0; i<v_num; i++)
			G[i] = new LinkedList<Edge>();
	}
	
	@Override
	public String  toString()
	{
		String result = "";
		for(int i=0; i<v_num; i++)
			result += i +" ==> "+G[i]+"\n";
		return result;
	}
	
	void addEdge(int u, int v, int w)
	{
		//undirected graph
		G[u].add(new Edge(v,w));
		G[v].add(new Edge(u,w));
	}
	
	void depthFirstSearch(int s)
	{
		boolean visited[] = new boolean[v_num];
		int parent[] = new int[v_num];
		
		for(int i=0; i<v_num; i++)
		{
		  visited[i] = false;
		  parent[i] = -1;
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		
		while(!stack.isEmpty())
		{
			int u  = stack.pop();
			
			if(!visited[u])
			{
			   System.out.print(u+" ");
			   visited[u] = true;
			}
			
			for(Edge e : G[u])
			{
				if(!visited[e.v])
				{
					stack.push(e.v);
					parent[e.v] = u;
				}
			}
		}		
	}

	void recursiveDFS(int v, boolean visited[])
	{
	    visited[v] = true;			
		System.out.print(v+" ");
		
		for(Edge e : G[v])
		{
			if(!visited[e.v])
			  recursiveDFS(e.v, visited);
		}
	}
	
}

public class DepthFirstSearch
{
	public static void main(String [] args)
	{
		 Graph g = new Graph(7);
		 g.addEdge(0,6,4);
		 g.addEdge(6,5,12);
		 g.addEdge(0,1,8);
		 g.addEdge(1,4,9);
		 g.addEdge(1,2,2);
		 g.addEdge(2,3,7);
		 g.addEdge(4,3,1);
		 g.addEdge(5,4,6);

		System.out.println(g);
		System.out.println("===============\n");
		/*boolean visited[] = new boolean[7];
		g.recursiveDFS(0, visited);*/
		
		g.depthFirstSearch(0);
	}
}