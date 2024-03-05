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
		int maxLen = 0;		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		
		for(int i=0; i<n; i++)
		{			
			if(A[i] == 0)
				sum += -1;
			else 
				sum += 1;
								 	
			if(map.containsKey(sum))
			   maxLen = Math.max(maxLen, i-map.get(sum));
			else 
				map.put(sum, i);
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