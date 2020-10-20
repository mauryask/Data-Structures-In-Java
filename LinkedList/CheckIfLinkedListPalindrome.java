// checking if list is palindrome or not
// Time complexity : O(n)
// Space Complexity : O(1)

import static java.lang.System.*;
class Node 
{
	int data;
	Node next;
	Node(int value)
	{
		data = value;
		next = null;
	}
}

public class CheckIfLinkedListPalindrome
{
	static Node insertNode(int value, Node head)
	{
		Node temp, ptr = null;
		temp = new Node(value);
		if(head == null)
			head = temp;
		else
		{
			ptr = head;
			while(ptr.next != null)
			{
				ptr = ptr.next;
			}
			ptr.next = temp;
		}
		return temp;
	}
	
///==============================================>> Main Method
   	
	public static void main(String [] args)
	{
		Node head = null;
	    head = insertNode(78, head);
		insertNode(56, head);
		insertNode(60, head);
		insertNode(50, head);
		insertNode(50, head);
		insertNode(60, head);   
		insertNode(56, head);   
		Node end = insertNode(78, head); 
       
	    out.println(checkPalin(head));
	}
	
   static boolean checkPalin(Node head)
   {
	   if(head == null || head.next == null)
		   return true;
	   
	   Node p1 = head;
	   Node p2 = head;
	   
	   Node revHead = null;

	   while(p2!= null && p2.next != null)
	   {
			   p1 = p1.next;
			   p2 = p2.next.next;
	   }
	   
	   revHead = reverse(p1);
	   boolean flag = true;
	   
	   while(head != p1)
	   {
		   if(head.data != revHead.data)
		   {
			   flag = false;
			   break;
		   }
		   head = head.next;
		   revHead = revHead.next;
	   }
	   
	   return flag;
    }


      static Node reverse(Node head)
	  {
		 Node ptr = head; 
		 Node prevPtr = null;
		 Node nextPtr = null;
		 
		 while(ptr!=null)
		 {
			 nextPtr = ptr.next;
			 ptr.next = prevPtr;
			 prevPtr = ptr;
			 ptr = nextPtr;
		 }
		 
		 return prevPtr;
	  }
}

