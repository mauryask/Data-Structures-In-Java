/**
Time complexity: O(n)
Space complexity: O(1)
*/

import static java.lang.System.*;
import java.util.*;

class Node  
{
	int value;
	Node next;
	
	public Node (int value)
	{
		this.value = value;
		next = null;
	}	
}

public class ReverseListInPairs
{
	static Node head; 
    static Node createNode(int value)
	{
		Node newNode = new Node(value);
		return newNode;
	}


	static void insertNode(int value)
	{
		Node newNode = createNode(value);
		if(head == null)
			head = newNode;
		else
		{
			Node p = head;
			while(p.next != null)
				p = p.next;
			
			p.next = newNode;
		}
	}
	
	 static void reverseListInPairs()
	 {
		 Node p1 = head;
		 Node p2 = head.next;
		 Node temp = null;
		 head = p2;
		 
		 while(true)
		 {
			temp = p2.next;
			p2.next = p1;
			
			if(temp == null || temp.next == null)
			{
				p1.next = temp;
				return;
			}
			
			p1.next = temp.next;
			p1 = temp;
			p2 = temp.next;
		 } 
	 }

    public static void displayNode(Node ptr)
	{
		while(ptr != null)
		{
			out.print(ptr.value+" ");
			ptr = ptr.next;
		}
		
		out.println();
	}

  /*
  * T(n) : O(n)
  * S(n) : O(n) > as stack
  */
   static void reverseListInPairs2()
   {
	   Node curr = head;
	   Node prev = null;
	   Node ptr = null;
	   Node newHead = null;
	   Stack<Node> stack = new Stack<>();
	   
	   while(curr != null)
	   {
		   int count = 0;
		   
		   while(curr != null && count < 2)
		   {
			   stack.push(curr);
			   ptr = curr;
			   curr = curr.next;
			   ptr.next = null;
			   count++;
		   }
		   		   
		   while(!stack.isEmpty())
		   {
			   if(newHead == null)
			   {
				   newHead = stack.pop();
				   prev = newHead;
			   }
			   else 
			   {
				   Node temp =  stack.pop();
				   prev.next = temp;
				   prev = temp;
			   }
		   }
	   }
	   
	  displayNode(newHead);
   }

	public static void main(String [] args)
	{
		insertNode(20);
		insertNode(30);
		insertNode(40);
		insertNode(50);
		insertNode(60);   
		insertNode(78);    
		insertNode(25);    
		
		reverseListInPairs2();
		//displayNode(head);
	}
	
}

