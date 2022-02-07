/*
** Quick Sort
***************
* Time complexity: 
****
* Best case: O(n * log n)
* Worst case: O(n*n)
**************
* Space complexity:
****
** These are the space taken by recursion stack
* Best case: O(log n)
* Worst case: O(n)
*****************
in genral it is S(n) : O(1)
*/

import static java.lang.System.*;
import java.util.*;

public class QuickSort
{
	static void quickSort(int A[], int p, int r)
	{
		if(p < r)
		{
			int q = partition(A, p, r);
			quickSort(A, p, q-1);
			quickSort(A, q+1, r);			
		}		
	}
   
    // O(n) always
     static int partition(int A[], int p, int r)
	 {
		 int i = p-1;
		 int temp = A[r];
				 
		 for(int j = p; j<r; j++)
		 {
			 if(A[j] <= temp)
			 {
				 i++;
				 int val = A[j];
				 A[j] = A[i];
				 A[i] = val;
			 }
		 }0
		
		 A[r] = A[i+1];
		 A[i+1] = temp;
		 
		 return i+1;
	 }
   
	public static void main (String[] args)
	{
		int A[] = {12,45,10,5,2,3,7,58};
		int n = A.length;
		quickSort(A, 0, n-1);
		for(int x : A)
			out.print(x+" ");
	}
}

