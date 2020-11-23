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
		Stack<Integer> stack = new Stack<>();
		stack.push(src);
		
		while(!stack.isEmpty())
		{
			int u = stack.pop();
			visited[u] = true;
			
			for(int v : G[u])
			{
				if(visited[v] && parent[u] != v)
					return true;
				
				if(!visited[v])
				{
					stack.push(v);
					parent[v] = u;
				}
			}
		}
		return false;
	}
}
	
public class CycleDetectionUsingDFS
{
	public static void main(String [] args)
	{
        Graph g = new Graph(6);
			g.addEdge(0,1);
			g.addEdge(0,3);
			g.addEdge(1,2);
			//g.addEdge(1,5);
			g.addEdge(3,2);
			g.addEdge(4,2);
			g.addEdge(5,4);
			
		  int parent[] = new int[6];
		  boolean visited[] = new boolean[6];
		  boolean flag = false;
		 
 		  for(int i=0;i<6;i++)
			  parent[i] = -1;
		  
		  for(int i=0;i<6; i++)
			  if(!visited[i])
			    flag = g.isCycle(i,visited,parent);
			
		  out.println(flag);
	}
}