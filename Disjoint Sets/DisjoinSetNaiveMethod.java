/*
*  Time complexity  : O(n^2)
*  Space complexity : O(n)
*  The array index represents elements-
*  set-name: to which the elements belongs
*  The array values represent the parents 
*  of the elements
**/

import static java.lang.System.*;

public class DisjoinSetNaiveMethod
{
	static void makeSet(int parent[], int n)
	{
	  for(int i=0; i<n; i++)
		parent[i] = i;		  
	}
	
	/*
	* Each find operation takes O(n)
	*/
	static int find(int x, int parent[])
	{
		int temp = x;
		
		while(parent[temp] != temp)
			temp = parent[temp];
		return temp;
	}
	
	static void union(int x,int y, int parent[])
	{
		int xSet = find(x, parent);
		int ySet = find(y, parent);
		
		if(xSet == ySet)
			return;
		
		parent[ySet] = xSet;
	}
	
	public static void main(String args[])
	{
	     int n = 7;
	     int parent[] = new int[n];
	     makeSet(parent, n);	   
	   
         union(0,1, parent);
		 union(2,3, parent);
		 union(5,6, parent);
		 union(0,5, parent);
		 union(6,2, parent);
		 union(3,4, parent);
		 union(4,3, parent);
		 
		 for(int i=0; i<n; i++)
		 {
			 out.print(parent[i]+" ");
		 }  
	}
}