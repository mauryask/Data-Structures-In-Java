/**
Time complexity: O(n)
Space complexity: O(n) -> as recursion stack
Note: very important
*/

class Node 
{
	int value;
	Node next;
	Node(int value)
	{
		this.value = value;
		next = null;		
	}
}

class ReverseLinkedListRecursively
{
	static Node head = null;
	static void insertNode(int value)
	{
		Node ptr, temp;
		temp = new Node(value);
		if(head== null)
			head = temp;
		else
		{
			ptr = head;
			while(ptr.next != null)
				ptr = ptr.next;
			ptr.next = temp;
		}
	}
	
	static void displayList()
	{
		Node ptr = head;
		while(ptr != null)
		{
			System.out.print(ptr.value+" ");
			ptr = ptr.next;
		}
	}
	
	static Node recursiveReverse(Node head)
	{
		if(head == null)
			return null;
		else if(head.next == null)
			return head;
		else
		{
			Node nextNode = head.next;
			head.next = null;
			Node rest = recursiveReverse(nextNode);
			nextNode.next = head;
			return rest;
		}
	}
	
	public static void main(String [] args)
	{
		insertNode(45);
		insertNode(78);
		insertNode(89);
		insertNode(23);
		insertNode(20);
		insertNode(14);
		insertNode(69);
		
		displayList();
		
		head = recursiveReverse(head);
		System.out.println();
		displayList();
	}		
}