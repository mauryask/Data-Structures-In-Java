/* Very Important
*******************
* Time complexity  : O(n)
* Space compelxity : O(1)
*******************
* The Peak element is the element
* which is greater than its neighbouring elements
* i.e. if (Ai-1 < Ai > Ai+1) then Ai is peak element
*  See the notebook for detailed description
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
            
			// if mid is not first and last element
            if(mid > 0 && mid < n-1)
            {
                if(A[mid] > A[mid+1] && A[mid] > A[mid-1])
                    return mid;
                else if(A[mid+1] > A[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            else // if mid is first or last element
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
		int A[] = {30,4,52,0,1,7,9,5,4,5,23};
		int n = A.length;
		
		out.println(findPeak(A, n));
	}
}