/**
Time complexity: O(n)
Space complexity: O(1)
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

public class FindNthElementFromEnd
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
		int m = 0; //total node in the list
		
		Node ptr = head;
		
		while(ptr != null)
		{
			m++;
			ptr = ptr.next;
		}
		
		// get m-n+1 node from the begining 	
		int count  = 1;
		ptr = head;
		
		while(ptr != null && count != m-n+1)
		{
		    count++;
			ptr = ptr.next;
		}
		
		if(count != m-n+1)
			out.println("Insufficient number of nodes");
		else
		  out.println(ptr.data);
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
	  nthNodeFromEnd(4);
	}
}