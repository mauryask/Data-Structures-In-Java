import static java.lang.System.*;
import java.util.*;

class Node 
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
		next = null;
	}
}

public class StackUsingLinkeList
{
	static Node top = null;
	
	static void push(int data)
	{
		Node temp =  new Node(data);
		temp.next = top;
		top = temp;
	}
	
	static Node pop()
	{
		//Handling underflow condition
		
		if(top == null)
			return new Node(-1);
		
	    Node temp = top, ptr = temp.next;
		top.next = null;
		top = ptr;
		return temp;
	}
	
	public static void main(String [] args)
	{
		push(12);
		push(5);
		push(23);
		push(85);
		push(41);
		push(96);
		
		out.println(pop().data);
		out.println(pop().data);
		out.println(pop().data);
		out.println(pop().data);
		out.println(pop().data);
		out.println(pop().data);
		out.println(pop().data);
		out.println(pop().data);
		out.println(pop().data);
	}
}

