/*
* Time complexity: 
* push : O(1)
* pop  : O(1)
* getMin() : O(1)
* Space complexity : O(n) (extra stack)
*/

import static java.lang.System.*;
import java.util.*;
public class FidningMinElementInAStack
{ 
	static Stack<Integer> s = new Stack<>();
	static Stack<Integer> ss = new Stack<>();
	
	static void builtInPush(int x)
	{
		s.push(x);
		
		if((!ss.isEmpty() && x <= ss.peek()) || ss.isEmpty())
			ss.push(x);	
	}
	
	static int builtInPop()
	{
		if(s.isEmpty())
			return -1;
		
		int data = s.pop();
		
		if(data == ss.peek())
			ss.pop();
		
		return data;
	}
	
	static int builtInMin()
	{
		if(!s.isEmpty())
			return ss.peek();
		return -1;
	}
	
	public static void main(String [] args)
	{
		int A[] = {3,3,2, 6, 1, 8, 5, 5, 4,7};
		int n = A.length;
		
		for(int i=0; i<n; i++)
		{
			builtInPush(A[i]);
			out.println(A[i] + " : " + builtInMin());
		}
		
	    out.println("========");
	    out.println(builtInPop()+" : "+builtInMin());
		out.println("========");
	    out.println(builtInPop()+" : "+builtInMin());
		out.println("========");
	    out.println(builtInPop()+" : "+builtInMin());
		out.println("========");
	    out.println(builtInPop()+" : "+builtInMin());
		out.println("========");
	    out.println(builtInPop()+" : "+builtInMin());
		out.println("========");
	    out.println(builtInPop()+" : "+builtInMin());		
		out.println("========");
	    out.println(builtInPop()+" : "+builtInMin());	
		out.println("========");
	    out.println(builtInPop()+" : "+builtInMin());
		out.println("========");
	    out.println(builtInPop()+" : "+builtInMin());
	}
}