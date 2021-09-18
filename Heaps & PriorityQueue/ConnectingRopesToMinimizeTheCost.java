/*
* T(n) : O(n*logn)
* S(n) : O(n)
*/

import static java.lang.System.*;
import java.util.*;

public class ConnectingRopesToMinimizeTheCost 
{
	static int minCost(int[] A,int n)
	{
	   if(n == 1)
			return A[0];
		
	   Queue<Integer> q = new PriorityQueue<>();
       
	   for(int x : A)
		 q.add(x);
      
	   int minCost = 0;
	   
       while(q.size() != 1)
	   {
		   int ropeLength = q.remove() + q.remove();
		   minCost += ropeLength; 	
		   q.add(ropeLength);		   
	   }

       return minCost;	   
	}
	
	public static void main(String [] args)
	{
		int A[] =  {2, 3, 4, 6};
		int n = A.length;
		
		out.println(minCost(A, n));
	}
}