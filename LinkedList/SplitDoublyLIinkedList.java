// splitting doubly linked list into two 
// two equal doubly linked lists (even number of nodes)
// make one node extra in first list (odd humber of noedes)

/*
* T(n) : O(n)
* S(n) : O(1)
**/

class Node 
{
	int data;
	Node next;
	Node(int value)
	{
		data = value;
		next = null;
	}
}

public class SplitDoublyLIinkedList
{
	static Node insertNode(int value, Node head)
	{
		Node temp, ptr = null;
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
	

    static void splitList(Node head)
	{
		Node p1 = head;
		Node p2 = head;
		do
		{
		  	p2 = p2.next;
			p1 = p1.next.next;
			
		}while(p1.next!=head && p1.next.next != head);
		
		if(p1.next == head) //odd number of nodes
		{
			// 2nd half
			p1.next = p2.next;
			Node head2 = p2.next;
			
			// 1st half
			p2.next = head;
			Node head1 = head;
			
			displayList(head1);
			System.out.println();
			displayList(head2);
		}
		
		else if(p1.next.next == head) //even number of nodes
		{
			// 2nd half
			
			p1 = p1.next;
			p1.next = p2.next;
			Node head2 = p2.next;
			
			// 1st half
			p2.next = head;
			Node head1 = head;
			
			displayList(head1);
			System.out.println();
			displayList(head2);
		}
	}

	static  void displayList(Node head)
	{
		Node temp = head;
		do{
			System.out.print(temp.data+" ");
		 temp = temp.next;
		}while(head != temp);
	}
	
	public static void main(String [] args)
	{
		Node head = null;
		
	    head = insertNode(10, head);
		insertNode(20, head);
		insertNode(30, head);
		insertNode(40, head);
		insertNode(50, head);
		insertNode(60, head);   
		insertNode(56, head);   
		Node end = insertNode(78, head); 
        
		end.next = head;
		
		displayList(head);
		System.out.println();
		splitList(head);
	}
}