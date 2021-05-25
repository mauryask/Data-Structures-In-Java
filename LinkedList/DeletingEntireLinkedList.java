class Node  
{
	int value;
	Node next;
	
	Node(int value)
	{
		this.value = value;
		this.next = null;
	}
}

public class DeletingEntireLinkedList
{
	static Node head = null;
	static void insertNode(int value) 
	{
		Node temp, ptr;
		temp = new Node(value);
		if(head == null)
		{
		head = temp;
		}
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
	
	static void displayNode()
	{
		Node ptr = head;
		while(ptr != null)
		{
			System.out.print(ptr.value+" ");
			ptr = ptr.next;
		}
	}
	
	//deliting the entire list
	static void deleteList() 
	{
		Node ptr = head;
       
		while(head != null)
		{
			head = ptr.next;
			ptr.next = null;
			ptr = head;
		}
	}
	
	public static void main(String [] args)
	{
		insertNode(10);
		insertNode(7);
		insertNode(15);
		insertNode(78);
		insertNode(12);
		insertNode(36);
		insertNode(9);
		
		displayNode();
		deleteList();
		System.out.println("\n------");
		displayNode();
	}
}