import static java.lang.System.*;
import java.util.*;

public class LongestValidParentheses 
{
	/*
	** Method-1
	* T(n) : O(n)
	* S(n) : O(n)
	*/
	static int validParen(String str, int n)
	{
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int max = 0;
		
		for(int i=0; i<n; i++)
		{
			char ch = str.charAt(i);
			
			if(ch == '(')
				stack.push(i);
			else
			{
				stack.pop();
				if(stack.isEmpty())
					stack.push(i);
				else
				{
					int len = i - stack.peek();
					max = Math.max(max, len);
				}
			}
		}
		
		return  max;
	}
	
  	public static void main(String [] args)
	{
		String str  = ")()())";
		int n = str.length();
		
		out.println(validParen(str, n));
	}
}