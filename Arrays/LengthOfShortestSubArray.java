// Queation No : #13

// Time Complexity  : O(n)
// Space Complexity : O(1)

import static java.lang.System.*;

public class LengthOfShortestSubArray
{	
	public static void main(String [] args)
	{
		int A[] = {6, 3, 10, 11, 15, 
               20, 13, 3, 18, 12};
		out.println(solve(A));
	}

	static int solve(int A[])
	{
		int n = A.length;
	    
		int left = 0;
		int right = n-1;
		// finding the possible length of the subarray
		// from left side
		while(left < right && A[left] <= A[left+1])
			left++;
		
		//if array is already sorted
		if(left == n-1)
			return 0;
		
		// finding the possible length of the subarray
		// from right side
		while(left < right && A[right] >= A[right-1]) 
			right--;
		
		 // get minimum length
         int min_length = Math.min(n-left-1, right);
 
         int j= right;
		 
		 // finding the possible length of the
		 // sub array in the middle
		 for(int i=0; i<=left; i++)
		 {
			 if(A[i] <= A[j])
				 min_length = Math.min(min_length, j-i-1);
			 else if(j<n)
				 j++;
			 else
				 break;
		 }
		 
		 return min_length;
	}
}