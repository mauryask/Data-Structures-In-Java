/**
Time complexity : O(n)
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

public class FindNthNodeFromEndBestMethod
{
	 static Node head = null, tail = null;
	
	 static void insertNode(int data)
	 {
		 Node temp = new Node(data), ptr = null;
		 if(head == null)
			 head = temp;
		 else
			 tail.next = temp;
		 tail = temp;
	 }
 
	 static void display()
	 {
		 Node ptr = head;
		 
		 while(ptr != null)
		 {
			 out.print(ptr.data+" ");
			 ptr = ptr.next;
		 }
		 out.println();
	 }
	 
	 static void nthNodeFromEnd(int n)
	 {
		// if no node present
         if(head == null)
		 {
			 out.println("Insufficient number of nodes");
			 return;
		 }
		 
		Node p1 = head, p2 = head;
		int count = 1;
		while(p2.next != null && count != n)
		{
			p2=  p2.next;
			count++;
		}
   
   		if(count != n)
		{
			out.println("Insufficient number of nodes");
			return;
		}
        
        
        while(p2.next != null)
		{
			p1 = p1.next;
			p2 = p2.next;
		}

    	  out.println(p1.data);
	 }
	 
	public static void main(String [] args) 
	{
      insertNode(10);

	  display();
	  out.println();
	  nthNodeFromEnd(5);
	}
}