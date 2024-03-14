/*
* Time complexity : O(n)
* Space complexity: O(n)
*****************
* What is stock span means for a day: 
* Maximum number of consecutive days just 
* before the given day on which the price of 
* stocks are less than or equal to the 
* current day stock price
* Note: current day stock price is inclusive
*****************
* Problem statement
** https://www.geeksforgeeks.org/the-stock-span-problem/
*/

import static java.lang.System.*;
import java.util.*;

public class StockSpanProblem
{
	static List<Integer> stackSpan(int[] A, int n)
	{
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		out.print(1+" ");
		
		for(int i=1; i<A.length; i++)
		{
			while(!stack.isEmpty() && A[stack.peek()] <= A[i])
				stack.pop();			
			out.print(stack.isEmpty() ? 1 : i-stack.peek() + " ");
			stack.push(i);
		}
	}
	
	/*
	* Time complexity  : O(n*n)
	* Space complexity : O(1)
	*/
	
	static List<Integer> bruteForce(int A[], int n)
	{
		List<Integer> list = new LinkedList<>();
		
		for(int i=0; i<n; i++)
		{
			int count = 0;
			// increse count until next greater element
			// not encountered
			for(int j=i; j>=0; j--)
			{
				if(A[j] <= A[i])
					count++;
				// once next greater element encountered
				// stop the loop
				else 				
					break;
			}
			
			// add span of current day
			// in list
			list.add(count);
		}
		
		return list;
	}
	
	public static void main(String [] args)
	{
		int A[] = {100,80,60,70,60,75,85};
		int n = A.length;
		
		//out.println(bruteForce(A, n));
		stackSpan(A);
	}
}