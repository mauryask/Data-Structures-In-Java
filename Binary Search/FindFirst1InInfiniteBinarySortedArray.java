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
		int index = 1;
		
		if(A[0] == key)
			return 0;
		
		while(A[end] < key)
		   index = index * 2;
		
		return binarySearch(A, index, index/2, key);
	}
	
	
	static int binarySearch(int A[],int start, int end, int key)
	{
		int result = -1;
		
		while(start <= end)
		{
			int mid = start + (end - start) / 2;
						
			//Here we dont need to check A[mid] > target 
            //since none of the element is greater than key(i.e. 1)
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
		out.println(findIndexOfFirstOne(A, key));
	}
}