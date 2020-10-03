//detecting loop in alinked list using hashset
//time complexity: O(n) ==>  during scanning the linkedlist

import java.util.HashMap;
class Node 
{
	int value;
	Node next;
	Node(int value)
	{
		this.value = value;
		next = null;
	}
}

public class CycleDetectionUsingHashTable
{
	static Node insertNode(Node head, int value)
	{
		Node ptr,temp;
		temp = new Node(value);
		if(head == null)
		{
			head = temp;
		}
		else
		{
			ptr = head;
			while(ptr.next!= null)
			{
				ptr = ptr.next;
			}
			ptr.next = temp;
		}
		return temp;
	}
	
	static void detectLoop(Node head)
	{
	   Map<Node> map = new HashMap<>();
	   int count = 0;
	   boolean flag = false;
	   while(head != null)
	   {
		   if(!map.containsKey(head))
		     map.put(head, count++);
		   else 
		   {
			   flag  = true;
			   break;
		   }
		   head = head.next;
	   }
	   if(flag == false)
		   System.out.println("\nNo loop found in the linked list");
	   else
	     System.out.println("\nloop detected at node: "+head.value);
	}
	
    public static void main(String [] args)
	{
		Node head =  null;
		head = insertNode(head,10);
		Node r2 = insertNode(head,23);
		Node r3 = insertNode(head,54);
		Node r4 = insertNode(head,13);
		Node r5 = insertNode(head,14);
		Node r6 = insertNode(head,45);
		Node r7 = insertNode(head,96);
		Node r8 = insertNode(head,78);
		
		r8.next = r2; //creating loop in the list
	    detectLoop(head);
	}
}
