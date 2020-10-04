// Given lonkedlist with even and odd numbers 
// arrange the lemnts in such a way 
// so that all the even numbers appear
// before odd numbers (in the same relative order)

/**
* This modified version of problem (leet code)
* Arrange elemnts in such a way such that all the elements
* at even positions come after all the elemnts 
* at odd positions and in the same relative order
*/


/**
* Inplace Technique demonstrated below
* Time Complexity : O(n)
* Space Complexity : O(1)
* Best Technique
*/

import static java.lang.System.*;

class Node 
{
	int data;
	Node next;
	Node(int data)
	{
		this.data = data;
		next = null;
	}
}

public class OddevenLinkedLists
{
	static Node insertNode(int data, Node head)
	{
		Node temp, ptr = null;
		temp = new Node(data);
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
	
	static void displayNode(Node head)
	{
		Node ptr = head;
		while(ptr != null)
		{
			out.print(ptr.data+" ");
			ptr =  ptr.next;
		}
		out.println();
	}


   static void evenOddList(Node head)
   {
	  Node eHead =null, oHead = null, e = null;
	  Node o = null, ptr = head;
	  
	  while(ptr != null)
	  {
		  if(ptr.data %2 == 0)
		  {
			if(eHead == null)
				e = eHead = ptr;
			else
			{
				e.next = ptr;
				e = ptr;
			}
		  }
		  else
		  {
			 if(oHead == null)
				o = oHead = ptr;
			else
			{
				o.next = ptr;
				o = ptr;
			}
		  }
		  
		  ptr = ptr.next;
	  }
	 
	  e.next = oHead;
	  o.next = null; 
	  
	  displayNode(eHead);
   }
	
	public static void main(String [] args)
	{
		Node head1 = null;
		head1 = insertNode(1, head1);
		insertNode(2, head1);
		insertNode(3, head1);
		insertNode(4, head1);
		insertNode(5, head1);
		insertNode(21, head1);
		insertNode(7, head1);
		insertNode(10, head1);
		insertNode(15, head1);
		insertNode(16, head1);
		
		displayNode(head1);
		
		evenOddList(head1);
	}
}