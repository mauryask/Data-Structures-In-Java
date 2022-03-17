 /*
* Time complexity: O(n*n)
* Space complexity: O(1)
*/

import static java.lang.System.*;

public class InsertionSort 
{
	static void insertionSort(int A[])
	{
		int i,j,temp;
		
		for(i=1; i<A.length; i++)
		{
			temp = A[i];
			
			for(j=(i-1); j>=0; j--)  
			{
				if(temp<A[j])
			      A[j+1] = A[j];
				else // if A0-Aj already sorted
				  break;					
			}
			
			A[j+1] = temp;
		}
	}
	
		public static void main(String [] args)
		{
			int A[] = {5,1,2,7,8,96,32,45,10};
			
			out.println("Array before sorting");
			for(int a: A)
				out.print(a+" ");
			out.println();
			
			InsertionSort.insertionSort(A);
			
			out.println("The array after sorting");
			for(int a : A)
				out.print(a+" ");
			out.println();
			
		}
	
}