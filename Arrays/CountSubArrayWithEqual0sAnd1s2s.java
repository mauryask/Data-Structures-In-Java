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
		* of subarrays with equal 0s 1s and 2s
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
		   
		   int diff01 = count0 - count1;
		   int diff12 = count1 - count2;
		   
		   String key = diff01+"#"+diff12;
		   
		   /*
		   * Check if key already present 
		   * increase count and increase the 
		   * frequency of the key
		   */
		   if(map.containsKey(key))
		   {
			   count += 1;
			   map.replace(key, map.get(key) + 1);
		   }
		   /*
		   * If key encountered for the first time
		   * put it in  the map with frequency one
		   */
		   else
			   map.put(key, 1);
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