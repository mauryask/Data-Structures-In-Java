/*Problem statement
** https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
************
* Here if interviewer asks to implemnt stack manually
* then use the following solution
******************
* We can solve it using Built-in stack as well
* as shown below
*/

/*
* Time complexity: 
* push : O(1)
* pop  : O(1)
* getMin() : O(1)
* Space complexity : O(n) (extra stack)
*/

import static java.lang.System.*;
import java.util.*;

class Node 
{
	Node next;
	int data;
	
	Node(int data)
	{
		this.data = data;
	}
}

public class FidningMinElementInAStack
{
	/* Implemnting stack manually */
	
	// main stack top
 	static Node top1 = null;
	// supporting stack top
	static Node top2 = null;
	
	static void push(int x)
	{   
	    /*
		* Initally both the satcks are empty
		* The first element is going to be the 
		* minimum element as well
		*/
		
		if(top2 == null && top1 == null)
		{
			top2 = new Node(x);
			top1 = new Node(x);
		}
		else // if stacks are not empty
		{
			Node temp1 = new Node(x);
			temp1.next = top1;
			top1 = temp1;
			
			/* 
			* check if data to be pushed
			* is less than the top2.data (supporting stack-top)
			* Push this to the supporting stack
			*/
			if(x <= top2.data)
			{
				Node temp2 = new Node(x);
				temp2.next = top2;
				top2 = temp2;
			}
		}
	}
	
	static int pop()
	{
		if(top1 == null)
			return -1;
	   
		int data = top1.data;		
				
		Node temp = null;
		
		if(top1.data == top2.data)
		{
			temp = top2.next;
			top2.next = null;
			top2 = temp;
		}
		
		temp = top1.next;
		top1.next = null;
		top1 = temp;
		
		return data;
	}
	
	static int getMin()
	{
		if(top2 == null)
			return -1;
		return top2.data;
	}
	
//===============================================================
	
	/* Implementing using built in stack */
	
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
		if(ss.isEmpty())
			return -1;
		return ss.peek();
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