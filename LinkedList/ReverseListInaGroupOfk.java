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

public class ReverseListInaGroupOfk 
{
	static Node head = null;
	
	static void insertNode(int data)
	{
		Node temp = null, ptr = null;
		temp = new Node(data);
		if(head  == null)
			head = temp;
		else
		{
			ptr = head;
			while(ptr.next != null)
			  ptr = ptr.next;
		  ptr.next = temp;
		}
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
	
	// reverse even if the number of nodes is not equal to 'k'
	/*
	* Time complexity  : O(n)
	* Space complexity : O(n/k) --> Number of funtion calls
	* = number of groups of size k
	**/
	
	static Node reverseList(int k, Node head)
	{
		    Node cur = head;
		
			Node nextPtr = null, prev = null;
			int count = 0;
				
		    while(cur != null && count < k)		
			{
				nextPtr = cur.next;
				cur.next = prev;
				prev = cur;
				cur = nextPtr;
				count++;
			}	
			
			if(nextPtr != null)
				head.next = reverseList(k, nextPtr);
			return prev;
	}
	
	// recursive version
	// this connects the rest of nodes as it is if number of
	// nodes is not equal to 'k'
	// best solution
	// time complexity : O(n)
	// space complexity : O(1)
	
	static Node reverseList2(int k)
	{
		Node temp =  new Node(-1); //create a temporary node
		Node cur = head;
		Node prev = temp;
		
		while(cur != null)
		{
			Node tail = cur;
			int count = 0;
			while(cur != null && count<k)
			{
				cur = cur.next;
				count++;
			}
			
			/*if(count != k)
				prev.next = tail;
			else
			{*/
				prev.next = reverseUtil(tail, k); // tail is head here of a group of 3 nodes
				prev = tail;
		//	}
		}
		return temp.next;
	}
	
	static Node reverseUtil(Node head, int k)
	{	
		Node prev = null, ptr = head, nextPtr = null;
		while(ptr != null && k-->0)
		{
			nextPtr = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = nextPtr;
		}
		
		return prev;
	}
	
	public static void main(String [] args)
	{
		insertNode(10);
		insertNode(23);
		insertNode(52);
		insertNode(89);
		insertNode(59);
		insertNode(31);
		insertNode(34);
		insertNode(45);
		insertNode(25);
		insertNode(47);
		
		printList();
		//head = reverseList(3, head);
		head = reverseList(3, head);
		printList();
	}
}