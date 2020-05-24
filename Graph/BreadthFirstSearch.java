import java.util.*;

class Graph 
{
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
	
	int v_num; //number of vertices
	List<Edge> G[];

	Graph(int v_num)
	{
		this.v_num = v_num;
		G = new LinkedList[v_num];
		for(int i=0; i< G.length; i++)
		{
			G[i] = new LinkedList<Edge>();
		}
	}
	
	void addEdge(int u, int v)
	{
		//two additions for undirected graph
       G[u].add(0,new Edge(v));		
       G[v].add(0,new Edge(u));		
	}

	public String toString()
	{
		String result = "";
		for(int i=0; i<G.length; i++)
			result+= i+" ==> "+G[i]+"\n";
		return result;
	}
	
	void bfsTraversal(int s)
	{
		boolean visited[] = new boolean[v_num];		
		LinkedList<Integer> queue = new LinkedList<>();	
        
		//mark current node as visited
		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0)
		{
			s = queue.poll();
			System.out.println(s+" ");			
			Iterator<Edge> itr = G[s].iterator();
			
			while(itr.hasNext())
			{
			  int n = itr.next().v;
			  if(!visited[n]) //if not visited 
			  {
				  visited[n] = true; //mark visited
				  queue.add(n); //add to the queue
			  }
			}
		}
		
	}
}

public class BreadthFirstSearch
{
	public static void main(String [] args)
	{
		Graph g = new Graph(4); //number of vertices
	    //arguments: source, destination
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
		
		System.out.println(g);
		
		//herethe argument given to it 
		//source node from where the 
		//traversal will begin
		g.bfsTraversal(2);
	}
}