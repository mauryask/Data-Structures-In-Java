/*
* Implementing findMid() and deleteMid() in O(1)
********************
* Time complexity:
* push : O(1)
* pop  : O(1)
* findMid : O(1)
* Space complexity: O(n)
*/

import static java.lang.System.*;

class Node 
{
	int  data;
	Node prev, next;
	Node(int data)
	{
		this.data = data;
		prev = next = null;
	}
}

public class FindMidDLLImpelementation
{
	static Node top = null, mid = null;
	static int count = -1;
	
	static void push(int x)
	{
		Node temp = new Node(x);
		
		count++;
		
		if(top == null)
		{
			mid = temp;
			top = temp;
		}
		else
		{
		  temp.next = top;
		  top.prev = temp;
		  top = temp;

		  if(count % 2 != 0)
			mid = mid.prev;				
		}
	}
	
	static int pop()
	{
		if(top == null)
			return -1;
		
		count--;
	
		int data = top.data;
		
		if(count == -1)
			top = mid = null;
		else
		{	
		    if(count % 2 == 0)
			  mid = mid.next; 	
		
		   	Node temp = top.next;
			top.next = null;
			temp.prev = null;
			top = temp;
		}		
		
		return data;
	}
	
	static int findMid()
	{
		return top == null ? -1 : mid.data;
	}
	
	static void deleteMid()
	{
		if(top == null)
			return;
		
		count--;
		
		if(count == -1)
		{
			top = mid = null;
			return;
		}
		
		Node temp = mid.next;
		mid.data = temp.data;
		mid.next = temp.next;
		temp.prev = null;
		
		if(temp.next != null)
		{
			temp.next = null;
			mid.next.prev = null;
		}
		else
			temp = null;
		
		if(count % 2 != 0)
			mid = mid.prev;
	}
	
	public static void main(String [] args)
	{
		push(10);
		push(16);
		push(14);
		push(23);
		push(12);
		push(18);
	    
		/*out.println(findMid());
		out.println(pop() + " : " + findMid());
		out.println(pop() + " : " + findMid());
		out.println(pop() + " : " + findMid());
		out.println(pop() + " : " + findMid());
		out.println(pop() + " : " + findMid());
		out.println(pop() + " : " + findMid());*/
		
		/*out.println(findMid());
		deleteMid();
		out.println(findMid());
		deleteMid();
		out.println(findMid());
		deleteMid();
		out.println(findMid());
		deleteMid();
		out.println(findMid());
		deleteMid();
		out.println(findMid());*/
		deleteMid();
		deleteMid();
		deleteMid();
		deleteMid();
		deleteMid();
		out.println(findMid());		
	}
}