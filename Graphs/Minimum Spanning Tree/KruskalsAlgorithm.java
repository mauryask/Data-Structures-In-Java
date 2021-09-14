/*
* Kruskal's Algorithm to find MST
* Time complexity : O(E*log V)
* Space complexity: O(V)
* This is a  Greedy Algorithm
*/

import java.util.*;
import static java.lang.System.*;

public class KruskalsAlgorithm 
{
	static class Edge 
	{
		int u, v, w;
		Edge(){}
		Edge(int u, int v, int w)
		{
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		@Override
		public String toString()
		{
			return "("+u+","+v+","+w+")";
		}
	}    
	
	static int find(int x, int parent[])
	{
		int temp = x;
		while(parent[temp] != temp)
			temp = parent[temp];
		parent[x] = temp;
		return temp;
	}
	
	static void union(int xSet, int ySet,
	int parent[], int rank[])
	{
		if(rank[xSet] > rank[ySet])
			parent[ySet] = xSet;
		else if(rank[ySet] > rank[xSet])
			parent[xSet] = ySet;
		else
		{
			rank[xSet] += 1;
			parent[ySet] = xSet;
		}
	}
	
	static void kmst(int n, Edge[] edge, Edge[] result)
	{
	   /*
	   * Sorting edges according to the weights
	   */
		Arrays.sort(edge, (e1, e2)->
		{return e1.w - e2.w;});
		
	   /* 
	   * Implementing union by rank
	   * to remove edges causing the cycle
	   * Since MST can't have a cycle 
	   */
		int parent[] = new int[n];
		int rank[] = new int[n];
		
		for(int i=0; i<n; i++)
			parent[i] = i;
		
		int j = 0;
		
		for(Edge e : edge)
		{
			int xSet = find(e.u, parent);
			int ySet = find(e.v, parent);
			
			if(xSet != ySet)
			{
				result[j++] = e;
				union(xSet, ySet, parent, rank);
			}
		}
		
		for(Edge e : result)
			out.println(e);
	}
	
	public static void main(String [] args)
	{
		int n = 4;
		int e = 5;
		Edge[] edge = new Edge[e];
       
	   /* 
	   * This array holds the resulting MST
	   * Size is |v|-1, since MST contains |v|-1 edges
 	   */
		Edge[] result = new Edge[n-1];
		
		for(int i=0; i<n-1; i++)
			result[i] = new Edge();
		
		edge[0] = new Edge(0,1,4);
		edge[1] = new Edge(0,2,12);
		edge[2] = new Edge(1,2,10);
		edge[3] = new Edge(0,3,18);
		edge[4] = new Edge(3,2,16);
		
		kmst(n, edge, result);
	}
}