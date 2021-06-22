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
	   Node p1 = null, p2 = head;
	   
	   // if list is empty
       if(head == null)
	   {
		   head = temp;
		   return;
	   }
	   
	   // if data is less than the head nodes
	   if(head.data > data)
	   {
		   temp.next = head;
		   head = temp;
		   return;
	   }
	   
	   // for rest of the cases	   
	   while(p2 != null)
	   {
		   if(p2.data < data)
		   {
			   p1 = p2;
			   p2 = p2.next;
		   }
		   else
			   break;
	   }
	   
	   p1.next = temp;
	   temp.next = p2;
	}
	
	public static void main(String [] args) 
	{
		insertNode(10);
		insertNode(12);
		insertNode(14);
		insertNode(28);
		insertNode(35);
		
		displayList();
		addNode(200);
		displayList();
	}
}