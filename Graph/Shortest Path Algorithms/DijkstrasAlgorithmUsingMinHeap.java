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
	
	int v_num;
	List<Edge> G[];
	
	Graph(int v_num)
	{
		this.v_num = v_num;
		G = new LinkedList[v_num];
		for(int i=0;i<v_num; i++)
		  G[i] = new LinkedList<Edge>();
	}
	
	void addEdge(int u, int v, int w)
	{
		G[u].add(0, new Edge(v,w));
		G[v].add(0, new Edge(u,w));
	} 

	class HeapNode 
	{
		int vertex;
		int dist;
	}
	
   void dijkstra(int src)
   {
      boolean visited[] = new boolean[v_num];   
	  HeapNode heap[] = new HeapNode[v_num];

	   TreeSet<HeapNode> q = new TreeSet<>((e1,e2)->
		{		
				return e1.dist - e2.dist;			
		});
	  
	    for(int i=0;i<v_num;i++)
		{
		  heap[i] = new HeapNode();
          heap[i].vertex = i;
          heap[i].dist = (i == src)? 0 : Integer.MAX_VALUE;	
          q.add(heap[i]);			  
		}
		
       while(!q.isEmpty()) // that means |v| - times
		{
			HeapNode node = q.pollFirst();			
			
			for(Edge e : G[node.vertex])
			{
				if(!visited[e.v] && (node.dist + e.w) < heap[e.v].dist)
				{
					q.remove(heap[e.v]);
					heap[e.v].dist = node.dist + e.w;
					q.add(heap[e.v]);
				}
			}
			visited[node.vertex] = true;
		}

      for(int i=0; i<v_num; i++)
			System.out.println(src+" ==> "+i+" = "+heap[i].dist);	   
   }
   
}

public class DijkstrasAlgorithmUsingMinHeap 
{
	public static void main(String [] args)
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