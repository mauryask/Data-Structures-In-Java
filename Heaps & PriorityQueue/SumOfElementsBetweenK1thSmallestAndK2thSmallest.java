/*
* T(n) : O(n) 
* S(n) : O(n)
*************
* finding sum of elemnts between 
* k1-th smallest and k2-th smallest 
* k1th and k2th elemnts are exclusive
*/

import static java.lang.System.*;
import java.util.*;

public class SumOfElementsBetweenK1thSmallestAndK2thSmallest 
{
	 static int getSum(int[] A, int n, int k1, int k2)
	 {
		  int x = Math.max(k1, k2);
		  int y = Math.min(k1, k2);
		  
		  // Max Heap
		  Queue<Integer> q = new PriorityQueue<>((a,b)->{
			  return b-a;
		  });
		  
		  for(int i=0; i<n; i++)
		  {
			 q.add(A[i]);
			 
			 if(q.size() > x)
				  q.remove();
		  }
		  
		  int sum = 0;
		  
		  // remove xth smallest
		  q.remove();
		  
		  // find sum till yth smallest encountered
		  while(q.size() != y)
			  sum += q.remove();
		  return sum;
	 }
	
	public static void main(String [] args)
	{
		int A[] = {10, 2, 50, 12, 48, 13};
		int n = A.length;
		int k1 = 2;
		int k2 = 6;
		out.println(getSum(A, n, k1, k2));
	}
}
