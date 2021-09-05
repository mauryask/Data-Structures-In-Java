// Question NUmber :  #4
 
import static java.lang.System.*;

public class FindNonRepeatedNumberInSortedArray
{
	public static void main(String [] args)
	{   int A[] = {1,1,2,2,3,3,4,4,5,6,6};
		//out.println(solve(A));
		out.println(method3(A));
	}
	
	// Time comlexity  : O(n)
	// Space Complexity : O(1)
	
	static int solve(int A[])
	{
		//one thing is clear that length 
		// is always will be odd
		// since all the elements are repeated
		// twice except one element

        int n = A.length;
		int i=0;
		while(i<n-1)
		{
		   	if(A[i] != A[i+1])
			  return A[i];
		    i+=2;
		}
		return A[i];
	}
	
	// since the xor of similiar elemnt is zero
	// hence all the the same pairs will become zero
	// and at the end we will get the our result
	// Time Complexity : O(n)
	// Space Complexity : O(1)
	
	static int method2(int A[])
	{
		int n = A.length;
		int result = 0;
		for(int i=0;i<n;i++)
			result = result ^ A[i];
		return result;
	}
	
	// Time Complexity  : O(log n)
	// Space Complexity : O(1)
	
	static int method3(int A[])
	{
		int n = A.length;
		int start = 0;
		int end = n-1;
		while(start != end)
		{
			int mid = (start + end)/2;
			
			if(mid %2 == 0)
			{
			  if(A[mid] == A[mid+1])
					start = mid + 2;
			  else
				end = mid;
			}
			else
			{
				if(A[mid] == A[mid-1])
					start = mid  + 1;
				else
					end = mid - 1;
			}
		}
		
		return A[start];
	}
}