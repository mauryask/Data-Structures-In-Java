/**
* Time Complexity: O(n+m)
* Space Complexity: O(1)
*/
import static java.lang.System.*;
import java.util.*;

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

public class PrintCommonNodesFromTwoGivenSortedLists
{
	static Node insertNode(int data, Node head)
	{
		Node temp = null, ptr = null;
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
	
	static void printList(Node head)
	{
		Node ptr = head;
		
		while(ptr != null)
		{
			out.print(ptr.data+" ");
			ptr = ptr.next;
		}
		
		out.println();
	}
	
	static void printCommonNodes(Node head1, Node head2)
	{
		while(head1 != null && head2 != null)
		{
		   	if(head1.data == head2.data)
			{
				out.print(head1.data+" ");
				head1 = head1.next;
				head2 = head2.next;
			}
			else if(head1.data > head2.data)
				head2 = head2.next;
			else
				head1 = head1.next;	
		}
	}
	
	public static void main(String [] args)
	{
		Node head1 =  null;
		Node head2 = null;		
		head1 = insertNode(10, head1);
		insertNode(22, head1);
		insertNode(14, head1);
		insertNode(44, head1);
		insertNode(125, head1);
		insertNode(78, head1);
		
		head2 = insertNode(25, head2);
		insertNode(36, head2);
		insertNode(44, head2);
		insertNode(100, head2);
		insertNode(125, head2);
		
		printList(head2);
		
		printCommonNodes(head1, head2);
	}
}