/*
* Time complexity  : O(log n)
* Space complexity : O(1)
* Nearly sorted array means 
* The element that could be found at ith index 
* in the sorted array
* In nearly sorted array it might be present at
* ith, (i+1)th or (i-1)th position
*/

import static java.lang.System.*;

public class SearchElementInANearLySortedArray
{
	static int searchElement(int A[], int n, int target)
	{
		int start = 0;
		int end = n-1;
		
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			
			if(A[mid] == target)
				return mid;
			
			// check the boundries of the array to prevent 
			// ArrayIndexOutOfBounds
			if(mid-1 >= 0 && A[mid-1] == target)
				return mid-1;
			
			if(mid+1 < n && A[mid+1] == target)
				return mid+1;
		    
			if(target > A[mid])
				start = mid + 1;
			else if(target < A[mid])
				end = mid - 1;
		}
		
		return -1;
	}
	
	public static void main(String [] args)
	{
	    int A[] = {2,8,4,12,10,16,14,18};
		int n = A.length;
		int target = 14;

        out.println(searchElement(A, n, target));		
	}
}