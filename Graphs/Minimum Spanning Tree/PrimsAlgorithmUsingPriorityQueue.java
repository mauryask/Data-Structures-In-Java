/*
* Time complexity is same as the 
* Dikstra's algorithm
* O(V + E * log V)
*/

import java.util.*;
import static java.lang.System.*;

class PrimsAlgorithmUsingPriorityQueue 
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
	
	PrimsAlgorithmUsingPriorityQueue (int v_num)
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
  
  // MinHeap
   class Util
	{
		int vertex; 
		int weight; 
		
		Util(int vertex, int weight)
		{
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
  
  void PMST(int src)
  {
	int parent[] = new int[v_num];  
	boolean visited[] = new boolean[v_num];
	int weight[] = new int[v_num];
	
	Arrays.fill(weight, Integer.MAX_VALUE);
	
	/* make sorce vertex weight as  0 */
    weight[src] = 0;
   
	Queue<Util> q = new PriorityQueue<>((a, b)->
	{
		return a.weight - b.weight;
	});
 	
	/*
	* Add source vertex in te heap 
	* along with its weight as 0
	*/
    q.add(new Util(src, 0));
	 	  
     while(!q.isEmpty())
	 {
		 /*
		 * Get vertex with minimum weight from the heap
		 * It will not contain the visitedf vertices 
		 * since visited verticers are being removed 
		 * from the heap at the end
		 */
		 
	    Util node  = q.element();
        int u = node.vertex;
        
		for(Edge e : G[u])
		{
				if(!visited[e.v] && weight[e.v]  > e.w)
				{
					weight[e.v] = e.w;
					parent[e.v] = u;
					/*
					* add adjacent vertices to the 
					* heap along with the updated
					* weight
					*/
					q.add(new Util(e.v, e.w));
				}
		}
		
		/*
		* Once sone with all the adjacent 
		* Its time to say good bye to it 
		* i.e. remove it from heap 
		* and mark it as visited
		*/
		
		visited[u] = true;
		q.remove();
	 } 
	 
	 /*
	 * Printing MST
	 */
	   for(int i=1; i<v_num ; i++)
		   out.println(parent[i]+" => "+ i + 
	       " : " + weight[i]);
 }
	
	  public static void main(String [] args)
		{
			/*
			* Creating graph
			*/
			PrimsAlgorithmUsingPriorityQueue  g = new PrimsAlgorithmUsingPriorityQueue (7);
			g.addEdge(0,1,8);
			g.addEdge(0,3,2);
			g.addEdge(0,2,3);
			g.addEdge(1,2,5);
			g.addEdge(1,4,6);
			g.addEdge(1,5,11);
			g.addEdge(2,4,12);
			g.addEdge(2,5,7);
			g.addEdge(4,6,9);
			g.addEdge(3,6,5);
			
			/* 
			* Lets take 0 as source vertex
			* Though we can pick any random vertex 
			* as source vertex
			*/
			
			g.PMST(0);	
		}
}