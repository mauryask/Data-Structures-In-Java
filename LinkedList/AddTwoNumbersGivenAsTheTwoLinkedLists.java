// Given two linked lists, each list node with 
// one integer digit, add these two
// linked lists. The result should be stored
// in the third linked list. Also note that the head node
// contains the most significant digit of the number.

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

public class AddTwoNumbersGivenAsTheTwoLinkedLists
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
	
	static Node findSum(Node p1, Node p2)
	{
		if(p1 == null && p2 != null)
			return  p1 ;
	    else if(p1 != null && p2 == null)
			return p2;
		if(p1 == null && p2 == null)
			return null;
		
		int carry = 0;
		int sum = 0;
		int nDigit= 0;
		
		Node head = p1;
		
		while(p1 != null && p2 != null)
		{
			sum = p1.data + p2.data + carry;
			nDigit = (int)Math.log10(sum) + 1; //finding number of digits

			if(nDigit > 1)
			{
				p1.data = sum % 10;
				carry = sum /10;
			}
			else
			{
				p1.data = sum;
				carry = 0;
			}
						
			if(p1.next ==  null && p2.next != null)
				p1.next = new Node(0);
			else if(p1.next != null && p2.next == null)
				p2.next = new Node(0);
			
			p1 = p1.next;
			p2 = p2.next;
			
		}
		return head;
	}
	
	static void displayNode(Node head)
	{
		Node ptr = head;
		while(ptr != null)
		{
			out.print(ptr.data);
			ptr = ptr.next;
		}
		out.println();
	}
	
	public static void main(String [] args)
	{
		Node head1 = null;
		Node head2 = null;
		
		head1 = insertNode(7, head1);
		insertNode(3, head1);
		insertNode(8, head1);
				
		
		head2 = insertNode(2, head2);
		insertNode(2, head2);
		insertNode(3, head2);
		
		displayNode(head1);
		displayNode(head2);
		
		Node head = findSum(head1, head2);
		displayNode(head);
	}
}