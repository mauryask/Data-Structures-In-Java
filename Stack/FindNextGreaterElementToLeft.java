/*
* T(n) : O(n)
* S(n) : O(n)
**************
* Same as the next gretaer to right
* Here next greater to left
*/

import static java.lang.System.*;
import java.util.*;

public class FindNextGreaterElementToLeft
{
	static List<Integer> findNextGreater(int[] A, int n)
	{
	   List<Integer> list = new LinkedList<>();
	   Stack<Integer> stack = new Stack<>();
	   
	   for(int i=0; i<n ;i++)
	   {
            while(!stack.isEmpty() && stack.peek()<=A[i])
				stack.pop();
			if(stack.isEmpty())
				list.add(-1);
			else
				list.add(stack.peek());
		    stack.push(A[i]);
	   }
	   return list;
	}
	
	public static void main(String [] args)
	{
		int A[] = {2,7,3,5,4,6,8};
		int n = A.length;
		
		out.println(findNextGreater(A, n));
	}
}