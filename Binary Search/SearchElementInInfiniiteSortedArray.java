/*
* Space complexity : O(1)
* Time complexity  : O(log n)
************
* Here we will apply binary search but the 
* Issue is we don't know where to put the "end" pointer
* Since the array has infinite number of element
* so we will put the end pointer at start + 1 (where start = 0)
* Now we will move the end pointer twice every time until the 
* key greater than the Aend
* Once we found the end index (where key < Aend)
* We got the sub array (start to end) where the element might be found
* Now we can apply binary search here 
*/

import static java.lang.System.*;

public class SearchElementInInfiniiteSortedArray
{
	static int findElement(int A[], int key)
	{
		int start = 0;
		int end = start + 1;
		
	    while(key > A[end])
		{
			start = end;
			end = end * 2;
		}
		
		return binarySearch(A, start, end, key);
	}
	
	static int binarySearch(int A[], int start,int end, int key)
	{
		while(start <= end)
		{
			int mid = start + (end-start)/2;
			
			if(A[mid] == key)
				return mid;
			
			if(A[mid] < key)
				start = mid+1;
			
			else if(A[mid] > key)
				end = mid - 1;
		}
		
		return -1;
	}
	
	public static void main(String [] args)
	{
		int A[] = {2,4,5,6,8,10,12,14,45,78,96,100,102,108,114,115,150,222,400,541,632};
		int key = 102;
		
		out.println(findElement(A, key));
	}
}