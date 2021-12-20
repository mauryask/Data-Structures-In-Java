/**
* Time Complexity : O(V+E)
* Space Complexity  : O(V)
* Kahn's Algorithm : (It uses BFS)
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
	* This method is going to compute the
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
		
		/*
		* add all the vertices in the Queue
		* having indegree 0
		* Because there could be multiple vertices 
		* with indegree 0 (as in this example)
		* Taking only one vertex with indegree 0
		* is not going to work in this example
		*/
			
		// T(n) = O(V)
		for(int i=0; i<n; i++)
		{
			if(indegree[i] == 0)
				q.add(i);
		}
		
		int count = 0;
		
		// T(n) = O(V+E)
		/*
		* If graph is a DAG then each and every vertex will 
		* come in the queue once hence the count will be 
		* equal to 'n' 
		*/
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
		g.addEdge(4,5);
		g.addEdge(2,5);
		g.addEdge(4,6);
		//g.addEdge(4,2);
		
		out.println(g);
		
	    int indegree[] = new int[n];
		// compute indegree
		g.computeIndegree(indegree, n);
		// print topological ordering
        g.topoLogicalOrdering(indegree,n);	
	}
}
