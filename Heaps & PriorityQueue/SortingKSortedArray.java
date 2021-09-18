/*
* T(n) : O(n*logk) 
* S(n) : O(k)
*/
import static java.lang.System.*;
import java.util.*;

public class SortingKSortedArray
{
	static void sortArray(int A[], int n, int k)
	{
		/*
		* Min Heap
		*/
		Queue<Integer> q = new PriorityQueue<>();
		int i = 0, j=0;
		
		while(j<n)
		{
		   q.add(A[j]);
           		
			/*
			* Once the heap size becomes k+1
			* remove top and put it at ith position
			* oncwe this size obtained we will maintain 
			* using sliding window technique
			**/	
		   if(j-i == k)
		   {
			   A[i] = q.remove();
			   i++;
		   }	
		   
		  j++;		   
		}
		
		/*
		* At the end all the elements that are 
		* left in the heap will be removed and kept in 
		* the array since top will always be smallest element
		*/
		while(!q.isEmpty() && i<n)
		 A[i++] = q.remove();

	 for(int x : A)
		 out.print(x+" ");
	}
	
	public static void main(String[] args)
	{
		int A[]  = {6, 5, 3, 2, 8, 10, 9};
		int n = A.length;
		int k = 3;
		sortArray(A, n, k);
	}
}
