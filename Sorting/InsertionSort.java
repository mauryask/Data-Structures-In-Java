 /*
* Time complexity: O(n*n)
* Space complexity: O(1)
*/

import static java.lang.System.*;

public class InsertionSort 
{
		static void insertionSort(int A[])
		{		
			for(int i=1; i<A.length; i++)
			{
				int temp = A[i];
				int j;
		
				for(j=i-1; j>=0 && A[j] > temp; j--)  
					  A[j+1] = A[j];
				  
				A[j+1] = temp;
			}
			
			for(int x : A)
				out.print(x+" ");
		}
	
		public static void main(String [] args)
		{
			int A[] = {5,1,2,7,8,96,32,45,10};
			insertionSort(A);
		}
	
}