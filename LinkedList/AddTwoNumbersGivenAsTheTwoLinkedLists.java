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
				
	 static void addList(Node l1, Node l2)
	 {
		 if(l1==null)
            displayList(l2);
        if(l2==null)
            displayList(l1);
        
        
        int carry  = 0;
        Node head = l1;
        
        while(true)
        {   
            int sum = l1.data + l2.data + carry;
            carry = sum / 10;
            int temp = sum % 10;
            l1.data = temp;
        
            if(l1.next == null && l2.next != null)
              l1.next = new Node(0);
            else if(l1.next != null && l2.next == null)
              l2.next = new Node(0);
            else if(l1.next == null && l2.next == null)
               break;
            
            l1 = l1.next;
            l2 = l2.next;
         }
        
        if(carry != 0)
           l1.next = new Node(carry);
        
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