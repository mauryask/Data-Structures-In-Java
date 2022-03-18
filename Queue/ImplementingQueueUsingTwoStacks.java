/*
* T(n) : O(n)
* S(n) : O(n)
*/
import static java.lang.System.*;
import java.util.*;

public class ImplementingQueueUsingTwoStacks 
{
	static Stack<Integer> s1 = new Stack<>();
	static Stack<Integer> s2 = new Stack<>();
	
	static void enQueue(int x)
	{
		s1.push(x);
	}
	
	static int deQueue()
	{
		if(s2.isEmpty())
		{
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}
		
		return !s2.isEmpty() ? s2.pop() : -1;
	}
	
	public static void main(String [] args)
	{
		enQueue(10);
		enQueue(15);
		enQueue(5);
		//enQueue(8);
		//enQueue(23);
		out.println(deQueue());
		out.println(deQueue());
		out.println(deQueue());
	}
}