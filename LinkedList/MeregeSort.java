/*
** Bubble Sort 
***************
* Time complexity: O(n*n)
* Space complexity: O(1)
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

public class MergeSort
{
	static Node findMid(Node head)
	{
	  if(head == null || head.next == null)
		return head;
		
		Node p1 = head; 
		Node p2 = head;
		
		while(p2.next != null && p2.next.next != null)
		{
			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		return p1;
	}
	
   	static Node meregeSort(Node head)
	{
		if(head == null || head.next == null)
			return head;

			Node mid = findMid(head);
			Node nextNode = mid.next;
			mid.next = null;
			Node left = meregeSort(head);
			Node right = meregeSort(nextNode);
			return merge(left, right);
	}
	
	static Node merge(Node head1, Node head2)
	{
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		
		Node head = null, s = null;
		
		if(head1.data <= head2.data)
		{
			s = head1;
			head1 = s.next;
		}
		else
		{
			s = head2;
			head2 = s.next;
		}
		
		head = s;
		
		
		while(head1 != null && head2 != null)
		{
		   if(head1.data <= head2 .data)
		   {
			   s.next = head1;
			   s = head1;
			   head1 = s.next;
		   }		
			else
			{
				s.next = head2;
				s = head2;
				head2 = s.next;
			}				
		}
		
		if(head1 == null)
			s.next = head2;
		else
			s.next = head1;
		return head;
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
	
	public static void main (String[] args)
	{
		Node head = new Node(120);
		Node n1 = new Node(30);
		Node n2 = new Node(45);
		Node n3 = new Node(15);
		Node n4 = new Node(38);
		Node n5 = new Node(5);
		Node n6 = new Node(21);
		Node n7 = new Node(10);
		Node n8 = new Node(12);
		Node n9 = new Node(7);
		
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		
		Node head1  = meregeSort(head);
		printList(head1);
	}
}

