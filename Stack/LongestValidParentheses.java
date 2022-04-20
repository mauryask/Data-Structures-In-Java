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
	
	/*
	** Method-2
	* T(n) : O(n) 
	* S(n) : O(1)
	*******
	* Anlogy : lets take : "()()" this string 
	* here we can see in order to be valida parentheses
	* number of opening brfaces should be same as 
	* number of closing brackets
	*/	
	
	static int validParen2(String str, int n)
	{
		int close = 0;
		int open = 0;
		int max = 0;
		
		// tarverse the string left to right
		for(int i=0; i<n; i++)
		{
		    char ch  = str.charAt(i);
		    
			if(ch == '(')
				open++;
			else if(ch == ')')
				close++;
			
			if(close == open)
			{
				int len = close + open;
				max = Math.max(len, max);
			}
			else if(close > open)
				close = open = 0;
		}
		
		// traverse the string right to left
		close  = open = 0;		
		
		for(int i=n-1; i>=0; i--)
		{
		    char ch  = str.charAt(i);
		    
			if(ch == '(')
				open++;
			else if(ch == ')')
				close++;
			
			if(close == open)
			{
				int len = close + open;
				max = Math.max(len, max);
			}
			else if(open > close)
				close = open = 0;
		}
		
		return max;
	}
	
  	public static void main(String [] args)
	{
		String str  = ")()())";
		int n = str.length();		
		out.println(validParen2(str, n));
	}
}