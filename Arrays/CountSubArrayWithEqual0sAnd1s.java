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
		int sum = 0; 		
		int count = 0; 
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		
		for(int x : A)
		{
			if(x == 0)
				sum += -1;
            else 		
			    sum += 1;
			
			if(map.containsKey(sum))
				count += map.get(sum);
			
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