/*
* T(n) : O(n) 
* S(n) : O(n)
*/

import static java.lang.System.*;
import java.util.*;

public class CountSubarraysWithSumDivisibleByK
{
	/*
	* T(n) : O(n*n)
	* S(n) : O(1)
	*/
	static void bruteForce(int A[], int n, int k)
	{
		int count = 0;
		int sum = 0;
		
		for(int i=0; i<n; i++)
		{
			for(int j=i; j<n; j++)
			{
				sum += A[j];
				if(((sum%k)+k)%k == 0)
					count++;
			}
			
			if(sum %k == 0)
				count++;
		}
		
		out.println("\n"+count);
	}
	
	
	static void countSubArrays(int A[], int n, int k)
	{
		/*
		* The map stored remainder and its frequency
 		*/
		
		Map<Integer, Integer> map =  new HashMap<>();
		
		/*
		* initialy sum  = 0 and remainder is 0
		* store 0 and frequency as 1 in the map
		*/
		int sum = 0;
		map.put(0, 1);
		// subarray count
		int count = 0;
		
		for(int i=0; i<n; i++)
		{
			sum += A[i];
			int rem = ((sum%k)+k)%k;
			
			/*
			* Check if this remainder 
			* already present update count
			*/
			if(map.containsKey(rem))
				count += map.get(rem);
			/*
			* Update frequerncy of remainder in the map
			*/
			map.put(rem, map.getOrDefault(rem, 0)+1);
		}
		
		out.println(count);
	}
	
	public static void main(String [] args)
	{   int A[] = {4, 5, 0, -12, -23, 1};
		int k = 5;
	    //countSubArrays(A, A.length, k);
	    bruteForce(A, A.length, k);
	}
}