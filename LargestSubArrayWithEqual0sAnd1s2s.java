/*
* T(n) : O(n) 
* S(n) : O(n)
*/

import static java.lang.System.*;
import java.util.*;

public class LargestSubArrayWithEqual0sAnd1s2s 
{
	static int largestSubArray(int A[], int n)
	{
	    int maxLen = 0;
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		
		int start = 0;
		int end = 0;
		
		Map<String, Integer> map = new HashMap<>();
		
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
		   
		   map.putIfAbsent(key, i);
		   
		   if(map.containsKey(key))
		   {
			   start = map.get(key)+1;
			   end = i;
		   }			 
		}
		
		out.println(start+", "+end);
		
		return maxLen;
	}
	
	public static void main(String [] args)
	{
		int A[] = {0,1,2,1,2,1,0,0,0,1,2,2,1};
		int n = A.length;
		
		out.println(largestSubArray(A,n));
	}
}