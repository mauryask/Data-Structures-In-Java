//===> Reversisng linked list in pairs recursively
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

public class ReverseInPairsRecursively 
{
	static Node insertNode(Node head,int value)
	{
		Node temp = null, ptr = null;
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
	
	//===> method to reverse the linked list recursively
	static Node reverseRecursive(Node head)
	{
		Node p1 = head;
		Node p2 = head.next;
		Node temp = p2.next;
		p2.next = p1;
		if(temp == null || temp.next == null)
		{
			p1.next = temp;
			return null;
		}
		p1.next = temp.next;		
		reverseRecursive(temp);
		return p2;
	}
	
	static void displayNode(Node head)
	{
		Node ptr = head;
		while(ptr != null)
		{
			System.out.print(ptr.data+" ");
			ptr = ptr.next;
		}
	}
	
	public static void main(String [] args)
	{
		Node head = null;
		head = insertNode(head,10);
		insertNode(head,15);
		insertNode(head,21);
		insertNode(head,89);
		insertNode(head,56);
		insertNode(head,23);
		insertNode(head,28);
		
		displayNode(head);
		System.out.println();
		head = reverseRecursive(head);
		displayNode(head);
	}
}