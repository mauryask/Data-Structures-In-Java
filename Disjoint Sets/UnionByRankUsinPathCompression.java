/*
* Union By Rank with path compression
* Time complexity for find() operation 
* is less than O(log n)due to path compression
* Space complexity: O(n) => auxilary array as rank
* Recommended to use this approach
* Note: Union By size and union by rank 
* both are almost same
**/

import java.util.*;
import static java.lang.System.*;

public class UnionByRankUsinPathCompression
{
	static void makeSet(int n, int parent[])
	{
		for(int i=0; i<n; i++)
			parent[i] = i;
	}
	
	static int find(int x, int parent[])
	{	
		int root =  x;
		
		while(parent[root] != root)
			root = parent[root];
		
		/*
		* Path compression implementation
		**/
		parent[x] = root;
		return root;
	}
	
	static void union(int x, int y, int parent[], int rank[])
	{
	   int xSet = find(x, parent); 
	   int ySet = find(y, parent); 
	   
		/*
		* check if both belong to the same parent
		*/
	   if(xSet == ySet)
		   return;
	   
	   /*
	   * If they belong from different sets
	   * One with the higher rank will be the parsent
	   */
	   if(rank[xSet] < rank[ySet])
		   parent[xSet] = ySet; 
	   else if(rank[xSet] > rank[ySet])
		   parent[ySet] = xSet;
	   else // if rank is same for both
	   {
		   parent[ySet] = xSet;
		   rank[xSet] += 1;
	   }
	}
	
	public static void main(String [] args)
	{
	   	 int n = 7;
		 int rank[] = new int[n];
		 int parent[] = new int[n];
		 makeSet(n, parent);
		 
		 union(0,1, parent, rank);
		 union(2,3, parent, rank);
		 union(5,6, parent, rank);
		 union(0,5, parent, rank);
		 union(6,2, parent, rank);
		 union(3,4, parent, rank);
		 union(4,3, parent, rank);
		 
		 for(int i=0; i<n; i++)
		 {
			 out.print(parent[i]+" ");
		 }
		 
		 out.println();
		 
		 for(int i=0; i<n; i++)
		 {
			out.print(rank[i]+" "); 
		 }
	}
}