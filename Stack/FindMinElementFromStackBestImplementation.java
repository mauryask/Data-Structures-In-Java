/* Best Implementation
******************
* Time complexity: 
* getMin : O(1)
* pop    : O(1)
* push   : O(1)
* Space complexity : O(1)
*/

import static java.lang.System.*;
import java.util.*;

public class FindMinElementFromStackBestImplementation
{
	static Stack<Integer> s = new Stack<>();
	static int min = -1;
	
	static int pop()
	{
		/*
		* Check for underflow
		* if stack is empty return -1
		*/
		if(s.isEmpty())
			return -1;
		
		/*
		* Else pop the element from the stack
		*/
		int data = s.pop();
		
		/*
		* Compare data with with min
		* If it is less than min then
		* update min = 2 * min - data
		* and return temp
		*/ 
		if(data < min)
		{
			int temp = min;
			min = 2 * min - data;
			return temp;
		}
		/*
		* if min is less than data
		* just return data
		* min will remain unchanged
		*/
		else
			return data;
	}
	
	static void push(int x)
	{
		/*
		* If dtack is empty 
		* push it to the stack at that time
		* update min = x; since there is only 
		* one element and it will be min itself
		*/
		if(s.isEmpty())
		{
			s.push(x);
			min = x;
		}
		else
		{
			/*
			* If element to be inserted (x) is greater
			* than than the min
			* directly insert it
			* min will remain unchanged
			*/
			if(x > min)
				s.push(x);
			/*
			* If the element to be inserted
			* is less than the min then 
			* push 2 * x  - min to stack
			* update min = x
			*/ 
			else 
			{
				s.push(2 * x - min);
				min = x;
			}
		}
	}
	
	static int getMin()
	{
		return min;
	}
	
	public static void main(String [] args)
	{
		int A[] = {3, 2, 6, 1, 8, 5, 5, 5, 5};
		int n = A.length;
		
		for(int x : A)
			push(x);
		
		out.println(pop()+" : "+getMin());
		out.println("==========");
		out.println(pop()+" : "+getMin());
		out.println("==========");
		out.println(pop()+" : "+getMin());
		out.println("==========");
		out.println(pop()+" : "+getMin());
		out.println("==========");
		out.println(pop()+" : "+getMin());
		out.println("==========");		
	}
}