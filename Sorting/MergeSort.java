/* 
* Time Complexity : O(n*log n)
* Space Complexity : O(n) 
***************************
** T(n) = 2 * T(n/2) + O(n)
** Apply merge sort to get time complexity
***************************
* The algorithm uses divide and conqure strategy
*/

import static java.lang.System.*;

public class MergeSort
{
	public static void main(String [] args)
	{
		int A[] = {10,5,7,3,1,14,9};
		int p = 0;
		int r = A.length-1;
		mergeSort(A, p, r);
		
		for(int x : A)
			out.print(x+" ");
	}
	
	static void merge(int A[], int p, int q, int r)
	{
		int n1 = q-p+1;
		int n2 = r-q;
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		int i = 0, j = 0, k = p;
		
        // Copying
		while(i<n1)
			L[i++] = A[k++];
		
		while(j<n2)
			R[j++] = A[k++];
		
		k = p; i = 0; j = 0;
	
	   // Merging
		while(i<n1 && j<n2) 
		{
		  if(L[i] < R[j])
			A[k++] = L[i++];
		  else
			  A[k++] = R[j++];
		}
		
		while(i<n1)
			A[k++] = L[i++];
		while(j<n2)
			A[k++] = R[j++];
	}
	
	static void mergeSort(int A[], int p, int r) // T(n)
	{
		if(p < r)
		{
		   int q = p  + (r-p)/2;
		   mergeSort(A,p,q); // T(n/2)
		   mergeSort(A,q+1,r); // T(n/2)
		   merge(A,p,q,r); // O(n)
		}
	}
}