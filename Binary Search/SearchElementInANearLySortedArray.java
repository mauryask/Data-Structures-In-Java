/*
* Time complexity  : O(log n)
* Space complexity : O(1)
*/

import static java.lang.System.*;

public class SearchElementInANearLySortedArray
{
	static int getElement(int A[], int target)
	{
		int start = 0;
		int end = A.length-1;
		
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			
			if(A[mid] == target)
				return mid;		
			else if(mid-1 >= 0 && A[mid-1] == target)
				return mid-1;			
			else if(mid+1 < n && A[mid+1] == target)
				return mid+1;
		    
			if(target > A[mid])
				start = mid + 2;
			else if(target < A[mid])
				end = mid - 2;
		}
		
		return -1;
	}
	
	public static void main(String [] args)
	{
	    int A[] = {2,8,4,12,10,16,14,18};
		int target = 14;
        out.println(searchElement(A, target));		
	}
}