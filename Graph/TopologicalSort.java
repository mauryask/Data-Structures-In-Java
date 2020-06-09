// This algorithm is known as the "Kahn's algoeithm to print the vertices in Topological Order"

import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

class Graph 
{
	int v_num;
	List<Integer> G[];
	Graph(int v_num)
	{
		this.v_num = v_num;
		G = new LinkedList[v_num];
		for(int i=0; i<v_num; i++)
			G[i] = new LinkedList<Integer>();
	}
	
	public String toString()
	{
		String result = "";
		for(int i=0; i< v_num; i++)
			result += i+" ==> "+G[i]+"\n";
		return result;
	}
	
	void addEdge(int u, int v)
	{
		//directed graph
		G[u].add(0,v);
	}
	
	
	void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack)
	{
	   	visited[v] =  true; 
		
		for(int e : G[v])
		{
			if(!visited[e])
				topologicalSortUtil(e,visited,stack);
		}
		
		stack.push(v);
	}
	
	void topologicalSort()
	{
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[v_num];
		
		for(int i=0; i<v_num; i++)
			visited[i] = false;
		
		for(int i=0; i<v_num; i++)
			if(!visited[i])
				topologicalSortUtil(i,visited,stack);
			
		//printing the oredering of the stack
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
			
	}
	
}

public class TopologicalSort
{
	public static void main(String [] args)
	{
		Graph g = new Graph(6);
		g.addEdge(0,1);
		g.addEdge(2,0);
		g.addEdge(2,3);
		g.addEdge(5,3);
		g.addEdge(4,5);
		g.addEdge(4,1);
		g.addEdge(3,1);
		
		System.out.println("\n"+g);
		System.out.println("=================\n");
		System.out.print("Topological ordering: ");
		g.topologicalSort();
		System.out.println();
	}
}