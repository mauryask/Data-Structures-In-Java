/*
* T(n) : O(n*logn)
* S(n) : O(n)
*** (Merge sort variation)
*/
import static java.lang.System.*;
import java.util.*;

public class SortArrayBasedOnAbsoluteDifferenceWithGivenKey 
{
	static void sort(int[] A, int key,  int n)
	{
		mergeSort(A, key,0,n-1);
	}
	
	static void mergeSort(int[] A, int key, int p, int r)
	{
		if(p<r)
		{
			int q = p+(r-p)/2;
			mergeSort(A, key,p,q);
			mergeSort(A, key, q+1,r);
			merge(A,key,p,q,r);
		}
	}
	
	static void merge(int[] A, int key, int p,  int q, int r)
	{
		int n1 = q-p+1;
		int n2 = r-q;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		int i=0,j=0,k=p;
		
		while(i<n1)
			L[i++] = A[k++];
		while(j<n2)
			R[j++] = A[k++];
		
		i=0;
		j=0;
		k=p;
		
		while(i<n1 && j<n2)
		{
			int lDiff = Math.abs(L[i]-key);
			int rDiff = Math.abs(R[j]-key);
			
			if(lDiff < rDiff)
			  A[k++] = L[i++];
		    else 
			  A[k++] = R[j++];
		}
		
		while(i<n1)
			A[k++] = L[i++];
		while(j<n2)
			A[k++] = R[j++];
	}
	
	public static void main(String [] args)
	{
		int A[] = {2, 6, 8, 3};
		int key = 5;
		sort(A, key, A.length);
		for(int x: A)
			out.print(x+" ");
	}
}