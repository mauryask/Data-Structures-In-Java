import static java.lang.System.*;
import java.util.*;

public class CountAllTheSubArraysWithSumK
{
    // Time Complexity  : O(n)
	// Space Complexity : O(n)
	
	static int subArrayCount2(int A[], int target)
	{
		int n = A.length;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0,1);
		
		int ans = 0;
		int sum = 0;
		
		for(int i=0;i<n; i++)
		{
			sum += A[i]; 
			// if sum is started from the starting
            // of the array			
			if(sum == k)
				count++;
			
			if(map.containsKey(sum-target))
			  ans += map.get(sum-target);
			
		    map.put(sum, map.getOrDefault(sum,0)+1);
		}
		
		return ans;
	}
	
	// Time Complexity  : O(n^2)
	// Space Complexity : O(1)
	
	static int subArrayCount(int A[], int target)
	{
		int current_sum = 0, count = 0;
		int n = A.length;
		
		for(int i=0; i<n;i++)
		{
			current_sum = 0;
			
			for(int j=i; j<n; j++)
			{
				current_sum += A[j];
				
				if(current_sum == target)
					count++;
			}
		}
		
		return count;
	}
	
	public static void main(String [] args)
	{
		int A[] = {1,3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6};
		int target = 5;
		out.println(subArrayCount(A,target));
	}
}