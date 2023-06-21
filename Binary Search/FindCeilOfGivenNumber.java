/*
* Time complexity  : O(log n)
* Space complexity : O(1)
*/

import static java.lang.System.*;

public class FindCeilOfGivenNumber
{
	static int getCeilValue(int A[], int target)
	{
		int start = 0;
		int end = A.length-1;
		int result = -1;
		
		while(start <= end)
		{
			int mid = start + (end-start)/2;
			
			if(A[mid] == target)
				return A[mid];
			else if(A[mid] > target)
			{
				result = A[mid];
				end = mid - 1;
			}
			else if(A[mid] < target)
				start = mid + 1;
		}
		
		return result;
	}

	public static void main(String [] args)
	{
		int A[] = {1,2,3,4,8,9,10,14,15};
		int num = 14;		
		out.println(getCeilValue(A, target));
	}
}