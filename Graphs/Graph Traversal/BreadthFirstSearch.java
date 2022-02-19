/*
* Time complexity: O(|V| + |E|) : Adjacency List
* Time complexity: O(|V|^2) : Adjacency Matrix
* Space complexity: O(|V| + |E|) : Ajacency List
* Space complexity: O(|V|^2): Adjacency Matrix
**/

import java.util.LinkedList;
import java.util.List;

class Graph 
{
	class Edge 
	{
		int v, w; 		
		Edge(int v, int w)
		{
			this.v = v;
			this.w = w;
		}
		
		public String toString()
		{
			return "("+v+","+w+")";
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
	
	void addEdge(int u, int v, int w)
	{
	   //two additions for undirected graph
          	G[u].add(new Edge(v,w));		
       		G[v].add(new Edge(u,w));		
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
		
		while(!queue.isEmpty())
		{
			int u = queue.poll(); //retrievs and removes head of the queue
			System.out.print(u+" ");			
			
			for(Edge e : G[u])
			{
			  if(!visited[e.v]) //if not visited 
			  {
				  visited[e.v] = true; //mark visited
				  queue.add(e.v); //add to the queue
			  }
			}
		}
	}
}
-
public class BreadthFirstSearch
{
	public static void main(String [] args)
	{
		Graph g = new Graph(4); //number of vertices
	    //arguments: source, destination
		g.addEdge(0, 1, 10); 
        g.addEdge(0, 2, 56); 
        g.addEdge(1, 2, 12); 
        g.addEdge(2, 0, 20); 
        g.addEdge(2, 3, 23); 
        g.addEdge(3, 3, 58); 
		
		System.out.println(g);
		
		//herethe argument given to it 
		//source node from where the 
		//traversal will begin
		g.bfsTraversal(0);
		System.out.println();
	}
}