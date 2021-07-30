// It is a modification of DFS
// Time Complexity: O(E+V)
// Space Coplexity : O(V)
// The algorithm is working even if Graph is not DAG
// Recommended to use : Kahn's Algorithm


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
	
	void topologicalSortUtil(int u, boolean visited[], 
	Stack<Integer> stack)
	{
	   	visited[u] =  true; 
		// print the element in case of DFS
		
		for(int v : G[u])
		{
			if(!visited[v])
				 	topologicalSortUtil(v,visited,stack);
		}
		
		stack.push(u);
	}
	
	void topologicalSort()
	{
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[v_num];
		for(int i=0; i<v_num; i++)
		{
		   if(!visited[i]) 
			  topologicalSortUtil(i,visited,stack);	
		}
			
    	//printing the oredering of the stack
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");		
	}
}

public class TopologicalSort
{
	public static void main(String [] args)
	{
		Graph g = new Graph(7);
		/*g.addEdge(4,0);
		g.addEdge(5,0);
		g.addEdge(5,2);
		g.addEdge(4,1);
		g.addEdge(2,3);
		g.addEdge(3,1);*/
		
		g.addEdge(0,1);
		g.addEdge(0,3);
		g.addEdge(1,2);
		g.addEdge(3,5);
		g.addEdge(5,4);
		g.addEdge(2,5);
		g.addEdge(5,6);
		g.addEdge(4,2);
		
		System.out.println("\n"+g);
		System.out.println("=================\n");
		System.out.print("Topological ordering: ");
		g.topologicalSort();
		System.out.println();
	}
}