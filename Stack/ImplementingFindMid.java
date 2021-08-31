/*
* Implementing findMid() and deleteMid() in O(1)
*******
* Time complexity:
* push : O(1)
* pop  : O(1)
* findMid : O(1)
* Space complexity: O(n)
*/

import static java.lang.System.*;
import java.util.*;

class Node 
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
		this.data = data;
		next = null;
		prev = null;
	}
}

public class ImplementingFindMid
{
	static Node top =  null, mid = null;
	
	static int count = 0;
	
	static int findMid()
	{
		if(mid == null)
			return -1;
		return mid.data;
	}
		
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
			
			if(count % 2 == 0)
				mid = mid.prev;
		}
	}
	
	static int pop()
	{
		if(top ==  null)
			return -1;
		
		count--;
		
		int data = top.data;
		
		if(top.next == null)
		{
			mid = null;
			top = null;
			return data;
		}

		if(count %2 != 0)
			mid = mid.next;
			
		Node temp = top.next;
		top.next = null;
		temp.prev = null;
		top = temp;
		
		return data;
	}
	
	static void deleteMid()
	{
		if(mid == null)
			return;
		
		count--;
		
		if(mid.next == null)
		{
			mid = null;
			top = null;
			return;
		}
		
		Node temp = mid.next;
		mid.data = temp.data;
		mid.next = temp.next;
		temp.prev = null;
		
		if(temp.next != null)
		{
			mid.next.prev = null;
			temp.next = null;
			mid.next.prev = mid;
		}
		
		if(count %2 == 0)
			mid = mid.prev;
	}
	
    public static void main(String [] args)
	{		
		push(10);
		push(12);
		push(14);
		push(16);
		push(18);

	/*	out.println(pop()+" : "+ findMid());
		out.println("=====");
		out.println(pop()+" : "+ findMid());
		out.println("=====");
		out.println(pop()+" : "+ findMid());
		out.println("=====");
		out.println(pop()+" : "+ findMid());
		out.println("=====");
		out.println(pop()+" : "+ findMid());		
		out.println("=====");
		out.println(pop()+" : "+ findMid()); */

        deleteMid();
        out.println(findMid());		
        deleteMid();
        out.println(findMid());		
        deleteMid();
        out.println(findMid());		
        deleteMid();
        out.println(findMid());		
        deleteMid();
        out.println(findMid());				
	}
}
