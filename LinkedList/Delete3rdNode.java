import static java.lang.System.*;

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

public class Delete3rdNode
{
	static Node head = null;
	
	static void insertNode(int data)
	{
		Node temp = null, ptr = null;
		temp = new Node(data);
		
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
	
	static void displayList()
	{
		Node ptr = head;
		while(ptr != null)
		{
			out.print(ptr.data+" ");
			ptr = ptr.next;
		}
	}
	
	static void deleteElement()
	{
		Node ptr1 = null, ptr2 = head;
		int count = 1;
		
		while(ptr2.next != null && count != 3)
		{
			count++;
			ptr1 = ptr2;
			ptr2 = ptr2.next;
		}
		
		if(count != 3)
			out.println("Insufficient number of nodes");
		else
			ptr1.next = ptr2.next;
		out.println();
	}
	
	public static void main(String [] args)
	{
		insertNode(10);
		insertNode(7);
		insertNode(6);
		insertNode(2);
		insertNode(5);
		displayList();
		deleteElement();
		displayList();
	}
}