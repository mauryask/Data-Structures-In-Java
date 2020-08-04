// Floyd's Tortoise and Hare AlgorithmConstraints
// Or simply Floyd's algorithm of cycle detection
// This is the best algorithm for cyclce detection

// Time Complexity : O(n)
// Space Complexity : O(1)

class Node 
{
	int data;
	Node next;
	Node(int data)
	{
		this.data = data;
	}
}

public class CycleDetectionInLinkedList 
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
		fast_ptr = head.next;
		
		while(fast_ptr.next != null)
		{
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
			
			if(fast_ptr.next == slow_ptr)
			{
				System.out.println("The Linkedlist contains Cycle at node : "+ slow_ptr.data);
				return;
			}
		}
		
		System.out.println("The Linkedlist don't have Cycle");
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
		n5.next = n2;
	    detectCycle(head);
	}
}

