// The time complexity of this Algorithm is : O(V^2)
// since we or using sequential search technique
// to find minimum key
/************************/
// But time complexity can be reduced to : O(E *s log V)
// if we use Min Binary Heap
// This is Greedy Algorithm

// ***************** Note: the source code is 
// ***************** same as the dijkstra algorithm

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
  
  void PMST(int src)
  {
	int parent[] = new int[v_num]; 
	
	/*
	* Each element of the weight array 
	* contains the smallest edge weight from 
	* the source vertex **
	* and indices represent the destination vertex 
	* both source and destination (u --> v) 
	* are being stored in parent array
    ***********
	* elements reprsent 'u' and indices reprsent 'v' 
	* in the parent array
	*/
	
	int weight[] = new int[v_num];
	boolean visited[] = new boolean[v_num];
	
	for(int i=0; i < v_num; i++)
	{
	  parent[i] = -1;
      weight[i] = Integer.MAX_VALUE;
	  visited[i] = false;
	}
	
	weight[src] = 0; // make source vertext weight = 0
	
	 for(int i=0; i<v_num; i++)
 	      primsUtil(parent, weight, visited);
	   
	   for(int i=0; i<v_num ; i++)
	   {                      //parent        //vertex  //weight 
		   System.out.println(parent[i]+" ==> "+i+" ==>"+weight[i]);
	   }
	}	
	
	void primsUtil(int parent[], int weight[],boolean visited[])
	{
		int u = minKey(weight, visited);
		
		for(Edge e : G[u])
		{
			int w = e.w;
			int v = e.v;
		   if(!visited[v] && weight[v] > w)
		   {			   
				weight[v] = w;
				parent[v] = u;
		   }
		}
		visited[u] = true;
	}
	
	int minKey(int weight[], boolean visited[])
	{
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		
		for(int i=0; i<v_num; i++)
		{
			if(!visited[i] && weight[i] < min)
			{
				min = weight[i];
				min_index = i;
			}
		}
	
		return min_index;
	}
}

public class PrimsAlgorithm
{
	public static void main(String [] args)
	{
		Graph g = new Graph(6);
		g.addEdge(0,1,4);
		g.addEdge(0,2,5);
		g.addEdge(0,3,10);
		g.addEdge(1,2,2);
		g.addEdge(3,2,7);
		g.addEdge(1,4,3);
		g.addEdge(4,2,1);
		g.addEdge(4,5,11);
		g.addEdge(3,5,3);
		g.addEdge(2,5,6);
		
	    g.PMST(4);
	}
}
