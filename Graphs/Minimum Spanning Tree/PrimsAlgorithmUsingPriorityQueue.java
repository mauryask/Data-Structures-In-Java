/*
* Time Complexity of this algorithm is : O(E log V)
* This is a Greedy Algorithm
*/

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
		for(int i=0; i<v_num; i++)
			G[i] = new LinkedList<Edge>();
	}
  
  void addEdge(int u, int v, int w)
  {
	  G[u].add(0, new Edge(v,w));
	  G[v].add(0, new Edge(u,w));
  }
  
  //Nodes of the minHeap
   class HeapNode 
	{
		int vertex; //stores thw vertex of graph 
		int key; //stores the weights
	}
	
  
  void PMST(int src)
  {
	int parent[] = new int[v_num];  
	HeapNode e[] = new HeapNode[v_num]; //this array holds the HeapNode objects
	boolean visited[] = new boolean[v_num];
	
	for(int i=0; i<v_num ; i++) //initialize the array with objects
		 e[i] = new HeapNode();
	
	for(int i=0; i < v_num; i++)
	{
	  parent[i] = -1;
	  visited[i] = false;
	  e[i].vertex = i;
	  e[i].key = Integer.MAX_VALUE; //intialize keys with Infinite
	}
	
	e[src].key = 0; //weight of the source node : 0
	
	// comparator to order the nodes in nondecreasing
	// order of weights(keys)	
	Comparator cmp = new Comparator<HeapNode>()
	{
		public int compare(HeapNode e1, HeapNode e2)
		{
		  return e1.key - e2.key;
		}
	};
	
	//instead of java PriorityQueue use TreeSet
	//since PriorityQueue remove operation takes O(n)
	// in java (I think TreeSet pollFirst() takes O(logN))
	 TreeSet<HeapNode> queue = new TreeSet<>(cmp);
	 for(int i=0; i<v_num ; i++)
	 {
		queue.add(e[i]); //add objects of into TreeSet 
	 }
	 	  
     while(!queue.isEmpty())
	 {
	    HeapNode node  = queue.pollFirst();	//remove first smallest node forever
		for(Edge edge : G[node.vertex])
		{
				if(!visited[edge.v] && e[edge.v].key  > edge.w)
				{
					queue.remove(e[edge.v]);
					e[edge.v].key = edge.w;
					queue.add(e[edge.v]);
					parent[edge.v] = node.vertex;
				}
		}
		
		visited[node.vertex] = true;
	 } 
	 
	   for(int i=0; i<v_num ; i++)
	   {                      //parent        //vertex  //weight 
		   System.out.println(parent[i]+" ==> "+i+" ==> "+e[i].key);
	   }
  }
  
}

public class PrimsAlgorithmUsingPriorityQueue 
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

	    g.PMST(0);	
	}
}