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
	Map<Character,Character> map;
	
	CheckBracketBalencing()
	{
		map = new HashMap<>();
		map.put('(',')');
		map.put('[',']');
		map.put('{','}');		
	}
			
	public boolean isBalenced(String str, int n)
	{
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<n; i++)
		{
			char c = str.charAt(i);
			
			// If opening bracket encountered
			if(map.containsKey(c))
				stack.push(c);
			/*
			* if a closing bracket encountered
			* check if the stack is not empty and
			* and check top if there is opening bracket
			* corresponing to the closing one
			* pop it from stack
			*/
			else if(map.containsValue(c))
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
				if(map.get(top) == c)
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
		return stack.isEmpty();
	}
	
	/*
	* Constant space complexity solution 
	* T(n) : O(n*n)
	* S(n) : O(1)
	*/
	
	 boolean isBalenced2(String str, int n)
	 {
		 /*
		 * This variable maintains the current top
		 * It replaces the stack
		 ** top =-1  means stack is empty initially
		 */
		 int top = -1;
          		 
		 for(int i=0; i<n; i++)
		 {
			 char ch = str.charAt(i);
			 // if opening bracket encountered
			 // push it in the stack (update top)
			 if(map.containsKey(ch))
			   top = i;
		     // if closing bracket encountered 			 
		     else if(map.containsValue(ch))
			 {
				 // top -1 means stack is empty
				if(top == -1)
					return false;
                // if top is pointing to opening bracket 
                // and ch is corresponing closing bracket
                // find next top				
				if(map.get(str.charAt(top)) == ch)
                    top = getTop(str, top-1);
                
                else return false; 				
			 }
		 }
         // if top is -1 (stack is empty) then brackets 
		 // are balanced else not
		 return top == -1;
	 }
	
	
	int getTop(String str, int top)
	{
		//  we are prety sure that the  
		// next top will lie between 0 and top-1
		int right = 0;
		
		while(top>=0)
		{
			char ch = str.charAt(top);
			// if closing bracket encountered
			// increase right 
			if(map.containsValue(ch))
				right++;
			// if opening bracket encountered 
			// decrease right
			else if(map.containsKey(ch))
				right--;
            // if right becomes -1
			// that means we have more number of opeing 
			// brackets than the closing  brackets
			// in this case top will point to next top 
			if(right < 0)
				return top;
			// decrease top
			top--;
		}
        		
		return -1;
	}
	
	public static void main(String [] args)
	{
		String exp = "[a+(b+c)*{c+(d+e)+(b+e)}]";
		int n = exp.length();
		CheckBracketBalencing check = new CheckBracketBalencing();
		out.println(check.isBalenced2(exp, n));
	}
}