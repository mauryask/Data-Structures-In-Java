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
	
	static int find(int key, int size[])
	{
		if(size[key] < 0)
			return key;
		
		int temp = key;
				
		while(size[temp] >= 0)
			temp = size[temp];
		
		size[key] = temp;
		
		return temp;
	}
		
	static void union(int xSet, int ySet, int size[])
	{
		if(Math.abs(size[ySet]) > Math.abs(size[xSet]))
		{
			size[ySet] += size[xSet];
			size[xSet] = ySet;			
		}
		else
		{
			size[xSet] += size[ySet];
			size[ySet] = xSet;
		}
	}
	
	static void kmst(int n, Edge[] edge, Edge[] result)
	{
	   /*
	   * Sorting edges according to the weights
	   */
		Arrays.sort(edge, (e1, e2)->e1.w - e2.w);
		
	   /* 
	   * Implementing union by rank
	   * to remove edges causing the cycle
	   * Since MST can't have a cycle 
	   */
		int size[] = new int[n];
		//Make set	
		Arrays.fill(size, -1);
		
		int j = 0;
		
		for(Edge e : edge)
		{
			int xSet = find(e.u, size);
			int ySet = find(e.v, size);
			
			if(xSet != ySet)
			{
				result[j++] = e;
				union(xSet, ySet, size);
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