// T(n) : O(log n)
// S(n) : O(1)

import static java.lang.System.*;

public class CountOccuranceOfANumebrInSortedArray
{
    static int getIndex(int A[], int target, int start, int end, boolean flag)
	{
		int result = -1;
		
		while(start <= end)
		{
			int mid = start + (end - start) / 2;
			
			if(A[mid] == target)
			{
				result = mid;
				//flag : true means we are finding first occurance
				if(flag == true)
				   end = mid - 1;
			   else
				   start = mid + 1;
			}			
			else if(A[mid] > target)
				end = mid - 1;
			else if(A[mid] < target)
				start = mid + 1;
		}
		
		return result;
	}
	
    static int countOccurance(int A[], int target)
	{		
		int startIndex = getIndex(A, target, 0, A.length - 1, true);
		
		//If element is not present in the array; ocuurance will be 0
		if(startIndex == -1)
			return 0;

		int lastIndex = getIndex(A, target, startIndex, A.length - 1, false);
		
		return lastIndex - startIndex + 1;
	}


	public static void main(String [] args)
	{
		int A[] = {1,2,3,4,10,10,10,10,10,10,45,74,85,96};
		int target = 10;	
		int count = countOccurance(A, target);
		out.println(count);
	}
}


































