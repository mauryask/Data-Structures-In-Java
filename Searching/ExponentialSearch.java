// T(n) : O(log i) : i is index of the last pointed element
//S(n) : O(1)
// This is useful in case when array is unbounded (tends to infinite)

import java.util.Arrays;
import static java.lang.System.*;

public class ExponentialSearch 
{
    static int exponentialSearch(int A[], int item)
	{
		int i = 1;
		
		if(A[0] == item)
		  return 0;
	  
	    //Finding the range where the element might be found
		while(i < A.length && A[i] <= item)  // O(log i)
		{
		     if(A[i] == item)
				 return i;
			 
			 i = i * 2;
		}
		
		//O(log i)
	    return Arrays.binarySearch(A,i/2,Math.min(i,A.length-1),item);
	}
		
	public static void main(String [] args)
	{
		int A[] = {0,4,5,6,7,8,10,23,23,45,52,54,78,78,156,645};
		int target = 45;
		out.print(exponentialSearch(A,target));		
	}
}