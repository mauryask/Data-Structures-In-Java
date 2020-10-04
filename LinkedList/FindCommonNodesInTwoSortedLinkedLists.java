// given two sorted linkedlists 
// find the nodes that are common in both(intersction of the linkedlists)
// Time Complexity : O(m+n)

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

public class FindCommonNodesInTwoSortedLinkedLists
{
	static Node insertNode(int data, Node head)
	{
		Node temp, ptr = null;
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
		return temp;
	}
	
	static void displayNode(Node head)
	{
		while(head != null)
		{
			out.print(head.data+" ");
			head =  head.next;
		}
	}
	
	static void findCommonNode(Node head1, Node head2)
	{
		while(head1 != null && head2 != null)
		{
			if(head1.data < head2.data)
				head1 = head1.next;
			else if(head1.data > head2.data)
				head2 = head2.next;
			else
			{
				out.print(head1.data+" ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
	}
	
	public static void main(String [] args)
	{
		Node head1 = null;
		Node head2 = null;
		head1 = insertNode(1, head1);
		insertNode(2, head1);
		insertNode(3, head1);
		insertNode(4, head1);
		insertNode(5, head1);
		insertNode(10, head1);
		insertNode(12, head1);
		insertNode(16, head1);
		
		head2 = insertNode(4, head2);
		insertNode(5, head2);
		insertNode(7, head2);
		insertNode(9, head2);
		insertNode(12, head2);
		insertNode(14, head2);
		
		displayNode(head1);
		out.println();
		displayNode(head2);
		out.println();
		findCommonNode(head1, head2);
	}
}