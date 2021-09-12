/*
* Finding first occurance of a given nuumber
* in a sorted array
* Time complexity  : O(log n)
* Space complexity : O(1)
*/

import static java.lang.System.*;

public class FindFirstAndLastOcuuranceOfAnElement
{
    static int findFirstOccuirrance(int A[], int n, int target)
	{
		int start = 0;
		int end = n-1;
		int result = -1;
		
		while(start <= end)
		{
			int mid = start + (end-start)/2;
			
			if(A[mid] == target)
			{
				result = mid;
				end = mid - 1;
			}
			else if(target > A[mid])
				start = mid + 1;
			else 
				end = mid - 1;
		}
		
		return result;
	}
	
	public static void main(String [] args)
	{
		int A[] = {1,2,3,5,10,10,10,10,12,13,14,15,16};
		out.println(findFirstOccuirrance(A, A.length, 10));
	}
}