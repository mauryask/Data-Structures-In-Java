/*
* T(n) : O(n) 
* S(n) : O(n)
*************
* The idea is if we encountered same key again
* it means increament in the number of 0s and 1s and 2s
* are same hence it has same number of 0s 1s and 2s
*/

import static java.lang.System.*;
import java.util.*;

public class CountSubArrayWithEqual0sAnd1s2s
{
	static int countSubArray(int A[], int n)
	{
		Map<String, Integer> map = new HashMap<>();
		
		/*
		* Initially count of 0s 1s and 2s are same
		*/
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		/*
		*  this variable holds total number
		*  of subarrays with equal 0s 1s and 2s
		*/
		int count = 0;
		
		/*
		* Initially diff between 0s count and 1s count  is 0
		* and diff between 1s count and 2s count  is 0
		*/
		map.put("0#0", 1);
		
		for(int i=0; i<n; i++)
		{
		   if(A[i] == 0)
			   count0 += 1;
		   else if(A[i] == 1)
			   count1 += 1;
		   else
			   count2 += 1;
		   
		   String diff  = (count0 - count1) +"#" + (count1-count2);
		   
		   if(map.containsKey(diff))
			   count += map.get(diff);
		   
           map.put(diff, map.getOrDefault(diff, 0)+1);    
		}
		
		return count;
	}
	
	public static void main(String [] args)
	{
		int A[] = {0,1,0,2,0,1,0};
		int n = A.length;
		
		out.println(countSubArray(A,n));
	}
}