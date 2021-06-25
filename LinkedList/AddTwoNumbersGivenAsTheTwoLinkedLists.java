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

public class AddTwoNumbersGivenAsTheTwoLinkedLists
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
				
	 static void addList(Node head1, Node head2)
	 {
		 // handling base cases
		 if(head1 == null && head2 != null)
		 {
			 displayList(head2);
			 return;
		 }
		 
		 if(head1 != null && head2 == null)
		 {
			 displayList(head1);
			 return;
		 }
		 
		 if(head1 == null && head2 == null)
			 return;
		 
		 int carry = 0, sum = 0, cumSum  = 0;
		 Node head = head1, prev = null;
		 
		 while(head1 != null && head2 != null)
		 {
			 cumSum = head1.data + head2.data + carry;
			 sum = cumSum % 10;
			 carry = cumSum / 10;
			 			 
			 head1.data = sum;
			 			 			 
			 if(head1.next == null && head2.next != null)
			 {
				 head1.next = new Node(0);
			 }
			 
			 if(head1.next != null && head2.next == null)
			 {
				head2.next = new Node(0);
			 }		

             prev  = head1;
             head1 = head1.next;
			 head2 = head2.next;			 
		 }
		 
		 if(carry != 0)
			 prev.next = new Node(carry);
		 displayList(head);
	 }	 
   		
					
	public static void main(String [] args) 
	{
		Node head1 =  null;
		head1 = insertNode(head1, 2);
		insertNode(head1, 4);
		insertNode(head1, 3);
		
		Node head2 =  null;
		head2 = insertNode(head2, 9);
		insertNode(head2, 7);
		insertNode(head2, 8);
       
        addList(head1, head2);
	}
}