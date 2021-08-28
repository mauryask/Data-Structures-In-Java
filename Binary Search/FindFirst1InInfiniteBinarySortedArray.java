/*
* Time complexity  : O(log n)
* Space complexity : O(1)
************
* This problem is combination of 
* (serach in infinite sorted array + find find first occurance)
*/

import static java.lang.System.*;

public class FindFirst1InInfiniteBinarySortedArray
{
	static int findIndexOfFirstOne(int A[], int key)
	{
		int start = 0;
		int end = start + 1;
		
		while(key > A[end])
		{
			start = end;
			end = end * 2;
		}
		
		return (binarySearch(A, start, end, key));
	}
	
	
	static int binarySearch(int A[],int start, int end, int key)
	{
		int result = -1;
		
		while(start <= end)
		{
			int mid = start + (end - start) / 2;
			
			if(A[mid] == key)
			{
				result = mid;
				end = mid -1;
				continue;
			}
			
			if(key > A[mid])
				start = mid + 1;
			
			else if(key < A[mid])
				end = mid - 1;
		}
		
		return  result;
	}
	
	public static void main(String [] args)
	{
		int A[] = {0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int key = 1;
		
		out.println(findIndexOfFirstOne(A, key));
	}
}