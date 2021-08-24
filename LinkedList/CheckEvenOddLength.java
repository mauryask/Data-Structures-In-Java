/**
Time complexity: O(n)
Space complexity : O(1) 
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

public class CheckEvenOddLength
{
	 static Node tail = null;
	
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
	 
	 
	 static String evenOrOdd(Node head)
	 {
		 if(head ==  null)
			 return "Even";
		 
		 Node p1 = head;
		 Node p2 = head;
		 
		 while(p2!=null && p2.next != null)
		 {
			 p1 = p1.next;
			 p2 = p2.next.next;
		 }
		 
		 if(p2 == null)
			 return "Even";
		 else
			 return "Odd";
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
	 			
	public static void main(String [] args) 
	{
		Node head =  null;
		head = insertNode(head, 5);
		//insertNode(head, 8);
		//insertNode(head, 32);
		//insertNode(head, 7);
		//insertNode(head, 52);
		//insertNode(head, 45);		
		displayList(head);
		out.print(evenOrOdd(head));
	}
}