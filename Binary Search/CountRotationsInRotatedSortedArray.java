/* Very Important
***********
* Time complexity  : O(log n)
* Space complexity : O(1)
* The solution below covers all the cases
**/

import static java.lang.System.*;

public class CountRotationsInRotatedSortedArray
{
	static int getRotationCount(int A[], int n)
	{
		int low = 0;
		int high = n-1;
		
		while(true)
		{
			if(high < low)
				return 0;
			
			// if there is only one element
			// if array is already sorted
			if(high == low)
				return low;
			
			int mid = high + (low-high)/2;
			
			// check if (mid+1) is min element
			if (mid < high && A[mid+1] < A[mid])
            return (mid + 1);
 
 			// check if mid itself is min element
            if (mid > low && A[mid] < A[mid - 1])
              return mid;

            /*
			* Deciding which subarray to 
			* take either left or right
			*/
			
			/*
			* If left subarray is already sorted
			* take right subarray
			* since the min element 
			* might be present there
			*/
			if(A[mid] > A[low])
				low = mid + 1;	
			
			/*
			* If right subarray is already sorted
			* take left subarray
			* since the min element 
			* might be present there
			*/			
			else if(A[mid] < A[high])
				high = mid - 1;		
		}
	}
	
	public static void main(String [] args)
	{
		int A[] = {20,22,24,26,28,30,32,34,36,10,12,14,16,18};
		int n = A.length;
		out.println(getRotationCount(A, n));
	}
}