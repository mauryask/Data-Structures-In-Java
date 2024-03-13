import static java.lang.System.*;
import java.util.*;

public class LongestValidParentheses 
{
	/*
	** Method-1
	* T(n) : O(n)
	* S(n) : O(n)
	*/
	
	/* 
	* In this approach the peek reprsents the 
	* boundary from which the valid parentheses starts
	* Our initial asumption was that -1 is index after which the valid 
    * parentheses starts 	
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
				else // we are pretty sure
                     //	that we have valid parenteses
					 //	of some length
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
	*  from left to right and from right to left as well
	* the same analogy used here to solve this problem
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
			// if at any point close > open 
			// we are pretty sure that at this point 
			// we encountered an invalid length of braces
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
	
	//"())" left to right len = 1, right to left len = 0
	//")()" rigth to left len = 1, left to right len = 0
  	public static void main(String [] args)
	{
		String str  = ")()())";
		int n = str.length();		
		out.println(validParen2(str, n));
	}
}