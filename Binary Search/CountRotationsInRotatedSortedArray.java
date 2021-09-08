/* Very Important
***********
* Time complexity  : O(log n)
* Space complexity : O(1)
* The solution below covers all the cases
***********
* The idea is to find min element index
* Since before this element 
* The rotated array exists
* in bruteForce solution we can directly find the 
* the index of smallest element
***********
* But Since the array is sorted we can apply 
* Binary search
**/
/*
* This solution not working if
* array is reverse sorted
*/

import static java.lang.System.*;

public class CountRotationsInRotatedSortedArray
{
	static int getRotationCount(int A[], int low, int high)
	{
		while(low < high)
		{			
			// if there is only one element
			// if array is already sorted
			if(high == low)
				return low;
			
			int mid = low + (high-low)/2;
			
			// check if (mid+1) is min element
			if (mid < high && A[mid+1] < A[mid])
				return mid+1;
			

			// check if mid itself is min element
			if (mid > low && A[mid] < A[mid - 1])
				return mid;

			/*
			* Deciding which subarray to 
			* take either left or right
			*/
			
			/*
			* If right subarray is already sorted
			* take left subarray
			* since the min element 
			* might be present there
			*/
			
			if(A[mid] < A[high])
				high = mid - 1;
			/*
			* If left subarray is already sorted
			* take right subarray
			* since the min element 
			* might be present there
			*/			
			else if(A[low] < A[mid])
				low = mid + 1;
		}
		
		return 0;
	}
	
	static int bruteForce(int A[], int n)
	{
		if(n==0 || n==1)
			return 0;
		
		int min = A[0];
		int minIndex = 0;
		
		for(int i=0; i<n; i++)
		{
			if(min > A[i])
			{
				min = A[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	public static void main(String [] args)
	{
		int A[] = {1,2,3,4,5,6};//{20,22,24,26,28,30,32,34,36,10,12,14,16,18};
		int n = A.length;
		out.println(getRotationCount(A, 0, n-1));
		//out.println(bruteForce(A, n));
		//out.println(adityaVermasSolution(A, n));
	}
}