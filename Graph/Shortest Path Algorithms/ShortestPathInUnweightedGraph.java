import java.util.LinkedList;
import java.util.List;
import static java.lang.System.out;
import static java.lang.System.in;

class Graph 
{
	int v_num;
	List<Integer> G[];
	
	Graph(int v_num)
	{
		this.v_num = v_num;
		G = new LinkedList[v_num];
		for(int i=0; i<G.length; i++)
			G[i] = new LinkedList<Integer>();
	}
 
  void addEdge(int u, int v)
  {
	  //undirected graph
	  G[u].add(0,v);
	  //G[v].add(0,u);
  }

	public String toString()
	{
		String result = "";
		for(int i=0; i<v_num; i++)
			result += i+" ==>"+G[i]+"\n";
		return result;
	}
		
	boolean isConnected(int u, int v)
	{
		for(Integer i : G[u])
		if(i == v)
			 return true;
		return false;
	}


   void findshortestPath(int s, int d)
   {
	   int distance[] = new int[v_num];
	   int parent[] = new int[v_num];
	  /* if(!bfSearch(s,d,distance,parent))
	   {
	      	System.out.println("They are not connected...");
			return;
	   }	
	  
	  System.out.println("Distance: "+distance[d]);
	 
	  LinkedList<Integer> path = new LinkedList<>();
	  int crawl = d;
	  path.add(crawl);
	  
	  while(parent[crawl] != -1)
	  {
		path.add(parent[crawl]);
		crawl = parent[crawl];
	  }
	  
	  for(int i = path.size()-1 ; i >= 0; i--)
		  System.out.print(path.get(i)+" ");*/
	  
	  //or we can use a recursive method to print shorest path
	    bfSearch(s,d,distance,parent);
		printPathRecursively(s, d, parent);
	  
	  }
	  
	  void printPathRecursively(int s, int d, int  parent[]) //destination vertex
	  {
		    if(d == s)
			 System.out.print(s+" ");
			else if(parent[d] == -1)
			{
				System.out.println("They are not connected..");	
				return;
			}
			else
			{
				printPathRecursively(s,parent[d],parent);
		        System.out.print(d+" ");
			}
	 }
	

	boolean bfSearch(int s, int d, int distance[],int parent[])
	{
	   boolean visited[] = new boolean[v_num];
	   LinkedList<Integer> queue = new LinkedList<>();
	   
	   for(int i=0; i<v_num; i++)
	   {
		   visited[i] = false;
		   distance[i] = Integer.MAX_VALUE;
		   parent[i] = -1;
	   }
	   
	   visited[s] = true;
	   distance[s] = 0;

	   queue.add(s);
	   
	   while(!queue.isEmpty())
	   {
		   int u = queue.remove();
		   for(Integer v : G[u])
		   {
			   if(visited[v] == false)
			   {
				   visited[v] = true;
				   distance[v] = distance[u] + 1;
				   queue.add(v);
				   parent[v] = u;
				   if(v == d)
					  return true;
			   }
		   }
	   }
	   
       return false;
	   
	}
	
}

public class ShortestPathInUnweightedGraph
{
	public static void main(String [] args)
	{
		Graph g = new Graph(7);
		
		g.addEdge(0,1);
		g.addEdge(2,0);
		g.addEdge(6,2);
		g.addEdge(3,6);
		g.addEdge(2,1);
		g.addEdge(1,4);
		g.addEdge(6,5);
		g.addEdge(5,3);
		g.addEdge(5,4);
		//g.addEdge(1,3);
		
		System.out.println(g);
		System.out.println("=================\n");	
		g.findshortestPath(3,4);
	
	}
}