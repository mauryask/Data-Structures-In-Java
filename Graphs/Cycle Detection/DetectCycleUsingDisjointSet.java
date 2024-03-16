/*
* T(n) : O(E * LogV)
* S(n ): O(V)
*/

import java.util.*;
import static java.lang.System.*;

public class DetectCycleUsingDisjointSet
{
    static class Edge 
    {
	   	int src;
		int dest;
		
		Edge(int src, int dest)
		{
			this.src = src;
			this.dest = dest;
		}
    }
   
   static int find(int size[], int key) //O(log n) (worst case)
   {	   
		if(size[key] < 0)
			return key;
		
		int temp = key;
		
		while(size[temp] >= 0)
		{
			temp = size[temp];
		}
		
		//Path compression (collapsing find)		
		size[key] = temp; //Updating parents
		
		return temp;
   }

   static void union(int size[], int xSet, int ySet)
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
   
   static boolean isCycle(List<Edge> edge)
   {
	    int n =  7;
	    int size[] = new int[n];			   
	    Arrays.fill(size, -1);
         
		for(Edge e : edge) 
		{
			int xSet  = find(size, e.src); 
			int ySet  = find(size, e.dest); 
			
			if(xSet == ySet)
				return true;
			
			union(size, xSet, ySet); 
		}
		
		return false;
   }
   
   	public static void main(String [] args)
	{		
	    List<Edge> edge = new ArrayList<>();
		
        edge.add(new Edge(0, 1));			
        edge.add(new Edge(1, 2));			
        edge.add(new Edge(0, 3));			
        edge.add(new Edge(2, 6));			
        edge.add(new Edge(2, 4));			
        //edge.add(new Edge(2, 3));			
        edge.add(new Edge(5, 4));				
	
		out.println(isCycle(edge));
	}
}

