// Queation Number : #8

// Time Complexity : O(n)

import java.util.*;
import static java.lang.System.*;

public class FindNextGreaterElementInArray
{
	static void findNextGreaterElement(int A[])
	{
		int n = A.length;
		int B[] = new int[n]; //arrray to store the result
		Arrays.fill(B,-1);
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for(int i=1;i<n;i++)
		{
			// if current elemnt is less than 
			// or equal to the stack.peek() 
			// then push its index into the stack
			// elese pop() tye index and put the corresponding 
			// current elemnt in array B at poped index 
			
			if(A[i] <= A[stack.peek()])
				stack.push(i);
			else
			{
				while(true)
				{
					if(!stack.isEmpty() && A[i] > A[stack.peek()])
						B[stack.pop()] = A[i];
					else
					{
						stack.push(i);
						break;
					}
				}
			}
		}
		
		for(int i = 0; i<n;i++)
			out.println(A[i]+" --> "+B[i]);
	}
	
	public static void main(String [] args)
	{
		int A[] = {4,5,2,25,6,21};
		findNextGreaterElement(A);
	}
}