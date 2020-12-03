// Queation Number : #2

import static java.lang.System.*;
import java.util.*;

public class LongestSubArrayWithEqualNumberOf0s1s 
{
	public static void main(String [] args)
	{
		int A[] = {0,1,0,1,1,1,0,1,0,0,1,1,1,0,1,1,0,1,0};
		solve(A);
	}
	
	static void solve(int A[])
	{
		int n = A.length;
		int count_0 = 0, count_1 = 0;
		int maxLength  = -1, diff = 0;
		int start = 0, end = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
	    map.put(0,-1);
		
		for(int i=0; i<n;i++)
		{
			if(A[i] == 0)
				count_0++;
			else
				count_1++;
		    diff = count_1 - count_0;
			if(map.containsKey(diff))
			{
				if(maxLength < i-map.get(diff))
				{
					maxLength = i-map.get(diff);
					start = map.get(diff)+1;
					end   = i;
				}
			}
			else
			  map.put(diff, i);
		}
		out.println("Maximum Length: "+maxLength+"\nStart Index: "
		+start+"\nEnd Index: "+end);
		out.print("The sub array: ");
		for(int i=start; i<=end;i++)
			out.print(A[i]+" ");
	}
}