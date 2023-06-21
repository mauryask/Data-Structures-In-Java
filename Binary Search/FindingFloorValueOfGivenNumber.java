/*
* Time complexity  : O(log n)
* Space complexity : O(1)
*/


import static java.lang.System.*;

public class FindingFloorValueOfGivenNumber
{
	
	static int findFloor(int A[], int target)
	{
		int start = 0;
		int end = A.length-1;
		int result = -1;
		
		while(start <= end)
		{
			int mid = start + (end-start)/2;

			if(A[mid] == target)
				return A[mid];
			else if(A[mid] < target)
			{
				result = A[mid];
				start = mid + 1;
			}
			else if(A[mid] > target)
				end = mid - 1;
		}
		
		return result;
	}

	public static void main(String [] args)
	{
		int A[] = {1,2,3,4,8,9,10,14,15};
		int target = 9;
		
		out.println(findFloor(A, target));
	}
}