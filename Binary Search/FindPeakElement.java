/* Very Important
*******************
* Time complexity  : O(log n)
* Space compelxity : O(1)
*******************
* The Peak element is the element
* which is greater than its neighbouring elements
* i.e. if (Ai-1 < Ai > Ai+1) then 'Ai' is peak element
* See the notebook for detailed description
*******************
* Here we are applying Binary Search algotrithm
* But the given array may or may not be sorted
* It will work for both of the cases
*/

import static java.lang.System.*;

public class FindPeakElement
{
	static int findPeak(int A[],int n)
	{
		 /* if there is only one element */ 
		 if(n == 1)
            return 0;
        
        int start = 0;
        int end = n-1;
        
        while(start <= end)
        {			
            int mid = start + (end-start)/2;
            
			// if mid is neither first nor last element
            if(mid > 0 && mid < n-1) 
            {
                if(A[mid] > A[mid+1] && A[mid] > A[mid-1])
                    return mid;
				// some part is commented to handle
				// if Amid is less than mid+1 and mid-1
                else if(/*A[mid-1] < A[mid] &&*/ A[mid] < A[mid+1])
                    start = mid + 1;
                else if(A[mid-1] > A[mid])// && A[mid] > A[mid+1])
                    end = mid - 1;
            }
            else // if mid is either first or last element
            {
                if(mid == 0)
                {
                    if(A[mid] > A[mid+1])
                        return mid;
                    else
                        start = mid + 1;
                }
                else if(mid == n-1)
                {
                    if(A[mid] > A[mid-1])
                        return mid;
                    else
                        end = mid - 1;
                }
            }
        }
         return -1;
	}
	
	public static void main(String [] args)
	{
		int A[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		int n = A.length;
		
		out.println(findPeak(A, n));
	}
}