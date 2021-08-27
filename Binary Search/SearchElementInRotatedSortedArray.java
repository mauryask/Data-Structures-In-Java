/*
* Time compelxity  : O(n)
* Space complexity : O(1)
*/

import static java.lang.System.*;

public class SearchElementInRotatedSortedArray
{
	static int findPivot(int A[], int n)
	{
		int low = 0;
		int high = n-1;
		
		while(true)
		{
			if(high < low)
				return 0;
			
			if(high == low)
				return low;
			
			int mid = high + (low - high)/2;
			
			if(mid < high && A[mid] > A[mid+1])
				return mid + 1;
			
			if(mid > low && A[mid] < A[mid-1])
				return mid;
			
			if(A[mid] > A[low])
				low = mid + 1;
			else if(A[mid] < A[high])
				high = mid - 1;
		}
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
		int A[] = {30};//{20,22,24,26,28,30,32,34,36,10,12,14,16,18};
		int n = A.length;
		int target = 30;
		
		/*
		* Finding the index of the  element (say pivot)
		* Before which the elements are rotated
		* now you have two sorted arrays
		* apply Binary Search on both of them
		*/
		
		int pivot = findPivot(A, n);
		int leftSub = binarySearch(A, n, 0, pivot-1, target);
		int rightSub = binarySearch(A, n, pivot , n-1, target);
		
		out.println(leftSub == -1 ? rightSub : leftSub);
	}
}