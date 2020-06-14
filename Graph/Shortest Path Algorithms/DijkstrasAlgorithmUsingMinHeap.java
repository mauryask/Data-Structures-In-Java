//Time Cimplexty : O(E * log V)

import java.util.*;
class Graph
{
	class Edge
	{
		int v;
		int w;
		
	   Edge(int v, int w)
	   {
		   this.v = v;
		   this.w = w;
	   }	   
	}
	
	class HeapNode 
	{
		int vertex;
		int dist; //distance
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
	
	void addEdge(int u, int v, int w)
	{
		G[u].add(0, new Edge(v,w));
		G[v].add(0, new Edge(u,w));
	}
		
	void dijkstra(int src)
	{
		boolean visited[] = new boolean[v_num];
		HeapNode e[] = new HeapNode[v_num];
		
		for(int i=0; i<v_num; i++)
			e[i] = new HeapNode();
		
		for(int i=0; i<v_num; i++)
		{
			visited[i] = false;
			e[i].vertex = i;
			e[i].dist = Integer.MAX_VALUE;
		}
		
		e[src].dist = 0;
		
		Comparator cmp =  new Comparator<HeapNode>()
		{
			public int compare(HeapNode e1 , HeapNode e2)
			{
				return e1.dist - e2.dist;
			}			
		};
		
		TreeSet<HeapNode> queue = new TreeSet<>(cmp);
		for(int i=0; i<v_num; i++)
			queue.add(e[i]);
		
	 while(!queue.isEmpty())
	 {
	    HeapNode node  = queue.pollFirst();	//remove first smallest node forever
		for(Edge edge : G[node.vertex])
		{
				if(!visited[edge.v] && (node.dist + edge.w) < e[edge.v].dist)
				{
					queue.remove(e[edge.v]);
					e[edge.v].dist = node.dist + edge.w;
					queue.add(e[edge.v]);
				}
		}
		
		visited[node.vertex] = true;
	 } 
		
		//printting the distance
		for(int i=0; i<v_num; i++)
			System.out.println(src+" ==> "+i+" = "+e[i].dist);
		
	}
       
}


public class DijkstrasAlgorithmUsingMinHeap
{
	public static void main(String [] arg)
	{
		Graph g = new Graph(6);
		g.addEdge(0,1,4);
		g.addEdge(0,3,10);
		g.addEdge(0,2,5);
		g.addEdge(1,2,2);
		g.addEdge(1,4,3);
		g.addEdge(3,2,7);
		g.addEdge(2,4,1);
		g.addEdge(2,5,6);
		g.addEdge(4,5,11);
		g.addEdge(3,5,3);
		
		g.dijkstra(0);
	}
}