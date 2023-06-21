/*
* Time complexity  : O(log n)
* Space complexity : O(1)
*/

import static java.lang.System.*;

public class FindFirst1InInfiniteBinarySortedArray
{
	static int getIndexOfFirstOne(int A[], int key)
	{
		int index = 1;
		
		if(A[0] == key)
			return 0;
		
		while(A[end] < key)
		   index = index * 2;
		
		return binarySearch(A, index/2, index, key);
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
			}			
			else if(A[mid] < key)
			    start = mid + 1;
		}
		
		return  result;
	}
	
	public static void main(String [] args)
	{
		int A[] = {0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int key = 1;		
		out.println(getIndexOfFirstOne(A, key));
	}
}