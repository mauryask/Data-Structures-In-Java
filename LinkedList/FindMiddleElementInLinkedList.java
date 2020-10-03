// Concept: when the fast pointer will reach to end
// The slow pointer wil point to middle element
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

public class FindMiddleElementInLinkedList
{
	static Node head = null;
	
	static void insertNode(int value)
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
	}
	
	static void printList()
	{
		while(head != null)
		{
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	
	static int findMiddleElement()
	{
		Node slow_ptr, fast_ptr;
		slow_ptr = head;
		fast_ptr = head;
		while(fast_ptr!= null && fast_ptr.next != null)
		{
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
		}
		
		return slow_ptr.data;
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
		
		int midNode = findMiddleElement();
		System.out.print(midNode);
	}
}