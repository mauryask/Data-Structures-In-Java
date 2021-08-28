/*
* Time complexity: O(n)
* Space complexity: O(n)
**************************
* Also known as next greater to right (NGR)
**/

import static java.lang.System.*;
import java.util.*;

public class FindNextGreaterElementToRight
{
	static List<Integer> finNextGreater(int A[], int n)
	{
		/*List stores the final result*/
	   List<Integer> list = new LinkedList<>();	   
	   Stack<Integer> stack = new Stack<>();
	   
	   for(int i=n-1; i>=0; i--)
	   {
			/*
			* pop the stack until it is 
			* empty or top becomes greater than Ai
			*/
			while(!stack.isEmpty() && stack.peek() <= A[i])
				stack.pop();

			/*
			* There might be two reasons for loop termination
			* Either stack is empty
			* or top is greater than Ai
			*/
			if(stack.isEmpty())
				list.add(0, -1);
			/*If top is grater than Ai*/
			else
				list.add(0, stack.pop());
				   
		   /*For each element push it to stack*/
		   stack.push(A[i]);
	   }
	   
	   /*Return the list containing the final solution*/
	   return list;
	}
	
	/* T(n) = O(n*n) and S(n) = O(1)*/	
	static List<Integer> bruteForce(int A[], int n)
	{
		List<Integer> list = new LinkedList<>();
		
		for(int i=0; i<n; i++)
		{
			boolean flag = false;
			
			for(int j =i+1; j<n; j++)
			{
				if(A[j] > A[i])
				{
					list.add(A[j]);
					flag = true;
					break;
				}
			}
			
			if(!flag)
				list.add(-1);
		}
		
		return list;
	}
	
	public static void main(String [] args)
	{
		int A[] = {2,7,3,5,4,6,8};
		int n = A.length;
		
		//out.println(finNextGreater(A, n));
		out.println(bruteForce(A, n));
	}
}