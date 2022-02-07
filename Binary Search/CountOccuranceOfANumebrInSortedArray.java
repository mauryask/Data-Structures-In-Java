/**
* Time complexity: O(n)
* Space compelxity: O(1)
*/

import static java.lang.System.*;

public class CountOccuranceOfANumebrInSortedArray
{
	static int countOccurance(int A[], int n, int target)
	{
		// find first occurance
        int start = getIndex(A, 0,n-1, target, true);
		
		// if the element is not found
		if(start == -1)
			return 0;
		
        // find last occurance
		int end = getIndex(A, start, n-1, target, false);
		// return total count of the element
		return end-start+1; 
	}

  		/*
		 * The variable flag decides 
		 * which occurance to find
		 * either first or last
		 * if true : first
		 * if false: last
		*/

    static int getIndex(int A[], int start, int end, 
	int target, boolean flag)
	{
		int result = -1;
		
		while(start <= end)
		{
			int mid = start + (end-start)/2;
			
			if(A[mid] == target)
			{
				result = mid;
				if(flag)
				   end = mid-1;
			   else
				   start = mid+1;
				continue;
			}
			
			if(target > A[mid])
				start = mid+1;
			else
				end = mid-1;
		}
		
		return result;
	}

	public static void main(String [] args)
	{
		int A[]  = {1,2,3,4,10,10,10,10,10,10,45,74,85,96};
		int n = A.length;
		int target = 10;
		
		int count = countOccurance(A, n, target);
		out.println(count);
	}
}