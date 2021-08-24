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

public class FindMiddleElementInLinkedList 
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
	 
	 
	 static void findMidNode(Node head)
	 {
		 // if list is empty
		 if(head == null)
		 {
			 out.println("list is empty");
			 return;
		 }
		 
		 Node p1 = head, p2 = head;
		 
		 while(p2 != null && p2.next != null)
		 {
			 p1 = p1.next;
			 p2 = p2.next.next;
		 }

		 out.println(p1.data);
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
		Node head1 =  null;
		head1 = insertNode(head1, 5);
		insertNode(head1, 12);
		insertNode(head1, 35);
		insertNode(head1, 44);
		insertNode(head1, 7);
		insertNode(head1, 24);
		displayList(head1);
		findMidNode(head1);
	}
}