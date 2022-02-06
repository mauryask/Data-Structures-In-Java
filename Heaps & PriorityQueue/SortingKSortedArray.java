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
		int i = 0;
		
		for(int j=0; j<n; j++)
		{
		   q.add(A[j]);
           		
			/*
			* Once the heap size becomes k
			* remove top
			**/	
		   if(q.size() > k)		   
			   A[i++] = q.remove();			   
		}
		
		/*
		* At the end all the elements that are 
		* left in the heap will be removed and kept in 
		* the array since top will always be smallest element
		*/
		while(!q.isEmpty())
		 A[i++] = q.remove();

	 for(int x : A)
		 out.print(x+" ");
	}
	
	public static void main(String[] args)
	{
		int A[]  = {6, 5, 3, 2,8, 10, 9};
		int n = A.length;
		int k = 3;
		sortArray(A, n, k);
	}
}
