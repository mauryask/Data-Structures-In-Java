/*
* Time complexity  : O(log n)
* Space compelxity : O(1)
*/

import static java.lang.System.*;

public class FindPeakElement
{
	static int getPeakElement(int A[])
	{		 
		 if(n == 1)
            return 0;
        
        int start = 0;
        int end = A.length-1;
        
        while(start <= end)
        {			
            int mid = start + (end-start)/2;

            if(mid > 0 && mid < n-1) 
            {
                if(A[mid] > A[mid+1] && A[mid] > A[mid-1])
                    return mid;
                else if(A[mid] < A[mid+1])
                    start = mid + 1;
                else if(A[mid-1] > A[mid])
                    end = mid - 1;
            }
            else
            {
                if((mid == 0 && A[mid] > A[mid+1]) ||
				(mid == A.length-1 && A[mid] > A[mid-1]))
                  return mid;
            }
        }
		
         return -1;
	}
	
	public static void main(String [] args)
	{
		int A[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		int n = A.length;
		
		out.println(getPeakElement(A, n));
	}
}