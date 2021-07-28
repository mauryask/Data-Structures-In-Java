//graph representation using adjacency list
import java.util.*;
public class GraphUsingAdjacencyMatrix 
{
	private static int v;
	private static int adjacencyMatrix[][];
	
	static void makeGraph(int vertex)
	{
		v = vertex;
		adjacencyMatrix = new int[v][v];
	}
	
	static void addEdge(int to, int from, int edge)
	{
	    try
	    {
			//for directed graph use it only once
		   adjacencyMatrix[to][from] = edge; 
		   //for undirected graph use it above 
		   //once more but inopposite index
		   adjacencyMatrix[from][to] = edge;
	    }	
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("invalid edge..");
		}
	}
	
	static int getEdge(int to, int from)
	{
		 try
		 {
			 return adjacencyMatrix[to][from];
		 }
		 catch(ArrayIndexOutOfBoundsException ex)
		 {
			 System.out.println("invalid edge..");
		 }
		 return -1; //if exception occurs
	}
	
	public static void main(String [] args)
	{
		int v, e, to = 0, from = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		v = sc.nextInt();
		System.out.print("\nEnter number of edges: ");
		e =  sc.nextInt();
		
		makeGraph(v);
		
		System.out.println("Enter edges to from: ");
		while(e-->0)
		{
		   to = sc.nextInt();
		   from = sc.nextInt();   
		   addEdge(to,from,1);
		}
		
		System.out.println("The adjacency matrix is: ");
				
		for(int i=0; i<v; i++)
		{
			System.out.print(" ");
			for(int j=0; j<v; j++)
			{
				System.out.print(getEdge(i,j)+" ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}