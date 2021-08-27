/*
* Time complexity  : O(log n)
* Space complexity : O(1)
* The largest number less than the given
* number is the floor of the number 
*/

import static java.lang.System.*;

public class FindingFloorValueOfGivenNumber
{
	
	static int findFloor(int A[], int n, int num)
	{
		int start = 0;
		int end = n-1;
		int result = -1;
		
		while(start <= end)
		{
			int mid = start + (end-start)/2;
			
			if(A[mid] == num)
				return A[mid];
			
			if(num > A[mid])
			{
				result = A[mid];
				start = mid + 1;
			}
			else if(num < A[mid])
				end = mid - 1;
		}
		
		return result;
	}

	public static void main(String [] args)
	{
		int A[] = {1,2,3,4,8,9,10,14,15};
		int n = A.length;
		int num = 9;
		
		out.println(findFloor(A, n, num));
	}
}