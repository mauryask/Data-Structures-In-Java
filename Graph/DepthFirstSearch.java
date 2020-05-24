import java.util.*;
class Graph 
{
	int v_num;
	class Edge 
	{
		int v;
		Edge(int v)
		{
			this.v = v;
		}
		
		public String toString()
		{
			return v+"";
		}
	}
	
     List<Edge> G[];
	
	Graph(int v_num)
	{
	   	this.v_num = v_num;
		G =  new LinkedList[v_num];
		for(int i=0; i<G.length; i++)
			G[i] = new LinkedList<Edge>();
	}
	
	public String toString()
	{
		String result = "";
		for(int i=0; i<G.length; i++)
			result+= i+" ==> "+G[i]+"\n";
		return result;
	}
	
	void addEdge(int u, int v)
	{
		G[u].add(new Edge(v));
		G[v].add(0, new Edge(u));
	}
	
	void dfsTraversal(int s)
	{
	    boolean visited[] = new boolean [v_num];
		Stack<Integer> stack = new Stack<>();	
		stack.push(s);
        
		while(!stack.isEmpty())
		{
			s = stack.peek();
			stack.pop();
			
			if(!visited[s])
			{
				System.out.print(s+" ");
				visited[s] = true;
			}
			
			Iterator<Edge> itr = G[s].iterator();
			
			while(itr.hasNext())
			{
				int n = itr.next().v;
				if(!visited[n])
				 stack.push(n);
			}
		}
        		
	}
}

public class DepthFirstSearch 
{
	public static void main(String [] args)
	{
	
        Graph g = new Graph(5);  //number of vertices
          
        g.addEdge(1, 0); 
        g.addEdge(0, 2); 
        g.addEdge(2, 1); 
        g.addEdge(0, 3); 
        g.addEdge(1, 4);  
              
		//printing the tree
        System.out.println(g);
		
		//traversing the graph
        g.dfsTraversal(3); 
	}
}