/*
* Space complexity : O(1)
* Time complexity  : O(log n)
* A variation of exponential search
*/

import static java.lang.System.*;

public class SearchElementInInfiniiteSortedArray
{
	static int getElementIndex(int A[], int key)
	{
		if(A[0] == key)
			return 0;
		
		int index = 1;
				
	    while(A[index] <= key)
		{
			if(A[index] == key)
				return index;
			
			index = index * 2;
		}
		
		return binarySearch(A, index/2, index, key);
	}
	
	static int binarySearch(int A[], int start,int end, int key)
	{
		while(start <= end)
		{
			int mid = start + (end-start)/2;
			
			if(A[mid] == key)
				return mid;			
			else if(A[mid] < key)
				start = mid+1;			
			else if(A[mid] > key)
				end = mid - 1;
		}
		
		return -1;
	}
	
	public static void main(String [] args)
	{
		int A[] = {2,4,5,6,8,10,12,14,45,78,96,100,102,108,114,115,150,222,400,5414,632};
		int key = 102;
		out.println(getElementIndex(A, key));
	}
}