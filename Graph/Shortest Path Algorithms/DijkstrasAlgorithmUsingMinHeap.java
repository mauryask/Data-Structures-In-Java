// Time Complexity : O(E*logV) + O(V*logV) = O(E*logV)
// Space Complexity: O(V+E)
 
import static java.lang.System.*;
import java.util.*;

class Graph 
{
	class Edge 
	{
		int v, w;
		Edge(int v, int w)
		{
			this.v = v;
			this.w = w;
		}
		
		@Override 
		public String toString()
		{
			return "("+v+","+w+")";
		}
	}
	int v_num;
	List<Edge> adj[];
	
	Graph(int v_num)
	{
		this.v_num = v_num;
		adj = new LinkedList[v_num];
		for(int i=0;i<v_num; i++)
			adj[i] = new LinkedList<Edge>();
	}
	
	@Override
	public String toString()
	{
		String result = "";
		for(int i=0;i<v_num;i++)
			result += i+" ==> "+adj[i]+"\n";
		return result;
	}
	
	void addEdge(int u, int v, int w)
	{
		adj[u].add(new Edge(v, w));
		//adj[v].add(new Edge(u, w));
	}
	
	class MinHeap
	{
		int vertex;
		int dist;
	}
	
	void dijkstra(int src)
	{
		boolean visited[] = new boolean[v_num];
		// it works as the distance array
		// where the indices are vertices and dist is distacnce from source
		// the vertex variabl is for TreeSet to find the minDist vertex not for 
		// heap array (forget it for the heap array declared below)
		MinHeap [] heap = new MinHeap[v_num]; 
		
        TreeSet<MinHeap> set = new TreeSet<>((o1,o2)->{
			return o1.dist - o2.dist;
		});		
		
		for(int i=0;i<v_num; i++)
		{
			visited[i] = false;
			heap[i] = new MinHeap();
			heap[i].dist = Integer.MAX_VALUE;
			heap[i].vertex = i;
			set.add(heap[i]);
		}
		
		heap[src].dist = 0;
		
		for(int i=0;i<v_num; i++)
		{
			//extrracting min
			MinHeap node = set.pollFirst(); // O(V*logV)
			int u  =  node.vertex;
			visited[u] = true;
			boolean flag =  false;
			
			// relaxing adjacent edges
			for(Edge e : adj[u]) // O(E*logV)
			{
				if(!visited[e.v] && heap[u].dist + e.w < heap[e.v].dist)
				{
					set.remove(heap[e.v]);
					heap[e.v].dist = heap[u].dist + e.w; // decrease key
					set.add(heap[e.v]);
				}
			}
		}
		
		for(int i=0;i<v_num; i++)
			out.println(src+" ==> "+i+" : "+heap[i].dist);
	}
}

public class DijkstrasAlgorithmUsingMinHeap
{
   public static void main(String [] args)
   {
	   Graph g = new Graph(8);
	   g.addEdge(0,1,7);
	   g.addEdge(4,1,11);
	   g.addEdge(2,1,8);
	   g.addEdge(6,1,3);
	   g.addEdge(4,5,4);
	   g.addEdge(5,3,3);
	   g.addEdge(2,3,5);
	   g.addEdge(2,7,2);
	   g.addEdge(6,7,9);
	   
	   g.dijkstra(0);
   }   
}
