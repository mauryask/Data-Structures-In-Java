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

public class CheckIfLinkedListPalindrome
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
		
		 do
		 {
			 out.print(ptr.data+" ");
			 ptr = ptr.next;
		 }while(ptr != null);
		 
		 out.println();
	 }
	 		
			
    static void checkPalin(Node head)
	{
		Node midNode = findMidNode(head);
		Node revHead = reverseList(midNode);
		boolean flag = true;

		while(revHead != null)
		{
			if(head.data != revHead.data)
			{
				flag = false;
				break;
			}
			
			head = head.next;
			revHead = revHead.next;
		}
		
		out.println(flag ? "Palindrome!" : "Not palindrome");
	}
	
	static Node reverseList(Node head)
	{
		Node ptr = head;
		Node prevNode = null, nextNode = null;
		
		while(ptr != null)
		{
			nextNode = ptr.next;
			ptr.next = prevNode;
			prevNode = ptr;
			ptr = nextNode;
		}
		
		return prevNode;
	}
	
	static Node findMidNode(Node head)
	{
		Node p1 = head, p2 = head;
		
		while(p2 != null && p2.next != null)
		{
			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		return p1;
	}
			
	public static void main(String [] args) 
	{
		Node head1 =  null;
		head1 = insertNode(head1, 1);
		insertNode(head1, 2);
		insertNode(head1, 3);
		insertNode(head1, 4);
		insertNode(head1, 3);
		insertNode(head1, 2);
		insertNode(head1, 1);
					
		displayList(head1);
		
		checkPalin(head1);
	}
}