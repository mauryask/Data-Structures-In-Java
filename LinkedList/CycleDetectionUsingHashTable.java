/**
Time complexity  : O(n)
Space complexity : O(n)
*/

import java.util.*;
import static java.lang.System.*;

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

public class CycleDetectionUsingHashTable
{
	 static Node tail = null;
	
	 static Node insertNode(Node head, int data)
	 {
		 Node temp = new Node(data), ptr = null;
		 if(head == null)
			 head = temp;
		 else
			 tail.next = temp;
		 tail = temp;
		 return temp;
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
	 
	 static void isLoop(Node head)
	 {
	    Set<Node> set = new HashSet<>();	
	    Node ptr  = head;
		boolean flag = false;
		
		while(ptr != null)
		{
			if(set.contains(ptr))
			{
				flag = true;
				break;
			}
			
			set.add(ptr);
			ptr = ptr.next;
		}
		
		out.println(flag ? "loop found!" : "loop not found!");
	 }
	public static void main(String [] args) 
	{
		Node head = null;
		head = insertNode(head, 13);
		Node r1 = insertNode(head, 5);
		Node r2 = insertNode(head, 12);
		Node r3 = insertNode(head, 20);
		Node r4 = insertNode(head, 32);
		Node r5 = insertNode(head, 24);
		
		// creating a loop
		r5.next = head; 
		
        isLoop(head);
	}
}