/*
* Kruskals Algorithm to find MST
* Time complexity : O(E*logE + E*logV)
* This is a  Greedy Algorithm
*/

import java.util.*;
class Graph 
{
	class Edge implements Comparable<Edge>
	{
		int src;
		int dest;
		int weight;
		public int compareTo(Edge e)
		{
			return this.weight - e.weight;
		}
	}
	
	int v_num;
	int e_num;
	Edge edge[];
	
	Graph(int v_num, int e_num)
	{
		this.v_num =  v_num;
		this.e_num = e_num;
		
	    edge = new Edge[e_num];
		
		for(int i=0; i<e_num ; i++)
			edge[i] = new Edge();
	}
		
    int find(int parent_set[],int item) // O(log V)
	{
		int root = item;
		if(parent_set[root] < 0)
			return root;
		//path compression
		//it gives amortize constant time complexity
		while(parent_set[root] >= 0)
			root = parent_set[root];
		parent_set[item] = root;		
		return parent_set[item];
	}
	
	void union(int parent_set[],int set_1, int set_2)
	{
	   if(parent_set[set_2] < parent_set[set_1])
		   parent_set[set_1] = set_2;
	   else
	   {
		   if(parent_set[set_1] == parent_set[set_2])
			   parent_set[set_1]--;
		   parent_set[set_2] = set_1;
	   }	
	}
	
   void KMST()
   {
	   int j=0;
	   //this array holds the resulting MST
	   Edge rslt[] = new Edge[v_num-1]; //since edges in MST : (|V|-1)
	   
	   for(int i=0; i<v_num-1; i++)
		   rslt[i] = new Edge();
	   
	   //sort the edges in non-decreasing order of weights
	   Arrays.sort(edge);  // O(E * log E)
	   
	   // this array holds the name of the set to which
	   // a vertex belongs
	   int parent_set[] = new int[v_num];
	   for(int i=0; i<v_num; i++)
		   parent_set[i] = -1;
	   
	   for(int i=0; i<e_num; i++)
	   {
		   int x =  find(parent_set, edge[i].src); // this is called E-times
		   int y =  find(parent_set, edge[i].dest); // this is called E-times
		   
		   // check if source and vertex belong from if different sets
		   // if x!=y > then no cycle is presetn here 
		   if(x!=y) 
		   {
			   rslt[j++] = edge[i];
			   union(parent_set,x,y);
		   }
	   }
	   	
	//pritin resulting MST
    for(int i=0; i<rslt.length; i++)
	   System.out.println(rslt[i].src+" ==> "+rslt[i].dest+" = "+rslt[i].weight);
   }
}

public class KruskalsAlgorithm 
{
	public static void main(String [] args)
	{
	    int v_num = 4;   //number of vertices
        int e_num = 5;  //number of edges
        Graph g = new Graph(v_num, e_num); 
  
        // Edge-1
        g.edge[0].src = 0; 
        g.edge[0].dest = 1; 
        g.edge[0].weight = 10; 
  
	    // Edge-4
        g.edge[1].src = 0; 
        g.edge[1].dest = 2; 
        g.edge[1].weight = 6; 
  
		// Edge-3
        g.edge[2].src = 0; 
        g.edge[2].dest = 3; 
        g.edge[2].weight = 5; 
  
		// Edge-4
        g.edge[3].src = 1; 
        g.edge[3].dest = 3; 
        g.edge[3].weight = 15; 
  
		// Edge-5
        g.edge[4].src = 2; 
        g.edge[4].dest = 3; 
        g.edge[4].weight = 4; 
  
        g.KMST();
	}
}