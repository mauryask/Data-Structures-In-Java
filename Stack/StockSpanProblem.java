/*
* Time complexity : O(n)
* Space complexity: O(n)
*****************
* What is stock Span mean for a day: 
* On each day count number stock prices of past consecutive
* days that or less or equal to the current day stock price
* Note: current day stock price is inclusive
*****************
* Problem statement
** https://www.geeksforgeeks.org/the-stock-span-problem/
*/

import static java.lang.System.*;
import java.util.*;

public class StockSpanProblem
{
	static List<Integer> countStack(int[] A, int n)
	{
		List<Integer> list = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<n; i++)
		{
			while(!stack.isEmpty() && A[stack.peek()] <= A[i])
				stack.pop();
			
			/*
			* If stack is empty that means
			* there is no such element to the left of 
			* Ai which is greter than this
			* So we assume it as -1 and
			*********
			* If stack is not empty compare Ai
			* with top of the stackm, if it is geater than 
			* Ai it will be the next greater  to the left of Ai
			**********
			* Th span of the day is obtained by subtracting 
			* the index of curent day with the index of the 
			* next greater element
			*/
			if(stack.isEmpty())
				list.add(i+1);  // i-(-1) = (i+1)
			else
				list.add(i-stack.peek());
			
			stack.push(i);
		}
		
		return list;
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
		
		//out.println(countStack(A, n));
		out.println(bruteForce(A, n));
	}
}