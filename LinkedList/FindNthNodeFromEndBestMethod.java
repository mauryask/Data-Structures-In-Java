/**
Time complexity : O(n)
Space complexity: O(1)
** Floyds Tortoise algo
** Why this works:
** The first pointer moving 𝑛 steps ahead creates a gap of 𝑛 between the two pointers.
** When first reaches the end, the second pointer will be at the desired
𝑛th node from the end.
*/

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
   
   		if(count < n)
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
      insertNode(12);
      insertNode(15);
      insertNode(23);
      insertNode(85);
      insertNode(74);

	  display();
	  out.println();
	  nthNodeFromEnd(5);
	}
}