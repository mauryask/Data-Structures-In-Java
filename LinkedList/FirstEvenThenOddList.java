/**
Time complexity: O(n)
Space complexity : O(1) => Think about it
as we are not using any extra space 
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
	   next =  null;
	}
}

public class FirstEvenThenOddList
{
	 static Node tail = null;
	 
	 // even node list stuffs
	 static Node evenHead = null;
	
	 static Node insertNode(Node head,int data)
	 {
		 Node temp = new Node(data);
		 Node ptr = null;
		 
		if(head == null)
		{
			head = temp;
			tail = head;
			return head;
		}
		
        tail.next = temp;
        tail = temp;
		
		return tail;
	 }
	 
	 
	 static void displayList(Node head)
	 {
		 Node ptr = head;
		
		 while(ptr != null)
		 {
			 out.print(ptr.data+" ");
			 ptr = ptr.next;
		 }
		 
		 out.println();
	 }	
					
	static void solve(Node head)
	{
		 Node ptr = head;
		 Node evenPrev = null, oddPrev = null;
		 Node oddHead = null;

		 while(ptr != null)
		 {			 
			if(ptr.data % 2 == 0)
			{
			   while(ptr != null && ptr.data %2==0)
			   {
				   evenPrev = ptr;
				   insertEvenNode(ptr);
				   ptr = ptr.next;
				   evenPrev.next = null;
			   }
			   
			   if(oddPrev  != null) // case when list starts with even nodes
			       oddPrev.next = ptr;
			}
			else
			{
				if(oddHead == null)
					oddHead = ptr;
				oddPrev  = ptr;
			    ptr = ptr.next;
			}

		 }
		
         // updated tail from even list insertion		
		 tail.next = oddHead;
		 
		 displayList(evenHead);
	}	
		
	// insert nodes in the even list	
	static void insertEvenNode(Node head)
	{
		if(evenHead == null)
			evenHead = head;
		else
			tail.next = head;
		tail = head;
	}
					
	public static void main(String [] args) 
	{
		Node head1 =  null;
		head1 = insertNode(head1, 2);
		insertNode(head1, 4);
		insertNode(head1, 3);
		insertNode(head1, 9);
		insertNode(head1, 7);
		insertNode(head1, 8);
		Node x = insertNode(head1, 12);

		//displayList(head1);
		solve(head1);
	}
}