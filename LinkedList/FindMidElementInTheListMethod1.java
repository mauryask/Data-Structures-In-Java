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

public class Test 
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
	 	
		static void findMidNode(Node head)
		{
			// list is empty
			if(head == null)
			{
				out.println("list is empty");
				return;
			}
			// list has only one nodes
			if(head.next == null)
			{
				out.println(head.data);
				return;
			}
			
						
			Node ptr = head;
			int n = 1; // total nodes in the list
			
			while(ptr.next != null)
			{
				n++;
				ptr = ptr.next;
			}
             
			ptr = head;
			int count = 0;
            while(ptr != null && count != n/2)
			{
				ptr = ptr.next;
				count++;
			}				
		    out.println(ptr.data);
		}
		
	public static void main(String [] args) 
	{
		Node head1 =  null;
		head1 = insertNode(head1, 5);
		Node f1 = insertNode(head1, 10);
		Node f2 = insertNode(head1, 12);
		Node f3 = insertNode(head1, 14);
		Node f4 = insertNode(head1, 28);
		Node f5 = insertNode(head1, 32);
		Node f6 = insertNode(head1, 55);
		displayList(head1);
		findMidNode(head1);
	}
}