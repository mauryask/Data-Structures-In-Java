/*
* T(n) : O(m * logn)
* Here logn is for single find operation
* for m find operations : m * logn
* S(n) : O(n)
**/

import static java.lang.System.*;

public class UnionBySizeWithPathCompression 
{
	static void makeSet(int size[], int n)
	{			
		for(int i=0; i<n; i++)
           size[i] = -1;
	}
	
	static int find(int key, int size[])
	{		
		if(size[key] < 0)
			return key;
		
		int temp = key;
		
		while(size[temp] > 0)
			temp = size[temp];
		
		//Path compression (collapsing find)		
		size[key] = temp; //Updating parents
		
		return temp;
	}
	
	static void union(int x, int y, int size[])
	{
		int xSet = find(x, size);
		int ySet = find(y, size);
		
		/*
		* Check if both elemnets belog to the same set
		*/
		if(xSet == ySet)
			return;

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
	
	public static void main(String [] args)
	{
		 int n = 7;
		 int size[] = new int[n];
		 makeSet(size, n);
		 
		 union(0,1,size);
		 union(2,3,size);
		 union(5,6,size);
		 union(0,5,size);
		 union(6,2,size);
		 union(3,4,size);
		 union(4,3,size);
		 
		 for(int i=0; i<n; i++)
			 out.println(i+" : "+size[i]);
	}
}