/*
* Similiarly Next smaller from left
**/

import static java.lang.System.*;
import java.util.*;

public class FindNextSmallerToRight
{
	static List<Integer> findNearestSmaller(int[] A, int n)
	{
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new LinkedList<>();
		
		for(int i=n-1; i>=0; i--)
		{
			while(!stack.isEmpty() && stack.peek()>= A[i])
			   stack.pop();
			if(stack.isEmpty())
			   list.add(0,-1);
			else
			   list.add(0, stack.peek());
			stack.push(A[i]);
		}
		
		return list;
	}
	
	public static void main(String [] args)
	{
		int A[] = {2,7,3,5,4,6,8};
		int n = A.length;
		
		out.println(findNearestSmaller(A, n));
	}
}