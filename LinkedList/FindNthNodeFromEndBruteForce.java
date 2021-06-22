// Finding nth node from end 
// Brute force approach
// Time complexity: O(n^2)
// Space complexity : O(1)

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

public class FindNthNodeFromEndBruteForce
{
	 static Node head = null;
	
	 static void insertNode(int data)
	 {
		 Node temp = new Node(data), ptr = null;
		 
		 if(head == null)
			 head = temp;
		 else
		 {
			 ptr = head;
			 while(ptr.next != null)
				 ptr = ptr.next;
			 ptr.next = temp;
		 }
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
	 
	 static void nthNode(int n)
	 {
		// 0 node in the list
		if(head == null)
		{
			out.println("Insufficient number of nodes");
			return;
		}
		
		Node temp = head;
		
		while(temp != null)
		{
			int count = 0;
			Node ptr = temp.next;
			
			while(ptr != null)
			{
			  	count++;
				ptr = ptr.next;
			}
			
			if(count < n-1)
			{
				out.println("Insufficient number of nodes!");
				break;
			}
			else if(count == n-1)
			{
			   out.println(temp.data);
			   break;
			}
			
			temp = temp.next;
		}
	 }
	 
	public static void main(String [] args) 
	{
	  insertNode(10);
	  insertNode(7);
	  insertNode(8);
	  insertNode(41);
	  insertNode(3);
	  insertNode(45);
	  display();
	  out.println();
	  nthNode(10);
	}
}