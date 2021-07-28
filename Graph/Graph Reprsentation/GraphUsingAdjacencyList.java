//Adjacency list implementation of graph
import java.util.*;

class Graph
{
	class Edge 
	{
		int v; //vertex
		int w; //weight
		
		public Edge(int v, int w)
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
	
	List<Edge> G[]; //array contains lists and lists contains
//	Edge object
	//you can say it is a generic array
	
	public Graph(int n)
	{
		G = new LinkedList[n];
		for(int i=0; i<G.length; i++)
			G[i] = new LinkedList<Edge>();
	}	
	
	void addEdge(int u, int v, int w)
	{
		G[u].add(new Edge(v,w)); 
		G[v].add(new Edge(u,w));
	}
	
	@Override
	public String toString()
	{
		String result = "";
		for(int i=0; i<G.length; i++)
			result += i+" ==> "+G[i]+"\n";
		return result;
	}
	
	/*
	* this method checks whether two vertices
	* are connected or not
	*/
	public boolean isConnected(int u, int v)
	{
		for(Edge i : G[u])
		   if(i.v == v)
				return true;
     	return false;
	}
	
}

public class GraphUsingAdjacencyList 
{
	public static void main(String [] args)
	{
		Graph g = new Graph(10);
		g.addEdge(0,2,10);
		g.addEdge(0,5,15);
		g.addEdge(2,5,10);
		g.addEdge(9,3,16);
		
		System.out.println(g); //toString() method will be called
		System.out.println(g.isConnected(7,5));
	}
}