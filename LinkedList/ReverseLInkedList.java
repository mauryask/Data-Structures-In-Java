// Time Complexity : O(n)

class Node  
{
	int data;
	Node next;
	Node(int data)
	{
		this.data = data;
		next = null;
	}	
}

public class ReverseLInkedList
{
	static Node head = null;
	static void insertNode(int data)
	{
		Node temp, ptr;
		temp = new Node(data);
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
	}
	
	static void printList()
	{
		Node ptr = head;
		while(ptr != null)
		{
			System.out.print(ptr.data+" ");
			ptr = ptr.next;
		}
	}
	
	static void revesreList()
	{
		Node nextPtr, ptr, prevPtr;
		ptr = head;
		nextPtr = prevPtr = null;
		
		while(ptr!= null)
		{
			nextPtr = ptr.next;
			ptr.next = prevPtr;
			prevPtr = ptr;
			ptr = nextPtr;
		}
		
		head = prevPtr;
	}
	
	public static void main(String [] args)
	{
		insertNode(12);
		insertNode(15);
		insertNode(45);
		insertNode(85);
		insertNode(89);
		insertNode(56);
		insertNode(23);
		
		printList();
	    revesreList();
		System.out.println();
		printList();
	}
}