// Floyd's Tortoise and Hare Algorithm -
// Or simply Floyd's algorithm of cycle detection
// This is the best algorithm for cyclce detection
// Time Complexity : O(n)
// Space Complexity : O(1)
//this is aloso known a memory less approach of loop detection
// here i have also implemented the algo to find loop length and 
//the node at which loop starts

class Node 
{
	int data;
	Node next;
	Node(int data)
	{
		this.data = data;
	}
}

public class CycleDetectionInLinkedListUsingFloydsAlgo 
{
	static Node insertNode(Node head,int value)
	{
		Node temp, ptr;
		temp = new Node(value);
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
	
	static void detectCycle(Node head)
	{
		Node fast_ptr, slow_ptr;
		slow_ptr = head;
		fast_ptr = head;
		
		while(fast_ptr.next != null && slow_ptr != null && fast_ptr != null)
		{
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
			
			if(fast_ptr == slow_ptr) //if true, then there is a loop
			{
				//===> finding node at which loop starts
				findNode(head, slow_ptr, fast_ptr);		
				//===> finding the length of the loop
				findLoopLength(head,slow_ptr, fast_ptr);
			
				return;
			}
		}
		
		System.out.println("No loop found");
	}
	
	static void findNode(Node head, Node slow_ptr, Node fast_ptr)
	{
		//after lop detection find node at whch loop started
				//initialize slow_ptr to head
				//and move both one by one now
				//the point at which they meet will be required node
				
				slow_ptr = head;
			    while(slow_ptr != fast_ptr)
				{
					slow_ptr = slow_ptr.next;
					fast_ptr = fast_ptr.next;
				}
				System.out.println("\nLoop detected at: "+slow_ptr.data);
	}
	
	static void findLoopLength(Node head, Node slow_ptr, Node fast_ptr)
	{
		//fix the slow ptr and move the fast_ptr 
		//until it reaches back to slow ptr
		int count = 1;
		
			while(fast_ptr.next != slow_ptr)
			{
				count++;
				fast_ptr = fast_ptr.next;
			}
		
		System.out.println("Lop Length: "+count);
	}
	
	public static void main(String [] args)
	{
	    Node head = null;
		head = insertNode(head,12);
		Node n1 = insertNode(head,45);
		Node n2 = insertNode(head,85);
		Node n3 = insertNode(head,96);
		Node n4 = insertNode(head,23);
		Node n5 = insertNode(head,78);
		//creating the linked list cycle
		n5.next = n3;
	    detectCycle(head);
	}
}

