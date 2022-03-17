/*
* T(n) : O(n) 
* S(n) : O(n)
*/
import static java.lang.System.*;
import java.util.*;

public class CountSubArrayWithEqual0sAnd1s 
{
	static int countSubArray(int A[], int n)
	{
		int sum = 0; // cum-sum				
		int count = 0; // count subarrays 
		
		Map<Integer, Integer> map = new HashMap<>();
				
		for(int i=0; i<n; i++)
		{
			if(A[i] == 0)
				sum += -1;
            else 		
			    sum += 1;
			
			// if sum zero startes from the startes
			// of the array
			if(sum == 0)
				count++;
			
			if(map.containsKey(sum-0))
				count += map.get(sum-0);
			
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		
		return count;
	}
	
	public static void main(String [] args)
	{
		int A[] = {1,0,0,1,0,1,1};
		int n = A.length;
		
		out.println(countSubArray(A,n));
	}
}