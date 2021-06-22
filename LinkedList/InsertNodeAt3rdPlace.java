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

public class InsertNodeAt3rdPlace
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
	
	static void insertElement(int data)
	{
		Node ptr1 = null, ptr2 = head;
		int count = 1;
		Node temp = new Node(data);
		
		while(ptr2 != null && count != 3)
		{
			count++;
			ptr1 = ptr2;
			ptr2 = ptr2.next;
		}
		
		if(count != 3)
			out.println("Insufficient number of nodes");
		else
		{
			ptr1.next = temp;
			temp.next = ptr2;
		}
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
		insertElement(20);
		displayList();
	}
}