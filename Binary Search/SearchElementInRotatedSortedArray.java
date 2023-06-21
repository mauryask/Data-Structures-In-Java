/*
* Time compelxity  : O(log n)
* Space complexity : O(1)
*/

import static java.lang.System.*;

public class SearchElementInRotatedSortedArray
{
	static int getPivotIndex(int A[], int n)
	{
		int low = 0;
		int high = n-1;
		
		while(low <= high)
		{
			if(high == low)
				return low;
			
			int mid = high + (low - high)/2;
			
			if(mid < high && A[mid] > A[mid+1])
				return mid + 1;			
			else if(mid > low && A[mid] < A[mid-1])
				return mid;
			
			if(A[mid] > A[low])
				low = mid + 1;
			else if(A[mid] < A[high])
				high = mid - 1;
		}
		
		//return -1 if array is not rotated
		return -1;
	}
	
	static int binarySearch(int A[],int n, int start, 
	int end, int target)
	{
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			
			if(A[mid] == target)
				return mid;
			
			if(target > A[mid])
				start = mid + 1;
			else if(target < A[mid])
				end = mid - 1;
		}
		
		return -1;
	}
	
	public static void main(String [] args)
	{
		int A[] =  {20,22,24,26,28,30,32,34,36,10,12,14,16,18};
		int n = A.length;
		int target = 14;
				
		int pivotIndex = getPivotIndex(A, n);
		
		//If array is not rotated
		if(pivotIndex == -1)
			out.println(binarySearch(A, n, 0, n-1));
		else 			
			return binarySearch(A, n, 0, pivotIndex-1, target) == -1 ? binarySearch(A, n, pivotIndex, n-1) : leftSub;				
	}
}