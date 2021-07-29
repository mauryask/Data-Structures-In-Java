/**
* Time Complexity : O(V+E)
* Space Complexi  : O(V)
* Kahn's Algorithm  
*/

import static java.lang.System.*;
import java.util.*;

public class KahnsAlgorithm
{
   List<Integer> adj[];
   
   KahnsAlgorithm(int n)
   {
	   adj = new LinkedList[n];
	   for(int i=0; i<n; i++)
		   adj[i] = new LinkedList<Integer>();
   }
	
	@Override
	public String toString()
	{
		String result = "";
		for(int i=0; i<adj.length; i++)
			result += i + " => " + adj[i] + "\n";
		return result;
	}
	
	void addEdge(int u, int v)
	{
		adj[u].add(v);
	}
	
	/**
	* This methiod is going to compute the
	* indegree of each vertex 
	* T(n) = O(V+E)
	*/
    void computeIndegree(int indegree[], int n)
	{
		 for(int i=0; i<n; i++)
		 {
     		 for(int v : adj[i])
			 {
				indegree[v]++;
			 }
		 }
	}
	
	
	void topoLogicalOrdering(int indegree[], int n)
	{
		List<Integer> q = new LinkedList<>();
		
		/**
		* finding vertex withn indegree 0
		*/
		
		int src = -1;
		
		// T(n) = O(V)
		for(int i=0; i<n; i++)
		{
			if(indegree[i] == 0)
				src = i;
		}
		
		/**
		* Check if there is no vertex withn in degree 0 
		*/
		
		if(src == -1)
		{
			out.println("Not a DAG!!");
			return;
		}
		
		q.add(src);
		
		int count = 0;
		
		// T(n) = O(V+E)
		while(!q.isEmpty())
		{
			int u = q.remove(0);
			out.print(u+" ");
			
			for(int v : adj[u])
			{
				indegree[v]--;
				if(indegree[v] == 0)
					q.add(v);
			}
			count++;
		}
		
		/**
		* Check if there exists a cycle
		* in the graph or not
		*/
		
		if(count != n)
		{
			out.println("..\nNot a DAG!!");
			return;
		}
	}
	
	public static void main(String [] args)
	{
		// number of vertices
		int n = 7; 
		KahnsAlgorithm g = new KahnsAlgorithm(n);
		
		g.addEdge(0,1);
		g.addEdge(0,3);
		g.addEdge(1,2);
		g.addEdge(3,5);
		g.addEdge(5,4);
		g.addEdge(2,5);
		g.addEdge(5,6);
		//g.addEdge(4,2);
		
		out.println(g);
		
	    int indegree[] = new int[n];
		// compute indegree
		g.computeIndegree(indegree, n);
		// print topological ordering
        g.topoLogicalOrdering(indegree,n);	
	}
}
