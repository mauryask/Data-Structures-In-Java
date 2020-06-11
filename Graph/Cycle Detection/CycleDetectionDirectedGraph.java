/*
* Cycle Detection in a Directed graph Using colors
*  0 > white (vertex is not yet discovered)
* -1 > gray (vertext is discovered)
*  1 > black (vertex is visited)
* Time complxity : O(V+E)
*/

//*Algorithm 
/*
* There will be cycle in the grapg if it consistes of a 
* back edge
*/

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
	}
	
	boolean isCycleUtil(int u, int state[])
	{
		state[u] = -1;
		
		for(int v : G[u])
		{
			if(state[v] == -1)
				return true;
			if(state[v] == 0 && isCycleUtil(v,state) == true)
				return true;
		}
		
		state[u] = 1;
		return false;
	}
	
	boolean isCycle()
	{
		int state[] = new int[v_num];
		for(int i=0; i<v_num; i++)
			state[i] = 0;
		
		for(int i=0; i<v_num ; i++)
		{
			if(state[i]==0)
			{
				if(isCycleUtil(i,state))
					return true;
			}
		}
		
		return false;
	}
}

public class CycleDetectionDirectedGraph 
{
	public static void main(String [] args)
	{
	   Graph  g = new  Graph(6);
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(1,3);
		g.addEdge(2,4);
		g.addEdge(5,4);
		
      System.out.println(g.isCycle());		
	}
}