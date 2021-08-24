/*
* Time complexity  : O(n)
* Space complexity : O(1)
**/

import static java.lang.System.*;
import java.util.*;

class Node 
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
		this.data = data;
		next = null;
		prev = null;
	}
}

public class PutevenNodesInTheBegining
{
	static Node head = null, tail = null;
	
	static void insertNode(int data)
	{
		Node temp, ptr;
		temp = new Node(data);
		
		if(head  ==  null)
			head = temp;
		else
			tail.next = temp;	
		tail = temp;
	}
	
	static void printList()
	{
		Node ptr = head;
		
		while(ptr != null)
		{
			out.print(ptr.data+" ");
			ptr = ptr.next;
		}
		
		out.println();
	}
	
	static void arrangeList()
	{
		
		if(head == null || head.next == null)
			return;
		
		Node ptr = head;
		Node prev = null;
		
		while(ptr!=null && ptr.data % 2 == 0)
			ptr  = ptr.next;
		
		while(ptr != null)
		{
			if(ptr.data %2 != 0)
			{
				prev = ptr;
				ptr = ptr.next;
			}
			else
			{
				prev.next = ptr.next;
				ptr.next = head;
				head = ptr;
				ptr = prev.next;
			}
		}
	}
	
	public static void main(String [] args)
	{
		insertNode(5);
		insertNode(12);
		insertNode(21);
		insertNode(7);
		insertNode(56);
		insertNode(85);
		insertNode(10);
		insertNode(2);
		insertNode(14);
		insertNode(20);
		insertNode(23);
		
		printList();
		arrangeList();
		printList();
	}
}

