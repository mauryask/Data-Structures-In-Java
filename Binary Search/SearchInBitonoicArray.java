/*
* Time complexity  : O(log n)
* Space complexity : O(1)
***********
* It is basically a variation of problem 
* finding peak element int the in the Bitonic array
* After peak is found the array will be divided into
* two sorted arrays one sorted in ascendin order
* another in Descending order
* Apply binary search on both
* The key might be present in any one of them
*****************
https://www.geeksforgeeks.org/find-element-bitonic-array/
*/
import static java.lang.System.*;

public class SearchInBitonoicArray
{
	static int searchElement(int A[], int n, int target)
	{  
		 int peek = findPeek(A, 0, n-1, n);
		 
		 int lSub = binarySearch(A, 0, peek, target, true);
		 if(lSub != -1)
			 return lSub;
		 
		 return binarySearch(A, peek+1, n-1, target, false);		 
	}
	
	static int binarySearch(int A[], int start, 
	int end, int target, boolean flag)
	{
		while(start <= end)
		{
			int mid = start + (end -start) / 2;
			
			if(A[mid] == target)
				return mid;
			
			if(A[mid] > target)
			{
				if(flag)
				   end = mid-1;
			    else
				   start = mid + 1;
			}
			
			else if(A[mid] < target)
			{
				if(flag)
					start = mid + 1;
				else
					end = mid - 1;
			}	
		}
		
		return -1;
	}
	
	static int findPeek(int A[], int start,int end, 
	int n)
	{
		if(n==1)
			return 0;
		
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			
			if(mid > 0 && mid < n-1)
			{
				if(A[mid] > A[mid+1] && A[mid] > A[mid-1])
					return mid;
				else if(A[mid+1] > A[mid])
					start = mid  + 1;
				else
					end = mid - 1;
			}
			else
			{
				if(mid == 0)
				{
					if(A[mid] > A[mid+1])
						return mid;
					else
						start = mid + 1;
				}
				else if(mid == n-1)
				{
					if(A[mid] > A[mid-1])
						return mid;
					else
						end = mid -1;
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String [] args)
	{
		int A[] = {1,3,8,12,14,16,18,24,26,10,9,7,6,5};
		int n = A.length;
		
		out.println(searchElement(A, n, 3));
	}
}