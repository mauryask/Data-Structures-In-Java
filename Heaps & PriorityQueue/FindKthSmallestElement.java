/*
* T(n) : O(n*logk) 
* S(n) : O(k)
*/
import static java.lang.System.*;
import java.util.*;

public class FindKthSmallestElement
{
	static int findKthSmallestElement(int A[], int n, int k)
	{
		/*
		* Max Heap
		*/
		Queue<Integer> q = new PriorityQueue<>((a,b)->{
			return b-a;
		});
		
		int i = 0, j=0;
		
		while(j<n)
		{
		   q.add(A[j]);
           		
			/*
			* Once the heap size becomes k+1
			* remove top and put it at ith position
			* once this size obtained we will maintain 
			* using sliding window technique
			**/	
		   if(j-i == k)
		   {
			  q.remove();
			  i++;
		   }	
		   
		  j++;		   
		}
		
		return q.remove();
	}
	
	public static void main(String[] args)
	{
		int A[]  = {6, 5, 3, 2, 8, 10, 9};
		int n = A.length;
		int k = 4;
		out.println(findKthSmallestElement(A, n, k));
	}
}
