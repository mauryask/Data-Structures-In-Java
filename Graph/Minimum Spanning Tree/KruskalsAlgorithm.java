/*
* Kruskal's Algorithm to find MST
* Time complexity : O(E*logE + E*logV) = O(E*log V)
* This is a  Greedy Algorithm
*/

import java.util.*;
import static java.lang.System.*;

class Graph 
{
	class Edge 
	{
		int src;
		int dest;
		int weight;
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
		if(parent_set[root]  == root)
			return root;
		while(parent_set[root] != root)
			root = parent_set[root];
		parent_set[item] = root;		
		return parent_set[item];
	}
	
	void union(int parent_set[],int rank[],int x, int y)
	{
	   if(parent_set[y] < parent_set[x])
		   parent_set[y] = x;
	   else if(parent_set[y] > parent_set[x])
	      parent_set[x] = y;
       else
	   {
		   parent_set[y] = x;
		   rank[x] += 1;
	   }
	}
	
   void KMST()
   {
	   int j=0;
	   //this array holds the resulting MST
	   Edge rslt[] = new Edge[v_num-1]; //since edges in MST : (|V|-1)
	   
	   for(int i=0; i<v_num-1; i++)
		   rslt[i] = new Edge();
	   
	   //sorting edges according to the weight
	   Arrays.sort(edge, (e1, e2) -> {return e1.w - e2.w;});
	   
	   // this array holds the name of the set to which
	   // a vertex belongs
	   int parent_set[] = new int[v_num];
	   int rank[] = new int[v_num];
	   for(int i=0; i<v_num; i++)
		   parent_set[i] = i;
	   
	   for(int i=0; i<e_num; i++)
	   {
		   int x =  find(parent_set, edge[i].src); // this is called E-times
		   int y =  find(parent_set, edge[i].dest); // this is called E-times
		   
		   // check if source and vertex belong from different sets
		   // if x!=y  then no cycle is presetn here 
		   //--------------***********************
		   // the sole purpose of the line is to 
		   // leave the egdes causing cycle int eh graph
		   if(x!=y)  
		   {
			   rslt[j++] = edge[i];
			   union(parent_set,rank,x,y);
		   }
	   }
	   	
     for(Edge e : rslt)
	   out.println(e.src+" ==> "+e.dest+" : "+e.weight);
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