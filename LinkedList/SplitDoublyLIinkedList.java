// splitting doubly linked list into two 
// two equal doubly linked lists (even number of nodes)
// make one node extra in first list (odd humber of noedes)

/*
* T(n) : O(n)
* S(n) : O(1)
**/
import static java.lang.System.*;

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
		Node p1Prev = null;
		Node p2Prev = null;
		Node head1 = null, head2 = null;
	
	    // One node 
  		if(head.next == head)
		{
			head1 = head;
			head2 = null;
		}
		// two node 
		if(head.next.next == head)
		{
			head1 = head;
			head2 = head.next;
			head1.next = head1;
			head2.next = head2;
		}
	
		do
		{
			p1Prev = p1;
			p2Prev = p2;
		  	p1 = p1.next;
			p2 = p2.next.next;
			
		}while(p2 != head && p2.next != head);
					
		// even number of nodes
	    if(p2 == head) 
		{
			head1 = head;
			head2 = p1;
			p1Prev.next = head1;
			p2Prev.next.next = head2;
		}
		else if(p2.next == head) // odd number of nodes
		{
			head1 = head;
			head2 = p1.next;
			p2.next = head2;
			p1.next = head1;
		}
		
		displayList(head1);
		displayList(head2);
	}

	static  void displayList(Node head)
	{
		Node temp = head;
		do{
			System.out.print(temp.data+" ");
		 temp = temp.next;
		}while(head != temp);
		out.println();
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
		insertNode(90, head);   
		Node end = insertNode(78, head); 
        
		end.next = head;
		 
		displayList(head);
		System.out.println();
		splitList(head);
	}
}