/*
* Simplest Kind of sorting
**
* T(n) = O(n*n) : for all cases 
* S(n) = O(1)
*/

import static java.lang.System.*;

public class SelectionSort 
{
	static void selectionSort(int A[])
	{
		for(int i=0; i<A.length-1; i++)
		{
			int minIndex = getMinIndex(A,i);
			int temp = A[minIndex];
			A[minIndex] = A[i];
			A[i] = temp;
		}
		
		for(int x : A)
		  out.print(x+" ");
	}

	static int getMinIndex(int A[], int i)
	{
	    int minValue = A[i];
  	    int minIndex = i;
		
		for(int j=i+1; j<A.length; j++)
		{
			if(minValue > A[j])
			{
				minValue = A[j];
				minIndex = j;
			}
		}
		return minIndex;		
	}
	
    public static void main(String [] args)
    {
		int A[] = {8,5,4,7,9,2,0,4,6};
		selectionSort(A);
    }
}
