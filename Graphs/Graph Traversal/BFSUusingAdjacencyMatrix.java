import java.util.*;
class Graph 
{
	int v_num;
	int adj[][];
	
	Graph(int v_num)
	{
		this.v_num = v_num;
		adj = new int[v_num][v_num];
	}
	
	void addEdge(int src, int dest)
	{
		  adj[src][dest] = 1;	
	      adj[dest][src] = 1;
	}
	
  void bfs(int src)
  {
	  boolean visited[] = new boolean[v_num];
	  Queue<Integer> q = new ArrayDeque<>();
	  
	  q.add(src);
	  visited[src] = true;
	  
	  while(!q.isEmpty())
	  {
		  int u = q.poll();
		  
		  System.out.print(u+" ");
		  
		  for(int v=0; v<v_num; v++)
		  {
			  if(adj[u][v] == 1 && !visited[v])
			  {
				  q.add(v);
				  visited[v] = true;
			  }				 
		  }
	  }

  }
}

public class BFSUusingAdjacencyMatrix
{
	public static void main(String [] args)
	{
		int v = 5;
		Graph g = new Graph(v);
		g.addEdge(0,4);
		g.addEdge(0,3);
		g.addEdge(3,2);
		g.addEdge(2,1);
		g.addEdge(1,0);
		
		g.bfs(0);
	}
}