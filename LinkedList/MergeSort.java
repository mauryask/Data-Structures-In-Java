/*
** Merge Sort 
***************************
* Time complexity: O(n*logn)
* Space complexity: O(n) (Recursion stack)
* in place (in case of linkedlists)
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
		
		/*
		* Here we have to go up to one node before mid node
		* **** don't use below condition
		* while(p2 != null && p2.next != null)
		* Instead use the condition given in code
	    * else it is going to be running infinitely
		***** If we use first condition condition
		
		 20 --> 30  null
		 head   p1   p2      
		 mid = 30, nextNode = mid.next =>  null
         ms(head) and ms(nextNode)
        
		* again give > mid = 30, midNext = null
		* it will run infinitely and won't achieve our goal	
		*/
		
		while(p2.next != null && p2.next.next!= null)
		{
			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		return p1;
	}
	
   	static Node mergeSort(Node head)
	{
		if(head == null || head.next == null)
			return head;

			Node mid = findMid(head);
			Node nextNode = mid.next;
			mid.next = null;
			Node left = mergeSort(head);
			Node right = mergeSort(nextNode);
			Node sortedList = merge(left, right);
			return sortedList;
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
		
		Node head1  = mergeSort(head);
		printList(head1);
	}
}

