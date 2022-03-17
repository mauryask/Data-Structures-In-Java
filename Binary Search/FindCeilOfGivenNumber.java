/*
* Time complexity  : O(log n)
* Space complexity : O(1)
* The smallest number greater than the given
* key is the ceil of the key
*/

import static java.lang.System.*;

public class FindCeilOfGivenNumber
{
	static int findCeil(int A[], int n, int num)
	{
		int start = 0;
		int end = n-1;
		int result = -1;
		
		while(start <= end)
		{
			int mid = start + (end-start)/2;
			
			// if element is present in the array then 
			// it is going to be ceil itself
			if(A[mid] == num)
				return A[mid];
			
			/*
			* If A[mid] > num then A[mid] 
			* could be the possible candidate
			*/
			
			if(num < A[mid])
			{
				result = A[mid];
				end = mid - 1;
			}
			else if(num > A[mid])
				start = mid + 1;
		}
		
		return result;
	}

	public static void main(String [] args)
	{
		int A[] = {1,2,3,4,8,9,10,14,15};
		int n = A.length;
		int num = 14;
		
		out.println(findCeil(A, n, num));
	}
}