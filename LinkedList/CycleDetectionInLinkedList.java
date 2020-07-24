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
		Node ptr1, ptr2;
		ptr1 = head;
		ptr2 = head.next;
		
		while(ptr2.next != null)
		{
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			
			if(ptr2.next == ptr1)
			{
				System.out.println("The Linkedlist contains Cycle at node : "+ ptr1.data);
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

