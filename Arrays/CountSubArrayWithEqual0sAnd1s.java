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
		
		/*
		* If no such subarray exist 
		* return count = 0
		*/
		
		int count = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		map.put(0, 1);
		
		for(int i=0; i<n; i++)
		{
			/*
			* if A[i] is 0 treat it as -1
			* and look for the subarrayu with sum = 0
			* since sum  = 0 is possibble if and only if 
			* there are eqaul 1s and -1s (aka 0s)
			*/
			
			/*
			* Storing Ai in temp if it is 0 then 
			* replace it with -1
			*/
			
			int temp = A[i];
		
			if(temp == 0)
				temp = -1;
	
			sum += temp;
			
			
					
			/*
			* Check if there exist (sum-k) (here k = 0)
			* update count variable			
 			*/
			
			if(map.containsKey(sum))
			{
			   count += map.get(sum);
			   map.replace(sum, map.get(sum) + 1);
			}
            else if(!map.containsKey(sum))
			{
			    map.put(sum, 1);	
			}	   
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