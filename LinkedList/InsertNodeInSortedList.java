/**
Time complexity: O(n)
Space complexity: O(1)
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

public class InsertNodeInSortedList
{
	 static Node tail = null, head = null;
	
	 static Node insertNode(int data)
	 {
		 Node temp = new Node(data), ptr = null;
		 if(head == null)
			 head = temp;
		 else
			 tail.next = temp;
		 tail = temp;
		 return temp;
	 }
	 
	 static void displayList()
	 {
		 Node ptr = head;
		 while(ptr != null)
		 {
			 out.print(ptr.data+" ");
			 ptr = ptr.next;
		 }
		 out.println();
	 }
	
	static void addNode(int data)
	{ 				
	   Node temp = new Node(data);
	   Node prev = null, ptr = head;
	   
	   // if list is empty
       if(head == null)
	   {
		   head = temp;
		   return;
	   }
	  
	   // for rest of the cases	   
	   while(ptr != null && ptr.data < data)
	   {
			   prev = ptr;
			   ptr = ptr.next;
	   }
	   
 	    if(prev == null)
		{
			temp.next = head;
			head = temp;
			return;
		}
		
	   prev.next = temp;
	   temp.next = ptr;
	}
	
	public static void main(String [] args) 
	{
		insertNode(10);
		insertNode(12);
		insertNode(14);
		insertNode(28);
		insertNode(35);
		
		displayList();
		addNode(5);
		displayList();
	}
}