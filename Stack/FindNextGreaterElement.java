/*
* Time complexity: O(n)
* Space complexity: O(n)
**/

import static java.lang.System.*;
import java.util.*;

public class FindNextGreaterElement
{
	static List<Integer> finNextGreater(int A[], int n)
	{
	   List<Integer> list = new LinkedList<>();	   
	   Stack<Integer> stack = new Stack<>();
	   
	   for(int i=n-1; i>=0; i--)
	   {
		   /* If stack is empty */
		   if(stack.isEmpty())
			   list.add(0,-1);
		   else /*If stack is not empty*/
		   {
			   /*If top of stack greater than Ai*/
			   if(stack.peek() > A[i])
				   list.add(0, stack.peek());
			   /*If top of stack is less or equal to Ai*/
			   else 
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
				   {
					   list.add(0, stack.pop());
				   }
			   }
		   }
		   
		   /*For each element push it to stack*/
		   stack.push(A[i]);
	   }
	   
	   /*Return the list containing the final solution*/
	   return list;
	}
	
	public static void main(String [] args)
	{
		int A[] = {2,7,3,5,4,6,8};
		int n = A.length;
		
		out.println(finNextGreater(A, n));
	}
}