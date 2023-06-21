//T(n) : O(log n)
//S(n) : O(1)

import static java.lang.System.*;

public class BinarySearch 
{
		private static int binarySearch(int A[], int target)
		{
			int start = 0;
			int end = A.length - 1;
			
			while(start <= end)
			{
				int mid = start + (end - start) / 2;
				
				if(A[mid] == target)
					return mid;
				else if(A[mid] > target)
					end = mid - 1;
				else if(A[mid] < target)
				    start = mid + 1;
			}
			
			return  -1;
		}
		
		public static void main(String [] args)
		{
			int A[] = {1,2,3,4,5,6,7,8,9}; 
			int target = 6;
		    int index = binarySearch(A, target);
		    out.println("The element is found at index: "+index);
		}
}
