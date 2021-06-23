/**
Time complexity: O(m+n)
Space complexity : O(m+n) 
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

public class MergeSortedListsRecursively
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
	 	
    static Node mergeLists(Node a, Node b)
	{
		Node rslt = null;
		
		if(a == null)
			return b;
		if(b == null)
			return a;
		
		if(a.data < b.data)
		{
			rslt = a;
			rslt.next = mergeLists(a.next, b);
		}
		else
		{
			rslt = b;
			rslt.next = mergeLists(a, b.next);
		}
		
		return rslt;
	}
		
	public static void main(String [] args) 
	{
		Node head1 =  null;
		head1 = insertNode(head1, 20);
		insertNode(head1, 22);
		insertNode(head1, 42);
		insertNode(head1, 64);
		insertNode(head1, 120);
		insertNode(head1, 189);
		
		displayList(head1);
		
		Node head2 =  null;
		head2 = insertNode(head2, 32);
		insertNode(head2, 34);
		insertNode(head2, 49);
		insertNode(head2, 100);
		insertNode(head2, 541);
		
		displayList(head2);
		
		Node head = mergeLists(head1, head2);
		
		displayList(head);
	}
}