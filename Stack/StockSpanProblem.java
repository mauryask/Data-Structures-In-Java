/*
* Time complexity : O(n)
* Space complexity: O(n)
*****************
* On each day count number stocks of past consecutive
* days that or less or equal to the current day stock price
********
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
			if(stack.isEmpty())
				list.add(1);
			else
			{
				if(A[stack.peek()] > A[i])
					list.add(i-stack.peek());
				else
				{
					while(!stack.isEmpty() && A[stack.peek()] < A[i])
						stack.pop();
					if(stack.isEmpty())
						list.add(1);
					else
						list.add(i-stack.peek());
				}
			}
			
			stack.push(i);
		}
		
		return list;
	}
	
	public static void main(String [] args)
	{
		int A[] = {100,80,60,70,60,75,85};
		int n = A.length;
		
		out.println(countStack(A, n));
	}
}