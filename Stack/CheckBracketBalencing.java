/*
* Time complexity: O(n)
* Space complexity: O(n) 
**************
Another variation of the same problem
** A html file is given check if tags are balenced
*/

import static java.lang.System.*;
import java.util.*;

public class CheckBracketBalencing
{
	static boolean isBalenced(char ch[], int n)
	{
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<n; i++)
		{
			if(ch[i] == '{' || ch[i] == '(' || ch[i] == '[')
				stack.push(ch[i]);
			/*
			* if a closing bracket encountered
			* check if the stacik is not empty and
			* and check top if there is opening bracket
			* corresponing to the closing one
			* pop it from stack
			*/
			else if(ch[i] == '}'
				|| ch[i] == ')' 
				|| ch[i] == ']')
			{
				/*
				* Stck will be empty if there are more 
				* closing brackets
				*/
				if(stack.isEmpty())
					return false;
				
				char top = stack.peek();
				
				/*
				* Check for appropriate counter part
				*/
				if((ch[i] == ')' && top == '(') 
					|| (ch[i] == '}' && top == '{')
					|| (ch[i] == ']' && top == '['))
					stack.pop();
				else
					return false;
			}			
		}
		
		/*
		* If stack is not empty at the end means
		* there are more opening bracketsthan closing
		* return false
		* if stack is empty return true
		*/
		return !stack.isEmpty() ? false : true;
	}
	
	public static void main(String [] args)
	{
		String exp = "[a+(b+c)*{c+(d+e)+(b+e)}]";
		char ch[] = exp.toCharArray();
		int n = ch.length;
		out.println(isBalenced(ch, n));
	}
}