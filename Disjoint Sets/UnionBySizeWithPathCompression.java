/*
* Union by size using path compression
* Here along with the size one more array
* parent is used to store the parent of each element
* ******
* Time complexity of find operation becomes even 
* less than (log n) , but the time complexity increases
* by O(n), since auxillary space
* is used as the parent array
**/

import static java.lang.System.*;

public class UnionBySizeWithPathCompression 
{
	static void makeSet(int size[], int parent[], int n)
	{
		/*
		* Initialize the size of each set to 1
		* and parent with the element itself
		*/
			
		for(int i=0; i<n; i++)
		{
           parent[i] = i;
		   size[i] = 1;
		}
	}
	
	/*
	* Time complexity: less than O(log n)
	*/
	static int find(int x, int parent[])
	{
		int temp = x;
		while(parent[temp] != temp)
			temp = parent[temp];
		/*
		* Path Compression
		*/
		parent[x] = temp;
		
		return temp;
	}
	
	static void union(int x, int y, int size[], int parent[])
	{
		int xSet = find(x, parent);
		int ySet = find(y, parent);
		
		/*
		* Check if both elemnets belog to the same set
		*/
		if(xSet == ySet)
			return;

		if(size[ySet] > size[xSet])
		{
			parent[xSet] = ySet;
			size[ySet] += size[xSet];
		}
		else 
		{
			parent[ySet] = xSet;
			size[xSet] += size[ySet];
		}		
	}
	
	public static void main(String [] args)
	{
		 int n = 7;
		 int size[] = new int[n];
		 int parent[] = new int[n];
		 makeSet(size, parent, n);
		 
		 union(0,1,size, parent);
		 union(2,3,size, parent);
		 union(5,6,size, parent);
		 union(0,5,size, parent);
		 union(6,2,size, parent);
		 union(3,4,size, parent);
		 union(4,3,size, parent);
		 
		 for(int i=0; i<n; i++)
		 {
			 out.print(parent[i]+" ");
		 }
		 
		 out.println();
		 
		 for(int i=0; i<n; i++)
		 {
			out.print(size[i]+" "); 
		 }
	}
}