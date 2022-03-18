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
		Queue<Integer> q = new PriorityQueue<>((a,b)->(b-a));
		
		for(int i=0; i<n; i++)
		{
		   q.add(A[i]);
           		
			/*
			* Once the heap size becomes k+1
			* remove top 
			**/	
		   if(q.size() > k)
			  q.remove();		   
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
