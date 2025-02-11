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
		  // Max Heap
		  Queue<Integer> q = new PriorityQueue<>((a,b)->{
			  return b-a;
		  });
		  
		  for(int i=0; i<n; i++)
		  {
			 q.add(A[i]);
			 
			 if(q.size() == k2)
				  q.remove();
		  }
		  
		  int sum = 0;

		  while(q.size() > k1){
			sum += q.poll();
		  }

		  return sum;
	 }
	
	public static void main(String [] args)
	{
		int A[] =  {20, 8, 22, 4, 12, 10, 14};//{10, 2, 50, 12, 48, 13};
		int n = A.length;
		int k1 = 3;
		int k2 = 6;
		out.println(getSum(A, n, k1, k2));
	}
}
