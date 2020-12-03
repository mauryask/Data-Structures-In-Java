// Queation Number : #2 
 
import static java.lang.System.*;
import java.util.*;

public class LongestSubArrayWithEqualNumberOf0s1sAnd2s 
{
	public static void main(String [] args)
	{
		int A[] = {0,1,2,1,0,1,2,0,1,0,0,2,1,0,1,2,2,1,1,0,1,0,1};
		solve(A);
	}
	
	static void solve(int A[])
	{
		int n = A.length;
		int count_0 = 0, count_1 = 0, count_2 = 0;
		int maxLength  = -1, diff_10 = 0, diff_21 = 0;
		int start = 0, end = 0;
		
		Map<String, Integer> map = new HashMap<>();
	    map.put(0+"#"+0,-1);
		
		for(int i=0; i<n;i++)
		{
			if(A[i] == 0)
				count_0++;
			else if(A[i] == 1)
				count_1++;
			else
				count_2++;
		    diff_10 = count_1 - count_0;
		    diff_21 = count_2 - count_1;
			String key = diff_10+"#"+diff_21;
			if(map.containsKey(key))
			{
				if(maxLength < i-map.get(key))
				{
					maxLength = i-map.get(key);
					start = map.get(key)+1;
					end   = i;
				}
			}
			else
			  map.put(key, i);
		}
		out.println("Maximum Length: "+maxLength+"\nStart Index: "
		+start+"\nEnd Index: "+end);
		out.print("The sub array: ");
		for(int i=start; i<=end;i++)
			out.print(A[i]+" ");
	}
}