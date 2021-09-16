/*
* T(n) : O(n) 
* S(n) : O(1)
*/
import static java.lang.System.*;
import java.util.*;

public class LargestSubArrayWithEqual0sAnd1s 
{
	static int largestSubArray(int A[], int n)
	{
		int sum = 0;
		/*
		* If no such subarray exist 
		* return maxLen = 0
		*/
		int maxLen = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++)
		{
			/*
			* if A[i] is 0 treat it as -1
			* and look for the subarrayu with sum = 0
			* since sum  = 0 is possibble if and only if 
			* there are eqaul 1s and -1s (aka 0s)
			*/
			
			/*
			* Storing Ai in temp if it is 0 then 
			* replace it with -1
			*/
			
			int temp = A[i];
		
			if(temp == 0)
				temp = -1;
	
			sum += temp;
			
			/*
			* If starting index of the subarray 
			* with sum = 0 is at 0
			*/
			if(sum == 0)
				maxLen = i+1;
				
		    map.putIfAbsent(sum, i);
				
			/*
			* Check if there update maxLen variable			
 			* exist (sum-k) (here k = 0)
			*/
			
			if(map.containsKey(sum-0))
			   maxLen = Math.max(maxLen, i-map.get(sum-0));	
		}
		
		return maxLen;
	}
	
	public static void main(String [] args)
	{
		int A[] = {1,0,1,1,1,0,0};
		int n = A.length;
		
		out.println(largestSubArray(A,n));
	}
}