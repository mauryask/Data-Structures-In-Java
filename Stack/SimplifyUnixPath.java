/*
* T(n) : O(n) : n is length of the string
* S(n) : O(n)
* all the cases are passed at leet code
*/
import static java.lang.System.*;
import java.util.*;

public class SimplifyUnixPath 
{
	static String simplePath(String path)
	{
		String[] tokens = path.split("/+"); 
		Stack<String> stack = new Stack<>();
	    		
		for(String token : tokens)
		{
			if(!stack.isEmpty() && token.equals(".."))
				stack.pop();
			/*
			* Here checking for "" because 
			* "/a/b" : on splitting by '/+'
			* first we will get empty string i.e. ("") 
			* and then a, b and so on 
			*/
			else if(!Arrays.asList(".", "", "..").contains(token))
				stack.push(token);
		}
		
		out.println(stack);
		
		StringBuilder sb = new StringBuilder();
		for(String str : stack)
			sb.append("/"+str);
		
		/*
		* check if stack is empty for the case: /////
		*/
		return stack.isEmpty() ? "/" : sb.toString();
	}
	
	public static void main(String [] args)
	{
		 String path = /*"/../";
		 */
		  "/a/./b/./c/./d/";/*
		 * "/../../../../../a";
		 * "////"; 
		 */
		 
		 /*String str[]  = path.split("/+");
		 for(String s : str)
			 out.println(s);*/
	     out.println(simplePath(path));
	}
}