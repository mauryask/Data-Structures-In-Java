/*
* T(n) : O(n)
* S(n) : O(1)
** Add one to a number 
** given as a linkelist
** here i used recursion to solve this
*/
import static java.lang.System.*;
import java.util.*;

class Node 
{
    int data;
    Node next;

	Node(int data)
	{
		this.data = data;
	}  
}


public class AddOneToALinkedList
{
	// Intial value to be added
	static int carry = 1;
	
	static void addOne(Node head)
	{
	   	if(head ==  null)
			return;
		
		Node nextHead =  head.next;
		
		addOne(nextHead);
		
		int sum = head.data + carry;		
		head.data = sum % 10;
		carry = sum / 10;
	}
	
	
	static void printList(Node head)
	{
		while(head != null)
		{
			out.print(head.data+" ");
			head = head.next;
		}
	 
	    out.println();
	}
	
	public static void main(String [] args)
	{
		Node head =  new Node(9);
		Node a =  new Node(9);
		Node b =  new Node(9);
		Node c =  new Node(9);
		Node d =  new Node(9);
		Node e =  new Node(9);
		
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		printList(head);
		
		addOne(head);
		
		// at the end check if the 
		// the adder is one (the carry from 
		// first element)
		if(carry > 0)
		{
			Node temp  = new Node(1);
			temp.next = head;
			head = temp;
		}
		
		printList(head);
	}
}