// Detecting Cycle in an undirected graph using 
// DisjointSet Datastructure (Union Find Algorithm)

// =======>>> Algorithm : 
/*
@ Traverse for each Edge
@ if a source vertex and destination vertex
@ belong to same set then there is a cycle
@ The time complexity : O(log n) > worst case
@ Here "n" is the nuber of the elements im a given set
*/

import java.util.*;

class Graph 
{
   int v_num, e_num;
   class Edge 
   {
	   int src;
	   int dest;
   }
   
   Edge edge[];

   Graph(int v_num, int e_num)
   {
	 this.v_num = v_num;
	 this.e_num = e_num;
	
     edge = new Edge[e_num];
	 
     for(int i=0; i<e_num; i++)
		 edge[i] = new Edge();
   }
   
 
   int find(int parent_set[], int item) //O(log n) (worst case)
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
   
   boolean isCycle(Graph g)
   {
	   int parent_set[] = new int[v_num];
	     for(int i=0; i<v_num; i++) 
			 parent_set[i] = -1;

		for(int i=0; i<e_num; i++) 
		{
			int x = find(parent_set,g.edge[i].src); 
			int y = find(parent_set, g.edge[i].dest); 
			if(x == y)
				return true;
			union(parent_set,x,y); 
		}
		
		return false;
   }
}
	
public class DetectCycleUsingDisjointSet
{
	public static void main(String [] args)
	{
		Graph g = new Graph(6, 6);
		g.edge[0].src = 0;
		g.edge[0].dest= 1;
		
		g.edge[1].src = 1;
		g.edge[1].dest= 2;
		
		g.edge[2].src = 0;
		g.edge[2].dest= 3;
		
		g.edge[3].src = 2;
		g.edge[3].dest= 3;
		
		g.edge[4].src = 2;
		g.edge[4].dest= 4;
		
		g.edge[5].src = 5;
		g.edge[5].dest= 4;
	
		System.out.println(g.isCycle(g));
	}
}

