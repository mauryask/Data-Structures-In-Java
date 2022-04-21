/*
* T(n) : O(n)
* S(n) : O(1)
** Subtract one to a number 
** given as a linkelist
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


public class SubtractOneFromALinkedList
{
	// val;ue to be subtracted
	static int sub = 1;
	
	static void subOne(Node head)
	{
	   if(head == null)	
		   return;
	   
	   Node nextHead = head.next;	   
	   subOne(nextHead);
	   
	   if(head.data == 0 && sub == 1)
		   head.data = 9;		   
	   else
	   {
		   head.data = head.data - sub;
		   sub = 0;
	   }
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
		Node head =  new Node(1);
		Node a =  new Node(0);
		Node b =  new Node(0);
		Node c =  new Node(4);
		Node d =  new Node(1);
		Node e =  new Node(0);
		
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		printList(head);
		
		subOne(head);	

         // if head of the list is zero 
		 // since it is meaning less remove it
         if(head != null && head.data == 0)
		 {
			 Node temp = head;
			 head = head.next;
			 temp.next = null;
		 }			 
		
		printList(head);
	}
}