/*
* Kruskal's Algorithm to find MST
* Time complexity : O(E*log V) 
**** log V is time taken by Union operation
**** and we are performing it exactly E-times
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
	
	static void makeSet(int parent[], int n)
	{
		for(int i=0; i<n; i++)
			parent[i] = i;
	}
	
	static int find(int ele, int parent[])
	{
		int temp = ele;
		while(parent[temp] != temp)
			temp = parent[temp];
		parent[ele] = temp;
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
		
		makeSet(parent, n);
		
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
				
		edge[0] = new Edge(0,1,4);
		edge[1] = new Edge(0,2,12);
		edge[2] = new Edge(1,2,10);
		edge[3] = new Edge(0,3,18);
		edge[4] = new Edge(3,2,16);
		
		kmst(n, edge, result);
	}
}