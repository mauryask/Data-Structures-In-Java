/*
* Union by Size without path compression
* Here initially each element is kept in a separate set
* and size of each set is -1
* The idea is to attach the tree with smaller size 
* to root of the tree with higher size 
* as the result the height of the tree nver exceeds (log n)
* so if there are m find operations then overall 
* Time Complexity: O(m*log n)
* In order to apply path compression we have to use another
* azuxillary array to store the size/rank of each element
*/

import static java.lang.System.*;
import java.util.Arrays;

public class UnionBySizeWithoutPathCompression 
{
	static void makeSet(int size[])
	{
		/*
		* Initialize the size of each set to -1
		*/
		Arrays.fill(size,-1);
	}
	
	/*
	* Time complexity: O(log n)
	*/
	static int find(int x, int size[])
	{
		int temp = x;
		while(size[temp] >= 0)
		{
			temp = size[temp];
		}
		
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
		
		/*
		* Compare the size of both sets
		* One with less size(-ve) will have
		* higher absolute value
		*/
		if(size[xSet] > size[ySet])
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
		 int n = 8;
		 int size[] = new int[n];
		 makeSet(size);
		 
		 union(0,1,size);
		 union(3,4,size);
		 union(6,7,size);
		 union(0,3,size);
		 union(3,7,size);
		 union(0,5,size);
		 union(2,3,size);
	}
}