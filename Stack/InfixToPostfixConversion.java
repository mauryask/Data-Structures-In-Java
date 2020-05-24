// infix to post-fix conversion
//https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
// watch "saurabh shukla" infix to post-fix video for algorithm
/*
 * https://www.geeksforgeeks.org/convert-infix-prefix-notation/
 * This link shows how to convert infix to prefix
 * see the algorithm given in the website
 * */
package com.pnstech;
import java.util.*;
public class InfixToPostfixConversion {

	static int precedence(char ch)
	{
		switch(ch)
		{
		case '+':
		case '-':
			return 1;
			
		case '*':
		case '/':
		case '%':
			return 2;
			
		case '^':
			return 3;
		}
		
		return -1; 
	}
	
	static String convertInfixToPostfix(String str)
	{
		Stack<Character> st = new Stack<>();
		String rslt = new String("");
		
		
		for(int i=0; i<str.length(); ++i)
		{
			char c = str.charAt(i);
			
			if(Character.isLetterOrDigit(c))
				rslt = rslt + c;
			
			else if(c == '(')
			   st.push(c);	
			
			
			else if(c == ')')
			{
				while( !st.isEmpty() && st.peek() != '(')
					rslt = rslt + st.pop();
				
				   st.pop();
			}
			
			else
			{
				while(!st.isEmpty() && precedence(c) <= precedence(st.peek()))
				{
					if(st.peek() == '(')
						return "Invalid Expression";
					rslt = rslt + st.pop();
				}
				
				st.push(c);
			}
			
				
		}
		
		while(!st.isEmpty())
		{
			if(st.peek() == '(')
				return "Invalid Expression";
			rslt = rslt + st.pop();	
		}
		
		return rslt;
		
	}
	
	public static void main(String[] args) {
	
		
		/***
		 * Infix to post-fix conversion
		 * */
		
		
		Scanner sc = new Scanner(System.in);
	    String str = sc.next(); //enter infix expression

	    System.out.println(convertInfixToPostfix(str));
	    
	   
	    
	    /***
	     * Infix to prefix conversion
	     * https://www.geeksforgeeks.org/convert-infix-prefix-notation/
	     * see algorithm from the given link
	     */
	    
	/*    StringBuilder strx  = new StringBuilder("(a-b/c)*(a/k-l)"); //infix expression
	    strx.reverse();
	    char ch [] = strx.toString().toCharArray();
	    //reverse this string

	    System.out.println(strx); //Output: )l-k/a(*)c/b-a(
	    
	    for(int i=0; i<ch.length; i++)
	    {
	    	if(ch[i] == ')')
	    		ch[i] = '(';
	    	else if(ch[i] == '(')
	    		ch[i] = ')';
	    }
	    
	    strx = new StringBuilder(convertInfixToPostfix(new String(ch)));
	    System.out.print(strx.reverse());
 		*/
	    sc.close();	
	}

}
