// counting total number of paths
// in a give graph (it works for both dircted as 
// well as undirected graph)

// Time Complexity : O(N!)
// where N is number of vertices

import java.util.*;
class Graph 
{
	int v_num;
	List<Integer> G[]; 
	Graph(int v_num)
	{
		this.v_num = v_num;
		G = new LinkedList[v_num];
		for(int i=0; i<v_num; i++)
			G[i] = new LinkedList<Integer>();
	}
  
  void addEdge(int u, int v)
  {
	  G[u].add(v);
	  G[v].add(u);
  }
  
  int countSimplePath(int u, int d, int count, boolean visited[])
  {
	  visited[u] = true;
	  if(u == d)
		  count++;
	  else
	  {
		  for(int v : G[u])
		  {
			  if(!visited[v])
			  {
			       count = countSimplePath(v, d, count, visited);
				   visited[v] = false;
			  }
		  }
	  }
	  return count;
  } 
  
  // Checkog is there is a path between source and destination 
  // Time Complexity : O(V+E)
  
   boolean isPathExist(int u, int d, boolean visited[])
   {
	   visited[u] = true;
	   if(u == d)
		   return true;
	   
	   for(int v : G[u])
	   {
		   if(!visited[v])
		     return pathExist(v,d,visited);
	   }
	   return false;
   }
}

public class CountSimplePathsInAGraph
{
	public static void main(String [] args)
	{
		Graph g = new Graph(4);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,2);
		g.addEdge(2,3);

		int count = 0;
		boolean visited[] = new boolean[4];
	    System.out.println(g.isPathExist(0,2,visited));
	    System.out.println(g.countSimplePath(0,2,count, visited));
	}
}
